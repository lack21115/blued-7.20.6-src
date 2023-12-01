package com.qiniu.pili.droid.shortvideo.f;

import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/g.class */
public class g {

    /* renamed from: com.qiniu.pili.droid.shortvideo.f.g$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/g$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13988a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PLVideoEncodeSetting.ProfileMode.values().length];
            f13988a = iArr;
            try {
                iArr[PLVideoEncodeSetting.ProfileMode.BASELINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13988a[PLVideoEncodeSetting.ProfileMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13988a[PLVideoEncodeSetting.ProfileMode.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static int a(MediaExtractor mediaExtractor, String str) {
        if (mediaExtractor == null || str == null) {
            e.w.e("MediaUtils", "find track error : extractor or mimeType can't be null!");
            return -1;
        }
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return -1;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString(MediaFormat.KEY_MIME);
            if (string.startsWith(str)) {
                e eVar = e.w;
                eVar.c("MediaUtils", "Extractor found track " + i2 + " (" + string + "): " + trackFormat);
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static int a(PLVideoEncodeSetting.ProfileMode profileMode) {
        int i = AnonymousClass1.f13988a[profileMode.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return 1;
                }
                i2 = 8;
            }
            return i2;
        }
        return 1;
    }

    public static long a(Object obj) {
        String a2 = a(obj, 9);
        if (a2 == null) {
            return 0L;
        }
        return Long.parseLong(a2);
    }

    public static MediaExtractor a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            e.w.e("MediaUtils", "create media extractor failed, assetFileDescriptor can't be null !");
            return null;
        }
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            if (assetFileDescriptor.getDeclaredLength() < 0) {
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor());
            } else {
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
            }
            return mediaExtractor;
        } catch (IOException e) {
            e eVar = e.w;
            eVar.e("MediaUtils", "create media extractor failed, setDataSource error : " + e.getMessage());
            return null;
        }
    }

    public static MediaExtractor a(String str) {
        if (str == null) {
            e.w.e("MediaUtils", "create media extractor failed, path can't be null !");
            return null;
        }
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            return mediaExtractor;
        } catch (IOException e) {
            e eVar = e.w;
            eVar.e("MediaUtils", "create media extractor failed, setDataSource error : " + e.getMessage());
            return null;
        }
    }

    public static MediaFormat a(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            e.w.e("MediaUtils", "select audio track failed, mediaExtractor can't be null !");
            return null;
        }
        int a2 = a(mediaExtractor, "audio/");
        if (a2 < 0) {
            e.w.e("MediaUtils", "select audio track failed, can't find audio track!");
            return null;
        }
        mediaExtractor.selectTrack(a2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(a2);
        e eVar = e.w;
        eVar.c("MediaUtils", "select audio track and get audio media format: " + trackFormat);
        return trackFormat;
    }

    public static PLVideoEncodeSetting.ProfileMode a(int i) {
        return i != 1 ? i != 2 ? i != 8 ? PLVideoEncodeSetting.ProfileMode.BASELINE : PLVideoEncodeSetting.ProfileMode.HIGH : PLVideoEncodeSetting.ProfileMode.MAIN : PLVideoEncodeSetting.ProfileMode.BASELINE;
    }

    private static String a(Object obj, int i) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (obj instanceof String) {
                mediaMetadataRetriever.setDataSource((String) obj);
            } else if (!(obj instanceof AssetFileDescriptor)) {
                e eVar = e.w;
                eVar.e("MediaUtils", "class of path is invalid: " + obj.getClass().getName() + ", only accept String or AssetFileDescriptor");
                return null;
            } else {
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            return mediaMetadataRetriever.extractMetadata(i);
        } catch (Exception e) {
            e eVar2 = e.w;
            eVar2.e("MediaUtils", "path not exist: " + obj);
            return null;
        }
    }

    public static int b(int i) {
        if (i % 16 != 0) {
            int i2 = ((i / 16) + 1) * 16;
            e eVar = e.h;
            eVar.d("MediaUtils", "num: " + i + " not multiple of 16, resize to: " + i2);
            return i2;
        }
        return i;
    }

    public static int b(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return -1;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString(MediaFormat.KEY_MIME);
            if (string.startsWith(str)) {
                e eVar = e.e;
                eVar.c("MediaUtils", "Extractor selected track " + i2 + " (" + string + "): " + trackFormat);
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static int b(Object obj) {
        String a2 = a(obj, 18);
        if (a2 == null) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static int c(Object obj) {
        String a2 = a(obj, 19);
        if (a2 == null) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static int d(Object obj) {
        String a2 = a(obj, 24);
        if (a2 == null) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static int e(Object obj) {
        String a2 = a(obj, 20);
        if (a2 == null) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static int f(Object obj) {
        f fVar = new f(obj.toString());
        int j = fVar.j();
        fVar.a();
        return j;
    }
}
