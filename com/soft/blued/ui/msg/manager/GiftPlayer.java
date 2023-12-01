package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import android.view.ViewStub;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.common.db.ChattingDao;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.j256.ormlite.stmt.QueryBuilder;
import com.soft.blued.ui.msg.customview.GiftPlayView;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;
import java.sql.SQLException;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/GiftPlayer.class */
public class GiftPlayer {

    /* renamed from: a  reason: collision with root package name */
    public static final String f32415a = GiftPlayer.class.getSimpleName();
    private ViewStub b;

    /* renamed from: c  reason: collision with root package name */
    private SessionModel f32416c;
    private GiftPlayView d;
    private long e;

    public GiftPlayer(ViewStub viewStub, long j) {
        this.b = viewStub;
        this.e = j;
    }

    private void a(final long j) {
        this.f32416c.unreadGiftCnt = 0;
        ChatManager.getInstance().updateSessionUnreadGiftCnt(this.f32416c.sessionType, this.f32416c.sessionId, 0, this.f32416c.lastMsgId);
        ThreadManager.a().a(new ThreadExecutor("findAndPlayAnimation") { // from class: com.soft.blued.ui.msg.manager.GiftPlayer.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                QueryBuilder<ChattingModelDB, Integer> queryBuilder = ChattingDao.a().b().queryBuilder();
                try {
                    queryBuilder.where().eq("fromId", Long.valueOf(GiftPlayer.this.f32416c.sessionId)).and().eq(RemoteMessageConst.MSGID, Long.valueOf(j));
                    final List<ChattingModelDB> query = queryBuilder.query();
                    if (query == null || query.size() <= 0) {
                        return;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.manager.GiftPlayer.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GiftPlayer.this.b() != null) {
                                GiftPlayer.this.b().a((MsgExtraGift) AppInfo.f().fromJson(((ChattingModelDB) query.get(0)).getMsgExtra(), (Class<Object>) MsgExtraGift.class));
                            }
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                    Logger.e("GiftPlayer", "SQLException===" + e.getMessage());
                }
            }
        });
    }

    public long a() {
        return this.e;
    }

    public void a(ChattingModel chattingModel) {
        if (b() != null) {
            b().a((MsgExtraGift) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgExtraGift.class));
        }
    }

    public void a(SessionModel sessionModel) {
        this.f32416c = sessionModel;
        if (sessionModel == null || sessionModel.unreadGiftCnt == 0) {
            return;
        }
        a(sessionModel.lastGiftMsgId);
    }

    public void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        if ((giftGivingOptionForJsonParse == null || b() != null) && !TextUtils.isEmpty(giftGivingOptionForJsonParse.effects)) {
            MsgExtraGift msgExtraGift = new MsgExtraGift();
            msgExtraGift.gift_like = new MsgExtraGift.GiftInfo();
            msgExtraGift.gift_like.giftTye = giftGivingOptionForJsonParse.type;
            msgExtraGift.gift_like.giftId = giftGivingOptionForJsonParse.gift_id;
            msgExtraGift.gift_like.gift_url = giftGivingOptionForJsonParse.effects;
            msgExtraGift.gift_like.gift_name_cn = giftGivingOptionForJsonParse.gift_name_cn;
            msgExtraGift.gift_like.gift_name_en = giftGivingOptionForJsonParse.gift_name_en;
            msgExtraGift.gift_like.gift_name_tw = giftGivingOptionForJsonParse.gift_name_tw;
            msgExtraGift.gift_like.cardGift = giftGivingOptionForJsonParse.extra_info;
            b().a(msgExtraGift);
        }
    }

    public GiftPlayView b() {
        ViewStub viewStub;
        if (this.d == null && (viewStub = this.b) != null) {
            this.d = (GiftPlayView) viewStub.inflate();
        }
        return this.d;
    }

    public void b(ChattingModel chattingModel) {
        a(chattingModel);
        SessionModel sessionModel = this.f32416c;
        if (sessionModel != null) {
            sessionModel.unreadGiftCnt = 0;
            this.f32416c.lastGiftMsgId = chattingModel.msgId;
            ChatManager.getInstance().updateSessionUnreadGiftCnt(this.f32416c.sessionType, this.f32416c.sessionId, 0, chattingModel.msgId);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.e == ((GiftPlayer) obj).e;
    }

    public int hashCode() {
        return (int) this.e;
    }
}
