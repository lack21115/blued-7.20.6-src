package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftScrawlModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.igexin.push.config.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlPlayView.class */
public class LiveGiftScrawlPlayView extends View {

    /* renamed from: a  reason: collision with root package name */
    int f13865a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    float f13866c;
    private Paint d;
    private int e;
    private int f;
    private Bitmap g;
    private int h;
    private final List<LiveGiftScrawlModel> i;
    private final Map<String, Bitmap> j;
    private final AtomicInteger k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private final Rect s;
    private final RectF t;
    private final int u;
    private final float v;
    private final float w;
    private float x;
    private boolean y;
    private ScrawlPlayListener z;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlPlayView$ScrawlPlayListener.class */
    public interface ScrawlPlayListener {
        void onPlayFinish();
    }

    public LiveGiftScrawlPlayView(Context context) {
        super(context);
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new AtomicInteger(0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = false;
        this.q = 750L;
        this.r = 0;
        this.s = new Rect();
        this.t = new RectF();
        this.u = 25;
        this.v = 0.04f;
        this.w = 0.01f;
        this.f13865a = 0;
        this.y = false;
        b();
    }

    public LiveGiftScrawlPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new AtomicInteger(0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = false;
        this.q = 750L;
        this.r = 0;
        this.s = new Rect();
        this.t = new RectF();
        this.u = 25;
        this.v = 0.04f;
        this.w = 0.01f;
        this.f13865a = 0;
        this.y = false;
        b();
    }

    public LiveGiftScrawlPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new AtomicInteger(0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = false;
        this.q = 750L;
        this.r = 0;
        this.s = new Rect();
        this.t = new RectF();
        this.u = 25;
        this.v = 0.04f;
        this.w = 0.01f;
        this.f13865a = 0;
        this.y = false;
        b();
    }

    public LiveGiftScrawlPlayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new AtomicInteger(0);
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = false;
        this.q = 750L;
        this.r = 0;
        this.s = new Rect();
        this.t = new RectF();
        this.u = 25;
        this.v = 0.04f;
        this.w = 0.01f;
        this.f13865a = 0;
        this.y = false;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGiftScrawlTransModel liveGiftScrawlTransModel) {
        if (liveGiftScrawlTransModel.goods == null || liveGiftScrawlTransModel.goods.size() <= 0) {
            this.p = false;
            setVisibility(8);
            ScrawlPlayListener scrawlPlayListener = this.z;
            if (scrawlPlayListener != null) {
                scrawlPlayListener.onPlayFinish();
                return;
            }
            return;
        }
        this.m = liveGiftScrawlTransModel.width;
        int i = liveGiftScrawlTransModel.height;
        this.n = i;
        float f = 1.0f;
        if (this.m > 0) {
            f = 1.0f;
            if (i > 0) {
                if (this.e <= 0) {
                    this.e = DisplayUtil.b(AppInfo.d(), AppInfo.l);
                    this.f = DisplayUtil.b(AppInfo.d(), AppInfo.m);
                }
                f = this.e / this.m;
            }
        }
        this.l = 0;
        this.o = 1;
        this.r = 0;
        this.y = false;
        for (LiveGiftScrawlModel liveGiftScrawlModel : liveGiftScrawlTransModel.goods) {
            if (liveGiftScrawlModel != null) {
                this.l += liveGiftScrawlModel.getPath().size();
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < liveGiftScrawlModel.getPath().size()) {
                    int i4 = liveGiftScrawlModel.getPath().get(i3).x;
                    int i5 = liveGiftScrawlModel.getPath().get(i3).y;
                    liveGiftScrawlModel.getPath().get(i3).x = DisplayUtil.a(getContext(), i4 * f) - (this.h / 2);
                    liveGiftScrawlModel.getPath().get(i3).y = DisplayUtil.a(getContext(), i5 * f) - (this.h / 2);
                    i2 = i3 + 1;
                }
            }
        }
        setVisibility(0);
        this.i.clear();
        this.i.addAll(liveGiftScrawlTransModel.goods);
        int i6 = this.l;
        if (i6 > 100) {
            this.q = c.j;
        } else if (i6 > 50) {
            this.q = 1000L;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, File file, Exception exc) {
        Bitmap bitmap;
        if (file == null || !file.exists()) {
            bitmap = this.g;
        } else {
            int i = this.h;
            Bitmap a2 = ImageUtils.a(file, i, i);
            if (a2 != null) {
                int i2 = this.h;
                bitmap = Bitmap.createScaledBitmap(a2, i2, i2, false);
            } else {
                bitmap = null;
            }
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = this.g;
        }
        synchronized (this.j) {
            if (bitmap2 != null) {
                this.j.put(str, bitmap2);
                if (this.k.decrementAndGet() <= 0) {
                    postInvalidate();
                }
            }
        }
    }

    private void b() {
        int a2 = DisplayUtil.a(getContext(), 1.0f);
        this.h = DisplayUtil.a(getContext(), 40.0f);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.gift_default_icon);
        int i = this.h;
        this.g = Bitmap.createScaledBitmap(decodeResource, i, i, false);
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStrokeWidth(a2);
        this.d.setStyle(Paint.Style.STROKE);
        this.s.top = 0;
        this.s.left = 0;
        this.s.bottom = this.h;
        this.s.right = this.h;
    }

    private void c() {
        boolean z = false;
        this.k.set(0);
        for (LiveGiftScrawlModel liveGiftScrawlModel : this.i) {
            final String str = liveGiftScrawlModel.images_static;
            if (!TextUtils.isEmpty(str) && (!this.j.containsKey(str) || this.j.get(str) == null)) {
                z = true;
                this.k.incrementAndGet();
                ImageFileLoader.a((IRequestHost) null).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlPlayView$Pn8mnD3kTLtR-mSAAi8mHq9KLfs
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        LiveGiftScrawlPlayView.this.a(str, file, exc);
                    }
                }).a();
            }
        }
        if (z) {
            return;
        }
        invalidate();
    }

    private void d() {
        for (Bitmap bitmap : this.j.values()) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.j.clear();
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        this.i.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.r = 1;
        invalidate();
    }

    public boolean a() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.r > 25) {
            return;
        }
        if (this.i.size() <= 0) {
            canvas.drawColor(0);
        } else if (this.o < this.l) {
            this.f13865a = 0;
            for (LiveGiftScrawlModel liveGiftScrawlModel : this.i) {
                Bitmap bitmap = this.j.get(liveGiftScrawlModel.images_static);
                Bitmap bitmap2 = bitmap;
                if (bitmap == null) {
                    bitmap2 = this.g;
                }
                if (bitmap2 != null) {
                    for (Point point : liveGiftScrawlModel.getPath()) {
                        if (this.f13865a > this.o) {
                            break;
                        }
                        canvas.drawBitmap(bitmap2, point.x, point.y, this.d);
                        this.f13865a++;
                    }
                }
                if (this.f13865a >= this.o) {
                    break;
                }
            }
            postInvalidateDelayed(20L);
            this.o++;
        } else {
            int i = this.r;
            if (i > 0) {
                if (i >= 25) {
                    this.p = false;
                    setAlpha(1.0f);
                    canvas.drawColor(0);
                    setVisibility(8);
                    ScrawlPlayListener scrawlPlayListener = this.z;
                    if (scrawlPlayListener != null) {
                        scrawlPlayListener.onPlayFinish();
                        return;
                    }
                    return;
                }
                postInvalidateDelayed(10L);
                this.r++;
            }
            setAlpha(1.0f - (this.r * 0.04f));
            for (LiveGiftScrawlModel liveGiftScrawlModel2 : this.i) {
                Bitmap bitmap3 = this.j.get(liveGiftScrawlModel2.images_static);
                Bitmap bitmap4 = bitmap3;
                if (bitmap3 == null) {
                    bitmap4 = this.g;
                }
                if (bitmap4 != null) {
                    for (Point point2 : liveGiftScrawlModel2.getPath()) {
                        this.b = point2.x;
                        float f = point2.y;
                        this.f13866c = f;
                        int i2 = this.r;
                        if (i2 > 0) {
                            float f2 = ((this.h * 0.01f) * i2) / 2.0f;
                            this.x = f2;
                            this.t.left = this.b - f2;
                            this.t.top = this.f13866c - this.x;
                            this.t.right = this.b + this.h + this.x;
                            this.t.bottom = this.f13866c + this.h + this.x;
                            canvas.drawBitmap(bitmap4, this.s, this.t, this.d);
                        } else {
                            canvas.drawBitmap(bitmap4, this.b, f, this.d);
                        }
                    }
                }
            }
            if (this.y) {
                return;
            }
            this.y = true;
            postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlPlayView$yzXg7-zY7YOMAusQ4fjFwbzH6ys
                @Override // java.lang.Runnable
                public final void run() {
                    LiveGiftScrawlPlayView.this.e();
                }
            }, this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() <= 0 || getMeasuredWidth() == this.e) {
            return;
        }
        this.e = DisplayUtil.b(AppInfo.d(), getMeasuredWidth());
        this.f = DisplayUtil.b(AppInfo.d(), getMeasuredHeight());
    }

    public void setData(final LiveGiftScrawlTransModel liveGiftScrawlTransModel) {
        if (liveGiftScrawlTransModel == null) {
            return;
        }
        this.p = true;
        postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlPlayView$C8Nw1Z5UPxm9p0XyOebDzCfEOXM
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftScrawlPlayView.this.a(liveGiftScrawlTransModel);
            }
        }, 200L);
    }

    public void setScrawlPlayListener(ScrawlPlayListener scrawlPlayListener) {
        this.z = scrawlPlayListener;
    }
}
