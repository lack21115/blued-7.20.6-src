package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ValueParser.class */
interface ValueParser<V> {
    V b(JsonReader jsonReader, float f) throws IOException;
}
