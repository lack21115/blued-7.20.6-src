package android.media;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/media/ThumbnailUtils.class */
public class ThumbnailUtils {
    private static final int MAX_NUM_PIXELS_MICRO_THUMBNAIL = 19200;
    private static final int MAX_NUM_PIXELS_THUMBNAIL = 196608;
    private static final int OPTIONS_NONE = 0;
    public static final int OPTIONS_RECYCLE_INPUT = 2;
    private static final int OPTIONS_SCALE_UP = 1;
    private static final String TAG = "ThumbnailUtils";
    public static final int TARGET_SIZE_MICRO_THUMBNAIL = 96;
    public static final int TARGET_SIZE_MINI_THUMBNAIL = 320;
    private static final int UNCONSTRAINED = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/ThumbnailUtils$SizedThumbnailBitmap.class */
    public static class SizedThumbnailBitmap {
        public Bitmap mBitmap;
        public byte[] mThumbnailData;
        public int mThumbnailHeight;
        public int mThumbnailWidth;

        private SizedThumbnailBitmap() {
        }
    }

    private static void closeSilently(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            return;
        }
        try {
            parcelFileDescriptor.close();
        } catch (Throwable th) {
        }
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
        if (min >= ceil) {
            if (i2 == -1 && i == -1) {
                return 1;
            }
            if (i != -1) {
                return min;
            }
        }
        return ceil;
    }

    private static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize <= 8) {
            int i4 = 1;
            while (true) {
                int i5 = i4;
                i3 = i5;
                if (i5 >= computeInitialSampleSize) {
                    break;
                }
                i4 = i5 << 1;
            }
        } else {
            i3 = ((computeInitialSampleSize + 7) / 8) * 8;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap createImageThumbnail(java.lang.String r5, int r6) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.ThumbnailUtils.createImageThumbnail(java.lang.String, int):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c9 -> B:9:0x0019). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void createThumbnailFromEXIF(java.lang.String r6, int r7, int r8, android.media.ThumbnailUtils.SizedThumbnailBitmap r9) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.ThumbnailUtils.createThumbnailFromEXIF(java.lang.String, int, int, android.media.ThumbnailUtils$SizedThumbnailBitmap):void");
    }

    public static Bitmap createVideoThumbnail(String str, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e) {
            }
        } catch (IllegalArgumentException e2) {
            try {
                mediaMetadataRetriever.release();
                bitmap = null;
            } catch (RuntimeException e3) {
                bitmap = null;
            }
        } catch (RuntimeException e4) {
            try {
                mediaMetadataRetriever.release();
                bitmap = null;
            } catch (RuntimeException e5) {
                bitmap = null;
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e6) {
            }
            throw th;
        }
        if (bitmap == null) {
            return null;
        }
        if (i == 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            bitmap2 = bitmap;
            if (max > 512) {
                float f = 512.0f / max;
                bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(width * f), Math.round(height * f), true);
            }
        } else {
            bitmap2 = bitmap;
            if (i == 3) {
                bitmap2 = extractThumbnail(bitmap, 96, 96, 2);
            }
        }
        return bitmap2;
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int i2) {
        return extractThumbnail(bitmap, i, i2, 0);
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth() < bitmap.getHeight() ? i / bitmap.getWidth() : i2 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        return transform(matrix, bitmap, i, i2, i3 | 1);
    }

    private static Bitmap makeBitmap(int i, int i2, Uri uri, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, BitmapFactory.Options options) {
        ParcelFileDescriptor parcelFileDescriptor2;
        ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor;
        try {
            if (parcelFileDescriptor == null) {
                parcelFileDescriptor2 = parcelFileDescriptor;
                try {
                    parcelFileDescriptor3 = makeInputStream(uri, contentResolver);
                } catch (OutOfMemoryError e) {
                    Log.e(TAG, "Got oom exception ", e);
                    closeSilently(parcelFileDescriptor2);
                    return null;
                }
            }
            if (parcelFileDescriptor3 == null) {
                closeSilently(parcelFileDescriptor3);
                return null;
            }
            BitmapFactory.Options options2 = options;
            if (options == null) {
                options2 = new BitmapFactory.Options();
            }
            ParcelFileDescriptor parcelFileDescriptor4 = parcelFileDescriptor3;
            FileDescriptor fileDescriptor = parcelFileDescriptor3.getFileDescriptor();
            ParcelFileDescriptor parcelFileDescriptor5 = parcelFileDescriptor3;
            options2.inSampleSize = 1;
            ParcelFileDescriptor parcelFileDescriptor6 = parcelFileDescriptor3;
            options2.inJustDecodeBounds = true;
            ParcelFileDescriptor parcelFileDescriptor7 = parcelFileDescriptor3;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options2);
            ParcelFileDescriptor parcelFileDescriptor8 = parcelFileDescriptor3;
            if (!options2.mCancel) {
                ParcelFileDescriptor parcelFileDescriptor9 = parcelFileDescriptor3;
                if (options2.outWidth != -1) {
                    ParcelFileDescriptor parcelFileDescriptor10 = parcelFileDescriptor3;
                    if (options2.outHeight != -1) {
                        options2.inSampleSize = computeSampleSize(options2, i, i2);
                        ParcelFileDescriptor parcelFileDescriptor11 = parcelFileDescriptor3;
                        options2.inJustDecodeBounds = false;
                        ParcelFileDescriptor parcelFileDescriptor12 = parcelFileDescriptor3;
                        options2.inDither = false;
                        ParcelFileDescriptor parcelFileDescriptor13 = parcelFileDescriptor3;
                        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        parcelFileDescriptor2 = parcelFileDescriptor3;
                        parcelFileDescriptor = parcelFileDescriptor3;
                        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options2);
                        closeSilently(parcelFileDescriptor3);
                        return decodeFileDescriptor;
                    }
                }
            }
            closeSilently(parcelFileDescriptor3);
            return null;
        } catch (Throwable th) {
            closeSilently(parcelFileDescriptor);
            throw th;
        }
    }

    private static ParcelFileDescriptor makeInputStream(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openFileDescriptor(uri, "r");
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x016c, code lost:
        if (r21 != r12) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap transform(android.graphics.Matrix r11, android.graphics.Bitmap r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.ThumbnailUtils.transform(android.graphics.Matrix, android.graphics.Bitmap, int, int, int):android.graphics.Bitmap");
    }
}
