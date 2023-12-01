package com.blued.android.module.external_sense_library.utils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/SenseLibSPMgr.class */
public class SenseLibSPMgr {
    private static SenseLibSPMgr a;
    private SPUtils b = new SPUtils("senseBeautyConfig");

    private SenseLibSPMgr() {
    }

    public static SenseLibSPMgr a() {
        if (a == null) {
            synchronized (SenseLibSPMgr.class) {
                try {
                    if (a == null) {
                        a = new SenseLibSPMgr();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a(String str) {
        SPUtils sPUtils = this.b;
        if (sPUtils != null) {
            sPUtils.a("external_sense_sticker_key", str);
        }
    }

    public String b() {
        SPUtils sPUtils = this.b;
        if (sPUtils != null) {
            return sPUtils.b("external_sense_sticker_key", null);
        }
        return null;
    }

    public void b(String str) {
        SPUtils sPUtils = this.b;
        if (sPUtils != null) {
            sPUtils.a("external_sense_filter_key", str);
        }
    }

    public String c() {
        SPUtils sPUtils = this.b;
        if (sPUtils != null) {
            return sPUtils.b("external_sense_filter_key", null);
        }
        return null;
    }
}
