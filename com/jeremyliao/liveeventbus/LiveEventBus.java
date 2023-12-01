package com.jeremyliao.liveeventbus;

import com.jeremyliao.liveeventbus.core.Config;
import com.jeremyliao.liveeventbus.core.LiveEvent;
import com.jeremyliao.liveeventbus.core.LiveEventBusCore;
import com.jeremyliao.liveeventbus.core.Observable;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/LiveEventBus.class */
public final class LiveEventBus {
    public static Config config() {
        return LiveEventBusCore.get().config();
    }

    public static <T extends LiveEvent> Observable<T> get(Class<T> cls) {
        return get(cls.getName(), cls);
    }

    public static Observable<Object> get(String str) {
        return get(str, Object.class);
    }

    public static <T> Observable<T> get(String str, Class<T> cls) {
        return LiveEventBusCore.get().with(str, cls);
    }
}
