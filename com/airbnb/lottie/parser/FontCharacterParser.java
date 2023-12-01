package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/FontCharacterParser.class */
class FontCharacterParser {
    private FontCharacterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static FontCharacter a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3173:
                    if (nextName.equals(RedirectReqWrapper.KEY_CHANNEL)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 109780401:
                    if (nextName.equals("style")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                c2 = jsonReader.nextString().charAt(0);
            } else if (z) {
                d = jsonReader.nextDouble();
            } else if (z) {
                d2 = jsonReader.nextDouble();
            } else if (z) {
                str = jsonReader.nextString();
            } else if (z) {
                str2 = jsonReader.nextString();
            } else if (!z) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("shapes".equals(jsonReader.nextName())) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c2, d, d2, str, str2);
    }
}
