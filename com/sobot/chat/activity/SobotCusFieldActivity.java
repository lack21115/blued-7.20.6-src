package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotCusFieldAdapter;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotCusFieldDataInfo;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotCusFieldActivity.class */
public class SobotCusFieldActivity extends SobotDialogBaseActivity {
    private SobotCusFieldAdapter adapter;
    private Bundle bundle;
    private SobotCusFieldConfig cusFieldConfig;
    private String fieldId;
    private int fieldType;
    private ListView mListView;
    private SobotFieldModel model;
    private float screenHeight70;
    private LinearLayout sobot_btn_cancle;
    private Button sobot_btn_submit;
    private EditText sobot_et_search;
    private LinearLayout sobot_ll_search;
    private LinearLayout sobot_ll_submit;
    private TextView sobot_tv_title;
    private List<SobotCusFieldDataInfo> infoLists = new ArrayList();
    private StringBuffer dataName = new StringBuffer();
    private StringBuffer dataValue = new StringBuffer();

    private String[] convertStrToArray(String str) {
        return str.split(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPageOrSDK() {
        String onlyStringData = SharedPreferencesUtil.getOnlyStringData(getBaseContext(), ZhiChiConstant.sobot_last_current_appkey, "");
        Context applicationContext = getApplicationContext();
        if (SharedPreferencesUtil.getIntData(applicationContext, onlyStringData + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.initType, -1) == 2) {
            finish();
            sendCloseIntent(1);
            return;
        }
        finish();
        sendCloseIntent(2);
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

    private void setListViewHeight(ListView listView, int i, int i2) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        View view = adapter.getView(0, null, listView);
        view.measure(0, 0);
        int measuredHeight = view.getMeasuredHeight() * adapter.getCount();
        listView.setLayoutParams(this.screenHeight70 < ((float) (ScreenUtils.dip2px(this, 60.0f) + measuredHeight)) ? new LinearLayout.LayoutParams(-1, (int) (this.screenHeight70 - ScreenUtils.dip2px(this, 60.0f))) : new LinearLayout.LayoutParams(-1, measuredHeight));
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_activity_cusfield");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        String[] convertStrToArray;
        Bundle bundleExtra = getIntent().getBundleExtra(TTLiveConstants.BUNDLE_KEY);
        this.bundle = bundleExtra;
        if (bundleExtra != null) {
            this.fieldType = bundleExtra.getInt("fieldType");
            if (this.bundle.getSerializable("cusFieldConfig") != null) {
                this.cusFieldConfig = (SobotCusFieldConfig) this.bundle.getSerializable("cusFieldConfig");
            }
            if (this.bundle.getSerializable("cusFieldList") != null) {
                this.model = (SobotFieldModel) this.bundle.getSerializable("cusFieldList");
            }
        }
        SobotCusFieldConfig sobotCusFieldConfig = this.cusFieldConfig;
        if (sobotCusFieldConfig != null && !TextUtils.isEmpty(sobotCusFieldConfig.getFieldName())) {
            this.sobot_tv_title.setText(this.cusFieldConfig.getFieldName());
        }
        int i = this.fieldType;
        if (7 == i) {
            this.sobot_ll_submit.setVisibility(0);
            this.sobot_ll_search.setVisibility(8);
        } else if (6 == i) {
            this.sobot_ll_submit.setVisibility(8);
            this.sobot_ll_search.setVisibility(0);
        }
        SobotFieldModel sobotFieldModel = this.model;
        if (sobotFieldModel == null || sobotFieldModel.getCusFieldDataInfoList().size() == 0) {
            return;
        }
        this.infoLists = this.model.getCusFieldDataInfoList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.infoLists.size()) {
                break;
            }
            if (7 == this.fieldType) {
                if (!TextUtils.isEmpty(this.cusFieldConfig.getId()) && (convertStrToArray = convertStrToArray(this.cusFieldConfig.getValue())) != null && convertStrToArray.length != 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < convertStrToArray.length) {
                            if (convertStrToArray[i5].equals(this.infoLists.get(i3).getDataValue())) {
                                this.infoLists.get(i3).setChecked(true);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(this.cusFieldConfig.getId()) && this.cusFieldConfig.getFieldId().equals(this.infoLists.get(i3).getFieldId()) && this.cusFieldConfig.isChecked() && this.cusFieldConfig.getValue().equals(this.infoLists.get(i3).getDataValue())) {
                this.infoLists.get(i3).setChecked(true);
            }
            i2 = i3 + 1;
        }
        SobotCusFieldAdapter sobotCusFieldAdapter = this.adapter;
        if (sobotCusFieldAdapter == null) {
            SobotCusFieldAdapter sobotCusFieldAdapter2 = new SobotCusFieldAdapter(this, this, this.infoLists, this.fieldType);
            this.adapter = sobotCusFieldAdapter2;
            this.mListView.setAdapter((ListAdapter) sobotCusFieldAdapter2);
        } else {
            sobotCusFieldAdapter.notifyDataSetChanged();
        }
        setListViewHeight(this.mListView, 5, 0);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.screenHeight70 = ScreenUtils.getScreenHeight(this) * 0.7f;
        this.sobot_tv_title = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        this.sobot_btn_cancle = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        EditText editText = (EditText) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_et_search"));
        this.sobot_et_search = editText;
        editText.setHint(ResourceUtils.getResString(this, "sobot_search"));
        this.sobot_ll_search = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_ll_search"));
        Button button = (Button) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_submit"));
        this.sobot_btn_submit = button;
        button.setText(ResourceUtils.getResString(this, "sobot_btn_submit"));
        this.sobot_ll_submit = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_ll_submit"));
        ListView listView = (ListView) findViewById(ResourceUtils.getResId(getBaseContext(), "sobot_activity_cusfield_listview"));
        this.mListView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.activity.SobotCusFieldActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (SobotCusFieldActivity.this.infoLists == null || SobotCusFieldActivity.this.infoLists.size() == 0) {
                    return;
                }
                if (SobotCusFieldActivity.this.fieldType == 7) {
                    SobotCusFieldActivity.this.dataName.delete(0, SobotCusFieldActivity.this.dataName.length());
                    SobotCusFieldActivity.this.dataValue.delete(0, SobotCusFieldActivity.this.dataValue.length());
                    if (((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).isChecked()) {
                        ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).setChecked(false);
                    } else {
                        ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).setChecked(true);
                    }
                    SobotCusFieldActivity sobotCusFieldActivity = SobotCusFieldActivity.this;
                    sobotCusFieldActivity.fieldId = ((SobotCusFieldDataInfo) sobotCusFieldActivity.infoLists.get(0)).getFieldId();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= SobotCusFieldActivity.this.infoLists.size()) {
                            SobotCusFieldActivity.this.adapter.notifyDataSetChanged();
                            return;
                        }
                        if (((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i3)).isChecked()) {
                            SobotCusFieldActivity.this.dataName.append(((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i3)).getDataName() + ",");
                            SobotCusFieldActivity.this.dataValue.append(((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i3)).getDataValue() + ",");
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("CATEGORYSMALL", "CATEGORYSMALL");
                    intent.putExtra("fieldType", SobotCusFieldActivity.this.fieldType);
                    ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).setChecked(true);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= SobotCusFieldActivity.this.infoLists.size()) {
                            intent.putExtra("category_typeName", ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).getDataName());
                            intent.putExtra("category_fieldId", ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).getFieldId());
                            intent.putExtra("category_typeValue", ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i)).getDataValue());
                            SobotCusFieldActivity.this.setResult(304, intent);
                            SobotCusFieldActivity.this.adapter.notifyDataSetChanged();
                            SobotCusFieldActivity.this.finish();
                            return;
                        }
                        if (i5 != i) {
                            ((SobotCusFieldDataInfo) SobotCusFieldActivity.this.infoLists.get(i5)).setChecked(false);
                        }
                        i4 = i5 + 1;
                    }
                }
            }
        });
        this.sobot_btn_cancle.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotCusFieldActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotCusFieldActivity.this.finishPageOrSDK();
            }
        });
        this.sobot_btn_submit.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotCusFieldActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotCusFieldActivity.this.onSumbitClick();
            }
        });
        this.sobot_et_search.addTextChangedListener(new TextWatcher() { // from class: com.sobot.chat.activity.SobotCusFieldActivity.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (SobotCusFieldActivity.this.adapter == null) {
                    return;
                }
                SobotCusFieldActivity.this.adapter.getFilter().filter(charSequence);
            }
        });
        displayInNotch(this, this.sobot_et_search);
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishPageOrSDK();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        HttpUtils.getInstance().cancelTag(this);
        MyApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initData();
    }

    protected void onSumbitClick() {
        if (this.dataName.length() == 0 || this.fieldId.length() == 0 || this.dataValue.length() == 0) {
            Intent intent = new Intent();
            intent.putExtra("CATEGORYSMALL", "CATEGORYSMALL");
            intent.putExtra("fieldType", this.fieldType);
            intent.putExtra("category_typeName", "");
            intent.putExtra("category_typeValue", "");
            intent.putExtra("category_fieldId", this.fieldId + "");
            setResult(304, intent);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("CATEGORYSMALL", "CATEGORYSMALL");
            intent2.putExtra("fieldType", this.fieldType);
            intent2.putExtra("category_typeName", ((Object) this.dataName) + "");
            intent2.putExtra("category_typeValue", ((Object) this.dataValue) + "");
            intent2.putExtra("category_fieldId", this.fieldId + "");
            setResult(304, intent2);
        }
        finish();
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
