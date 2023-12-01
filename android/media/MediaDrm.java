package android.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm.class */
public final class MediaDrm {
    public static final int CERTIFICATE_TYPE_NONE = 0;
    public static final int CERTIFICATE_TYPE_X509 = 1;
    private static final int DRM_EVENT = 200;
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int EVENT_VENDOR_DEFINED = 4;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;
    private static final String PERMISSION = "android.permission.ACCESS_DRM_CERTIFICATES";
    public static final String PROPERTY_ALGORITHMS = "algorithms";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DEVICE_UNIQUE_ID = "deviceUniqueId";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_VERSION = "version";
    private static final String TAG = "MediaDrm";
    private EventHandler mEventHandler;
    private long mNativeContext;
    private OnEventListener mOnEventListener;

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$Certificate.class */
    public static final class Certificate {
        private byte[] mCertificateData;
        private byte[] mWrappedKey;

        Certificate() {
        }

        public byte[] getContent() {
            return this.mCertificateData;
        }

        public byte[] getWrappedPrivateKey() {
            return this.mWrappedKey;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$CertificateRequest.class */
    public static final class CertificateRequest {
        private byte[] mData;
        private String mDefaultUrl;

        CertificateRequest(byte[] bArr, String str) {
            this.mData = bArr;
            this.mDefaultUrl = str;
        }

        public byte[] getData() {
            return this.mData;
        }

        public String getDefaultUrl() {
            return this.mDefaultUrl;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$CryptoSession.class */
    public final class CryptoSession {
        private MediaDrm mDrm;
        private byte[] mSessionId;

        CryptoSession(MediaDrm mediaDrm, byte[] bArr, String str, String str2) {
            this.mSessionId = bArr;
            this.mDrm = mediaDrm;
            MediaDrm.setCipherAlgorithmNative(mediaDrm, bArr, str);
            MediaDrm.setMacAlgorithmNative(mediaDrm, bArr, str2);
        }

        public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            return MediaDrm.decryptNative(this.mDrm, this.mSessionId, bArr, bArr2, bArr3);
        }

        public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            return MediaDrm.encryptNative(this.mDrm, this.mSessionId, bArr, bArr2, bArr3);
        }

        public byte[] sign(byte[] bArr, byte[] bArr2) {
            return MediaDrm.signNative(this.mDrm, this.mSessionId, bArr, bArr2);
        }

        public boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            return MediaDrm.verifyNative(this.mDrm, this.mSessionId, bArr, bArr2, bArr3);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$EventHandler.class */
    private class EventHandler extends Handler {
        private MediaDrm mMediaDrm;

        public EventHandler(MediaDrm mediaDrm, Looper looper) {
            super(looper);
            this.mMediaDrm = mediaDrm;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mMediaDrm.mNativeContext == 0) {
                Log.w(MediaDrm.TAG, "MediaDrm went away with unhandled events");
                return;
            }
            switch (message.what) {
                case 200:
                    Log.i(MediaDrm.TAG, "Drm event (" + message.arg1 + "," + message.arg2 + ")");
                    if (MediaDrm.this.mOnEventListener == null || message.obj == null || !(message.obj instanceof Parcel)) {
                        return;
                    }
                    Parcel parcel = (Parcel) message.obj;
                    byte[] createByteArray = parcel.createByteArray();
                    byte[] bArr = createByteArray;
                    if (createByteArray.length == 0) {
                        bArr = null;
                    }
                    byte[] createByteArray2 = parcel.createByteArray();
                    byte[] bArr2 = createByteArray2;
                    if (createByteArray2.length == 0) {
                        bArr2 = null;
                    }
                    MediaDrm.this.mOnEventListener.onEvent(this.mMediaDrm, bArr, message.arg1, message.arg2, bArr2);
                    return;
                default:
                    Log.e(MediaDrm.TAG, "Unknown message type " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$KeyRequest.class */
    public static final class KeyRequest {
        private byte[] mData;
        private String mDefaultUrl;

        KeyRequest() {
        }

        public byte[] getData() {
            return this.mData;
        }

        public String getDefaultUrl() {
            return this.mDefaultUrl;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$MediaDrmStateException.class */
    public static final class MediaDrmStateException extends IllegalStateException {
        private final String mDiagnosticInfo;
        private final int mErrorCode;

        public MediaDrmStateException(int i, String str) {
            super(str);
            this.mErrorCode = i;
            this.mDiagnosticInfo = "android.media.MediaDrm.error_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public String getDiagnosticInfo() {
            return this.mDiagnosticInfo;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$OnEventListener.class */
    public interface OnEventListener {
        void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaDrm$ProvisionRequest.class */
    public static final class ProvisionRequest {
        private byte[] mData;
        private String mDefaultUrl;

        ProvisionRequest() {
        }

        public byte[] getData() {
            return this.mData;
        }

        public String getDefaultUrl() {
            return this.mDefaultUrl;
        }
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    public MediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this), getByteArrayFromUUID(uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native byte[] decryptNative(MediaDrm mediaDrm, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native byte[] encryptNative(MediaDrm mediaDrm, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static final byte[] getByteArrayFromUUID(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return bArr;
            }
            bArr[i2] = (byte) (mostSignificantBits >>> ((7 - i2) * 8));
            bArr[i2 + 8] = (byte) (leastSignificantBits >>> ((7 - i2) * 8));
            i = i2 + 1;
        }
    }

    private native ProvisionRequest getProvisionRequestNative(int i, String str);

    public static final boolean isCryptoSchemeSupported(UUID uuid) {
        return isCryptoSchemeSupportedNative(getByteArrayFromUUID(uuid), null);
    }

    public static final boolean isCryptoSchemeSupported(UUID uuid, String str) {
        return isCryptoSchemeSupportedNative(getByteArrayFromUUID(uuid), str);
    }

    private static final native boolean isCryptoSchemeSupportedNative(byte[] bArr, String str);

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj, byte[] bArr);

    private static void postEventFromNative(Object obj, int i, int i2, Object obj2) {
        MediaDrm mediaDrm = (MediaDrm) ((WeakReference) obj).get();
        if (mediaDrm == null || mediaDrm.mEventHandler == null) {
            return;
        }
        mediaDrm.mEventHandler.sendMessage(mediaDrm.mEventHandler.obtainMessage(200, i, i2, obj2));
    }

    private native Certificate provideProvisionResponseNative(byte[] bArr) throws DeniedByServerException;

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void setCipherAlgorithmNative(MediaDrm mediaDrm, byte[] bArr, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void setMacAlgorithmNative(MediaDrm mediaDrm, byte[] bArr, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native byte[] signNative(MediaDrm mediaDrm, byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static final native byte[] signRSANative(MediaDrm mediaDrm, byte[] bArr, String str, byte[] bArr2, byte[] bArr3);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native boolean verifyNative(MediaDrm mediaDrm, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public native void closeSession(byte[] bArr);

    protected void finalize() {
        native_finalize();
    }

    public CertificateRequest getCertificateRequest(int i, String str) {
        ProvisionRequest provisionRequestNative = getProvisionRequestNative(i, str);
        return new CertificateRequest(provisionRequestNative.getData(), provisionRequestNative.getDefaultUrl());
    }

    public CryptoSession getCryptoSession(byte[] bArr, String str, String str2) {
        return new CryptoSession(this, bArr, str, str2);
    }

    public native KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i, HashMap<String, String> hashMap) throws NotProvisionedException;

    public native byte[] getPropertyByteArray(String str);

    public native String getPropertyString(String str);

    public ProvisionRequest getProvisionRequest() {
        return getProvisionRequestNative(0, "");
    }

    public native byte[] getSecureStop(byte[] bArr);

    public native List<byte[]> getSecureStops();

    public native byte[] openSession() throws NotProvisionedException, ResourceBusyException;

    public Certificate provideCertificateResponse(byte[] bArr) throws DeniedByServerException {
        return provideProvisionResponseNative(bArr);
    }

    public native byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        provideProvisionResponseNative(bArr);
    }

    public native HashMap<String, String> queryKeyStatus(byte[] bArr);

    public final native void release();

    public native void releaseAllSecureStops();

    public native void releaseSecureStops(byte[] bArr);

    public native void removeKeys(byte[] bArr);

    public native void restoreKeys(byte[] bArr, byte[] bArr2);

    public void setOnEventListener(OnEventListener onEventListener) {
        this.mOnEventListener = onEventListener;
    }

    public native void setPropertyByteArray(String str, byte[] bArr);

    public native void setPropertyString(String str, String str2);

    public byte[] signRSA(byte[] bArr, String str, byte[] bArr2, byte[] bArr3) {
        return signRSANative(this, bArr, str, bArr2, bArr3);
    }

    public native void unprovisionDevice();
}
