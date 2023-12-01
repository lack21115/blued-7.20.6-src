package android.nfc.tech;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/NfcV.class */
public final class NfcV extends BasicTagTechnology {
    public static final String EXTRA_DSFID = "dsfid";
    public static final String EXTRA_RESP_FLAGS = "respflags";
    private byte mDsfId;
    private byte mRespFlags;

    public NfcV(Tag tag) throws RemoteException {
        super(tag, 5);
        Bundle techExtras = tag.getTechExtras(5);
        this.mRespFlags = techExtras.getByte(EXTRA_RESP_FLAGS);
        this.mDsfId = techExtras.getByte(EXTRA_DSFID);
    }

    public static NfcV get(Tag tag) {
        if (tag.hasTech(5)) {
            try {
                return new NfcV(tag);
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

    public byte getDsfId() {
        return this.mDsfId;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public byte getResponseFlags() {
        return this.mRespFlags;
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
