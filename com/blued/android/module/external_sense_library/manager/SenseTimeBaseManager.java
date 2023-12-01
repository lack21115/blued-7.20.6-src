package com.blued.android.module.external_sense_library.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.contract.IGetBufferCallback;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.contract.IHandActionListener;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.display.STGLRender;
import com.blued.android.module.external_sense_library.gl.TextureProcessor;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.AppLogger;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.HandlerUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import com.sensetime.stmobile.STEffectInImage;
import com.sensetime.stmobile.STMobileAnimalNative;
import com.sensetime.stmobile.STMobileEffectNative;
import com.sensetime.stmobile.STMobileFaceAttributeNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileObjectTrackNative;
import com.sensetime.stmobile.model.STAnimalFace;
import com.sensetime.stmobile.model.STAnimalFaceInfo;
import com.sensetime.stmobile.model.STEffectCustomParam;
import com.sensetime.stmobile.model.STEffectRenderInParam;
import com.sensetime.stmobile.model.STEffectRenderOutParam;
import com.sensetime.stmobile.model.STEffectTexture;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STQuaternion;
import com.sensetime.stmobile.model.STRect;
import com.sensetime.stmobile.model.STStickerInputParams;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeBaseManager.class */
public abstract class SenseTimeBaseManager implements SensorEventListener, IRequestHost, IGetBufferCallback, ISenseTimeProcessor {
    protected static final String DRAW_FRAME_TAG = "Blued_Sense_DrawFrame";
    protected static final int MESSAGE_NEED_ADD_STICKER = 1006;
    protected static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
    protected static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
    protected static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
    protected static final int MESSAGE_PROCESS_IMAGE = 100;
    protected static final int RESULT_DEFAULT = 1000;
    protected static final int RESULT_SUCCESS = 0;
    protected static final int ST_E_ZIP_EXIST_IN_MEMORY = -33;
    protected static final String TAG = "Blued_Sense_SenseTimeManager";
    protected int CHANGESTICKER_RESULT;
    private int effectNativeInstanceResult;
    protected IHandActionListener iHandActionListener;
    protected STStickerInputParams inputEvent;
    protected boolean isActive;
    protected boolean isEffectNativeInstance;
    protected boolean isNeedSaveFrame;
    protected boolean isUseSensor;
    protected boolean loadStickering;
    protected Accelerometer mAccelerometer;
    protected STAnimalFaceInfo[] mAnimalFaceInfo;
    protected float[] mBeautifyParams;
    protected int[] mBeautifyTextureId;
    protected volatile boolean mCameraChanging;
    protected int mCameraID;
    protected Handler mChangeStickerManagerHandler;
    protected HandlerThread mChangeStickerManagerThread;
    protected Context mContext;
    protected float mCurrentFilterStrength;
    protected String mCurrentFilterStyle;
    protected StickerBaseModel mCurrentStickerModel;
    protected int mCustomEvent;
    protected long mDetectConfig;
    protected float mFilterStrength;
    protected String mFilterStyle;
    protected int[] mFilterTextureOutId;
    protected Handler mHandler;
    protected STHumanAction mHumanActionBeautyOutput;
    protected int mHumanActionCreateConfig;
    protected HandlerThread mHumanActionDetectThread;
    protected Object mHumanActionHandleLock;
    protected volatile byte[] mImageData;
    protected Object mImageDataLock;
    protected int mImageHeight;
    protected int mImageRotation;
    protected int mImageWidth;
    protected Rect mIndexRect;
    protected int mInputTextureId;
    protected boolean mIsCreateHumanActionHandleSucceeded;
    protected boolean mIsObjectTracking;
    protected boolean mIsPaused;
    protected boolean mNeedAnimalDetect;
    protected boolean mNeedBeautify;
    protected boolean mNeedFaceAttribute;
    protected boolean mNeedFilter;
    protected boolean mNeedObject;
    protected boolean mNeedSetObjectTarget;
    protected boolean mNeedShowRect;
    protected boolean mNeedSticker;
    protected byte[] mNv21ImageData;
    protected byte[] mOutputBuffer;
    protected int mParamType;
    protected Handler mProcessImageHandler;
    protected HandlerThread mProcessImageThread;
    protected ByteBuffer mRGBABuffer;
    protected Sensor mRotation;
    protected STMobileFaceAttributeNative mSTFaceAttributeNative;
    protected STGLRender mSTGLRender;
    protected STMobileHumanActionNative mSTHumanActionNative;
    protected STMobileEffectNative mSTMobileEffectNative;
    protected STMobileObjectTrackNative mSTMobileObjectTrackNative;
    protected int mScreenIndexRectWidth;
    protected SensorEvent mSensorEvent;
    protected SensorManager mSensorManager;
    protected HashMap<String, ISetStickerListener> mSetStickerListenerMap;
    protected STMobileAnimalNative mStAnimalNative;
    protected HashMap<String, Integer> mStickerMaps;
    protected int[] mStickerTextureOutId;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;
    protected Rect mTargetRect;
    protected int mTexHeight;
    protected int mTexWidth;
    protected TextureProcessor mTextureProcessor;
    protected TextureProcessor mTextureProcessorBack;
    protected TextureProcessor mTextureProcessorFront;
    protected Handler mUpdateHandActionHandler;
    protected int result;

    public SenseTimeBaseManager(Context context) {
        this(context, true);
    }

    public SenseTimeBaseManager(Context context, boolean z) {
        this.isNeedSaveFrame = false;
        this.mCurrentFilterStrength = 0.65f;
        this.mFilterStrength = 0.65f;
        this.mHumanActionBeautyOutput = new STHumanAction();
        this.mCameraChanging = false;
        this.mNeedShowRect = true;
        this.mScreenIndexRectWidth = 0;
        this.mCustomEvent = 0;
        this.mTargetRect = new Rect();
        this.mIndexRect = new Rect();
        this.mNeedSetObjectTarget = false;
        this.mIsObjectTracking = false;
        this.mCameraID = 1;
        this.mNeedBeautify = false;
        this.mNeedFaceAttribute = false;
        this.mNeedSticker = false;
        this.mNeedFilter = false;
        this.mNeedObject = false;
        this.mBeautifyParams = new float[]{0.02f, 0.36f, 0.74f, 0.0f, 0.11f, 0.13f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mIsPaused = false;
        this.mDetectConfig = 0L;
        this.mIsCreateHumanActionHandleSucceeded = false;
        this.mHumanActionHandleLock = new Object();
        this.mImageDataLock = new Object();
        this.mHumanActionCreateConfig = STMobileHumanActionNative.ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO;
        this.mStickerMaps = new HashMap<>();
        this.mParamType = 0;
        this.result = 1000;
        this.CHANGESTICKER_RESULT = 1000;
        this.mNeedAnimalDetect = false;
        this.loadStickering = false;
        this.isUseSensor = true;
        this.mSetStickerListenerMap = new HashMap<>();
        this.mAnimalFaceInfo = new STAnimalFaceInfo[2];
        if (context == null || AppInfo.d() == null) {
            return;
        }
        StickerConfig.a(AppInfo.d());
        this.mContext = context;
        this.isUseSensor = z;
        this.isActive = true;
    }

    private void initHandlerManager() {
        HandlerThread handlerThread = new HandlerThread("ProcessImageThread");
        this.mProcessImageThread = handlerThread;
        handlerThread.start();
        this.mProcessImageHandler = new Handler(this.mProcessImageThread.getLooper()) { // from class: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 100 || SenseTimeBaseManager.this.mIsPaused || SenseTimeBaseManager.this.mCameraChanging) {
                    return;
                }
                SenseTimeBaseManager.this.objectTrack();
            }
        };
        HandlerThread handlerThread2 = new HandlerThread("mHumanActionDetectThread");
        this.mHumanActionDetectThread = handlerThread2;
        handlerThread2.start();
        this.mUpdateHandActionHandler = new Handler(this.mHumanActionDetectThread.getLooper()) { // from class: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 141) {
                    return;
                }
                try {
                    if (message.obj != null) {
                        long longValue = ((Long) message.obj).longValue();
                        if (SenseTimeBaseManager.this.iHandActionListener != null) {
                            SenseTimeBaseManager.this.iHandActionListener.onHandAction(longValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        HandlerThread handlerThread3 = new HandlerThread("ChangeStickerManagerThread");
        this.mChangeStickerManagerThread = handlerThread3;
        handlerThread3.start();
        this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) { // from class: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (SenseTimeBaseManager.this.mIsPaused) {
                    return;
                }
                StickerBaseModel stickerBaseModel = (StickerBaseModel) message.obj;
                switch (message.what) {
                    case 1003:
                        if (stickerBaseModel == null) {
                            LogUtils.c(SenseTimeBaseManager.TAG, "change sticker | baseModel == null", new Object[0]);
                            return;
                        }
                        String str = stickerBaseModel.localPath;
                        String str2 = stickerBaseModel.name;
                        String str3 = SenseTimeBaseManager.this.mCurrentStickerModel != null ? SenseTimeBaseManager.this.mCurrentStickerModel.localPath : "";
                        LogUtils.c(SenseTimeBaseManager.TAG, "change sticker | changeSticker: " + str, new Object[0]);
                        if (!str3.equals(str)) {
                            LogUtils.c(SenseTimeBaseManager.TAG, "change sticker | !mCurrentSticker.equals(changeSticker)", new Object[0]);
                            LogUtils.c(SenseTimeBaseManager.TAG, "change sticker | result: " + SenseTimeBaseManager.this.CHANGESTICKER_RESULT, new Object[0]);
                            SenseTimeBaseManager.this.mSTMobileEffectNative.changePackage(str);
                            SenseTimeBaseManager.this.updateHumanActionDetectConfig();
                            if (TextUtils.isEmpty(str)) {
                                SenseTimeBaseManager.this.mCurrentStickerModel = null;
                            } else if (SenseTimeBaseManager.this.CHANGESTICKER_RESULT == 0 || SenseTimeBaseManager.this.CHANGESTICKER_RESULT == -33) {
                                SenseTimeBaseManager.this.mCurrentStickerModel = stickerBaseModel;
                            }
                        }
                        SenseTimeBaseManager.this.loadStickering = false;
                        return;
                    case 1004:
                        if (stickerBaseModel == null) {
                            LogUtils.c(SenseTimeBaseManager.TAG, "remove sticker | baseModel == null", new Object[0]);
                            return;
                        }
                        String str4 = stickerBaseModel.localPath;
                        String str5 = stickerBaseModel.name;
                        int intValue = SenseTimeBaseManager.this.mStickerMaps.get(str4).intValue();
                        LogUtils.c(SenseTimeBaseManager.TAG, "remove sticker | packageId:%d | removeStickerPath:%s ", Integer.valueOf(intValue), str4);
                        SenseTimeBaseManager senseTimeBaseManager = SenseTimeBaseManager.this;
                        senseTimeBaseManager.result = senseTimeBaseManager.mSTMobileEffectNative.removeEffect(intValue);
                        if (SenseTimeBaseManager.this.mStickerMaps != null && SenseTimeBaseManager.this.result == 0) {
                            SenseTimeBaseManager.this.mStickerMaps.remove(str4);
                        }
                        SenseTimeBaseManager.this.updateHumanActionDetectConfig();
                        return;
                    case 1005:
                        SenseTimeBaseManager.this.mSTMobileEffectNative.clear();
                        if (SenseTimeBaseManager.this.mStickerMaps != null) {
                            SenseTimeBaseManager.this.mStickerMaps.clear();
                        }
                        SenseTimeBaseManager.this.updateHumanActionDetectConfig();
                        return;
                    case 1006:
                        if (stickerBaseModel == null) {
                            LogUtils.c(SenseTimeBaseManager.TAG, "add sticker | baseModel == null", new Object[0]);
                            return;
                        }
                        String str6 = stickerBaseModel.localPath;
                        String str7 = stickerBaseModel.name;
                        LogUtils.c(SenseTimeBaseManager.TAG, "add sticker | addStickerPath: " + str6, new Object[0]);
                        if (TextUtils.isEmpty(str6)) {
                            return;
                        }
                        int addPackage = SenseTimeBaseManager.this.mSTMobileEffectNative.addPackage(str6);
                        if (addPackage <= 0) {
                            SenseTimeBaseManager.this.mySendMessage(160);
                            return;
                        }
                        if (SenseTimeBaseManager.this.mStickerMaps != null) {
                            SenseTimeBaseManager.this.mStickerMaps.put(str6, Integer.valueOf(addPackage));
                        }
                        SenseTimeBaseManager.this.updateHumanActionDetectConfig();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void initHumanAction() {
        LogUtils.b(TAG, "----》initHumanAction", new Object[0]);
        setHumanActionDetectConfig(true, getStickerTriggerAction());
        new Thread(new Runnable() { // from class: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SenseTimeBaseManager.this.mHumanActionHandleLock) {
                    int createInstanceFromAssetFile = SenseTimeBaseManager.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), SenseTimeBaseManager.this.mHumanActionCreateConfig, SenseTimeBaseManager.this.mContext.getAssets());
                    LogUtils.c(SenseTimeBaseManager.TAG, "the result for createInstance for human_action is " + createInstanceFromAssetFile, new Object[0]);
                    if (createInstanceFromAssetFile == 0) {
                        LogUtils.c(SenseTimeBaseManager.TAG, "add hand model result: %d", Integer.valueOf(SenseTimeBaseManager.this.mSTHumanActionNative.addSubModelFromAssetFile("models/M_SenseME_Hand_5.4.0.model", SenseTimeBaseManager.this.mContext.getAssets())));
                        SenseTimeBaseManager.this.mIsCreateHumanActionHandleSucceeded = true;
                        SenseTimeBaseManager.this.mSTHumanActionNative.setParam(401, 0.35f);
                    }
                }
            }
        }).start();
    }

    private void initNative() {
        this.mSTHumanActionNative = new STMobileHumanActionNative();
        this.mStAnimalNative = new STMobileAnimalNative();
        this.mSTFaceAttributeNative = new STMobileFaceAttributeNative();
        this.mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
        this.mSTMobileEffectNative = new STMobileEffectNative();
    }

    private void initSensorManager() {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mRotation = sensorManager.getDefaultSensor(11);
    }

    private void removeSticker(int i) {
        this.mChangeStickerManagerHandler.removeMessages(1004);
        Message obtainMessage = this.mChangeStickerManagerHandler.obtainMessage(1004);
        obtainMessage.obj = Integer.valueOf(i);
        this.mChangeStickerManagerHandler.sendMessage(obtainMessage);
    }

    protected void animalDetect(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        if (this.mNeedAnimalDetect) {
            long currentTimeMillis = System.currentTimeMillis();
            int animalDetectConfig = (int) this.mSTMobileEffectNative.getAnimalDetectConfig();
            Log.d("animalDetect", "test_animalDetect: " + animalDetectConfig);
            STAnimalFace[] animalDetect = this.mStAnimalNative.animalDetect(bArr, i, i2, animalDetectConfig, i3, i4);
            boolean z = true;
            int i6 = 0;
            LogUtils.c(TAG, "animal detect cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            STAnimalFace[] sTAnimalFaceArr = animalDetect;
            if (animalDetect != null) {
                sTAnimalFaceArr = animalDetect;
                if (animalDetect.length > 0) {
                    Log.d("animalDetect", "animalDetect: " + animalDetect.length);
                    if (this.mCameraID != 1) {
                        z = false;
                    }
                    sTAnimalFaceArr = processAnimalFaceResult(animalDetect, z, i2);
                }
            }
            STAnimalFaceInfo[] sTAnimalFaceInfoArr = this.mAnimalFaceInfo;
            if (sTAnimalFaceArr != null) {
                i6 = sTAnimalFaceArr.length;
            }
            sTAnimalFaceInfoArr[i5] = new STAnimalFaceInfo(sTAnimalFaceArr, i6);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void changeCustomEvent() {
        this.mCustomEvent = 3;
    }

    public void changeSticker(String str) {
        changeSticker(str, FileUtils.a(AppInfo.d(), str));
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void changeSticker(String str, String str2) {
        if (this.mSetStickerListenerMap.get(str) != null) {
            this.mSetStickerListenerMap.get(str).onSetSticker();
        }
        StickerBaseModel stickerBaseModel = new StickerBaseModel();
        stickerBaseModel.name = str;
        stickerBaseModel.localPath = str2;
        this.mChangeStickerManagerHandler.removeMessages(1003);
        Message obtainMessage = this.mChangeStickerManagerHandler.obtainMessage(1003);
        obtainMessage.obj = stickerBaseModel;
        this.mChangeStickerManagerHandler.sendMessage(obtainMessage);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void changeSticker(final String str, String str2, ISetStickerListener iSetStickerListener) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (iSetStickerListener != null) {
                iSetStickerListener.onFailed(ErrorCode.PlayStickerCode.DATA_ERROR, "name or path is null");
            }
            changeSticker(str, str2);
            return;
        }
        this.loadStickering = true;
        if (iSetStickerListener != null) {
            this.mSetStickerListenerMap.put(str, iSetStickerListener);
        }
        StickerDataManager.getStickerPath(str, str2, new IGetStickerListener() { // from class: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.1
            @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
            public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str3) {
                SenseTimeBaseManager.this.loadStickering = false;
                if (SenseTimeBaseManager.this.mSetStickerListenerMap.get(str) != null) {
                    ISetStickerListener iSetStickerListener2 = SenseTimeBaseManager.this.mSetStickerListenerMap.get(str);
                    iSetStickerListener2.onFailed(playStickerCode, "downLoad fail | " + str3);
                }
            }

            @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
            public void onSuccess(String str3, String str4) {
                SenseTimeBaseManager.this.changeSticker(str3, str4);
            }

            @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
            public void onSyncStart() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkTexture(int i, int i2) {
        AppLogger a2 = AppLogger.a();
        a2.a("Blued_Sense_SenseTimeManager texWidth:" + i + " | texHeight:" + i2, new Object[0]);
        if (this.mTexWidth != i || this.mTexHeight != i2 || this.mCameraChanging) {
            deleteInternalTextures();
            this.mTexWidth = i;
            this.mTexHeight = i2;
            this.mCameraChanging = false;
        }
        checkTextureOutId();
    }

    protected abstract void checkTextureOutId();

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteInternalTextures() {
        int[] iArr = this.mBeautifyTextureId;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mBeautifyTextureId = null;
        }
        int[] iArr2 = this.mStickerTextureOutId;
        if (iArr2 != null) {
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.mStickerTextureOutId = null;
        }
        int[] iArr3 = this.mFilterTextureOutId;
        if (iArr3 != null) {
            GLES20.glDeleteTextures(1, iArr3, 0);
            this.mFilterTextureOutId = null;
        }
        synchronized (this.mImageDataLock) {
            if (this.mImageData != null) {
                this.mImageData = new byte[0];
            }
        }
        if (this.mOutputBuffer != null) {
            this.mOutputBuffer = new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destorySTNative() {
        synchronized (this.mHumanActionHandleLock) {
            this.mSTHumanActionNative.destroyInstance();
        }
        this.mSTFaceAttributeNative.destroyInstance();
        this.mSTMobileObjectTrackNative.destroyInstance();
        this.mStAnimalNative.destroyInstance();
    }

    protected void destroyEffectNative() {
        this.mSTMobileEffectNative.destroyInstance();
        this.isEffectNativeInstance = false;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void disableObjectTracking() {
        this.mIsObjectTracking = false;
    }

    public int drawFrame(int i, int i2, int i3) {
        return drawFrame(i, i2, i3, false);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public abstract void enableBeautify(boolean z);

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableObject(boolean z) {
        this.mNeedObject = z;
        if (z) {
            resetIndexRect();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableSticker(boolean z) {
        this.mNeedSticker = z;
        if (z) {
            return;
        }
        updateHumanActionDetectConfig();
        changeSticker(null, null, null);
    }

    protected int getCameraOrientation(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return 0;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (i == cameraInfo.facing) {
                return cameraInfo.orientation;
            }
            i2 = i3 + 1;
        }
    }

    protected abstract int getCurrentOrientation();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        if ((r4 & 1) == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getHumanActionOrientation() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.mCameraID
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            r1 = 1
            if (r0 != r1) goto L11
            r0 = 1
            r4 = r0
            goto L13
        L11:
            r0 = 0
            r4 = r0
        L13:
            int r0 = com.blued.android.module.external_sense_library.utils.Accelerometer.c()
            r6 = r0
            r0 = r4
            if (r0 != 0) goto L24
            r0 = r6
            if (r0 != 0) goto L24
            r0 = 2
            r4 = r0
            goto L34
        L24:
            r0 = r4
            if (r0 != 0) goto L32
            r0 = r6
            r1 = 2
            if (r0 != r1) goto L32
            r0 = r5
            r4 = r0
            goto L34
        L32:
            r0 = r6
            r4 = r0
        L34:
            r0 = r3
            int r0 = r0.mImageRotation
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L45
            r0 = r4
            r1 = 1
            r0 = r0 & r1
            r1 = 1
            if (r0 == r1) goto L58
        L45:
            r0 = r4
            r5 = r0
            r0 = r3
            int r0 = r0.mImageRotation
            r1 = 90
            if (r0 != r1) goto L5c
            r0 = r4
            r5 = r0
            r0 = r4
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L5c
        L58:
            r0 = r4
            r1 = 2
            r0 = r0 ^ r1
            r5 = r0
        L5c:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager.getHumanActionOrientation():int");
    }

    protected byte[] getImgeData() {
        return this.mNv21ImageData;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public Rect getIndexRect() {
        return this.mIndexRect;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public byte[] getOutputBuffer() {
        return this.mOutputBuffer;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public long getStickerTriggerAction() {
        return this.mSTMobileEffectNative.getHumanActionDetectConfig();
    }

    public void handsStickerMsg(STHumanAction sTHumanAction) {
        long j = 0;
        if (sTHumanAction.getHands() == null || sTHumanAction.getHands().length <= 0) {
            Message obtainMessage = this.mUpdateHandActionHandler.obtainMessage(141);
            obtainMessage.obj = 0L;
            this.mUpdateHandActionHandler.sendMessage(obtainMessage);
            return;
        }
        long handAction = sTHumanAction.getHands()[0].getHandAction();
        if ((handAction & 131072) > 0) {
            j = 131072;
        } else if ((handAction & 262144) > 0) {
            j = 262144;
        } else if ((handAction & 8192) > 0) {
            j = 8192;
        } else if ((handAction & 2048) > 0) {
            j = 2048;
        } else if ((handAction & 16384) > 0) {
            j = 16384;
        }
        Message obtainMessage2 = this.mUpdateHandActionHandler.obtainMessage(141);
        obtainMessage2.obj = Long.valueOf(j);
        this.mUpdateHandActionHandler.sendMessage(obtainMessage2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        init(true, STMobileHumanActionNative.ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(boolean z, int i) {
        this.mAccelerometer = new Accelerometer(this.mContext);
        if (this.isUseSensor) {
            initSensorManager();
        }
        this.mHumanActionCreateConfig = i;
        initNative();
        initHumanAction();
        initObjectTrack();
        initHandlerManager();
        this.mSTGLRender = new STGLRender(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initBeauty() {
        if (!this.isEffectNativeInstance) {
            this.isEffectNativeInstance = true;
            this.effectNativeInstanceResult = this.mSTMobileEffectNative.createInstance(this.mContext, 0);
        }
        if (this.effectNativeInstanceResult == 0) {
            this.mSTMobileEffectNative.setBeautyStrength(101, this.mBeautifyParams[0]);
            this.mSTMobileEffectNative.setBeautyStrength(102, this.mBeautifyParams[1]);
            this.mSTMobileEffectNative.setBeautyStrength(103, this.mBeautifyParams[2]);
            this.mSTMobileEffectNative.setBeautyStrength(201, this.mBeautifyParams[4]);
            this.mSTMobileEffectNative.setBeautyStrength(202, this.mBeautifyParams[5]);
            this.mSTMobileEffectNative.setBeautyStrength(203, this.mBeautifyParams[6]);
            this.mSTMobileEffectNative.setBeautyStrength(204, this.mBeautifyParams[7]);
            this.mSTMobileEffectNative.setBeautyStrength(601, this.mBeautifyParams[8]);
            this.mSTMobileEffectNative.setBeautyStrength(602, this.mBeautifyParams[9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initFilter() {
        if (!this.isEffectNativeInstance) {
            this.isEffectNativeInstance = true;
            this.effectNativeInstanceResult = this.mSTMobileEffectNative.createInstance(this.mContext, 0);
        }
        if (TextUtils.isEmpty(this.mFilterStyle)) {
            return;
        }
        Log.e("setFilterStyle", "setFilterStyle:" + this.mFilterStyle + " ；mCurrentFilterStrength：" + this.mCurrentFilterStrength);
        this.mSTMobileEffectNative.setBeauty(501, this.mFilterStyle);
        this.mSTMobileEffectNative.setBeautyStrength(501, this.mCurrentFilterStrength);
    }

    protected void initObjectTrack() {
        this.mSTMobileObjectTrackNative.createInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initSticker() {
        StickerBaseModel stickerBaseModel;
        LogUtils.b(TAG, "the result for createInstance for sticker is : " + this.result, new Object[0]);
        if (this.mNeedSticker && (stickerBaseModel = this.mCurrentStickerModel) != null) {
            changeSticker(stickerBaseModel.name, this.mCurrentStickerModel.localPath);
        }
        updateHumanActionDetectConfig();
        LogUtils.c(TAG, "the result for createInstance for initSticker is " + this.result, new Object[0]);
    }

    @Override // com.blued.android.core.net.IRequestHost
    public boolean isActive() {
        return this.isActive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFlipHorizontal() {
        return this.mCameraID != 1;
    }

    protected boolean isFlipVertical() {
        return getCameraOrientation(this.mCameraID) == 90 || getCameraOrientation(this.mCameraID) == 270;
    }

    protected void mySendMessage(int i) {
        mySendMessage(i, null, -1, -1);
    }

    protected void mySendMessage(int i, Object obj) {
        mySendMessage(i, obj, -1, -1);
    }

    protected void mySendMessage(int i, Object obj, int i2, int i3) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(i);
            if (obj != null) {
                obtainMessage.obj = obj;
            }
            if (i2 != -1) {
                obtainMessage.arg1 = i2;
            }
            if (i3 != -1) {
                obtainMessage.arg2 = i3;
            }
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    protected void objectTrack() {
        if (this.mImageData == null || this.mImageData.length == 0) {
            return;
        }
        boolean z = this.mNeedObject;
        if (!z) {
            if (z && (this.mNeedBeautify || this.mNeedSticker || this.mNeedFaceAttribute)) {
                return;
            }
            mySendMessage(130);
            return;
        }
        if (this.mNeedSetObjectTarget) {
            long currentTimeMillis = System.currentTimeMillis();
            Rect c2 = STUtils.c(this.mTargetRect, this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation);
            this.mTargetRect = c2;
            this.mSTMobileObjectTrackNative.setTarget(this.mImageData, 3, this.mImageHeight, this.mImageWidth, new STRect(c2.left, this.mTargetRect.top, this.mTargetRect.right, this.mTargetRect.bottom));
            LogUtils.c(TAG, "setTarget cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " rotation = " + this.mImageRotation, new Object[0]);
            this.mNeedSetObjectTarget = false;
            this.mIsObjectTracking = true;
        }
        Rect rect = new Rect(0, 0, 0, 0);
        if (!this.mIsObjectTracking) {
            if (this.mNeedShowRect) {
                mySendMessage(121, this.mIndexRect);
                return;
            }
            mySendMessage(120, rect);
            this.mIndexRect = rect;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        STRect objectTrack = this.mSTMobileObjectTrackNative.objectTrack(this.mImageData, 3, this.mImageHeight, this.mImageWidth, new float[1]);
        LogUtils.c(TAG, "objectTrack cost time: " + (System.currentTimeMillis() - currentTimeMillis2), new Object[0]);
        if (objectTrack != null) {
            Rect b = STUtils.b(STUtils.d(new Rect(objectTrack.getRect().left, objectTrack.getRect().top, objectTrack.getRect().right, objectTrack.getRect().bottom), this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
            if (this.mNeedShowRect) {
                return;
            }
            mySendMessage(120, b);
            this.mIndexRect = b;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onDestroy() {
        LogUtils.c(TAG, "onDestroy()", new Object[0]);
        this.isActive = false;
        destorySTNative();
        Context context = this.mContext;
        if (context == null || ((Activity) context).isFinishing()) {
            StickerDataManager.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroySenseNative() {
        this.mSTHumanActionNative.reset();
        destroyEffectNative();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int onProcessTexture(int i, int i2, int i3, int i4, STHumanAction sTHumanAction) {
        STEffectCustomParam sTEffectCustomParam;
        if (this.mNeedAnimalDetect) {
            animalDetect(this.mNv21ImageData, 3, getHumanActionOrientation(), this.mImageHeight, this.mImageWidth, 0);
        }
        STEffectTexture sTEffectTexture = new STEffectTexture(i, i2, i3, 0);
        STEffectTexture sTEffectTexture2 = new STEffectTexture(this.mBeautifyTextureId[0], i2, i3, 0);
        int i5 = this.mCustomEvent;
        SensorEvent sensorEvent = this.mSensorEvent;
        boolean z = true;
        if (sensorEvent == null || sensorEvent.values == null || this.mSensorEvent.values.length <= 0) {
            sTEffectCustomParam = new STEffectCustomParam(new STQuaternion(0.0f, 0.0f, 0.0f, 1.0f), this.mCameraID == 1, i5);
        } else {
            STQuaternion sTQuaternion = new STQuaternion(this.mSensorEvent.values);
            if (this.mCameraID != 1) {
                z = false;
            }
            sTEffectCustomParam = new STEffectCustomParam(sTQuaternion, z, i5);
        }
        STEffectRenderInParam sTEffectRenderInParam = new STEffectRenderInParam(sTHumanAction, this.mAnimalFaceInfo[0], i4, i4, false, sTEffectCustomParam, sTEffectTexture, (STEffectInImage) null);
        STEffectRenderOutParam sTEffectRenderOutParam = new STEffectRenderOutParam(sTEffectTexture2, null, this.mHumanActionBeautyOutput);
        this.mSTMobileEffectNative.render(sTEffectRenderInParam, sTEffectRenderOutParam, false);
        return sTEffectRenderOutParam.getTexture() != null ? sTEffectRenderOutParam.getTexture().getId() : i;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.isUseSensor) {
            this.mSensorEvent = sensorEvent;
        }
    }

    protected STAnimalFace[] processAnimalFaceResult(STAnimalFace[] sTAnimalFaceArr, boolean z, int i) {
        if (sTAnimalFaceArr == null) {
            return null;
        }
        if (z && i == 90) {
            STAnimalFace[] animalRotate = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 1, sTAnimalFaceArr, sTAnimalFaceArr.length);
            return STMobileAnimalNative.animalMirror(this.mImageWidth, animalRotate, animalRotate.length);
        } else if (z && i == 270) {
            STAnimalFace[] animalRotate2 = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 3, sTAnimalFaceArr, sTAnimalFaceArr.length);
            return STMobileAnimalNative.animalMirror(this.mImageWidth, animalRotate2, animalRotate2.length);
        } else if (z || i != 270) {
            STAnimalFace[] sTAnimalFaceArr2 = sTAnimalFaceArr;
            if (!z) {
                sTAnimalFaceArr2 = sTAnimalFaceArr;
                if (i == 90) {
                    sTAnimalFaceArr2 = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 1, sTAnimalFaceArr, sTAnimalFaceArr.length);
                }
            }
            return sTAnimalFaceArr2;
        } else {
            return STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 3, sTAnimalFaceArr, sTAnimalFaceArr.length);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.IGetBufferCallback
    public void readBuffer(byte[] bArr) {
        byte[] bArr2;
        if (this.mNeedFilter || bArr == null || (bArr2 = this.mOutputBuffer) == null || bArr.length > bArr2.length) {
            return;
        }
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerSensorListener() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.mRotation, 1);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void removeAllStickers() {
        this.mChangeStickerManagerHandler.removeMessages(1005);
        this.mChangeStickerManagerHandler.sendMessage(this.mChangeStickerManagerHandler.obtainMessage(1005));
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void resetIndexRect() {
        if (this.mImageWidth == 0) {
            return;
        }
        int i = this.mSurfaceWidth;
        int i2 = i / 4;
        this.mScreenIndexRectWidth = i2;
        this.mIndexRect.left = (i - i2) / 2;
        this.mIndexRect.top = (this.mSurfaceHeight - this.mScreenIndexRectWidth) / 2;
        Rect rect = this.mIndexRect;
        rect.right = rect.left + this.mScreenIndexRectWidth;
        Rect rect2 = this.mIndexRect;
        rect2.bottom = rect2.top + this.mScreenIndexRectWidth;
        this.mNeedShowRect = true;
        this.mNeedSetObjectTarget = false;
        this.mIsObjectTracking = false;
    }

    protected void saveImageBuffer2Picture(int i, byte[] bArr) {
        if (this.mHandler != null) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            allocate.put(bArr);
            Message obtain = Message.obtain(this.mHandler);
            obtain.what = 150;
            obtain.obj = allocate;
            obtain.arg1 = i;
            Bundle bundle = new Bundle();
            bundle.putInt("imageWidth", this.mImageWidth);
            bundle.putInt("imageHeight", this.mImageHeight);
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setBeautyParam(BluedBeautifyKey.KEY key, float f) {
        if (key == null || this.mBeautifyParams[key.getIndex()] == f) {
            return;
        }
        this.mSTMobileEffectNative.setBeautyStrength(key.getBeautyParamsType(), f);
        this.mBeautifyParams[key.getIndex()] = f;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setCameraFacing(boolean z) {
        if (z) {
            this.mCameraID = 1;
        } else {
            this.mCameraID = 0;
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setFilterStrength(float f) {
        this.mFilterStrength = f;
        this.mCurrentFilterStrength = f;
        this.mSTMobileEffectNative.setBeautyStrength(501, f);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setFilterStyle(BluedFilterType.FILER filer) {
        if (filer == null) {
            this.mFilterStyle = "";
            this.mNeedFilter = false;
            this.mSTMobileEffectNative.setBeauty(501, null);
            return;
        }
        String model = FilterDataManager.getInstance().getModel(filer);
        this.mFilterStyle = model;
        this.mNeedFilter = true;
        if (TextUtils.isEmpty(model)) {
            return;
        }
        this.mSTMobileEffectNative.setBeauty(501, this.mFilterStyle);
        this.mSTMobileEffectNative.setBeautyStrength(501, this.mCurrentFilterStrength);
    }

    public void setHandActionListener(IHandActionListener iHandActionListener) {
        this.iHandActionListener = iHandActionListener;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    protected abstract void setHumanActionDetectConfig(boolean z, long j);

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setIndexRect(int i, int i2, boolean z) {
        int i3 = this.mScreenIndexRectWidth;
        this.mIndexRect = new Rect(i, i2, i + i3, i3 + i2);
        this.mNeedShowRect = z;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setNeedSaveFrame(boolean z) {
        this.isNeedSaveFrame = z;
        if (z) {
            this.mHandler = new HandlerUtils().a();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setObjectTrackRect() {
        this.mNeedSetObjectTarget = true;
        this.mIsObjectTracking = false;
        this.mTargetRect = STUtils.a(getIndexRect(), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void switchCamera() {
        int i = 0;
        LogUtils.c(TAG, "switchCamera()", new Object[0]);
        this.mCameraChanging = true;
        if (this.mCameraID != 1) {
            i = 1;
        }
        this.mCameraID = i;
        if (this.mNeedObject) {
            resetIndexRect();
        } else {
            mySendMessage(130);
        }
    }

    public void updateAnimalDetectConfig() {
        this.mNeedAnimalDetect = this.mSTMobileEffectNative.getAnimalDetectConfig() > 0;
    }

    public void updateHumanActionDetectConfig() {
        this.mDetectConfig = this.mSTMobileEffectNative.getHumanActionDetectConfig();
    }
}
