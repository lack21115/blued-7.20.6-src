package android.nfc.tech;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/IsoDep.class */
public final class IsoDep extends BasicTagTechnology {
    public static final String EXTRA_HIST_BYTES = "histbytes";
    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    private static final String TAG = "NFC";
    private byte[] mHiLayerResponse;
    private byte[] mHistBytes;

    public IsoDep(Tag tag) throws RemoteException {
        super(tag, 3);
        this.mHiLayerResponse = null;
        this.mHistBytes = null;
        Bundle techExtras = tag.getTechExtras(3);
        if (techExtras != null) {
            this.mHiLayerResponse = techExtras.getByteArray(EXTRA_HI_LAYER_RESP);
            this.mHistBytes = techExtras.getByteArray(EXTRA_HIST_BYTES);
        }
    }

    public static IsoDep get(Tag tag) {
        if (tag.hasTech(3)) {
            try {
                return new IsoDep(tag);
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

    public byte[] getHiLayerResponse() {
        return this.mHiLayerResponse;
    }

    public byte[] getHistoricalBytes() {
        return this.mHistBytes;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        try {
            return this.mTag.getTagService().getTimeout(3);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    public boolean isExtendedLengthApduSupported() {
        try {
            return this.mTag.getTagService().getExtendedLengthApdusSupported();
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }

    public void setTimeout(int i) {
        try {
            if (this.mTag.getTagService().setTimeout(3, i) != 0) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    public byte[] transceive(byte[] bArr) throws IOException {
        return transceive(bArr, true);
    }
}
