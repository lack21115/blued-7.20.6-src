package com.sobot.chat.listener;

import android.content.Context;
import com.sobot.chat.api.model.SobotTransferOperatorParam;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/SobotTransferOperatorInterceptor.class */
public interface SobotTransferOperatorInterceptor {
    void onTransferStart(Context context, SobotTransferOperatorParam sobotTransferOperatorParam);
}
