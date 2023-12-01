package com.tencent.tmsbeacon.base.net.call;

import com.tencent.tmsbeacon.base.net.NetException;
import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.b.d;
import com.tencent.tmsbeacon.pack.AbstractResponseCommon;
import com.tencent.tmsbeacon.pack.ResponsePackage;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/j.class */
public class j implements com.tencent.tmsbeacon.base.net.call.a<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final JceRequestEntity f25828a;
    private long b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/j$a.class */
    public class a implements Runnable {
        public final /* synthetic */ Callback b;

        public a(Callback callback) {
            this.b = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.b(this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/j$b.class */
    public class b implements Runnable {
        public final /* synthetic */ Callback b;

        public b(Callback callback) {
            this.b = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.b(this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/j$c.class */
    public class c implements Callback<byte[]> {
        public final /* synthetic */ Callback b;

        public c(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(byte[] bArr) throws NetException {
            AbstractResponseCommon a2;
            byte[] bArr2;
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "raw response size: " + bArr.length, new Object[0]);
            if (j.this.f25828a.getType() == RequestType.EVENT) {
                a2 = com.tencent.tmsbeacon.base.net.c.c().e.b().a(bArr);
                if (a2 == null) {
                    throw new NetException("ResponsePackageV2 == null");
                }
                bArr2 = null;
            } else {
                a2 = com.tencent.tmsbeacon.base.net.c.c().d.b().a(bArr);
                if (a2 == null) {
                    throw new NetException("responsePackage == null");
                }
                ResponsePackage responsePackage = (ResponsePackage) a2;
                if (responsePackage.cmd != j.this.f25828a.getResponseCmd()) {
                    throw new NetException("responsePackage.cmd != requestEntity.responseCmd");
                }
                if (responsePackage.result != 0) {
                    throw new NetException("responsePackage.result != OK(0)");
                }
                bArr2 = responsePackage.sBuffer;
                if (bArr2 == null || bArr2.length <= 0) {
                    throw new NetException("responsePackage.buffer == null");
                }
            }
            d.a(j.this.b, a2.serverTime, a2.srcGatewayIp);
            Callback callback = this.b;
            if (callback != null) {
                callback.onResponse(bArr2);
            }
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(com.tencent.tmsbeacon.base.net.d dVar) {
            Callback callback = this.b;
            if (callback != null) {
                callback.onFailure(dVar);
            }
        }
    }

    public j(JceRequestEntity jceRequestEntity) {
        this.f25828a = jceRequestEntity;
    }

    public void a(Callback<byte[]> callback) {
        com.tencent.tmsbeacon.a.b.a.a().a(new a(callback));
    }

    public void a(Callback<byte[]> callback, com.tencent.tmsbeacon.a.b.a aVar) {
        aVar.a(new b(callback));
    }

    public void b(Callback<byte[]> callback) {
        this.b = new Date().getTime();
        com.tencent.tmsbeacon.base.net.c.c().a(this.f25828a, new c(callback));
    }
}
