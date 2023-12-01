package com.baidu.aip.face;

import android.content.Context;
import android.media.Image;
import com.baidu.aip.face.camera.Camera1Control;
import com.baidu.aip.face.camera.ICameraControl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/CameraImageSource.class */
public class CameraImageSource extends ImageSource {
    private ICameraControl cameraControl;
    private Context context;
    private ArgbPool argbPool = new ArgbPool();
    private int cameraFaceType = 1;

    public CameraImageSource(Context context) {
        this.context = context;
        Camera1Control camera1Control = new Camera1Control(getContext());
        this.cameraControl = camera1Control;
        camera1Control.setCameraFacing(this.cameraFaceType);
        this.cameraControl.setOnFrameListener(new ICameraControl.OnFrameListener<byte[]>() { // from class: com.baidu.aip.face.CameraImageSource.1
            /* JADX WARN: Code restructure failed: missing block: B:5:0x001f, code lost:
                if (r0.length != (r10 * r11)) goto L18;
             */
            @Override // com.baidu.aip.face.camera.ICameraControl.OnFrameListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPreviewFrame(byte[] r8, int r9, int r10, int r11) {
                /*
                    r7 = this;
                    r0 = r7
                    com.baidu.aip.face.CameraImageSource r0 = com.baidu.aip.face.CameraImageSource.this
                    com.baidu.aip.face.ArgbPool r0 = com.baidu.aip.face.CameraImageSource.access$000(r0)
                    r1 = r10
                    r2 = r11
                    int[] r0 = r0.acquire(r1, r2)
                    r15 = r0
                    r0 = r15
                    if (r0 == 0) goto L22
                    r0 = r15
                    r14 = r0
                    r0 = r15
                    int r0 = r0.length
                    r1 = r10
                    r2 = r11
                    int r1 = r1 * r2
                    if (r0 == r1) goto L2a
                L22:
                    r0 = r10
                    r1 = r11
                    int r0 = r0 * r1
                    int[] r0 = new int[r0]
                    r14 = r0
                L2a:
                    r0 = r9
                    r12 = r0
                    r0 = r9
                    if (r0 >= 0) goto L38
                    r0 = r9
                    r1 = 360(0x168, float:5.04E-43)
                    int r0 = r0 + r1
                    r12 = r0
                L38:
                    r0 = r8
                    r1 = r10
                    r2 = r11
                    r3 = r14
                    r4 = r12
                    r5 = 0
                    com.baidu.aip.FaceDetector.yuvToARGB(r0, r1, r2, r3, r4, r5)
                    r0 = r10
                    r13 = r0
                    r0 = r11
                    r9 = r0
                    r0 = r12
                    r1 = 180(0xb4, float:2.52E-43)
                    int r0 = r0 % r1
                    r1 = 90
                    if (r0 != r1) goto L5b
                    r0 = r10
                    r9 = r0
                    r0 = r11
                    r13 = r0
                L5b:
                    com.baidu.aip.ImageFrame r0 = new com.baidu.aip.ImageFrame
                    r1 = r0
                    r1.<init>()
                    r8 = r0
                    r0 = r8
                    r1 = r14
                    r0.setArgb(r1)
                    r0 = r8
                    r1 = r13
                    r0.setWidth(r1)
                    r0 = r8
                    r1 = r9
                    r0.setHeight(r1)
                    r0 = r8
                    r1 = r7
                    com.baidu.aip.face.CameraImageSource r1 = com.baidu.aip.face.CameraImageSource.this
                    com.baidu.aip.face.ArgbPool r1 = com.baidu.aip.face.CameraImageSource.access$000(r1)
                    r0.setPool(r1)
                    r0 = r7
                    com.baidu.aip.face.CameraImageSource r0 = com.baidu.aip.face.CameraImageSource.this
                    java.util.ArrayList r0 = r0.getListeners()
                    java.util.Iterator r0 = r0.iterator()
                    r14 = r0
                L8b:
                    r0 = r14
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto La8
                    r0 = r14
                    java.lang.Object r0 = r0.next()
                    com.baidu.aip.face.OnFrameAvailableListener r0 = (com.baidu.aip.face.OnFrameAvailableListener) r0
                    r1 = r8
                    r0.onFrameAvailable(r1)
                    goto L8b
                La8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.CameraImageSource.AnonymousClass1.onPreviewFrame(byte[], int, int, int):void");
            }
        });
    }

    private Context getContext() {
        return this.context;
    }

    private byte[] imageToByteArray(Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        ByteBuffer buffer2 = image.getPlanes()[2].getBuffer();
        ByteBuffer buffer3 = image.getPlanes()[1].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        int remaining3 = buffer3.remaining();
        byte[] bArr = new byte[remaining + remaining2 + remaining3];
        buffer.get(bArr, 0, remaining);
        buffer2.get(bArr, remaining, remaining3);
        buffer3.get(bArr, remaining + remaining3, remaining2);
        return bArr;
    }

    private int[] toIntArray(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int[] iArr = new int[bArr.length / 4];
        order.asIntBuffer().put(iArr);
        return iArr;
    }

    public ICameraControl getCameraControl() {
        return this.cameraControl;
    }

    public void setCameraFacing(int i) {
        this.cameraFaceType = i;
    }

    @Override // com.baidu.aip.face.ImageSource
    public void setPreviewView(PreviewView previewView) {
        this.cameraControl.setPreviewView(previewView);
    }

    @Override // com.baidu.aip.face.ImageSource
    public void start() {
        super.start();
        this.cameraControl.start();
    }

    @Override // com.baidu.aip.face.ImageSource
    public void stop() {
        super.stop();
        this.cameraControl.stop();
    }
}
