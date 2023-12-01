package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/AnimatableValueParser.class */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return a(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue a(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(a(jsonReader, z ? Utils.a() : 1.0f, lottieComposition, FloatParser.f4400a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableGradientColorValue a(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        return new AnimatableGradientColorValue(a(jsonReader, lottieComposition, new GradientColorParser(i)));
    }

    private static <T> List<Keyframe<T>> a(JsonReader jsonReader, float f, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, f, valueParser);
    }

    private static <T> List<Keyframe<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableIntegerValue b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(a(jsonReader, lottieComposition, IntegerParser.f4402a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatablePointValue c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(a(jsonReader, Utils.a(), lottieComposition, PointFParser.f4406a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableScaleValue d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(a(jsonReader, lottieComposition, ScaleXYParser.f4407a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableShapeValue e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(a(jsonReader, Utils.a(), lottieComposition, ShapeDataParser.f4408a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableTextFrame f(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(a(jsonReader, lottieComposition, DocumentDataParser.f4399a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableColorValue g(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(a(jsonReader, lottieComposition, ColorParser.f4398a));
    }
}
