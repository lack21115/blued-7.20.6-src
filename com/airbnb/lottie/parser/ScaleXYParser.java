package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ScaleXYParser.class */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: a  reason: collision with root package name */
    public static final ScaleXYParser f4407a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public ScaleXY b(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new ScaleXY((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
