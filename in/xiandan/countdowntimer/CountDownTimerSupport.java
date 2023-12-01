package in.xiandan.countdowntimer;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8829756-dex2jar.jar:in/xiandan/countdowntimer/CountDownTimerSupport.class */
public class CountDownTimerSupport implements ITimerSupport {

    /* renamed from: a  reason: collision with root package name */
    private Timer f28552a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private long f28553c;
    private long d;
    private long e;
    private OnCountDownTimerListener f;
    private TimerState g;

    @Deprecated
    public CountDownTimerSupport() {
        this.g = TimerState.FINISH;
        this.b = new Handler();
    }

    public CountDownTimerSupport(long j, long j2) {
        this.g = TimerState.FINISH;
        a(j);
        b(j2);
        this.b = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        if (this.f28552a != null) {
            f();
            this.e = this.f28553c;
            this.g = TimerState.FINISH;
            this.b.post(new Runnable() { // from class: in.xiandan.countdowntimer.CountDownTimerSupport.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CountDownTimerSupport.this.f != null) {
                        if (z) {
                            CountDownTimerSupport.this.f.b();
                        } else {
                            CountDownTimerSupport.this.f.a();
                        }
                    }
                }
            });
        }
    }

    private void f() {
        this.f28552a.cancel();
        this.f28552a.purge();
        this.f28552a = null;
    }

    public void a() {
        if (this.f28552a != null || this.g == TimerState.START) {
            return;
        }
        Timer timer = new Timer();
        this.f28552a = timer;
        timer.scheduleAtFixedRate(e(), 0L, this.d);
        this.g = TimerState.START;
    }

    @Deprecated
    public void a(long j) {
        this.f28553c = j;
        this.e = j;
    }

    public void a(OnCountDownTimerListener onCountDownTimerListener) {
        this.f = onCountDownTimerListener;
    }

    public void b() {
        if (this.f28552a == null || this.g != TimerState.START) {
            return;
        }
        f();
        this.g = TimerState.PAUSE;
    }

    @Deprecated
    public void b(long j) {
        this.d = j;
    }

    public void c() {
        if (this.g == TimerState.PAUSE) {
            a();
        }
    }

    public void d() {
        a(true);
    }

    protected TimerTask e() {
        return new TimerTask() { // from class: in.xiandan.countdowntimer.CountDownTimerSupport.2
            private long b = -1;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (this.b < 0) {
                    this.b = scheduledExecutionTime() - (CountDownTimerSupport.this.f28553c - CountDownTimerSupport.this.e);
                    CountDownTimerSupport.this.b.post(new Runnable() { // from class: in.xiandan.countdowntimer.CountDownTimerSupport.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CountDownTimerSupport.this.f != null) {
                                CountDownTimerSupport.this.f.a(CountDownTimerSupport.this.e);
                            }
                        }
                    });
                    return;
                }
                CountDownTimerSupport countDownTimerSupport = CountDownTimerSupport.this;
                countDownTimerSupport.e = countDownTimerSupport.f28553c - (scheduledExecutionTime() - this.b);
                CountDownTimerSupport.this.b.post(new Runnable() { // from class: in.xiandan.countdowntimer.CountDownTimerSupport.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CountDownTimerSupport.this.f != null) {
                            CountDownTimerSupport.this.f.a(CountDownTimerSupport.this.e);
                        }
                    }
                });
                if (CountDownTimerSupport.this.e <= 0) {
                    CountDownTimerSupport.this.a(false);
                }
            }
        };
    }
}
