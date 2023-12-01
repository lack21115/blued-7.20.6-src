package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ak.class */
public final class ak {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void a(String str, byte[] bArr, boolean z, int i) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        try {
            fileOutputStream2 = new FileOutputStream(new File(str), z);
            try {
                bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2);
            } catch (Exception e) {
                bufferedOutputStream2 = null;
            } catch (Throwable th) {
                bufferedOutputStream = null;
                fileOutputStream = fileOutputStream2;
                th = th;
            }
        } catch (Exception e2) {
            fileOutputStream2 = null;
            bufferedOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream3.write(bArr, 0, i);
            try {
                bufferedOutputStream3.close();
                fileOutputStream2.close();
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            bufferedOutputStream2 = bufferedOutputStream3;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e5) {
                    return;
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            bufferedOutputStream = bufferedOutputStream3;
            fileOutputStream = fileOutputStream2;
            th = th3;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e6) {
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(Context context, String str) {
        StringBuilder sb;
        try {
            String[] list = context.getAssets().list("");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.length) {
                    sb = new StringBuilder();
                    break;
                } else if (list[i2].equals(str.trim())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" exist");
                    return true;
                } else {
                    i = i2 + 1;
                }
            }
        } catch (IOException e) {
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append(" not exist");
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static String b(Context context, String str) {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            if (open.read(bArr) <= 0) {
                if (open != null) {
                    try {
                        open.close();
                        return "";
                    } catch (IOException e) {
                        return "";
                    }
                }
                return "";
            }
            open.close();
            inputStream2 = open;
            inputStream = open;
            String str2 = new String(bArr, "utf-8");
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e2) {
                    return str2;
                }
            }
            return str2;
        } catch (IOException e3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return "";
                } catch (IOException e4) {
                    return "";
                }
            }
            return "";
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public static String b(String str) {
        File file = new File(str);
        StringBuilder sb = new StringBuilder("");
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            bufferedReader2.close();
                            String sb2 = sb.toString();
                            try {
                                bufferedReader2.close();
                                return sb2;
                            } catch (IOException e) {
                                throw new RuntimeException("IOException occurred. ", e);
                            }
                        }
                        sb.append(readLine);
                    } catch (IOException e2) {
                        e = e2;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                throw new RuntimeException("IOException occurred. ", e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
