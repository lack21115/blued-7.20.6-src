package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.amap.api.col.p0003sl.iu;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/GradientStrokeParser.class */
public class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GradientStroke a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        ShapeStroke.LineCapType lineCapType;
        AnimatableFloatValue animatableFloatValue;
        boolean z2;
        GradientType gradientType;
        AnimatableFloatValue animatableFloatValue2;
        ShapeStroke.LineCapType lineCapType2;
        AnimatableFloatValue animatableFloatValue3;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType2 = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        ShapeStroke.LineCapType lineCapType3 = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        AnimatableFloatValue animatableFloatValue5 = null;
        boolean z4 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            AnimatableFloatValue animatableFloatValue6 = animatableFloatValue5;
            if (hashCode == 100) {
                if (nextName.equals("d")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 101) {
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
            } else if (hashCode == 119) {
                if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
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
            } else if (hashCode == 3487) {
                if (nextName.equals("ml")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 3519) {
                if (nextName.equals("nm")) {
                    z = false;
                }
                z = true;
            } else if (hashCode != 115) {
                if (hashCode == 116 && nextName.equals("t")) {
                    z = true;
                }
                z = true;
            } else {
                if (nextName.equals("s")) {
                    z = true;
                }
                z = true;
            }
            switch (z) {
                case false:
                    str = jsonReader.nextString();
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    AnimatableFloatValue animatableFloatValue7 = animatableFloatValue4;
                    lineCapType = lineCapType3;
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
                    animatableFloatValue = animatableFloatValue7;
                    animatableFloatValue5 = animatableFloatValue6;
                    lineCapType2 = lineCapType;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                    break;
                case true:
                    animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    AnimatableFloatValue animatableFloatValue8 = animatableFloatValue4;
                    ShapeStroke.LineCapType lineCapType4 = lineCapType3;
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    animatableFloatValue = animatableFloatValue8;
                    animatableFloatValue2 = animatableFloatValue6;
                    lineCapType = lineCapType4;
                    gradientType2 = gradientType;
                    animatableFloatValue6 = animatableFloatValue2;
                    animatableFloatValue5 = animatableFloatValue6;
                    lineCapType2 = lineCapType;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    animatablePointValue = AnimatableValueParser.c(jsonReader, lottieComposition);
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    animatablePointValue2 = AnimatableValueParser.c(jsonReader, lottieComposition);
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    animatableFloatValue4 = AnimatableValueParser.a(jsonReader, lottieComposition);
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    animatableFloatValue = animatableFloatValue4;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue5 = animatableFloatValue6;
                    lineCapType2 = lineCapType;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    AnimatableFloatValue animatableFloatValue9 = animatableFloatValue4;
                    lineCapType = lineCapType3;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue5 = animatableFloatValue6;
                    animatableFloatValue = animatableFloatValue9;
                    lineCapType2 = lineCapType;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    f = (float) jsonReader.nextDouble();
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    z4 = jsonReader.nextBoolean();
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                case true:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        AnimatableFloatValue animatableFloatValue10 = null;
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            int hashCode3 = nextName3.hashCode();
                            if (hashCode3 != 110) {
                                if (hashCode3 == 118 && nextName3.equals("v")) {
                                    z3 = true;
                                }
                                z3 = true;
                            } else {
                                if (nextName3.equals("n")) {
                                    z3 = false;
                                }
                                z3 = true;
                            }
                            if (!z3) {
                                str2 = jsonReader.nextString();
                            } else if (!z3) {
                                jsonReader.skipValue();
                            } else {
                                animatableFloatValue10 = AnimatableValueParser.a(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            animatableFloatValue3 = animatableFloatValue10;
                        } else {
                            if (!str2.equals("d")) {
                                animatableFloatValue3 = animatableFloatValue6;
                                if (str2.equals("g")) {
                                }
                            }
                            lottieComposition.a(true);
                            arrayList.add(animatableFloatValue10);
                        }
                        animatableFloatValue6 = animatableFloatValue3;
                    }
                    AnimatableFloatValue animatableFloatValue11 = animatableFloatValue4;
                    ShapeStroke.LineCapType lineCapType5 = lineCapType3;
                    jsonReader.endArray();
                    gradientType = gradientType2;
                    lineCapType = lineCapType5;
                    animatableFloatValue2 = animatableFloatValue6;
                    animatableFloatValue = animatableFloatValue11;
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        gradientType = gradientType2;
                        lineCapType = lineCapType5;
                        animatableFloatValue2 = animatableFloatValue6;
                        animatableFloatValue = animatableFloatValue11;
                    }
                    gradientType2 = gradientType;
                    animatableFloatValue6 = animatableFloatValue2;
                    animatableFloatValue5 = animatableFloatValue6;
                    lineCapType2 = lineCapType;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
                    break;
                default:
                    jsonReader.skipValue();
                    lineCapType2 = lineCapType3;
                    animatableFloatValue = animatableFloatValue4;
                    animatableFloatValue4 = animatableFloatValue;
                    lineCapType3 = lineCapType2;
            }
        }
        return new GradientStroke(str, gradientType2, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue4, lineCapType3, lineJoinType, f, arrayList, animatableFloatValue5, z4);
    }
}
