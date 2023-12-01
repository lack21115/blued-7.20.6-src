package com.sobot.chat.conversation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.utils.ZhiChiConstant;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatActivity.class */
public class SobotChatActivity extends SobotBaseActivity {
    SobotChatFSFragment chatFSFragment;
    SobotChatFragment chatFragment;
    Bundle informationBundle;

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int i) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(i, fragment);
        beginTransaction.commit();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_chat_act");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (bundle == null) {
            this.informationBundle = getIntent().getBundleExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION);
        } else {
            this.informationBundle = bundle.getBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        if (isFullScreen()) {
            SobotChatFSFragment sobotChatFSFragment = (SobotChatFSFragment) getSupportFragmentManager().findFragmentById(getResId("sobot_contentFrame"));
            this.chatFSFragment = sobotChatFSFragment;
            if (sobotChatFSFragment == null) {
                this.chatFSFragment = SobotChatFSFragment.newInstance(this.informationBundle);
                addFragmentToActivity(getSupportFragmentManager(), this.chatFSFragment, getResId("sobot_contentFrame"));
                return;
            }
            return;
        }
        SobotChatFragment sobotChatFragment = (SobotChatFragment) getSupportFragmentManager().findFragmentById(getResId("sobot_contentFrame"));
        this.chatFragment = sobotChatFragment;
        if (sobotChatFragment == null) {
            this.chatFragment = SobotChatFragment.newInstance(this.informationBundle);
            addFragmentToActivity(getSupportFragmentManager(), this.chatFragment, getResId("sobot_contentFrame"));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isFullScreen()) {
            SobotChatFSFragment sobotChatFSFragment = this.chatFSFragment;
            if (sobotChatFSFragment != null) {
                sobotChatFSFragment.onBackPress();
                return;
            } else {
                super.onBackPressed();
                return;
            }
        }
        SobotChatFragment sobotChatFragment = this.chatFragment;
        if (sobotChatFragment != null) {
            sobotChatFragment.onLeftMenuClick();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, this.informationBundle);
        super.onSaveInstanceState(bundle);
    }
}
