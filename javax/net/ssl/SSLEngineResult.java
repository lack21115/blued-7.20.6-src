package javax.net.ssl;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLEngineResult.class */
public class SSLEngineResult {
    private final int bytesConsumed;
    private final int bytesProduced;
    private final HandshakeStatus handshakeStatus;
    private final Status status;

    /* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLEngineResult$HandshakeStatus.class */
    public enum HandshakeStatus {
        NOT_HANDSHAKING,
        FINISHED,
        NEED_TASK,
        NEED_WRAP,
        NEED_UNWRAP
    }

    /* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLEngineResult$Status.class */
    public enum Status {
        BUFFER_OVERFLOW,
        BUFFER_UNDERFLOW,
        CLOSED,
        OK
    }

    public SSLEngineResult(Status status, HandshakeStatus handshakeStatus, int i, int i2) {
        if (status == null) {
            throw new IllegalArgumentException("status == null");
        }
        if (handshakeStatus == null) {
            throw new IllegalArgumentException("handshakeStatus == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("bytesConsumed < 0: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("bytesProduced < 0: " + i2);
        }
        this.status = status;
        this.handshakeStatus = handshakeStatus;
        this.bytesConsumed = i;
        this.bytesProduced = i2;
    }

    public final int bytesConsumed() {
        return this.bytesConsumed;
    }

    public final int bytesProduced() {
        return this.bytesProduced;
    }

    public final HandshakeStatus getHandshakeStatus() {
        return this.handshakeStatus;
    }

    public final Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "SSLEngineReport: Status = " + this.status + "  HandshakeStatus = " + this.handshakeStatus + "\n                 bytesConsumed = " + this.bytesConsumed + " bytesProduced = " + this.bytesProduced;
    }
}
