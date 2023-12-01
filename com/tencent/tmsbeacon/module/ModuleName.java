package com.tencent.tmsbeacon.module;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/ModuleName.class */
public enum ModuleName {
    STRATEGY("com.tencent.tmsbeacon.module.StrategyModule"),
    EVENT("com.tencent.tmsbeacon.module.EventModule"),
    AUDIT("com.tencent.tmsbeacon.module.AuditModule"),
    STAT("com.tencent.tmsbeacon.module.StatModule"),
    QMSP("com.tencent.tmsbeacon.module.QmspModule");
    
    private String className;

    ModuleName(String str) {
        this.className = str;
    }

    public String getClassName() {
        return this.className;
    }
}
