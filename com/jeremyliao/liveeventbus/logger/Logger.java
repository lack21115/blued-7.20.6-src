package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/logger/Logger.class */
public interface Logger {
    void log(Level level, String str);

    void log(Level level, String str, Throwable th);
}
