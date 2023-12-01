package com.anythink.basead.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.y;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/c/g.class */
public final class g extends y {
    String a;
    String b;

    public g(com.anythink.core.common.e.i iVar, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = iVar;
    }

    @Override // com.anythink.core.common.e.y
    public final void a(Activity activity) {
        try {
            String aa = this.c instanceof aa ? ((aa) this.c).aa() : "";
            String str = aa;
            if (TextUtils.isEmpty(aa)) {
                str = this.c.r();
            }
            final Context g = n.a().g();
            View inflate = LayoutInflater.from(activity).inflate(com.anythink.core.common.k.h.a(g, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(com.anythink.core.common.k.h.a(g, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) inflate.findViewById(com.anythink.core.common.k.h.a(g, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) inflate.findViewById(com.anythink.core.common.k.h.a(g, "myoffer_confirm_continue", "id"));
            textView.setText("立即打开\"" + str + "\"?");
            textView2.setText("取 消");
            textView3.setText("确 定");
            final Dialog dialog = new Dialog(activity, com.anythink.core.common.k.h.a(g, "style_full_screen_translucent_dialog", "style"));
            dialog.setContentView(inflate);
            dialog.setCancelable(false);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.c.g.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    com.anythink.core.common.j.c.a(g.this.b, g.this.c.p(), g.this.a, 7, (String) null, 0L, 0L);
                    try {
                        dialog.dismiss();
                    } catch (Throwable th) {
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.c.g.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    try {
                        com.anythink.core.common.j.c.a(g.this.b, g.this.c.p(), g.this.a, 8, (String) null, 0L, 0L);
                        if (com.anythink.basead.a.b.a(g, g.this.c)) {
                            com.anythink.core.common.j.c.a(g.this.b, g.this.c.p(), g.this.a, 9, (String) null, 0L, 0L);
                        }
                        dialog.dismiss();
                    } catch (Throwable th) {
                    }
                }
            });
            dialog.show();
        } catch (Throwable th) {
        }
    }
}
