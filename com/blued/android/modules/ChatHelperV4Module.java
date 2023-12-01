package com.blued.android.modules;

import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.base.chat.IChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/ChatHelperV4Module.class */
public class ChatHelperV4Module {

    /* renamed from: a  reason: collision with root package name */
    static IChatHelperV4 f18624a = new IChatHelperV4() { // from class: com.blued.android.modules.ChatHelperV4Module.1
        @Override // com.blued.android.module.base.chat.IChatHelperV4
        public void b() {
            ChatHelperV4.a().e();
        }

        @Override // com.blued.android.module.base.chat.IChatHelperV4
        public void c() {
            ChatHelperV4.a().d();
        }
    };

    public static void a() {
        ChatHelperV4Proxy.a().a(f18624a);
    }
}
