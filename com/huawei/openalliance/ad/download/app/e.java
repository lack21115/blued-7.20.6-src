package com.huawei.openalliance.ad.download.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.hj;
import com.huawei.hms.ads.hq;
import com.huawei.openalliance.ad.activity.AgProtocolActivity;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.DownloadListener;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/e.class */
public class e implements DownloadListener<AppDownloadTask>, com.huawei.openalliance.ad.download.e<AppDownloadTask>, NotifyCallback {
    private static Map<String, Method> B = new HashMap();
    private static final String Code = "ApDnDe";
    private Context V;
    private AppDownloadListener Z;
    private Map<String, Set<com.huawei.openalliance.ad.download.g>> I = new ConcurrentHashMap();
    private BroadcastReceiver C = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.1.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb;
                    try {
                        String action = intent.getAction();
                        ge.Code(e.Code, "appRe action: %s", action);
                        e.this.Code(intent, action);
                    } catch (IllegalStateException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        ge.I(e.Code, sb.toString());
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("appRe ");
                        sb.append(e.getClass().getSimpleName());
                        ge.I(e.Code, sb.toString());
                    }
                }
            });
        }
    };
    private BroadcastReceiver S = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            Runnable runnable;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                ge.V(e.Code, "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    ge.I(e.Code, "itRe dataString is empty, " + action);
                    return;
                }
                final String substring = dataString.substring(8);
                e.this.Code(action, substring);
                if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.onAppInstalled(g.I().Code(substring));
                        }
                    });
                    return;
                }
                if (Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
                    e.this.Code(substring);
                    if (TextUtils.isEmpty(substring)) {
                        ge.V(e.Code, "a bad removed intent");
                        return;
                    } else if (!substring.equals(com.huawei.openalliance.ad.utils.e.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                } else if (!Intent.ACTION_PACKAGE_DATA_CLEARED.equals(action)) {
                    return;
                } else {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        ge.V(e.Code, "a bad intent");
                        return;
                    } else if (!schemeSpecificPart.equals(com.huawei.openalliance.ad.utils.e.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                }
                ba.Code(runnable);
            } catch (IllegalStateException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                ge.I(e.Code, sb.toString());
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("itRe:");
                sb.append(e.getClass().getSimpleName());
                ge.I(e.Code, sb.toString());
            }
        }
    };

    public e(Context context) {
        this.V = context.getApplicationContext();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("huawei.intent.action.DOWNLOAD");
            intentFilter.addAction("huawei.intent.action.OPEN");
            intentFilter.addAction(d.I);
            intentFilter.addAction(d.f22967c);
            intentFilter.addAction(d.B);
            this.V.registerReceiver(this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (v.B(this.V)) {
                com.huawei.openalliance.ad.msgnotify.b.Code(context, d.i, this);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.V(context, d.i, this);
            }
            IntentFilter intentFilter2 = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            intentFilter2.addAction(Intent.ACTION_PACKAGE_REMOVED);
            intentFilter2.addAction(Intent.ACTION_PACKAGE_REPLACED);
            intentFilter2.addAction(Intent.ACTION_PACKAGE_DATA_CLEARED);
            intentFilter2.addDataScheme("package");
            this.V.registerReceiver(this.S, intentFilter2);
            hq.Code(context).Code();
            Code();
        } catch (Throwable th) {
            ge.I(Code, "registerReceiver " + th.getClass().getSimpleName());
        }
    }

    private Set<com.huawei.openalliance.ad.download.g> Code(AppInfo appInfo) {
        synchronized (this) {
            if (appInfo != null) {
                if (!TextUtils.isEmpty(appInfo.Code())) {
                    return V(appInfo.Code());
                }
            }
            return null;
        }
    }

    private static void Code() {
        try {
            Method[] declaredMethods = e.class.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Method method = declaredMethods[i2];
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(AppDownloadTask.class)) {
                    B.put(method.getName(), method);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            ge.Code(Code, "transport=%s", th.getMessage());
            ge.Z(Code, "transport=" + th.getClass().getSimpleName());
        }
    }

    private void Code(Intent intent) {
        try {
            if (d.I.equals(intent.getAction())) {
                AppInfo appInfo = (AppInfo) z.V(intent.getStringExtra("appInfo"), AppInfo.class, new Class[0]);
                if (appInfo == null) {
                    ge.V(Code, "appInfo is null");
                    return;
                }
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(appInfo);
                }
            }
        } catch (Throwable th) {
            ge.I(Code, "exception: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent, String str) {
        AppInfo appInfo;
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!"huawei.intent.action.DOWNLOAD".equals(str)) {
            if ("huawei.intent.action.OPEN".equals(str)) {
                String stringExtra = safeIntent.getStringExtra("appPackageName");
                AppDownloadListener appDownloadListener = this.Z;
                if (appDownloadListener != null) {
                    appDownloadListener.Code(stringExtra);
                    return;
                }
                return;
            } else if (d.I.equals(str)) {
                Code(safeIntent);
                return;
            } else if (d.f22967c.equals(str)) {
                ge.V(Code, "request intent");
                V(safeIntent);
                return;
            } else if (d.B.equals(str)) {
                I(safeIntent);
                return;
            } else {
                return;
            }
        }
        String stringExtra2 = safeIntent.getStringExtra("appPackageName");
        AppDownloadTask Code2 = g.I().Code(stringExtra2);
        if (Code2 == null) {
            ge.V(Code, " task is null, pkg=" + stringExtra2);
            I(stringExtra2);
            return;
        }
        String stringExtra3 = safeIntent.getStringExtra("appInfo");
        if (!TextUtils.isEmpty(stringExtra3) && (appInfo = (AppInfo) z.V(stringExtra3, AppInfo.class, new Class[0])) != null) {
            ge.V(Code, "update appInfo from remote task.");
            Code2.Code(appInfo);
        }
        Code(Code2, safeIntent);
        String stringExtra4 = safeIntent.getStringExtra("appDownloadMethod");
        if (TextUtils.isEmpty(stringExtra4)) {
            return;
        }
        if (stringExtra4.equals("onDownloadDeleted")) {
            g.I().I((g) Code2);
            return;
        }
        Method method = B.get(stringExtra4);
        if (method != null) {
            try {
                ge.Code(Code, "methodName:%s", stringExtra4);
                method.invoke(this, Code2);
            } catch (IllegalAccessException e) {
                ge.Code(Code, "ilex=%s", stringExtra4);
            } catch (InvocationTargetException e2) {
                ge.Code(Code, "itex=%s", stringExtra4);
            }
        }
    }

    private void Code(AppDownloadTask appDownloadTask, int i) {
        appDownloadTask.V((appDownloadTask.I() * i) / 100);
    }

    private void Code(AppDownloadTask appDownloadTask, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        appDownloadTask.Code(safeIntent.getIntExtra("downloadStatus", 0));
        appDownloadTask.I(safeIntent.getIntExtra("downloadProgress", 0));
        appDownloadTask.Z(safeIntent.getIntExtra("pauseReason", 0));
        appDownloadTask.B(safeIntent.getIntExtra(d.k, 0));
        Code(appDownloadTask, appDownloadTask.S());
    }

    private void Code(k kVar, AppDownloadTask appDownloadTask) {
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(kVar, appDownloadTask.L());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Set<com.huawei.openalliance.ad.download.g> V = V(str2);
        if (V != null && V.size() > 0) {
            if (Intent.ACTION_PACKAGE_ADDED.equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar : V) {
                    if (gVar != null) {
                        gVar.V(str2);
                    }
                }
            } else if (Intent.ACTION_PACKAGE_REMOVED.equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar2 : V) {
                    if (gVar2 != null) {
                        gVar2.I(str2);
                    }
                }
            }
        }
        if (!Intent.ACTION_PACKAGE_REMOVED.equals(str) || this.Z == null) {
            return;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.D(str2);
        this.Z.Code(k.DOWNLOAD, appInfo);
    }

    private void I(Intent intent) {
        String str;
        if (intent == null) {
            str = "msgData is empty!";
        } else {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra(at.f22944ar);
            if (stringExtra == null || stringExtra.equals(this.V.getPackageName())) {
                String stringExtra2 = safeIntent.getStringExtra("contentRecord");
                if (ge.Code()) {
                    ge.Code(Code, "sendNotify content: %s", bc.Code(stringExtra2));
                }
                AdContentData adContentData = (AdContentData) z.V(stringExtra2, AdContentData.class, new Class[0]);
                if (adContentData != null) {
                    String stringExtra3 = safeIntent.getStringExtra("unique_id");
                    AppInfo u = adContentData.u();
                    if (u == null || u.l() != 1 || TextUtils.isEmpty(u.m())) {
                        return;
                    }
                    int intExtra = safeIntent.getIntExtra(at.L, 1);
                    hj hjVar = new hj(this.V, adContentData, stringExtra3);
                    hjVar.Code(intExtra);
                    hjVar.I();
                    return;
                }
                str = " contentData is empty.";
            } else {
                str = "sourcePackageName not equals packageName.";
            }
        }
        ge.V(Code, str);
    }

    private void I(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        for (com.huawei.openalliance.ad.download.g gVar : Code2) {
            gVar.V(appDownloadTask);
        }
    }

    private void I(String str) {
        if (TextUtils.isEmpty(str)) {
            ge.V(Code, " packageName is empty.");
            return;
        }
        Set<com.huawei.openalliance.ad.download.g> V = V(str);
        ge.Code(Code, " findAndRefreshTask list:%s", V);
        if (V == null || V.size() <= 0) {
            return;
        }
        for (com.huawei.openalliance.ad.download.g gVar : V) {
            gVar.Code(str);
        }
    }

    private Set<com.huawei.openalliance.ad.download.g> V(String str) {
        Set<com.huawei.openalliance.ad.download.g> set;
        synchronized (this) {
            set = this.I.get(str);
        }
        return set;
    }

    private void V(Intent intent) {
        String str;
        String str2;
        try {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(d.d);
            int i = -1;
            if (pendingIntent != null) {
                Intent intent2 = new Intent();
                intent2.setClass(this.V, AgProtocolActivity.class);
                intent2.putExtra(d.d, pendingIntent);
                i = intent.getIntExtra(d.e, 6);
                intent2.putExtra(d.e, i);
                String stringExtra = intent.getStringExtra(d.f);
                intent2.putExtra(d.f, stringExtra);
                String stringExtra2 = intent.getStringExtra("ag_action_name");
                intent2.putExtra("ag_action_name", stringExtra2);
                intent2.addFlags(268959744);
                intent2.setClipData(t.cF);
                this.V.startActivity(intent2);
                str = stringExtra;
                str2 = stringExtra2;
            } else {
                str = null;
                str2 = null;
            }
            eh.Code(this.V, i, str, str2, a.Code);
        } catch (Throwable th) {
            ge.V(Code, " requestAgProtocol error");
        }
    }

    private void V(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        for (com.huawei.openalliance.ad.download.g gVar : Code2) {
            gVar.Code(appDownloadTask);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.Z = appDownloadListener;
    }

    public void Code(String str) {
        NotificationManager notificationManager;
        if (TextUtils.isEmpty(str) || (notificationManager = (NotificationManager) this.V.getSystemService("notification")) == null) {
            return;
        }
        notificationManager.cancel(str.hashCode());
    }

    public void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        synchronized (this) {
            Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.I.put(str, hashSet);
            }
            hashSet.add(gVar);
        }
    }

    @Override // com.huawei.openalliance.ad.download.e
    public boolean Code(AppDownloadTask appDownloadTask) {
        return g.I().Z(appDownloadTask);
    }

    public void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        synchronized (this) {
            Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
            if (set != null && set.size() > 0) {
                set.remove(gVar);
                if (set.size() <= 0) {
                    this.I.remove(str);
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onAppInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            appDownloadTask.Code(6);
            Code(k.INSTALLED, appDownloadTask);
            I(appDownloadTask);
            g.I().V((g) appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onAppUnInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            String Code2 = appDownloadTask.L().Code();
            Set<com.huawei.openalliance.ad.download.g> V = V(Code2);
            if (V != null && V.size() > 0) {
                for (com.huawei.openalliance.ad.download.g gVar : V) {
                    gVar.I(Code2);
                }
            }
            Code(k.DOWNLOAD, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadDeleted(AppDownloadTask appDownloadTask) {
        appDownloadTask.I(0);
        appDownloadTask.V(0L);
        appDownloadTask.Code(4);
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadFail(AppDownloadTask appDownloadTask) {
        if (Code(appDownloadTask)) {
            return;
        }
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadPaused(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.PAUSE, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        boolean z = true;
        if (this.Z != null) {
            z = false;
        }
        ge.Code(Code, "onDownloadProgress: %s", Boolean.valueOf(z));
        V(appDownloadTask);
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadResumed(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.RESUME, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.DOWNLOADING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        Code(k.DOWNLOADED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.WAITING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            ge.V(Code, "msgName or msgData is empty!");
            return;
        }
        ge.Code(Code, "onMessageNotify msgName:%s", str);
        this.C.onReceive(this.V, intent);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onSilentInstallFailed(AppDownloadTask appDownloadTask) {
        boolean z = true;
        ge.I(Code, "install apk failed, reason: %s", Integer.valueOf(appDownloadTask.n()));
        if (appDownloadTask.n() != 1) {
            z = false;
        }
        if (z || !Code(appDownloadTask)) {
            I(appDownloadTask);
            Code(appDownloadTask.B() == 4 ? k.DOWNLOAD : k.INSTALL, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onSilentInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onSilentInstallSuccess(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    public void onSystemInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALL, appDownloadTask);
    }
}
