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
package org.everit.osgi.audit;

import org.everit.osgi.audit.dto.AuditEvent;

/**
 * Interface for logging {@link AuditEvent}s.
 */
public interface LoggingService {

    /**
     * Persists the given audit event to the event store. For e.g. to database, file, etc.
     *
     * @param auditEvent
     *            the event to persist, cannot be <code>null</code>
     * @throws NullPointerException
     *             if the <code>auditEvent</code> parameter is <code>null</code>.
     */
    void logEvent(AuditEvent auditEvent);

}
