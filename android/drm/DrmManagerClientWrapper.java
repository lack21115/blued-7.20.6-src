package android.drm;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClientWrapper.class */
public class DrmManagerClientWrapper extends DrmManagerClient {
    private static final String ACTION_STRING_CONSTRAINTS = "constraints";
    private static final String ACTION_STRING_METADATA = "metadata";
    private static final String ACTION_STRING_RIGHTS = "rights";
    private static final String FAKE_ACTION = "0";
    private static final String TAG = "DrmManagerClientWrapper";

    public DrmManagerClientWrapper(Context context) {
        super(context);
    }

    private ContentValues parseConstraints(String str) {
        ContentValues contentValues = new ContentValues();
        String[] split = TextUtils.split(str, "\n");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return contentValues;
            }
            String[] split2 = TextUtils.split(split[i2], "\t");
            if (split2.length > 0 && !TextUtils.isEmpty(split2[0])) {
                contentValues.put(split2[0], split2[1]);
            }
            i = i2 + 1;
        }
    }

    private ContentValues parseMetadata(String str) {
        ContentValues contentValues = new ContentValues();
        if (!TextUtils.isEmpty(str)) {
            String[] split = TextUtils.split(str, "\n");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String[] split2 = TextUtils.split(split[i2], "\t");
                if (split2[0].equals("DRM-TYPE") && split2[1] != null) {
                    contentValues.put("DRM-TYPE", Integer.valueOf(Integer.parseInt(split2[1])));
                }
                if (split2[0].equals("Rights-Issuer") && split2[1] != null) {
                    contentValues.put("Rights-Issuer", split2[1]);
                }
                i = i2 + 1;
            }
        }
        return contentValues;
    }

    private int parseRightsStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return Integer.parseInt(str.trim());
    }

    @Override // android.drm.DrmManagerClient
    public int checkRightsStatus(String str, int i) {
        String str2;
        String str3 = ACTION_STRING_RIGHTS + i + ":" + str;
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        FileDescriptor fileDescriptor = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                FileInputStream fileInputStream3 = null;
                if (file.exists()) {
                    fileInputStream3 = new FileInputStream(file);
                    try {
                        fileDescriptor = fileInputStream3.getFD();
                    } catch (IOException e) {
                        fileInputStream = fileInputStream3;
                        e = e;
                        fileInputStream2 = fileInputStream;
                        Log.e(TAG, "checkRightsStatus failed! Exception : " + e);
                        str2 = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                str2 = null;
                            } catch (IOException e2) {
                                Log.e(TAG, "checkRightsStatus failed to close stream! Exception : " + e2);
                                str2 = null;
                            }
                        }
                        Log.i(TAG, "Got RightsStatus info! info = " + str2);
                        return parseRightsStatus(str2);
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "checkRightsStatus failed to close stream! Exception : " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                String internalInfo = getInternalInfo(str3, fileDescriptor);
                str2 = internalInfo;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        str2 = internalInfo;
                    } catch (IOException e4) {
                        Log.e(TAG, "checkRightsStatus failed to close stream! Exception : " + e4);
                        str2 = internalInfo;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        Log.i(TAG, "Got RightsStatus info! info = " + str2);
        return parseRightsStatus(str2);
    }

    @Override // android.drm.DrmManagerClient
    public ContentValues getConstraints(String str, int i) {
        String str2;
        String str3 = ACTION_STRING_CONSTRAINTS + i + ":" + str;
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        FileDescriptor fileDescriptor = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                FileInputStream fileInputStream3 = null;
                if (file.exists()) {
                    fileInputStream3 = new FileInputStream(file);
                    try {
                        fileDescriptor = fileInputStream3.getFD();
                    } catch (IOException e) {
                        fileInputStream = fileInputStream3;
                        e = e;
                        fileInputStream2 = fileInputStream;
                        Log.e(TAG, "getConstraints failed! Exception : " + e);
                        str2 = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                str2 = null;
                            } catch (IOException e2) {
                                Log.e(TAG, "getConstraints failed to close stream! Exception : " + e2);
                                str2 = null;
                            }
                        }
                        Log.i(TAG, "Got Constraints info! info = " + str2);
                        return parseConstraints(str2);
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "getConstraints failed to close stream! Exception : " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                String internalInfo = getInternalInfo(str3, fileDescriptor);
                str2 = internalInfo;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        str2 = internalInfo;
                    } catch (IOException e4) {
                        Log.e(TAG, "getConstraints failed to close stream! Exception : " + e4);
                        str2 = internalInfo;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        Log.i(TAG, "Got Constraints info! info = " + str2);
        return parseConstraints(str2);
    }

    @Override // android.drm.DrmManagerClient
    public ContentValues getMetadata(String str) {
        String str2;
        String str3 = "metadata0:" + str;
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        FileDescriptor fileDescriptor = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                FileInputStream fileInputStream3 = null;
                if (file.exists()) {
                    fileInputStream3 = new FileInputStream(file);
                    try {
                        fileDescriptor = fileInputStream3.getFD();
                    } catch (IOException e) {
                        fileInputStream = fileInputStream3;
                        e = e;
                        Log.e(TAG, "getMetadata failed! IOException : " + e);
                        str2 = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                str2 = null;
                            } catch (IOException e2) {
                                Log.e(TAG, "getMetadata failed to close stream! Exception : " + e2);
                                str2 = null;
                            }
                        }
                        Log.i(TAG, "Got Metadata info! info = " + str2);
                        return parseMetadata(str2);
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "getMetadata failed to close stream! Exception : " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                String internalInfo = getInternalInfo(str3, fileDescriptor);
                str2 = internalInfo;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        str2 = internalInfo;
                    } catch (IOException e4) {
                        Log.e(TAG, "getMetadata failed to close stream! Exception : " + e4);
                        str2 = internalInfo;
                    }
                }
            } catch (IOException e5) {
                e = e5;
            }
            Log.i(TAG, "Got Metadata info! info = " + str2);
            return parseMetadata(str2);
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
