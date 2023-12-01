package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/multipart/PartSource.class */
public interface PartSource {
    InputStream createInputStream() throws IOException;

    String getFileName();

    long getLength();
}
