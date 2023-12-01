package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/RotateLayout.class */
public class RotateLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f11034a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f11035c;
    private float d;
    private boolean e;
    private boolean f;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/RotateLayout$baseAnimationListener.class */
    public class baseAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public RotateLayout(Context context) {
        super(context);
        this.d = 0.0f;
        this.e = false;
        this.f = false;
        a();
    }

    public RotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.e = false;
        this.f = false;
        a();
    }

    void a() {
        this.b = LayoutInflater.from(getContext()).inflate(R.layout.rotatelayout, this);
        this.f11034a = BitmapFactory.decodeResource(getResources(), R.drawable.icon_userinfo_refreshing);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.iv_loading);
        this.f11035c = imageView;
        imageView.setImageBitmap(this.f11034a);
    }

    public void a(float f) {
        int width = this.f11034a.getWidth();
        int height = this.f11034a.getHeight();
        Matrix matrix = new Matrix();
        float f2 = this.d + f;
        this.d = f2;
        matrix.setRotate(f2, width / 2, height / 2);
        Bitmap createBitmap = Bitmap.createBitmap(this.f11034a, 0, 0, width, height, matrix, true);
        this.f11035c.setScaleType(ImageView.ScaleType.CENTER);
        this.f11035c.setImageBitmap(createBitmap);
    }

    public void b() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        this.f11035c.startAnimation(rotateAnimation);
    }

    public void c() {
        this.f11035c.clearAnimation();
    }

    public void d() {
        if (this.e) {
            return;
        }
        this.e = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_in);
        loadAnimation.setDuration(500L);
        loadAnimation.setFillAfter(true);
        this.f11035c.setVisibility(0);
        this.f11035c.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.common.view.RotateLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RotateLayout.this.f = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                RotateLayout.this.f = false;
            }
        });
    }

    public void e() {
        c();
        this.e = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_out);
        loadAnimation.setDuration(500L);
        loadAnimation.setFillAfter(true);
        this.f11035c.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.common.view.RotateLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RotateLayout.this.scrollTo(0, 0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void setRefreshingBM(int i) {
        this.f11034a = BitmapFactory.decodeResource(getResources(), i);
    }
}
