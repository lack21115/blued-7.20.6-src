package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/AndroidDnsServer.class */
public final class AndroidDnsServer {
    public static IResolver defaultResolver() {
        return new IResolver() { // from class: com.qiniu.android.dns.local.AndroidDnsServer.1
            @Override // com.qiniu.android.dns.IResolver
            public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
                InetAddress[] byReflection = AndroidDnsServer.getByReflection();
                InetAddress[] inetAddressArr = byReflection;
                if (byReflection == null) {
                    inetAddressArr = AndroidDnsServer.getByCommand();
                }
                if (inetAddressArr != null) {
                    return new HijackingDetectWrapper(new Resolver(inetAddressArr[0])).resolve(domain, networkInfo);
                }
                throw new IOException("cant get local dns server");
            }
        };
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0191: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:90:0x0191 */
    public static InetAddress[] getByCommand() {
        LineNumberReader lineNumberReader;
        InputStream inputStream;
        LineNumberReader lineNumberReader2;
        InputStream inputStream2;
        ArrayList arrayList;
        String hostAddress;
        try {
            try {
                try {
                    inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
                    try {
                        lineNumberReader2 = new LineNumberReader(new InputStreamReader(inputStream));
                    } catch (IOException e) {
                        e = e;
                        lineNumberReader2 = null;
                    } catch (Throwable th) {
                        th = th;
                        lineNumberReader = null;
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e2) {
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    inputStream = null;
                    lineNumberReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    lineNumberReader = null;
                    inputStream = null;
                }
                try {
                    arrayList = new ArrayList(5);
                    while (true) {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int indexOf = readLine.indexOf("]: [");
                        if (indexOf != -1) {
                            String substring = readLine.substring(1, indexOf);
                            String substring2 = readLine.substring(indexOf + 4, readLine.length() - 1);
                            if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                                InetAddress byName = InetAddress.getByName(substring2);
                                if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                                    arrayList.add(byName);
                                }
                            }
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e);
                    if (lineNumberReader2 != null) {
                        lineNumberReader2.close();
                    }
                    if (inputStream == null) {
                        return null;
                    }
                    inputStream.close();
                    return null;
                }
                if (arrayList.size() <= 0) {
                    lineNumberReader2.close();
                    if (inputStream == null) {
                        return null;
                    }
                    inputStream.close();
                    return null;
                }
                InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
                try {
                    lineNumberReader2.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return inetAddressArr;
                } catch (Exception e5) {
                    return inetAddressArr;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
            }
        } catch (Exception e6) {
            return null;
        }
    }

    public static InetAddress[] getByReflection() {
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            ArrayList arrayList = new ArrayList(5);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    break;
                }
                String str = (String) method.invoke(null, new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}[i2]);
                if (str != null && str.length() != 0 && (byName = InetAddress.getByName(str)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(byName)) {
                    arrayList.add(byName);
                }
                i = i2 + 1;
            }
            if (arrayList.size() > 0) {
                return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
            }
            return null;
        } catch (Exception e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e);
            return null;
        }
    }
}
