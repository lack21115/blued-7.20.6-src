package dalvik.system.profiler;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/PortableThreadSampler.class */
class PortableThreadSampler implements ThreadSampler {
    private int depth;

    @Override // dalvik.system.profiler.ThreadSampler
    public StackTraceElement[] getStackTrace(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length == 0) {
            return null;
        }
        StackTraceElement[] stackTraceElementArr = stackTrace;
        if (stackTrace.length > this.depth) {
            stackTraceElementArr = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, 0, this.depth);
        }
        return stackTraceElementArr;
    }

    @Override // dalvik.system.profiler.ThreadSampler
    public void setDepth(int i) {
        this.depth = i;
    }
}
