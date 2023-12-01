package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ShapePathParser.class */
public class ShapePathParser {
    private ShapePathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapePath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 3432) {
                    if (hashCode != 3519) {
                        if (hashCode == 104415 && nextName.equals("ind")) {
                            z2 = true;
                        }
                    } else if (nextName.equals("nm")) {
                        z2 = false;
                    }
                } else if (nextName.equals("ks")) {
                    z2 = true;
                }
            } else if (nextName.equals("hd")) {
                z2 = true;
            }
            if (!z2) {
                str = jsonReader.nextString();
            } else if (z2) {
                i = jsonReader.nextInt();
            } else if (z2) {
                animatableShapeValue = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (!z2) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new ShapePath(str, i, animatableShapeValue, z);
    }
}
