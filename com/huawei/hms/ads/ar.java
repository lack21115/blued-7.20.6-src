package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.at;
import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.download.app.b;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Collections;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ar.class */
public class ar extends ap {
    private static final String Z = "JsbOnAgReserveStatusChange";

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ar$a.class */
    static class a implements com.huawei.openalliance.ad.download.f {
        private static final byte[] Code = new byte[0];
        private static a V;
        private String I;
        private Map<String, RemoteCallResultCallback<String>> Z = Collections.synchronizedMap(new at.c(5));

        private a(Context context) {
            ge.V("jsb", "ReserveStatusListener init");
            b.Code(context).Code(this);
        }

        public static a Code(Context context) {
            a aVar;
            synchronized (Code) {
                if (V == null) {
                    V = new a(context);
                }
                aVar = V;
            }
            return aVar;
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.Z.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i) {
            Map<String, RemoteCallResultCallback<String>> map = this.Z;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.Z.values()) {
                af.Code(remoteCallResultCallback, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(str, i)), false);
            }
        }
    }

    public ar() {
        super(ai.e);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a.Code(context).Code(remoteCallResultCallback, this.Code, this.I);
    }
}
