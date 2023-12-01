package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotBaseHelpCenterActivity;
import com.sobot.chat.adapter.SobotCategoryAdapter;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotProblemCategoryActivity.class */
public class SobotProblemCategoryActivity extends SobotBaseHelpCenterActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_KEY_CATEGORY = "EXTRA_KEY_CATEGORY";
    private SobotCategoryAdapter mAdapter;
    private StCategoryModel mCategory;
    private TextView mEmpty;
    private ListView mListView;

    public static Intent newIntent(Context context, Information information, StCategoryModel stCategoryModel) {
        Intent intent = new Intent(context, SobotProblemCategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO, information);
        intent.putExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
        intent.putExtra(EXTRA_KEY_CATEGORY, stCategoryModel);
        return intent;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_problem_category");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseHelpCenterActivity, com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        super.initBundleData(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mCategory = (StCategoryModel) intent.getSerializableExtra(EXTRA_KEY_CATEGORY);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        SobotMsgManager.getInstance(getApplicationContext()).getZhiChiApi().getHelpDocByCategoryId(this, this.mCategory.getAppId(), this.mCategory.getCategoryId(), new StringResultCallBack<List<StDocModel>>() { // from class: com.sobot.chat.activity.SobotProblemCategoryActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotProblemCategoryActivity.this.getApplicationContext(), str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<StDocModel> list) {
                if (list != null) {
                    if (SobotProblemCategoryActivity.this.mAdapter == null) {
                        SobotProblemCategoryActivity.this.mAdapter = new SobotCategoryAdapter(SobotProblemCategoryActivity.this.getApplicationContext(), SobotProblemCategoryActivity.this, list);
                        SobotProblemCategoryActivity.this.mListView.setAdapter((ListAdapter) SobotProblemCategoryActivity.this.mAdapter);
                    } else {
                        List<StDocModel> datas = SobotProblemCategoryActivity.this.mAdapter.getDatas();
                        datas.clear();
                        datas.addAll(list);
                        SobotProblemCategoryActivity.this.mAdapter.notifyDataSetChanged();
                    }
                }
                if (list == null || list.size() == 0) {
                    SobotProblemCategoryActivity.this.mEmpty.setVisibility(0);
                    SobotProblemCategoryActivity.this.mListView.setVisibility(8);
                    return;
                }
                SobotProblemCategoryActivity.this.mEmpty.setVisibility(8);
                SobotProblemCategoryActivity.this.mListView.setVisibility(0);
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_grey_selector"), "", true);
        this.mListView = (ListView) findViewById(getResId("sobot_listview"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_empty"));
        this.mEmpty = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_no_content"));
        setTitle(this.mCategory.getCategoryName());
        this.mListView.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        startActivity(SobotProblemDetailActivity.newIntent(getApplicationContext(), this.mInfo, this.mAdapter.getDatas().get(i)));
    }
}
