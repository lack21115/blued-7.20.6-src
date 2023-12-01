package com.blued.android.module.external_sense_library.glutils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/GlUtil.class */
public class GlUtil {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private GlUtil() {
    }

    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static int a(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(i, i2);
        GLES20.glTexParameterf(i, GL10.GL_TEXTURE_MIN_FILTER, 9729.0f);
        GLES20.glTexParameterf(i, GL10.GL_TEXTURE_MAG_FILTER, 9729.0f);
        GLES20.glTexParameterf(i, GL10.GL_TEXTURE_WRAP_S, 33071.0f);
        GLES20.glTexParameterf(i, GL10.GL_TEXTURE_WRAP_T, 33071.0f);
        b("generateTexture");
        return i2;
    }

    public static void a(int i, int i2, int[] iArr, int i3) {
        int length = iArr.length;
        if (length > 0) {
            GLES20.glGenTextures(length, iArr, 0);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return;
            }
            GLES20.glBindTexture(i3, iArr[i5]);
            GLES20.glTexParameterf(i3, GL10.GL_TEXTURE_MAG_FILTER, 9729.0f);
            GLES20.glTexParameterf(i3, GL10.GL_TEXTURE_MIN_FILTER, 9729.0f);
            GLES20.glTexParameterf(i3, GL10.GL_TEXTURE_WRAP_S, 33071.0f);
            GLES20.glTexParameterf(i3, GL10.GL_TEXTURE_WRAP_T, 33071.0f);
            GLES20.glTexImage2D(i3, 0, GL10.GL_RGBA, i, i2, 0, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, null);
            i4 = i5 + 1;
        }
    }

    public static boolean a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
            return true;
        }
        return false;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if (bArr != null && bArr.length != 0) {
            int i5 = i * i2;
            if (i5 * 4 == bArr.length) {
                int i6 = (i5 * 3) / 2;
                byte[] bArr2 = new byte[i6];
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < i2; i9++) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10;
                        if (i11 < i) {
                            int i12 = i8 + 1;
                            byte b = bArr[i8];
                            int i13 = i12 + 1;
                            byte b2 = bArr[i12];
                            byte b3 = bArr[i13];
                            int i14 = i13 + 1 + 1;
                            int i15 = b & 255;
                            int i16 = b2 & 255;
                            int i17 = b3 & 255;
                            int i18 = (((((i15 * 66) + (i16 * 129)) + (i17 * 25)) + 128) >> 8) + 16;
                            if (i18 > 255) {
                                i3 = 255;
                            } else {
                                i3 = i18;
                                if (i18 < 0) {
                                    i3 = 0;
                                }
                            }
                            bArr2[i7] = (byte) i3;
                            int i19 = i5;
                            if ((i9 & 1) == 0) {
                                i19 = i5;
                                if (((i14 >> 2) & 1) == 0) {
                                    i19 = i5;
                                    if (i5 < i6 - 2) {
                                        int i20 = (((((i15 * (-38)) - (i16 * 74)) + (i17 * 112)) + 128) >> 8) + 128;
                                        int i21 = (((((i15 * 112) - (i16 * 94)) - (i17 * 18)) + 128) >> 8) + 128;
                                        int i22 = i5 + 1;
                                        if (i21 > 255) {
                                            i4 = 255;
                                        } else {
                                            i4 = i21;
                                            if (i21 < 0) {
                                                i4 = 0;
                                            }
                                        }
                                        bArr2[i5] = (byte) i4;
                                        int i23 = i22 + 1;
                                        bArr2[i22] = (byte) (i20 > 255 ? 255 : i20 < 0 ? 0 : i20);
                                        i19 = i23;
                                    }
                                }
                            }
                            i7++;
                            i5 = i19;
                            i8 = i14;
                            i10 = i11 + 1;
                        }
                    }
                }
                return bArr2;
            }
        }
        throw new IllegalArgumentException("invalid image params!");
    }

    public static void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": GLES20 error: " + glGetError);
    }
}
