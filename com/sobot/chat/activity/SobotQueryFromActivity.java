package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.PhoneAccount;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.SobotCityResult;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotProvinInfo;
import com.sobot.chat.api.model.SobotQueryFormModel;
import com.sobot.chat.listener.ISobotCusField;
import com.sobot.chat.presenter.StCusFieldPresenter;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.dialog.SobotDialogUtils;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotQueryFromActivity.class */
public class SobotQueryFromActivity extends SobotBaseActivity implements View.OnClickListener, ISobotCusField {
    private boolean isSubmitting = false;
    private String mActiveTransfer;
    private String mDocId;
    private ArrayList<SobotFieldModel> mField;
    private SobotProvinInfo.SobotProvinceModel mFinalData;
    private String mGroupId;
    private String mGroupName;
    private Bundle mIntentBundleData;
    private String mKeyword;
    private String mKeywordId;
    private SobotQueryFormModel mQueryFormModel;
    private int mTransferType;
    private String mUid;
    private String mUnknownQuestion;
    private Button sobot_btn_submit;
    private LinearLayout sobot_container;
    private TextView sobot_tv_doc;
    private TextView sobot_tv_safety;

    private void backPressed() {
        setResult(105, new Intent());
        finish();
    }

    private boolean checkInput(ArrayList<SobotFieldModel> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return true;
            }
            if (arrayList.get(i2).getCusFieldConfig() != null) {
                if (1 == arrayList.get(i2).getCusFieldConfig().getFillFlag()) {
                    if ("city".equals(arrayList.get(i2).getCusFieldConfig().getFieldId())) {
                        if (arrayList.get(i2).getCusFieldConfig().getProvinceModel() == null) {
                            Context applicationContext = getApplicationContext();
                            ToastUtil.showToast(applicationContext, arrayList.get(i2).getCusFieldConfig().getFieldName() + "  " + getResString("sobot__is_null"));
                            return false;
                        }
                    } else if (TextUtils.isEmpty(arrayList.get(i2).getCusFieldConfig().getValue())) {
                        Context applicationContext2 = getApplicationContext();
                        ToastUtil.showToast(applicationContext2, arrayList.get(i2).getCusFieldConfig().getFieldName() + "  " + getResString("sobot__is_null"));
                        return false;
                    }
                }
                if ("email".equals(arrayList.get(i2).getCusFieldConfig().getFieldId()) && !TextUtils.isEmpty(arrayList.get(i2).getCusFieldConfig().getValue()) && !ScreenUtils.isEmail(arrayList.get(i2).getCusFieldConfig().getValue())) {
                    ToastUtil.showToast(getApplicationContext(), getResString("sobot_email_dialog_hint"));
                    return false;
                } else if (PhoneAccount.SCHEME_TEL.equals(arrayList.get(i2).getCusFieldConfig().getFieldId()) && !TextUtils.isEmpty(arrayList.get(i2).getCusFieldConfig().getValue()) && !ScreenUtils.isMobileNO(arrayList.get(i2).getCusFieldConfig().getValue())) {
                    Context applicationContext3 = getApplicationContext();
                    ToastUtil.showToast(applicationContext3, getResString("sobot_phone") + getResString("sobot_input_type_err"));
                    return false;
                }
            }
            i = i2 + 1;
        }
    }

    private void initIntent(Bundle bundle) {
        this.mGroupId = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPID);
        this.mGroupName = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPNAME);
        this.mQueryFormModel = (SobotQueryFormModel) bundle.getSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD);
        this.mDocId = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID);
        this.mUnknownQuestion = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION);
        this.mActiveTransfer = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER);
        this.mKeywordId = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID);
        this.mKeyword = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD);
        this.mUid = bundle.getString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UID);
        this.mTransferType = bundle.getInt(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_TRANSFER_TYPE, 0);
        SobotQueryFormModel sobotQueryFormModel = this.mQueryFormModel;
        if (sobotQueryFormModel != null) {
            this.mField = sobotQueryFormModel.getField();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIntentWithFinish() {
        try {
            KeyboardUtil.hideKeyboard(getCurrentFocus());
            Intent intent = new Intent();
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPID, this.mGroupId);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPNAME, this.mGroupName);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_TRANSFER_TYPE, this.mTransferType);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID, this.mDocId);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION, this.mUnknownQuestion);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER, this.mActiveTransfer);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD, this.mKeyword);
            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID, this.mKeywordId);
            setResult(104, intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void submit() {
        if (this.isSubmitting) {
            return;
        }
        this.isSubmitting = true;
        this.zhiChiApi.submitForm(this, this.mUid, StCusFieldPresenter.getCusFieldVal(this.mField, this.mFinalData), new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.activity.SobotQueryFromActivity.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                SobotQueryFromActivity.this.isSubmitting = false;
                ToastUtil.showToast(SobotQueryFromActivity.this.getApplicationContext(), str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModel commonModel) {
                SobotQueryFromActivity.this.isSubmitting = false;
                if (commonModel != null && "1".equals(commonModel.getCode())) {
                    CustomToast.makeText(SobotQueryFromActivity.this.getBaseContext(), ResourceUtils.getResString(SobotQueryFromActivity.this.getBaseContext(), "sobot_leavemsg_success_tip"), 1000, ResourceUtils.getDrawableId(SobotQueryFromActivity.this.getBaseContext(), "sobot_iv_login_right")).show();
                    SobotQueryFromActivity.this.saveIntentWithFinish();
                } else if (commonModel == null || !"0".equals(commonModel.getCode())) {
                } else {
                    ToastUtil.showToast(SobotQueryFromActivity.this.getSobotBaseActivity(), commonModel.getMsg());
                }
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_query_from");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (bundle == null) {
            this.mIntentBundleData = getIntent().getBundleExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA);
        } else {
            this.mIntentBundleData = bundle.getBundle(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA);
        }
        Bundle bundle2 = this.mIntentBundleData;
        if (bundle2 != null) {
            initIntent(bundle2);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        Button button = (Button) findViewById(getResId("sobot_btn_submit"));
        this.sobot_btn_submit = button;
        button.setText(ResourceUtils.getResString(this, "sobot_btn_submit_text"));
        this.sobot_btn_submit.setOnClickListener(this);
        this.sobot_container = (LinearLayout) findViewById(getResId("sobot_container"));
        this.sobot_tv_doc = (TextView) findViewById(getResId("sobot_tv_doc"));
        this.sobot_tv_safety = (TextView) findViewById(getResId("sobot_tv_safety"));
        SobotQueryFormModel sobotQueryFormModel = this.mQueryFormModel;
        if (sobotQueryFormModel != null) {
            setTitle(sobotQueryFormModel.getFormTitle());
            HtmlTools.getInstance(getSobotBaseActivity()).setRichText(this.sobot_tv_doc, this.mQueryFormModel.getFormDoc(), ResourceUtils.getIdByName(getSobotBaseActivity(), "color", "sobot_color_link"));
            if (TextUtils.isEmpty(this.mQueryFormModel.getFormSafety())) {
                this.sobot_tv_safety.setVisibility(8);
            } else {
                this.sobot_tv_safety.setVisibility(0);
                this.sobot_tv_safety.setText(this.mQueryFormModel.getFormSafety());
            }
        }
        displayInNotch(this.sobot_tv_doc);
        StCusFieldPresenter.addWorkOrderCusFields(this, this, this.mField, this.sobot_container, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StCusFieldPresenter.onStCusFieldActivityResult(this, intent, this.mField, this.sobot_container);
        if (intent == null || i != 106) {
            return;
        }
        String stringExtra = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD_ID);
        SobotProvinInfo.SobotProvinceModel sobotProvinceModel = (SobotProvinInfo.SobotProvinceModel) intent.getSerializableExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_PROVININFO);
        this.mFinalData = sobotProvinceModel;
        if (this.mField == null || sobotProvinceModel == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mField.size()) {
                return;
            }
            SobotCusFieldConfig cusFieldConfig = this.mField.get(i4).getCusFieldConfig();
            if (cusFieldConfig != null && stringExtra.equals(cusFieldConfig.getFieldId())) {
                cusFieldConfig.setChecked(true);
                cusFieldConfig.setProvinceModel(this.mFinalData);
                View findViewWithTag = this.sobot_container.findViewWithTag(stringExtra);
                if (findViewWithTag != null) {
                    TextView textView = (TextView) findViewWithTag.findViewById(ResourceUtils.getIdByName(getApplicationContext(), "id", "work_order_customer_date_text_click"));
                    String str = this.mFinalData.provinceName == null ? "" : this.mFinalData.provinceName;
                    String str2 = this.mFinalData.cityName == null ? "" : this.mFinalData.cityName;
                    String str3 = this.mFinalData.areaName != null ? this.mFinalData.areaName : "";
                    textView.setText(str + str2 + str3);
                    TextView textView2 = (TextView) findViewWithTag.findViewById(ResourceUtils.getIdByName(getBaseContext(), "id", "work_order_customer_field_text_lable"));
                    ((LinearLayout) findViewWithTag.findViewById(ResourceUtils.getIdByName(getBaseContext(), "id", "work_order_customer_field_ll"))).setVisibility(0);
                    textView2.setTextColor(ContextCompat.getColor(this, ResourceUtils.getResColorId(this, "sobot_common_gray2")));
                    textView2.setTextSize(12.0f);
                }
            }
            i3 = i4 + 1;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        backPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_btn_submit && TextUtils.isEmpty(StCusFieldPresenter.formatCusFieldVal(this, this.sobot_container, this.mField)) && checkInput(this.mField)) {
            submit();
        }
    }

    @Override // com.sobot.chat.listener.ISobotCusField
    public void onClickCusField(View view, int i, final SobotFieldModel sobotFieldModel) {
        switch (i) {
            case 3:
            case 4:
                StCusFieldPresenter.openTimePicker(this, view, i);
                return;
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                StCusFieldPresenter.startSobotCusFieldActivity(this, sobotFieldModel);
                return;
            case 9:
                LogUtils.i("点击了城市");
                SobotDialogUtils.startProgressDialog(this);
                this.zhiChiApi.queryCity(this, null, null, new StringResultCallBack<SobotCityResult>() { // from class: com.sobot.chat.activity.SobotQueryFromActivity.2
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str) {
                        SobotDialogUtils.stopProgressDialog(SobotQueryFromActivity.this);
                        ToastUtil.showToast(SobotQueryFromActivity.this.getApplicationContext(), str);
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onSuccess(SobotCityResult sobotCityResult) {
                        SobotDialogUtils.stopProgressDialog(SobotQueryFromActivity.this);
                        SobotProvinInfo data = sobotCityResult.getData();
                        if (data.getProvinces() == null || data.getProvinces().size() <= 0) {
                            return;
                        }
                        StCusFieldPresenter.startChooseCityAct(SobotQueryFromActivity.this, data, sobotFieldModel);
                    }
                });
                return;
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SobotDialogUtils.stopProgressDialog(this);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA, this.mIntentBundleData);
        super.onSaveInstanceState(bundle);
    }
}
