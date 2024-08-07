package com.enayapbm.medimpact.delivery;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.logging.Level;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import com.enayapbm.medimpact.model.MedImpactRequest;
import com.enayapbm.medimpact.model.MedImpactResponse;
import com.enayapbm.medimpact.model.ProjectLogger;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@RequestScoped
public class MedimpactRestClientHandler {

	private static final int READ_TIMEOUT = 60000;
	private static final int CONNECTION_TIMEOUT = 60000;
	private String url;
	private String username;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	private int numberOfRetries;
	private int connectTimeout;
	private int readTimeout;

	public void prepareHandler(String url, String username, String password, int numberOfRetries) {
		this.url = url;
		this.setUsername(username);
		this.password = password;
		this.numberOfRetries = numberOfRetries;
		this.connectTimeout = CONNECTION_TIMEOUT;
		this.readTimeout = READ_TIMEOUT;
	}

	public void prepareHandler(String url, String username, String password, int numberOfRetries, int connectionTimeout,
			int readTimeout) {
		this.url = url;
		System.out.println("URL =====>"+url);
		this.setUsername(username);
		this.password = password;
		this.numberOfRetries = numberOfRetries;
		this.connectTimeout = connectionTimeout;
		this.readTimeout = readTimeout;
	}
	int j=0;
	public MedImpactResponse doPostForNewRequest(MedImpactRequest request) {
		MedImpactResponse response = null;
		String requestId = request.getRequestId();
		String newRequestId = UUID.randomUUID().toString();
		request.setRequestId(newRequestId);
		try {
			System.out.println("Starting Time :===="+System.currentTimeMillis());
			System.out.println(new Gson().toJson(request));
			WebResource resource = initConnection();
			ClientResponse httpResponse = resource.header("Content-Type", "application/json")
					.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, new Gson().toJson(request));

			if (httpResponse.getStatus() != 200) {
				String httpDescriptionForError = httpResponse.getHeaders().getFirst("response-description");
				System.out.println("Error Description====: Request ID: "+request.getRequestId()+" With ProviderId===> "+request.getPharmacyId()+" "+httpDescriptionForError);
				
				return new MedImpactResponse(httpResponse.getStatus(), httpDescriptionForError,requestId);
			}

			String responseReceived = httpResponse.getEntity(String.class);
			
			response = new Gson().fromJson(responseReceived, MedImpactResponse.class);
			response.setHttpStatusCode(200);
			response.setRequestId(requestId);
			j++;
			System.out.println("Counter =====>"+j);
		} catch (Exception e) {
			ProjectLogger.logBasic("Pbm connection failed", Level.SEVERE, e);
			return new MedImpactResponse(requestId);
		}
		
		System.out.println("Response From PBM"+new Gson().toJson(response));
		System.out.println("End Time :===="+System.currentTimeMillis());
		if(response == null)
			return new MedImpactResponse(requestId);
		return response;

//		if (httpResponse.getStatus() != 200) {
//			String httpDescriptionForError = httpResponse.getHeaders().getFirst("response-description");
//			return new MedImpactResponse(httpResponse.getStatus(), httpDescriptionForError);
//		}

//		String responseReceived = httpResponse.getEntity(String.class);
//
//		response = new Gson().fromJson(responseReceived, MedImpactResponse.class);
//		response.setHttpStatusCode(200);
//		} catch (Exception e) {
//			ProjectLogger.logBasic("Pbm connection failed", Level.SEVERE, e);
//		}
//		return response;
	}

//	public MedImpactResponse doPutForFollowUpRequest(MedImpactRequest request) {
//		WebTarget resource = initConnection();
////		ClientResponse httpResponse = resource.request(MediaType.APPLICATION_JSON).post(ClientResponse.class,
////				new Gson().toJson(request));
//
////		if (httpResponse.getStatus() != 200) {
////			String httpDescriptionForError = httpResponse.getHeaders().getFirst("response-description");
////			return new MedImpactResponse(httpResponse.getStatus(), httpDescriptionForError);
////		}
//
////		String responseReceived = httpResponse.getEntity(String.class);
//
//		MedImpactResponse response = resource.request(MediaType.APPLICATION_JSON).post(Entity.json(request),
//				MedImpactResponse.class);
//
////		response.setHttpStatusCode(200);
//		return response;
//	}

//	public MedImpactCancellationResponse cancellation(MedImpactCancellationRequest request) {
//		WebTarget resource = initConnection();
////		ClientResponse httpResponse = resource.request(MediaType.APPLICATION_JSON).post(ClientResponse.class,
////				new Gson().toJson(request));
//
////		if (httpResponse.getStatus() != 200) {
////			String httpDescriptionForError = httpResponse.getHeaders().getFirst("response-description");
////			return new MedImpactCancellationResponse(httpResponse.getStatus(), httpDescriptionForError);
////		}
//
////		String responseReceived = httpResponse.getEntity(String.class);
//
//		MedImpactCancellationResponse response = resource.request(MediaType.APPLICATION_JSON).post(Entity.json(request),
//				MedImpactCancellationResponse.class);
//
////		response.setHttpStatusCode(200);
//		return response;
//	}
//

	private String getBasicAuthentication() {
		String token = this.username + ":" + this.password;
		String result;
		try {
			result = "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException("Cannot encode with UTF-8", ex);
		}
		return result;
	}

	private WebResource initConnection() {
//		Client httpClient = ClientBuilder.newClient();
//        
//		httpClient.property("jersey.config.client.connectTimeout", connectTimeout);
//		httpClient.property("jersey.config.client.readTimeout", readTimeout);
//		httpClient.property("Authorization", getBasicAuthentication());
//		WebTarget resource = httpClient.target(url);
//		
//		//restClient.addFilter(new HTTPBasicAuthFilter(username, password));
//
//		// Set Timeouts.
//
//		return resource;

		Client restClient = Client.create();
		restClient.addFilter(new HTTPBasicAuthFilter(username, password));

		// Set Timeouts.
		restClient.setConnectTimeout(360000);
		restClient.setReadTimeout(360000);

		WebResource webResource = restClient.resource(url);
		return webResource;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
