//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.02 at 02:34:25 PM GMT 
//


package com.redhat.ukiservices.etl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="QueryTimetable" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="TimeTableId"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1&gt;TimetableIDType"&gt;
 *                 &lt;attribute name="ttfile" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TimetableFilenameType" /&gt;
 *                 &lt;attribute name="ttreffile" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TimetableFilenameType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GetSnapshotReq"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="viaftp" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GetFullSnapshotReq"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="viaftp" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SnapshotId" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}SnapshotIDType"/&gt;
 *         &lt;element name="StartUpdateReq" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="StopUpdateReq" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="FailureResp"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://thalesgroup.com/RTTI/PushPortStatus/root_1&gt;StatusType"&gt;
 *                 &lt;attribute name="requestSource" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}SourceTypeInst" /&gt;
 *                 &lt;attribute name="requestID" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DCISRequestID" /&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="uR"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://www.thalesgroup.com/rtti/PushPort/v12}DataResponse"&gt;
 *                 &lt;attribute name="updateOrigin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="requestSource" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}SourceTypeInst" /&gt;
 *                 &lt;attribute name="requestID" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DCISRequestID" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sR" type="{http://www.thalesgroup.com/rtti/PushPort/v12}DataResponse"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="ts" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}RTTIDateTimeType" /&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "queryTimetable",
    "timeTableId",
    "getSnapshotReq",
    "getFullSnapshotReq",
    "snapshotId",
    "startUpdateReq",
    "stopUpdateReq",
    "failureResp",
    "ur",
    "sr"
})
@XmlRootElement(name = "Pport", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
public class Pport {

    @XmlElement(name = "QueryTimetable", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Object queryTimetable;
    @XmlElement(name = "TimeTableId", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Pport.TimeTableId timeTableId;
    @XmlElement(name = "GetSnapshotReq", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Pport.GetSnapshotReq getSnapshotReq;
    @XmlElement(name = "GetFullSnapshotReq", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Pport.GetFullSnapshotReq getFullSnapshotReq;
    @XmlElement(name = "SnapshotId", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected String snapshotId;
    @XmlElement(name = "StartUpdateReq", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Object startUpdateReq;
    @XmlElement(name = "StopUpdateReq", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Object stopUpdateReq;
    @XmlElement(name = "FailureResp", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Pport.FailureResp failureResp;
    @XmlElement(name = "uR", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected Pport.UR ur;
    @XmlElement(name = "sR", namespace = "http://www.thalesgroup.com/rtti/PushPort/v12")
    protected DataResponse sr;
    @XmlAttribute(name = "ts", required = true)
    protected XMLGregorianCalendar ts;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the queryTimetable property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getQueryTimetable() {
        return queryTimetable;
    }

    /**
     * Sets the value of the queryTimetable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setQueryTimetable(Object value) {
        this.queryTimetable = value;
    }

    /**
     * Gets the value of the timeTableId property.
     * 
     * @return
     *     possible object is
     *     {@link Pport.TimeTableId }
     *     
     */
    public Pport.TimeTableId getTimeTableId() {
        return timeTableId;
    }

    /**
     * Sets the value of the timeTableId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pport.TimeTableId }
     *     
     */
    public void setTimeTableId(Pport.TimeTableId value) {
        this.timeTableId = value;
    }

    /**
     * Gets the value of the getSnapshotReq property.
     * 
     * @return
     *     possible object is
     *     {@link Pport.GetSnapshotReq }
     *     
     */
    public Pport.GetSnapshotReq getGetSnapshotReq() {
        return getSnapshotReq;
    }

    /**
     * Sets the value of the getSnapshotReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pport.GetSnapshotReq }
     *     
     */
    public void setGetSnapshotReq(Pport.GetSnapshotReq value) {
        this.getSnapshotReq = value;
    }

    /**
     * Gets the value of the getFullSnapshotReq property.
     * 
     * @return
     *     possible object is
     *     {@link Pport.GetFullSnapshotReq }
     *     
     */
    public Pport.GetFullSnapshotReq getGetFullSnapshotReq() {
        return getFullSnapshotReq;
    }

    /**
     * Sets the value of the getFullSnapshotReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pport.GetFullSnapshotReq }
     *     
     */
    public void setGetFullSnapshotReq(Pport.GetFullSnapshotReq value) {
        this.getFullSnapshotReq = value;
    }

    /**
     * Gets the value of the snapshotId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * Sets the value of the snapshotId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnapshotId(String value) {
        this.snapshotId = value;
    }

    /**
     * Gets the value of the startUpdateReq property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getStartUpdateReq() {
        return startUpdateReq;
    }

    /**
     * Sets the value of the startUpdateReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStartUpdateReq(Object value) {
        this.startUpdateReq = value;
    }

    /**
     * Gets the value of the stopUpdateReq property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getStopUpdateReq() {
        return stopUpdateReq;
    }

    /**
     * Sets the value of the stopUpdateReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStopUpdateReq(Object value) {
        this.stopUpdateReq = value;
    }

    /**
     * Gets the value of the failureResp property.
     * 
     * @return
     *     possible object is
     *     {@link Pport.FailureResp }
     *     
     */
    public Pport.FailureResp getFailureResp() {
        return failureResp;
    }

    /**
     * Sets the value of the failureResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pport.FailureResp }
     *     
     */
    public void setFailureResp(Pport.FailureResp value) {
        this.failureResp = value;
    }

    /**
     * Gets the value of the ur property.
     * 
     * @return
     *     possible object is
     *     {@link Pport.UR }
     *     
     */
    public Pport.UR getUR() {
        return ur;
    }

    /**
     * Sets the value of the ur property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pport.UR }
     *     
     */
    public void setUR(Pport.UR value) {
        this.ur = value;
    }

    /**
     * Gets the value of the sr property.
     * 
     * @return
     *     possible object is
     *     {@link DataResponse }
     *     
     */
    public DataResponse getSR() {
        return sr;
    }

    /**
     * Sets the value of the sr property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataResponse }
     *     
     */
    public void setSR(DataResponse value) {
        this.sr = value;
    }

    /**
     * Gets the value of the ts property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTs() {
        return ts;
    }

    /**
     * Sets the value of the ts property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTs(XMLGregorianCalendar value) {
        this.ts = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://thalesgroup.com/RTTI/PushPortStatus/root_1&gt;StatusType"&gt;
     *       &lt;attribute name="requestSource" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}SourceTypeInst" /&gt;
     *       &lt;attribute name="requestID" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DCISRequestID" /&gt;
     *       &lt;anyAttribute processContents='lax'/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FailureResp
        extends StatusType
    {

        @XmlAttribute(name = "requestSource")
        protected String requestSource;
        @XmlAttribute(name = "requestID")
        protected String requestID;

        /**
         * Gets the value of the requestSource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestSource() {
            return requestSource;
        }

        /**
         * Sets the value of the requestSource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestSource(String value) {
            this.requestSource = value;
        }

        /**
         * Gets the value of the requestID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestID() {
            return requestID;
        }

        /**
         * Sets the value of the requestID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestID(String value) {
            this.requestID = value;
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
     *       &lt;attribute name="viaftp" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GetFullSnapshotReq {

        @XmlAttribute(name = "viaftp")
        protected Boolean viaftp;

        /**
         * Gets the value of the viaftp property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isViaftp() {
            if (viaftp == null) {
                return false;
            } else {
                return viaftp;
            }
        }

        /**
         * Sets the value of the viaftp property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setViaftp(Boolean value) {
            this.viaftp = value;
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
     *       &lt;attribute name="viaftp" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GetSnapshotReq {

        @XmlAttribute(name = "viaftp")
        protected Boolean viaftp;

        /**
         * Gets the value of the viaftp property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isViaftp() {
            if (viaftp == null) {
                return false;
            } else {
                return viaftp;
            }
        }

        /**
         * Sets the value of the viaftp property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setViaftp(Boolean value) {
            this.viaftp = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1&gt;TimetableIDType"&gt;
     *       &lt;attribute name="ttfile" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TimetableFilenameType" /&gt;
     *       &lt;attribute name="ttreffile" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TimetableFilenameType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TimeTableId {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "ttfile", required = true)
        protected String ttfile;
        @XmlAttribute(name = "ttreffile", required = true)
        protected String ttreffile;

        /**
         * Unique Timetable identifier 
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the ttfile property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTtfile() {
            return ttfile;
        }

        /**
         * Sets the value of the ttfile property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTtfile(String value) {
            this.ttfile = value;
        }

        /**
         * Gets the value of the ttreffile property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTtreffile() {
            return ttreffile;
        }

        /**
         * Sets the value of the ttreffile property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTtreffile(String value) {
            this.ttreffile = value;
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
     *     &lt;extension base="{http://www.thalesgroup.com/rtti/PushPort/v12}DataResponse"&gt;
     *       &lt;attribute name="updateOrigin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="requestSource" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}SourceTypeInst" /&gt;
     *       &lt;attribute name="requestID" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DCISRequestID" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UR
        extends DataResponse
    {

        @XmlAttribute(name = "updateOrigin")
        protected String updateOrigin;
        @XmlAttribute(name = "requestSource")
        protected String requestSource;
        @XmlAttribute(name = "requestID")
        protected String requestID;

        /**
         * Gets the value of the updateOrigin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUpdateOrigin() {
            return updateOrigin;
        }

        /**
         * Sets the value of the updateOrigin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUpdateOrigin(String value) {
            this.updateOrigin = value;
        }

        /**
         * Gets the value of the requestSource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestSource() {
            return requestSource;
        }

        /**
         * Sets the value of the requestSource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestSource(String value) {
            this.requestSource = value;
        }

        /**
         * Gets the value of the requestID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestID() {
            return requestID;
        }

        /**
         * Sets the value of the requestID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestID(String value) {
            this.requestID = value;
        }

    }

}
