package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/IntegerParser.class */
public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntegerParser f4402a = new IntegerParser();

    private IntegerParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.b(jsonReader) * f));
    }
}
