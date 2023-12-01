package com.tencent.liteav.videobase.c;

import android.opengl.GLES11Ext;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/c/a.class */
public final class a extends com.tencent.liteav.videobase.a.b {
    public a() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying highp vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main()\n{\n   gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int getTarget() {
        return GLES11Ext.GL_TEXTURE_EXTERNAL_OES;
    }
}
