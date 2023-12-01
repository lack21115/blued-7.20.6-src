package com.blued.android.module.svgaplayer.cache;

import android.graphics.Bitmap;
import com.blued.android.module.svgaplayer.entities.SVGAAudioEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.entities.SVGAVideoShapeEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoSpriteEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoSpriteFrameEntity;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/cache/SizeUtilKt.class */
public final class SizeUtilKt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15989a = "SizeUtil";

    public static final int a(Bitmap bitmap) {
        Intrinsics.e(bitmap, "<this>");
        return bitmap.getByteCount();
    }

    public static final int a(SVGAVideoData sVGAVideoData) {
        int i;
        Intrinsics.e(sVGAVideoData, "<this>");
        Iterator<Map.Entry<String, Bitmap>> it = sVGAVideoData.h().entrySet().iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Bitmap> next = it.next();
            next.getKey();
            i2 = i + a(next.getValue());
        }
        for (SVGAVideoSpriteEntity sVGAVideoSpriteEntity : sVGAVideoData.f()) {
            i += a(sVGAVideoSpriteEntity);
        }
        for (SVGAAudioEntity sVGAAudioEntity : sVGAVideoData.g()) {
            i += a(sVGAAudioEntity.a());
        }
        return i;
    }

    public static final int a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
        Intrinsics.e(sVGAVideoShapeEntity, "<this>");
        Map<String, Object> a2 = sVGAVideoShapeEntity.a();
        int i = 0;
        int i2 = 0;
        if (a2 != null) {
            Iterator<Map.Entry<String, Object>> it = a2.entrySet().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                Object value = next.getValue();
                int a3 = i2 + a(key);
                i2 = a3;
                if (value instanceof String) {
                    i2 = a3 + a((String) value);
                }
            }
        }
        return i;
    }

    public static final int a(SVGAVideoSpriteEntity sVGAVideoSpriteEntity) {
        Intrinsics.e(sVGAVideoSpriteEntity, "<this>");
        int a2 = a(sVGAVideoSpriteEntity.a()) + 0 + a(sVGAVideoSpriteEntity.b());
        for (SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity : sVGAVideoSpriteEntity.c()) {
            Iterator<SVGAVideoShapeEntity> it = sVGAVideoSpriteFrameEntity.e().iterator();
            int i = a2;
            while (true) {
                int i2 = i;
                a2 = i2;
                if (it.hasNext()) {
                    i = i2 + a(it.next());
                }
            }
        }
        return a2;
    }

    public static final int a(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return 0;
        }
        return (str.length() * 2) + 40;
    }
}
