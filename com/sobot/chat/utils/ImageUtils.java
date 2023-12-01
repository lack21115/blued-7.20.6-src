package com.sobot.chat.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ImageUtils.class */
public class ImageUtils {
    public static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
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

    public static Bitmap getBitmapFromUri(Context context, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
                return null;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static Uri getImageContentUri(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (new File(str).exists()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        Uri parse = Uri.parse("content://media/external/images/media");
        return Uri.withAppendedPath(parse, "" + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri getImageUrlWithAuthority(android.content.Context r3, android.net.Uri r4) {
        /*
            r0 = r4
            java.lang.String r0 = r0.getAuthority()
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L70
            r0 = r3
            android.content.ContentResolver r0 = r0.getContentResolver()
            if (r0 == 0) goto L70
            r0 = r3
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L43
            r1 = r4
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L43
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            r1 = r5
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.io.FileNotFoundException -> L37 java.lang.Throwable -> L5d
            android.net.Uri r0 = writeToTempImageAndGetPathUri(r0, r1)     // Catch: java.io.FileNotFoundException -> L37 java.lang.Throwable -> L5d
            r3 = r0
            r0 = r5
            if (r0 == 0) goto L35
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L30
            r0 = r3
            return r0
        L30:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L35:
            r0 = r3
            return r0
        L37:
            r6 = move-exception
            r0 = r5
            r3 = r0
            goto L46
        L3d:
            r3 = move-exception
            r0 = r6
            r4 = r0
            goto L5e
        L43:
            r6 = move-exception
            r0 = 0
            r3 = r0
        L46:
            r0 = r3
            r4 = r0
            r0 = r6
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            r0 = r3
            if (r0 == 0) goto L70
            r0 = r3
            r0.close()     // Catch: java.io.IOException -> L56
            r0 = 0
            return r0
        L56:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
            r0 = 0
            return r0
        L5d:
            r3 = move-exception
        L5e:
            r0 = r4
            if (r0 == 0) goto L6e
            r0 = r4
            r0.close()     // Catch: java.io.IOException -> L69
            goto L6e
        L69:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L6e:
            r0 = r3
            throw r0
        L70:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.ImageUtils.getImageUrlWithAuthority(android.content.Context, android.net.Uri):android.net.Uri");
    }

    public static Uri getMediaUriFromPath(Context context, String str) {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query.getCount() <= 0) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= query.getCount()) {
                query.close();
                return null;
            }
            query.moveToPosition(i2);
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex != -1) {
                String string = query.getString(columnIndex);
                LogUtils.e("path1 ==================> " + string);
                if (string.equals(str)) {
                    return ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndex("_id")));
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x02ec: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:112:0x02e9 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x02e9: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:112:0x02e9 */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0333 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x031b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getPath(android.content.Context r9, android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.ImageUtils.getPath(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static Uri getUri(Intent intent, Context context) {
        Uri data = intent.getData();
        String type = intent.getType();
        Uri uri = data;
        if (data.getScheme().equals(ContentResolver.SCHEME_FILE)) {
            uri = data;
            if (type.contains("image/*")) {
                String encodedPath = data.getEncodedPath();
                uri = data;
                if (encodedPath != null) {
                    String decode = Uri.decode(encodedPath);
                    ContentResolver contentResolver = context.getContentResolver();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("(");
                    stringBuffer.append("_data");
                    stringBuffer.append("=");
                    stringBuffer.append("'" + decode + "'");
                    stringBuffer.append(")");
                    Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, stringBuffer.toString(), null, null);
                    int i = 0;
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("_id"));
                        query.moveToNext();
                    }
                    if (i == 0) {
                        return data;
                    }
                    Uri parse = Uri.parse("content://media/external/images/media/" + i);
                    uri = data;
                    if (parse != null) {
                        uri = parse;
                    }
                }
            }
        }
        return uri;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isNewGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.contentprovider".equals(uri.getAuthority());
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (i != 0) {
            matrix.postRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014a A[Catch: Exception -> 0x0167, IOException -> 0x018d, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x018d, blocks: (B:55:0x013c, B:58:0x014a), top: B:90:0x013c, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String uriToFileApiQ(android.content.Context r7, android.net.Uri r8) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.ImageUtils.uriToFileApiQ(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri writeToTempImageAndGetPathUri(android.content.Context r5, android.graphics.Bitmap r6) {
        /*
            Method dump skipped, instructions count: 180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.ImageUtils.writeToTempImageAndGetPathUri(android.content.Context, android.graphics.Bitmap):android.net.Uri");
    }
}
