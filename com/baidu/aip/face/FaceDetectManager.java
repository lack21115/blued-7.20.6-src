package com.baidu.aip.face;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.baidu.aip.FaceSDKManager;
import com.baidu.aip.ImageFrame;
import com.baidu.aip.face.FaceFilter;
import com.baidu.aip.face.stat.Ast;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceDetectManager.class */
public class FaceDetectManager {
    private byte[] data;
    private ImageSource imageSource;
    private ImageFrame lastFrame;
    private OnFaceDetectListener listener;
    private Context mContext;
    private Handler processHandler;
    private HandlerThread processThread;
    private Handler uiHandler;
    private int mDetectMax = 3;
    private FaceFilter faceFilter = new FaceFilter();
    private int mPreviewDegree = 90;
    private ArrayList<FaceProcessor> preProcessors = new ArrayList<>();
    private Runnable processRunnable = new Runnable() { // from class: com.baidu.aip.face.FaceDetectManager.1
        @Override // java.lang.Runnable
        public void run() {
            int[] argb;
            int width;
            int height;
            ArgbPool pool;
            if (FaceDetectManager.this.lastFrame == null) {
                return;
            }
            Process.setThreadPriority(-19);
            synchronized (FaceDetectManager.this.lastFrame) {
                argb = FaceDetectManager.this.lastFrame.getArgb();
                width = FaceDetectManager.this.lastFrame.getWidth();
                height = FaceDetectManager.this.lastFrame.getHeight();
                pool = FaceDetectManager.this.lastFrame.getPool();
                FaceDetectManager.this.lastFrame = null;
            }
            FaceDetectManager.this.process(argb, width, height, pool);
        }
    };
    private OnFrameAvailableListener onFrameAvailableListener = new OnFrameAvailableListener() { // from class: com.baidu.aip.face.FaceDetectManager.2
        @Override // com.baidu.aip.face.OnFrameAvailableListener
        public void onFrameAvailable(ImageFrame imageFrame) {
            FaceDetectManager.this.lastFrame = imageFrame;
            FaceDetectManager.this.processHandler.removeCallbacks(FaceDetectManager.this.processRunnable);
            FaceDetectManager.this.processHandler.post(FaceDetectManager.this.processRunnable);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceDetectManager$OnFaceDetectListener.class */
    public interface OnFaceDetectListener {
        void onDetectFace(int i, FaceInfo[] faceInfoArr, ImageFrame imageFrame);
    }

    public FaceDetectManager(Context context) {
        this.mContext = context;
        Ast.getInstance().init(context.getApplicationContext(), "3.3.0.0", "facedetect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(int[] iArr, int i, int i2, ArgbPool argbPool) {
        ImageFrame borrowImageFrame = this.imageSource.borrowImageFrame();
        borrowImageFrame.setArgb(iArr);
        borrowImageFrame.setWidth(i);
        borrowImageFrame.setHeight(i2);
        borrowImageFrame.setPool(argbPool);
        Iterator<FaceProcessor> it = this.preProcessors.iterator();
        while (it.hasNext() && !it.next().process(this, borrowImageFrame)) {
        }
        int prepare_max_face_data_for_verify = FaceSDKManager.getInstance().getFaceTracker(this.mContext).prepare_max_face_data_for_verify(borrowImageFrame.getArgb(), borrowImageFrame.getHeight(), borrowImageFrame.getWidth(), FaceSDK.ImgType.ARGB.ordinal(), FaceTracker.ActionType.RECOGNIZE.ordinal());
        FaceSDKManager.getInstance().getFaceTracker(this.mContext).track(borrowImageFrame.getArgb(), borrowImageFrame.getHeight(), borrowImageFrame.getWidth(), FaceSDK.ImgType.ARGB.ordinal(), this.mDetectMax);
        FaceInfo[] faceInfoArr = FaceSDKManager.getInstance().getFaceTracker(this.mContext).get_TrackedFaceInfo();
        if (prepare_max_face_data_for_verify == 0) {
            this.faceFilter.filter(faceInfoArr, borrowImageFrame);
        }
        OnFaceDetectListener onFaceDetectListener = this.listener;
        if (onFaceDetectListener != null) {
            onFaceDetectListener.onDetectFace(prepare_max_face_data_for_verify, faceInfoArr, borrowImageFrame);
        }
        Ast.getInstance().faceHit("detect", 3600000, faceInfoArr);
        borrowImageFrame.release();
    }

    public void addPreProcessor(FaceProcessor faceProcessor) {
        this.preProcessors.add(faceProcessor);
    }

    public FaceFilter getFaceFilter() {
        return this.faceFilter;
    }

    public ImageSource getImageSource() {
        return this.imageSource;
    }

    public void setDetectMax(int i) {
        this.mDetectMax = i;
    }

    public void setImageSource(ImageSource imageSource) {
        this.imageSource = imageSource;
    }

    public void setOnFaceDetectListener(OnFaceDetectListener onFaceDetectListener) {
        this.listener = onFaceDetectListener;
    }

    public void setOnTrackListener(FaceFilter.OnTrackListener onTrackListener) {
        this.faceFilter.setOnTrackListener(onTrackListener);
    }

    public void setPreviewDegree(int i) {
        this.mPreviewDegree = i;
    }

    public void start() {
        this.imageSource.addOnFrameAvailableListener(this.onFrameAvailableListener);
        HandlerThread handlerThread = new HandlerThread(UMModuleRegister.PROCESS);
        this.processThread = handlerThread;
        handlerThread.setPriority(10);
        this.processThread.start();
        this.processHandler = new Handler(this.processThread.getLooper());
        this.uiHandler = new Handler();
        this.imageSource.start();
    }

    public void stop() {
        ImageSource imageSource = this.imageSource;
        if (imageSource != null) {
            imageSource.stop();
            this.imageSource.removeOnFrameAvailableListener(this.onFrameAvailableListener);
        }
        HandlerThread handlerThread = this.processThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.processThread = null;
        }
        Ast.getInstance().immediatelyUpload();
    }
}
