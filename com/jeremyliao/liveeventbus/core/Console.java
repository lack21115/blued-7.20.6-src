package com.jeremyliao.liveeventbus.core;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/Console.class */
public final class Console {
    private Console() {
    }

    public static String getInfo() {
        return LiveEventBusCore.get().console.getConsoleInfo();
    }
}
