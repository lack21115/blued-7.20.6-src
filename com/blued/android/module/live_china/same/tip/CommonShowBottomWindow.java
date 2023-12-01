package com.blued.android.module.live_china.same.tip;

import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.media.selector.view.ActionSheet;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonShowBottomWindow.class */
public class CommonShowBottomWindow {
    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, String str, ActionSheet.ActionSheetListener actionSheetListener) {
        return ActionSheet.a(fragmentActivity, fragmentActivity.getFragmentManager()).a(fragmentActivity.getResources().getString(R.string.biao_v4_cancel)).a(strArr).b(str).a(true).a(actionSheetListener).b();
    }
}
