package com.android.internal.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/SubtitleView.class */
public class SubtitleView extends View {
    private static final int COLOR_BEVEL_DARK = Integer.MIN_VALUE;
    private static final int COLOR_BEVEL_LIGHT = -2130706433;
    private static final float INNER_PADDING_RATIO = 0.125f;
    private Layout.Alignment mAlignment;
    private int mBackgroundColor;
    private final float mCornerRadius;
    private int mEdgeColor;
    private int mEdgeType;
    private int mForegroundColor;
    private boolean mHasMeasurements;
    private int mInnerPaddingX;
    private int mLastMeasuredWidth;
    private StaticLayout mLayout;
    private final RectF mLineBounds;
    private final float mOutlineWidth;
    private Paint mPaint;
    private final float mShadowOffsetX;
    private final float mShadowOffsetY;
    private final float mShadowRadius;
    private float mSpacingAdd;
    private float mSpacingMult;
    private final StringBuilder mText;
    private TextPaint mTextPaint;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubtitleView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SubtitleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mLineBounds = new RectF();
        this.mText = new StringBuilder();
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mInnerPaddingX = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextView, i, i2);
        CharSequence charSequence = "";
        int i3 = 15;
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= indexCount) {
                Resources resources = getContext().getResources();
                this.mCornerRadius = resources.getDimensionPixelSize(com.android.internal.R.dimen.subtitle_corner_radius);
                this.mOutlineWidth = resources.getDimensionPixelSize(com.android.internal.R.dimen.subtitle_outline_width);
                this.mShadowRadius = resources.getDimensionPixelSize(com.android.internal.R.dimen.subtitle_shadow_radius);
                this.mShadowOffsetX = resources.getDimensionPixelSize(com.android.internal.R.dimen.subtitle_shadow_offset);
                this.mShadowOffsetY = this.mShadowOffsetX;
                this.mTextPaint = new TextPaint();
                this.mTextPaint.setAntiAlias(true);
                this.mTextPaint.setSubpixelText(true);
                this.mPaint = new Paint();
                this.mPaint.setAntiAlias(true);
                setText(charSequence);
                setTextSize(i3);
                return;
            }
            int index = obtainStyledAttributes.getIndex(i5);
            switch (index) {
                case 0:
                    i3 = obtainStyledAttributes.getDimensionPixelSize(index, i3);
                    break;
                case 18:
                    charSequence = obtainStyledAttributes.getText(index);
                    break;
                case 53:
                    this.mSpacingAdd = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mSpacingAdd);
                    break;
                case 54:
                    this.mSpacingMult = obtainStyledAttributes.getFloat(index, this.mSpacingMult);
                    break;
            }
            i4 = i5 + 1;
        }
    }

    private boolean computeMeasurements(int i) {
        if (this.mHasMeasurements && i == this.mLastMeasuredWidth) {
            return true;
        }
        int i2 = i - ((this.mPaddingLeft + this.mPaddingRight) + (this.mInnerPaddingX * 2));
        if (i2 <= 0) {
            return false;
        }
        this.mHasMeasurements = true;
        this.mLastMeasuredWidth = i2;
        this.mLayout = new StaticLayout(this.mText, this.mTextPaint, i2, this.mAlignment, this.mSpacingMult, this.mSpacingAdd, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout = this.mLayout;
        if (staticLayout == null) {
            return;
        }
        int save = canvas.save();
        int i = this.mInnerPaddingX;
        canvas.translate(this.mPaddingLeft + i, this.mPaddingTop);
        int lineCount = staticLayout.getLineCount();
        TextPaint textPaint = this.mTextPaint;
        Paint paint = this.mPaint;
        RectF rectF = this.mLineBounds;
        if (Color.alpha(this.mBackgroundColor) > 0) {
            float f = this.mCornerRadius;
            float lineTop = staticLayout.getLineTop(0);
            paint.setColor(this.mBackgroundColor);
            paint.setStyle(Paint.Style.FILL);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= lineCount) {
                    break;
                }
                rectF.left = staticLayout.getLineLeft(i3) - i;
                rectF.right = staticLayout.getLineRight(i3) + i;
                rectF.top = lineTop;
                rectF.bottom = staticLayout.getLineBottom(i3);
                lineTop = rectF.bottom;
                canvas.drawRoundRect(rectF, f, f, paint);
                i2 = i3 + 1;
            }
        }
        int i4 = this.mEdgeType;
        if (i4 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.mOutlineWidth);
            textPaint.setColor(this.mEdgeColor);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= lineCount) {
                    break;
                }
                staticLayout.drawText(canvas, i6, i6);
                i5 = i6 + 1;
            }
        } else if (i4 == 2) {
            textPaint.setShadowLayer(this.mShadowRadius, this.mShadowOffsetX, this.mShadowOffsetY, this.mEdgeColor);
        } else if (i4 == 3 || i4 == 4) {
            boolean z = i4 == 3;
            int i7 = z ? -1 : this.mEdgeColor;
            int i8 = z ? this.mEdgeColor : -1;
            float f2 = this.mShadowRadius / 2.0f;
            textPaint.setColor(this.mForegroundColor);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setShadowLayer(this.mShadowRadius, -f2, -f2, i7);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= lineCount) {
                    break;
                }
                staticLayout.drawText(canvas, i10, i10);
                i9 = i10 + 1;
            }
            textPaint.setShadowLayer(this.mShadowRadius, f2, f2, i8);
        }
        textPaint.setColor(this.mForegroundColor);
        textPaint.setStyle(Paint.Style.FILL);
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= lineCount) {
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                canvas.restoreToCount(save);
                return;
            }
            staticLayout.drawText(canvas, i12, i12);
            i11 = i12 + 1;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        computeMeasurements(i3 - i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!computeMeasurements(View.MeasureSpec.getSize(i))) {
            setMeasuredDimension(16777216, 16777216);
            return;
        }
        StaticLayout staticLayout = this.mLayout;
        setMeasuredDimension(staticLayout.getWidth() + this.mPaddingLeft + this.mPaddingRight + (this.mInnerPaddingX * 2), staticLayout.getHeight() + this.mPaddingTop + this.mPaddingBottom);
    }

    public void setAlignment(Layout.Alignment alignment) {
        if (this.mAlignment != alignment) {
            this.mAlignment = alignment;
            this.mHasMeasurements = false;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        invalidate();
    }

    public void setEdgeColor(int i) {
        this.mEdgeColor = i;
        invalidate();
    }

    public void setEdgeType(int i) {
        this.mEdgeType = i;
        invalidate();
    }

    public void setForegroundColor(int i) {
        this.mForegroundColor = i;
        invalidate();
    }

    public void setStyle(int i) {
        CaptioningManager.CaptionStyle customStyle = i == -1 ? CaptioningManager.CaptionStyle.getCustomStyle(this.mContext.getContentResolver()) : CaptioningManager.CaptionStyle.PRESETS[i];
        CaptioningManager.CaptionStyle captionStyle = CaptioningManager.CaptionStyle.DEFAULT;
        this.mForegroundColor = customStyle.hasForegroundColor() ? customStyle.foregroundColor : captionStyle.foregroundColor;
        this.mBackgroundColor = customStyle.hasBackgroundColor() ? customStyle.backgroundColor : captionStyle.backgroundColor;
        this.mEdgeType = customStyle.hasEdgeType() ? customStyle.edgeType : captionStyle.edgeType;
        this.mEdgeColor = customStyle.hasEdgeColor() ? customStyle.edgeColor : captionStyle.edgeColor;
        this.mHasMeasurements = false;
        setTypeface(customStyle.getTypeface());
        requestLayout();
    }

    public void setText(int i) {
        setText(getContext().getText(i));
    }

    public void setText(CharSequence charSequence) {
        this.mText.setLength(0);
        this.mText.append(charSequence);
        this.mHasMeasurements = false;
        requestLayout();
        invalidate();
    }

    public void setTextSize(float f) {
        if (this.mTextPaint.getTextSize() != f) {
            this.mTextPaint.setTextSize(f);
            this.mInnerPaddingX = (int) ((INNER_PADDING_RATIO * f) + 0.5f);
            this.mHasMeasurements = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            this.mHasMeasurements = false;
            requestLayout();
            invalidate();
        }
    }
}
