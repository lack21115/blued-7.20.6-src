package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hn.class */
public enum hn {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f571a;

    hn(int i) {
        this.f571a = i;
    }

    public static hn a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}
