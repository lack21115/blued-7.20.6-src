package com.sobot.chat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.R;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/StExpandableTextView.class */
public class StExpandableTextView extends LinearLayout implements View.OnClickListener {
    private static final float DEFAULT_ANIM_ALPHA_START = 1.0f;
    private static final int DEFAULT_ANIM_DURATION = 300;
    private static final int MAX_COLLAPSED_LINES = 5;
    private static final String TAG = StExpandableTextView.class.getSimpleName();
    private boolean haveFile;
    private boolean linkBottomLine;
    private float mAnimAlphaStart;
    private boolean mAnimating;
    private int mAnimationDuration;
    protected ViewGroup mButton;
    int mCollapseStrResId;
    private boolean mCollapsed;
    private int mCollapsedHeight;
    private SparseBooleanArray mCollapsedStatus;
    int mExpandStrResId;
    protected ImageView mImageView;
    private OnExpandStateChangeListener mListener;
    private int mMarginBetweenTxtAndBottom;
    private int mMaxCollapsedLines;
    protected ViewGroup mOtherView;
    private int mPosition;
    private boolean mRelayout;
    protected TextView mTextBtn;
    private int mTextHeightWithMaxLines;
    protected TextView mTv;
    protected int otherViewHeight;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/StExpandableTextView$ExpandCollapseAnimation.class */
    class ExpandCollapseAnimation extends Animation {
        private final int mEndHeight;
        private final int mStartHeight;
        private final View mTargetView;

        public ExpandCollapseAnimation(View view, int i, int i2) {
            this.mTargetView = view;
            this.mStartHeight = i;
            this.mEndHeight = i2;
            setDuration(StExpandableTextView.this.mAnimationDuration);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            int i = this.mEndHeight;
            int i2 = this.mStartHeight;
            int i3 = (int) (((i - i2) * f) + i2);
            StExpandableTextView.this.mTv.setMaxHeight(i3 - StExpandableTextView.this.mMarginBetweenTxtAndBottom);
            if (Float.compare(StExpandableTextView.this.mAnimAlphaStart, 1.0f) != 0) {
                StExpandableTextView.applyAlphaAnimation(StExpandableTextView.this.mTv, StExpandableTextView.this.mAnimAlphaStart + (f * (1.0f - StExpandableTextView.this.mAnimAlphaStart)));
            }
            this.mTargetView.getLayoutParams().height = i3;
            this.mTargetView.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/StExpandableTextView$OnExpandStateChangeListener.class */
    public interface OnExpandStateChangeListener {
        void onExpandStateChanged(TextView textView, boolean z);
    }

    public StExpandableTextView(Context context) {
        this(context, null);
    }

    public StExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.otherViewHeight = 0;
        this.mCollapsed = true;
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyAlphaAnimation(View view, float f) {
        if (isPostHoneycomb()) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void findViews() {
        this.mTv = (TextView) findViewById(ResourceUtils.getResId(getContext(), "expandable_text"));
        this.mButton = (ViewGroup) findViewById(ResourceUtils.getResId(getContext(), "expand_collapse"));
        this.mImageView = (ImageView) findViewById(ResourceUtils.getResId(getContext(), "expand_image"));
        this.mTextBtn = (TextView) findViewById(ResourceUtils.getResId(getContext(), "expand_text_btn"));
        this.mOtherView = (ViewGroup) findViewById(ResourceUtils.getResId(getContext(), "expand_other_groupView"));
        setupExpandCollapse();
        this.mButton.setOnClickListener(this);
    }

    private static Drawable getDrawable(Context context, int i) {
        Resources resources = context.getResources();
        return isPostLolipop() ? resources.getDrawable(i, context.getTheme()) : resources.getDrawable(i);
    }

    private static int getRealTextViewHeight(TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    private void init(AttributeSet attributeSet) {
        this.mAnimationDuration = 300;
        this.mAnimAlphaStart = 1.0f;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sobot_ExpandableTextView);
        this.mMaxCollapsedLines = obtainStyledAttributes.getInt(R.styleable.sobot_ExpandableTextView_sobot_maxCollapsedLines, 5);
        this.mExpandStrResId = obtainStyledAttributes.getResourceId(R.styleable.sobot_ExpandableTextView_sobot_ExpandStrResId, ResourceUtils.getDrawableId(getContext(), "sobot_icon_triangle_down"));
        this.mCollapseStrResId = obtainStyledAttributes.getResourceId(R.styleable.sobot_ExpandableTextView_sobot_CollapseStrResId, ResourceUtils.getDrawableId(getContext(), "sobot_icon_triangle_up"));
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
        this.linkBottomLine = false;
    }

    private static boolean isPostHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static boolean isPostLolipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private void setOtherViewVisibility(int i) {
        ViewGroup viewGroup = this.mOtherView;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }

    private void setupExpandCollapse() {
        this.mImageView.setSelected(!this.mCollapsed);
        this.mImageView.setImageResource(this.mCollapsed ? this.mExpandStrResId : this.mCollapseStrResId);
        ViewGroup viewGroup = this.mOtherView;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.mCollapsed ? 8 : 0);
        }
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public CharSequence getText() {
        TextView textView = this.mTv;
        return textView == null ? "" : textView.getText();
    }

    public TextView getTextBtn() {
        return this.mTextBtn;
    }

    public ViewGroup getmOtherView() {
        return this.mOtherView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExpandCollapseAnimation expandCollapseAnimation;
        ViewGroup viewGroup;
        Tracker.onClick(view);
        if (this.mButton.getVisibility() != 0) {
            return;
        }
        this.mCollapsed = !this.mCollapsed;
        setupExpandCollapse();
        SparseBooleanArray sparseBooleanArray = this.mCollapsedStatus;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.mPosition, this.mCollapsed);
        }
        this.mAnimating = true;
        if (this.mCollapsed) {
            OnExpandStateChangeListener onExpandStateChangeListener = this.mListener;
            if (onExpandStateChangeListener != null) {
                onExpandStateChangeListener.onExpandStateChanged(this.mTv, false);
            }
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), this.mCollapsedHeight);
        } else {
            OnExpandStateChangeListener onExpandStateChangeListener2 = this.mListener;
            if (onExpandStateChangeListener2 != null) {
                onExpandStateChangeListener2.onExpandStateChanged(this.mTv, true);
            }
            if (this.otherViewHeight == 0 && (viewGroup = this.mOtherView) != null) {
                this.otherViewHeight = viewGroup.getMeasuredHeight();
            }
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), ((getHeight() + this.otherViewHeight) + this.mTextHeightWithMaxLines) - this.mTv.getHeight());
        }
        expandCollapseAnimation.setFillAfter(true);
        expandCollapseAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sobot.chat.widget.StExpandableTextView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                StExpandableTextView.this.clearAnimation();
                StExpandableTextView.this.mAnimating = false;
                if (StExpandableTextView.this.mListener != null) {
                    StExpandableTextView.this.mListener.onExpandStateChanged(StExpandableTextView.this.mTv, !StExpandableTextView.this.mCollapsed);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                StExpandableTextView.applyAlphaAnimation(StExpandableTextView.this.mTv, StExpandableTextView.this.mAnimAlphaStart);
            }
        });
        clearAnimation();
        startAnimation(expandCollapseAnimation);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViews();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mAnimating;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.mRelayout = false;
        this.mButton.setVisibility(8);
        this.mTv.setMaxLines(Integer.MAX_VALUE);
        setOtherViewVisibility(0);
        super.onMeasure(i, i2);
        if (this.mTv.getLineCount() > this.mMaxCollapsedLines || this.haveFile) {
            this.mTextHeightWithMaxLines = getRealTextViewHeight(this.mTv);
            if (this.mCollapsed) {
                this.mTv.setMaxLines(this.mMaxCollapsedLines);
                setOtherViewVisibility(8);
            }
            this.mButton.setVisibility(0);
            super.onMeasure(i, i2);
            if (this.mCollapsed) {
                this.mTv.post(new Runnable() { // from class: com.sobot.chat.widget.StExpandableTextView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StExpandableTextView stExpandableTextView = StExpandableTextView.this;
                        stExpandableTextView.mMarginBetweenTxtAndBottom = stExpandableTextView.getHeight() - StExpandableTextView.this.mTv.getHeight();
                    }
                });
                this.mCollapsedHeight = getMeasuredHeight();
            }
        }
    }

    public void setHaveFile(boolean z) {
        this.haveFile = z;
        postInvalidate();
    }

    public void setLinkBottomLine(boolean z) {
        this.linkBottomLine = z;
    }

    public void setOnExpandStateChangeListener(OnExpandStateChangeListener onExpandStateChangeListener) {
        this.mListener = onExpandStateChangeListener;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
        super.setOrientation(i);
    }

    public void setText(CharSequence charSequence) {
        this.mRelayout = true;
        if (TextUtils.isEmpty(charSequence)) {
            this.mTv.setText("");
        } else {
            HtmlTools.getInstance(getContext()).setRichText(this.mTv, charSequence.toString(), ResourceUtils.getResColorId(getContext(), "sobot_announcement_title_color_2"), this.linkBottomLine);
        }
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setText(CharSequence charSequence, SparseBooleanArray sparseBooleanArray, int i) {
        this.mCollapsedStatus = sparseBooleanArray;
        this.mPosition = i;
        boolean z = sparseBooleanArray.get(i, true);
        clearAnimation();
        this.mCollapsed = z;
        setupExpandCollapse();
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }
}
