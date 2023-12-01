package com.kuaishou.weapon.p0;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cq.class */
public class cq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f23795a = false;
    private static volatile boolean b = true;

    static {
        try {
            f23795a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception e) {
            f23795a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f23795a;
    }

    public static boolean b() {
        return b;
    }
}
