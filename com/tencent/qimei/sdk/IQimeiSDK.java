package com.tencent.qimei.sdk;

import android.content.Context;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qimei.sdk.debug.IDebugger;
import com.tencent.qimei.strategy.terminal.ITerminalStrategy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/sdk/IQimeiSDK.class */
public interface IQimeiSDK {
    IQimeiSDK addUserId(String str, String str2);

    String getBeaconTicket();

    IDebugger getDebugger();

    Qimei getQimei();

    void getQimei(IAsyncQimeiListener iAsyncQimeiListener);

    String getSdkVersion();

    ITerminalStrategy getStrategy();

    String getToken();

    boolean init(Context context);

    boolean isQimeiValid(String str, String str2);

    IQimeiSDK setAppVersion(String str);

    IQimeiSDK setChannelID(String str);

    IQimeiSDK setLogAble(boolean z);

    IQimeiSDK setLogObserver(IObservableLog iObservableLog);

    IQimeiSDK setSdkName(String str);
}
