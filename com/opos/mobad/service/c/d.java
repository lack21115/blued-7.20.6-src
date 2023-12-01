package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;
import com.opos.mobad.c.a.a;
import com.opos.mobad.h;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f13627a;
    private f b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.i.a f13628c;
    private volatile List<a.b> d;

    /* renamed from: com.opos.mobad.service.c.d$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/d$1.class */
    class AnonymousClass1 implements a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(final a.InterfaceC0475a interfaceC0475a) {
            final List list = d.this.d;
            if (list != null && list.size() > 0) {
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "start to load action");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.c.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.opos.mobad.d.d.a().a(list, new a.InterfaceC0507a() { // from class: com.opos.mobad.service.c.d.1.1.1
                                @Override // com.opos.mobad.c.a.a.InterfaceC0507a
                                public void a() {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                                    d.this.a(list);
                                    if (interfaceC0475a != null) {
                                        interfaceC0475a.a();
                                    }
                                }

                                @Override // com.opos.mobad.c.a.a.InterfaceC0507a
                                public void a(String str) {
                                }

                                @Override // com.opos.mobad.c.a.a.InterfaceC0507a
                                public void a(String str, int i) {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", str, Integer.valueOf(i));
                                }
                            }, com.opos.mobad.c.a(f.a(d.this.f13627a)));
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("Dynamic-Loader", "", e);
                        }
                    }
                });
                return;
            }
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "load action but empty load info");
            if (interfaceC0475a != null) {
                interfaceC0475a.b();
            }
        }
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f13627a = applicationContext;
        this.b = new f(applicationContext);
        this.f13628c = new com.opos.cmn.i.a(new AnonymousClass1(), Integer.MAX_VALUE, 10000);
    }

    public static void a(Context context) {
        try {
            com.opos.mobad.c a2 = com.opos.mobad.c.a(f.a(context));
            if (a2 != null) {
                try {
                    if (h.a(a2, 6, 70)) {
                        c.a(new File(f.a(context)), STMobileHumanActionNative.ST_MOBILE_BODY_KEYPOINTS, 20);
                        c.b(new File(f.b(context)), STMobileHumanActionNative.ST_MOBILE_BODY_CONTOUR, 20);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e);
                    if (a2 == null) {
                        return;
                    }
                }
            }
            if (a2 == null) {
                return;
            }
            a2.b();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a.b> list) {
        for (a.b bVar : list) {
            if (bVar != null && !TextUtils.isEmpty(bVar.f12118a)) {
                String b = this.b.b(bVar.f12118a);
                e.a(this.f13627a, b);
                File file = new File(b);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private List<a.b> b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= strArr.length || i3 >= 3) {
                break;
            }
            String str = strArr[i];
            int i4 = i3;
            if (!TextUtils.isEmpty(str)) {
                if (a(str)) {
                    i4 = i3;
                } else {
                    arrayList.add(new a.b(str, "", ".dynamic"));
                    i4 = i3 + 1;
                }
            }
            i++;
            i2 = i4;
        }
        com.opos.cmn.an.f.a.a("Dynamic-Loader", "load info list =", arrayList);
        return arrayList;
    }

    public void a(String[] strArr) {
        String str;
        if (strArr == null || strArr.length <= 0) {
            str = "loadMaterialList fail ";
        } else if (com.opos.cmn.an.h.c.a.e(this.f13627a)) {
            this.d = b(strArr);
            if (this.d == null || this.d.size() < 0) {
                return;
            }
            this.f13628c.a();
            return;
        } else {
            str = "is not wifi do not download zip ";
        }
        com.opos.cmn.an.f.a.b("Dynamic-Loader", str);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File a2 = f.a(this.f13627a, this.b.b(str));
        if (a2 == null) {
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "check file exit but not exit: " + str);
            return false;
        } else if (a2.exists()) {
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit: ", str, a2.getAbsolutePath());
            return true;
        } else {
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit but not exit: " + str + ", file =" + a2.getAbsolutePath());
            return false;
        }
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File a2 = f.a(this.f13627a, this.b.b(str));
        return a2 != null ? a2.getAbsolutePath() : "";
    }

    public void c(String str) {
        StringBuilder sb;
        String str2;
        if (TextUtils.isEmpty(str)) {
            sb = new StringBuilder();
            str2 = "no need load template empty url = ";
        } else if (com.opos.cmn.an.h.c.a.e(this.f13627a)) {
            if (a(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "loadMaterial url = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new a.b(str, "", ".dynamic"));
            this.d = arrayList;
            this.f13628c.a();
            return;
        } else {
            sb = new StringBuilder();
            str2 = "is not wifi do not download zip ";
        }
        sb.append(str2);
        sb.append(str);
        com.opos.cmn.an.f.a.b("Dynamic-Loader", sb.toString());
    }
}
