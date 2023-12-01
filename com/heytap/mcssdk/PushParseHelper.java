package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.parser.MessageParser;
import com.heytap.mcssdk.processor.Processor;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.ThreadUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/PushParseHelper.class */
public class PushParseHelper {
    public static void parseIntent(final Context context, final Intent intent, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            LogUtil.e("context is null , please check param of parseIntent()");
        } else if (intent == null) {
            LogUtil.e("intent is null , please check param of parseIntent()");
        } else if (iDataMessageCallBackService == null) {
            LogUtil.e("callback is null , please check param of parseIntent()");
        } else if (Utils.isSupportPushByClient(context)) {
            ThreadUtil.executeOnBackground(new Runnable() { // from class: com.heytap.mcssdk.PushParseHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    List<BaseMode> messageList = MessageParser.getMessageList(Context.this, intent);
                    if (messageList == null) {
                        return;
                    }
                    for (BaseMode baseMode : messageList) {
                        if (baseMode != null) {
                            for (Processor processor : PushService.getInstance().getProcessors()) {
                                if (processor != null) {
                                    processor.process(Context.this, baseMode, iDataMessageCallBackService);
                                }
                            }
                        }
                    }
                }
            });
        } else {
            LogUtil.e("push is null ,please check system has push");
        }
    }
}
