package com.airbnb.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.amap.api.col.p0003sl.iu;
import com.anythink.core.common.g.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/LottieCompositionParser.class */
public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static LottieComposition a(JsonReader jsonReader) throws IOException {
        boolean z;
        float a = Utils.a();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals("assets")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 104:
                    if (nextName.equals(iu.g)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 118:
                    if (nextName.equals("v")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case GL10.GL_TEXTURE_2D /* 3553 */:
                    if (nextName.equals("op")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 839250809:
                    if (nextName.equals("markers")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    i = jsonReader.nextInt();
                    break;
                case true:
                    i2 = jsonReader.nextInt();
                    break;
                case true:
                    f = (float) jsonReader.nextDouble();
                    break;
                case true:
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case true:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case true:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!Utils.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    } else {
                        break;
                    }
                case true:
                    a(jsonReader, lottieComposition, arrayList, longSparseArray);
                    break;
                case true:
                    a(jsonReader, lottieComposition, hashMap, hashMap2);
                    break;
                case true:
                    a(jsonReader, hashMap3);
                    break;
                case true:
                    a(jsonReader, lottieComposition, sparseArrayCompat);
                    break;
                case true:
                    a(jsonReader, lottieComposition, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        lottieComposition.a(new Rect(0, 0, (int) (i * a), (int) (i2 * a)), f, f2, f3, arrayList, longSparseArray, hashMap, hashMap2, sparseArrayCompat, hashMap3, arrayList2);
        return lottieComposition;
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter a = FontCharacterParser.a(jsonReader, lottieComposition);
            sparseArrayCompat.put(a.hashCode(), a);
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String str = null;
            jsonReader.beginObject();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                boolean z = true;
                int hashCode = nextName.hashCode();
                if (hashCode != 3178) {
                    if (hashCode != 3214) {
                        if (hashCode == 3705 && nextName.equals("tm")) {
                            z = true;
                        }
                    } else if (nextName.equals("dr")) {
                        z = true;
                    }
                } else if (nextName.equals("cm")) {
                    z = false;
                }
                if (!z) {
                    str = jsonReader.nextString();
                } else if (z) {
                    f = (float) jsonReader.nextDouble();
                } else if (!z) {
                    jsonReader.skipValue();
                } else {
                    f2 = (float) jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            list.add(new Marker(str, f, f2));
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer a = LayerParser.a(jsonReader, lottieComposition);
            int i2 = i;
            if (a.k() == Layer.LayerType.IMAGE) {
                i2 = i + 1;
            }
            list.add(a);
            longSparseArray.put(a.e(), a);
            i = i2;
            if (i2 > 4) {
                Logger.b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                i = i2;
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                boolean z = true;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        z = false;
                                    }
                                } else if (nextName.equals("w")) {
                                    z = true;
                                }
                            } else if (nextName.equals("u")) {
                                z = true;
                            }
                        } else if (nextName.equals(c.W)) {
                            z = true;
                        }
                    } else if (nextName.equals(iu.g)) {
                        z = true;
                    }
                } else if (nextName.equals("layers")) {
                    z = true;
                }
                if (!z) {
                    str = jsonReader.nextString();
                } else if (z) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer a = LayerParser.a(jsonReader, lottieComposition);
                        longSparseArray.put(a.e(), a);
                        arrayList.add(a);
                    }
                    jsonReader.endArray();
                } else if (z) {
                    i = jsonReader.nextInt();
                } else if (z) {
                    i2 = jsonReader.nextInt();
                } else if (z) {
                    str2 = jsonReader.nextString();
                } else if (!z) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i, i2, str, str2, str3);
                map2.put(lottieImageAsset.a(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z = true;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                z = false;
            }
            if (z) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font a = FontParser.a(jsonReader);
                    map.put(a.b(), a);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }
}
