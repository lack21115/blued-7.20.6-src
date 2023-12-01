package com.ss.android.downloadlib.addownload.mb;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.R;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb/hj.class */
public class hj extends Dialog {
    private TextView b;
    private boolean h;
    private b hj;
    private String ko;
    private String lz;
    private TextView mb;
    private TextView ox;
    private Activity u;
    private String ww;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb/hj$mb.class */
    public static class mb {
        private String b;
        private boolean h;
        private String hj;
        private Activity mb;
        private String ox;
        private b u;

        public mb(Activity activity) {
            this.mb = activity;
        }

        public mb b(String str) {
            this.hj = str;
            return this;
        }

        public mb mb(b bVar) {
            this.u = bVar;
            return this;
        }

        public mb mb(String str) {
            this.ox = str;
            return this;
        }

        public mb mb(boolean z) {
            this.h = z;
            return this;
        }

        public hj mb() {
            return new hj(this.mb, this.ox, this.b, this.hj, this.h, this.u);
        }

        public mb ox(String str) {
            this.b = str;
            return this;
        }
    }

    public hj(Activity activity, String str, String str2, String str3, boolean z, b bVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.u = activity;
        this.hj = bVar;
        this.ko = str;
        this.ww = str2;
        this.lz = str3;
        setCanceledOnTouchOutside(z);
        hj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.h = true;
        dismiss();
    }

    private void hj() {
        setContentView(LayoutInflater.from(this.u.getApplicationContext()).inflate(mb(), (ViewGroup) null));
        this.mb = (TextView) findViewById(ox());
        this.ox = (TextView) findViewById(b());
        this.b = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.ww)) {
            this.mb.setText(this.ww);
        }
        if (!TextUtils.isEmpty(this.lz)) {
            this.ox.setText(this.lz);
        }
        if (!TextUtils.isEmpty(this.ko)) {
            this.b.setText(this.ko);
        }
        this.mb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.mb.hj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                hj.this.h();
            }
        });
        this.ox.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.mb.hj.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                hj.this.u();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        dismiss();
    }

    public int b() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.u.isFinishing()) {
            this.u.finish();
        }
        if (this.h) {
            this.hj.mb();
        } else {
            this.hj.ox();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int mb() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int ox() {
        return R.id.confirm_tv;
    }
}
