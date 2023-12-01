package com.opos.mobad.o.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.opos.mobad.o.a.b.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f13337a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.o.a.b.a f13338c;
    private com.opos.mobad.o.a.b.b d;
    private final String e = "提交成功，感谢您的反馈！";
    private c f = new c() { // from class: com.opos.mobad.o.a.a.2
        @Override // com.opos.mobad.o.a.b.c
        public void a() {
            if (a.this.f13338c != null) {
                a.this.f13338c.dismiss();
            }
        }

        @Override // com.opos.mobad.o.a.b.c
        public void a(int i) {
            if (a.this.f13338c != null) {
                a.this.f13338c.dismiss();
            }
            if (a.this.b != null) {
                a.this.b.a(i);
            }
            Toast.makeText(a.this.f13337a, "提交成功，感谢您的反馈！", 1).show();
        }
    };

    public a(Context context, b bVar) {
        this.f13337a = context.getApplicationContext();
        this.b = bVar;
        com.opos.mobad.o.a.b.a aVar = new com.opos.mobad.o.a.b.a(context);
        this.f13338c = aVar;
        aVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.opos.mobad.o.a.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.b != null) {
                    a.this.b.a(false);
                }
            }
        });
    }

    public void a() {
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "destroy mFeedBackPopWindow =" + this.f13338c);
        com.opos.mobad.o.a.b.a aVar = this.f13338c;
        if (aVar != null) {
            aVar.dismiss();
            this.f13338c.setOnDismissListener(null);
        }
        com.opos.mobad.o.a.b.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (b(view.getRootView())) {
                    if (this.d != null) {
                        this.d.b();
                    }
                    com.opos.mobad.o.a.b.b bVar = new com.opos.mobad.o.a.b.b(this.f13337a, this.f);
                    this.d = bVar;
                    this.f13338c.a(bVar.a(), -1, -1, view);
                    return;
                }
            } catch (Exception e) {
            }
        }
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.a(true);
        }
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public boolean b(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            com.opos.cmn.an.f.a.b("FeedBackPresenter", "isMeetSize viewArea =" + rect.toString());
            if (rect.width() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f) && rect.height() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f)) {
                return true;
            }
        }
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "decorView is not meet Size with FeedBackContent");
        return false;
    }
}
