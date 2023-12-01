package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/f.class */
final class f implements DialogInterface.OnKeyListener {
    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }
}
