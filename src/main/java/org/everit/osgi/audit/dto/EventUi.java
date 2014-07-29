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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventUi {

    public static class Builder {

        private long eventId;

        private String typeName;

        private String appName;

        private Instant saveTimestamp;

        private final Map<String, EventData> eventData = new HashMap<>();

        public Builder appName(final String appName) {
            this.appName = appName;
            return this;
        }

        public Builder binaryData(final String name, final byte[] data) {
            eventData.put(name, new EventData(name, data));
            return this;
        }

        public EventUi build() {
            return new EventUi(eventId, typeName, appName, saveTimestamp, eventData);
        }

        public Builder eventId(final long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder numberData(final String name, final double number) {
            eventData.put(name, new EventData(name, number));
            return this;
        }

        public Builder saveTimestamp(final Instant saveTimestamp) {
            this.saveTimestamp = saveTimestamp;
            return this;
        }

        public Builder stringData(final String name, final String data) {
            eventData.put(name, new EventData(name, data));
            return this;
        }

        public Builder textData(final String name, final String data) {
            eventData.put(name, new EventData(name, false, data));
            return this;
        }

        public Builder timestampData(final String name, final Instant data) {
            eventData.put(name, new EventData(name, data));
            return this;
        }

        public Builder typeName(final String typeName) {
            this.typeName = typeName;
            return this;
        }

    }

    /**
     * Id of the event.
     */
    private final long id;
    /**
     * Name of the event.
     */
    private final String name;
    /**
     * The name of the application which the event belongs to.
     */
    private final String applicationName;
    /**
     * TimeStamp when the event was saved.
     */
    private final Instant saveTimeStamp;
    /**
     * Map containing the event data.
     */
    private final Map<String, EventData> eventData;

    public EventUi(final long id, final String name, final String applicationName, final Instant saveTimeStamp,
            final Map<String, EventData> eventData) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.applicationName = Objects.requireNonNull(applicationName, "applicationName cannot be null");
        this.saveTimeStamp = Objects.requireNonNull(saveTimeStamp, "saveTimeStamp cannot be null");
        this.eventData = Objects.requireNonNull(eventData, "eventData cannot be null");
    }

    public String getApplicationName() {
        return applicationName;
    }

    public Map<String, EventData> getEventData() {
        return eventData;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getSaveTimeStamp() {
        return saveTimeStamp;
    }

}
