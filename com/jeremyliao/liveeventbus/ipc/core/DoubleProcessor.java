package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/DoubleProcessor.class */
public class DoubleProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return Double.valueOf(bundle.getDouble(IpcConst.KEY_VALUE));
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(IpcConst.KEY_VALUE, ((Double) obj).doubleValue());
            return true;
        }
        return false;
    }
}
