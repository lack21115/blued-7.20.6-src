package android.hardware.camera2.utils;

import android.os.Handler;
import android.util.Log;
import com.android.internal.util.Preconditions;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TaskDrainer.class */
public class TaskDrainer<T> {
    private static final String TAG = "TaskDrainer";
    private final boolean VERBOSE;
    private boolean mDrainFinished;
    private boolean mDraining;
    private final Handler mHandler;
    private final DrainListener mListener;
    private final Object mLock;
    private final String mName;
    private final Set<T> mTaskSet;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TaskDrainer$DrainListener.class */
    public interface DrainListener {
        void onDrained();
    }

    public TaskDrainer(Handler handler, DrainListener drainListener) {
        this.VERBOSE = Log.isLoggable(TAG, 2);
        this.mTaskSet = new HashSet();
        this.mLock = new Object();
        this.mDraining = false;
        this.mDrainFinished = false;
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler must not be null");
        this.mListener = (DrainListener) Preconditions.checkNotNull(drainListener, "listener must not be null");
        this.mName = null;
    }

    public TaskDrainer(Handler handler, DrainListener drainListener, String str) {
        this.VERBOSE = Log.isLoggable(TAG, 2);
        this.mTaskSet = new HashSet();
        this.mLock = new Object();
        this.mDraining = false;
        this.mDrainFinished = false;
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler must not be null");
        this.mListener = (DrainListener) Preconditions.checkNotNull(drainListener, "listener must not be null");
        this.mName = str;
    }

    private void checkIfDrainFinished() {
        if (this.mTaskSet.isEmpty() && this.mDraining && !this.mDrainFinished) {
            this.mDrainFinished = true;
            postDrained();
        }
    }

    private void postDrained() {
        this.mHandler.post(new Runnable() { // from class: android.hardware.camera2.utils.TaskDrainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (TaskDrainer.this.VERBOSE) {
                    Log.v("TaskDrainer[" + TaskDrainer.this.mName + "]", "onDrained");
                }
                TaskDrainer.this.mListener.onDrained();
            }
        });
    }

    public void beginDrain() {
        synchronized (this.mLock) {
            if (!this.mDraining) {
                if (this.VERBOSE) {
                    Log.v("TaskDrainer[" + this.mName + "]", "beginDrain started");
                }
                this.mDraining = true;
                checkIfDrainFinished();
            } else if (this.VERBOSE) {
                Log.v("TaskDrainer[" + this.mName + "]", "beginDrain ignored");
            }
        }
    }

    public void taskFinished(T t) {
        synchronized (this.mLock) {
            if (this.VERBOSE) {
                Log.v("TaskDrainer[" + this.mName + "]", "taskFinished " + t);
            }
            if (!this.mTaskSet.remove(t)) {
                throw new IllegalStateException("Task " + t + " was already finished");
            }
            checkIfDrainFinished();
        }
    }

    public void taskStarted(T t) {
        synchronized (this.mLock) {
            if (this.VERBOSE) {
                Log.v("TaskDrainer[" + this.mName + "]", "taskStarted " + t);
            }
            if (this.mDraining) {
                throw new IllegalStateException("Can't start more tasks after draining has begun");
            }
            if (!this.mTaskSet.add(t)) {
                throw new IllegalStateException("Task " + t + " was already started");
            }
        }
    }
}
