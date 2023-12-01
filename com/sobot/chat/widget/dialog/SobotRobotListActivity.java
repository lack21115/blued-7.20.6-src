package com.sobot.chat.widget.dialog;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotRobotListAdapter;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotRobotListActivity.class */
public class SobotRobotListActivity extends SobotDialogBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private final String CANCEL_TAG = SobotRobotListActivity.class.getSimpleName();
    private SobotRobotListAdapter mListAdapter;
    private String mRobotFlag;
    private String mUid;
    private GridView sobot_gv;
    private LinearLayout sobot_negativeButton;
    private TextView sobot_tv_title;

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_layout_switch_robot");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        this.mUid = getIntent().getStringExtra("partnerid");
        this.mRobotFlag = getIntent().getStringExtra("robotFlag");
        SobotMsgManager.getInstance(getBaseContext()).getZhiChiApi().getRobotSwitchList(this.CANCEL_TAG, this.mUid, new StringResultCallBack<List<SobotRobot>>() { // from class: com.sobot.chat.widget.dialog.SobotRobotListActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<SobotRobot> list) {
                Iterator<SobotRobot> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SobotRobot next = it.next();
                    if (next.getRobotFlag() != null && next.getRobotFlag().equals(SobotRobotListActivity.this.mRobotFlag)) {
                        next.setSelected(true);
                        break;
                    }
                }
                if (SobotRobotListActivity.this.mListAdapter == null) {
                    SobotRobotListActivity.this.mListAdapter = new SobotRobotListAdapter(SobotRobotListActivity.this.getBaseContext(), list);
                    SobotRobotListActivity.this.sobot_gv.setAdapter((ListAdapter) SobotRobotListActivity.this.mListAdapter);
                    return;
                }
                List datas = SobotRobotListActivity.this.mListAdapter.getDatas();
                datas.clear();
                datas.addAll(list);
                SobotRobotListActivity.this.mListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        this.sobot_negativeButton = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_title"));
        this.sobot_tv_title = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_switch_robot_title"));
        GridView gridView = (GridView) findViewById(getResId("sobot_gv"));
        this.sobot_gv = gridView;
        gridView.setOnItemClickListener(this);
        this.sobot_negativeButton.setOnClickListener(this);
        displayInNotch(this, this.sobot_gv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_negativeButton) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        HttpUtils.getInstance().cancelTag(this.CANCEL_TAG);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        SobotRobot sobotRobot = (SobotRobot) this.mListAdapter.getItem(i);
        if (sobotRobot.getRobotFlag() == null || sobotRobot.getRobotFlag().equals(this.mRobotFlag)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("sobotRobot", sobotRobot);
        setResult(-1, intent);
        finish();
    }
}
