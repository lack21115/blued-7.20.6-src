package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/GestureDetectorCompat.class */
public final class GestureDetectorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetectorCompatImpl f2634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImpl.class */
    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase.class */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int j = ViewConfiguration.getTapTimeout();
        private static final int k = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        final GestureDetector.OnGestureListener f2635a;
        GestureDetector.OnDoubleTapListener b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2636c;
        boolean d;
        MotionEvent e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler l;
        private boolean m;
        private boolean n;
        private boolean o;
        private MotionEvent p;
        private boolean q;
        private float r;
        private float s;
        private float t;
        private float u;
        private boolean v;
        private VelocityTracker w;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler.class */
        class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase.this.f2635a.onShowPress(GestureDetectorCompatImplBase.this.e);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.a();
                } else if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                } else if (GestureDetectorCompatImplBase.this.b != null) {
                    if (GestureDetectorCompatImplBase.this.f2636c) {
                        GestureDetectorCompatImplBase.this.d = true;
                    } else {
                        GestureDetectorCompatImplBase.this.b.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.e);
                    }
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.l = new GestureHandler(handler);
            } else {
                this.l = new GestureHandler();
            }
            this.f2635a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f2635a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.v = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f = scaledTouchSlop * scaledTouchSlop;
            this.g = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            boolean z = false;
            if (this.o && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= k) {
                int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                if ((x * x) + (y * y) < this.g) {
                    z = true;
                }
                return z;
            }
            return false;
        }

        private void b() {
            this.l.removeMessages(1);
            this.l.removeMessages(2);
            this.l.removeMessages(3);
            this.w.recycle();
            this.w = null;
            this.q = false;
            this.f2636c = false;
            this.n = false;
            this.o = false;
            this.d = false;
            if (this.m) {
                this.m = false;
            }
        }

        private void c() {
            this.l.removeMessages(1);
            this.l.removeMessages(2);
            this.l.removeMessages(3);
            this.q = false;
            this.n = false;
            this.o = false;
            this.d = false;
            if (this.m) {
                this.m = false;
            }
        }

        void a() {
            this.l.removeMessages(3);
            this.d = false;
            this.m = true;
            this.f2635a.onLongPress(this.e);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.v;
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x0246, code lost:
            if (java.lang.Math.abs(r0) >= 1.0f) goto L79;
         */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0412  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x043f  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                Method dump skipped, instructions count: 1160
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.v = z;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.b = onDoubleTapListener;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2.class */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f2638a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2638a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.f2638a.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f2638a.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.f2638a.setIsLongpressEnabled(z);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2638a.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2634a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f2634a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.f2634a.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2634a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f2634a.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f2634a.setOnDoubleTapListener(onDoubleTapListener);
    }
}
