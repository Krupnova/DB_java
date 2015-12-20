package sample;

/**
 * Created by Дарья on 20.12.2015.
 */
public class SQLTableColumnsInfo {
    private String columnName, columnType, isPrimary;

    public SQLTableColumnsInfo(String columnName, String columnType, String isPrimary) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.isPrimary = isPrimary;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public String getIsPrimary() {
        return isPrimary;
    }
}
