package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22578a = 0;
    private static final String b = "ExtractNativeUtils";

    /* renamed from: c  reason: collision with root package name */
    private static final int f22579c = -1;
    private static final int d = 128;
    private static final int e = 50;
    private static final int f = 52428800;
    private static Pattern g = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/x$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f22580a;
        ZipEntry b;

        /* renamed from: c  reason: collision with root package name */
        String f22581c;

        private a(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.f22580a = str;
            this.f22581c = str2;
        }

        /* synthetic */ a(ZipEntry zipEntry, String str, String str2, byte b) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) {
        ZipFile zipFile;
        aa.b(b, "begin extractNativeLibrary");
        int i = 0;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile.entries();
                        HashMap hashMap = new HashMap();
                        int a2 = a(entries, hashMap, 0);
                        if (a2 == -1) {
                            aa.d(b, "Unsafe zip name!");
                            ae.a(zipFile);
                            return -1;
                        } else if (a2 > 50) {
                            aa.d(b, "the total number is larger than the max");
                            ae.a(zipFile);
                            return -1;
                        } else {
                            Iterator it = hashMap.keySet().iterator();
                            int i2 = 0;
                            while (true) {
                                i = i2;
                                try {
                                    if (!it.hasNext()) {
                                        ae.a(zipFile);
                                        return i2;
                                    }
                                    int i3 = i2;
                                    Set set = (Set) hashMap.get((String) it.next());
                                    if (set == null) {
                                        i = i2;
                                        aa.d(b, "Get nativeZipEntries failed.");
                                        ae.a(zipFile);
                                        return -1;
                                    }
                                    Iterator it2 = set.iterator();
                                    int i4 = i2;
                                    while (true) {
                                        i2 = i4;
                                        if (it2.hasNext()) {
                                            int i5 = i4;
                                            a aVar = (a) it2.next();
                                            int i6 = i4;
                                            StringBuilder sb = new StringBuilder();
                                            int i7 = i4;
                                            sb.append(str);
                                            int i8 = i4;
                                            sb.append(File.separator);
                                            int i9 = i4;
                                            sb.append(aVar.f22581c);
                                            int i10 = i4;
                                            String sb2 = sb.toString();
                                            int i11 = i4;
                                            y.a(sb2);
                                            int i12 = i4;
                                            new File(sb2).setExecutable(true, false);
                                            int i13 = i4;
                                            i4 = a(zipFile, aVar, sb2);
                                            if (i4 != 0) {
                                                ae.a(zipFile);
                                                return i4;
                                            }
                                            new File(sb2, aVar.f22580a).setReadable(true, false);
                                        }
                                    }
                                } catch (IOException e2) {
                                    zipFile2 = zipFile;
                                    aa.d(b, "catch IOException");
                                    ae.a(zipFile);
                                    return i;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        zipFile2 = zipFile;
                        th = th;
                        ae.a(zipFile2);
                        throw th;
                    }
                } catch (IOException e3) {
                }
            } catch (IOException e4) {
                zipFile = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<a>> hashMap, int i) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    aa.d(b, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet<a> hashSet = hashMap.get(group);
                    HashSet<a> hashSet2 = hashSet;
                    if (hashSet == null) {
                        hashSet2 = new HashSet<>();
                        hashMap.put(group, hashSet2);
                    }
                    hashSet2.add(new a(zipEntry, group2, group, (byte) 0));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
        r0 = new java.lang.StringBuilder("so file too big , ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
        r0.append(r8.f22581c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0098, code lost:
        r0.append(" , ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a9, code lost:
        r0.append(r8.f22580a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b4, code lost:
        r13 = r0;
        r14 = r0;
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bc, code lost:
        com.huawei.hms.ads.uiengineloader.aa.d(com.huawei.hms.ads.uiengineloader.x.b, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c8, code lost:
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.zip.ZipFile r7, com.huawei.hms.ads.uiengineloader.x.a r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.x.a(java.util.zip.ZipFile, com.huawei.hms.ads.uiengineloader.x$a, java.lang.String):int");
    }

    public static int a(ZipFile zipFile, Set<a> set, String str) {
        aa.b(b, "begin extractNativeLibrary ");
        int i = 0;
        for (a aVar : set) {
            File file = new File(str);
            if (!file.exists()) {
                y.a(str);
            }
            file.setExecutable(true, false);
            i = a(zipFile, aVar, str);
            if (i != 0) {
                return i;
            }
            File file2 = new File(str, aVar.f22580a);
            if (Build.VERSION.SDK_INT < 23 && file2.getAbsolutePath().length() > 128) {
                aa.c(b, file2.getName() + "  too long,  length > 128");
                return -1;
            }
            file2.setReadable(true, false);
        }
        return i;
    }

    public static void a(Enumeration enumeration, Set<a> set, String str) throws ZipException {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    throw new ZipException("Unsafe zip name!");
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (group.equals(str)) {
                        set.add(new a(zipEntry, group2, group, (byte) 0));
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            aa.b(b, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                aa.b(b, "The extract-native-flag has set, need to extract.");
                return true;
            }
            aa.b(b, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception e2) {
            aa.c(b, "Get package name failed: name not found.");
            return true;
        }
    }
}
