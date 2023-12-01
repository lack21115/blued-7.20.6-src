package com.tencent.beacon.base.net.a;

import android.text.TextUtils;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.e.h;
import com.tencent.beacon.pack.SocketRequestPackage;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/d.class */
public final class d implements c<JceRequestEntity, SocketRequestPackage> {
    private Map<String, String> b(JceRequestEntity jceRequestEntity) {
        Map<String, String> header = jceRequestEntity.getHeader();
        if (!header.containsKey("sid")) {
            String c2 = h.b().c();
            if (!TextUtils.isEmpty(c2)) {
                header.put("sid", c2);
            }
        }
        return header;
    }

    @Override // com.tencent.beacon.base.net.a.c
    public SocketRequestPackage a(JceRequestEntity jceRequestEntity) {
        return new SocketRequestPackage(b(jceRequestEntity), jceRequestEntity.getContent());
    }
}
