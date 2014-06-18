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
import java.util.GregorianCalendar;
import java.util.Objects;

public class EventData {

    /**
     * The name of the data element.
     */
    private final String name;

    /**
     * The type of the event data.
     */
    private final EventDataType eventDataType;

    /**
     * Number value of the event data. Used only if the data type is number.
     */
    private double numberValue;

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
        this(name, shortString ? EventDataType.STRING : EventDataType.TEXT);
        this.textValue = Objects.requireNonNull(textValue, "textValue cannot be null");
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
        this(name, EventDataType.BINARY);
        this.binaryValue = Objects.requireNonNull(binaryValue, "binaryValue cannot be null");
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
        this(name, EventDataType.TIMESTAMP);
        this.timestampValue = Objects.requireNonNull(timestampValue, "timestampValue cannot be null");
    }

    /**
     * Constructor for number property.
     *
     * @param name
     *            The name of the property.
     * @param numberValue
     *            The value of the property.
     */
    public EventData(final String name, final double numberValue) {
        this(name, EventDataType.NUMBER);
        this.numberValue = numberValue;
    }

    private EventData(final String name, final EventDataType eventDataType) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.eventDataType = Objects.requireNonNull(eventDataType, "eventDataType cannot be null");
    }

    /**
     * Constructor for JPA queries.
     */
    public EventData(final String name, final EventDataType eventDataType, final Double numberValue,
            final String stringValue, final String textValue, final Calendar timestampValue, final byte[] binaryValue) {
        this(name, eventDataType);
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
        this(name, EventDataType.STRING);
        textValue = stringValue;
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

    public double getNumberValue() {
        return numberValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public Calendar getTimestampValue() {
        GregorianCalendar rval = new GregorianCalendar();
        rval.setTimeInMillis(timestampValue.getTimeInMillis());
        return rval;
    }

}
