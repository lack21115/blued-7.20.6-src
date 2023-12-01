package com.sobot.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotProvinAdapter;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.SobotCityResult;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotProvinInfo;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.dialog.SobotDialogUtils;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotChooseCityActivity.class */
public class SobotChooseCityActivity extends SobotDialogBaseActivity {
    private SobotProvinAdapter categoryAdapter;
    private SobotCusFieldConfig cusFieldConfig;
    private String mFiledId;
    private Bundle mIntentBundleData;
    private ListView mListView;
    private SobotProvinInfo mProvinInfo;
    private LinearLayout sobot_btn_cancle;
    private TextView sobot_tv_title;
    private SparseArray<List<SobotProvinInfo.SobotProvinceModel>> tmpMap = new SparseArray<>();
    private List<SobotProvinInfo.SobotProvinceModel> tmpDatas = new ArrayList();
    private int currentLevel = 1;
    private boolean isRunning = false;
    private SobotProvinInfo.SobotProvinceModel mFinalData = new SobotProvinInfo.SobotProvinceModel();

    /* JADX INFO: Access modifiers changed from: private */
    public void backPressed() {
        int i = this.currentLevel;
        if (i <= 1) {
            finish();
        } else if (this.isRunning) {
        } else {
            int i2 = i - 1;
            this.currentLevel = i2;
            notifyListData(this.tmpMap.get(i2));
        }
    }

    private void fillData(int i) {
        ArrayList arrayList = (ArrayList) this.tmpMap.get(i);
        if (arrayList != null) {
            notifyListData(arrayList);
        }
    }

    private void initIntent() {
        Bundle bundleExtra = getIntent().getBundleExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA);
        this.mIntentBundleData = bundleExtra;
        if (bundleExtra != null) {
            if (bundleExtra.getSerializable("cusFieldConfig") != null) {
                this.cusFieldConfig = (SobotCusFieldConfig) this.mIntentBundleData.getSerializable("cusFieldConfig");
            }
            this.mProvinInfo = (SobotProvinInfo) this.mIntentBundleData.getSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_PROVININFO);
        }
        SobotCusFieldConfig sobotCusFieldConfig = this.cusFieldConfig;
        if (sobotCusFieldConfig != null && !TextUtils.isEmpty(sobotCusFieldConfig.getFieldName())) {
            this.sobot_tv_title.setText(this.cusFieldConfig.getFieldName());
        }
        this.mFiledId = this.mIntentBundleData.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD_ID);
        SobotProvinInfo sobotProvinInfo = this.mProvinInfo;
        if (sobotProvinInfo == null || sobotProvinInfo.getProvinces() == null) {
            return;
        }
        this.currentLevel = 1;
        this.tmpMap.put(1, this.mProvinInfo.getProvinces());
    }

    private void notifyListData(List<SobotProvinInfo.SobotProvinceModel> list) {
        this.tmpDatas.clear();
        this.tmpDatas.addAll(list);
        SobotProvinAdapter sobotProvinAdapter = this.categoryAdapter;
        if (sobotProvinAdapter != null) {
            sobotProvinAdapter.notifyDataSetChanged();
            return;
        }
        SobotProvinAdapter sobotProvinAdapter2 = new SobotProvinAdapter(this, this, this.tmpDatas);
        this.categoryAdapter = sobotProvinAdapter2;
        this.mListView.setAdapter((ListAdapter) sobotProvinAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData(int i, SobotProvinInfo.SobotProvinceModel sobotProvinceModel) {
        if (i == 0) {
            this.mFinalData.provinceId = sobotProvinceModel.provinceId;
            this.mFinalData.provinceName = sobotProvinceModel.provinceName;
        } else if (i != 1) {
            this.mFinalData.areaId = sobotProvinceModel.areaId;
            this.mFinalData.areaName = sobotProvinceModel.areaName;
        } else {
            this.mFinalData.cityId = sobotProvinceModel.cityId;
            this.mFinalData.cityName = sobotProvinceModel.cityName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showData(List<SobotProvinInfo.SobotProvinceModel> list, SobotProvinInfo.SobotProvinceModel sobotProvinceModel) {
        saveData(sobotProvinceModel.level, sobotProvinceModel);
        int i = this.currentLevel + 1;
        this.currentLevel = i;
        this.tmpMap.put(i, list);
        fillData(this.currentLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDataWithLevel(final SobotProvinInfo.SobotProvinceModel sobotProvinceModel) {
        if (sobotProvinceModel == null) {
            fillData(1);
        } else if (this.isRunning) {
        } else {
            this.isRunning = true;
            ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(getBaseContext()).getZhiChiApi();
            String str = null;
            String str2 = sobotProvinceModel.level == 0 ? sobotProvinceModel.provinceId : null;
            if (sobotProvinceModel.level == 1) {
                str = sobotProvinceModel.cityId;
            }
            zhiChiApi.queryCity(this, str2, str, new StringResultCallBack<SobotCityResult>() { // from class: com.sobot.chat.activity.SobotChooseCityActivity.3
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str3) {
                    SobotChooseCityActivity.this.isRunning = false;
                    SobotDialogUtils.stopProgressDialog(SobotChooseCityActivity.this);
                    ToastUtil.showToast(SobotChooseCityActivity.this.getApplicationContext(), str3);
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(SobotCityResult sobotCityResult) {
                    SobotChooseCityActivity.this.isRunning = false;
                    SobotProvinInfo data = sobotCityResult.getData();
                    if (data.getCitys() != null && data.getCitys().size() > 0) {
                        SobotChooseCityActivity.this.showData(data.getCitys(), sobotProvinceModel);
                    }
                    if (data.getAreas() == null || data.getAreas().size() <= 0) {
                        return;
                    }
                    SobotChooseCityActivity.this.showData(data.getAreas(), sobotProvinceModel);
                }
            });
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_activity_cusfield");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        initIntent();
        SobotProvinInfo sobotProvinInfo = this.mProvinInfo;
        if (sobotProvinInfo == null || sobotProvinInfo.getProvinces() == null) {
            return;
        }
        showDataWithLevel(null);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.sobot_btn_cancle = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        this.sobot_tv_title = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        ListView listView = (ListView) findViewById(ResourceUtils.getResId(getBaseContext(), "sobot_activity_cusfield_listview"));
        this.mListView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.activity.SobotChooseCityActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                SobotProvinInfo.SobotProvinceModel sobotProvinceModel = (SobotProvinInfo.SobotProvinceModel) SobotChooseCityActivity.this.tmpDatas.get(i);
                if (sobotProvinceModel.nodeFlag) {
                    SobotChooseCityActivity.this.showDataWithLevel(sobotProvinceModel);
                    return;
                }
                SobotChooseCityActivity sobotChooseCityActivity = SobotChooseCityActivity.this;
                sobotChooseCityActivity.saveData(sobotChooseCityActivity.currentLevel - 1, sobotProvinceModel);
                Intent intent = new Intent();
                intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_PROVININFO, SobotChooseCityActivity.this.mFinalData);
                intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD_ID, SobotChooseCityActivity.this.mFiledId);
                SobotChooseCityActivity.this.setResult(106, intent);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ((List) SobotChooseCityActivity.this.tmpMap.get(SobotChooseCityActivity.this.currentLevel)).size()) {
                        SobotChooseCityActivity.this.categoryAdapter.notifyDataSetChanged();
                        SobotChooseCityActivity.this.finish();
                        return;
                    }
                    ((SobotProvinInfo.SobotProvinceModel) SobotChooseCityActivity.this.tmpDatas.get(i3)).isChecked = i3 == i;
                    i2 = i3 + 1;
                }
            }
        });
        this.sobot_btn_cancle.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotChooseCityActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChooseCityActivity.this.backPressed();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        backPressed();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SobotDialogUtils.stopProgressDialog(this);
        super.onDestroy();
    }
}
