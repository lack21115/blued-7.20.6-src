package com.vivo.push;

import android.content.Intent;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.b.r;
import com.vivo.push.b.t;
import com.vivo.push.b.u;
import com.vivo.push.d.ag;
import com.vivo.push.d.z;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d.class */
public final class d implements IPushClientFactory {

    /* renamed from: a  reason: collision with root package name */
    private ag f27378a = new ag();

    @Override // com.vivo.push.IPushClientFactory
    public final z createReceiveTask(o oVar) {
        return ag.b(oVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final o createReceiverCommand(Intent intent) {
        o uVar;
        int intExtra = intent.getIntExtra(IntentConstant.COMMAND, -1);
        int i = intExtra;
        if (intExtra < 0) {
            i = intent.getIntExtra("method", -1);
        }
        if (i == 20) {
            uVar = new u();
        } else if (i != 2016) {
            switch (i) {
                case 1:
                case 2:
                    uVar = new t(i);
                    break;
                case 3:
                    uVar = new com.vivo.push.b.o();
                    break;
                case 4:
                    uVar = new com.vivo.push.b.q();
                    break;
                case 5:
                    uVar = new com.vivo.push.b.p();
                    break;
                case 6:
                    uVar = new r();
                    break;
                case 7:
                    uVar = new com.vivo.push.b.n();
                    break;
                case 8:
                    uVar = new com.vivo.push.b.m();
                    break;
                case 9:
                    uVar = new com.vivo.push.b.k();
                    break;
                case 10:
                case 11:
                    uVar = new com.vivo.push.b.i(i);
                    break;
                case 12:
                    uVar = new com.vivo.push.b.j();
                    break;
                default:
                    uVar = null;
                    break;
            }
        } else {
            uVar = new com.vivo.push.b.l();
        }
        if (uVar != null) {
            a a2 = a.a(intent);
            if (a2 == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
                return uVar;
            }
            uVar.b(a2);
        }
        return uVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final l createTask(o oVar) {
        return ag.a(oVar);
    }
}
