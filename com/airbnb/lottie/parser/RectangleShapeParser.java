package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/RectangleShapeParser.class */
public class RectangleShapeParser {
    private RectangleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectangleShape a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3324) {
                    if (hashCode != 3519) {
                        if (hashCode != 114) {
                            if (hashCode == 115 && nextName.equals("s")) {
                                z2 = true;
                            }
                        } else if (nextName.equals("r")) {
                            z2 = true;
                        }
                    } else if (nextName.equals("nm")) {
                        z2 = false;
                    }
                } else if (nextName.equals("hd")) {
                    z2 = true;
                }
            } else if (nextName.equals("p")) {
                z2 = true;
            }
            if (!z2) {
                str = jsonReader.nextString();
            } else if (z2) {
                animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (z2) {
                animatablePointValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (z2) {
                animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition);
            } else if (!z2) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
