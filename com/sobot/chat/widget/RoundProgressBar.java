package com.sobot.chat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/RoundProgressBar.class */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        int sp2px = ScreenUtils.sp2px(context, 14.0f);
        int dip2px = ScreenUtils.dip2px(context, 3.0f);
        this.progress = 0;
        this.roundColor = Color.parseColor("#c2bab5");
        this.roundProgressColor = -1;
        this.textColor = -1;
        this.textSize = sp2px;
        this.roundWidth = dip2px;
        this.textIsDisplayable = true;
        this.max = 100;
        this.style = 0;
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public int getMax() {
        int i;
        synchronized (this) {
            i = this.max;
        }
        return i;
    }

    public int getProgress() {
        int i;
        synchronized (this) {
            i = this.progress;
        }
        return i;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i2 = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(f, f, i2, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int i3 = (int) ((this.progress / this.max) * 100.0f);
        float measureText = this.paint.measureText(i3 + "%");
        if (this.textIsDisplayable && this.style == 0) {
            canvas.drawText(i3 + "%", f - (measureText / 2.0f), f + (this.textSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f2 = width - i2;
        float f3 = width + i2;
        RectF rectF = new RectF(f2, f2, f3, f3);
        int i4 = this.style;
        if (i4 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, 0.0f, (this.progress * 360) / this.max, false, this.paint);
        } else if (i4 != 1) {
        } else {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                canvas.drawArc(rectF, 0.0f, (i * 360) / this.max, true, this.paint);
            }
        }
    }

    public void setCricleColor(int i) {
        this.roundColor = i;
    }

    public void setCricleProgressColor(int i) {
        this.roundProgressColor = i;
    }

    public void setMax(int i) {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("max not less than 0");
            }
            this.max = i;
        }
    }

    public void setProgress(int i) {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("progress not less than 0");
            }
            int i2 = i;
            if (i > this.max) {
                i2 = this.max;
            }
            if (i2 <= this.max) {
                this.progress = i2;
                postInvalidate();
            }
        }
    }

    public void setRoundWidth(float f) {
        this.roundWidth = f;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void setTextDisplayable(boolean z) {
        this.textIsDisplayable = z;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }
}
