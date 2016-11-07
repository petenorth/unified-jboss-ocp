//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.07 at 10:08:16 AM GMT 
//


package com.redhat.ukiservices.etl.model.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlertAudienceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AlertAudienceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Customer"/&gt;
 *     &lt;enumeration value="Staff"/&gt;
 *     &lt;enumeration value="Operations"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AlertAudienceType", namespace = "http://www.thalesgroup.com/rtti/PushPort/TrainAlerts/v1")
@XmlEnum
public enum AlertAudienceType {

    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("Staff")
    STAFF("Staff"),
    @XmlEnumValue("Operations")
    OPERATIONS("Operations");
    private final String value;

    AlertAudienceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlertAudienceType fromValue(String v) {
        for (AlertAudienceType c: AlertAudienceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}