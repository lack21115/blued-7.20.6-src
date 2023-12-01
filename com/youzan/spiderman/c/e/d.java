package com.youzan.spiderman.c.e;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonParseException;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.NetWorkUtil;
import com.youzan.spiderman.utils.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f41763a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f41764c;
    private int d;
    private boolean e;
    private List<String> f;
    private com.youzan.spiderman.c.f.b g = com.youzan.spiderman.c.f.b.a();

    private d() {
    }

    public static d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f41763a == null) {
                    f41763a = new d();
                }
                dVar = f41763a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final String str, final String str2, final long j, final com.youzan.spiderman.c.b.f fVar, final e eVar, final f fVar2) {
        if (!NetWorkUtil.hasNetworkPermission(context)) {
            Logger.e("SyncManager", "has no network permission to request sync", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.youzan.spiderman.c.b.a());
        hashMap.put("start", String.valueOf(this.f41764c));
        hashMap.put("offset", String.valueOf(this.d));
        hashMap.put("query_condition", StringUtils.join(this.f));
        hashMap.put("last_update_time", j > 0 ? String.valueOf(j) : "0");
        hashMap.put("biz_tag", str);
        hashMap.put("access_token", str2);
        this.e = false;
        new OkHttpClient().newCall(new Request.Builder().url(com.youzan.spiderman.cache.b.a("https://carmen.youzan.com/api/oauthentry/youzan.goldwing.modify.resource/1.0.0/get", hashMap)).build()).enqueue(new Callback() { // from class: com.youzan.spiderman.c.e.d.2

            /* renamed from: com.youzan.spiderman.c.e.d$2$1  reason: invalid class name */
            /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/d$2$1.class */
            final class AnonymousClass1 implements com.youzan.spiderman.c.f.a {
                AnonymousClass1() {
                }

                @Override // com.youzan.spiderman.c.f.a
                public final void a(String str) {
                    if (StringUtils.isEmpty(str)) {
                        return;
                    }
                    d.a(d.this, context, str, str, j, fVar, eVar, fVar2);
                }
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                Logger.e("SyncManager", "sync modify resource failed", iOException);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Logger.e("SyncManager", "sync modify resource not successful", Integer.valueOf(response.code()), response.message());
                    onFailure(call, new IOException());
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    onFailure(call, new IOException("download file content is null"));
                    return;
                }
                com.youzan.spiderman.c.d.b bVar = null;
                try {
                    bVar = (com.youzan.spiderman.c.d.b) JsonUtil.fromJson(body.string(), (Class<Object>) com.youzan.spiderman.c.d.b.class);
                } catch (JsonParseException e) {
                    Logger.e("SyncManager", "parse sync modify response exception", e);
                }
                if (bVar == null) {
                    onFailure(call, new IOException());
                    return;
                }
                Logger.i("SyncManager", "sync modify get null modified resource", new Object[0]);
                onFailure(call, new IOException());
            }
        });
    }

    static /* synthetic */ void a(d dVar, Context context, String str, String str2, long j, com.youzan.spiderman.c.b.f fVar, e eVar, f fVar2) {
        dVar.b = System.currentTimeMillis();
        dVar.f41764c = 0;
        dVar.d = 50;
        dVar.f = new ArrayList();
        dVar.a(context, str, str2, j, fVar, eVar, fVar2);
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.e = true;
        return true;
    }

    public final void a(final Context context) {
        final String a2 = com.youzan.spiderman.c.a.a();
        if (TextUtils.isEmpty(a2)) {
            Logger.e("SyncManager", "syncModifyResource bizTag should not be null", new Object[0]);
            return;
        }
        final com.youzan.spiderman.c.b.f c2 = com.youzan.spiderman.c.a.a.a().c();
        final f fVar = new f();
        fVar.a(context, c2);
        if (com.youzan.spiderman.c.a.a.a().b()) {
            Set<String> a3 = ((b) com.youzan.spiderman.cache.b.a((Class<Object>) b.class, "resource_list_pref")).a();
            HashSet hashSet = a3;
            if (a3 == null) {
                hashSet = new HashSet();
            }
            fVar.a(hashSet);
            final e eVar = (e) com.youzan.spiderman.cache.b.a((Class<Object>) e.class, "sync_pref");
            final long a4 = eVar.a();
            long b = eVar.b();
            long a5 = c2.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b >= a5 || currentTimeMillis <= b) {
                this.g.a(new com.youzan.spiderman.c.f.a() { // from class: com.youzan.spiderman.c.e.d.1
                    @Override // com.youzan.spiderman.c.f.a
                    public final void a(String str) {
                        if (StringUtils.isEmpty(str)) {
                            return;
                        }
                        d.a(d.this, context, a2, str, a4, c2, eVar, fVar);
                    }
                });
            } else {
                Logger.i("SyncManager", "in sync interval, return", new Object[0]);
            }
        }
    }
}
