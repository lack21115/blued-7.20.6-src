package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/DownloadAlertDialogInfo.class */
public class DownloadAlertDialogInfo {
    public String b;
    public String h;
    public String hj;
    public Drawable ko;
    public View lz;
    public Context mb;
    public String ox;
    public boolean u;
    public ox ww;
    public int x;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/DownloadAlertDialogInfo$Scene.class */
    public @interface Scene {
        public static final int BACK_INSTALL = 1;
        public static final int CANCEL = 3;
        public static final int OPEN_APP = 2;
        public static final int WEBVIEW_START = 0;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/DownloadAlertDialogInfo$mb.class */
    public static final class mb {
        private Context b;
        private String h;
        private String hj;
        private String ko;
        private Drawable lz;
        public View mb;
        public int ox;
        private String u;
        private boolean ww;
        private ox x;

        public mb(Context context) {
            this.b = context;
        }

        public mb b(String str) {
            this.u = str;
            return this;
        }

        public mb hj(String str) {
            this.ko = str;
            return this;
        }

        public mb mb(int i) {
            this.ox = i;
            return this;
        }

        public mb mb(Drawable drawable) {
            this.lz = drawable;
            return this;
        }

        public mb mb(ox oxVar) {
            this.x = oxVar;
            return this;
        }

        public mb mb(String str) {
            this.hj = str;
            return this;
        }

        public mb mb(boolean z) {
            this.ww = z;
            return this;
        }

        public DownloadAlertDialogInfo mb() {
            return new DownloadAlertDialogInfo(this);
        }

        public mb ox(String str) {
            this.h = str;
            return this;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/DownloadAlertDialogInfo$ox.class */
    public interface ox {
        void b(DialogInterface dialogInterface);

        void mb(DialogInterface dialogInterface);

        void ox(DialogInterface dialogInterface);
    }

    private DownloadAlertDialogInfo(mb mbVar) {
        this.u = true;
        this.mb = mbVar.b;
        this.ox = mbVar.hj;
        this.b = mbVar.h;
        this.hj = mbVar.u;
        this.h = mbVar.ko;
        this.u = mbVar.ww;
        this.ko = mbVar.lz;
        this.ww = mbVar.x;
        this.lz = mbVar.mb;
        this.x = mbVar.ox;
    }
}
