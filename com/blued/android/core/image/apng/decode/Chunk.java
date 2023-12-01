package com.blued.android.core.image.apng.decode;

import android.text.TextUtils;
import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/Chunk.class */
class Chunk {
    int d;
    int e;
    int f;
    int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void a(APNGReader aPNGReader) throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(APNGReader aPNGReader) throws IOException {
        int available = aPNGReader.available();
        a(aPNGReader);
        int available2 = available - aPNGReader.available();
        int i = this.d;
        if (available2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (available2 < i) {
            aPNGReader.skip(i - available2);
        }
    }
}
