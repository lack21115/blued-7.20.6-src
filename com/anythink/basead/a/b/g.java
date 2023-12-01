package com.anythink.basead.a.b;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/g.class */
public final class g {

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5851a;
        public int b;
    }

    private static a a(FileDescriptor fileDescriptor) {
        a aVar;
        if (fileDescriptor == null) {
            return null;
        }
        try {
            a aVar2 = new a();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fileDescriptor);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                aVar2.f5851a = Integer.parseInt(extractMetadata);
                aVar2.b = Integer.parseInt(extractMetadata2);
                return aVar2;
            } catch (Exception e) {
                aVar = aVar2;
                e = e;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e2) {
            e = e2;
            aVar = null;
        }
    }

    private static a a(FileDescriptor fileDescriptor, int i, int i2) {
        a a2 = a(fileDescriptor);
        if (a2 == null) {
            return null;
        }
        float f = (a2.f5851a * 1.0f) / a2.b;
        if (f < (i * 1.0f) / i2) {
            a2.b = i2;
            a2.f5851a = (int) Math.ceil(a2.b * f);
            return a2;
        }
        a2.f5851a = i;
        a2.b = (int) Math.ceil(a2.f5851a / f);
        return a2;
    }

    public static a a(String str) {
        a aVar;
        try {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                a aVar2 = new a();
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    mediaMetadataRetriever.release();
                    aVar2.f5851a = Integer.parseInt(extractMetadata);
                    aVar2.b = Integer.parseInt(extractMetadata2);
                    return aVar2;
                } catch (Exception e) {
                    aVar = aVar2;
                    e = e;
                    e.printStackTrace();
                    return aVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
            aVar = null;
        }
    }

    private static a a(String str, int i, int i2) {
        a a2 = a(str);
        if (a2 == null) {
            return null;
        }
        float f = (a2.f5851a * 1.0f) / a2.b;
        if (f < (i * 1.0f) / i2) {
            a2.b = i2;
            a2.f5851a = (int) (a2.b * f);
            return a2;
        }
        a2.f5851a = i;
        a2.b = (int) (a2.f5851a / f);
        return a2;
    }
}
