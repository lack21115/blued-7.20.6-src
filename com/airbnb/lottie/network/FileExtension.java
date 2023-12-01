package com.airbnb.lottie.network;

import com.anythink.china.common.a.a;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/network/FileExtension.class */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    
    public final String c;

    FileExtension(String str) {
        this.c = str;
    }

    public String a() {
        return a.e + this.c;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }
}
