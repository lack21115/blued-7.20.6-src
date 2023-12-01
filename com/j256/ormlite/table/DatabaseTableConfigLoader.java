package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/table/DatabaseTableConfigLoader.class */
public class DatabaseTableConfigLoader {
    private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
    private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
    private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
    private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
    private static final String FIELD_NAME_DATA_CLASS = "dataClass";
    private static final String FIELD_NAME_TABLE_NAME = "tableName";

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r6 == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.j256.ormlite.table.DatabaseTableConfig<T> fromReader(java.io.BufferedReader r5) throws java.sql.SQLException {
        /*
            com.j256.ormlite.table.DatabaseTableConfig r0 = new com.j256.ormlite.table.DatabaseTableConfig
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = 0
            r6 = r0
        La:
            r0 = r5
            java.lang.String r0 = r0.readLine()     // Catch: java.io.IOException -> L97
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L16
            goto L1f
        L16:
            r0 = r7
            java.lang.String r1 = "# --table-end--"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
        L1f:
            r0 = r6
            if (r0 == 0) goto L25
            r0 = r8
            return r0
        L25:
            r0 = 0
            return r0
        L27:
            r0 = r7
            java.lang.String r1 = "# --table-fields-start--"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = r5
            r1 = r8
            readFields(r0, r1)
            goto La
        L38:
            r0 = r7
            int r0 = r0.length()
            if (r0 == 0) goto La
            r0 = r7
            java.lang.String r1 = "#"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto La
            r0 = r7
            java.lang.String r1 = "# --table-start--"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            goto La
        L54:
            r0 = r7
            java.lang.String r1 = "="
            r2 = -2
            java.lang.String[] r0 = r0.split(r1, r2)
            r9 = r0
            r0 = r9
            int r0 = r0.length
            r1 = 2
            if (r0 != r1) goto L76
            r0 = r8
            r1 = r9
            r2 = 0
            r1 = r1[r2]
            r2 = r9
            r3 = 1
            r2 = r2[r3]
            readTableField(r0, r1, r2)
            r0 = 1
            r6 = r0
            goto La
        L76:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "DatabaseTableConfig reading from stream cannot parse line: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.sql.SQLException r0 = new java.sql.SQLException
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L97:
            r5 = move-exception
            java.lang.String r0 = "Could not read DatabaseTableConfig from stream"
            r1 = r5
            java.sql.SQLException r0 = com.j256.ormlite.misc.SqlExceptionUtil.create(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.DatabaseTableConfigLoader.fromReader(java.io.BufferedReader):com.j256.ormlite.table.DatabaseTableConfig");
    }

    public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader bufferedReader) throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            DatabaseTableConfig fromReader = fromReader(bufferedReader);
            if (fromReader == null) {
                return arrayList;
            }
            arrayList.add(fromReader);
        }
    }

    private static <T> void readFields(BufferedReader bufferedReader, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        DatabaseFieldConfig fromReader;
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals(CONFIG_FILE_FIELDS_END) || (fromReader = DatabaseFieldConfigLoader.fromReader(bufferedReader)) == null) {
                    break;
                }
                arrayList.add(fromReader);
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read next field from config file", e);
            }
        }
        databaseTableConfig.setFieldConfigs(arrayList);
    }

    private static <T> void readTableField(DatabaseTableConfig<T> databaseTableConfig, String str, String str2) {
        if (!str.equals(FIELD_NAME_DATA_CLASS)) {
            if (str.equals(FIELD_NAME_TABLE_NAME)) {
                databaseTableConfig.setTableName(str2);
                return;
            }
            return;
        }
        try {
            databaseTableConfig.setDataClass(Class.forName(str2));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown class specified for dataClass: " + str2);
        }
    }

    public static <T> void write(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseTableConfig);
        } catch (IOException e) {
            throw SqlExceptionUtil.create("Could not write config to writer", e);
        }
    }

    private static <T> void writeConfig(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws IOException, SQLException {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseTableConfig.getDataClass() != null) {
            bufferedWriter.append(FIELD_NAME_DATA_CLASS).append('=').append((CharSequence) databaseTableConfig.getDataClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseTableConfig.getTableName() != null) {
            bufferedWriter.append(FIELD_NAME_TABLE_NAME).append('=').append((CharSequence) databaseTableConfig.getTableName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_START);
        bufferedWriter.newLine();
        if (databaseTableConfig.getFieldConfigs() != null) {
            for (DatabaseFieldConfig databaseFieldConfig : databaseTableConfig.getFieldConfigs()) {
                DatabaseFieldConfigLoader.write(bufferedWriter, databaseFieldConfig, databaseTableConfig.getTableName());
            }
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_END);
        bufferedWriter.newLine();
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }
}
