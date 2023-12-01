package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.IntentConstant;
import com.heytap.mcssdk.constant.MessageConstant;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/DataMessageUtil.class */
public class DataMessageUtil {
    private static final String TYPE = "type";

    public void appArrive(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(PushService.getInstance().getReceiveSdkAction(context));
            intent.setPackage(PushService.getInstance().getMcsPackageName(context));
            intent.putExtra(IntentConstant.APP_PACKAGE, context.getPackageName());
            intent.putExtra(IntentConstant.MESSAGE_ID, str);
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e) {
            LogUtil.e("statisticMessage--Exception" + e.getMessage());
        }
    }
}
