package com.blued.android.module.svgaplayer.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.util.LruCache;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/cache/SVGAVideoDataCache.class */
public final class SVGAVideoDataCache {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f15986a = new Companion(null);
    private static SVGAVideoDataCache d;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, SVGAVideoData> f15987c;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/cache/SVGAVideoDataCache$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SVGAVideoDataCache a(Context context) {
            if (SVGAVideoDataCache.d == null) {
                SVGAVideoDataCache.d = new SVGAVideoDataCache(context, null);
            }
            SVGAVideoDataCache sVGAVideoDataCache = SVGAVideoDataCache.d;
            Intrinsics.a(sVGAVideoDataCache);
            return sVGAVideoDataCache;
        }
    }

    private SVGAVideoDataCache(Context context) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.c(simpleName, "this::class.java.simpleName");
        this.b = simpleName;
        float a2 = a(context) * 0.4f;
        LogUtils logUtils = LogUtils.f16034a;
        String str = this.b;
        logUtils.a(str, "cacheSize = " + a2);
        this.f15987c = new LruCache<String, SVGAVideoData>((int) a2) { // from class: com.blued.android.module.svgaplayer.cache.SVGAVideoDataCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str2, SVGAVideoData sVGAVideoData) {
                if (sVGAVideoData != null) {
                    return SizeUtilKt.a(sVGAVideoData);
                }
                return 0;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, String str2, SVGAVideoData sVGAVideoData, SVGAVideoData sVGAVideoData2) {
                LogUtils logUtils2 = LogUtils.f16034a;
                String str3 = SVGAVideoDataCache.this.b;
                logUtils2.a(str3, "entryRemoved:: evicted=" + z + ", key=" + str2);
                if (!z || sVGAVideoData == null) {
                    return;
                }
                sVGAVideoData.l();
            }
        };
    }

    public /* synthetic */ SVGAVideoDataCache(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final int a(Context context) {
        if (context == null) {
            return 1048576000;
        }
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return ((ActivityManager) systemService).getLargeMemoryClass() * 1024 * 1024;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final SVGAVideoData a(String str) {
        SVGAVideoData sVGAVideoData = this.f15987c.get(str);
        LogUtils logUtils = LogUtils.f16034a;
        String str2 = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("getVideoEntity key=");
        sb.append(str);
        sb.append(", data == null is ");
        sb.append(sVGAVideoData == null);
        logUtils.a(str2, sb.toString());
        return sVGAVideoData;
    }

    public final void a(String str, SVGAVideoData sVGAVideoData) {
        boolean z;
        LogUtils.f16034a.a(this.b, "addVideoEntityToMemory:: key=" + str);
        if (sVGAVideoData != null) {
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                    if (z || a(str) != null) {
                    }
                    this.f15987c.put(str, sVGAVideoData);
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }
    }
}
