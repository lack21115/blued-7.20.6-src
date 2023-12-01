package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/FloatParser.class */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser a = new FloatParser();

    private FloatParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Float b(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(JsonUtils.b(jsonReader) * f);
    }
}
