package com.tencent.smtt.export.external.jscore.interfaces;

import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/jscore/interfaces/IX5JsVirtualMachine.class */
public interface IX5JsVirtualMachine {
    IX5JsContext createJsContext();

    void destroy();

    Looper getLooper();

    void onPause();

    void onResume();
}
