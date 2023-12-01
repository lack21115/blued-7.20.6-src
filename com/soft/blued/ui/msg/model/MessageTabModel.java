package com.soft.blued.ui.msg.model;

import android.content.Context;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.R;
import com.soft.blued.ui.msg.MsgFragment;
import com.soft.blued.ui.notify.fragment.SystemNoticeFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MessageTabModel.class */
public class MessageTabModel {
    private static List<MessageTabModel> tabs;
    public int tabid;
    public String title;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MessageTabModel$MESSAGE_TAB_ID.class */
    public interface MESSAGE_TAB_ID {
        public static final int CHAT = 1;
        public static final int NOTICE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MessageTabModel$MessageTabDef.class */
    public @interface MessageTabDef {
    }

    public MessageTabModel(int i, Context context) {
        this.tabid = i;
        if (i == 0) {
            this.title = context.getResources().getString(R.string.msg_notice_tab);
        } else if (i != 1) {
        } else {
            this.title = context.getResources().getString(R.string.biao_b_chat);
        }
    }

    public static void clearTabs() {
        tabs = null;
    }

    public static List<MessageTabModel> getMessageTabs(Context context) {
        List<MessageTabModel> list = tabs;
        if (list == null || list.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            tabs = arrayList;
            arrayList.add(new MessageTabModel(0, context));
            tabs.add(new MessageTabModel(1, context));
            return tabs;
        }
        return tabs;
    }

    public static int getTabPosition(int i) {
        if (tabs == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= tabs.size()) {
                return -1;
            }
            if (tabs.get(i3).tabid == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public BaseFragment getFragment() {
        int i = this.tabid;
        if (i != 0 && i == 1) {
            return new MsgFragment();
        }
        return new SystemNoticeFragment();
    }
}
