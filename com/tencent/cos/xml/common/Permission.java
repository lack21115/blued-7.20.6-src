package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/Permission.class */
public enum Permission {
    READ("READ"),
    WRITE("WRITE"),
    FULL_CONTROL("FULL_CONTROL");
    
    private String permission;

    Permission(String str) {
        this.permission = str;
    }

    public static Permission fromValue(String str) {
        Permission[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Permission permission = values[i2];
            if (permission.permission.equalsIgnoreCase(str)) {
                return permission;
            }
            i = i2 + 1;
        }
    }

    public String getPermission() {
        return this.permission;
    }
}
