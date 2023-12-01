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

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10014a;

        StreamReader(InputStream inputStream) {
            this.f10014a = inputStream;
        }

        @Override // com.blued.android.framework.ui.xpop.util.ImageHeaderParser.Reader
        public int a() throws IOException {
            return ((this.f10014a.read() << 8) & 65280) | (this.f10014a.read() & 255);
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
                long skip = this.f10014a.skip(j2);
                if (skip <= 0) {
                    if (this.f10014a.read() == -1) {
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
            return this.f10014a.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageType a(InputStream inputStream) throws IOException {
        StreamReader streamReader = new StreamReader(inputStream);
        int a2 = streamReader.a();
        if (a2 == 65496) {
            return ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & (-65536)) | (streamReader.a() & 65535);
        if (a3 == -1991225785) {
            streamReader.a(21L);
            return streamReader.b() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            if (a3 != 1380533830) {
                return ImageType.UNKNOWN;
            }
            streamReader.a(4L);
            if ((((streamReader.a() << 16) & (-65536)) | (streamReader.a() & 65535)) != 1464156752) {
                return ImageType.UNKNOWN;
            }
            int a4 = ((streamReader.a() << 16) & (-65536)) | (streamReader.a() & 65535);
            if ((a4 & (-256)) != 1448097792) {
                return ImageType.UNKNOWN;
            }
            int i = a4 & 255;
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
