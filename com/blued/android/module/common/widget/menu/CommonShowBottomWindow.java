package com.blued.android.module.common.widget.menu;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/CommonShowBottomWindow.class */
public class CommonShowBottomWindow {
    public static BasePopupView a(Context context, List<BottomMenuPop.MenuItemInfo> list) {
        BottomMenuPop bottomMenuPop = new BottomMenuPop(context);
        bottomMenuPop.b = list;
        return new XPopup.Builder(context).a((BasePopupView) bottomMenuPop);
    }

    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, int i, ActionSheet.ActionSheetListener actionSheetListener) {
        fragmentActivity.setTheme(R.style.ActionSheetStyleIOS7);
        return ActionSheet.a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager()).a(fragmentActivity.getResources().getString(R.string.cancel)).a(strArr).a(i).a(true).a(actionSheetListener).b();
    }

    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, ActionSheet.ActionSheetListener actionSheetListener) {
        return a(fragmentActivity, strArr, -1, actionSheetListener);
    }

    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, String str, ActionSheet.ActionSheetListener actionSheetListener) {
        fragmentActivity.setTheme(R.style.ActionSheetStyleIOS7);
        return ActionSheet.a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager()).a(fragmentActivity.getResources().getString(R.string.cancel)).a(strArr).b(str).a(true).a(actionSheetListener).b();
    }

    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, boolean z, ActionSheet.ActionSheetListener actionSheetListener) {
        fragmentActivity.setTheme(R.style.ActionSheetStyleIOS7);
        return ActionSheet.a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager()).a(fragmentActivity.getResources().getString(R.string.cancel)).a(strArr).b(z).a(true).a(actionSheetListener).b();
    }

    public static ActionSheet a(FragmentActivity fragmentActivity, String[] strArr, int[] iArr, String str, ActionSheet.ActionSheetListener actionSheetListener) {
        fragmentActivity.setTheme(R.style.ActionSheetStyleIOS7);
        return ActionSheet.a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager()).a(fragmentActivity.getResources().getString(R.string.cancel)).a(strArr).a(iArr).c(str).a(true).a(actionSheetListener).b();
    }
}
