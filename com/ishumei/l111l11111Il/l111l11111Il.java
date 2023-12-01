package com.ishumei.l111l11111Il;

import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111Il.class */
public final class l111l11111Il {
    public static HashMap<String, String> l1111l111111Il(boolean z) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1bd8a96939b");
            Field[] l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l111l11111Il);
            if (z) {
                try {
                    Object l1111l111111Il2 = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l111l11111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9a8d969e93"));
                    if (l1111l111111Il2 != null) {
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c9a8d969e93a0af"), l1111l111111Il2.toString());
                    }
                } catch (Throwable th) {
                }
                str = "9d909e8d9bd392909b9a93d38c9a8d969e93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
            } else {
                str = "9d909e8d9bd392909b9a93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
            }
            String l111l11111Il2 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il(str);
            int length = l1111l111111Il.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return hashMap;
                }
                Field field = l1111l111111Il[i2];
                field.setAccessible(true);
                String lowerCase = field.getName().toLowerCase();
                if (l111l11111Il2.contains(lowerCase)) {
                    hashMap.put(lowerCase, field.get(null).toString());
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return hashMap;
        }
    }
}
