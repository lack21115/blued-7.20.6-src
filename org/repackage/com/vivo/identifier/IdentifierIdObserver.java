package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/vivo/identifier/IdentifierIdObserver.class */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f44120a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private IdentifierIdClient f44121c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        this.f44121c = identifierIdClient;
        this.b = i;
        this.f44120a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.f44121c;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.b, this.f44120a);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
