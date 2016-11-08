package com.redhat.ukiservices.etl.model.common;

import java.util.HashMap;

public interface IRefData {

	public RefDataType getRDType();

	public void setRDType(RefDataType rdType);

	public String getCode();

	public void setCode(String code);

	public HashMap<String, String> getAlternateCodes();

	public void setAlternateCodes(HashMap<String, String> code);

	public String getValue();

	public void setValue(String value);

}
