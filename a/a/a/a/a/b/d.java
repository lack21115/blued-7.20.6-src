package a.a.a.a.a.b;

import com.qiniu.pili.droid.streaming.CameraStreamingSetting;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1302a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1303c = true;
    public boolean d;
    public CameraStreamingSetting.CAMERA_FACING_ID e;

    public void a(CameraStreamingSetting.CAMERA_FACING_ID camera_facing_id) {
        this.e = camera_facing_id;
    }

    public void a(boolean z) {
        this.f1302a = z;
    }

    public boolean a() {
        if (this.f1303c) {
            boolean z = false;
            this.f1303c = false;
            if (this.e == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
                if (this.b) {
                    z = this.f1302a;
                } else if (!this.f1302a) {
                    z = true;
                }
                this.d = z;
            } else {
                this.d = false;
            }
            return this.d;
        }
        return this.d;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void c(boolean z) {
        this.f1303c = z;
    }

    public boolean d(boolean z) {
        if (this.e == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
            if (!this.b) {
                z = !z;
            }
            this.d = z;
        } else {
            this.d = z;
        }
        return this.d;
    }
}
