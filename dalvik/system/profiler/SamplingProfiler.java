package dalvik.system.profiler;

import dalvik.system.profiler.BinaryHprof;
import dalvik.system.profiler.HprofData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/SamplingProfiler.class */
public final class SamplingProfiler {
    private final int depth;
    private Sampler sampler;
    private final ThreadSet threadSet;
    private final Map<HprofData.StackTrace, int[]> stackTraces = new HashMap();
    private final HprofData hprofData = new HprofData(this.stackTraces);
    private final Timer timer = new Timer("SamplingProfiler", true);
    private int nextThreadId = 200001;
    private int nextStackTraceId = 300001;
    private int nextObjectId = 1;
    private Thread[] currentThreads = new Thread[0];
    private final Map<Thread, Integer> threadIds = new HashMap();
    private final HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
    private final ThreadSampler threadSampler = findDefaultThreadSampler();

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/SamplingProfiler$ArrayThreadSet.class */
    private static class ArrayThreadSet implements ThreadSet {
        private final Thread[] threads;

        public ArrayThreadSet(Thread... threadArr) {
            if (threadArr == null) {
                throw new NullPointerException("threads == null");
            }
            this.threads = threadArr;
        }

        @Override // dalvik.system.profiler.SamplingProfiler.ThreadSet
        public Thread[] threads() {
            return this.threads;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/SamplingProfiler$Sampler.class */
    public class Sampler extends TimerTask {
        private boolean stop;
        private boolean stopped;
        private Thread timerThread;

        private Sampler() {
        }

        private void addEndThread(Thread thread) {
            if (thread == null) {
                throw new NullPointerException("thread == null");
            }
            Integer num = (Integer) SamplingProfiler.this.threadIds.remove(thread);
            if (num == null) {
                throw new IllegalArgumentException("Unknown thread " + thread);
            }
            SamplingProfiler.this.hprofData.addThreadEvent(HprofData.ThreadEvent.end(num.intValue()));
        }

        private void addStartThread(Thread thread) {
            if (thread == null) {
                throw new NullPointerException("thread == null");
            }
            int access$1108 = SamplingProfiler.access$1108(SamplingProfiler.this);
            Integer num = (Integer) SamplingProfiler.this.threadIds.put(thread, Integer.valueOf(access$1108));
            if (num != null) {
                throw new IllegalArgumentException("Thread already registered as " + num);
            }
            String name = thread.getName();
            ThreadGroup threadGroup = thread.getThreadGroup();
            String name2 = threadGroup == null ? null : threadGroup.getName();
            ThreadGroup parent = threadGroup == null ? null : threadGroup.getParent();
            SamplingProfiler.this.hprofData.addThreadEvent(HprofData.ThreadEvent.start(SamplingProfiler.access$1208(SamplingProfiler.this), access$1108, name, name2, parent == null ? null : parent.getName()));
        }

        private void recordStackTrace(Thread thread, StackTraceElement[] stackTraceElementArr) {
            Integer num = (Integer) SamplingProfiler.this.threadIds.get(thread);
            if (num == null) {
                throw new IllegalArgumentException("Unknown thread " + thread);
            }
            SamplingProfiler.this.mutableStackTrace.threadId = num.intValue();
            SamplingProfiler.this.mutableStackTrace.stackFrames = stackTraceElementArr;
            int[] iArr = (int[]) SamplingProfiler.this.stackTraces.get(SamplingProfiler.this.mutableStackTrace);
            int[] iArr2 = iArr;
            if (iArr == null) {
                iArr2 = new int[1];
                SamplingProfiler.this.hprofData.addStackTrace(new HprofData.StackTrace(SamplingProfiler.access$908(SamplingProfiler.this), num.intValue(), (StackTraceElement[]) stackTraceElementArr.clone()), iArr2);
            }
            iArr2[0] = iArr2[0] + 1;
        }

        private void updateThreadHistory(Thread[] threadArr, Thread[] threadArr2) {
            HashSet hashSet = new HashSet(Arrays.asList(threadArr2));
            HashSet hashSet2 = new HashSet(Arrays.asList(threadArr));
            HashSet<Thread> hashSet3 = new HashSet(hashSet);
            hashSet3.removeAll(hashSet2);
            HashSet<Thread> hashSet4 = new HashSet(hashSet2);
            hashSet4.removeAll(hashSet);
            for (Thread thread : hashSet3) {
                if (thread != null && thread != this.timerThread) {
                    addStartThread(thread);
                }
            }
            for (Thread thread2 : hashSet4) {
                if (thread2 != null && thread2 != this.timerThread) {
                    addEndThread(thread2);
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Thread thread;
            StackTraceElement[] stackTrace;
            synchronized (this) {
                if (this.stop) {
                    cancel();
                    this.stopped = true;
                    notifyAll();
                    return;
                }
                if (this.timerThread == null) {
                    this.timerThread = Thread.currentThread();
                }
                Thread[] threads = SamplingProfiler.this.threadSet.threads();
                if (!Arrays.equals(SamplingProfiler.this.currentThreads, threads)) {
                    updateThreadHistory(SamplingProfiler.this.currentThreads, threads);
                    SamplingProfiler.this.currentThreads = (Thread[]) threads.clone();
                }
                Thread[] threadArr = SamplingProfiler.this.currentThreads;
                int length = threadArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length || (thread = threadArr[i2]) == null) {
                        return;
                    }
                    if (thread != this.timerThread && (stackTrace = SamplingProfiler.this.threadSampler.getStackTrace(thread)) != null) {
                        recordStackTrace(thread, stackTrace);
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/SamplingProfiler$ThreadGroupThreadSet.class */
    public static class ThreadGroupThreadSet implements ThreadSet {
        private int lastThread;
        private final ThreadGroup threadGroup;
        private Thread[] threads;

        public ThreadGroupThreadSet(ThreadGroup threadGroup) {
            if (threadGroup == null) {
                throw new NullPointerException("threadGroup == null");
            }
            this.threadGroup = threadGroup;
            resize();
        }

        private void resize() {
            this.threads = new Thread[this.threadGroup.activeCount() * 2];
            this.lastThread = 0;
        }

        @Override // dalvik.system.profiler.SamplingProfiler.ThreadSet
        public Thread[] threads() {
            int enumerate;
            while (true) {
                enumerate = this.threadGroup.enumerate(this.threads);
                if (enumerate != this.threads.length) {
                    break;
                }
                resize();
            }
            if (enumerate < this.lastThread) {
                Arrays.fill(this.threads, enumerate, this.lastThread, (Object) null);
            }
            this.lastThread = enumerate;
            return this.threads;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/SamplingProfiler$ThreadSet.class */
    public interface ThreadSet {
        Thread[] threads();
    }

    public SamplingProfiler(int i, ThreadSet threadSet) {
        this.depth = i;
        this.threadSet = threadSet;
        this.threadSampler.setDepth(i);
        this.hprofData.setFlags(BinaryHprof.ControlSettings.CPU_SAMPLING.bitmask);
        this.hprofData.setDepth(i);
    }

    static /* synthetic */ int access$1108(SamplingProfiler samplingProfiler) {
        int i = samplingProfiler.nextThreadId;
        samplingProfiler.nextThreadId = i + 1;
        return i;
    }

    static /* synthetic */ int access$1208(SamplingProfiler samplingProfiler) {
        int i = samplingProfiler.nextObjectId;
        samplingProfiler.nextObjectId = i + 1;
        return i;
    }

    static /* synthetic */ int access$908(SamplingProfiler samplingProfiler) {
        int i = samplingProfiler.nextStackTraceId;
        samplingProfiler.nextStackTraceId = i + 1;
        return i;
    }

    private static ThreadSampler findDefaultThreadSampler() {
        if ("Dalvik Core Library".equals(System.getProperty("java.specification.name"))) {
            try {
                return (ThreadSampler) Class.forName("dalvik.system.profiler.DalvikThreadSampler").newInstance();
            } catch (Exception e) {
                System.out.println("Problem creating dalvik.system.profiler.DalvikThreadSampler: " + e);
            }
        }
        return new PortableThreadSampler();
    }

    public static ThreadSet newArrayThreadSet(Thread... threadArr) {
        return new ArrayThreadSet(threadArr);
    }

    public static ThreadSet newThreadGroupThreadSet(ThreadGroup threadGroup) {
        return new ThreadGroupThreadSet(threadGroup);
    }

    public HprofData getHprofData() {
        if (this.sampler != null) {
            throw new IllegalStateException("cannot access hprof data while sampling");
        }
        return this.hprofData;
    }

    public void shutdown() {
        stop();
        this.timer.cancel();
    }

    public void start(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("interval < 1");
        }
        if (this.sampler != null) {
            throw new IllegalStateException("profiling already started");
        }
        this.sampler = new Sampler();
        this.hprofData.setStartMillis(System.currentTimeMillis());
        this.timer.scheduleAtFixedRate(this.sampler, 0L, i);
    }

    public void stop() {
        if (this.sampler == null) {
            return;
        }
        synchronized (this.sampler) {
            this.sampler.stop = true;
            while (!this.sampler.stopped) {
                try {
                    this.sampler.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        this.sampler = null;
    }
}
