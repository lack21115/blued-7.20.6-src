package android.nfc;

import android.content.Context;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcManager.class */
public final class NfcManager {
    private final NfcAdapter mAdapter;

    public NfcManager(Context context) {
        NfcAdapter nfcAdapter;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("context not associated with any application (using a mock context?)");
        }
        try {
            nfcAdapter = NfcAdapter.getNfcAdapter(applicationContext);
        } catch (UnsupportedOperationException e) {
            nfcAdapter = null;
        }
        this.mAdapter = nfcAdapter;
    }

    public NfcAdapter getDefaultAdapter() {
        return this.mAdapter;
    }
}
