package com.kwad.sdk.core.network.b;

import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/b/a.class */
public final class a implements AdHttpProxy {
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGet(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.kwai.b.doGet(str, map);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGetWithoutResponse(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.kwai.b.a(str, map, false);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        return new c();
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return com.kwad.sdk.core.network.kwai.b.doPost(str, map, map2);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return com.kwad.sdk.core.network.kwai.b.doPost(str, map, jSONObject);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final boolean downloadUrlToStream(String str, OutputStream outputStream, int i) {
        return com.kwad.sdk.core.network.kwai.b.downloadUrlToStream(str, outputStream, i);
    }
}
