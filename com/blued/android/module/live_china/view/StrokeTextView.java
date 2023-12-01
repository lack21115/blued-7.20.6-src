package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Field;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/StrokeTextView.class */
public class StrokeTextView extends AppCompatTextView {
    public StrokeTextView(Context context) {
        super(context);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setTextColorUseReflection(int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCurTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i));
            declaredField.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        getPaint().setColor(i);
    }

    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        setTextColorUseReflection(-1);
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setFakeBoldText(true);
        paint.setShadowLayer(1.0f, 0.0f, 0.0f, 0);
        super.onDraw(canvas);
        setTextColorUseReflection(Color.parseColor("#ffd542"));
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setFakeBoldText(false);
        paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        super.onDraw(canvas);
    }
}
