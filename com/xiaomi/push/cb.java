package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cb.class */
public class cb extends cd {
    public cb(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static cb a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m8531a = ch.a(context).m8531a(str);
        if (TextUtils.isEmpty(m8531a)) {
            return null;
        }
        return new cb(str, "rowDataId in (select " + "rowDataId from ".concat(String.valueOf(m8531a)) + " order by createTimeStamp asc limit ?)", new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        if (this.f206a == null || this.f206a.length <= 0) {
            return;
        }
        this.f206a[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.ch.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a2 = cn.a(a());
            long j = bz.f187a;
            if (a2 <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a2 - j) * 1.2d) / j) * longValue);
            a(j2);
            bv a3 = bv.a(context);
            a3.a("begin delete " + j2 + "noUpload messages , because db size is " + a2 + "B");
            super.a(context, obj);
        }
    }
}
