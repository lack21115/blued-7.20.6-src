package com.igexin.sdk;

import android.content.Context;
import android.util.Log;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.service.CompatibleDataMessageCallbackService;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/OppoPushService.class */
public class OppoPushService extends CompatibleDataMessageCallbackService {
    public static final String TAG = "Assist_OP_PS";

    @Override // com.heytap.msp.push.service.CompatibleDataMessageCallbackService, com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context context, DataMessage dataMessage) {
        try {
            Log.d(TAG, "processMessage receive app meaasge ...");
            Log.d(TAG, "processMessage receive app meaasge:".concat(String.valueOf(dataMessage)));
            if (context != null && dataMessage != null) {
                MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, dataMessage.getContent());
                messageBean.setMessageSource(AssistPushConsts.OPPO_PREFIX);
                MessageManger.getInstance().addMessage(messageBean);
            }
            AssistUtils.startGetuiService(context);
        } catch (Throwable th) {
            Log.d(TAG, th.getMessage());
        }
    }
}
