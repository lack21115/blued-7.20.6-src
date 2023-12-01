package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.ch;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ce.class */
public class ce extends ch.e {

    /* renamed from: a  reason: collision with root package name */
    private String f41301a;

    public ce(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f41301a = "MessageInsertJob";
        this.f41301a = str2;
    }

    public static ce a(Context context, String str, hk hkVar) {
        byte[] a2 = iq.a(hkVar);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hkVar.d());
        contentValues.put("messageItem", a2);
        contentValues.put("appId", bv.a(context).b());
        contentValues.put("packageName", bv.a(context).m11558a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new ce(str, contentValues, "a job build to insert message to db");
    }
}
