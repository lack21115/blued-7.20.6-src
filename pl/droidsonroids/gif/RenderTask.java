package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/RenderTask.class */
public class RenderTask extends SafeRunnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // pl.droidsonroids.gif.SafeRunnable
    public void a() {
        long a = this.c.f.a(this.c.e);
        if (a >= 0) {
            this.c.c = SystemClock.uptimeMillis() + a;
            if (this.c.isVisible() && this.c.b && !this.c.h) {
                this.c.a.remove(this);
                this.c.j = this.c.a.schedule(this, a, TimeUnit.MILLISECONDS);
            }
            if (!this.c.g.isEmpty() && this.c.d() == this.c.f.p() - 1) {
                this.c.i.sendEmptyMessageAtTime(this.c.e(), this.c.c);
            }
        } else {
            this.c.c = Long.MIN_VALUE;
            this.c.b = false;
        }
        if (!this.c.isVisible() || this.c.i.hasMessages(-1)) {
            return;
        }
        this.c.i.sendEmptyMessageAtTime(-1, 0L);
    }
}
