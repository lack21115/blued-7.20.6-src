package com.amap.api.col.p0003sl;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.amap.api.col.3sl.ba  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ba.class */
public final class ba extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f4770a;
    private bm b;

    public ba(Context context) {
        this.f4770a = context;
        this.b = bm.a(context);
    }

    private static bh a(File file) {
        String a2 = dw.a(file);
        bh bhVar = new bh();
        bhVar.b(a2);
        return bhVar;
    }

    private bh a(String str) {
        String str2 = str;
        if (str.equals("quanguo")) {
            str2 = "quanguogaiyaotu";
        }
        ax a2 = ax.a(this.f4770a);
        bh bhVar = null;
        bh bhVar2 = null;
        if (a2 != null) {
            String g = a2.g(str2);
            File[] listFiles = new File(dw.c(this.f4770a)).listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    bhVar = bhVar2;
                    if (i2 >= length) {
                        break;
                    }
                    File file = listFiles[i2];
                    if ((file.getName().contains(g) || file.getName().contains(str2)) && file.getName().endsWith(".zip.tmp.dt")) {
                        bh a3 = a(file);
                        bhVar2 = a3;
                        if (a3.c() != null) {
                            return a3;
                        }
                    }
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        }
        return bhVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x011e, code lost:
        if (r0.contains(r0.h()) != false) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ba.a():void");
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(dw.b(this.f4770a) + str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                String substring = name.substring(0, lastIndexOf);
                if (!arrayList.contains(substring)) {
                    arrayList.add(substring);
                }
            }
            i = i2 + 1;
        }
    }

    private static boolean a(String str, ArrayList<bh> arrayList) {
        Iterator<bh> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().h())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> b() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(dw.c(this.f4770a));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                File file2 = listFiles[i2];
                if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.ArrayList<java.lang.String> r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ba.b(java.util.ArrayList, java.lang.String):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
