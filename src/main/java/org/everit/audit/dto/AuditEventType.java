/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.audit.dto;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * The type of audit event.
 */
public class AuditEventType {

  /**
   * Builder class to create audit event type easily.
   */
  public static class Builder {

    private long eventTypeId;

    private String eventTypeName;

    private long resourceId;

    /**
     * Default constructor.
     */
    public Builder() {
    }

    /**
     * Deep copy constructor.
     *
     * @param auditEventType
     *          the original audit event type to copy deeply, cannot be <code>null</code>.
     */
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

  /**
   * The identifier of the event type.
   */
  public long eventTypeId;

  /**
   * The name of the event type.
   */
  public String eventTypeName;

  /**
   * The resource ID belonging to the event type.
   */
  public long resourceId;

  /**
   * Default constructor.
   */
  public AuditEventType() {
  }

  /**
   * Deep copy constructor.
   *
   * @param original
   *          the original instance to copy deeply, cannot be <code>null</code>.
   */
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
  @Generated("eclipse")
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
  @Generated("eclipse")
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
    return "AuditEventType [eventTypeId=" + eventTypeId + ", eventTypeName=" + eventTypeName
        + ", resourceId="
        + resourceId + "]";
  }

}
