package android.nfc.tech;

import android.nfc.Tag;
import android.nfc.TransceiveResult;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/tech/BasicTagTechnology.class */
abstract class BasicTagTechnology implements TagTechnology {
    private static final String TAG = "NFC";
    boolean mIsConnected;
    int mSelectedTechnology;
    final Tag mTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicTagTechnology(Tag tag, int i) throws RemoteException {
        this.mTag = tag;
        this.mSelectedTechnology = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkConnected() {
        if (this.mTag.getConnectedTechnology() != this.mSelectedTechnology || this.mTag.getConnectedTechnology() == -1) {
            throw new IllegalStateException("Call connect() first!");
        }
    }

    @Override // android.nfc.tech.TagTechnology, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.mTag.getTagService().resetTimeouts();
            this.mTag.getTagService().reconnect(this.mTag.getServiceHandle());
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        } finally {
            this.mIsConnected = false;
            this.mTag.setTechnologyDisconnected();
        }
    }

    @Override // android.nfc.tech.TagTechnology
    public void connect() throws IOException {
        try {
            int connect = this.mTag.getTagService().connect(this.mTag.getServiceHandle(), this.mSelectedTechnology);
            if (connect == 0) {
                this.mTag.setConnectedTechnology(this.mSelectedTechnology);
                this.mIsConnected = true;
            } else if (connect != -21) {
                throw new IOException();
            } else {
                throw new UnsupportedOperationException("Connecting to this technology is not supported by the NFC adapter.");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxTransceiveLengthInternal() {
        try {
            return this.mTag.getTagService().getMaxTransceiveLength(this.mSelectedTechnology);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }

    @Override // android.nfc.tech.TagTechnology
    public Tag getTag() {
        return this.mTag;
    }

    @Override // android.nfc.tech.TagTechnology
    public boolean isConnected() {
        if (this.mIsConnected) {
            try {
                return this.mTag.getTagService().isPresent(this.mTag.getServiceHandle());
            } catch (RemoteException e) {
                Log.e(TAG, "NFC service dead", e);
                return false;
            }
        }
        return false;
    }

    @Override // android.nfc.tech.TagTechnology
    public void reconnect() throws IOException {
        if (!this.mIsConnected) {
            throw new IllegalStateException("Technology not connected yet");
        }
        try {
            if (this.mTag.getTagService().reconnect(this.mTag.getServiceHandle()) != 0) {
                this.mIsConnected = false;
                this.mTag.setTechnologyDisconnected();
                throw new IOException();
            }
        } catch (RemoteException e) {
            this.mIsConnected = false;
            this.mTag.setTechnologyDisconnected();
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] transceive(byte[] bArr, boolean z) throws IOException {
        checkConnected();
        try {
            TransceiveResult transceive = this.mTag.getTagService().transceive(this.mTag.getServiceHandle(), bArr, z);
            if (transceive == null) {
                throw new IOException("transceive failed");
            }
            return transceive.getResponseOrThrow();
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }
}
