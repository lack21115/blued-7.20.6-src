package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u.class */
public class u extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar) {
        super(vVar);
        long j = vVar.d.e.getLong("app_log_last_config_time", 0L);
        this.f21307c = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ac A[Catch: all -> 0x0202, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0202, blocks: (B:15:0x00c3, B:17:0x00ec, B:23:0x00fd, B:46:0x01ac, B:49:0x01ba, B:50:0x01c8, B:42:0x019f), top: B:96:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c8 A[Catch: all -> 0x0202, TRY_ENTER, TryCatch #0 {all -> 0x0202, blocks: (B:15:0x00c3, B:17:0x00ec, B:23:0x00fd, B:46:0x01ac, B:49:0x01ba, B:50:0x01c8, B:42:0x019f), top: B:96:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x029c  */
    @Override // com.bytedance.bdtracker.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.u.c():boolean");
    }

    @Override // com.bytedance.bdtracker.t
    public String d() {
        return "Configure";
    }

    @Override // com.bytedance.bdtracker.t
    public long[] e() {
        return x.i;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public long h() {
        return this.e.d.e.getLong("fetch_interval", com.anythink.expressad.d.a.b.aD);
    }
}
