package com.tencent.liteav.txcplayer.b;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import java.lang.reflect.Method;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22786a = c.class.getName();

    private static a a() {
        try {
            Class.forName("com.tencent.ijk.media.player.IjkDownloadCenter");
            Method method = Class.forName("com.tencent.ijk.media.player.IjkDownloadCenter").getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            return (a) method.invoke(null, new Object[0]);
        } catch (Exception e) {
            String str = f22786a;
            LiteavLog.e(str, "create IjkPlayer Downloader exception!" + e.getMessage());
            return null;
        }
    }

    public static a a(Context context) {
        a b = context != null ? b(context) : null;
        a aVar = b;
        if (b == null) {
            aVar = a();
        }
        return aVar;
    }

    private static a b(Context context) {
        try {
            Class<?> cls = Class.forName("com.tencent.liteav.thumbplayer.downloader.ThumbPlayerDownloader");
            if (context != null) {
                Method method = cls.getMethod("getInstance", Context.class);
                method.setAccessible(true);
                return (a) method.invoke(null, context);
            }
            return null;
        } catch (Exception e) {
            String str = f22786a;
            LiteavLog.e(str, "create ThumbPlayer Downloader exception!" + e.getMessage());
            return null;
        }
    }
}
