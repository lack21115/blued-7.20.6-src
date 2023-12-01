package com.zx.sdk.common.utils;

import com.igexin.sdk.PushConsts;
import com.zx.a.I8b7.n1;
import com.zx.a.I8b7.n2;
import com.zx.a.I8b7.y2;

/* loaded from: source-8829756-dex2jar.jar:com/zx/sdk/common/utils/ZXTask.class */
public class ZXTask implements Runnable {
    private a errorCallback;
    private Runnable r;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/sdk/common/utils/ZXTask$a.class */
    public interface a {
    }

    public ZXTask(Runnable runnable, a aVar) {
        this.r = runnable;
        this.errorCallback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.r;
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            a aVar = this.errorCallback;
            if (aVar != null) {
                ((y2) aVar).f28541a.f28410c.onMessage("MESSAGE_ON_ZXID_RECEIVED", n1.a(PushConsts.GET_SDKSERVICEPID, th.getMessage()));
                StringBuilder sb = new StringBuilder();
                sb.append("ZXCore start failed: ");
                n2.a(th, sb);
            }
        }
    }
}
