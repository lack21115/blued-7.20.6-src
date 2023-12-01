package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ShapeStrokeParser.class */
public class ShapeStrokeParser {
    private ShapeStrokeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeStroke a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z4 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 99) {
                if (nextName.equals("c")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 100) {
                if (nextName.equals("d")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 111) {
                if (nextName.equals("o")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 119) {
                if (nextName.equals("w")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3324) {
                if (nextName.equals("hd")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3447) {
                if (nextName.equals("lc")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3454) {
                if (nextName.equals("lj")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 3487) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    z = false;
                }
                z = true;
            } else {
                if (nextName.equals("ml")) {
                    z = true;
                }
                z = true;
            }
            switch (z) {
                case false:
                    str = jsonReader.nextString();
                    break;
                case true:
                    animatableColorValue = AnimatableValueParser.g(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
                    break;
                case true:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case true:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case true:
                    f = (float) jsonReader.nextDouble();
                    break;
                case true:
                    z4 = jsonReader.nextBoolean();
                    break;
                case true:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            int hashCode2 = nextName2.hashCode();
                            if (hashCode2 != 110) {
                                if (hashCode2 == 118 && nextName2.equals("v")) {
                                    z3 = true;
                                }
                                z3 = true;
                            } else {
                                if (nextName2.equals("n")) {
                                    z3 = false;
                                }
                                z3 = true;
                            }
                            if (!z3) {
                                str2 = jsonReader.nextString();
                            } else if (!z3) {
                                jsonReader.skipValue();
                            } else {
                                animatableFloatValue3 = AnimatableValueParser.a(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.endObject();
                        int hashCode3 = str2.hashCode();
                        if (hashCode3 == 100) {
                            if (str2.equals("d")) {
                                z2 = true;
                            }
                            z2 = true;
                        } else if (hashCode3 != 103) {
                            if (hashCode3 == 111 && str2.equals("o")) {
                                z2 = false;
                            }
                            z2 = true;
                        } else {
                            if (str2.equals(iu.f)) {
                                z2 = true;
                            }
                            z2 = true;
                        }
                        if (!z2) {
                            animatableFloatValue = animatableFloatValue3;
                        } else if (z2 || z2) {
                            lottieComposition.a(true);
                            arrayList.add(animatableFloatValue3);
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeStroke(str, animatableFloatValue, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue2, lineCapType, lineJoinType, f, z4);
    }
}
