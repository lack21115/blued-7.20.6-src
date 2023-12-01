package com.opos.mobad.r.a;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import java.io.File;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/r/a/c.class */
public class c {
    public static Bitmap a(Object obj, String str) {
        Bitmap bitmap = null;
        if (obj == null) {
            return null;
        }
        Bitmap bitmap2 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (obj instanceof TextureView) {
                bitmap = ((TextureView) obj).getBitmap();
            } else if (obj instanceof SurfaceView) {
                SurfaceView surfaceView = (SurfaceView) obj;
                if (Build.VERSION.SDK_INT >= 25) {
                    bitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                    PixelCopy.request(surfaceView, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.c.1
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i) {
                        }
                    }, surfaceView.getHandler());
                } else {
                    bitmap = b(str);
                }
            }
            Bitmap bitmap3 = bitmap;
            StringBuilder sb = new StringBuilder();
            Bitmap bitmap4 = bitmap;
            sb.append("getFirstOrCurrentFrame end:");
            Bitmap bitmap5 = bitmap;
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            bitmap2 = bitmap;
            com.opos.cmn.an.f.a.b("VideoFrameUtils", sb.toString());
            return bitmap;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame fail");
            return bitmap2;
        }
    }

    public static Bitmap a(String str) {
        return a(str, true);
    }

    public static Bitmap a(String str, boolean z) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "video path = " + str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (z) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoFrameUtils", e.getStackTrace(), e);
            bitmap = null;
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return bitmap;
    }

    private static Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://127.0.0.1")) {
            return a(str);
        }
        String str2 = str;
        if (str.startsWith(ContentResolver.SCHEME_FILE)) {
            str2 = Uri.parse(str).getPath();
        }
        return c(str2);
    }

    private static Bitmap c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).exists()) {
            return a(str, false);
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "local video is null");
        return null;
    }
}
