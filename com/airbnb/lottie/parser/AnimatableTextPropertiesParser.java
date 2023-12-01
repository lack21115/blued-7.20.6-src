package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/AnimatableTextPropertiesParser.class */
public class AnimatableTextPropertiesParser {
    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z = true;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                z = false;
            }
            if (z) {
                jsonReader.skipValue();
            } else {
                animatableTextProperties = b(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return animatableTextProperties == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
    }

    private static AnimatableTextProperties b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            z = true;
                        }
                    } else if (nextName.equals("sc")) {
                        z = true;
                    }
                } else if (nextName.equals("fc")) {
                    z = false;
                }
            } else if (nextName.equals("t")) {
                z = true;
            }
            if (!z) {
                animatableColorValue = AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (z) {
                animatableColorValue2 = AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (z) {
                animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition);
            } else if (!z) {
                jsonReader.skipValue();
            } else {
                animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}
