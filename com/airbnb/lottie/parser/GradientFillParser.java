package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/GradientFillParser.class */
public class GradientFillParser {
    private GradientFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static GradientFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        boolean z2;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z3 = false;
        GradientType gradientType = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 101) {
                if (nextName.equals(iu.h)) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 103) {
                if (nextName.equals("g")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 111) {
                if (nextName.equals("o")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3324) {
                if (nextName.equals("hd")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 3519) {
                switch (hashCode) {
                    case 114:
                        if (nextName.equals("r")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
            } else {
                if (nextName.equals("nm")) {
                    z = false;
                }
                z = true;
            }
            switch (z) {
                case false:
                    str = jsonReader.nextString();
                    break;
                case true:
                    jsonReader.beginObject();
                    int i = -1;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode2 = nextName2.hashCode();
                        if (hashCode2 != 107) {
                            if (hashCode2 == 112 && nextName2.equals("p")) {
                                z2 = false;
                            }
                            z2 = true;
                        } else {
                            if (nextName2.equals("k")) {
                                z2 = true;
                            }
                            z2 = true;
                        }
                        if (!z2) {
                            i = jsonReader.nextInt();
                        } else if (!z2) {
                            jsonReader.skipValue();
                        } else {
                            animatableGradientColorValue = AnimatableValueParser.a(jsonReader, lottieComposition, i);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case true:
                    animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
                    break;
                case true:
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case true:
                    animatablePointValue = AnimatableValueParser.c(jsonReader, lottieComposition);
                    break;
                case true:
                    animatablePointValue2 = AnimatableValueParser.c(jsonReader, lottieComposition);
                    break;
                case true:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case true:
                    z3 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, z3);
    }
}
