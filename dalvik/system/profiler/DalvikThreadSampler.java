package dalvik.system.profiler;

import dalvik.system.VMStack;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/DalvikThreadSampler.class */
class DalvikThreadSampler implements ThreadSampler {
    private int depth;
    private StackTraceElement[][] mutableStackTraceElements;

    DalvikThreadSampler() {
    }

    @Override // dalvik.system.profiler.ThreadSampler
    public StackTraceElement[] getStackTrace(Thread thread) {
        int fillStackTraceElements = VMStack.fillStackTraceElements(thread, this.mutableStackTraceElements[this.depth]);
        if (fillStackTraceElements == 0) {
            return null;
        }
        if (fillStackTraceElements < this.depth) {
            System.arraycopy(this.mutableStackTraceElements[this.depth], 0, this.mutableStackTraceElements[fillStackTraceElements], 0, fillStackTraceElements);
        }
        return this.mutableStackTraceElements[fillStackTraceElements];
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.StackTraceElement[], java.lang.StackTraceElement[][]] */
    @Override // dalvik.system.profiler.ThreadSampler
    public void setDepth(int i) {
        this.depth = i;
        this.mutableStackTraceElements = new StackTraceElement[i + 1];
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mutableStackTraceElements.length) {
                return;
            }
            this.mutableStackTraceElements[i3] = new StackTraceElement[i3];
            i2 = i3 + 1;
        }
    }
}
