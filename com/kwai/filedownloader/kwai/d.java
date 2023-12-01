package com.kwai.filedownloader.kwai;

import com.google.common.net.HttpHeaders;
import com.kwai.filedownloader.e.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/d.class */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String o = bVar.o(HttpHeaders.LOCATION);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        b bVar2 = bVar;
        String str = o;
        while (cG(responseCode)) {
            if (str == null) {
                throw new IllegalAccessException(f.j("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar2.W()));
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(d.class, "redirect to %s with %d, %s", str, Integer.valueOf(responseCode), arrayList);
            }
            bVar2.X();
            bVar2 = b(map, str);
            arrayList.add(str);
            bVar2.execute();
            responseCode = bVar2.getResponseCode();
            str = bVar2.o(HttpHeaders.LOCATION);
            i++;
            if (i >= 10) {
                throw new IllegalAccessException(f.j("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar2;
    }

    private static b b(Map<String, List<String>> map, String str) {
        b fp = com.kwai.filedownloader.download.b.HF().fp(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    fp.addHeader(key, str2);
                }
            }
        }
        return fp;
    }

    private static boolean cG(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
