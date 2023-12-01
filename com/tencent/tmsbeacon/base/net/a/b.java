package com.tencent.tmsbeacon.base.net.a;

import com.tencent.tmsbeacon.base.net.a.c;
import com.tencent.tmsbeacon.d.g;
import com.tencent.tmsbeacon.pack.AbstractJceStruct;
import com.tencent.tmsbeacon.pack.RequestPackageV2;
import com.tencent.tmsbeacon.pack.ResponsePackageV2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/b.class */
public class b extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a  reason: collision with root package name */
    private final a f25802a = new a();
    private final C0863b b = new C0863b();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/b$a.class */
    public static final class a implements c<RequestPackageV2, byte[]> {
        private byte[] a(byte[] bArr) {
            g b = g.b();
            byte[] bArr2 = bArr;
            if (b != null) {
                if (com.tencent.tmsbeacon.d.b.a().h()) {
                    return com.tencent.tmsbeacon.base.util.b.b(bArr, 2, 3, b.a());
                }
                bArr2 = com.tencent.tmsbeacon.base.util.b.b(bArr, 2);
            }
            return bArr2;
        }

        @Override // com.tencent.tmsbeacon.base.net.a.c
        public byte[] a(RequestPackageV2 requestPackageV2) {
            if (requestPackageV2 == null) {
                return null;
            }
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "RequestPackageV2: " + requestPackageV2.toString(), new Object[0]);
            com.tencent.tmsbeacon.pack.b bVar = new com.tencent.tmsbeacon.pack.b();
            requestPackageV2.writeTo(bVar);
            byte[] a2 = a(bVar.b());
            if (a2 != null) {
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a2.length, new Object[0]);
            }
            return a2;
        }
    }

    /* renamed from: com.tencent.tmsbeacon.base.net.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/b$b.class */
    public static final class C0863b implements c<byte[], ResponsePackageV2> {
        private byte[] b(byte[] bArr) {
            return com.tencent.tmsbeacon.d.b.a().h() ? com.tencent.tmsbeacon.base.util.b.a(bArr, 2, 3, g.b().a()) : com.tencent.tmsbeacon.base.util.b.a(bArr, 2);
        }

        @Override // com.tencent.tmsbeacon.base.net.a.c
        public ResponsePackageV2 a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            byte[] b = b(bArr);
            ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
            responsePackageV2.readFrom(new com.tencent.tmsbeacon.pack.a(b));
            return responsePackageV2;
        }
    }

    public static b a() {
        return new b();
    }

    public c<byte[], ResponsePackageV2> b() {
        return this.b;
    }

    public c<RequestPackageV2, byte[]> c() {
        return this.f25802a;
    }
}
