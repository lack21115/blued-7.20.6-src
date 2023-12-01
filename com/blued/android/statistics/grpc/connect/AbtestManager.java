package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.biz.Abtest;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.AbtestStorageUtils;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.android.statistics.util.Utils;
import com.blued.das.client.ClientProtos;
import com.blued.das.client.abtest.AbClientProtos;
import com.blued.das.client.abtest.AbClientServiceGrpc;
import com.blued.das.client.abtest.AbTestProtos;
import com.google.protobuf.Any;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/AbtestManager.class */
public class AbtestManager {

    /* renamed from: a  reason: collision with root package name */
    private volatile ConcurrentHashMap<String, AbClientProtos.AbResult> f18705a;
    private volatile ConcurrentHashMap<String, AbClientProtos.AbResult> b;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f18706c;
    private volatile String d;
    private final Runnable e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/AbtestManager$AbtestSyncRunnable.class */
    class AbtestSyncRunnable extends NamedRunnable {
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18709c;

        public AbtestSyncRunnable(String str, String str2) {
            super(StatConfig.a("abtest"));
            this.f18709c = str;
            this.b = str2;
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            AbClientProtos.Response response;
            AbClientProtos.Request build = AbClientProtos.Request.newBuilder().setDecisionId(this.b).setToken(this.f18709c).setCommon(BluedStatistics.a().b()).build();
            if (StatConfig.o()) {
                StatConfig.b().b("ABTEST start-request \n", build);
            }
            AbClientServiceGrpc.AbClientServiceBlockingStub abClientServiceBlockingStub = (AbClientServiceGrpc.AbClientServiceBlockingStub) ((AbClientServiceGrpc.AbClientServiceBlockingStub) ((AbClientServiceGrpc.AbClientServiceBlockingStub) ConnectManager.a(AbClientServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
            AbClientProtos.Response response2 = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                AbClientProtos.Response abResult = abClientServiceBlockingStub.getAbResult(build);
                response = abResult;
                if (abResult != null) {
                    int code = abResult.getCode();
                    abResult.getMessage();
                    response = abResult;
                    if (code == 200) {
                        response = abResult;
                        if (AbtestManager.this.d.equals(this.b)) {
                            response2 = abResult;
                            AbtestManager.this.a(this.b, abResult.getResultsMap());
                            response = abResult;
                        }
                    }
                }
            } catch (Exception e) {
                response = response2;
                if (StatConfig.o()) {
                    e.printStackTrace();
                    response = response2;
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (StatConfig.o()) {
                StatConfig.b().b("ABTEST ", Long.valueOf(uptimeMillis2 - uptimeMillis), ", ", response);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/connect/AbtestManager$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final AbtestManager f18710a = new AbtestManager();

        private InstanceHolder() {
        }
    }

    private AbtestManager() {
        this.f18705a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.e = new Runnable() { // from class: com.blued.android.statistics.grpc.connect.AbtestManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (StatConfig.n()) {
                    AbtestManager abtestManager = AbtestManager.this;
                    StatThreadManager.a(new AbtestSyncRunnable(abtestManager.f18706c, AbtestManager.this.d));
                }
                Utils.a(this, 60000L);
            }
        };
    }

    public static AbtestManager a() {
        return InstanceHolder.f18710a;
    }

    private AbClientProtos.AbResult a(AbClientProtos.AbResult abResult, AbClientProtos.AbResult abResult2) {
        return AbClientProtos.AbResult.newBuilder().setGid(abResult.getGid()).setParamType(abResult.getParamType()).setParamValue(abResult.getParamValue()).setIsFreeze(abResult.getIsFreeze()).setIsGroupFreeze(abResult2.getIsGroupFreeze()).setIsTrack(abResult2.getIsTrack()).build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (r0.getIsGroupFreeze() != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.statistics.grpc.connect.AbtestManager.a(java.lang.String, int):java.lang.String");
    }

    private void a(long j) {
        if (j > 0) {
            ClientManager.a().a((ClientManager) ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtra(Any.pack(AbTestProtos.AbTestProto.newBuilder().setEvent(AbTestProtos.Event.ABTEST_EXPOSURE).setGid(j).build())).setUidStr(Utils.b(this.d)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Abtest.OnLocalLoadedListener onLocalLoadedListener) {
        this.b = AbtestStorageUtils.a(this.d);
        Utils.a(new Runnable() { // from class: com.blued.android.statistics.grpc.connect.-$$Lambda$AbtestManager$-OCkipmfK5PI0YUTtF9AbStZ6EQ
            @Override // java.lang.Runnable
            public final void run() {
                AbtestManager.this.b(onLocalLoadedListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, AbClientProtos.AbResult> map) {
        this.f18705a = new ConcurrentHashMap<>(map);
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (Map.Entry<String, AbClientProtos.AbResult> entry : this.f18705a.entrySet()) {
            String key = entry.getKey();
            AbClientProtos.AbResult value = entry.getValue();
            if (StatConfig.o()) {
                StatConfig.b().a("ABTEST ", key, " -> ", value.getParamValue());
            }
            AbClientProtos.AbResult abResult = this.b.get(key);
            if (value.getIsFreeze()) {
                if (abResult != null) {
                    hashSet.add(key);
                }
            } else if (value.getIsGroupFreeze()) {
                if (abResult == null) {
                    this.b.put(key, value);
                } else {
                    if (abResult.getIsTrack() != value.getIsTrack() || abResult.getIsGroupFreeze() != value.getIsGroupFreeze()) {
                        this.b.put(key, a(abResult, value));
                    }
                    hashSet.add(key);
                }
                z = true;
                hashSet.add(key);
            }
        }
        HashSet hashSet2 = new HashSet(this.b.keySet());
        hashSet2.removeAll(hashSet);
        if (hashSet2.size() > 0) {
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                this.b.remove((String) it.next());
            }
            z = true;
        }
        if (z) {
            AbtestStorageUtils.a(str, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Abtest.OnLocalLoadedListener onLocalLoadedListener) {
        if (onLocalLoadedListener != null) {
            onLocalLoadedListener.a();
        }
        Utils.b(this.e);
        Utils.a(this.e);
    }

    public String a(String str, String str2) {
        String a2 = a(str, 1);
        return TextUtils.isEmpty(a2) ? str2 : a2;
    }

    public void a(String str, String str2, final Abtest.OnLocalLoadedListener onLocalLoadedListener) {
        if (!StatConfig.n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f18706c = str;
        this.d = str2;
        this.f18705a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        StatThreadManager.a(new Runnable() { // from class: com.blued.android.statistics.grpc.connect.-$$Lambda$AbtestManager$2LIaAc6t48mKHhBVDZ45j0UfdZg
            @Override // java.lang.Runnable
            public final void run() {
                AbtestManager.this.a(onLocalLoadedListener);
            }
        });
    }
}
