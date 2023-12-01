package a.a.a.a.a.b;

import android.hardware.Camera;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/a.class */
public final class a implements Camera.AutoFocusMoveCallback {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0005a f1233a;

    /* renamed from: a.a.a.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/a$a.class */
    public interface InterfaceC0005a {
        void a(boolean z, Camera camera);
    }

    public a(InterfaceC0005a interfaceC0005a) {
        this.f1233a = interfaceC0005a;
    }

    @Override // android.hardware.Camera.AutoFocusMoveCallback
    public void onAutoFocusMoving(boolean z, Camera camera) {
        InterfaceC0005a interfaceC0005a = this.f1233a;
        if (interfaceC0005a != null) {
            interfaceC0005a.a(z, camera);
        }
    }
}
