package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/StrokeTextView.class */
public final class StrokeTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18001a;
    private int b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.b = R.color.white;
        this.f18001a = new TextView(context, attributeSet, i);
    }

    public final void a() {
        TextView textView = this.f18001a;
        Intrinsics.a(textView);
        TextPaint paint = textView.getPaint();
        Intrinsics.c(paint, "backGroundText!!.paint");
        paint.setStrokeWidth(4.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setFakeBoldText(true);
        TextView textView2 = this.f18001a;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#ffffff"));
        }
        TextView textView3 = this.f18001a;
        if (textView3 != null) {
            textView3.setGravity(getGravity());
        }
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), getResources().getColor(this.b), getResources().getColor(R.color.white), Shader.TileMode.CLAMP));
        getPaint().setFakeBoldText(true);
    }

    public final int getColo() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        a();
        TextView textView = this.f18001a;
        Intrinsics.a(textView);
        textView.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TextView textView = this.f18001a;
        Intrinsics.a(textView);
        textView.layout(i, i2, i3, i4);
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        TextView textView = this.f18001a;
        Intrinsics.a(textView);
        CharSequence text = textView.getText();
        if (text == null || !Intrinsics.a(text, getText())) {
            TextView textView2 = this.f18001a;
            Intrinsics.a(textView2);
            textView2.setText(getText());
            postInvalidate();
        }
        TextView textView3 = this.f18001a;
        Intrinsics.a(textView3);
        textView3.measure(i, i2);
        super.onMeasure(i, i2);
    }

    public final void setColo(int i) {
        this.b = i;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        TextView textView = this.f18001a;
        Intrinsics.a(textView);
        textView.setLayoutParams(layoutParams);
        super.setLayoutParams(layoutParams);
    }
}
