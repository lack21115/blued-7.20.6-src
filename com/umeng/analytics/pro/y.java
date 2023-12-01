package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/y.class */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private static volatile y f27096c;

    /* renamed from: a  reason: collision with root package name */
    private w f27097a = new x();
    private String b;
    private List<a> d;
    private String e;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/y$a.class */
    public interface a {
        void a(String str, long j, long j2, long j3);

        void a(String str, String str2, long j, long j2, long j3);
    }

    private y() {
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception e) {
            j = 0;
        }
        long j2 = j;
        if (j <= 0) {
            j2 = System.currentTimeMillis();
        }
        return j2;
    }

    public static y a() {
        if (f27096c == null) {
            synchronized (y.class) {
                try {
                    if (f27096c == null) {
                        f27096c = new y();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27096c;
    }

    private void a(long j, long j2, long j3, String str, boolean z) {
        List<a> list = this.d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.b, j, j2, j3);
                    } catch (Exception e) {
                    }
                } else {
                    aVar.a(this.b, j, j2, j3);
                }
            }
        }
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(u.d, d(context));
            edit.commit();
        } catch (Exception e) {
        }
        long h = h(context);
        long i = i(context);
        String str = this.b;
        long a2 = u.a(context);
        long j = a2 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i, h, j, str, false);
        this.b = this.f27097a.a(context);
        a(i, h, j, str, true);
        this.f27097a.a(context, this.b);
        return this.b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.b) && i.a(context).a(this.b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f);
    }

    private long i(Context context) {
        return a(context, u.f27090a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(u.e, 0L);
            long j2 = sharedPreferences.getLong(u.f, 0L);
            long j3 = j2;
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                j3 = j2;
                if (j > 0) {
                    j3 = j2;
                    if (j2 == 0) {
                        long a2 = u.a(appContext);
                        j3 = j2;
                        if (a2 > 0) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                            j3 = j + (a2 * 5000);
                        }
                    }
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j));
            return this.f27097a.a(j, j3);
        } catch (Exception e) {
            return false;
        }
    }

    public String a(Context context) {
        String string;
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(u.d, "");
                str = string;
            }
            return string;
        } catch (Exception e) {
            return str;
        }
    }

    public String a(Context context, long j) {
        String str;
        if (TextUtils.isEmpty(this.e)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SUB" + j);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.e = sb.toString();
        }
        return this.e;
    }

    public void a(long j) {
        this.f27097a.a(j);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (this.d.contains(aVar)) {
            return;
        }
        this.d.add(aVar);
    }

    public long b() {
        return this.f27097a.a();
    }

    public String b(Context context) {
        synchronized (this) {
            Context appContext = UMGlobalContext.getAppContext(context);
            if (appContext == null) {
                return "";
            }
            this.b = d(appContext);
            if (e(appContext)) {
                try {
                    this.b = f(appContext);
                } catch (Exception e) {
                }
            }
            return this.b;
        }
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.d) == null || list.size() == 0) {
            return;
        }
        this.d.remove(aVar);
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (Exception e) {
        }
        return this.b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception e) {
            }
        }
        return this.b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return TextUtils.isEmpty(this.b) || j(context) || g(context);
    }
}
