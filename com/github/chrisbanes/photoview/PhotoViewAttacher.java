package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/PhotoViewAttacher.class */
public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private static float f22045a = 3.0f;
    private static float b = 1.75f;

    /* renamed from: c  reason: collision with root package name */
    private static float f22046c = 1.0f;
    private static int d = 200;
    private static int e = 1;
    private OnScaleChangedListener A;
    private OnSingleFlingListener B;
    private OnViewDragListener C;
    private FlingRunnable D;
    private float G;
    private ImageView m;
    private GestureDetector n;
    private CustomGestureDetector o;
    private OnMatrixChangedListener u;
    private OnPhotoTapListener v;
    private OnOutsidePhotoTapListener w;
    private OnViewTapListener x;
    private View.OnClickListener y;
    private View.OnLongClickListener z;
    private Interpolator f = new AccelerateDecelerateInterpolator();
    private int g = d;
    private float h = f22046c;
    private float i = b;
    private float j = f22045a;
    private boolean k = true;
    private boolean l = false;
    private final Matrix p = new Matrix();
    private final Matrix q = new Matrix();
    private final Matrix r = new Matrix();
    private final RectF s = new RectF();
    private final float[] t = new float[9];
    private int E = 2;
    private int F = 2;
    private boolean H = true;
    private ImageView.ScaleType I = ImageView.ScaleType.FIT_CENTER;
    private OnGestureListener J = new OnGestureListener() { // from class: com.github.chrisbanes.photoview.PhotoViewAttacher.1
        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void a(float f, float f2) {
            if (PhotoViewAttacher.this.o.a()) {
                return;
            }
            if (PhotoViewAttacher.this.C != null) {
                PhotoViewAttacher.this.C.a(f, f2);
            }
            PhotoViewAttacher.this.r.postTranslate(f, f2);
            PhotoViewAttacher.this.l();
            ViewParent parent = PhotoViewAttacher.this.m.getParent();
            if (!PhotoViewAttacher.this.k || PhotoViewAttacher.this.o.a() || PhotoViewAttacher.this.l) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((PhotoViewAttacher.this.E == 2 || ((PhotoViewAttacher.this.E == 0 && f >= 1.0f) || ((PhotoViewAttacher.this.E == 1 && f <= -1.0f) || ((PhotoViewAttacher.this.F == 0 && f2 >= 1.0f) || (PhotoViewAttacher.this.F == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void a(float f, float f2, float f3) {
            if (PhotoViewAttacher.this.e() < PhotoViewAttacher.this.j || f < 1.0f) {
                if (PhotoViewAttacher.this.A != null) {
                    PhotoViewAttacher.this.A.a(f, f2, f3);
                }
                PhotoViewAttacher.this.r.postScale(f, f, f2, f3);
                PhotoViewAttacher.this.l();
            }
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void a(float f, float f2, float f3, float f4) {
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.D = new FlingRunnable(photoViewAttacher.m.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.D;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int a2 = photoViewAttacher2.a(photoViewAttacher2.m);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.a(a2, photoViewAttacher3.b(photoViewAttacher3.m), (int) f3, (int) f4);
            PhotoViewAttacher.this.m.post(PhotoViewAttacher.this.D);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$4  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/PhotoViewAttacher$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22050a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f22050a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22050a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22050a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22050a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/PhotoViewAttacher$AnimatedZoomRunnable.class */
    public class AnimatedZoomRunnable implements Runnable {
        private final float b;

        /* renamed from: c  reason: collision with root package name */
        private final float f22052c;
        private final long d = System.currentTimeMillis();
        private final float e;
        private final float f;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.b = f3;
            this.f22052c = f4;
            this.e = f;
            this.f = f2;
        }

        private float a() {
            return PhotoViewAttacher.this.f.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / PhotoViewAttacher.this.g));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a2 = a();
            float f = this.e;
            PhotoViewAttacher.this.J.a((f + ((this.f - f) * a2)) / PhotoViewAttacher.this.e(), this.b, this.f22052c);
            if (a2 < 1.0f) {
                Compat.a(PhotoViewAttacher.this.m, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/PhotoViewAttacher$FlingRunnable.class */
    public class FlingRunnable implements Runnable {
        private final OverScroller b;

        /* renamed from: c  reason: collision with root package name */
        private int f22054c;
        private int d;

        public FlingRunnable(Context context) {
            this.b = new OverScroller(context);
        }

        public void a() {
            this.b.forceFinished(true);
        }

        public void a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF a2 = PhotoViewAttacher.this.a();
            if (a2 == null) {
                return;
            }
            int round = Math.round(-a2.left);
            float f = i;
            if (f < a2.width()) {
                i5 = Math.round(a2.width() - f);
                i6 = 0;
            } else {
                i5 = round;
                i6 = round;
            }
            int round2 = Math.round(-a2.top);
            float f2 = i2;
            if (f2 < a2.height()) {
                i8 = Math.round(a2.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.f22054c = round;
            this.d = round2;
            if (round == i5 && round2 == i8) {
                return;
            }
            this.b.fling(round, round2, i3, i4, i6, i5, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.isFinished() && this.b.computeScrollOffset()) {
                int currX = this.b.getCurrX();
                int currY = this.b.getCurrY();
                PhotoViewAttacher.this.r.postTranslate(this.f22054c - currX, this.d - currY);
                PhotoViewAttacher.this.l();
                this.f22054c = currX;
                this.d = currY;
                Compat.a(PhotoViewAttacher.this.m, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.m = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.G = 0.0f;
        this.o = new CustomGestureDetector(imageView.getContext(), this.J);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.github.chrisbanes.photoview.PhotoViewAttacher.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (PhotoViewAttacher.this.B == null || PhotoViewAttacher.this.e() > PhotoViewAttacher.f22046c || motionEvent.getPointerCount() > PhotoViewAttacher.e || motionEvent2.getPointerCount() > PhotoViewAttacher.e) {
                    return false;
                }
                return PhotoViewAttacher.this.B.a(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.z != null) {
                    PhotoViewAttacher.this.z.onLongClick(PhotoViewAttacher.this.m);
                }
            }
        });
        this.n = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.github.chrisbanes.photoview.PhotoViewAttacher.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                try {
                    float e2 = PhotoViewAttacher.this.e();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (e2 < PhotoViewAttacher.this.c()) {
                        PhotoViewAttacher.this.a(PhotoViewAttacher.this.c(), x, y, true);
                        return true;
                    } else if (e2 < PhotoViewAttacher.this.c() || e2 >= PhotoViewAttacher.this.d()) {
                        PhotoViewAttacher.this.a(PhotoViewAttacher.this.b(), x, y, true);
                        return true;
                    } else {
                        PhotoViewAttacher.this.a(PhotoViewAttacher.this.d(), x, y, true);
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e3) {
                    return true;
                }
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.y != null) {
                    PhotoViewAttacher.this.y.onClick(PhotoViewAttacher.this.m);
                }
                RectF a2 = PhotoViewAttacher.this.a();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (PhotoViewAttacher.this.x != null) {
                    PhotoViewAttacher.this.x.a(PhotoViewAttacher.this.m, x, y);
                }
                if (a2 != null) {
                    if (!a2.contains(x, y)) {
                        if (PhotoViewAttacher.this.w != null) {
                            PhotoViewAttacher.this.w.a(PhotoViewAttacher.this.m);
                            return false;
                        }
                        return false;
                    }
                    float width = (x - a2.left) / a2.width();
                    float height = (y - a2.top) / a2.height();
                    if (PhotoViewAttacher.this.v != null) {
                        PhotoViewAttacher.this.v.a(PhotoViewAttacher.this.m, width, height);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.t);
        return this.t[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private void a(Matrix matrix) {
        RectF b2;
        this.m.setImageMatrix(matrix);
        if (this.u == null || (b2 = b(matrix)) == null) {
            return;
        }
        this.u.a(b2);
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float a2 = a(this.m);
        float b2 = b(this.m);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.p.reset();
        float f = intrinsicWidth;
        float f2 = a2 / f;
        float f3 = intrinsicHeight;
        float f4 = b2 / f3;
        if (this.I == ImageView.ScaleType.CENTER) {
            this.p.postTranslate((a2 - f) / 2.0f, (b2 - f3) / 2.0f);
        } else if (this.I == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            this.p.postScale(max, max);
            this.p.postTranslate((a2 - (f * max)) / 2.0f, (b2 - (f3 * max)) / 2.0f);
        } else if (this.I == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            this.p.postScale(min, min);
            this.p.postTranslate((a2 - (f * min)) / 2.0f, (b2 - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, a2, b2);
            if (((int) this.G) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f3, f);
            }
            int i = AnonymousClass4.f22050a[this.I.ordinal()];
            if (i == 1) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private RectF b(Matrix matrix) {
        Drawable drawable = this.m.getDrawable();
        if (drawable != null) {
            this.s.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.s);
            return this.s;
        }
        return null;
    }

    private Matrix j() {
        this.q.set(this.p);
        this.q.postConcat(this.r);
        return this.q;
    }

    private void k() {
        this.r.reset();
        b(this.G);
        a(j());
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (m()) {
            a(j());
        }
    }

    private boolean m() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF b2 = b(j());
        if (b2 == null) {
            return false;
        }
        float height = b2.height();
        float width = b2.width();
        float b3 = b(this.m);
        if (height <= b3) {
            int i = AnonymousClass4.f22050a[this.I.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (b3 - height) / 2.0f;
                    f6 = b2.top;
                } else {
                    f5 = b3 - height;
                    f6 = b2.top;
                }
                f = f5 - f6;
            } else {
                f = -b2.top;
            }
            this.F = 2;
        } else if (b2.top > 0.0f) {
            this.F = 0;
            f = -b2.top;
        } else if (b2.bottom < b3) {
            this.F = 1;
            f = b3 - b2.bottom;
        } else {
            this.F = -1;
            f = 0.0f;
        }
        float a2 = a(this.m);
        if (width <= a2) {
            int i2 = AnonymousClass4.f22050a[this.I.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (a2 - width) / 2.0f;
                    f4 = b2.left;
                } else {
                    f3 = a2 - width;
                    f4 = b2.left;
                }
                f2 = f3 - f4;
            } else {
                f2 = -b2.left;
            }
            this.E = 2;
        } else if (b2.left > 0.0f) {
            this.E = 0;
            f2 = -b2.left;
        } else if (b2.right < a2) {
            f2 = a2 - b2.right;
            this.E = 1;
        } else {
            this.E = -1;
            f2 = 0.0f;
        }
        this.r.postTranslate(f2, f);
        return true;
    }

    private void n() {
        FlingRunnable flingRunnable = this.D;
        if (flingRunnable != null) {
            flingRunnable.a();
            this.D = null;
        }
    }

    public RectF a() {
        m();
        return b(j());
    }

    public void a(float f) {
        this.r.setRotate(f % 360.0f);
        l();
    }

    public void a(float f, float f2, float f3, boolean z) {
        if (f < this.h || f > this.j) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.m.post(new AnimatedZoomRunnable(e(), f, f2, f3));
            return;
        }
        this.r.setScale(f, f, f2, f3);
        l();
    }

    public void a(float f, boolean z) {
        a(f, this.m.getRight() / 2, this.m.getBottom() / 2, z);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.n.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void a(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.z = onLongClickListener;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!Util.a(scaleType) || scaleType == this.I) {
            return;
        }
        this.I = scaleType;
        update();
    }

    public void a(OnMatrixChangedListener onMatrixChangedListener) {
        this.u = onMatrixChangedListener;
    }

    public void a(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.w = onOutsidePhotoTapListener;
    }

    public void a(OnPhotoTapListener onPhotoTapListener) {
        this.v = onPhotoTapListener;
    }

    public void a(OnScaleChangedListener onScaleChangedListener) {
        this.A = onScaleChangedListener;
    }

    public void a(OnSingleFlingListener onSingleFlingListener) {
        this.B = onSingleFlingListener;
    }

    public void a(OnViewDragListener onViewDragListener) {
        this.C = onViewDragListener;
    }

    public void a(OnViewTapListener onViewTapListener) {
        this.x = onViewTapListener;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public float b() {
        return this.h;
    }

    public void b(float f) {
        this.r.postRotate(f % 360.0f);
        l();
    }

    public void b(boolean z) {
        this.H = z;
        update();
    }

    public float c() {
        return this.i;
    }

    public void c(float f) {
        Util.a(f, this.i, this.j);
        this.h = f;
    }

    public float d() {
        return this.j;
    }

    public void d(float f) {
        Util.a(this.h, f, this.j);
        this.i = f;
    }

    public float e() {
        return (float) Math.sqrt(((float) Math.pow(a(this.r, 0), 2.0d)) + ((float) Math.pow(a(this.r, 3), 2.0d)));
    }

    public void e(float f) {
        Util.a(this.h, this.i, f);
        this.j = f;
    }

    public ImageView.ScaleType f() {
        return this.I;
    }

    public void f(float f) {
        a(f, false);
    }

    public Matrix g() {
        return this.q;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        a(this.m.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0147  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void update() {
        if (this.H) {
            a(this.m.getDrawable());
        } else {
            k();
        }
    }
}
