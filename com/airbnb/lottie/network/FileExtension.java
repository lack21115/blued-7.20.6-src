package com.airbnb.lottie.network;

import com.anythink.china.common.a.a;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/network/FileExtension.class */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    

    /* renamed from: c  reason: collision with root package name */
    public final String f4394c;

    FileExtension(String str) {
        this.f4394c = str;
    }

    public String a() {
        return a.e + this.f4394c;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4394c;
    }
}
