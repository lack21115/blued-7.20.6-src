package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.view.BubbleLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKBubbleLayout.class */
public class LivePKBubbleLayout extends BubbleLayout {
    private List<BubbleLayout.Bubble> a;
    private Random b;
    private int c;
    private int d;
    private Context e;
    private Paint f;
    private int g;
    private int h;
    private int i;

    public LivePKBubbleLayout(Context context) {
        super(context);
        this.a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
    }

    public LivePKBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
    }

    public LivePKBubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Collections.synchronizedList(new ArrayList());
        this.b = new Random();
        this.f = new Paint();
    }

    public void a(int i) {
        float f;
        if (i <= 0) {
            return;
        }
        this.f.reset();
        this.f.setColor(6723993);
        this.c = getWidth();
        this.d = getHeight();
        final BubbleLayout.Bubble bubble = new BubbleLayout.Bubble();
        TextView textView = new TextView(this.e);
        textView.setText("+" + i);
        if (i > 0 && i <= 20) {
            textView.setTextColor(Color.parseColor("#ffb119"));
            textView.setTextSize(18.0f);
        } else if (i <= 20 || i >= 100) {
            textView.setTextColor(Color.parseColor("#f65e4a"));
            textView.setTextSize(28.0f);
        } else {
            textView.setTextColor(Color.parseColor("#ff873e"));
            textView.setTextSize(22.0f);
        }
        textView.setDrawingCacheEnabled(true);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(textView.getDrawingCache());
        textView.destroyDrawingCache();
        bubble.e = createBitmap;
        bubble.c(8.0f);
        bubble.c = 0.08f;
        int measuredWidth = this.c - textView.getMeasuredWidth();
        bubble.a(measuredWidth > 0 ? this.b.nextInt(measuredWidth) : this.c);
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
        bubble.a = bubble.e();
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKBubbleLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivePKBubbleLayout.this.a.size() <= 50) {
                    LivePKBubbleLayout.this.a.add(bubble);
                }
                LivePKBubbleLayout.this.invalidate();
            }
        });
    }

    @Override // com.blued.android.module.live_china.view.BubbleLayout
    public void a(Context context) {
        this.e = context;
        this.i = DensityUtils.a(context, 65.0f);
        this.g = DensityUtils.a(this.e, 28.0f);
        this.h = DensityUtils.a(this.e, 17.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.live_china.view.BubbleLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a.size() > 0) {
            Iterator<BubbleLayout.Bubble> it = this.a.iterator();
            while (it.hasNext()) {
                BubbleLayout.Bubble next = it.next();
                if (next != null) {
                    if (next.c() - next.d() <= 0.0f) {
                        it.remove();
                    } else {
                        float b = (this.c - this.g) - next.b();
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
                        if (next.b < 1.0f) {
                            Matrix matrix = new Matrix();
                            matrix.postScale(next.b * 1.0f, next.b * 1.0f, 1.0f, 1.0f);
                            matrix.postTranslate(next.b(), next.c());
                            if (next.e != null) {
                                canvas.drawBitmap(next.e, matrix, this.f);
                            }
                            next.b += next.c;
                            next.b(next.c() - 5.0f);
                            next.a(next.b() - 3.5f);
                        } else {
                            Matrix matrix2 = new Matrix();
                            matrix2.postScale(1.0f, 1.0f, 1.0f, 1.0f);
                            matrix2.postTranslate(next.b(), next.c());
                            if (next.e != null) {
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
    }
}
