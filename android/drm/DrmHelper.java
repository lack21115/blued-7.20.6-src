package android.drm;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmHelper.class */
public class DrmHelper {
    public static final String BUY_LICENSE = "android.drmservice.intent.action.BUY_LICENSE";
    public static final String EXTENSION_DCF = ".dcf";
    public static final String EXTENSION_DM = ".dm";
    public static final String EXTENSION_FL = ".fl";
    public static final String MIMETYPE_DRM_CONTENT = "application/vnd.oma.drm.content";
    public static final String MIMETYPE_DRM_MESSAGE = "application/vnd.oma.drm.message";
    public static final String TAG = "Gallery2/DrmHelper";

    public static final int checkRightsStatus(Context context, String str, String str2) {
        DrmManagerClientWrapper drmManagerClientWrapper;
        int i = -1;
        DrmManagerClientWrapper drmManagerClientWrapper2 = null;
        try {
            try {
                drmManagerClientWrapper = new DrmManagerClientWrapper(context);
                try {
                    i = checkRightsStatus(drmManagerClientWrapper, str, str2);
                } catch (Exception e) {
                    drmManagerClientWrapper2 = drmManagerClientWrapper;
                    Log.e(TAG, "Exception while checking rights");
                    if (drmManagerClientWrapper != null) {
                        drmManagerClientWrapper.release();
                        return -1;
                    }
                    return i;
                } catch (Throwable th) {
                    drmManagerClientWrapper2 = drmManagerClientWrapper;
                    th = th;
                    if (drmManagerClientWrapper2 != null) {
                        drmManagerClientWrapper2.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            drmManagerClientWrapper = null;
        }
        if (drmManagerClientWrapper != null) {
            drmManagerClientWrapper.release();
            return i;
        }
        return i;
    }

    public static final int checkRightsStatus(DrmManagerClientWrapper drmManagerClientWrapper, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str2.startsWith("image") ? drmManagerClientWrapper.checkRightsStatus(str, 7) : drmManagerClientWrapper.checkRightsStatus(str, 1);
        }
        String replace = str.replace("/storage/emulated/0", "/storage/emulated/legacy");
        return drmManagerClientWrapper.getOriginalMimeType(replace).startsWith("image") ? drmManagerClientWrapper.checkRightsStatus(replace, 7) : drmManagerClientWrapper.checkRightsStatus(replace, 1);
    }

    public static boolean consumeDrmRights(String str, String str2) {
        if (!isDrmFile(str)) {
            Log.e(TAG, "Could not consume rights from non-drm file. path = " + str);
            return false;
        } else if (TextUtils.isEmpty(str2) || !str2.startsWith("image")) {
            Log.e(TAG, "Can not comsume rights of a non-image file");
            return false;
        } else {
            return BitmapFactory.consumeDrmImageRights(str);
        }
    }

    public static BitmapRegionDecoder createBitmapRegionDecoder(String str, boolean z) {
        if (!isDrmFile(str)) {
            Log.e(TAG, "Could not decode non-drm file. path = " + str);
            return null;
        }
        try {
            return BitmapRegionDecoder.newInstanceDrmFile(str, z);
        } catch (Throwable th) {
            Log.w(TAG, "Could not decode non-drm file. error = " + th);
            return null;
        }
    }

    public static Bitmap getBitmap(String str) {
        return getBitmap(str, null);
    }

    public static Bitmap getBitmap(String str, BitmapFactory.Options options) {
        if (!isDrmFile(str)) {
            Log.e(TAG, "Could not decode non-drm file. path = " + str);
            return null;
        }
        BitmapFactory.Options options2 = options;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
        return BitmapFactory.decodeDrmFile(str, options2);
    }

    public static byte[] getDrmImageBytes(String str) {
        if (!isDrmFile(str)) {
            Log.e(TAG, "Could not decode non-drm file. path = " + str);
            return null;
        }
        try {
            return BitmapFactory.getDrmImageBytes(str);
        } catch (Throwable th) {
            Log.w(TAG, "Could not decode non-drm file. error = " + th);
            return null;
        }
    }

    public static final String getFilePath(Context context, Uri uri) {
        String str;
        if (isDrmFile(uri.toString())) {
            str = uri.toString();
        } else {
            Cursor cursor = null;
            Cursor cursor2 = null;
            try {
                try {
                    Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                    String str2 = null;
                    if (query.moveToFirst()) {
                        cursor2 = query;
                        cursor = query;
                        str2 = query.getString(0);
                    }
                    str = str2;
                    if (query != null) {
                        str = str2;
                        if (!query.isClosed()) {
                            query.close();
                            return str2;
                        }
                    }
                } catch (Exception e) {
                    cursor = cursor2;
                    Log.e(TAG, "Could not get drm file path");
                    str = null;
                    if (cursor2 != null) {
                        str = null;
                        if (!cursor2.isClosed()) {
                            cursor2.close();
                            return null;
                        }
                    }
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
        return str;
    }

    public static final String getOriginalMimeType(Context context, String str) {
        DrmManagerClientWrapper drmManagerClientWrapper = new DrmManagerClientWrapper(context);
        try {
            return drmManagerClientWrapper.canHandle(str, (String) null) ? drmManagerClientWrapper.getOriginalMimeType(str) : "";
        } finally {
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
            }
        }
    }

    public static final boolean isDrmCD(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(EXTENSION_DM);
    }

    public static final boolean isDrmCDBlocking(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        DrmManagerClientWrapper drmManagerClientWrapper = new DrmManagerClientWrapper(context);
        try {
            ContentValues metadata = drmManagerClientWrapper.getMetadata(str);
            if (metadata != null) {
                if (metadata.getAsInteger("DRM-TYPE").intValue() == 2) {
                }
            }
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
                return false;
            }
            return false;
        } finally {
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
            }
        }
    }

    public static final boolean isDrmFL(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(EXTENSION_FL);
    }

    public static final boolean isDrmFLBlocking(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        DrmManagerClientWrapper drmManagerClientWrapper = new DrmManagerClientWrapper(context);
        try {
            ContentValues metadata = drmManagerClientWrapper.getMetadata(str);
            if (metadata != null) {
                if (metadata.getAsInteger("DRM-TYPE").intValue() == 1) {
                }
            }
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
                return false;
            }
            return false;
        } finally {
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
            }
        }
    }

    public static final boolean isDrmFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(EXTENSION_FL) || str.endsWith(EXTENSION_DM) || str.endsWith(EXTENSION_DCF);
    }

    public static final boolean isDrmMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "application/vnd.oma.drm.message".equals(str) || "application/vnd.oma.drm.content".equals(str);
    }

    public static final boolean isDrmSD(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(EXTENSION_DCF);
    }

    public static final boolean isDrmSDBlocking(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        DrmManagerClientWrapper drmManagerClientWrapper = new DrmManagerClientWrapper(context);
        try {
            ContentValues metadata = drmManagerClientWrapper.getMetadata(str);
            if (metadata != null) {
                if (metadata.getAsInteger("DRM-TYPE").intValue() == 3) {
                }
            }
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
                return false;
            }
            return false;
        } finally {
            if (drmManagerClientWrapper != null) {
                drmManagerClientWrapper.release();
            }
        }
    }

    public static final boolean isLicenseableDrmFile(String str) {
        if (isDrmFile(str)) {
            return str.endsWith(EXTENSION_DM) || str.endsWith(EXTENSION_DCF);
        }
        return false;
    }

    public static final boolean isShareableDrmFile(String str) {
        return !isDrmFile(str) || str.endsWith(EXTENSION_DCF);
    }

    public static final void manageDrmLicense(final Context context, Handler handler, final String str, final String str2) {
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: android.drm.DrmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DrmHelper.isDrmFile(String.this) && DrmHelper.validateLicense(context, String.this, str2)) {
                        DrmHelper.consumeDrmRights(String.this, str2);
                    }
                }
            }, 1000L);
        } else {
            manageDrmLicense(context, str, str2);
        }
    }

    public static final void manageDrmLicense(Context context, String str, String str2) {
        if (isDrmFile(str) && validateLicense(context, str, str2)) {
            consumeDrmRights(str, str2);
        }
    }

    public static final void showDrmInfo(Context context, String str) {
        if (isDrmFile(str)) {
            Intent intent = new Intent("android.drmservice.intent.action.SHOW_PROPERTIES");
            intent.putExtra("DRM_FILE_PATH", str.replace("/storage/emulated/0", "/storage/emulated/legacy"));
            intent.putExtra("DRM_TYPE", "OMAV1");
            context.sendBroadcast(intent);
        }
    }

    public static final boolean validateLicense(Context context, String str, String str2) {
        DrmManagerClientWrapper drmManagerClientWrapper;
        DrmManagerClientWrapper drmManagerClientWrapper2;
        boolean z = true;
        DrmManagerClientWrapper drmManagerClientWrapper3 = null;
        try {
            try {
                drmManagerClientWrapper2 = new DrmManagerClientWrapper(context);
                try {
                    if (checkRightsStatus(drmManagerClientWrapper2, str, str2) != 0) {
                        String asString = drmManagerClientWrapper2.getMetadata(str).getAsString("Rights-Issuer");
                        Intent intent = new Intent(BUY_LICENSE);
                        intent.putExtra("DRM_FILE_PATH", asString);
                        context.sendBroadcast(intent);
                        Log.e(TAG, "Drm License expared! can not proceed ahead");
                        z = false;
                    }
                } catch (Exception e) {
                    drmManagerClientWrapper = drmManagerClientWrapper2;
                    drmManagerClientWrapper3 = drmManagerClientWrapper;
                    Log.e(TAG, "Exception while valicating drm license");
                    z = true;
                    if (drmManagerClientWrapper != null) {
                        drmManagerClientWrapper.release();
                        return true;
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    drmManagerClientWrapper3 = drmManagerClientWrapper2;
                    if (drmManagerClientWrapper3 != null) {
                        drmManagerClientWrapper3.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            drmManagerClientWrapper = null;
        }
        if (drmManagerClientWrapper2 != null) {
            drmManagerClientWrapper2.release();
            return z;
        }
        return z;
    }
}
