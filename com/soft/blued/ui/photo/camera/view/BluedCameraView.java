package com.soft.blued.ui.photo.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.module.common.utils.PermissionUtils;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.CameraView;
import com.soft.blued.R;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/view/BluedCameraView.class */
public class BluedCameraView extends CameraView implements PermissionCallbacks {
    private static final String b = BluedCameraView.class.getSimpleName();
    private static final int[] g = {3, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    CameraView.Callback f33043a;

    /* renamed from: c  reason: collision with root package name */
    private OperationCallback f33044c;
    private Handler d;
    private float e;
    private boolean f;

    /* renamed from: com.soft.blued.ui.photo.camera.view.BluedCameraView$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/view/BluedCameraView$1.class */
    class AnonymousClass1 extends CameraView.Callback {
        AnonymousClass1() {
        }

        @Override // com.google.android.cameraview.CameraView.Callback
        public void onCameraClosed(CameraView cameraView) {
            if (AppInfo.m()) {
                Logger.c(BluedCameraView.b, "onCameraClosed");
            }
        }

        @Override // com.google.android.cameraview.CameraView.Callback
        public void onCameraOpened(CameraView cameraView) {
            if (!BluedCameraView.this.f) {
                BluedCameraView.this.f = true;
            }
            if (AppInfo.m()) {
                Logger.c(BluedCameraView.b, "onCameraOpened");
            }
        }

        @Override // com.google.android.cameraview.CameraView.Callback
        public void onPictureTaken(CameraView cameraView, final byte[] bArr) {
            if (AppInfo.m()) {
                Logger.c(BluedCameraView.b, "onPictureTaken ", Integer.valueOf(bArr == null ? 0 : bArr.length));
            }
            if (BluedCameraView.this.f33044c != null) {
                BluedCameraView.this.f33044c.d();
            }
            if (cameraView != null && bArr != null && bArr.length > 0) {
                BluedCameraView.this.getBgHandler().post(new Runnable() { // from class: com.soft.blued.ui.photo.camera.view.BluedCameraView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr2 = bArr;
                        final String absolutePath = CameraImageUtils.a(bArr2, (AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES) + CameraContents.f28312c + CameraContents.d.format(new Date())) + ".jpg").getAbsolutePath();
                        Houyi.a().a(absolutePath).b();
                        File a2 = CameraImageUtils.a(CameraImageUtils.a(absolutePath, BluedCameraView.this.e), absolutePath);
                        CameraImageUtils.a(absolutePath);
                        final boolean z = a2.length() > 0;
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.photo.camera.view.BluedCameraView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BluedCameraView.this.f33044c != null) {
                                    BluedCameraView.this.f33044c.a(z, absolutePath);
                                }
                            }
                        });
                    }
                });
            } else if (BluedCameraView.this.f33044c != null) {
                BluedCameraView.this.f33044c.a(false, null);
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/view/BluedCameraView$OperationCallback.class */
    public interface OperationCallback {
        void a(boolean z, String str);

        void b();

        void d();
    }

    public BluedCameraView(Context context) {
        this(context, null);
    }

    public BluedCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BluedCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1.0f;
        this.f = false;
        this.f33043a = new AnonymousClass1();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BluedCameraView, i, 0);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        if (!TextUtils.isEmpty(string)) {
            AspectRatio parse = AspectRatio.parse(string);
            this.e = (parse.getX() * 1.0f) / parse.getY();
        }
        f();
    }

    private void f() {
        addCallback(this.f33043a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getBgHandler() {
        if (this.d == null) {
            HandlerThread handlerThread = new HandlerThread(CameraContents.b);
            handlerThread.start();
            this.d = new Handler(handlerThread.getLooper());
        }
        return this.d;
    }

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void U_() {
        start();
    }

    public void a(OperationCallback operationCallback) {
        this.f33044c = operationCallback;
        PermissionUtils.b(this);
    }

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void a(String[] strArr) {
        OperationCallback operationCallback = this.f33044c;
        if (operationCallback != null) {
            operationCallback.b();
        }
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        stop();
    }

    public void d() {
        if (this.d != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.d.getLooper().quitSafely();
            } else {
                this.d.getLooper().quit();
            }
            this.d = null;
        }
    }
}
