package com.opos.cmn.an.f.a.a;

import android.text.TextUtils;
import com.oplus.log.b;
import com.oplus.log.c;
import com.oplus.log.g.c;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/a/d.class */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.an.f.b.b f10821a;
    private com.oplus.log.b b;

    /* renamed from: com.opos.cmn.an.f.a.a.d$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/a/d$3.class */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.an.f.b.c f10824a;
        final /* synthetic */ com.opos.cmn.an.f.b.a b;

        AnonymousClass3(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
            this.f10824a = cVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.b.a("advertise_sdk", this.f10824a.f10849a, new c.e() { // from class: com.opos.cmn.an.f.a.a.d.3.1
                    @Override // com.oplus.log.g.c.e
                    public void a(UserTraceConfigDto userTraceConfigDto) {
                        try {
                            if (userTraceConfigDto != null) {
                                d.this.b.a(new c.g() { // from class: com.opos.cmn.an.f.a.a.d.3.1.1
                                    @Override // com.oplus.log.g.c.g
                                    public void a() {
                                        if (AnonymousClass3.this.b != null) {
                                            AnonymousClass3.this.b.onUploaderSuccess();
                                        }
                                    }

                                    @Override // com.oplus.log.g.c.g
                                    public void a(String str) {
                                        if (AnonymousClass3.this.b != null) {
                                            AnonymousClass3.this.b.onUploaderFailed(str);
                                        }
                                    }
                                });
                                d.this.b.a("advertise_sdk", String.valueOf(userTraceConfigDto.getTraceId()), userTraceConfigDto.getBeginTime(), userTraceConfigDto.getEndTime(), userTraceConfigDto.getForce() == 1, AnonymousClass3.this.f10824a.f10849a);
                            } else if (AnonymousClass3.this.b != null) {
                                AnonymousClass3.this.b.onDontNeedUpload("userTraceConfigDto is null");
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override // com.oplus.log.g.c.e
                    public void a(String str) {
                        if (AnonymousClass3.this.b != null) {
                            AnonymousClass3.this.b.onDontNeedUpload(str);
                        }
                    }
                });
            } catch (Exception e) {
                com.opos.cmn.an.f.b.a aVar = this.b;
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    private void a(int i, String str, String str2) {
        com.oplus.log.b bVar = this.b;
        if (bVar == null || bVar.d() == null) {
            return;
        }
        if (i == 1) {
            this.b.d().b(str, str2, com.opos.cmn.an.f.a.c.b());
        } else if (i == 2) {
            this.b.d().a(str, str2, com.opos.cmn.an.f.a.c.b());
        } else if (i == 3) {
            this.b.d().c(str, str2, com.opos.cmn.an.f.a.c.b());
        } else if (i == 4) {
            this.b.d().d(str, str2, com.opos.cmn.an.f.a.c.b());
        } else if (i != 5) {
        } else {
            this.b.d().e(str, str2, com.opos.cmn.an.f.a.c.b());
        }
    }

    private String b() {
        try {
            if (com.opos.cmn.an.f.c.b.b()) {
                return this.f10821a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_log";
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private String c() {
        try {
            if (com.opos.cmn.an.f.c.b.b()) {
                return this.f10821a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_mmap_cache_log";
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a() {
        com.oplus.log.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.e();
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(int i) {
        com.oplus.log.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.a.b.d dVar) {
        com.oplus.log.b bVar;
        if (dVar == null || dVar.b == null || dVar.f10831a == null || (bVar = this.b) == null || bVar.d() == null) {
            return;
        }
        int i = dVar.d;
        try {
            String a2 = com.opos.cmn.an.f.c.b.a(dVar);
            if (a2.length() > 3072 && com.opos.cmn.an.f.a.c.b()) {
                int length = a2.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (length <= i3) {
                        return;
                    }
                    int i4 = i3 + 3072;
                    if (length <= i4) {
                        i4 = length;
                    }
                    a(i, this.f10821a.f10843a, a2.substring(i3, i4));
                    i2 = i4;
                }
            }
            a(i, this.f10821a.f10843a, a2);
        } catch (Throwable th) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        int i;
        this.f10821a = bVar;
        try {
            if (com.opos.cmn.an.f.c.b.a()) {
                com.opos.cmn.an.f.a.c.a();
                i = 1;
            } else {
                i = this.f10821a.f10844c;
            }
            b.a a2 = com.oplus.log.b.c().a(new c()).d("ad").c(b()).b(c()).c(this.f10821a.d).a(this.f10821a.b).b(i).a(this.f10821a.f).a(new c.a() { // from class: com.opos.cmn.an.f.a.a.d.2
                @Override // com.oplus.log.c.a
                public String a() {
                    return d.this.f10821a.h.a();
                }
            }).a(new c.b() { // from class: com.opos.cmn.an.f.a.a.d.1
                @Override // com.oplus.log.c.b
                public String a() {
                    return "";
                }

                @Override // com.oplus.log.c.b
                public String b() {
                    return d.this.f10821a.i.a();
                }

                @Override // com.oplus.log.c.b
                public String c() {
                    return "";
                }
            });
            String c2 = com.opos.cmn.an.f.c.b.c();
            if (!TextUtils.isEmpty(c2)) {
                a2.e(c2);
            }
            this.b = a2.a(this.f10821a.g);
            com.oplus.log.b.a(false);
        } catch (Exception e) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        String str;
        if (cVar == null) {
            if (aVar == null) {
                return;
            }
            str = "uploadParams is null";
        } else if (com.opos.cmn.an.c.a.a(cVar.f10849a)) {
            if (aVar == null) {
                return;
            }
            str = "businessType is null";
        } else if (this.b != null) {
            com.opos.cmn.an.f.b.b bVar = this.f10821a;
            if (bVar == null || com.opos.cmn.an.f.a.a.a(bVar.g)) {
                new Thread(new AnonymousClass3(cVar, aVar)).start();
                return;
            } else if (aVar == null) {
                return;
            } else {
                str = "log buried point switch is closed, cannot upload log";
            }
        } else if (aVar == null) {
            return;
        } else {
            str = "mLogger is null";
        }
        aVar.onUploaderFailed(str);
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(boolean z) {
        com.oplus.log.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b(z);
        } catch (Exception e) {
        }
    }
}
