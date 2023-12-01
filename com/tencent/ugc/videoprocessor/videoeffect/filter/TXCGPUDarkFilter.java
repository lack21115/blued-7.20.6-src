package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUDarkFilter.class */
public class TXCGPUDarkFilter extends TXCGPUEffectFilterBase {
    private static final String FRAGMENT_SHADER = "precision mediump float;  \nvarying vec2 textureCoordinate;  \nuniform sampler2D inputImageTexture;  \nuniform vec2 textureSize;  \nconst mat3 xKernal = mat3(-1.0, 0.0, 1.0,  \n                          -2.0, 0.0, 2.0,  \n                          -1.0, 0.0, 1.0);  \nconst mat3 yKernal = mat3(1.0, 2.0, 1.0,  \n                          0.0, 0.0, 0.0,  \n                          -1.0, -2.0, -1.0);  \nconst vec3 LW = vec3(0.2125, 0.7154, 0.0721);  \nfloat convolution3x3(float invalue[9], mat3 kernal)  \n{  \n   float v = 0.0;  \n   v += invalue[0] * kernal[0][0];  \n   v += invalue[1] * kernal[0][1];  \n   v += invalue[2] * kernal[0][2];  \n   v += invalue[3] * kernal[1][0];  \n   v += invalue[4] * kernal[1][1];  \n   v += invalue[5] * kernal[1][2];  \n   v += invalue[6] * kernal[2][0];  \n   v += invalue[7] * kernal[2][1];  \n   v += invalue[8] * kernal[2][2];  \n   return v;  \n}  \nvoid main()  \n{  \n   float gray[9];  \n   vec2 offsets[9];  \n   offsets[0] = vec2(-1.0, 1.0);  \n   offsets[1] = vec2(0.0, 1.0);  \n   offsets[2] = vec2(1.0, 1.0);  \n   offsets[3] = vec2(-1.0, 0.0);  \n   offsets[4] = vec2(0.0, 0.0);  \n   offsets[5] = vec2(0.0, 1.0);  \n   offsets[6] = vec2(-1.0, -1.0);  \n   offsets[7] = vec2(0.0, -1.0);  \n   offsets[8] = vec2(1.0, -1.0);  \n   vec2 _step = vec2(1.0 / textureSize.x, 1.0 / textureSize.y);  \n   for (int i = 0; i < 9; ++i)  \n   {  \n       gray[i] = dot(texture2D(inputImageTexture, textureCoordinate + _step * offsets[i]).xyz, LW);  \n   }  \n   vec2 G = vec2(convolution3x3(gray, xKernal), convolution3x3(gray, yKernal));  \n   gl_FragColor = vec4(vec3(length(G)), 1.0);  \n}  \n";
    private int mSizeLocation;

    public TXCGPUDarkFilter() {
        super(b.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
        this.mSizeLocation = -1;
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mSizeLocation = GLES20.glGetUniformLocation(getProgramId(), "textureSize");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setFloatVec2OnDraw(this.mSizeLocation, new float[]{i, i2});
    }
}
