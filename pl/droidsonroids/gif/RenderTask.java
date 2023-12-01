package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/RenderTask.class */
class RenderTask extends SafeRunnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // pl.droidsonroids.gif.SafeRunnable
    public void a() {
        long a2 = this.f44170c.f.a(this.f44170c.e);
        if (a2 >= 0) {
            this.f44170c.f44130c = SystemClock.uptimeMillis() + a2;
            if (this.f44170c.isVisible() && this.f44170c.b && !this.f44170c.h) {
                this.f44170c.f44129a.remove(this);
                this.f44170c.j = this.f44170c.f44129a.schedule(this, a2, TimeUnit.MILLISECONDS);
            }
            if (!this.f44170c.g.isEmpty() && this.f44170c.d() == this.f44170c.f.p() - 1) {
                this.f44170c.i.sendEmptyMessageAtTime(this.f44170c.e(), this.f44170c.f44130c);
            }
        } else {
            this.f44170c.f44130c = Long.MIN_VALUE;
            this.f44170c.b = false;
        }
        if (!this.f44170c.isVisible() || this.f44170c.i.hasMessages(-1)) {
            return;
        }
        this.f44170c.i.sendEmptyMessageAtTime(-1, 0L);
    }
}
