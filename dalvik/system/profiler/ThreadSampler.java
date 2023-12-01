package dalvik.system.profiler;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/ThreadSampler.class */
public interface ThreadSampler {
    StackTraceElement[] getStackTrace(Thread thread);

    void setDepth(int i);
}
