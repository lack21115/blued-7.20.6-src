package com.igexin.base.util;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/util/IOUtils.class */
public class IOUtils {
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
