package com.blued.android.module.base.live;

import android.content.Context;
import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/live/LiveFloatManagerProxy.class */
public class LiveFloatManagerProxy extends BaseProxy<ILiveFloatManager> implements ILiveFloatManager {
    private static LiveFloatManagerProxy b;

    public static LiveFloatManagerProxy a() {
        if (b == null) {
            synchronized (LiveFloatManagerProxy.class) {
                try {
                    if (b == null) {
                        b = new LiveFloatManagerProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.live.ILiveFloatManager
    public boolean a(Context context) {
        if (this.f10426a != 0) {
            return ((ILiveFloatManager) this.f10426a).a(context);
        }
        return false;
    }
}
