package com.blued.android.modules;

import android.content.Context;
import com.blued.android.module.base.ui.IPopMenuFromCenter;
import com.blued.android.module.base.ui.PopMenuFromCenterProxy;
import com.soft.blued.utils.PopMenuUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/PopMenuFromCenterModule.class */
public class PopMenuFromCenterModule {

    /* renamed from: a  reason: collision with root package name */
    protected static IPopMenuFromCenter f18632a = new IPopMenuFromCenter() { // from class: com.blued.android.modules.PopMenuFromCenterModule.1
        @Override // com.blued.android.module.base.ui.IPopMenuFromCenter
        public boolean a(Context context) {
            return PopMenuUtils.a(context);
        }
    };

    public static void a() {
        PopMenuFromCenterProxy.a().a((PopMenuFromCenterProxy) f18632a);
    }
}
