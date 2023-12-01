package com.igexin.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.foundation.h.i;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/FlymePushReceiver.class */
public class FlymePushReceiver extends MzPushMessageReceiver {
    public static final String CONTENT = "content";
    public static final String MSG_KEY_PAYLOAD = "gt_payload";
    public static final String MZ_STATUS_BAR_SMALL_ICON = "mz_push_notification_small_icon";
    public static final String TAG = "Assist_MZ";
    private Context context;
    private int statusBarIconId;

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            Log.d("Assist_MZ", "onMessage intent msg...");
            Log.d("Assist_MZ", "onMessage intent msg :" + intent.toUri(0));
            String stringExtra = intent.getStringExtra("content");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            MessageBean messageBean = new MessageBean(context, "payload", stringExtra);
            messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, String str) {
        try {
            Log.d("Assist_MZ", "onMessage receive msg ...");
            Log.d("Assist_MZ", "onMessage receive msg:".concat(String.valueOf(str)));
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            MessageBean messageBean = new MessageBean(context, "payload", str);
            messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        Log.d("Assist_MZ", "onNotificationArrived receive msg ...");
        Log.d("Assist_MZ", "onNotificationArrived receive msg:".concat(String.valueOf(mzPushMessage)));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        try {
            Log.d("Assist_MZ", "onNotificationClicked receive msg ...");
            Log.d("Assist_MZ", "onNotificationClicked receive msg:" + mzPushMessage.getTitle() + ":" + mzPushMessage.getContent() + ":" + mzPushMessage.getSelfDefineContentString());
            String selfDefineContentString = mzPushMessage.getSelfDefineContentString();
            if (context != null && !TextUtils.isEmpty(selfDefineContentString)) {
                JSONObject jSONObject = new JSONObject(selfDefineContentString);
                String str = selfDefineContentString;
                if (jSONObject.has(MSG_KEY_PAYLOAD)) {
                    str = jSONObject.getString(MSG_KEY_PAYLOAD);
                }
                if (!TextUtils.isEmpty(str)) {
                    MessageBean messageBean = new MessageBean(context, "payload", str);
                    messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
                    MessageManger.getInstance().addMessage(messageBean);
                }
            }
            AssistUtils.startGetuiService(context);
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        Log.d("Assist_MZ", "onPushStatus:".concat(String.valueOf(pushSwitchStatus)));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.context = context.getApplicationContext();
        super.onReceive(context, intent);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegister(Context context, String str) {
        try {
            Log.d("Assist_MZ", "onRegister :".concat(String.valueOf(str)));
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.MZ_PREFIX.concat(String.valueOf(str))));
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        try {
            Log.d("Assist_MZ", "onRegisterStatus :".concat(String.valueOf(registerStatus)));
            String pushId = registerStatus.getPushId();
            if (context == null || TextUtils.isEmpty(pushId)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.MZ_PREFIX.concat(String.valueOf(pushId))));
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegister(Context context, boolean z) {
        Log.d("Assist_MZ", "onUnRegister:".concat(String.valueOf(z)));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
        Log.d("Assist_MZ", "onUnRegisterStatus:".concat(String.valueOf(unRegisterStatus)));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        try {
            if (this.statusBarIconId != 0) {
                pushNotificationBuilder.setStatusBarIcon(this.statusBarIconId);
            } else if (this.context != null) {
                int identifier = this.context.getResources().getIdentifier("mz_push_notification_small_icon", i.f7952c, this.context.getPackageName());
                this.statusBarIconId = identifier;
                if (identifier != 0) {
                    pushNotificationBuilder.setStatusBarIcon(identifier);
                }
            }
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }
}
