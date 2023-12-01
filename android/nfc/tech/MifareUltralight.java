package android.nfc.tech;

import android.nfc.Tag;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/MifareUltralight.class */
public final class MifareUltralight extends BasicTagTechnology {
    public static final String EXTRA_IS_UL_C = "isulc";
    private static final int MAX_PAGE_COUNT = 256;
    private static final int NXP_MANUFACTURER_ID = 4;
    public static final int PAGE_SIZE = 4;
    private static final String TAG = "NFC";
    public static final int TYPE_ULTRALIGHT = 1;
    public static final int TYPE_ULTRALIGHT_C = 2;
    public static final int TYPE_UNKNOWN = -1;
    private int mType;

    public MifareUltralight(Tag tag) throws RemoteException {
        super(tag, 9);
        NfcA nfcA = NfcA.get(tag);
        this.mType = -1;
        if (nfcA.getSak() == 0 && tag.getId()[0] == 4) {
            if (tag.getTechExtras(9).getBoolean(EXTRA_IS_UL_C)) {
                this.mType = 2;
            } else {
                this.mType = 1;
            }
        }
    }

    public static MifareUltralight get(Tag tag) {
        if (tag.hasTech(9)) {
            try {
                return new MifareUltralight(tag);
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    private static void validatePageIndex(int i) {
        if (i < 0 || i >= 256) {
            throw new IndexOutOfBoundsException("page out of bounds: " + i);
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
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
            return this.mTag.getTagService().getTimeout(9);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }

    public int getType() {
        return this.mType;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    public byte[] readPages(int i) throws IOException {
        validatePageIndex(i);
        checkConnected();
        return transceive(new byte[]{48, (byte) i}, false);
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }

    public void setTimeout(int i) {
        try {
            if (this.mTag.getTagService().setTimeout(9, i) != 0) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    public byte[] transceive(byte[] bArr) throws IOException {
        return transceive(bArr, true);
    }

    public void writePage(int i, byte[] bArr) throws IOException {
        validatePageIndex(i);
        checkConnected();
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = -94;
        bArr2[1] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        transceive(bArr2, false);
    }
}
