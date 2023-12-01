package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgModel;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.dialog.SobotFreeAccountTipDialog;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.network.http.callback.StringResultCallBack;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPostLeaveMsgActivity.class */
public class SobotPostLeaveMsgActivity extends SobotBaseActivity implements View.OnClickListener {
    private static final String EXTRA_MSG_LEAVE_CONTENT = "EXTRA_MSG_LEAVE_CONTENT";
    private static final String EXTRA_MSG_LEAVE_CONTENT_TXT = "EXTRA_MSG_LEAVE_CONTENT_TXT";
    public static final int EXTRA_MSG_LEAVE_REQUEST_CODE = 109;
    private static final String EXTRA_MSG_LEAVE_TXT = "EXTRA_MSG_LEAVE_TXT";
    private static final String EXTRA_MSG_UID = "EXTRA_MSG_UID";
    private String mUid;
    private String skillGroupId = "";
    private SobotFreeAccountTipDialog sobotFreeAccountTipDialog;
    private Button sobot_btn_submit;
    private EditText sobot_post_et_content;
    private TextView sobot_tv_leaveExplain;
    private TextView sobot_tv_post_msg;
    private TextView sobot_tv_problem_description;

    public static String getResultContent(Intent intent) {
        if (intent != null) {
            return intent.getStringExtra(EXTRA_MSG_LEAVE_CONTENT);
        }
        return null;
    }

    public static Intent newIntent(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, SobotPostLeaveMsgActivity.class);
        intent.putExtra(EXTRA_MSG_LEAVE_TXT, str);
        intent.putExtra(EXTRA_MSG_LEAVE_CONTENT_TXT, str2);
        intent.putExtra(EXTRA_MSG_UID, str3);
        return intent;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_post_leave_msg");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra(EXTRA_MSG_UID);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        ZhiChiInitModeBase zhiChiInitModeBase = (ZhiChiInitModeBase) SharedPreferencesUtil.getObject(this, ZhiChiConstant.sobot_last_current_initModel);
        if (zhiChiInitModeBase != null && ChatUtils.isFreeAccount(zhiChiInitModeBase.getAccountStatus())) {
            SobotFreeAccountTipDialog sobotFreeAccountTipDialog = new SobotFreeAccountTipDialog(this, new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostLeaveMsgActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotPostLeaveMsgActivity.this.sobotFreeAccountTipDialog.dismiss();
                    SobotPostLeaveMsgActivity.this.finish();
                }
            });
            this.sobotFreeAccountTipDialog = sobotFreeAccountTipDialog;
            if (sobotFreeAccountTipDialog != null && !sobotFreeAccountTipDialog.isShowing()) {
                this.sobotFreeAccountTipDialog.show();
            }
        }
        this.skillGroupId = SharedPreferencesUtil.getStringData(this, ZhiChiConstant.sobot_connect_group_id, "");
        this.zhiChiApi.getLeavePostOfflineConfig(SobotPostLeaveMsgActivity.class, this.mUid, this.skillGroupId, new StringResultCallBack<SobotOfflineLeaveMsgModel>() { // from class: com.sobot.chat.activity.SobotPostLeaveMsgActivity.2
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotPostLeaveMsgActivity.this.getApplicationContext(), str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotOfflineLeaveMsgModel sobotOfflineLeaveMsgModel) {
                if (sobotOfflineLeaveMsgModel != null) {
                    SobotPostLeaveMsgActivity.this.sobot_tv_post_msg.setText(TextUtils.isEmpty(sobotOfflineLeaveMsgModel.getMsgLeaveTxt()) ? "" : sobotOfflineLeaveMsgModel.getMsgLeaveTxt());
                    SobotPostLeaveMsgActivity.this.sobot_post_et_content.setHint(TextUtils.isEmpty(sobotOfflineLeaveMsgModel.getMsgLeaveContentTxt()) ? "" : sobotOfflineLeaveMsgModel.getMsgLeaveContentTxt());
                    if (TextUtils.isEmpty(sobotOfflineLeaveMsgModel.getLeaveExplain())) {
                        SobotPostLeaveMsgActivity.this.sobot_tv_leaveExplain.setVisibility(8);
                        return;
                    }
                    SobotPostLeaveMsgActivity.this.sobot_tv_leaveExplain.setVisibility(0);
                    SobotPostLeaveMsgActivity.this.sobot_tv_leaveExplain.setText(sobotOfflineLeaveMsgModel.getLeaveExplain());
                }
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        setTitle(getResString("sobot_leavemsg_title"));
        this.sobot_tv_post_msg = (TextView) findViewById(getResId("sobot_tv_post_msg"));
        this.sobot_post_et_content = (EditText) findViewById(getResId("sobot_post_et_content"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_problem_description"));
        this.sobot_tv_problem_description = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_problem_description"));
        Button button = (Button) findViewById(getResId("sobot_btn_submit"));
        this.sobot_btn_submit = button;
        button.setText(ResourceUtils.getResString(this, "sobot_btn_submit_text"));
        this.sobot_btn_submit.setOnClickListener(this);
        this.sobot_tv_leaveExplain = (TextView) findViewById(getResId("sobot_tv_leaveExplain"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_btn_submit) {
            final String obj = this.sobot_post_et_content.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(this.mUid)) {
                KeyboardUtil.hideKeyboard(this.sobot_post_et_content);
                this.zhiChiApi.leaveMsg(SobotPostLeaveMsgActivity.class, this.mUid, this.skillGroupId, obj, new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.activity.SobotPostLeaveMsgActivity.3
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str) {
                        ToastUtil.showToast(SobotPostLeaveMsgActivity.this.getApplicationContext(), str);
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onSuccess(BaseCode baseCode) {
                        CustomToast.makeText(SobotPostLeaveMsgActivity.this.getBaseContext(), ResourceUtils.getResString(SobotPostLeaveMsgActivity.this.getBaseContext(), "sobot_leavemsg_success_tip"), 1000, ResourceUtils.getDrawableId(SobotPostLeaveMsgActivity.this.getBaseContext(), "sobot_iv_login_right")).show();
                        Intent intent = new Intent();
                        intent.putExtra(SobotPostLeaveMsgActivity.EXTRA_MSG_LEAVE_CONTENT, obj);
                        SobotPostLeaveMsgActivity.this.setResult(109, intent);
                        SobotPostLeaveMsgActivity.this.finish();
                    }
                });
                return;
            }
            CustomToast.makeText(this, ResourceUtils.getResString(this, "sobot_problem_description") + ResourceUtils.getResString(this, "sobot__is_null"), 1000).show();
        }
    }
}
