package com.tencent.beacon.module;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/module/ModuleName.class */
public enum ModuleName {
    STRATEGY("com.tencent.beacon.module.StrategyModule"),
    EVENT("com.tencent.beacon.module.EventModule"),
    AUDIT("com.tencent.beacon.module.AuditModule"),
    STAT("com.tencent.beacon.module.StatModule"),
    QMSP("com.tencent.beacon.module.QmspModule");
    
    private String className;

    ModuleName(String str) {
        this.className = str;
    }

    public String getClassName() {
        return this.className;
    }
}
