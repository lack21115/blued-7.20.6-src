package com.ss.android.socialbase.appdownloader.hj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/hj/mb.class */
public class mb extends com.ss.android.socialbase.appdownloader.b.ox {
    private AlertDialog.Builder mb;

    /* renamed from: com.ss.android.socialbase.appdownloader.hj.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/hj/mb$mb.class */
    static class C0714mb implements jb {
        private AlertDialog mb;

        public C0714mb(AlertDialog.Builder builder) {
            if (builder != null) {
                this.mb = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public void mb() {
            AlertDialog alertDialog = this.mb;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public boolean ox() {
            AlertDialog alertDialog = this.mb;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public mb(Context context) {
        this.mb = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public jb mb() {
        return new C0714mb(this.mb);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(int i) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(String str) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je ox(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }
}
