package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.j;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/c/d.class */
public class d extends j {
    public static final String TWOINPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}";
    private int mGLAttribTextureCoord2;
    private final FloatBuffer mSecondTextureCoordsBuffer;

    public d(String str) {
        this(TWOINPUT_VERTEX_SHADER, str);
    }

    public d(String str, String str2) {
        super(str, str2);
        this.mGLAttribTextureCoord2 = -1;
        this.mSecondTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }

    @Override // com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        int i = this.mGLAttribTextureCoord2;
        if (i != -1) {
            GLES20.glDisableVertexAttribArray(i);
        }
    }

    @Override // com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i) {
        super.beforeDrawArrays(i);
        int i2 = this.mGLAttribTextureCoord2;
        if (i2 != -1) {
            GLES20.glVertexAttribPointer(i2, 2, 5126, false, 0, (Buffer) this.mSecondTextureCoordsBuffer);
            GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mGLAttribTextureCoord2 = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate2");
    }

    public void setSecondInputTexture(int i) {
        setInputTexture(j.SECOND_INPUT_SAMPLE2D_NAME, i);
    }
}
