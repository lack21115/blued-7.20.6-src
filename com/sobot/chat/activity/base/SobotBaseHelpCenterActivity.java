package com.sobot.chat.activity.base;

import android.os.Bundle;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/base/SobotBaseHelpCenterActivity.class */
public abstract class SobotBaseHelpCenterActivity extends SobotBaseActivity {
    protected Information mInfo;
    protected Bundle mInformationBundle;

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (bundle == null) {
            this.mInformationBundle = getIntent().getBundleExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION);
        } else {
            this.mInformationBundle = bundle.getBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION);
        }
        Bundle bundle2 = this.mInformationBundle;
        if (bundle2 != null) {
            Serializable serializable = bundle2.getSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO);
            if (serializable instanceof Information) {
                this.mInfo = (Information) serializable;
                SharedPreferencesUtil.saveObject(getSobotBaseContext(), ZhiChiConstant.sobot_last_current_info, this.mInfo);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, this.mInformationBundle);
        super.onSaveInstanceState(bundle);
    }
}
