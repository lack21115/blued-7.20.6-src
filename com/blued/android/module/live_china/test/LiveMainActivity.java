package com.blued.android.module.live_china.test;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.R;
import com.blued.login.test.LoginFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveMainActivity.class */
public final class LiveMainActivity extends AppCompatActivity {
    public final void a() {
        if (UserInfo.getInstance().isLogin()) {
            LiveFragmentTest.f14136a.a(this);
        } else {
            LoginFragment.f20569a.a(this);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live);
        if (Build.VERSION.SDK_INT < 23) {
            a();
            return;
        }
        LiveMainActivity liveMainActivity = this;
        if (ContextCompat.checkSelfPermission(liveMainActivity, Manifest.permission.CAMERA) == 0 && ContextCompat.checkSelfPermission(liveMainActivity, Manifest.permission.RECORD_AUDIO) == 0) {
            a();
        } else {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 101);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.e(permissions, "permissions");
        Intrinsics.e(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        a();
    }
}
