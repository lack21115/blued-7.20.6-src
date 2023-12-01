package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.Font;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/FontParser.class */
class FontParser {
    private FontParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Font a(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        z = false;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        z = true;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        z = true;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z) {
                str = jsonReader.nextString();
            } else if (z) {
                str2 = jsonReader.nextString();
            } else if (z) {
                str3 = jsonReader.nextString();
            } else if (!z) {
                jsonReader.skipValue();
            } else {
                f = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new Font(str, str2, str3, f);
    }
}
