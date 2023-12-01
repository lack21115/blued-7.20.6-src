package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/GraphRunner.class */
public abstract class GraphRunner {
    public static final int RESULT_BLOCKED = 4;
    public static final int RESULT_ERROR = 6;
    public static final int RESULT_FINISHED = 2;
    public static final int RESULT_RUNNING = 1;
    public static final int RESULT_SLEEPING = 3;
    public static final int RESULT_STOPPED = 5;
    public static final int RESULT_UNKNOWN = 0;
    protected FilterContext mFilterContext;

    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/GraphRunner$OnRunnerDoneListener.class */
    public interface OnRunnerDoneListener {
        void onRunnerDone(int i);
    }

    public GraphRunner(FilterContext filterContext) {
        this.mFilterContext = null;
        this.mFilterContext = filterContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean activateGlContext() {
        GLEnvironment gLEnvironment = this.mFilterContext.getGLEnvironment();
        if (gLEnvironment == null || gLEnvironment.isActive()) {
            return false;
        }
        gLEnvironment.activate();
        return true;
    }

    public abstract void close();

    /* JADX INFO: Access modifiers changed from: protected */
    public void deactivateGlContext() {
        GLEnvironment gLEnvironment = this.mFilterContext.getGLEnvironment();
        if (gLEnvironment != null) {
            gLEnvironment.deactivate();
        }
    }

    public FilterContext getContext() {
        return this.mFilterContext;
    }

    public abstract Exception getError();

    public abstract FilterGraph getGraph();

    public abstract boolean isRunning();

    public abstract void run();

    public abstract void setDoneCallback(OnRunnerDoneListener onRunnerDoneListener);

    public abstract void stop();
}
