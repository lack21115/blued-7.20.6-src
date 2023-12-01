package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveWishCourtModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.model.RankingHourExtra;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.LiveAnnouceView;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFullModeFragment.class */
public class PlayingOnliveFullModeFragment extends PlayingOnliveBaseModeFragment {
    public static PlayingOnliveFullModeFragment a(short s, long j) {
        return new PlayingOnliveFullModeFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveZanExtraModel liveZanExtraModel) {
        this.q.a(liveZanExtraModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RankingHourExtra rankingHourExtra) {
        if (this.aT == null || rankingHourExtra == null) {
            return;
        }
        this.aT.setHourCountView(rankingHourExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        this.q.f(num.intValue());
    }

    private void ae() {
        LiveEventBus.get("live_ranking_msg", RankingExtra.class).observe(this, new Observer<RankingExtra>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment.2
            /* renamed from: a */
            public void onChanged(RankingExtra rankingExtra) {
                if (LiveRoomManager.a().p() == null) {
                    return;
                }
                LiveRoomManager.a().p().rankingExtra = rankingExtra;
                if (PlayingOnliveFullModeFragment.this.aT == null) {
                    return;
                }
                PlayingOnliveFullModeFragment.this.aT.setValue(rankingExtra);
            }
        });
        LiveEventBus.get("live_ranking_hour_msg", RankingHourExtra.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$swTZInwOb7hKSXnUBvj3yu_DHE0
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.b((RankingHourExtra) obj);
            }
        });
        LiveEventBus.get("live_ranking_hour_count_msg", RankingHourExtra.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$nDaMWvZQPnbfObtDscma1QlixDU
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.a((RankingHourExtra) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.b, LiveChattingModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$XG3L1_o4YxpqKFcdNLXgSDjQ1WE
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.e((LiveChattingModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.e, Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$mXbo7rQLp1Imd4ani94X9WiBY4g
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.e(((Boolean) obj).booleanValue());
            }
        });
        LiveEventBus.get(LiveEventBusUtil.f, LiveZanExtraModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$iYuWc0VVIpBapqQ7yLkWJW1nE5M
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.a((LiveZanExtraModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.g, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$ldpsEHkGYd0whIZF9xVb61OqTgU
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.a((Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.q, LiveAnnounceModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$DSgP5plCLIdIg2Vg2iUyuVJAJeQ
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.b((LiveAnnounceModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.z, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$Kyy4d5AK4hSaXKInTLuoK_o79yY
            public final void onChanged(Object obj) {
                PlayingOnliveFullModeFragment.this.i((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void af() {
        if (this.v) {
            return;
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(RankingHourExtra rankingHourExtra) {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        LiveRoomManager.a().p().rankingHourExtra = rankingHourExtra;
        if (this.aT == null) {
            return;
        }
        this.aT.a(rankingHourExtra.rank, rankingHourExtra.need_score);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return;
        }
        if (this.q != null) {
            this.q.g(liveChattingModel);
        }
        d(liveChattingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        if (z) {
            this.I.setVisibility(4);
        } else {
            this.I.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str) {
        if (this.aQ != null) {
            this.aQ.a(str);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D() {
        super.D();
        this.q.m();
        this.q.o();
        this.l.c();
        this.d.setVisibility(0);
        this.q.d(0);
        this.m.setVisibility(0);
        if (this.aP != null) {
            this.aP.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.manager.PlayGifObserver.IPlayGifObserver
    public void F() {
        if (PlayingOnliveFragment.cB != 1 || this.v) {
            return;
        }
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFullModeFragment$BkzWsxOXl-9SJ8PBJsz5tCJKQTY
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFullModeFragment.this.af();
            }
        });
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H() {
        if (PlayingOnliveFragment.cB == 1) {
            LiveMsgSendManager.a().e();
            LiveRoomHttpUtils.a(String.valueOf(this.s));
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void N() {
        super.N();
        if (PlayingOnliveFragment.cB != 1 || LiveRoomManager.a().t()) {
            return;
        }
        LiveRoomInfo a = LiveRoomInfo.a();
        Context context = this.a;
        String g = LiveRoomManager.a().g();
        a.a(context, this, g, "liveanchor_" + this.s, getFragmentActive());
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(EditText editText, boolean z, SendMsgListener sendMsgListener) {
        super.a(editText, z, sendMsgListener);
        LiveMsgSendManager.a().a(editText.getText().toString(), z, sendMsgListener);
    }

    /* renamed from: a */
    public void b(LiveAnnounceModel liveAnnounceModel) {
        if (liveAnnounceModel == null) {
            this.aR.b();
        } else if (this.aR != null) {
            this.aR.a(liveAnnounceModel.notice_content);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveChattingModel liveChattingModel) {
        if (PlayingOnliveFragment.cB == 1) {
            this.q.c(liveChattingModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
        super.a(liveHornModelNew, z);
        if (PlayingOnliveFragment.cB != 1 || liveHornModelNew == null) {
            return;
        }
        if (liveHornModelNew.position == 1) {
            if (this.m != null) {
                this.m.a(liveHornModelNew, z);
            }
        } else if (liveHornModelNew.position != 2 || this.n == null) {
        } else {
            this.n.a(liveHornModelNew);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomData liveRoomData) {
        super.a(liveRoomData);
        if (this.aQ != null) {
            this.aQ.setData(liveRoomData.custom_rank);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment
    public void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel) {
        super.a(liveRoomFunctionItemModel);
        if (liveRoomFunctionItemModel == null || TextUtils.isEmpty(liveRoomFunctionItemModel.getLink())) {
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomUserModel liveRoomUserModel) {
        if (this.q != null) {
            this.q.a(liveRoomUserModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, String str2) {
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z) {
        super.a(z);
        this.q.l();
        this.q.n();
        this.l.b();
        this.q.d(8);
        this.d.setVisibility(8);
        this.m.setVisibility(8);
        if (this.aP != null) {
            this.aP.setVisibility(8);
        }
    }

    public PlayingOnliveFragment ad() {
        return (PlayingOnliveFragment) getParentFragment();
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(int i) {
        this.q.a(i);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveChattingModel liveChattingModel) {
        if (PlayingOnliveFragment.cB == 1) {
            this.q.d(liveChattingModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveGiftModel liveGiftModel) {
        if (PlayingOnliveFragment.cB == 1) {
            this.q.e(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveRoomData liveRoomData) {
        if (this.q != null) {
            this.q.a(liveRoomData);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment
    protected boolean b() {
        return PlayingOnliveFragment.cB == 1;
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b_(String str) {
        if (this.q != null) {
            this.q.b(str);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveGiftModel liveGiftModel) {
        if (PlayingOnliveFragment.cB == 1) {
            d(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(String str, int i) {
        if (this.q != null) {
            this.q.a(str, i);
        }
    }

    public void d(LiveChattingModel liveChattingModel) {
        short s = liveChattingModel.msgType;
        if (s == 247) {
            if (!(liveChattingModel instanceof LiveChattingModel) || this.aQ == null) {
                return;
            }
            DefinedRankInfo definedRankInfo = (DefinedRankInfo) LiveChattingModel.copy(liveChattingModel).getObjExtra();
            this.aQ.setData(definedRankInfo);
            LiveRoomManager.a().p().custom_rank = definedRankInfo;
        } else if (s == 252 && (liveChattingModel instanceof LiveChattingModel) && this.aN != null) {
            LiveWishCourtModel liveWishCourtModel = (LiveWishCourtModel) LiveChattingModel.copy(liveChattingModel).getObjExtra();
            this.aN.a(EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue(), liveWishCourtModel);
            ad().a((HTMLNoticeModel) liveWishCourtModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment
    public void f() {
        super.f();
        this.aP = this.b.findViewById(R.id.ll_icons_top_right);
        this.aR = (LiveAnnouceView) this.b.findViewById(R.id.live_annoce);
        if (this.P != null) {
            ImageLoader.c(null, "img_live_recommend.png").g(-1).e(this.P.getId()).a(this.P);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(String str) {
        super.g(str);
        if (PlayingOnliveFragment.cB == 1) {
            LiveMsgSendManager.a().a(str);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void h(String str) {
        super.h(str);
        Logger.a("rrb", "setReplyClick name = ", str);
        if (!TextUtils.isEmpty(str) && PlayingOnliveFragment.cB == 1) {
            String str2 = this.S.getText().toString() + "@" + str + " ";
            int length = str2.length();
            this.S.setText(str2);
            this.S.setSelection(length);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayingOnliveFullModeFragment.this.S != null) {
                        PlayingOnliveFullModeFragment.this.S.setFocusableInTouchMode(true);
                        PlayingOnliveFullModeFragment.this.S.requestFocus();
                    }
                    KeyboardUtils.c(PlayingOnliveFullModeFragment.this.getActivity());
                    Logger.a("rrb", "setReplyClick end");
                }
            }, 500L);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = false;
        ae();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        X();
        Y();
        LiveEventBus.get("live_msg_daily_task_complete", Integer.class).observe(this, new Observer<Integer>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment.1
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (PlayingOnliveFullModeFragment.this.q != null) {
                    PlayingOnliveFullModeFragment.this.q.c(num.intValue());
                }
            }
        });
        return onCreateView;
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        Z();
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void q() {
        if (this.q != null) {
            this.q.f();
        }
    }
}
