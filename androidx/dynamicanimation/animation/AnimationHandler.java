package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler.class */
public class AnimationHandler {
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();
    private AnimationFrameCallbackProvider e;

    /* renamed from: c  reason: collision with root package name */
    private final SimpleArrayMap<AnimationFrameCallback, Long> f2746c = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<AnimationFrameCallback> f2745a = new ArrayList<>();
    private final AnimationCallbackDispatcher d = new AnimationCallbackDispatcher();
    long b = 0;
    private boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler$AnimationCallbackDispatcher.class */
    public class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        void a() {
            AnimationHandler.this.b = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.a(animationHandler.b);
            if (AnimationHandler.this.f2745a.size() > 0) {
                AnimationHandler.this.a().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler$AnimationFrameCallback.class */
    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler$AnimationFrameCallbackProvider.class */
    public static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a  reason: collision with root package name */
        final AnimationCallbackDispatcher f2748a;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f2748a = animationCallbackDispatcher;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler$FrameCallbackProvider14.class */
    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        long b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f2749c;
        private final Handler d;

        FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.b = -1L;
            this.f2749c = new Runnable() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameCallbackProvider14.this.b = SystemClock.uptimeMillis();
                    FrameCallbackProvider14.this.f2748a.a();
                }
            };
            this.d = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void a() {
            this.d.postDelayed(this.f2749c, Math.max(10 - (SystemClock.uptimeMillis() - this.b), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/AnimationHandler$FrameCallbackProvider16.class */
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer b;

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f2751c;

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.b = Choreographer.getInstance();
            this.f2751c = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    FrameCallbackProvider16.this.f2748a.a();
                }
            };
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void a() {
            this.b.postFrameCallback(this.f2751c);
        }
    }

    AnimationHandler() {
    }

    private boolean a(AnimationFrameCallback animationFrameCallback, long j) {
        Long l = this.f2746c.get(animationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f2746c.remove(animationFrameCallback);
            return true;
        }
        return false;
    }

    private void b() {
        if (!this.f) {
            return;
        }
        int size = this.f2745a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                this.f = false;
                return;
            }
            if (this.f2745a.get(i) == null) {
                this.f2745a.remove(i);
            }
            size = i;
        }
    }

    public static long getFrameTime() {
        if (sAnimatorHandler.get() == null) {
            return 0L;
        }
        return sAnimatorHandler.get().b;
    }

    public static AnimationHandler getInstance() {
        if (sAnimatorHandler.get() == null) {
            sAnimatorHandler.set(new AnimationHandler());
        }
        return sAnimatorHandler.get();
    }

    AnimationFrameCallbackProvider a() {
        if (this.e == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.e = new FrameCallbackProvider16(this.d);
            } else {
                this.e = new FrameCallbackProvider14(this.d);
            }
        }
        return this.e;
    }

    void a(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2745a.size()) {
                b();
                return;
            }
            AnimationFrameCallback animationFrameCallback = this.f2745a.get(i2);
            if (animationFrameCallback != null && a(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j);
            }
            i = i2 + 1;
        }
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.f2745a.size() == 0) {
            a().a();
        }
        if (!this.f2745a.contains(animationFrameCallback)) {
            this.f2745a.add(animationFrameCallback);
        }
        if (j > 0) {
            this.f2746c.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.f2746c.remove(animationFrameCallback);
        int indexOf = this.f2745a.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.f2745a.set(indexOf, null);
            this.f = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.e = animationFrameCallbackProvider;
    }
}
