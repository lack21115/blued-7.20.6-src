package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/SupportInfo.class */
class SupportInfo {
    String a;
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
        return TextUtils.equals(this.a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.a = str;
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
