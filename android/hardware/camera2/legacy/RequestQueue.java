package android.hardware.camera2.legacy;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.utils.LongParcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestQueue.class */
public class RequestQueue {
    private static final long INVALID_FRAME = -1;
    private static final String TAG = "RequestQueue";
    private final List<Long> mJpegSurfaceIds;
    private BurstHolder mRepeatingRequest = null;
    private final ArrayDeque<BurstHolder> mRequestQueue = new ArrayDeque<>();
    private long mCurrentFrameNumber = 0;
    private long mCurrentRepeatingFrameNumber = -1;
    private int mCurrentRequestId = 0;

    public RequestQueue(List<Long> list) {
        this.mJpegSurfaceIds = list;
    }

    private long calculateLastFrame(int i) {
        long j = this.mCurrentFrameNumber;
        Iterator<BurstHolder> it = this.mRequestQueue.iterator();
        while (it.hasNext()) {
            BurstHolder next = it.next();
            long numberOfRequests = j + next.getNumberOfRequests();
            j = numberOfRequests;
            if (next.getRequestId() == i) {
                return numberOfRequests - 1;
            }
        }
        throw new IllegalStateException("At least one request must be in the queue to calculate frame number");
    }

    public Pair<BurstHolder, Long> getNext() {
        Pair<BurstHolder, Long> pair;
        synchronized (this) {
            BurstHolder poll = this.mRequestQueue.poll();
            BurstHolder burstHolder = poll;
            if (poll == null) {
                burstHolder = poll;
                if (this.mRepeatingRequest != null) {
                    burstHolder = this.mRepeatingRequest;
                    this.mCurrentRepeatingFrameNumber = this.mCurrentFrameNumber + burstHolder.getNumberOfRequests();
                }
            }
            if (burstHolder == null) {
                pair = null;
            } else {
                Pair<BurstHolder, Long> pair2 = new Pair<>(burstHolder, Long.valueOf(this.mCurrentFrameNumber));
                this.mCurrentFrameNumber += burstHolder.getNumberOfRequests();
                pair = pair2;
            }
        }
        return pair;
    }

    public long stopRepeating() {
        long stopRepeating;
        synchronized (this) {
            if (this.mRepeatingRequest == null) {
                Log.e(TAG, "cancel failed: no repeating request exists.");
                stopRepeating = -1;
            } else {
                stopRepeating = stopRepeating(this.mRepeatingRequest.getRequestId());
            }
        }
        return stopRepeating;
    }

    public long stopRepeating(int i) {
        long j;
        synchronized (this) {
            j = -1;
            if (this.mRepeatingRequest == null || this.mRepeatingRequest.getRequestId() != i) {
                Log.e(TAG, "cancel failed: no repeating request exists for request id: " + i);
            } else {
                this.mRepeatingRequest = null;
                j = this.mCurrentRepeatingFrameNumber == -1 ? -1L : this.mCurrentRepeatingFrameNumber - 1;
                this.mCurrentRepeatingFrameNumber = -1L;
                Log.i(TAG, "Repeating capture request cancelled.");
            }
        }
        return j;
    }

    public int submit(List<CaptureRequest> list, boolean z, LongParcelable longParcelable) {
        int i;
        synchronized (this) {
            i = this.mCurrentRequestId;
            this.mCurrentRequestId = i + 1;
            BurstHolder burstHolder = new BurstHolder(i, z, list, this.mJpegSurfaceIds);
            long j = -1;
            if (burstHolder.isRepeating()) {
                Log.i(TAG, "Repeating capture request set.");
                if (this.mRepeatingRequest != null) {
                    j = this.mCurrentRepeatingFrameNumber == -1 ? -1L : this.mCurrentRepeatingFrameNumber - 1;
                }
                this.mCurrentRepeatingFrameNumber = -1L;
                this.mRepeatingRequest = burstHolder;
            } else {
                this.mRequestQueue.offer(burstHolder);
                j = calculateLastFrame(burstHolder.getRequestId());
            }
            longParcelable.setNumber(j);
        }
        return i;
    }
}
