package com.blued.android.module.chat;

import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.http.IModuleChatHttp;
import com.blued.android.module.chat.http.ModuleChatHttpUtils;
import com.blued.android.module.chat.manager.SessionDataManager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/ModuleChatConfig.class */
public class ModuleChatConfig {
    private static ModuleChatConfig instance;
    private String TAG = ModuleChatConfig.class.getSimpleName();

    public static ModuleChatConfig getInstance() {
        if (instance == null) {
            instance = new ModuleChatConfig();
        }
        return instance;
    }

    public void setHttpImpl(IModuleChatHttp iModuleChatHttp) {
        ModuleChatHttpUtils.getInstance().setHttpImpl(iModuleChatHttp);
    }

    public void setSessionSettingDBOperImpl(SessionSettingDBOper sessionSettingDBOper) {
        SessionDataManager.getInstance().init(sessionSettingDBOper);
    }
}
