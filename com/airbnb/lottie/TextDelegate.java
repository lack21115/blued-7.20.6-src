package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/TextDelegate.class */
public class TextDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f4266a = new HashMap();
    private boolean d = true;
    private final LottieAnimationView b = null;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f4267c = null;

    TextDelegate() {
    }

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.d && this.f4266a.containsKey(str)) {
            return this.f4266a.get(str);
        }
        String b = b(str);
        if (this.d) {
            this.f4266a.put(str, b);
        }
        return b;
    }
}
