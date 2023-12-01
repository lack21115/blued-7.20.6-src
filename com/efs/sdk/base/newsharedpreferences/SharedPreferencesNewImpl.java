package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl.class */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private static final String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final Object mFileMonitorSyncObj = new Object();
    private static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static ExecutorService sCachedThreadPool;
    private String mBackupFilePath;
    private int mCurTryTime;
    private Vector<SharedPreferences.Editor> mEditorList;
    private OnSharedPreferenceErrorListener mErrorListener;
    private File mFile;
    private FileChannel mFileChannel;
    private FileMonitor mFileMonitor;
    private Handler mHandler;
    private boolean mIsSaving;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final LinkedHashMap<String, Object> mMap;
    private MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    private int mModifyID;
    private RunnableEx mSaveRunnable;
    private final Object mSyncObj;
    private final Object mSyncSaveObj;
    private final Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$ByteFloatUtils.class */
    public static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] floatToBytes(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$ByteIntUtils.class */
    public static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] intToBytes(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$ByteLongUtils.class */
    public static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] longToBytes(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$EditorImpl.class */
    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        final boolean doClear() {
            boolean z;
            synchronized (this) {
                z = this.mClear;
                this.mClear = false;
            }
            return z;
        }

        final HashMap<String, Object> getAll() {
            HashMap<String, Object> hashMap;
            synchronized (this) {
                hashMap = this.mModified;
            }
            return hashMap;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$FileMonitor.class */
    final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$OnSharedPreferenceErrorListener.class */
    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$RunnableEx.class */
    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/newsharedpreferences/SharedPreferencesNewImpl$SUPPORTED_TYPE.class */
    class SUPPORTED_TYPE {
        static final byte TYPE_BOOLEAN = 4;
        static final byte TYPE_FLOAT = 2;
        static final byte TYPE_INT = 1;
        static final byte TYPE_LONG = 3;
        static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                sCachedThreadPool = Executors.newCachedThreadPool();
                return;
            }
            mHandlerThreadPool[i2] = new HandlerThread("newsp".concat(String.valueOf(i2)));
            mHandlerThreadPool[i2].start();
            i = i2 + 1;
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID <= 0 || modifyID == SharedPreferencesNewImpl.this.mModifyID) {
                    return;
                }
                SharedPreferencesNewImpl.this.saveInner(false);
            }
        };
        this.mSaveRunnable = new RunnableEx() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z);
        }
        this.mHandler.post(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (file2.exists()) {
                        return;
                    }
                    file2.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, boolean z) {
        this(file, 0, null, z);
    }

    private MappedByteBuffer allocBuffer(int i) {
        MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        int position = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(position);
        }
        return this.mMappedByteBuffer;
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    wait();
                }
            }
        }
        tryReload();
    }

    private void backup() {
        Closeable closeable = null;
        Closeable closeable2 = null;
        try {
            File file = new File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                closeable2 = channel;
                this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), channel);
                safeClose(fileOutputStream);
                safeClose(channel);
            } catch (Throwable th) {
                closeable = fileOutputStream;
                th = th;
                try {
                    th.printStackTrace();
                } finally {
                    safeClose(closeable);
                    safeClose(closeable2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = null;
        }
    }

    private byte getBCCCode(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte[] getBytes(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return ((String) obj).getBytes();
                }
                if (obj instanceof Boolean) {
                    int i = 1;
                    if (!((Boolean) obj).booleanValue()) {
                        i = 0;
                    }
                    return new byte[]{(byte) i};
                } else if (obj instanceof Float) {
                    return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
                } else {
                    if (obj instanceof Integer) {
                        return ByteIntUtils.intToBytes(((Integer) obj).intValue());
                    }
                    if (obj instanceof Long) {
                        return ByteLongUtils.longToBytes(((Long) obj).longValue());
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[Catch: all -> 0x00a3, TryCatch #0 {, blocks: (B:10:0x0019, B:13:0x004f, B:16:0x005c, B:18:0x0063, B:20:0x0070, B:21:0x007c, B:23:0x0083, B:24:0x008e, B:26:0x009b, B:30:0x00a0), top: B:48:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getContentLength() {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.getContentLength():int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Pair<Integer, byte[][]> getDataBytes() {
        byte[] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int size = arrayList.size() - 1;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (size < 0) {
                return new Pair<>(Integer.valueOf(i), bArr);
            }
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            int i4 = i;
            int i5 = i3;
            if (str != null) {
                i4 = i;
                i5 = i3;
                if (str.trim().length() > 0) {
                    i4 = i;
                    i5 = i3;
                    if (value != null) {
                        byte[] bytes = str.getBytes();
                        byte[] intToBytes = ByteIntUtils.intToBytes(bytes.length);
                        bArr[i3] = intToBytes;
                        bArr[i3 + 1] = bytes;
                        int length = intToBytes.length;
                        int length2 = bytes.length;
                        byte[] bytes2 = getBytes(value);
                        byte[] intToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                        bArr[i3 + 2] = intToBytes2;
                        bArr[i3 + 3] = bytes2;
                        int length3 = intToBytes2.length;
                        int length4 = bytes2.length;
                        byte[] bArr2 = new byte[1];
                        bArr2[0] = (byte) getObjectType(value);
                        bArr[i3 + 4] = bArr2;
                        i4 = i + length + length2 + length3 + length4 + 1;
                        i5 = i3 + 5;
                    }
                }
            }
            size--;
            i = i4;
            i2 = i5;
        }
    }

    private HandlerThread getHandlerThread() {
        int nextInt = new Random().nextInt();
        int i = nextInt;
        if (nextInt < 0) {
            i = -nextInt;
        }
        return mHandlerThreadPool[i % 3];
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    private Object getObjectByType(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i == 5) {
                return new String(bArr);
            }
            boolean z = true;
            if (i == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 2) {
                return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
            } else {
                if (i == 1) {
                    return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
                }
                if (i == 3) {
                    return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int i3 = i + 4;
        if (bArr[i3] == 18 || bArr[i3] == getMaskByte(bArr2)) {
            int i4 = i3 + 1;
            int bytesToInt = ByteIntUtils.bytesToInt(bArr2);
            if (bytesToInt < 0 || (i2 = i4 + bytesToInt) >= bArr.length || bytesToInt > Integer.MAX_VALUE) {
                throw new Exception("length string is invalid");
            }
            byte[] bArr3 = null;
            int i5 = i4;
            if (bytesToInt != 0) {
                bArr3 = new byte[bytesToInt];
                System.arraycopy(bArr, i4, bArr3, 0, bytesToInt);
                if (bArr[i2] != 18 && bArr[i2] != getMaskByte(bArr3)) {
                    throw new Exception("Stored bytes' finish mark missing");
                }
                i5 = i2;
            }
            return new Pair<>(bArr3, Integer.valueOf(i5 + 1));
        }
        throw new Exception("length string's finish mark missing");
    }

    private int increaseModifyID() {
        int i = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i;
        return i;
    }

    private boolean initBuffer() {
        boolean z;
        boolean z2 = true;
        if (this.mMappedByteBuffer == null) {
            try {
                if (!this.mFile.exists()) {
                    this.mFile.getParentFile().mkdirs();
                    this.mFile.createNewFile();
                    z2 = new File(this.mBackupFilePath).exists();
                } else if (this.mFile.length() == 0) {
                    if (this.mErrorListener != null) {
                        this.mErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                    }
                    z2 = false;
                }
                this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
                allocBuffer(10);
                if (!z2) {
                    initFileHeader();
                }
                return z2;
            } catch (Exception e) {
                e.printStackTrace();
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                z = false;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath() + " " + e.getCause(), 10, -1L);
                    return false;
                }
            }
        } else {
            z = true;
        }
        return z;
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] intToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(intToBytes);
            byte[] intToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(intToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    private void load(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        byte[] bArr;
        FileLock lockFile = z ? null : lockFile(true);
        if (lockFile == null && !z) {
            if (z) {
                return;
            }
            loadFromBakFile();
            return;
        }
        boolean z5 = false;
        byte[] bArr2 = null;
        try {
            reallocBuffer();
            if (this.mMappedByteBuffer != null && this.mMappedByteBuffer.capacity() != 0) {
                long contentLength = getContentLength();
                if (contentLength <= 10) {
                    try {
                        z5 = parseBytesIntoMap(null, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!z5 || this.mModifyID < 0) {
                        loadFromBakFile();
                    }
                    if (lockFile != null) {
                        try {
                            lockFile.release();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                int modifyID = getModifyID();
                this.mModifyID = modifyID;
                byte[] bArr3 = null;
                if (modifyID > 0) {
                    synchronized (this.mSyncObj) {
                        this.mMappedByteBuffer.position(10);
                        bArr = new byte[((int) contentLength) - 10];
                        safeBufferGet(this.mMappedByteBuffer, bArr);
                        bArr2 = bArr;
                    }
                    bArr3 = bArr;
                }
                try {
                    z4 = parseBytesIntoMap(bArr3, true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    z4 = false;
                }
                if (!z4 || (bArr3 == null && this.mModifyID < 0)) {
                    loadFromBakFile();
                }
                if (lockFile != null) {
                    try {
                        lockFile.release();
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                z3 = parseBytesIntoMap(null, true);
            } catch (Exception e5) {
                e5.printStackTrace();
                z3 = false;
            }
            if (!z3 || this.mModifyID < 0) {
                loadFromBakFile();
            }
            if (lockFile != null) {
                try {
                    lockFile.release();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                z2 = parseBytesIntoMap(bArr2, true);
            } catch (Exception e7) {
                e7.printStackTrace();
                z2 = false;
            }
            if (!z2 || (bArr2 == null && this.mModifyID < 0)) {
                loadFromBakFile();
            }
            if (lockFile != null) {
                try {
                    lockFile.release();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    private boolean loadFromBakFile() {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        boolean z;
        boolean z2;
        long length;
        String str;
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        int bytesToInt;
        boolean z3 = true;
        try {
            randomAccessFile = new RandomAccessFile(this.mBackupFilePath, "r");
            bArr = null;
        } catch (Throwable th) {
            th = th;
            bArr = null;
            randomAccessFile = null;
        }
        try {
            byte[] bArr2 = new byte[4];
            randomAccessFile.read(bArr2, 0, 4);
            bytesToInt = ByteIntUtils.bytesToInt(bArr2);
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                safeClose(randomAccessFile);
                try {
                    z3 = parseBytesIntoMap(bArr, false);
                } catch (Exception e) {
                    e.printStackTrace();
                    z3 = true;
                }
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
                z2 = z3;
                if (onSharedPreferenceErrorListener2 != null) {
                    String str2 = this.mBackupFilePath + "#" + th.getCause() + "#" + z3;
                    length = bArr == null ? 0 : bArr.length;
                    str = str2;
                    onSharedPreferenceErrorListener = onSharedPreferenceErrorListener2;
                    onSharedPreferenceErrorListener.onError(str, 12, length);
                    return z3;
                }
                return z2;
            } catch (Throwable th3) {
                safeClose(randomAccessFile);
                try {
                    z = parseBytesIntoMap(bArr, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = true;
                }
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener3 = this.mErrorListener;
                if (onSharedPreferenceErrorListener3 != null) {
                    onSharedPreferenceErrorListener3.onError(this.mBackupFilePath + "#" + th.getCause() + "#" + z, 12, bArr == null ? 0 : bArr.length);
                }
                throw th3;
            }
        }
        if (bytesToInt <= 10) {
            safeClose(randomAccessFile);
            try {
                parseBytesIntoMap(null, false);
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        int i = bytesToInt;
        if (bytesToInt > Integer.MAX_VALUE) {
            i = Integer.MAX_VALUE;
        }
        if (i > randomAccessFile.length()) {
            i = (int) randomAccessFile.length();
        }
        int i2 = i - 10;
        byte[] bArr3 = new byte[i2];
        randomAccessFile.seek(10L);
        bArr = bArr3;
        randomAccessFile.read(bArr3);
        safeClose(randomAccessFile);
        try {
            z3 = parseBytesIntoMap(bArr3, false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        onSharedPreferenceErrorListener = this.mErrorListener;
        z2 = z3;
        if (onSharedPreferenceErrorListener != null) {
            str = this.mBackupFilePath + "#" + ((Object) "") + "#" + z3;
            length = i2;
            onSharedPreferenceErrorListener.onError(str, 12, length);
            return z3;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private FileLock lockFile(boolean z) {
        FileLock fileLock;
        FileChannel fileChannel = this.mFileChannel;
        FileLock fileLock2 = null;
        FileLock fileLock3 = null;
        if (fileChannel == null) {
            return null;
        }
        if (z) {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                fileLock2 = fileLock3;
                if (fileLock3 == null) {
                    try {
                        fileLock = this.mFileChannel.tryLock();
                    } catch (Exception e) {
                        e.printStackTrace();
                        fileLock = fileLock3;
                    }
                    if (fileLock == null) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    fileLock3 = fileLock;
                }
            } while (SystemClock.uptimeMillis() - uptimeMillis <= 10000);
            return fileLock;
        }
        try {
            return fileChannel.tryLock();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return fileLock2;
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean doClear = editorImpl.doClear();
        if (doClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return doClear;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mListeners.size()) {
                return;
            }
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i2);
            if (onSharedPreferenceChangeListener != null) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
            }
            i = i2 + 1;
        }
    }

    private byte[] obtainTotalBytes() {
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int intValue = dataBytes.first.intValue() + 10 + (dataBytes.second.length * 1);
        int i = intValue;
        if (intValue > Integer.MAX_VALUE) {
            i = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[i];
        byte[] intToBytes = ByteIntUtils.intToBytes(i);
        System.arraycopy(intToBytes, 0, bArr, 0, intToBytes.length);
        int length = intToBytes.length + 0;
        bArr[length] = getMaskByte(intToBytes);
        int i2 = length + 1;
        byte[] intToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(intToBytes2, 0, bArr, i2, intToBytes2.length);
        int length2 = i2 + intToBytes2.length;
        bArr[length2] = getMaskByte(intToBytes2);
        int i3 = length2 + 1;
        byte[][] bArr2 = dataBytes.second;
        int length3 = bArr2.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i4];
            int i5 = i3;
            if (bArr3 != null) {
                if (bArr3.length + i3 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i3, bArr3.length);
                    int length4 = i3 + bArr3.length;
                    bArr[length4] = getMaskByte(bArr3);
                    i5 = length4 + 1;
                } else {
                    StringBuilder sb = new StringBuilder("Write too much data in ");
                    File file = this.mFile;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    Log.e(TAG, sb.toString());
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.mFile;
                        String str = null;
                        if (file2 != null) {
                            str = file2.getAbsolutePath();
                        }
                        onSharedPreferenceErrorListener.onError(str, 7, -1L);
                        return bArr;
                    }
                }
            }
            i4++;
            i3 = i5;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a7, code lost:
        if (r7.mErrorListener == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
        r0 = r7.mErrorListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
        if (r7.mFile == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b7, code lost:
        r16 = r7.mFile.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
        r0.onError(r16, 8, r8.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0209, code lost:
        r16 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseBytesIntoMap(byte[] r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.parseBytesIntoMap(byte[], boolean):boolean");
    }

    private void reallocBuffer() {
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                int contentLength = getContentLength();
                if (contentLength > this.mMappedByteBuffer.capacity()) {
                    allocBuffer(contentLength + 1024);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        MappedByteBuffer mappedByteBuffer2 = mappedByteBuffer;
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer2 = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer2.put(bArr);
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z4 = false;
            this.mCurTryTime = 0;
            if (merge(editor, this.mMap, false)) {
                z4 = true;
            } else if (this.mEditorList.size() == 0) {
                return;
            }
            if (z4) {
                this.mEditorList.add(editor);
            }
            if (z2) {
                saveInner(z);
                return;
            }
            long j = z3 ? 1000L : 0L;
            this.mSaveRunnable.setArg(Boolean.valueOf(z));
            Message obtain = Message.obtain(this.mHandler, this.mSaveRunnable);
            obtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(obtain, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(final boolean z) {
        synchronized (this.mSyncSaveObj) {
            FileLock lockFile = lockFile(false);
            if (lockFile != null) {
                this.mIsSaving = true;
                if (tryReloadWhenSave()) {
                    mergeWhenReload();
                    notifyDataChanged(null);
                }
                synchronized (this.mMap) {
                    if (this.mEditorList.size() <= 0) {
                        try {
                            lockFile.release();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.mIsSaving = false;
                        return;
                    }
                    saveToMappedBuffer(obtainTotalBytes(), z);
                    backup();
                    try {
                        lockFile.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.mIsSaving = false;
                }
            }
            int i = this.mCurTryTime;
            this.mCurTryTime = i + 1;
            if (i < 6) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferencesNewImpl.this.saveInner(z);
                    }
                }, 2000L);
            }
        }
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private void startLoadFromDisk(boolean z) {
        synchronized (this) {
            this.mLoaded = false;
        }
        Runnable runnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z) {
            runnable.run();
        } else {
            sCachedThreadPool.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > TRY_RELOAD_INTERVAL) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    final boolean checkTypeValid(byte b) {
        return b == 4 || b == 2 || b == 1 || b == 3 || b == 5;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        boolean containsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap hashMap;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        boolean z2;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Boolean bool = (Boolean) this.mMap.get(str);
                z2 = z;
                if (bool != null) {
                    z2 = bool.booleanValue();
                }
            } catch (ClassCastException e) {
                if (this.mErrorListener != null) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                }
                return z;
            }
        }
        return z2;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        float f2;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Float f3 = (Float) this.mMap.get(str);
                f2 = f;
                if (f3 != null) {
                    f2 = f3.floatValue();
                }
            } catch (ClassCastException e) {
                if (this.mErrorListener != null) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                }
                return f;
            }
        }
        return f2;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        int i2;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Integer num = (Integer) this.mMap.get(str);
                i2 = i;
                if (num != null) {
                    i2 = num.intValue();
                }
            } catch (ClassCastException e) {
                if (this.mErrorListener != null) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                }
                return i;
            }
        }
        return i2;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        long j2;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Long l = (Long) this.mMap.get(str);
                j2 = j;
                if (l != null) {
                    j2 = l.longValue();
                }
            } catch (ClassCastException e) {
                if (this.mErrorListener != null) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                }
                return j;
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0012, B:11:0x0049, B:14:0x0056, B:17:0x0067, B:19:0x006e, B:21:0x007b, B:22:0x0087, B:24:0x008e, B:25:0x0099, B:27:0x00a6, B:31:0x00ab), top: B:44:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0012, B:11:0x0049, B:14:0x0056, B:17:0x0067, B:19:0x006e, B:21:0x007b, B:22:0x0087, B:24:0x008e, B:25:0x0099, B:27:0x00a6, B:31:0x00ab), top: B:44:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getModifyID() {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.getModifyID():int");
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                String str3 = (String) this.mMap.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } catch (ClassCastException e) {
                if (this.mErrorListener != null) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e);
                    onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                }
                return str2;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }
}
