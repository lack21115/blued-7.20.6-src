package android.drm;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import dalvik.system.CloseGuard;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient.class */
public class DrmManagerClient {
    private static final int ACTION_PROCESS_DRM_INFO = 1002;
    private static final int ACTION_REMOVE_ALL_RIGHTS = 1001;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_UNKNOWN = -2000;
    public static final int INVALID_SESSION = -1;
    private static final String TAG = "DrmManagerClient";
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private Context mContext;
    private EventHandler mEventHandler;
    HandlerThread mEventThread;
    private InfoHandler mInfoHandler;
    HandlerThread mInfoThread;
    private long mNativeContext;
    private OnErrorListener mOnErrorListener;
    private OnEventListener mOnEventListener;
    private OnInfoListener mOnInfoListener;
    private volatile boolean mReleased;
    private int mUniqueId;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient$EventHandler.class */
    public class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DrmErrorEvent drmErrorEvent;
            DrmEvent drmEvent = null;
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case 1001:
                    if (DrmManagerClient.this._removeAllRights(DrmManagerClient.this.mUniqueId) != 0) {
                        drmErrorEvent = new DrmErrorEvent(DrmManagerClient.this.mUniqueId, 2007, null);
                        break;
                    } else {
                        drmEvent = new DrmEvent(DrmManagerClient.this.mUniqueId, 1001, null);
                        drmErrorEvent = null;
                        break;
                    }
                case 1002:
                    DrmInfo drmInfo = (DrmInfo) message.obj;
                    DrmInfoStatus _processDrmInfo = DrmManagerClient.this._processDrmInfo(DrmManagerClient.this.mUniqueId, drmInfo);
                    hashMap.put(DrmEvent.DRM_INFO_STATUS_OBJECT, _processDrmInfo);
                    hashMap.put(DrmEvent.DRM_INFO_OBJECT, drmInfo);
                    if (_processDrmInfo != null && 1 == _processDrmInfo.statusCode) {
                        drmEvent = new DrmEvent(DrmManagerClient.this.mUniqueId, DrmManagerClient.this.getEventType(_processDrmInfo.infoType), null, hashMap);
                        drmErrorEvent = null;
                        break;
                    } else {
                        drmErrorEvent = new DrmErrorEvent(DrmManagerClient.this.mUniqueId, DrmManagerClient.this.getErrorType(_processDrmInfo != null ? _processDrmInfo.infoType : drmInfo.getInfoType()), null, hashMap);
                        break;
                    }
                    break;
                default:
                    Log.e(DrmManagerClient.TAG, "Unknown message type " + message.what);
                    return;
            }
            if (DrmManagerClient.this.mOnEventListener != null && drmEvent != null) {
                DrmManagerClient.this.mOnEventListener.onEvent(DrmManagerClient.this, drmEvent);
            }
            if (DrmManagerClient.this.mOnErrorListener == null || drmErrorEvent == null) {
                return;
            }
            DrmManagerClient.this.mOnErrorListener.onError(DrmManagerClient.this, drmErrorEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient$InfoHandler.class */
    public class InfoHandler extends Handler {
        public static final int INFO_EVENT_TYPE = 1;

        public InfoHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00d8 -> B:21:0x00c8). Please submit an issue!!! */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DrmInfoEvent drmInfoEvent;
            DrmErrorEvent drmErrorEvent = null;
            switch (message.what) {
                case 1:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    String obj = message.obj.toString();
                    switch (i2) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            drmInfoEvent = new DrmInfoEvent(i, i2, obj);
                            break;
                        case 2:
                            try {
                                DrmUtils.removeFile(obj);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            drmInfoEvent = new DrmInfoEvent(i, i2, obj);
                            break;
                        default:
                            drmErrorEvent = new DrmErrorEvent(i, i2, obj);
                            drmInfoEvent = null;
                            break;
                    }
                    if (DrmManagerClient.this.mOnInfoListener != null && drmInfoEvent != null) {
                        DrmManagerClient.this.mOnInfoListener.onInfo(DrmManagerClient.this, drmInfoEvent);
                    }
                    if (DrmManagerClient.this.mOnErrorListener == null || drmErrorEvent == null) {
                        return;
                    }
                    DrmManagerClient.this.mOnErrorListener.onError(DrmManagerClient.this, drmErrorEvent);
                    return;
                default:
                    Log.e(DrmManagerClient.TAG, "Unknown message type " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient$OnErrorListener.class */
    public interface OnErrorListener {
        void onError(DrmManagerClient drmManagerClient, DrmErrorEvent drmErrorEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient$OnEventListener.class */
    public interface OnEventListener {
        void onEvent(DrmManagerClient drmManagerClient, DrmEvent drmEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/drm/DrmManagerClient$OnInfoListener.class */
    public interface OnInfoListener {
        void onInfo(DrmManagerClient drmManagerClient, DrmInfoEvent drmInfoEvent);
    }

    static {
        System.loadLibrary("drmframework_jni");
    }

    public DrmManagerClient(Context context) {
        this.mContext = context;
        createEventThreads();
        this.mUniqueId = _initialize();
        this.mCloseGuard.open("release");
    }

    private native DrmInfo _acquireDrmInfo(int i, DrmInfoRequest drmInfoRequest);

    private native boolean _canHandle(int i, String str, String str2);

    private native int _checkRightsStatus(int i, String str, int i2);

    private native DrmConvertedStatus _closeConvertSession(int i, int i2);

    private native DrmConvertedStatus _convertData(int i, int i2, byte[] bArr);

    private native DrmSupportInfo[] _getAllSupportInfo(int i);

    private native ContentValues _getConstraints(int i, String str, int i2);

    private native int _getDrmObjectType(int i, String str, String str2);

    private native ContentValues _getMetadata(int i, String str);

    private native String _getOriginalMimeType(int i, String str, FileDescriptor fileDescriptor);

    private native int _initialize();

    private native void _installDrmEngine(int i, String str);

    private native int _openConvertSession(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native DrmInfoStatus _processDrmInfo(int i, DrmInfo drmInfo);

    private native void _release(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int _removeAllRights(int i);

    private native int _removeRights(int i, String str);

    private native int _saveRights(int i, DrmRights drmRights, String str, String str2);

    private native void _setListeners(int i, Object obj);

    private String convertUriToPath(Uri uri) {
        String str = null;
        if (uri != null) {
            String scheme = uri.getScheme();
            if (scheme == null || scheme.equals("") || scheme.equals(ContentResolver.SCHEME_FILE)) {
                str = uri.getPath();
            } else if (scheme.equals("http")) {
                return uri.toString();
            } else {
                if (!scheme.equals("content")) {
                    throw new IllegalArgumentException("Given Uri scheme is not supported");
                }
                AutoCloseable autoCloseable = null;
                try {
                    try {
                        Cursor query = this.mContext.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                        if (query == null || query.getCount() == 0 || !query.moveToFirst()) {
                            throw new IllegalArgumentException("Given Uri could not be found in media store");
                        }
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        str = string;
                        if (query != null) {
                            query.close();
                            return string;
                        }
                    } catch (SQLiteException e) {
                        throw new IllegalArgumentException("Given Uri is not formatted in a way so that it can be found in media store.");
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        autoCloseable.close();
                    }
                    throw th;
                }
            }
        }
        return str;
    }

    private void createEventThreads() {
        if (this.mEventHandler == null && this.mInfoHandler == null) {
            this.mInfoThread = new HandlerThread("DrmManagerClient.InfoHandler");
            this.mInfoThread.start();
            this.mInfoHandler = new InfoHandler(this.mInfoThread.getLooper());
            this.mEventThread = new HandlerThread("DrmManagerClient.EventHandler");
            this.mEventThread.start();
            this.mEventHandler = new EventHandler(this.mEventThread.getLooper());
        }
    }

    private void createListeners() {
        _setListeners(this.mUniqueId, new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getErrorType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return 2006;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEventType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return 1002;
            default:
                return -1;
        }
    }

    public static void notify(Object obj, int i, int i2, String str) {
        DrmManagerClient drmManagerClient = (DrmManagerClient) ((WeakReference) obj).get();
        if (drmManagerClient == null || drmManagerClient.mInfoHandler == null) {
            return;
        }
        drmManagerClient.mInfoHandler.sendMessage(drmManagerClient.mInfoHandler.obtainMessage(1, i, i2, str));
    }

    public DrmInfo acquireDrmInfo(DrmInfoRequest drmInfoRequest) {
        if (drmInfoRequest == null || !drmInfoRequest.isValid()) {
            throw new IllegalArgumentException("Given drmInfoRequest is invalid/null");
        }
        return _acquireDrmInfo(this.mUniqueId, drmInfoRequest);
    }

    public int acquireRights(DrmInfoRequest drmInfoRequest) {
        DrmInfo acquireDrmInfo = acquireDrmInfo(drmInfoRequest);
        return acquireDrmInfo == null ? ERROR_UNKNOWN : processDrmInfo(acquireDrmInfo);
    }

    public boolean canHandle(Uri uri, String str) {
        if ((uri == null || Uri.EMPTY == uri) && (str == null || str.equals(""))) {
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        }
        return canHandle(convertUriToPath(uri), str);
    }

    public boolean canHandle(String str, String str2) {
        if ((str == null || str.equals("")) && (str2 == null || str2.equals(""))) {
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        }
        return _canHandle(this.mUniqueId, str, str2);
    }

    public int checkRightsStatus(Uri uri) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return checkRightsStatus(convertUriToPath(uri));
    }

    public int checkRightsStatus(Uri uri, int i) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return checkRightsStatus(convertUriToPath(uri), i);
    }

    public int checkRightsStatus(String str) {
        return checkRightsStatus(str, 0);
    }

    public int checkRightsStatus(String str, int i) {
        if (str == null || str.equals("") || !DrmStore.Action.isValid(i)) {
            throw new IllegalArgumentException("Given path or action is not valid");
        }
        return _checkRightsStatus(this.mUniqueId, str, i);
    }

    public DrmConvertedStatus closeConvertSession(int i) {
        return _closeConvertSession(this.mUniqueId, i);
    }

    public DrmConvertedStatus convertData(int i, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            throw new IllegalArgumentException("Given inputData should be non null");
        }
        return _convertData(this.mUniqueId, i, bArr);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mCloseGuard != null) {
                this.mCloseGuard.warnIfOpen();
            }
            release();
        } finally {
            super.finalize();
        }
    }

    public String[] getAvailableDrmEngines() {
        DrmSupportInfo[] _getAllSupportInfo = _getAllSupportInfo(this.mUniqueId);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= _getAllSupportInfo.length) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            arrayList.add(_getAllSupportInfo[i2].getDescriprition());
            i = i2 + 1;
        }
    }

    public ContentValues getConstraints(Uri uri, int i) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Uri should be non null");
        }
        return getConstraints(convertUriToPath(uri), i);
    }

    public ContentValues getConstraints(String str, int i) {
        if (str == null || str.equals("") || !DrmStore.Action.isValid(i)) {
            throw new IllegalArgumentException("Given usage or path is invalid/null");
        }
        return _getConstraints(this.mUniqueId, str, i);
    }

    public int getDrmObjectType(Uri uri, String str) {
        String str2;
        if ((uri == null || Uri.EMPTY == uri) && (str == null || str.equals(""))) {
            throw new IllegalArgumentException("Uri or the mimetype should be non null");
        }
        try {
            str2 = convertUriToPath(uri);
        } catch (Exception e) {
            Log.w(TAG, "Given Uri could not be found in media store");
            str2 = "";
        }
        return getDrmObjectType(str2, str);
    }

    public int getDrmObjectType(String str, String str2) {
        if ((str == null || str.equals("")) && (str2 == null || str2.equals(""))) {
            throw new IllegalArgumentException("Path or the mimetype should be non null");
        }
        return _getDrmObjectType(this.mUniqueId, str, str2);
    }

    public String getInternalInfo(String str, FileDescriptor fileDescriptor) {
        return _getOriginalMimeType(this.mUniqueId, str, fileDescriptor);
    }

    public ContentValues getMetadata(Uri uri) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Uri should be non null");
        }
        return getMetadata(convertUriToPath(uri));
    }

    public ContentValues getMetadata(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path is invalid/null");
        }
        return _getMetadata(this.mUniqueId, str);
    }

    public String getOriginalMimeType(Uri uri) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return getOriginalMimeType(convertUriToPath(uri));
    }

    public String getOriginalMimeType(String str) {
        String str2;
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        FileInputStream fileInputStream = null;
        FileDescriptor fileDescriptor = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    fileDescriptor = fileInputStream.getFD();
                } catch (IOException e) {
                    fileInputStream2 = fileInputStream;
                    str2 = null;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                            return null;
                        } catch (IOException e2) {
                            return null;
                        }
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream3 = fileInputStream;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            fileInputStream2 = fileInputStream;
            fileInputStream3 = fileInputStream;
            String _getOriginalMimeType = _getOriginalMimeType(this.mUniqueId, str, fileDescriptor);
            str2 = _getOriginalMimeType;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    str2 = _getOriginalMimeType;
                } catch (IOException e4) {
                    return _getOriginalMimeType;
                }
            }
        } catch (IOException e5) {
        } catch (Throwable th2) {
            th = th2;
        }
        return str2;
    }

    public void installDrmEngine(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given engineFilePath: " + str + "is not valid");
        }
        _installDrmEngine(this.mUniqueId, str);
    }

    public int openConvertSession(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Path or the mimeType should be non null");
        }
        return _openConvertSession(this.mUniqueId, str);
    }

    public int processDrmInfo(DrmInfo drmInfo) {
        if (drmInfo == null || !drmInfo.isValid()) {
            throw new IllegalArgumentException("Given drmInfo is invalid/null");
        }
        int i = -2000;
        if (this.mEventHandler != null) {
            i = -2000;
            if (this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(1002, drmInfo))) {
                i = 0;
            }
        }
        return i;
    }

    public void release() {
        if (this.mReleased) {
            return;
        }
        this.mReleased = true;
        if (this.mEventHandler != null) {
            this.mEventThread.quit();
            this.mEventThread = null;
        }
        if (this.mInfoHandler != null) {
            this.mInfoThread.quit();
            this.mInfoThread = null;
        }
        this.mEventHandler = null;
        this.mInfoHandler = null;
        this.mOnEventListener = null;
        this.mOnInfoListener = null;
        this.mOnErrorListener = null;
        _release(this.mUniqueId);
        this.mCloseGuard.close();
    }

    public int removeAllRights() {
        int i = -2000;
        if (this.mEventHandler != null) {
            i = -2000;
            if (this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(1001))) {
                i = 0;
            }
        }
        return i;
    }

    public int removeRights(Uri uri) {
        if (uri == null || Uri.EMPTY == uri) {
            throw new IllegalArgumentException("Given uri is not valid");
        }
        return removeRights(convertUriToPath(uri));
    }

    public int removeRights(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Given path should be non null");
        }
        return _removeRights(this.mUniqueId, str);
    }

    public int saveRights(DrmRights drmRights, String str, String str2) throws IOException {
        if (drmRights == null || !drmRights.isValid()) {
            throw new IllegalArgumentException("Given drmRights or contentPath is not valid");
        }
        if (str != null && !str.equals("")) {
            DrmUtils.writeToFile(str, drmRights.getData());
        }
        return _saveRights(this.mUniqueId, drmRights, str, str2);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        synchronized (this) {
            this.mOnErrorListener = onErrorListener;
            if (onErrorListener != null) {
                createListeners();
            }
        }
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        synchronized (this) {
            this.mOnEventListener = onEventListener;
            if (onEventListener != null) {
                createListeners();
            }
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        synchronized (this) {
            this.mOnInfoListener = onInfoListener;
            if (onInfoListener != null) {
                createListeners();
            }
        }
    }
}
