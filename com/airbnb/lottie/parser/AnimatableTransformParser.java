package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/AnimatableTransformParser.class */
public class AnimatableTransformParser {
    private AnimatableTransformParser() {
    }

    public static AnimatableTransform a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue = null;
        AnimatablePathValue animatablePathValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 97) {
                if (hashCode != 3242) {
                    if (hashCode != 3656) {
                        if (hashCode != 3662) {
                            if (hashCode != 3672) {
                                if (hashCode != 3676) {
                                    if (hashCode != 111) {
                                        if (hashCode != 112) {
                                            if (hashCode != 114) {
                                                if (hashCode == 115 && nextName.equals("s")) {
                                                    z2 = true;
                                                }
                                            } else if (nextName.equals("r")) {
                                                z2 = true;
                                            }
                                        } else if (nextName.equals("p")) {
                                            z2 = true;
                                        }
                                    } else if (nextName.equals("o")) {
                                        z2 = true;
                                    }
                                } else if (nextName.equals("so")) {
                                    z2 = true;
                                }
                            } else if (nextName.equals("sk")) {
                                z2 = true;
                            }
                        } else if (nextName.equals("sa")) {
                            z2 = true;
                        }
                    } else if (nextName.equals("rz")) {
                        z2 = true;
                    }
                } else if (nextName.equals("eo")) {
                    z2 = true;
                }
            } else if (nextName.equals("a")) {
                z2 = false;
            }
            switch (z2) {
                case false:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            animatablePathValue = AnimatablePathValueParser.a(jsonReader, lottieComposition);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case true:
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    continue;
                case true:
                    animatableScaleValue = AnimatableValueParser.d(jsonReader, lottieComposition);
                    continue;
                case true:
                    lottieComposition.a("Lottie doesn't support 3D layers.");
                    break;
                case true:
                    break;
                case true:
                    animatableIntegerValue = AnimatableValueParser.b(jsonReader, lottieComposition);
                    continue;
                case true:
                    animatableFloatValue4 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    continue;
                case true:
                    animatableFloatValue5 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    continue;
                case true:
                    animatableFloatValue2 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    continue;
                case true:
                    animatableFloatValue3 = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition, false);
            if (animatableFloatValue.c().isEmpty()) {
                animatableFloatValue.c().add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.g())));
            } else if (((Keyframe) animatableFloatValue.c().get(0)).f4418a == 0) {
                animatableFloatValue.c().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.g())));
            }
        }
        if (z) {
            jsonReader.endObject();
        }
        AnimatablePathValue animatablePathValue2 = animatablePathValue;
        if (a(animatablePathValue)) {
            animatablePathValue2 = null;
        }
        AnimatableValue<PointF, PointF> animatableValue2 = a(animatableValue) ? null : animatableValue;
        if (a(animatableFloatValue)) {
            animatableFloatValue = null;
        }
        if (a(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        if (b(animatableFloatValue2)) {
            animatableFloatValue2 = null;
        }
        if (c(animatableFloatValue3)) {
            animatableFloatValue3 = null;
        }
        return new AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, animatableFloatValue2, animatableFloatValue3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) r3.c().get(0)).f4418a).floatValue() == 0.0f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.airbnb.lottie.model.animatable.AnimatableFloatValue r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 == 0) goto L2c
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.b()
            if (r0 == 0) goto L2e
            r0 = r5
            r4 = r0
            r0 = r3
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2e
        L2c:
            r0 = 1
            r4 = r0
        L2e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.a(com.airbnb.lottie.model.animatable.AnimatableFloatValue):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (r4.c().get(0).f4418a.equals(0.0f, 0.0f) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.airbnb.lottie.model.animatable.AnimatablePathValue r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L2c
            r0 = r6
            r5 = r0
            r0 = r4
            boolean r0 = r0.b()
            if (r0 == 0) goto L2e
            r0 = r6
            r5 = r0
            r0 = r4
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            r1 = 0
            r2 = 0
            boolean r0 = r0.equals(r1, r2)
            if (r0 == 0) goto L2e
        L2c:
            r0 = 1
            r5 = r0
        L2e:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.a(com.airbnb.lottie.model.animatable.AnimatablePathValue):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (((com.airbnb.lottie.value.ScaleXY) ((com.airbnb.lottie.value.Keyframe) r4.c().get(0)).f4418a).b(1.0f, 1.0f) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.airbnb.lottie.model.animatable.AnimatableScaleValue r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L2c
            r0 = r6
            r5 = r0
            r0 = r4
            boolean r0 = r0.b()
            if (r0 == 0) goto L2e
            r0 = r6
            r5 = r0
            r0 = r4
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            com.airbnb.lottie.value.ScaleXY r0 = (com.airbnb.lottie.value.ScaleXY) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            boolean r0 = r0.b(r1, r2)
            if (r0 == 0) goto L2e
        L2c:
            r0 = 1
            r5 = r0
        L2e:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.a(com.airbnb.lottie.model.animatable.AnimatableScaleValue):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r4.c().get(0).f4418a.equals(0.0f, 0.0f) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L39
            r0 = r6
            r5 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue
            if (r0 != 0) goto L3b
            r0 = r6
            r5 = r0
            r0 = r4
            boolean r0 = r0.b()
            if (r0 == 0) goto L3b
            r0 = r6
            r5 = r0
            r0 = r4
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            r1 = 0
            r2 = 0
            boolean r0 = r0.equals(r1, r2)
            if (r0 == 0) goto L3b
        L39:
            r0 = 1
            r5 = r0
        L3b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.a(com.airbnb.lottie.model.animatable.AnimatableValue):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) r3.c().get(0)).f4418a).floatValue() == 0.0f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(com.airbnb.lottie.model.animatable.AnimatableFloatValue r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 == 0) goto L2c
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.b()
            if (r0 == 0) goto L2e
            r0 = r5
            r4 = r0
            r0 = r3
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2e
        L2c:
            r0 = 1
            r4 = r0
        L2e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.b(com.airbnb.lottie.model.animatable.AnimatableFloatValue):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) r3.c().get(0)).f4418a).floatValue() == 0.0f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(com.airbnb.lottie.model.animatable.AnimatableFloatValue r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 == 0) goto L2c
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.b()
            if (r0 == 0) goto L2e
            r0 = r5
            r4 = r0
            r0 = r3
            java.util.List r0 = r0.c()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.f4418a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2e
        L2c:
            r0 = 1
            r4 = r0
        L2e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.c(com.airbnb.lottie.model.animatable.AnimatableFloatValue):boolean");
    }
}
