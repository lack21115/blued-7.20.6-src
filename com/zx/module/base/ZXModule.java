package com.zx.module.base;

import com.zx.module.context.ContextHolder;
import com.zx.module.exception.ZXModuleInvokeException;
import com.zx.module.exception.ZXModuleOnCreateException;
import com.zx.module.exception.ZXModuleOnDestroyException;
import com.zx.module.exception.ZXModuleStartException;

/* loaded from: source-8829756-dex2jar.jar:com/zx/module/base/ZXModule.class */
public interface ZXModule {
    String getModuleIdentifier();

    String getModuleVersion();

    String invoke(String str, String str2) throws ZXModuleInvokeException;

    String invokeAsync(String str, String str2, Callback callback) throws ZXModuleInvokeException;

    void onCreate(ContextHolder contextHolder) throws ZXModuleOnCreateException;

    void onDestroy() throws ZXModuleOnDestroyException;

    void setMessageListener(Listener listener);

    void start() throws ZXModuleStartException;
}
