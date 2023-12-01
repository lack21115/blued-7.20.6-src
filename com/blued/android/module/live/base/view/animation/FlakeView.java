package com.blued.android.module.live.base.view.animation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live.base.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/FlakeView.class */
public class FlakeView extends View {
    private Context a;
    private int b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private long i;
    private long j;
    private int k;
    private LiveAnimationListener l;
    private Bitmap m;
    private ArrayList<FlakeConfig> n;
    private ValueAnimator o;
    private Matrix p;

    public FlakeView(Context context) {
        this(context, null);
    }

    public FlakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new ArrayList<>();
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlakeView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FlakeView_flake_pic, R.drawable.icon_money_gift);
        this.b = obtainStyledAttributes.getInt(R.styleable.FlakeView_flake_count, 0);
        this.c = obtainStyledAttributes.getDimension(R.styleable.FlakeView_drop_speed_low_limit, 1300.0f);
        this.d = obtainStyledAttributes.getDimension(R.styleable.FlakeView_drop_speed_high_limit, 1800.0f);
        this.e = obtainStyledAttributes.getDimension(R.styleable.FlakeView_rotation_speed_low_limit, -45.0f);
        this.f = obtainStyledAttributes.getDimension(R.styleable.FlakeView_rotation_speed_high_limit, 45.0f);
        this.g = obtainStyledAttributes.getDimension(R.styleable.FlakeView_rotation_degree_low_limit, -90.0f);
        this.h = obtainStyledAttributes.getDimension(R.styleable.FlakeView_rotation_degree_high_limit, 90.0f);
        this.m = BitmapFactory.decodeResource(getResources(), resourceId);
        a();
        obtainStyledAttributes.recycle();
    }

    private void a(FlakeConfig flakeConfig) {
        flakeConfig.a(this.c, this.d);
        flakeConfig.b(this.g, this.h);
        flakeConfig.c(this.e, this.f);
        flakeConfig.a();
    }

    private void c() {
        this.n.clear();
        this.o.cancel();
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        c();
        LiveAnimationListener liveAnimationListener = this.l;
        if (liveAnimationListener != null) {
            liveAnimationListener.b();
        }
    }

    protected void a() {
        this.p = new Matrix();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live.base.view.animation.FlakeView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((float) (currentTimeMillis - FlakeView.this.j)) / 1000.0f;
                FlakeView.this.j = currentTimeMillis;
                long j = currentTimeMillis - FlakeView.this.i;
                Iterator it = FlakeView.this.n.iterator();
                while (it.hasNext()) {
                    FlakeConfig flakeConfig = (FlakeConfig) it.next();
                    flakeConfig.d += flakeConfig.f * f;
                    flakeConfig.e += flakeConfig.g * f;
                    if (flakeConfig.d >= FlakeView.this.getHeight() && j <= 2500) {
                        flakeConfig.a();
                    }
                    if (flakeConfig.d >= FlakeView.this.getHeight() && j > 2500) {
                        it.remove();
                    }
                }
                Log.v("drb", "totalTime = " + j);
                if (FlakeView.this.n.size() == 0) {
                    FlakeView.this.d();
                }
                FlakeView.this.invalidate();
            }
        });
        this.o.setRepeatCount(-1);
        this.o.setDuration(2500L);
    }

    public void a(int i) {
        int i2;
        int i3;
        if (((Activity) this.a).getRequestedOrientation() == 1) {
            i2 = AppInfo.l;
            i3 = AppInfo.m;
        } else {
            i2 = AppInfo.m;
            i3 = AppInfo.l;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                return;
            }
            FlakeConfig flakeConfig = new FlakeConfig(this.a, i2, i3, this.m);
            a(flakeConfig);
            this.n.add(flakeConfig);
            i4 = i5 + 1;
        }
    }

    public void b() {
        LiveAnimationListener liveAnimationListener = this.l;
        if (liveAnimationListener != null) {
            liveAnimationListener.a();
        }
        c();
        this.k = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.i = currentTimeMillis;
        this.j = currentTimeMillis;
        setVisibility(0);
        a(this.b);
        this.o.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.n.size()) {
                return;
            }
            FlakeConfig flakeConfig = this.n.get(i2);
            this.p.setTranslate((-flakeConfig.a) / 2, (-flakeConfig.b) / 2);
            this.p.postRotate(flakeConfig.e);
            this.p.postTranslate((flakeConfig.a / 2) + flakeConfig.c, (flakeConfig.b / 2) + flakeConfig.d);
            canvas.drawBitmap(flakeConfig.h, this.p, null);
            i = i2 + 1;
        }
    }

    public void setAnimationListener(LiveAnimationListener liveAnimationListener) {
        this.l = liveAnimationListener;
    }
}
