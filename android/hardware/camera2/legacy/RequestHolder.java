package android.hardware.camera2.legacy;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.legacy.LegacyExceptionUtils;
import android.util.Log;
import android.view.Surface;
import com.android.internal.util.Preconditions;
import java.util.Collection;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestHolder.class */
public class RequestHolder {
    private static final String TAG = "RequestHolder";
    private volatile boolean mFailed;
    private final long mFrameNumber;
    private final int mNumJpegTargets;
    private final int mNumPreviewTargets;
    private final boolean mRepeating;
    private final CaptureRequest mRequest;
    private final int mRequestId;
    private final int mSubsequeceId;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestHolder$Builder.class */
    public static final class Builder {
        private final Collection<Long> mJpegSurfaceIds;
        private final int mNumJpegTargets;
        private final int mNumPreviewTargets;
        private final boolean mRepeating;
        private final CaptureRequest mRequest;
        private final int mRequestId;
        private final int mSubsequenceId;

        public Builder(int i, int i2, CaptureRequest captureRequest, boolean z, Collection<Long> collection) {
            Preconditions.checkNotNull(captureRequest, "request must not be null");
            this.mRequestId = i;
            this.mSubsequenceId = i2;
            this.mRequest = captureRequest;
            this.mRepeating = z;
            this.mJpegSurfaceIds = collection;
            this.mNumJpegTargets = numJpegTargets(this.mRequest);
            this.mNumPreviewTargets = numPreviewTargets(this.mRequest);
        }

        private boolean jpegType(Surface surface) throws LegacyExceptionUtils.BufferQueueAbandonedException {
            return LegacyCameraDevice.containsSurfaceId(surface, this.mJpegSurfaceIds);
        }

        private int numJpegTargets(CaptureRequest captureRequest) {
            int i = 0;
            for (Surface surface : captureRequest.getTargets()) {
                try {
                    if (jpegType(surface)) {
                        i++;
                    }
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                    Log.d(RequestHolder.TAG, "Surface abandoned, skipping...", e);
                }
            }
            return i;
        }

        private int numPreviewTargets(CaptureRequest captureRequest) {
            int i = 0;
            for (Surface surface : captureRequest.getTargets()) {
                try {
                    if (previewType(surface)) {
                        i++;
                    }
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                    Log.d(RequestHolder.TAG, "Surface abandoned, skipping...", e);
                }
            }
            return i;
        }

        private boolean previewType(Surface surface) throws LegacyExceptionUtils.BufferQueueAbandonedException {
            return !jpegType(surface);
        }

        public RequestHolder build(long j) {
            return new RequestHolder(this.mRequestId, this.mSubsequenceId, this.mRequest, this.mRepeating, j, this.mNumJpegTargets, this.mNumPreviewTargets);
        }
    }

    private RequestHolder(int i, int i2, CaptureRequest captureRequest, boolean z, long j, int i3, int i4) {
        this.mFailed = false;
        this.mRepeating = z;
        this.mRequest = captureRequest;
        this.mRequestId = i;
        this.mSubsequeceId = i2;
        this.mFrameNumber = j;
        this.mNumJpegTargets = i3;
        this.mNumPreviewTargets = i4;
    }

    public void failRequest() {
        Log.w(TAG, "Capture failed for request: " + getRequestId());
        this.mFailed = true;
    }

    public long getFrameNumber() {
        return this.mFrameNumber;
    }

    public Collection<Surface> getHolderTargets() {
        return getRequest().getTargets();
    }

    public CaptureRequest getRequest() {
        return this.mRequest;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public int getSubsequeceId() {
        return this.mSubsequeceId;
    }

    public boolean hasJpegTargets() {
        return this.mNumJpegTargets > 0;
    }

    public boolean hasPreviewTargets() {
        return this.mNumPreviewTargets > 0;
    }

    public boolean isRepeating() {
        return this.mRepeating;
    }

    public int numJpegTargets() {
        return this.mNumJpegTargets;
    }

    public int numPreviewTargets() {
        return this.mNumPreviewTargets;
    }

    public boolean requestFailed() {
        return this.mFailed;
    }
}
