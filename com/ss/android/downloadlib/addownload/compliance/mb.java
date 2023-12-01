package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.hj;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.utils.jb;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/mb.class */
public class mb extends Dialog {
    private TextView b;
    private TextView h;
    private TextView hj;
    private long jb;
    private final com.ss.android.downloadlib.addownload.model.ox je;
    private ClipImageView ko;
    private Activity lz;
    private TextView mb;
    private TextView ox;
    private TextView u;
    private LinearLayout ww;
    private final long x;

    public mb(Activity activity, long j) {
        super(activity);
        this.lz = activity;
        this.x = j;
        this.je = b.mb().get(Long.valueOf(j));
    }

    private void mb() {
        this.mb = (TextView) findViewById(R.id.tv_app_name);
        this.ox = (TextView) findViewById(R.id.tv_app_version);
        this.b = (TextView) findViewById(R.id.tv_app_developer);
        this.hj = (TextView) findViewById(R.id.tv_app_detail);
        this.h = (TextView) findViewById(R.id.tv_app_privacy);
        this.u = (TextView) findViewById(R.id.tv_give_up);
        this.ko = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.ww = (LinearLayout) findViewById(R.id.ll_download);
        this.mb.setText(jb.mb(this.je.h, "--"));
        TextView textView = this.ox;
        textView.setText("版本号：" + jb.mb(this.je.u, "--"));
        TextView textView2 = this.b;
        textView2.setText("开发者：" + jb.mb(this.je.ko, "应用信息正在完善中"));
        this.ko.setRoundRadius(jb.mb(x.getContext(), 8.0f));
        this.ko.setBackgroundColor(Color.parseColor("#EBEBEB"));
        hj.mb().mb(this.x, new hj.mb() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.2
            @Override // com.ss.android.downloadlib.addownload.compliance.hj.mb
            public void mb(Bitmap bitmap) {
                if (bitmap != null) {
                    mb.this.ko.setImageBitmap(bitmap);
                } else {
                    h.mb(8, mb.this.jb);
                }
            }
        });
        this.hj.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ox.mb().mb(mb.this.lz);
                AppDetailInfoActivity.mb(mb.this.lz, mb.this.x);
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_DETAIL, mb.this.jb);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ox.mb().mb(mb.this.lz);
                AppPrivacyPolicyActivity.mb(mb.this.lz, mb.this.x);
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_PRIVACY, mb.this.jb);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                mb.this.dismiss();
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_GIVE_UP, mb.this.jb);
            }
        });
        this.ww.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_DOWNLOAD, mb.this.jb);
                ox.mb().ox(mb.this.jb);
                mb.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.b.mb(this.lz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.je == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.jb = this.je.ox;
        mb();
        h.ox(EventConstants.Label.LP_APP_DIALOG_SHOW, this.jb);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CANCEL, mb.this.jb);
            }
        });
    }
}
