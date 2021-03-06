package com.redhat.ukiservices.model.common.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.annotations.ProtoMessage;

import com.redhat.ukiservices.model.common.DarwinDataType;
import com.redhat.ukiservices.model.common.IDarwinData;


@Indexed
@ProtoMessage(name = "DarwinDataModel")
public class DarwinDataModel implements IDarwinData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4918206326578441127L;

	@Field(store = Store.YES, analyze = Analyze.YES)
	private DarwinDataType ddType;

	@Field(store = Store.YES, analyze = Analyze.YES)
	private String id;

	@Field(store = Store.YES, analyze = Analyze.YES)
	private String message;

	@IndexedEmbedded
	private ArrayList<String> locations;

	public DarwinDataModel() {
		// Default constructor for ProtoBuf purposes
	}

	public DarwinDataModel(DarwinDataType ddType, String id, String message, ArrayList<String> locations) {
		this.ddType = ddType;
		this.id = id;
		this.message = message;
		this.locations = locations;
	}

	@Override
	@ProtoField(number = 1, required = true)
	public DarwinDataType getDarwinDataType() {
		return ddType;
	}

	@Override
	public void setDarwinDataType(DarwinDataType ddType) {
		this.ddType = ddType;
	}

	@Override
	@ProtoField(number = 2, required = true)
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;

	}

	@Override
	@ProtoField(number = 3)
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;

	}

	@Override
	@ProtoField(number = 4)
	public ArrayList<String> getLocations() {

		if (locations == null) {
			locations = new ArrayList<String>();
		}

		return locations;
	}

	@Override
	public void setLocations(ArrayList<String> locations) {
		this.locations = locations;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DarwinDataModel [getDarwinDataType()=");
		builder.append(getDarwinDataType());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getMessage()=");
		builder.append(getMessage());
		builder.append(", getLocations()=");
		builder.append(getLocations());
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
		result = prime * result + ((ddType == null) ? 0 : ddType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		DarwinDataModel other = (DarwinDataModel) obj;
		if (ddType != other.ddType)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equalsIgnoreCase(other.id))
			return false;
		if (locations == null) {
			if (other.locations != null)
				return false;
		} else if (!locations.equals(other.locations))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equalsIgnoreCase(other.message))
			return false;
		return true;
	}

}
