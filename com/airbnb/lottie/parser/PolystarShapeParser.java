package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.anythink.core.common.b.g;
import com.anythink.core.common.g.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/PolystarShapeParser.class */
public class PolystarShapeParser {
    private PolystarShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 112) {
                if (nextName.equals(c.W)) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 114) {
                if (nextName.equals(g.o.o)) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3324) {
                if (nextName.equals("hd")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3519) {
                if (nextName.equals("nm")) {
                    z = false;
                }
                z = true;
            } else if (hashCode == 3588) {
                if (nextName.equals("pt")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3686) {
                if (nextName.equals("sy")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3369) {
                if (nextName.equals("ir")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3370) {
                if (nextName.equals("is")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 3555) {
                if (hashCode == 3556 && nextName.equals("os")) {
                    z = true;
                }
                z = true;
            } else {
                if (nextName.equals("or")) {
                    z = true;
                }
                z = true;
            }
            switch (z) {
                case false:
                    str = jsonReader.nextString();
                    break;
                case true:
                    type = PolystarShape.Type.a(jsonReader.nextInt());
                    break;
                case true:
                    animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    break;
                case true:
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    break;
                case true:
                    animatableFloatValue4 = AnimatableValueParser.a(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableFloatValue6 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    break;
                case true:
                    animatableFloatValue3 = AnimatableValueParser.a(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableFloatValue5 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    break;
                case true:
                    z2 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z2);
    }
}
