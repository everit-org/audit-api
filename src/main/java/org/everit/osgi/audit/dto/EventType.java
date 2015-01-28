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

import java.util.Objects;

public class EventType {

    private final long id;

    private final String name;

    private final long resourceId;

    public EventType(final long id, final String name, final long resourceId) {
        super();
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.resourceId = resourceId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getResourceId() {
        return resourceId;
    }

}
