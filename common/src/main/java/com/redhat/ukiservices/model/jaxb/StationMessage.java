//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.07 at 10:08:16 AM GMT 
//


package com.redhat.ukiservices.model.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * Darwin Workstation Station Message
 * 
 * <p>Java class for StationMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StationMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Station" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="crs" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}CrsType" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Msg"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}p" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}a" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="cat" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}MsgCategoryType" /&gt;
 *       &lt;attribute name="sev" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}MsgSeverityType" /&gt;
 *       &lt;attribute name="suppress" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StationMessage", namespace = "http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1", propOrder = {
    "station",
    "msg"
})
public class StationMessage {

    @XmlElement(name = "Station")
    protected List<StationMessage.Station> station;
    @XmlElement(name = "Msg", required = true)
    protected StationMessage.Msg msg;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "cat", required = true)
    protected MsgCategoryType cat;
    @XmlAttribute(name = "sev", required = true)
    protected String sev;
    @XmlAttribute(name = "suppress")
    protected Boolean suppress;

    /**
     * Gets the value of the station property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the station property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StationMessage.Station }
     * 
     * 
     */
    public List<StationMessage.Station> getStation() {
        if (station == null) {
            station = new ArrayList<StationMessage.Station>();
        }
        return this.station;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link StationMessage.Msg }
     *     
     */
    public StationMessage.Msg getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link StationMessage.Msg }
     *     
     */
    public void setMsg(StationMessage.Msg value) {
        this.msg = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the cat property.
     * 
     * @return
     *     possible object is
     *     {@link MsgCategoryType }
     *     
     */
    public MsgCategoryType getCat() {
        return cat;
    }

    /**
     * Sets the value of the cat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgCategoryType }
     *     
     */
    public void setCat(MsgCategoryType value) {
        this.cat = value;
    }

    /**
     * Gets the value of the sev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSev() {
        return sev;
    }

    /**
     * Sets the value of the sev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSev(String value) {
        this.sev = value;
    }

    /**
     * Gets the value of the suppress property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSuppress() {
        if (suppress == null) {
            return false;
        } else {
            return suppress;
        }
    }

    /**
     * Sets the value of the suppress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppress(Boolean value) {
        this.suppress = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element ref="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}p" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element ref="{http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1}a" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Msg {

        @XmlElementRefs({
            @XmlElementRef(name = "a", namespace = "http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1", type = A.class, required = false),
            @XmlElementRef(name = "p", namespace = "http://www.thalesgroup.com/rtti/PushPort/StationMessages/v1", type = P.class, required = false)
        })
        @XmlMixed
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link P }
         * {@link A }
         * 
         * 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="crs" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}CrsType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Station {

        @XmlAttribute(name = "crs", required = true)
        protected String crs;

        /**
         * Gets the value of the crs property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCrs() {
            return crs;
        }

        /**
         * Sets the value of the crs property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCrs(String value) {
            this.crs = value;
        }

    }

}