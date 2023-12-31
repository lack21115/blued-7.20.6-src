package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/APNGParser.class */
public class APNGParser {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/APNGParser$FormatException.class */
    public static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    public static List<Chunk> a(APNGReader aPNGReader) throws IOException {
        if (aPNGReader.a("\u0089PNG") && aPNGReader.a("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (aPNGReader.available() > 0) {
                arrayList.add(b(aPNGReader));
            }
            return arrayList;
        }
        throw new FormatException();
    }

    public static boolean a(Reader reader) {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            if (aPNGReader.a("\u0089PNG") && aPNGReader.a("\r\n\u001a\n")) {
                do {
                    if (aPNGReader.available() <= 0) {
                        return false;
                    }
                } while (!(b(aPNGReader) instanceof ACTLChunk));
                return true;
            }
            throw new FormatException();
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    private static Chunk b(APNGReader aPNGReader) throws IOException {
        int b = aPNGReader.b();
        int m_ = aPNGReader.m_();
        int d = aPNGReader.d();
        ACTLChunk aCTLChunk = d == ACTLChunk.a ? new ACTLChunk() : d == FCTLChunk.a ? new FCTLChunk() : d == FDATChunk.a ? new FDATChunk() : d == IDATChunk.a ? new IDATChunk() : d == IENDChunk.a ? new IENDChunk() : d == IHDRChunk.a ? new IHDRChunk() : new Chunk();
        aCTLChunk.g = b;
        aCTLChunk.e = d;
        aCTLChunk.d = m_;
        aCTLChunk.b(aPNGReader);
        aCTLChunk.f = aPNGReader.m_();
        return aCTLChunk;
    }
}
