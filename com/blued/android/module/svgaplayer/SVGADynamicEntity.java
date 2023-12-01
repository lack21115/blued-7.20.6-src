package com.blued.android.module.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.Window;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGADynamicEntity.class */
public final class SVGADynamicEntity {
    private HashMap<String, Boolean> a = new HashMap<>();
    private HashMap<String, Bitmap> b = new HashMap<>();
    private HashMap<String, String> c = new HashMap<>();
    private HashMap<String, TextPaint> d = new HashMap<>();
    private HashMap<String, StaticLayout> e = new HashMap<>();
    private HashMap<String, BoringLayout> f = new HashMap<>();
    private HashMap<String, Function2<Canvas, Integer, Boolean>> g = new HashMap<>();
    private HashMap<String, int[]> h = new HashMap<>();
    private HashMap<String, IClickAreaListener> i = new HashMap<>();
    private HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> j = new HashMap<>();
    private boolean k;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SVGADynamicEntity this$0, Bitmap it, String forKey) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        Intrinsics.e(forKey, "$forKey");
        this$0.a(it, forKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String url, Handler handler, final SVGADynamicEntity this$0, final String forKey) {
        InputStream inputStream;
        Intrinsics.e(url, "$url");
        Intrinsics.e(handler, "$handler");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(forKey, "$forKey");
        URLConnection openConnection = new URL(url).openConnection();
        HttpURLConnection httpURLConnection = openConnection instanceof HttpURLConnection ? (HttpURLConnection) openConnection : null;
        try {
            if (httpURLConnection == null) {
                return;
            }
            try {
                httpURLConnection.setConnectTimeout(Window.PROGRESS_SECONDARY_START);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream != null) {
                    Intrinsics.c(decodeStream, "decodeStream(stream)");
                    handler.post(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGADynamicEntity$wWeAU_YR3yGV_O2h9zyYu_-McsY
                        @Override // java.lang.Runnable
                        public final void run() {
                            SVGADynamicEntity.a(SVGADynamicEntity.this, decodeStream, forKey);
                        }
                    });
                }
                CloseableKt.a(inputStream, null);
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th) {
                }
            } finally {
            }
        } catch (Throwable th2) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    public final SVGADynamicEntity a(Bitmap bitmap, String forKey) {
        Intrinsics.e(bitmap, "bitmap");
        Intrinsics.e(forKey, "forKey");
        this.b.put(forKey, bitmap);
        return this;
    }

    public final SVGADynamicEntity a(StaticLayout layoutText, String forKey) {
        Intrinsics.e(layoutText, "layoutText");
        Intrinsics.e(forKey, "forKey");
        this.k = true;
        this.e.put(forKey, layoutText);
        return this;
    }

    public final SVGADynamicEntity a(String text, TextPaint textPaint, Layout.Alignment align, String forKey) {
        Intrinsics.e(text, "text");
        Intrinsics.e(textPaint, "textPaint");
        Intrinsics.e(align, "align");
        Intrinsics.e(forKey, "forKey");
        return a(new StaticLayout(text, 0, text.length(), textPaint, 0, align, 1.0f, 0.0f, false), forKey);
    }

    public final SVGADynamicEntity a(String text, TextPaint textPaint, String forKey) {
        Intrinsics.e(text, "text");
        Intrinsics.e(textPaint, "textPaint");
        Intrinsics.e(forKey, "forKey");
        this.k = true;
        this.c.put(forKey, text);
        this.d.put(forKey, textPaint);
        return this;
    }

    public final SVGADynamicEntity a(final String url, final String forKey) {
        Intrinsics.e(url, "url");
        Intrinsics.e(forKey, "forKey");
        final Handler handler = new Handler();
        SVGAParser.a.a().execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGADynamicEntity$vmGI_p_MdHrmA5yUX8Fvz-Q3rSg
            @Override // java.lang.Runnable
            public final void run() {
                SVGADynamicEntity.a(String.this, handler, this, forKey);
            }
        });
        return this;
    }

    public final HashMap<String, Boolean> a() {
        return this.a;
    }

    public final void a(boolean z) {
        this.k = z;
    }

    public final HashMap<String, Bitmap> b() {
        return this.b;
    }

    public final HashMap<String, String> c() {
        return this.c;
    }

    public final HashMap<String, TextPaint> d() {
        return this.d;
    }

    public final HashMap<String, StaticLayout> e() {
        return this.e;
    }

    public final HashMap<String, BoringLayout> f() {
        return this.f;
    }

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> g() {
        return this.g;
    }

    public final HashMap<String, int[]> h() {
        return this.h;
    }

    public final HashMap<String, IClickAreaListener> i() {
        return this.i;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }
}
