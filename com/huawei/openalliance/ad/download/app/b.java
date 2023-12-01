package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/b.class */
public class b {
    private static final String B = "reserveappstatus";
    private static final String C = "com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED";
    private static final String Code = "AgReserveDownloadManager";
    private static final String D = "com.huawei.appmarket.RECV_THIRD_COMMON_MSG";
    private static final int F = 2;
    private static final String I = "com.huawei.appgallery.reserveappstatus";
    private static b L;
    private static final String S = "callerpackage";
    private static final byte[] V = new byte[0];
    private static final String Z = "reserveapp";

    /* renamed from: a  reason: collision with root package name */
    private a f22963a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private com.huawei.openalliance.ad.download.f f22964c;
    private Context d;
    private Map<String, WeakHashMap<com.huawei.openalliance.ad.download.g, Object>> e = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/b$a.class */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ge.V(b.Code, "reserve broadcast.");
            try {
                SafeIntent safeIntent = new SafeIntent(intent);
                String action = safeIntent.getAction();
                if (b.I.equals(action)) {
                    b.this.Code(safeIntent);
                } else {
                    ge.I(b.Code, "inValid para %s.", action);
                }
            } catch (IllegalStateException e) {
                ge.I(b.Code, "reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
            } catch (Exception e2) {
                ge.I(b.Code, "reserve onReceive Exception: %s", e2.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.openalliance.ad.download.app.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/b$b.class */
    public static class C0431b implements RemoteCallResultCallback<String> {
        private C0431b() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            ge.V(b.Code, "reserve app %s.", Integer.valueOf(callResult.getCode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/b$c.class */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ge.V(b.Code, "silent reserve broadcast.");
            b.this.Code(context, intent);
        }
    }

    private b(Context context) {
        String str;
        this.d = context.getApplicationContext();
        try {
            Code();
        } catch (IllegalStateException e) {
            str = "registerReceiver IllegalStateException";
            ge.I(Code, str);
        } catch (Exception e2) {
            str = "registerReceiver Exception";
            ge.I(Code, str);
        }
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (V) {
            if (L == null) {
                L = new b(context);
            }
            bVar = L;
        }
        return bVar;
    }

    private WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code(String str) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap;
        synchronized (this) {
            weakHashMap = this.e.get(str);
        }
        return weakHashMap;
    }

    private void Code() {
        this.f22963a = new a();
        this.d.registerReceiver(this.f22963a, new IntentFilter(I), D, null);
        this.b = new c();
        this.d.registerReceiver(this.b, new IntentFilter(C), "com.huawei.permission.app.DOWNLOAD", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (!C.equals(action) || context == null) {
                ge.I(Code, "reserve onReceive inValid para %s.", action);
                return;
            }
            String stringExtra = safeIntent.getStringExtra(S);
            String packageName = context.getPackageName();
            if (!au.Code(stringExtra, packageName)) {
                ge.V(Code, "caller does not match, caller %s, currentPackage %s.", stringExtra, packageName);
            } else if (safeIntent.getIntExtra(B, -1) == 0) {
                ge.V(Code, "silent reserve failed no need to notify");
            } else {
                Code(safeIntent);
            }
        } catch (IllegalStateException e) {
            ge.I(Code, "silent reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
        } catch (Exception e2) {
            ge.I(Code, "silent reserve onReceive Exception: %s", e2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent) {
        String stringExtra = intent.getStringExtra(Z);
        int intExtra = intent.getIntExtra(B, -1);
        ge.V(Code, "reserve status: %s", Integer.valueOf(intExtra));
        int i = intExtra;
        if (intExtra == 2) {
            i = 1;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            ge.V(Code, "pkg is null");
        } else {
            Code(stringExtra, i);
        }
    }

    private void Code(String str, int i) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code2 = Code(str);
        if (Code2 != null && Code2.size() > 0) {
            for (com.huawei.openalliance.ad.download.g gVar : Code2.keySet()) {
                if (gVar != null) {
                    gVar.Code(str, i);
                }
            }
        }
        com.huawei.openalliance.ad.download.f fVar = this.f22964c;
        if (fVar != null) {
            fVar.Code(str, i);
        }
    }

    public void Code(AppDownloadTask appDownloadTask) {
        com.huawei.openalliance.ad.download.app.c.Z(this.d, appDownloadTask, new C0431b(), String.class);
    }

    public void Code(com.huawei.openalliance.ad.download.f fVar) {
        this.f22964c = fVar;
    }

    public void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        synchronized (this) {
            WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
            WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap2 = weakHashMap;
            if (weakHashMap == null) {
                weakHashMap2 = new WeakHashMap<>();
                this.e.put(str, weakHashMap2);
            }
            weakHashMap2.put(gVar, null);
        }
    }

    public void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        synchronized (this) {
            WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
            if (weakHashMap != null && weakHashMap.size() > 0) {
                weakHashMap.remove(gVar);
                if (weakHashMap.size() <= 0) {
                    this.e.remove(str);
                }
            }
        }
    }
}
