package com.tencent.liteav.txcplayer;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import java.lang.reflect.Constructor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22798a = f.class.getName();

    public static ITXVCubePlayer a(Context context) {
        return b(context);
    }

    private static ITXVCubePlayer b(Context context) {
        try {
            Constructor<?> declaredConstructor = Class.forName("com.tencent.liteav.thumbplayer.ThumbMediaPlayer").getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return (ITXVCubePlayer) declaredConstructor.newInstance(context);
        } catch (Exception e) {
            String str = f22798a;
            LiteavLog.e(str, "create thumbplayer exception: " + e.getMessage());
            return null;
        }
    }
}
