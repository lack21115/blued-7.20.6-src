package com.mokee.volley;

import java.util.Collections;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/NetworkResponse.class */
public class NetworkResponse {
    public final byte[] data;
    public final Map<String, String> headers;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this.statusCode = i;
        this.data = bArr;
        this.headers = map;
        this.notModified = z;
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false);
    }

    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false);
    }
}
