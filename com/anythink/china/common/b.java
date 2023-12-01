package com.anythink.china.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/b.class */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6306a = b.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ((Intent.ACTION_PACKAGE_ADDED.equals(action) || Intent.ACTION_PACKAGE_REPLACED.equals(action)) && intent.getData() != null) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            StringBuilder sb = new StringBuilder("onReceive: apk install success( ");
            sb.append(schemeSpecificPart);
            sb.append(")");
            a.a(context).b(schemeSpecificPart);
        }
    }
}
