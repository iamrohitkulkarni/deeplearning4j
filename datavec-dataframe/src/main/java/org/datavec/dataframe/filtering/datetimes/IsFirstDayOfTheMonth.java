package org.datavec.dataframe.filtering.datetimes;

import org.datavec.dataframe.api.ColumnType;
import org.datavec.dataframe.api.DateColumn;
import org.datavec.dataframe.api.DateTimeColumn;
import org.datavec.dataframe.api.Table;
import org.datavec.dataframe.columns.Column;
import org.datavec.dataframe.columns.ColumnReference;
import org.datavec.dataframe.filtering.ColumnFilter;
import org.datavec.dataframe.util.Selection;

/**
 *
 */
public class IsFirstDayOfTheMonth extends ColumnFilter {

    public IsFirstDayOfTheMonth(ColumnReference columnReference) {
        super(columnReference);
    }

    @Override
    public Selection apply(Table relation) {

        String name = columnReference().getColumnName();
        Column column = relation.column(name);
        ColumnType type = column.type();
        switch (type) {
            case LOCAL_DATE:
                DateColumn dateColumn = relation.dateColumn(name);
                return dateColumn.isFirstDayOfMonth();
            case LOCAL_DATE_TIME:
                DateTimeColumn dateTimeColumn = relation.dateTimeColumn(name);
                return dateTimeColumn.isFirstDayOfMonth();
            default:
                throw new UnsupportedOperationException("Columns of type " + type.name()
                                + " do not support the operation " + "isFirstDayOfTheMonth() ");
        }
    }
}
