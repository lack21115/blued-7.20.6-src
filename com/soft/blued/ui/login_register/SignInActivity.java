package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.login.fragment.LoginMainFragment;
import com.umeng.analytics.MobclickAgent;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/SignInActivity.class */
public class SignInActivity extends TerminalActivity {
    public static boolean d = false;
    public static String e;
    public static String f;

    public static void a(Context context, Bundle... bundleArr) {
        if (context == null) {
            return;
        }
        Bundle bundle = bundleArr.length > 0 ? bundleArr[0] : new Bundle();
        a(bundle);
        d(context, LoginMainFragment.class, bundle);
        if (bundleArr.length == 0 && (context instanceof Activity) && !(context instanceof SignInActivity)) {
            ((Activity) context).finish();
        }
    }

    private boolean d(Bundle bundle) {
        return bundle != null && bundle.containsKey("aliasUserId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!UserInfo.getInstance().isLogin() || d(bundle)) {
            d = false;
        } else {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
        MobclickAgent.onPause(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }
}
