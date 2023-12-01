package com.alibaba.fastjson.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/ServiceLoader.class */
public class ServiceLoader {
    private static final String PREFIX = "META-INF/services/";
    private static final Set<String> loadedUrls = new HashSet();

    public static <T> Set<T> load(Class<T> cls, ClassLoader classLoader) {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String str = PREFIX + cls.getName();
        HashSet<String> hashSet2 = new HashSet();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                if (!loadedUrls.contains(nextElement.toString())) {
                    load(nextElement, hashSet2);
                    loadedUrls.add(nextElement.toString());
                }
            }
        } catch (IOException e) {
        }
        for (String str2 : hashSet2) {
            try {
                hashSet.add(classLoader.loadClass(str2).newInstance());
            } catch (Exception e2) {
            }
        }
        return hashSet;
    }

    public static void load(URL url, Set<String> set) throws IOException {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            inputStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            IOUtils.close(bufferedReader2);
                            IOUtils.close(inputStream);
                            return;
                        }
                        int indexOf = readLine.indexOf(35);
                        String str = readLine;
                        if (indexOf >= 0) {
                            str = readLine.substring(0, indexOf);
                        }
                        String trim = str.trim();
                        if (trim.length() != 0) {
                            set.add(trim);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        IOUtils.close(bufferedReader);
                        IOUtils.close(inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            bufferedReader = null;
        }
    }
}
