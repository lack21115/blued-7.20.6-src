package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ac.class */
public final class ac {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ac$a.class */
    public static final class a {
        private int azR;
        private int azS;
        private int azT;
        private int azU;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.azR = -1;
            this.azS = -1;
            this.azT = -1;
            this.azU = -1;
        }

        public a(int i, int i2) {
            this.mWidth = -1;
            this.mHeight = -1;
            this.azR = -1;
            this.azS = -1;
            this.azT = -1;
            this.azU = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final int DH() {
            return this.azR;
        }

        public final int DI() {
            return this.azS;
        }

        public final int DJ() {
            return this.azT;
        }

        public final int DK() {
            return this.azU;
        }

        public final void f(float f, float f2) {
            this.azR = (int) f;
            this.azS = (int) f2;
        }

        public final void g(float f, float f2) {
            this.azT = (int) f;
            this.azU = (int) f2;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.azR + ", mDownY=" + this.azS + ", mUpX=" + this.azT + ", mUpY=" + this.azU + '}';
        }

        public final void u(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }

    public static String a(String str, a aVar) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            if (aVar == null) {
                return str;
            }
            str2 = str.replace("__WIDTH__", cg(aVar.getWidth())).replace("__HEIGHT__", cg(aVar.getHeight())).replace("__DOWN_X__", cg(aVar.DH())).replace("__DOWN_Y__", cg(aVar.DI())).replace("__UP_X__", cg(aVar.DJ())).replace("__UP_Y__", cg(aVar.DK()));
        }
        return str2;
    }

    public static String ag(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.bJ(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.bK(context)));
    }

    public static String c(Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bf.v(context, z)));
    }

    private static String cg(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }
}
