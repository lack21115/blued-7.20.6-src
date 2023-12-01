package com.soft.blued.ui.find.manager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/MapFindManager.class */
public class MapFindManager {

    /* renamed from: a  reason: collision with root package name */
    private static MapFindManager f30598a;
    private MapFindBean b;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/MapFindManager$MapFindBean.class */
    public static class MapFindBean {

        /* renamed from: a  reason: collision with root package name */
        public String f30599a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public double f30600c;
        public String d;
        public String e;
    }

    private MapFindManager() {
    }

    public static MapFindManager a() {
        if (f30598a == null) {
            synchronized (MapFindManager.class) {
                try {
                    if (f30598a == null) {
                        f30598a = new MapFindManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f30598a;
    }

    public void a(MapFindBean mapFindBean) {
        this.b = mapFindBean;
    }

    public boolean b() {
        return this.b != null;
    }

    public MapFindBean c() {
        return this.b;
    }
}
