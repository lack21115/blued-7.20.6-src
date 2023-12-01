package com.sobot.chat.fragment;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.openalliance.ad.constant.t;
import com.sobot.chat.activity.SobotPhotoActivity;
import com.sobot.chat.activity.SobotPostCascadeActivity;
import com.sobot.chat.activity.SobotPostCategoryActivity;
import com.sobot.chat.activity.SobotPostMsgActivity;
import com.sobot.chat.activity.SobotVideoActivity;
import com.sobot.chat.adapter.SobotPicListAdapter;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.PostParamModel;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveMsgParamModel;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiUploadAppFileModelResult;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.listener.ISobotCusField;
import com.sobot.chat.presenter.StCusFieldPresenter;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ImageUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MD5Util;
import com.sobot.chat.utils.MediaFileUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotJsonUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.attachment.FileTypeConfig;
import com.sobot.chat.widget.dialog.SobotDeleteWorkOrderDialog;
import com.sobot.chat.widget.dialog.SobotDialogUtils;
import com.sobot.chat.widget.dialog.SobotSelectPicDialog;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.network.http.callback.StringResultCallBack;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/fragment/SobotPostMsgFragment.class */
public class SobotPostMsgFragment extends SobotBaseFragment implements View.OnClickListener, ISobotCusField {
    private SobotPicListAdapter adapter;
    private TextView email_hint_input_label;
    private boolean flag_exit_sdk;
    private Information information;
    private SobotLeaveMsgConfig mConfig;
    private ArrayList<SobotFieldModel> mCusAddFields;
    private ArrayList<SobotFieldModel> mFields;
    private View mRootView;
    private SobotSelectPicDialog menuWindow;
    private TextView phone_hint_input_label;
    protected SobotDeleteWorkOrderDialog seleteMenuWindow;
    private Button sobot_btn_submit;
    private LinearLayout sobot_enclosure_container;
    private EditText sobot_et_content;
    private View sobot_frist_line;
    private LinearLayout sobot_ll_content_img;
    private View sobot_phone_line;
    private LinearLayout sobot_post_customer_field;
    private View sobot_post_customer_line;
    private View sobot_post_customer_sec_line;
    private EditText sobot_post_email;
    private TextView sobot_post_email_lable;
    private RelativeLayout sobot_post_email_rl;
    private TextView sobot_post_lable;
    private LinearLayout sobot_post_msg_layout;
    private GridView sobot_post_msg_pic;
    private EditText sobot_post_phone;
    private TextView sobot_post_phone_lable;
    private RelativeLayout sobot_post_phone_rl;
    private TextView sobot_post_question_lable;
    private View sobot_post_question_line;
    private LinearLayout sobot_post_question_ll;
    private View sobot_post_question_sec_line;
    private TextView sobot_post_question_type;
    private EditText sobot_post_title;
    private TextView sobot_post_title_lable;
    private View sobot_post_title_line;
    private RelativeLayout sobot_post_title_rl;
    private View sobot_post_title_sec_line;
    private TextView sobot_tv_post_msg;
    private TextView sobot_tv_problem_description;
    private TextView title_hint_input_lable;
    private ArrayList<ZhiChiUploadAppFileModelResult> pic_list = new ArrayList<>();
    private String uid = "";
    private String mGroupId = "";
    private int flag_exit_type = -1;
    public Handler handler = new Handler() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (SobotPostMsgFragment.this.flag_exit_type == 1) {
                SobotPostMsgFragment.this.finishPageOrSDK(true);
            } else if (SobotPostMsgFragment.this.flag_exit_type == 2) {
                SobotPostMsgFragment.this.getSobotActivity().setResult(200);
                SobotPostMsgFragment.this.finishPageOrSDK(false);
            } else {
                SobotPostMsgFragment sobotPostMsgFragment = SobotPostMsgFragment.this;
                sobotPostMsgFragment.finishPageOrSDK(sobotPostMsgFragment.flag_exit_sdk);
            }
        }
    };
    private ChatUtils.SobotSendFileListener sendFileListener = new ChatUtils.SobotSendFileListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.12
        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onError() {
            SobotDialogUtils.stopProgressDialog(SobotPostMsgFragment.this.getSobotActivity());
        }

        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onSuccess(final String str) {
            ZhiChiApi zhiChiApi = SobotPostMsgFragment.this.zhiChiApi;
            SobotPostMsgFragment sobotPostMsgFragment = SobotPostMsgFragment.this;
            zhiChiApi.fileUploadForPostMsg(sobotPostMsgFragment, sobotPostMsgFragment.mConfig.getCompanyId(), SobotPostMsgFragment.this.uid, str, new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.12.1
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str2) {
                    SobotDialogUtils.stopProgressDialog(SobotPostMsgFragment.this.getSobotActivity());
                    SobotPostMsgFragment.this.showHint(ResourceUtils.getResString(SobotPostMsgFragment.this.getSobotActivity(), "sobot_net_work_err"));
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(ZhiChiMessage zhiChiMessage) {
                    SobotDialogUtils.stopProgressDialog(SobotPostMsgFragment.this.getSobotActivity());
                    if (zhiChiMessage.getData() != null) {
                        ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = new ZhiChiUploadAppFileModelResult();
                        zhiChiUploadAppFileModelResult.setFileUrl(zhiChiMessage.getData().getUrl());
                        zhiChiUploadAppFileModelResult.setFileLocalPath(str);
                        zhiChiUploadAppFileModelResult.setViewState(1);
                        SobotPostMsgFragment.this.adapter.addData(zhiChiUploadAppFileModelResult);
                    }
                }
            });
        }
    };
    private View.OnClickListener itemsOnClick = new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            SobotPostMsgFragment.this.menuWindow.dismiss();
            if (view.getId() == SobotPostMsgFragment.this.getResId("btn_take_photo")) {
                LogUtils.i("拍照");
                SobotPostMsgFragment.this.selectPicFromCameraBySys();
            }
            if (view.getId() == SobotPostMsgFragment.this.getResId("btn_pick_photo")) {
                LogUtils.i("选择照片");
                SobotPostMsgFragment.this.selectPicFromLocal();
            }
            if (view.getId() == SobotPostMsgFragment.this.getResId("btn_pick_vedio")) {
                LogUtils.i("选择视频");
                SobotPostMsgFragment.this.selectVedioFromLocal();
            }
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:67:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkSubmit() {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.fragment.SobotPostMsgFragment.checkSubmit():void");
    }

    private void editTextSetHint() {
        if (this.mConfig.isEmailFlag()) {
            TextView textView = this.sobot_post_email_lable;
            textView.setText(Html.fromHtml(getResString("sobot_email") + "<font color='#f9676f'>&nbsp;*</font>"));
        } else {
            this.sobot_post_email_lable.setText(Html.fromHtml(getResString("sobot_email")));
        }
        if (this.mConfig.isTelFlag()) {
            TextView textView2 = this.sobot_post_phone_lable;
            textView2.setText(Html.fromHtml(getResString("sobot_phone") + "<font color='#f9676f'>&nbsp;*</font>"));
        } else {
            this.sobot_post_phone_lable.setText(Html.fromHtml(getResString("sobot_phone")));
        }
        if (this.mConfig.isTicketTitleShowFlag()) {
            TextView textView3 = this.sobot_post_title_lable;
            textView3.setText(Html.fromHtml(getResString("sobot_title") + "<font color='#f9676f'>&nbsp;*</font>"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPageOrSDK(boolean z) {
        if (z) {
            MyApplication.getInstance().exit();
        } else if (getSobotActivity() != null) {
            getSobotActivity().finish();
            getSobotActivity().overridePendingTransition(ResourceUtils.getIdByName(getSobotActivity(), i.f, "sobot_push_right_in"), ResourceUtils.getIdByName(getSobotActivity(), i.f, "sobot_push_right_out"));
        } else {
            Activity lastActivity = MyApplication.getInstance().getLastActivity();
            if (lastActivity == null || !(lastActivity instanceof SobotPostMsgActivity)) {
                return;
            }
            lastActivity.finish();
            lastActivity.overridePendingTransition(ResourceUtils.getIdByName(lastActivity, i.f, "sobot_push_right_in"), ResourceUtils.getIdByName(lastActivity, i.f, "sobot_push_right_out"));
        }
    }

    private void initPicListView() {
        this.sobot_post_msg_pic = (GridView) this.mRootView.findViewById(getResId("sobot_post_msg_pic"));
        SobotPicListAdapter sobotPicListAdapter = new SobotPicListAdapter(getSobotActivity(), this.pic_list);
        this.adapter = sobotPicListAdapter;
        this.sobot_post_msg_pic.setAdapter((ListAdapter) sobotPicListAdapter);
        this.adapter.setOnClickItemViewListener(new SobotPicListAdapter.ViewClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.10
            @Override // com.sobot.chat.adapter.SobotPicListAdapter.ViewClickListener
            public void clickView(View view, int i, int i2) {
                ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult;
                KeyboardUtil.hideKeyboard(view);
                if (i2 == 0) {
                    SobotPostMsgFragment.this.menuWindow = new SobotSelectPicDialog(SobotPostMsgFragment.this.getSobotActivity(), SobotPostMsgFragment.this.itemsOnClick);
                    SobotPostMsgFragment.this.menuWindow.show();
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    String resString = ResourceUtils.getResString(SobotPostMsgFragment.this.getSobotActivity(), "sobot_do_you_delete_picture");
                    if (SobotPostMsgFragment.this.adapter == null || SobotPostMsgFragment.this.adapter.getPicList() == null) {
                        return;
                    }
                    ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult2 = SobotPostMsgFragment.this.adapter.getPicList().get(i);
                    String str = resString;
                    if (zhiChiUploadAppFileModelResult2 != null) {
                        str = resString;
                        if (!TextUtils.isEmpty(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                            str = resString;
                            if (MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                                str = ResourceUtils.getResString(SobotPostMsgFragment.this.getSobotActivity(), "sobot_do_you_delete_video");
                            }
                        }
                    }
                    if (SobotPostMsgFragment.this.seleteMenuWindow != null) {
                        SobotPostMsgFragment.this.seleteMenuWindow.dismiss();
                        SobotPostMsgFragment.this.seleteMenuWindow = null;
                    }
                    if (SobotPostMsgFragment.this.seleteMenuWindow == null) {
                        SobotPostMsgFragment.this.seleteMenuWindow = new SobotDeleteWorkOrderDialog(SobotPostMsgFragment.this.getSobotActivity(), str, new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.10.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                Tracker.onClick(view2);
                                SobotPostMsgFragment.this.seleteMenuWindow.dismiss();
                                if (view2.getId() == SobotPostMsgFragment.this.getResId("btn_pick_photo")) {
                                    Log.e("onClick: ", SobotPostMsgFragment.this.seleteMenuWindow.getPosition() + "");
                                    SobotPostMsgFragment.this.pic_list.remove(SobotPostMsgFragment.this.seleteMenuWindow.getPosition());
                                    SobotPostMsgFragment.this.adapter.restDataView();
                                }
                            }
                        });
                    }
                    SobotPostMsgFragment.this.seleteMenuWindow.setPosition(i);
                    SobotPostMsgFragment.this.seleteMenuWindow.show();
                } else {
                    LogUtils.i("当前选择图片位置：" + i);
                    if (SobotPostMsgFragment.this.adapter == null || SobotPostMsgFragment.this.adapter.getPicList() == null || (zhiChiUploadAppFileModelResult = SobotPostMsgFragment.this.adapter.getPicList().get(i)) == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) || !MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                        if (SobotOption.imagePreviewListener != null) {
                            if (SobotOption.imagePreviewListener.onPreviewImage(SobotPostMsgFragment.this.getSobotActivity(), TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                                return;
                            }
                        }
                        Intent intent = new Intent(SobotPostMsgFragment.this.getSobotActivity(), SobotPhotoActivity.class);
                        intent.putExtra("imageUrL", TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath());
                        SobotPostMsgFragment.this.getSobotActivity().startActivity(intent);
                        return;
                    }
                    File file = new File(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    SobotCacheFile sobotCacheFile = new SobotCacheFile();
                    sobotCacheFile.setFileName(file.getName());
                    sobotCacheFile.setUrl(zhiChiUploadAppFileModelResult.getFileUrl());
                    sobotCacheFile.setFilePath(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    sobotCacheFile.setFileType(FileTypeConfig.getFileType(FileUtil.getFileEndWith(zhiChiUploadAppFileModelResult.getFileLocalPath())));
                    sobotCacheFile.setMsgId("" + System.currentTimeMillis());
                    SobotPostMsgFragment.this.getSobotActivity().startActivity(SobotVideoActivity.newIntent(SobotPostMsgFragment.this.getSobotActivity(), sobotCacheFile));
                }
            }
        });
        this.adapter.restDataView();
    }

    private void msgFilter() {
        Information information = this.information;
        if (information != null && information.getLeaveMsgTemplateContent() != null) {
            this.sobot_et_content.setHint(Html.fromHtml(this.information.getLeaveMsgTemplateContent().replace("<br/>", "")));
        } else if (!TextUtils.isEmpty(this.mConfig.getMsgTmp())) {
            SobotLeaveMsgConfig sobotLeaveMsgConfig = this.mConfig;
            sobotLeaveMsgConfig.setMsgTmp(sobotLeaveMsgConfig.getMsgTmp().replace("<br/>", "").replace("<p>", "").replace("</p>", ""));
            this.sobot_et_content.setHint(Html.fromHtml(this.mConfig.getMsgTmp()));
        }
        Information information2 = this.information;
        if (information2 != null && information2.getLeaveMsgGuideContent() != null) {
            if (TextUtils.isEmpty(this.information.getLeaveMsgGuideContent())) {
                this.sobot_tv_post_msg.setVisibility(8);
            }
            HtmlTools.getInstance(getSobotActivity().getApplicationContext()).setRichText(this.sobot_tv_post_msg, this.information.getLeaveMsgGuideContent().replace("<br/>", ""), ResourceUtils.getIdByName(getSobotActivity(), "color", "sobot_postMsg_url_color"));
        } else if (TextUtils.isEmpty(this.mConfig.getMsgTxt())) {
            this.sobot_tv_post_msg.setVisibility(8);
        } else {
            SobotLeaveMsgConfig sobotLeaveMsgConfig2 = this.mConfig;
            sobotLeaveMsgConfig2.setMsgTxt(sobotLeaveMsgConfig2.getMsgTxt().replace("<br/>", "").replace("<p>", "").replace("</p>", "").replace("\n", ""));
            HtmlTools.getInstance(getSobotActivity().getApplicationContext()).setRichText(this.sobot_tv_post_msg, this.mConfig.getMsgTxt(), ResourceUtils.getIdByName(getSobotActivity(), "color", "sobot_postMsg_url_color"));
        }
        this.sobot_post_msg_layout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                KeyboardUtil.hideKeyboard(SobotPostMsgFragment.this.sobot_post_msg_layout);
            }
        });
    }

    public static SobotPostMsgFragment newInstance(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
        SobotPostMsgFragment sobotPostMsgFragment = new SobotPostMsgFragment();
        sobotPostMsgFragment.setArguments(bundle2);
        return sobotPostMsgFragment;
    }

    private void postMsg(String str, String str2, String str3) {
        PostParamModel postParamModel = new PostParamModel();
        postParamModel.setTemplateId(this.mConfig.getTemplateId());
        postParamModel.setPartnerId(this.information.getPartnerid());
        postParamModel.setUid(this.uid);
        postParamModel.setTicketContent(this.sobot_et_content.getText().toString());
        postParamModel.setCustomerEmail(str2);
        postParamModel.setCustomerPhone(str);
        postParamModel.setTicketTitle(str3);
        postParamModel.setCompanyId(this.mConfig.getCompanyId());
        postParamModel.setFileStr(getFileStr());
        postParamModel.setGroupId(this.mGroupId);
        postParamModel.setTicketFrom("4");
        Information information = this.information;
        if (information != null && information.getLeaveParamsExtends() != null) {
            postParamModel.setParamsExtends(SobotJsonUtils.toJson(this.information.getLeaveParamsExtends()));
        }
        if (this.sobot_post_question_type.getTag() != null && !TextUtils.isEmpty(this.sobot_post_question_type.getTag().toString())) {
            postParamModel.setTicketTypeId(this.sobot_post_question_type.getTag().toString());
        }
        ArrayList<SobotFieldModel> arrayList = this.mCusAddFields;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mFields == null) {
                this.mFields = new ArrayList<>();
            }
            this.mFields.addAll(this.mCusAddFields);
        }
        postParamModel.setExtendFields(StCusFieldPresenter.getSaveFieldVal(this.mFields));
        this.zhiChiApi.postMsg(this, postParamModel, new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.9
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str4) {
                try {
                    SobotPostMsgFragment.this.showHint(ResourceUtils.getResString(SobotPostMsgFragment.this.getSobotActivity(), "sobot_try_again"));
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (Integer.parseInt(commonModelBase.getStatus()) == 0) {
                    SobotPostMsgFragment.this.showHint(commonModelBase.getMsg());
                } else if (Integer.parseInt(commonModelBase.getStatus()) != 1 || SobotPostMsgFragment.this.getSobotActivity() == null) {
                } else {
                    KeyboardUtil.hideKeyboard(SobotPostMsgFragment.this.getSobotActivity().getCurrentFocus());
                    Intent intent = new Intent();
                    intent.setAction(SobotPostMsgActivity.SOBOT_ACTION_SHOW_COMPLETED_VIEW);
                    CommonUtils.sendLocalBroadcast(SobotPostMsgFragment.this.getSobotActivity(), intent);
                }
            }
        });
    }

    private void setCusFieldValue() {
        String formatCusFieldVal = StCusFieldPresenter.formatCusFieldVal(getSobotActivity(), this.sobot_post_customer_field, this.mFields);
        if (TextUtils.isEmpty(formatCusFieldVal)) {
            checkSubmit();
        } else {
            showHint(formatCusFieldVal);
        }
    }

    public String getFileStr() {
        ArrayList<ZhiChiUploadAppFileModelResult> picList;
        String str = "";
        if (!this.mConfig.isEnclosureShowFlag()) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.adapter.getPicList().size()) {
                return str;
            }
            str = str + picList.get(i2).getFileUrl() + t.aE;
            i = i2 + 1;
        }
    }

    protected void initData() {
        this.information = (Information) SharedPreferencesUtil.getObject(getSobotActivity(), ZhiChiConstant.sobot_last_current_info);
        this.zhiChiApi.getTemplateFieldsInfo(this, this.uid, this.mConfig.getTemplateId(), new StringResultCallBack<SobotLeaveMsgParamModel>() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.8
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                try {
                    SobotPostMsgFragment.this.showHint(ResourceUtils.getResString(SobotPostMsgFragment.this.getSobotActivity(), "sobot_try_again"));
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotLeaveMsgParamModel sobotLeaveMsgParamModel) {
                if (sobotLeaveMsgParamModel == null || sobotLeaveMsgParamModel.getField() == null || sobotLeaveMsgParamModel.getField().size() == 0) {
                    return;
                }
                SobotPostMsgFragment.this.sobot_post_customer_line.setVisibility(0);
                SobotPostMsgFragment.this.sobot_post_customer_sec_line.setVisibility(0);
                SobotPostMsgFragment.this.mFields = sobotLeaveMsgParamModel.getField();
                StCusFieldPresenter.addWorkOrderCusFields(SobotPostMsgFragment.this.getSobotActivity(), SobotPostMsgFragment.this.getSobotActivity(), SobotPostMsgFragment.this.mFields, SobotPostMsgFragment.this.sobot_post_customer_field, SobotPostMsgFragment.this);
            }
        });
        msgFilter();
        editTextSetHint();
    }

    protected void initView(View view) {
        this.sobot_ll_content_img = (LinearLayout) view.findViewById(getResId("sobot_ll_content_img"));
        this.sobot_post_phone = (EditText) view.findViewById(getResId("sobot_post_phone"));
        this.sobot_post_email = (EditText) view.findViewById(getResId("sobot_post_email"));
        this.sobot_post_title = (EditText) view.findViewById(getResId("sobot_post_title"));
        this.sobot_frist_line = view.findViewById(getResId("sobot_frist_line"));
        this.sobot_post_title_line = view.findViewById(getResId("sobot_post_title_line"));
        this.sobot_post_question_line = view.findViewById(getResId("sobot_post_question_line"));
        this.sobot_post_customer_line = view.findViewById(getResId("sobot_post_customer_line"));
        this.sobot_post_title_sec_line = view.findViewById(getResId("sobot_post_title_sec_line"));
        this.sobot_post_question_sec_line = view.findViewById(getResId("sobot_post_question_sec_line"));
        this.sobot_post_customer_sec_line = view.findViewById(getResId("sobot_post_customer_sec_line"));
        this.sobot_phone_line = view.findViewById(getResId("sobot_phone_line"));
        this.sobot_et_content = (EditText) view.findViewById(getResId("sobot_post_et_content"));
        this.sobot_tv_post_msg = (TextView) view.findViewById(getResId("sobot_tv_post_msg"));
        this.sobot_post_email_lable = (TextView) view.findViewById(getResId("sobot_post_email_lable"));
        this.sobot_post_phone_lable = (TextView) view.findViewById(getResId("sobot_post_phone_lable"));
        this.sobot_post_title_lable = (TextView) view.findViewById(getResId("sobot_post_title_lable"));
        this.sobot_post_lable = (TextView) view.findViewById(getResId("sobot_post_question_lable"));
        this.sobot_post_lable.setText(Html.fromHtml(getResString("sobot_problem_types") + "<font color='#f9676f'>&nbsp;*</font>"));
        this.sobot_post_question_lable = (TextView) view.findViewById(getResId("sobot_post_question_lable"));
        this.sobot_post_question_type = (TextView) view.findViewById(getResId("sobot_post_question_type"));
        this.sobot_post_msg_layout = (LinearLayout) view.findViewById(getResId("sobot_post_msg_layout"));
        this.sobot_enclosure_container = (LinearLayout) view.findViewById(getResId("sobot_enclosure_container"));
        this.sobot_post_customer_field = (LinearLayout) view.findViewById(getResId("sobot_post_customer_field"));
        this.sobot_post_email_rl = (RelativeLayout) view.findViewById(getResId("sobot_post_email_rl"));
        TextView textView = (TextView) view.findViewById(getResId("sobot_post_email_lable_hint"));
        this.email_hint_input_label = textView;
        textView.setHint(ResourceUtils.getResString(getSobotActivity(), "sobot_please_input"));
        TextView textView2 = (TextView) view.findViewById(getResId("sobot_post_title_lable_hint"));
        this.title_hint_input_lable = textView2;
        textView2.setHint(ResourceUtils.getResString(getSobotActivity(), "sobot_please_input"));
        this.sobot_post_phone_rl = (RelativeLayout) view.findViewById(getResId("sobot_post_phone_rl"));
        TextView textView3 = (TextView) view.findViewById(getResId("sobot_post_phone_lable_hint"));
        this.phone_hint_input_label = textView3;
        textView3.setHint(ResourceUtils.getResString(getSobotActivity(), "sobot_please_input"));
        this.sobot_post_title_rl = (RelativeLayout) view.findViewById(getResId("sobot_post_title_rl"));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(getResId("sobot_post_question_ll"));
        this.sobot_post_question_ll = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView4 = (TextView) view.findViewById(getResId("sobot_tv_problem_description"));
        this.sobot_tv_problem_description = textView4;
        textView4.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_problem_description"));
        Button button = (Button) view.findViewById(getResId("sobot_btn_submit"));
        this.sobot_btn_submit = button;
        button.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_btn_submit_text"));
        this.sobot_btn_submit.setOnClickListener(this);
        this.sobot_post_customer_field.setVisibility(8);
        if (this.mConfig.isEmailShowFlag()) {
            this.sobot_post_email_rl.setVisibility(0);
            this.sobot_post_email_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    SobotPostMsgFragment.this.sobot_post_email.setVisibility(0);
                    SobotPostMsgFragment.this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray2")));
                    SobotPostMsgFragment.this.sobot_post_email_lable.setTextSize(12.0f);
                    SobotPostMsgFragment.this.sobot_post_email.setFocusable(true);
                    SobotPostMsgFragment.this.sobot_post_email.setFocusableInTouchMode(true);
                    SobotPostMsgFragment.this.sobot_post_email.requestFocus();
                    SobotPostMsgFragment.this.email_hint_input_label.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotPostMsgFragment.this.sobot_post_email);
                }
            });
        } else {
            this.sobot_post_email_rl.setVisibility(8);
        }
        this.sobot_post_email.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                Tracker.onFocusChange(view2, z);
                if (z) {
                    SobotPostMsgFragment.this.email_hint_input_label.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotPostMsgFragment.this.sobot_post_email.getText().toString().trim())) {
                    SobotPostMsgFragment.this.sobot_post_email_lable.setTextSize(14.0f);
                    SobotPostMsgFragment.this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray1")));
                    SobotPostMsgFragment.this.sobot_post_email.setVisibility(8);
                    SobotPostMsgFragment.this.email_hint_input_label.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isTelShowFlag()) {
            this.sobot_post_phone_rl.setVisibility(0);
            this.sobot_post_phone_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    SobotPostMsgFragment.this.sobot_post_phone.setVisibility(0);
                    SobotPostMsgFragment.this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray2")));
                    SobotPostMsgFragment.this.sobot_post_phone_lable.setTextSize(12.0f);
                    SobotPostMsgFragment.this.sobot_post_phone.setFocusable(true);
                    SobotPostMsgFragment.this.sobot_post_phone.setFocusableInTouchMode(true);
                    SobotPostMsgFragment.this.sobot_post_phone.requestFocus();
                    SobotPostMsgFragment.this.phone_hint_input_label.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotPostMsgFragment.this.sobot_post_phone);
                }
            });
        } else {
            this.sobot_post_phone_rl.setVisibility(8);
        }
        this.sobot_post_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                Tracker.onFocusChange(view2, z);
                if (z) {
                    SobotPostMsgFragment.this.phone_hint_input_label.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotPostMsgFragment.this.sobot_post_phone.getText().toString().trim())) {
                    SobotPostMsgFragment.this.sobot_post_phone_lable.setTextSize(14.0f);
                    SobotPostMsgFragment.this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray1")));
                    SobotPostMsgFragment.this.sobot_post_phone.setVisibility(8);
                    SobotPostMsgFragment.this.phone_hint_input_label.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isTicketTitleShowFlag()) {
            this.sobot_post_title_rl.setVisibility(0);
            this.sobot_post_title_line.setVisibility(0);
            this.sobot_post_title_sec_line.setVisibility(0);
            this.sobot_post_title_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    SobotPostMsgFragment.this.sobot_post_title.setVisibility(0);
                    SobotPostMsgFragment.this.sobot_post_title_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray2")));
                    SobotPostMsgFragment.this.sobot_post_title_lable.setTextSize(12.0f);
                    SobotPostMsgFragment.this.sobot_post_title.setFocusable(true);
                    SobotPostMsgFragment.this.sobot_post_title.setFocusableInTouchMode(true);
                    SobotPostMsgFragment.this.sobot_post_title.requestFocus();
                    SobotPostMsgFragment.this.title_hint_input_lable.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotPostMsgFragment.this.sobot_post_title);
                }
            });
        } else {
            this.sobot_post_title_rl.setVisibility(8);
        }
        this.sobot_post_title.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.fragment.SobotPostMsgFragment.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                Tracker.onFocusChange(view2, z);
                if (z) {
                    SobotPostMsgFragment.this.title_hint_input_lable.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotPostMsgFragment.this.sobot_post_title.getText().toString().trim())) {
                    SobotPostMsgFragment.this.sobot_post_title_lable.setTextSize(14.0f);
                    SobotPostMsgFragment.this.sobot_post_title_lable.setTextColor(ContextCompat.getColor(SobotPostMsgFragment.this.getSobotActivity(), ResourceUtils.getResColorId(SobotPostMsgFragment.this.getSobotActivity(), "sobot_common_gray1")));
                    SobotPostMsgFragment.this.sobot_post_title.setVisibility(8);
                    SobotPostMsgFragment.this.title_hint_input_lable.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isEmailShowFlag()) {
            this.sobot_frist_line.setVisibility(0);
        } else {
            this.sobot_frist_line.setVisibility(8);
        }
        this.sobot_phone_line.setVisibility(this.mConfig.isTelShowFlag() ? 0 : 8);
        Information information = this.information;
        String user_tels = information != null ? information.getUser_tels() : "";
        if (this.mConfig.isTelShowFlag() && !TextUtils.isEmpty(user_tels)) {
            this.sobot_post_phone.setVisibility(0);
            this.sobot_post_phone.setText(user_tels);
            this.phone_hint_input_label.setVisibility(8);
            this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(getSobotActivity(), ResourceUtils.getResColorId(getSobotActivity(), "sobot_common_gray2")));
            this.sobot_post_phone_lable.setTextSize(12.0f);
        }
        Information information2 = this.information;
        String user_emails = information2 != null ? information2.getUser_emails() : "";
        if (this.mConfig.isEmailShowFlag() && !TextUtils.isEmpty(user_emails)) {
            this.sobot_post_email.setVisibility(0);
            this.sobot_post_email.setText(user_emails);
            this.email_hint_input_label.setVisibility(8);
            this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(getSobotActivity(), ResourceUtils.getResColorId(getSobotActivity(), "sobot_common_gray2")));
            this.sobot_post_email_lable.setTextSize(12.0f);
        }
        if (this.mConfig.isEnclosureShowFlag()) {
            this.sobot_enclosure_container.setVisibility(0);
            initPicListView();
        } else {
            this.sobot_enclosure_container.setVisibility(8);
        }
        if (this.mConfig.isTicketTypeFlag()) {
            this.sobot_post_question_ll.setVisibility(0);
            this.sobot_post_question_line.setVisibility(0);
            this.sobot_post_question_sec_line.setVisibility(0);
        } else {
            this.sobot_post_question_ll.setVisibility(8);
            this.sobot_post_question_type.setTag(this.mConfig.getTicketTypeId());
        }
        displayInNotch(this.sobot_tv_post_msg);
        displayInNotch(this.sobot_post_email_lable);
        displayInNotch(this.sobot_post_phone_lable);
        displayInNotch(this.sobot_post_title_lable);
        displayInNotch(this.sobot_post_question_type);
        displayInNotch(this.sobot_post_question_lable);
        displayInNotch(this.sobot_ll_content_img);
        displayInNotch(this.sobot_post_email);
        displayInNotch(this.sobot_post_phone);
        displayInNotch(this.sobot_post_title);
        displayInNotch(this.title_hint_input_lable);
        displayInNotch(this.email_hint_input_label);
        displayInNotch(this.phone_hint_input_label);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        initData();
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 701) {
                if (intent == null || intent.getData() == null) {
                    showHint(getResString("sobot_did_not_get_picture_path"));
                } else {
                    Uri data = intent.getData();
                    Uri uri = data;
                    if (data == null) {
                        uri = ImageUtils.getUri(intent, getSobotActivity());
                    }
                    String path = ImageUtils.getPath(getSobotActivity(), uri);
                    if (StringUtils.isEmpty(path)) {
                        showHint(getResString("sobot_did_not_get_picture_path"));
                    } else if (MediaFileUtils.isVideoFileType(path)) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(getSobotActivity(), uri);
                            mediaPlayer.prepare();
                            if (mediaPlayer.getDuration() / 1000 > 15) {
                                ToastUtil.showToast(getSobotActivity(), getResString("sobot_upload_vodie_length"));
                                return;
                            }
                            SobotDialogUtils.startProgressDialog(getSobotActivity());
                            String encode = MD5Util.encode(path);
                            try {
                                Activity sobotActivity = getSobotActivity();
                                this.sendFileListener.onSuccess(FileUtil.saveImageFile(sobotActivity, uri, encode + FileUtil.getFileEndWith(path), path));
                            } catch (Exception e) {
                                e.printStackTrace();
                                ToastUtil.showToast(getSobotActivity(), ResourceUtils.getResString(getSobotActivity(), "sobot_pic_type_error"));
                                return;
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        SobotDialogUtils.startProgressDialog(getSobotActivity());
                        ChatUtils.sendPicByUriPost(getSobotActivity(), uri, this.sendFileListener, false);
                    }
                }
            } else if (i == 702) {
                if (this.cameraFile == null || !this.cameraFile.exists()) {
                    showHint(getResString("sobot_pic_select_again"));
                } else {
                    SobotDialogUtils.startProgressDialog(getSobotActivity());
                    ChatUtils.sendPicByFilePath(getSobotActivity(), this.cameraFile.getAbsolutePath(), this.sendFileListener, true);
                }
            }
        }
        StCusFieldPresenter.onStCusFieldActivityResult(getSobotActivity(), intent, this.mFields, this.sobot_post_customer_field);
        if (intent != null) {
            if (i == 302) {
                this.adapter.addDatas((List) intent.getExtras().getSerializable(ZhiChiConstant.SOBOT_KEYTYPE_PIC_LIST));
            } else if (i == 304 && !TextUtils.isEmpty(intent.getStringExtra("category_typeId"))) {
                String stringExtra = intent.getStringExtra("category_typeName");
                String stringExtra2 = intent.getStringExtra("category_typeId");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.sobot_post_question_type.setText(stringExtra);
                this.sobot_post_question_type.setTag(stringExtra2);
                this.sobot_post_question_type.setVisibility(0);
                this.sobot_post_question_lable.setTextColor(ContextCompat.getColor(getSobotActivity(), ResourceUtils.getResColorId(getSobotActivity(), "sobot_common_gray2")));
                this.sobot_post_question_lable.setTextSize(12.0f);
            }
        }
    }

    public void onBackPress() {
        if (getView() != null) {
            KeyboardUtil.hideKeyboard(((ViewGroup) getView()).getFocusedChild());
        }
        int i = this.flag_exit_type;
        if (i == 1 || i == 2) {
            finishPageOrSDK(false);
        } else {
            finishPageOrSDK(this.flag_exit_sdk);
        }
    }

    public void onBackPressed() {
        int i = this.flag_exit_type;
        if (i == 1 || i == 2) {
            finishPageOrSDK(false);
        } else {
            finishPageOrSDK(this.flag_exit_sdk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_post_question_ll && this.mConfig.getType() != null && this.mConfig.getType().size() != 0) {
            Intent intent = new Intent(getSobotActivity(), SobotPostCategoryActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("types", this.mConfig.getType());
            TextView textView = this.sobot_post_question_type;
            if (textView != null && !TextUtils.isEmpty(textView.getText().toString()) && this.sobot_post_question_type.getTag() != null && !TextUtils.isEmpty(this.sobot_post_question_type.getTag().toString())) {
                bundle.putString("typeName", this.sobot_post_question_type.getText().toString());
                bundle.putString("typeId", this.sobot_post_question_type.getTag().toString());
            }
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            startActivityForResult(intent, 304);
        }
        if (view == this.sobot_btn_submit) {
            setCusFieldValue();
        }
    }

    @Override // com.sobot.chat.listener.ISobotCusField
    public void onClickCusField(View view, int i, SobotFieldModel sobotFieldModel) {
        switch (i) {
            case 3:
            case 4:
                StCusFieldPresenter.openTimePicker(getSobotActivity(), view, i);
                return;
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                StCusFieldPresenter.startSobotCusFieldActivity(getSobotActivity(), this, sobotFieldModel);
                return;
            case 9:
                if (sobotFieldModel == null || sobotFieldModel.getCusFieldDataInfoList() == null || sobotFieldModel.getCusFieldDataInfoList().size() <= 0) {
                    return;
                }
                Intent intent = new Intent(getSobotActivity(), SobotPostCascadeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cusField", sobotFieldModel);
                bundle.putSerializable("fieldId", sobotFieldModel.getCusFieldConfig().getFieldId());
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                startActivityForResult(intent, 304);
                return;
        }
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        if (getArguments() == null || (bundle2 = getArguments().getBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION)) == null) {
            return;
        }
        this.uid = bundle2.getString("intent_key_uid");
        this.mGroupId = bundle2.getString(StPostMsgPresenter.INTENT_KEY_GROUPID);
        this.mCusAddFields = (ArrayList) bundle2.getSerializable(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS);
        this.flag_exit_type = bundle2.getInt(ZhiChiConstant.FLAG_EXIT_TYPE, -1);
        this.flag_exit_sdk = bundle2.getBoolean(ZhiChiConstant.FLAG_EXIT_SDK, false);
        this.mConfig = (SobotLeaveMsgConfig) bundle2.getSerializable(StPostMsgPresenter.INTENT_KEY_CONFIG);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getResLayoutId("sobot_fragment_post_msg"), viewGroup, false);
        this.mRootView = inflate;
        initView(inflate);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SobotDialogUtils.stopProgressDialog(getSobotActivity());
        super.onDestroy();
    }

    public void showHint(String str) {
        CustomToast.makeText(getSobotActivity(), str, 1000).show();
    }
}
