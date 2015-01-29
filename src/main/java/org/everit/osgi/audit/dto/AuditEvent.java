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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AuditEvent {

    public static class Builder {

        private String eventTypeName;

        private Instant occuredAt = Instant.now();

        private final List<EventData> eventDataList = new ArrayList<>();

        public Builder() {
        }

        public Builder(final AuditEvent auditEvent) {
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

        public AuditEvent build() {
            return new AuditEvent(this);
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
     * The name of the event type.
     */
    public String eventTypeName;

    /**
     * Timestamp when the event occured at.
     */
    public Instant occuredAt;

    /**
     * The data array belonging to the event.
     */
    public EventData[] eventDataArray;

    public AuditEvent() {
    }

    private AuditEvent(final Builder builder) {
        super();
        eventTypeName = Objects.requireNonNull(builder.eventTypeName, "eventTypeName cannot be null");
        occuredAt = Objects.requireNonNull(builder.occuredAt, "occuredAt cannot be null");
        int eventDataSize = builder.eventDataList.size();
        eventDataArray = new EventData[eventDataSize];
        int i = 0;
        for (EventData eventData : builder.eventDataList) {
            eventDataArray[i] = new EventData.Builder(eventData).build();
            i++;
        }
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + Arrays.hashCode(eventDataArray);
        result = (prime * result) + ((eventTypeName == null) ? 0 : eventTypeName.hashCode());
        result = (prime * result) + ((occuredAt == null) ? 0 : occuredAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuditEvent [eventTypeName=" + eventTypeName + ", occuredAt=" + occuredAt + ", eventDataArray="
                + Arrays.toString(eventDataArray) + "]";
    }

}
