package com.tencent.smtt.export.external.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/ConsoleMessage.class */
public interface ConsoleMessage {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel.class */
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
