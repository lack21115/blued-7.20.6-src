package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/TextViewWithCircularIndicator.class */
class TextViewWithCircularIndicator extends TextView {
    private static final int SELECTED_CIRCLE_ALPHA = 60;
    private int mCircleColor;
    private final Paint mCirclePaint;
    private boolean mDrawIndicator;
    private final String mItemIsSelectedText;

    public TextViewWithCircularIndicator(Context context) {
        this(context, null);
    }

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mCirclePaint = new Paint();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(13, -1);
        if (resourceId != -1) {
            setTextAppearance(context, resourceId);
        }
        this.mItemIsSelectedText = context.getResources().getString(R.string.item_is_selected);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        this.mCirclePaint.setTypeface(Typeface.create(this.mCirclePaint.getTypeface(), 1));
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setTextAlign(Paint.Align.CENTER);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        CharSequence text = getText();
        String str = text;
        if (this.mDrawIndicator) {
            str = String.format(this.mItemIsSelectedText, text);
        }
        return str;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawIndicator) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, this.mCirclePaint);
        }
    }

    public void setCircleColor(int i) {
        if (i != this.mCircleColor) {
            this.mCircleColor = i;
            this.mCirclePaint.setColor(this.mCircleColor);
            this.mCirclePaint.setAlpha(60);
            requestLayout();
        }
    }

    public void setDrawIndicator(boolean z) {
        this.mDrawIndicator = z;
    }
}
