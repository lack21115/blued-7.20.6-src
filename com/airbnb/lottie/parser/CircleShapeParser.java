package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.anythink.core.common.g.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/CircleShapeParser.class */
public class CircleShapeParser {
    private CircleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z3 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode != 3324) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                z3 = false;
                            }
                        } else if (nextName.equals("hd")) {
                            z3 = true;
                        }
                    } else if (nextName.equals("s")) {
                        z3 = true;
                    }
                } else if (nextName.equals(c.W)) {
                    z3 = true;
                }
            } else if (nextName.equals("d")) {
                z3 = true;
            }
            if (!z3) {
                str = jsonReader.nextString();
            } else if (z3) {
                animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (z3) {
                animatablePointValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (z3) {
                z2 = jsonReader.nextBoolean();
            } else if (!z3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextInt() == 3;
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z, z2);
    }
}
