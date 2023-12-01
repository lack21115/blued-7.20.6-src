package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/OkHttpAdapter.class */
public class OkHttpAdapter extends AbstractNetAdapter {
    private OkHttpClient client;
    private int failCount;

    private OkHttpAdapter() {
        this.client = new OkHttpClient.Builder().connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).build();
    }

    private OkHttpAdapter(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    static /* synthetic */ int access$008(OkHttpAdapter okHttpAdapter) {
        int i = okHttpAdapter.failCount;
        okHttpAdapter.failCount = i + 1;
        return i;
    }

    private RequestBody buildBody(com.tencent.beacon.base.net.call.e eVar) {
        BodyType a2 = eVar.a();
        int i = e.f34968a[a2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return RequestBody.create(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA), eVar.c());
            }
            return RequestBody.create(MediaType.parse(a2.httpType), eVar.f());
        }
        return RequestBody.create(MediaType.parse(a2.httpType), com.tencent.beacon.base.net.b.d.b(eVar.d()));
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

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        RequestBody create = RequestBody.create(MediaType.parse("jce"), jceRequestEntity.getContent());
        Headers mapToHeaders = mapToHeaders(jceRequestEntity.getHeader());
        String name = jceRequestEntity.getType().name();
        this.client.newCall(new Request.Builder().url(jceRequestEntity.getUrl()).tag(name).post(create).headers(mapToHeaders).build()).enqueue(new c(this, callback, name));
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
        String h = eVar.h();
        this.client.newCall(new Request.Builder().url(eVar.i()).method(eVar.g().name(), buildBody(eVar)).headers(mapToHeaders(eVar.e())).tag(h == null ? "beacon" : h).build()).enqueue(new d(this, callback, h));
    }
}
