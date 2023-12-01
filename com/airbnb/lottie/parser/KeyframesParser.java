package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.value.Keyframe;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/KeyframesParser.class */
class KeyframesParser {
    private KeyframesParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z = true;
            if (nextName.hashCode() == 107 && nextName.equals(iu.k)) {
                z = false;
            }
            if (z) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(KeyframeParser.a(jsonReader, lottieComposition, f, valueParser, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.a(jsonReader, lottieComposition, f, valueParser, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.a(jsonReader, lottieComposition, f, valueParser, false));
            }
        }
        jsonReader.endObject();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends Keyframe<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe<T> keyframe = list.get(i2);
            int i3 = i2 + 1;
            Keyframe<T> keyframe2 = list.get(i3);
            keyframe.e = Float.valueOf(keyframe2.d);
            i2 = i3;
            if (keyframe.b == null) {
                i2 = i3;
                if (keyframe2.a != null) {
                    keyframe.b = keyframe2.a;
                    i2 = i3;
                    if (keyframe instanceof PathKeyframe) {
                        ((PathKeyframe) keyframe).a();
                        i2 = i3;
                    }
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i);
        if ((keyframe3.a == null || keyframe3.b == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
