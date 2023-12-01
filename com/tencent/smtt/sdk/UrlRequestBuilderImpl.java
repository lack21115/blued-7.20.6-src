package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/UrlRequestBuilderImpl.class */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38794a = UrlRequestBuilderImpl.class.getSimpleName();
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final UrlRequest.Callback f38795c;
    private final Executor d;
    private String e;
    private boolean g;
    private String i;
    private byte[] j;
    private String k;
    private String l;
    private final ArrayList<Pair<String, String>> f = new ArrayList<>();
    private int h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        this.b = str;
        this.f38795c = callback;
        this.d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                if ("Accept-Encoding".equalsIgnoreCase(str)) {
                    return this;
                }
                this.f.add(Pair.create(str, str2));
                return this;
            }
            throw new NullPointerException("Invalid header value.");
        }
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return null;
        }
        DexLoader b = a2.c().b();
        Class<Integer> cls = Integer.TYPE;
        Class<Boolean> cls2 = Boolean.TYPE;
        String str = this.b;
        int i = this.h;
        UrlRequest urlRequest = (UrlRequest) b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, str, Integer.valueOf(i), this.f38795c, this.d, Boolean.valueOf(this.g), this.e, this.f, this.i, this.j, this.k, this.l);
        UrlRequest urlRequest2 = urlRequest;
        if (urlRequest == null) {
            Class<Integer> cls3 = Integer.TYPE;
            Class<Boolean> cls4 = Boolean.TYPE;
            String str2 = this.b;
            int i2 = this.h;
            urlRequest2 = (UrlRequest) b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls3, UrlRequest.Callback.class, Executor.class, cls4, String.class, ArrayList.class, String.class}, str2, Integer.valueOf(i2), this.f38795c, this.d, Boolean.valueOf(this.g), this.e, this.f, this.i);
        }
        UrlRequest urlRequest3 = urlRequest2;
        if (urlRequest2 == null) {
            Class<Integer> cls5 = Integer.TYPE;
            Class<Boolean> cls6 = Boolean.TYPE;
            String str3 = this.b;
            int i3 = this.h;
            urlRequest3 = (UrlRequest) b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls5, UrlRequest.Callback.class, Executor.class, cls6, String.class, ArrayList.class}, str3, Integer.valueOf(i3), this.f38795c, this.d, Boolean.valueOf(this.g), this.e, this.f);
        }
        UrlRequest urlRequest4 = urlRequest3;
        if (urlRequest3 == null) {
            Class<Integer> cls7 = Integer.TYPE;
            Class<Boolean> cls8 = Boolean.TYPE;
            String str4 = this.b;
            int i4 = this.h;
            urlRequest4 = (UrlRequest) b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, cls7, UrlRequest.Callback.class, Executor.class, cls8, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, str4, Integer.valueOf(i4), this.f38795c, this.d, Boolean.valueOf(this.g), this.e, this.f, this.i, this.j, this.k, this.l);
        }
        if (urlRequest4 != null) {
            return urlRequest4;
        }
        throw new NullPointerException("UrlRequest build fail");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setDns(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("host and address are required.");
        }
        this.k = str;
        this.l = str2;
        try {
            w a2 = w.a();
            if (a2 != null && a2.b()) {
                a2.c().b().invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[]{String.class, String.class}, this.k, this.l);
            }
            return this;
        } catch (Exception e) {
            return this;
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str != null) {
            this.e = str;
            return this;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.h = i;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        if (str != null) {
            this.i = str;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr != null) {
            this.j = bArr;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }
}
