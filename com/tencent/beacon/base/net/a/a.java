package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.e.h;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackage;
import com.tencent.beacon.pack.ResponsePackage;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/a.class */
public final class a extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a  reason: collision with root package name */
    private final C0896a f34961a = new C0896a();
    private final b b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.beacon.base.net.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/a$a.class */
    public static final class C0896a implements c<RequestPackage, byte[]> {
        C0896a() {
        }

        private byte[] a(byte[] bArr) {
            h b = h.b();
            byte[] bArr2 = bArr;
            if (b != null) {
                bArr2 = com.tencent.beacon.base.util.b.b(bArr, 2, 3, b.a());
            }
            return bArr2;
        }

        private byte[] b(RequestPackage requestPackage) {
            com.tencent.beacon.pack.c cVar = new com.tencent.beacon.pack.c();
            cVar.a(1);
            cVar.b("test");
            cVar.a("test");
            cVar.b("detail", requestPackage);
            return cVar.a();
        }

        @Override // com.tencent.beacon.base.net.a.c
        public byte[] a(RequestPackage requestPackage) {
            if (requestPackage == null) {
                return null;
            }
            com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackage: " + requestPackage.toString(), new Object[0]);
            byte[] a2 = a(b(requestPackage));
            if (a2 != null) {
                com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a2.length, new Object[0]);
            }
            return a2;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/a$b.class */
    static final class b implements c<byte[], ResponsePackage> {
        b() {
        }

        private ResponsePackage b(byte[] bArr) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        com.tencent.beacon.pack.c cVar = new com.tencent.beacon.pack.c();
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
            return com.tencent.beacon.base.util.b.a(bArr, 2, 3, h.b().a());
        }

        @Override // com.tencent.beacon.base.net.a.c
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
        return this.f34961a;
    }
}
