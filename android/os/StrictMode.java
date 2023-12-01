package android.os;

import android.animation.ValueAnimator;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.ApplicationErrorReport;
import android.app.IActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.MessageQueue;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Printer;
import android.util.Singleton;
import android.util.Slog;
import android.view.IWindowManager;
import com.android.internal.os.RuntimeInit;
import com.android.internal.util.FastPrintWriter;
import com.blued.das.live.LiveProtos;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import dalvik.system.VMDebug;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode.class */
public final class StrictMode {
    private static final int ALL_THREAD_DETECT_BITS = 15;
    private static final int ALL_VM_DETECT_BITS = 32256;
    public static final int DETECT_CUSTOM = 8;
    public static final int DETECT_DISK_READ = 2;
    public static final int DETECT_DISK_WRITE = 1;
    public static final int DETECT_NETWORK = 4;
    public static final int DETECT_VM_ACTIVITY_LEAKS = 2048;
    public static final int DETECT_VM_CLOSABLE_LEAKS = 1024;
    public static final int DETECT_VM_CURSOR_LEAKS = 512;
    private static final int DETECT_VM_FILE_URI_EXPOSURE = 16384;
    private static final int DETECT_VM_INSTANCE_LEAKS = 4096;
    public static final int DETECT_VM_REGISTRATION_LEAKS = 8192;
    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    private static final int MAX_OFFENSES_PER_LOOP = 10;
    private static final int MAX_SPAN_TAGS = 20;
    private static final long MIN_DIALOG_INTERVAL_MS = 30000;
    private static final long MIN_LOG_INTERVAL_MS = 1000;
    public static final int PENALTY_DEATH = 64;
    public static final int PENALTY_DEATH_ON_NETWORK = 512;
    public static final int PENALTY_DIALOG = 32;
    public static final int PENALTY_DROPBOX = 128;
    public static final int PENALTY_FLASH = 2048;
    public static final int PENALTY_GATHER = 256;
    public static final int PENALTY_LOG = 16;
    private static final int THREAD_PENALTY_MASK = 3056;
    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    private static final int VM_PENALTY_MASK = 208;
    private static final String TAG = "StrictMode";
    private static final boolean LOG_V = Log.isLoggable(TAG, 2);
    private static final boolean IS_USER_BUILD = "user".equals(Build.TYPE);
    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    private static final HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<>();
    private static volatile int sVmPolicyMask = 0;
    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
    private static final AtomicInteger sDropboxCallsInFlight = new AtomicInteger(0);
    private static final ThreadLocal<ArrayList<ViolationInfo>> gatheredViolations = new ThreadLocal<ArrayList<ViolationInfo>>() { // from class: android.os.StrictMode.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ViolationInfo> initialValue() {
            return null;
        }
    };
    private static final ThreadLocal<ArrayList<ViolationInfo>> violationsBeingTimed = new ThreadLocal<ArrayList<ViolationInfo>>() { // from class: android.os.StrictMode.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ViolationInfo> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<Handler> threadHandler = new ThreadLocal<Handler>() { // from class: android.os.StrictMode.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Handler initialValue() {
            return new Handler();
        }
    };
    private static final ThreadLocal<AndroidBlockGuardPolicy> threadAndroidPolicy = new ThreadLocal<AndroidBlockGuardPolicy>() { // from class: android.os.StrictMode.4
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public AndroidBlockGuardPolicy initialValue() {
            return new AndroidBlockGuardPolicy(0);
        }
    };
    private static long sLastInstanceCountCheckMillis = 0;
    private static boolean sIsIdlerRegistered = false;
    private static final MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() { // from class: android.os.StrictMode.6
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - StrictMode.sLastInstanceCountCheckMillis > 30000) {
                long unused = StrictMode.sLastInstanceCountCheckMillis = uptimeMillis;
                StrictMode.conditionallyCheckInstanceCounts();
                return true;
            }
            return true;
        }
    };
    private static final HashMap<Integer, Long> sLastVmViolationTime = new HashMap<>();
    private static final Span NO_OP_SPAN = new Span() { // from class: android.os.StrictMode.7
        @Override // android.os.StrictMode.Span
        public void finish() {
        }
    };
    private static final ThreadLocal<ThreadSpanState> sThisThreadSpanState = new ThreadLocal<ThreadSpanState>() { // from class: android.os.StrictMode.8
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ThreadSpanState initialValue() {
            return new ThreadSpanState();
        }
    };
    private static Singleton<IWindowManager> sWindowManager = new Singleton<IWindowManager>() { // from class: android.os.StrictMode.9
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.util.Singleton
        public IWindowManager create() {
            return IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        }
    };
    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$AndroidBlockGuardPolicy.class */
    public static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
        private ArrayMap<Integer, Long> mLastViolationTime;
        private int mPolicyMask;

        public AndroidBlockGuardPolicy(int i) {
            this.mPolicyMask = i;
        }

        @Override // dalvik.system.BlockGuard.Policy
        public int getPolicyMask() {
            return this.mPolicyMask;
        }

        void handleViolation(ViolationInfo violationInfo) {
            ArrayList arrayList;
            if (violationInfo == null || violationInfo.crashInfo == null || violationInfo.crashInfo.stackTrace == null) {
                Log.wtf(StrictMode.TAG, "unexpected null stacktrace");
                return;
            }
            if (StrictMode.LOG_V) {
                Log.d(StrictMode.TAG, "handleViolation; policy=" + violationInfo.policy);
            }
            if ((violationInfo.policy & 256) != 0) {
                ArrayList arrayList2 = (ArrayList) StrictMode.gatheredViolations.get();
                if (arrayList2 == null) {
                    arrayList = new ArrayList(1);
                    StrictMode.gatheredViolations.set(arrayList);
                } else {
                    arrayList = arrayList2;
                    if (arrayList2.size() >= 5) {
                        return;
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (violationInfo.crashInfo.stackTrace.equals(((ViolationInfo) it.next()).crashInfo.stackTrace)) {
                        return;
                    }
                }
                arrayList.add(violationInfo);
                return;
            }
            Integer valueOf = Integer.valueOf(violationInfo.hashCode());
            long j = 0;
            if (this.mLastViolationTime != null) {
                Long l = this.mLastViolationTime.get(valueOf);
                if (l != null) {
                    j = l.longValue();
                }
            } else {
                this.mLastViolationTime = new ArrayMap<>(1);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mLastViolationTime.put(valueOf, Long.valueOf(uptimeMillis));
            long j2 = j == 0 ? Long.MAX_VALUE : uptimeMillis - j;
            if ((violationInfo.policy & 16) != 0 && j2 > 1000) {
                if (violationInfo.durationMillis != -1) {
                    Log.d(StrictMode.TAG, "StrictMode policy violation; ~duration=" + violationInfo.durationMillis + " ms: " + violationInfo.crashInfo.stackTrace);
                } else {
                    Log.d(StrictMode.TAG, "StrictMode policy violation: " + violationInfo.crashInfo.stackTrace);
                }
            }
            int i = 0;
            if ((violationInfo.policy & 32) != 0) {
                i = 0;
                if (j2 > 30000) {
                    i = 0 | 32;
                }
            }
            int i2 = i;
            if ((violationInfo.policy & 128) != 0) {
                i2 = i;
                if (j == 0) {
                    i2 = i | 128;
                }
            }
            if (i2 != 0) {
                int parseViolationFromMessage = i2 | StrictMode.parseViolationFromMessage(violationInfo.crashInfo.exceptionMessage);
                int threadPolicyMask = StrictMode.getThreadPolicyMask();
                if ((violationInfo.policy & 3056) == 128) {
                    StrictMode.dropboxViolationAsync(parseViolationFromMessage, violationInfo);
                    return;
                }
                try {
                    StrictMode.setThreadPolicyMask(0);
                    ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), parseViolationFromMessage, violationInfo);
                } catch (RemoteException e) {
                    Log.e(StrictMode.TAG, "RemoteException trying to handle StrictMode violation", e);
                } finally {
                    StrictMode.setThreadPolicyMask(threadPolicyMask);
                }
            }
            if ((violationInfo.policy & 64) != 0) {
                StrictMode.executeDeathPenalty(violationInfo);
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007c -> B:18:0x005f). Please submit an issue!!! */
        void handleViolationWithTimingAttempt(ViolationInfo violationInfo) {
            if (Looper.myLooper() == null || (violationInfo.policy & 3056) == 64) {
                violationInfo.durationMillis = -1;
                handleViolation(violationInfo);
                return;
            }
            final ArrayList arrayList = (ArrayList) StrictMode.violationsBeingTimed.get();
            if (arrayList.size() < 10) {
                arrayList.add(violationInfo);
                if (arrayList.size() <= 1) {
                    IWindowManager iWindowManager = (violationInfo.policy & 2048) != 0 ? (IWindowManager) StrictMode.sWindowManager.get() : null;
                    if (iWindowManager != null) {
                        try {
                            iWindowManager.showStrictModeViolation(true);
                        } catch (RemoteException e) {
                        }
                    }
                    final IWindowManager iWindowManager2 = iWindowManager;
                    ((Handler) StrictMode.threadHandler.get()).postAtFrontOfQueue(new Runnable() { // from class: android.os.StrictMode.AndroidBlockGuardPolicy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            if (iWindowManager2 != null) {
                                try {
                                    iWindowManager2.showStrictModeViolation(false);
                                } catch (RemoteException e2) {
                                }
                            }
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= arrayList.size()) {
                                    arrayList.clear();
                                    return;
                                }
                                ViolationInfo violationInfo2 = (ViolationInfo) arrayList.get(i2);
                                violationInfo2.violationNumThisLoop = i2 + 1;
                                violationInfo2.durationMillis = (int) (uptimeMillis - violationInfo2.violationUptimeMillis);
                                AndroidBlockGuardPolicy.this.handleViolation(violationInfo2);
                                i = i2 + 1;
                            }
                        }
                    });
                }
            }
        }

        void onCustomSlowCall(String str) {
            if ((this.mPolicyMask & 8) == 0 || StrictMode.access$400()) {
                return;
            }
            StrictModeCustomViolation strictModeCustomViolation = new StrictModeCustomViolation(this.mPolicyMask, str);
            strictModeCustomViolation.fillInStackTrace();
            startHandlingViolationException(strictModeCustomViolation);
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onNetwork() {
            if ((this.mPolicyMask & 4) == 0) {
                return;
            }
            if ((this.mPolicyMask & 512) != 0) {
                throw new NetworkOnMainThreadException();
            }
            if (StrictMode.access$400()) {
                return;
            }
            StrictModeNetworkViolation strictModeNetworkViolation = new StrictModeNetworkViolation(this.mPolicyMask);
            strictModeNetworkViolation.fillInStackTrace();
            startHandlingViolationException(strictModeNetworkViolation);
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onReadFromDisk() {
            if ((this.mPolicyMask & 2) == 0 || StrictMode.access$400()) {
                return;
            }
            StrictModeDiskReadViolation strictModeDiskReadViolation = new StrictModeDiskReadViolation(this.mPolicyMask);
            strictModeDiskReadViolation.fillInStackTrace();
            startHandlingViolationException(strictModeDiskReadViolation);
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onWriteToDisk() {
            if ((this.mPolicyMask & 1) == 0 || StrictMode.access$400()) {
                return;
            }
            StrictModeDiskWriteViolation strictModeDiskWriteViolation = new StrictModeDiskWriteViolation(this.mPolicyMask);
            strictModeDiskWriteViolation.fillInStackTrace();
            startHandlingViolationException(strictModeDiskWriteViolation);
        }

        public void setPolicyMask(int i) {
            this.mPolicyMask = i;
        }

        void startHandlingViolationException(BlockGuard.BlockGuardPolicyException blockGuardPolicyException) {
            ViolationInfo violationInfo = new ViolationInfo(blockGuardPolicyException, blockGuardPolicyException.getPolicy());
            violationInfo.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(violationInfo);
        }

        public String toString() {
            return "AndroidBlockGuardPolicy; mPolicyMask=" + this.mPolicyMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$AndroidCloseGuardReporter.class */
    public static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        private AndroidCloseGuardReporter() {
        }

        @Override // dalvik.system.CloseGuard.Reporter
        public void report(String str, Throwable th) {
            StrictMode.onVmPolicyViolation(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$InstanceCountViolation.class */
    public static class InstanceCountViolation extends Throwable {
        private static final StackTraceElement[] FAKE_STACK = {new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit", "StrictMode.java", 1)};
        final Class mClass;
        final long mInstances;
        final int mLimit;

        public InstanceCountViolation(Class cls, long j, int i) {
            super(cls.toString() + "; instances=" + j + "; limit=" + i);
            setStackTrace(FAKE_STACK);
            this.mClass = cls;
            this.mInstances = j;
            this.mLimit = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$InstanceTracker.class */
    public static final class InstanceTracker {
        private static final HashMap<Class<?>, Integer> sInstanceCounts = new HashMap<>();
        private final Class<?> mKlass;

        public InstanceTracker(Object obj) {
            this.mKlass = obj.getClass();
            synchronized (sInstanceCounts) {
                Integer num = sInstanceCounts.get(this.mKlass);
                sInstanceCounts.put(this.mKlass, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            }
        }

        public static int getInstanceCount(Class<?> cls) {
            int intValue;
            synchronized (sInstanceCounts) {
                Integer num = sInstanceCounts.get(cls);
                intValue = num != null ? num.intValue() : 0;
            }
            return intValue;
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (sInstanceCounts) {
                    Integer num = sInstanceCounts.get(this.mKlass);
                    if (num != null) {
                        int intValue = num.intValue() - 1;
                        if (intValue > 0) {
                            sInstanceCounts.put(this.mKlass, Integer.valueOf(intValue));
                        } else {
                            sInstanceCounts.remove(this.mKlass);
                        }
                    }
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$LogStackTrace.class */
    public static class LogStackTrace extends Exception {
        private LogStackTrace() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$Span.class */
    public static class Span {
        private final ThreadSpanState mContainerState;
        private long mCreateMillis;
        private String mName;
        private Span mNext;
        private Span mPrev;

        protected Span() {
            this.mContainerState = null;
        }

        Span(ThreadSpanState threadSpanState) {
            this.mContainerState = threadSpanState;
        }

        public void finish() {
            ThreadSpanState threadSpanState = this.mContainerState;
            synchronized (threadSpanState) {
                if (this.mName == null) {
                    return;
                }
                if (this.mPrev != null) {
                    this.mPrev.mNext = this.mNext;
                }
                if (this.mNext != null) {
                    this.mNext.mPrev = this.mPrev;
                }
                if (threadSpanState.mActiveHead == this) {
                    threadSpanState.mActiveHead = this.mNext;
                }
                threadSpanState.mActiveSize--;
                if (StrictMode.LOG_V) {
                    Log.d(StrictMode.TAG, "Span finished=" + this.mName + "; size=" + threadSpanState.mActiveSize);
                }
                this.mCreateMillis = -1L;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;
                if (threadSpanState.mFreeListSize < 5) {
                    this.mNext = threadSpanState.mFreeListHead;
                    threadSpanState.mFreeListHead = this;
                    threadSpanState.mFreeListSize++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$StrictModeCustomViolation.class */
    public static class StrictModeCustomViolation extends StrictModeViolation {
        public StrictModeCustomViolation(int i, String str) {
            super(i, 8, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$StrictModeDiskReadViolation.class */
    public static class StrictModeDiskReadViolation extends StrictModeViolation {
        public StrictModeDiskReadViolation(int i) {
            super(i, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$StrictModeDiskWriteViolation.class */
    public static class StrictModeDiskWriteViolation extends StrictModeViolation {
        public StrictModeDiskWriteViolation(int i) {
            super(i, 1, null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$StrictModeNetworkViolation.class */
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        public StrictModeNetworkViolation(int i) {
            super(i, 4, null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$StrictModeViolation.class */
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        public StrictModeViolation(int i, int i2, String str) {
            super(i, i2, str);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$ThreadPolicy.class */
    public static final class ThreadPolicy {
        public static final ThreadPolicy LAX = new ThreadPolicy(0);
        final int mask;

        /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$ThreadPolicy$Builder.class */
        public static final class Builder {
            private int mMask;

            public Builder() {
                this.mMask = 0;
                this.mMask = 0;
            }

            public Builder(ThreadPolicy threadPolicy) {
                this.mMask = 0;
                this.mMask = threadPolicy.mask;
            }

            private Builder disable(int i) {
                this.mMask &= i ^ (-1);
                return this;
            }

            private Builder enable(int i) {
                this.mMask |= i;
                return this;
            }

            public ThreadPolicy build() {
                if (this.mMask != 0 && (this.mMask & 240) == 0) {
                    penaltyLog();
                }
                return new ThreadPolicy(this.mMask);
            }

            public Builder detectAll() {
                return enable(15);
            }

            public Builder detectCustomSlowCalls() {
                return enable(8);
            }

            public Builder detectDiskReads() {
                return enable(2);
            }

            public Builder detectDiskWrites() {
                return enable(1);
            }

            public Builder detectNetwork() {
                return enable(4);
            }

            public Builder penaltyDeath() {
                return enable(64);
            }

            public Builder penaltyDeathOnNetwork() {
                return enable(512);
            }

            public Builder penaltyDialog() {
                return enable(32);
            }

            public Builder penaltyDropBox() {
                return enable(128);
            }

            public Builder penaltyFlashScreen() {
                return enable(2048);
            }

            public Builder penaltyLog() {
                return enable(16);
            }

            public Builder permitAll() {
                return disable(15);
            }

            public Builder permitCustomSlowCalls() {
                return disable(8);
            }

            public Builder permitDiskReads() {
                return disable(2);
            }

            public Builder permitDiskWrites() {
                return disable(1);
            }

            public Builder permitNetwork() {
                return disable(4);
            }
        }

        private ThreadPolicy(int i) {
            this.mask = i;
        }

        public String toString() {
            return "[StrictMode.ThreadPolicy; mask=" + this.mask + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$ThreadSpanState.class */
    public static class ThreadSpanState {
        public Span mActiveHead;
        public int mActiveSize;
        public Span mFreeListHead;
        public int mFreeListSize;

        private ThreadSpanState() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$ViolationInfo.class */
    public static class ViolationInfo {
        public String broadcastIntentAction;
        public final ApplicationErrorReport.CrashInfo crashInfo;
        public int durationMillis;
        public int numAnimationsRunning;
        public long numInstances;
        public final int policy;
        public String[] tags;
        public int violationNumThisLoop;
        public long violationUptimeMillis;

        public ViolationInfo() {
            this.durationMillis = -1;
            this.numAnimationsRunning = 0;
            this.numInstances = -1L;
            this.crashInfo = null;
            this.policy = 0;
        }

        public ViolationInfo(Parcel parcel) {
            this(parcel, false);
        }

        public ViolationInfo(Parcel parcel, boolean z) {
            this.durationMillis = -1;
            this.numAnimationsRunning = 0;
            this.numInstances = -1L;
            this.crashInfo = new ApplicationErrorReport.CrashInfo(parcel);
            int readInt = parcel.readInt();
            if (z) {
                this.policy = readInt & (-257);
            } else {
                this.policy = readInt;
            }
            this.durationMillis = parcel.readInt();
            this.violationNumThisLoop = parcel.readInt();
            this.numAnimationsRunning = parcel.readInt();
            this.violationUptimeMillis = parcel.readLong();
            this.numInstances = parcel.readLong();
            this.broadcastIntentAction = parcel.readString();
            this.tags = parcel.readStringArray();
        }

        public ViolationInfo(Throwable th, int i) {
            this.durationMillis = -1;
            this.numAnimationsRunning = 0;
            this.numInstances = -1L;
            this.crashInfo = new ApplicationErrorReport.CrashInfo(th);
            this.violationUptimeMillis = SystemClock.uptimeMillis();
            this.policy = i;
            this.numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent intentBeingBroadcast = ActivityThread.getIntentBeingBroadcast();
            if (intentBeingBroadcast != null) {
                this.broadcastIntentAction = intentBeingBroadcast.getAction();
            }
            ThreadSpanState threadSpanState = (ThreadSpanState) StrictMode.sThisThreadSpanState.get();
            if (th instanceof InstanceCountViolation) {
                this.numInstances = ((InstanceCountViolation) th).mInstances;
            }
            synchronized (threadSpanState) {
                int i2 = threadSpanState.mActiveSize;
                int i3 = i2 > 20 ? 20 : i2;
                if (i3 != 0) {
                    this.tags = new String[i3];
                    int i4 = 0;
                    for (Span span = threadSpanState.mActiveHead; span != null && i4 < i3; span = span.mNext) {
                        this.tags[i4] = span.mName;
                        i4++;
                    }
                }
            }
        }

        public void dump(Printer printer, String str) {
            String[] strArr;
            this.crashInfo.dump(printer, str);
            printer.println(str + "policy: " + this.policy);
            if (this.durationMillis != -1) {
                printer.println(str + "durationMillis: " + this.durationMillis);
            }
            if (this.numInstances != -1) {
                printer.println(str + "numInstances: " + this.numInstances);
            }
            if (this.violationNumThisLoop != 0) {
                printer.println(str + "violationNumThisLoop: " + this.violationNumThisLoop);
            }
            if (this.numAnimationsRunning != 0) {
                printer.println(str + "numAnimationsRunning: " + this.numAnimationsRunning);
            }
            printer.println(str + "violationUptimeMillis: " + this.violationUptimeMillis);
            if (this.broadcastIntentAction != null) {
                printer.println(str + "broadcastIntentAction: " + this.broadcastIntentAction);
            }
            if (this.tags == null) {
                return;
            }
            int length = this.tags.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    return;
                }
                printer.println(str + "tag[" + i3 + "]: " + strArr[i]);
                i++;
                i2 = i3 + 1;
            }
        }

        public int hashCode() {
            int hashCode = this.crashInfo.stackTrace.hashCode() + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
            int i = hashCode;
            if (this.numAnimationsRunning != 0) {
                i = hashCode * 37;
            }
            int i2 = i;
            if (this.broadcastIntentAction != null) {
                i2 = (i * 37) + this.broadcastIntentAction.hashCode();
            }
            int i3 = i2;
            if (this.tags != null) {
                String[] strArr = this.tags;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    i3 = i2;
                    if (i5 >= length) {
                        break;
                    }
                    i2 = (i2 * 37) + strArr[i5].hashCode();
                    i4 = i5 + 1;
                }
            }
            return i3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.crashInfo.writeToParcel(parcel, i);
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(this.policy);
            parcel.writeInt(this.durationMillis);
            parcel.writeInt(this.violationNumThisLoop);
            parcel.writeInt(this.numAnimationsRunning);
            parcel.writeLong(this.violationUptimeMillis);
            parcel.writeLong(this.numInstances);
            parcel.writeString(this.broadcastIntentAction);
            parcel.writeStringArray(this.tags);
            if (parcel.dataPosition() - dataPosition > 10240) {
                Slog.d(StrictMode.TAG, "VIO: policy=" + this.policy + " dur=" + this.durationMillis + " numLoop=" + this.violationNumThisLoop + " anim=" + this.numAnimationsRunning + " uptime=" + this.violationUptimeMillis + " numInst=" + this.numInstances);
                Slog.d(StrictMode.TAG, "VIO: action=" + this.broadcastIntentAction);
                Slog.d(StrictMode.TAG, "VIO: tags=" + Arrays.toString(this.tags));
                Slog.d(StrictMode.TAG, "VIO: TOTAL BYTES WRITTEN: " + (parcel.dataPosition() - dataPosition));
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$VmPolicy.class */
    public static final class VmPolicy {
        public static final VmPolicy LAX = new VmPolicy(0, StrictMode.EMPTY_CLASS_LIMIT_MAP);
        final HashMap<Class, Integer> classInstanceLimit;
        final int mask;

        /* loaded from: source-9557208-dex2jar.jar:android/os/StrictMode$VmPolicy$Builder.class */
        public static final class Builder {
            private HashMap<Class, Integer> mClassInstanceLimit;
            private boolean mClassInstanceLimitNeedCow;
            private int mMask;

            public Builder() {
                this.mClassInstanceLimitNeedCow = false;
                this.mMask = 0;
            }

            public Builder(VmPolicy vmPolicy) {
                this.mClassInstanceLimitNeedCow = false;
                this.mMask = vmPolicy.mask;
                this.mClassInstanceLimitNeedCow = true;
                this.mClassInstanceLimit = vmPolicy.classInstanceLimit;
            }

            private Builder enable(int i) {
                this.mMask |= i;
                return this;
            }

            public VmPolicy build() {
                if (this.mMask != 0 && (this.mMask & 240) == 0) {
                    penaltyLog();
                }
                return new VmPolicy(this.mMask, this.mClassInstanceLimit != null ? this.mClassInstanceLimit : StrictMode.EMPTY_CLASS_LIMIT_MAP);
            }

            public Builder detectActivityLeaks() {
                return enable(2048);
            }

            public Builder detectAll() {
                return enable(28160);
            }

            public Builder detectFileUriExposure() {
                return enable(16384);
            }

            public Builder detectLeakedClosableObjects() {
                return enable(1024);
            }

            public Builder detectLeakedRegistrationObjects() {
                return enable(8192);
            }

            public Builder detectLeakedSqlLiteObjects() {
                return enable(512);
            }

            public Builder penaltyDeath() {
                return enable(64);
            }

            public Builder penaltyDropBox() {
                return enable(128);
            }

            public Builder penaltyLog() {
                return enable(16);
            }

            public Builder setClassInstanceLimit(Class cls, int i) {
                if (cls == null) {
                    throw new NullPointerException("klass == null");
                }
                if (this.mClassInstanceLimitNeedCow) {
                    if (this.mClassInstanceLimit.containsKey(cls) && this.mClassInstanceLimit.get(cls).intValue() == i) {
                        return this;
                    }
                    this.mClassInstanceLimitNeedCow = false;
                    this.mClassInstanceLimit = (HashMap) this.mClassInstanceLimit.clone();
                } else if (this.mClassInstanceLimit == null) {
                    this.mClassInstanceLimit = new HashMap<>();
                }
                this.mMask |= 4096;
                this.mClassInstanceLimit.put(cls, Integer.valueOf(i));
                return this;
            }
        }

        private VmPolicy(int i, HashMap<Class, Integer> hashMap) {
            if (hashMap == null) {
                throw new NullPointerException("classInstanceLimit == null");
            }
            this.mask = i;
            this.classInstanceLimit = hashMap;
        }

        public String toString() {
            return "[StrictMode.VmPolicy; mask=" + this.mask + "]";
        }
    }

    private StrictMode() {
    }

    static /* synthetic */ boolean access$400() {
        return tooManyViolationsThisLoop();
    }

    public static ThreadPolicy allowThreadDiskReads() {
        int threadPolicyMask = getThreadPolicyMask();
        int i = threadPolicyMask & (-3);
        if (i != threadPolicyMask) {
            setThreadPolicyMask(i);
        }
        return new ThreadPolicy(threadPolicyMask);
    }

    public static ThreadPolicy allowThreadDiskWrites() {
        int threadPolicyMask = getThreadPolicyMask();
        int i = threadPolicyMask & (-4);
        if (i != threadPolicyMask) {
            setThreadPolicyMask(i);
        }
        return new ThreadPolicy(threadPolicyMask);
    }

    private static boolean amTheSystemServerProcess() {
        if (Process.myUid() != 1000) {
            return false;
        }
        Throwable th = new Throwable();
        th.fillInStackTrace();
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String className = stackTrace[i2].getClassName();
            if (className != null && className.startsWith("com.android.server.")) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    public static void conditionallyCheckInstanceCounts() {
        VmPolicy vmPolicy = getVmPolicy();
        if (vmPolicy.classInstanceLimit.size() == 0) {
            return;
        }
        System.gc();
        System.runFinalization();
        System.gc();
        for (Map.Entry<Class, Integer> entry : vmPolicy.classInstanceLimit.entrySet()) {
            Class key = entry.getKey();
            int intValue = entry.getValue().intValue();
            long countInstancesOfClass = VMDebug.countInstancesOfClass(key, false);
            if (countInstancesOfClass > intValue) {
                InstanceCountViolation instanceCountViolation = new InstanceCountViolation(key, countInstancesOfClass, intValue);
                onVmPolicyViolation(instanceCountViolation.getMessage(), instanceCountViolation);
            }
        }
    }

    public static boolean conditionallyEnableDebugLogging() {
        boolean z = SystemProperties.getBoolean(VISUAL_PROPERTY, false) && !amTheSystemServerProcess();
        boolean z2 = SystemProperties.getBoolean(DISABLE_PROPERTY, false);
        if (!z && (IS_USER_BUILD || z2)) {
            setCloseGuardEnabled(false);
            return false;
        }
        boolean z3 = z;
        if (IS_ENG_BUILD) {
            z3 = true;
        }
        int i = 7;
        if (!IS_USER_BUILD) {
            i = 7 | 128;
        }
        int i2 = i;
        if (z3) {
            i2 = i | 2048;
        }
        setThreadPolicyMask(i2);
        if (IS_USER_BUILD) {
            setCloseGuardEnabled(false);
            return true;
        }
        VmPolicy.Builder penaltyDropBox = new VmPolicy.Builder().detectAll().penaltyDropBox();
        if (IS_ENG_BUILD) {
            penaltyDropBox.penaltyLog();
        }
        setVmPolicy(penaltyDropBox.build());
        setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[Catch: all -> 0x0019, TRY_ENTER, TryCatch #0 {all -> 0x0019, blocks: (B:7:0x0008, B:10:0x0017, B:17:0x001f, B:19:0x0030, B:36:0x0080, B:24:0x003f, B:28:0x004d, B:37:0x008b), top: B:39:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b A[Catch: all -> 0x0019, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0019, blocks: (B:7:0x0008, B:10:0x0017, B:17:0x001f, B:19:0x0030, B:36:0x0080, B:24:0x003f, B:28:0x004d, B:37:0x008b), top: B:39:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void decrementExpectedActivityCount(java.lang.Class r7) {
        /*
            r0 = r7
            if (r0 != 0) goto L5
        L4:
            return
        L5:
            java.lang.Class<android.os.StrictMode> r0 = android.os.StrictMode.class
            monitor-enter(r0)
            android.os.StrictMode$VmPolicy r0 = android.os.StrictMode.sVmPolicy     // Catch: java.lang.Throwable -> L19
            int r0 = r0.mask     // Catch: java.lang.Throwable -> L19
            r1 = 2048(0x800, float:2.87E-42)
            r0 = r0 & r1
            if (r0 != 0) goto L1f
            java.lang.Class<android.os.StrictMode> r0 = android.os.StrictMode.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            return
        L19:
            r7 = move-exception
            java.lang.Class<android.os.StrictMode> r0 = android.os.StrictMode.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            r0 = r7
            throw r0
        L1f:
            java.util.HashMap<java.lang.Class, java.lang.Integer> r0 = android.os.StrictMode.sExpectedActivityInstanceCount     // Catch: java.lang.Throwable -> L19
            r1 = r7
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L19
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L19
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L9a
            r0 = r11
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L80
            goto L9a
        L3b:
            r0 = r8
            if (r0 != 0) goto L8b
            java.util.HashMap<java.lang.Class, java.lang.Integer> r0 = android.os.StrictMode.sExpectedActivityInstanceCount     // Catch: java.lang.Throwable -> L19
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L19
        L47:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            java.lang.Class<android.os.StrictMode> r0 = android.os.StrictMode.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            r0 = r7
            int r0 = android.os.StrictMode.InstanceTracker.getInstanceCount(r0)
            r1 = r8
            if (r0 <= r1) goto L4
            java.lang.System.gc()
            java.lang.System.runFinalization()
            java.lang.System.gc()
            r0 = r7
            r1 = 0
            long r0 = dalvik.system.VMDebug.countInstancesOfClass(r0, r1)
            r9 = r0
            r0 = r9
            r1 = r8
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4
            android.os.StrictMode$InstanceCountViolation r0 = new android.os.StrictMode$InstanceCountViolation
            r1 = r0
            r2 = r7
            r3 = r9
            r4 = r8
            r1.<init>(r2, r3, r4)
            r7 = r0
            r0 = r7
            java.lang.String r0 = r0.getMessage()
            r1 = r7
            onVmPolicyViolation(r0, r1)
            return
        L80:
            r0 = r11
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L19
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            goto L3b
        L8b:
            java.util.HashMap<java.lang.Class, java.lang.Integer> r0 = android.os.StrictMode.sExpectedActivityInstanceCount     // Catch: java.lang.Throwable -> L19
            r1 = r7
            r2 = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L19
            goto L47
        L9a:
            r0 = 0
            r8 = r0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.StrictMode.decrementExpectedActivityCount(java.lang.Class):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dropboxViolationAsync(final int i, final ViolationInfo violationInfo) {
        int incrementAndGet = sDropboxCallsInFlight.incrementAndGet();
        if (incrementAndGet > 20) {
            sDropboxCallsInFlight.decrementAndGet();
            return;
        }
        if (LOG_V) {
            Log.d(TAG, "Dropboxing async; in-flight=" + incrementAndGet);
        }
        new Thread("callActivityManagerForStrictModeDropbox") { // from class: android.os.StrictMode.5
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0051 -> B:6:0x0015). Please submit an issue!!! */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                try {
                    IActivityManager iActivityManager = ActivityManagerNative.getDefault();
                    if (iActivityManager == null) {
                        Log.d(StrictMode.TAG, "No activity manager; failed to Dropbox violation.");
                    } else {
                        iActivityManager.handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), i, violationInfo);
                    }
                } catch (RemoteException e) {
                    Log.e(StrictMode.TAG, "RemoteException handling StrictMode violation", e);
                }
                int decrementAndGet = StrictMode.sDropboxCallsInFlight.decrementAndGet();
                if (StrictMode.LOG_V) {
                    Log.d(StrictMode.TAG, "Dropbox complete; in-flight=" + decrementAndGet);
                }
            }
        }.start();
    }

    public static void enableDeathOnNetwork() {
        setThreadPolicyMask(getThreadPolicyMask() | 4 | 512);
    }

    public static void enableDefaults() {
        setThreadPolicy(new ThreadPolicy.Builder().detectAll().penaltyLog().build());
        setVmPolicy(new VmPolicy.Builder().detectAll().penaltyLog().build());
    }

    public static Span enterCriticalSpan(String str) {
        Span span;
        if (IS_USER_BUILD) {
            return NO_OP_SPAN;
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("name must be non-null and non-empty");
        }
        ThreadSpanState threadSpanState = sThisThreadSpanState.get();
        synchronized (threadSpanState) {
            if (threadSpanState.mFreeListHead != null) {
                span = threadSpanState.mFreeListHead;
                threadSpanState.mFreeListHead = span.mNext;
                threadSpanState.mFreeListSize--;
            } else {
                span = new Span(threadSpanState);
            }
            span.mName = str;
            span.mCreateMillis = SystemClock.uptimeMillis();
            span.mNext = threadSpanState.mActiveHead;
            span.mPrev = null;
            threadSpanState.mActiveHead = span;
            threadSpanState.mActiveSize++;
            if (span.mNext != null) {
                span.mNext.mPrev = span;
            }
            if (LOG_V) {
                Log.d(TAG, "Span enter=" + str + "; size=" + threadSpanState.mActiveSize);
            }
        }
        return span;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void executeDeathPenalty(ViolationInfo violationInfo) {
        throw new StrictModeViolation(violationInfo.policy, parseViolationFromMessage(violationInfo.crashInfo.exceptionMessage), null);
    }

    public static ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy(getThreadPolicyMask());
    }

    public static int getThreadPolicyMask() {
        return BlockGuard.getThreadPolicy().getPolicyMask();
    }

    public static VmPolicy getVmPolicy() {
        VmPolicy vmPolicy;
        synchronized (StrictMode.class) {
            try {
                vmPolicy = sVmPolicy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return vmPolicy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasGatheredViolations() {
        return gatheredViolations.get() != null;
    }

    public static void incrementExpectedActivityCount(Class cls) {
        if (cls == null) {
            return;
        }
        synchronized (StrictMode.class) {
            try {
                if ((sVmPolicy.mask & 2048) == 0) {
                    return;
                }
                Integer num = sExpectedActivityInstanceCount.get(cls);
                sExpectedActivityInstanceCount.put(cls, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            } finally {
            }
        }
    }

    public static void noteDiskRead() {
        BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
        if (threadPolicy instanceof AndroidBlockGuardPolicy) {
            ((AndroidBlockGuardPolicy) threadPolicy).onReadFromDisk();
        }
    }

    public static void noteDiskWrite() {
        BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
        if (threadPolicy instanceof AndroidBlockGuardPolicy) {
            ((AndroidBlockGuardPolicy) threadPolicy).onWriteToDisk();
        }
    }

    public static void noteSlowCall(String str) {
        BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
        if (threadPolicy instanceof AndroidBlockGuardPolicy) {
            ((AndroidBlockGuardPolicy) threadPolicy).onCustomSlowCall(str);
        }
    }

    private static void onBinderStrictModePolicyChange(int i) {
        setBlockGuardPolicy(i);
    }

    public static void onFileUriExposed(String str) {
        String str2 = "file:// Uri exposed through " + str;
        onVmPolicyViolation(str2, new Throwable(str2));
    }

    public static void onIntentReceiverLeaked(Throwable th) {
        onVmPolicyViolation(null, th);
    }

    public static void onServiceConnectionLeaked(Throwable th) {
        onVmPolicyViolation(null, th);
    }

    public static void onSqliteObjectLeaked(String str, Throwable th) {
        onVmPolicyViolation(str, th);
    }

    public static void onVmPolicyViolation(String str, Throwable th) {
        boolean z = (sVmPolicyMask & 128) != 0;
        boolean z2 = (sVmPolicyMask & 64) != 0;
        boolean z3 = (sVmPolicyMask & 16) != 0;
        ViolationInfo violationInfo = new ViolationInfo(th, sVmPolicyMask);
        violationInfo.numAnimationsRunning = 0;
        violationInfo.tags = null;
        violationInfo.broadcastIntentAction = null;
        Integer valueOf = Integer.valueOf(violationInfo.hashCode());
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        long j2 = Long.MAX_VALUE;
        synchronized (sLastVmViolationTime) {
            if (sLastVmViolationTime.containsKey(valueOf)) {
                j = sLastVmViolationTime.get(valueOf).longValue();
                j2 = uptimeMillis - j;
            }
            if (j2 > 1000) {
                sLastVmViolationTime.put(valueOf, Long.valueOf(uptimeMillis));
            }
        }
        if (z3 && j2 > 1000) {
            Log.e(TAG, str, th);
        }
        int i = (sVmPolicyMask & ALL_VM_DETECT_BITS) | 128;
        if (z && !z2) {
            dropboxViolationAsync(i, violationInfo);
            return;
        }
        if (z && j == 0) {
            int threadPolicyMask = getThreadPolicyMask();
            try {
                setThreadPolicyMask(0);
                ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), i, violationInfo);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException trying to handle StrictMode violation", e);
            } finally {
                setThreadPolicyMask(threadPolicyMask);
            }
        }
        if (z2) {
            System.err.println("StrictMode VmPolicy violation with POLICY_DEATH; shutting down.");
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    public static void onWebViewMethodCalledOnWrongThread(Throwable th) {
        onVmPolicyViolation(null, th);
    }

    private static int parsePolicyFromMessage(String str) {
        int indexOf;
        if (str == null || !str.startsWith("policy=") || (indexOf = str.indexOf(32)) == -1) {
            return 0;
        }
        try {
            return Integer.valueOf(str.substring(7, indexOf)).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseViolationFromMessage(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf("violation=")) == -1) {
            return 0;
        }
        int length = indexOf + "violation=".length();
        int indexOf2 = str.indexOf(32, length);
        int i = indexOf2;
        if (indexOf2 == -1) {
            i = str.length();
        }
        try {
            return Integer.valueOf(str.substring(length, i)).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void readAndHandleBinderCallViolations(Parcel parcel) {
        StringWriter stringWriter = new StringWriter();
        FastPrintWriter fastPrintWriter = new FastPrintWriter((Writer) stringWriter, false, 256);
        new LogStackTrace().printStackTrace(fastPrintWriter);
        fastPrintWriter.flush();
        String stringWriter2 = stringWriter.toString();
        int threadPolicyMask = getThreadPolicyMask();
        boolean z = (threadPolicyMask & 256) != 0;
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            if (LOG_V) {
                Log.d(TAG, "strict mode violation stacks read from binder call.  i=" + i2);
            }
            ViolationInfo violationInfo = new ViolationInfo(parcel, !z);
            if (violationInfo.crashInfo.stackTrace == null || violationInfo.crashInfo.stackTrace.length() <= 10000) {
                StringBuilder sb = new StringBuilder();
                ApplicationErrorReport.CrashInfo crashInfo = violationInfo.crashInfo;
                crashInfo.stackTrace = sb.append(crashInfo.stackTrace).append("# via Binder call with stack:\n").append(stringWriter2).toString();
                BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
                if (threadPolicy instanceof AndroidBlockGuardPolicy) {
                    ((AndroidBlockGuardPolicy) threadPolicy).handleViolationWithTimingAttempt(violationInfo);
                }
                i = i2 + 1;
            } else {
                String substring = violationInfo.crashInfo.stackTrace.substring(256);
                while (true) {
                    i2++;
                    if (i2 >= readInt) {
                        clearGatheredViolations();
                        Slog.wtfStack(TAG, "Stack is too large: numViolations=" + readInt + " policy=#" + Integer.toHexString(threadPolicyMask) + " front=" + substring);
                        return;
                    }
                    new ViolationInfo(parcel, !z);
                }
            }
        }
    }

    private static void setBlockGuardPolicy(int i) {
        AndroidBlockGuardPolicy androidBlockGuardPolicy;
        if (i == 0) {
            BlockGuard.setThreadPolicy(BlockGuard.LAX_POLICY);
            return;
        }
        BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
        if (threadPolicy instanceof AndroidBlockGuardPolicy) {
            androidBlockGuardPolicy = (AndroidBlockGuardPolicy) threadPolicy;
        } else {
            androidBlockGuardPolicy = threadAndroidPolicy.get();
            BlockGuard.setThreadPolicy(androidBlockGuardPolicy);
        }
        androidBlockGuardPolicy.setPolicyMask(i);
    }

    private static void setCloseGuardEnabled(boolean z) {
        if (!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter)) {
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        }
        CloseGuard.setEnabled(z);
    }

    public static void setThreadPolicy(ThreadPolicy threadPolicy) {
        setThreadPolicyMask(threadPolicy.mask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setThreadPolicyMask(int i) {
        setBlockGuardPolicy(i);
        Binder.setThreadStrictModePolicy(i);
    }

    public static void setVmPolicy(VmPolicy vmPolicy) {
        synchronized (StrictMode.class) {
            try {
                sVmPolicy = vmPolicy;
                sVmPolicyMask = vmPolicy.mask;
                setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper != null) {
                    MessageQueue messageQueue = mainLooper.mQueue;
                    if (vmPolicy.classInstanceLimit.size() == 0 || (sVmPolicyMask & 208) == 0) {
                        messageQueue.removeIdleHandler(sProcessIdleHandler);
                        sIsIdlerRegistered = false;
                    } else if (!sIsIdlerRegistered) {
                        messageQueue.addIdleHandler(sProcessIdleHandler);
                        sIsIdlerRegistered = true;
                    }
                }
            } finally {
            }
        }
    }

    private static boolean tooManyViolationsThisLoop() {
        return violationsBeingTimed.get().size() >= 10;
    }

    public static Object trackActivity(Object obj) {
        return new InstanceTracker(obj);
    }

    public static boolean vmClosableObjectLeaksEnabled() {
        return (sVmPolicyMask & 1024) != 0;
    }

    public static boolean vmFileUriExposureEnabled() {
        return (sVmPolicyMask & 16384) != 0;
    }

    public static boolean vmRegistrationLeaksEnabled() {
        return (sVmPolicyMask & 8192) != 0;
    }

    public static boolean vmSqliteObjectLeaksEnabled() {
        return (sVmPolicyMask & 512) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeGatheredViolationsToParcel(Parcel parcel) {
        ArrayList<ViolationInfo> arrayList = gatheredViolations.get();
        if (arrayList == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(arrayList.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                int dataPosition = parcel.dataPosition();
                arrayList.get(i2).writeToParcel(parcel, 0);
                if (parcel.dataPosition() - dataPosition > 10240) {
                    Slog.d(TAG, "Wrote violation #" + i2 + " of " + arrayList.size() + ": " + (parcel.dataPosition() - dataPosition) + " bytes");
                }
                i = i2 + 1;
            }
            if (LOG_V) {
                Log.d(TAG, "wrote violations to response parcel; num=" + arrayList.size());
            }
            arrayList.clear();
        }
        gatheredViolations.set(null);
    }
}
