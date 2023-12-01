package com.airbnb.lottie.model;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/Marker.class */
public class Marker {

    /* renamed from: c  reason: collision with root package name */
    private static String f4325c = "\r";

    /* renamed from: a  reason: collision with root package name */
    public final float f4326a;
    public final float b;
    private final String d;

    public Marker(String str, float f, float f2) {
        this.d = str;
        this.b = f2;
        this.f4326a = f;
    }

    public boolean a(String str) {
        if (this.d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.d.endsWith(f4325c)) {
            String str2 = this.d;
            return str2.substring(0, str2.length() - 1).equalsIgnoreCase(str);
        }
        return false;
    }
}
