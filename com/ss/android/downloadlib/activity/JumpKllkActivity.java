package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.utils.ko;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/activity/JumpKllkActivity.class */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void mb() {
        if (getIntent() == null) {
            b.mb().mb("handleIntent is null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            b.mb().mb("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
        boolean z = false;
        int optInt = x.lz().optInt("ab", 0);
        if (optInt == 1) {
            z = true;
        }
        ko.mb(this, stringExtra, longExtra, z);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
    }
}
