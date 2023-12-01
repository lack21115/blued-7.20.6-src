package com.tencent.beacon.pack;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/pack/SocketRequestPackage.class */
public final class SocketRequestPackage extends AbstractJceStruct {
    static byte[] cache_body;
    static Map<String, String> cache_header;
    public byte[] body;
    public Map<String, String> header;

    static {
        HashMap hashMap = new HashMap();
        cache_header = hashMap;
        hashMap.put("", "");
        cache_body = r0;
        byte[] bArr = {0};
    }

    public SocketRequestPackage() {
        this.header = null;
        this.body = null;
    }

    public SocketRequestPackage(Map<String, String> map, byte[] bArr) {
        this.header = null;
        this.body = null;
        this.header = map;
        this.body = bArr;
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.header = (Map) aVar.a((a) cache_header, 0, true);
        this.body = aVar.a(cache_body, 1, true);
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a((Map) this.header, 0);
        bVar.a(this.body, 1);
    }
}
