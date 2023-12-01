package com.blued.android.framework.qrcode.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.blued.android.framework.qrcode.camera.CameraManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.Vector;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/CaptureActivityHandler.class */
public final class CaptureActivityHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6662a = CaptureActivityHandler.class.getSimpleName();
    private final OnCaptureHandlerListener b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeThread f6663c;
    private State d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/CaptureActivityHandler$State.class */
    public enum State {
        PREVIEW,
        SUCCESS,
        ErrorCode,
        DONE
    }

    public CaptureActivityHandler(OnCaptureHandlerListener onCaptureHandlerListener, Vector<BarcodeFormat> vector, String str) {
        this.b = onCaptureHandlerListener;
        DecodeThread decodeThread = new DecodeThread(onCaptureHandlerListener, vector, str);
        this.f6663c = decodeThread;
        decodeThread.start();
        this.d = State.SUCCESS;
        CameraManager.a().d();
        b();
    }

    private void b() {
        if (this.d == State.SUCCESS) {
            this.d = State.PREVIEW;
            CameraManager.a().a(this.f6663c.a(), 2000);
            CameraManager.a().b(this, 1001);
        }
    }

    public void a() {
        this.d = State.DONE;
        CameraManager.a().e();
        Message.obtain(this.f6663c.a(), 4002).sendToTarget();
        try {
            this.f6663c.join();
        } catch (InterruptedException e) {
        }
        removeMessages(2002);
        removeMessages(2001);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1001) {
            if (this.d == State.PREVIEW) {
                CameraManager.a().b(this, 1001);
            }
        } else if (i == 4001) {
            Log.d(f6662a, "Got product query message");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
            intent.addFlags(524288);
            this.b.a(intent);
        } else if (i == 2001) {
            this.d = State.PREVIEW;
            CameraManager.a().a(this.f6663c.a(), 2000);
        } else if (i == 2002) {
            Log.d(f6662a, "Got decode succeeded message");
            this.d = State.SUCCESS;
            Bundle data = message.getData();
            this.b.a((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap"));
        } else if (i == 4003) {
            Log.d(f6662a, "Got restart preview message");
            b();
        } else if (i != 4004) {
        } else {
            Log.d(f6662a, "Got return scan result message");
            this.b.a(-1, (Intent) message.obj);
        }
    }
}
