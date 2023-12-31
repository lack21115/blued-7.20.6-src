package com.android.internal.http.multipart;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/multipart/PartBase.class */
public abstract class PartBase extends Part {
    private String charSet;
    private String contentType;
    private String name;
    private String transferEncoding;

    public PartBase(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        this.name = str;
        this.contentType = str2;
        this.charSet = str3;
        this.transferEncoding = str4;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getCharSet() {
        return this.charSet;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getName() {
        return this.name;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public void setCharSet(String str) {
        this.charSet = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        this.name = str;
    }

    public void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }
}
