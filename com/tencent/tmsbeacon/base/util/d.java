package com.tencent.tmsbeacon.base.util;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f25838a;

    public static boolean a() {
        ArrayList<String> e = e();
        if (e == null || e.size() <= 0) {
            c.a("[core] no response}", new Object[0]);
            return false;
        }
        Iterator<String> it = e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            c.a(next, new Object[0]);
            if (next.contains("not found")) {
                return false;
            }
        }
        c.a("[core] sufile}", new Object[0]);
        return true;
    }

    public static boolean b() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                c.a("[core] super_apk", new Object[0]);
                return true;
            }
            return false;
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }

    public static boolean c() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        c.a("[core] test-keys", new Object[0]);
        return true;
    }

    public static boolean d() {
        if (f25838a) {
            return true;
        }
        boolean z = true;
        if (!c()) {
            z = true;
            if (!b()) {
                z = a();
            }
        }
        f25838a = z;
        return z;
    }

    private static ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "type su"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream(), Charset.forName("UTF-8")));
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    return arrayList;
                }
                arrayList.add(readLine2);
            }
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }
}
