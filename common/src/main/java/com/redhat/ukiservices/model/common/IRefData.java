package com.redhat.ukiservices.model.common;

import java.util.ArrayList;

public interface IRefData {

	public RefDataType getRDType();

	public void setRDType(RefDataType rdType);

	public String getCode();

	public void setCode(String code);

	public ArrayList<String> getAlternateCodes();

	public void setAlternateCodes(ArrayList<String> alternateCodes);

	public String getValue();

	public void setValue(String value);

}
