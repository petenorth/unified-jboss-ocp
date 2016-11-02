//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.02 at 02:34:25 PM GMT 
//


package com.redhat.ukiservices.etl.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Train Status. Update to the "real time" forecast data for a service.
 * 
 * <p>Java class for TS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LateReason" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DisruptionReasonType" minOccurs="0"/&gt;
 *         &lt;element name="Location" type="{http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2}TSLocation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="rid" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}RIDType" /&gt;
 *       &lt;attribute name="uid" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}UIDType" /&gt;
 *       &lt;attribute name="ssd" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}RTTIDateType" /&gt;
 *       &lt;attribute name="isReverseFormation" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TS", namespace = "http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2", propOrder = {
    "lateReason",
    "location"
})
public class TS {

    @XmlElement(name = "LateReason")
    protected DisruptionReasonType lateReason;
    @XmlElement(name = "Location")
    protected List<TSLocation> location;
    @XmlAttribute(name = "rid", required = true)
    protected String rid;
    @XmlAttribute(name = "uid", required = true)
    protected String uid;
    @XmlAttribute(name = "ssd", required = true)
    protected XMLGregorianCalendar ssd;
    @XmlAttribute(name = "isReverseFormation")
    protected Boolean isReverseFormation;

    /**
     * Gets the value of the lateReason property.
     * 
     * @return
     *     possible object is
     *     {@link DisruptionReasonType }
     *     
     */
    public DisruptionReasonType getLateReason() {
        return lateReason;
    }

    /**
     * Sets the value of the lateReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisruptionReasonType }
     *     
     */
    public void setLateReason(DisruptionReasonType value) {
        this.lateReason = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the location property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSLocation }
     * 
     * 
     */
    public List<TSLocation> getLocation() {
        if (location == null) {
            location = new ArrayList<TSLocation>();
        }
        return this.location;
    }

    /**
     * Gets the value of the rid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRid() {
        return rid;
    }

    /**
     * Sets the value of the rid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRid(String value) {
        this.rid = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the ssd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSsd() {
        return ssd;
    }

    /**
     * Sets the value of the ssd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSsd(XMLGregorianCalendar value) {
        this.ssd = value;
    }

    /**
     * Gets the value of the isReverseFormation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsReverseFormation() {
        if (isReverseFormation == null) {
            return false;
        } else {
            return isReverseFormation;
        }
    }

    /**
     * Sets the value of the isReverseFormation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsReverseFormation(Boolean value) {
        this.isReverseFormation = value;
    }

}
