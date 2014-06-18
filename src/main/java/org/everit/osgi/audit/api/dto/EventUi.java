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
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class EventUi {
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
    private final Date saveTimeStamp;
    /**
     * Map containing the event data.
     */
    private Map<String, EventData> eventData;

    public EventUi(final long id, final String name, final String applicationName, final Calendar saveTimeStamp) {
        this(id, name, applicationName, saveTimeStamp.getTime());
    }

    public EventUi(final Long id, final String name, final String applicationName, final Date saveTimeStamp) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.applicationName = Objects.requireNonNull(applicationName, "applicationName cannot be null");
        this.saveTimeStamp = new Date(saveTimeStamp.getTime());
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

    public Date getSaveTimeStamp() {
        return new Date(saveTimeStamp.getTime());
    }

}
