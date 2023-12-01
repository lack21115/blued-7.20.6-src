package com.vivo.push.b;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/x.class */
public final class x extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f41057a;
    private long b;

    public x() {
        super(2012);
    }

    public x(long j) {
        this();
        this.b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f41057a = hashMap;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f41057a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    public final void d() {
        String sb;
        if (this.f41057a == null) {
            sb = "reportParams is empty";
        } else {
            StringBuilder sb2 = new StringBuilder("report message reportType:");
            sb2.append(this.b);
            sb2.append(",msgId:");
            String str = this.f41057a.get(IntentConstant.MESSAGE_ID);
            if (TextUtils.isEmpty(str)) {
                str = this.f41057a.get("message_id");
            }
            sb2.append(str);
            sb = sb2.toString();
        }
        com.vivo.push.util.p.d("ReporterCommand", sb);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f41057a = (HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }
}
