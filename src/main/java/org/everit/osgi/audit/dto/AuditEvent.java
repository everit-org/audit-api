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
import java.util.Objects;

public class AuditEvent {

    /**
     * The name of the event type.
     */
    private final String eventTypeName;

    /**
     * Timestamp when the event occured at.
     */
    private final Instant occuredAt;

    /**
     * The data array belonging to the event.
     */
    private final EventData[] eventDataArray;

    public AuditEvent(final String eventTypeName, final EventData... eventDataArray) {
        this(eventTypeName, Instant.now(), eventDataArray);
    }

    /**
     * Constructor for setting initial parameters.
     *
     * @param eventTypeName
     *            the name of the event type
     * @param occuredAt
     *            Timestamp when the event was saved
     * @param eventDataArray
     *            The event data array for this event.
     */
    public AuditEvent(final String eventTypeName, final Instant occuredAt, final EventData... eventDataArray) {
        this.eventTypeName = Objects.requireNonNull(eventTypeName, "eventTypeName cannot be null");
        this.occuredAt = Objects.requireNonNull(occuredAt, "occuredAt cannot be null");
        this.eventDataArray = Objects.requireNonNull(eventDataArray, "eventDataArray cannot be null").clone();
    }

    public EventData[] getEventDataArray() {
        return eventDataArray;
    }

    public String getName() {
        return eventTypeName;
    }

    public Instant getOccuredAt() {
        return occuredAt;
    }

}
