package com.tencent.turingface.sdk.mfa;

import android.os.Process;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/wmqhz.class */
public final class wmqhz {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f40009a;
    public static final String[] b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f40010c;

    static {
        HashSet hashSet = new HashSet();
        f40009a = hashSet;
        b = new String[0];
        hashSet.add(kC0XR.a(kC0XR.M));
        hashSet.add(kC0XR.a(kC0XR.N));
        hashSet.add(kC0XR.a(kC0XR.O));
        hashSet.add(kC0XR.a(kC0XR.P));
        hashSet.add(kC0XR.a(kC0XR.Q));
        hashSet.add(kC0XR.a(kC0XR.R));
        hashSet.add(kC0XR.a(kC0XR.S));
        hashSet.add(kC0XR.a(kC0XR.T));
        hashSet.add(kC0XR.a(kC0XR.U));
        hashSet.add(kC0XR.a(kC0XR.V));
        hashSet.add(kC0XR.a(kC0XR.W));
        hashSet.add(kC0XR.a(kC0XR.X));
        HashSet hashSet2 = new HashSet();
        f40010c = hashSet2;
        hashSet2.add(kC0XR.a(kC0XR.L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r0.length == 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.wmqhz.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static List<Bwfl9> a() {
        boolean z;
        boolean z2;
        bUA8L b2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = list[i2];
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b2 = com.tencent.turingcam.oqKCa.b(Integer.parseInt(str))) != null) {
                            arrayList2.add(b2);
                        }
                    } catch (Exception e) {
                    }
                }
                i = i2 + 1;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int myPid = Process.myPid();
        Iterator it = arrayList2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            bUA8L bua8l = (bUA8L) it.next();
            if (myPid == bua8l.f39939a) {
                i3 = bua8l.e;
            }
        }
        if (i3 != 0 && myPid != i3) {
            Iterator it2 = arrayList2.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                bUA8L bua8l2 = (bUA8L) it2.next();
                if (i3 == bua8l2.f39939a) {
                    str2 = bua8l2.d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Bwfl9 bwfl9 = new Bwfl9();
                bwfl9.f39862a = uAnWx.f40000a + uAnWx.e;
                bwfl9.b = str2;
                arrayList3.add(bwfl9);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            bUA8L bua8l3 = (bUA8L) it3.next();
            Iterator<String> it4 = f40009a.iterator();
            while (it4.hasNext()) {
                if (bua8l3.d.contains(it4.next())) {
                    sb.append(bua8l3.d);
                    sb.append(BridgeUtil.UNDERLINE_STR);
                }
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            Bwfl9 bwfl92 = new Bwfl9();
            bwfl92.f39862a = uAnWx.f40000a + uAnWx.f40001c;
            bwfl92.b = sb2.substring(0, sb2.length() - 1);
            arrayList4.add(bwfl92);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb3 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it5 = arrayList2.iterator();
        int i4 = 0;
        while (it5.hasNext()) {
            bUA8L bua8l4 = (bUA8L) it5.next();
            if (bua8l4.f39940c == 0 && bua8l4.d.startsWith(BridgeUtil.SPLIT_MARK) && !bua8l4.d.startsWith("/system") && !bua8l4.d.startsWith("/dev") && !bua8l4.d.startsWith("/sbin") && !bua8l4.d.startsWith("/init") && !bua8l4.d.startsWith("/vendor") && !bua8l4.d.startsWith("/bin") && !bua8l4.d.startsWith("/usr") && !bua8l4.d.contains("kinguser") && !bua8l4.d.endsWith("so")) {
                Iterator<String> it6 = f40009a.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        z = false;
                        break;
                    } else if (bua8l4.d.contains(it6.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    continue;
                } else {
                    Iterator<String> it7 = f40010c.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            z2 = false;
                            break;
                        } else if (bua8l4.d.contains(it7.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        continue;
                    } else {
                        hashSet.add(bua8l4.d);
                        if (i4 >= 8) {
                            break;
                        }
                        i4++;
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            Iterator it8 = hashSet.iterator();
            while (it8.hasNext()) {
                sb3.append((String) it8.next());
                sb3.append("%3B");
            }
            String sb4 = sb3.toString();
            Bwfl9 bwfl93 = new Bwfl9();
            bwfl93.f39862a = uAnWx.f40000a + uAnWx.d;
            bwfl93.b = sb4.substring(0, sb4.length() - 1);
            arrayList5.add(bwfl93);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a2 = a(kC0XR.a(kC0XR.o0), kC0XR.a(kC0XR.C0), "v4");
        if (!TextUtils.isEmpty(a2)) {
            stringBuffer.append(a2);
        }
        String a3 = a(kC0XR.a(kC0XR.p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (!TextUtils.isEmpty(a3)) {
            if (!TextUtils.isEmpty(a2)) {
                stringBuffer.append(BridgeUtil.UNDERLINE_STR);
            }
            stringBuffer.append(a3);
        }
        return stringBuffer.toString();
    }
}
