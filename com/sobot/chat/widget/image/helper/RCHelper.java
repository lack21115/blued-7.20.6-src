package com.sobot.chat.widget.image.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.sobot.chat.R;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/image/helper/RCHelper.class */
public class RCHelper {
    public Region mAreaRegion;
    public boolean mChecked;
    public boolean mClipBackground;
    public Path mClipPath;
    public int mDefaultStrokeColor;
    public RectF mLayer;
    public OnCheckedChangeListener mOnCheckedChangeListener;
    public Paint mPaint;
    public int mStrokeColor;
    public ColorStateList mStrokeColorStateList;
    public int mStrokeWidth;
    public float[] radii = new float[8];
    public boolean mRoundAsCircle = false;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/image/helper/RCHelper$OnCheckedChangeListener.class */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(View view, boolean z);
    }

    public void drawableStateChanged(View view) {
        if (!(view instanceof RCAttrs)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof Checkable) {
            arrayList.add(16842911);
            if (((Checkable) view).isChecked()) {
                arrayList.add(16842912);
            }
        }
        if (view.isEnabled()) {
            arrayList.add(16842910);
        }
        if (view.isFocused()) {
            arrayList.add(16842908);
        }
        if (view.isPressed()) {
            arrayList.add(16842919);
        }
        if (view.isHovered()) {
            arrayList.add(16843623);
        }
        if (view.isSelected()) {
            arrayList.add(16842913);
        }
        if (view.isActivated()) {
            arrayList.add(16843518);
        }
        if (view.hasWindowFocus()) {
            arrayList.add(16842909);
        }
        ColorStateList colorStateList = this.mStrokeColorStateList;
        if (colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                ((RCAttrs) view).setStrokeColor(this.mStrokeColorStateList.getColorForState(iArr, this.mDefaultStrokeColor));
                return;
            }
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            i = i2 + 1;
        }
    }

    public void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SobotRCAttrs);
        this.mRoundAsCircle = obtainStyledAttributes.getBoolean(R.styleable.SobotRCAttrs_sobot_round_as_circle, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SobotRCAttrs_sobot_stroke_color);
        this.mStrokeColorStateList = colorStateList;
        if (colorStateList != null) {
            this.mStrokeColor = colorStateList.getDefaultColor();
            this.mDefaultStrokeColor = this.mStrokeColorStateList.getDefaultColor();
        } else {
            this.mStrokeColor = -1;
            this.mDefaultStrokeColor = -1;
        }
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_stroke_width, 0);
        this.mClipBackground = obtainStyledAttributes.getBoolean(R.styleable.SobotRCAttrs_sobot_clip_background, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_round_corner, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_round_corner_top_left, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_round_corner_top_right, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_round_corner_bottom_left, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SobotRCAttrs_sobot_round_corner_bottom_right, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.radii;
        float f = dimensionPixelSize2;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = dimensionPixelSize3;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = dimensionPixelSize5;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = dimensionPixelSize4;
        fArr[6] = f4;
        fArr[7] = f4;
        this.mLayer = new RectF();
        this.mClipPath = new Path();
        this.mAreaRegion = new Region();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
    }

    public void onClipDraw(Canvas canvas) {
        if (this.mStrokeWidth > 0) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.mPaint.setColor(-1);
            this.mPaint.setStrokeWidth(this.mStrokeWidth * 2);
            this.mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.mClipPath, this.mPaint);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.mPaint.setColor(this.mStrokeColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.mClipPath, this.mPaint);
        }
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 26) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.mClipPath, this.mPaint);
            return;
        }
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, (int) this.mLayer.width(), (int) this.mLayer.height(), Path.Direction.CW);
        path.op(this.mClipPath, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.mPaint);
    }

    public void onSizeChanged(View view, int i, int i2) {
        this.mLayer.set(0.0f, 0.0f, i, i2);
        refreshRegion(view);
    }

    public void refreshRegion(View view) {
        int width = (int) this.mLayer.width();
        int height = (int) this.mLayer.height();
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        rectF.right = width - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.mClipPath.reset();
        if (this.mRoundAsCircle) {
            float height2 = (rectF.width() >= rectF.height() ? rectF.height() : rectF.width()) / 2.0f;
            float f = width / 2;
            float f2 = height / 2;
            PointF pointF = new PointF(f, f2);
            if (Build.VERSION.SDK_INT <= 26) {
                this.mClipPath.addCircle(pointF.x, pointF.y, height2, Path.Direction.CW);
                this.mClipPath.moveTo(0.0f, 0.0f);
                this.mClipPath.moveTo(width, height);
            } else {
                float f3 = f2 - height2;
                this.mClipPath.moveTo(rectF.left, f3);
                this.mClipPath.addCircle(pointF.x, f3 + height2, height2, Path.Direction.CW);
            }
        } else {
            this.mClipPath.addRoundRect(rectF, this.radii, Path.Direction.CW);
        }
        this.mAreaRegion.setPath(this.mClipPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
