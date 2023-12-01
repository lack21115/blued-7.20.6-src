package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/HttpDataFetcher.class */
public class HttpDataFetcher implements DataFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private GlideUrl f9554a;
    private DataFetcher.DataCallback<? super InputStream> b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f9555c;
    private HttpRequestWrapper d;
    private InputStreamHttpResponseHandler e;

    public HttpDataFetcher(GlideUrl glideUrl) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher :" + glideUrl);
        }
        this.f9554a = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher cleanup");
        }
        try {
            if (this.f9555c != null) {
                this.f9555c.close();
                this.f9555c = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamHttpResponseHandler inputStreamHttpResponseHandler = this.e;
        if (inputStreamHttpResponseHandler != null) {
            inputStreamHttpResponseHandler.a();
            this.e = null;
        }
        this.b = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher loadData " + Thread.currentThread().getName());
        }
        this.b = dataCallback;
        this.e = new InputStreamHttpResponseHandler() { // from class: com.blued.android.core.image.http.HttpDataFetcher.1
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(InputStream inputStream) {
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "-- HttpDataFetcher loadData ++ onSuccess " + Thread.currentThread().getName());
                }
                long b = getResponseLength(inputStream);
                HttpDataFetcher.this.f9555c = ContentLengthInputStream.a(inputStream, b);
                if (HttpDataFetcher.this.b != null) {
                    HttpDataFetcher.this.b.a((DataFetcher.DataCallback) HttpDataFetcher.this.f9555c);
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i, InputStream inputStream) {
                if (ImageLoader.a()) {
                    Log.e("IMAGE", "-- HttpDataFetcher loadData ++ onFailure " + Thread.currentThread().getName());
                }
                super.onFailure(th, i, inputStream);
                if (HttpDataFetcher.this.b != null) {
                    HttpDataFetcher.this.b.a(new Exception(th));
                }
            }
        };
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f9554a.c().entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        hashMap.put(HttpHeaders.ACCEPT, "image/webp, */*");
        this.d = HttpManager.a(this.f9554a.b(), this.e).b(hashMap).f().h();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher cancel");
        }
        HttpRequestWrapper httpRequestWrapper = this.d;
        if (httpRequestWrapper != null) {
            httpRequestWrapper.i();
            this.d = null;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.REMOTE;
    }
}
