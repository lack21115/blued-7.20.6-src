package com.sobot.chat.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.SobotMuItiPostMsgActivty;
import com.sobot.chat.activity.SobotPostMsgActivity;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.widget.dialog.SobotPostMsgTmpListActivity;
import com.sobot.chat.widget.dialog.SobotPostMsgTmpListDialog;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/presenter/StPostMsgPresenter.class */
public class StPostMsgPresenter {
    public static final String INTENT_KEY_COMPANYID = "intent_key_companyid";
    public static final String INTENT_KEY_CONFIG = "intent_key_config";
    public static final String INTENT_KEY_CUSTOMERID = "intent_key_customerid";
    public static final String INTENT_KEY_CUS_FIELDS = "intent_key_cus_fields";
    public static final String INTENT_KEY_GROUPID = "intent_key_groupid";
    public static final String INTENT_KEY_IS_SHOW_TICKET = "intent_key_is_show_ticket";
    public static final String INTENT_KEY_UID = "intent_key_uid";
    ZhiChiApi mApi;
    private Object mCancelTag;
    private Context mContext;
    private ObtainTemplateListDelegate mDelegate;
    private SobotPostMsgTmpListDialog mDialog;
    private boolean mIsActive;
    private boolean mIsRunning;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/presenter/StPostMsgPresenter$ObtainTemplateListDelegate.class */
    public interface ObtainTemplateListDelegate {
        void onSuccess(Intent intent);
    }

    private StPostMsgPresenter() {
        this.mIsActive = true;
    }

    private StPostMsgPresenter(Object obj, Context context) {
        this.mIsActive = true;
        this.mCancelTag = obj;
        this.mContext = context;
        this.mIsActive = true;
        this.mApi = SobotMsgManager.getInstance(context).getZhiChiApi();
    }

    public static StPostMsgPresenter newInstance(Object obj, Context context) {
        return new StPostMsgPresenter(obj, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReqFailure(Exception exc, String str) {
        this.mIsRunning = false;
        if (this.mIsActive) {
            ToastUtil.showToast(this.mContext, str);
        }
    }

    public void destory() {
        SobotPostMsgTmpListDialog sobotPostMsgTmpListDialog = this.mDialog;
        if (sobotPostMsgTmpListDialog != null && sobotPostMsgTmpListDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mIsActive = false;
        HttpUtils.getInstance().cancelTag(this.mCancelTag);
    }

    public Intent newPostMsgIntent(String str, SobotLeaveMsgConfig sobotLeaveMsgConfig) {
        Intent intent = new Intent(this.mContext, SobotPostMsgActivity.class);
        intent.putExtra("intent_key_uid", str);
        intent.putExtra(INTENT_KEY_CONFIG, sobotLeaveMsgConfig);
        return intent;
    }

    public void obtainTemplateList(final String str, String str2, final boolean z, final boolean z2, ObtainTemplateListDelegate obtainTemplateListDelegate) {
        if (TextUtils.isEmpty(str) || this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        this.mDelegate = obtainTemplateListDelegate;
        this.mApi.getWsTemplate(this.mCancelTag, str, str2, new StringResultCallBack<ArrayList<SobotPostMsgTemplate>>() { // from class: com.sobot.chat.presenter.StPostMsgPresenter.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str3) {
                StPostMsgPresenter.this.processReqFailure(exc, str3);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ArrayList<SobotPostMsgTemplate> arrayList) {
                if (!StPostMsgPresenter.this.mIsActive) {
                    StPostMsgPresenter.this.mIsRunning = false;
                } else if (arrayList == null || arrayList.size() <= 0) {
                } else {
                    if (arrayList.size() == 1) {
                        StPostMsgPresenter.this.obtainTmpConfig(str, arrayList.get(0).getTemplateId());
                    } else if (!SobotApi.getSwitchMarkStatus(1) || !SobotApi.getSwitchMarkStatus(4)) {
                        StPostMsgPresenter stPostMsgPresenter = StPostMsgPresenter.this;
                        stPostMsgPresenter.mDialog = stPostMsgPresenter.showTempListDialog((Activity) stPostMsgPresenter.mContext, arrayList, new SobotPostMsgTmpListDialog.SobotDialogListener() { // from class: com.sobot.chat.presenter.StPostMsgPresenter.1.1
                            @Override // com.sobot.chat.widget.dialog.SobotPostMsgTmpListDialog.SobotDialogListener
                            public void onListItemClick(SobotPostMsgTemplate sobotPostMsgTemplate) {
                                StPostMsgPresenter.this.obtainTmpConfig(str, sobotPostMsgTemplate.getTemplateId());
                            }
                        });
                        StPostMsgPresenter.this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sobot.chat.presenter.StPostMsgPresenter.1.2
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                StPostMsgPresenter.this.mIsRunning = false;
                            }
                        });
                    } else {
                        StPostMsgPresenter.this.mIsRunning = false;
                        Intent intent = new Intent(StPostMsgPresenter.this.mContext, SobotPostMsgTmpListActivity.class);
                        intent.putExtra("sobotPostMsgTemplateList", arrayList);
                        intent.putExtra("uid", str);
                        intent.putExtra("flag_exit_sdk", z);
                        intent.putExtra("isShowTicket", z2);
                        StPostMsgPresenter.this.mContext.startActivity(intent);
                    }
                }
            }
        });
    }

    public void obtainTmpConfig(final String str, String str2) {
        this.mApi.getMsgTemplateConfig(this.mCancelTag, str, str2, new StringResultCallBack<SobotLeaveMsgConfig>() { // from class: com.sobot.chat.presenter.StPostMsgPresenter.2
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str3) {
                StPostMsgPresenter.this.processReqFailure(exc, str3);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotLeaveMsgConfig sobotLeaveMsgConfig) {
                if (!StPostMsgPresenter.this.mIsActive) {
                    StPostMsgPresenter.this.mIsRunning = false;
                    return;
                }
                if (sobotLeaveMsgConfig != null && StPostMsgPresenter.this.mDelegate != null) {
                    StPostMsgPresenter.this.mDelegate.onSuccess(StPostMsgPresenter.this.newPostMsgIntent(str, sobotLeaveMsgConfig));
                }
                StPostMsgPresenter.this.mIsRunning = false;
            }
        });
    }

    public void obtainTmpConfigToMuItiPostMsg(final String str, String str2) {
        this.mApi.getMsgTemplateConfig(this.mCancelTag, str, str2, new StringResultCallBack<SobotLeaveMsgConfig>() { // from class: com.sobot.chat.presenter.StPostMsgPresenter.3
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str3) {
                StPostMsgPresenter.this.processReqFailure(exc, str3);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotLeaveMsgConfig sobotLeaveMsgConfig) {
                Intent intent = new Intent(StPostMsgPresenter.this.mContext, SobotMuItiPostMsgActivty.class);
                intent.putExtra("intent_key_uid", str);
                intent.putExtra(StPostMsgPresenter.INTENT_KEY_CONFIG, sobotLeaveMsgConfig);
                StPostMsgPresenter.this.mContext.startActivity(intent);
            }
        });
    }

    public SobotPostMsgTmpListDialog showTempListDialog(Activity activity, ArrayList<SobotPostMsgTemplate> arrayList, SobotPostMsgTmpListDialog.SobotDialogListener sobotDialogListener) {
        if (activity == null || arrayList == null || sobotDialogListener == null) {
            return null;
        }
        SobotPostMsgTmpListDialog sobotPostMsgTmpListDialog = new SobotPostMsgTmpListDialog(activity, arrayList, sobotDialogListener);
        sobotPostMsgTmpListDialog.setCanceledOnTouchOutside(true);
        sobotPostMsgTmpListDialog.show();
        return sobotPostMsgTmpListDialog;
    }
}
