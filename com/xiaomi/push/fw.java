package com.xiaomi.push;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fw.class */
public class fw {
    public static int a(Throwable th) {
        boolean z = th instanceof gf;
        Throwable th2 = th;
        if (z) {
            gf gfVar = (gf) th;
            th2 = th;
            if (gfVar.a() != null) {
                th2 = gfVar.a();
            }
        }
        String message = th2.getMessage();
        if (th2.getCause() != null) {
            message = th2.getCause().getMessage();
        }
        if (th2 instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(th2 instanceof SocketException)) {
            if (th2 instanceof UnknownHostException) {
                return 107;
            }
            return z ? 399 : 0;
        } else if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        } else {
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        }
    }
}
