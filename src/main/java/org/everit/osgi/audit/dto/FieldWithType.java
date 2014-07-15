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

public class FieldWithType {

    private final String name;

    private final EventDataType type;

    private final String localizedName;

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

}
