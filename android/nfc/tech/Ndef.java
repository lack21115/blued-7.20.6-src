package android.nfc.tech;

import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/Ndef.class */
public final class Ndef extends BasicTagTechnology {
    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
    public static final String EXTRA_NDEF_MSG = "ndefmsg";
    public static final String EXTRA_NDEF_TYPE = "ndeftype";
    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
    public static final int NDEF_MODE_READ_ONLY = 1;
    public static final int NDEF_MODE_READ_WRITE = 2;
    public static final int NDEF_MODE_UNKNOWN = 3;
    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    private static final String TAG = "NFC";
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_ICODE_SLI = 102;
    public static final int TYPE_MIFARE_CLASSIC = 101;
    public static final int TYPE_OTHER = -1;
    public static final String UNKNOWN = "android.ndef.unknown";
    private final int mCardState;
    private final int mMaxNdefSize;
    private final NdefMessage mNdefMsg;
    private final int mNdefType;

    public Ndef(Tag tag) throws RemoteException {
        super(tag, 6);
        Bundle techExtras = tag.getTechExtras(6);
        if (techExtras == null) {
            throw new NullPointerException("NDEF tech extras are null.");
        }
        this.mMaxNdefSize = techExtras.getInt(EXTRA_NDEF_MAXLENGTH);
        this.mCardState = techExtras.getInt(EXTRA_NDEF_CARDSTATE);
        this.mNdefMsg = (NdefMessage) techExtras.getParcelable(EXTRA_NDEF_MSG);
        this.mNdefType = techExtras.getInt(EXTRA_NDEF_TYPE);
    }

    public static Ndef get(Tag tag) {
        if (tag.hasTech(6)) {
            try {
                return new Ndef(tag);
            } catch (RemoteException e) {
                return null;
            }
        }
        return null;
    }

    public boolean canMakeReadOnly() {
        INfcTag tagService = this.mTag.getTagService();
        if (tagService == null) {
            return false;
        }
        try {
            return tagService.canMakeReadOnly(this.mNdefType);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
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

    public NdefMessage getCachedNdefMessage() {
        return this.mNdefMsg;
    }

    public int getMaxSize() {
        return this.mMaxNdefSize;
    }

    public NdefMessage getNdefMessage() throws IOException, FormatException {
        NdefMessage ndefMessage;
        INfcTag tagService;
        checkConnected();
        try {
            tagService = this.mTag.getTagService();
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            ndefMessage = null;
        }
        if (tagService == null) {
            throw new IOException("Mock tags don't support this operation.");
        }
        int serviceHandle = this.mTag.getServiceHandle();
        if (!tagService.isNdef(serviceHandle)) {
            if (tagService.isPresent(serviceHandle)) {
                return null;
            }
            throw new TagLostException();
        }
        NdefMessage ndefRead = tagService.ndefRead(serviceHandle);
        ndefMessage = ndefRead;
        if (ndefRead == null) {
            ndefMessage = ndefRead;
            if (!tagService.isPresent(serviceHandle)) {
                throw new TagLostException();
            }
        }
        return ndefMessage;
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ Tag getTag() {
        return super.getTag();
    }

    public String getType() {
        switch (this.mNdefType) {
            case 1:
                return NFC_FORUM_TYPE_1;
            case 2:
                return NFC_FORUM_TYPE_2;
            case 3:
                return NFC_FORUM_TYPE_3;
            case 4:
                return NFC_FORUM_TYPE_4;
            case 101:
                return MIFARE_CLASSIC;
            case 102:
                return ICODE_SLI;
            default:
                return UNKNOWN;
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    public boolean isWritable() {
        return this.mCardState == 2;
    }

    public boolean makeReadOnly() throws IOException {
        checkConnected();
        try {
            INfcTag tagService = this.mTag.getTagService();
            if (tagService == null) {
                return false;
            }
            if (tagService.isNdef(this.mTag.getServiceHandle())) {
                switch (tagService.ndefMakeReadOnly(this.mTag.getServiceHandle())) {
                    case -8:
                        return false;
                    case -1:
                        throw new IOException();
                    case 0:
                        return true;
                    default:
                        throw new IOException();
                }
            }
            throw new IOException("Tag is not ndef");
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
        }
    }

    @Override // android.nfc.tech.BasicTagTechnology, android.nfc.tech.TagTechnology
    public /* bridge */ /* synthetic */ void reconnect() throws IOException {
        super.reconnect();
    }

    public void writeNdefMessage(NdefMessage ndefMessage) throws IOException, FormatException {
        checkConnected();
        try {
            INfcTag tagService = this.mTag.getTagService();
            if (tagService == null) {
                throw new IOException("Mock tags don't support this operation.");
            }
            int serviceHandle = this.mTag.getServiceHandle();
            if (!tagService.isNdef(serviceHandle)) {
                throw new IOException("Tag is not ndef");
            }
            switch (tagService.ndefWrite(serviceHandle, ndefMessage)) {
                case -8:
                    throw new FormatException();
                case -1:
                    throw new IOException();
                case 0:
                    return;
                default:
                    throw new IOException();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }
}
