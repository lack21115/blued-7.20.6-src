package com.android.internal.util.cm;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.ThemeUtils;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.provider.ThemesContract;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/ImageUtils.class */
public class ImageUtils {
    private static final String ASSET_URI_PREFIX = "file:///android_asset/";
    private static final int DEFAULT_IMG_QUALITY = 100;
    private static final String TAG = ImageUtils.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.io.ByteArrayInputStream] */
    public static InputStream cropImage(InputStream inputStream, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        InputStream inputStream2;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException(String.format("imageWidth and imageHeight must be > 0: imageWidth=%d imageHeight=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i3 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException(String.format("outWidth and outHeight must be > 0: outWidth=%d outHeight=%d", Integer.valueOf(i), Integer.valueOf(i4)));
        }
        int min = Math.min(i / i3, i2 / i4);
        ?? r0 = min;
        if (r0 > 0) {
            i /= min;
            i2 /= min;
        } else {
            try {
                float f = i3 / i4;
                if (i < i2 * f) {
                    i3 = i;
                    i4 = (int) (i3 / f);
                } else {
                    i4 = i2;
                    i3 = (int) (i4 * f);
                }
            } catch (Exception unused) {
                inputStream2 = null;
                Log.e(TAG, "Exception " + ((Object) r0));
            }
        }
        int i5 = (i - i3) / 2;
        int i6 = (i2 - i4) / 2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (min > 1) {
            options.inSampleSize = min;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (decodeStream == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, i5, i6, i3, i4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        inputStream2 = null;
        if (createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
            r0 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            inputStream2 = r0;
        }
        return inputStream2;
    }

    public static InputStream getCroppedKeyguardStream(String str, Context context) throws IllegalArgumentException {
        InputStream inputStream;
        InputStream originalKeyguardStream;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("'pkgName' cannot be null or empty!");
        }
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        try {
            try {
                originalKeyguardStream = getOriginalKeyguardStream(str, context);
            } catch (Exception e) {
                inputStream2 = inputStream3;
                Log.e(TAG, "Exception " + e);
                IoUtils.closeQuietly(inputStream3);
                inputStream = null;
            }
            if (originalKeyguardStream == null) {
                IoUtils.closeQuietly(originalKeyguardStream);
                return null;
            }
            Point imageDimension = getImageDimension(originalKeyguardStream);
            IoUtils.closeQuietly(originalKeyguardStream);
            if (imageDimension == null || imageDimension.x == 0 || imageDimension.y == 0) {
                IoUtils.closeQuietly(originalKeyguardStream);
                return null;
            }
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
            int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
            int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
            InputStream originalKeyguardStream2 = getOriginalKeyguardStream(str, context);
            if (originalKeyguardStream2 == null) {
                IoUtils.closeQuietly(originalKeyguardStream2);
                return null;
            }
            inputStream3 = originalKeyguardStream2;
            inputStream2 = originalKeyguardStream2;
            inputStream = cropImage(originalKeyguardStream2, imageDimension.x, imageDimension.y, desiredMinimumWidth, desiredMinimumHeight);
            IoUtils.closeQuietly(originalKeyguardStream2);
            return inputStream;
        } catch (Throwable th) {
            IoUtils.closeQuietly(inputStream2);
            throw th;
        }
    }

    public static InputStream getCroppedWallpaperStream(String str, long j, Context context) {
        InputStream inputStream;
        InputStream originalWallpaperStream;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("'pkgName' cannot be null or empty!");
        }
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        try {
            try {
                originalWallpaperStream = getOriginalWallpaperStream(str, j, context);
            } catch (Exception e) {
                inputStream2 = inputStream3;
                Log.e(TAG, "Exception " + e);
                IoUtils.closeQuietly(inputStream3);
                inputStream = null;
            }
            if (originalWallpaperStream == null) {
                IoUtils.closeQuietly(originalWallpaperStream);
                return null;
            }
            Point imageDimension = getImageDimension(originalWallpaperStream);
            IoUtils.closeQuietly(originalWallpaperStream);
            if (imageDimension == null || imageDimension.x == 0 || imageDimension.y == 0) {
                IoUtils.closeQuietly(originalWallpaperStream);
                return null;
            }
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
            int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
            int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
            InputStream originalWallpaperStream2 = getOriginalWallpaperStream(str, j, context);
            if (originalWallpaperStream2 == null) {
                IoUtils.closeQuietly(originalWallpaperStream2);
                return null;
            }
            inputStream3 = originalWallpaperStream2;
            inputStream2 = originalWallpaperStream2;
            inputStream = cropImage(originalWallpaperStream2, imageDimension.x, imageDimension.y, desiredMinimumWidth, desiredMinimumHeight);
            IoUtils.closeQuietly(originalWallpaperStream2);
            return inputStream;
        } catch (Throwable th) {
            IoUtils.closeQuietly(inputStream2);
            throw th;
        }
    }

    public static Point getImageDimension(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("'inputStream' cannot be null!");
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return new Point(options.outWidth, options.outHeight);
    }

    private static InputStream getOriginalKeyguardStream(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            Context createPackageContext = context.createPackageContext(str, 2);
            String lockscreenWallpaperPath = ThemeUtils.getLockscreenWallpaperPath(createPackageContext.getAssets());
            if (lockscreenWallpaperPath == null) {
                Log.w(TAG, "Not setting lockscreen wp because wallpaper file was not found.");
                return null;
            }
            return ThemeUtils.getInputStreamFromAsset(createPackageContext, ASSET_URI_PREFIX + lockscreenWallpaperPath);
        } catch (Exception e) {
            Log.e(TAG, "There was an error setting lockscreen wp for pkg " + str, e);
            return null;
        }
    }

    private static InputStream getOriginalWallpaperStream(String str, long j, Context context) {
        InputStream inputStreamFromAsset;
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(ThemesContract.ThemesColumns.CONTENT_URI, null, "pkg_name= ?", new String[]{str}, null);
        if (query == null || query.getCount() < 1) {
            return query != null ? null : null;
        }
        query.moveToFirst();
        try {
            try {
                Context createPackageContext = context.createPackageContext(str, 2);
                if (query.getInt(query.getColumnIndex(ThemesContract.ThemesColumns.IS_LEGACY_THEME)) == 1) {
                }
                String string = query.getString(query.getColumnIndex(ThemesContract.ThemesColumns.WALLPAPER_URI));
                if (string != null) {
                    inputStreamFromAsset = URLUtil.isAssetUrl(string) ? ThemeUtils.getInputStreamFromAsset(createPackageContext, string) : context.getContentResolver().openInputStream(Uri.parse(string));
                } else {
                    Context createPackageContext2 = context.createPackageContext(str, 2);
                    AssetManager assets = createPackageContext2.getAssets();
                    String queryWpPathFromComponentId = queryWpPathFromComponentId(context, str, j);
                    String str2 = queryWpPathFromComponentId;
                    if (queryWpPathFromComponentId == null) {
                        str2 = ThemeUtils.getWallpaperPath(assets);
                    }
                    if (str2 == null) {
                        Log.e(TAG, "Not setting wp because wallpaper file was not found.");
                        inputStreamFromAsset = null;
                    } else {
                        inputStreamFromAsset = ThemeUtils.getInputStreamFromAsset(createPackageContext2, ASSET_URI_PREFIX + str2);
                    }
                }
                query.close();
                return inputStreamFromAsset;
            } catch (Exception e) {
                Log.e(TAG, "getWallpaperStream: " + e);
                query.close();
                return null;
            }
        } finally {
            query.close();
        }
    }

    private static String queryWpPathFromComponentId(Context context, String str, long j) {
        Cursor query = context.getContentResolver().query(ThemesContract.PreviewColumns.COMPONENTS_URI, new String[]{"value"}, "pkg_name=? AND component_id=? AND key=?", new String[]{str, Long.toString(j), ThemesContract.PreviewColumns.WALLPAPER_FULL}, null);
        String str2 = null;
        if (query != null) {
            str2 = null;
            try {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndex("value"));
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Could not get wallpaper path", e);
                    query.close();
                    return null;
                }
            } finally {
                query.close();
            }
        }
        return str2;
    }
}
