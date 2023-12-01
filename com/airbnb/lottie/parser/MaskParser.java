package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/MaskParser.class */
public class MaskParser {
    private MaskParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mask a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        boolean z2;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z3 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 111) {
                if (nextName.equals("o")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3588) {
                if (nextName.equals("pt")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && nextName.equals("mode")) {
                    z = false;
                }
                z = true;
            } else {
                if (nextName.equals("inv")) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                String nextString = jsonReader.nextString();
                int hashCode2 = nextString.hashCode();
                if (hashCode2 == 97) {
                    z2 = true;
                    if (nextString.equals("a")) {
                        z2 = false;
                    }
                } else if (hashCode2 == 105) {
                    z2 = true;
                    if (nextString.equals("i")) {
                        z2 = true;
                    }
                } else if (hashCode2 != 115) {
                    z2 = true;
                } else {
                    z2 = true;
                    if (nextString.equals("s")) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else if (z2) {
                    maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                } else if (!z2) {
                    Logger.b("Unknown mask mode " + nextName + ". Defaulting to Add.");
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else {
                    lottieComposition.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                }
            } else if (z) {
                animatableShapeValue = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (z) {
                animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
            } else if (!z) {
                jsonReader.skipValue();
            } else {
                z3 = jsonReader.nextBoolean();
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z3);
    }
}
