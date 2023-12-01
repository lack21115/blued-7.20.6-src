package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/MergePathsParser.class */
class MergePathsParser {
    private MergePathsParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 3488) {
                    if (hashCode == 3519 && nextName.equals("nm")) {
                        z2 = false;
                    }
                } else if (nextName.equals("mm")) {
                    z2 = true;
                }
            } else if (nextName.equals("hd")) {
                z2 = true;
            }
            if (!z2) {
                str = jsonReader.nextString();
            } else if (z2) {
                mergePathsMode = MergePaths.MergePathsMode.a(jsonReader.nextInt());
            } else if (!z2) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
