package com.airbnb.lottie.model;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/Marker.class */
public class Marker {
    private static String c = "\r";
    public final float a;
    public final float b;
    private final String d;

    public Marker(String str, float f, float f2) {
        this.d = str;
        this.b = f2;
        this.a = f;
    }

    public boolean a(String str) {
        if (this.d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.d.endsWith(c)) {
            String str2 = this.d;
            return str2.substring(0, str2.length() - 1).equalsIgnoreCase(str);
        }
        return false;
    }
}
