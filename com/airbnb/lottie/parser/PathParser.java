package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/PathParser.class */
public class PathParser implements ValueParser<PointF> {
    public static final PathParser a = new PathParser();

    private PathParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public PointF b(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.b(jsonReader, f);
    }
}
