/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.audit.dto;

import java.time.Instant;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * The event data belonging to the audit event.
 */
public class EventData {

  /**
   * Builder class to create event data easily. This is not a typical builder class, because onece
   * the value is defined the EventData is built.
   */
  public static class Builder {

    private final String eventDataName;

    private EventDataType eventDataType;

    private double numberValue;

    private String textValue;

    private Instant timestampValue;

    /**
     * Deep copy constructor.
     *
     * @param eventData
     *          the original event data to copy deeply, cannot be <code>null</code>.
     */
    public Builder(final EventData eventData) {
      Objects.requireNonNull(eventData, "eventData cannot be null");
      eventDataName = eventData.eventDataName;
      eventDataType = eventData.eventDataType;
      numberValue = eventData.numberValue;
      textValue = eventData.textValue;
      timestampValue = eventData.timestampValue;
    }

    public Builder(final String eventDataName) {
      this.eventDataName = Objects.requireNonNull(eventDataName, "eventDataName cannot be null");
    }

    public EventData build() {
      return new EventData(this);
    }

    /**
     * Builds an event data with the given number value and sets its data type to
     * {@link EventDataType#NUMBER}.
     */
    public EventData buildNumberValue(final double numberValue) {
      this.numberValue = numberValue;
      eventDataType = EventDataType.NUMBER;
      return new EventData(this);
    }

    /**
     * Builds an event data with the given string value, validates its length against
     * {@link EventDataType#STRING_MAX_LENGTH} and sets its data type to
     * {@link EventDataType#STRING}.
     */
    public EventData buildStringValue(final String stringValue) {
      if (stringValue.length() > EventDataType.STRING_MAX_LENGTH) {
        throw new IllegalArgumentException("too long ["
            + stringValue.length() + "] string value provided, the maximum supported is ["
            + EventDataType.STRING_MAX_LENGTH + "]");
      }
      textValue = stringValue;
      eventDataType = EventDataType.STRING;
      return new EventData(this);
    }

    /**
     * Builds an event data with the given text value and sets its data type to
     * {@link EventDataType#TEXT}.
     *
     * @param shortString
     *          <code>true</code> if the length of the string value is always less than
     *          org.everit.audit.api.dto.STRING_MAX_LENGTH (in that case the
     *          {@link EventDataType#STRING} will be used), <code>false</code> otherwise.
     */
    public EventData buildTextValue(final boolean shortString, final String textValue) {
      this.textValue = textValue;
      eventDataType = shortString ? EventDataType.STRING : EventDataType.TEXT;
      return new EventData(this);
    }

    /**
     * Builds an event data with the given time stamp value and sets its data type to
     * {@link EventDataType#TIMESTAMP}.
     */
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
   * Default constructor.
   */
  public EventData() {
  }

  private EventData(final Builder builder) {
    eventDataName = builder.eventDataName;
    eventDataType = Objects.requireNonNull(builder.eventDataType, "eventDataType cannot be null");
    numberValue = builder.numberValue;
    textValue = builder.textValue;
    timestampValue = builder.timestampValue;
  }

  /**
   * Deep copy constructor.
   *
   * @param original
   *          the original instance to copy deeply, cannot be <code>null</code>.
   */
  public EventData(final EventData original) {
    Objects.requireNonNull(original, "original cannot be null");
    eventDataName = original.eventDataName;
    eventDataType = original.eventDataType;
    numberValue = original.numberValue;
    textValue = original.textValue;
    timestampValue = original.timestampValue;
  }

  @Override
  @Generated("eclipse")
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
  @Generated(value = "eclipse")
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    return "EventData [eventDataName=" + eventDataName + ", eventDataType=" + eventDataType
        + ", numberValue=" + numberValue + ", textValue=" + textValue + ", timestampValue="
        + timestampValue + "]";
  }
}
