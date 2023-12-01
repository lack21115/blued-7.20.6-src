package com.kwad.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/a/b.class */
public final class b {
    private static final Map<String, String> aaV = new HashMap();
    private final AtomicBoolean aaW;
    private final AtomicBoolean aaX;
    private final BroadcastReceiver aaY;
    private final List<com.kwad.sdk.a.a> mListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/a/b$a.class */
    public static final class a {
        private static final b aba = new b((byte) 0);
    }

    private b() {
        this.aaW = new AtomicBoolean();
        this.aaX = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.aaY = new BroadcastReceiver() { // from class: com.kwad.sdk.a.b.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    if (TextUtils.equals(Intent.ACTION_PACKAGE_ADDED, action)) {
                        b.this.t(context, schemeSpecificPart);
                    } else if (TextUtils.equals(Intent.ACTION_PACKAGE_REMOVED, action)) {
                        b.this.bj(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        };
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private void av(Context context) {
        synchronized (this) {
            if (this.aaW.get()) {
                return;
            }
            v(context, "com.smile.gifmaker");
            v(context, "com.kuaishou.nebula");
            v(context, "com.tencent.mm");
            this.aaW.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(String str) {
        com.kwad.sdk.core.d.b.d("AppInstallManager", "unInstallApp packageName: " + str);
        bn(str);
        bk(str);
        bm(str);
    }

    private static void bk(String str) {
        try {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = str;
            ((com.kwad.sdk.service.kwai.b) ServiceProvider.get(com.kwad.sdk.service.kwai.b.class)).e(InstalledAppInfoManager.a(appPackageInfo), 2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    private void bl(String str) {
        for (com.kwad.sdk.a.a aVar : this.mListeners) {
            try {
                aVar.X(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    private void bm(String str) {
        Iterator<com.kwad.sdk.a.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private static void bn(String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -973170826) {
            if (str.equals("com.tencent.mm")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 473713875) {
            if (hashCode == 1659293491 && str.equals("com.smile.gifmaker")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("com.kuaishou.nebula")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            aaV.put("com.smile.gifmaker", "");
        } else if (z) {
            aaV.put("com.kuaishou.nebula", "");
        } else if (!z) {
        } else {
            aaV.put("com.tencent.mm", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context, String str) {
        com.kwad.sdk.core.d.b.d("AppInstallManager", "installApp packageName: " + str);
        v(context, str);
        u(context, str);
        bl(str);
    }

    public static b tA() {
        return a.aba;
    }

    private static void u(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                ((com.kwad.sdk.service.kwai.b) ServiceProvider.get(com.kwad.sdk.service.kwai.b.class)).e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    private static void v(Context context, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -973170826) {
            if (str.equals("com.tencent.mm")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 473713875) {
            if (hashCode == 1659293491 && str.equals("com.smile.gifmaker")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("com.kuaishou.nebula")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            aaV.put("com.smile.gifmaker", k.F(context, "com.smile.gifmaker"));
        } else if (z) {
            aaV.put("com.kuaishou.nebula", k.F(context, "com.kuaishou.nebula"));
        } else if (!z) {
        } else {
            aaV.put("com.tencent.mm", k.F(context, "com.tencent.mm"));
        }
    }

    public final void a(com.kwad.sdk.a.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.add(aVar);
    }

    public final void b(com.kwad.sdk.a.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(aVar);
    }

    public final void checkInit() {
        synchronized (this) {
            try {
                if (this.aaX.get()) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
                intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
                intentFilter.addDataScheme("package");
                ServiceProvider.CA().registerReceiver(this.aaY, intentFilter);
                this.aaX.set(true);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        av(context);
        return aaV.get(str);
    }
}
