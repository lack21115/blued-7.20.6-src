package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/HttpUrlFetcher.class */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    static final HttpUrlConnectionFactory f7113a = new DefaultHttpUrlConnectionFactory();
    private final GlideUrl b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7114c;
    private final HttpUrlConnectionFactory d;
    private HttpURLConnection e;
    private InputStream f;
    private volatile boolean g;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/HttpUrlFetcher$DefaultHttpUrlConnectionFactory.class */
    static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/HttpUrlFetcher$HttpUrlConnectionFactory.class */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, f7113a);
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.b = glideUrl;
        this.f7114c = i;
        this.d = httpUrlConnectionFactory;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f = ContentLengthInputStream.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f = httpURLConnection.getInputStream();
        }
        return this.f;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException e) {
                }
            }
            this.e = this.d.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.e.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.e.setConnectTimeout(this.f7114c);
            this.e.setReadTimeout(this.f7114c);
            this.e.setUseCaches(false);
            this.e.setDoInput(true);
            this.e.setInstanceFollowRedirects(false);
            this.e.connect();
            this.f = this.e.getInputStream();
            if (this.g) {
                return null;
            }
            int responseCode = this.e.getResponseCode();
            if (a(responseCode)) {
                return a(this.e);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.e.getResponseMessage(), responseCode);
            }
            String headerField = this.e.getHeaderField(HttpHeaders.LOCATION);
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url");
            }
            URL url3 = new URL(url, headerField);
            a();
            return a(url3, i + 1, url, map);
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a() {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.e = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void a(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long a2 = LogTime.a();
        try {
            try {
                dataCallback.a((DataFetcher.DataCallback<? super InputStream>) a(this.b.a(), 0, null, this.b.c()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dataCallback.a((Exception) e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.a(a2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(a2));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        this.g = true;
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
