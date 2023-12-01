package com.youzan.jsbridge.entrance;

import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/entrance/CommonEntrance.class */
public class CommonEntrance extends JsBridgeEntrance {
    public static final String ENTRANCE_NAME = "YZAndroidJS";

    @Override // com.youzan.jsbridge.entrance.JsBridgeEntrance
    protected String getEntrance() {
        return "YZAndroidJS";
    }

    @Override // com.youzan.jsbridge.entrance.JsBridgeEntrance
    protected Set<String> getMethods() {
        HashSet hashSet = new HashSet();
        hashSet.add("doCall");
        return hashSet;
    }
}
