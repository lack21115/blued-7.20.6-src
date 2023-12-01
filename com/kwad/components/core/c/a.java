package com.kwad.components.core.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.blued.das.live.LiveProtos;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.w;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.h;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.k;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/c/a.class */
public final class a {
    private static boolean Io;
    private static final AtomicBoolean Ip = new AtomicBoolean(false);
    private static List<Throwable> Iq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/c/a$a.class */
    public static final class C0516a {
        public static String Y(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            File file = null;
            if (Build.VERSION.SDK_INT >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                file = context.getDataDir();
            }
            File file2 = file;
            if (file == null) {
                File file3 = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                file2 = file3;
                if (!file3.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return file2;
        }
    }

    private static String al(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void b(Throwable th) {
        b.printStackTrace(th);
        if (Ip.get()) {
            com.kwad.sdk.crash.b.g(th);
        } else {
            c(th);
        }
    }

    private static void c(Throwable th) {
        if (Iq == null) {
            Iq = new CopyOnWriteArrayList();
        }
        Iq.add(th);
    }

    public static void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                try {
                    if (!Ip.get() && !Io) {
                        Io = true;
                        g.execute(new aw() { // from class: com.kwad.components.core.c.a.1
                            @Override // com.kwad.sdk.utils.aw
                            public final void doTask() {
                                if (d.b(c.abI)) {
                                    b.d("KsAdExceptionCollectorHelper", "init");
                                    com.kwad.sdk.crash.b.a(a.mx());
                                    a.Ip.set(true);
                                    a.mt();
                                }
                            }
                        });
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mt() {
        List<Throwable> list = Iq;
        if (list == null) {
            return;
        }
        for (Throwable th : list) {
            com.kwad.sdk.crash.b.g(th);
        }
        Iq.clear();
        Iq = null;
        ServiceProvider.b(new com.kwad.sdk.e.a<Throwable>() { // from class: com.kwad.components.core.c.a.2
            private static void d(Throwable th2) {
                com.kwad.sdk.crash.b.g(th2);
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(Throwable th2) {
                d(th2);
            }
        });
    }

    private static com.kwad.sdk.crash.c mu() {
        final Context context = ServiceProvider.getContext();
        return new c.a().bm(context).bf(d.b(com.kwad.sdk.core.config.c.acS)).bg(d.b(com.kwad.sdk.core.config.c.acT)).bh(KsAdSDKImpl.get().getIsExternal()).dr(d.a(com.kwad.sdk.core.config.c.acU)).dq(d.a(com.kwad.sdk.core.config.c.acV)).dx(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).bF(KsAdSDKImpl.get().getSDKVersionCode()).dy(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).bG(KsAdSDKImpl.get().getApiVersionCode()).bH(1).dw("com.kwad.sdk").dz(context.getPackageName()).dA(ServiceProvider.CB().appId).dB(ServiceProvider.CB().appName).dC(k.bH(context)).dt(au.getDeviceId()).du(ServiceProvider.CB().appId).ds("Android").dv(C0516a.Y(context)).a(new h() { // from class: com.kwad.components.core.c.a.4
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a mA() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.dD(w.xi());
                aVar.putString("mKsadAppId", ServiceProvider.CB().appId);
                aVar.putString("mKsadAppName", ServiceProvider.CB().appName);
                aVar.putString("mKsadAppPackageName", Context.this.getPackageName());
                aVar.putString("mKsadAppVersion", k.bH(Context.this));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE);
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.c.a.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                com.kwad.sdk.g.sS();
                if (i == 1 || i == 3 || i == 4) {
                    b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
            }
        }).d(mv()).e(mw()).u(d.tY()).j(d.a(com.kwad.sdk.core.config.c.adO)).zx();
    }

    private static String[] mv() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(al(KsAdSDKImpl.class.getName()));
            arrayList.add(al(DownloadTask.class.getName()));
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
        try {
            arrayList.add(al(CpuMemoryProfiler.class.getName()));
            arrayList.add(al(Aegon.class.getName()));
        } catch (Throwable th2) {
            b.printStackTraceOnly(th2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] mw() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
            return strArr;
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
            return strArr;
        }
    }

    static /* synthetic */ com.kwad.sdk.crash.c mx() {
        return mu();
    }
}
