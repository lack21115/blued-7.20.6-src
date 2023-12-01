package com.blued.android.module.live_china.manager;

import android.os.Handler;
import android.text.TextUtils;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGuideModel;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGuideListManager.class */
public class LiveGuideListManager {
    private LiveBaseFragment a;
    private boolean b;
    private Handler c = new Handler();
    private List<LiveGuideModel> d = new ArrayList();
    private boolean e = true;
    private List<LiveChattingModel> f = new ArrayList();

    public LiveGuideListManager(LiveBaseFragment liveBaseFragment, boolean z) {
        this.a = liveBaseFragment;
        this.b = z;
        a();
        c();
    }

    private void a(final LiveChattingModel liveChattingModel) {
        if (this.e) {
            if (this.f == null) {
                this.f = new ArrayList();
            }
            this.f.add(liveChattingModel);
        } else if (liveChattingModel.msgId <= 0) {
            LiveMsgSendManager.a().a(liveChattingModel);
        } else {
            long j = liveChattingModel.msgId;
            liveChattingModel.msgId = 0L;
            this.d.add(new LiveGuideModel());
            Handler handler = this.c;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveGuideListManager$tmQKXVh93d1CYF55o4U779qObBw
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveGuideListManager.b(LiveChattingModel.this);
                    }
                }, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveGuideModel> list) {
        if (this.c == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        for (LiveGuideModel liveGuideModel : list) {
            c(liveGuideModel);
        }
    }

    private LiveChattingModel b(String str) {
        if (this.b || !(LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null)) {
            long g = this.b ? LiveRoomInfo.a().g() : LiveRoomManager.a().f();
            String c = this.b ? LiveRoomInfo.a().c() : LiveRoomManager.a().p().profile.name;
            String d = this.b ? LiveRoomInfo.a().d() : LiveRoomManager.a().p().profile.avatar;
            int r = this.b ? LiveRoomInfo.a().r() : LiveRoomManager.a().p().anchor_rich_level;
            SessionProfileModel sessionProfileModel = new SessionProfileModel();
            sessionProfileModel.nickname = c;
            sessionProfileModel.avatar = d;
            LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().d(), (short) 1, str, sessionProfileModel, "", LiveRoomManager.a().j()));
            copy.fromId = g;
            copy.fromNickName = c;
            copy.fromRichLevel = r;
            return copy;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(LiveChattingModel liveChattingModel) {
        LiveMsgSendManager.a().a(liveChattingModel);
    }

    private void b(final LiveGuideModel liveGuideModel) {
        if (this.d == null || liveGuideModel == null) {
            return;
        }
        liveGuideModel.task = new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveGuideListManager$5in9xQKNY9rpAumrTwg5l9ly0Jk
            @Override // java.lang.Runnable
            public final void run() {
                LiveGuideListManager.this.j(liveGuideModel);
            }
        };
        if (this.c.postDelayed(liveGuideModel.task, liveGuideModel.getNextTime())) {
            this.d.add(liveGuideModel);
        }
    }

    private void c() {
        LiveRoomHttpUtils.E(new BluedUIHttpResponse<BluedEntityA<LiveGuideModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.LiveGuideListManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGuideModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                LiveGuideListManager.this.a(bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LiveGuideModel liveGuideModel) {
        if (liveGuideModel == null || !d(liveGuideModel)) {
            return;
        }
        int i = (liveGuideModel.getNextTime() > 0L ? 1 : (liveGuideModel.getNextTime() == 0L ? 0 : -1));
        if (i == 0 && !liveGuideModel.is_grpc) {
            f(liveGuideModel);
        } else if (i > 0 || liveGuideModel.is_grpc) {
            b(liveGuideModel);
        }
    }

    private void d() {
        List<LiveChattingModel> list = this.f;
        if (list != null) {
            list.clear();
        }
        List<LiveGuideModel> list2 = this.d;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        for (LiveGuideModel liveGuideModel : this.d) {
            if (liveGuideModel != null && liveGuideModel.task != null) {
                this.c.removeCallbacks(liveGuideModel.task);
                AppInfo.n().removeCallbacks(liveGuideModel.task);
            }
        }
        this.d.clear();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean d(LiveGuideModel liveGuideModel) {
        boolean z;
        String guideType = liveGuideModel.getGuideType();
        int hashCode = guideType.hashCode();
        if (hashCode == 47571) {
            if (guideType.equals(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE)) {
                z = false;
            }
            z = true;
        } else if (hashCode == 48532) {
            if (guideType.equals(LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE)) {
                z = true;
            }
            z = true;
        } else if (hashCode != 50454) {
            switch (hashCode) {
                case 49494:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49495:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49496:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49497:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49498:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_HOST_WELCOME)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        } else {
            if (guideType.equals(LiveGuideType.GUIDE_TYPE_HOST_LIVE_NOTICE)) {
                z = true;
            }
            z = true;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(LiveGuideModel liveGuideModel) {
        liveGuideModel.task = null;
        if (liveGuideModel.count > 1) {
            liveGuideModel.count--;
        } else if (liveGuideModel.count == 1) {
            liveGuideModel.count = -1L;
        }
        if (liveGuideModel.countdown > 0) {
            liveGuideModel.countdown = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(LiveGuideModel liveGuideModel) {
        LiveChattingModel b;
        if (liveGuideModel == null) {
            return;
        }
        String guideType = liveGuideModel.getGuideType();
        boolean z = true;
        int hashCode = guideType.hashCode();
        if (hashCode != 49498) {
            if (hashCode == 50454 && guideType.equals(LiveGuideType.GUIDE_TYPE_HOST_LIVE_NOTICE)) {
                z = false;
            }
        } else if (guideType.equals(LiveGuideType.GUIDE_TYPE_HOST_WELCOME)) {
            z = true;
        }
        if (!z) {
            String i = i(liveGuideModel);
            if (TextUtils.isEmpty(i)) {
                return;
            }
            b = b(i);
            b.msgId = 1000L;
        } else if (!z) {
            b = h(liveGuideModel);
        } else {
            b = g(liveGuideModel);
            b.msgId = 1500L;
        }
        if (b == null) {
            return;
        }
        a(b);
        a(liveGuideModel.id);
        e(liveGuideModel);
    }

    private LiveChattingModel g(LiveGuideModel liveGuideModel) {
        return b(liveGuideModel.content);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private LiveChattingModel h(LiveGuideModel liveGuideModel) {
        boolean z;
        String guideType = liveGuideModel.getGuideType();
        int hashCode = guideType.hashCode();
        if (hashCode == 47571) {
            if (guideType.equals(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE)) {
                z = false;
            }
            z = true;
        } else if (hashCode != 48532) {
            switch (hashCode) {
                case 49494:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49495:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49496:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 49497:
                    if (guideType.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        } else {
            if (guideType.equals(LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE)) {
                z = true;
            }
            z = true;
        }
        LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().d(), z ? !z ? (z || z || z || z) ? (short) -10006 : (short) -1 : (short) -10005 : (short) -10004, liveGuideModel.content, null, "", LiveRoomManager.a().j()));
        copy.msgMapExtra = new HashMap();
        copy.msgMapExtra.put("guideType", liveGuideModel.getGuideType());
        if (LiveGuideType.GUIDE_TYPE_MARKETING_CAMPAIGN_NOTICE.equals(liveGuideModel.getGuideType())) {
            copy.msgMapExtra.put("url", liveGuideModel.url);
        }
        return copy;
    }

    private String i(LiveGuideModel liveGuideModel) {
        LiveAnnounceInfoModel liveAnnounceInfoModel;
        if (liveGuideModel == null) {
            return "";
        }
        if (TextUtils.isEmpty(liveGuideModel.extra)) {
            return !TextUtils.isEmpty(liveGuideModel.content) ? liveGuideModel.content : "";
        }
        try {
            liveAnnounceInfoModel = (LiveAnnounceInfoModel) AppInfo.f().fromJson(liveGuideModel.extra, LiveAnnounceInfoModel.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            liveAnnounceInfoModel = null;
        }
        if (liveAnnounceInfoModel == null || liveAnnounceInfoModel.controller != 1) {
            return "";
        }
        String a = liveAnnounceInfoModel.live_time_controller == 1 ? LiveUtils.a(liveAnnounceInfoModel) : "";
        String str = liveAnnounceInfoModel.notice_controller == 1 ? liveAnnounceInfoModel.notice : "";
        if (TextUtils.isEmpty(a) && TextUtils.isEmpty(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(a) && TextUtils.isEmpty(str)) {
            return a + "直播";
        } else if (!TextUtils.isEmpty(a) || TextUtils.isEmpty(str)) {
            return a + "直播，" + liveAnnounceInfoModel.notice;
        } else {
            return liveAnnounceInfoModel.notice;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final LiveGuideModel liveGuideModel) {
        a(liveGuideModel.id);
        LiveRoomHttpUtils.a(Integer.valueOf(liveGuideModel.id), Integer.valueOf(liveGuideModel.type), Integer.valueOf(liveGuideModel.sub_type), liveGuideModel.content, new BluedUIHttpResponse<BluedEntityA<LiveGuideModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.LiveGuideListManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGuideModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    LiveGuideListManager.this.e(liveGuideModel);
                    if (liveGuideModel.is_grpc && liveGuideModel.getNextTime() == 0) {
                        LiveGuideListManager.this.a(liveGuideModel.id);
                        return;
                    } else {
                        LiveGuideListManager.this.c(liveGuideModel);
                        return;
                    }
                }
                LiveGuideModel singleData = bluedEntityA.getSingleData();
                if (singleData.is_send) {
                    if (!TextUtils.isEmpty(singleData.content)) {
                        liveGuideModel.content = singleData.content;
                    }
                    if (!TextUtils.isEmpty(singleData.url)) {
                        liveGuideModel.url = singleData.url;
                    }
                    LiveGuideListManager.this.f(liveGuideModel);
                    if (liveGuideModel.is_grpc && liveGuideModel.getNextTime() == 0) {
                        LiveGuideListManager.this.a(liveGuideModel.id);
                    } else {
                        LiveGuideListManager.this.c(liveGuideModel);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveGuideListManager.this.e(liveGuideModel);
                if (liveGuideModel.is_grpc && liveGuideModel.getNextTime() == 0) {
                    LiveGuideListManager.this.a(liveGuideModel.id);
                    return true;
                }
                LiveGuideListManager.this.c(liveGuideModel);
                return true;
            }
        });
    }

    public void a() {
        d();
        this.c.removeCallbacksAndMessages(null);
    }

    public void a(int i) {
        List<LiveGuideModel> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.size()) {
                return;
            }
            LiveGuideModel liveGuideModel = this.d.get(i3);
            if (liveGuideModel != null && liveGuideModel.id == i && liveGuideModel.task != null) {
                this.c.removeCallbacks(liveGuideModel.task);
                AppInfo.n().removeCallbacks(liveGuideModel.task);
                liveGuideModel.task = null;
                this.d.remove(i3);
            }
            i2 = i3 + 1;
        }
    }

    public void a(LiveGuideModel liveGuideModel) {
        liveGuideModel.is_grpc = true;
        c(liveGuideModel);
    }

    public void a(String str) {
        List<LiveGuideModel> list = this.d;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            LiveGuideModel liveGuideModel = this.d.get(i2);
            int i3 = i2;
            if (liveGuideModel != null) {
                i3 = i2;
                if (str.equals(liveGuideModel.getGuideType())) {
                    i3 = i2;
                    if (liveGuideModel.task != null) {
                        this.c.removeCallbacks(liveGuideModel.task);
                        AppInfo.n().removeCallbacks(liveGuideModel.task);
                        liveGuideModel.task = null;
                        this.d.remove(i2);
                        i3 = i2 - 1;
                    }
                }
            }
            i = i3 + 1;
        }
    }

    public void b() {
        this.e = false;
        List<LiveChattingModel> list = this.f;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (LiveChattingModel liveChattingModel : this.f) {
            a(liveChattingModel);
        }
    }
}
