package com.heytap.mcssdk.processor;

import android.content.Context;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/processor/Processor.class */
public interface Processor {
    void process(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService);
}
