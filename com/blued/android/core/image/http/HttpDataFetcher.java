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
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/HttpDataFetcher.class */
public class HttpDataFetcher implements DataFetcher<InputStream> {
    private GlideUrl a;
    private DataFetcher.DataCallback<? super InputStream> b;
    private InputStream c;
    private HttpRequestWrapper d;
    private InputStreamHttpResponseHandler e;

    public HttpDataFetcher(GlideUrl glideUrl) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher :" + glideUrl);
        }
        this.a = glideUrl;
    }

    public void a() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "-- HttpDataFetcher cleanup");
        }
        try {
            if (this.c != null) {
                this.c.close();
                this.c = null;
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
                HttpDataFetcher.this.c = ContentLengthInputStream.a(inputStream, b);
                if (HttpDataFetcher.this.b != null) {
                    HttpDataFetcher.this.b.a(HttpDataFetcher.this.c);
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
        for (Map.Entry entry : this.a.c().entrySet()) {
            hashMap.put((String) entry.getKey(), (String) entry.getValue());
        }
        hashMap.put("Accept", "image/webp, */*");
        this.d = HttpManager.a(this.a.b(), this.e).b(hashMap).f().h();
    }

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

    public Class<InputStream> c() {
        return InputStream.class;
    }

    public DataSource d() {
        return DataSource.b;
    }
}
