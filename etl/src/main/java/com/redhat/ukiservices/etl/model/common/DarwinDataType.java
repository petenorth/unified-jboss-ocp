package com.redhat.ukiservices.etl.model.common;

import org.infinispan.protostream.annotations.ProtoEnumValue;
import org.infinispan.protostream.annotations.ProtoMessage;

@ProtoMessage(name = "DarwinDataType")
public enum DarwinDataType {

	@ProtoEnumValue(number = 1, name = "TRAINSTATUS")
	TRAINSTATUS, 
	
	@ProtoEnumValue(number = 2, name = "STATIONMESSAGE")
	STATIONMESSAGE;

}
