package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ac.class */
public class ac {
    private String a(int i, int i2) {
        StringBuilder sb;
        String str;
        if (i2 < 26) {
            return "u:r:untrusted_app";
        }
        if (i < i2) {
            if (i < 26) {
                sb = new StringBuilder();
                sb.append("u:r:untrusted_app");
                str = "_25:s0";
            } else if (i2 != 27) {
                if (i2 == 28 || i2 == 29) {
                    if (i < 26) {
                        return "u:r:untrusted_app";
                    }
                    sb = new StringBuilder();
                } else if (i2 != 30) {
                    return "u:r:untrusted_app";
                } else {
                    if (i >= 29) {
                        sb = new StringBuilder();
                        sb.append("u:r:untrusted_app");
                        str = "_29:s0";
                    } else {
                        sb = new StringBuilder();
                    }
                }
                sb.append("u:r:untrusted_app");
                sb.append("_27:s0");
                return sb.toString();
            } else if (i < 26) {
                return "u:r:untrusted_app";
            } else {
                sb = new StringBuilder();
            }
            sb.append(str);
            return sb.toString();
        }
        sb = new StringBuilder();
        sb.append("u:r:untrusted_app");
        sb.append(":s0");
        return sb.toString();
    }

    public boolean a() {
        return Process.myUid() / 100000 != 0;
    }

    public boolean a(Context context) {
        try {
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            return new File(absolutePath + File.separator + "..").canRead();
        } catch (Throwable th) {
            return false;
        }
    }

    public String b(Context context) {
        try {
            return context.getFilesDir().getParentFile().getAbsolutePath();
        } catch (Throwable th) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null || map.size() <= 0) {
                return null;
            }
            for (Object obj : map.keySet()) {
                if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                    File file = new File("/data/data" + File.separator + obj.toString());
                    if (file.exists() && file.canWrite()) {
                        return obj.toString();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONArray d(Context context) {
        BufferedReader bufferedReader;
        String substring;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/self/maps"));
            try {
                HashSet hashSet = new HashSet();
                String packageName = context.getPackageName();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (!readLine.contains("@Hw") && !readLine.contains(".apk@classes.dex") && !readLine.contains("WebViewGoogle") && !readLine.contains("FeatureFramework") && !readLine.contains("framework@oppo") && !readLine.contains("framework@mediatek")) {
                            if (hashSet.size() > 15) {
                                break;
                            }
                            if (!readLine.contains(packageName) && readLine.contains("/data/") && readLine.contains(".so")) {
                                substring = readLine.substring(readLine.indexOf("/data/"), readLine.indexOf(".so") + 3);
                            } else if (!readLine.contains(packageName) && readLine.contains("/data/") && readLine.contains(ShareConstants.DEX_SUFFIX)) {
                                substring = readLine.substring(readLine.indexOf("/data/"), readLine.indexOf(ShareConstants.DEX_SUFFIX) + 4);
                            }
                            hashSet.add(substring);
                        }
                    } else {
                        break;
                    }
                }
                bufferedReader = bufferedReader2;
                if (hashSet.size() > 0) {
                    JSONArray jSONArray = new JSONArray((Collection) hashSet);
                    try {
                        bufferedReader2.close();
                        return jSONArray;
                    } catch (IOException e) {
                        return jSONArray;
                    }
                }
            } catch (Throwable th) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return null;
                }
                bufferedReader.close();
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int e(Context context) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public boolean f(Context context) {
        try {
            int i = context.getApplicationInfo().targetSdkVersion;
            Class<?> cls = Class.forName("android.os.SELinux");
            String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
            String a2 = a(i, Build.VERSION.SDK_INT);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !str.startsWith(a2);
        } catch (Exception e) {
            return false;
        }
    }
}
