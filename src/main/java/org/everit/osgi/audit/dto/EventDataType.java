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
package org.everit.osgi.audit.dto;

/**
 * The supported types of the {@link EventData}.
 */
public enum EventDataType {

  /**
   * Number type.
   */
  NUMBER,

  /**
   * Short text type (max length is STRING_MAX_LENGTH).
   */
  STRING,

  /**
   * Long text type. (Max length 4Gb)
   */
  TEXT,

  /**
   * Timestamp value.
   */
  TIMESTAMP;

  /**
   * String maximum length.
   */
  public static final int STRING_MAX_LENGTH = 2000;

}
