package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/crash/a.class */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        String str = null;
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String obj = stringWriter.toString();
            printWriter.close();
            str = obj;
            stringWriter.close();
            return obj;
        } catch (Exception e) {
            return str;
        }
    }
}
