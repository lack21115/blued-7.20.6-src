package android.renderscript;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.SystemProperties;
import android.renderscript.Element;
import android.util.Log;
import android.view.Surface;
import android.widget.ExpandableListView;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript.class */
public class RenderScript {
    public static final int CREATE_FLAG_LOW_LATENCY = 2;
    public static final int CREATE_FLAG_LOW_POWER = 4;
    public static final int CREATE_FLAG_NONE = 0;
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static final long TRACE_TAG = 32768;
    static File mCacheDir;
    static Method registerNativeAllocation;
    static Method registerNativeFree;
    static boolean sInitialized = false;
    static final long sMinorID = 1;
    static int sPointerSize;
    static Object sRuntime;
    private Context mApplicationContext;
    long mContext;
    long mDev;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_FONT;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_MESH;
    Element mElement_PROGRAM_FRAGMENT;
    Element mElement_PROGRAM_RASTER;
    Element mElement_PROGRAM_STORE;
    Element mElement_PROGRAM_VERTEX;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    Element mElement_YUV;
    MessageThread mMessageThread;
    ProgramRaster mProgramRaster_CULL_BACK;
    ProgramRaster mProgramRaster_CULL_FRONT;
    ProgramRaster mProgramRaster_CULL_NONE;
    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_TEST;
    ProgramStore mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
    ProgramStore mProgramStore_BLEND_NONE_DEPTH_TEST;
    ReentrantReadWriteLock mRWLock;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;
    RSMessageHandler mMessageCallback = null;
    RSErrorHandler mErrorCallback = null;
    ContextType mContextType = ContextType.NORMAL;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript$ContextType.class */
    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        int mID;

        ContextType(int i) {
            this.mID = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript$MessageThread.class */
    public static class MessageThread extends Thread {
        static final int RS_ERROR_FATAL_DEBUG = 2048;
        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NEW_BUFFER = 5;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int[] mAuxData;
        RenderScript mRS;
        boolean mRun;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRun = true;
            this.mAuxData = new int[2];
            this.mRS = renderScript;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int[] iArr = new int[16];
            this.mRS.nContextInitToClient(this.mRS.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                int nContextPeekMessage = this.mRS.nContextPeekMessage(this.mRS.mContext, this.mAuxData);
                int i = this.mAuxData[1];
                int i2 = this.mAuxData[0];
                if (nContextPeekMessage == 4) {
                    int[] iArr2 = iArr;
                    if ((i >> 2) >= iArr.length) {
                        iArr2 = new int[(i + 3) >> 2];
                    }
                    if (this.mRS.nContextGetUserMessage(this.mRS.mContext, iArr2) != 4) {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                    if (this.mRS.mMessageCallback == null) {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                    this.mRS.mMessageCallback.mData = iArr2;
                    this.mRS.mMessageCallback.mID = i2;
                    this.mRS.mMessageCallback.mLength = i;
                    this.mRS.mMessageCallback.run();
                    iArr = iArr2;
                } else if (nContextPeekMessage == 3) {
                    String nContextGetErrorMessage = this.mRS.nContextGetErrorMessage(this.mRS.mContext);
                    if (i2 >= 4096 || (i2 >= 2048 && (this.mRS.mContextType != ContextType.DEBUG || this.mRS.mErrorCallback == null))) {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    }
                    if (this.mRS.mErrorCallback != null) {
                        this.mRS.mErrorCallback.mErrorMessage = nContextGetErrorMessage;
                        this.mRS.mErrorCallback.mErrorNum = i2;
                        this.mRS.mErrorCallback.run();
                    } else {
                        Log.e(RenderScript.LOG_TAG, "non fatal RS error, " + nContextGetErrorMessage);
                    }
                } else if (nContextPeekMessage != 5) {
                    try {
                        sleep(1L, 0);
                    } catch (InterruptedException e) {
                    }
                } else if (this.mRS.nContextGetUserMessage(this.mRS.mContext, iArr) != 5) {
                    throw new RSDriverException("Error processing message from RenderScript.");
                } else {
                    Allocation.sendBufferNotification((iArr[1] << 32) + (iArr[0] & ExpandableListView.PACKED_POSITION_VALUE_NULL));
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript$Priority.class */
    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        int mID;

        Priority(int i) {
            this.mID = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript$RSErrorHandler.class */
    public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        protected int mErrorNum;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/RenderScript$RSMessageHandler.class */
    public static class RSMessageHandler implements Runnable {
        protected int[] mData;
        protected int mID;
        protected int mLength;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        if (SystemProperties.getBoolean("config.disable_renderscript", false)) {
            return;
        }
        try {
            Class.forName("dalvik.system.VMRuntime");
            throw new VerifyError("bad dex opcode");
        } catch (Exception e) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderScript(Context context) {
        if (context != null) {
            this.mApplicationContext = context.getApplicationContext();
        }
        this.mRWLock = new ReentrantReadWriteLock();
        try {
            registerNativeAllocation.invoke(sRuntime, 4194304);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Couldn't invoke registerNativeAllocation:" + e);
            throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + e);
        }
    }

    static native void _nInit();

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript create(Context context, int i) {
        return create(context, i, ContextType.NORMAL, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType, int i2) {
        if (!sInitialized) {
            Log.e(LOG_TAG, "RenderScript.create() called when disabled; someone is likely to crash");
            return null;
        } else if ((i2 & (-7)) != 0) {
            throw new RSIllegalArgumentException("Invalid flags passed.");
        } else {
            RenderScript renderScript = new RenderScript(context);
            renderScript.mDev = renderScript.nDeviceCreate();
            renderScript.mContext = renderScript.nContextCreate(renderScript.mDev, i2, i, contextType.mID);
            renderScript.mContextType = contextType;
            if (renderScript.mContext == 0) {
                throw new RSDriverException("Failed to create RS context.");
            }
            renderScript.mMessageThread = new MessageThread(renderScript);
            renderScript.mMessageThread.start();
            return renderScript;
        }
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, 0);
    }

    public static RenderScript create(Context context, ContextType contextType, int i) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, i);
    }

    public static long getMinorID() {
        return 1L;
    }

    static native int rsnSystemGetPointerSize();

    public static void setupDiskCache(File file) {
        if (sInitialized) {
            mCacheDir = file;
        } else {
            Log.e(LOG_TAG, "RenderScript.setupDiskCache() called when disabled");
        }
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        validate();
        nContextFinish();
        nContextDeinitToClient(this.mContext);
        this.mMessageThread.mRun = false;
        try {
            this.mMessageThread.join();
        } catch (InterruptedException e) {
        }
        nContextDestroy();
        nDeviceDestroy(this.mDev);
        this.mDev = 0L;
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAlive() {
        return this.mContext != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationCopyFromBitmap(long j, Bitmap bitmap) {
        synchronized (this) {
            validate();
            rsnAllocationCopyFromBitmap(this.mContext, j, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationCopyToBitmap(long j, Bitmap bitmap) {
        synchronized (this) {
            validate();
            rsnAllocationCopyToBitmap(this.mContext, j, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nAllocationCreateBitmapBackedAllocation(long j, int i, Bitmap bitmap, int i2) {
        long rsnAllocationCreateBitmapBackedAllocation;
        synchronized (this) {
            validate();
            rsnAllocationCreateBitmapBackedAllocation = rsnAllocationCreateBitmapBackedAllocation(this.mContext, j, i, bitmap, i2);
        }
        return rsnAllocationCreateBitmapBackedAllocation;
    }

    long nAllocationCreateBitmapRef(long j, Bitmap bitmap) {
        long rsnAllocationCreateBitmapRef;
        synchronized (this) {
            validate();
            rsnAllocationCreateBitmapRef = rsnAllocationCreateBitmapRef(this.mContext, j, bitmap);
        }
        return rsnAllocationCreateBitmapRef;
    }

    long nAllocationCreateFromAssetStream(int i, int i2, int i3) {
        long rsnAllocationCreateFromAssetStream;
        synchronized (this) {
            validate();
            rsnAllocationCreateFromAssetStream = rsnAllocationCreateFromAssetStream(this.mContext, i, i2, i3);
        }
        return rsnAllocationCreateFromAssetStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nAllocationCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        long rsnAllocationCreateFromBitmap;
        synchronized (this) {
            validate();
            rsnAllocationCreateFromBitmap = rsnAllocationCreateFromBitmap(this.mContext, j, i, bitmap, i2);
        }
        return rsnAllocationCreateFromBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nAllocationCreateTyped(long j, int i, int i2, long j2) {
        long rsnAllocationCreateTyped;
        synchronized (this) {
            validate();
            rsnAllocationCreateTyped = rsnAllocationCreateTyped(this.mContext, j, i, i2, j2);
        }
        return rsnAllocationCreateTyped;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nAllocationCubeCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        long rsnAllocationCubeCreateFromBitmap;
        synchronized (this) {
            validate();
            rsnAllocationCubeCreateFromBitmap = rsnAllocationCubeCreateFromBitmap(this.mContext, j, i, bitmap, i2);
        }
        return rsnAllocationCubeCreateFromBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationData1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, j2, i7, i8, i9, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData2D(long j, int i, int i2, int i3, int i4, Bitmap bitmap) {
        synchronized (this) {
            validate();
            rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, int i9, int i10, int i11) {
        synchronized (this) {
            validate();
            rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, j2, i8, i9, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationElementData1D(long j, int i, int i2, int i3, byte[] bArr, int i4) {
        synchronized (this) {
            validate();
            rsnAllocationElementData1D(this.mContext, j, i, i2, i3, bArr, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationGenerateMipmaps(long j) {
        synchronized (this) {
            validate();
            rsnAllocationGenerateMipmaps(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Surface nAllocationGetSurface(long j) {
        Surface rsnAllocationGetSurface;
        synchronized (this) {
            validate();
            rsnAllocationGetSurface = rsnAllocationGetSurface(this.mContext, j);
        }
        return rsnAllocationGetSurface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nAllocationGetType(long j) {
        long rsnAllocationGetType;
        synchronized (this) {
            validate();
            rsnAllocationGetType = rsnAllocationGetType(this.mContext, j);
        }
        return rsnAllocationGetType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationIoReceive(long j) {
        synchronized (this) {
            validate();
            rsnAllocationIoReceive(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationIoSend(long j) {
        synchronized (this) {
            validate();
            rsnAllocationIoSend(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationRead(long j, Object obj, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationRead(this.mContext, j, obj, dataType.mID);
        }
    }

    void nAllocationRead1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationRead1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID);
        }
    }

    void nAllocationRead2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType) {
        synchronized (this) {
            validate();
            rsnAllocationRead2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationResize1D(long j, int i) {
        synchronized (this) {
            validate();
            rsnAllocationResize1D(this.mContext, j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationSetSurface(long j, Surface surface) {
        synchronized (this) {
            validate();
            rsnAllocationSetSurface(this.mContext, j, surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAllocationSyncAll(long j, int i) {
        synchronized (this) {
            validate();
            rsnAllocationSyncAll(this.mContext, j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nAssignName(long j, byte[] bArr) {
        synchronized (this) {
            validate();
            rsnAssignName(this.mContext, j, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextBindProgramFragment(long j) {
        synchronized (this) {
            validate();
            rsnContextBindProgramFragment(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextBindProgramRaster(long j) {
        synchronized (this) {
            validate();
            rsnContextBindProgramRaster(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextBindProgramStore(long j) {
        synchronized (this) {
            validate();
            rsnContextBindProgramStore(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextBindProgramVertex(long j) {
        synchronized (this) {
            validate();
            rsnContextBindProgramVertex(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextBindRootScript(long j) {
        synchronized (this) {
            validate();
            rsnContextBindRootScript(this.mContext, j);
        }
    }

    void nContextBindSampler(int i, int i2) {
        synchronized (this) {
            validate();
            rsnContextBindSampler(this.mContext, i, i2);
        }
    }

    long nContextCreate(long j, int i, int i2, int i3) {
        long rsnContextCreate;
        synchronized (this) {
            rsnContextCreate = rsnContextCreate(j, i, i2, i3);
        }
        return rsnContextCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nContextCreateGL(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13) {
        long rsnContextCreateGL;
        synchronized (this) {
            rsnContextCreateGL = rsnContextCreateGL(j, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, f, i13);
        }
        return rsnContextCreateGL;
    }

    native void nContextDeinitToClient(long j);

    void nContextDestroy() {
        synchronized (this) {
            validate();
            ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
            writeLock.lock();
            long j = this.mContext;
            this.mContext = 0L;
            writeLock.unlock();
            rsnContextDestroy(j);
        }
    }

    void nContextDump(int i) {
        synchronized (this) {
            validate();
            rsnContextDump(this.mContext, i);
        }
    }

    void nContextFinish() {
        synchronized (this) {
            validate();
            rsnContextFinish(this.mContext);
        }
    }

    native String nContextGetErrorMessage(long j);

    native int nContextGetUserMessage(long j, int[] iArr);

    native void nContextInitToClient(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextPause() {
        synchronized (this) {
            validate();
            rsnContextPause(this.mContext);
        }
    }

    native int nContextPeekMessage(long j, int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextResume() {
        synchronized (this) {
            validate();
            rsnContextResume(this.mContext);
        }
    }

    void nContextSendMessage(int i, int[] iArr) {
        synchronized (this) {
            validate();
            rsnContextSendMessage(this.mContext, i, iArr);
        }
    }

    void nContextSetPriority(int i) {
        synchronized (this) {
            validate();
            rsnContextSetPriority(this.mContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nContextSetSurface(int i, int i2, Surface surface) {
        synchronized (this) {
            validate();
            rsnContextSetSurface(this.mContext, i, i2, surface);
        }
    }

    void nContextSetSurfaceTexture(int i, int i2, SurfaceTexture surfaceTexture) {
        synchronized (this) {
            validate();
            rsnContextSetSurfaceTexture(this.mContext, i, i2, surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long nDeviceCreate();

    native void nDeviceDestroy(long j);

    native void nDeviceSetConfig(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nElementCreate(long j, int i, boolean z, int i2) {
        long rsnElementCreate;
        synchronized (this) {
            validate();
            rsnElementCreate = rsnElementCreate(this.mContext, j, i, z, i2);
        }
        return rsnElementCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nElementCreate2(long[] jArr, String[] strArr, int[] iArr) {
        long rsnElementCreate2;
        synchronized (this) {
            validate();
            rsnElementCreate2 = rsnElementCreate2(this.mContext, jArr, strArr, iArr);
        }
        return rsnElementCreate2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nElementGetNativeData(long j, int[] iArr) {
        synchronized (this) {
            validate();
            rsnElementGetNativeData(this.mContext, j, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nElementGetSubElements(long j, long[] jArr, String[] strArr, int[] iArr) {
        synchronized (this) {
            validate();
            rsnElementGetSubElements(this.mContext, j, jArr, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFileA3DCreateFromAsset(AssetManager assetManager, String str) {
        long rsnFileA3DCreateFromAsset;
        synchronized (this) {
            validate();
            rsnFileA3DCreateFromAsset = rsnFileA3DCreateFromAsset(this.mContext, assetManager, str);
        }
        return rsnFileA3DCreateFromAsset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFileA3DCreateFromAssetStream(long j) {
        long rsnFileA3DCreateFromAssetStream;
        synchronized (this) {
            validate();
            rsnFileA3DCreateFromAssetStream = rsnFileA3DCreateFromAssetStream(this.mContext, j);
        }
        return rsnFileA3DCreateFromAssetStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFileA3DCreateFromFile(String str) {
        long rsnFileA3DCreateFromFile;
        synchronized (this) {
            validate();
            rsnFileA3DCreateFromFile = rsnFileA3DCreateFromFile(this.mContext, str);
        }
        return rsnFileA3DCreateFromFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFileA3DGetEntryByIndex(long j, int i) {
        long rsnFileA3DGetEntryByIndex;
        synchronized (this) {
            validate();
            rsnFileA3DGetEntryByIndex = rsnFileA3DGetEntryByIndex(this.mContext, j, i);
        }
        return rsnFileA3DGetEntryByIndex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nFileA3DGetIndexEntries(long j, int i, int[] iArr, String[] strArr) {
        synchronized (this) {
            validate();
            rsnFileA3DGetIndexEntries(this.mContext, j, i, iArr, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nFileA3DGetNumIndexEntries(long j) {
        int rsnFileA3DGetNumIndexEntries;
        synchronized (this) {
            validate();
            rsnFileA3DGetNumIndexEntries = rsnFileA3DGetNumIndexEntries(this.mContext, j);
        }
        return rsnFileA3DGetNumIndexEntries;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFontCreateFromAsset(AssetManager assetManager, String str, float f, int i) {
        long rsnFontCreateFromAsset;
        synchronized (this) {
            validate();
            rsnFontCreateFromAsset = rsnFontCreateFromAsset(this.mContext, assetManager, str, f, i);
        }
        return rsnFontCreateFromAsset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFontCreateFromAssetStream(String str, float f, int i, long j) {
        long rsnFontCreateFromAssetStream;
        synchronized (this) {
            validate();
            rsnFontCreateFromAssetStream = rsnFontCreateFromAssetStream(this.mContext, str, f, i, j);
        }
        return rsnFontCreateFromAssetStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nFontCreateFromFile(String str, float f, int i) {
        long rsnFontCreateFromFile;
        synchronized (this) {
            validate();
            rsnFontCreateFromFile = rsnFontCreateFromFile(this.mContext, str, f, i);
        }
        return rsnFontCreateFromFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String nGetName(long j) {
        String rsnGetName;
        synchronized (this) {
            validate();
            rsnGetName = rsnGetName(this.mContext, j);
        }
        return rsnGetName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nMeshCreate(long[] jArr, long[] jArr2, int[] iArr) {
        long rsnMeshCreate;
        synchronized (this) {
            validate();
            rsnMeshCreate = rsnMeshCreate(this.mContext, jArr, jArr2, iArr);
        }
        return rsnMeshCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nMeshGetIndexCount(long j) {
        int rsnMeshGetIndexCount;
        synchronized (this) {
            validate();
            rsnMeshGetIndexCount = rsnMeshGetIndexCount(this.mContext, j);
        }
        return rsnMeshGetIndexCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nMeshGetIndices(long j, long[] jArr, int[] iArr, int i) {
        synchronized (this) {
            validate();
            rsnMeshGetIndices(this.mContext, j, jArr, iArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nMeshGetVertexBufferCount(long j) {
        int rsnMeshGetVertexBufferCount;
        synchronized (this) {
            validate();
            rsnMeshGetVertexBufferCount = rsnMeshGetVertexBufferCount(this.mContext, j);
        }
        return rsnMeshGetVertexBufferCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nMeshGetVertices(long j, long[] jArr, int i) {
        synchronized (this) {
            validate();
            rsnMeshGetVertices(this.mContext, j, jArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nObjDestroy(long j) {
        if (this.mContext != 0) {
            rsnObjDestroy(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nPathCreate(int i, boolean z, long j, long j2, float f) {
        long rsnPathCreate;
        synchronized (this) {
            validate();
            rsnPathCreate = rsnPathCreate(this.mContext, i, z, j, j2, f);
        }
        return rsnPathCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nProgramBindConstants(long j, int i, long j2) {
        synchronized (this) {
            validate();
            rsnProgramBindConstants(this.mContext, j, i, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nProgramBindSampler(long j, int i, long j2) {
        synchronized (this) {
            validate();
            rsnProgramBindSampler(this.mContext, j, i, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nProgramBindTexture(long j, int i, long j2) {
        synchronized (this) {
            validate();
            rsnProgramBindTexture(this.mContext, j, i, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nProgramFragmentCreate(String str, String[] strArr, long[] jArr) {
        long rsnProgramFragmentCreate;
        synchronized (this) {
            validate();
            rsnProgramFragmentCreate = rsnProgramFragmentCreate(this.mContext, str, strArr, jArr);
        }
        return rsnProgramFragmentCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nProgramRasterCreate(boolean z, int i) {
        long rsnProgramRasterCreate;
        synchronized (this) {
            validate();
            rsnProgramRasterCreate = rsnProgramRasterCreate(this.mContext, z, i);
        }
        return rsnProgramRasterCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nProgramStoreCreate(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, int i2, int i3) {
        long rsnProgramStoreCreate;
        synchronized (this) {
            validate();
            rsnProgramStoreCreate = rsnProgramStoreCreate(this.mContext, z, z2, z3, z4, z5, z6, i, i2, i3);
        }
        return rsnProgramStoreCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nProgramVertexCreate(String str, String[] strArr, long[] jArr) {
        long rsnProgramVertexCreate;
        synchronized (this) {
            validate();
            rsnProgramVertexCreate = rsnProgramVertexCreate(this.mContext, str, strArr, jArr);
        }
        return rsnProgramVertexCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nSamplerCreate(int i, int i2, int i3, int i4, int i5, float f) {
        long rsnSamplerCreate;
        synchronized (this) {
            validate();
            rsnSamplerCreate = rsnSamplerCreate(this.mContext, i, i2, i3, i4, i5, f);
        }
        return rsnSamplerCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptBindAllocation(long j, long j2, int i) {
        synchronized (this) {
            validate();
            rsnScriptBindAllocation(this.mContext, j, j2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptCCreate(String str, String str2, byte[] bArr, int i) {
        long rsnScriptCCreate;
        synchronized (this) {
            validate();
            rsnScriptCCreate = rsnScriptCCreate(this.mContext, str, str2, bArr, i);
        }
        return rsnScriptCCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptFieldIDCreate(long j, int i) {
        long rsnScriptFieldIDCreate;
        synchronized (this) {
            validate();
            rsnScriptFieldIDCreate = rsnScriptFieldIDCreate(this.mContext, j, i);
        }
        return rsnScriptFieldIDCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptForEach(long j, int i, long j2, long j3, byte[] bArr) {
        synchronized (this) {
            validate();
            if (bArr == null) {
                rsnScriptForEach(this.mContext, j, i, j2, j3);
            } else {
                rsnScriptForEach(this.mContext, j, i, j2, j3, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptForEachClipped(long j, int i, long j2, long j3, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        synchronized (this) {
            validate();
            if (bArr == null) {
                rsnScriptForEachClipped(this.mContext, j, i, j2, j3, i2, i3, i4, i5, i6, i7);
            } else {
                rsnScriptForEachClipped(this.mContext, j, i, j2, j3, bArr, i2, i3, i4, i5, i6, i7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptForEachMultiClipped(long j, int i, long[] jArr, long j2, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        synchronized (this) {
            validate();
            if (bArr == null) {
                rsnScriptForEachMultiClipped(this.mContext, j, i, jArr, j2, i2, i3, i4, i5, i6, i7);
            } else {
                rsnScriptForEachMultiClipped(this.mContext, j, i, jArr, j2, bArr, i2, i3, i4, i5, i6, i7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double nScriptGetVarD(long j, int i) {
        double rsnScriptGetVarD;
        synchronized (this) {
            validate();
            rsnScriptGetVarD = rsnScriptGetVarD(this.mContext, j, i);
        }
        return rsnScriptGetVarD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float nScriptGetVarF(long j, int i) {
        float rsnScriptGetVarF;
        synchronized (this) {
            validate();
            rsnScriptGetVarF = rsnScriptGetVarF(this.mContext, j, i);
        }
        return rsnScriptGetVarF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nScriptGetVarI(long j, int i) {
        int rsnScriptGetVarI;
        synchronized (this) {
            validate();
            rsnScriptGetVarI = rsnScriptGetVarI(this.mContext, j, i);
        }
        return rsnScriptGetVarI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptGetVarJ(long j, int i) {
        long rsnScriptGetVarJ;
        synchronized (this) {
            validate();
            rsnScriptGetVarJ = rsnScriptGetVarJ(this.mContext, j, i);
        }
        return rsnScriptGetVarJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptGetVarV(long j, int i, byte[] bArr) {
        synchronized (this) {
            validate();
            rsnScriptGetVarV(this.mContext, j, i, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptGroupCreate(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5) {
        long rsnScriptGroupCreate;
        synchronized (this) {
            validate();
            rsnScriptGroupCreate = rsnScriptGroupCreate(this.mContext, jArr, jArr2, jArr3, jArr4, jArr5);
        }
        return rsnScriptGroupCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptGroupExecute(long j) {
        synchronized (this) {
            validate();
            rsnScriptGroupExecute(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptGroupSetInput(long j, long j2, long j3) {
        synchronized (this) {
            validate();
            rsnScriptGroupSetInput(this.mContext, j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptGroupSetOutput(long j, long j2, long j3) {
        synchronized (this) {
            validate();
            rsnScriptGroupSetOutput(this.mContext, j, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptIntrinsicCreate(int i, long j) {
        long rsnScriptIntrinsicCreate;
        synchronized (this) {
            validate();
            rsnScriptIntrinsicCreate = rsnScriptIntrinsicCreate(this.mContext, i, j);
        }
        return rsnScriptIntrinsicCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptInvoke(long j, int i) {
        synchronized (this) {
            validate();
            rsnScriptInvoke(this.mContext, j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptInvokeV(long j, int i, byte[] bArr) {
        synchronized (this) {
            validate();
            rsnScriptInvokeV(this.mContext, j, i, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nScriptKernelIDCreate(long j, int i, int i2) {
        long rsnScriptKernelIDCreate;
        synchronized (this) {
            validate();
            rsnScriptKernelIDCreate = rsnScriptKernelIDCreate(this.mContext, j, i, i2);
        }
        return rsnScriptKernelIDCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetTimeZone(long j, byte[] bArr) {
        synchronized (this) {
            validate();
            rsnScriptSetTimeZone(this.mContext, j, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarD(long j, int i, double d) {
        synchronized (this) {
            validate();
            rsnScriptSetVarD(this.mContext, j, i, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarF(long j, int i, float f) {
        synchronized (this) {
            validate();
            rsnScriptSetVarF(this.mContext, j, i, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarI(long j, int i, int i2) {
        synchronized (this) {
            validate();
            rsnScriptSetVarI(this.mContext, j, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarJ(long j, int i, long j2) {
        synchronized (this) {
            validate();
            rsnScriptSetVarJ(this.mContext, j, i, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarObj(long j, int i, long j2) {
        synchronized (this) {
            validate();
            rsnScriptSetVarObj(this.mContext, j, i, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarV(long j, int i, byte[] bArr) {
        synchronized (this) {
            validate();
            rsnScriptSetVarV(this.mContext, j, i, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nScriptSetVarVE(long j, int i, byte[] bArr, long j2, int[] iArr) {
        synchronized (this) {
            validate();
            rsnScriptSetVarVE(this.mContext, j, i, bArr, j2, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long nTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        long rsnTypeCreate;
        synchronized (this) {
            validate();
            rsnTypeCreate = rsnTypeCreate(this.mContext, j, i, i2, i3, z, z2, i4);
        }
        return rsnTypeCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nTypeGetNativeData(long j, long[] jArr) {
        synchronized (this) {
            validate();
            rsnTypeGetNativeData(this.mContext, j, jArr);
        }
    }

    native void rsnAllocationCopyFromBitmap(long j, long j2, Bitmap bitmap);

    native void rsnAllocationCopyToBitmap(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateBitmapBackedAllocation(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateBitmapRef(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateFromAssetStream(long j, int i, int i2, int i3);

    native long rsnAllocationCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateTyped(long j, long j2, int i, int i2, long j3);

    native long rsnAllocationCubeCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native void rsnAllocationData1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, long j3, int i7, int i8, int i9, int i10);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, Bitmap bitmap);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, int i9, int i10, int i11);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9);

    native void rsnAllocationElementData1D(long j, long j2, int i, int i2, int i3, byte[] bArr, int i4);

    native void rsnAllocationGenerateMipmaps(long j, long j2);

    native Surface rsnAllocationGetSurface(long j, long j2);

    native long rsnAllocationGetType(long j, long j2);

    native void rsnAllocationIoReceive(long j, long j2);

    native void rsnAllocationIoSend(long j, long j2);

    native void rsnAllocationRead(long j, long j2, Object obj, int i);

    native void rsnAllocationRead1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5);

    native void rsnAllocationRead2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8);

    native void rsnAllocationResize1D(long j, long j2, int i);

    native void rsnAllocationSetSurface(long j, long j2, Surface surface);

    native void rsnAllocationSyncAll(long j, long j2, int i);

    native void rsnAssignName(long j, long j2, byte[] bArr);

    native void rsnContextBindProgramFragment(long j, long j2);

    native void rsnContextBindProgramRaster(long j, long j2);

    native void rsnContextBindProgramStore(long j, long j2);

    native void rsnContextBindProgramVertex(long j, long j2);

    native void rsnContextBindRootScript(long j, long j2);

    native void rsnContextBindSampler(long j, int i, int i2);

    native long rsnContextCreate(long j, int i, int i2, int i3);

    native long rsnContextCreateGL(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13);

    native void rsnContextDestroy(long j);

    native void rsnContextDump(long j, int i);

    native void rsnContextFinish(long j);

    native void rsnContextPause(long j);

    native void rsnContextResume(long j);

    native void rsnContextSendMessage(long j, int i, int[] iArr);

    native void rsnContextSetPriority(long j, int i);

    native void rsnContextSetSurface(long j, int i, int i2, Surface surface);

    native void rsnContextSetSurfaceTexture(long j, int i, int i2, SurfaceTexture surfaceTexture);

    native long rsnElementCreate(long j, long j2, int i, boolean z, int i2);

    native long rsnElementCreate2(long j, long[] jArr, String[] strArr, int[] iArr);

    native void rsnElementGetNativeData(long j, long j2, int[] iArr);

    native void rsnElementGetSubElements(long j, long j2, long[] jArr, String[] strArr, int[] iArr);

    native long rsnFileA3DCreateFromAsset(long j, AssetManager assetManager, String str);

    native long rsnFileA3DCreateFromAssetStream(long j, long j2);

    native long rsnFileA3DCreateFromFile(long j, String str);

    native long rsnFileA3DGetEntryByIndex(long j, long j2, int i);

    native void rsnFileA3DGetIndexEntries(long j, long j2, int i, int[] iArr, String[] strArr);

    native int rsnFileA3DGetNumIndexEntries(long j, long j2);

    native long rsnFontCreateFromAsset(long j, AssetManager assetManager, String str, float f, int i);

    native long rsnFontCreateFromAssetStream(long j, String str, float f, int i, long j2);

    native long rsnFontCreateFromFile(long j, String str, float f, int i);

    native String rsnGetName(long j, long j2);

    native long rsnMeshCreate(long j, long[] jArr, long[] jArr2, int[] iArr);

    native int rsnMeshGetIndexCount(long j, long j2);

    native void rsnMeshGetIndices(long j, long j2, long[] jArr, int[] iArr, int i);

    native int rsnMeshGetVertexBufferCount(long j, long j2);

    native void rsnMeshGetVertices(long j, long j2, long[] jArr, int i);

    native void rsnObjDestroy(long j, long j2);

    native long rsnPathCreate(long j, int i, boolean z, long j2, long j3, float f);

    native void rsnProgramBindConstants(long j, long j2, int i, long j3);

    native void rsnProgramBindSampler(long j, long j2, int i, long j3);

    native void rsnProgramBindTexture(long j, long j2, int i, long j3);

    native long rsnProgramFragmentCreate(long j, String str, String[] strArr, long[] jArr);

    native long rsnProgramRasterCreate(long j, boolean z, int i);

    native long rsnProgramStoreCreate(long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, int i2, int i3);

    native long rsnProgramVertexCreate(long j, String str, String[] strArr, long[] jArr);

    native long rsnSamplerCreate(long j, int i, int i2, int i3, int i4, int i5, float f);

    native void rsnScriptBindAllocation(long j, long j2, long j3, int i);

    native long rsnScriptCCreate(long j, String str, String str2, byte[] bArr, int i);

    native long rsnScriptFieldIDCreate(long j, long j2, int i);

    native void rsnScriptForEach(long j, long j2, int i, long j3, long j4);

    native void rsnScriptForEach(long j, long j2, int i, long j3, long j4, byte[] bArr);

    native void rsnScriptForEachClipped(long j, long j2, int i, long j3, long j4, int i2, int i3, int i4, int i5, int i6, int i7);

    native void rsnScriptForEachClipped(long j, long j2, int i, long j3, long j4, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7);

    native void rsnScriptForEachMultiClipped(long j, long j2, int i, long[] jArr, long j3, int i2, int i3, int i4, int i5, int i6, int i7);

    native void rsnScriptForEachMultiClipped(long j, long j2, int i, long[] jArr, long j3, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7);

    native double rsnScriptGetVarD(long j, long j2, int i);

    native float rsnScriptGetVarF(long j, long j2, int i);

    native int rsnScriptGetVarI(long j, long j2, int i);

    native long rsnScriptGetVarJ(long j, long j2, int i);

    native void rsnScriptGetVarV(long j, long j2, int i, byte[] bArr);

    native long rsnScriptGroupCreate(long j, long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5);

    native void rsnScriptGroupExecute(long j, long j2);

    native void rsnScriptGroupSetInput(long j, long j2, long j3, long j4);

    native void rsnScriptGroupSetOutput(long j, long j2, long j3, long j4);

    native long rsnScriptIntrinsicCreate(long j, int i, long j2);

    native void rsnScriptInvoke(long j, long j2, int i);

    native void rsnScriptInvokeV(long j, long j2, int i, byte[] bArr);

    native long rsnScriptKernelIDCreate(long j, long j2, int i, int i2);

    native void rsnScriptSetTimeZone(long j, long j2, byte[] bArr);

    native void rsnScriptSetVarD(long j, long j2, int i, double d);

    native void rsnScriptSetVarF(long j, long j2, int i, float f);

    native void rsnScriptSetVarI(long j, long j2, int i, int i2);

    native void rsnScriptSetVarJ(long j, long j2, int i, long j3);

    native void rsnScriptSetVarObj(long j, long j2, int i, long j3);

    native void rsnScriptSetVarV(long j, long j2, int i, byte[] bArr);

    native void rsnScriptSetVarVE(long j, long j2, int i, byte[] bArr, long j3, int[] iArr);

    native long rsnTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    native void rsnTypeGetNativeData(long j, long j2, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0L;
    }

    public void sendMessage(int i, int[] iArr) {
        nContextSendMessage(i, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validate() {
        if (this.mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validateObject(BaseObj baseObj) {
        if (baseObj != null && baseObj.mRS != this) {
            throw new RSIllegalArgumentException("Attempting to use an object across contexts.");
        }
    }
}
