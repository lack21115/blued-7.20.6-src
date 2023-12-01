package android.nfc.tech;

import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/MifareClassic.class */
public final class MifareClassic extends BasicTagTechnology {
    public static final int BLOCK_SIZE = 16;
    public static final byte[] KEY_DEFAULT = {-1, -1, -1, -1, -1, -1};
    public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY = {-96, -95, -94, -93, -92, -91};
    public static final byte[] KEY_NFC_FORUM = {-45, -9, -45, -9, -45, -9};
    private static final int MAX_BLOCK_COUNT = 256;
    private static final int MAX_SECTOR_COUNT = 40;
    public static final int SIZE_1K = 1024;
    public static final int SIZE_2K = 2048;
    public static final int SIZE_4K = 4096;
    public static final int SIZE_MINI = 320;
    private static final String TAG = "NFC";
    public static final int TYPE_CLASSIC = 0;
    public static final int TYPE_PLUS = 1;
    public static final int TYPE_PRO = 2;
    public static final int TYPE_UNKNOWN = -1;
    private boolean mIsEmulated;
    private int mSize;
    private int mType;

    public MifareClassic(Tag tag) throws RemoteException {
        super(tag, 8);
        NfcA nfcA = NfcA.get(tag);
        this.mIsEmulated = false;
        switch (nfcA.getSak()) {
            case 1:
            case 8:
                this.mType = 0;
                this.mSize = 1024;
                return;
            case 9:
                this.mType = 0;
                this.mSize = 320;
                return;
            case 16:
                this.mType = 1;
                this.mSize = 2048;
                return;
            case 17:
                this.mType = 1;
                this.mSize = 4096;
                return;
            case 24:
                this.mType = 0;
                this.mSize = 4096;
                return;
            case 40:
                this.mType = 0;
                this.mSize = 1024;
                this.mIsEmulated = true;
                return;
            case 56:
                this.mType = 0;
                this.mSize = 4096;
                this.mIsEmulated = true;
                return;
            case 136:
                this.mType = 0;
                this.mSize = 1024;
                return;
            case 152:
            case 184:
                this.mType = 2;
                this.mSize = 4096;
                return;
            default:
                throw new RuntimeException("Tag incorrectly enumerated as MIFARE Classic, SAK = " + ((int) nfcA.getSak()));
        }
    }

    private boolean authenticate(int i, byte[] bArr, boolean z) throws IOException {
        validateSector(i);
        checkConnected();
        byte[] bArr2 = new byte[12];
        if (z) {
            bArr2[0] = 96;
        } else {
            bArr2[0] = 97;
        }
        bArr2[1] = (byte) sectorToBlock(i);
        byte[] id = getTag().getId();
        System.arraycopy(id, id.length - 4, bArr2, 2, 4);
        System.arraycopy(bArr, 0, bArr2, 6, 6);
        try {
            return transceive(bArr2, false) != null;
        } catch (TagLostException e) {
            throw e;
        } catch (IOException e2) {
            return false;
        }
    }

    public static MifareClassic get(Tag tag) {
        if (tag.hasTech(8)) {
            try {
                return new MifareClassic(tag);
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    private static void validateBlock(int i) {
        if (i < 0 || i >= 256) {
            throw new IndexOutOfBoundsException("block out of bounds: " + i);
        }
    }

    private static void validateSector(int i) {
        if (i < 0 || i >= 40) {
            throw new IndexOutOfBoundsException("sector out of bounds: " + i);
        }
    }

    private static void validateValueOperand(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value operand negative");
        }
    }

    public boolean authenticateSectorWithKeyA(int i, byte[] bArr) throws IOException {
        return authenticate(i, bArr, true);
    }

    public boolean authenticateSectorWithKeyB(int i, byte[] bArr) throws IOException {
        return authenticate(i, bArr, false);
    }

    public int blockToSector(int i) {
        validateBlock(i);
        return i < 128 ? i / 4 : ((i - 128) / 16) + 32;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
    }

    public void decrement(int i, int i2) throws IOException {
        validateBlock(i);
        validateValueOperand(i2);
        checkConnected();
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) -64);
        allocate.put((byte) i);
        allocate.putInt(i2);
        transceive(allocate.array(), false);
    }

    public int getBlockCount() {
        return this.mSize / 16;
    }

    public int getBlockCountInSector(int i) {
        validateSector(i);
        return i < 32 ? 4 : 16;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public int getSectorCount() {
        switch (this.mSize) {
            case 320:
                return 5;
            case 1024:
                return 16;
            case 2048:
                return 32;
            case 4096:
                return 40;
            default:
                return 0;
        }
    }

    public int getSize() {
        return this.mSize;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        try {
            return this.mTag.getTagService().getTimeout(8);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }

    public int getType() {
        return this.mType;
    }

    public void increment(int i, int i2) throws IOException {
        validateBlock(i);
        validateValueOperand(i2);
        checkConnected();
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) -63);
        allocate.put((byte) i);
        allocate.putInt(i2);
        transceive(allocate.array(), false);
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    public boolean isEmulated() {
        return this.mIsEmulated;
    }

    public byte[] readBlock(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        return transceive(new byte[]{48, (byte) i}, false);
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }

    public void restore(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        transceive(new byte[]{-62, (byte) i}, false);
    }

    public int sectorToBlock(int i) {
        return i < 32 ? i * 4 : ((i - 32) * 16) + 128;
    }

    public void setTimeout(int i) {
        try {
            if (this.mTag.getTagService().setTimeout(8, i) != 0) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    public byte[] transceive(byte[] bArr) throws IOException {
        return transceive(bArr, true);
    }

    public void transfer(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        transceive(new byte[]{-80, (byte) i}, false);
    }

    public void writeBlock(int i, byte[] bArr) throws IOException {
        validateBlock(i);
        checkConnected();
        if (bArr.length != 16) {
            throw new IllegalArgumentException("must write 16-bytes");
        }
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = -96;
        bArr2[1] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        transceive(bArr2, false);
    }
}
