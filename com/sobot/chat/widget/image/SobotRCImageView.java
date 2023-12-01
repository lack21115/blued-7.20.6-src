package com.sobot.chat.widget.image;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.ImageView;
import com.sobot.chat.widget.image.RCHelper;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/image/SobotRCImageView.class */
public class SobotRCImageView extends ImageView implements Checkable, RCAttrs {
    RCHelper mRCHelper;

    public SobotRCImageView(Context context) {
        this(context, null);
    }

    public SobotRCImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SobotRCImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RCHelper rCHelper = new RCHelper();
        this.mRCHelper = rCHelper;
        rCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 || this.mRCHelper.mAreaRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (action == 0 || action == 1) {
                refreshDrawableState();
            } else if (action == 3) {
                setPressed(false);
                refreshDrawableState();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.mRCHelper.mClipBackground) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.mRCHelper.mClipPath);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.mRCHelper.drawableStateChanged(this);
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public float getBottomLeftRadius() {
        return this.mRCHelper.radii[4];
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public float getBottomRightRadius() {
        return this.mRCHelper.radii[6];
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public int getStrokeColor() {
        return this.mRCHelper.mStrokeColor;
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public int getStrokeWidth() {
        return this.mRCHelper.mStrokeWidth;
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public float getTopLeftRadius() {
        return this.mRCHelper.radii[0];
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public float getTopRightRadius() {
        return this.mRCHelper.radii[2];
    }

    @Override // android.view.View
    public void invalidate() {
        RCHelper rCHelper = this.mRCHelper;
        if (rCHelper != null) {
            rCHelper.refreshRegion(this);
        }
        super.invalidate();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mRCHelper.mChecked;
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public boolean isClipBackground() {
        return this.mRCHelper.mClipBackground;
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public boolean isRoundAsCircle() {
        return this.mRCHelper.mRoundAsCircle;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.mRCHelper.mLayer, null, 31);
        super.onDraw(canvas);
        this.mRCHelper.onClipDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRCHelper.onSizeChanged(this, i, i2);
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setBottomLeftRadius(int i) {
        float f = i;
        this.mRCHelper.radii[6] = f;
        this.mRCHelper.radii[7] = f;
        invalidate();
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setBottomRightRadius(int i) {
        float f = i;
        this.mRCHelper.radii[4] = f;
        this.mRCHelper.radii[5] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mRCHelper.mChecked != z) {
            this.mRCHelper.mChecked = z;
            refreshDrawableState();
            if (this.mRCHelper.mOnCheckedChangeListener != null) {
                this.mRCHelper.mOnCheckedChangeListener.onCheckedChanged(this, this.mRCHelper.mChecked);
            }
        }
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setClipBackground(boolean z) {
        this.mRCHelper.mClipBackground = z;
        invalidate();
    }

    public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener onCheckedChangeListener) {
        this.mRCHelper.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setRadius(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mRCHelper.radii.length) {
                invalidate();
                return;
            } else {
                this.mRCHelper.radii[i3] = i;
                i2 = i3 + 1;
            }
        }
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setRoundAsCircle(boolean z) {
        this.mRCHelper.mRoundAsCircle = z;
        invalidate();
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setStrokeColor(int i) {
        this.mRCHelper.mStrokeColor = i;
        invalidate();
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setStrokeWidth(int i) {
        this.mRCHelper.mStrokeWidth = i;
        invalidate();
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setTopLeftRadius(int i) {
        float f = i;
        this.mRCHelper.radii[0] = f;
        this.mRCHelper.radii[1] = f;
        invalidate();
    }

    @Override // com.sobot.chat.widget.image.RCAttrs
    public void setTopRightRadius(int i) {
        float f = i;
        this.mRCHelper.radii[2] = f;
        this.mRCHelper.radii[3] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mRCHelper.mChecked);
    }
}
