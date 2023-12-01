package com.sobot.chat.widget.dialog;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotPostMsgTmpListAdapter;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotPostMsgTmpListActivity.class */
public class SobotPostMsgTmpListActivity extends SobotDialogBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayList<SobotPostMsgTemplate> mDatas;
    private SobotPostMsgTmpListAdapter mListAdapter;
    private GridView sobot_gv;
    private LinearLayout sobot_negativeButton;
    private TextView sobot_tv_title;

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(getContext(), "sobot_layout_post_msg_tmps");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        this.mDatas = (ArrayList) getIntent().getSerializableExtra("sobotPostMsgTemplateList");
        if (this.mListAdapter == null) {
            SobotPostMsgTmpListAdapter sobotPostMsgTmpListAdapter = new SobotPostMsgTmpListAdapter(getContext(), this.mDatas);
            this.mListAdapter = sobotPostMsgTmpListAdapter;
            this.sobot_gv.setAdapter((ListAdapter) sobotPostMsgTmpListAdapter);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.sobot_negativeButton = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        GridView gridView = (GridView) findViewById(getResId("sobot_gv"));
        this.sobot_gv = gridView;
        gridView.setOnItemClickListener(this);
        this.sobot_negativeButton.setOnClickListener(this);
        TextView textView = (TextView) findViewById(getResId("sobot_tv_title"));
        this.sobot_tv_title = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_choice_business"));
        displayInNotch(this, this.sobot_gv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_negativeButton) {
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        this.zhiChiApi.getMsgTemplateConfig(getContext(), getIntent().getStringExtra("uid"), ((SobotPostMsgTemplate) this.mListAdapter.getItem(i)).getTemplateId(), new StringResultCallBack<SobotLeaveMsgConfig>() { // from class: com.sobot.chat.widget.dialog.SobotPostMsgTmpListActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotLeaveMsgConfig sobotLeaveMsgConfig) {
                if (sobotLeaveMsgConfig != null) {
                    Intent intent = new Intent();
                    intent.setAction(ZhiChiConstants.SOBOT_POST_MSG_TMP_BROCAST);
                    intent.putExtra("sobotLeaveMsgConfig", sobotLeaveMsgConfig);
                    intent.putExtra("uid", SobotPostMsgTmpListActivity.this.getIntent().getStringExtra("uid"));
                    intent.putExtra("mflag_exit_sdk", SobotPostMsgTmpListActivity.this.getIntent().getBooleanExtra("flag_exit_sdk", false));
                    intent.putExtra("mIsShowTicket", SobotPostMsgTmpListActivity.this.getIntent().getBooleanExtra("isShowTicket", false));
                    CommonUtils.sendLocalBroadcast(SobotPostMsgTmpListActivity.this.getContext(), intent);
                    SobotPostMsgTmpListActivity.this.finish();
                }
            }
        });
    }
}
