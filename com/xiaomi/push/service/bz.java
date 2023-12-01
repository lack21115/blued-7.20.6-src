package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bz.class */
public class bz {

    /* renamed from: a  reason: collision with root package name */
    private static String f27967a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f991a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f992a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f991a = simpleDateFormat;
        f27967a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static Cif a(String str, String str2, hj hjVar) {
        return new Cif("-1", false).d(str).b(str2).a(com.xiaomi.push.x.a(iq.a(hjVar))).c(hq.UploadTinyData.f536a);
    }

    public static String a() {
        String str;
        synchronized (bz.class) {
            try {
                String format = f991a.format(Long.valueOf(System.currentTimeMillis()));
                if (!TextUtils.equals(f27967a, format)) {
                    f992a.set(0L);
                    f27967a = format;
                }
                str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f992a.incrementAndGet();
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.Cif> a(java.util.List<com.xiaomi.push.hk> r5, java.lang.String r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bz.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        hkVar.a("push_sdk_channel");
        hkVar.g(context.getPackageName());
        hkVar.e(context.getPackageName());
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.f(a());
        ca.a(context, hkVar);
    }

    public static boolean a(hk hkVar, boolean z) {
        String str;
        if (hkVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hkVar.f508a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hkVar.f515d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hkVar.f514c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.bn.m8498a(hkVar.f515d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.bn.m8498a(hkVar.f514c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (hkVar.f513b == null || hkVar.f513b.length() <= 10240) {
            return false;
        } else {
            str = "item.data is too large(" + hkVar.f513b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a(str);
        return true;
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.r.m9020b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
