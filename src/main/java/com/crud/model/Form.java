package com.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "forms")
public class Form {
    public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public Form() {
		
	}
	@Override
	public String toString() {
		return "Form [formId=" + formId + ", formName=" + formName + ", formJson=" + formJson + ", formCreateDate="
				+ formCreateDate + ", formModifiedDate=" + formModifiedDate + ", clientIds=" + clientIds + "]";
	}
	public Form(String formId, String formName, String formJson, Instant formCreateDate, Instant formModifiedDate,
			List<String> clientIds) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.formJson = formJson;
		this.formCreateDate = formCreateDate;
		this.formModifiedDate = formModifiedDate;
		this.clientIds = clientIds;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormJson() {
		return formJson;
	}
	public void setFormJson(String formJson) {
		this.formJson = formJson;
	}
	public Instant getFormCreateDate() {
		return formCreateDate;
	}
	public void setFormCreateDate(Instant formCreateDate) {
		this.formCreateDate = formCreateDate;
	}
	public Instant getFormModifiedDate() {
		return formModifiedDate;
	}
	public void setFormModifiedDate(Instant formModifiedDate) {
		this.formModifiedDate = formModifiedDate;
	}
	public List<String> getClientIds() {
		return clientIds;
	}
	public void setClientIds(List<String> clientIds) {
		this.clientIds = clientIds;
	}
	@Id
    private String formId;
    private String formName;
    private String formJson;
    private Instant formCreateDate;
    private Instant formModifiedDate;
    private List<String> clientIds; // List of associated Client IDs

    // Getters and Setters
}
