package com.anythink.expressad.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.v;
import com.bytedance.applog.tracker.Tracker;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/a/a.class */
public final class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5945a = "ATAlertDialog";
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f5946c;
    private TextView d;
    private Button e;
    private Button f;

    public a(Context context, final b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(i.a(context, "anythink_cm_alertview", "layout"), (ViewGroup) null);
        this.b = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f5946c = (TextView) inflate.findViewById(i.a(context, "anythink_video_common_alertview_titleview", "id"));
            } catch (Exception e) {
                o.a(f5945a, e.getMessage());
            }
            try {
                this.d = (TextView) inflate.findViewById(i.a(context, "anythink_video_common_alertview_contentview", "id"));
                this.e = (Button) inflate.findViewById(i.a(context, "anythink_video_common_alertview_confirm_button", "id"));
                this.f = (Button) inflate.findViewById(i.a(context, "anythink_video_common_alertview_cancel_button", "id"));
            } catch (Exception e2) {
                o.a(f5945a, e2.getMessage());
            }
        }
        Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.widget.a.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    a.this.cancel();
                    a.this.a();
                }
            });
        }
        Button button2 = this.e;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.widget.a.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    a.this.cancel();
                    a.this.a();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(int i) {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a(i == com.anythink.expressad.foundation.g.a.cr ? "Confirm" : "Tips");
            b(i == com.anythink.expressad.foundation.g.a.cr ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
            c(i == com.anythink.expressad.foundation.g.a.cr ? "Close" : "Cancel");
            d("Continue");
            return;
        }
        a(i == com.anythink.expressad.foundation.g.a.cr ? "确认关闭？" : "提示");
        b(i == com.anythink.expressad.foundation.g.a.cr ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
        c(i == com.anythink.expressad.foundation.g.a.cr ? "确认关闭" : "取消");
        d("继续");
    }

    private static void a(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT >= 19) {
                window.addFlags(67108864);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    private void a(String str) {
        TextView textView = this.f5946c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str);
        b(str2);
        c(str3);
        d(str4);
    }

    private void b(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void c() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("Confirm to close? ");
            b("You will not be rewarded after closing the window");
            c("Close it");
            d("Continue");
            return;
        }
        a("确认关闭？");
        b("关闭后您将不会获得任何奖励噢~ ");
        c("确认关闭");
        d("继续观看");
    }

    private void c(String str) {
        Button button = this.e;
        if (button != null) {
            button.setText(str);
        }
    }

    private void d() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b != null) {
            a(b.C(), b.D(), b.E(), b.F());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("Confirm to close? ");
            b("You will not be rewarded after closing the window");
            c("Close it");
            d("Continue");
            return;
        }
        a("确认关闭？");
        b("关闭后您将不会获得任何奖励噢~ ");
        c("确认关闭");
        d("继续试玩");
    }

    private void d(String str) {
        Button button = this.f;
        if (button != null) {
            button.setText(str);
        }
    }

    private void e() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            a("Confirm to close? ");
            b("You will not be rewarded after closing the window");
            c("Close it");
            d("Continue");
            return;
        }
        a("确认关闭？");
        b("关闭后您将不会获得任何奖励噢~ ");
        c("确认关闭");
        d("继续试玩");
    }

    public final void a() {
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void a(int i, String str) {
        try {
            String obj = v.b(getContext(), "Anythink_ConfirmTitle".concat(String.valueOf(str)), "").toString();
            String obj2 = v.b(getContext(), "Anythink_ConfirmContent".concat(String.valueOf(str)), "").toString();
            String obj3 = v.b(getContext(), "Anythink_CancelText".concat(String.valueOf(str)), "").toString();
            String obj4 = v.b(getContext(), "Anythink_ConfirmText".concat(String.valueOf(str)), "").toString();
            if (!TextUtils.isEmpty(obj) || !TextUtils.isEmpty(obj2) || !TextUtils.isEmpty(obj3) || !TextUtils.isEmpty(obj4)) {
                a(obj, obj2, obj3, obj4);
                return;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                a(i == com.anythink.expressad.foundation.g.a.cr ? "Confirm" : "Tips");
                b(i == com.anythink.expressad.foundation.g.a.cr ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                c(i == com.anythink.expressad.foundation.g.a.cr ? "Close" : "Cancel");
                d("Continue");
                return;
            }
            a(i == com.anythink.expressad.foundation.g.a.cr ? "确认关闭？" : "提示");
            b(i == com.anythink.expressad.foundation.g.a.cr ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
            c(i == com.anythink.expressad.foundation.g.a.cr ? "确认关闭" : "取消");
            d("继续");
        } catch (Exception e) {
            o.a(f5945a, e.getMessage());
        }
    }

    public final void b() {
        try {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                a("Confirm to close? ");
                b("You will not be rewarded after closing the window");
                c("Close it");
                d("Continue");
                return;
            }
            a("确认关闭？");
            b("关闭后您将不会获得任何奖励噢~ ");
            c("确认关闭");
            d("继续观看");
        } catch (Exception e) {
            o.a(f5945a, e.getMessage());
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT >= 19) {
                    window.addFlags(67108864);
                    window.getDecorView().setSystemUiVisibility(4098);
                } else {
                    window.getDecorView().setSystemUiVisibility(2);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                window.setGravity(17);
            }
            getWindow().clearFlags(8);
        } catch (Exception e) {
            o.d(f5945a, e.getMessage());
            super.show();
        }
    }
}
