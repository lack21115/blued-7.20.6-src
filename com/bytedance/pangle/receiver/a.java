package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.d.e;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/a.class */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (c.a().f7860c.contains(Integer.valueOf(hashCode()))) {
            c.a().a(context, intent);
        } else {
            e.b(new Runnable() { // from class: com.bytedance.pangle.receiver.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.a().a(context, intent);
                }
            });
        }
    }
}
