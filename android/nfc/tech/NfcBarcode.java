package android.nfc.tech;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/NfcBarcode.class */
public final class NfcBarcode extends BasicTagTechnology {
    public static final String EXTRA_BARCODE_TYPE = "barcodetype";
    public static final int TYPE_KOVIO = 1;
    public static final int TYPE_UNKNOWN = -1;
    private int mType;

    public NfcBarcode(Tag tag) throws RemoteException {
        super(tag, 10);
        Bundle techExtras = tag.getTechExtras(10);
        if (techExtras == null) {
            throw new NullPointerException("NfcBarcode tech extras are null.");
        }
        this.mType = techExtras.getInt(EXTRA_BARCODE_TYPE);
    }

    public static NfcBarcode get(Tag tag) {
        if (tag.hasTech(10)) {
            try {
                return new NfcBarcode(tag);
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
    }

    public byte[] getBarcode() {
        switch (this.mType) {
            case 1:
                return this.mTag.getId();
            default:
                return null;
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ Tag getTag() {
        return super.getTag();
    }

    public int getType() {
        return this.mType;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }
}
