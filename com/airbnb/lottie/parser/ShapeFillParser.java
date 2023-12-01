package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ShapeFillParser.class */
public class ShapeFillParser {
    private ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z3 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode != 3324) {
                                if (hashCode == 3519 && nextName.equals("nm")) {
                                    z3 = false;
                                }
                            } else if (nextName.equals("hd")) {
                                z3 = true;
                            }
                        } else if (nextName.equals("r")) {
                            z3 = true;
                        }
                    } else if (nextName.equals("o")) {
                        z3 = true;
                    }
                } else if (nextName.equals("c")) {
                    z3 = true;
                }
            } else if (nextName.equals("fillEnabled")) {
                z3 = true;
            }
            if (!z3) {
                str = jsonReader.nextString();
            } else if (z3) {
                animatableColorValue = AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (z3) {
                animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
            } else if (z3) {
                z = jsonReader.nextBoolean();
            } else if (z3) {
                i = jsonReader.nextInt();
            } else if (!z3) {
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
