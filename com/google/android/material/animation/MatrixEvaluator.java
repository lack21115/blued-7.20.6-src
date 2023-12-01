package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/animation/MatrixEvaluator.class */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempStartValues = new float[9];
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();

    @Override // android.animation.TypeEvaluator
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 9) {
                this.tempMatrix.setValues(this.tempEndValues);
                return this.tempMatrix;
            }
            float[] fArr = this.tempEndValues;
            float f2 = fArr[i2];
            float[] fArr2 = this.tempStartValues;
            fArr[i2] = fArr2[i2] + ((f2 - fArr2[i2]) * f);
            i = i2 + 1;
        }
    }
}
