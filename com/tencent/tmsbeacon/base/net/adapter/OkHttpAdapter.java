package com.tencent.tmsbeacon.base.net.adapter;

import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.BodyType;
import com.tencent.tmsbeacon.base.net.b.d;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.net.call.e;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/OkHttpAdapter.class */
public class OkHttpAdapter extends AbstractNetAdapter {
    private OkHttpClient client;
    private int failCount;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/OkHttpAdapter$a.class */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.tmsbeacon.base.net.call.Callback f39494a;
        public final /* synthetic */ String b;

        public a(com.tencent.tmsbeacon.base.net.call.Callback callback, String str) {
            this.f39494a = callback;
            this.b = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/OkHttpAdapter$b.class */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.tmsbeacon.base.net.call.Callback f39496a;
        public final /* synthetic */ String b;

        public b(com.tencent.tmsbeacon.base.net.call.Callback callback, String str) {
            this.f39496a = callback;
            this.b = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/OkHttpAdapter$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39498a;

        static {
            BodyType.values();
            int[] iArr = new int[3];
            f39498a = iArr;
            try {
                BodyType bodyType = BodyType.FORM;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f39498a;
                BodyType bodyType2 = BodyType.JSON;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f39498a;
                BodyType bodyType3 = BodyType.DATA;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private OkHttpAdapter() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.client = builder.connectTimeout(30000L, timeUnit).readTimeout(10000L, timeUnit).build();
    }

    private OkHttpAdapter(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public static /* synthetic */ int access$008(OkHttpAdapter okHttpAdapter) {
        int i = okHttpAdapter.failCount;
        okHttpAdapter.failCount = i + 1;
        return i;
    }

    private RequestBody buildBody(e eVar) {
        BodyType a2 = eVar.a();
        int i = c.f39498a[a2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return RequestBody.create(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA), eVar.c());
            }
            return RequestBody.create(MediaType.parse(a2.httpType), eVar.f());
        }
        return RequestBody.create(MediaType.parse(a2.httpType), d.b(eVar.d()));
    }

    public static AbstractNetAdapter create(OkHttpClient okHttpClient) {
        return okHttpClient != null ? new OkHttpAdapter(okHttpClient) : new OkHttpAdapter();
    }

    private Headers mapToHeaders(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, com.tencent.tmsbeacon.base.net.call.Callback<byte[]> callback) {
        RequestBody create = RequestBody.create(MediaType.parse("jce"), jceRequestEntity.getContent());
        Headers mapToHeaders = mapToHeaders(jceRequestEntity.getHeader());
        String name = jceRequestEntity.getType().name();
        this.client.newCall(new Request.Builder().url(jceRequestEntity.getUrl()).tag(name).post(create).headers(mapToHeaders).build()).enqueue(new a(callback, name));
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(e eVar, com.tencent.tmsbeacon.base.net.call.Callback<BResponse> callback) {
        String h = eVar.h();
        this.client.newCall(new Request.Builder().url(eVar.i()).method(eVar.g().name(), buildBody(eVar)).headers(mapToHeaders(eVar.e())).tag(h == null ? "beacon" : h).build()).enqueue(new b(callback, h));
    }
}
