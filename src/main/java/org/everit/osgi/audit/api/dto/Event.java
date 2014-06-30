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

import java.util.Date;
import java.util.Objects;

public class Event {

    /**
     * The name of the event type.
     */
    private final String name;

    /**
     * The name of the application the event belongs to.
     */
    private final String applicationName;

    /**
     * Timestamp when the event was saved.
     */
    private final Date saveTimeStamp;

    /**
     * The data array belonging to the event.
     */
    private final EventData[] eventDataArray;

    /**
     * Constructor for setting initial parameters.
     *
     * @param id
     *            Event id. Can be null.
     * @param name
     *            Event name.
     * @param applicationName
     *            Application name.
     * @param saveTimeStamp
     *            Timestamp when the event was saved.
     * @param eventDataArray
     *            The event data array for this event.
     */
    public Event(final String name, final String applicationName, final Date saveTimeStamp,
            final EventData[] eventDataArray) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.applicationName = Objects.requireNonNull(applicationName, "applicationName cannot be null");
        this.saveTimeStamp = new Date(Objects.requireNonNull(saveTimeStamp, "saveTimeStamp cannot be null").getTime());
        this.eventDataArray = Objects.requireNonNull(eventDataArray, "eventDataArray cannot be null").clone();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public EventData[] getEventDataArray() {
        return eventDataArray;
    }

    public String getName() {
        return name;
    }

    public Date getSaveTimeStamp() {
        return new Date(saveTimeStamp.getTime());
    }

}
