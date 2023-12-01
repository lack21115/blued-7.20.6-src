package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ColorParser.class */
public class ColorParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f4398a = new ColorParser();

    private ColorParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double nextDouble = jsonReader.nextDouble();
        double nextDouble2 = jsonReader.nextDouble();
        double nextDouble3 = jsonReader.nextDouble();
        double nextDouble4 = jsonReader.nextDouble();
        if (z) {
            jsonReader.endArray();
        }
        double d = nextDouble;
        double d2 = nextDouble2;
        double d3 = nextDouble3;
        double d4 = nextDouble4;
        if (nextDouble <= 1.0d) {
            d = nextDouble;
            d2 = nextDouble2;
            d3 = nextDouble3;
            d4 = nextDouble4;
            if (nextDouble2 <= 1.0d) {
                d = nextDouble;
                d2 = nextDouble2;
                d3 = nextDouble3;
                d4 = nextDouble4;
                if (nextDouble3 <= 1.0d) {
                    d = nextDouble;
                    d2 = nextDouble2;
                    d3 = nextDouble3;
                    d4 = nextDouble4;
                    if (nextDouble4 <= 1.0d) {
                        d = nextDouble * 255.0d;
                        d2 = nextDouble2 * 255.0d;
                        d3 = nextDouble3 * 255.0d;
                        d4 = nextDouble4 * 255.0d;
                    }
                }
            }
        }
        return Integer.valueOf(Color.argb((int) d4, (int) d, (int) d2, (int) d3));
    }
}
