package com.redhat.ukiservices.etl.model.common;

import org.infinispan.protostream.annotations.ProtoEnumValue;
import org.infinispan.protostream.annotations.ProtoMessage;

@ProtoMessage(name = "RefDataType")
public enum RefDataType {

	@ProtoEnumValue(number = 1, name = "LOCATION")
	LOCATION, 
	
	@ProtoEnumValue(number = 2, name = "CRS")
	CRS, 
	
	@ProtoEnumValue(number = 3, name = "CANCELLATIONREASON")
	CANCELLATIONREASON, 
	
	@ProtoEnumValue(number = 4, name = "LATEREASON")
	LATEREASON;

}
