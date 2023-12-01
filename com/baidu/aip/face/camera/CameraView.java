package com.baidu.aip.face.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.aip.face.camera.ICameraControl;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/CameraView.class */
public class CameraView extends FrameLayout {
    public static final int ORIENTATION_HORIZONTAL = 1;
    public static final int ORIENTATION_INVERT = 2;
    public static final int ORIENTATION_PORTRAIT = 0;
    private ICameraControl cameraControl;
    private CameraViewTakePictureCallback cameraViewTakePictureCallback;
    private View displayView;
    private ImageView hintView;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/CameraView$CameraViewTakePictureCallback.class */
    class CameraViewTakePictureCallback implements ICameraControl.OnTakePictureCallback {
        private CameraViewTakePictureCallback() {
        }

        @Override // com.baidu.aip.face.camera.ICameraControl.OnTakePictureCallback
        public void onPictureTaken(byte[] bArr) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/CameraView$OnTakePictureCallback.class */
    interface OnTakePictureCallback {
        void onPictureTaken(Bitmap bitmap);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/CameraView$Orientation.class */
    public @interface Orientation {
    }

    public CameraView(Context context) {
        super(context);
        this.cameraViewTakePictureCallback = new CameraViewTakePictureCallback();
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cameraViewTakePictureCallback = new CameraViewTakePictureCallback();
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cameraViewTakePictureCallback = new CameraViewTakePictureCallback();
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.cameraControl = new Camera2Control(getContext());
        } else {
            this.cameraControl = new Camera1Control(getContext());
        }
        View displayView = this.cameraControl.getDisplayView();
        this.displayView = displayView;
        addView(displayView);
        ImageView imageView = new ImageView(getContext());
        this.hintView = imageView;
        addView(imageView);
    }

    public ICameraControl getCameraControl() {
        return this.cameraControl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.displayView.layout(i, 0, i3, i4 - i2);
    }

    public void setOrientation(int i) {
        this.cameraControl.setDisplayOrientation(i);
    }

    public void start() {
        this.cameraControl.start();
        setKeepScreenOn(true);
    }

    public void stop() {
        this.cameraControl.stop();
        setKeepScreenOn(false);
    }
}
