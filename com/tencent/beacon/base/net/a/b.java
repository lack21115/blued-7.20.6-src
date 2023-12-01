package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.e.h;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import com.tencent.beacon.pack.ResponsePackageV2;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/b.class */
public class b extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a  reason: collision with root package name */
    private final a f34962a = new a();
    private final C0897b b = new C0897b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/b$a.class */
    public static final class a implements c<RequestPackageV2, byte[]> {
        a() {
        }

        private byte[] a(byte[] bArr) {
            h b = h.b();
            byte[] bArr2 = bArr;
            if (b != null) {
                if (com.tencent.beacon.e.b.a().m()) {
                    return com.tencent.beacon.base.util.b.b(bArr, 2, 3, b.a());
                }
                bArr2 = com.tencent.beacon.base.util.b.b(bArr, 2);
            }
            return bArr2;
        }

        @Override // com.tencent.beacon.base.net.a.c
        public byte[] a(RequestPackageV2 requestPackageV2) {
            if (requestPackageV2 == null) {
                return null;
            }
            com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackageV2: " + requestPackageV2.toString(), new Object[0]);
            com.tencent.beacon.pack.b bVar = new com.tencent.beacon.pack.b();
            requestPackageV2.writeTo(bVar);
            byte[] a2 = a(bVar.b());
            if (a2 != null) {
                com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a2.length, new Object[0]);
            }
            return a2;
        }
    }

    /* renamed from: com.tencent.beacon.base.net.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/a/b$b.class */
    static final class C0897b implements c<byte[], ResponsePackageV2> {
        C0897b() {
        }

        private byte[] b(byte[] bArr) {
            return com.tencent.beacon.e.b.a().m() ? com.tencent.beacon.base.util.b.a(bArr, 2, 3, h.b().a()) : com.tencent.beacon.base.util.b.a(bArr, 2);
        }

        @Override // com.tencent.beacon.base.net.a.c
        public ResponsePackageV2 a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            byte[] b = b(bArr);
            ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
            responsePackageV2.readFrom(new com.tencent.beacon.pack.a(b));
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
        return this.f34962a;
    }
}
