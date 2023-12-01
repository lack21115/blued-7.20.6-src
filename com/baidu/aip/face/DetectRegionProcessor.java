package com.baidu.aip.face;

import android.graphics.Rect;
import android.graphics.RectF;
import com.baidu.aip.ImageFrame;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/DetectRegionProcessor.class */
public class DetectRegionProcessor implements FaceProcessor {
    private RectF detectedRect;
    private RectF originalCoordinate = new RectF();
    private Rect cropRect = new Rect();

    @Override // com.baidu.aip.face.FaceProcessor
    public boolean process(FaceDetectManager faceDetectManager, ImageFrame imageFrame) {
        RectF rectF = this.detectedRect;
        if (rectF != null) {
            this.originalCoordinate.set(rectF);
            ((CameraImageSource) faceDetectManager.getImageSource()).getCameraControl().getPreviewView().mapToOriginalRect(this.originalCoordinate);
            this.cropRect.left = (int) this.originalCoordinate.left;
            this.cropRect.top = (int) this.originalCoordinate.top;
            this.cropRect.right = (int) this.originalCoordinate.right;
            this.cropRect.bottom = (int) this.originalCoordinate.bottom;
            imageFrame.setArgb(FaceCropper.crop(imageFrame.getArgb(), imageFrame.getWidth(), this.cropRect));
            imageFrame.setWidth(this.cropRect.width());
            imageFrame.setHeight(this.cropRect.height());
            return false;
        }
        return false;
    }

    public void setDetectedRect(RectF rectF) {
        this.detectedRect = rectF;
    }
}
