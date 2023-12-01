package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Timer.class */
public class Timer {
    private static long timerId;
    private final FinalizerHelper finalizer;
    private final TimerImpl impl;

    /* loaded from: source-2895416-dex2jar.jar:java/util/Timer$FinalizerHelper.class */
    private static final class FinalizerHelper {
        private final TimerImpl impl;

        FinalizerHelper(TimerImpl timerImpl) {
            this.impl = timerImpl;
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this.impl) {
                    this.impl.finished = true;
                    this.impl.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Timer$TimerImpl.class */
    public static final class TimerImpl extends Thread {
        private boolean cancelled;
        private boolean finished;
        private TimerHeap tasks = new TimerHeap();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/Timer$TimerImpl$TimerHeap.class */
        public static final class TimerHeap {
            private int DEFAULT_HEAP_SIZE;
            private int deletedCancelledNumber;
            private int size;
            private TimerTask[] timers;

            private TimerHeap() {
                this.DEFAULT_HEAP_SIZE = 256;
                this.timers = new TimerTask[this.DEFAULT_HEAP_SIZE];
                this.size = 0;
                this.deletedCancelledNumber = 0;
            }

            private void downHeap(int i) {
                int i2 = i;
                int i3 = (i * 2) + 1;
                while (i3 < this.size && this.size > 0) {
                    int i4 = i3;
                    if (i3 + 1 < this.size) {
                        i4 = i3;
                        if (this.timers[i3 + 1].when < this.timers[i3].when) {
                            i4 = i3 + 1;
                        }
                    }
                    if (this.timers[i2].when < this.timers[i4].when) {
                        return;
                    }
                    TimerTask timerTask = this.timers[i2];
                    this.timers[i2] = this.timers[i4];
                    this.timers[i4] = timerTask;
                    i3 = (i4 * 2) + 1;
                    i2 = i4;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getTask(TimerTask timerTask) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.timers.length) {
                        return -1;
                    }
                    if (this.timers[i2] == timerTask) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            }

            private void upHeap() {
                int i = this.size - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    int i3 = i2;
                    if (this.timers[i].when >= this.timers[i3].when) {
                        return;
                    }
                    TimerTask timerTask = this.timers[i];
                    this.timers[i] = this.timers[i3];
                    this.timers[i3] = timerTask;
                    i = i3;
                    i2 = (i3 - 1) / 2;
                }
            }

            public void adjustMinimum() {
                downHeap(0);
            }

            public void delete(int i) {
                if (i < 0 || i >= this.size) {
                    return;
                }
                TimerTask[] timerTaskArr = this.timers;
                TimerTask[] timerTaskArr2 = this.timers;
                int i2 = this.size - 1;
                this.size = i2;
                timerTaskArr[i] = timerTaskArr2[i2];
                this.timers[this.size] = null;
                downHeap(i);
            }

            public void deleteIfCancelled() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.size) {
                        return;
                    }
                    int i3 = i2;
                    if (this.timers[i2].cancelled) {
                        this.deletedCancelledNumber++;
                        delete(i2);
                        i3 = i2 - 1;
                    }
                    i = i3 + 1;
                }
            }

            public void insert(TimerTask timerTask) {
                if (this.timers.length == this.size) {
                    TimerTask[] timerTaskArr = new TimerTask[this.size * 2];
                    System.arraycopy(this.timers, 0, timerTaskArr, 0, this.size);
                    this.timers = timerTaskArr;
                }
                TimerTask[] timerTaskArr2 = this.timers;
                int i = this.size;
                this.size = i + 1;
                timerTaskArr2[i] = timerTask;
                upHeap();
            }

            public boolean isEmpty() {
                return this.size == 0;
            }

            public TimerTask minimum() {
                return this.timers[0];
            }

            public void reset() {
                this.timers = new TimerTask[this.DEFAULT_HEAP_SIZE];
                this.size = 0;
            }
        }

        TimerImpl(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void insertTask(TimerTask timerTask) {
            this.tasks.insert(timerTask);
            notify();
        }

        public void cancel() {
            synchronized (this) {
                this.cancelled = true;
                this.tasks.reset();
                notify();
            }
        }

        public int purge() {
            if (this.tasks.isEmpty()) {
                return 0;
            }
            this.tasks.deletedCancelledNumber = 0;
            this.tasks.deleteIfCancelled();
            return this.tasks.deletedCancelledNumber;
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x014f, code lost:
            monitor-enter(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0150, code lost:
            r6.cancelled = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0159, code lost:
            throw r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0000, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x010c, code lost:
            r0.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0110, code lost:
            if (1 != 0) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0114, code lost:
            monitor-enter(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0115, code lost:
            r6.cancelled = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x011b, code lost:
            monitor-exit(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0148, code lost:
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x014b, code lost:
            if (0 == 0) goto L77;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Timer.TimerImpl.run():void");
        }
    }

    public Timer() {
        this(false);
    }

    public Timer(String str) {
        this(str, false);
    }

    public Timer(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.impl = new TimerImpl(str, z);
        this.finalizer = new FinalizerHelper(this.impl);
    }

    public Timer(boolean z) {
        this("Timer-" + nextId(), z);
    }

    private static long nextId() {
        long j;
        synchronized (Timer.class) {
            try {
                j = timerId;
                timerId = 1 + j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private void scheduleImpl(TimerTask timerTask, long j, long j2, boolean z) {
        synchronized (this.impl) {
            if (this.impl.cancelled) {
                throw new IllegalStateException("Timer was canceled");
            }
            long currentTimeMillis = j + System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + currentTimeMillis);
            }
            synchronized (timerTask.lock) {
                if (timerTask.isScheduled()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                }
                if (timerTask.cancelled) {
                    throw new IllegalStateException("TimerTask is canceled");
                }
                timerTask.when = currentTimeMillis;
                timerTask.period = j2;
                timerTask.fixedRate = z;
            }
            this.impl.insertTask(timerTask);
        }
    }

    public void cancel() {
        this.impl.cancel();
    }

    public int purge() {
        int purge;
        synchronized (this.impl) {
            purge = this.impl.purge();
        }
        return purge;
    }

    public void schedule(TimerTask timerTask, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        scheduleImpl(timerTask, j, -1L, false);
    }

    public void schedule(TimerTask timerTask, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, j, j2, false);
    }

    public void schedule(TimerTask timerTask, Date date) {
        long j = 0;
        if (date.getTime() < 0) {
            throw new IllegalArgumentException("when < 0: " + date.getTime());
        }
        long time = date.getTime() - System.currentTimeMillis();
        if (time >= 0) {
            j = time;
        }
        scheduleImpl(timerTask, j, -1L, false);
    }

    public void schedule(TimerTask timerTask, Date date, long j) {
        long j2 = 0;
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long time = date.getTime() - System.currentTimeMillis();
        if (time >= 0) {
            j2 = time;
        }
        scheduleImpl(timerTask, j2, j, false);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, j, j2, true);
    }

    public void scheduleAtFixedRate(TimerTask timerTask, Date date, long j) {
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(timerTask, date.getTime() - System.currentTimeMillis(), j, true);
    }
}
