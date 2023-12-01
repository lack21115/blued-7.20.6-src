package mtopsdk.mtop.antiattack;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxyBase;
import mtopsdk.mtop.util.Result;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/AntiAttackHandlerImpl.class */
public class AntiAttackHandlerImpl implements AntiAttackHandler {

    /* renamed from: mtopsdk.mtop.antiattack.AntiAttackHandlerImpl$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/AntiAttackHandlerImpl$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Result a = AntiAttackUtil.a(this.a);
                boolean z = true;
                if (a != null) {
                    z = true;
                    if (a.d()) {
                        CheckCodeDO checkCodeDO = (CheckCodeDO) a.a();
                        if (checkCodeDO == null || !checkCodeDO.a() || MtopProxyBase.c == null) {
                            StringBuilder sb = new StringBuilder("[callCheckCodeValidateListener] invalid checkcodeDO or checkCodeValidateListener,checkCodeDO=");
                            sb.append(checkCodeDO);
                            TBSdkLog.d("mtopsdk.AntiAttackHandlerImpl", sb.toString());
                            z = true;
                        } else {
                            z = false;
                            MtopProxyBase.c.a(checkCodeDO);
                        }
                    }
                }
                if (z) {
                    AntiAttackUtil.a();
                }
            } catch (Throwable th) {
                try {
                    if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                        TBSdkLog.a("mtopsdk.AntiAttackHandlerImpl", "[callCheckCodeValidateListener] call CheckCodeValidate Listener error---", th);
                    }
                } finally {
                    if (1 != 0) {
                        AntiAttackUtil.a();
                    }
                }
            }
        }
    }
}
