package com.sobot.chat.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.adapter.SobotPicListAdapter;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.PostParamModel;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveMsgParamModel;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiUploadAppFileModelResult;
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
import com.sobot.chat.utils.SobotSerializableMap;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotMuItiPostMsgActivty.class */
public class SobotMuItiPostMsgActivty extends SobotDialogBaseActivity implements View.OnClickListener, ISobotCusField {
    private SobotPicListAdapter adapter;
    private TextView email_hint_input_label;
    private boolean flag_exit_sdk;
    private Information information;
    private SobotLeaveMsgConfig mConfig;
    private ArrayList<SobotFieldModel> mCusAddFields;
    private ArrayList<SobotFieldModel> mFields;
    private SobotSelectPicDialog menuWindow;
    private TextView phone_hint_input_label;
    protected SobotDeleteWorkOrderDialog seleteMenuWindow;
    private LinearLayout sobot_btn_cancle;
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
    private TextView sobot_tv_title;
    private TextView title_hint_input_lable;
    private ArrayList<ZhiChiUploadAppFileModelResult> pic_list = new ArrayList<>();
    private String mUid = "";
    private String uid = "";
    private String mGroupId = "";
    private int flag_exit_type = -1;
    private ChatUtils.SobotSendFileListener sendFileListener = new ChatUtils.SobotSendFileListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.12
        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onError() {
            SobotDialogUtils.stopProgressDialog(SobotMuItiPostMsgActivty.this.getSobotBaseActivity());
        }

        @Override // com.sobot.chat.utils.ChatUtils.SobotSendFileListener
        public void onSuccess(final String str) {
            ZhiChiApi zhiChiApi = SobotMuItiPostMsgActivty.this.zhiChiApi;
            SobotMuItiPostMsgActivty sobotMuItiPostMsgActivty = SobotMuItiPostMsgActivty.this;
            zhiChiApi.fileUploadForPostMsg(sobotMuItiPostMsgActivty, sobotMuItiPostMsgActivty.mConfig.getCompanyId(), SobotMuItiPostMsgActivty.this.uid, str, new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.12.1
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str2) {
                    SobotDialogUtils.stopProgressDialog(SobotMuItiPostMsgActivty.this.getSobotBaseActivity());
                    SobotMuItiPostMsgActivty.this.showHint(ResourceUtils.getResString(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_net_work_err"));
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(ZhiChiMessage zhiChiMessage) {
                    SobotDialogUtils.stopProgressDialog(SobotMuItiPostMsgActivty.this.getSobotBaseActivity());
                    if (zhiChiMessage.getData() != null) {
                        ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = new ZhiChiUploadAppFileModelResult();
                        zhiChiUploadAppFileModelResult.setFileUrl(zhiChiMessage.getData().getUrl());
                        zhiChiUploadAppFileModelResult.setFileLocalPath(str);
                        zhiChiUploadAppFileModelResult.setViewState(1);
                        SobotMuItiPostMsgActivty.this.adapter.addData(zhiChiUploadAppFileModelResult);
                    }
                }
            });
        }
    };
    private View.OnClickListener itemsOnClick = new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            SobotMuItiPostMsgActivty.this.menuWindow.dismiss();
            if (view.getId() == SobotMuItiPostMsgActivty.this.getResId("btn_take_photo")) {
                LogUtils.i("拍照");
                SobotMuItiPostMsgActivty.this.selectPicFromCameraBySys();
            }
            if (view.getId() == SobotMuItiPostMsgActivty.this.getResId("btn_pick_photo")) {
                LogUtils.i("选择照片");
                SobotMuItiPostMsgActivty.this.selectPicFromLocal();
            }
            if (view.getId() == SobotMuItiPostMsgActivty.this.getResId("btn_pick_vedio")) {
                LogUtils.i("选择视频");
                SobotMuItiPostMsgActivty.this.selectVedioFromLocal();
            }
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:67:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkSubmit() {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.activity.SobotMuItiPostMsgActivty.checkSubmit():void");
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

    private void initPicListView() {
        this.sobot_post_msg_pic = (GridView) findViewById(getResId("sobot_post_msg_pic"));
        SobotPicListAdapter sobotPicListAdapter = new SobotPicListAdapter(getSobotBaseActivity(), this.pic_list);
        this.adapter = sobotPicListAdapter;
        this.sobot_post_msg_pic.setAdapter((ListAdapter) sobotPicListAdapter);
        this.adapter.setOnClickItemViewListener(new SobotPicListAdapter.ViewClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.10
            @Override // com.sobot.chat.adapter.SobotPicListAdapter.ViewClickListener
            public void clickView(View view, int i, int i2) {
                ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult;
                KeyboardUtil.hideKeyboard(view);
                if (i2 == 0) {
                    SobotMuItiPostMsgActivty.this.menuWindow = new SobotSelectPicDialog(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), SobotMuItiPostMsgActivty.this.itemsOnClick);
                    SobotMuItiPostMsgActivty.this.menuWindow.show();
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    String resString = ResourceUtils.getResString(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_do_you_delete_picture");
                    if (SobotMuItiPostMsgActivty.this.adapter == null || SobotMuItiPostMsgActivty.this.adapter.getPicList() == null) {
                        return;
                    }
                    ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult2 = SobotMuItiPostMsgActivty.this.adapter.getPicList().get(i);
                    String str = resString;
                    if (zhiChiUploadAppFileModelResult2 != null) {
                        str = resString;
                        if (!TextUtils.isEmpty(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                            str = resString;
                            if (MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult2.getFileLocalPath())) {
                                str = ResourceUtils.getResString(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_do_you_delete_video");
                            }
                        }
                    }
                    if (SobotMuItiPostMsgActivty.this.seleteMenuWindow != null) {
                        SobotMuItiPostMsgActivty.this.seleteMenuWindow.dismiss();
                        SobotMuItiPostMsgActivty.this.seleteMenuWindow = null;
                    }
                    if (SobotMuItiPostMsgActivty.this.seleteMenuWindow == null) {
                        SobotMuItiPostMsgActivty.this.seleteMenuWindow = new SobotDeleteWorkOrderDialog(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), str, new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.10.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                Tracker.onClick(view2);
                                SobotMuItiPostMsgActivty.this.seleteMenuWindow.dismiss();
                                if (view2.getId() == SobotMuItiPostMsgActivty.this.getResId("btn_pick_photo")) {
                                    Log.e("onClick: ", SobotMuItiPostMsgActivty.this.seleteMenuWindow.getPosition() + "");
                                    SobotMuItiPostMsgActivty.this.pic_list.remove(SobotMuItiPostMsgActivty.this.seleteMenuWindow.getPosition());
                                    SobotMuItiPostMsgActivty.this.adapter.restDataView();
                                }
                            }
                        });
                    }
                    SobotMuItiPostMsgActivty.this.seleteMenuWindow.setPosition(i);
                    SobotMuItiPostMsgActivty.this.seleteMenuWindow.show();
                } else {
                    LogUtils.i("当前选择图片位置：" + i);
                    if (SobotMuItiPostMsgActivty.this.adapter == null || SobotMuItiPostMsgActivty.this.adapter.getPicList() == null || (zhiChiUploadAppFileModelResult = SobotMuItiPostMsgActivty.this.adapter.getPicList().get(i)) == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) || !MediaFileUtils.isVideoFileType(zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                        if (SobotOption.imagePreviewListener != null) {
                            if (SobotOption.imagePreviewListener.onPreviewImage(SobotMuItiPostMsgActivty.this.getSobotBaseContext(), TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath())) {
                                return;
                            }
                        }
                        Intent intent = new Intent(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), SobotPhotoActivity.class);
                        intent.putExtra("imageUrL", TextUtils.isEmpty(zhiChiUploadAppFileModelResult.getFileLocalPath()) ? zhiChiUploadAppFileModelResult.getFileUrl() : zhiChiUploadAppFileModelResult.getFileLocalPath());
                        SobotMuItiPostMsgActivty.this.getSobotBaseActivity().startActivity(intent);
                        return;
                    }
                    File file = new File(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    SobotCacheFile sobotCacheFile = new SobotCacheFile();
                    sobotCacheFile.setFileName(file.getName());
                    sobotCacheFile.setUrl(zhiChiUploadAppFileModelResult.getFileUrl());
                    sobotCacheFile.setFilePath(zhiChiUploadAppFileModelResult.getFileLocalPath());
                    sobotCacheFile.setFileType(FileTypeConfig.getFileType(FileUtil.getFileEndWith(zhiChiUploadAppFileModelResult.getFileLocalPath())));
                    sobotCacheFile.setMsgId("" + System.currentTimeMillis());
                    SobotMuItiPostMsgActivty.this.getSobotBaseActivity().startActivity(SobotVideoActivity.newIntent(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), sobotCacheFile));
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
            HtmlTools.getInstance(getSobotBaseActivity().getApplicationContext()).setRichText(this.sobot_tv_post_msg, this.information.getLeaveMsgGuideContent().replace("<br/>", ""), ResourceUtils.getIdByName(getSobotBaseActivity(), "color", "sobot_postMsg_url_color"));
        } else if (TextUtils.isEmpty(this.mConfig.getMsgTxt())) {
            this.sobot_tv_post_msg.setVisibility(8);
        } else {
            SobotLeaveMsgConfig sobotLeaveMsgConfig2 = this.mConfig;
            sobotLeaveMsgConfig2.setMsgTxt(sobotLeaveMsgConfig2.getMsgTxt().replace("<br/>", "").replace("<p>", "").replace("</p>", "").replace("\n", ""));
            HtmlTools.getInstance(getSobotBaseActivity().getApplicationContext()).setRichText(this.sobot_tv_post_msg, this.mConfig.getMsgTxt(), ResourceUtils.getIdByName(getSobotBaseActivity(), "color", "sobot_postMsg_url_color"));
        }
        this.sobot_post_msg_layout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                KeyboardUtil.hideKeyboard(SobotMuItiPostMsgActivty.this.sobot_post_msg_layout);
            }
        });
    }

    private void postMsg(String str, String str2, String str3) {
        Map saveFieldNameAndVal;
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
        postParamModel.setTicketFrom("21");
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
        Information information = this.information;
        if (information != null && information.getLeaveParamsExtends() != null) {
            postParamModel.setParamsExtends(SobotJsonUtils.toJson(this.information.getLeaveParamsExtends()));
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.mConfig.isTicketTitleShowFlag()) {
            String replace = this.sobot_post_title_lable.getText().toString().replace(" *", "");
            String str4 = str3;
            if (StringUtils.isEmpty(str3)) {
                str4 = " - -";
            }
            linkedHashMap.put(replace, str4);
        }
        if (this.mConfig.isTicketTypeFlag()) {
            linkedHashMap.put(this.sobot_post_question_lable.getText().toString().replace(" *", ""), StringUtils.isEmpty(this.sobot_post_question_type.getText().toString()) ? " - -" : this.sobot_post_question_type.getText().toString());
        }
        ArrayList<SobotFieldModel> arrayList2 = this.mFields;
        if (arrayList2 != null && arrayList2.size() > 0 && (saveFieldNameAndVal = StCusFieldPresenter.getSaveFieldNameAndVal(this.mFields)) != null) {
            linkedHashMap.putAll(saveFieldNameAndVal);
        }
        linkedHashMap.put(getResString("sobot_problem_description"), StringUtils.isEmpty(this.sobot_et_content.getText().toString()) ? " - -" : this.sobot_et_content.getText().toString());
        if (this.mConfig.isEnclosureShowFlag()) {
            linkedHashMap.put(getResString("sobot_enclosure_string"), StringUtils.isEmpty(getFileNameStr()) ? " - -" : getFileNameStr());
        }
        if (this.mConfig.isEmailShowFlag()) {
            String replace2 = this.sobot_post_email_lable.getText().toString().replace(" *", "");
            String str5 = str2;
            if (StringUtils.isEmpty(str2)) {
                str5 = " - -";
            }
            linkedHashMap.put(replace2, str5);
        }
        if (this.mConfig.isTelShowFlag()) {
            String replace3 = this.sobot_post_phone_lable.getText().toString().replace(" *", "");
            String str6 = str;
            if (StringUtils.isEmpty(str)) {
                str6 = " - -";
            }
            linkedHashMap.put(replace3, str6);
        }
        this.zhiChiApi.postMsg(this, postParamModel, new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.9
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str7) {
                try {
                    SobotMuItiPostMsgActivty.this.showHint(ResourceUtils.getResString(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_try_again"));
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (Integer.parseInt(commonModelBase.getStatus()) == 0) {
                    SobotMuItiPostMsgActivty.this.showHint(commonModelBase.getMsg());
                } else if (Integer.parseInt(commonModelBase.getStatus()) != 1 || SobotMuItiPostMsgActivty.this.getSobotBaseActivity() == null) {
                } else {
                    KeyboardUtil.hideKeyboard(SobotMuItiPostMsgActivty.this.getSobotBaseActivity().getCurrentFocus());
                    Intent intent = new Intent();
                    intent.setAction(ZhiChiConstants.SOBOT_CHAT_MUITILEAVEMSG_TO_CHATLIST);
                    Bundle bundle = new Bundle();
                    SobotSerializableMap sobotSerializableMap = new SobotSerializableMap();
                    sobotSerializableMap.setMap(linkedHashMap);
                    bundle.putSerializable("leaveMsgData", sobotSerializableMap);
                    intent.putExtras(bundle);
                    CommonUtils.sendLocalBroadcast(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), intent);
                    SobotMuItiPostMsgActivty.this.finish();
                }
            }
        });
    }

    private void setCusFieldValue() {
        String formatCusFieldVal = StCusFieldPresenter.formatCusFieldVal(getSobotBaseActivity(), this.sobot_post_customer_field, this.mFields);
        if (TextUtils.isEmpty(formatCusFieldVal)) {
            checkSubmit();
        } else {
            showHint(formatCusFieldVal);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_muit_post_msg");
    }

    public String getFileNameStr() {
        String str = "";
        if (!this.mConfig.isEnclosureShowFlag()) {
            return "";
        }
        ArrayList<ZhiChiUploadAppFileModelResult> picList = this.adapter.getPicList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= picList.size()) {
                return str;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(picList.get(i2).getFileLocalPath())) {
                str2 = str + picList.get(i2).getFileLocalPath().substring(picList.get(i2).getFileLocalPath().lastIndexOf(BridgeUtil.SPLIT_MARK) + 1);
            }
            str = str2;
            if (i2 != picList.size() - 1) {
                str = str2 + "<br/>";
            }
            i = i2 + 1;
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
            str = str + picList.get(i2).getFileUrl() + ";";
            i = i2 + 1;
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        this.information = (Information) SharedPreferencesUtil.getObject(getSobotBaseActivity(), ZhiChiConstant.sobot_last_current_info);
        this.zhiChiApi.getTemplateFieldsInfo(this, this.uid, this.mConfig.getTemplateId(), new StringResultCallBack<SobotLeaveMsgParamModel>() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.8
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                try {
                    SobotMuItiPostMsgActivty.this.showHint(ResourceUtils.getResString(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_try_again"));
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotLeaveMsgParamModel sobotLeaveMsgParamModel) {
                if (sobotLeaveMsgParamModel == null || sobotLeaveMsgParamModel.getField() == null || sobotLeaveMsgParamModel.getField().size() == 0) {
                    return;
                }
                SobotMuItiPostMsgActivty.this.sobot_post_customer_line.setVisibility(0);
                SobotMuItiPostMsgActivty.this.sobot_post_customer_sec_line.setVisibility(0);
                SobotMuItiPostMsgActivty.this.mFields = sobotLeaveMsgParamModel.getField();
                StCusFieldPresenter.addWorkOrderCusFields(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), SobotMuItiPostMsgActivty.this.mFields, SobotMuItiPostMsgActivty.this.sobot_post_customer_field, SobotMuItiPostMsgActivty.this);
            }
        });
        msgFilter();
        editTextSetHint();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_tv_title"));
        this.sobot_tv_title = textView;
        textView.setText(getResString("sobot_write_info_string"));
        LinearLayout linearLayout = (LinearLayout) findViewById(ResourceUtils.getIdByName(this, "id", "sobot_btn_cancle"));
        this.sobot_btn_cancle = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotMuItiPostMsgActivty.this.finish();
            }
        });
        ZhiChiInitModeBase zhiChiInitModeBase = (ZhiChiInitModeBase) SharedPreferencesUtil.getObject(getSobotBaseContext(), ZhiChiConstant.sobot_last_current_initModel);
        this.mUid = getIntent().getStringExtra("intent_key_uid");
        this.mConfig = (SobotLeaveMsgConfig) getIntent().getSerializableExtra(StPostMsgPresenter.INTENT_KEY_CONFIG);
        this.mGroupId = getIntent().getStringExtra(StPostMsgPresenter.INTENT_KEY_GROUPID);
        if (this.mConfig == null) {
            Information information = (Information) SharedPreferencesUtil.getObject(getSobotBaseContext(), ZhiChiConstant.sobot_last_current_info);
            SobotLeaveMsgConfig sobotLeaveMsgConfig = new SobotLeaveMsgConfig();
            this.mConfig = sobotLeaveMsgConfig;
            sobotLeaveMsgConfig.setEmailFlag(zhiChiInitModeBase.isEmailFlag());
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
        this.uid = bundle.getString("intent_key_uid");
        this.mGroupId = bundle.getString(StPostMsgPresenter.INTENT_KEY_GROUPID);
        this.mCusAddFields = (ArrayList) bundle.getSerializable(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS);
        this.flag_exit_type = bundle.getInt(ZhiChiConstant.FLAG_EXIT_TYPE, -1);
        this.flag_exit_sdk = bundle.getBoolean(ZhiChiConstant.FLAG_EXIT_SDK, false);
        this.mConfig = (SobotLeaveMsgConfig) bundle.getSerializable(StPostMsgPresenter.INTENT_KEY_CONFIG);
        this.sobot_ll_content_img = (LinearLayout) findViewById(getResId("sobot_ll_content_img"));
        this.sobot_post_phone = (EditText) findViewById(getResId("sobot_post_phone"));
        this.sobot_post_email = (EditText) findViewById(getResId("sobot_post_email"));
        this.sobot_post_title = (EditText) findViewById(getResId("sobot_post_title"));
        this.sobot_frist_line = findViewById(getResId("sobot_frist_line"));
        this.sobot_post_title_line = findViewById(getResId("sobot_post_title_line"));
        this.sobot_post_question_line = findViewById(getResId("sobot_post_question_line"));
        this.sobot_post_customer_line = findViewById(getResId("sobot_post_customer_line"));
        this.sobot_post_title_sec_line = findViewById(getResId("sobot_post_title_sec_line"));
        this.sobot_post_question_sec_line = findViewById(getResId("sobot_post_question_sec_line"));
        this.sobot_post_customer_sec_line = findViewById(getResId("sobot_post_customer_sec_line"));
        this.sobot_phone_line = findViewById(getResId("sobot_phone_line"));
        this.sobot_et_content = (EditText) findViewById(getResId("sobot_post_et_content"));
        this.sobot_tv_post_msg = (TextView) findViewById(getResId("sobot_tv_post_msg"));
        this.sobot_post_email_lable = (TextView) findViewById(getResId("sobot_post_email_lable"));
        this.sobot_post_phone_lable = (TextView) findViewById(getResId("sobot_post_phone_lable"));
        this.sobot_post_title_lable = (TextView) findViewById(getResId("sobot_post_title_lable"));
        this.sobot_post_lable = (TextView) findViewById(getResId("sobot_post_question_lable"));
        this.sobot_post_lable.setText(Html.fromHtml(getResString("sobot_problem_types") + "<font color='#f9676f'>&nbsp;*</font>"));
        this.sobot_post_question_lable = (TextView) findViewById(getResId("sobot_post_question_lable"));
        this.sobot_post_question_type = (TextView) findViewById(getResId("sobot_post_question_type"));
        this.sobot_post_msg_layout = (LinearLayout) findViewById(getResId("sobot_post_msg_layout"));
        this.sobot_enclosure_container = (LinearLayout) findViewById(getResId("sobot_enclosure_container"));
        this.sobot_post_customer_field = (LinearLayout) findViewById(getResId("sobot_post_customer_field"));
        this.sobot_post_email_rl = (RelativeLayout) findViewById(getResId("sobot_post_email_rl"));
        TextView textView2 = (TextView) findViewById(getResId("sobot_post_email_lable_hint"));
        this.email_hint_input_label = textView2;
        textView2.setHint(ResourceUtils.getResString(getSobotBaseActivity(), "sobot_please_input"));
        TextView textView3 = (TextView) findViewById(getResId("sobot_post_title_lable_hint"));
        this.title_hint_input_lable = textView3;
        textView3.setHint(ResourceUtils.getResString(getSobotBaseActivity(), "sobot_please_input"));
        this.sobot_post_phone_rl = (RelativeLayout) findViewById(getResId("sobot_post_phone_rl"));
        TextView textView4 = (TextView) findViewById(getResId("sobot_post_phone_lable_hint"));
        this.phone_hint_input_label = textView4;
        textView4.setHint(ResourceUtils.getResString(getSobotBaseActivity(), "sobot_please_input"));
        this.sobot_post_title_rl = (RelativeLayout) findViewById(getResId("sobot_post_title_rl"));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(getResId("sobot_post_question_ll"));
        this.sobot_post_question_ll = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(getResId("sobot_tv_problem_description"));
        this.sobot_tv_problem_description = textView5;
        textView5.setText(ResourceUtils.getResString(getSobotBaseActivity(), "sobot_problem_description"));
        Button button = (Button) findViewById(getResId("sobot_btn_submit"));
        this.sobot_btn_submit = button;
        button.setText(ResourceUtils.getResString(getSobotBaseActivity(), "sobot_btn_submit_text"));
        this.sobot_btn_submit.setOnClickListener(this);
        this.sobot_post_customer_field.setVisibility(8);
        if (this.mConfig.isEmailShowFlag()) {
            this.sobot_post_email_rl.setVisibility(0);
            this.sobot_post_email_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotMuItiPostMsgActivty.this.sobot_post_email.setVisibility(0);
                    SobotMuItiPostMsgActivty.this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray2")));
                    SobotMuItiPostMsgActivty.this.sobot_post_email_lable.setTextSize(12.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_email.setFocusable(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_email.setFocusableInTouchMode(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_email.requestFocus();
                    SobotMuItiPostMsgActivty.this.email_hint_input_label.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotMuItiPostMsgActivty.this.sobot_post_email);
                }
            });
        } else {
            this.sobot_post_email_rl.setVisibility(8);
        }
        this.sobot_post_email.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    SobotMuItiPostMsgActivty.this.email_hint_input_label.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotMuItiPostMsgActivty.this.sobot_post_email.getText().toString().trim())) {
                    SobotMuItiPostMsgActivty.this.sobot_post_email_lable.setTextSize(14.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray1")));
                    SobotMuItiPostMsgActivty.this.sobot_post_email.setVisibility(8);
                    SobotMuItiPostMsgActivty.this.email_hint_input_label.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isTelShowFlag()) {
            this.sobot_post_phone_rl.setVisibility(0);
            this.sobot_post_phone_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone.setVisibility(0);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray2")));
                    SobotMuItiPostMsgActivty.this.sobot_post_phone_lable.setTextSize(12.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone.setFocusable(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone.setFocusableInTouchMode(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone.requestFocus();
                    SobotMuItiPostMsgActivty.this.phone_hint_input_label.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotMuItiPostMsgActivty.this.sobot_post_phone);
                }
            });
        } else {
            this.sobot_post_phone_rl.setVisibility(8);
        }
        this.sobot_post_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    SobotMuItiPostMsgActivty.this.phone_hint_input_label.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotMuItiPostMsgActivty.this.sobot_post_phone.getText().toString().trim())) {
                    SobotMuItiPostMsgActivty.this.sobot_post_phone_lable.setTextSize(14.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray1")));
                    SobotMuItiPostMsgActivty.this.sobot_post_phone.setVisibility(8);
                    SobotMuItiPostMsgActivty.this.phone_hint_input_label.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isTicketTitleShowFlag()) {
            this.sobot_post_title_rl.setVisibility(0);
            this.sobot_post_title_line.setVisibility(0);
            this.sobot_post_title_sec_line.setVisibility(0);
            this.sobot_post_title_rl.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotMuItiPostMsgActivty.this.sobot_post_title.setVisibility(0);
                    SobotMuItiPostMsgActivty.this.sobot_post_title_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray2")));
                    SobotMuItiPostMsgActivty.this.sobot_post_title_lable.setTextSize(12.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_title.setFocusable(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_title.setFocusableInTouchMode(true);
                    SobotMuItiPostMsgActivty.this.sobot_post_title.requestFocus();
                    SobotMuItiPostMsgActivty.this.title_hint_input_lable.setVisibility(8);
                    KeyboardUtil.showKeyboard(SobotMuItiPostMsgActivty.this.sobot_post_title);
                }
            });
        } else {
            this.sobot_post_title_rl.setVisibility(8);
        }
        this.sobot_post_title.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.activity.SobotMuItiPostMsgActivty.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    SobotMuItiPostMsgActivty.this.title_hint_input_lable.setVisibility(8);
                } else if (TextUtils.isEmpty(SobotMuItiPostMsgActivty.this.sobot_post_title.getText().toString().trim())) {
                    SobotMuItiPostMsgActivty.this.sobot_post_title_lable.setTextSize(14.0f);
                    SobotMuItiPostMsgActivty.this.sobot_post_title_lable.setTextColor(ContextCompat.getColor(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), ResourceUtils.getResColorId(SobotMuItiPostMsgActivty.this.getSobotBaseActivity(), "sobot_common_gray1")));
                    SobotMuItiPostMsgActivty.this.sobot_post_title.setVisibility(8);
                    SobotMuItiPostMsgActivty.this.title_hint_input_lable.setVisibility(0);
                }
            }
        });
        if (this.mConfig.isEmailShowFlag()) {
            this.sobot_frist_line.setVisibility(0);
        } else {
            this.sobot_frist_line.setVisibility(8);
        }
        this.sobot_phone_line.setVisibility(this.mConfig.isTelShowFlag() ? 0 : 8);
        Information information2 = this.information;
        String user_tels = information2 != null ? information2.getUser_tels() : "";
        if (this.mConfig.isTelShowFlag() && !TextUtils.isEmpty(user_tels)) {
            this.sobot_post_phone.setVisibility(0);
            this.sobot_post_phone.setText(user_tels);
            this.phone_hint_input_label.setVisibility(8);
            this.sobot_post_phone_lable.setTextColor(ContextCompat.getColor(getSobotBaseActivity(), ResourceUtils.getResColorId(getSobotBaseActivity(), "sobot_common_gray2")));
            this.sobot_post_phone_lable.setTextSize(12.0f);
        }
        Information information3 = this.information;
        String user_emails = information3 != null ? information3.getUser_emails() : "";
        if (this.mConfig.isEmailShowFlag() && !TextUtils.isEmpty(user_emails)) {
            this.sobot_post_email.setVisibility(0);
            this.sobot_post_email.setText(user_emails);
            this.email_hint_input_label.setVisibility(8);
            this.sobot_post_email_lable.setTextColor(ContextCompat.getColor(getSobotBaseActivity(), ResourceUtils.getResColorId(getSobotBaseActivity(), "sobot_common_gray2")));
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
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
                        uri = ImageUtils.getUri(intent, getSobotBaseActivity());
                    }
                    String path = ImageUtils.getPath(getSobotBaseActivity(), uri);
                    if (StringUtils.isEmpty(path)) {
                        showHint(getResString("sobot_did_not_get_picture_path"));
                    } else if (MediaFileUtils.isVideoFileType(path)) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(getSobotBaseActivity(), uri);
                            mediaPlayer.prepare();
                            if (mediaPlayer.getDuration() / 1000 > 15) {
                                ToastUtil.showToast(getSobotBaseActivity(), getResString("sobot_upload_vodie_length"));
                                return;
                            }
                            SobotDialogUtils.startProgressDialog(getSobotBaseActivity());
                            String encode = MD5Util.encode(path);
                            try {
                                SobotBaseActivity sobotBaseActivity = getSobotBaseActivity();
                                this.sendFileListener.onSuccess(FileUtil.saveImageFile(sobotBaseActivity, uri, encode + FileUtil.getFileEndWith(path), path));
                            } catch (Exception e) {
                                e.printStackTrace();
                                ToastUtil.showToast(getSobotBaseActivity(), ResourceUtils.getResString(getSobotBaseActivity(), "sobot_pic_type_error"));
                                return;
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        SobotDialogUtils.startProgressDialog(getSobotBaseActivity());
                        ChatUtils.sendPicByUriPost(getSobotBaseActivity(), uri, this.sendFileListener, false);
                    }
                }
            } else if (i == 702) {
                if (this.cameraFile == null || !this.cameraFile.exists()) {
                    showHint(getResString("sobot_pic_select_again"));
                } else {
                    SobotDialogUtils.startProgressDialog(getSobotBaseActivity());
                    ChatUtils.sendPicByFilePath(getSobotBaseActivity(), this.cameraFile.getAbsolutePath(), this.sendFileListener, true);
                }
            }
        }
        StCusFieldPresenter.onStCusFieldActivityResult(getSobotBaseActivity(), intent, this.mFields, this.sobot_post_customer_field);
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
                this.sobot_post_question_lable.setTextColor(ContextCompat.getColor(getSobotBaseActivity(), ResourceUtils.getResColorId(getSobotBaseActivity(), "sobot_common_gray2")));
                this.sobot_post_question_lable.setTextSize(12.0f);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_post_question_ll && this.mConfig.getType() != null && this.mConfig.getType().size() != 0) {
            Intent intent = new Intent(getSobotBaseActivity(), SobotPostCategoryActivity.class);
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
                StCusFieldPresenter.openTimePicker(getSobotBaseActivity(), view, i);
                return;
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                StCusFieldPresenter.startSobotCusFieldActivity(getSobotBaseActivity(), null, sobotFieldModel);
                return;
            case 9:
                if (sobotFieldModel == null || sobotFieldModel.getCusFieldDataInfoList() == null || sobotFieldModel.getCusFieldDataInfoList().size() <= 0) {
                    return;
                }
                Intent intent = new Intent(getContext(), SobotPostCascadeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cusField", sobotFieldModel);
                bundle.putSerializable("fieldId", sobotFieldModel.getCusFieldConfig().getFieldId());
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                startActivityForResult(intent, 304);
                return;
        }
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity, com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            if (SobotApi.getSwitchMarkStatus(1)) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(7);
            }
        }
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SobotDialogUtils.stopProgressDialog(getSobotBaseActivity());
        super.onDestroy();
    }

    public void showHint(String str) {
        CustomToast.makeText(getSobotBaseActivity(), str, 1000).show();
    }
}
