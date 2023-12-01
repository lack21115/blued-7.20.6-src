package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/FontCharacter.class */
public class FontCharacter {

    /* renamed from: a  reason: collision with root package name */
    private final List<ShapeGroup> f4321a;
    private final char b;

    /* renamed from: c  reason: collision with root package name */
    private final double f4322c;
    private final double d;
    private final String e;
    private final String f;

    public FontCharacter(List<ShapeGroup> list, char c2, double d, double d2, String str, String str2) {
        this.f4321a = list;
        this.b = c2;
        this.f4322c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> a() {
        return this.f4321a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return a(this.b, this.f, this.e);
    }
}
