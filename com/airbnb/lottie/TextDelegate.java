package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/TextDelegate.class */
public class TextDelegate {
    private final Map<String, String> a = new HashMap();
    private boolean d = true;
    private final LottieAnimationView b = null;
    private final LottieDrawable c = null;

    TextDelegate() {
    }

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.d && this.a.containsKey(str)) {
            return this.a.get(str);
        }
        String b = b(str);
        if (this.d) {
            this.a.put(str, b);
        }
        return b;
    }
}
