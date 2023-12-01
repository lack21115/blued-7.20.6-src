package com.android.internal.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/content/SelectionBuilder.class */
public class SelectionBuilder {
    private StringBuilder mSelection = new StringBuilder();
    private ArrayList<String> mSelectionArgs = new ArrayList<>();

    public SelectionBuilder append(String str, Object... objArr) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mSelection.length() > 0) {
                this.mSelection.append(" AND ");
            }
            this.mSelection.append("(").append(str).append(")");
            if (objArr != null) {
                int length = objArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    this.mSelectionArgs.add(String.valueOf(objArr[i2]));
                    i = i2 + 1;
                }
            }
        } else if (objArr != null && objArr.length > 0) {
            throw new IllegalArgumentException("Valid selection required when including arguments");
        }
        return this;
    }

    public int delete(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete(str, getSelection(), getSelectionArgs());
    }

    public String getSelection() {
        return this.mSelection.toString();
    }

    public String[] getSelectionArgs() {
        return (String[]) this.mSelectionArgs.toArray(new String[this.mSelectionArgs.size()]);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2) {
        return query(sQLiteDatabase, str, strArr, null, null, str2, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        return sQLiteDatabase.query(str, strArr, getSelection(), getSelectionArgs(), str2, str3, str4, str5);
    }

    public SelectionBuilder reset() {
        this.mSelection.setLength(0);
        this.mSelectionArgs.clear();
        return this;
    }

    public int update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        return sQLiteDatabase.update(str, contentValues, getSelection(), getSelectionArgs());
    }
}
