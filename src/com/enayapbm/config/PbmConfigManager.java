package com.enayapbm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PbmConfigManager {
   private static final String MEDIMPACT_AUTHENTICATION_USER = "Medimpact_Authentication_User";
   private static final String MEDIMPACT_AUTHENTICATION_PASSWORD = "Medimpact_Authentication_Password";
   private static final String MEDIMPACT_API_URL_NEW_REQUEST = "Medimpact_Api_Url";
   private static final String MEDIMPACT_API_URL_CANCELLATION_REQUEST = "Medimpact_Api_Cancellation_Url";
   private static final String ENCRYPT_MEMBERID = "EncryptMemberId";
   private static final String WASEEL_PBM_SERVICE_API_URL_NEW_REQUEST = "Waseel_Pbm_Service_Api_New_Url";
   private static final String WASEEL_PBM_SERVICE_API_URL_FOLLOWUP_REQUEST = "Waseel_Pbm_Service_Api_Followup_Url";
   private static final String WASEEL_PBM_SERVICE_API_URL_CANCELLATION_REQUEST = "Waseel_Pbm_Service_Api_Cancellation_Url";
   private static final String TIMEOUT = "TIMEOUT";
   private static final String NO_OF_RETRIES = "NO_OF_RETRIES";
   private static final String Dss_New_Api_Url = "Dss_New_Api_Url";
   private static final String Dss_Followup_Api_Url = "StringDss_Followup_Api_Url";
   private static final String Dss_Cancellation_Api_Url = "Dss_Cancellation_Api_Url";
   private static final String Dss_Override_Api_Url = "Dss_Override_Api_Url";
   private static final String Enable_Direct_Access_To_Dss = "Enable_Direct_Access_To_Dss";
   private Properties pbmConfigs;

   @PostConstruct
   public void init() {
      this.pbmConfigs = new Properties();
      String fileName = "pbmconfig.properties";
      InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);

      try {
         if (input != null) {
            this.pbmConfigs.load(input);
         }
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public String getAuthentication_Username_Medimpact() {
      return this.pbmConfigs.getProperty("Medimpact_Authentication_User");
   }

   public boolean isEncryptMemberId() {
      return this.pbmConfigs.getProperty("EncryptMemberId") != null && !this.pbmConfigs.getProperty("EncryptMemberId").equals("0");
   }

   public String getAuthentication_Password_Medimpact() {
      return this.pbmConfigs.getProperty("Medimpact_Authentication_Password");
   }

   public String getApiUrl_New_Request_MedImpact() {
      return this.pbmConfigs.getProperty("Medimpact_Api_Url");
   }

   public String getApiUrl_Cancellation_Request_MedImpact() {
      return this.pbmConfigs.getProperty("Medimpact_Api_Cancellation_Url");
   }

   public String getWaseelPbmServiceApiUrlNewRequest() {
      return this.pbmConfigs.getProperty("Medimpact_Api_Url");
   }

   public String getWaseelPbmServiceApiUrlFollowupRequest() {
      return this.pbmConfigs.getProperty("Waseel_Pbm_Service_Api_Followup_Url");
   }

   public String getWaseelPbmServiceApiUrlCancellationRequest() {
      return this.pbmConfigs.getProperty("Waseel_Pbm_Service_Api_Cancellation_Url");
   }

   public String getTimeout() {
      return this.pbmConfigs.getProperty("TIMEOUT");
   }

   public String getNoOfRetries() {
      return this.pbmConfigs.getProperty("NO_OF_RETRIES");
   }

   public String getDssNewApiUrl() {
      return this.pbmConfigs.getProperty("Dss_New_Api_Url");
   }

   public String getDssFollowupApiUrl() {
      return this.pbmConfigs.getProperty("StringDss_Followup_Api_Url");
   }

   public String getDssCancellationApiUrl() {
      return this.pbmConfigs.getProperty("Dss_Cancellation_Api_Url");
   }

   public String getDssOverrideApiUrl() {
      return this.pbmConfigs.getProperty("Dss_Override_Api_Url");
   }

   public String getEnableDirectAccessToDss() {
      return this.pbmConfigs.getProperty("Enable_Direct_Access_To_Dss");
   }
}
