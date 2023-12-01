package com.tencent.tmsbeacon.base.net.a;

import com.tencent.tmsbeacon.base.net.a.c;
import com.tencent.tmsbeacon.d.g;
import com.tencent.tmsbeacon.pack.AbstractJceStruct;
import com.tencent.tmsbeacon.pack.RequestPackage;
import com.tencent.tmsbeacon.pack.ResponsePackage;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/a.class */
public final class a extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a  reason: collision with root package name */
    private final C0862a f25801a = new C0862a();
    private final b b = new b();

    /* renamed from: com.tencent.tmsbeacon.base.net.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/a$a.class */
    public static final class C0862a implements c<RequestPackage, byte[]> {
        private byte[] a(byte[] bArr) {
            g b = g.b();
            byte[] bArr2 = bArr;
            if (b != null) {
                bArr2 = com.tencent.tmsbeacon.base.util.b.b(bArr, 2, 3, b.a());
            }
            return bArr2;
        }

        private byte[] b(RequestPackage requestPackage) {
            com.tencent.tmsbeacon.pack.c cVar = new com.tencent.tmsbeacon.pack.c();
            cVar.a(1);
            cVar.b("test");
            cVar.a("test");
            cVar.b("detail", requestPackage);
            return cVar.a();
        }

        @Override // com.tencent.tmsbeacon.base.net.a.c
        public byte[] a(RequestPackage requestPackage) {
            if (requestPackage == null) {
                return null;
            }
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "RequestPackage: " + requestPackage.toString(), new Object[0]);
            byte[] a2 = a(b(requestPackage));
            if (a2 != null) {
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a2.length, new Object[0]);
            }
            return a2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/a/a$b.class */
    public static final class b implements c<byte[], ResponsePackage> {
        private ResponsePackage b(byte[] bArr) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        com.tencent.tmsbeacon.pack.c cVar = new com.tencent.tmsbeacon.pack.c();
                        cVar.a(bArr);
                        return (ResponsePackage) cVar.a("detail", (String) new ResponsePackage());
                    }
                    return null;
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }

        private byte[] c(byte[] bArr) {
            return com.tencent.tmsbeacon.base.util.b.a(bArr, 2, 3, g.b().a());
        }

        @Override // com.tencent.tmsbeacon.base.net.a.c
        public ResponsePackage a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return b(c(bArr));
        }
    }

    public static a a() {
        return new a();
    }

    public c<byte[], ResponsePackage> b() {
        return this.b;
    }

    public c<RequestPackage, byte[]> c() {
        return this.f25801a;
    }
}
