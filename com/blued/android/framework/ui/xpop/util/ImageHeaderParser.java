package com.blued.android.framework.ui.xpop.util;

import com.blued.android.framework.ui.xpop.enums.ImageType;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/ImageHeaderParser.class */
public class ImageHeaderParser {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/ImageHeaderParser$Reader.class */
    interface Reader {
        int a() throws IOException;

        long a(long j) throws IOException;

        int b() throws IOException;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/ImageHeaderParser$StreamReader.class */
    static final class StreamReader implements Reader {
        private final InputStream a;

        StreamReader(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.blued.android.framework.ui.xpop.util.ImageHeaderParser.Reader
        public int a() throws IOException {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
        }

        @Override // com.blued.android.framework.ui.xpop.util.ImageHeaderParser.Reader
        public long a(long j) throws IOException {
            long j2;
            if (j < 0) {
                return 0L;
            }
            long j3 = j;
            while (true) {
                j2 = j3;
                if (j2 <= 0) {
                    break;
                }
                long skip = this.a.skip(j2);
                if (skip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 = j2 - skip;
            }
            return j - j2;
        }

        @Override // com.blued.android.framework.ui.xpop.util.ImageHeaderParser.Reader
        public int b() throws IOException {
            return this.a.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageType a(InputStream inputStream) throws IOException {
        StreamReader streamReader = new StreamReader(inputStream);
        int a = streamReader.a();
        if (a == 65496) {
            return ImageType.JPEG;
        }
        int a2 = ((a << 16) & (-65536)) | (streamReader.a() & 65535);
        if (a2 == -1991225785) {
            streamReader.a(21L);
            return streamReader.b() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((a2 >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            if (a2 != 1380533830) {
                return ImageType.UNKNOWN;
            }
            streamReader.a(4L);
            if ((((streamReader.a() << 16) & (-65536)) | (streamReader.a() & 65535)) != 1464156752) {
                return ImageType.UNKNOWN;
            }
            int a3 = ((streamReader.a() << 16) & (-65536)) | (streamReader.a() & 65535);
            if ((a3 & (-256)) != 1448097792) {
                return ImageType.UNKNOWN;
            }
            int i = a3 & 255;
            if (i == 88) {
                streamReader.a(4L);
                return (streamReader.b() & 16) != 0 ? ImageType.WEBP_A : ImageType.WEBP;
            } else if (i == 76) {
                streamReader.a(4L);
                return (streamReader.b() & 8) != 0 ? ImageType.WEBP_A : ImageType.WEBP;
            } else {
                inputStream.close();
                return ImageType.WEBP;
            }
        }
    }
}
