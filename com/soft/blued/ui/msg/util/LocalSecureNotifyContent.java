package com.soft.blued.ui.msg.util;

import android.content.res.Resources;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/LocalSecureNotifyContent.class */
public class LocalSecureNotifyContent {
    public static MsgExtraForTextTypeEntity.SecureNotify a(Resources resources) {
        MsgExtraForTextTypeEntity.SecureNotify secureNotify = new MsgExtraForTextTypeEntity.SecureNotify();
        secureNotify.notify_type = 1;
        secureNotify.link = "http://native.blued.cn?action=store_yz&linkId=47&url=https%3A%2F%2Fj.youzan.com%2FmprqSL";
        ArrayList arrayList = new ArrayList(3);
        arrayList.add("");
        arrayList.add(resources.getString(R.string.msg_secure_notify_highlight_keywords));
        arrayList.add("");
        secureNotify.highlight_keywords = arrayList;
        ArrayList arrayList2 = new ArrayList(2);
        MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = new MsgExtraForTextTypeEntity.SecureNotify.SecureContent();
        secureContent.title = resources.getString(R.string.msg_secure_notify_1_title);
        secureContent.body = resources.getString(R.string.msg_secure_notify_1_body);
        arrayList2.add(secureContent);
        MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent2 = new MsgExtraForTextTypeEntity.SecureNotify.SecureContent();
        secureContent2.title = resources.getString(R.string.msg_secure_notify_2_title);
        secureContent2.body = resources.getString(R.string.msg_secure_notify_2_body);
        secureContent2.link_title = resources.getString(R.string.msg_secure_notify_2_link_title);
        secureContent2.link = "http://native.blued.cn?action=store_yz&url=https%3A%2F%2Fj.youzan.com%2F3tSZP8";
        arrayList2.add(secureContent2);
        secureNotify.multi_contents = arrayList2;
        return secureNotify;
    }
}
