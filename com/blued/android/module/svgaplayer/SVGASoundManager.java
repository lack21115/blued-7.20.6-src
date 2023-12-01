package com.blued.android.module.svgaplayer;

import android.media.SoundPool;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.io.FileDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGASoundManager.class */
public final class SVGASoundManager {
    public static final SVGASoundManager a = new SVGASoundManager();
    private static final String b;
    private static SoundPool c;
    private static final Map<Integer, SVGASoundCallBack> d;
    private static float e;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGASoundManager$SVGASoundCallBack.class */
    public interface SVGASoundCallBack {
    }

    static {
        String simpleName = SVGASoundManager.class.getSimpleName();
        Intrinsics.c(simpleName, "SVGASoundManager::class.java.simpleName");
        b = simpleName;
        d = new LinkedHashMap();
        e = 1.0f;
    }

    private SVGASoundManager() {
    }

    private final boolean b() {
        boolean a2 = a();
        if (!a2) {
            LogUtils.a.d(b, "soundPool is null, you need call init() !!!");
        }
        return a2;
    }

    public final int a(SVGASoundCallBack sVGASoundCallBack, FileDescriptor fileDescriptor, long j, long j2, int i) {
        if (b()) {
            SoundPool soundPool = c;
            Intrinsics.a(soundPool);
            int load = soundPool.load(fileDescriptor, j, j2, i);
            LogUtils logUtils = LogUtils.a;
            String str = b;
            logUtils.b(str, "load soundId=" + load + " callBack=" + sVGASoundCallBack);
            if (sVGASoundCallBack != null && !d.containsKey(Integer.valueOf(load))) {
                d.put(Integer.valueOf(load), sVGASoundCallBack);
            }
            return load;
        }
        return -1;
    }

    public final void a(int i) {
        if (b()) {
            LogUtils logUtils = LogUtils.a;
            String str = b;
            logUtils.b(str, "unload soundId=" + i);
            SoundPool soundPool = c;
            Intrinsics.a(soundPool);
            soundPool.unload(i);
            d.remove(Integer.valueOf(i));
        }
    }

    public final boolean a() {
        return c != null;
    }

    public final int b(int i) {
        if (b()) {
            LogUtils logUtils = LogUtils.a;
            String str = b;
            logUtils.b(str, "play soundId=" + i);
            SoundPool soundPool = c;
            Intrinsics.a(soundPool);
            float f = e;
            return soundPool.play(i, f, f, 1, 0, 1.0f);
        }
        return -1;
    }

    public final void c(int i) {
        if (b()) {
            LogUtils logUtils = LogUtils.a;
            String str = b;
            logUtils.b(str, "stop soundId=" + i);
            SoundPool soundPool = c;
            Intrinsics.a(soundPool);
            soundPool.stop(i);
        }
    }
}
