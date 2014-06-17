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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class EventUi implements Serializable {
    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Id of the event.
     */
    private Long id;
    /**
     * Name of the event.
     */
    private String name;
    /**
     * The name of the application which the event belongs to.
     */
    private String applicationName;
    /**
     * TimeStamp when the event was saved.
     */
    private Date saveTimeStamp;
    /**
     * Map containing the event data.
     */
    private Map<String, EventData> eventData;

    public EventUi() {
    }

    /**
     * This constructor is required to handle the different type of saveTimeStamp from the entity.
     */
    public EventUi(final Long id, final String name, final String applicationName, final Calendar saveTimeStamp) {
        this.id = id;
        this.name = name;
        this.applicationName = applicationName;
        this.saveTimeStamp = saveTimeStamp.getTime();
    }

    public EventUi(final Long id, final String name, final String applicationName, final Date saveTimeStamp) {
        this.id = id;
        this.name = name;
        this.applicationName = applicationName;
        this.saveTimeStamp = saveTimeStamp;
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
        return saveTimeStamp;
    }

    public void setApplicationName(final String applicationName) {
        this.applicationName = applicationName;
    }

    public void setEventData(final Map<String, EventData> eventData) {
        this.eventData = eventData;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSaveTimeStamp(final Date saveTimeStamp) {
        this.saveTimeStamp = saveTimeStamp;
    }

}
