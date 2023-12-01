package com.google.auto.service.processor;

import com.google.common.base.Charsets;
import com.google.common.io.Closer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8110460-dex2jar.jar:com/google/auto/service/processor/ServicesFiles.class */
final class ServicesFiles {
    public static final String SERVICES_PATH = "META-INF/services";

    private ServicesFiles() {
    }

    static String getPath(String str) {
        return "META-INF/services/" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> readServiceFile(InputStream inputStream) throws IOException {
        HashSet hashSet = new HashSet();
        try {
            BufferedReader bufferedReader = (BufferedReader) Closer.create().register(new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return hashSet;
                }
                int indexOf = readLine.indexOf(35);
                String str = readLine;
                if (indexOf >= 0) {
                    str = readLine.substring(0, indexOf);
                }
                String trim = str.trim();
                if (!trim.isEmpty()) {
                    hashSet.add(trim);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeServiceFile(Collection<String> collection, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charsets.UTF_8));
        for (String str : collection) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
