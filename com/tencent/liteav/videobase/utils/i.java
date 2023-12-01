package com.tencent.liteav.videobase.utils;

import android.opengl.GLES20;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f22969a;
    public final String b;

    public i(String str, String str2) {
        this.f22969a = str;
        this.b = str2;
    }

    public static int a(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            OpenGlUtils.checkGlError("glCompileShader");
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
