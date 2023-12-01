package com.qiniu.pili.droid.shortvideo.c.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/c/a/b.class */
public class b {
    public static int a(Context context, String str, boolean z) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            Bitmap a2 = z ? a(context, str) : a(str);
            if (a2 == null) {
                e eVar = e.w;
                eVar.e("OpenGlUtils", "bitmap create error, name is : " + str);
                return 0;
            }
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, a2, 0);
            a2.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }

    public static int a(String str, int i, int i2) {
        Bitmap b = b(str, i, i2);
        if (b == null) {
            e.w.e("OpenGlUtils", "loadTextureByPath，load bitmap error, check the file path is correct!");
            return 0;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, b, 0);
        }
        if (iArr[0] == 0) {
            e.w.e("OpenGlUtils", "loadTextureByPath, the texture id is 0!");
        }
        return iArr[0];
    }

    private static Bitmap a(Context context, String str) {
        AssetManager assets = context.getResources().getAssets();
        Bitmap bitmap = null;
        try {
            InputStream open = assets.open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            bitmap = decodeStream;
            open.close();
            return decodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    private static Bitmap a(String str) {
        if (new File(str).exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return null;
    }

    public static void a(int i) {
        if (i == 0) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    private static Bitmap b(String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return BitmapFactory.decodeFile(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        e.w.c("OpenGlUtils", "loadSuitableBitmap, bitmap size = " + i3 + "x" + i4);
        int i5 = i3 / i;
        int i6 = i4 / i2;
        if (i5 >= i6) {
            i5 = i6;
        }
        if (i5 <= 0) {
            i5 = 1;
        }
        options.inSampleSize = i5;
        e.w.c("OpenGlUtils", "loadSuitableBitmap, inSampleSize = " + i5);
        return BitmapFactory.decodeFile(str, options);
    }
}
