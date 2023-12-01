package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/de.class */
public class de extends dd.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27641a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f244a;

    /* renamed from: a  reason: collision with other field name */
    File f245a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f246a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f247a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f248a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f244a = ddVar;
        this.f27641a = i;
        this.f247a = date;
        this.f249b = date2;
        this.f246a = str;
        this.b = str2;
        this.f248a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (z.d()) {
            try {
                File file = new File(this.f244a.f237a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.f27641a);
                    this.f245a = dcVar.a(this.f244a.f237a, this.f247a, this.f249b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo8568c() {
        File file = this.f245a;
        if (file != null && file.exists()) {
            this.f244a.f238a.add(new dd.c(this.f246a, this.b, this.f245a, this.f248a));
        }
        this.f244a.a(0L);
    }
}
