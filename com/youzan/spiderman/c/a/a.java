package com.youzan.spiderman.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.youzan.spiderman.c.b.d;
import com.youzan.spiderman.c.b.f;
import com.youzan.spiderman.c.b.g;
import com.youzan.spiderman.utils.DeviceUuidFactory;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.NetWorkUtil;
import com.youzan.spiderman.utils.StringUtils;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f41734a;
    private com.youzan.spiderman.c.f.b b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41735c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.youzan.spiderman.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/a/a$a.class */
    public static final class C1097a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f41740a = new a((byte) 0);
    }

    private a() {
        h();
        this.f41735c = h().a().b().a().b();
        this.b = com.youzan.spiderman.c.f.b.a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C1097a.f41740a;
    }

    static /* synthetic */ void a(a aVar, final Context context, final String str, final String str2) {
        if (!NetWorkUtil.hasNetworkPermission(context)) {
            Logger.e("ConfigManager", "has no network permission to request config", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("biz_tag", str2);
        hashMap.putAll(com.youzan.spiderman.c.b.a());
        hashMap.put("uuid_string", new DeviceUuidFactory(context).getDeviceUuid());
        hashMap.put("access_token", str);
        new OkHttpClient().newCall(new Request.Builder().url("https://carmen.youzan.com/api/oauthentry/youzan.goldwing.get.certificate/1.0.0/config").post(com.youzan.spiderman.cache.b.a(hashMap)).build()).enqueue(new Callback() { // from class: com.youzan.spiderman.c.a.a.2

            /* renamed from: com.youzan.spiderman.c.a.a$2$1  reason: invalid class name */
            /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/a/a$2$1.class */
            final class AnonymousClass1 implements com.youzan.spiderman.c.f.a {
                AnonymousClass1() {
                }

                @Override // com.youzan.spiderman.c.f.a
                public final void a(String str) {
                    if (StringUtils.isEmpty(str)) {
                        return;
                    }
                    a.a(a.this, context, str, str2);
                }
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                Logger.e("ConfigManager", "config request fail", new Object[0]);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Logger.e("ConfigManager", "config request fail", new Object[0]);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    return;
                }
                com.youzan.spiderman.c.d.a aVar2 = null;
                try {
                    aVar2 = (com.youzan.spiderman.c.d.a) JsonUtil.fromJson(body.string(), (Class<Object>) com.youzan.spiderman.c.d.a.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.e("ConfigManager", "json parse error: " + e.getMessage(), new Object[0]);
                }
                if (aVar2 == null) {
                }
            }
        });
    }

    private static b h() {
        if (f41734a == null) {
            b bVar = (b) com.youzan.spiderman.cache.b.a((Class<Object>) b.class, "config_pref");
            f41734a = bVar;
            if (bVar == null) {
                f41734a = new b();
            }
        }
        return f41734a;
    }

    public final void a(final Context context) {
        this.b.a(new com.youzan.spiderman.c.f.a() { // from class: com.youzan.spiderman.c.a.a.1
            @Override // com.youzan.spiderman.c.f.a
            public final void a(String str) {
                String a2 = com.youzan.spiderman.c.a.a();
                if (TextUtils.isEmpty(a2)) {
                    Logger.e("ConfigManager", "request config, bizTag should not be null", new Object[0]);
                } else {
                    a.a(a.this, context, str, a2);
                }
            }
        });
    }

    public final boolean b() {
        return this.f41735c;
    }

    public final f c() {
        h();
        return f41734a.a().b().b();
    }

    public final g d() {
        h();
        return f41734a.a().b().c();
    }

    public final com.youzan.spiderman.c.b.a e() {
        h();
        return f41734a.a().a();
    }

    public final d f() {
        h();
        return f41734a.a().b().d();
    }
}
