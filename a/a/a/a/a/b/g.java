package a.a.a.a.a.b;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.ui.FocusIndicator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1261a = a.a.a.a.a.e.h.a(120);
    public static final int b = a.a.a.a.a.e.h.a(120);
    public boolean d;
    public boolean e;
    public boolean f;
    public ViewGroup h;
    public View i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public List<Camera.Area> n;
    public List<Camera.Area> o;
    public String p;
    public String[] q;
    public String r;
    public Camera.Parameters s;
    public Handler t;
    public a u;
    public CameraStreamingSetting v;

    /* renamed from: c  reason: collision with root package name */
    public int f1262c = 0;
    public Matrix g = new Matrix();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/g$a.class */
    public interface a {
        void d(int i);

        void r();

        void s();

        void t();
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/g$b.class */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                g.this.n();
            } else if (i == 1) {
                g.this.l();
            } else if (i == 2) {
                g.this.o();
            } else if (i != 3) {
            } else {
                g.this.d(((Boolean) message.obj).booleanValue());
            }
        }
    }

    public g(CameraStreamingSetting cameraStreamingSetting, String[] strArr, ViewGroup viewGroup, Camera.Parameters parameters, a aVar, boolean z, Looper looper, View view) {
        this.t = new b(looper);
        this.v = cameraStreamingSetting;
        this.q = strArr;
        a(viewGroup, view);
        a(parameters);
        this.u = aVar;
        a(z);
    }

    public void a() {
        this.f1262c = 0;
    }

    public void a(int i) {
        this.m = i;
        p();
    }

    public void a(int i, int i2) {
        if (this.j == i && this.k == i2) {
            return;
        }
        this.j = i;
        this.k = i2;
        p();
        int min = Math.min(this.j, this.k) / 4;
        View view = this.i;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = min;
            layoutParams.height = min;
        }
    }

    public final void a(int i, int i2, float f, int i3, int i4, int i5, int i6, Rect rect) {
        int i7 = (int) (i * f);
        int i8 = (int) (i2 * f);
        int a2 = a.a.a.a.a.e.h.a(i3 - (i7 / 2), 0, i5 - i7);
        int a3 = a.a.a.a.a.e.h.a(i4 - (i8 / 2), 0, i6 - i8);
        RectF rectF = new RectF(a2, a3, a2 + i7, a3 + i8);
        this.g.mapRect(rectF);
        a.a.a.a.a.e.h.a(rectF, rect);
    }

    public void a(Camera.Parameters parameters) {
        if (parameters == null) {
            a.a.a.a.a.e.e.g.d("FocusManager", "Param is null while init FocusManager");
            return;
        }
        this.s = parameters;
        this.e = parameters.getMaxNumFocusAreas() > 0 && a.a.a.a.a.e.h.a("auto", this.s.getSupportedFocusModes());
        if (this.s.isAutoExposureLockSupported()) {
            return;
        }
        this.s.isAutoWhiteBalanceLockSupported();
    }

    public void a(ViewGroup viewGroup, View view) {
        this.h = viewGroup;
        this.i = view;
    }

    public void a(boolean z) {
        this.l = z;
        p();
    }

    public void b() {
        this.f1262c = 0;
        this.t.removeMessages(0);
        this.t.sendEmptyMessage(0);
        g();
    }

    public void b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.d) {
            if (this.n != null && ((i5 = this.f1262c) == 1 || i5 == 2 || i5 == 3)) {
                l();
            }
            if (this.n == null) {
                ArrayList arrayList = new ArrayList();
                this.n = arrayList;
                arrayList.add(new Camera.Area(new Rect(), 1));
                ArrayList arrayList2 = new ArrayList();
                this.o = arrayList2;
                arrayList2.add(new Camera.Area(new Rect(), 1));
            }
            int i6 = this.j;
            int i7 = this.k;
            ViewGroup viewGroup = this.h;
            if (viewGroup != null) {
                i3 = viewGroup.getWidth();
                i4 = this.h.getHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams.setMargins(a.a.a.a.a.e.h.a(i - (i3 / 2), 0, i6 - i3), a.a.a.a.a.e.h.a(i2 - (i4 / 2), 0, i7 - i4), 0, 0);
                layoutParams.gravity = 0;
                this.h.requestLayout();
            } else {
                i3 = f1261a;
                i4 = b;
            }
            a(i3, i4, 1.0f, i, i2, i6, i7, this.n.get(0).rect);
            a(i3, i4, 1.5f, i, i2, i6, i7, this.o.get(0).rect);
            this.u.t();
            if (this.e) {
                k();
                return;
            }
            g();
            this.t.removeMessages(1);
            this.t.sendEmptyMessageDelayed(1, r());
        }
    }

    public void b(boolean z) {
        if (this.f1262c == 1) {
            if (z) {
                this.f1262c = 2;
                if (!"continuous-picture".equals(this.p)) {
                    this.u.d(1);
                }
            } else {
                this.f1262c = 3;
            }
            g();
            if (this.n != null) {
                this.t.sendEmptyMessageDelayed(1, r());
            }
        }
    }

    public void c() {
        b();
    }

    public void c(boolean z) {
        if (this.h != null) {
            this.t.removeMessages(3);
            Handler handler = this.t;
            handler.sendMessage(handler.obtainMessage(3, Boolean.valueOf(z)));
        }
    }

    public String d() {
        String str = this.r;
        if (str != null) {
            return str;
        }
        Camera.Parameters parameters = this.s;
        if (parameters == null) {
            return m();
        }
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!this.e || this.n == null) {
            String m = m();
            this.p = m;
            if (m == null) {
                String[] strArr = this.q;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = strArr[i2];
                    if (a.a.a.a.a.e.h.a(str2, supportedFocusModes)) {
                        this.p = str2;
                        break;
                    }
                    i = i2 + 1;
                }
            }
        } else {
            this.p = "auto";
        }
        if (!a.a.a.a.a.e.h.a(this.p, supportedFocusModes)) {
            if (a.a.a.a.a.e.h.a("auto", this.s.getSupportedFocusModes())) {
                this.p = "auto";
            } else {
                this.p = this.s.getFocusMode();
            }
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("FocusManager", "getFocusMode focusMode:" + this.p);
        return this.p;
    }

    public final void d(boolean z) {
        if (this.f1262c != 0) {
            return;
        }
        ViewGroup viewGroup = this.h;
        if (!(viewGroup instanceof FocusIndicator)) {
            a.a.a.a.a.e.e.g.d("FocusManager", "Not the FocusIndicator type!");
            return;
        }
        FocusIndicator focusIndicator = (FocusIndicator) viewGroup;
        if (z) {
            focusIndicator.showStart();
        } else {
            focusIndicator.showSuccess(true);
        }
    }

    public List<Camera.Area> e() {
        return this.n;
    }

    public List<Camera.Area> f() {
        return this.o;
    }

    public void g() {
        this.t.removeMessages(2);
        this.t.sendEmptyMessage(2);
    }

    public void h() {
        this.t.removeMessages(0);
        this.t.sendEmptyMessage(0);
    }

    public void i() {
        this.t.removeMessages(1);
    }

    public boolean j() {
        return this.f;
    }

    public final void k() {
        a.a.a.a.a.e.e.g.a("FocusManager", "Start autofocus.");
        this.u.r();
        this.f1262c = 1;
        g();
        this.t.removeMessages(1);
    }

    public final void l() {
        a.a.a.a.a.e.e.g.a("FocusManager", "Cancel autofocus.");
        n();
        this.u.s();
        this.f1262c = 0;
        o();
        this.t.removeMessages(1);
    }

    public final String m() {
        if (q() < 0) {
            return null;
        }
        CameraStreamingSetting cameraStreamingSetting = this.v;
        if (cameraStreamingSetting != null) {
            if (cameraStreamingSetting.isCAFEnabled()) {
                return this.v.getFocusMode();
            }
            return null;
        }
        return "continuous-video";
    }

    public final void n() {
        if (this.d) {
            ViewGroup viewGroup = this.h;
            if (viewGroup != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                layoutParams.gravity = 17;
                this.h.requestLayout();
                ViewGroup viewGroup2 = this.h;
                if (!(viewGroup2 instanceof FocusIndicator)) {
                    a.a.a.a.a.e.e.g.d("FocusManager", "Not the FocusIndicator type!");
                    return;
                }
                ((FocusIndicator) viewGroup2).clear();
            }
            this.n = null;
            this.o = null;
        }
    }

    public final void o() {
        ViewGroup viewGroup;
        if (!this.d || (viewGroup = this.h) == null) {
            return;
        }
        if (!(viewGroup instanceof FocusIndicator)) {
            a.a.a.a.a.e.e.g.d("FocusManager", "Not the FocusIndicator type!");
            return;
        }
        FocusIndicator focusIndicator = (FocusIndicator) viewGroup;
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("FocusManager", "mState:" + this.f1262c);
        int i = this.f1262c;
        if (i == 0) {
            if (this.n == null) {
                focusIndicator.clear();
            } else {
                focusIndicator.showStart();
            }
        } else if (i == 1) {
            focusIndicator.showStart();
        } else if ("continuous-picture".equals(this.p)) {
            focusIndicator.showSuccess(false);
        } else {
            int i2 = this.f1262c;
            if (i2 == 2) {
                focusIndicator.showSuccess(false);
            } else if (i2 == 3) {
                focusIndicator.showFail(false);
            }
        }
    }

    public final void p() {
        if (this.j == 0 || this.k == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        a.a.a.a.a.e.h.a(matrix, this.l, this.m, this.j, this.k);
        matrix.invert(this.g);
        this.d = true;
    }

    public final int q() {
        CameraStreamingSetting cameraStreamingSetting = this.v;
        if (cameraStreamingSetting != null) {
            return cameraStreamingSetting.getResetTouchFocusDelay();
        }
        return 3000;
    }

    public final int r() {
        int q = q();
        int i = q;
        if (q < 0) {
            i = q * (-1);
        }
        return i;
    }
}
