package com.anythink.china.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/NotificationBroadcaseReceiver.class */
public class NotificationBroadcaseReceiver extends BroadcastReceiver {
    private static final String a = NotificationBroadcaseReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        intent.getStringExtra(com.anythink.china.common.b.a.d);
        String stringExtra = intent.getStringExtra(com.anythink.china.common.b.a.e);
        String stringExtra2 = intent.getStringExtra(com.anythink.china.common.b.a.f);
        boolean z = true;
        int intExtra = intent.getIntExtra(com.anythink.china.common.b.a.g, -1);
        int hashCode = action.hashCode();
        if (hashCode != -1222061724) {
            if (hashCode == 760792937 && action.equals(com.anythink.china.common.b.a.c)) {
                z = true;
            }
        } else if (action.equals(com.anythink.china.common.b.a.b)) {
            z = false;
        }
        if (!z) {
            a.a(context).a(stringExtra, stringExtra2, intExtra);
        } else if (!z) {
        } else {
            a.a(context).a(stringExtra, stringExtra2);
        }
    }
}
