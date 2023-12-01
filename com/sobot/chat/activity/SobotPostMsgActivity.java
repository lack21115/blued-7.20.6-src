package com.sobot.chat.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.adapter.StViewPagerAdapter;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.fragment.SobotBaseFragment;
import com.sobot.chat.fragment.SobotPostMsgFragment;
import com.sobot.chat.fragment.SobotTicketInfoFragment;
import com.sobot.chat.listener.SobotFunctionType;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.PagerSlidingTab;
import com.sobot.chat.widget.dialog.SobotFreeAccountTipDialog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPostMsgActivity.class */
public class SobotPostMsgActivity extends SobotBaseActivity implements View.OnClickListener {
    public static final String SOBOT_ACTION_SHOW_COMPLETED_VIEW = "sobot_action_show_completed_view";
    private boolean flag_exit_sdk;
    private StViewPagerAdapter mAdapter;
    private SobotLeaveMsgConfig mConfig;
    private boolean mIsCreateSuccess;
    private boolean mIsShowTicket;
    private LinearLayout mLlCompleted;
    private SobotPostMsgFragment mPostMsgFragment;
    private MessageReceiver mReceiver;
    private TextView mTvCompleted;
    private TextView mTvLeaveMsgCreateSuccess;
    private TextView mTvLeaveMsgCreateSuccessDes;
    private TextView mTvTicket;
    private ViewPager mViewPager;
    private LinearLayout mllContainer;
    private ImageView psgBackIv;
    private SobotFreeAccountTipDialog sobotFreeAccountTipDialog;
    private PagerSlidingTab sobot_pst_indicator;
    private String mUid = "";
    private String mGroupId = "";
    private String mCustomerId = "";
    private String mCompanyId = "";
    private int flag_exit_type = -1;
    private List<SobotBaseFragment> mFragments = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotPostMsgActivity$MessageReceiver.class */
    public class MessageReceiver extends BroadcastReceiver {
        public MessageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && SobotPostMsgActivity.SOBOT_ACTION_SHOW_COMPLETED_VIEW.equals(intent.getAction())) {
                SobotPostMsgActivity.this.mllContainer.setVisibility(8);
                SobotPostMsgActivity.this.mViewPager.setVisibility(8);
                SobotPostMsgActivity.this.mLlCompleted.setVisibility(0);
                SobotPostMsgActivity.this.mIsCreateSuccess = true;
                SobotPostMsgActivity.this.initData();
            }
        }
    }

    private void initReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new MessageReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SOBOT_ACTION_SHOW_COMPLETED_VIEW);
        LocalBroadcastManager.getInstance(getSobotBaseActivity()).registerReceiver(this.mReceiver, intentFilter);
    }

    private void showTicketInfo() {
        if (this.mFragments.size() > 0) {
            int size = this.mFragments.size() - 1;
            this.mViewPager.setCurrentItem(size);
            SobotBaseFragment sobotBaseFragment = this.mFragments.get(size);
            if (sobotBaseFragment instanceof SobotTicketInfoFragment) {
                ((SobotTicketInfoFragment) sobotBaseFragment).initData();
            }
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_post_msg");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("intent_key_uid");
            this.mConfig = (SobotLeaveMsgConfig) getIntent().getSerializableExtra(StPostMsgPresenter.INTENT_KEY_CONFIG);
            this.mGroupId = getIntent().getStringExtra(StPostMsgPresenter.INTENT_KEY_GROUPID);
            this.mCustomerId = getIntent().getStringExtra(StPostMsgPresenter.INTENT_KEY_CUSTOMERID);
            this.mCompanyId = getIntent().getStringExtra("intent_key_companyid");
            this.flag_exit_type = getIntent().getIntExtra(ZhiChiConstant.FLAG_EXIT_TYPE, -1);
            this.flag_exit_sdk = getIntent().getBooleanExtra(ZhiChiConstant.FLAG_EXIT_SDK, false);
            this.mIsShowTicket = getIntent().getBooleanExtra(StPostMsgPresenter.INTENT_KEY_IS_SHOW_TICKET, false);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        SobotLeaveMsgConfig sobotLeaveMsgConfig;
        ZhiChiInitModeBase zhiChiInitModeBase = (ZhiChiInitModeBase) SharedPreferencesUtil.getObject(this, ZhiChiConstant.sobot_last_current_initModel);
        if (zhiChiInitModeBase != null && ChatUtils.isFreeAccount(zhiChiInitModeBase.getAccountStatus())) {
            SobotFreeAccountTipDialog sobotFreeAccountTipDialog = new SobotFreeAccountTipDialog(this, new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotPostMsgActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotPostMsgActivity.this.sobotFreeAccountTipDialog.dismiss();
                    SobotPostMsgActivity.this.finish();
                }
            });
            this.sobotFreeAccountTipDialog = sobotFreeAccountTipDialog;
            if (sobotFreeAccountTipDialog != null && !sobotFreeAccountTipDialog.isShowing()) {
                this.sobotFreeAccountTipDialog.show();
            }
        }
        this.mFragments.clear();
        if (!this.mIsShowTicket) {
            if (this.mConfig == null) {
                Information information = (Information) SharedPreferencesUtil.getObject(this, ZhiChiConstant.sobot_last_current_info);
                SobotLeaveMsgConfig sobotLeaveMsgConfig2 = new SobotLeaveMsgConfig();
                this.mConfig = sobotLeaveMsgConfig2;
                sobotLeaveMsgConfig2.setEmailFlag(zhiChiInitModeBase.isEmailFlag());
                this.mConfig.setEmailShowFlag(zhiChiInitModeBase.isEmailShowFlag());
                this.mConfig.setEnclosureFlag(zhiChiInitModeBase.isEnclosureFlag());
                this.mConfig.setEnclosureShowFlag(zhiChiInitModeBase.isEnclosureShowFlag());
                this.mConfig.setTelFlag(zhiChiInitModeBase.isTelFlag());
                this.mConfig.setTelShowFlag(zhiChiInitModeBase.isTelShowFlag());
                this.mConfig.setTicketStartWay(zhiChiInitModeBase.isTicketStartWay());
                this.mConfig.setTicketShowFlag(zhiChiInitModeBase.isTicketShowFlag());
                this.mConfig.setCompanyId(zhiChiInitModeBase.getCompanyId());
                if (TextUtils.isEmpty(information.getLeaveMsgTemplateContent())) {
                    this.mConfig.setMsgTmp(zhiChiInitModeBase.getMsgTmp());
                } else {
                    this.mConfig.setMsgTmp(information.getLeaveMsgTemplateContent());
                }
                if (TextUtils.isEmpty(information.getLeaveMsgGuideContent())) {
                    this.mConfig.setMsgTxt(zhiChiInitModeBase.getMsgTxt());
                } else {
                    this.mConfig.setMsgTxt(information.getLeaveMsgGuideContent());
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("intent_key_uid", this.mUid);
            bundle.putString(StPostMsgPresenter.INTENT_KEY_GROUPID, this.mGroupId);
            bundle.putInt(ZhiChiConstant.FLAG_EXIT_TYPE, this.flag_exit_type);
            bundle.putBoolean(ZhiChiConstant.FLAG_EXIT_SDK, this.flag_exit_sdk);
            bundle.putSerializable(StPostMsgPresenter.INTENT_KEY_CONFIG, this.mConfig);
            bundle.putSerializable(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS, getIntent().getSerializableExtra(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS));
            if (this.mConfig != null) {
                SobotPostMsgFragment newInstance = SobotPostMsgFragment.newInstance(bundle);
                this.mPostMsgFragment = newInstance;
                this.mFragments.add(newInstance);
            }
        }
        if (this.mIsShowTicket || ((sobotLeaveMsgConfig = this.mConfig) != null && sobotLeaveMsgConfig.isTicketShowFlag())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("intent_key_uid", this.mUid);
            bundle2.putString("intent_key_companyid", this.mCompanyId);
            bundle2.putString(StPostMsgPresenter.INTENT_KEY_CUSTOMERID, this.mCustomerId);
            this.mFragments.add(SobotTicketInfoFragment.newInstance(bundle2));
        }
        SobotLeaveMsgConfig sobotLeaveMsgConfig3 = this.mConfig;
        if (sobotLeaveMsgConfig3 != null) {
            this.mTvTicket.setVisibility(sobotLeaveMsgConfig3.isTicketShowFlag() ? 0 : 8);
        }
        StViewPagerAdapter stViewPagerAdapter = new StViewPagerAdapter(this, getSupportFragmentManager(), new String[]{getResString("sobot_please_leave_a_message"), getResString("sobot_message_record")}, this.mFragments);
        this.mAdapter = stViewPagerAdapter;
        this.mViewPager.setAdapter(stViewPagerAdapter);
        SobotLeaveMsgConfig sobotLeaveMsgConfig4 = this.mConfig;
        if (sobotLeaveMsgConfig4 != null && sobotLeaveMsgConfig4.isTicketShowFlag() && !this.mIsShowTicket) {
            if (!this.mIsCreateSuccess) {
                this.mLlCompleted.setVisibility(0);
                this.mllContainer.setVisibility(0);
            }
            this.sobot_pst_indicator.setViewPager(this.mViewPager);
        }
        if (!this.mIsShowTicket) {
            getToolBar().setVisibility(8);
            return;
        }
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        setTitle(getResString("sobot_message_record"));
        showTicketInfo();
        getToolBar().setVisibility(0);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.mLlCompleted = (LinearLayout) findViewById(getResId("sobot_ll_completed"));
        this.mllContainer = (LinearLayout) findViewById(getResId("sobot_ll_container"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_ticket"));
        this.mTvTicket = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_leaveMsg_to_ticket"));
        TextView textView2 = (TextView) findViewById(getResId("sobot_tv_completed"));
        this.mTvCompleted = textView2;
        textView2.setText(ResourceUtils.getResString(this, "sobot_leaveMsg_create_complete"));
        this.mViewPager = (ViewPager) findViewById(getResId("sobot_viewPager"));
        this.sobot_pst_indicator = (PagerSlidingTab) findViewById(getResId("sobot_pst_indicator"));
        ImageView imageView = (ImageView) findViewById(getResId("sobot_pst_back_iv"));
        this.psgBackIv = imageView;
        if (imageView != null && SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4)) {
            ((LinearLayout.LayoutParams) this.psgBackIv.getLayoutParams()).leftMargin += 34;
        }
        TextView textView3 = (TextView) findViewById(getResId("sobot_tv_leaveMsg_create_success"));
        this.mTvLeaveMsgCreateSuccess = textView3;
        textView3.setText(ResourceUtils.getResString(this, "sobot_leavemsg_success_tip"));
        TextView textView4 = (TextView) findViewById(getResId("sobot_tv_leaveMsg_create_success_des"));
        this.mTvLeaveMsgCreateSuccessDes = textView4;
        textView4.setText(ResourceUtils.getResString(this, "sobot_leaveMsg_create_success_des"));
        this.mTvTicket.setOnClickListener(this);
        this.mTvCompleted.setOnClickListener(this);
        this.psgBackIv.setOnClickListener(this);
        initReceiver();
        if (SobotApi.getSwitchMarkStatus(1)) {
            ((LinearLayout.LayoutParams) this.mTvCompleted.getLayoutParams()).topMargin = ScreenUtils.dip2px(this, 40.0f);
        }
        displayInNotch(this.mllContainer);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SobotPostMsgFragment sobotPostMsgFragment = this.mPostMsgFragment;
        if (sobotPostMsgFragment != null) {
            sobotPostMsgFragment.onBackPress();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.mTvTicket) {
            this.mLlCompleted.setVisibility(8);
            this.mViewPager.setVisibility(0);
            SobotLeaveMsgConfig sobotLeaveMsgConfig = this.mConfig;
            if (sobotLeaveMsgConfig != null && sobotLeaveMsgConfig.isTicketShowFlag()) {
                this.mllContainer.setVisibility(0);
            }
            showTicketInfo();
        }
        if (view == this.mTvCompleted) {
            onBackPressed();
        }
        if (view == this.psgBackIv) {
            onBackPressed();
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getSobotBaseActivity()).unregisterReceiver(this.mReceiver);
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotBaseActivity(), SobotFunctionType.ZC_CloseLeave);
        }
        super.onDestroy();
    }
}
