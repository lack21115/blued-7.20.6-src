package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/a.class */
public class a extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f35776a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f35777c;
    private String d;
    private String e;
    private Context f;
    private InterfaceC0916a g;

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/a$a.class */
    public interface InterfaceC0916a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.f = context;
        this.e = "1";
    }

    public a(Context context, String str) {
        super(context);
        this.f = context;
        this.e = str;
    }

    private void a(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }

    public a a(String str) {
        this.f35776a = str;
        return this;
    }

    public void a(InterfaceC0916a interfaceC0916a) {
        this.g = interfaceC0916a;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public a c(String str) {
        this.f35777c = str;
        return this;
    }

    public a d(String str) {
        this.d = str;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
        if (r3.e.equals("2") != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (r3.e.equals("2") != false) goto L11;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r4) {
        /*
            r3 = this;
            r0 = r4
            com.bytedance.applog.tracker.Tracker.onClick(r0)
            r0 = r4
            int r0 = r0.getId()
            r5 = r0
            r0 = r5
            int r1 = com.tencent.cloud.huiyansdkface.R.id.wbcf_button_right
            if (r0 != r1) goto L37
            r0 = r3
            java.lang.String r0 = r0.e
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L28
        L1c:
            r0 = r3
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a r0 = r0.g
            r0.a()
            goto L65
        L28:
            r0 = r3
            java.lang.String r0 = r0.e
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L65
            goto L4a
        L37:
            r0 = r5
            int r1 = com.tencent.cloud.huiyansdkface.R.id.wbcf_button_left
            if (r0 != r1) goto L65
            r0 = r3
            java.lang.String r0 = r0.e
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L56
        L4a:
            r0 = r3
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a r0 = r0.g
            r0.b()
            goto L65
        L56:
            r0 = r3
            java.lang.String r0 = r0.e
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L65
            goto L1c
        L65:
            r0 = r3
            r0.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.onClick(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a6  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        a(getWindow().getDecorView());
        getWindow().clearFlags(8);
    }
}
