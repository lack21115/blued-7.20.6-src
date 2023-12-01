package com.youzan.jsbridge.entrance;

import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/entrance/CompatEntrance.class */
public class CompatEntrance extends JsBridgeEntrance {
    public static final String API_CONFIG_NATIVE = "configNative";
    public static final String API_CONFIG_RIGHT_BAR_MENU = "configRightBarItems";
    public static final String API_DO_ACTION = "doAction";
    public static final String API_GET_DATA = "getData";
    public static final String API_GET_USER_INFO = "getUserInfo";
    public static final String API_GOTO_NATIVE = "gotoNative";
    public static final String API_GOTO_WEBVIEW = "gotoWebview";
    public static final String API_PUT_DATA = "putData";
    public static final String API_RETURN_SHARE_DATA = "returnShareData";
    public static final String API_SET_RIGHT_MENU = "setRightMenu";
    public static final String API_TURN_OFF_PULL_DOWN_REFRESH = "turnOffPullDownRefresh";
    public static final String API_WEB_READY = "webReady";
    public static final String ENTRANCE_NAME = "androidJS";

    @Override // com.youzan.jsbridge.entrance.JsBridgeEntrance
    protected String getEntrance() {
        return "androidJS";
    }

    @Override // com.youzan.jsbridge.entrance.JsBridgeEntrance
    protected Set<String> getMethods() {
        HashSet hashSet = new HashSet();
        hashSet.add("getData");
        hashSet.add("putData");
        hashSet.add("doAction");
        hashSet.add("gotoNative");
        hashSet.add("gotoWebview");
        hashSet.add("configNative");
        hashSet.add("setRightMenu");
        hashSet.add("turnOffPullDownRefresh");
        hashSet.add(API_CONFIG_RIGHT_BAR_MENU);
        hashSet.add("webReady");
        hashSet.add("returnShareData");
        hashSet.add("getUserInfo");
        return hashSet;
    }
}
