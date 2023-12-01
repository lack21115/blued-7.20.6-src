package com.blued.android.module.yy_china.test;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.anythink.china.common.d;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.R;
import com.blued.login.test.LoginFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YyMainActivity.class */
public final class YyMainActivity extends AppCompatActivity {
    public final void a() {
        if (UserInfo.getInstance().isLogin()) {
            UserInfo.getInstance().saveUserInfo(UserInfo.getInstance().getUserName(), UserInfo.getInstance().getLoginType(), UserAccountsVDao.a().c().getLoginresult(), UserInfo.getInstance().getLoginUserInfo(), null);
            YYTestFragment.a.a((Context) this);
        } else {
            LoginFragment.a.a((Context) this);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_yy);
        if (Build.VERSION.SDK_INT < 23) {
            a();
            return;
        }
        Context context = (Context) this;
        if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) {
            a();
        } else {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", d.b, "android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 101);
        }
    }

    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.e(permissions, "permissions");
        Intrinsics.e(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        a();
    }
}
