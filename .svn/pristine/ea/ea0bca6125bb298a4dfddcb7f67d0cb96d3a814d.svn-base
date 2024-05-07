package com.enayapbm.business;

import java.util.LinkedList;
import java.util.List;

public class Violation extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private List<String> listOfViolations;
	private String messageTemplate;
	private MessageTemplate violationCause;

	public Violation() {
		listOfViolations = new LinkedList<String>();
	}

	public Violation addAll(MessageTemplate violationMessageTemplate,
			List<String> v) {
		setMessageTemplate(violationMessageTemplate.value());
		violationCause = violationMessageTemplate;
		listOfViolations.addAll(v);
		return this;
	}

	public Violation add(MessageTemplate violationMessageTemplate, String... v) {
		setMessageTemplate(violationMessageTemplate.value());
		violationCause = violationMessageTemplate;
		for (String violation : v) {
			listOfViolations.add(violation);
		}
		return this;
	}

	@Override
	public String getMessage() {
		try {
			StringBuffer buffer = new StringBuffer();
			for (String violation : listOfViolations) {
				buffer.append(violation).append(" ");
			}
//			buffer.append(messageTemplate);
			return buffer.toString().trim();
		} catch (Exception e) {
			return "";
		}
	}

	public MessageTemplate getViolationCause() {
		return violationCause;
	}

	public void setViolationCause(MessageTemplate template) {
		violationCause = template;
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

	public enum MessageTemplate {
		Empty(""), NotValid("not valid!"), NotFormed("not generated!"), NotValidResponse(
				"not generated!"), NotReceived("not received!"), NotMatched(
				"not matched!"), NotSupported("not supported!"), NotSent("not sent!"), Error(
				"Please Contact Waseel"), NotAuthorized(""), Unknown(
				"Please Contact Waseel");

		private final String value;

		MessageTemplate(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		public static MessageTemplate fromValue(String v) {
			for (MessageTemplate c : MessageTemplate.values()) {
				if (c.value.equals(v)) {
					return c;
				}
			}
			throw new IllegalArgumentException(v);
		}
	}
}
