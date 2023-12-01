package com.scwang.smartrefresh.layout.constant;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/constant/DimensionStatus.class */
public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);
    
    public final boolean m;

    DimensionStatus(boolean z) {
        this.m = z;
    }

    public DimensionStatus a() {
        if (this.m) {
            DimensionStatus dimensionStatus = values()[ordinal() - 1];
            return !dimensionStatus.m ? dimensionStatus : DefaultUnNotify;
        }
        return this;
    }

    public boolean a(DimensionStatus dimensionStatus) {
        if (ordinal() >= dimensionStatus.ordinal()) {
            return (!this.m || CodeExact == this) && ordinal() == dimensionStatus.ordinal();
        }
        return true;
    }

    public DimensionStatus b() {
        return !this.m ? values()[ordinal() + 1] : this;
    }
}
