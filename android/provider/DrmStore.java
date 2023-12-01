package android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.drm.mobile1.DrmRawContent;
import android.drm.mobile1.DrmRightsManager;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/provider/DrmStore.class */
public final class DrmStore {
    private static final String ACCESS_DRM_PERMISSION = "android.permission.ACCESS_DRM";
    public static final String AUTHORITY = "drm";
    private static final String TAG = "DrmStore";

    /* loaded from: source-9557208-dex2jar.jar:android/provider/DrmStore$Audio.class */
    public interface Audio extends Columns {
        public static final Uri CONTENT_URI = Uri.parse("content://drm/audio");
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/DrmStore$Columns.class */
    public interface Columns extends BaseColumns {
        public static final String DATA = "_data";
        public static final String MIME_TYPE = "mime_type";
        public static final String SIZE = "_size";
        public static final String TITLE = "title";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/DrmStore$Images.class */
    public interface Images extends Columns {
        public static final Uri CONTENT_URI = Uri.parse("content://drm/images");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileInputStream] */
    public static final Intent addDrmFile(ContentResolver contentResolver, File file, String str) {
        String str2;
        Intent intent;
        String str3 = null;
        try {
            try {
                ?? fileInputStream = new FileInputStream(file);
                str3 = str;
                if (str == null) {
                    try {
                        String name = file.getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        str3 = name;
                        if (lastIndexOf > 0) {
                            str3 = name.substring(0, lastIndexOf);
                        }
                    } catch (Exception e) {
                        e = e;
                        str2 = fileInputStream;
                        str3 = str2;
                        Log.e(TAG, "pushing file failed", e);
                        intent = null;
                        if (str2 != null) {
                            try {
                                str2.close();
                                return null;
                            } catch (IOException e2) {
                                Log.e(TAG, "IOException in DrmStore.addDrmFile()", e2);
                                return null;
                            }
                        }
                        return intent;
                    } catch (Throwable th) {
                        th = th;
                        str3 = fileInputStream;
                        if (str3 != null) {
                            try {
                                str3.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "IOException in DrmStore.addDrmFile()", e3);
                            }
                        }
                        throw th;
                    }
                }
                Intent addDrmFile = addDrmFile(contentResolver, (FileInputStream) fileInputStream, str3);
                if (fileInputStream != 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "IOException in DrmStore.addDrmFile()", e4);
                        return addDrmFile;
                    }
                }
                intent = addDrmFile;
            } catch (Exception e5) {
                e = e5;
                str2 = null;
            }
            return intent;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final Intent addDrmFile(ContentResolver contentResolver, FileInputStream fileInputStream, String str) {
        Intent intent;
        Intent intent2;
        OutputStream outputStream = null;
        OutputStream outputStream2 = null;
        try {
            try {
                DrmRawContent drmRawContent = new DrmRawContent(fileInputStream, fileInputStream.available(), "application/vnd.oma.drm.message");
                String contentType = drmRawContent.getContentType();
                long size = fileInputStream.getChannel().size();
                InputStream contentInputStream = drmRawContent.getContentInputStream(DrmRightsManager.getInstance().queryRights(drmRawContent));
                Uri uri = null;
                if (contentType.startsWith("audio/")) {
                    uri = Audio.CONTENT_URI;
                } else if (contentType.startsWith("image/")) {
                    uri = Images.CONTENT_URI;
                } else {
                    Log.w(TAG, "unsupported mime type " + contentType);
                }
                OutputStream outputStream3 = null;
                Intent intent3 = null;
                if (uri != null) {
                    ContentValues contentValues = new ContentValues(3);
                    contentValues.put("title", str);
                    contentValues.put("_size", Long.valueOf(size));
                    contentValues.put("mime_type", contentType);
                    Uri insert = contentResolver.insert(uri, contentValues);
                    outputStream3 = null;
                    intent3 = null;
                    if (insert != null) {
                        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                        byte[] bArr = new byte[1000];
                        while (true) {
                            int read = contentInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            openOutputStream.write(bArr, 0, read);
                        }
                        outputStream = openOutputStream;
                        Intent intent4 = new Intent();
                        try {
                            intent4.setDataAndType(insert, contentType);
                            intent3 = intent4;
                            outputStream3 = openOutputStream;
                        } catch (Exception e) {
                            e = e;
                            outputStream = openOutputStream;
                            intent = intent4;
                            Log.e(TAG, "pushing file failed", e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    Log.e(TAG, "IOException in DrmStore.addDrmFile()", e2);
                                    return intent;
                                }
                            }
                            intent2 = intent;
                            if (outputStream != null) {
                                outputStream.close();
                                intent2 = intent;
                            }
                            return intent2;
                        } catch (Throwable th) {
                            outputStream2 = openOutputStream;
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    Log.e(TAG, "IOException in DrmStore.addDrmFile()", e3);
                                    throw th;
                                }
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            throw th;
                        }
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "IOException in DrmStore.addDrmFile()", e4);
                        return intent3;
                    }
                }
                intent2 = intent3;
                if (outputStream3 != null) {
                    outputStream3.close();
                    return intent3;
                }
            } catch (Exception e5) {
                e = e5;
                intent = null;
            }
            return intent2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void enforceAccessDrmPermission(Context context) {
        if (context.checkCallingOrSelfPermission(ACCESS_DRM_PERMISSION) != 0) {
            throw new SecurityException("Requires DRM permission");
        }
    }
}
