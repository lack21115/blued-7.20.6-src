package com.anythink.expressad.video.dynview.i;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.anythink.core.common.b.n;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f5535a;

    private static Bitmap a(int i) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_4444);
            if (i == 1) {
                createBitmap.eraseColor(Color.parseColor("#FF0000"));
                return createBitmap;
            }
            createBitmap.eraseColor(Color.parseColor("#FFFFFF"));
            return createBitmap;
        } catch (Exception e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                RenderScript create = RenderScript.create(n.a().g());
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(18.0f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                create.destroy();
                return createBitmap;
            }
            return a(i);
        } catch (Throwable th) {
            return null;
        }
    }

    public static b a() {
        if (f5535a == null) {
            synchronized (b.class) {
                try {
                    if (f5535a == null) {
                        f5535a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5535a;
    }
}
