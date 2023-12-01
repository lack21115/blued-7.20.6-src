package com.blued.android.module.yy_china.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYRouteUtil.class */
public class YYRouteUtil {
    public static boolean a = false;

    public static void a(Fragment fragment, Bundle bundle, int i) {
        if (a) {
            return;
        }
        LiveSetPayPwdFragment liveSetPayPwdFragment = new LiveSetPayPwdFragment();
        liveSetPayPwdFragment.setTargetFragment(fragment, i);
        liveSetPayPwdFragment.setArguments(bundle);
        liveSetPayPwdFragment.setCancelable(true);
        liveSetPayPwdFragment.show(fragment.getFragmentManager(), liveSetPayPwdFragment.b());
    }
}
