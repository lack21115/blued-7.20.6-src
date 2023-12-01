package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f.class */
public class f {
    private static Handler Uk;
    private static ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!f.access$000()) {
                    com.kwad.sdk.core.d.b.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = f.ayT;
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            } catch (SecurityException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.service.b.gatherException(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private static Messenger ayT;
    private static volatile ExecutorService ayU;
    private static volatile AppStatusRules ayV;
    private static WeakReference<Context> ayW;
    private static com.kwad.sdk.collector.h ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.f$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f$2.class */
    public static final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context jN;

        AnonymousClass2(Context context) {
            this.jN = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.jN, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.jN);
                    AppStatusRules unused = f.ayV = appStatusRules;
                    f.b(AnonymousClass2.this.jN, f.ayV);
                    f.by(AnonymousClass2.this.jN);
                    boolean dc = bd.dc(AnonymousClass2.this.jN);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.ayV);
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dc);
                    if (dc && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.ayV.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            f.e(AnonymousClass2.this.jN, obtainDefaultScanInterval);
                        } else {
                            f.bA(AnonymousClass2.this.jN);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.ayV);
                    boolean z = f.ayV.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && dc) {
                        f.CF();
                        f.ayU.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.jN, f.ayV);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.b.gatherException(th);
                                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void h(int i, String str) {
                    com.kwad.sdk.core.d.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> azd = new ArrayList();
        private String packageName;

        public a() {
        }

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        private static List<a> A(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list == null || list.size() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            try {
                for (com.kwad.sdk.collector.model.b bVar : list) {
                    String b = com.kwad.sdk.collector.model.c.b(bVar);
                    if (hashMap.containsKey(b)) {
                        aVar = (a) hashMap.get(b);
                    } else {
                        aVar = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                        hashMap.put(b, aVar);
                    }
                    long c2 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                    if (aVar != null) {
                        aVar.af(c2);
                    }
                }
                return new ArrayList(hashMap.values());
            } catch (ClassCastException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                return null;
            }
        }

        private void af(long j) {
            this.azd.add(Long.valueOf(j));
        }

        public static JSONArray z(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = A(list);
            } catch (Exception e) {
                com.kwad.sdk.service.b.gatherException(e);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : list2) {
                jSONArray.put(aVar.toJson());
            }
            return jSONArray;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray == null) {
                return;
            }
            this.azd.clear();
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                try {
                    this.azd.add(Long.valueOf(optJSONArray.getLong(i2)));
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
                i = i2 + 1;
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "appName", this.appName);
            t.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.azd) {
                jSONArray.put(l.longValue());
            }
            t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f$b.class */
    public interface b {
        void l(List<com.kwad.sdk.collector.model.b> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f$c.class */
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        private static void B(List<a> list) {
            if (list == null) {
                return;
            }
            f.ayX.c(t.C(list));
        }

        private static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray z;
            if (arrayList == null || (z = a.z(arrayList)) == null) {
                return;
            }
            f.ayX.c(z);
        }

        private void b(Message message) {
            ArrayList arrayList;
            List list;
            Collection<AppStatusRules.Strategy> collection;
            Bundle data = message.getData();
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            private static a CO() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a tU() {
                                return CO();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable th) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
                if (list != null) {
                    B(list);
                }
            }
            if (f.ayW != null && f.ayW.get() != 0 && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    collection = null;
                    if (string != null) {
                        collection = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            private static AppStatusRules.Strategy CP() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy tU() {
                                return CP();
                            }
                        });
                    }
                } else {
                    collection = (ArrayList) data.getSerializable("allStrategy");
                }
                if (collection != null) {
                    for (AppStatusRules.Strategy strategy : collection) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.ayW.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.ayW == null || f.ahE == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.a.a.b((Context) f.ayW.get(), f.ahE);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                b(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/f$d.class */
    public static final class d implements b {
        private b azf = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void l(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray z = a.z(list);
            if (z != null) {
                f.ayX.c(z);
            }
            b bVar = this.azf;
            if (bVar != null) {
                bVar.l(list);
            }
        }
    }

    public static AppStatusRules CD() {
        return ayV;
    }

    private static boolean CE() {
        if (ayT == null) {
            try {
                ayT = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable th) {
            }
        }
        return ayT != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void CF() {
        if (ayU == null) {
            synchronized (f.class) {
                try {
                    if (ayU == null) {
                        ExecutorService xT = GlobalThreadPools.xT();
                        ayU = xT;
                        com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) xT, "appStatusHelper");
                    }
                } finally {
                }
            }
        }
    }

    private static boolean CG() {
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = ServiceProvider.getContext();
                if (context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0) {
                    z = true;
                }
                return z;
            }
            return false;
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return false;
        }
    }

    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.tD().a(strategy);
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (at.Ef() || com.kwad.sdk.core.config.d.E(8192L) || context == null || com.kwad.sdk.utils.c.bw(context)) {
            return;
        }
        ayX = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            ayW = new WeakReference<>(context);
            if (Uk == null) {
                Uk = new Handler(Looper.getMainLooper());
            }
            Uk.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || at.Ef() || com.kwad.sdk.core.config.d.E(8192L) || com.kwad.sdk.utils.c.bw(context)) {
            return;
        }
        CF();
        ayU.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List<com.kwad.sdk.collector.model.b> bB;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bd.dc(Context.this) || (bB = f.bB(Context.this)) == null) {
                        return;
                    }
                    for (com.kwad.sdk.collector.model.b bVar2 : bB) {
                        com.kwad.sdk.core.d.b.d("AppStatusHelper", "AppRunningInfo: " + bVar2);
                    }
                    hashSet.addAll(bB);
                    if (bVar != null) {
                        bVar.l(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    com.kwad.sdk.service.b.gatherException(th);
                }
            }
        });
    }

    static /* synthetic */ boolean access$000() {
        return CE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.g(file.getAbsolutePath(), com.kwad.sdk.core.kwai.c.bW(jSONObject), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bA(Context context) {
        if (context == null) {
            return;
        }
        boolean CG = CG();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isServiceAvailable: " + CG);
        if (CG) {
            com.kwad.sdk.collector.a.a.a(context, ahE);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.kwad.sdk.collector.model.b> bB(Context context) {
        if (bd.dc(context)) {
            if (ayV == null) {
                ayV = bz(context);
            }
            return bC(context);
        }
        return new ArrayList();
    }

    private static List<com.kwad.sdk.collector.model.b> bC(Context context) {
        ArrayList arrayList = new ArrayList();
        if (!at.Ef() && !com.kwad.sdk.core.config.d.E(8192L) && !com.kwad.sdk.utils.c.bw(context)) {
            AppStatusRules CD = CD();
            for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(CD)) {
                arrayList.addAll(a(strategy));
                strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
            }
            AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(CD);
            arrayList.addAll(a(d2));
            d2.setNeedSaveLaunchTime(System.currentTimeMillis());
            return y(arrayList);
        }
        return arrayList;
    }

    public static void by(Context context) {
        if (ayV == null) {
            ayV = bz(context);
        }
    }

    private static AppStatusRules bz(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (file.exists()) {
            try {
                String D = com.kwad.sdk.crash.utils.h.D(file);
                if (TextUtils.isEmpty(D)) {
                    return null;
                }
                String str = D;
                if (com.kwad.sdk.core.kwai.c.bY(D)) {
                    str = com.kwad.sdk.core.kwai.c.bX(D);
                }
                JSONObject jSONObject = new JSONObject(str);
                AppStatusRules appStatusRules = new AppStatusRules();
                appStatusRules.parseJson(jSONObject);
                return appStatusRules;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public static void e(final Context context, final long j) {
        if (Uk == null) {
            Uk = new Handler(Looper.getMainLooper());
        }
        Uk.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.bA(Context.this);
                f.Uk.postDelayed(this, j);
            }
        });
    }

    private static List<com.kwad.sdk.collector.model.b> y(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }
}
