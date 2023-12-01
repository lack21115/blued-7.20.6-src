package com.youzan.spiderman.cache;

import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/ResourceResponse.class */
public class ResourceResponse {

    /* renamed from: a  reason: collision with root package name */
    private String f28100a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f28101c;

    public ResourceResponse(String str, String str2, InputStream inputStream) {
        this.f28100a = str;
        this.b = str2;
        this.f28101c = inputStream;
    }

    public String getEncoding() {
        return this.b;
    }

    public InputStream getInputStream() {
        return this.f28101c;
    }

    public String getMimeType() {
        return this.f28100a;
    }

    public void setEncoding(String str) {
        this.b = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.f28101c = inputStream;
    }

    public void setMimeType(String str) {
        this.f28100a = str;
    }
}
