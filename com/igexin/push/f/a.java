package com.igexin.push.f;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23636a = "BasicCheck";

    private static String a(int i) {
        String str;
        try {
            str = a(String.format("/proc/%d/cmdline", Integer.valueOf(i))).trim();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return a(String.format("/proc/%d/stat", Integer.valueOf(i))).split("\\s+")[1].replace("(", "").replace(")", "");
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        return str;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00f9: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:64:0x00f9 */
    private static String a(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileReader fileReader2;
        FileReader fileReader3;
        StringBuilder sb;
        try {
            try {
                sb = new StringBuilder();
                fileReader = new FileReader(str);
            } catch (Exception e) {
                e = e;
                bufferedReader2 = null;
                fileReader2 = null;
            } catch (Throwable th) {
                th = th;
                fileReader = null;
                bufferedReader = null;
            }
            try {
                BufferedReader bufferedReader3 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (Exception e2) {
                        e = e2;
                        fileReader2 = fileReader;
                        bufferedReader2 = bufferedReader3;
                        com.igexin.c.a.c.a.a(e);
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                return null;
                            } catch (Exception e4) {
                                com.igexin.c.a.c.a.a(e4);
                                return null;
                            }
                        }
                        return null;
                    }
                }
                if (sb.length() > 2) {
                    String substring = sb.substring(0, sb.length() - 2);
                    try {
                        fileReader.close();
                    } catch (Exception e5) {
                        com.igexin.c.a.c.a.a(e5);
                    }
                    try {
                        bufferedReader3.close();
                        return substring;
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        return substring;
                    }
                }
                String sb2 = sb.toString();
                try {
                    fileReader.close();
                } catch (Exception e7) {
                    com.igexin.c.a.c.a.a(e7);
                }
                try {
                    bufferedReader3.close();
                    return sb2;
                } catch (Exception e8) {
                    com.igexin.c.a.c.a.a(e8);
                    return sb2;
                }
            } catch (Exception e9) {
                e = e9;
                fileReader2 = fileReader;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e10) {
                        com.igexin.c.a.c.a.a(e10);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e11) {
                        com.igexin.c.a.c.a.a(e11);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileReader = fileReader3;
            th = th3;
        }
    }

    public static boolean a() {
        try {
            Class.forName("com.igexin.push.f.g");
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    public static boolean b() {
        try {
            String[] split = com.igexin.push.core.e.aI.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (com.igexin.push.core.e.F.toLowerCase().contains(split[i2].toLowerCase())) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }
}
