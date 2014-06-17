/**
 * This file is part of Everit - Audit API.
 *
 * Everit - Audit API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Audit API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Audit API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.audit.api.dto;

import java.util.Calendar;

public class EventData {

    // TODO This class is not immutable, thus it implies a security issue.

    /**
     * The name of the data element.
     */
    private String name;

    /**
     * The type of the event data.
     */
    private EventDataType eventDataType;

    /**
     * Number value of the event data. Used only if the data type is number.
     */
    private Double numberValue;

    /**
     * Text value of the event data. Used only if the data type is string or text.
     */
    private String textValue;

    /**
     * Timestamp value of the event data. Used only if the data type is timestamp.
     */
    private Calendar timestampValue;

    /**
     * Binary value of the event data. Used only if the data type is binary.
     */
    private byte[] binaryValue;

    /**
     * Default constructor for jaxb.
     */
    public EventData() {
        super();
    }

    /**
     * Constructor for string property.
     *
     * @param name
     *            The name of the property.
     * @param shortString
     *            True, if the length of the string value is always less than
     *            org.everit.audit.api.dto.STRING_MAX_LENGTH, false otherwise.
     * @param textValue
     *            The value of the property.
     */
    public EventData(final String name, final boolean shortString, final String textValue) {
        super();
        this.name = name;
        this.textValue = textValue;
        if (shortString) {
            eventDataType = EventDataType.STRING;
        } else {
            eventDataType = EventDataType.TEXT;
        }
    }

    /**
     * Constructor for binary property.
     *
     * @param name
     *            The name of the property.
     * @param binaryValue
     *            The value of the property.
     */
    public EventData(final String name, final byte[] binaryValue) {
        super();
        this.name = name;
        this.binaryValue = binaryValue;
        eventDataType = EventDataType.BINARY;
    }

    /**
     * Constructor for timestamp property.
     *
     * @param name
     *            The name of the property.
     * @param timestampValue
     *            The value of the property.
     */
    public EventData(final String name, final Calendar timestampValue) {
        super();
        this.name = name;
        this.timestampValue = timestampValue;
        eventDataType = EventDataType.TIMESTAMP;
    }

    /**
     * Constructor for number property.
     *
     * @param name
     *            The name of the property.
     * @param numberValue
     *            The value of the property.
     */
    public EventData(final String name, final Double numberValue) {
        super();
        this.name = name;
        this.numberValue = numberValue;
        eventDataType = EventDataType.NUMBER;
    }

    /**
     * Constructor for JPA queries.
     */
    public EventData(final String name, final EventDataType eventDataType, final Double numberValue,
            final String stringValue, final String textValue, final Calendar timestampValue, final byte[] binaryValue) {
        this.name = name;
        this.eventDataType = eventDataType;
        this.numberValue = numberValue;
        if (stringValue != null) {
            this.textValue = stringValue;
        } else if (textValue != null) {
            this.textValue = textValue;
        } else {
            this.textValue = null;
        }
        this.timestampValue = timestampValue;
        this.binaryValue = binaryValue;
    }

    /**
     * Constructor for short string property.
     *
     * @param name
     *            The name of the property.
     * @param stringValue
     *            The value of the property. The length of the string value must be less than
     *            org.everit.audit.api.dto.STRING_MAX_LENGTH.
     */
    public EventData(final String name, final String stringValue) {
        super();
        this.name = name;
        textValue = stringValue;
        eventDataType = EventDataType.STRING;
    }

    public byte[] getBinaryValue() {
        return binaryValue;
    }

    public EventDataType getEventDataType() {
        return eventDataType;
    }

    public String getName() {
        return name;
    }

    public Double getNumberValue() {
        return numberValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public Calendar getTimestampValue() {
        return timestampValue;
    }

    public void setBinaryValue(final byte[] binaryValue) {
        this.binaryValue = binaryValue;
    }

    public void setEventDataType(final EventDataType eventDataType) {
        this.eventDataType = eventDataType;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setNumberValue(final Double numberValue) {
        this.numberValue = numberValue;
    }

    public void setTextValue(final String textValue) {
        this.textValue = textValue;
    }

    public void setTimestampValue(final Calendar timestampValue) {
        this.timestampValue = timestampValue;
    }

}
