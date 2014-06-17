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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.everit.osgi.audit.api.dto.Event;

/**
 *
 * Interface for LoggingServices.
 *
 */
public interface LoggingService {

    /**
     * Logging an event.
     *
     * @param event
     *            The event.
     * @throws EventLoggingException
     *             If the logging fails.
     */
    void logEvent(Event event);

    /**
     * Logging an evnt with more params to be able to create auditLog from eg. groovy or any script which can handle
     * only primitive types.
     *
     * @param eventName
     *            The name of the event.
     * @param appName
     *            The name of the application.
     * @param eventDataList
     *            The list of the eventData.
     * @throws EventLoggingException
     *             If the logging fails.
     */
    void logEvent(String eventName, String appName, List<Map<String, Serializable>> eventDataList);

}
