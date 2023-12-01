package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.liteav.videobase.c.d;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUIllusionFilter.class */
public class TXCGPUIllusionFilter extends d {
    private static final String FRAGMENT_SHADER = "precision mediump float;  \nvarying vec2 textureCoordinate;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvoid main() {   \n\tgl_FragColor = vec4(mix(texture2D(inputImageTexture2, textureCoordinate).rgb,    texture2D(inputImageTexture, textureCoordinate).rgb, vec3(0.06,0.21,0.6)),1.0);   \n}  \n";
    private com.tencent.liteav.videobase.frame.d mPreTextureBuf;

    public TXCGPUIllusionFilter() {
        super(FRAGMENT_SHADER);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        com.tencent.liteav.videobase.frame.d dVar2 = this.mPreTextureBuf;
        if (dVar2 == null) {
            setSecondInputTexture(i);
        } else {
            setSecondInputTexture(dVar2.a());
        }
        super.onDraw(i, dVar, floatBuffer, floatBuffer2);
        com.tencent.liteav.videobase.frame.d dVar3 = this.mPreTextureBuf;
        if (dVar3 != null) {
            dVar3.release();
        }
        this.mPreTextureBuf = dVar;
        dVar.retain();
    }
}
