package com.tencent.tendinsv.b;

import com.tencent.tendinsv.utils.r;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static int f39006a;

    public static k a(String str) {
        if (str.equals("SAMSUNG")) {
            f39006a = 10;
        }
        if (str.equals("XIAOMI")) {
            f39006a = 5;
        }
        if (str.equals("BLACKSHARK")) {
            f39006a = 4;
        }
        if (str.equals("IQOO")) {
            f39006a = 1;
        }
        if (str.equals(r.d)) {
            f39006a = 0;
        }
        if (str.equals(r.f)) {
            f39006a = 2;
        }
        if (str.equals("HONOR")) {
            f39006a = 6;
        }
        if (str.equals("MEIZU")) {
            f39006a = 9;
        }
        if (str.equals("REDMI")) {
            f39006a = 3;
        }
        if (str.equals("HUA_WEI")) {
            f39006a = 7;
        }
        if (str.equals("HUAWEI")) {
            f39006a = 8;
        }
        switch (f39006a) {
            case 0:
                return new j();
            case 1:
            case 2:
                return new n();
            case 3:
            case 4:
            case 5:
                return new c();
            case 6:
            case 7:
            case 8:
                return new a();
            case 9:
                return new d();
            case 10:
                return new m();
            default:
                return null;
        }
    }
}
