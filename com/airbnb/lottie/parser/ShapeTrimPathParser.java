package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ShapeTrimPathParser.class */
public class ShapeTrimPathParser {
    private ShapeTrimPathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 101) {
                if (nextName.equals(iu.h)) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 109) {
                if (nextName.equals("m")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 111) {
                if (nextName.equals("o")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 115) {
                if (nextName.equals("s")) {
                    z = false;
                }
                z = true;
            } else if (hashCode != 3324) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    z = true;
                }
                z = true;
            } else {
                if (nextName.equals("hd")) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            } else if (z) {
                animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            } else if (z) {
                animatableFloatValue3 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            } else if (z) {
                str = jsonReader.nextString();
            } else if (z) {
                type = ShapeTrimPath.Type.a(jsonReader.nextInt());
            } else if (!z) {
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z2);
    }
}
