package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/logger/LoggerManager.class */
public class LoggerManager implements Logger {
    private boolean enable = true;
    private Logger logger;

    public LoggerManager(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public boolean isEnable() {
        return this.enable;
    }

    @Override // com.jeremyliao.liveeventbus.logger.Logger
    public void log(Level level, String str) {
        if (this.enable) {
            this.logger.log(level, str);
        }
    }

    @Override // com.jeremyliao.liveeventbus.logger.Logger
    public void log(Level level, String str, Throwable th) {
        if (this.enable) {
            this.logger.log(level, str, th);
        }
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
