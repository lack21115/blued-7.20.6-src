package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/CustomViewTarget.class */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    private static final int b = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f7452a;

    /* renamed from: c  reason: collision with root package name */
    private final SizeDeterminer f7453c;
    private View.OnAttachStateChangeListener d;
    private boolean e;
    private boolean f;

    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/CustomViewTarget$1.class */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomViewTarget f7454a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f7454a.a();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f7454a.b();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/CustomViewTarget$SizeDeterminer.class */
    static final class SizeDeterminer {

        /* renamed from: a  reason: collision with root package name */
        static Integer f7455a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final View f7456c;
        private final List<SizeReadyCallback> d = new ArrayList();
        private SizeDeterminerLayoutListener e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/CustomViewTarget$SizeDeterminer$SizeDeterminerLayoutListener.class */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f7457a;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f7457a = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f7457a.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.a();
                    return true;
                }
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f7456c = view;
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.b && this.f7456c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f7456c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f7456c.getContext());
        }

        private static int a(Context context) {
            if (f7455a == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.a((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f7455a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f7455a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.d).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).a(i, i2);
            }
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean b(int i, int i2) {
            return a(i) && a(i2);
        }

        private int c() {
            int paddingTop = this.f7456c.getPaddingTop();
            int paddingBottom = this.f7456c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f7456c.getLayoutParams();
            return a(this.f7456c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop + paddingBottom);
        }

        private int d() {
            int paddingLeft = this.f7456c.getPaddingLeft();
            int paddingRight = this.f7456c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f7456c.getLayoutParams();
            return a(this.f7456c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft + paddingRight);
        }

        void a() {
            if (this.d.isEmpty()) {
                return;
            }
            int d = d();
            int c2 = c();
            if (b(d, c2)) {
                a(d, c2);
                b();
            }
        }

        void a(SizeReadyCallback sizeReadyCallback) {
            int d = d();
            int c2 = c();
            if (b(d, c2)) {
                sizeReadyCallback.a(d, c2);
                return;
            }
            if (!this.d.contains(sizeReadyCallback)) {
                this.d.add(sizeReadyCallback);
            }
            if (this.e == null) {
                ViewTreeObserver viewTreeObserver = this.f7456c.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.e = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f7456c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.e);
            }
            this.e = null;
            this.d.clear();
        }

        void b(SizeReadyCallback sizeReadyCallback) {
            this.d.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(T t) {
        this.f7452a = (T) Preconditions.a(t);
        this.f7453c = new SizeDeterminer(t);
    }

    private void a(Object obj) {
        this.f7452a.setTag(b, obj);
    }

    private Object c() {
        return this.f7452a.getTag(b);
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener == null || this.f) {
            return;
        }
        this.f7452a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f = true;
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener == null || !this.f) {
            return;
        }
        this.f7452a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f = false;
    }

    final void a() {
        Request request = getRequest();
        if (request == null || !request.f()) {
            return;
        }
        request.a();
    }

    protected abstract void a(Drawable drawable);

    final void b() {
        Request request = getRequest();
        if (request != null) {
            this.e = true;
            request.b();
            this.e = false;
        }
    }

    protected void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        Object c2 = c();
        if (c2 != null) {
            if (c2 instanceof Request) {
                return (Request) c2;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        this.f7453c.a(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
        this.f7453c.b();
        a(drawable);
        if (this.e) {
            return;
        }
        e();
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable drawable) {
        d();
        b(drawable);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.f7453c.b(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request) {
        a(request);
    }

    public String toString() {
        return "Target for: " + this.f7452a;
    }
}
