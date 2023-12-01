package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/StringProcessor.class */
public class StringProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return bundle.getString(IpcConst.KEY_VALUE);
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (obj instanceof String) {
            bundle.putString(IpcConst.KEY_VALUE, (String) obj);
            return true;
        }
        return false;
    }
}
