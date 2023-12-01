package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/AnimatablePathValueParser.class */
public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.a(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.a(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.b(jsonReader, Utils.a())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        z2 = true;
                    }
                } else if (nextName.equals("x")) {
                    z2 = true;
                }
            } else if (nextName.equals(iu.k)) {
                z2 = false;
            }
            if (!z2) {
                animatablePathValue = a(jsonReader, lottieComposition);
            } else if (!z2) {
                if (!z2) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                    z = true;
                } else {
                    animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition);
                }
            } else if (jsonReader.peek() == JsonToken.STRING) {
                jsonReader.skipValue();
                z = true;
            } else {
                animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
