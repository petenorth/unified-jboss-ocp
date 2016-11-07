package com.redhat.ukiservices.etl.model.common;

import java.util.Map;

public interface IRefData {

	public RefDataType getRDType();

	public void setRDType(RefDataType rdType);

	public String getCode();

	public void setCode(String code);

	public Map<String, String> getAlternateCodes();

	public void setAlternateCodes(Map<String, String> code);

	public String getValue();

	public void setValue(String value);

}
