package com.soft.blued.ui.msg.observer;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/observer/RecvMsgListenerObserver.class */
public class RecvMsgListenerObserver {

    /* renamed from: a  reason: collision with root package name */
    private static RecvMsgListenerObserver f32458a;
    private ArrayList<IRecvMsgListener> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/observer/RecvMsgListenerObserver$IRecvMsgListener.class */
    public interface IRecvMsgListener {
        void a(SessionModel sessionModel, ChattingModel chattingModel);
    }

    private RecvMsgListenerObserver() {
    }

    public static RecvMsgListenerObserver a() {
        if (f32458a == null) {
            synchronized (RecvMsgListenerObserver.class) {
                try {
                    if (f32458a == null) {
                        f32458a = new RecvMsgListenerObserver();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f32458a;
    }

    public void a(SessionModel sessionModel, ChattingModel chattingModel) {
        Iterator<IRecvMsgListener> it = this.b.iterator();
        while (it.hasNext()) {
            IRecvMsgListener next = it.next();
            if (next != null) {
                next.a(sessionModel, chattingModel);
            }
        }
    }
}
