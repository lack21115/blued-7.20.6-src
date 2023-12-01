package android.filterfw.core;

import android.filterfw.core.GraphRunner;
import android.os.AsyncTask;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/AsyncRunner.class */
public class AsyncRunner extends GraphRunner {
    private static final String TAG = "AsyncRunner";
    private boolean isProcessing;
    private GraphRunner.OnRunnerDoneListener mDoneListener;
    private Exception mException;
    private boolean mLogVerbose;
    private AsyncRunnerTask mRunTask;
    private SyncRunner mRunner;
    private Class mSchedulerClass;

    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/AsyncRunner$AsyncRunnerTask.class */
    private class AsyncRunnerTask extends AsyncTask<SyncRunner, Void, RunnerResult> {
        private static final String TAG = "AsyncRunnerTask";

        private AsyncRunnerTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public RunnerResult doInBackground(SyncRunner... syncRunnerArr) {
            RunnerResult runnerResult = new RunnerResult();
            try {
            } catch (Exception e) {
                runnerResult.exception = e;
                runnerResult.status = 6;
            }
            if (syncRunnerArr.length > 1) {
                throw new RuntimeException("More than one runner received!");
            }
            syncRunnerArr[0].assertReadyToStep();
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Starting background graph processing.");
            }
            AsyncRunner.this.activateGlContext();
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Preparing filter graph for processing.");
            }
            syncRunnerArr[0].beginProcessing();
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Running graph.");
            }
            runnerResult.status = 1;
            while (!isCancelled() && runnerResult.status == 1) {
                if (!syncRunnerArr[0].performStep()) {
                    runnerResult.status = syncRunnerArr[0].determinePostRunState();
                    if (runnerResult.status == 3) {
                        syncRunnerArr[0].waitUntilWake();
                        runnerResult.status = 1;
                    }
                }
            }
            if (isCancelled()) {
                runnerResult.status = 5;
            }
            try {
                AsyncRunner.this.deactivateGlContext();
            } catch (Exception e2) {
                runnerResult.exception = e2;
                runnerResult.status = 6;
            }
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Done with background graph processing.");
            }
            return runnerResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(RunnerResult runnerResult) {
            onPostExecute(runnerResult);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(RunnerResult runnerResult) {
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Starting post-execute.");
            }
            AsyncRunner.this.setRunning(false);
            RunnerResult runnerResult2 = runnerResult;
            if (runnerResult == null) {
                runnerResult2 = new RunnerResult();
                runnerResult2.status = 5;
            }
            AsyncRunner.this.setException(runnerResult2.exception);
            if (runnerResult2.status == 5 || runnerResult2.status == 6) {
                if (AsyncRunner.this.mLogVerbose) {
                    Log.v(TAG, "Closing filters.");
                }
                try {
                    AsyncRunner.this.mRunner.close();
                } catch (Exception e) {
                    runnerResult2.status = 6;
                    AsyncRunner.this.setException(e);
                }
            }
            if (AsyncRunner.this.mDoneListener != null) {
                if (AsyncRunner.this.mLogVerbose) {
                    Log.v(TAG, "Calling graph done callback.");
                }
                AsyncRunner.this.mDoneListener.onRunnerDone(runnerResult2.status);
            }
            if (AsyncRunner.this.mLogVerbose) {
                Log.v(TAG, "Completed post-execute.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/AsyncRunner$RunnerResult.class */
    public class RunnerResult {
        public Exception exception;
        public int status;

        private RunnerResult() {
            this.status = 0;
        }
    }

    public AsyncRunner(FilterContext filterContext) {
        super(filterContext);
        this.mSchedulerClass = SimpleScheduler.class;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    public AsyncRunner(FilterContext filterContext, Class cls) {
        super(filterContext);
        this.mSchedulerClass = cls;
        this.mLogVerbose = Log.isLoggable(TAG, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setException(Exception exc) {
        synchronized (this) {
            this.mException = exc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunning(boolean z) {
        synchronized (this) {
            this.isProcessing = z;
        }
    }

    @Override // android.filterfw.core.GraphRunner
    public void close() {
        synchronized (this) {
            if (isRunning()) {
                throw new RuntimeException("Cannot close graph while it is running!");
            }
            if (this.mLogVerbose) {
                Log.v(TAG, "Closing filters.");
            }
            this.mRunner.close();
        }
    }

    @Override // android.filterfw.core.GraphRunner
    public Exception getError() {
        Exception exc;
        synchronized (this) {
            exc = this.mException;
        }
        return exc;
    }

    @Override // android.filterfw.core.GraphRunner
    public FilterGraph getGraph() {
        if (this.mRunner != null) {
            return this.mRunner.getGraph();
        }
        return null;
    }

    @Override // android.filterfw.core.GraphRunner
    public boolean isRunning() {
        boolean z;
        synchronized (this) {
            z = this.isProcessing;
        }
        return z;
    }

    @Override // android.filterfw.core.GraphRunner
    public void run() {
        synchronized (this) {
            if (this.mLogVerbose) {
                Log.v(TAG, "Running graph.");
            }
            setException(null);
            if (isRunning()) {
                throw new RuntimeException("Graph is already running!");
            }
            if (this.mRunner == null) {
                throw new RuntimeException("Cannot run before a graph is set!");
            }
            this.mRunTask = new AsyncRunnerTask();
            setRunning(true);
            this.mRunTask.execute(this.mRunner);
        }
    }

    @Override // android.filterfw.core.GraphRunner
    public void setDoneCallback(GraphRunner.OnRunnerDoneListener onRunnerDoneListener) {
        this.mDoneListener = onRunnerDoneListener;
    }

    public void setGraph(FilterGraph filterGraph) {
        synchronized (this) {
            if (isRunning()) {
                throw new RuntimeException("Graph is already running!");
            }
            this.mRunner = new SyncRunner(this.mFilterContext, filterGraph, this.mSchedulerClass);
        }
    }

    @Override // android.filterfw.core.GraphRunner
    public void stop() {
        synchronized (this) {
            if (this.mRunTask != null && !this.mRunTask.isCancelled()) {
                if (this.mLogVerbose) {
                    Log.v(TAG, "Stopping graph.");
                }
                this.mRunTask.cancel(false);
            }
        }
    }
}
