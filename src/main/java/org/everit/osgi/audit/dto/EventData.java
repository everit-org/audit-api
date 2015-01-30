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
package org.everit.osgi.audit.dto;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

public class EventData {

    public static class Builder {

        private final String eventDataName;

        private EventDataType eventDataType;

        private double numberValue;

        private String textValue;

        private Instant timestampValue;

        private byte[] binaryValue;

        public Builder(final EventData eventData) {
            Objects.requireNonNull(eventData, "eventData cannot be null");
            eventDataName = eventData.eventDataName;
            eventDataType = eventData.eventDataType;
            numberValue = eventData.numberValue;
            textValue = eventData.textValue;
            timestampValue = eventData.timestampValue;
            binaryValue = eventData.binaryValue == null ? null :
                    Arrays.copyOf(eventData.binaryValue, eventData.binaryValue.length);
        }

        public Builder(final String eventDataName) {
            this.eventDataName = Objects.requireNonNull(eventDataName, "eventDataName cannot be null");
        }

        public EventData build() {
            return new EventData(this);
        }

        public EventData buildBinaryValue(final byte[] binaryValue) {
            this.binaryValue = binaryValue;
            eventDataType = EventDataType.BINARY;
            return new EventData(this);
        }

        public EventData buildNumberValue(final double numberValue) {
            this.numberValue = numberValue;
            eventDataType = EventDataType.NUMBER;
            return new EventData(this);
        }

        public EventData buildStringValue(final String stringValue) {
            textValue = stringValue;
            eventDataType = EventDataType.STRING;
            return new EventData(this);
        }

        /**
         * @param shortString
         *            <code>true</code> if the length of the string value is always less than
         *            org.everit.audit.api.dto.STRING_MAX_LENGTH, <code>false</code> otherwise.
         */
        public EventData buildTextValue(final boolean shortString, final String textValue) {
            this.textValue = textValue;
            eventDataType = shortString ? EventDataType.STRING : EventDataType.TEXT;
            return new EventData(this);
        }

        public EventData buildTimestampValue(final Instant timestampValue) {
            this.timestampValue = timestampValue;
            eventDataType = EventDataType.TIMESTAMP;
            return new EventData(this);
        }

    }

    /**
     * The name of the data element.
     */
    public String eventDataName;

    /**
     * The type of the event data.
     */
    public EventDataType eventDataType;

    /**
     * Number value of the event data. Used only if the data type is number.
     */
    public double numberValue;

    /**
     * Text value of the event data. Used only if the data type is string or text.
     */
    public String textValue;

    /**
     * Timestamp value of the event data. Used only if the data type is timestamp.
     */
    public Instant timestampValue;

    /**
     * Binary value of the event data. Used only if the data type is binary.
     */
    public byte[] binaryValue;

    public EventData() {
    }

    private EventData(final Builder builder) {
        eventDataName = builder.eventDataName;
        eventDataType = Objects.requireNonNull(builder.eventDataType, "eventDataType cannot be null");
        numberValue = builder.numberValue;
        textValue = builder.textValue;
        timestampValue = builder.timestampValue;
        binaryValue = builder.binaryValue == null ? null :
                Arrays.copyOf(builder.binaryValue, builder.binaryValue.length);
    }

    public EventData(final EventData original) {
        Objects.requireNonNull(original, "original cannot be null");
        eventDataName = original.eventDataName;
        eventDataType = original.eventDataType;
        numberValue = original.numberValue;
        textValue = original.textValue;
        timestampValue = original.timestampValue;
        binaryValue = original.binaryValue == null ? null :
                Arrays.copyOf(original.binaryValue, original.binaryValue.length);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EventData other = (EventData) obj;
        if (!Arrays.equals(binaryValue, other.binaryValue)) {
            return false;
        }
        if (eventDataType != other.eventDataType) {
            return false;
        }
        if (eventDataName == null) {
            if (other.eventDataName != null) {
                return false;
            }
        } else if (!eventDataName.equals(other.eventDataName)) {
            return false;
        }
        if (Double.doubleToLongBits(numberValue) != Double.doubleToLongBits(other.numberValue)) {
            return false;
        }
        if (textValue == null) {
            if (other.textValue != null) {
                return false;
            }
        } else if (!textValue.equals(other.textValue)) {
            return false;
        }
        if (timestampValue == null) {
            if (other.timestampValue != null) {
                return false;
            }
        } else if (!timestampValue.equals(other.timestampValue)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + Arrays.hashCode(binaryValue);
        result = (prime * result) + ((eventDataType == null) ? 0 : eventDataType.hashCode());
        result = (prime * result) + ((eventDataName == null) ? 0 : eventDataName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(numberValue);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + ((textValue == null) ? 0 : textValue.hashCode());
        result = (prime * result) + ((timestampValue == null) ? 0 : timestampValue.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventData [eventDataName=" + eventDataName + ", eventDataType=" + eventDataType + ", numberValue="
                + numberValue + ", textValue=" + textValue + ", timestampValue=" + timestampValue + ", binaryValue="
                + Arrays.toString(binaryValue) + "]";
    }

}
