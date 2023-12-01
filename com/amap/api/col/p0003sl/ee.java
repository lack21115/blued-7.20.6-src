package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.ee  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ee.class */
public class ee extends ScrollView {
    public static final String a = ee.class.getSimpleName();
    int b;
    private Context c;
    private LinearLayout d;
    private int e;
    private List<String> f;
    private int g;
    private int h;
    private Bitmap i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Runnable p;
    private int q;
    private a r;

    /* renamed from: com.amap.api.col.3sl.ee$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ee$a.class */
    public interface a {
        void a(int i);
    }

    public ee(Context context) {
        super(context);
        this.e = 0;
        this.g = -1;
        this.i = null;
        this.j = Color.parseColor("#eeffffff");
        this.k = Color.parseColor("#44383838");
        this.l = 4;
        this.m = 1;
        this.b = 1;
        this.q = 50;
        a(context);
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    private void a(int i) {
        int i2;
        TextView textView;
        int i3 = this.e;
        if (i3 == 0) {
            return;
        }
        int i4 = i / i3;
        int i5 = this.m;
        int i6 = i4 + i5;
        int i7 = i % i3;
        int i8 = i / i3;
        if (i7 == 0) {
            i2 = i8 + i5;
        } else {
            i2 = i6;
            if (i7 > i3 / 2) {
                i2 = i8 + i5 + 1;
            }
        }
        int childCount = this.d.getChildCount();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= childCount || (textView = (TextView) this.d.getChildAt(i10)) == null) {
                return;
            }
            if (i2 == i10) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
            i9 = i10 + 1;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x004f -> B:6:0x0027). Please submit an issue!!! */
    private void a(Context context) {
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                InputStream open = dq.a(context).open("map_indoor_select.png");
                this.i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable th) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.d);
        this.p = new Runnable() { // from class: com.amap.api.col.3sl.ee.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ee.this.o - ee.this.getScrollY() != 0) {
                    ee eeVar = ee.this;
                    eeVar.o = eeVar.getScrollY();
                    ee eeVar2 = ee.this;
                    eeVar2.postDelayed(eeVar2.p, ee.this.q);
                } else if (ee.this.e == 0) {
                } else {
                    final int i = ee.this.o % ee.this.e;
                    final int i2 = ee.this.o / ee.this.e;
                    if (i == 0) {
                        ee eeVar3 = ee.this;
                        eeVar3.b = i2 + eeVar3.m;
                        ee.this.f();
                    } else if (i > ee.this.e / 2) {
                        ee.this.post(new Runnable() { // from class: com.amap.api.col.3sl.ee.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ee.this.smoothScrollTo(0, (ee.this.o - i) + ee.this.e);
                                ee.this.b = i2 + ee.this.m + 1;
                                ee.this.f();
                            }
                        });
                    } else {
                        ee.this.post(new Runnable() { // from class: com.amap.api.col.3sl.ee.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ee.this.smoothScrollTo(0, ee.this.o - i);
                                ee.this.b = i2 + ee.this.m;
                                ee.this.f();
                            }
                        });
                    }
                }
            }
        };
    }

    private TextView b(String str) {
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a2 = a(this.c, 8.0f);
        int a3 = a(this.c, 6.0f);
        textView.setPadding(a2, a3, a2, a3);
        if (this.e == 0) {
            this.e = a(textView);
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
        }
        return textView;
    }

    private static void b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void c() {
        this.o = getScrollY();
        postDelayed(this.p, this.q);
    }

    private void d() {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        this.d.removeAllViews();
        this.n = (this.m * 2) + 1;
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                a(0);
                return;
            } else {
                this.d.addView(b(this.f.get(i)));
                size = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] e() {
        int i = this.e;
        int i2 = this.m;
        return new int[]{i * i2, i * (i2 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a aVar = this.r;
        if (aVar != null) {
            try {
                aVar.a(g());
            } catch (Throwable th) {
            }
        }
    }

    private int g() {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int size = this.f.size();
        int i = this.b;
        return Math.min(this.f.size() - (this.m * 2), Math.max(0, ((size - 1) - i) - this.m));
    }

    public final void a() {
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            dw.a(this.i);
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public final void a(a aVar) {
        this.r = aVar;
    }

    public final void a(String str) {
        List<String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f.indexOf(str);
        int size = this.f.size();
        int i = this.m;
        final int i2 = ((size - i) - 1) - indexOf;
        this.b = i + i2;
        post(new Runnable() { // from class: com.amap.api.col.3sl.ee.3
            @Override // java.lang.Runnable
            public final void run() {
                ee eeVar = ee.this;
                eeVar.smoothScrollTo(0, i2 * eeVar.e);
            }
        });
    }

    public final void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public final void a(String[] strArr) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                break;
            }
            this.f.add(strArr[i2]);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.m) {
                d();
                return;
            }
            this.f.add(0, "");
            this.f.add("");
            i3 = i4 + 1;
        }
    }

    public final boolean b() {
        return getVisibility() == 0;
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a(i2);
        if (i2 > i4) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.j = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.c.getSystemService("window");
                if (windowManager != null) {
                    this.h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() { // from class: com.amap.api.col.3sl.ee.2
            private void a(Canvas canvas) {
                canvas.drawColor(ee.this.j);
            }

            private void b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = ee.this.i.getWidth() + 0;
                rect.bottom = ee.this.i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = ee.this.e()[0];
                rect2.right = ee.this.h + 0;
                rect2.bottom = ee.this.e()[1];
                canvas.drawBitmap(ee.this.i, rect, rect2, paint);
            }

            private void c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(ee.this.k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(ee.this.l);
                canvas.drawRect(clipBounds, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public final void draw(Canvas canvas) {
                try {
                    a(canvas);
                    b(canvas);
                    c(canvas);
                } catch (Throwable th2) {
                }
            }

            @Override // android.graphics.drawable.Drawable
            public final int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public final void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public final void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }
}
