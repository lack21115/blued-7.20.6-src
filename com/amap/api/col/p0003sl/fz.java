package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.fz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fz.class */
final class fz {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f4977a = false;

    public static void a() {
        synchronized (fz.class) {
            try {
                if (!f4977a) {
                    ga.a().a("regeo", new gc("/geocode/regeo"));
                    ga.a().a("placeAround", new gc("/place/around"));
                    ga.a().a("placeText", new gb("/place/text"));
                    ga.a().a("geo", new gb("/geocode/geo"));
                    f4977a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
