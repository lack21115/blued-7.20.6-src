package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/n.class */
final class n extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof l) {
            l lVar = (l) obj;
            com.vivo.push.util.p.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(lVar)));
            lVar.run();
        }
    }
}
