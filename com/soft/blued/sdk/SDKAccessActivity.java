package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKAccessActivity.class */
public class SDKAccessActivity extends BaseFragmentActivity {
    /* JADX WARN: Multi-variable type inference failed */
    private void a(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        SDKBaseAction a2 = SDKBaseAction.a(intent);
        Logger.a("SDKAction", "AccessActivity receive a action:", a2);
        if (a2 == null) {
            finish();
            return;
        }
        SDKActionManager.a(a2);
        if (UserInfo.getInstance().isLogin()) {
            a2.c(this);
            return;
        }
        FirstActivity.a((Context) this);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
