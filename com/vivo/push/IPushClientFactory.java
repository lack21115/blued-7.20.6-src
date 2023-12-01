package com.vivo.push;

import android.content.Intent;
import com.vivo.push.d.z;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/IPushClientFactory.class */
public interface IPushClientFactory {
    z createReceiveTask(o oVar);

    o createReceiverCommand(Intent intent);

    l createTask(o oVar);
}
