package com.blued.community;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.ui.home.HomeFragment;
import com.blued.login.test.LoginFragment;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/MainActivity.class */
public final class MainActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_community);
        if (UserInfo.getInstance().isLogin()) {
            HomeFragment.f19883a.a(this);
        } else {
            LoginFragment.f20569a.a(this);
        }
        finish();
    }
}
