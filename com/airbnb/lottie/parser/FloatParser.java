package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/FloatParser.class */
public class FloatParser implements ValueParser<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatParser f4400a = new FloatParser();

    private FloatParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Float b(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(JsonUtils.b(jsonReader) * f);
    }
}
