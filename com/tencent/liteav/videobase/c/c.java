package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/c/c.class */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final FloatBuffer f36611a;
    private int b;

    public c(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
    }

    public c(String str, String str2) {
        super(str, str2);
        this.f36611a = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        int i = this.b;
        if (i != -1) {
            GLES20.glDisableVertexAttribArray(i);
        }
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i) {
        super.beforeDrawArrays(i);
        int i2 = this.b;
        if (i2 != -1) {
            GLES20.glVertexAttribPointer(i2, 2, 5126, false, 0, (Buffer) this.f36611a);
            GLES20.glEnableVertexAttribArray(this.b);
        }
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(null);
        this.b = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate3");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
    }
}
