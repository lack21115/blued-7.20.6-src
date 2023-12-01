package android.database.sqlite;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/SQLiteQueryBuilder.class */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mStrict;
    private Map<String, String> mProjectionMap = null;
    private String mTables = "";
    private StringBuilder mWhereClause = null;
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;

    private static void appendClause(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(' ');
                return;
            }
            String str = strArr[i2];
            if (str != null) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
            i = i2 + 1;
        }
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
                StringBuilder sb = new StringBuilder(120);
                sb.append("SELECT ");
                if (z) {
                    sb.append("DISTINCT ");
                }
                if (strArr == null || strArr.length == 0) {
                    sb.append("* ");
                } else {
                    appendColumns(sb, strArr);
                }
                sb.append("FROM ");
                sb.append(str);
                appendClause(sb, " WHERE ", str2);
                appendClause(sb, " GROUP BY ", str3);
                appendClause(sb, " HAVING ", str4);
                appendClause(sb, " ORDER BY ", str5);
                appendClause(sb, " LIMIT ", str6);
                return sb.toString();
            }
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str6);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    private String[] computeProjection(String[] strArr) {
        String[] strArr2;
        int i;
        if (strArr == null || strArr.length <= 0) {
            if (this.mProjectionMap == null) {
                return null;
            }
            Set<Map.Entry<String, String>> entrySet = this.mProjectionMap.entrySet();
            String[] strArr3 = new String[entrySet.size()];
            Iterator<Map.Entry<String, String>> it = entrySet.iterator();
            int i2 = 0;
            while (true) {
                strArr2 = strArr3;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (!next.getKey().equals(BaseColumns._COUNT)) {
                    strArr3[i2] = next.getValue();
                    i2++;
                }
            }
        } else if (this.mProjectionMap != null) {
            String[] strArr4 = new String[strArr.length];
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                i = i3;
                strArr2 = strArr4;
                if (i >= length) {
                    break;
                }
                String str = strArr[i];
                String str2 = this.mProjectionMap.get(str);
                if (str2 != null) {
                    strArr4[i] = str2;
                } else if (this.mStrict || !(str.contains(" AS ") || str.contains(" as "))) {
                    break;
                } else {
                    strArr4[i] = str;
                }
                i3 = i + 1;
            }
            throw new IllegalArgumentException("Invalid column " + strArr[i]);
        } else {
            strArr2 = strArr;
        }
        return strArr2;
    }

    private void validateQuerySql(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        sQLiteDatabase.getThreadSession().prepare(str, sQLiteDatabase.getThreadDefaultConnectionFlags(true), cancellationSignal, null);
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public String buildQuery(String[] strArr, String str, String str2, String str3, String str4, String str5) {
        String[] computeProjection = computeProjection(strArr);
        StringBuilder sb = new StringBuilder();
        boolean z = this.mWhereClause != null && this.mWhereClause.length() > 0;
        if (z) {
            sb.append(this.mWhereClause.toString());
            sb.append(')');
        }
        if (str != null && str.length() > 0) {
            if (z) {
                sb.append(" AND ");
            }
            sb.append('(');
            sb.append(str);
            sb.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, computeProjection, sb.toString(), str2, str3, str4, str5);
    }

    @Deprecated
    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return buildQuery(strArr, str, str2, str3, str4, str5);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder sb = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                appendClause(sb, " ORDER BY ", str);
                appendClause(sb, " LIMIT ", str2);
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(str3);
            }
            sb.append(strArr[i2]);
            i = i2 + 1;
        }
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String str4, String str5) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return buildQuery(strArr2, str3, str4, str5, null, null);
            }
            String str6 = strArr[i3];
            if (str6.equals(str)) {
                strArr2[i3] = "'" + str2 + "' AS " + str;
            } else if (i3 <= i || set.contains(str6)) {
                strArr2[i3] = str6;
            } else {
                strArr2[i3] = "NULL AS " + str6;
            }
            i2 = i3 + 1;
        }
    }

    @Deprecated
    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String[] strArr2, String str4, String str5) {
        return buildUnionSubQuery(str, strArr, set, i, str2, str3, str4, str5);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, str5, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, CancellationSignal cancellationSignal) {
        if (this.mTables == null) {
            return null;
        }
        if (this.mStrict && str != null && str.length() > 0) {
            validateQuerySql(sQLiteDatabase, buildQuery(strArr, "(" + str + ")", str2, str3, str4, str5), cancellationSignal);
        }
        String buildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Performing query: " + buildQuery);
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables), cancellationSignal);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setStrict(boolean z) {
        this.mStrict = z;
    }

    public void setTables(String str) {
        this.mTables = str;
    }
}
