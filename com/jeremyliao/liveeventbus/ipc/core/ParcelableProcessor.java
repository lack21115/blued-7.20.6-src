package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import android.os.Parcelable;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/ParcelableProcessor.class */
public class ParcelableProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return bundle.getParcelable(IpcConst.KEY_VALUE);
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (obj instanceof Parcelable) {
            bundle.putParcelable(IpcConst.KEY_VALUE, (Parcelable) obj);
            return true;
        }
        return false;
    }
}
