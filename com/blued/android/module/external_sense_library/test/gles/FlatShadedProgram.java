package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.GLES20;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/FlatShadedProgram.class */
public class FlatShadedProgram {
    private int a;
    private int b;
    private int c;
    private int d;

    public FlatShadedProgram() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        int a = GlUtil.a("uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}", "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}");
        this.a = a;
        if (a == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Grafika", "Created program " + this.a);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.a, "aPosition");
        this.d = glGetAttribLocation;
        GlUtil.b(glGetAttribLocation, "aPosition");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
        this.c = glGetUniformLocation;
        GlUtil.b(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.a, "uColor");
        this.b = glGetUniformLocation2;
        GlUtil.b(glGetUniformLocation2, "uColor");
    }
}
