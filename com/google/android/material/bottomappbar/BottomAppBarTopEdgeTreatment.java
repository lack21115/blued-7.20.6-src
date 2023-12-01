package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/bottomappbar/BottomAppBarTopEdgeTreatment.class */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
        this.horizontalOffset = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4;
        float f5 = this.fabDiameter;
        if (f5 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f6 = ((this.fabMargin * 2.0f) + f5) / 2.0f;
        float f7 = f3 * this.roundedCornerRadius;
        float f8 = f2 + this.horizontalOffset;
        float f9 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f10 = this.fabCornerSize;
        float f11 = f10 * f3;
        boolean z = f10 == -1.0f || Math.abs((f10 * 2.0f) - f5) < 0.1f;
        if (z) {
            f4 = 0.0f;
        } else {
            f4 = 1.75f;
            f9 = 0.0f;
        }
        float f12 = f6 + f7;
        float f13 = f9 + f7;
        float sqrt = (float) Math.sqrt((f12 * f12) - (f13 * f13));
        float f14 = f8 - sqrt;
        float f15 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f13));
        float f16 = (90.0f - degrees) + f4;
        shapePath.lineTo(f14, 0.0f);
        float f17 = f7 * 2.0f;
        shapePath.addArc(f14 - f7, 0.0f, f14 + f7, f17, 270.0f, degrees);
        if (z) {
            shapePath.addArc(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f16, (f16 * 2.0f) - 180.0f);
        } else {
            float f18 = this.fabMargin;
            float f19 = f11 * 2.0f;
            float f20 = f8 - f6;
            shapePath.addArc(f20, -(f11 + f18), f20 + f18 + f19, f18 + f11, 180.0f - f16, ((f16 * 2.0f) - 180.0f) / 2.0f);
            float f21 = f8 + f6;
            float f22 = this.fabMargin;
            shapePath.lineTo(f21 - ((f22 / 2.0f) + f11), f22 + f11);
            float f23 = this.fabMargin;
            shapePath.addArc(f21 - (f19 + f23), -(f11 + f23), f21, f23 + f11, 90.0f, f16 - 90.0f);
        }
        shapePath.addArc(f15 - f7, 0.0f, f15 + f7, f17, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCradleVerticalOffset(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f;
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
