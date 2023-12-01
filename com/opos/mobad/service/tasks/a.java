package com.opos.mobad.service.tasks;

import android.app.ActivityManager;
import android.content.Context;
import android.os.StatFs;
import android.provider.Settings;
import com.omes.scorpion.OmasStub;
import com.opos.mobad.provider.record.CookieData;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/tasks/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static CookieData f27421a;
    private static final FileFilter b = new FileFilter() { // from class: com.opos.mobad.service.tasks.a.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return OmasStub.omasBoolean(24, new Object[]{this, file});
        }
    };

    public static final ActivityManager.MemoryInfo a(Context context) {
        return (ActivityManager.MemoryInfo) OmasStub.omasObject(0, new Object[]{context});
    }

    public static final StatFs a() {
        return (StatFs) OmasStub.omasObject(1, new Object[0]);
    }

    public static final String a(float[][] fArr) {
        return (String) OmasStub.omasObject(2, new Object[]{fArr});
    }

    public static HashMap<String, String> a(Context context, boolean z, int i) {
        return (HashMap) OmasStub.omasObject(3, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)});
    }

    public static final void a(Context context, HashMap<String, String> hashMap) {
        OmasStub.omasVoid(4, new Object[]{context, hashMap});
    }

    public static final void a(Context context, Map<String, String> map) {
        OmasStub.omasVoid(5, new Object[]{context, map});
    }

    private static final boolean a(String str) {
        return OmasStub.omasBoolean(6, new Object[]{str});
    }

    public static final int b(Context context) {
        return OmasStub.omasInt(7, new Object[]{context});
    }

    public static final long b() {
        return OmasStub.omasLong(8, new Object[0]);
    }

    public static final int c() {
        return OmasStub.omasInt(9, new Object[0]);
    }

    public static final String c(Context context) {
        return (String) OmasStub.omasObject(10, new Object[]{context});
    }

    private static final boolean d() throws IOException {
        return OmasStub.omasBoolean(11, new Object[0]);
    }

    private static final boolean d(Context context) {
        return OmasStub.omasBoolean(12, new Object[]{context});
    }

    private static final boolean e(Context context) {
        return OmasStub.omasBoolean(13, new Object[]{context});
    }

    private static final boolean f(Context context) {
        return OmasStub.omasBoolean(14, new Object[]{context});
    }

    private static String g(Context context) {
        return (String) OmasStub.omasObject(15, new Object[]{context});
    }

    private static String h(Context context) {
        return (String) OmasStub.omasObject(16, new Object[]{context});
    }

    private static String i(Context context) {
        return (String) OmasStub.omasObject(17, new Object[]{context});
    }

    private static CookieData j(Context context) {
        return (CookieData) OmasStub.omasObject(18, new Object[]{context});
    }

    private static CookieData k(Context context) throws NoSuchAlgorithmException {
        return (CookieData) OmasStub.omasObject(19, new Object[]{context});
    }

    private static String l(Context context) {
        return (String) OmasStub.omasObject(20, new Object[]{context});
    }

    private static final int m(Context context) throws Settings.SettingNotFoundException {
        return OmasStub.omasInt(21, new Object[]{context});
    }
}
