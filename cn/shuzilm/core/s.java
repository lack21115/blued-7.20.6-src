package cn.shuzilm.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/s.class */
public class s extends BroadcastReceiver {
    private s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(j jVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getAction() == null) {
                return;
            }
            DUHelper.aXZlZWNl(context, intent);
        } catch (Exception e) {
        }
    }
}
