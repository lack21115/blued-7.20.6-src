package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/vivo/identifier/IdentifierIdObserver.class */
public class IdentifierIdObserver extends ContentObserver {
    private String a;
    private int b;
    private IdentifierIdClient c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        this.c = identifierIdClient;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.c;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.b, this.a);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
