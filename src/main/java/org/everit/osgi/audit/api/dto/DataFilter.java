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

import java.util.Calendar;
import java.util.Date;

public class DataFilter extends EventData {

    /**
     * Operator for the filter.
     */
    private int operator;
    /**
     * Value of the filter.
     */
    private Date dateValue;

    /**
     * Default constructor.
     */
    public DataFilter() {
        super();
        operator = Operator.EQ;
    }

    /**
     * Gets the date value.
     *
     * @return The dateValue.
     */
    public Date getDateValue() {
        if (null != getTimestampValue()) {
            dateValue = getTimestampValue().getTime();
        }
        return dateValue;
    }

    public int getOperator() {
        return operator;
    }

    /**
     * Sets the dateValue.
     *
     * @param dateValue
     *            The value to be set.
     */
    public void setDateValue(final Date dateValue) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateValue);
        setTimestampValue(c);
        this.dateValue = dateValue;
    }

    public void setOperator(final int operator) {
        this.operator = operator;
    }

}
