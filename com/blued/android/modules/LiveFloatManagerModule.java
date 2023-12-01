package com.blued.android.modules;

import android.content.Context;
import com.blued.android.module.base.live.ILiveFloatManager;
import com.blued.android.module.base.live.LiveFloatManagerProxy;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.ui.msg.DialogSkipFragment;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/LiveFloatManagerModule.class */
public class LiveFloatManagerModule {
    protected static ILiveFloatManager a = new ILiveFloatManager() { // from class: com.blued.android.modules.LiveFloatManagerModule.1
        @Override // com.blued.android.module.base.live.ILiveFloatManager
        public boolean a(Context context) {
            if (LiveFloatManager.a().H()) {
                DialogSkipFragment.a(context, 4);
                return true;
            }
            return false;
        }
    };

    public static void a() {
        LiveFloatManagerProxy.a().a((LiveFloatManagerProxy) a);
    }
}
