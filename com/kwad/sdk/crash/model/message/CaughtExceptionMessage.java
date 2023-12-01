package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/model/message/CaughtExceptionMessage.class */
public final class CaughtExceptionMessage extends JavaExceptionMessage implements Serializable {
    private static final long serialVersionUID = -4220068453451250185L;

    @Override // com.kwad.sdk.crash.model.message.JavaExceptionMessage, com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "CAUGHT_";
    }
}
