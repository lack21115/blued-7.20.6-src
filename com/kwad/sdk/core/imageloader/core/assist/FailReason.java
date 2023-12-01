package com.kwad.sdk.core.imageloader.core.assist;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/assist/FailReason.class */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/assist/FailReason$FailType.class */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }

    public String toString() {
        return "FailReason{type=" + this.type + ", cause=" + this.cause + '}';
    }
}
