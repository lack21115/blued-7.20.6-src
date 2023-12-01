package com.ishumei.l111l11111Il;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l11l1111I1l.class */
public final class l11l1111I1l {
    public static HashMap<String, String> l1111l111111Il() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Class<?> loadClass = Context.class.getClassLoader().loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1ac868c8b9a92af8d908f9a8d8b969a8c"));
            Method method = loadClass.getMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8b"), String.class);
            method.setAccessible(true);
            String l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d19b9a9d8a98989e9d939a");
            String l111l11111Il2 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d19d90908bd1979e8d9b889e8d9a");
            String l111l11111Il3 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("988c92d18c9692d18c8b9e8b9a");
            String l111l11111Il4 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c868cd18a8c9dd18c8b9e8b9a");
            String l111l11111Il5 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d18d9693d1909a92d18c9190");
            String l111l11111Il6 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d18d9693d1909a92d18f8c9190");
            String l111l11111Il7 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d18d8f929dd19d909e8d9b");
            String l111l11111Il8 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c868cd18c9a8d969e939190");
            String l111l11111Il9 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d90d19d90908bd18c9a9c8a8d9a9d90908b949a86979e8c97");
            String l111l11111Il10 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8f9a8d8c968c8bd18c868cd18c979088d19b9a89969c9ad196929a96");
            String l111l11111Il11 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("988c92d18c9a8d969e93");
            String l111l11111Il12 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8f9a8d8c968c8bd18d9e9b9690d18c9a8d969e939190");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 12) {
                    return hashMap;
                }
                String str = new String[]{l111l11111Il, l111l11111Il2, l111l11111Il3, l111l11111Il4, l111l11111Il5, l111l11111Il6, l111l11111Il7, l111l11111Il8, l111l11111Il9, l111l11111Il10, l111l11111Il11, l111l11111Il12}[i2];
                String str2 = (String) method.invoke(loadClass, str);
                if (str2 != null && !str2.isEmpty()) {
                    hashMap.put(str, str2);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return hashMap;
        }
    }
}
