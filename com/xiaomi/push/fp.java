package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fp.class */
public final class fp extends fj {
    public fp() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fj
    /* renamed from: a */
    public final ByteBuffer mo11759a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.mo11759a(byteBuffer);
    }

    @Override // com.xiaomi.push.fj
    public final int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
