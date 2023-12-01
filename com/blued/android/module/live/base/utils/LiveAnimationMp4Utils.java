package com.blued.android.module.live.base.utils;

import android.view.View;
import com.blued.android.module.video_gift.AlphaVideoGiftView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveAnimationMp4Utils.class */
public class LiveAnimationMp4Utils {
    public static boolean a(View view) {
        if (view instanceof AlphaVideoGiftView) {
            AlphaVideoGiftView alphaVideoGiftView = (AlphaVideoGiftView) view;
            alphaVideoGiftView.setOnVideoStateChangedListener(null);
            alphaVideoGiftView.e();
            alphaVideoGiftView.i();
            return true;
        }
        return false;
    }
}
