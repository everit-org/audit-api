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

public class Application {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Application id.
     */
    private Long applicationId;
    /**
     * Application name.
     */
    private String appName;
    /**
     * Resource id.
     */
    private Long resourceId;

    public Application() {
    }

    /**
     * Constructor for setting initial parameters.
     *
     * @param applicationId
     *            Id of the application.
     * @param appName
     *            Name of the application.
     * @param resourceId
     *            ResourceId of the application.
     */
    public Application(final Long applicationId, final String appName, final Long resourceId) {
        super();
        this.applicationId = applicationId;
        this.appName = appName;
        this.resourceId = resourceId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public String getAppName() {
        return appName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setApplicationId(final Long applicationId) {
        this.applicationId = applicationId;
    }

    public void setAppName(final String appName) {
        this.appName = appName;
    }

    public void setResourceId(final Long resourceId) {
        this.resourceId = resourceId;
    }

}
