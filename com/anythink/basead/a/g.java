package com.anythink.basead.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/g.class */
public final class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String stringExtra = intent.getStringExtra(com.anythink.china.common.a.f);
            String stringExtra2 = intent.getStringExtra(com.anythink.china.common.a.g);
            boolean z = true;
            switch (action.hashCode()) {
                case -1301069232:
                    if (action.equals(com.anythink.china.common.a.c)) {
                        z = true;
                        break;
                    }
                    break;
                case -478940009:
                    if (action.equals(com.anythink.china.common.a.b)) {
                        z = false;
                        break;
                    }
                    break;
                case 468136042:
                    if (action.equals(com.anythink.china.common.a.e)) {
                        z = true;
                        break;
                    }
                    break;
                case 1256250514:
                    if (action.equals(com.anythink.china.common.a.d)) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z) {
                h.a(context.getApplicationContext()).a(stringExtra, stringExtra2);
            } else if (z) {
                h.a(context.getApplicationContext()).b(stringExtra, stringExtra2);
            } else if (z) {
                h.a(context.getApplicationContext()).d(stringExtra, stringExtra2);
            } else if (!z) {
            } else {
                h.a(context.getApplicationContext()).c(stringExtra, stringExtra2);
            }
        }
    }
}
