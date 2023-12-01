package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/a/b.class */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2 A[Catch: Exception -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x00b9, blocks: (B:22:0x0062, B:44:0x00b2), top: B:86:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ba -> B:85:0x00be). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.a.b.a(android.content.Context):java.lang.String");
    }

    public static void a(Context context, String str) {
        File c2 = c(context);
        if (c2 == null || !c2.exists()) {
            a(b(context), str);
        } else {
            a(c2, str);
        }
    }

    private static void a(File file, String str) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        if (file == null || !file.exists()) {
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file, false);
                    try {
                        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter);
                        String str2 = str;
                        try {
                            if (TextUtils.isEmpty(str)) {
                                str2 = "";
                            }
                            bufferedWriter3.write(str2);
                            bufferedWriter3.flush();
                            try {
                                bufferedWriter3.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            fileWriter.close();
                        } catch (Exception e2) {
                            bufferedWriter = bufferedWriter3;
                            e = e2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter2 = bufferedWriter3;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        bufferedWriter = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileWriter = null;
                    bufferedWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    private static File b(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir() + "/eAccount/Log/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "ipa_ol.ds");
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                return file2;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static File c(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir() + "/eAccount/Log/");
                if (file.exists()) {
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        return file2;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
