package com.blued.android.module.external_sense_library.glutils;

import android.opengl.GLES20;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/OpenGLUtils.class */
public class OpenGLUtils {
    public static int a(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        return iArr[0];
    }

    private static int a(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            return 0;
        }
        return glCreateShader;
    }

    public static int a(String str, String str2) {
        int[] iArr = new int[1];
        int a2 = a(str, (int) GLES20.GL_VERTEX_SHADER);
        if (a2 == 0) {
            Log.d("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int a3 = a(str2, (int) GLES20.GL_FRAGMENT_SHADER);
        if (a3 == 0) {
            Log.d("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(glCreateProgram, a3);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] <= 0) {
            Log.d("Load Program", "Linking Failed");
            return 0;
        }
        GLES20.glDeleteShader(a2);
        GLES20.glDeleteShader(a3);
        return glCreateProgram;
    }
}
