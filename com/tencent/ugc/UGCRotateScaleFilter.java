package com.tencent.ugc;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.BatteryManager;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCRotateScaleFilter.class */
public class UGCRotateScaleFilter extends com.tencent.liteav.videobase.a.b {
    private static final String TRANSFORM_FRAG_SHADER = "precision mediump float;\nvarying mediump vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float scale;\n uniform mediump float alpha;\n\nvoid main(void) {\n    gl_FragColor = vec4(texture2D(inputImageTexture, textureCoordinate).rgb, alpha); \n}\n";
    private static final String TRANSFORM_VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform mat4 transformMatrix;\n uniform mat4 orthographicMatrix;\n \n varying vec2 textureCoordinate;\n void main()\n {\n     gl_Position = transformMatrix * vec4(position.xyz, 1.0) * orthographicMatrix;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
    private int mAlphaUniform;
    private float[] mTransform3D;
    private int mTransformMatrixUniform;

    public UGCRotateScaleFilter() {
        super(TRANSFORM_VERTEX_SHADER, TRANSFORM_FRAG_SHADER);
        this.mTransformMatrixUniform = -1;
        this.mAlphaUniform = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] setRotateInternal(float[] fArr, float f) {
        float[] fArr2 = fArr;
        if (fArr == null) {
            fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
        }
        Matrix.setRotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
        this.mTransform3D = fArr2;
        GLES20.glUniformMatrix4fv(this.mTransformMatrixUniform, 1, false, fArr2, 0);
        return fArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleInternal(float[] fArr, float f) {
        float[] fArr2 = fArr;
        if (fArr == null) {
            fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
        }
        Matrix.scaleM(fArr2, 0, f, f, 1.0f);
        this.mTransform3D = fArr2;
        GLES20.glUniformMatrix4fv(this.mTransformMatrixUniform, 1, false, fArr2, 0);
    }

    private void setUniformMatrix4f(int i, float[] fArr) {
        runOnDraw(ei.a(i, fArr));
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.mTransformMatrixUniform = GLES20.glGetUniformLocation(getProgramId(), "transformMatrix");
        int glGetUniformLocation = GLES20.glGetUniformLocation(getProgramId(), "orthographicMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(getProgramId(), BatteryManager.EXTRA_SCALE);
        this.mAlphaUniform = GLES20.glGetUniformLocation(getProgramId(), "alpha");
        float[] fArr = new float[16];
        Matrix.orthoM(fArr, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
        setUniformMatrix4f(glGetUniformLocation, fArr);
        float[] fArr2 = new float[16];
        this.mTransform3D = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        setUniformMatrix4f(this.mTransformMatrixUniform, this.mTransform3D);
        setFloatOnDraw(glGetUniformLocation2, 1.0f);
        setAlpha(1.0f);
    }

    public void setAlpha(float f) {
        setFloatOnDraw(this.mAlphaUniform, f);
    }

    public void setRotate(float f) {
        runOnDraw(eg.a(this, f));
    }

    public void setRotateAndScale(float f, float f2) {
        runOnDraw(eh.a(this, f, f2));
    }
}
