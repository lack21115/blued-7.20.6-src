package com.heytap.mcssdk.processor;

import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.mode.CallBackResult;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.ThreadUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/processor/CallBackResultProcessor.class */
public class CallBackResultProcessor implements Processor {
    /* JADX INFO: Access modifiers changed from: private */
    public void processCallBackResult(CallBackResult callBackResult, PushService pushService) {
        if (callBackResult == null) {
            LogUtil.e("message is null , please check param of parseCommandMessage(2)");
        } else if (pushService == null) {
            LogUtil.e("pushService is null , please check param of parseCommandMessage(2)");
        } else if (pushService.getPushCallback() == null) {
            LogUtil.e("pushService.getPushCallback() is null , please check param of parseCommandMessage(2)");
        } else {
            int command = callBackResult.getCommand();
            if (command == 12287) {
                ICallBackResultService pushCallback = pushService.getPushCallback();
                if (pushCallback != null) {
                    pushCallback.onError(callBackResult.getResponseCode(), callBackResult.getContent());
                }
            } else if (command == 12298) {
                pushService.getPushCallback().onSetPushTime(callBackResult.getResponseCode(), callBackResult.getContent());
            } else if (command == 12306) {
                pushService.getPushCallback().onGetPushStatus(callBackResult.getResponseCode(), Utils.parseInt(callBackResult.getContent()));
            } else if (command == 12309) {
                pushService.getPushCallback().onGetNotificationStatus(callBackResult.getResponseCode(), Utils.parseInt(callBackResult.getContent()));
            } else if (command == 12289) {
                if (callBackResult.getResponseCode() == 0) {
                    pushService.setRegisterID(callBackResult.getContent());
                }
                pushService.getPushCallback().onRegister(callBackResult.getResponseCode(), callBackResult.getContent());
            } else if (command == 12290) {
                pushService.getPushCallback().onUnRegister(callBackResult.getResponseCode());
            } else {
                switch (command) {
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                        if (pushSetAppNotificationCallBack != null) {
                            pushSetAppNotificationCallBack.onSetAppNotificationSwitch(callBackResult.getResponseCode());
                            return;
                        }
                        return;
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        int i = 0;
                        try {
                            i = Integer.parseInt(callBackResult.getContent());
                        } catch (Exception e) {
                        }
                        IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                        if (pushGetAppNotificationCallBack != null) {
                            pushGetAppNotificationCallBack.onGetAppNotificationSwitch(callBackResult.getResponseCode(), i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.processor.Processor
    public void process(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final CallBackResult callBackResult = (CallBackResult) baseMode;
            LogUtil.d("mcssdk-CallBackResultProcessor:" + callBackResult.toString());
            ThreadUtil.executeOnUiThread(new Runnable() { // from class: com.heytap.mcssdk.processor.CallBackResultProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    CallBackResultProcessor.this.processCallBackResult(callBackResult, PushService.getInstance());
                }
            });
        }
    }
}
