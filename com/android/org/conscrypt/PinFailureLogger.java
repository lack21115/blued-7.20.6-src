package com.android.org.conscrypt;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;
import libcore.io.Base64;
import libcore.io.DropBox;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/PinFailureLogger.class */
public class PinFailureLogger {
    private static final long LOG_INTERVAL_NANOS = 817405952;
    private static long lastLoggedNanos = 0;

    public static void log(String str, boolean z, boolean z2, List<X509Certificate> list) {
        synchronized (PinFailureLogger.class) {
            try {
                if (timeToLog()) {
                    writeToLog(str, z, z2, list);
                    lastLoggedNanos = System.nanoTime();
                }
            } finally {
            }
        }
    }

    protected static boolean timeToLog() {
        return System.nanoTime() - lastLoggedNanos > LOG_INTERVAL_NANOS;
    }

    protected static void writeToLog(String str, boolean z, boolean z2, List<X509Certificate> list) {
        synchronized (PinFailureLogger.class) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("|");
                sb.append(z);
                sb.append("|");
                sb.append(z2);
                sb.append("|");
                for (X509Certificate x509Certificate : list) {
                    try {
                        sb.append(Base64.encode(x509Certificate.getEncoded()));
                    } catch (CertificateEncodingException e) {
                        sb.append("Error: could not encode certificate");
                    }
                    sb.append("|");
                }
                DropBox.addText("exp_det_cert_pin_failure", sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
