//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.07 at 10:08:16 AM GMT 
//


package com.redhat.ukiservices.etl.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Forecast data for an individual location in the service's schedule
 * 
 * <p>Java class for TSLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSLocation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arr" type="{http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2}TSTimeData" minOccurs="0"/&gt;
 *         &lt;element name="dep" type="{http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2}TSTimeData" minOccurs="0"/&gt;
 *         &lt;element name="pass" type="{http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2}TSTimeData" minOccurs="0"/&gt;
 *         &lt;element name="plat" type="{http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2}PlatformData" minOccurs="0"/&gt;
 *         &lt;element name="suppr" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="length" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TrainLengthType" minOccurs="0"/&gt;
 *         &lt;element name="detachFront" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}CircularTimes"/&gt;
 *       &lt;attribute name="tpl" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TiplocType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSLocation", namespace = "http://www.thalesgroup.com/rtti/PushPort/Forecasts/v2", propOrder = {
    "arr",
    "dep",
    "pass",
    "plat",
    "suppr",
    "length",
    "detachFront"
})
public class TSLocation {

    protected TSTimeData arr;
    protected TSTimeData dep;
    protected TSTimeData pass;
    protected PlatformData plat;
    @XmlElement(defaultValue = "false")
    protected Boolean suppr;
    @XmlElement(defaultValue = "0")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer length;
    @XmlElement(defaultValue = "false")
    protected Boolean detachFront;
    @XmlAttribute(name = "tpl", required = true)
    protected String tpl;
    @XmlAttribute(name = "wta")
    protected String wta;
    @XmlAttribute(name = "wtd")
    protected String wtd;
    @XmlAttribute(name = "wtp")
    protected String wtp;
    @XmlAttribute(name = "pta")
    protected String pta;
    @XmlAttribute(name = "ptd")
    protected String ptd;

    /**
     * Gets the value of the arr property.
     * 
     * @return
     *     possible object is
     *     {@link TSTimeData }
     *     
     */
    public TSTimeData getArr() {
        return arr;
    }

    /**
     * Sets the value of the arr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSTimeData }
     *     
     */
    public void setArr(TSTimeData value) {
        this.arr = value;
    }

    /**
     * Gets the value of the dep property.
     * 
     * @return
     *     possible object is
     *     {@link TSTimeData }
     *     
     */
    public TSTimeData getDep() {
        return dep;
    }

    /**
     * Sets the value of the dep property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSTimeData }
     *     
     */
    public void setDep(TSTimeData value) {
        this.dep = value;
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link TSTimeData }
     *     
     */
    public TSTimeData getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSTimeData }
     *     
     */
    public void setPass(TSTimeData value) {
        this.pass = value;
    }

    /**
     * Gets the value of the plat property.
     * 
     * @return
     *     possible object is
     *     {@link PlatformData }
     *     
     */
    public PlatformData getPlat() {
        return plat;
    }

    /**
     * Sets the value of the plat property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlatformData }
     *     
     */
    public void setPlat(PlatformData value) {
        this.plat = value;
    }

    /**
     * Gets the value of the suppr property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuppr() {
        return suppr;
    }

    /**
     * Sets the value of the suppr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppr(Boolean value) {
        this.suppr = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLength(Integer value) {
        this.length = value;
    }

    /**
     * Gets the value of the detachFront property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDetachFront() {
        return detachFront;
    }

    /**
     * Sets the value of the detachFront property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDetachFront(Boolean value) {
        this.detachFront = value;
    }

    /**
     * Gets the value of the tpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpl() {
        return tpl;
    }

    /**
     * Sets the value of the tpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpl(String value) {
        this.tpl = value;
    }

    /**
     * Gets the value of the wta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWta() {
        return wta;
    }

    /**
     * Sets the value of the wta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWta(String value) {
        this.wta = value;
    }

    /**
     * Gets the value of the wtd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWtd() {
        return wtd;
    }

    /**
     * Sets the value of the wtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWtd(String value) {
        this.wtd = value;
    }

    /**
     * Gets the value of the wtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWtp() {
        return wtp;
    }

    /**
     * Sets the value of the wtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWtp(String value) {
        this.wtp = value;
    }

    /**
     * Gets the value of the pta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPta() {
        return pta;
    }

    /**
     * Sets the value of the pta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPta(String value) {
        this.pta = value;
    }

    /**
     * Gets the value of the ptd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtd() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtd(String value) {
        this.ptd = value;
    }

}
