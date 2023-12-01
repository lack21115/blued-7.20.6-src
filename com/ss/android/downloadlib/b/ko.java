package com.ss.android.downloadlib.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadlib.utils.x;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/ko.class */
public class ko extends com.ss.android.socialbase.appdownloader.b.mb {
    private static String mb = ko.class.getSimpleName();

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/ko$mb.class */
    static class mb implements jb {
        private Dialog mb;

        public mb(Dialog dialog) {
            if (dialog != null) {
                this.mb = dialog;
                mb();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public void mb() {
            Dialog dialog = this.mb;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public boolean ox() {
            Dialog dialog = this.mb;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.mb, com.ss.android.socialbase.appdownloader.b.b
    public je mb(final Context context) {
        return new je() { // from class: com.ss.android.downloadlib.b.ko.1
            private DownloadAlertDialogInfo.mb b;
            private DialogInterface.OnClickListener h;
            private DialogInterface.OnClickListener hj;
            private DialogInterface.OnCancelListener u;

            {
                this.b = new DownloadAlertDialogInfo.mb(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public jb mb() {
                this.b.mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.b.ko.1.1
                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.u == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.u.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void mb(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.hj != null) {
                            AnonymousClass1.this.hj.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void ox(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.h != null) {
                            AnonymousClass1.this.h.onClick(dialogInterface, -2);
                        }
                    }
                });
                x.mb(ko.mb, "getThemedAlertDlgBuilder", null);
                this.b.mb(3);
                return new mb(com.ss.android.downloadlib.addownload.x.b().ox(this.b.mb()));
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(int i) {
                this.b.mb(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(int i, DialogInterface.OnClickListener onClickListener) {
                this.b.b(context.getResources().getString(i));
                this.hj = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(DialogInterface.OnCancelListener onCancelListener) {
                this.u = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(String str) {
                this.b.ox(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(boolean z) {
                this.b.mb(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je ox(int i, DialogInterface.OnClickListener onClickListener) {
                this.b.hj(context.getResources().getString(i));
                this.h = onClickListener;
                return this;
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.b.mb, com.ss.android.socialbase.appdownloader.b.b
    public boolean mb() {
        return true;
    }
}
