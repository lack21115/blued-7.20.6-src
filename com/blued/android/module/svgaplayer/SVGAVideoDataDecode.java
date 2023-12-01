package com.blued.android.module.svgaplayer;

import android.graphics.Bitmap;
import com.blued.android.module.svgaplayer.bitmap.SVGABitmapByteArrayDecoder;
import com.blued.android.module.svgaplayer.bitmap.SVGABitmapFileDecoder;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.entities.SVGAVideoSpriteEntity;
import com.blued.android.module.svgaplayer.proto.MovieEntity;
import com.blued.android.module.svgaplayer.proto.MovieParams;
import com.blued.android.module.svgaplayer.proto.SpriteEntity;
import com.blued.android.module.svgaplayer.utils.SVGARect;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAVideoDataDecode.class */
public final class SVGAVideoDataDecode {
    public static final SVGAVideoDataDecode a;
    private static final String b;

    static {
        SVGAVideoDataDecode sVGAVideoDataDecode = new SVGAVideoDataDecode();
        a = sVGAVideoDataDecode;
        String simpleName = sVGAVideoDataDecode.getClass().getSimpleName();
        Intrinsics.c(simpleName, "this::class.java.simpleName");
        b = simpleName;
    }

    private SVGAVideoDataDecode() {
    }

    private final Bitmap a(SVGAVideoData sVGAVideoData, byte[] bArr, String str) {
        Bitmap a2 = SVGABitmapByteArrayDecoder.a.a(bArr, sVGAVideoData.k(), sVGAVideoData.j());
        Bitmap bitmap = a2;
        if (a2 == null) {
            bitmap = a(str, sVGAVideoData.k(), sVGAVideoData.j());
        }
        return bitmap;
    }

    private final Bitmap a(String str, int i, int i2) {
        return SVGABitmapFileDecoder.a.a(str, i, i2);
    }

    private final String a(File file, String str, String str2) {
        if (file == null) {
            LogUtils.a.d(b, "generateBitmapFilePath:: cacheDir is null");
            return "";
        }
        LogUtils.a.a(b, "generateBitmapFilePath:: cacheDir=" + file.getAbsolutePath() + ", imgName=" + str + ", imgKey=" + str2);
        String str3 = file.getAbsolutePath() + '/' + str;
        String str4 = str3 + ".png";
        String str5 = file.getAbsolutePath() + '/' + str2 + ".png";
        if (new File(str3).exists()) {
            return str3;
        }
        if (new File(str4).exists()) {
            return str4;
        }
        return new File(str5).exists() ? str5 : "";
    }

    private final void a(SVGAVideoData sVGAVideoData, MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        Map<String, ByteString> map = movieEntity.images;
        if (map == null || (entrySet = map.entrySet()) == null) {
            return;
        }
        for (Map.Entry<String, ByteString> entry : entrySet) {
            byte[] byteArray = entry.getValue().toByteArray();
            if (byteArray.length >= 4) {
                List<Byte> a2 = ArraysKt.a(byteArray, new IntRange(0, 3));
                if (a2.get(0).byteValue() != 73 || a2.get(1).byteValue() != 68 || a2.get(2).byteValue() != 51) {
                    SVGAVideoDataDecode sVGAVideoDataDecode = a;
                    File i = sVGAVideoData.i();
                    String utf8 = entry.getValue().utf8();
                    String key = entry.getKey();
                    Intrinsics.c(key, "entry.key");
                    Bitmap a3 = a.a(sVGAVideoData, byteArray, sVGAVideoDataDecode.a(i, utf8, key));
                    if (a3 != null) {
                        HashMap<String, Bitmap> h = sVGAVideoData.h();
                        String key2 = entry.getKey();
                        Intrinsics.c(key2, "entry.key");
                        h.put(key2, a3);
                    }
                }
            }
        }
    }

    private final void a(SVGAVideoData sVGAVideoData, MovieParams movieParams) {
        Float f = movieParams.viewBoxWidth;
        double floatValue = f != null ? f.floatValue() : 0.0f;
        Float f2 = movieParams.viewBoxHeight;
        float f3 = 0.0f;
        if (f2 != null) {
            f3 = f2.floatValue();
        }
        sVGAVideoData.a(new SVGARect(0.0d, 0.0d, floatValue, f3));
        Integer num = movieParams.fps;
        sVGAVideoData.a(num == null ? 20 : num.intValue());
        Integer num2 = movieParams.frames;
        sVGAVideoData.b(num2 == null ? 0 : num2.intValue());
    }

    private final void a(SVGAVideoData sVGAVideoData, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("viewBox");
        if (optJSONObject != null) {
            sVGAVideoData.a(new SVGARect(0.0d, 0.0d, optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d)));
        }
        sVGAVideoData.a(jSONObject.optInt("fps", 20));
        sVGAVideoData.b(jSONObject.optInt("frames", 0));
    }

    private final void b(SVGAVideoData sVGAVideoData, MovieEntity movieEntity) {
        ArrayList b2;
        List<SpriteEntity> list = movieEntity.sprites;
        if (list != null) {
            List<SpriteEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) list2, 10));
            for (SpriteEntity it : list2) {
                Intrinsics.c(it, "it");
                arrayList.add(new SVGAVideoSpriteEntity(it));
            }
            b2 = arrayList;
        } else {
            b2 = CollectionsKt.b();
        }
        sVGAVideoData.a(b2);
    }

    private final void b(SVGAVideoData sVGAVideoData, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("images");
        if (optJSONObject == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        Intrinsics.c(keys, "imgJson.keys()");
        while (keys.hasNext()) {
            String imgKey = keys.next();
            SVGAVideoDataDecode sVGAVideoDataDecode = a;
            File i = sVGAVideoData.i();
            String obj = optJSONObject.get(imgKey).toString();
            Intrinsics.c(imgKey, "imgKey");
            String a2 = sVGAVideoDataDecode.a(i, obj, imgKey);
            if (a2.length() == 0) {
                return;
            }
            String a3 = StringsKt.a(imgKey, ".matte", "", false, 4, (Object) null);
            Bitmap a4 = a.a(a2, sVGAVideoData.k(), sVGAVideoData.j());
            if (a4 != null) {
                sVGAVideoData.h().put(a3, a4);
            }
        }
    }

    private final void c(SVGAVideoData sVGAVideoData, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    Intrinsics.c(optJSONObject, "optJSONObject(i)");
                    arrayList.add(new SVGAVideoSpriteEntity(optJSONObject));
                }
            }
        }
        sVGAVideoData.a(CollectionsKt.f((Iterable) arrayList));
    }

    public final SVGAVideoData a(MovieEntity entity, File cacheDir, int i, int i2) {
        Intrinsics.e(entity, "entity");
        Intrinsics.e(cacheDir, "cacheDir");
        SVGAVideoData sVGAVideoData = new SVGAVideoData();
        sVGAVideoData.d(i);
        sVGAVideoData.c(i2);
        sVGAVideoData.a(cacheDir);
        sVGAVideoData.a(entity);
        MovieParams movieParams = entity.params;
        if (movieParams != null) {
            a.a(sVGAVideoData, movieParams);
        }
        try {
            a(sVGAVideoData, entity);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        b(sVGAVideoData, entity);
        return sVGAVideoData;
    }

    public final SVGAVideoData a(JSONObject json, File cacheDir, int i, int i2) {
        Intrinsics.e(json, "json");
        Intrinsics.e(cacheDir, "cacheDir");
        LogUtils logUtils = LogUtils.a;
        String str = b;
        logUtils.a(str, "decode:: json=" + json + ", cacheDir=" + cacheDir + ", frameWidth=" + i + ", frameHeight=" + i2);
        SVGAVideoData sVGAVideoData = new SVGAVideoData();
        sVGAVideoData.d(i);
        sVGAVideoData.c(i2);
        sVGAVideoData.a(cacheDir);
        JSONObject optJSONObject = json.optJSONObject("movie");
        if (optJSONObject == null) {
            LogUtils.a.d(b, "decode:: error no movie data ");
            return sVGAVideoData;
        }
        a(sVGAVideoData, optJSONObject);
        try {
            b(sVGAVideoData, json);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        c(sVGAVideoData, json);
        return sVGAVideoData;
    }
}
