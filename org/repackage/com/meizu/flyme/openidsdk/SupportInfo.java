package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/SupportInfo.class */
public class SupportInfo {

    /* renamed from: a  reason: collision with root package name */
    String f44109a;
    Boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f44109a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.f44109a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
