package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.nearx.tapplugin.pluginapi.PluginApi;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.mobad.service.f.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/e.class */
public class e {
    private void b() {
    }

    public com.opos.mobad.ad.a.a a(Activity activity, String str, com.opos.mobad.ad.a.b bVar) {
        return c.d().a(activity, str, bVar);
    }

    public com.opos.mobad.ad.b.a a(Activity activity, String str, com.opos.mobad.ad.b.b bVar) {
        return c.d().a(activity, str, bVar);
    }

    public com.opos.mobad.ad.b.c a(Activity activity, String str, com.opos.mobad.ad.b.d dVar) {
        return c.d().a(activity, str, dVar);
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, int i, m mVar) {
        return c.d().a(context, str, i, mVar);
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, com.opos.mobad.ad.c.f fVar) {
        return c.d().a(context, str, fVar);
    }

    public g a(Context context, String str, j jVar) {
        return c.d().a(context, str, jVar);
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return c.d().a(context, str, sVar, oVar);
    }

    public com.opos.mobad.ad.d.a a(Context context, String str, com.opos.mobad.ad.d.b bVar) {
        return c.d().a(context, str, bVar);
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().a(context, str, cVar, fVar);
    }

    public com.opos.mobad.ad.e.b a(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().a(activity, str, cVar, fVar);
    }

    public void a(Context context) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("", "exit with null context");
            return;
        }
        com.opos.mobad.service.f.e();
        c.b(com.opos.mobad.service.b.a(context));
        com.opos.mobad.service.b.a();
    }

    public void a(Context context, String str, int i) {
        a(context, str, i, (com.opos.mobad.ad.e) null);
    }

    public void a(Context context, String str, int i, com.opos.mobad.ad.e eVar) {
        a(context, str, false, true, i, eVar, false, 0, null);
    }

    public void a(final Context context, final String str, boolean z, boolean z2, final int i, com.opos.mobad.ad.e eVar, boolean z3, int i2, final com.opos.mobad.ad.d dVar) {
        String str2;
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            if (eVar == null) {
                return;
            }
            str2 = "context or appId is null.";
        } else if (PluginApi.sPluginMode) {
            if (com.opos.cmn.an.b.c.b() >= 21 || eVar == null) {
                return;
            }
            str2 = "init sdk failed! sdk not support android sdk version < 21";
        } else if (com.opos.cmn.an.b.c.b() >= 19) {
            if (com.opos.cmn.i.b.a(context, Uri.parse("content://" + MobAdGlobalProvider.getAuthority(context)))) {
                if (com.opos.cmn.i.b.a(context, Uri.parse("content://" + context.getPackageName() + ".MobFileProvider"))) {
                    Context context2 = PluginApi.sPluginContext;
                    if (!PluginApi.sPluginMode || context2 != null) {
                        if (context2 == null) {
                            context2 = context;
                        }
                        com.opos.cmn.an.d.a.a.a(context2);
                        com.opos.mobad.service.b.a(context2, context);
                        com.opos.mobad.service.f.a(context2, z, z2, z3, i2, new a.c() { // from class: com.opos.mobad.f.e.1

                            /* renamed from: c  reason: collision with root package name */
                            private String f26138c;
                            private String d;
                            private Boolean e;

                            @Override // com.opos.mobad.service.f.a.c
                            public String a() {
                                if (TextUtils.isEmpty(this.f26138c)) {
                                    this.f26138c = com.opos.mobad.cmn.a.b.c.a(context);
                                }
                                return this.f26138c;
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public String b() {
                                if (TextUtils.isEmpty(this.d)) {
                                    this.d = com.opos.mobad.cmn.a.b.c.a();
                                }
                                return this.d;
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public boolean c() {
                                if (this.e == null) {
                                    this.e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                                }
                                return this.e.booleanValue();
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public void d() {
                                this.f26138c = com.opos.mobad.cmn.a.b.c.a(context);
                                this.d = com.opos.mobad.cmn.a.b.c.a();
                                this.e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                            }
                        }, new a.g() { // from class: com.opos.mobad.f.e.2

                            /* renamed from: c  reason: collision with root package name */
                            private String f26140c;
                            private String d;
                            private Boolean e;

                            @Override // com.opos.mobad.service.f.a.g
                            public String a() {
                                if (TextUtils.isEmpty(this.f26140c)) {
                                    this.f26140c = com.opos.mobad.cmn.a.b.c.a(context);
                                }
                                return this.f26140c;
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public String b() {
                                if (TextUtils.isEmpty(this.d)) {
                                    this.d = com.opos.mobad.cmn.a.b.c.a();
                                }
                                return this.d;
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public boolean c() {
                                if (this.e == null) {
                                    this.e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                                }
                                return this.e.booleanValue();
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public void d() {
                                this.f26140c = com.opos.mobad.cmn.a.b.c.a(context);
                                this.d = com.opos.mobad.cmn.a.b.c.a();
                                this.e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                            }
                        }, new a.InterfaceC0735a() { // from class: com.opos.mobad.f.e.3
                            private String d;
                            private String e;
                            private int f = -1;

                            @Override // com.opos.mobad.service.f.a.InterfaceC0735a
                            public String a() {
                                return str;
                            }

                            @Override // com.opos.mobad.service.f.a.InterfaceC0735a
                            public String b() {
                                if (TextUtils.isEmpty(this.d)) {
                                    this.d = context.getPackageName();
                                }
                                return this.d;
                            }

                            @Override // com.opos.mobad.service.f.a.InterfaceC0735a
                            public String c() {
                                if (TextUtils.isEmpty(this.e)) {
                                    Context context3 = context;
                                    this.e = com.opos.cmn.an.h.d.a.c(context3, context3.getPackageName());
                                }
                                return this.e;
                            }
                        }, new a.f() { // from class: com.opos.mobad.f.e.4
                            @Override // com.opos.mobad.service.f.a.f
                            public int a() {
                                return 481004;
                            }

                            @Override // com.opos.mobad.service.f.a.f
                            public String b() {
                                return "4.8.1";
                            }

                            @Override // com.opos.mobad.service.f.a.f
                            public int c() {
                                return i;
                            }
                        }, dVar == null ? null : new a.b() { // from class: com.opos.mobad.f.e.5
                            @Override // com.opos.mobad.service.f.a.b
                            public String a() {
                                return dVar.a();
                            }
                        });
                        c.d().a(context, str, i, z, z3);
                        if (com.opos.cmn.a.a.a()) {
                            c.a a2 = c.d().a();
                            if (!a2.f25670a) {
                                com.opos.cmn.an.f.a.d("MobAdManager", a2.b);
                                if (eVar == null) {
                                    return;
                                }
                                str2 = a2.b;
                            }
                        }
                        if (c.d().b()) {
                            b();
                            if (eVar != null) {
                                eVar.a();
                                return;
                            }
                            return;
                        } else if (eVar == null) {
                            return;
                        } else {
                            str2 = "init fail";
                        }
                    } else if (eVar == null) {
                        return;
                    } else {
                        str2 = "init sdk failed!";
                    }
                } else if (eVar == null) {
                    return;
                } else {
                    str2 = "init sdk failed! com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.";
                }
            } else if (eVar == null) {
                return;
            } else {
                str2 = "init sdk failed! com.opos.mobad.provider.MobAdGlobalProvider don't find in AndroidManifest.xml.";
            }
        } else if (eVar == null) {
            return;
        } else {
            str2 = "init sdk failed! sdk not support android sdk version < 19";
        }
        eVar.a(str2);
    }

    public void a(Context context, String str, boolean z, boolean z2, int i, boolean z3, int i2, com.opos.mobad.ad.d dVar) {
        a(context, str, z, z2, i, null, z3, i2, dVar);
    }

    public boolean a() {
        return com.opos.mobad.service.f.b().c();
    }

    public com.opos.mobad.ad.e.b b(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().b(activity, str, cVar, fVar);
    }
}
