package com.anythink.china.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.f.a;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity.class */
public class ApkConfirmDialogActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static i f6249a;
    private static a b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f6250c;

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$2.class */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$3.class */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$4.class */
    final class AnonymousClass4 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6258a;
        final /* synthetic */ RoundImageView b;

        AnonymousClass4(String str, RoundImageView roundImageView) {
            this.f6258a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.f6258a)) {
                this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$5.class */
    final class AnonymousClass5 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6260a;

        AnonymousClass5(i iVar) {
            this.f6260a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(ApkConfirmDialogActivity.this, this.f6260a.I());
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$6  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$6.class */
    final class AnonymousClass6 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6261a;

        AnonymousClass6(i iVar) {
            this.f6261a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(ApkConfirmDialogActivity.this, this.f6261a.H());
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$7  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$7.class */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.7.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(true);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$8  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/ApkConfirmDialogActivity$8.class */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.8.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ApkConfirmDialogActivity.b != null) {
                        ApkConfirmDialogActivity.b.a(false);
                    }
                }
            });
            ApkConfirmDialogActivity.this.finish();
        }
    }

    public static void a(final Context context, final i iVar, final a aVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.common.a.a(Context.this).a(iVar)) {
                    aVar.a(true);
                } else if (com.anythink.china.common.c.a.a(Context.this, iVar.B())) {
                    aVar.a(true);
                } else {
                    n.a().a(new Runnable() { // from class: com.anythink.china.activity.ApkConfirmDialogActivity.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApkConfirmDialogActivity.f6249a = iVar;
                            a unused = ApkConfirmDialogActivity.b = aVar;
                            Intent intent = new Intent(Context.this, ApkConfirmDialogActivity.class);
                            intent.addFlags(268435456);
                            Context.this.startActivity(intent);
                        }
                    });
                }
            }
        });
    }

    private void b() {
        try {
            String aa = f6249a instanceof aa ? ((aa) f6249a).aa() : "";
            String str = aa;
            if (TextUtils.isEmpty(aa)) {
                str = f6249a.r();
            }
            View inflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText("立即下载\"" + str + "\"?");
            textView2.setText("取 消");
            textView3.setText("确 定");
            textView2.setOnClickListener(new AnonymousClass2());
            textView3.setOnClickListener(new AnonymousClass3());
            Dialog dialog = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f6250c = dialog;
            dialog.setContentView(inflate);
            this.f6250c.setCancelable(false);
            this.f6250c.show();
        } catch (Throwable th) {
            finish();
        }
    }

    private void c() {
        try {
            i iVar = f6249a;
            View inflate = LayoutInflater.from(this).inflate(h.a(this, "confirm", "layout"), (ViewGroup) null, false);
            RoundImageView roundImageView = (RoundImageView) inflate.findViewById(h.a(this, "confirm_dialog_icon", "id"));
            TextView textView = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_title", "id"));
            TextView textView2 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_version_name", "id"));
            TextView textView3 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_publisher_name", "id"));
            TextView textView4 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_permission_manage", "id"));
            TextView textView5 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_privacy_agreement", "id"));
            TextView textView6 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_download_now", "id"));
            TextView textView7 = (TextView) inflate.findViewById(h.a(this, "confirm_dialog_give_up", "id"));
            String t = iVar.t();
            if (TextUtils.isEmpty(t)) {
                ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.height = 0;
                roundImageView.setLayoutParams(layoutParams);
            } else {
                roundImageView.setNeedRadiu(true);
                roundImageView.setRadiusInDip(4);
                ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                b.a(this).a(new e(1, t), layoutParams2.width, layoutParams2.height, new AnonymousClass4(t, roundImageView));
            }
            String aa = iVar instanceof aa ? ((aa) iVar).aa() : "";
            String str = aa;
            if (TextUtils.isEmpty(aa)) {
                str = iVar.r();
            }
            textView.setText(str);
            textView2.setText(getResources().getString(h.a(this, "confirm_dialog_version", "string"), iVar.G()));
            textView3.setText(getResources().getString(h.a(this, "confirm_dialog_publisher", "string"), iVar.F()));
            String string = getResources().getString(h.a(this, "confirm_dialog_privacy_agreement", "string"));
            String string2 = getResources().getString(h.a(this, "confirm_dialog_application_permission", "string"));
            int length = string.length();
            int length2 = string2.length();
            if (length != length2) {
                int abs = Math.abs(length2 - length);
                StringBuilder sb = new StringBuilder(string);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= abs) {
                        break;
                    }
                    sb.append(" ");
                    i = i2 + 1;
                }
                string = sb.toString();
            }
            textView5.setText(string);
            textView4.setOnClickListener(new AnonymousClass5(iVar));
            textView5.setOnClickListener(new AnonymousClass6(iVar));
            textView6.setOnClickListener(new AnonymousClass7());
            textView7.setOnClickListener(new AnonymousClass8());
            Dialog dialog = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f6250c = dialog;
            dialog.setContentView(inflate);
            this.f6250c.setCancelable(false);
            Window window = this.f6250c.getWindow();
            if (window != null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(h.a(this, "confirm_dialog_margin", "dimen"));
                int i3 = getResources().getDisplayMetrics().widthPixels;
                int i4 = getResources().getDisplayMetrics().heightPixels;
                if (i3 > i4) {
                    int i5 = i4 - (dimensionPixelSize * 2);
                    window.setLayout((int) Math.ceil(i5 * 0.98859316f), i5);
                } else {
                    int i6 = i3 - (dimensionPixelSize * 2);
                    window.setLayout(i6, (int) Math.ceil(i6 / 0.98859316f));
                }
            }
            this.f6250c.show();
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0328 A[Catch: all -> 0x0410, TRY_LEAVE, TryCatch #0 {all -> 0x0410, blocks: (B:64:0x031f, B:66:0x0328, B:68:0x0338, B:70:0x033f, B:72:0x0348), top: B:82:0x031f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x033f A[Catch: all -> 0x0410, TryCatch #0 {all -> 0x0410, blocks: (B:64:0x031f, B:66:0x0328, B:68:0x0338, B:70:0x033f, B:72:0x0348), top: B:82:0x031f }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x041a  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.activity.ApkConfirmDialogActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        u.a(false);
        Dialog dialog = this.f6250c;
        if (dialog != null) {
            dialog.dismiss();
            this.f6250c = null;
        }
        f6249a = null;
        b = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        u.a(true);
    }
}
