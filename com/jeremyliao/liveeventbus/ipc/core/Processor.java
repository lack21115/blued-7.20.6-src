package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/Processor.class */
public interface Processor {
    Object createFromBundle(Bundle bundle) throws Exception;

    boolean writeToBundle(Bundle bundle, Object obj) throws Exception;
}
