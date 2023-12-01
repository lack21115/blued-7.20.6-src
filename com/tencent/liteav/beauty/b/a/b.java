package com.tencent.liteav.beauty.b.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/a/b.class */
public final class b extends com.tencent.liteav.videobase.c.d {
    public b() {
        super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     highp vec3 diffColor = (iColor - meanColor) * 7.07;\n     diffColor = min(diffColor * diffColor, 1.0);\n     gl_FragColor = vec4(diffColor, 1.0);\n }\n");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        float min = Math.min(1.0f, 360.0f / Math.min(i, i2));
        super.onOutputSizeChanged(Math.round(i * min), Math.round(i2 * min));
    }
}
