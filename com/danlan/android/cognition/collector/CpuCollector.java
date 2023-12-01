package com.danlan.android.cognition.collector;

import android.content.Context;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/CpuCollector.class */
public class CpuCollector extends SubCollector {
    private static final int EI_CLASS = 4;
    private static final int ELFCLASS32 = 1;
    private static final int ELFCLASS64 = 2;
    private Context mcontext;
    private static final String CPU_ARCHITECTURE_KEY_64 = StringFog.decrypt("U0wKU1NMQFRCVwpAUVYKQENKSEpSVxIV");
    private static final String CPU_ARCHITECTURE_TYPE_32 = StringFog.decrypt("EhE=");
    private static final String CPU_ARCHITECTURE_TYPE_64 = StringFog.decrypt("Fxc=");
    private static final String PROC_CPU_INFO_PATH = StringFog.decrypt("DlNWTEIMR1FUSkpFTg==");
    private static final String SYSTEM_LIB_C_PATH = StringFog.decrypt("DlBdUFVGSQ5NSkYMTUpGQg9QSw==");
    private static final String SYSTEM_LIB_C_PATH_64 = StringFog.decrypt("DlBdUFVGSQ5NSkYVFQxISENAClBO");
    private static String vendor_id = StringFog.decrypt("VE1PTU5USg==");
    private static String cpuHardware = StringFog.decrypt("VE1PTU5USg==");
    private static String features = StringFog.decrypt("VE1PTU5USg==");

    public CpuCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void collectOtherCpuInfo() {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.collectOtherCpuInfo():void");
    }

    private void filterKey(String str, String str2) {
        if (str.equalsIgnoreCase(StringFog.decrypt("aUJWR1ZCVkQ="))) {
            cpuHardware = str2;
        } else if (str.equalsIgnoreCase(StringFog.decrypt("V0ZKR05Re0hF"))) {
            vendor_id = str2;
        } else if (str.equalsIgnoreCase(StringFog.decrypt("Z0ZFV1RRQVI="))) {
            features = str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCpuDriver() {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCpuDriver():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCpuType() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCpuType():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
        if (r5 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
        if (r5 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ab, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCurCpuFreq() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCurCpuFreq():java.lang.String");
    }

    private boolean isCPUInfo64() {
        FileInputStream fileInputStream;
        File file = new File(PROC_CPU_INFO_PATH);
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream), 512);
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null && readLine.length() > 0) {
                            if (readLine.toLowerCase(Locale.US).contains(StringFog.decrypt("QFFHSxcX"))) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                try {
                                    fileInputStream.close();
                                    return true;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return true;
                                }
                            }
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileInputStream == null) {
                            return false;
                        }
                        fileInputStream.close();
                        return false;
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
                return false;
            } catch (Exception e5) {
                e5.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private boolean isLibc64() {
        byte[] readELFHeadrIndentArray;
        byte[] readELFHeadrIndentArray2;
        File file = new File(SYSTEM_LIB_C_PATH);
        if (file.exists() && (readELFHeadrIndentArray2 = readELFHeadrIndentArray(file)) != null && readELFHeadrIndentArray2[4] == 2) {
            return true;
        }
        File file2 = new File(SYSTEM_LIB_C_PATH_64);
        return file2.exists() && (readELFHeadrIndentArray = readELFHeadrIndentArray(file2)) != null && readELFHeadrIndentArray[4] == 2;
    }

    private byte[] readELFHeadrIndentArray(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream2 = fileInputStream;
        } catch (Throwable th) {
            fileInputStream = null;
        }
        try {
            try {
                if (fileInputStream.available() > 0) {
                    byte[] bArr = new byte[16];
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream.read(bArr, 0, 16) == 16) {
                        try {
                            fileInputStream.close();
                            return bArr;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return bArr;
                        }
                    }
                }
            } catch (Throwable th2) {
                if (fileInputStream != null) {
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    return null;
                }
                return null;
            }
            fileInputStream2.close();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        collectOtherCpuInfo();
        safeJSONObject.put(StringFog.decrypt("QlNRa0BRQFZAUUE="), cpuHardware);
        safeJSONObject.put(StringFog.decrypt("V0ZKR05Re0hF"), vendor_id);
        safeJSONObject.put(StringFog.decrypt("QlNRYlNATA=="), getArchType());
        safeJSONObject.put(StringFog.decrypt("UlZUU05RUERFYkZKUg=="), getSupportAbi());
        safeJSONObject.put(StringFog.decrypt("QkxWRm9WSUNEUQ=="), getCoreNumber());
        safeJSONObject.put(StringFog.decrypt("TEJcZVNGVQ=="), getMaxCpuFreq());
        safeJSONObject.put(StringFog.decrypt("TEpKZVNGVQ=="), getMinCpuFreq());
        safeJSONObject.put(StringFog.decrypt("QlZWUURNUGdTRlU="), getCurCpuFreq());
        safeJSONObject.put(StringFog.decrypt("R0ZFV1RRQVI="), features);
        safeJSONObject.put(StringFog.decrypt("VVpURg=="), getCpuType());
        safeJSONObject.put(StringFog.decrypt("RVFNVURR"), getCpuDriver());
        put(StringFog.decrypt("QlNR"), safeJSONObject);
        collectDone();
    }

    public final String getArchType() {
        if ((NativeLib.checkLoadSo() ? NativeLib.pg(CPU_ARCHITECTURE_KEY_64, "") : "").isEmpty() && !isCPUInfo64() && !isLibc64()) {
            return CPU_ARCHITECTURE_TYPE_32;
        }
        return CPU_ARCHITECTURE_TYPE_64;
    }

    public final int getCoreNumber() {
        try {
            return new File(StringFog.decrypt("DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EO")).listFiles(new FileFilter() { // from class: com.danlan.android.cognition.collector.CpuCollector.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches(StringFog.decrypt("QlNReBEOHXw="), file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00af, code lost:
        if (r8 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getMaxCpuFreq() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getMaxCpuFreq():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00af, code lost:
        if (r8 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getMinCpuFreq() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getMinCpuFreq():java.lang.String");
    }

    public final String getSupportAbi() {
        String decrypt = StringFog.decrypt("VE1PTU5USg==");
        if (NativeLib.checkLoadSo()) {
            String pg = NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpAUVYKQENKSEpSVw=="), StringFog.decrypt("VE1PTU5USg=="));
            decrypt = pg;
            if (pg.equals(StringFog.decrypt("VE1PTU5USg=="))) {
                decrypt = NativeLib.pg(StringFog.decrypt("U0wKUFhQUERMDVRRTkdRQlUNR1NUDUVDSE9NUFU="), StringFog.decrypt("VE1PTU5USg=="));
            }
        }
        return decrypt;
    }
}
