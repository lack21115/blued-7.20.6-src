package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tb.class */
public class tb implements RequestProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f24332a;

    private tb(boolean z) {
        this.f24332a = z;
    }

    public static tb a(boolean z) {
        return new tb(z);
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        if (this.f24332a) {
            String str = netRequest.url;
            String str2 = str;
            if (str.startsWith("http://")) {
                str2 = str.replaceFirst("http://", "https://");
            }
            netRequest.url = str2;
        }
    }
}
