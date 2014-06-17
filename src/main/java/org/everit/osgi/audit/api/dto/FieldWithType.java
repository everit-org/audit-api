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

public class FieldWithType {

    /**
     * Field name.
     */
    private String name;
    /**
     * Field type.
     */
    private EventDataType type;

    private String localizedName;

    /**
     * Default constructor for jaxb.
     */
    public FieldWithType() {
        super();
    }

    /**
     * Constructor with initial parameters.
     *
     * @param name
     *            Name of the field.
     * @param type
     *            Type of the field.
     */
    public FieldWithType(final String name, final EventDataType type) {
        super();
        this.name = name;
        this.type = type;
    }

    /**
     * Constructor with initial parameters.
     *
     * @param name
     *            Name of the field.
     * @param localizedName
     *            The localized name by default locale if exists.
     * @param type
     *            Type of the field.
     */
    public FieldWithType(final String name, final EventDataType type, final String localizedName) {
        super();
        this.name = name;
        this.type = type;
        this.localizedName = localizedName;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getName() {
        return name;
    }

    public EventDataType getType() {
        return type;
    }

    public void setLocalizedName(final String localizedName) {
        this.localizedName = localizedName;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setType(final EventDataType type) {
        this.type = type;
    }

}
