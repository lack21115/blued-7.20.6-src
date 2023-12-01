package com.tencent.tmsqmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.mapsdk.internal.oj;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f26024a;
    private static final int b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/h$a.class */
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            h.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/h$b.class */
    public static final class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            h.b();
        }
    }

    static {
        int i = 23;
        if (Build.VERSION.SDK_INT < 23) {
            i = 9;
        }
        b = i;
    }

    private static void a() {
        String str;
        try {
            int i = b;
            String[] strArr = new String[i];
            f.a(10L, 0L, 0L, 0L, null, null, null, strArr);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    sb2.append(String.format(";k%d:", Integer.valueOf(i + 1)));
                    sb2.append("4.1");
                    sb.append(sb2.toString());
                    sb.append(",");
                    sb.append(com.tencent.tmsqmsp.sdk.a.c.a(sb2.toString()));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Java -- cbid: ");
                    sb3.append(sb.toString());
                    sb3.append(" bidMd5: ");
                    sb3.append(com.tencent.tmsqmsp.sdk.a.c.a(sb2.toString()));
                    com.tencent.tmsqmsp.sdk.f.g.b("cbid", 0, sb3.toString());
                    com.tencent.tmsqmsp.sdk.a.f.a(sb.toString(), 5);
                    return;
                }
                strArr[i3] = com.tencent.tmsqmsp.sdk.f.i.a(strArr[i3]);
                sb.append(strArr[i3]);
                sb.append(",");
                if (i3 == 0) {
                    sb2.append(String.format("k%d:", Integer.valueOf(i3 + 1)));
                    str = strArr[i3];
                } else {
                    sb2.append(String.format(";k%d:", Integer.valueOf(i3 + 1)));
                    str = strArr[i3];
                }
                sb2.append(str);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(long j) {
        f.i().c().postDelayed(new b(), j);
    }

    public static void a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(com.tencent.tmsqmsp.sdk.c.b.f26014a);
            sb.append("qmsp_cbid_time");
            f26024a = context.getSharedPreferences(sb.toString(), 0);
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        boolean taskStatus;
        long j;
        try {
            taskStatus = oj.getTaskStatus();
            if (!taskStatus) {
                com.tencent.tmsqmsp.sdk.f.g.a("cbid", 1, "Cbid Task Finish！");
            } else if (f26024a != null) {
                if (!f.i().a(1002).booleanValue()) {
                    a(28800000L);
                    return;
                }
                long j2 = 0;
                long j3 = f26024a.getLong("cbid_last_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = currentTimeMillis - j3;
                if (j4 >= 0) {
                    j2 = j4;
                }
                if (j2 > 28800000) {
                    a();
                    SharedPreferences.Editor edit = f26024a.edit();
                    edit.putLong("cbid_last_time", currentTimeMillis);
                    edit.commit();
                    j = 28800000;
                } else {
                    j = 28800000 - j2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cbid rpt after: ");
                sb.append(j);
                com.tencent.tmsqmsp.sdk.f.g.a("cbid", 1, sb.toString());
                f.i().c().postDelayed(new a(), j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
