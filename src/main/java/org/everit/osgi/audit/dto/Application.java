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

public class Application {

    private final long applicationId;

    private final String appName;

    private final long resourceId;

    public Application(final long applicationId, final String appName, final long resourceId) {
        this.applicationId = applicationId;
        this.appName = Objects.requireNonNull(appName, "appName cannot be null");
        this.resourceId = resourceId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public String getAppName() {
        return appName;
    }

    public long getResourceId() {
        return resourceId;
    }

}
