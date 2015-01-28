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

public class AuditEventType {

    private final long id;

    private final String name;

    private final long resourceId;

    public AuditEventType(final long id, final String name, final long resourceId) {
        super();
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AuditEventType other = (AuditEventType) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (resourceId != other.resourceId) {
            return false;
        }
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (id ^ (id >>> 32));
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        result = (prime * result) + (int) (resourceId ^ (resourceId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AuditEventType [id=" + id + ", name=" + name + ", resourceId=" + resourceId + "]";
    }

}
