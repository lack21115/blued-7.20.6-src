package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BubbleLayout.class */
public class BubbleLayout extends View {

    /* renamed from: a  reason: collision with root package name */
    private List<Bubble> f14239a;
    private Random b;

    /* renamed from: c  reason: collision with root package name */
    private int f14240c;
    private int d;
    private Context e;
    private Paint f;
    private int g;
    private int h;
    private int i;
    private ArrayList<Bitmap> j;
    private LoadOptions k;
    private Bitmap l;
    private boolean m;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BubbleLayout$Bubble.class */
    public static class Bubble {

        /* renamed from: a  reason: collision with root package name */
        public float f14246a;

        /* renamed from: c  reason: collision with root package name */
        public float f14247c;
        public Bitmap e;
        private float f;
        private float g;
        private float h;
        private float i;
        public float b = 0.2f;
        public int d = 220;

        public void a() {
            float f = this.i;
            float f2 = this.f;
            if (f - f2 <= this.d) {
                int i = (int) (f - f2);
                this.d = i;
                if (i <= 10) {
                    this.d = 0;
                }
            }
        }

        public void a(float f) {
            this.h = f;
        }

        public float b() {
            return this.h;
        }

        public void b(float f) {
            this.i = f;
        }

        public float c() {
            return this.i;
        }

        public void c(float f) {
            this.f = f;
        }

        public float d() {
            return this.f;
        }

        public void d(float f) {
            this.g = f;
        }

        public float e() {
            return this.g;
        }
    }

    public BubbleLayout(Context context) {
        super(context);
        this.f14239a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
        this.m = true;
        a(context);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14239a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
        this.m = true;
        a(context);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14239a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
        this.m = true;
        a(context);
    }

    protected Bitmap a(Bitmap bitmap) {
        float a2 = DensityUtils.a(this.e, 5.0f) / 10.0f;
        Matrix matrix = new Matrix();
        matrix.postScale(a2, a2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public void a() {
        this.m = false;
    }

    public void a(Context context) {
        this.e = context;
        this.i = DensityUtils.a(context, 65.0f);
        this.g = DensityUtils.a(this.e, 28.0f);
        this.h = DensityUtils.a(this.e, 17.0f);
        this.j = new ArrayList<>();
        LoadOptions loadOptions = new LoadOptions();
        this.k = loadOptions;
        loadOptions.a(DensityUtils.a(this.e, 28.0f), DensityUtils.a(this.e, 50.0f));
    }

    public void a(boolean z, int i) {
        a(z, i, false);
    }

    public void a(final boolean z, final int i, boolean z2) {
        float f;
        if (!z2 && !z) {
            int nextInt = this.b.nextInt(3);
            for (int i2 = 0; i2 < nextInt + 3; i2++) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.BubbleLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BubbleLayout.this.a(z, i, true);
                    }
                }, i2 * 500);
            }
            return;
        }
        this.m = true;
        if (this.l == null) {
            this.l = ((BitmapDrawable) getResources().getDrawable(R.drawable.icon_rich26_like)).getBitmap();
        }
        synchronized (this.j) {
            if (this.j.size() == 0) {
                this.j.add(((BitmapDrawable) getResources().getDrawable(R.drawable.heart_self)).getBitmap());
            }
            this.f.reset();
            this.f.setColor(6723993);
            this.f14240c = getWidth();
            this.d = getHeight();
            final Bubble bubble = new Bubble();
            if (i >= 26) {
                bubble.e = this.l;
            } else {
                bubble.e = this.j.get(this.b.nextInt(this.j.size()));
            }
            bubble.c((this.b.nextFloat() * 5.0f) + 1.5f);
            bubble.f14247c = 0.08f;
            bubble.a((this.f14240c - this.h) - DensityUtils.a(this.e, 22.0f));
            bubble.b(this.d - DensityUtils.a(this.e, 12.0f));
            float nextFloat = this.b.nextFloat();
            while (true) {
                f = nextFloat - 1.0f;
                if (f < -0.25d && f > -0.7f) {
                    break;
                }
                nextFloat = this.b.nextFloat();
            }
            float f2 = f;
            if (!(this.b.nextInt(2) == 0)) {
                f2 = f * (-1.0f);
            }
            bubble.d(f2 * 3.0f);
            bubble.f14246a = bubble.e();
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.BubbleLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        BubbleLayout.this.f14239a.add(bubble);
                    } else if (BubbleLayout.this.f14239a.size() <= 50) {
                        BubbleLayout.this.f14239a.add(bubble);
                    }
                    BubbleLayout.this.invalidate();
                }
            });
        }
    }

    public void a(String[] strArr) {
        synchronized (this.j) {
            if (strArr != null) {
                if (strArr.length > 0) {
                    this.j.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        if (!TextUtils.isEmpty(strArr[i2])) {
                            ImageFileLoader.a((IRequestHost) null).a(strArr[i2]).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.BubbleLayout.1
                                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                                public void onUIFinish(File file, Exception exc) {
                                    Bitmap decodeFile;
                                    if (file == null || !file.exists() || (decodeFile = BitmapFactory.decodeFile(file.getPath())) == null) {
                                        return;
                                    }
                                    BubbleLayout.this.j.add(BubbleLayout.this.a(decodeFile));
                                }
                            }).a();
                        }
                        i = i2 + 1;
                    }
                }
            }
            this.j.add(((BitmapDrawable) getResources().getDrawable(R.drawable.heart_self)).getBitmap());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.j.size()) {
                    break;
                }
                this.j.get(i2).recycle();
                i = i2 + 1;
            }
            this.j.clear();
        }
        Bitmap bitmap = this.l;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.l.recycle();
        }
        List<Bubble> list = this.f14239a;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.m || this.f14239a.size() <= 0) {
            return;
        }
        Iterator<Bubble> it = this.f14239a.iterator();
        while (it.hasNext()) {
            Bubble next = it.next();
            if (next != null) {
                if (next.c() - next.d() <= 0.0f || (next.e != null && next.e.isRecycled())) {
                    it.remove();
                } else {
                    float b = (this.f14240c - this.g) - next.b();
                    float f = this.i;
                    if (next.e() >= 0.0f) {
                        if (b <= 0.0f) {
                            next.d(-next.e());
                        }
                    } else if (f - b <= 0.0f) {
                        next.d(-next.e());
                    }
                    next.a();
                    this.f.setAlpha(next.d);
                    float width = next.e.getWidth() > DensityUtils.a(this.e, 28.0f) ? 1.0f / (next.e.getWidth() / DensityUtils.a(this.e, 28.0f)) : 1.0f;
                    if (next.b < 1.0f) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(next.b * width, next.b * width, 1.0f, 1.0f);
                        matrix.postTranslate(next.b(), next.c());
                        if (next.e != null && !next.e.isRecycled()) {
                            canvas.drawBitmap(next.e, matrix, this.f);
                        }
                        next.b += next.f14247c;
                        next.b(next.c() - 5.0f);
                        next.a(next.b() - 3.5f);
                    } else {
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(width, width, 1.0f, 1.0f);
                        matrix2.postTranslate(next.b(), next.c());
                        if (next.e != null && !next.e.isRecycled()) {
                            canvas.drawBitmap(next.e, matrix2, this.f);
                        }
                        next.a(next.b() + next.e());
                        next.b(next.c() - next.d());
                    }
                }
            }
        }
        invalidate();
    }

    public void setShakeWidth(int i) {
        this.i = i;
    }
}
