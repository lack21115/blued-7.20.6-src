package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/SquareGLSurfaceView.class */
public class SquareGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private static String f15912a = SquareGLSurfaceView.class.getSimpleName();

    public SquareGLSurfaceView(Context context) {
        super(context);
    }

    public SquareGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        String str = f15912a;
        Log.i(str, "specify width mode:" + View.MeasureSpec.toString(i) + " size:" + size);
        String str2 = f15912a;
        Log.i(str2, "specify height mode:" + View.MeasureSpec.toString(i2) + " size:" + size2);
        setMeasuredDimension(size, size2);
    }
}
