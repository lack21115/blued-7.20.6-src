package com.blued.android.module.yy_china.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.IPopShowAndDismissListener;
import com.blued.android.module.yy_china.view.YYPopupWindow;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/PopupwindowFactory.class */
public class PopupwindowFactory {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/PopupwindowFactory$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f17872a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f17873c;
        private View d;
        private Context e;
        private int f;
        private IPopShowAndDismissListener h;
        private int g = -1;
        private boolean i = true;

        public Builder(Context context) {
            this.e = context;
        }

        public int a() {
            return this.b;
        }

        public Builder a(int i) {
            this.f17872a = i;
            return this;
        }

        public Builder a(View view) {
            this.d = view;
            return this;
        }

        public Builder a(IPopShowAndDismissListener iPopShowAndDismissListener) {
            this.h = iPopShowAndDismissListener;
            return this;
        }

        public Builder a(boolean z) {
            this.i = z;
            return this;
        }

        public void a(Context context) {
            this.e = context;
        }

        public int b() {
            return this.f17873c;
        }

        public Builder b(int i) {
            this.b = i;
            return this;
        }

        public View c() {
            return this.d;
        }

        public Builder c(int i) {
            this.f17873c = i;
            return this;
        }

        public Context d() {
            return this.e;
        }

        public Builder d(int i) {
            this.f = i;
            return this;
        }

        public int e() {
            return this.f;
        }

        public Builder e(int i) {
            this.g = i;
            return this;
        }

        public boolean f() {
            return this.i;
        }

        public IPopShowAndDismissListener g() {
            return this.h;
        }

        public PopupWindow h() {
            YYPopupWindow yYPopupWindow = new YYPopupWindow(this.e, this);
            int i = this.f17872a;
            if (i == 80) {
                yYPopupWindow.setAnimationStyle(R.style.yy_pop_bottom_in_anim);
            } else if (i == 48) {
                yYPopupWindow.setAnimationStyle(R.style.yy_pop_top_in_anim);
                yYPopupWindow.setClippingEnabled(false);
            } else if (i == 5) {
                yYPopupWindow.setAnimationStyle(R.style.yy_pop_right_in_anim);
            }
            int i2 = this.g;
            if (i2 != -1) {
                yYPopupWindow.setAnimationStyle(i2);
            }
            yYPopupWindow.setSoftInputMode(1);
            yYPopupWindow.setSoftInputMode(16);
            yYPopupWindow.showAtLocation(((Activity) this.e).getWindow().getDecorView(), this.f17872a, 0, 0);
            return yYPopupWindow;
        }
    }
}
