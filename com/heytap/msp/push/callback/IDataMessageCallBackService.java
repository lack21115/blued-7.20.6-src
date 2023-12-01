package com.heytap.msp.push.callback;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/push/callback/IDataMessageCallBackService.class */
public interface IDataMessageCallBackService {
    void processMessage(Context context, DataMessage dataMessage);
}
