package com.android.internal.http.multipart;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/multipart/ByteArrayPartSource.class */
public class ByteArrayPartSource implements PartSource {
    private byte[] bytes;
    private String fileName;

    public ByteArrayPartSource(String str, byte[] bArr) {
        this.fileName = str;
        this.bytes = bArr;
    }

    @Override // com.android.internal.http.multipart.PartSource
    public InputStream createInputStream() {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.android.internal.http.multipart.PartSource
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.android.internal.http.multipart.PartSource
    public long getLength() {
        return this.bytes.length;
    }
}
