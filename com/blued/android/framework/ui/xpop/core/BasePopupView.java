package com.blued.android.framework.ui.xpop.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.BlurAnimator;
import com.blued.android.framework.ui.xpop.animator.EmptyAnimator;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAlphaAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.impl.FullScreenPopupView;
import com.blued.android.framework.ui.xpop.impl.PartShadowPopupView;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.util.navbar.OnNavigationBarListener;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BasePopupView.class */
public abstract class BasePopupView extends FrameLayout implements LifecycleObserver, OnNavigationBarListener {

    /* renamed from: a  reason: collision with root package name */
    private static Stack<BasePopupView> f9964a = new Stack<>();
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f9965c;
    private Runnable d;
    private boolean e;
    private Runnable f;
    private Runnable g;
    private ShowSoftInputTask h;
    private Runnable i;
    private float j;
    private float k;
    public PopupInfo l;
    protected PopupAnimator m;
    protected ShadowBgAnimator n;
    protected BlurAnimator o;
    public PopupStatus p;
    protected boolean q;
    public FullScreenDialog r;
    Runnable s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.core.BasePopupView$7  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BasePopupView$7.class */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9973a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010d -> B:111:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0111 -> B:105:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0115 -> B:123:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0119 -> B:117:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x011d -> B:133:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0121 -> B:127:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0125 -> B:99:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0129 -> B:93:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x012d -> B:109:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0131 -> B:103:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0135 -> B:121:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0139 -> B:115:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x013d -> B:131:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0141 -> B:125:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0145 -> B:97:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0149 -> B:91:0x00c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x014d -> B:107:0x00d0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0151 -> B:101:0x00dc). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0155 -> B:119:0x00e8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0159 -> B:113:0x00f4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x015d -> B:129:0x0100). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            f9973a = iArr;
            try {
                iArr[PopupAnimation.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9973a[PopupAnimation.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9973a[PopupAnimation.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9973a[PopupAnimation.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9973a[PopupAnimation.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9973a[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9973a[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9973a[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9973a[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9973a[PopupAnimation.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f9973a[PopupAnimation.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f9973a[PopupAnimation.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f9973a[PopupAnimation.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f9973a[PopupAnimation.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f9973a[PopupAnimation.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BasePopupView$BackPressListener.class */
    public class BackPressListener implements View.OnKeyListener {
        BackPressListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && BasePopupView.this.l != null) {
                if (BasePopupView.this.l.b.booleanValue()) {
                    if (BasePopupView.this.l.p == null || !BasePopupView.this.l.p.f(BasePopupView.this)) {
                        BasePopupView.this.k();
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BasePopupView$ShowSoftInputTask.class */
    public static class ShowSoftInputTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        View f9975a;
        boolean b = false;

        public ShowSoftInputTask(View view) {
            this.f9975a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f9975a;
            if (view == null || this.b) {
                return;
            }
            this.b = true;
            KeyboardUtils.a(view);
        }
    }

    public BasePopupView(Context context) {
        super(context);
        this.p = PopupStatus.Dismiss;
        this.q = false;
        this.f9965c = new Handler(Looper.getMainLooper());
        this.d = new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BasePopupView.this.r == null || BasePopupView.this.r.getWindow() == null || BasePopupView.this.l == null) {
                    return;
                }
                BasePopupView basePopupView = BasePopupView.this;
                basePopupView.b(XPopupUtils.b(basePopupView.r.getWindow()));
                BasePopupView.this.getPopupContentView().setAlpha(1.0f);
                BasePopupView.this.a();
                if (BasePopupView.this.l.p != null) {
                    BasePopupView.this.l.p.b(BasePopupView.this);
                }
                BasePopupView.this.j();
                BasePopupView.this.n();
                BasePopupView.this.i();
            }
        };
        this.e = false;
        this.f = new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BasePopupView.this.c();
                    if (BasePopupView.this.getContext() instanceof FragmentActivity) {
                        ((FragmentActivity) BasePopupView.this.getContext()).getLifecycle().addObserver(BasePopupView.this);
                    }
                    BasePopupView.this.l.q = (ViewGroup) BasePopupView.this.r.getWindow().getDecorView();
                    KeyboardUtils.a(BasePopupView.this.r.getWindow(), BasePopupView.this, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.2.1
                        @Override // com.blued.android.framework.ui.xpop.util.KeyboardUtils.OnSoftInputChangedListener
                        public void a(int i) {
                            if (BasePopupView.this.l != null && BasePopupView.this.l.p != null) {
                                BasePopupView.this.l.p.a(BasePopupView.this, i);
                            }
                            if (i == 0) {
                                XPopupUtils.a(BasePopupView.this);
                                BasePopupView.this.e = false;
                            } else if ((BasePopupView.this instanceof FullScreenPopupView) && BasePopupView.this.p == PopupStatus.Showing) {
                            } else {
                                if ((BasePopupView.this instanceof PartShadowPopupView) && BasePopupView.this.p == PopupStatus.Showing) {
                                    return;
                                }
                                XPopupUtils.a(i, BasePopupView.this);
                                BasePopupView.this.e = true;
                            }
                        }
                    });
                    BasePopupView.this.f();
                } catch (Throwable th) {
                }
            }
        };
        this.g = new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.3
            @Override // java.lang.Runnable
            public void run() {
                BasePopupView.this.p = PopupStatus.Show;
                BasePopupView.this.w();
                if (BasePopupView.this.l != null && BasePopupView.this.l.p != null) {
                    BasePopupView.this.l.p.c(BasePopupView.this);
                }
                if (BasePopupView.this.r == null || XPopupUtils.a(BasePopupView.this.r.getWindow()) <= 0 || BasePopupView.this.e) {
                    return;
                }
                XPopupUtils.a(XPopupUtils.a(BasePopupView.this.r.getWindow()), BasePopupView.this);
            }
        };
        this.i = new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.6
            @Override // java.lang.Runnable
            public void run() {
                View findViewById;
                if (BasePopupView.this.l == null) {
                    return;
                }
                if (BasePopupView.this.l.o.booleanValue()) {
                    BasePopupView basePopupView = BasePopupView.this;
                    if (basePopupView instanceof PartShadowPopupView) {
                        KeyboardUtils.b(basePopupView);
                    }
                }
                BasePopupView.this.u();
                if (BasePopupView.this.l.p != null) {
                    BasePopupView.this.l.p.d(BasePopupView.this);
                }
                if (BasePopupView.this.s != null) {
                    BasePopupView.this.s.run();
                    BasePopupView.this.s = null;
                }
                BasePopupView.this.p = PopupStatus.Dismiss;
                if (!BasePopupView.f9964a.isEmpty()) {
                    BasePopupView.f9964a.pop();
                }
                if (BasePopupView.this.l.B) {
                    if (!BasePopupView.f9964a.isEmpty()) {
                        ((BasePopupView) BasePopupView.f9964a.get(BasePopupView.f9964a.size() - 1)).j();
                    } else if (BasePopupView.this.l.q != null && (findViewById = BasePopupView.this.l.q.findViewById(16908290)) != null) {
                        findViewById.setFocusable(true);
                        findViewById.setFocusableInTouchMode(true);
                    }
                }
                if (BasePopupView.this.r != null) {
                    BasePopupView.this.r.dismiss();
                }
            }
        };
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.n = new ShadowBgAnimator(this);
        View inflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        inflate.setAlpha(0.0f);
        addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if ((this instanceof AttachPopupView) && !(this instanceof PartShadowPopupView)) {
            if (this.l.j != null) {
                PopupAnimator popupAnimator = this.l.j;
                this.m = popupAnimator;
                popupAnimator.f9941c = getPopupContentView();
            } else {
                PopupAnimator l = l();
                this.m = l;
                if (l == null) {
                    this.m = getPopupAnimator();
                }
            }
            if (this.l.e.booleanValue()) {
                this.n.a();
            }
            if (this.l.f.booleanValue()) {
                BlurAnimator blurAnimator = new BlurAnimator(this);
                this.o = blurAnimator;
                blurAnimator.b = this.l.e.booleanValue();
                this.o.f9940a = XPopupUtils.a(XPopupUtils.b((View) this).getWindow().getDecorView());
                this.o.a();
            }
            PopupAnimator popupAnimator2 = this.m;
            if (popupAnimator2 != null) {
                popupAnimator2.a();
            }
        } else if (this.m == null) {
            if (this.l.j != null) {
                PopupAnimator popupAnimator3 = this.l.j;
                this.m = popupAnimator3;
                popupAnimator3.f9941c = getPopupContentView();
            } else {
                PopupAnimator l2 = l();
                this.m = l2;
                if (l2 == null) {
                    this.m = getPopupAnimator();
                }
            }
            if (this.l.e.booleanValue()) {
                this.n.a();
            }
            if (this.l.f.booleanValue()) {
                BlurAnimator blurAnimator2 = new BlurAnimator(this);
                this.o = blurAnimator2;
                blurAnimator2.b = this.l.e.booleanValue();
                this.o.f9940a = XPopupUtils.a(XPopupUtils.b((View) this).getWindow().getDecorView());
                this.o.a();
            }
            PopupAnimator popupAnimator4 = this.m;
            if (popupAnimator4 != null) {
                popupAnimator4.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.r == null) {
            this.r = new FullScreenDialog(getContext()).a(this);
        }
        try {
            this.r.show();
        } catch (Throwable th) {
        }
    }

    public void a(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        this.f9965c.postDelayed(new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.5
            @Override // java.lang.Runnable
            public void run() {
                BasePopupView.this.p();
            }
        }, j2);
    }

    protected void a(View view) {
        if (this.l.o.booleanValue()) {
            ShowSoftInputTask showSoftInputTask = this.h;
            if (showSoftInputTask == null) {
                this.h = new ShowSoftInputTask(view);
            } else {
                this.f9965c.removeCallbacks(showSoftInputTask);
            }
            this.f9965c.postDelayed(this.h, 10L);
        }
    }

    @Override // com.blued.android.framework.ui.xpop.util.navbar.OnNavigationBarListener
    public void a(boolean z) {
        if (z) {
            b(true);
        } else {
            g();
        }
    }

    public void b() {
    }

    protected void b(boolean z) {
    }

    protected void f() {
        if (this instanceof AttachPopupView) {
            b();
        } else if (!this.q) {
            b();
        }
        if (!(this instanceof FullScreenPopupView)) {
            XPopupUtils.a(getTargetSizeView(), (getMaxWidth() == 0 || getPopupWidth() <= getMaxWidth()) ? getPopupWidth() : getMaxWidth(), (getMaxHeight() == 0 || getPopupHeight() <= getMaxHeight()) ? getPopupHeight() : getMaxHeight());
        }
        if (!this.q) {
            this.q = true;
            m();
            if (this.l.p != null) {
                this.l.p.a(this);
            }
        }
        this.f9965c.postDelayed(this.d, 50L);
    }

    protected void g() {
    }

    public int getAnimationDuration() {
        if (this.l.i == PopupAnimation.NoAnimation) {
            return 10;
        }
        return 10 + XPopup.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getImplLayoutId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxHeight() {
        return this.l.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxWidth() {
        return 0;
    }

    protected PopupAnimator getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    protected int getPopupHeight() {
        return 0;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    protected abstract int getPopupLayoutId();

    protected int getPopupWidth() {
        return 0;
    }

    protected View getTargetSizeView() {
        return getPopupContentView();
    }

    public BasePopupView h() {
        Activity b = XPopupUtils.b((View) this);
        if (b != null) {
            if (!b.isFinishing() && this.p != PopupStatus.Showing) {
                this.p = PopupStatus.Showing;
                FullScreenDialog fullScreenDialog = this.r;
                if (fullScreenDialog != null && fullScreenDialog.isShowing()) {
                    return this;
                }
                this.f9965c.post(this.f);
            }
            return this;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.f9965c.removeCallbacks(this.g);
        this.f9965c.postDelayed(this.g, getAnimationDuration());
    }

    public void j() {
        PopupInfo popupInfo = this.l;
        if (popupInfo == null || !popupInfo.B) {
            return;
        }
        setFocusableInTouchMode(true);
        requestFocus();
        if (!f9964a.contains(this)) {
            f9964a.push(this);
        }
        setOnKeyListener(new BackPressListener());
        if (!this.l.C) {
            a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        XPopupUtils.a(arrayList, (ViewGroup) getPopupContentView());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            EditText editText = (EditText) arrayList.get(i2);
            editText.setOnKeyListener(new BackPressListener());
            if (i2 == 0 && this.l.C) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                a(editText);
            }
            i = i2 + 1;
        }
    }

    protected void k() {
        if (KeyboardUtils.f10015a == 0) {
            p();
        } else {
            KeyboardUtils.b(this);
        }
    }

    protected PopupAnimator l() {
        PopupInfo popupInfo = this.l;
        if (popupInfo == null || popupInfo.i == null) {
            return null;
        }
        switch (AnonymousClass7.f9973a[this.l.i.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new ScaleAlphaAnimator(getPopupContentView(), this.l.i);
            case 6:
            case 7:
            case 8:
            case 9:
                return new TranslateAlphaAnimator(getPopupContentView(), this.l.i);
            case 10:
            case 11:
            case 12:
            case 13:
                return new TranslateAnimator(getPopupContentView(), this.l.i);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new ScrollScaleAnimator(getPopupContentView(), this.l.i);
            case 22:
                return new EmptyAnimator(getPopupContentView());
            default:
                return null;
        }
    }

    protected void m() {
    }

    public void n() {
        BlurAnimator blurAnimator;
        if (this.l.e.booleanValue() && !this.l.f.booleanValue()) {
            this.n.b();
        } else if (this.l.f.booleanValue() && (blurAnimator = this.o) != null) {
            blurAnimator.b();
        }
        PopupAnimator popupAnimator = this.m;
        if (popupAnimator != null) {
            popupAnimator.b();
        }
    }

    public void o() {
        BlurAnimator blurAnimator;
        if (this.l.e.booleanValue() && !this.l.f.booleanValue()) {
            this.n.c();
        } else if (this.l.f.booleanValue() && (blurAnimator = this.o) != null) {
            blurAnimator.c();
        }
        PopupAnimator popupAnimator = this.m;
        if (popupAnimator != null) {
            popupAnimator.c();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f9964a.clear();
        this.f9965c.removeCallbacksAndMessages(null);
        PopupInfo popupInfo = this.l;
        if (popupInfo != null) {
            if (popupInfo.q != null) {
                KeyboardUtils.a(this.l.q, this);
            }
            if (this.l.H) {
                this.l.g = null;
                this.l.h = null;
                this.l.p = null;
                this.l = null;
            }
        }
        this.p = PopupStatus.Dismiss;
        this.h = null;
        this.e = false;
        BlurAnimator blurAnimator = this.o;
        if (blurAnimator == null || blurAnimator.f9940a == null || this.o.f9940a.isRecycled()) {
            return;
        }
        this.o.f9940a.recycle();
        this.o.f9940a = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupInfo popupInfo;
        Rect rect = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!XPopupUtils.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.j = motionEvent.getX();
                this.k = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.j, 2.0d) + Math.pow(motionEvent.getY() - this.k, 2.0d))) < this.b && this.l.f9988c.booleanValue()) {
                    p();
                }
                this.j = 0.0f;
                this.k = 0.0f;
            }
        }
        if (this.r == null || (popupInfo = this.l) == null || !popupInfo.D) {
            return true;
        }
        this.r.a(motionEvent);
        return true;
    }

    public void p() {
        this.f9965c.removeCallbacks(this.f);
        this.f9965c.removeCallbacks(this.d);
        if (this.p == PopupStatus.Dismissing || this.p == PopupStatus.Dismiss) {
            return;
        }
        this.p = PopupStatus.Dismissing;
        clearFocus();
        PopupInfo popupInfo = this.l;
        if (popupInfo != null && popupInfo.p != null) {
            this.l.p.e(this);
        }
        v();
        o();
        r();
    }

    public void q() {
        this.f9965c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.BasePopupView.4
            @Override // java.lang.Runnable
            public void run() {
                BasePopupView.this.a(XPopup.b() + 50);
            }
        });
    }

    public void r() {
        PopupInfo popupInfo = this.l;
        if (popupInfo != null && popupInfo.o.booleanValue() && !(this instanceof PartShadowPopupView)) {
            KeyboardUtils.b(this);
        }
        this.f9965c.removeCallbacks(this.i);
        this.f9965c.postDelayed(this.i, getAnimationDuration());
    }

    public boolean s() {
        return this.p != PopupStatus.Dismiss;
    }

    public boolean t() {
        return this.p == PopupStatus.Dismiss;
    }

    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
    }

    public void w() {
    }

    public void x() {
        FullScreenDialog fullScreenDialog = this.r;
        if (fullScreenDialog != null) {
            fullScreenDialog.dismiss();
        }
        onDetachedFromWindow();
        PopupInfo popupInfo = this.l;
        if (popupInfo != null) {
            popupInfo.g = null;
            this.l.h = null;
            this.l.p = null;
        }
        this.l = null;
    }
}
