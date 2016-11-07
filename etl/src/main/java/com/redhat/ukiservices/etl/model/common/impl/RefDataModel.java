package com.redhat.ukiservices.etl.model.common.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.redhat.ukiservices.etl.model.common.IRefData;
import com.redhat.ukiservices.etl.model.common.RefDataType;

@Indexed
public class RefDataModel implements IRefData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4473274870937954222L;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefDataModel [getRDType()=");
		builder.append(getRDType());
		builder.append(", getCode()=");
		builder.append(getCode());
		builder.append(", getAlternateCodes()=");
		builder.append(getAlternateCodes());
		builder.append(", getValue()=");
		builder.append(getValue());
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternateCodes == null) ? 0 : alternateCodes.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((rdType == null) ? 0 : rdType.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefDataModel other = (RefDataModel) obj;
		if (alternateCodes == null) {
			if (other.alternateCodes != null)
				return false;
		} else if (!alternateCodes.equals(other.alternateCodes))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equalsIgnoreCase(other.code))
			return false;
		if (rdType != other.rdType)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equalsIgnoreCase(other.value))
			return false;
		return true;
	}

}
