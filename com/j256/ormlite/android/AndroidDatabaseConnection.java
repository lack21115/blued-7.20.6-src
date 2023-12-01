package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/AndroidDatabaseConnection.class */
public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.48__";
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;
    private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
    private static final String[] NO_STRING_ARGS = new String[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/AndroidDatabaseConnection$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c5 -> B:73:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c9 -> B:69:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00cd -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d5 -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d9 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00dd -> B:97:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e1 -> B:91:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e5 -> B:71:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e9 -> B:67:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00ed -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f1 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f5 -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00f9 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00fd -> B:95:0x00b8). Please submit an issue!!! */
        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/AndroidDatabaseConnection$OurSavePoint.class */
    static class OurSavePoint implements Savepoint {
        private String name;

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sQLiteStatement.bindNull(i2 + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i2].getSqlType();
                switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i2 + 1, obj.toString());
                        continue;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i2 + 1, ((Number) obj).longValue());
                        continue;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i2 + 1, ((Number) obj).doubleValue());
                        continue;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i2 + 1, (byte[]) obj);
                        continue;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
            i = i2 + 1;
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return strArr;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                strArr[i2] = null;
            } else {
                strArr[i2] = obj.toString();
            }
            i = i2 + 1;
        }
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws SQLException {
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        int i;
        SQLiteStatement compileStatement;
        int simpleQueryForLong;
        SQLiteStatement sQLiteStatement3 = null;
        try {
            try {
                SQLiteStatement compileStatement2 = this.db.compileStatement(str);
                try {
                    bindArgs(compileStatement2, objArr, fieldTypeArr);
                    compileStatement2.execute();
                    if (compileStatement2 != null) {
                        compileStatement2.close();
                        sQLiteStatement2 = null;
                    } else {
                        sQLiteStatement2 = compileStatement2;
                    }
                    SQLiteStatement sQLiteStatement4 = sQLiteStatement2;
                    try {
                        compileStatement = this.db.compileStatement("SELECT CHANGES()");
                        sQLiteStatement4 = compileStatement;
                        sQLiteStatement2 = compileStatement;
                        simpleQueryForLong = (int) compileStatement.simpleQueryForLong();
                        i = simpleQueryForLong;
                    } catch (android.database.SQLException e) {
                        i = 1;
                        if (sQLiteStatement2 != null) {
                            i = 1;
                        }
                    } catch (Throwable th) {
                        if (sQLiteStatement4 != null) {
                            sQLiteStatement4.close();
                        }
                        throw th;
                    }
                    if (compileStatement != null) {
                        i = simpleQueryForLong;
                        sQLiteStatement2 = compileStatement;
                        sQLiteStatement2.close();
                    }
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(i), str);
                    return i;
                } catch (android.database.SQLException e2) {
                    e = e2;
                    sQLiteStatement = compileStatement2;
                    StringBuilder sb = new StringBuilder();
                    SQLiteStatement sQLiteStatement5 = sQLiteStatement;
                    sb.append("updating database failed: ");
                    SQLiteStatement sQLiteStatement6 = sQLiteStatement;
                    sb.append(str);
                    SQLiteStatement sQLiteStatement7 = sQLiteStatement;
                    throw SqlExceptionUtil.create(sb.toString(), e);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteStatement3 = compileStatement2;
                    if (sQLiteStatement3 != null) {
                        sQLiteStatement3.close();
                    }
                    throw th;
                }
            } catch (android.database.SQLException e3) {
                e = e3;
                sQLiteStatement = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void close() throws SQLException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", this, this.db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException e) {
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e);
            }
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                SQLiteStatement compileStatement = this.db.compileStatement(str);
                bindArgs(compileStatement, objArr, fieldTypeArr);
                long executeInsert = compileStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(executeInsert));
                }
                sQLiteStatement2 = compileStatement;
                sQLiteStatement = compileStatement;
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                if (compileStatement != null) {
                    compileStatement.close();
                    return 1;
                }
                return 1;
            } catch (android.database.SQLException e) {
                StringBuilder sb = new StringBuilder();
                SQLiteStatement sQLiteStatement3 = sQLiteStatement;
                sb.append("inserting to database failed: ");
                SQLiteStatement sQLiteStatement4 = sQLiteStatement;
                sb.append(str);
                SQLiteStatement sQLiteStatement5 = sQLiteStatement;
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } catch (Throwable th) {
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        SQLiteDatabase sQLiteDatabase = this.db;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", null);
        try {
            boolean z = rawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
            rawQuery.close();
            return z;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                SQLiteStatement compileStatement = this.db.compileStatement(str);
                long simpleQueryForLong = compileStatement.simpleQueryForLong();
                sQLiteStatement2 = compileStatement;
                sQLiteStatement = compileStatement;
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(simpleQueryForLong), str);
                if (compileStatement != null) {
                    compileStatement.close();
                }
                return simpleQueryForLong;
            } catch (android.database.SQLException e) {
                StringBuilder sb = new StringBuilder();
                SQLiteStatement sQLiteStatement3 = sQLiteStatement;
                sb.append("queryForLong from database failed: ");
                SQLiteStatement sQLiteStatement4 = sQLiteStatement;
                sb.append(str);
                SQLiteStatement sQLiteStatement5 = sQLiteStatement;
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } catch (Throwable th) {
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long queryForLong(java.lang.String r7, java.lang.Object[] r8, com.j256.ormlite.field.FieldType[] r9) throws java.sql.SQLException {
        /*
            r6 = this;
            r0 = 0
            r12 = r0
            r0 = r6
            android.database.sqlite.SQLiteDatabase r0 = r0.db     // Catch: java.lang.Throwable -> L59 android.database.SQLException -> L60
            r1 = r7
            r2 = r6
            r3 = r8
            java.lang.String[] r2 = r2.toStrings(r3)     // Catch: java.lang.Throwable -> L59 android.database.SQLException -> L60
            android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L59 android.database.SQLException -> L60
            r9 = r0
            r0 = r9
            r8 = r0
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            r1 = r0
            r2 = r9
            r3 = 0
            r1.<init>(r2, r3)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            r12 = r0
            r0 = r9
            r8 = r0
            r0 = r12
            boolean r0 = r0.first()     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            if (r0 == 0) goto L9d
            r0 = r9
            r8 = r0
            r0 = r12
            r1 = 0
            long r0 = r0.getLong(r1)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            r10 = r0
            goto L35
        L35:
            r0 = r9
            r8 = r0
            com.j256.ormlite.logger.Logger r0 = com.j256.ormlite.android.AndroidDatabaseConnection.logger     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            java.lang.String r1 = "{}: query for long raw query returned {}: {}"
            r2 = r6
            r3 = r10
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            r4 = r7
            r0.trace(r1, r2, r3, r4)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L90
            r0 = r9
            if (r0 == 0) goto L51
            r0 = r9
            r0.close()
        L51:
            r0 = r10
            return r0
        L54:
            r12 = move-exception
            goto L64
        L59:
            r7 = move-exception
            r0 = r12
            r8 = r0
            goto L91
        L60:
            r12 = move-exception
            r0 = 0
            r9 = r0
        L64:
            r0 = r9
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L90
            r13 = r0
            r0 = r9
            r8 = r0
            r0 = r13
            java.lang.String r1 = "queryForLong from database failed: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L90
            r0 = r9
            r8 = r0
            r0 = r13
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L90
            r0 = r9
            r8 = r0
            r0 = r13
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L90
            r1 = r12
            java.sql.SQLException r0 = com.j256.ormlite.misc.SqlExceptionUtil.create(r0, r1)     // Catch: java.lang.Throwable -> L90
            throw r0     // Catch: java.lang.Throwable -> L90
        L90:
            r7 = move-exception
        L91:
            r0 = r8
            if (r0 == 0) goto L9b
            r0 = r8
            r0.close()
        L9b:
            r0 = r7
            throw r0
        L9d:
            r0 = 0
            r10 = r0
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[]):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object queryForOne(java.lang.String r6, java.lang.Object[] r7, com.j256.ormlite.field.FieldType[] r8, com.j256.ormlite.stmt.GenericRowMapper<T> r9, com.j256.ormlite.dao.ObjectCache r10) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForOne(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.stmt.GenericRowMapper, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (!z) {
            if (this.db.inTransaction()) {
                return;
            }
            this.db.beginTransaction();
        } else if (this.db.inTransaction()) {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }
}
