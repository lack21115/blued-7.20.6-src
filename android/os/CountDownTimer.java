package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/CountDownTimer.class */
public abstract class CountDownTimer {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;
    private boolean mCancelled = false;
    private Handler mHandler = new Handler() { // from class: android.os.CountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (CountDownTimer.this) {
                if (CountDownTimer.this.mCancelled) {
                    return;
                }
                long elapsedRealtime = CountDownTimer.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    CountDownTimer.this.onFinish();
                } else if (elapsedRealtime < CountDownTimer.this.mCountdownInterval) {
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    CountDownTimer.this.onTick(elapsedRealtime);
                    long elapsedRealtime3 = (CountDownTimer.this.mCountdownInterval + elapsedRealtime2) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += CountDownTimer.this.mCountdownInterval;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            }
        }
    };

    public CountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final void cancel() {
        synchronized (this) {
            this.mCancelled = true;
            this.mHandler.removeMessages(1);
        }
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final CountDownTimer start() {
        synchronized (this) {
            this.mCancelled = false;
            if (this.mMillisInFuture <= 0) {
                onFinish();
            } else {
                this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        }
        return this;
    }
}
