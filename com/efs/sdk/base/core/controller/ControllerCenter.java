package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.a.c;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.e.d;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.c.a.c.a.d;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.umcrash.UMCrash;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/controller/ControllerCenter.class */
public class ControllerCenter implements Handler.Callback {
    private static GlobalEnvStruct h;

    /* renamed from: a  reason: collision with root package name */
    private int f8153a = 0;
    private final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f8154c = 1;
    private final int d = 2;
    private final int e = 3;
    private volatile boolean f = false;
    private a g;
    private Handler i;

    public ControllerCenter(EfsReporter.Builder builder) {
        h = builder.getGlobalEnvStruct();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.f8189a.getLooper(), this);
        this.i = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.g == null) {
            this.g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            h.mAppContext.registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            Log.w("efs.base", "register network change receiver error", th);
            int i = this.f8153a + 1;
            this.f8153a = i;
            if (i < 3) {
                this.i.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("log_type", iLogProtocol.getLogType());
            hashMap.put(d.d, iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            Message obtain = Message.obtain(null, 9, hashMap);
            Message obtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(b.a.a().f8151a);
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final com.efs.sdk.base.core.d.b a2 = com.efs.sdk.base.core.d.b.a(iLogProtocol);
                        final com.efs.sdk.base.core.e.d a3 = d.a.a();
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.e.d.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a3.f8164a.a(a2);
                            }
                        });
                    }
                } catch (Throwable th) {
                    Log.e("efs.base", "log send error", th);
                }
            }
        });
    }

    public static GlobalEnvStruct getGlobalEnvStruct() {
        return h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i != 3) {
                    return true;
                }
                a();
                return true;
            }
            Object obj = message.obj;
            if (obj == null || !(obj instanceof ILogProtocol)) {
                return true;
            }
            b((ILogProtocol) obj);
            return true;
        }
        b a2 = b.a.a();
        a2.f8151a = new com.efs.sdk.base.core.config.a();
        a2.f8151a.a("appid", getGlobalEnvStruct().getAppid());
        int myPid = ProcessUtil.myPid();
        a2.f8151a.a("pid", Integer.valueOf(myPid));
        a2.f8151a.a("ps", ProcessUtil.getProcessName(myPid));
        String a3 = com.efs.sdk.base.core.util.d.a(a2.b);
        a2.f8151a.a("wid", a3);
        if (TextUtils.isEmpty(getGlobalEnvStruct().getUid())) {
            a2.f8151a.a("uid", a3);
        } else {
            a2.f8151a.a("uid", getGlobalEnvStruct().getUid());
        }
        com.efs.sdk.base.core.config.a aVar = a2.f8151a;
        com.efs.sdk.base.core.a.a.a();
        aVar.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
        a2.f8151a.a("pkg", PackageUtil.getPackageName(a2.b));
        a2.f8151a.a("ver", PackageUtil.getAppVersionName(a2.b));
        a2.f8151a.a(RedirectRespWrapper.KEY_VERCODE, PackageUtil.getAppVersionCode(a2.b));
        a2.f8151a.a(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.3.10.umeng");
        a2.f8151a.a("brand", Build.BRAND.toLowerCase());
        a2.f8151a.a("model", Build.MODEL == null ? "unknown" : Build.MODEL.replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase());
        a2.f8151a.a("build_model", Build.MODEL);
        DisplayMetrics displayMetrics = a2.b.getResources().getDisplayMetrics();
        a2.f8151a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
        a2.f8151a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
        a2.f8151a.a(com.anythink.expressad.video.dynview.a.a.Z, "android");
        a2.f8151a.a("rom", Build.VERSION.RELEASE);
        a2.f8151a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
        a2.f8151a.a("lang", Locale.getDefault().getLanguage());
        a2.f8151a.a("tzone", TimeZone.getDefault().getID());
        a2.f8151a.a(TKDownloadReason.KSAD_TK_NET, NetworkUtil.getNetworkType(a2.b));
        try {
            String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(a2.b);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                a2.f8151a.a(UMCrash.KEY_HEADER_ACCESS, "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                a2.f8151a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
            } else {
                a2.f8151a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                a2.f8151a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
            }
            a2.f8151a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(a2.b)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        f.a.a();
        c.a().b();
        a();
        com.efs.sdk.base.core.f.f a4 = f.a.a();
        boolean isIntl = h.isIntl();
        com.efs.sdk.base.core.f.c cVar = a4.f8173a;
        if (isIntl) {
            cVar.f8170a = "https://errlogos.umeng.com/api/crashsdk/logcollect";
            cVar.b = "4ea4e41a3993";
        } else {
            cVar.f8170a = "https://errlog.umeng.com/api/crashsdk/logcollect";
            cVar.b = "28ef1713347d";
        }
        a4.b = this;
        a4.f8174c.f8167a = a4.b;
        a4.d.f8167a = a4.b;
        this.f = true;
        com.efs.sdk.base.core.c.d.a().sendEmptyMessageDelayed(0, h.getLogSendDelayMills());
        com.efs.sdk.base.core.f.f a5 = f.a.a();
        if (a5.b == null || !getGlobalEnvStruct().isEnableWaStat()) {
            return true;
        }
        a5.b.send(new com.efs.sdk.base.core.f.b("efs_core", "pvuv", a5.f8173a.f8171c));
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f) {
            b(iLogProtocol);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iLogProtocol;
        this.i.sendMessage(obtain);
    }

    public HttpResponse sendSyncImmediately(String str, int i, String str2, boolean z, File file) {
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str, (byte) 2);
        bVar.b(1);
        bVar.d = file;
        bVar.a(str2);
        bVar.a(i);
        bVar.b.b = z;
        bVar.c();
        d.a.a().f8164a.a(bVar);
        return bVar.b.f8161c;
    }
}
