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
package org.everit.osgi.audit.api;

import java.util.List;

import org.everit.osgi.audit.api.dto.Application;
import org.everit.osgi.audit.api.dto.EventType;
import org.everit.osgi.audit.api.dto.EventUi;
import org.everit.osgi.audit.api.dto.FieldWithType;

public interface AuditService {
    /**
     * Audit max result must be lower then this constant.
     */
    public static final int AUDIT_SEARCH_MAX_RESULT_LIMIT = 200;

    /**
     * Creating an application and assigning to a new resource automatically.
     *
     * @param appName
     *            The unique name of the application.
     * @throws NullPointerException
     *             if {@code appName} is null
     */
    Application createApplication(String appName);

    /**
     * Creating an application.
     *
     * @param appName
     *            The unique name of the application.
     * @param resourceId
     *            Id of the resource the application will belong to. If null a new resource will be created.
     */
    Application createApplication(String appName, Long resourceId);

    /**
     * Find applications by name.
     *
     * @param appName
     *            Application name.
     * @return With the Application dto object from the database with the given name.
     * @throws NullPointerException
     *             if {@code appName} is {@code null}.
     */
    Application findAppByName(String appName);

    /**
     * Get all applications.
     *
     * @return With the List of application stored in db.
     */
    List<Application> getApplications();

    EventUi getEventById(long eventId);

    /**
     * Get the event types associated with a single application.
     *
     * @param selectedAppId
     *            Application Id.
     * @param eventName
     *            The name of the event.
     * @return EventType dto object the given appId belongs to.
     * @throws IllegalArgumentException
     *             is no event type found for the application with the given name.
     */
    EventType getEventTypeByNameForApplication(long selectedAppId, String eventName);

    /**
     * Get the event types associated with a single application.
     *
     * @param selectedAppId
     *            Application Id.
     * @return With the list of EventType dto object the given appId belongs to.
     */
    List<EventType> getEventTypesByApplication(long selectedAppId);

    Application getOrCreateApplication(String applicationName);

    EventType getOrCreateEventType(String applicationName, String eventTypeName);

    EventType[] getOrCreateEventTypes(String applicationName, String[] eventTypeNames);

    /**
     * Gets the result according to application and eventType parameters.
     *
     * @param selectedAppId
     *            The selected applicationId.
     * @param selectedEventTypeId
     *            The selected eventTypeId.
     * @return With a list of EventData related to the selected apps and events to be shown on the result screen to be
     *         able to show the fields with datatypes for UI filter.
     */
    List<FieldWithType> getResultFieldsWithTypes(Long[] selectedAppId, Long[] selectedEventTypeId);

    /**
     * Read a single event.
     *
     * @param eventId
     *            The id of the event to be read.
     * @param dataFields
     *            the fields for the event to be read.
     * @return The eventUi dto.
     */
    EventUi readEvent(final long eventId, final List<String> dataFields);
}
