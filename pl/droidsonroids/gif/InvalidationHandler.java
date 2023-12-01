package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/InvalidationHandler.class */
class InvalidationHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<GifDrawable> f44164a;

    public InvalidationHandler(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.f44164a = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GifDrawable gifDrawable = this.f44164a.get();
        if (gifDrawable == null) {
            return;
        }
        if (message.what == -1) {
            gifDrawable.invalidateSelf();
            return;
        }
        Iterator<AnimationListener> it = gifDrawable.g.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
