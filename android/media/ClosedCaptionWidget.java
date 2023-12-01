package android.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.CCParser;
import android.media.SubtitleTrack;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/media/ClosedCaptionWidget.class */
class ClosedCaptionWidget extends ViewGroup implements SubtitleTrack.RenderingWidget, CCParser.DisplayListener {
    private static final String TAG = "ClosedCaptionWidget";
    private static final String mDummyText = "1234567890123456789012345678901234";
    private CaptioningManager.CaptionStyle mCaptionStyle;
    private final CaptioningManager.CaptioningChangeListener mCaptioningListener;
    private CCLayout mClosedCaptionLayout;
    private boolean mHasChangeListener;
    private SubtitleTrack.RenderingWidget.OnChangedListener mListener;
    private final CaptioningManager mManager;
    private static final Rect mTextBounds = new Rect();
    private static final CaptioningManager.CaptionStyle DEFAULT_CAPTION_STYLE = CaptioningManager.CaptionStyle.DEFAULT;

    /* loaded from: source-9557208-dex2jar.jar:android/media/ClosedCaptionWidget$CCLayout.class */
    private static class CCLayout extends LinearLayout {
        private static final int MAX_ROWS = 15;
        private static final float SAFE_AREA_RATIO = 0.9f;
        private final CCLineBox[] mLineBoxes;

        CCLayout(Context context) {
            super(context);
            this.mLineBoxes = new CCLineBox[15];
            setGravity(8388611);
            setOrientation(1);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 15) {
                    return;
                }
                this.mLineBoxes[i2] = new CCLineBox(getContext());
                addView(this.mLineBoxes[i2], -2, -2);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7 = i3 - i;
            int i8 = i4 - i2;
            if (i7 * 3 >= i8 * 4) {
                i5 = (i8 * 4) / 3;
                i6 = i8;
            } else {
                i5 = i7;
                i6 = (i7 * 3) / 4;
            }
            int i9 = (int) (i5 * 0.9f);
            int i10 = (int) (i6 * 0.9f);
            int i11 = (i7 - i9) / 2;
            int i12 = (i8 - i10) / 2;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= 15) {
                    return;
                }
                this.mLineBoxes[i14].layout(i11, ((i10 * i14) / 15) + i12, i11 + i9, (((i14 + 1) * i10) / 15) + i12);
                i13 = i14 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth * 3 >= measuredHeight * 4) {
                measuredWidth = (measuredHeight * 4) / 3;
            } else {
                measuredHeight = (measuredWidth * 3) / 4;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((int) (measuredHeight * 0.9f)) / 15, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * 0.9f), 1073741824);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 15) {
                    return;
                }
                this.mLineBoxes[i4].measure(makeMeasureSpec2, makeMeasureSpec);
                i3 = i4 + 1;
            }
        }

        void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 15) {
                    return;
                }
                this.mLineBoxes[i2].setCaptionStyle(captionStyle);
                i = i2 + 1;
            }
        }

        void update(SpannableStringBuilder[] spannableStringBuilderArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 15) {
                    return;
                }
                if (spannableStringBuilderArr[i2] != null) {
                    this.mLineBoxes[i2].setText(spannableStringBuilderArr[i2], TextView.BufferType.SPANNABLE);
                    this.mLineBoxes[i2].setVisibility(0);
                } else {
                    this.mLineBoxes[i2].setVisibility(4);
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/ClosedCaptionWidget$CCLineBox.class */
    public static class CCLineBox extends TextView {
        private static final float EDGE_OUTLINE_RATIO = 0.1f;
        private static final float EDGE_SHADOW_RATIO = 0.05f;
        private static final float FONT_PADDING_RATIO = 0.75f;
        private int mBgColor;
        private int mEdgeColor;
        private int mEdgeType;
        private float mOutlineWidth;
        private float mShadowOffset;
        private float mShadowRadius;
        private int mTextColor;

        CCLineBox(Context context) {
            super(context);
            this.mTextColor = -1;
            this.mBgColor = -16777216;
            this.mEdgeType = 0;
            this.mEdgeColor = 0;
            setGravity(17);
            setBackgroundColor(0);
            setTextColor(-1);
            setTypeface(Typeface.MONOSPACE);
            setVisibility(4);
            Resources resources = getContext().getResources();
            this.mOutlineWidth = resources.getDimensionPixelSize(R.dimen.subtitle_outline_width);
            this.mShadowRadius = resources.getDimensionPixelSize(R.dimen.subtitle_shadow_radius);
            this.mShadowOffset = resources.getDimensionPixelSize(R.dimen.subtitle_shadow_offset);
        }

        private void drawEdgeOutline(Canvas canvas) {
            TextPaint paint = getPaint();
            Paint.Style style = paint.getStyle();
            Paint.Join strokeJoin = paint.getStrokeJoin();
            float strokeWidth = paint.getStrokeWidth();
            setTextColor(this.mEdgeColor);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(this.mOutlineWidth);
            super.onDraw(canvas);
            setTextColor(this.mTextColor);
            paint.setStyle(style);
            paint.setStrokeJoin(strokeJoin);
            paint.setStrokeWidth(strokeWidth);
            setBackgroundSpans(0);
            super.onDraw(canvas);
            setBackgroundSpans(this.mBgColor);
        }

        private void drawEdgeRaisedOrDepressed(Canvas canvas) {
            int i = -1;
            TextPaint paint = getPaint();
            Paint.Style style = paint.getStyle();
            paint.setStyle(Paint.Style.FILL);
            boolean z = this.mEdgeType == 3;
            int i2 = z ? -1 : this.mEdgeColor;
            if (z) {
                i = this.mEdgeColor;
            }
            float f = this.mShadowRadius / 2.0f;
            setShadowLayer(this.mShadowRadius, -f, -f, i2);
            super.onDraw(canvas);
            setBackgroundSpans(0);
            setShadowLayer(this.mShadowRadius, f, f, i);
            super.onDraw(canvas);
            paint.setStyle(style);
            setBackgroundSpans(this.mBgColor);
        }

        private void setBackgroundSpans(int i) {
            CharSequence text = getText();
            if (!(text instanceof Spannable)) {
                return;
            }
            Spannable spannable = (Spannable) text;
            MutableBackgroundColorSpan[] mutableBackgroundColorSpanArr = (MutableBackgroundColorSpan[]) spannable.getSpans(0, spannable.length(), MutableBackgroundColorSpan.class);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= mutableBackgroundColorSpanArr.length) {
                    return;
                }
                mutableBackgroundColorSpanArr[i3].setBackgroundColor(i);
                i2 = i3 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            if (this.mEdgeType == -1 || this.mEdgeType == 0 || this.mEdgeType == 2) {
                super.onDraw(canvas);
            } else if (this.mEdgeType == 1) {
                drawEdgeOutline(canvas);
            } else {
                drawEdgeRaisedOrDepressed(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            float size = View.MeasureSpec.getSize(i2) * 0.75f;
            setTextSize(0, size);
            this.mOutlineWidth = (0.1f * size) + 1.0f;
            this.mShadowRadius = (0.05f * size) + 1.0f;
            this.mShadowOffset = this.mShadowRadius;
            setScaleX(1.0f);
            getPaint().getTextBounds(ClosedCaptionWidget.mDummyText, 0, ClosedCaptionWidget.mDummyText.length(), ClosedCaptionWidget.mTextBounds);
            setScaleX(View.MeasureSpec.getSize(i) / ClosedCaptionWidget.mTextBounds.width());
            super.onMeasure(i, i2);
        }

        void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
            this.mTextColor = captionStyle.foregroundColor;
            this.mBgColor = captionStyle.backgroundColor;
            this.mEdgeType = captionStyle.edgeType;
            this.mEdgeColor = captionStyle.edgeColor;
            setTextColor(this.mTextColor);
            if (this.mEdgeType == 2) {
                setShadowLayer(this.mShadowRadius, this.mShadowOffset, this.mShadowOffset, this.mEdgeColor);
            } else {
                setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            invalidate();
        }
    }

    public ClosedCaptionWidget(Context context) {
        this(context, null);
    }

    public ClosedCaptionWidget(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public ClosedCaptionWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCaptioningListener = new CaptioningManager.CaptioningChangeListener() { // from class: android.media.ClosedCaptionWidget.1
            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onUserStyleChanged(CaptioningManager.CaptionStyle captionStyle) {
                ClosedCaptionWidget.this.mCaptionStyle = ClosedCaptionWidget.DEFAULT_CAPTION_STYLE.applyStyle(captionStyle);
                ClosedCaptionWidget.this.mClosedCaptionLayout.setCaptionStyle(ClosedCaptionWidget.this.mCaptionStyle);
            }
        };
        setLayerType(1, null);
        this.mManager = (CaptioningManager) context.getSystemService(Context.CAPTIONING_SERVICE);
        this.mCaptionStyle = DEFAULT_CAPTION_STYLE.applyStyle(this.mManager.getUserStyle());
        this.mClosedCaptionLayout = new CCLayout(context);
        this.mClosedCaptionLayout.setCaptionStyle(this.mCaptionStyle);
        addView(this.mClosedCaptionLayout, -1, -1);
        requestLayout();
    }

    private void manageChangeListener() {
        boolean z = isAttachedToWindow() && getVisibility() == 0;
        if (this.mHasChangeListener != z) {
            this.mHasChangeListener = z;
            if (z) {
                this.mManager.addCaptioningChangeListener(this.mCaptioningListener);
            } else {
                this.mManager.removeCaptioningChangeListener(this.mCaptioningListener);
            }
        }
    }

    @Override // android.media.CCParser.DisplayListener
    public CaptioningManager.CaptionStyle getCaptionStyle() {
        return this.mCaptionStyle;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        manageChangeListener();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        manageChangeListener();
    }

    @Override // android.media.CCParser.DisplayListener
    public void onDisplayChanged(SpannableStringBuilder[] spannableStringBuilderArr) {
        this.mClosedCaptionLayout.update(spannableStringBuilderArr);
        if (this.mListener != null) {
            this.mListener.onChanged(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mClosedCaptionLayout.layout(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mClosedCaptionLayout.measure(i, i2);
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setOnChangedListener(SubtitleTrack.RenderingWidget.OnChangedListener onChangedListener) {
        this.mListener = onChangedListener;
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setSize(int i, int i2) {
        measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        layout(0, 0, i, i2);
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setVisible(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        manageChangeListener();
    }
}
