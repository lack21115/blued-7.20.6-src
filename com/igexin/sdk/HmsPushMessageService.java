package com.igexin.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/HmsPushMessageService.class */
public class HmsPushMessageService extends HmsMessageService {
    public static final String TAG = "Assist_HW";

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            if (remoteMessage == null) {
                Log.e("Assist_HW", "Received message entity is null!");
                return;
            }
            Log.i("Assist_HW", "Received payload");
            if (TextUtils.isEmpty(remoteMessage.getData())) {
                return;
            }
            MessageBean messageBean = new MessageBean(getApplicationContext(), AssistPushConsts.MSG_TYPE_PAYLOAD, remoteMessage.getData());
            messageBean.setMessageSource(AssistPushConsts.HW_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_HW", th.getMessage());
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        try {
            Log.i("Assist_HW", "onNewToken :" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Context applicationContext = getApplicationContext();
            MessageManger.getInstance().addMessage(new MessageBean(applicationContext, "token", AssistPushConsts.HW_PREFIX + str));
        } catch (Throwable th) {
            Log.d("Assist_HW", th.getMessage());
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str, Bundle bundle) {
        try {
            Log.i("Assist_HW", "onNewTokenAndBundle :" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Context applicationContext = getApplicationContext();
            MessageManger.getInstance().addMessage(new MessageBean(applicationContext, "token", AssistPushConsts.HW_PREFIX + str));
        } catch (Throwable th) {
            Log.d("Assist_HW", th.getMessage());
        }
    }
}
