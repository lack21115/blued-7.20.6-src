package com.soft.blued.customview.capricorn;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.capricorn.ArcLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/ArcMenu.class */
public class ArcMenu extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArcLayout f28567a;
    private ViewGroup b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28568c;

    /* renamed from: com.soft.blued.customview.capricorn.ArcMenu$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/ArcMenu$2.class */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnItemDisappearListener f28570a;
        final /* synthetic */ View.OnClickListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArcMenu f28571c;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f28571c.a(view, true, 400L).setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.customview.capricorn.ArcMenu.2.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AnonymousClass2.this.f28571c.postDelayed(new Runnable() { // from class: com.soft.blued.customview.capricorn.ArcMenu.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.f28571c.a();
                            if (AnonymousClass2.this.f28570a != null) {
                                AnonymousClass2.this.f28570a.a();
                            }
                        }
                    }, 0L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f28571c.a(false);
            int childCount = this.f28571c.f28567a.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = this.f28571c.f28567a.getChildAt(i2);
                if (view != childAt) {
                    this.f28571c.a(childAt, false, 300L);
                }
                i = i2 + 1;
            }
            this.f28571c.f28567a.invalidate();
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/ArcMenu$OnItemDisappearListener.class */
    public interface OnItemDisappearListener {
        void a();
    }

    public ArcMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(attributeSet);
    }

    private static Animation a(long j, boolean z) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new ScaleAnimation(1.0f, z ? 2.0f : 0.0f, 1.0f, z ? 2.0f : 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setDuration(j);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setFillAfter(true);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation a(View view, boolean z, long j) {
        Animation a2 = a(j, z);
        view.setAnimation(a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int childCount = this.f28567a.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                this.f28567a.a(false);
                return;
            } else {
                this.f28567a.getChildAt(i2).clearAnimation();
                i = i2 + 1;
            }
        }
    }

    private void a(Context context) {
        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.arc_menu, this);
        this.f28567a = (ArcLayout) findViewById(R.id.item_layout);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.control_layout);
        this.b = viewGroup;
        viewGroup.setClickable(true);
        this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.customview.capricorn.ArcMenu.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    ArcMenu.this.f28567a.a(true);
                    return false;
                }
                return false;
            }
        });
        this.f28568c = (ImageView) findViewById(R.id.control_hint);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ArcLayout, 0, 0);
            this.f28567a.a(obtainStyledAttributes.getFloat(1, 270.0f), obtainStyledAttributes.getFloat(2, 360.0f));
            this.f28567a.setChildSize(obtainStyledAttributes.getDimensionPixelSize(0, this.f28567a.getChildSize()));
            obtainStyledAttributes.recycle();
        }
    }

    public void a(boolean z) {
        ArcLayout arcLayout = this.f28567a;
        if (arcLayout != null) {
            arcLayout.b(z);
        }
    }

    public void setOnExpandListener(ArcLayout.OnExpandListener onExpandListener) {
        this.f28567a.a(onExpandListener, this.b);
    }
}
