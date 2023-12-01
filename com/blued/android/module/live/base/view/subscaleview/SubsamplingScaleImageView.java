package com.blued.android.module.live.base.view.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.view.subscaleview.decoder.CompatDecoderFactory;
import com.blued.android.module.live.base.view.subscaleview.decoder.DecoderFactory;
import com.blued.android.module.live.base.view.subscaleview.decoder.ImageDecoder;
import com.blued.android.module.live.base.view.subscaleview.decoder.ImageRegionDecoder;
import com.blued.android.module.live.base.view.subscaleview.decoder.SkiaImageDecoder;
import com.blued.android.module.live.base.view.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView.class */
public class SubsamplingScaleImageView extends View {
    private static Bitmap.Config aC;
    private float A;
    private int B;
    private int C;
    private float D;
    private float E;
    private PointF F;
    private PointF G;
    private PointF H;
    private Float I;
    private PointF J;
    private PointF K;
    private int L;
    private int M;
    private int N;
    private Rect O;
    private Rect P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private GestureDetector U;
    private GestureDetector V;
    private ImageRegionDecoder W;
    private final float[] aA;
    private final float aB;
    private final ReadWriteLock aa;
    private DecoderFactory<? extends ImageDecoder> ab;
    private DecoderFactory<? extends ImageRegionDecoder> ac;
    private PointF ad;
    private float ae;
    private final float af;
    private float ag;
    private boolean ah;
    private PointF ai;
    private PointF aj;
    private PointF ak;
    private Anim al;
    private boolean am;
    private boolean an;
    private OnImageEventListener ao;
    private OnStateChangedListener ap;
    private View.OnLongClickListener aq;

    /* renamed from: ar  reason: collision with root package name */
    private final Handler f11556ar;
    private Paint as;
    private Paint at;
    private Paint au;
    private Paint av;
    private ScaleAndTranslate aw;
    private Matrix ax;
    private RectF ay;
    private final float[] az;
    private Bitmap g;
    private boolean h;
    private boolean i;
    private Uri j;
    private int k;
    private Map<Integer, List<Tile>> l;
    private boolean m;
    private int n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private Executor v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: a  reason: collision with root package name */
    private static final String f11554a = SubsamplingScaleImageView.class.getSimpleName();
    private static final List<Integer> b = Arrays.asList(0, 90, 180, 270, -1);

    /* renamed from: c  reason: collision with root package name */
    private static final List<Integer> f11555c = Arrays.asList(1, 2, 3);
    private static final List<Integer> d = Arrays.asList(2, 1);
    private static final List<Integer> e = Arrays.asList(1, 2, 3);
    private static final List<Integer> f = Arrays.asList(2, 1, 3, 4);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$Anim.class */
    public static class Anim {

        /* renamed from: a  reason: collision with root package name */
        private float f11560a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private PointF f11561c;
        private PointF d;
        private PointF e;
        private PointF f;
        private PointF g;
        private long h;
        private boolean i;
        private int j;
        private int k;
        private long l;
        private OnAnimationEventListener m;

        private Anim() {
            this.h = 500L;
            this.i = true;
            this.j = 2;
            this.k = 1;
            this.l = System.currentTimeMillis();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$AnimationBuilder.class */
    public final class AnimationBuilder {
        private final float b;

        /* renamed from: c  reason: collision with root package name */
        private final PointF f11563c;
        private final PointF d;
        private long e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private OnAnimationEventListener j;

        private AnimationBuilder(float f, PointF pointF) {
            this.e = 500L;
            this.f = 2;
            this.g = 1;
            this.h = true;
            this.i = true;
            this.b = f;
            this.f11563c = pointF;
            this.d = null;
        }

        private AnimationBuilder(float f, PointF pointF, PointF pointF2) {
            this.e = 500L;
            this.f = 2;
            this.g = 1;
            this.h = true;
            this.i = true;
            this.b = f;
            this.f11563c = pointF;
            this.d = pointF2;
        }

        private AnimationBuilder(PointF pointF) {
            this.e = 500L;
            this.f = 2;
            this.g = 1;
            this.h = true;
            this.i = true;
            this.b = SubsamplingScaleImageView.this.D;
            this.f11563c = pointF;
            this.d = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder b(int i) {
            this.g = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationBuilder b(boolean z) {
            this.i = z;
            return this;
        }

        public AnimationBuilder a(int i) {
            if (SubsamplingScaleImageView.d.contains(Integer.valueOf(i))) {
                this.f = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder a(long j) {
            this.e = j;
            return this;
        }

        public AnimationBuilder a(boolean z) {
            this.h = z;
            return this;
        }

        public void a() {
            if (SubsamplingScaleImageView.this.al != null && SubsamplingScaleImageView.this.al.m != null) {
                try {
                    SubsamplingScaleImageView.this.al.m.c();
                } catch (Exception e) {
                    Log.w(SubsamplingScaleImageView.f11554a, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft();
            int width = ((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop();
            int height = ((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
            float f = SubsamplingScaleImageView.this.f(this.b);
            PointF a2 = this.i ? SubsamplingScaleImageView.this.a(this.f11563c.x, this.f11563c.y, f, new PointF()) : this.f11563c;
            SubsamplingScaleImageView.this.al = new Anim();
            SubsamplingScaleImageView.this.al.f11560a = SubsamplingScaleImageView.this.D;
            SubsamplingScaleImageView.this.al.b = f;
            SubsamplingScaleImageView.this.al.l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.al.e = a2;
            SubsamplingScaleImageView.this.al.f11561c = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.al.d = a2;
            SubsamplingScaleImageView.this.al.f = SubsamplingScaleImageView.this.b(a2);
            SubsamplingScaleImageView.this.al.g = new PointF(paddingLeft + width, paddingTop + height);
            SubsamplingScaleImageView.this.al.h = this.e;
            SubsamplingScaleImageView.this.al.i = this.h;
            SubsamplingScaleImageView.this.al.j = this.f;
            SubsamplingScaleImageView.this.al.k = this.g;
            SubsamplingScaleImageView.this.al.l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.al.m = this.j;
            PointF pointF = this.d;
            if (pointF != null) {
                float f2 = pointF.x - (SubsamplingScaleImageView.this.al.f11561c.x * f);
                float f3 = this.d.y - (SubsamplingScaleImageView.this.al.f11561c.y * f);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(f, new PointF(f2, f3));
                SubsamplingScaleImageView.this.a(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.al.g = new PointF(this.d.x + (scaleAndTranslate.b.x - f2), this.d.y + (scaleAndTranslate.b.y - f3));
            }
            SubsamplingScaleImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$BitmapLoadTask.class */
    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f11564a;
        private final WeakReference<Context> b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> f11565c;
        private final Uri d;
        private final boolean e;
        private Bitmap f;
        private Exception g;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.f11564a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.f11565c = new WeakReference<>(decoderFactory);
            this.d = uri;
            this.e = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.d.toString();
                Context context = this.b.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.f11565c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f11564a.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.a("BitmapLoadTask.doInBackground", new Object[0]);
                this.f = decoderFactory.a().a(context, this.d);
                return Integer.valueOf(subsamplingScaleImageView.a(context, uri));
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.f11554a, "Failed to load bitmap", e);
                this.g = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.f11554a, "Failed to load bitmap - OutOfMemoryError", e2);
                this.g = new RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f11564a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f;
                if (bitmap != null && num != null) {
                    if (this.e) {
                        subsamplingScaleImageView.a(bitmap);
                    } else {
                        subsamplingScaleImageView.a(bitmap, num.intValue(), false);
                    }
                } else if (this.g == null || subsamplingScaleImageView.ao == null) {
                } else {
                    if (this.e) {
                        subsamplingScaleImageView.ao.a(this.g);
                    } else {
                        subsamplingScaleImageView.ao.b(this.g);
                    }
                }
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$DefaultOnAnimationEventListener.class */
    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void a() {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void b() {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void c() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$DefaultOnImageEventListener.class */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void a() {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void a(Exception exc) {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void b() {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void b(Exception exc) {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void c() {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void c(Exception exc) {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$DefaultOnStateChangedListener.class */
    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void a(float f, int i) {
        }

        @Override // com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void a(PointF pointF, int i) {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$OnAnimationEventListener.class */
    public interface OnAnimationEventListener {
        void a();

        void b();

        void c();
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$OnImageEventListener.class */
    public interface OnImageEventListener {
        void a();

        void a(Exception exc);

        void b();

        void b(Exception exc);

        void c();

        void c(Exception exc);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$OnStateChangedListener.class */
    public interface OnStateChangedListener {
        void a(float f, int i);

        void a(PointF pointF, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$ScaleAndTranslate.class */
    public static class ScaleAndTranslate {

        /* renamed from: a  reason: collision with root package name */
        private float f11566a;
        private final PointF b;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.f11566a = f;
            this.b = pointF;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$Tile.class */
    public static class Tile {

        /* renamed from: a  reason: collision with root package name */
        private Rect f11567a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f11568c;
        private boolean d;
        private boolean e;
        private Rect f;
        private Rect g;

        private Tile() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$TileLoadTask.class */
    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f11569a;
        private final WeakReference<ImageRegionDecoder> b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<Tile> f11570c;
        private Exception d;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.f11569a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(imageRegionDecoder);
            this.f11570c = new WeakReference<>(tile);
            tile.d = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.f11569a.get();
                ImageRegionDecoder imageRegionDecoder = this.b.get();
                Tile tile = this.f11570c.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.a() || !tile.e) {
                    if (tile != null) {
                        tile.d = false;
                        return null;
                    }
                    return null;
                }
                subsamplingScaleImageView.a("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.f11567a, Integer.valueOf(tile.b));
                subsamplingScaleImageView.aa.readLock().lock();
                if (!imageRegionDecoder.a()) {
                    tile.d = false;
                    subsamplingScaleImageView.aa.readLock().unlock();
                    return null;
                }
                subsamplingScaleImageView.a(tile.f11567a, tile.g);
                if (subsamplingScaleImageView.O != null) {
                    tile.g.offset(subsamplingScaleImageView.O.left, subsamplingScaleImageView.O.top);
                }
                Bitmap a2 = imageRegionDecoder.a(tile.g, tile.b);
                subsamplingScaleImageView.aa.readLock().unlock();
                return a2;
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.f11554a, "Failed to decode tile", e);
                this.d = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.f11554a, "Failed to decode tile - OutOfMemoryError", e2);
                this.d = new RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f11569a.get();
            Tile tile = this.f11570c.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.f11568c = bitmap;
                tile.d = false;
                subsamplingScaleImageView.k();
            } else if (this.d == null || subsamplingScaleImageView.ao == null) {
            } else {
                subsamplingScaleImageView.ao.c(this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/SubsamplingScaleImageView$TilesInitTask.class */
    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<SubsamplingScaleImageView> f11571a;
        private final WeakReference<Context> b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> f11572c;
        private final Uri d;
        private ImageRegionDecoder e;
        private Exception f;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.f11571a = new WeakReference<>(subsamplingScaleImageView);
            this.b = new WeakReference<>(context);
            this.f11572c = new WeakReference<>(decoderFactory);
            this.d = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.f11571a.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.e;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.a(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.f == null || subsamplingScaleImageView.ao == null) {
                } else {
                    subsamplingScaleImageView.ao.b(this.f);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.d.toString();
                Context context = this.b.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.f11572c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.f11571a.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.a("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder a2 = decoderFactory.a();
                this.e = a2;
                Point a3 = a2.a(context, this.d);
                int i = a3.x;
                int i2 = a3.y;
                int a4 = subsamplingScaleImageView.a(context, uri);
                int i3 = i2;
                int i4 = i;
                if (subsamplingScaleImageView.O != null) {
                    subsamplingScaleImageView.O.left = Math.max(0, subsamplingScaleImageView.O.left);
                    subsamplingScaleImageView.O.top = Math.max(0, subsamplingScaleImageView.O.top);
                    subsamplingScaleImageView.O.right = Math.min(i, subsamplingScaleImageView.O.right);
                    subsamplingScaleImageView.O.bottom = Math.min(i2, subsamplingScaleImageView.O.bottom);
                    i4 = subsamplingScaleImageView.O.width();
                    i3 = subsamplingScaleImageView.O.height();
                }
                return new int[]{i4, i3, a4};
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.f11554a, "Failed to initialise bitmap decoder", e);
                this.f = e;
                return null;
            }
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.n = 0;
        this.o = 2.0f;
        this.p = n();
        this.q = -1;
        this.r = 1;
        this.s = 1;
        this.t = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.v = AsyncTask.THREAD_POOL_EXECUTOR;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = 1.0f;
        this.B = 1;
        this.C = 500;
        this.aa = new ReentrantReadWriteLock(true);
        this.ab = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.ac = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.az = new float[8];
        this.aA = new float[8];
        this.aB = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.f11556ar = new Handler(new Handler.Callback() { // from class: com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 1 || SubsamplingScaleImageView.this.aq == null) {
                    return true;
                }
                SubsamplingScaleImageView.this.T = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.aq);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener(null);
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_assetName) && (string = obtainStyledAttributes.getString(R.styleable.SubsamplingScaleImageView_assetName)) != null && string.length() > 0) {
                setImage(ImageSource.a(string).a());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_subSrc) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SubsamplingScaleImageView_subSrc, 0)) > 0) {
                setImage(ImageSource.a(resourceId).a());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.af = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    private float a(int i, long j, float f2, float f3, long j2) {
        if (i != 1) {
            if (i == 2) {
                return b(j, f2, f3, j2);
            }
            throw new IllegalStateException("Unexpected easing type: " + i);
        }
        return a(j, f2, f3, j2);
    }

    private float a(long j, float f2, float f3, long j2) {
        float f4 = ((float) j) / ((float) j2);
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    private int a(float f2) {
        int round;
        float f3 = f2;
        if (this.q > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f3 = f2 * (this.q / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f));
        }
        int l = (int) (l() * f3);
        int m = (int) (m() * f3);
        if (l == 0 || m == 0) {
            return 32;
        }
        int i = 1;
        if (m() > m || l() > l) {
            round = Math.round(m() / m);
            int round2 = Math.round(l() / l);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i2 = i * 2;
            if (i2 >= round) {
                return i;
            }
            i = i2;
        }
    }

    private int a(int i) {
        return (int) (this.aB * i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
        if (r8 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(android.content.Context r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.a(android.content.Context, java.lang.String):int");
    }

    private Point a(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.t), Math.min(canvas.getMaximumBitmapHeight(), this.u));
    }

    private PointF a(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft();
        int width = ((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2;
        int paddingTop = getPaddingTop();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        if (this.aw == null) {
            this.aw = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.aw.f11566a = f4;
        this.aw.b.set((paddingLeft + width) - (f2 * f4), (paddingTop + height) - (f3 * f4));
        a(true, this.aw);
        return this.aw.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF a(float f2, float f3, float f4, PointF pointF) {
        PointF a2 = a(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - a2.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - a2.y) / f4);
        return pointF;
    }

    private void a(float f2, PointF pointF, int i) {
        OnStateChangedListener onStateChangedListener = this.ap;
        if (onStateChangedListener != null) {
            float f3 = this.D;
            if (f3 != f2) {
                onStateChangedListener.a(f3, i);
            }
        }
        if (this.ap == null || this.F.equals(pointF)) {
            return;
        }
        this.ap.a(getCenter(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        synchronized (this) {
            a("onPreviewLoaded", new Object[0]);
            if (this.g == null && !this.an) {
                if (this.P != null) {
                    this.g = Bitmap.createBitmap(bitmap, this.P.left, this.P.top, this.P.width(), this.P.height());
                } else {
                    this.g = bitmap;
                }
                this.h = true;
                if (g()) {
                    invalidate();
                    requestLayout();
                }
                return;
            }
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, int i, boolean z) {
        synchronized (this) {
            a("onImageLoaded", new Object[0]);
            if (this.L > 0 && this.M > 0 && (this.L != bitmap.getWidth() || this.M != bitmap.getHeight())) {
                a(false);
            }
            if (this.g != null && !this.i) {
                this.g.recycle();
            }
            if (this.g != null && this.i && this.ao != null) {
                this.ao.c();
            }
            this.h = false;
            this.i = z;
            this.g = bitmap;
            this.L = bitmap.getWidth();
            this.M = bitmap.getHeight();
            this.N = i;
            boolean g = g();
            boolean h = h();
            if (g || h) {
                invalidate();
                requestLayout();
            }
        }
    }

    private void a(Point point) {
        synchronized (this) {
            a("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
            ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
            this.aw = scaleAndTranslate;
            a(true, scaleAndTranslate);
            int a2 = a(this.aw.f11566a);
            this.k = a2;
            if (a2 > 1) {
                this.k = a2 / 2;
            }
            if (this.k != 1 || this.O != null || l() >= point.x || m() >= point.y) {
                b(point);
                for (Tile tile : this.l.get(Integer.valueOf(this.k))) {
                    a(new TileLoadTask(this, this.W, tile));
                }
                c(true);
            } else {
                this.W.b();
                this.W = null;
                a(new BitmapLoadTask(this, getContext(), this.ab, this.j, false));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PointF pointF, PointF pointF2) {
        if (!this.x) {
            PointF pointF3 = this.K;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.K.y;
            } else {
                pointF.x = l() / 2;
                pointF.y = m() / 2;
            }
        }
        float min = Math.min(this.o, this.A);
        float f2 = this.D;
        boolean z = ((double) f2) <= ((double) min) * 0.9d || f2 == this.p;
        if (!z) {
            min = n();
        }
        int i = this.B;
        if (i == 3) {
            a(min, pointF);
        } else if (i == 2 || !z || !this.x) {
            new AnimationBuilder(min, pointF).a(false).a(this.C).b(4).a();
        } else if (i == 1) {
            new AnimationBuilder(min, pointF, pointF2).a(false).a(this.C).b(4).a();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.M - rect.right, rect.bottom, this.M - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.L - rect.right, this.M - rect.bottom, this.L - rect.left, this.M - rect.top);
        } else {
            rect2.set(this.L - rect.bottom, rect.left, this.L - rect.top, rect.right);
        }
    }

    private void a(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.v, new Void[0]);
    }

    private void a(ImageViewState imageViewState) {
        if (imageViewState == null || !b.contains(Integer.valueOf(imageViewState.c()))) {
            return;
        }
        this.n = imageViewState.c();
        this.I = Float.valueOf(imageViewState.a());
        this.J = imageViewState.b();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        synchronized (this) {
            a("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.n));
            if (this.L > 0 && this.M > 0 && (this.L != i || this.M != i2)) {
                a(false);
                if (this.g != null) {
                    if (!this.i) {
                        this.g.recycle();
                    }
                    this.g = null;
                    if (this.ao != null && this.i) {
                        this.ao.c();
                    }
                    this.h = false;
                    this.i = false;
                }
            }
            this.W = imageRegionDecoder;
            this.L = i;
            this.M = i2;
            this.N = i3;
            g();
            if (!h() && this.t > 0 && this.t != Integer.MAX_VALUE && this.u > 0 && this.u != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                a(new Point(this.t, this.u));
            }
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object... objArr) {
        if (this.m) {
            Log.d(f11554a, String.format(str, objArr));
        }
    }

    private void a(boolean z) {
        OnImageEventListener onImageEventListener;
        a("reset newImage=" + z, new Object[0]);
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = Float.valueOf(0.0f);
        this.J = null;
        this.K = null;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.k = 0;
        this.ad = null;
        this.ae = 0.0f;
        this.ag = 0.0f;
        this.ah = false;
        this.aj = null;
        this.ai = null;
        this.ak = null;
        this.al = null;
        this.aw = null;
        this.ax = null;
        this.ay = null;
        if (z) {
            this.j = null;
            this.aa.writeLock().lock();
            try {
                if (this.W != null) {
                    this.W.b();
                    this.W = null;
                }
                this.aa.writeLock().unlock();
                Bitmap bitmap = this.g;
                if (bitmap != null && !this.i) {
                    bitmap.recycle();
                }
                if (this.g != null && this.i && (onImageEventListener = this.ao) != null) {
                    onImageEventListener.c();
                }
                this.L = 0;
                this.M = 0;
                this.N = 0;
                this.O = null;
                this.P = null;
                this.am = false;
                this.an = false;
                this.g = null;
                this.h = false;
                this.i = false;
            } catch (Throwable th) {
                this.aa.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.l;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                for (Tile tile : entry.getValue()) {
                    tile.e = false;
                    if (tile.f11568c != null) {
                        tile.f11568c.recycle();
                        tile.f11568c = null;
                    }
                }
            }
            this.l = null;
        }
        setGestureDetector(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float max;
        int max2;
        float max3;
        float f2;
        boolean z2 = z;
        if (this.r == 2) {
            z2 = z;
            if (a()) {
                z2 = false;
            }
        }
        PointF pointF = scaleAndTranslate.b;
        float f3 = f(scaleAndTranslate.f11566a);
        float l = l() * f3;
        float m = m() * f3;
        if (this.r == 3 && a()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - l);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - m);
        } else if (z2) {
            pointF.x = Math.max(pointF.x, getWidth() - l);
            pointF.y = Math.max(pointF.y, getHeight() - m);
        } else {
            pointF.x = Math.max(pointF.x, -l);
            pointF.y = Math.max(pointF.y, -m);
        }
        float f4 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f4 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.r == 3 && a()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z2) {
            float max4 = Math.max(0.0f, (getWidth() - l) * paddingLeft);
            max3 = Math.max(0.0f, (getHeight() - m) * f4);
            f2 = max4;
            pointF.x = Math.min(pointF.x, f2);
            pointF.y = Math.min(pointF.y, max3);
            scaleAndTranslate.f11566a = f3;
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        f2 = max;
        max3 = max2;
        pointF.x = Math.min(pointF.x, f2);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.f11566a = f3;
    }

    private void a(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x02f8, code lost:
        if (r7.ah != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x03fe, code lost:
        if ((r7.D * l()) >= getWidth()) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0678 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 2064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.a(android.view.MotionEvent):boolean");
    }

    private boolean a(Tile tile) {
        return b(0.0f) <= ((float) tile.f11567a.right) && ((float) tile.f11567a.left) <= b((float) getWidth()) && c(0.0f) <= ((float) tile.f11567a.bottom) && ((float) tile.f11567a.top) <= c((float) getHeight());
    }

    private float b(float f2) {
        PointF pointF = this.F;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.D;
    }

    private float b(long j, float f2, float f3, long j2) {
        float f4;
        float f5;
        float f6 = ((float) j) / (((float) j2) / 2.0f);
        if (f6 < 1.0f) {
            f4 = (f3 / 2.0f) * f6;
            f5 = f6;
        } else {
            float f7 = f6 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f7 * (f7 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private void b(Point point) {
        int i;
        int i2;
        int i3;
        a("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.l = new LinkedHashMap();
        int i4 = this.k;
        int i5 = 1;
        int i6 = 1;
        while (true) {
            int i7 = i6;
            int l = l() / i5;
            int m = m() / i7;
            int i8 = l / i4;
            int i9 = m / i4;
            while (true) {
                if (i8 + i5 + 1 <= point.x) {
                    i = i7;
                    i2 = m;
                    i3 = i9;
                    if (i8 <= getWidth() * 1.25d) {
                        break;
                    }
                    i = i7;
                    i2 = m;
                    i3 = i9;
                    if (i4 >= this.k) {
                        break;
                    }
                }
                i5++;
                l = l() / i5;
                i8 = l / i4;
            }
            while (true) {
                if (i3 + i + 1 > point.y || (i3 > getHeight() * 1.25d && i4 < this.k)) {
                    i++;
                    i2 = m() / i;
                    i3 = i2 / i4;
                }
            }
            ArrayList arrayList = new ArrayList(i5 * i);
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= i5) {
                    break;
                }
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < i) {
                        Tile tile = new Tile();
                        tile.b = i4;
                        tile.e = i4 == this.k;
                        tile.f11567a = new Rect(i11 * l, i13 * i2, i11 == i5 - 1 ? l() : (i11 + 1) * l, i13 == i - 1 ? m() : (i13 + 1) * i2);
                        tile.f = new Rect(0, 0, 0, 0);
                        tile.g = new Rect(tile.f11567a);
                        arrayList.add(tile);
                        i12 = i13 + 1;
                    }
                }
                i10 = i11 + 1;
            }
            this.l.put(Integer.valueOf(i4), arrayList);
            if (i4 == 1) {
                return;
            }
            i4 /= 2;
            i6 = i;
        }
    }

    private void b(Rect rect, Rect rect2) {
        rect2.set((int) d(rect.left), (int) e(rect.top), (int) d(rect.right), (int) e(rect.bottom));
    }

    private void b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private float c(float f2) {
        PointF pointF = this.F;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.D;
    }

    private void c(boolean z) {
        if (this.W == null || this.l == null) {
            return;
        }
        int min = Math.min(this.k, a(this.D));
        for (Map.Entry<Integer, List<Tile>> entry : this.l.entrySet()) {
            for (Tile tile : entry.getValue()) {
                if (tile.b < min || (tile.b > min && tile.b != this.k)) {
                    tile.e = false;
                    if (tile.f11568c != null) {
                        tile.f11568c.recycle();
                        tile.f11568c = null;
                    }
                }
                if (tile.b == min) {
                    if (a(tile)) {
                        tile.e = true;
                        if (!tile.d && tile.f11568c == null && z) {
                            a(new TileLoadTask(this, this.W, tile));
                        }
                    } else if (tile.b != this.k) {
                        tile.e = false;
                        if (tile.f11568c != null) {
                            tile.f11568c.recycle();
                            tile.f11568c = null;
                        }
                    }
                } else if (tile.b == this.k) {
                    tile.e = true;
                }
            }
        }
    }

    private float d(float f2) {
        PointF pointF = this.F;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.D) + pointF.x;
    }

    private void d(boolean z) {
        boolean z2;
        if (this.F == null) {
            z2 = true;
            this.F = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.aw == null) {
            this.aw = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.aw.f11566a = this.D;
        this.aw.b.set(this.F);
        a(z, this.aw);
        this.D = this.aw.f11566a;
        this.F.set(this.aw.b);
        if (!z2 || this.s == 4) {
            return;
        }
        this.F.set(a(l() / 2, m() / 2, this.D));
    }

    private float e(float f2) {
        PointF pointF = this.F;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.D) + pointF.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f(float f2) {
        return Math.min(this.o, Math.max(n(), f2));
    }

    private boolean f() {
        boolean z = true;
        if (this.g == null || this.h) {
            Map<Integer, List<Tile>> map = this.l;
            if (map != null) {
                for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
                    if (entry.getKey().intValue() == this.k) {
                        Iterator<Tile> it = entry.getValue().iterator();
                        boolean z2 = z;
                        while (true) {
                            z = z2;
                            if (it.hasNext()) {
                                Tile next = it.next();
                                if (next.d || next.f11568c == null) {
                                    z2 = false;
                                }
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }
        return true;
    }

    private boolean g() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.L > 0 && this.M > 0 && (this.g != null || f());
        if (!this.am && z) {
            j();
            this.am = true;
            b();
            OnImageEventListener onImageEventListener = this.ao;
            if (onImageEventListener != null) {
                onImageEventListener.a();
            }
        }
        return z;
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return aC;
    }

    private int getRequiredRotation() {
        int i = this.n;
        int i2 = i;
        if (i == -1) {
            i2 = this.N;
        }
        return i2;
    }

    private boolean h() {
        boolean f2 = f();
        if (!this.an && f2) {
            j();
            this.an = true;
            c();
            OnImageEventListener onImageEventListener = this.ao;
            if (onImageEventListener != null) {
                onImageEventListener.b();
            }
        }
        return f2;
    }

    private void i() {
        if (this.as == null) {
            Paint paint = new Paint();
            this.as = paint;
            paint.setAntiAlias(true);
            this.as.setFilterBitmap(true);
            this.as.setDither(true);
        }
        if ((this.at == null || this.au == null) && this.m) {
            Paint paint2 = new Paint();
            this.at = paint2;
            paint2.setTextSize(a(12));
            this.at.setColor(Color.MAGENTA);
            this.at.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.au = paint3;
            paint3.setColor(Color.MAGENTA);
            this.au.setStyle(Paint.Style.STROKE);
            this.au.setStrokeWidth(a(1));
        }
    }

    private void j() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.L <= 0 || this.M <= 0) {
            return;
        }
        if (this.J != null && (f2 = this.I) != null) {
            this.D = f2.floatValue();
            if (this.F == null) {
                this.F = new PointF();
            }
            this.F.x = (getWidth() / 2) - (this.D * this.J.x);
            this.F.y = (getHeight() / 2) - (this.D * this.J.y);
            this.J = null;
            this.I = null;
            d(true);
            c(true);
        }
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            a("onTileLoaded", new Object[0]);
            g();
            h();
            if (f() && this.g != null) {
                if (!this.i) {
                    this.g.recycle();
                }
                this.g = null;
                if (this.ao != null && this.i) {
                    this.ao.c();
                }
                this.h = false;
                this.i = false;
            }
            invalidate();
        }
    }

    private int l() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.M : this.L;
    }

    private int m() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.L : this.M;
    }

    private float n() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.s;
        if (i == 2 || i == 4) {
            return Math.max((getWidth() - paddingLeft) / l(), (getHeight() - paddingBottom) / m());
        }
        if (i == 3) {
            float f2 = this.p;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / l(), (getHeight() - paddingBottom) / m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.U = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (SubsamplingScaleImageView.this.y && SubsamplingScaleImageView.this.am && SubsamplingScaleImageView.this.F != null) {
                    SubsamplingScaleImageView.this.setGestureDetector(context);
                    if (!SubsamplingScaleImageView.this.z) {
                        SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView.a(subsamplingScaleImageView.a(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                        return true;
                    }
                    SubsamplingScaleImageView.this.ad = new PointF(motionEvent.getX(), motionEvent.getY());
                    SubsamplingScaleImageView.this.G = new PointF(SubsamplingScaleImageView.this.F.x, SubsamplingScaleImageView.this.F.y);
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView2.E = subsamplingScaleImageView2.D;
                    SubsamplingScaleImageView.this.S = true;
                    SubsamplingScaleImageView.this.Q = true;
                    SubsamplingScaleImageView.this.ag = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView3.aj = subsamplingScaleImageView3.a(subsamplingScaleImageView3.ad);
                    SubsamplingScaleImageView.this.ak = new PointF(motionEvent.getX(), motionEvent.getY());
                    SubsamplingScaleImageView.this.ai = new PointF(SubsamplingScaleImageView.this.aj.x, SubsamplingScaleImageView.this.aj.y);
                    SubsamplingScaleImageView.this.ah = false;
                    return false;
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (!SubsamplingScaleImageView.this.x || !SubsamplingScaleImageView.this.am || SubsamplingScaleImageView.this.F == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || SubsamplingScaleImageView.this.Q))) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.F.x + (f2 * 0.25f), SubsamplingScaleImageView.this.F.y + (f3 * 0.25f));
                new AnimationBuilder(new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.D, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.D)).a(1).b(false).b(3).a();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.V = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        aC = config;
    }

    public final PointF a(float f2, float f3) {
        return a(f2, f3, new PointF());
    }

    public final PointF a(float f2, float f3, PointF pointF) {
        if (this.F == null) {
            return null;
        }
        pointF.set(b(f2), c(f3));
        return pointF;
    }

    public final PointF a(PointF pointF) {
        return a(pointF.x, pointF.y, new PointF());
    }

    public final void a(float f2, PointF pointF) {
        this.al = null;
        this.I = Float.valueOf(f2);
        this.J = pointF;
        this.K = pointF;
        invalidate();
    }

    public final void a(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        a(true);
        if (imageViewState != null) {
            a(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.c() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (imageSource.f() <= 0 || imageSource.g() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
            this.L = imageSource.f();
            this.M = imageSource.g();
            this.P = imageSource2.h();
            if (imageSource2.c() != null) {
                this.i = imageSource2.i();
                a(imageSource2.c());
            } else {
                Uri b2 = imageSource2.b();
                Uri uri = b2;
                if (b2 == null) {
                    uri = b2;
                    if (imageSource2.d() != null) {
                        uri = Uri.parse("android.resource://" + getContext().getPackageName() + BridgeUtil.SPLIT_MARK + imageSource2.d());
                    }
                }
                a(new BitmapLoadTask(this, getContext(), this.ab, uri, true));
            }
        }
        if (imageSource.c() != null && imageSource.h() != null) {
            a(Bitmap.createBitmap(imageSource.c(), imageSource.h().left, imageSource.h().top, imageSource.h().width(), imageSource.h().height()), 0, false);
        } else if (imageSource.c() != null) {
            a(imageSource.c(), 0, imageSource.i());
        } else {
            this.O = imageSource.h();
            Uri b3 = imageSource.b();
            this.j = b3;
            if (b3 == null && imageSource.d() != null) {
                this.j = Uri.parse("android.resource://" + getContext().getPackageName() + BridgeUtil.SPLIT_MARK + imageSource.d());
            }
            if (imageSource.e() || this.O != null) {
                a(new TilesInitTask(this, getContext(), this.ac, this.j));
            } else {
                a(new BitmapLoadTask(this, getContext(), this.ab, this.j, false));
            }
        }
    }

    public final void a(ImageSource imageSource, ImageViewState imageViewState) {
        a(imageSource, (ImageSource) null, imageViewState);
    }

    public final boolean a() {
        return this.am;
    }

    public final PointF b(float f2, float f3, PointF pointF) {
        if (this.F == null) {
            return null;
        }
        pointF.set(d(f2), e(f3));
        return pointF;
    }

    public final PointF b(PointF pointF) {
        return b(pointF.x, pointF.y, new PointF());
    }

    protected void b() {
    }

    protected void c() {
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return a(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.o;
    }

    public final float getMinScale() {
        return n();
    }

    public final int getOrientation() {
        return this.n;
    }

    public final int getSHeight() {
        return this.M;
    }

    public final int getSWidth() {
        return this.L;
    }

    public final float getScale() {
        return this.D;
    }

    public final ImageViewState getState() {
        if (this.F == null || this.L <= 0 || this.M <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        i();
        if (this.L == 0 || this.M == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.l == null && this.W != null) {
            a(a(canvas));
        }
        if (g()) {
            j();
            Anim anim = this.al;
            if (anim != null && anim.f != null) {
                float f3 = this.D;
                if (this.H == null) {
                    this.H = new PointF(0.0f, 0.0f);
                }
                this.H.set(this.F);
                long currentTimeMillis = System.currentTimeMillis() - this.al.l;
                boolean z = currentTimeMillis > this.al.h;
                long min = Math.min(currentTimeMillis, this.al.h);
                this.D = a(this.al.j, min, this.al.f11560a, this.al.b - this.al.f11560a, this.al.h);
                float a2 = a(this.al.j, min, this.al.f.x, this.al.g.x - this.al.f.x, this.al.h);
                float a3 = a(this.al.j, min, this.al.f.y, this.al.g.y - this.al.f.y, this.al.h);
                this.F.x -= d(this.al.d.x) - a2;
                this.F.y -= e(this.al.d.y) - a3;
                d(z || this.al.f11560a == this.al.b);
                a(f3, this.H, this.al.k);
                c(z);
                if (z) {
                    if (this.al.m != null) {
                        try {
                            this.al.m.a();
                        } catch (Exception e2) {
                            Log.w(f11554a, "Error thrown by animation listener", e2);
                        }
                    }
                    this.al = null;
                }
                invalidate();
            }
            if (this.l == null || !f()) {
                Bitmap bitmap = this.g;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float f4 = this.D;
                    if (this.h) {
                        f4 *= this.L / this.g.getWidth();
                        f2 = this.D * (this.M / this.g.getHeight());
                    } else {
                        f2 = f4;
                    }
                    if (this.ax == null) {
                        this.ax = new Matrix();
                    }
                    this.ax.reset();
                    this.ax.postScale(f4, f2);
                    this.ax.postRotate(getRequiredRotation());
                    this.ax.postTranslate(this.F.x, this.F.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix = this.ax;
                        float f5 = this.D;
                        matrix.postTranslate(this.L * f5, f5 * this.M);
                    } else if (getRequiredRotation() == 90) {
                        this.ax.postTranslate(this.D * this.M, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.ax.postTranslate(0.0f, this.D * this.L);
                    }
                    if (this.av != null) {
                        if (this.ay == null) {
                            this.ay = new RectF();
                        }
                        this.ay.set(0.0f, 0.0f, this.h ? this.g.getWidth() : this.L, this.h ? this.g.getHeight() : this.M);
                        this.ax.mapRect(this.ay);
                        canvas.drawRect(this.ay, this.av);
                    }
                    canvas.drawBitmap(this.g, this.ax, this.as);
                }
            } else {
                int min2 = Math.min(this.k, a(this.D));
                boolean z2 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.l.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        Iterator<Tile> it = entry.getValue().iterator();
                        boolean z3 = z2;
                        while (true) {
                            z2 = z3;
                            if (it.hasNext()) {
                                Tile next = it.next();
                                if (next.e && (next.d || next.f11568c == null)) {
                                    z3 = true;
                                }
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.l.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z2) {
                        for (Tile tile : entry2.getValue()) {
                            b(tile.f11567a, tile.f);
                            if (!tile.d && tile.f11568c != null) {
                                if (this.av != null) {
                                    canvas.drawRect(tile.f, this.av);
                                }
                                if (this.ax == null) {
                                    this.ax = new Matrix();
                                }
                                this.ax.reset();
                                a(this.az, 0.0f, 0.0f, tile.f11568c.getWidth(), 0.0f, tile.f11568c.getWidth(), tile.f11568c.getHeight(), 0.0f, tile.f11568c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    a(this.aA, tile.f.left, tile.f.top, tile.f.right, tile.f.top, tile.f.right, tile.f.bottom, tile.f.left, tile.f.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    a(this.aA, tile.f.right, tile.f.top, tile.f.right, tile.f.bottom, tile.f.left, tile.f.bottom, tile.f.left, tile.f.top);
                                } else if (getRequiredRotation() == 180) {
                                    a(this.aA, tile.f.right, tile.f.bottom, tile.f.left, tile.f.bottom, tile.f.left, tile.f.top, tile.f.right, tile.f.top);
                                } else if (getRequiredRotation() == 270) {
                                    a(this.aA, tile.f.left, tile.f.bottom, tile.f.left, tile.f.top, tile.f.right, tile.f.top, tile.f.right, tile.f.bottom);
                                }
                                this.ax.setPolyToPoly(this.az, 0, this.aA, 0, 4);
                                canvas.drawBitmap(tile.f11568c, this.ax, this.as);
                                if (this.m) {
                                    canvas.drawRect(tile.f, this.au);
                                }
                            } else if (tile.d && this.m) {
                                canvas.drawText("LOADING", tile.f.left + a(5), tile.f.top + a(35), this.at);
                            }
                            if (tile.e && this.m) {
                                canvas.drawText("ISS " + tile.b + " RECT " + tile.f11567a.top + "," + tile.f11567a.left + "," + tile.f11567a.bottom + "," + tile.f11567a.right, tile.f.left + a(5), tile.f.top + a(15), this.at);
                            }
                        }
                    }
                }
            }
            if (this.m) {
                canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.D)) + " (" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(n())) + " - " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.o)) + ")", a(5), a(15), this.at);
                StringBuilder sb = new StringBuilder();
                sb.append("Translate: ");
                sb.append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.F.x)));
                sb.append(":");
                sb.append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.F.y)));
                canvas.drawText(sb.toString(), (float) a(5), (float) a(30), this.at);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), a(5), a(45), this.at);
                Anim anim2 = this.al;
                if (anim2 != null) {
                    PointF b2 = b(anim2.f11561c);
                    PointF b3 = b(this.al.e);
                    PointF b4 = b(this.al.d);
                    canvas.drawCircle(b2.x, b2.y, a(10), this.au);
                    this.au.setColor(-65536);
                    canvas.drawCircle(b3.x, b3.y, a(20), this.au);
                    this.au.setColor(Color.BLUE);
                    canvas.drawCircle(b4.x, b4.y, a(25), this.au);
                    this.au.setColor(Color.CYAN);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, a(30), this.au);
                }
                if (this.ad != null) {
                    this.au.setColor(-65536);
                    canvas.drawCircle(this.ad.x, this.ad.y, a(20), this.au);
                }
                if (this.aj != null) {
                    this.au.setColor(Color.BLUE);
                    canvas.drawCircle(d(this.aj.x), e(this.aj.y), a(35), this.au);
                }
                if (this.ak != null && this.S) {
                    this.au.setColor(Color.CYAN);
                    canvas.drawCircle(this.ak.x, this.ak.y, a(30), this.au);
                }
                this.au.setColor(Color.MAGENTA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = true;
        boolean z2 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z = false;
        }
        int i3 = size;
        int i4 = size2;
        if (this.L > 0) {
            i3 = size;
            i4 = size2;
            if (this.M > 0) {
                if (z2 && z) {
                    i3 = l();
                    i4 = m();
                } else if (z) {
                    i4 = (int) ((m() / l()) * size);
                    i3 = size;
                } else {
                    i3 = size;
                    i4 = size2;
                    if (z2) {
                        i3 = (int) ((l() / m()) * size2);
                        i4 = size2;
                    }
                }
            }
        }
        setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(i4, getSuggestedMinimumHeight()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        a("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        PointF center = getCenter();
        if (!this.am || center == null) {
            return;
        }
        this.al = null;
        this.I = Float.valueOf(this.D);
        this.J = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.al;
        boolean z = true;
        if (anim != null && !anim.i) {
            b(true);
            return true;
        }
        Anim anim2 = this.al;
        if (anim2 != null && anim2.m != null) {
            try {
                this.al.m.b();
            } catch (Exception e2) {
                Log.w(f11554a, "Error thrown by animation listener", e2);
            }
        }
        this.al = null;
        if (this.F == null) {
            GestureDetector gestureDetector2 = this.V;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
                return true;
            }
            return true;
        } else if (!this.S && ((gestureDetector = this.U) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.Q = false;
            this.R = false;
            this.T = 0;
            return true;
        } else {
            if (this.G == null) {
                this.G = new PointF(0.0f, 0.0f);
            }
            if (this.H == null) {
                this.H = new PointF(0.0f, 0.0f);
            }
            if (this.ad == null) {
                this.ad = new PointF(0.0f, 0.0f);
            }
            float f2 = this.D;
            this.H.set(this.F);
            boolean a2 = a(motionEvent);
            a(f2, this.H, 2);
            if (!a2) {
                if (super.onTouchEvent(motionEvent)) {
                    return true;
                }
                z = false;
            }
            return z;
        }
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.ab = new CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.ab = decoderFactory;
    }

    public final void setDebug(boolean z) {
        this.m = z;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.C = Math.max(0, i);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.A = f2;
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (f11555c.contains(Integer.valueOf(i))) {
            this.B = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.w = z;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.v = executor;
    }

    public final void setImage(ImageSource imageSource) {
        a(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setMaxScale(float f2) {
        this.o = f2;
    }

    public void setMaxTileSize(int i) {
        this.t = i;
        this.u = i;
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinScale(float f2) {
        this.p = f2;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinimumScaleType(int i) {
        if (!f.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid scale type: " + i);
        }
        this.s = i;
        if (a()) {
            d(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.q = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
        if (a()) {
            a(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.ao = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aq = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.ap = onStateChangedListener;
    }

    public final void setOrientation(int i) {
        if (!b.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid orientation: " + i);
        }
        this.n = i;
        a(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.x = z;
        if (z || (pointF = this.F) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.D * (l() / 2));
        this.F.y = (getHeight() / 2) - (this.D * (m() / 2));
        if (a()) {
            c(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i) {
        if (!e.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i);
        }
        this.r = i;
        if (a()) {
            d(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.z = z;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.ac = new CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.ac = decoderFactory;
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.av = null;
        } else {
            Paint paint = new Paint();
            this.av = paint;
            paint.setStyle(Paint.Style.FILL);
            this.av.setColor(i);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.y = z;
    }
}
