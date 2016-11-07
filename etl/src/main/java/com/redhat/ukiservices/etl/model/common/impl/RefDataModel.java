package com.redhat.ukiservices.etl.model.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.redhat.ukiservices.etl.model.common.IRefData;
import com.redhat.ukiservices.etl.model.common.RefDataType;

@Indexed
public class RefDataModel implements IRefData {

	@Field
	private RefDataType rdType;
	@Field
	private String code;
	@Field
	private Map<String, String> alternateCodes;
	@Field
	private String value;

	public RefDataModel(RefDataType rdType, String code, String value) {
		this.rdType = rdType;
		this.code = code;
		this.value = value;
	}

	@Override
	public RefDataType getRDType() {
		return rdType;
	}

	@Override
	public void setRDType(RefDataType rdType) {
		this.rdType = rdType;

	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;

	}

	@Override
	public Map<String, String> getAlternateCodes() {
		if (alternateCodes == null) {
			alternateCodes = new HashMap<>();
		}
		return alternateCodes;
	}

	@Override
	public void setAlternateCodes(Map<String, String> codes) {
		this.alternateCodes = codes;

	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;

	}

}
