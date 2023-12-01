package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/l.class */
final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final long f21420a = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final FileDescriptor b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21421c;
    private final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FileDescriptor fileDescriptor, long j, long j2) {
        this.b = fileDescriptor;
        this.f21421c = j;
        this.d = j2;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017c  */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r11, long r12, int r14) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
