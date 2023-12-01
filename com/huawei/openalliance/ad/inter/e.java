package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.aw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/e.class */
public class e extends IGlobalUtil.b {
    private static final String B = "GlobalUtil";
    private static final byte[] C = new byte[0];
    private static e F;
    private static final String S = "onActivityStartFinish";
    private List<IPPSUiEngineCallback> D = new ArrayList();
    private Context L;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/e$a.class */
    static class a implements RemoteCallResultCallback<String> {
        private final IPPSUiEngineCallback Code;

        public a(IPPSUiEngineCallback iPPSUiEngineCallback) {
            this.Code = iPPSUiEngineCallback;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            try {
                if (au.Code(callResult.getData()) || !callResult.getData().startsWith(bm.CONTENT.toString())) {
                    this.Code.onCallResult("getFilePath", null);
                    return;
                }
                String data = callResult.getData();
                Bundle bundle = new Bundle();
                bundle.putString("filePath", data);
                this.Code.onCallResult("getFilePath", bundle);
            } catch (Throwable th) {
                ge.V(e.B, "getFilePath err: %s", th.getClass().getSimpleName());
            }
        }
    }

    private e(Context context) {
        this.L = context;
    }

    public static e Code(Context context) {
        return V(context);
    }

    private static e V(Context context) {
        e eVar;
        synchronized (C) {
            if (F == null) {
                F = new e(context);
            }
            eVar = F;
        }
        return eVar;
    }

    public void V() {
        for (IPPSUiEngineCallback iPPSUiEngineCallback : this.D) {
            if (iPPSUiEngineCallback != null) {
                try {
                    iPPSUiEngineCallback.onCallResult(S, null);
                } catch (Throwable th) {
                    ge.V(B, "onCallResult err: %s", th.getClass().getSimpleName());
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        com.huawei.openalliance.ad.ipc.h.Code(this.L, false).Code(com.huawei.openalliance.ad.constant.p.x, str, new a(iPPSUiEngineCallback), String.class);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirect(final String str) {
        try {
            String str2 = (String) aw.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code */
                public String call() {
                    return (String) com.huawei.openalliance.ad.ipc.b.Code(e.this.L).Code(com.huawei.openalliance.ad.constant.p.x, str, String.class).getData();
                }
            }, null);
            ge.Code(B, "filePath = %s", str2);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        } catch (Throwable th) {
            ge.V(B, "getFilePath err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        ge.V(B, "registerActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.D.add(iPPSUiEngineCallback);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        ge.V(B, "unregisterActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.D.remove(iPPSUiEngineCallback);
        }
    }
}
