package com.igexin.push.config;

import com.igexin.push.f.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f9769a = "FileConfig";

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093 A[Catch: all -> 0x0147, Exception -> 0x0194, TryCatch #16 {Exception -> 0x0194, all -> 0x0147, blocks: (B:31:0x0083, B:33:0x0093, B:36:0x00cf, B:37:0x00d8, B:38:0x00d9, B:38:0x00d9, B:39:0x00dc, B:40:0x00e4), top: B:118:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff A[Catch: all -> 0x012a, Exception -> 0x01a3, TRY_ENTER, TryCatch #15 {Exception -> 0x01a3, all -> 0x012a, blocks: (B:43:0x00f7, B:45:0x00ff, B:47:0x0108), top: B:119:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0113 A[EDGE_INSN: B:98:0x0113->B:48:0x0113 ?: BREAK  , EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.e.a():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(InputStream inputStream) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                                return;
                            }
                        } else if (!readLine.startsWith("#")) {
                            String[] split = readLine.split("=");
                            boolean z = true;
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                switch (trim.hashCode()) {
                                    case -1784363506:
                                        if (trim.equals("sdk.readlocalcell.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -1734610495:
                                        if (trim.equals("sdk.enter.backup.detect.failed.cnt")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -1286040506:
                                        if (trim.equals("sdk.detect.ip.expired.time")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -1050591911:
                                        if (trim.equals("sdk.feature.setsilenttime.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -1004501973:
                                        if (trim.equals("sdk.config_address")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -416668775:
                                        if (trim.equals("sdk.feature.setsockettimeout.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -367623287:
                                        if (trim.equals("sdk.address.id")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case -52474114:
                                        if (trim.equals("sdk.feature.sendmessage.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 85426222:
                                        if (trim.equals("sdk.cm_address_backup")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 178406040:
                                        if (trim.equals("sdk.stay.backup.time")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 275980049:
                                        if (trim.equals("sdk.login.failed.cnt")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 352273926:
                                        if (trim.equals("sdk.feature.setheartbeatinterval.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 914256432:
                                        if (trim.equals("sdk.bi_address")) {
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1188929677:
                                        if (trim.equals("sdk.feature.settag.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1457933893:
                                        if (trim.equals("sdk.log_address")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1488582065:
                                        if (trim.equals("sdk.address.key")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1603576119:
                                        if (trim.equals("sdk.domainbackup.enable")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1676315519:
                                        if (trim.equals("sdk.detect.interval.time")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 2077859667:
                                        if (trim.equals("sdk.cm_address")) {
                                            z = false;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    default:
                                        z = true;
                                        break;
                                }
                                switch (z) {
                                    case false:
                                        SDKUrlConfig.setXfrAddressIps(trim2.split(","));
                                        break;
                                    case true:
                                        SDKUrlConfig.CONFIG_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case true:
                                        SDKUrlConfig.BI_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case true:
                                        SDKUrlConfig.LOG_ADDRESS_IPS = trim2.split(",");
                                        break;
                                    case true:
                                        SDKUrlConfig.XFR_ADDRESS_BAK = trim2.split(",");
                                        break;
                                    case true:
                                        d.g = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.h = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.j = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.k = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.l = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.m = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.n = Boolean.parseBoolean(trim2);
                                        break;
                                    case true:
                                        d.r = Long.parseLong(trim2) * 1000;
                                        break;
                                    case true:
                                        d.s = Integer.parseInt(trim2);
                                        break;
                                    case true:
                                        d.t = Integer.parseInt(trim2);
                                        break;
                                    case true:
                                        d.u = Long.parseLong(trim2) * 1000;
                                        break;
                                    case true:
                                        d.v = Long.parseLong(trim2) * 1000;
                                        break;
                                    case true:
                                        com.igexin.push.f.g.f10040a = trim2;
                                        break;
                                    case true:
                                        com.igexin.push.f.g.b = trim2;
                                        break;
                                }
                                com.igexin.c.a.c.a.a(f9769a, "loadConfigFromFile, config line:".concat(String.valueOf(readLine)));
                            }
                        }
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader3 = bufferedReader;
                        sb.append(f9769a);
                        BufferedReader bufferedReader4 = bufferedReader;
                        sb.append("｜no config file found.");
                        BufferedReader bufferedReader5 = bufferedReader;
                        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Boolean bool) {
        try {
            if (new File(j.e).exists()) {
                b(bool);
                return;
            }
            byte[] bytes = "sdk.debug=".concat(String.valueOf(bool)).getBytes();
            if (bytes != null) {
                j.a(bytes, j.e);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(boolean z, boolean z2) {
        try {
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f9870a, Boolean.valueOf(z));
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b, Boolean.valueOf(z2));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static int b() {
        try {
            Boolean a2 = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f9870a);
            int i = a2 == null ? -1 : a2.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(f9769a + "|getGuardMeFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static void b(Boolean bool) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            fileInputStream = new FileInputStream(j.e);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            } catch (Exception e) {
                bufferedReader2 = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Exception e2) {
            fileInputStream = null;
            bufferedReader2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("#")) {
                    sb.append(readLine);
                } else {
                    String[] split = readLine.split("=");
                    if (split.length < 2) {
                        sb.append(readLine);
                    } else {
                        String trim = split[0].trim();
                        split[1].trim();
                        if (!trim.equals("sdk.debug")) {
                            sb.append(readLine);
                        }
                    }
                }
                sb.append("\n");
            }
            sb.append("sdk.debug=".concat(String.valueOf(bool)));
            byte[] bytes = sb.toString().getBytes();
            if (bytes != null) {
                j.a(bytes, j.e);
            }
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
            try {
                fileInputStream.close();
            } catch (Exception e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        } catch (Exception e5) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    com.igexin.c.a.c.a.a(e6);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                    com.igexin.c.a.c.a.a(e7);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e8) {
                    com.igexin.c.a.c.a.a(e8);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e9) {
                    com.igexin.c.a.c.a.a(e9);
                }
            }
            throw th;
        }
    }

    public static int c() {
        try {
            Boolean a2 = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b);
            int i = a2 == null ? -1 : a2.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(f9769a + "|getGuardOthersFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }
}
