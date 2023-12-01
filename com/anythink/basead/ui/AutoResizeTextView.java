package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/AutoResizeTextView.class */
public class AutoResizeTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6042a = 1000;
    private static final int b = 5;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f6043c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;

    public AutoResizeTextView(Context context) {
        super(context);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    private int a(CharSequence charSequence, int i) {
        return new StaticLayout(charSequence, this.f6043c, i, Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
    }

    private void a() {
        this.f6043c = new TextPaint();
    }

    private void b() {
        int i;
        CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || TextUtils.isEmpty(text)) {
            return;
        }
        this.g = true;
        int textSize = (int) getTextSize();
        while (true) {
            i = textSize;
            if (i < 5) {
                break;
            }
            this.f6043c.setTextSize(i);
            int measureText = (int) this.f6043c.measureText(text, 0, text.length());
            int height2 = new StaticLayout(text, this.f6043c, width, Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
            if (measureText < width && height2 < height) {
                break;
            }
            textSize = i - 1;
        }
        setTextSize(0, i);
        this.g = false;
        this.f = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        if (this.g) {
            return;
        }
        if (!this.f) {
            super.onDraw(canvas);
            return;
        }
        CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || TextUtils.isEmpty(text)) {
            return;
        }
        this.g = true;
        int textSize = (int) getTextSize();
        while (true) {
            i = textSize;
            if (i < 5) {
                break;
            }
            this.f6043c.setTextSize(i);
            int measureText = (int) this.f6043c.measureText(text, 0, text.length());
            int height2 = new StaticLayout(text, this.f6043c, width, Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
            if (measureText < width && height2 < height) {
                break;
            }
            textSize = i - 1;
        }
        setTextSize(0, i);
        this.g = false;
        this.f = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.f = true;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.d = f2;
        this.e = f;
    }
}
