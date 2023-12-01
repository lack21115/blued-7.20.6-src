package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.anythink.core.common.c.d;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/vivo/identifier/DataBaseOperation.class */
public class DataBaseOperation {
    private Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataBaseOperation(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(int i, String str) {
        Uri parse;
        Cursor cursor;
        String str2;
        String str3;
        Cursor cursor2;
        Cursor query;
        String str4;
        Cursor cursor3 = null;
        if (i == 0) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i == 2) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i == 3) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
        } else if (i != 4) {
            parse = i != 5 ? null : Uri.parse("content://com.vivo.abe.exidentifier/guid");
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
        }
        try {
            if (parse == null) {
                return null;
            }
            try {
                query = this.a.getContentResolver().query(parse, null, null, null, null);
            } catch (Exception e) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
            try {
                if (query != null) {
                    str4 = null;
                    if (query.moveToNext()) {
                        str4 = query.getString(query.getColumnIndex(d.a.d));
                    }
                } else {
                    Log.d("VMS_SDK_DB", "return cursor is null,return");
                    str4 = null;
                }
                str2 = str4;
            } catch (Exception e2) {
                cursor = query;
                cursor3 = cursor;
                Log.e("VMS_SDK_DB", "return cursor is error");
                str2 = null;
                if (cursor != null) {
                    str3 = null;
                    cursor2 = cursor;
                    cursor2.close();
                    return str3;
                }
                return str2;
            }
            if (query != null) {
                cursor2 = query;
                str3 = str4;
                cursor2.close();
                return str3;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        if (i == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            int bulkInsert = this.a.getContentResolver().bulkInsert(parse, contentValuesArr);
            Log.d("VMS_SDK_DB", "insert:" + bulkInsert);
            return bulkInsert != 0;
        } catch (Exception e) {
            Log.e("VMS_SDK_DB", "return insert is error");
            return false;
        }
    }
}
