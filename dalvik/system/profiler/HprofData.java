package dalvik.system.profiler;

import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData.class */
public final class HprofData {
    private int depth;
    private int flags;
    private final Map<StackTrace, int[]> stackTraces;
    private long startMillis;
    private final List<ThreadEvent> threadHistory = new ArrayList();
    private final Map<Integer, ThreadEvent> threadIdToThreadEvent = new HashMap();

    /* renamed from: dalvik.system.profiler.HprofData$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType = new int[ThreadEventType.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0022 -> B:11:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[ThreadEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[ThreadEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData$Sample.class */
    public static final class Sample {
        public final int count;
        public final StackTrace stackTrace;

        private Sample(StackTrace stackTrace, int i) {
            if (stackTrace == null) {
                throw new NullPointerException("stackTrace == null");
            }
            if (i < 0) {
                throw new IllegalArgumentException("count < 0:" + i);
            }
            this.stackTrace = stackTrace;
            this.count = i;
        }

        /* synthetic */ Sample(StackTrace stackTrace, int i, AnonymousClass1 anonymousClass1) {
            this(stackTrace, i);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Sample) {
                Sample sample = (Sample) obj;
                return this.count == sample.count && this.stackTrace.equals(sample.stackTrace);
            }
            return false;
        }

        public int hashCode() {
            return ((this.stackTrace.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.count;
        }

        public String toString() {
            return "Sample[count=" + this.count + " " + this.stackTrace + "]";
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData$StackTrace.class */
    public static final class StackTrace {
        StackTraceElement[] stackFrames;
        public final int stackTraceId;
        int threadId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public StackTrace() {
            this.stackTraceId = -1;
        }

        public StackTrace(int i, int i2, StackTraceElement[] stackTraceElementArr) {
            if (stackTraceElementArr == null) {
                throw new NullPointerException("stackFrames == null");
            }
            this.stackTraceId = i;
            this.threadId = i2;
            this.stackFrames = stackTraceElementArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StackTrace) {
                StackTrace stackTrace = (StackTrace) obj;
                return this.threadId == stackTrace.threadId && Arrays.equals(this.stackFrames, stackTrace.stackFrames);
            }
            return false;
        }

        public StackTraceElement[] getStackFrames() {
            return this.stackFrames;
        }

        public int getThreadId() {
            return this.threadId;
        }

        public int hashCode() {
            return ((this.threadId + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + Arrays.hashCode(this.stackFrames);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.stackFrames.length > 0) {
                sb.append('\n');
                StackTraceElement[] stackTraceElementArr = this.stackFrames;
                int length = stackTraceElementArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    sb.append("\t at ");
                    sb.append(stackTraceElement);
                    sb.append('\n');
                    i = i2 + 1;
                }
            } else {
                sb.append("<empty>");
            }
            return "StackTrace[stackTraceId=" + this.stackTraceId + ", threadId=" + this.threadId + ", frames=" + ((Object) sb) + "]";
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData$ThreadEvent.class */
    public static final class ThreadEvent {
        public final String groupName;
        public final int objectId;
        public final String parentGroupName;
        public final int threadId;
        public final String threadName;
        public final ThreadEventType type;

        private ThreadEvent(ThreadEventType threadEventType, int i) {
            this.type = ThreadEventType.END;
            this.objectId = -1;
            this.threadId = i;
            this.threadName = null;
            this.groupName = null;
            this.parentGroupName = null;
        }

        private ThreadEvent(ThreadEventType threadEventType, int i, int i2, String str, String str2, String str3) {
            if (str == null) {
                throw new NullPointerException("threadName == null");
            }
            this.type = ThreadEventType.START;
            this.objectId = i;
            this.threadId = i2;
            this.threadName = str;
            this.groupName = str2;
            this.parentGroupName = str3;
        }

        public static ThreadEvent end(int i) {
            return new ThreadEvent(ThreadEventType.END, i);
        }

        private static boolean equal(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        private static int hashCode(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public static ThreadEvent start(int i, int i2, String str, String str2, String str3) {
            return new ThreadEvent(ThreadEventType.START, i, i2, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ThreadEvent) {
                ThreadEvent threadEvent = (ThreadEvent) obj;
                return this.type == threadEvent.type && this.objectId == threadEvent.objectId && this.threadId == threadEvent.threadId && equal(this.threadName, threadEvent.threadName) && equal(this.groupName, threadEvent.groupName) && equal(this.parentGroupName, threadEvent.parentGroupName);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.objectId + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.threadId) * 31) + hashCode(this.threadName)) * 31) + hashCode(this.groupName)) * 31) + hashCode(this.parentGroupName);
        }

        public String toString() {
            switch (AnonymousClass1.$SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[this.type.ordinal()]) {
                case 1:
                    return String.format("THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")", Integer.valueOf(this.objectId), Integer.valueOf(this.threadId), this.threadName, this.groupName);
                case 2:
                    return String.format("THREAD END (id = %d)", Integer.valueOf(this.threadId));
                default:
                    throw new IllegalStateException(this.type.toString());
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/HprofData$ThreadEventType.class */
    public enum ThreadEventType {
        START,
        END
    }

    public HprofData(Map<StackTrace, int[]> map) {
        if (map == null) {
            throw new NullPointerException("stackTraces == null");
        }
        this.stackTraces = map;
    }

    public void addStackTrace(StackTrace stackTrace, int[] iArr) {
        if (!this.threadIdToThreadEvent.containsKey(Integer.valueOf(stackTrace.threadId))) {
            throw new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
        }
        if (this.stackTraces.put(stackTrace, iArr) != null) {
            throw new IllegalArgumentException("StackTrace already registered for id " + stackTrace.stackTraceId + ":\n" + stackTrace);
        }
    }

    public void addThreadEvent(ThreadEvent threadEvent) {
        if (threadEvent == null) {
            throw new NullPointerException("event == null");
        }
        ThreadEvent put = this.threadIdToThreadEvent.put(Integer.valueOf(threadEvent.threadId), threadEvent);
        switch (AnonymousClass1.$SwitchMap$dalvik$system$profiler$HprofData$ThreadEventType[threadEvent.type.ordinal()]) {
            case 1:
                if (put != null) {
                    throw new IllegalArgumentException("ThreadEvent already registered for id " + threadEvent.threadId);
                }
                break;
            case 2:
                if (put != null && put.type == ThreadEventType.END) {
                    throw new IllegalArgumentException("Duplicate ThreadEvent.end for id " + threadEvent.threadId);
                }
                break;
        }
        this.threadHistory.add(threadEvent);
    }

    public int getDepth() {
        return this.depth;
    }

    public int getFlags() {
        return this.flags;
    }

    public Set<Sample> getSamples() {
        HashSet hashSet = new HashSet(this.stackTraces.size());
        for (Map.Entry<StackTrace, int[]> entry : this.stackTraces.entrySet()) {
            hashSet.add(new Sample(entry.getKey(), entry.getValue()[0], null));
        }
        return hashSet;
    }

    public long getStartMillis() {
        return this.startMillis;
    }

    public List<ThreadEvent> getThreadHistory() {
        return Collections.unmodifiableList(this.threadHistory);
    }

    public void setDepth(int i) {
        this.depth = i;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void setStartMillis(long j) {
        this.startMillis = j;
    }
}
