package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.community.model.FeedNotice;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/MsgAttentionNotifyFragment_MVP.class */
public final class MsgAttentionNotifyFragment_MVP implements MvpDispatcher {
    private void a(MsgAttentionNotifyFragment msgAttentionNotifyFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != 1243180967) {
            if (hashCode == 2071979985 && str.equals("SHOW_LOAD_ERROR")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("ATTENTION_NOTICE_CLEAR")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            msgAttentionNotifyFragment.b();
        } else if (!z) {
        } else {
            msgAttentionNotifyFragment.c();
        }
    }

    public void a(MvpFragment mvpFragment, String str, List list) {
        MsgAttentionNotifyFragment msgAttentionNotifyFragment = (MsgAttentionNotifyFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != 1980030948 || !str.equals("ATTENTION_NOTICE_LIST")) {
                    z = true;
                }
                if (!z && FeedNotice.class.isInstance(obj)) {
                    msgAttentionNotifyFragment.a(list);
                    return;
                }
            }
        }
        a(msgAttentionNotifyFragment, str);
    }
}
