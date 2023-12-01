package com.soft.blued.ui.msg.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/observer/MessageSetSelectedTab.class */
public class MessageSetSelectedTab {

    /* renamed from: a  reason: collision with root package name */
    private static MessageSetSelectedTab f32457a = new MessageSetSelectedTab();
    private List<IMessageSetSelectedTab> b = new ArrayList();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/observer/MessageSetSelectedTab$IMessageSetSelectedTab.class */
    public interface IMessageSetSelectedTab {
    }

    public static MessageSetSelectedTab a() {
        return f32457a;
    }

    public void a(IMessageSetSelectedTab iMessageSetSelectedTab) {
        synchronized (this) {
            if (iMessageSetSelectedTab != null) {
                this.b.add(iMessageSetSelectedTab);
            }
        }
    }

    public void b(IMessageSetSelectedTab iMessageSetSelectedTab) {
        synchronized (this) {
            if (iMessageSetSelectedTab != null) {
                this.b.remove(iMessageSetSelectedTab);
            }
        }
    }
}
