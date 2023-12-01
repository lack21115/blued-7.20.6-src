package com.tramini.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/c.class */
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40497a = c.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(intent.getAction());
            String stringExtra2 = intent.getStringExtra("data");
            String[] stringArrayExtra = intent.getStringArrayExtra(NetworkUtil.NETWORK_CLASS_DENIED);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            com.tramini.plugin.a.a.c.a().a(stringArrayExtra);
            com.tramini.plugin.a.a.c.a().b(stringExtra);
            com.tramini.plugin.a.a.c.a().c(stringExtra2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
