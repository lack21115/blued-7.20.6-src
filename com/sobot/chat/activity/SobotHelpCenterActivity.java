package com.sobot.chat.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseHelpCenterActivity;
import com.sobot.chat.adapter.SobotHelpCenterAdapter;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.SobotFunctionType;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.SobotAutoGridView;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotHelpCenterActivity.class */
public class SobotHelpCenterActivity extends SobotBaseHelpCenterActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private SobotHelpCenterAdapter mAdapter;
    private View mBottomBtn;
    private View mEmptyView;
    private SobotAutoGridView mGridView;
    private TextView tvNoData;
    private TextView tvNoDataDescribe;
    private TextView tvOnlineService;
    private TextView tv_sobot_layout_online_service;
    private TextView tv_sobot_layout_online_tel;

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_help_center");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        SobotMsgManager.getInstance(getApplicationContext()).getZhiChiApi().getCategoryList(this, this.mInfo.getApp_key(), new StringResultCallBack<List<StCategoryModel>>() { // from class: com.sobot.chat.activity.SobotHelpCenterActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotHelpCenterActivity.this.getApplicationContext(), str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<StCategoryModel> list) {
                if (list == null || list.size() <= 0) {
                    SobotHelpCenterActivity.this.mEmptyView.setVisibility(0);
                    SobotHelpCenterActivity.this.mGridView.setVisibility(8);
                    return;
                }
                SobotHelpCenterActivity.this.mEmptyView.setVisibility(8);
                SobotHelpCenterActivity.this.mGridView.setVisibility(0);
                if (SobotHelpCenterActivity.this.mAdapter == null) {
                    SobotHelpCenterActivity.this.mAdapter = new SobotHelpCenterAdapter(SobotHelpCenterActivity.this.getApplicationContext(), list);
                    SobotHelpCenterActivity.this.mGridView.setAdapter((ListAdapter) SobotHelpCenterActivity.this.mAdapter);
                    return;
                }
                List<StCategoryModel> datas = SobotHelpCenterActivity.this.mAdapter.getDatas();
                datas.clear();
                datas.addAll(list);
                SobotHelpCenterActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        setTitle(getResString("sobot_help_center_title"));
        showLeftMenu(getResDrawableId("sobot_btn_back_grey_selector"), "", true);
        this.mEmptyView = findViewById(getResId("ll_empty_view"));
        this.mBottomBtn = findViewById(getResId("ll_bottom"));
        this.tv_sobot_layout_online_service = (TextView) findViewById(getResId("tv_sobot_layout_online_service"));
        this.tv_sobot_layout_online_tel = (TextView) findViewById(getResId("tv_sobot_layout_online_tel"));
        this.mGridView = (SobotAutoGridView) findViewById(getResId("sobot_gv"));
        TextView textView = (TextView) findViewById(getResId("tv_sobot_help_center_no_data"));
        this.tvNoData = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_help_center_no_data"));
        TextView textView2 = (TextView) findViewById(getResId("tv_sobot_help_center_no_data_describe"));
        this.tvNoDataDescribe = textView2;
        textView2.setText(ResourceUtils.getResString(this, "sobot_help_center_no_data_describe"));
        TextView textView3 = (TextView) findViewById(getResId("tv_sobot_layout_online_service"));
        this.tvOnlineService = textView3;
        textView3.setText(ResourceUtils.getResString(this, "sobot_help_center_online_service"));
        this.tv_sobot_layout_online_service.setOnClickListener(this);
        this.tv_sobot_layout_online_tel.setOnClickListener(this);
        this.mGridView.setOnItemClickListener(this);
        if (this.mInfo == null || TextUtils.isEmpty(this.mInfo.getHelpCenterTelTitle()) || TextUtils.isEmpty(this.mInfo.getHelpCenterTel())) {
            this.tv_sobot_layout_online_tel.setVisibility(8);
        } else {
            this.tv_sobot_layout_online_tel.setVisibility(0);
            this.tv_sobot_layout_online_tel.setText(this.mInfo.getHelpCenterTelTitle());
        }
        displayInNotch(this.mGridView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.tv_sobot_layout_online_service) {
            SobotApi.startSobotChat(getApplicationContext(), this.mInfo);
        }
        if (view != this.tv_sobot_layout_online_tel || TextUtils.isEmpty(this.mInfo.getHelpCenterTel())) {
            return;
        }
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotBaseActivity(), SobotFunctionType.ZC_PhoneCustomerService);
        }
        ChatUtils.callUp(this.mInfo.getHelpCenterTel(), getSobotBaseActivity());
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotBaseActivity(), SobotFunctionType.ZC_CloseHelpCenter);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        startActivity(SobotProblemCategoryActivity.newIntent(getApplicationContext(), this.mInfo, this.mAdapter.getDatas().get(i)));
    }
}
