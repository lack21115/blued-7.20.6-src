package com.blued.android.module.common.view.scrollpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/StringScrollPicker.class */
public class StringScrollPicker extends ScrollPickerView<CharSequence> {
    private int a;
    private int b;
    private TextPaint c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Layout.Alignment j;

    public StringScrollPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StringScrollPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 24;
        this.e = 32;
        this.f = View.MEASURED_STATE_MASK;
        this.g = -7829368;
        this.h = -7829368;
        this.i = -1;
        this.j = Layout.Alignment.ALIGN_CENTER;
        TextPaint textPaint = new TextPaint(1);
        this.c = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.c.setColor(View.MEASURED_STATE_MASK);
        a(attributeSet);
        setData(new ArrayList(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")));
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StringScrollPicker);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StringScrollPicker_spv_min_text_size, this.d);
            this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StringScrollPicker_spv_max_text_size, this.e);
            this.h = obtainStyledAttributes.getColor(R.styleable.StringScrollPicker_spv_end_color, this.h);
            this.g = obtainStyledAttributes.getColor(R.styleable.StringScrollPicker_spv_centre_color, this.h);
            this.f = obtainStyledAttributes.getColor(R.styleable.StringScrollPicker_spv_start_color, this.f);
            this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StringScrollPicker_spv_max_line_width, this.i);
            int i = obtainStyledAttributes.getInt(R.styleable.StringScrollPicker_spv_alignment, 1);
            if (i == 2) {
                this.j = Layout.Alignment.ALIGN_NORMAL;
            } else if (i == 3) {
                this.j = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                this.j = Layout.Alignment.ALIGN_CENTER;
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void a(CharSequence charSequence, int i, int i2, float f) {
        float f2 = i2;
        float abs = (f2 - Math.abs(f)) / f2;
        this.c.setColor(i != -2 ? i != -1 ? i != 0 ? i != 1 ? i != 2 ? this.h : f < 0.0f ? a(this.g, this.h, abs) : this.h : f < 0.0f ? a(this.f, this.g, abs) : a(this.h, this.g, abs) : a(this.f, this.g, Math.abs(f) / f2) : f < 0.0f ? a(this.h, this.g, abs) : a(this.f, this.g, abs) : f < 0.0f ? this.h : a(this.g, this.h, abs));
    }

    public int a(int i, int i2, float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f2;
        if (f2 > 1.0f) {
            f3 = 1.0f;
        }
        return Color.argb(Math.round(Color.alpha(i) + ((Color.alpha(i2) - Color.alpha(i)) * f3)), Math.round(Color.red(i) + ((Color.red(i2) - Color.red(i)) * f3)), Math.round(Color.green(i) + ((Color.green(i2) - Color.green(i)) * f3)), Math.round(Color.blue(i) + ((Color.blue(i2) - Color.blue(i)) * f3)));
    }

    public void a(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        invalidate();
    }

    @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView
    public void a(Canvas canvas, List<CharSequence> list, int i, int i2, float f, float f2) {
        int i3;
        float itemHeight;
        float itemWidth;
        int i4;
        CharSequence charSequence = list.get(i);
        int itemSize = getItemSize();
        if (i2 == -1) {
            if (f < 0.0f) {
                this.c.setTextSize(this.d);
            } else {
                this.c.setTextSize(this.d + (((this.e - i4) * f) / itemSize));
            }
        } else if (i2 == 0) {
            TextPaint textPaint = this.c;
            int i5 = this.d;
            float f3 = i5;
            float f4 = this.e - i5;
            float f5 = itemSize;
            textPaint.setTextSize(f3 + ((f4 * (f5 - Math.abs(f))) / f5));
        } else if (i2 != 1) {
            this.c.setTextSize(this.d);
        } else if (f > 0.0f) {
            this.c.setTextSize(this.d);
        } else {
            this.c.setTextSize(this.d + (((this.e - i3) * (-f)) / itemSize));
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, 0, charSequence.length(), this.c, this.i, this.j, 1.0f, 0.0f, true, null, 0);
        float width = staticLayout.getWidth();
        if (g()) {
            itemWidth = f2 + ((getItemWidth() - width) / 2.0f);
            itemHeight = (getItemHeight() - staticLayout.getHeight()) / 2;
        } else {
            itemHeight = f2 + ((getItemHeight() - staticLayout.getHeight()) / 2);
            itemWidth = (getItemWidth() - width) / 2.0f;
        }
        a(charSequence, i2, itemSize, f);
        canvas.save();
        canvas.translate(itemWidth, itemHeight);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public Layout.Alignment getAlignment() {
        return this.j;
    }

    public int getCentreColor() {
        return this.g;
    }

    public int getEndColor() {
        return this.h;
    }

    public int getMaxLineWidth() {
        return this.i;
    }

    public int getMaxTextSize() {
        return this.e;
    }

    public int getMinTextSize() {
        return this.d;
    }

    public int getStartColor() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        if (this.i < 0) {
            this.i = getItemWidth();
        }
    }

    public void setAlignment(Layout.Alignment alignment) {
        this.j = alignment;
    }

    public void setMaxLineWidth(int i) {
        this.i = i;
    }
}
