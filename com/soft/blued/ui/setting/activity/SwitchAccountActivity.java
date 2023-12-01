package com.soft.blued.ui.setting.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.ui.setting.fragment.SwitchAccountFragment;
import skin.support.SkinCompatManager;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/activity/SwitchAccountActivity.class */
public class SwitchAccountActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    private View f33271c;

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        this.f33271c = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f33271c.setId(2131369470);
        setContentView(this.f33271c);
        if (StatusBarHelper.a(this, AppInfo.i())) {
            this.f33271c.setFitsSystemWindows(true);
            getWindow().setBackgroundDrawable(StatusBarHelper.a(this, AppInfo.k(), AppInfo.l(), AppInfo.j(), true));
            if (SkinCompatManager.a() != null) {
                findViewById(16908290).setBackgroundColor(BluedSkinUtils.a(this, AppInfo.k()));
            }
        }
        try {
            getSupportFragmentManager().beginTransaction().replace(2131369470, new SwitchAccountFragment()).commitAllowingStateLoss();
        } catch (Throwable th) {
        }
    }
}
