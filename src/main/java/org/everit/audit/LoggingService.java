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
package org.everit.audit;

import org.everit.audit.dto.AuditEvent;

/**
 * Interface for logging {@link AuditEvent}s.
 */
public interface LoggingService {

  /**
   * Persists the given audit event to the event store. For e.g. to database, file, etc.
   *
   * @param auditEvent
   *          the event to persist, cannot be <code>null</code>
   * @throws NullPointerException
   *           if the <code>auditEvent</code> parameter is <code>null</code>.
   */
  void logEvent(AuditEvent auditEvent);

}
