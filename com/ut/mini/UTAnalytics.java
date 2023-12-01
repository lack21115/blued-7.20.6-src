package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTAnalytics.class */
public class UTAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static UTAnalytics f27324a;

    /* renamed from: a  reason: collision with other field name */
    private UTTracker f28a;
    private Map<String, UTTracker> u = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    public static UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            try {
                if (f27324a == null) {
                    f27324a = new UTAnalytics();
                }
                uTAnalytics = f27324a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uTAnalytics;
    }

    private boolean o() {
        try {
            Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UTTracker getDefaultTracker() {
        UTTracker uTTracker;
        synchronized (this) {
            if (this.f28a == null) {
                this.f28a = new UTTracker();
            }
            if (this.f28a == null) {
                i.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
            }
            uTTracker = this.f28a;
        }
        return uTTracker;
    }

    public UTTracker getTracker(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                i.a("getTracker", "TrackId is null.");
                return null;
            } else if (this.u.containsKey(str)) {
                return this.u.get(str);
            } else {
                UTTracker uTTracker = new UTTracker();
                uTTracker.p(str);
                this.u.put(str, uTTracker);
                return uTTracker;
            }
        }
    }

    public void setAppApplicationInstance(Application application) {
        b.a().setAppApplicationInstance(application);
        AppMonitor.init(application);
        if (application != null) {
            try {
                ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return;
                }
                String str = applicationInfo.metaData.get("com.alibaba.apmplus.app_key") + "";
                String str2 = applicationInfo.metaData.get("com.alibaba.apmplus.app_secret") + "";
                String str3 = applicationInfo.metaData.get("com.alibaba.apmplus.authcode") + "";
                String str4 = applicationInfo.metaData.get("com.alibaba.apmplus.channel") + "";
                if (!TextUtils.isEmpty(str)) {
                    AppMonitor.setRequestAuthInfo(o(), str, str2, str3);
                }
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                AppMonitor.setChannel(str4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAppVersion(String str) {
        b.a().setAppVersion(str);
    }

    public void setChannel(String str) {
        AppMonitor.setChannel(str);
    }

    public void setContext(Context context) {
        b.a().setContext(context);
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            i.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            AppMonitor.setRequestAuthInfo(false, iUTRequestAuthentication.getAppkey(), ((UTBaseRequestAuthentication) iUTRequestAuthentication).getAppSecret(), (String) null);
        } else {
            AppMonitor.setRequestAuthInfo(true, iUTRequestAuthentication.getAppkey(), (String) null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
        }
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }

    public void turnOnDebug() {
        b.a().turnOnDebug();
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map a2 = c.a().a();
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            hashMap.putAll(a2);
        }
        hashMap.putAll(map);
        c.a().c(hashMap);
    }

    public void updateUserAccount(String str, String str2) {
        b.a().updateUserAccount(str, str2);
    }

    public void userRegister(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("userRegister", "Fatal Error,usernick can not be null or empty!");
            return;
        }
        UTTracker defaultTracker = getDefaultTracker();
        if (defaultTracker != null) {
            defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
        } else {
            i.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }
}
