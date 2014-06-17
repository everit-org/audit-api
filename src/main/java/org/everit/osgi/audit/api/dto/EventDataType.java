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
     * Binary value.
     */
    BINARY,

    /**
     * Timestamp value.
     */
    TIMESTAMP;
    /**
     * String maximum length.
     */
    public static final int STRING_MAX_LENGTH = 255;

}
