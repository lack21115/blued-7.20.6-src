package android.hardware.camera2;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CaptureFailure.class */
public class CaptureFailure {
    public static final int REASON_ERROR = 0;
    public static final int REASON_FLUSHED = 1;
    private final boolean mDropped;
    private final long mFrameNumber;
    private final int mReason;
    private final CaptureRequest mRequest;
    private final int mSequenceId;

    public CaptureFailure(CaptureRequest captureRequest, int i, boolean z, int i2, long j) {
        this.mRequest = captureRequest;
        this.mReason = i;
        this.mDropped = z;
        this.mSequenceId = i2;
        this.mFrameNumber = j;
    }

    public long getFrameNumber() {
        return this.mFrameNumber;
    }

    public int getReason() {
        return this.mReason;
    }

    public CaptureRequest getRequest() {
        return this.mRequest;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean wasImageCaptured() {
        return !this.mDropped;
    }
}
