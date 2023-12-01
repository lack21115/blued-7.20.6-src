package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/b.class */
public class b {
    private static b a = new b();
    private Context mContext = null;
    private String C = null;
    private String D = null;
    private String E = null;
    private String F = null;

    /* renamed from: a  reason: collision with other field name */
    private Application f27a = null;
    private String G = null;

    /* renamed from: a  reason: collision with other field name */
    private IUTRequestAuthentication f28a = null;
    private boolean s = false;
    private boolean t = false;

    private b() {
    }

    public static b a() {
        return a;
    }

    private void c(String str) {
        Context context;
        this.C = str;
        if (!TextUtils.isEmpty(str)) {
            this.D = str;
        }
        if (TextUtils.isEmpty(str) || (context = this.mContext) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_lun", new String(com.alibaba.mtl.log.e.c.encode(str.getBytes("UTF-8"), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void d(String str) {
        Context context;
        this.E = str;
        if (!TextUtils.isEmpty(str)) {
            this.F = str;
        }
        if (TextUtils.isEmpty(str) || (context = this.mContext) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_luid", new String(com.alibaba.mtl.log.e.c.encode(str.getBytes("UTF-8"), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void o() {
        if (this.s || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            if (a().m8609a() != null) {
                UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(a().m8609a());
                this.s = true;
                return;
            }
            UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application) a().getContext().getApplicationContext());
            this.s = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("UTEngine", "You need set a application instance for UT.");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Application m8609a() {
        return this.f27a;
    }

    public String getAppVersion() {
        return this.G;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setAppApplicationInstance(Application application) {
        this.f27a = application;
        o();
    }

    public void setAppVersion(String str) {
        this.G = str;
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
            String string = sharedPreferences.getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.D = new String(com.alibaba.mtl.log.e.c.decode(string.getBytes(), 2), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string2 = sharedPreferences.getString("_luid", "");
            if (!TextUtils.isEmpty(string2)) {
                try {
                    this.F = new String(com.alibaba.mtl.log.e.c.decode(string2.getBytes(), 2), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        o();
    }

    public void turnOnDebug() {
        i.d(true);
    }

    public void updateUserAccount(String str, String str2) {
        c(str);
        d(str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("UT", 1007, str, str2, (String) null, (Map) null).build());
    }
}
