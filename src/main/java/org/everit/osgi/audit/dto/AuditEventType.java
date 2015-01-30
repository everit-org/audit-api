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

    public static class Builder {

        private long eventTypeId;

        private String eventTypeName;

        private long resourceId;

        public Builder() {
        }

        public Builder(final AuditEventType auditEventType) {
            Objects.requireNonNull(auditEventType, "auditEventType cannot be null");
            eventTypeId = auditEventType.eventTypeId;
            eventTypeName = auditEventType.eventTypeName;
            resourceId = auditEventType.resourceId;
        }

        public AuditEventType build() {
            return new AuditEventType(this);
        }

        public Builder eventTypeId(final long eventTypeId) {
            this.eventTypeId = eventTypeId;
            return this;
        }

        public Builder eventTypeName(final String eventTypeName) {
            this.eventTypeName = eventTypeName;
            return this;
        }

        public Builder resourceId(final long resourceId) {
            this.resourceId = resourceId;
            return this;
        }

    }

    public long eventTypeId;

    public String eventTypeName;

    public long resourceId;

    public AuditEventType() {
    }

    public AuditEventType(final AuditEventType original) {
        Objects.requireNonNull(original, "original cannot be null");
        eventTypeId = original.eventTypeId;
        eventTypeName = original.eventTypeName;
        resourceId = original.resourceId;
    }

    private AuditEventType(final Builder builder) {
        eventTypeId = builder.eventTypeId;
        eventTypeName = Objects.requireNonNull(builder.eventTypeName, "name cannot be null");
        resourceId = builder.resourceId;
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
        if (eventTypeId != other.eventTypeId) {
            return false;
        }
        if (eventTypeName == null) {
            if (other.eventTypeName != null) {
                return false;
            }
        } else if (!eventTypeName.equals(other.eventTypeName)) {
            return false;
        }
        if (resourceId != other.resourceId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (eventTypeId ^ (eventTypeId >>> 32));
        result = (prime * result) + ((eventTypeName == null) ? 0 : eventTypeName.hashCode());
        result = (prime * result) + (int) (resourceId ^ (resourceId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AuditEventType [eventTypeId=" + eventTypeId + ", eventTypeName=" + eventTypeName + ", resourceId="
                + resourceId + "]";
    }

}
