package com.amap.api.services.core;

import android.content.Context;
import android.view.Window;
import com.amap.api.col.p0003sl.fd;
import com.amap.api.col.p0003sl.fe;
import com.amap.api.col.p0003sl.gk;
import com.amap.api.col.p0003sl.hq;
import com.amap.api.col.p0003sl.hu;
import com.amap.api.col.p0003sl.hx;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/core/ServiceSettings.class */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings c;
    private String a = "zh-CN";
    private int b = 1;
    private int d = Window.PROGRESS_SECONDARY_START;
    private int e = Window.PROGRESS_SECONDARY_START;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (c == null) {
            c = new ServiceSettings();
        }
        return c;
    }

    public static void updatePrivacyAgree(Context context, boolean z) {
        synchronized (ServiceSettings.class) {
            try {
                hx.a(context, z, fd.a(false));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void updatePrivacyShow(Context context, boolean z, boolean z2) {
        synchronized (ServiceSettings.class) {
            try {
                hx.a(context, z, z2, fd.a(false));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            gk.b();
        } catch (Throwable th) {
            fe.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.d;
    }

    public String getLanguage() {
        return this.a;
    }

    public int getProtocol() {
        return this.b;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setApiKey(String str) {
        hq.a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setLanguage(String str) {
        this.a = str;
    }

    public void setProtocol(int i) {
        this.b = i;
        hu.a().a(this.b == 2);
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }
}
