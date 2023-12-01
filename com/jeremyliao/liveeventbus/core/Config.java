package com.jeremyliao.liveeventbus.core;

import android.content.Context;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.utils.AppUtils;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/Config.class */
public class Config {
    public Config autoClear(boolean z) {
        LiveEventBusCore.get().setAutoClear(z);
        return this;
    }

    public Config enableLogger(boolean z) {
        LiveEventBusCore.get().enableLogger(z);
        return this;
    }

    public Config lifecycleObserverAlwaysActive(boolean z) {
        LiveEventBusCore.get().setLifecycleObserverAlwaysActive(z);
        return this;
    }

    public Config setContext(Context context) {
        AppUtils.init(context);
        LiveEventBusCore.get().registerReceiver();
        return this;
    }

    public Config setLogger(Logger logger) {
        LiveEventBusCore.get().setLogger(logger);
        return this;
    }
}
