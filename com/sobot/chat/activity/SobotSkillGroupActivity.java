package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotSikllAdapter;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotConnCusParam;
import com.sobot.chat.api.model.ZhiChiGroup;
import com.sobot.chat.api.model.ZhiChiGroupBase;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.attachment.SpaceItemDecoration;
import com.sobot.chat.widget.horizontalgridpage.SobotRecyclerCallBack;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotSkillGroupActivity.class */
public class SobotSkillGroupActivity extends SobotDialogBaseActivity {
    private boolean flag_exit_sdk;
    private StPostMsgPresenter mPressenter;
    private SobotConnCusParam param;
    private SobotSikllAdapter sobotSikllAdapter;
    private LinearLayout sobot_btn_cancle;
    private RecyclerView sobot_rcy_skill;
    private TextView sobot_tv_title;
    private int transferType;
    private ZhiChiApi zhiChiApi;
    private List<ZhiChiGroupBase> list_skill = new ArrayList();
    private String uid = null;
    private String companyId = null;
    private String customerId = null;
    private String appkey = null;
    private String msgTmp = null;
    private String msgTxt = null;
    private int mType = -1;
    private int msgFlag = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPageOrSDK() {
        Context applicationContext = getApplicationContext();
        if (SharedPreferencesUtil.getIntData(applicationContext, this.appkey + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.initType, -1) == 2) {
            finish();
            sendCloseIntent(1);
        } else if (this.flag_exit_sdk) {
            MyApplication.getInstance().exit();
        } else {
            finish();
            sendCloseIntent(2);
        }
    }

    private void sendCloseIntent(int i) {
        Intent intent = new Intent();
        if (i == 1) {
            intent.setAction(ZhiChiConstants.sobot_close_now_clear_cache);
        } else {
            intent.setAction(ZhiChiConstants.sobot_click_cancle);
        }
        CommonUtils.sendLocalBroadcast(getApplicationContext(), intent);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_activity_skill_group");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        if (getIntent() != null) {
            this.uid = getIntent().getStringExtra("uid");
            this.companyId = getIntent().getStringExtra("companyId");
            this.customerId = getIntent().getStringExtra("customerId");
            this.appkey = getIntent().getStringExtra("appkey");
            this.flag_exit_sdk = getIntent().getBooleanExtra(ZhiChiConstant.FLAG_EXIT_SDK, false);
            this.mType = getIntent().getIntExtra("type", -1);
            this.msgTmp = getIntent().getStringExtra("msgTmp");
            this.msgTxt = getIntent().getStringExtra("msgTxt");
            this.msgFlag = getIntent().getIntExtra("msgFlag", 0);
            this.transferType = getIntent().getIntExtra("transferType", 0);
            this.param = (SobotConnCusParam) getIntent().getSerializableExtra("sobotConnCusParam");
        }
        ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(getApplicationContext()).getZhiChiApi();
        this.zhiChiApi = zhiChiApi;
        zhiChiApi.getGroupList(this, this.appkey, this.uid, new StringResultCallBack<ZhiChiGroup>() { // from class: com.sobot.chat.activity.SobotSkillGroupActivity.3
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                SobotSkillGroupActivity.this.sobot_tv_title.setText(ResourceUtils.getResString(SobotSkillGroupActivity.this, "sobot_switch_robot_title_2"));
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiGroup zhiChiGroup) {
                SobotSkillGroupActivity.this.list_skill = zhiChiGroup.getData();
                if (SobotSkillGroupActivity.this.list_skill == null || SobotSkillGroupActivity.this.list_skill.size() <= 0 || SobotSkillGroupActivity.this.sobotSikllAdapter == null) {
                    SobotSkillGroupActivity.this.sobot_tv_title.setText(ResourceUtils.getResString(SobotSkillGroupActivity.this, "sobot_switch_robot_title_2"));
                    return;
                }
                if (((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(0)).getGroupStyle() == 1) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(SobotSkillGroupActivity.this, 4);
                    SobotSkillGroupActivity.this.sobot_rcy_skill.addItemDecoration(new SpaceItemDecoration(ScreenUtils.dip2px(SobotSkillGroupActivity.this, 10.0f), ScreenUtils.dip2px(SobotSkillGroupActivity.this, 10.0f), 0, 1));
                    SobotSkillGroupActivity.this.sobot_rcy_skill.setLayoutManager(gridLayoutManager);
                } else if (((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(0)).getGroupStyle() == 2) {
                    SobotSkillGroupActivity.this.sobot_rcy_skill.setLayoutManager(new LinearLayoutManager(SobotSkillGroupActivity.this));
                } else {
                    GridLayoutManager gridLayoutManager2 = new GridLayoutManager(SobotSkillGroupActivity.this, 2);
                    SobotSkillGroupActivity.this.sobot_rcy_skill.addItemDecoration(new SpaceItemDecoration(ScreenUtils.dip2px(SobotSkillGroupActivity.this, 10.0f), ScreenUtils.dip2px(SobotSkillGroupActivity.this, 10.0f), 0, 1));
                    SobotSkillGroupActivity.this.sobot_rcy_skill.setLayoutManager(gridLayoutManager2);
                }
                SobotSkillGroupActivity.this.sobotSikllAdapter.setList(SobotSkillGroupActivity.this.list_skill);
                SobotSkillGroupActivity.this.sobotSikllAdapter.setMsgFlag(SobotSkillGroupActivity.this.msgFlag);
                SobotSkillGroupActivity.this.sobotSikllAdapter.notifyDataSetChanged();
                if (TextUtils.isEmpty(((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(0)).getGroupGuideDoc())) {
                    SobotSkillGroupActivity.this.sobot_tv_title.setText(ResourceUtils.getResString(SobotSkillGroupActivity.this, "sobot_switch_robot_title_2"));
                } else {
                    SobotSkillGroupActivity.this.sobot_tv_title.setText(((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(0)).getGroupGuideDoc());
                }
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.sobot_tv_title = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        this.mPressenter = StPostMsgPresenter.newInstance(this, this);
        this.sobot_btn_cancle = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        this.sobot_rcy_skill = (RecyclerView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_rcy_skill"));
        SobotSikllAdapter sobotSikllAdapter = new SobotSikllAdapter(this, this.list_skill, this.msgFlag, new SobotRecyclerCallBack() { // from class: com.sobot.chat.activity.SobotSkillGroupActivity.1
            @Override // com.sobot.chat.widget.horizontalgridpage.SobotRecyclerCallBack
            public void onItemClickListener(View view, int i) {
                if (SobotSkillGroupActivity.this.list_skill == null || SobotSkillGroupActivity.this.list_skill.size() <= 0) {
                    return;
                }
                if (!"true".equals(((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(i)).isOnline())) {
                    if (SobotSkillGroupActivity.this.msgFlag == 0) {
                        Intent intent = new Intent();
                        intent.putExtra("toLeaveMsg", true);
                        intent.putExtra("groupIndex", i);
                        SobotSkillGroupActivity.this.setResult(100, intent);
                        SobotSkillGroupActivity.this.finish();
                    }
                } else if (TextUtils.isEmpty(((ZhiChiGroupBase) SobotSkillGroupActivity.this.list_skill.get(i)).getGroupName())) {
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("groupIndex", i);
                    intent2.putExtra("transferType", SobotSkillGroupActivity.this.transferType);
                    if (SobotSkillGroupActivity.this.param != null) {
                        intent2.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID, SobotSkillGroupActivity.this.param.getDocId());
                        intent2.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION, SobotSkillGroupActivity.this.param.getUnknownQuestion());
                        intent2.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER, SobotSkillGroupActivity.this.param.getActiveTransfer());
                        intent2.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD, SobotSkillGroupActivity.this.param.getKeyword());
                        intent2.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID, SobotSkillGroupActivity.this.param.getKeywordId());
                    }
                    SobotSkillGroupActivity.this.setResult(100, intent2);
                    SobotSkillGroupActivity.this.finish();
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.SobotRecyclerCallBack
            public void onItemLongClickListener(View view, int i) {
            }
        });
        this.sobotSikllAdapter = sobotSikllAdapter;
        this.sobot_rcy_skill.setAdapter(sobotSikllAdapter);
        this.sobot_btn_cancle.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotSkillGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotSkillGroupActivity.this.finishPageOrSDK();
            }
        });
        displayInNotch(this, this.sobot_rcy_skill);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 200) {
            finish();
        }
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishPageOrSDK();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mPressenter.destory();
        HttpUtils.getInstance().cancelTag(this);
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || motionEvent.getY() > 0.0f) {
            return true;
        }
        finishPageOrSDK();
        return true;
    }
}
