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
package org.everit.audit.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * The audit event that can be logged.
 */
public class AuditEvent {

  /**
   * Builder class to build the audit event easily. For example:<br>
   * <br>
   * <blockquote>
   *
   * <pre>
   * AuditEvent event = new AuditEvent.Builder().eventTypeName(&quot;myEvent&quot;)
   *     .addStringEventData(&quot;name&quot;, &quot;John&quot;)
   *     .addTextEventData(&quot;description&quot;, false, &quot;lorem ipsum&quot;)
   *     .addNumberEventData(&quot;age&quot;, 18)
   *     .addTimestampEventData(&quot;registered&quot;, Instant.now())
   *     .build();
   * </pre>
   *
   * </blockquote>
   */
  public static class Builder {

    private final List<EventData> eventDataList = new ArrayList<EventData>();

    private String eventTypeName;

    private Instant occuredAt = Instant.now();

    /**
     * Default constructor.
     */
    public Builder() {
    }

    /**
     * Deep copy constructor.
     *
     * @param auditEvent
     *          the original AuditEvent to copy deeply, cannot be <code>null</code>.
     */
    public Builder(final AuditEvent auditEvent) {
      Objects.requireNonNull(auditEvent, "auditEvent cannot be null");
      eventTypeName = auditEvent.eventTypeName;
      occuredAt = auditEvent.occuredAt;
      for (EventData eventData : auditEvent.eventDataArray) {
        eventDataList.add(new EventData.Builder(eventData).build());
      }
    }

    public Builder addEventData(final EventData eventData) {
      eventDataList.add(new EventData.Builder(eventData).build());
      return this;
    }

    /**
     * See the documentation of {@link Builder}.
     */
    public Builder addNumberEventData(final String eventDataName, final double numberValue) {
      eventDataList.add(createBuilder(eventDataName).buildNumberValue(numberValue));
      return this;
    }

    /**
     * See the documentation of {@link Builder}.
     */
    public Builder addStringEventData(final String eventDataName, final String stringValue) {
      eventDataList.add(createBuilder(eventDataName).buildStringValue(stringValue));
      return this;
    }

    /**
     * See the documentation of {@link Builder}.
     */
    public Builder addTextEventData(final String eventDataName, final boolean shortString,
        final String textValue) {
      eventDataList.add(createBuilder(eventDataName).buildTextValue(shortString, textValue));
      return this;
    }

    /**
     * See the documentation of {@link Builder}.
     */
    public Builder addTimestampEventData(final String eventDataName, final Instant timestampValue) {
      eventDataList.add(createBuilder(eventDataName).buildTimestampValue(timestampValue));
      return this;
    }

    public AuditEvent build() {
      return new AuditEvent(this);
    }

    private EventData.Builder createBuilder(final String eventDataName) {
      return new EventData.Builder(eventDataName);
    }

    public Builder eventTypeName(final String eventTypeName) {
      this.eventTypeName = eventTypeName;
      return this;
    }

    public Builder occuredAt(final Instant occuredAt) {
      this.occuredAt = occuredAt;
      return this;
    }

  }

  /**
   * The data array belonging to the event.
   */
  public EventData[] eventDataArray;

  /**
   * The name of the event type.
   */
  public String eventTypeName;

  /**
   * Timestamp when the event occured at.
   */
  public Instant occuredAt;

  /**
   * Default constructor.
   */
  public AuditEvent() {
  }

  /**
   * Deep copy constructor.
   *
   * @param original
   *          the original instance to copy deeply, cannot be <code>null</code>.
   */
  public AuditEvent(final AuditEvent original) {
    Objects.requireNonNull(original, "original cannot be null");
    eventTypeName = original.eventTypeName;
    occuredAt = original.occuredAt;
    int eventDataSize = original.eventDataArray.length;
    eventDataArray = new EventData[eventDataSize];
    int index = 0;
    for (EventData eventData : original.eventDataArray) {
      eventDataArray[index] = new EventData.Builder(eventData).build();
      index++;
    }
  }

  private AuditEvent(final Builder builder) {
    super();
    eventTypeName = Objects.requireNonNull(builder.eventTypeName, "eventTypeName cannot be null");
    occuredAt = Objects.requireNonNull(builder.occuredAt, "occuredAt cannot be null");
    int eventDataSize = builder.eventDataList.size();
    eventDataArray = new EventData[eventDataSize];
    int index = 0;
    for (EventData eventData : builder.eventDataList) {
      eventDataArray[index] = new EventData.Builder(eventData).build();
      index++;
    }
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
    AuditEvent other = (AuditEvent) obj;
    if (!Arrays.equals(eventDataArray, other.eventDataArray)) {
      return false;
    }
    if (eventTypeName == null) {
      if (other.eventTypeName != null) {
        return false;
      }
    } else if (!eventTypeName.equals(other.eventTypeName)) {
      return false;
    }
    if (occuredAt == null) {
      if (other.occuredAt != null) {
        return false;
      }
    } else if (!occuredAt.equals(other.occuredAt)) {
      return false;
    }
    return true;
  }

  @Override
  @Generated("eclipse")
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + Arrays.hashCode(eventDataArray);
    result = (prime * result) + ((eventTypeName == null) ? 0 : eventTypeName.hashCode());
    result = (prime * result) + ((occuredAt == null) ? 0 : occuredAt.hashCode());
    return result;
  }

  @Override
  @Generated("eclipse")
  public String toString() {
    return "AuditEvent [eventTypeName=" + eventTypeName + ", occuredAt=" + occuredAt
        + ", eventDataArray="
        + Arrays.toString(eventDataArray) + "]";
  }

}
