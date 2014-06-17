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

import java.io.Serializable;

public class EventType implements Serializable {
    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    // TODO This class is not immutable, thus it implies a security issue.
    /**
     * Id of the event type.
     */
    private Long id;
    /**
     * Name of the event type.
     */
    private String name;

    /**
     * Default constructor for jaxb.
     */
    protected EventType() {
        super();
    }

    /**
     * Constructor with initial parameters.
     *
     * @param id
     *            Id of the event type.
     * @param name
     *            Name of the event type.
     */
    public EventType(final Long id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
