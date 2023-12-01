package com.amap.api.maps.model;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/BaseOptions.class */
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/BaseOptions$BaseUpdateFlags.class */
    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate = false;

        public void reset() {
            this.zIndexUpdate = false;
        }
    }

    protected BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    protected Object method1(Object... objArr) {
        return null;
    }

    protected Object method2(Object... objArr) {
        return null;
    }

    public void resetUpdateFlags() {
    }
}
