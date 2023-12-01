package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/g.class */
public class g extends com.huawei.openalliance.ad.download.b<AppDownloadTask> {
    private static final byte[] B = new byte[0];
    private static g C;
    private static final String Z = "ApDnMgr";
    private e F;
    private Context S;

    private g(Context context) {
        super(context);
        super.Code();
        this.S = context.getApplicationContext();
        e eVar = new e(context);
        this.F = eVar;
        super.Code(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean B(com.huawei.openalliance.ad.download.app.AppDownloadTask r8) {
        /*
            r7 = this;
            r0 = r8
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            r0 = r8
            boolean r0 = r0.l()
            if (r0 == 0) goto L35
            java.lang.String r0 = "ApDnMgr"
            java.lang.String r1 = "switch next install way succ, curInstallWay:%s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.String r5 = r5.j()
            r3[r4] = r5
            com.huawei.hms.ads.ge.V(r0, r1, r2)
            r0 = r8
            boolean r0 = r0.m()
            if (r0 == 0) goto L33
            r0 = r7
            android.content.Context r0 = r0.Code
            boolean r0 = com.huawei.openalliance.ad.utils.v.S(r0)
            if (r0 != 0) goto L33
            goto L6
        L33:
            r0 = 1
            return r0
        L35:
            java.lang.String r0 = "ApDnMgr"
            java.lang.String r1 = "switch next install way fail, curInstallWay:%s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.String r5 = r5.j()
            r3[r4] = r5
            com.huawei.hms.ads.ge.V(r0, r1, r2)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.download.app.g.B(com.huawei.openalliance.ad.download.app.AppDownloadTask):boolean");
    }

    private boolean C(AppDownloadTask appDownloadTask) {
        AdContentData f = appDownloadTask.f();
        if (f != null) {
            return new com.huawei.openalliance.ad.uriaction.b(this.Code, f).Code();
        }
        return false;
    }

    public static void Code(Context context) {
        synchronized (B) {
            if (C == null) {
                C = new g(context);
            }
        }
    }

    public static g I() {
        g gVar;
        synchronized (B) {
            if (C == null) {
                throw new RuntimeException("AppDownloadManager instance is not init!");
            }
            gVar = C;
        }
        return gVar;
    }

    private static boolean I(AppInfo appInfo) {
        return appInfo == null || TextUtils.isEmpty(appInfo.Code());
    }

    @Override // com.huawei.openalliance.ad.download.b
    public void Code(final AppDownloadTask appDownloadTask) {
        if (!appDownloadTask.k()) {
            c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() != -1) {
                        g.super.Code((g) appDownloadTask);
                    }
                }
            }, String.class);
            return;
        }
        AppInfo L = appDownloadTask.L();
        if (L == null || TextUtils.isEmpty(L.h()) || !C(appDownloadTask)) {
            ge.V(Z, "can not open Ag detail");
            Z(appDownloadTask);
        }
    }

    public void Code(AppInfo appInfo) {
        if (I(appInfo)) {
            return;
        }
        final AppDownloadTask V = V(appInfo);
        if (V != null) {
            c.I(this.S, V, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.4
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == 200 && String.valueOf(Boolean.TRUE).equals(callResult.getData())) {
                        g.super.I((g) V);
                        ge.V(g.Z, " removeTask task is success:" + V.F());
                    }
                }
            }, String.class);
            return;
        }
        ge.V(Z, " removeTask failed:" + appInfo.Code());
    }

    public void Code(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!I(appInfo)) {
            this.F.Code(appInfo.Code(), gVar);
        }
        if (dp.Code(appInfo)) {
            b.Code(this.Code).Code(appInfo.G(), gVar);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.F.Code(appDownloadListener);
    }

    public void I(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    ge.V(g.Z, " resume task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public AppDownloadTask V(AppInfo appInfo) {
        RemoteAppDownloadTask remoteAppDownloadTask;
        if (I(appInfo)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(appInfo.Code());
        if (appDownloadTask != null || (remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, RemoteAppDownloadTask.class)) == null) {
            return appDownloadTask;
        }
        ge.Code(Z, " remote task is exist, create proxy task by appInfo");
        ge.V(Z, " remote task is exist, create proxy task");
        AppDownloadTask Code = remoteAppDownloadTask.Code(appInfo);
        super.Code((g) Code);
        return Code;
    }

    @Override // com.huawei.openalliance.ad.download.b
    /* renamed from: V */
    public AppDownloadTask Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(str);
        if (appDownloadTask == null) {
            AppInfo appInfo = new AppInfo();
            appInfo.D(str);
            appInfo.I("5");
            RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, RemoteAppDownloadTask.class);
            if (remoteAppDownloadTask != null) {
                ge.V(Z, " remote task is exist, create proxy task");
                AppDownloadTask Code = remoteAppDownloadTask.Code(appInfo);
                super.Code((g) Code);
                return Code;
            }
        }
        return appDownloadTask;
    }

    public void V(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.V(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    ge.V(g.Z, " pause task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public void V(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!I(appInfo)) {
            this.F.V(appInfo.Code(), gVar);
        }
        if (dp.Code(appInfo)) {
            b.Code(this.Code).V(appInfo.G(), gVar);
        }
    }

    public boolean Z(AppDownloadTask appDownloadTask) {
        if (B(appDownloadTask)) {
            V((g) appDownloadTask);
            Code(appDownloadTask);
            return true;
        }
        return false;
    }
}
