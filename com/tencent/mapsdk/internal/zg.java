package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zg.class */
public class zg extends ib {
    private static final int b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static zg f24473c;

    private byte[] a(RttResponse rttResponse) {
        if (rttResponse == null) {
            return null;
        }
        return rttResponse.result;
    }

    private RttResponse b(byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return null;
            }
            try {
                NetResponse rttData = ((b3) ((p3) n2.a(p3.class)).d()).rttData(bArr);
                if (rttData != null && rttData.data != null) {
                    f fVar = new f();
                    fVar.b("UTF-8");
                    fVar.a(rttData.data);
                    return (RttResponse) fVar.c(ShareConstants.RES_PATH);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static zg c() {
        zg zgVar;
        synchronized (zg.class) {
            try {
                if (f24473c == null) {
                    f24473c = new zg();
                }
                zgVar = f24473c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zgVar;
    }

    @Override // com.tencent.mapsdk.internal.ib
    public byte[] a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length == 0) {
                    return null;
                }
                return a(b(bArr));
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
