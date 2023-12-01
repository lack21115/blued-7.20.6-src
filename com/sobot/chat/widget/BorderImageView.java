package com.sobot.chat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/BorderImageView.class */
public class BorderImageView extends ImageView {
    private int color;

    public BorderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.color = Color.parseColor("#dcdcdc");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect clipBounds = canvas.getClipBounds();
        Paint paint = new Paint();
        paint.setColor(this.color);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(clipBounds, paint);
    }
}
