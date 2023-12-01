package com.anythink.expressad.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/ATAdChoice.class */
public class ATAdChoice extends ATImageView {

    /* renamed from: a  reason: collision with root package name */
    private static String f5937a = "ATAdChoice";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5938c;
    private String d;
    private Context e;

    /* renamed from: com.anythink.expressad.widget.ATAdChoice$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/ATAdChoice$1.class */
    final class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            ATAdChoice.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    public ATAdChoice(Context context) {
        super(context);
        this.b = "";
        this.f5938c = "";
        this.d = "";
        this.e = context;
        a();
    }

    public ATAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.f5938c = "";
        this.d = "";
        this.e = context;
        a();
    }

    public ATAdChoice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.f5938c = "";
        this.d = "";
        this.e = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.anythink.expressad.foundation.d.c r4) {
        /*
            r3 = this;
            r0 = 1
            r7 = r0
            r0 = r4
            if (r0 == 0) goto L4e
            r0 = r4
            com.anythink.expressad.foundation.d.c$a r0 = r0.v()
            if (r0 == 0) goto L4e
            r0 = r4
            com.anythink.expressad.foundation.d.c$a r0 = r0.v()
            java.lang.String r0 = r0.c()
            r8 = r0
            r0 = r3
            r1 = r8
            r0.b = r1
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4e
            r0 = r4
            com.anythink.expressad.foundation.d.c$a r0 = r0.v()
            java.lang.String r0 = r0.b()
            r8 = r0
            r0 = r3
            r1 = r8
            r0.d = r1
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4e
            r0 = r4
            com.anythink.expressad.foundation.d.c$a r0 = r0.v()
            java.lang.String r0 = r0.d()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4e
            r0 = 1
            r5 = r0
            goto L50
        L4e:
            r0 = 0
            r5 = r0
        L50:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto La5
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()
            java.lang.String r0 = r0.e()
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.b()
            r4 = r0
            r0 = r4
            if (r0 == 0) goto La1
            r0 = r4
            java.lang.String r0 = r0.H()
            r8 = r0
            r0 = r3
            r1 = r8
            r0.b = r1
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La1
            r0 = r4
            java.lang.String r0 = r0.J()
            r8 = r0
            r0 = r3
            r1 = r8
            r0.d = r1
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La1
            r0 = r4
            java.lang.String r0 = r0.I()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La1
            r0 = r7
            r5 = r0
            goto La3
        La1:
            r0 = 0
            r5 = r0
        La3:
            r0 = r5
            r6 = r0
        La5:
            r0 = r3
            r1 = r3
            java.lang.String r1 = r1.b
            r0.setImageUrl(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.widget.ATAdChoice.a(com.anythink.expressad.foundation.d.c):boolean");
    }

    private void b() {
        Context context = this.e;
        if (context != null) {
            b.a(context).a(this.b, new AnonymousClass1());
        }
    }

    private void c() {
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        s.a(this.e, this.d, null);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (TextUtils.isEmpty(this.d)) {
            return true;
        }
        s.a(this.e, this.d, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCampaign(com.anythink.expressad.out.j r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.widget.ATAdChoice.setCampaign(com.anythink.expressad.out.j):void");
    }
}
