package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/l.class */
public class l {
    private static l B;
    private static final String Code = "GPDownloadManager";
    private static final int V = 900000;
    private Context C;
    private static final byte[] I = new byte[0];
    private static final byte[] Z = new byte[0];
    private Map<String, AppDownloadTask> S = new ConcurrentHashMap();
    private BroadcastReceiver F = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.l.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                ge.I(l.Code, "itRer dataString is empty");
                return;
            }
            String substring = dataString.substring(8);
            try {
                if (Intent.ACTION_PACKAGE_ADDED.equals(intent.getAction())) {
                    l.this.Code(substring);
                }
            } catch (Throwable th) {
                ge.I(l.Code, "itRer: %s", th.getClass().getSimpleName());
            }
        }
    };

    private l(Context context) {
        this.C = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addDataScheme("package");
        this.C.registerReceiver(this.F, intentFilter);
    }

    public static l Code(Context context) {
        l lVar;
        synchronized (I) {
            if (B == null) {
                B = new l(context);
            }
            lVar = B;
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        ge.V(Code, "dealWithAdd");
        synchronized (Z) {
            if (this.S.containsKey(str)) {
                AppDownloadTask appDownloadTask = this.S.get(str);
                this.S.remove(str);
                ge.V(Code, "task size after remove: %s", Integer.valueOf(this.S.size()));
                AdContentData f = appDownloadTask.f();
                if (f != null && f.u() != null) {
                    ko.Code(this.C, f, appDownloadTask.b(), f.u().i());
                }
            }
        }
    }

    public void Code(String str, AppDownloadTask appDownloadTask) {
        synchronized (Z) {
            ge.Code(Code, "task size before: %s", Integer.valueOf(this.S.size()));
            for (Map.Entry entry : new ConcurrentHashMap(this.S).entrySet()) {
                ge.Code(Code, "entry key: %s time: %s", entry.getKey(), Long.valueOf(((AppDownloadTask) entry.getValue()).o()));
                if (System.currentTimeMillis() - ((AppDownloadTask) entry.getValue()).o() > 900000) {
                    this.S.remove(entry.getKey());
                }
            }
            this.S.put(str, appDownloadTask);
            ge.V(Code, "task size after: %s, packageName: %s time: %s", Integer.valueOf(this.S.size()), str, this.S.get(str) != null ? Long.valueOf(this.S.get(str).o()) : null);
        }
    }
}
