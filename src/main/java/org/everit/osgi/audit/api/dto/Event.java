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

public class Event {

    /**
     * The ID of the event type.
     */
    private Long id;

    /**
     * The name of the event type.
     */
    private String name;

    /**
     * The name of the application the event belongs to.
     */
    private String applicationName;

    /**
     * Timestamp when the event was saved.
     */
    private Date saveTimeStamp;

    /**
     * The data array belonging to the event.
     */
    private EventData[] eventDataArray;

    /**
     * Default constructor for jaxb.
     */
    protected Event() {
        super();
    }

    /**
     * Constructor for setting initial parameters.
     *
     * @param id
     *            Event id.
     * @param name
     *            Event name.
     * @param applicationName
     *            Application name.
     * @param saveTimeStamp
     *            Timestamp when the event was saved.
     * @param eventDataArray
     *            The event data array for this event.
     */
    public Event(final Long id, final String name, final String applicationName, final Date saveTimeStamp,
            final EventData[] eventDataArray) {
        super();
        this.id = id;
        this.name = name;
        this.applicationName = applicationName;
        this.saveTimeStamp = saveTimeStamp;
        this.eventDataArray = eventDataArray;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public EventData[] getEventDataArray() {
        return eventDataArray;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getSaveTimeStamp() {
        return saveTimeStamp;
    }

    public void setApplicationName(final String applicationName) {
        this.applicationName = applicationName;
    }

    public void setEventDataArray(final EventData[] eventDataArray) {
        this.eventDataArray = eventDataArray;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSaveTimeStamp(final Date saveTimeStamp) {
        this.saveTimeStamp = saveTimeStamp;
    }

}
