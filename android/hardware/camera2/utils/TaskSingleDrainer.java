package android.hardware.camera2.utils;

import android.hardware.camera2.utils.TaskDrainer;
import android.os.Handler;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TaskSingleDrainer.class */
public class TaskSingleDrainer {
    private final Object mSingleTask = new Object();
    private final TaskDrainer<Object> mTaskDrainer;

    public TaskSingleDrainer(Handler handler, TaskDrainer.DrainListener drainListener) {
        this.mTaskDrainer = new TaskDrainer<>(handler, drainListener);
    }

    public TaskSingleDrainer(Handler handler, TaskDrainer.DrainListener drainListener, String str) {
        this.mTaskDrainer = new TaskDrainer<>(handler, drainListener, str);
    }

    public void beginDrain() {
        this.mTaskDrainer.beginDrain();
    }

    public void taskFinished() {
        this.mTaskDrainer.taskFinished(this.mSingleTask);
    }

    public void taskStarted() {
        this.mTaskDrainer.taskStarted(this.mSingleTask);
    }
}
