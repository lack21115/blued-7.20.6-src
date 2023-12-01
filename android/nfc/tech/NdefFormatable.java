package android.nfc.tech;

import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/NdefFormatable.class */
public final class NdefFormatable extends BasicTagTechnology {
    private static final String TAG = "NFC";

    public NdefFormatable(Tag tag) throws RemoteException {
        super(tag, 7);
    }

    public static NdefFormatable get(Tag tag) {
        if (tag.hasTech(7)) {
            try {
                return new NdefFormatable(tag);
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

    public void format(NdefMessage ndefMessage) throws IOException, FormatException {
        format(ndefMessage, false);
    }

    void format(NdefMessage ndefMessage, boolean z) throws IOException, FormatException {
        checkConnected();
        try {
            int serviceHandle = this.mTag.getServiceHandle();
            INfcTag tagService = this.mTag.getTagService();
            switch (tagService.formatNdef(serviceHandle, MifareClassic.KEY_DEFAULT)) {
                case -8:
                    throw new FormatException();
                case -1:
                    throw new IOException();
                case 0:
                    if (!tagService.isNdef(serviceHandle)) {
                        throw new IOException();
                    }
                    if (ndefMessage != null) {
                        switch (tagService.ndefWrite(serviceHandle, ndefMessage)) {
                            case -8:
                                throw new FormatException();
                            case -1:
                                throw new IOException();
                            case 0:
                                break;
                            default:
                                throw new IOException();
                        }
                    }
                    if (z) {
                        switch (tagService.ndefMakeReadOnly(serviceHandle)) {
                            case -8:
                                throw new IOException();
                            case -1:
                                throw new IOException();
                            case 0:
                                return;
                            default:
                                throw new IOException();
                        }
                    }
                    return;
                default:
                    throw new IOException();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    public void formatReadOnly(NdefMessage ndefMessage) throws IOException, FormatException {
        format(ndefMessage, true);
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
}
