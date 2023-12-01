package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/b.class */
public class b implements IGDTAdManager {
    public static final ExecutorService g = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private volatile Boolean f14223a;
    private volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Context f14224c;
    private volatile PM d;
    private volatile DevTools e;
    private volatile String f;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static b f14225a = new b(null);
    }

    private b() {
        this.f14223a = Boolean.FALSE;
        this.b = false;
    }

    /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        return a.f14225a;
    }

    public String a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, String str) {
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 14) {
                GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
                return false;
            } else if (this.f14223a.booleanValue()) {
                return true;
            } else {
                if (context == null || TextUtils.isEmpty(str)) {
                    GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
                    return false;
                }
                this.f = str;
                this.f14224c = context.getApplicationContext();
                this.d = new PM(this.f14224c, null);
                g.submit(new com.qq.e.comm.managers.a(this));
                this.f14223a = Boolean.TRUE;
                return true;
            }
        }
    }

    public PM c() {
        return this.d;
    }

    public boolean d() {
        if (this.f14223a == null || !this.f14223a.booleanValue()) {
            GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (d()) {
            try {
                return this.d.getPOFactory().getBuyerId(map);
            } catch (Exception e) {
                GDTLogger.e("SDK 初始化异常", e);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.e == null) {
            this.e = new DevTools();
        }
        return this.e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (d()) {
            try {
                return this.d.getPOFactory().getSDKInfo(str);
            } catch (Exception e) {
                GDTLogger.e("SDK 初始化异常", e);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (this.b) {
            try {
                return this.d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
            } catch (Exception e) {
                GDTLogger.e("SDK 初始化异常", e);
                return 0;
            }
        }
        return 0;
    }
}
