package com.tencent.tendinsv.b;

import com.tencent.tendinsv.utils.r;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static int f25315a;

    public static k a(String str) {
        if (str.equals("SAMSUNG")) {
            f25315a = 10;
        }
        if (str.equals("XIAOMI")) {
            f25315a = 5;
        }
        if (str.equals("BLACKSHARK")) {
            f25315a = 4;
        }
        if (str.equals("IQOO")) {
            f25315a = 1;
        }
        if (str.equals(r.d)) {
            f25315a = 0;
        }
        if (str.equals(r.f)) {
            f25315a = 2;
        }
        if (str.equals("HONOR")) {
            f25315a = 6;
        }
        if (str.equals("MEIZU")) {
            f25315a = 9;
        }
        if (str.equals("REDMI")) {
            f25315a = 3;
        }
        if (str.equals("HUA_WEI")) {
            f25315a = 7;
        }
        if (str.equals("HUAWEI")) {
            f25315a = 8;
        }
        switch (f25315a) {
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
