package com.unikuwei.mianmi.account.shield.tencent.e;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/b.class */
public class b {
    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                a(listFiles[i2]);
                i = i2 + 1;
            }
        }
        file.delete();
    }

    public static void a(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str));
                    try {
                        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream);
                        try {
                            bufferedOutputStream3.write(bArr);
                            bufferedOutputStream3.flush();
                            try {
                                bufferedOutputStream3.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            bufferedOutputStream = bufferedOutputStream3;
                            e = e2;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream3;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        bufferedOutputStream = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00c3: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:61:0x00c3 */
    public static byte[] a(InputStream inputStream) {
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(8192);
                } catch (FileNotFoundException e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable2 = null;
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (autoCloseable2 != null) {
                        try {
                            autoCloseable2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (FileNotFoundException e6) {
                    e = e6;
                    e.printStackTrace();
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                        return null;
                    }
                    return null;
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                        return null;
                    }
                    return null;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                return inputStream;
            }
        } catch (Throwable th3) {
            autoCloseable2 = autoCloseable;
            th = th3;
        }
    }
}
