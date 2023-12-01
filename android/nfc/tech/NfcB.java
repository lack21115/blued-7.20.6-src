package android.nfc.tech;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/NfcB.class */
public final class NfcB extends BasicTagTechnology {
    public static final String EXTRA_APPDATA = "appdata";
    public static final String EXTRA_PROTINFO = "protinfo";
    private byte[] mAppData;
    private byte[] mProtInfo;

    public NfcB(Tag tag) throws RemoteException {
        super(tag, 2);
        Bundle techExtras = tag.getTechExtras(2);
        this.mAppData = techExtras.getByteArray(EXTRA_APPDATA);
        this.mProtInfo = techExtras.getByteArray(EXTRA_PROTINFO);
    }

    public static NfcB get(Tag tag) {
        if (tag.hasTech(2)) {
            try {
                return new NfcB(tag);
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

    public byte[] getApplicationData() {
        return this.mAppData;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public byte[] getProtocolInfo() {
        return this.mProtInfo;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ Tag getTag() {
        return super.getTag();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }

    public byte[] transceive(byte[] bArr) throws IOException {
        return transceive(bArr, true);
    }
}
