package com.tencent.tmsbeacon.base.net.a;

import com.tencent.tmsbeacon.pack.SocketResponsePackage;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/e.class */
public final class e implements c<byte[], SocketResponsePackage> {
    @Override // com.tencent.tmsbeacon.base.net.a.c
    public SocketResponsePackage a(byte[] bArr) {
        SocketResponsePackage socketResponsePackage = new SocketResponsePackage();
        socketResponsePackage.readFrom(new com.tencent.tmsbeacon.pack.a(bArr));
        com.tencent.tmsbeacon.base.net.b.d.c(socketResponsePackage.header);
        return socketResponsePackage;
    }
}
