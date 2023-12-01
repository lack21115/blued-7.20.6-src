package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/LongProcessor.class */
public class LongProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return Long.valueOf(bundle.getLong(IpcConst.KEY_VALUE));
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(IpcConst.KEY_VALUE, ((Long) obj).longValue());
            return true;
        }
        return false;
    }
}
