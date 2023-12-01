package com.blued.android.module.base.chat;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/chat/ChatHelperV4Proxy.class */
public class ChatHelperV4Proxy extends BaseProxy<IChatHelperV4> implements IChatHelperV4 {
    private static ChatHelperV4Proxy b;

    private ChatHelperV4Proxy() {
    }

    public static ChatHelperV4Proxy a() {
        if (b == null) {
            synchronized (ChatHelperV4Proxy.class) {
                try {
                    if (b == null) {
                        b = new ChatHelperV4Proxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.chat.IChatHelperV4
    public void b() {
        if (this.f10426a != 0) {
            ((IChatHelperV4) this.f10426a).b();
        }
    }

    @Override // com.blued.android.module.base.chat.IChatHelperV4
    public void c() {
        if (this.f10426a != 0) {
            ((IChatHelperV4) this.f10426a).c();
        }
    }
}
