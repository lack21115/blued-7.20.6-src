package com.igexin.push.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/l.class */
public final class l {
    public static Bitmap a(String str) {
        if (str != null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile != null) {
                    return decodeFile;
                }
                return null;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return null;
            }
        }
        return null;
    }
}
