package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/c.class */
public final class c extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/c$a.class */
    public static final class a {
        private static final c art = new c((byte) 0);
    }

    private c() {
    }

    /* synthetic */ c(byte b) {
        this();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:1|(2:2|3)|(11:(3:210|211|(38:213|214|6|(1:8)|199|200|201|202|203|10|(1:12)|188|189|190|191|192|14|(1:16)|177|178|179|180|181|18|(1:20)|166|167|168|169|170|22|23|24|(1:26)|28|29|30|(7:32|(1:34)|35|(2:37|(4:39|40|41|42)(1:45))|46|47|48)(2:50|(4:52|(1:54)(1:64)|55|(3:57|58|59)(1:63))(1:65))))|169|170|22|23|24|(0)|28|29|30|(0)(0))|5|6|(0)|199|200|201|202|203|10|(0)|188|189|190|191|192|14|(0)|177|178|179|180|181|18|(0)|166|167|168|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(32:1|2|3|(11:(3:210|211|(38:213|214|6|(1:8)|199|200|201|202|203|10|(1:12)|188|189|190|191|192|14|(1:16)|177|178|179|180|181|18|(1:20)|166|167|168|169|170|22|23|24|(1:26)|28|29|30|(7:32|(1:34)|35|(2:37|(4:39|40|41|42)(1:45))|46|47|48)(2:50|(4:52|(1:54)(1:64)|55|(3:57|58|59)(1:63))(1:65))))|169|170|22|23|24|(0)|28|29|30|(0)(0))|5|6|(0)|199|200|201|202|203|10|(0)|188|189|190|191|192|14|(0)|177|178|179|180|181|18|(0)|166|167|168|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009a, code lost:
        if (r0 != 0) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e8, code lost:
        if (r0 != 0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0136, code lost:
        if (r0 != 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0184, code lost:
        if (r0 != 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02cb, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02cc, code lost:
        r9 = r15;
        r16 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02d6, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02d7, code lost:
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02dd, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02de, code lost:
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02e4, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02e5, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02eb, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02ef, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02f0, code lost:
        r14 = r0;
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02fa, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02fb, code lost:
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ff, code lost:
        r9 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0340 A[Catch: all -> 0x03ec, TRY_ENTER, TryCatch #10 {all -> 0x03ec, blocks: (B:101:0x0334, B:103:0x0340, B:105:0x0358, B:108:0x0365, B:110:0x0378, B:112:0x0390, B:113:0x039d, B:115:0x03a3, B:119:0x03ac, B:121:0x03b8, B:122:0x03c4, B:124:0x03df), top: B:200:0x0334 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01dc A[Catch: all -> 0x02b1, TryCatch #15 {all -> 0x02b1, blocks: (B:41:0x01c8, B:43:0x01dc), top: B:209:0x01c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f7 A[Catch: all -> 0x02a4, TRY_ENTER, TryCatch #3 {all -> 0x02a4, blocks: (B:45:0x01eb, B:47:0x01f7, B:49:0x0210, B:52:0x021d, B:54:0x0230, B:56:0x0248, B:57:0x0255, B:59:0x025b, B:63:0x0264, B:65:0x0270, B:66:0x027c, B:68:0x0297), top: B:187:0x01eb }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x025f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Throwable r7, com.kwad.sdk.crash.model.message.ExceptionMessage r8, android.content.Context r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    public static c zO() {
        return a.art;
    }

    public final void a(Throwable th, ExceptionMessage exceptionMessage, Context context) {
        a(th, exceptionMessage, context, ((e) ServiceProvider.get(e.class)).getIsExternal());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.zy().isDebug()) {
            initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        int length = fileArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            fVar.a(fileArr[i2], countDownLatch);
            i = i2 + 1;
        }
    }
}
