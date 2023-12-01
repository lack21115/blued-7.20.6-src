package com.blued.android.framework.ui.xpop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.core.PopupInfo;
import com.blued.android.framework.ui.xpop.core.PositionPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.enums.PopupType;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/XPopup.class */
public class XPopup {
    private static int b = Color.parseColor("#121212");

    /* renamed from: c  reason: collision with root package name */
    private static int f9937c = 350;

    /* renamed from: a  reason: collision with root package name */
    public static int f9936a = Color.parseColor("#55000000");
    private static int d = Color.parseColor("#6F000000");

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/XPopup$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final PopupInfo f9938a = new PopupInfo();
        private Context b;

        /* renamed from: com.blued.android.framework.ui.xpop.XPopup$Builder$1  reason: invalid class name */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/XPopup$Builder$1.class */
        class AnonymousClass1 implements View.OnTouchListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Builder f9939a;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.f9939a.f9938a.k == null || motionEvent.getAction() == 0) {
                    this.f9939a.f9938a.k = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                    return false;
                }
                return false;
            }
        }

        public Builder(Context context) {
            this.b = context;
        }

        public Builder a(int i) {
            this.f9938a.l = i;
            return this;
        }

        public Builder a(View view) {
            this.f9938a.g = view;
            return this;
        }

        public Builder a(PopupAnimation popupAnimation) {
            this.f9938a.i = popupAnimation;
            return this;
        }

        public Builder a(PopupPosition popupPosition) {
            this.f9938a.s = popupPosition;
            return this;
        }

        public Builder a(PopupType popupType) {
            this.f9938a.f9987a = popupType;
            return this;
        }

        public Builder a(XPopupCallback xPopupCallback) {
            this.f9938a.p = xPopupCallback;
            return this;
        }

        public Builder a(Boolean bool) {
            this.f9938a.b = bool;
            return this;
        }

        public Builder a(boolean z) {
            this.f9938a.v = Boolean.valueOf(z);
            return this;
        }

        public BasePopupView a(BasePopupView basePopupView) {
            if (basePopupView instanceof CenterPopupView) {
                a(PopupType.Center);
            } else if (basePopupView instanceof BottomPopupView) {
                a(PopupType.Bottom);
            } else if (basePopupView instanceof AttachPopupView) {
                a(PopupType.AttachView);
            } else if (basePopupView instanceof PositionPopupView) {
                a(PopupType.Position);
            }
            basePopupView.l = this.f9938a;
            return basePopupView;
        }

        public Builder b(int i) {
            this.f9938a.x = i;
            return this;
        }

        public Builder b(Boolean bool) {
            this.f9938a.f9988c = bool;
            return this;
        }

        public Builder b(boolean z) {
            this.f9938a.A = z;
            return this;
        }

        public Builder c(int i) {
            this.f9938a.y = i;
            return this;
        }

        public Builder c(Boolean bool) {
            this.f9938a.d = bool;
            return this;
        }

        public Builder c(boolean z) {
            this.f9938a.D = z;
            return this;
        }

        public Builder d(Boolean bool) {
            this.f9938a.e = bool;
            return this;
        }

        public Builder d(boolean z) {
            this.f9938a.H = z;
            return this;
        }

        public Builder e(Boolean bool) {
            this.f9938a.o = bool;
            return this;
        }

        public Builder f(Boolean bool) {
            this.f9938a.r = bool;
            return this;
        }
    }

    private XPopup() {
    }

    public static int a() {
        return d;
    }

    public static int b() {
        return f9937c;
    }
}
