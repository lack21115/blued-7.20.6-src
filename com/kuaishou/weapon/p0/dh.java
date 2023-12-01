package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dh.class */
public class dh {
    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            try {
                String readLine = bufferedReader.readLine();
                String str2 = "";
                if (readLine != null) {
                    str2 = "" + readLine;
                }
                try {
                    bufferedReader.close();
                    return str2;
                } catch (Exception e) {
                    return str2;
                }
            } catch (Exception e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Exception e3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b() {
        try {
            String a2 = a(" pidof adbd ");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String str = a2;
            if (a2.length() > 10) {
                str = a2.substring(0, 10);
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.contains("TCP") && !readLine.contains(":443")) {
                    arrayList.add(readLine);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Set c() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            HashSet hashSet = new HashSet();
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -nap ").getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.contains("tcp") && readLine.contains("ESTABLISHED") && readLine.contains(":5555 ")) {
                        hashSet.add(readLine);
                    }
                } catch (Exception e) {
                    if (bufferedReader != null) {
                        bufferedReader2 = bufferedReader;
                        bufferedReader2.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            }
            bufferedReader2 = bufferedReader;
            if (hashSet.size() > 0) {
                try {
                    bufferedReader.close();
                    return hashSet;
                } catch (Exception e3) {
                    return hashSet;
                }
            }
        } catch (Exception e4) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            bufferedReader2.close();
            return null;
        } catch (Exception e5) {
            return null;
        }
    }

    public static int d() {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -apn | grep scrcpy ").getInputStream()));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return 0;
                        } catch (Exception e) {
                            return 0;
                        }
                    }
                } catch (Exception e2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return 0;
                        } catch (Exception e3) {
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } while (!readLine.contains("scrcpy"));
            try {
                bufferedReader.close();
                return 1;
            } catch (Exception e5) {
                return 1;
            }
        } catch (Exception e6) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[Catch: all -> 0x00d2, Exception -> 0x00f7, TRY_ENTER, TryCatch #8 {Exception -> 0x00f7, all -> 0x00d2, blocks: (B:4:0x001c, B:5:0x001f, B:7:0x0026, B:9:0x002e, B:11:0x0039, B:14:0x0043, B:16:0x004b, B:18:0x0053, B:23:0x0072, B:27:0x007f, B:28:0x008b, B:32:0x009b, B:36:0x00ab, B:20:0x005f, B:22:0x0068, B:40:0x00bb), top: B:84:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x007c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject e() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dh.e():org.json.JSONObject");
    }
}
