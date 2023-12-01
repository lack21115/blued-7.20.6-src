package com.opos.mobad.ad;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/e.class */
public interface e {

    /* renamed from: c  reason: collision with root package name */
    public static final e f11991c = new e() { // from class: com.opos.mobad.ad.e.1
        @Override // com.opos.mobad.ad.e
        public void a() {
            com.opos.cmn.an.f.a.b("IInitListener", "init success.");
        }

        @Override // com.opos.mobad.ad.e
        public void a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("init failed.reason=");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.c("IInitListener", sb.toString());
        }
    };

    void a();

    void a(String str);
}
