package com.blued.community.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/FloatFooterView.class */
public class FloatFooterView extends LinearLayout implements View.OnClickListener {
    private static final int ANIM_TIME = 450;
    private BtnAnimatorUpdateListener btnAnimatorUpdateListener;
    private int hideHeight;
    private View iconRedDot;
    private boolean isPostBtnShowed;
    private ImageView ivBtn;
    private ShapeLinearLayout mBtn;
    private Context mContext;
    private OnBtnClickListener onBtnClickListener;
    private TextView tvBtn;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/FloatFooterView$BtnAnimatorUpdateListener.class */
    public interface BtnAnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/FloatFooterView$OnBtnClickListener.class */
    public interface OnBtnClickListener {
        void onPostFeedClick();
    }

    public FloatFooterView(Context context) {
        this(context, null);
    }

    public FloatFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPostBtnShowed = true;
        this.mContext = context;
        this.hideHeight = dip2px(context, 150.0f);
        initView(attributeSet);
    }

    private static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView(AttributeSet attributeSet) {
        View.inflate(getContext(), R.layout.view_float_footer, this);
        ShapeLinearLayout findViewById = findViewById(R.id.btn);
        this.mBtn = findViewById;
        findViewById.setOnClickListener(new SingleClickProxy(this));
        this.ivBtn = (ImageView) findViewById(R.id.iv_btn);
        this.tvBtn = (TextView) findViewById(R.id.tv_btn);
        this.iconRedDot = findViewById(R.id.icon_red_dot);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.FloatFooterView);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FloatFooterView_text, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.FloatFooterView_src, 0);
            if (resourceId != 0) {
                this.tvBtn.setText(resourceId);
            }
            if (resourceId2 != 0) {
                this.ivBtn.setImageResource(resourceId2);
                this.ivBtn.setVisibility(0);
            } else {
                this.ivBtn.setVisibility(8);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void playImageButtonClickAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.7f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.FloatFooterView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatFooterView.this.mBtn.setScaleX(floatValue);
                FloatFooterView.this.mBtn.setScaleY(floatValue);
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.7f, 1.0f);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.FloatFooterView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatFooterView.this.mBtn.setScaleX(floatValue);
                FloatFooterView.this.mBtn.setScaleY(floatValue);
            }
        });
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.view.FloatFooterView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FloatFooterView.this.onBtnClickListener != null) {
                    FloatFooterView.this.onBtnClickListener.onPostFeedClick();
                }
                FloatFooterView.this.mBtn.setOnClickListener(new SingleClickProxy(FloatFooterView.this));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FloatFooterView.this.mBtn.setOnClickListener((View.OnClickListener) null);
            }
        });
        animatorSet.start();
    }

    private void startBtmBtnHideAnim() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBtn.getLayoutParams();
        if (marginLayoutParams.topMargin != this.hideHeight) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(marginLayoutParams.topMargin, this.hideHeight);
            ofInt.setDuration(450L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.FloatFooterView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FloatFooterView.this.mBtn.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, intValue, layoutParams.rightMargin, layoutParams.bottomMargin);
                    FloatFooterView.this.mBtn.setLayoutParams(layoutParams);
                    if (FloatFooterView.this.btnAnimatorUpdateListener != null) {
                        FloatFooterView.this.btnAnimatorUpdateListener.onAnimationUpdate(valueAnimator);
                    }
                }
            });
            ofInt.start();
        }
    }

    private void startBtmBtnShowAnim() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBtn.getLayoutParams();
        if (marginLayoutParams.topMargin != 0) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(marginLayoutParams.topMargin, 0);
            ofInt.setDuration(450L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.FloatFooterView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FloatFooterView.this.mBtn.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, intValue, layoutParams.rightMargin, layoutParams.bottomMargin);
                    FloatFooterView.this.mBtn.setLayoutParams(layoutParams);
                    if (FloatFooterView.this.btnAnimatorUpdateListener != null) {
                        FloatFooterView.this.btnAnimatorUpdateListener.onAnimationUpdate(valueAnimator);
                    }
                }
            });
            ofInt.start();
        }
    }

    public void hideRedDot() {
        this.iconRedDot.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.btn) {
            playImageButtonClickAnimator();
        }
    }

    public void setBtnAnimatorUpdateListener(BtnAnimatorUpdateListener btnAnimatorUpdateListener) {
        this.btnAnimatorUpdateListener = btnAnimatorUpdateListener;
    }

    public void setBtnBackgroundColor(int i) {
        ShapeHelper.b(this.mBtn, i);
        ShapeHelper.a(this.mBtn, i, i);
    }

    public void setBtnEnabled(boolean z) {
        this.mBtn.setEnabled(z);
    }

    public void setBtnIconImageDrawable(Drawable drawable) {
        this.ivBtn.setImageDrawable(drawable);
    }

    public void setBtnText(int i) {
        this.tvBtn.setText(i);
    }

    public void setBtnText(CharSequence charSequence) {
        this.tvBtn.setText(charSequence);
    }

    public void setBtnWidthAndHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.mBtn.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.mBtn.setLayoutParams(layoutParams);
    }

    public void setHideHeight(int i) {
        this.hideHeight = i;
    }

    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
    }

    public void setRedDotVisibility(boolean z) {
        this.iconRedDot.setVisibility(z ? 0 : 8);
    }

    public void showRedDot() {
        this.iconRedDot.setVisibility(0);
    }

    public void startBtmBtnHide() {
        if (this.isPostBtnShowed) {
            this.isPostBtnShowed = false;
            startBtmBtnHideAnim();
        }
    }

    public void startBtmBtnShow() {
        if (this.isPostBtnShowed) {
            return;
        }
        this.isPostBtnShowed = true;
        startBtmBtnShowAnim();
    }
}
