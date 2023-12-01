package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/de.class */
public class de extends dd.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41332a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f291a;

    /* renamed from: a  reason: collision with other field name */
    File f292a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f293a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f294a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f295a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f296b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f291a = ddVar;
        this.f41332a = i;
        this.f294a = date;
        this.f296b = date2;
        this.f293a = str;
        this.b = str2;
        this.f295a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (z.d()) {
            try {
                File file = new File(this.f291a.f284a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.f41332a);
                    this.f292a = dcVar.a(this.f291a.f284a, this.f294a, this.f296b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo11618c() {
        File file = this.f292a;
        if (file != null && file.exists()) {
            this.f291a.f285a.add(new dd.c(this.f293a, this.b, this.f292a, this.f295a));
        }
        this.f291a.a(0L);
    }
}
