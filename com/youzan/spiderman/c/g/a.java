package com.youzan.spiderman.c.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.youzan.spiderman.c.b.g;
import com.youzan.spiderman.c.d.c;
import com.youzan.spiderman.cache.CacheUrl;
import com.youzan.spiderman.utils.DeviceUuidFactory;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.NetWorkUtil;
import com.youzan.spiderman.utils.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/g/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f41776a;
    private com.youzan.spiderman.c.f.b b = com.youzan.spiderman.c.f.b.a();

    private a() {
    }

    public static a a() {
        if (f41776a == null) {
            f41776a = new a();
        }
        return f41776a;
    }

    static /* synthetic */ List a(a aVar, List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Uri.Builder builder = new Uri.Builder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CacheUrl cacheUrl = (CacheUrl) it.next();
                if (cacheUrl != null && cacheUrl.isImg()) {
                    Uri uri = cacheUrl.getUri();
                    arrayList.add(builder.path(uri.getPath()).encodedQuery(uri.getQuery()).fragment(uri.getFragment()).build().toString());
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void a(a aVar, final Context context, final String str, final String str2, final String str3, final List list) {
        if (!NetWorkUtil.hasNetworkPermission(context)) {
            Logger.e("UploadManager", "has no network permission to request upload", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.youzan.spiderman.c.b.a());
        hashMap.put("access_token", str);
        hashMap.put("biz_tag", str2);
        hashMap.put("uuid_string", str3);
        hashMap.put("resource_path", StringUtils.join(list));
        new OkHttpClient().newCall(new Request.Builder().url("https://carmen.youzan.com/api/oauthentry/youzan.goldwing.upload/1.0.0/resource").post(com.youzan.spiderman.cache.b.a(hashMap)).build()).enqueue(new Callback() { // from class: com.youzan.spiderman.c.g.a.2

            /* renamed from: com.youzan.spiderman.c.g.a$2$1  reason: invalid class name */
            /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/g/a$2$1.class */
            final class AnonymousClass1 implements com.youzan.spiderman.c.f.a {
                AnonymousClass1() {
                }

                @Override // com.youzan.spiderman.c.f.a
                public final void a(String str) {
                    if (StringUtils.isEmpty(str)) {
                        return;
                    }
                    a.a(a.this, context, str, str2, str3, list);
                }
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                Logger.e("UploadManager", "upload request fail: " + iOException, new Object[0]);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Logger.i("UploadManager", "upload request is not successful", new Object[0]);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    return;
                }
                c cVar = null;
                try {
                    cVar = (c) JsonUtil.fromJson(body.string(), (Class<Object>) c.class);
                } catch (Exception e) {
                    Logger.e("UploadManager", "parse upload response exception: ", e);
                    e.printStackTrace();
                }
                if (cVar == null) {
                    return;
                }
                Logger.e("UploadManager", "upload response is false", new Object[0]);
            }
        });
    }

    public final void a(final Context context, b bVar) {
        final String a2 = com.youzan.spiderman.c.a.a();
        if (TextUtils.isEmpty(a2)) {
            Logger.i("UploadManager", "upload bizTag should not be null", new Object[0]);
            return;
        }
        g d = com.youzan.spiderman.c.a.a.a().d();
        if (!d.a()) {
            Logger.i("UploadManager", "upload api unable", new Object[0]);
            return;
        }
        com.youzan.spiderman.c.b.a e = com.youzan.spiderman.c.a.a.a().e();
        long currentTimeMillis = System.currentTimeMillis();
        if (!(e.a() <= currentTimeMillis && currentTimeMillis - e.a() <= e.b())) {
            Logger.e("UploadManager", "certificate has expired", new Object[0]);
        } else if (!com.youzan.spiderman.cache.b.a(d, bVar)) {
            Logger.i("UploadManager", "this url don't allow upload, url:", new Object[0]);
        } else {
            Logger.i("UploadManager", "this url match success", new Object[0]);
            final String deviceUuid = new DeviceUuidFactory(context).getDeviceUuid();
            final List<CacheUrl> b = bVar.b();
            if (b == null || b.isEmpty()) {
                return;
            }
            this.b.a(new com.youzan.spiderman.c.f.a() { // from class: com.youzan.spiderman.c.g.a.1
                @Override // com.youzan.spiderman.c.f.a
                public final void a(String str) {
                    if (StringUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        List a3 = a.a(a.this, b);
                        if (a3.isEmpty()) {
                            return;
                        }
                        a.a(a.this, context, str, a2, deviceUuid, a3);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
