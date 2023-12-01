package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.group.GroupNotifyFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgBoxPresent.class */
public class MsgBoxPresent extends MvpPresenter {
    private MsgSessionListener h = new MsgSessionListener();
    private BottomMenuPop i;
    private List<SessionModel> j;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgBoxPresent$MsgSessionListener.class */
    public class MsgSessionListener extends StableSessionListListener {
        public MsgSessionListener() {
        }

        public void onUISessionDataChanged(List<SessionModel> list) {
            ChatHelperV4.a(list, true);
            MsgBoxPresent.this.j = new ArrayList();
            if (list != null) {
                MsgBoxPresent.this.j.addAll(MsgBoxManager.a().a(list, true));
            }
            if (BluedConstant.f14549a) {
                Iterator it = MsgBoxPresent.this.j.iterator();
                while (it.hasNext()) {
                    SessionModel sessionModel = (SessionModel) it.next();
                    if (sessionModel.sessionType == 3) {
                        it.remove();
                    } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2) {
                        it.remove();
                    }
                }
            }
            MsgBoxPresent msgBoxPresent = MsgBoxPresent.this;
            msgBoxPresent.a("session_list", msgBoxPresent.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SessionModel a(int i) {
        if (i < 0 || i >= this.j.size()) {
            return null;
        }
        return this.j.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SessionModel sessionModel, boolean z) {
        if (sessionModel == null) {
            return;
        }
        short s = sessionModel.sessionType;
        LogData logData = new LogData();
        logData.from = "none";
        if (s == 1) {
            if (sessionModel.sessionId != 2) {
                if (sessionModel.sessionId == 5) {
                    ChatHelperV4.a().a(h(), sessionModel.sessionId, sessionModel.maxHasReadMsgID);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("passby_session_id", sessionModel.sessionId);
            bundle.putShort("passby_session_type", (short) 1);
            TerminalActivity.d(h(), GroupNotifyFragment.class, bundle);
        } else if (s != 2) {
            if (s != 3) {
                return;
            }
            ChatHelperV4.a().a((Context) h(), sessionModel.sessionId, sessionModel.nickName, sessionModel.avatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), true);
        } else {
            ChatHelperV4 a2 = ChatHelperV4.a();
            Activity h = h();
            long j = sessionModel.sessionId;
            String str = sessionModel.nickName;
            String str2 = sessionModel.avatar;
            int i = sessionModel.vBadge;
            int i2 = sessionModel.vipGrade;
            int i3 = sessionModel.vipAnnual;
            int i4 = sessionModel.vipExpLvl;
            a2.a((Context) h, j, str, str2, i, i2, i3, i4, sessionModel.lastMsgFromDistance + "", z, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), true);
        }
    }

    public void a(SessionModel sessionModel) {
        if (sessionModel == null) {
            return;
        }
        ChatManager.getInstance().deleteSession(sessionModel.sessionType, sessionModel.sessionId);
    }

    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void b(SessionModel sessionModel) {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 2 || BluedConfig.a().g().is_view_secretly != 0) {
            InstantLog.a("msg_view_secretly_click", 1);
            a(sessionModel, true);
            return;
        }
        InstantLog.a("msg_view_secretly_click", 0);
        PayUtils.a(h(), 6, "chat_msg_quiet_singe");
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        ChatManager.getInstance().registerSessionListener(this.h);
    }

    public void n() {
        ChatManager.getInstance().unregisterSessionListener(this.h);
    }

    public AdapterView.OnItemLongClickListener o() {
        return new AdapterView.OnItemLongClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgBoxPresent.1
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                final SessionModel a2 = MsgBoxPresent.this.a(i - 2);
                if (a2 == null) {
                    return true;
                }
                ArrayList<String> arrayList = new ArrayList();
                if (a2.sessionType == 2) {
                    arrayList.add(AppUtils.a(2131890773));
                    arrayList.add(AppUtils.a((int) R.string.msg_item_delete));
                } else {
                    arrayList.add(AppUtils.a((int) R.string.msg_item_delete));
                }
                ArrayList arrayList2 = new ArrayList();
                for (final String str : arrayList) {
                    BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
                    menuItemInfo.a = str;
                    if (TextUtils.equals(str, AppUtils.a(2131890773))) {
                        menuItemInfo.c = 2131233869;
                    }
                    menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgBoxPresent.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            if (MsgBoxPresent.this.i != null) {
                                MsgBoxPresent.this.i.p();
                            }
                            if (TextUtils.equals(str, AppUtils.a(2131890773))) {
                                MsgBoxPresent.this.b(a2);
                            } else if (TextUtils.equals(str, AppUtils.a((int) R.string.msg_item_delete))) {
                                MsgBoxPresent.this.a(a2);
                            }
                        }
                    };
                    arrayList2.add(menuItemInfo);
                }
                MsgBoxPresent.this.i = new BottomMenuPop(MsgBoxPresent.this.h());
                MsgBoxPresent.this.i.b = arrayList2;
                new XPopup.Builder(MsgBoxPresent.this.h()).a(MsgBoxPresent.this.i).h();
                return true;
            }
        };
    }

    public AdapterView.OnItemClickListener p() {
        return new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgBoxPresent.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                SessionModel a2 = MsgBoxPresent.this.a(i - 2);
                if (a2 != null) {
                    if (BluedPreferences.av()) {
                        MsgBoxPresent.this.b(a2);
                    } else {
                        MsgBoxPresent.this.a(a2, false);
                    }
                }
            }
        };
    }

    public void q() {
        ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>() { // from class: com.soft.blued.ui.msg.presenter.MsgBoxPresent.3
            /* renamed from: a */
            public void onFetchData(final List<SessionModel> list) {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgBoxPresent.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MsgBoxPresent.this.h.onUISessionDataChanged(list);
                    }
                });
            }
        });
    }
}
