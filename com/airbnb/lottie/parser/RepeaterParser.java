package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/RepeaterParser.class */
public class RepeaterParser {
    private RepeaterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Repeater a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3324) {
                        if (hashCode != 3519) {
                            if (hashCode == 3710 && nextName.equals("tr")) {
                                z2 = true;
                            }
                        } else if (nextName.equals("nm")) {
                            z2 = false;
                        }
                    } else if (nextName.equals("hd")) {
                        z2 = true;
                    }
                } else if (nextName.equals("o")) {
                    z2 = true;
                }
            } else if (nextName.equals("c")) {
                z2 = true;
            }
            if (!z2) {
                str = jsonReader.nextString();
            } else if (z2) {
                animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            } else if (z2) {
                animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            } else if (z2) {
                animatableTransform = AnimatableTransformParser.a(jsonReader, lottieComposition);
            } else if (!z2) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z);
    }
}
