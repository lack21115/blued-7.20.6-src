package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.GLES20;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/FlatShadedProgram.class */
public class FlatShadedProgram {

    /* renamed from: a  reason: collision with root package name */
    private int f11290a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11291c;
    private int d;

    public FlatShadedProgram() {
        this.f11290a = -1;
        this.b = -1;
        this.f11291c = -1;
        this.d = -1;
        int a2 = GlUtil.a("uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}", "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}");
        this.f11290a = a2;
        if (a2 == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Grafika", "Created program " + this.f11290a);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f11290a, "aPosition");
        this.d = glGetAttribLocation;
        GlUtil.b(glGetAttribLocation, "aPosition");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f11290a, "uMVPMatrix");
        this.f11291c = glGetUniformLocation;
        GlUtil.b(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f11290a, "uColor");
        this.b = glGetUniformLocation2;
        GlUtil.b(glGetUniformLocation2, "uColor");
    }
}
