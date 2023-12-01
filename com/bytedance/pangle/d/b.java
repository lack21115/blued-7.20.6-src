package com.bytedance.pangle.d;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bun.miitmdid.core.Utils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f21369a;
    private static Map<String, Integer> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("arm64-v8a", 64);
        b.put("armeabi-v7a", 32);
        b.put("armeabi", 32);
        b.put("x86_64", 64);
        b.put(Utils.CPU_ABI_X86, 32);
        b.put("mips64", 64);
        b.put("mips", 32);
        f21369a = c();
    }

    public static com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> a(File file) {
        ZipFile zipFile;
        boolean a2;
        HashMap hashMap = new HashMap();
        ZipFile zipFile2 = null;
        try {
            try {
                ZipFile zipFile3 = new ZipFile(file);
                try {
                    hashMap.putAll(a(zipFile3));
                    if (hashMap.isEmpty()) {
                        a2 = true;
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                    } else {
                        a2 = a(hashMap, f21369a);
                        if (a2) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                        }
                    }
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar = new com.bytedance.pangle.util.e<>(Boolean.valueOf(a2), hashMap);
                    try {
                        zipFile3.close();
                        return eVar;
                    } catch (IOException e) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        return eVar;
                    }
                } catch (IOException e2) {
                    zipFile = zipFile3;
                    e = e2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    zipFile2 = zipFile;
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar2 = new com.bytedance.pangle.util.e<>(Boolean.FALSE, hashMap);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return eVar2;
                        } catch (IOException e3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                            return eVar2;
                        }
                    }
                    return eVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile2 = zipFile3;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
        }
    }

    public static String a() {
        String str = f21369a;
        if (str != null) {
            return str;
        }
        String c2 = c();
        f21369a = c2;
        return c2;
    }

    private static String a(JSONObject jSONObject) {
        int i;
        if (i.a()) {
            try {
                String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "primaryCpuAbi", str);
                if (str != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        int i2 = 0;
                        try {
                            i = Process.is64Bit() ? 64 : 32;
                            i2 = i;
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i2)));
                            i = i2;
                        }
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
                        i = 0;
                    }
                    a(jSONObject, "processMode", String.valueOf(i));
                    if (i == 0) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
                        return str;
                    } else if (b.get(str).intValue() == i) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                        return str;
                    } else {
                        return null;
                    }
                }
                return null;
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e2);
                a(jSONObject, "autoError", "1");
                return null;
            }
        }
        return null;
    }

    private static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (b.containsKey(str)) {
                    if (hashMap.get(str) == 0) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(File file, File file2, String str, Map<String, List<ZipEntry>> map) {
        ZipFile zipFile;
        Map<String, List<ZipEntry>> a2;
        boolean z;
        try {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.mSharedHostSos.size() != 0) {
                ArrayList arrayList = new ArrayList(plugin.mSharedHostSos);
                String str2 = Zeus.getAppApplication().getApplicationInfo().nativeLibraryDir;
                if (!TextUtils.isEmpty(str2)) {
                    String[] split = str2.split(File.pathSeparator);
                    for (String str3 : plugin.mSharedHostSos) {
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < length) {
                                File file3 = new File(split[i2], str3);
                                if (arrayList.contains(str3) && file3.exists()) {
                                    h.a(file3.getAbsolutePath(), new File(file2, str3).getAbsolutePath());
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file3.getAbsolutePath());
                                    arrayList.remove(str3);
                                }
                                i = i2 + 1;
                            }
                        }
                    }
                }
            }
            ZipFile zipFile2 = new ZipFile(file);
            if (map == null) {
                try {
                    a2 = a(zipFile2);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } else {
                a2 = map;
            }
            boolean a3 = a(a2, f21369a);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + a3 + "], pkg=" + str);
            if (a3) {
                LinkedList<ZipEntry> linkedList = null;
                if (a2 != null) {
                    if (!a2.isEmpty()) {
                        linkedList = new LinkedList();
                        HashSet hashSet = new HashSet();
                        String str4 = f21369a;
                        switch (str4.hashCode()) {
                            case -1073971299:
                                if (str4.equals("mips64")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case -806050265:
                                if (str4.equals("x86_64")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case -738963905:
                                if (str4.equals("armeabi")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 117110:
                                if (str4.equals(Utils.CPU_ABI_X86)) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 3351711:
                                if (str4.equals("mips")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 145444210:
                                if (str4.equals("armeabi-v7a")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1431565292:
                                if (str4.equals("arm64-v8a")) {
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
                                a(a2, "arm64-v8a", linkedList, hashSet);
                                break;
                            case true:
                                a(a2, "armeabi-v7a", linkedList, hashSet);
                                a(a2, "armeabi", linkedList, hashSet);
                                break;
                            case true:
                                a(a2, "armeabi", linkedList, hashSet);
                                a(a2, "armeabi-v7a", linkedList, hashSet);
                                break;
                            case true:
                                a(a2, "x86_64", linkedList, hashSet);
                                break;
                            case true:
                                a(a2, Utils.CPU_ABI_X86, linkedList, hashSet);
                                break;
                            case true:
                                a(a2, "mips64", linkedList, hashSet);
                                break;
                            case true:
                                a(a2, "mips", linkedList, hashSet);
                                break;
                        }
                    } else {
                        linkedList = null;
                    }
                }
                if (linkedList != null && !linkedList.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    for (ZipEntry zipEntry : linkedList) {
                        a(zipFile2, zipEntry, file2);
                    }
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                zipFile2.close();
                return;
            }
            zipFile2.close();
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
        }
    }

    private static void a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        boolean z;
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i = 0;
        boolean z2 = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                g.a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
            } catch (IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
                z = z2;
            }
            z2 = z;
        } while (!z);
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(Map<String, List<ZipEntry>> map, String str) {
        return (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) ? map.containsKey("armeabi") || map.containsKey("armeabi-v7a") : map.containsKey(str);
    }

    public static int b() {
        return b.get(a()).intValue();
    }

    private static String b(JSONObject jSONObject) {
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException e) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            String[] strArr = i.a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (!hashSet.isEmpty()) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr[i2];
                    if (hashSet.contains(str)) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                        a(jSONObject, "matchCpuAbi", str);
                        return str;
                    }
                    i = i2 + 1;
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                a(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            a(jSONObject, "manualError", "1");
            if (i.a()) {
                a(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            a(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        }
    }

    public static boolean b(File file) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                            try {
                                zipFile.close();
                                return true;
                            } catch (IOException e) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (IOException e2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        return false;
                    }
                } catch (IOException e3) {
                    e = e3;
                    zipFile2 = zipFile;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException e4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    zipFile2 = zipFile;
                    th = th;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e5) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
        }
    }

    private static String c() {
        JSONObject d = d();
        String a2 = a(d);
        String str = a2;
        if (a2 == null) {
            str = b(d);
        }
        return str;
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
