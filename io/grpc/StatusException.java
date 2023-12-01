package io.grpc;

import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/StatusException.class */
public class StatusException extends Exception {
    private static final long serialVersionUID = -660954903976144640L;
    private final boolean fillInStackTrace;
    private final Status status;
    private final Metadata trailers;

    public StatusException(Status status) {
        this(status, null);
    }

    public StatusException(Status status, @Nullable Metadata metadata) {
        this(status, metadata, true);
    }

    StatusException(Status status, @Nullable Metadata metadata, boolean z) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
        this.fillInStackTrace = z;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        Throwable fillInStackTrace;
        synchronized (this) {
            fillInStackTrace = this.fillInStackTrace ? super.fillInStackTrace() : this;
        }
        return fillInStackTrace;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Metadata getTrailers() {
        return this.trailers;
    }
}
