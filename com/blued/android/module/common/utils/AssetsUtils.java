package com.blued.android.module.common.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/AssetsUtils.class */
public class AssetsUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0178: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:77:0x0178 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.io.OutputStream] */
    public static String a(String str, boolean z) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        File file = new File(AppInfo.d().getFilesDir().getPath() + BridgeUtil.SPLIT_MARK);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            if (!z) {
                return file2.getAbsolutePath();
            }
            file2.delete();
        }
        try {
            try {
                try {
                    inputStream = AppInfo.d().getAssets().open(str);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    inputStream = null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    file = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (file != null) {
                        file.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (!file2.exists()) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        fileOutputStream.close();
                        return "";
                    }
                    String absolutePath = file2.getAbsolutePath();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return absolutePath;
                        }
                    }
                    fileOutputStream.close();
                    return absolutePath;
                } catch (FileNotFoundException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        return "";
                    }
                    return "";
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        return "";
                    }
                    return "";
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStream2;
        }
    }
}
