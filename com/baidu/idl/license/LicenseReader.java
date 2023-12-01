package com.baidu.idl.license;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/license/LicenseReader.class */
class LicenseReader {
    public static final String TAG = "License-SDK";
    private static final String URL = "https://aip.baidubce.com/public/2.0/license/face-api/app/querydevicelicense";
    private String path;

    /* JADX WARN: Removed duplicated region for block: B:121:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] get_local_license(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.license.LicenseReader.get_local_license(android.content.Context):java.lang.String[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x03ef, code lost:
        if (r15 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0497, code lost:
        if (r15 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x053f, code lost:
        if (r15 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0542, code lost:
        r15.disconnect();
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0549, code lost:
        r8 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03d7 A[Catch: IOException -> 0x0646, TRY_ENTER, TryCatch #5 {IOException -> 0x0646, blocks: (B:99:0x03ca, B:102:0x03d7, B:105:0x03e0), top: B:214:0x03ca }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03e0 A[Catch: IOException -> 0x0646, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0646, blocks: (B:99:0x03ca, B:102:0x03d7, B:105:0x03e0), top: B:214:0x03ca }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x047f A[Catch: IOException -> 0x064a, TRY_ENTER, TryCatch #4 {IOException -> 0x064a, blocks: (B:121:0x0472, B:124:0x047f, B:127:0x0488), top: B:212:0x0472 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0488 A[Catch: IOException -> 0x064a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x064a, blocks: (B:121:0x0472, B:124:0x047f, B:127:0x0488), top: B:212:0x0472 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0527 A[Catch: IOException -> 0x064e, TRY_ENTER, TryCatch #23 {IOException -> 0x064e, blocks: (B:143:0x051a, B:146:0x0527, B:149:0x0530), top: B:225:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0530 A[Catch: IOException -> 0x064e, TRY_ENTER, TRY_LEAVE, TryCatch #23 {IOException -> 0x064e, blocks: (B:143:0x051a, B:146:0x0527, B:149:0x0530), top: B:225:0x051a }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0472 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x051a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] get_remote_license(android.content.Context r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 1622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.license.LicenseReader.get_remote_license(android.content.Context, java.lang.String):java.lang.String[]");
    }

    public int init(String str) {
        this.path = str;
        return 0;
    }

    public int put_local_license(Context context, String[] strArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        int i;
        File dir = context.getDir(this.path, 0);
        Log.e("License-SDK", "put_local_license =" + dir.getAbsolutePath());
        if (dir != null) {
            dir.delete();
        }
        if (dir != null && !dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException e) {
                Log.e("License-SDK", "IOException");
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream4 = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream5 = new FileOutputStream(dir);
                    try {
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= length) {
                                fileOutputStream5.close();
                                return 0;
                            }
                            fileOutputStream5.write(strArr[i3].getBytes());
                            fileOutputStream5.write(10);
                            i2 = i3 + 1;
                        }
                    } catch (FileNotFoundException e2) {
                        fileOutputStream3 = fileOutputStream5;
                        e = e2;
                        Log.e("License-SDK", "FileNotFoundException");
                        FileOutputStream fileOutputStream6 = fileOutputStream3;
                        e.printStackTrace();
                        if (fileOutputStream3 != null) {
                            fileOutputStream3.close();
                        }
                        i = -1;
                        return i;
                    } catch (IOException e3) {
                        fileOutputStream2 = fileOutputStream5;
                        e = e3;
                        Log.e("License-SDK", "IOException");
                        FileOutputStream fileOutputStream7 = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        i = -1;
                        return i;
                    } catch (Exception e4) {
                        fileOutputStream = fileOutputStream5;
                        e = e4;
                        Log.e("License-SDK", "Exception");
                        FileOutputStream fileOutputStream8 = fileOutputStream;
                        e.printStackTrace();
                        i = 0;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return 0;
                        }
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream4 = fileOutputStream5;
                        if (fileOutputStream4 != null) {
                            try {
                                fileOutputStream4.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileOutputStream3 = null;
                } catch (IOException e7) {
                    e = e7;
                    fileOutputStream2 = null;
                } catch (Exception e8) {
                    e = e8;
                    fileOutputStream = null;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                i = -1;
                return i;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
