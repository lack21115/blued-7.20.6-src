package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/GlideUrl.class */
public class GlideUrl implements Key {
    private final Headers b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f7270c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public GlideUrl(String str) {
        this(str, Headers.b);
    }

    public GlideUrl(String str, Headers headers) {
        this.f7270c = null;
        this.d = Preconditions.a(str);
        this.b = (Headers) Preconditions.a(headers);
    }

    public GlideUrl(URL url) {
        this(url, Headers.b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f7270c = (URL) Preconditions.a(url);
        this.d = null;
        this.b = (Headers) Preconditions.a(headers);
    }

    private URL e() throws MalformedURLException {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    private String f() {
        if (TextUtils.isEmpty(this.e)) {
            String str = this.d;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = ((URL) Preconditions.a(this.f7270c)).toString();
            }
            this.e = Uri.encode(str2, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private byte[] g() {
        if (this.g == null) {
            this.g = d().getBytes(f7100a);
        }
        return this.g;
    }

    public URL a() throws MalformedURLException {
        return e();
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(g());
    }

    public String b() {
        return f();
    }

    public Map<String, String> c() {
        return this.b.a();
    }

    public String d() {
        String str = this.d;
        return str != null ? str : ((URL) Preconditions.a(this.f7270c)).toString();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            z = false;
            if (d().equals(glideUrl.d())) {
                z = false;
                if (this.b.equals(glideUrl.b)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.h == 0) {
            int hashCode = d().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return d();
    }
}
