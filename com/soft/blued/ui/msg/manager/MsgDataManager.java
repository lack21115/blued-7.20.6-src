package com.soft.blued.ui.msg.manager;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.soft.blued.BluedConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/MsgDataManager.class */
public class MsgDataManager {

    /* renamed from: a  reason: collision with root package name */
    private List<SessionModel> f32433a = new ArrayList();
    private List<SessionModel> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<SessionModel> f32434c = new ArrayList();
    private List<SessionModel> d = new ArrayList();

    public List<SessionModel> a() {
        return this.b;
    }

    public void a(SessionModel sessionModel) {
        List<SessionModel> list = this.d;
        if (list == null || list.contains(sessionModel)) {
            return;
        }
        this.d.add(sessionModel);
    }

    public void a(List<SessionModel> list) {
        this.f32434c.clear();
        if (list != null) {
            this.f32434c.addAll(list);
        }
    }

    public List<SessionModel> b() {
        return this.d;
    }

    public void b(List<SessionModel> list) {
        this.b.clear();
        if (list != null) {
            this.b.addAll(list);
        }
    }

    public void c() {
        this.d.clear();
    }

    public void c(List<SessionModel> list) {
        this.f32433a.clear();
        if (list != null) {
            this.f32433a.addAll(list);
        }
    }

    public int d(List<SessionModel> list) {
        int i;
        int i2 = 0;
        int i3 = 0;
        if (list.size() > 0) {
            Iterator<SessionModel> it = list.iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                SessionModel next = it.next();
                SessionSettingModel sessionSettingModel = (SessionSettingModel) next.sessionSettingModel;
                if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0) {
                    if (!BluedConstant.f28239a) {
                        i = next.noReadMsgCount;
                    } else if (next.sessionType != 3) {
                        if (next.sessionType != 1) {
                            i = next.noReadMsgCount;
                        } else if (next.sessionId != 2) {
                            i = next.noReadMsgCount;
                        }
                    }
                    i3 += i;
                }
            }
        }
        return i2;
    }

    public List<SessionModel> d() {
        return this.f32433a;
    }

    public List<SessionModel> e() {
        List<SessionModel> list;
        synchronized (this.f32434c) {
            list = this.f32434c;
        }
        return list;
    }
}
