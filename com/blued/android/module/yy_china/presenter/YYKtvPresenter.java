package com.blued.android.module.yy_china.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.ISongScoreListener;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicDetailModel;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.BaseConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.PlayingStudioFragment;
import com.blued.android.module.yy_china.fragment.YYKtvGorgeousPrizeDialog;
import com.blued.android.module.yy_china.fragment.YYKtvMusicCenterDialog;
import com.blued.android.module.yy_china.fragment.YYKtvPrizeDialog;
import com.blued.android.module.yy_china.manager.YYGiftManager;
import com.blued.android.module.yy_china.manager.YYKtvMusicManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYConfiguredResourcesModel;
import com.blued.android.module.yy_china.model.YYKtvStageModel;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMsgKtvPrize;
import com.blued.android.module.yy_china.model.YYMsgKtvSinger;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcSongScoreModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.DialogKtvCommonView;
import com.blued.android.module.yy_china.view.YYKtvBroadcastView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYKtvPresenter.class */
public final class YYKtvPresenter extends AbstractBasePresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYKtvPresenter(BaseYYStudioFragment fragment) {
        super(fragment);
        Intrinsics.e(fragment, "fragment");
        if (YYRoomInfoManager.e().h == null) {
            YYRoomInfoManager.e().h = new YYKtvMusicManager();
        }
        k();
    }

    private final void a(BaseYYStudioFragment baseYYStudioFragment) {
        Fragment findFragmentByTag = baseYYStudioFragment.getParentFragmentManager().findFragmentByTag("give_up_dialog");
        if (findFragmentByTag != null) {
            try {
                ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
            } catch (Exception e) {
            }
        }
        Fragment findFragmentByTag2 = baseYYStudioFragment.getParentFragmentManager().findFragmentByTag("confirm_dialog");
        if (findFragmentByTag2 == null) {
            return;
        }
        try {
            ((DialogFragment) findFragmentByTag2).dismissAllowingStateLoss();
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, TrtcMusicModel trtcMusicModel) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
        if (baseConnectingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
        }
        ((YYSeatKTVAdapter) baseConnectingAdapter).a(trtcMusicModel.curPtsMS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, YYKtvStageModel yYKtvStageModel) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.T.setVisibility(yYKtvStageModel.status == 1 ? 0 : 8);
        if (baseYYStudioFragment.E instanceof YYSeatKTVAdapter) {
            BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).a(yYKtvStageModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, YYMsgKtvMusic yYMsgKtvMusic) {
        YYRoomModel b;
        YYMsgKtvMusic yYMsgKtvMusic2;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null || (b = YYRoomInfoManager.e().b()) == null || (yYMsgKtvMusic2 = b.music) == null) {
            return;
        }
        LiveLogUtils.a("KTV开始");
        BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
        if (baseConnectingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
        }
        ((YYSeatKTVAdapter) baseConnectingAdapter).f();
        BaseConnectingAdapter baseConnectingAdapter2 = baseYYStudioFragment.E;
        if (baseConnectingAdapter2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
        }
        ((YYSeatKTVAdapter) baseConnectingAdapter2).g();
        this$0.a(yYMsgKtvMusic2.dynamicLyricUrl);
        if (!TextUtils.equals(yYMsgKtvMusic2.uid, YYRoomInfoManager.e().k()) || yYMsgKtvMusic2.isSinging) {
            return;
        }
        yYMsgKtvMusic2.isSinging = true;
        this$0.b(yYMsgKtvMusic2.musicId, yYMsgKtvMusic2.playToken);
        EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_PLAY, b.room_id, b.uid, yYMsgKtvMusic2.musicId, true ^ b.getNormalKtv().booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, YYMsgKtvPrize it) {
        ActivityResultCaller yYKtvPrizeDialog;
        Intrinsics.e(this$0, "this$0");
        YYMusicManager.f11418a.c().g();
        this$0.g();
        YYRoomModel b = YYRoomInfoManager.e().b();
        boolean z = false;
        if (b != null) {
            z = Intrinsics.a((Object) b.getNormalKtv(), (Object) false);
        }
        if (z) {
            Intrinsics.c(it, "it");
            yYKtvPrizeDialog = new YYKtvGorgeousPrizeDialog(it);
        } else {
            Intrinsics.c(it, "it");
            yYKtvPrizeDialog = new YYKtvPrizeDialog(it);
        }
        FragmentManager parentFragmentManager = this$0.f17634a.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "fragment.parentFragmentManager");
        ((BaseFullScreenDialog) yYKtvPrizeDialog).show(parentFragmentManager, "open_prize_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, YYMsgKtvSinger yYMsgKtvSinger) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment != null) {
            BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).a(yYMsgKtvSinger);
        }
        if (TextUtils.equals(yYMsgKtvSinger.uid, YYRoomInfoManager.e().k())) {
            this$0.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPresenter this$0, TrtcSongScoreModel trtcSongScoreModel) {
        YYMsgKtvMusic yYMsgKtvMusic;
        String str;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if ((baseYYStudioFragment == null ? null : baseYYStudioFragment.E) instanceof YYSeatKTVAdapter) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null ? false : Intrinsics.a((Object) b.getNormalKtv(), (Object) true)) {
                return;
            }
            YYRoomInfoManager.e().a(trtcSongScoreModel);
            LogUtils.d("ktv", Intrinsics.a("score: ", (Object) trtcSongScoreModel));
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            Integer valueOf = (b2 == null || (yYMsgKtvMusic = b2.music) == null) ? null : Integer.valueOf(yYMsgKtvMusic.lrcCount);
            BaseConnectingAdapter baseConnectingAdapter = this$0.f17634a.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            YYSeatKTVAdapter yYSeatKTVAdapter = (YYSeatKTVAdapter) baseConnectingAdapter;
            yYSeatKTVAdapter.d(trtcSongScoreModel.averageScore);
            yYSeatKTVAdapter.c(trtcSongScoreModel.currentScore);
            int i = trtcSongScoreModel.gotTotalScore;
            String num = valueOf == null ? null : valueOf.toString();
            YYRoomModel b3 = YYRoomInfoManager.e().b();
            if (b3 == null) {
                str = null;
            } else {
                YYKtvStageModel yYKtvStageModel = b3.stage_info;
                str = yYKtvStageModel == null ? null : yYKtvStageModel.total_score;
            }
            this$0.a("7", String.valueOf(i), num, str);
        }
    }

    private final void a(String str) {
        String lowerCase;
        String a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.e("download", Intrinsics.a("lrc purl: ", (Object) str));
        if (str == null) {
            lowerCase = null;
        } else {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        Logger.e("download", Intrinsics.a("lrc file name: ", (Object) Md5.a(lowerCase)));
        String str2 = AppMethods.b("/lrc") + ((Object) File.separator) + ((Object) a2);
        Logger.e("download", Intrinsics.a("lrc filePath: ", (Object) str2));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        LiveLogUtils.a(Intrinsics.a("Lrc --> 歌词下载：", (Object) str2));
        FileDownloader.a(str, str2, new YYKtvPresenter$downloadLrc$1(this), this.f17634a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final String str, String str2, String str3) {
        String str4;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (str4 = b.room_id) == null) {
            return;
        }
        final ActivityFragmentActive fragmentActive = this.f17634a.getFragmentActive();
        YYRoomHttpUtils.a(str4, str, str2, str3, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this, fragmentActive) { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$switchOtherSong$1$1
            final /* synthetic */ YYKtvPresenter b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                String str5 = String.this;
                if (!Intrinsics.a((Object) str5, (Object) "3")) {
                    if (Intrinsics.a((Object) str5, (Object) "2")) {
                        AudioChannelManager.j().d(4443);
                        AudioChannelManager.j().d(4444);
                        return;
                    }
                    return;
                }
                BaseYYStudioFragment baseYYStudioFragment = this.b.f17634a;
                if (baseYYStudioFragment == null) {
                    return;
                }
                BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
                if (baseConnectingAdapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
                }
                ((YYSeatKTVAdapter) baseConnectingAdapter).e();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str5) {
                return super.onUIFailure(i, str5);
            }
        }, this.f17634a.getFragmentActive());
    }

    private final void a(String str, String str2, String str3, String str4) {
        String str5 = YYRoomInfoManager.e().b().room_id;
        final ActivityFragmentActive fragmentActive = this.f17634a.getFragmentActive();
        YYRoomHttpUtils.a(str5, str, str2, str3, str4, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$reportSongScore$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, this.f17634a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        YYKtvMusicCenterDialog yYKtvMusicCenterDialog = new YYKtvMusicCenterDialog();
        yYKtvMusicCenterDialog.a(this$0.f17634a);
        FragmentManager parentFragmentManager = this$0.f17634a.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "fragment.parentFragmentManager");
        yYKtvMusicCenterDialog.show(parentFragmentManager, "open_music_center_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        String lowerCase;
        String a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.e("download", Intrinsics.a("Midi url: ", (Object) str));
        if (str == null) {
            lowerCase = null;
        } else {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        Logger.e("download", Intrinsics.a("Midi file name: ", (Object) Md5.a(lowerCase)));
        String str2 = AppMethods.b("/lrc") + ((Object) File.separator) + ((Object) a2);
        Logger.e("download", Intrinsics.a("Midi filePath: ", (Object) str2));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        FileDownloader.a(str, str2, new YYKtvPresenter$downloadMidi$1(this), this.f17634a.getFragmentActive());
    }

    private final void b(String str, String str2) {
        YYMusicManager.f11418a.c().a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f17634a.E instanceof YYSeatKTVAdapter) {
            BaseConnectingAdapter baseConnectingAdapter = this$0.f17634a.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.f17634a.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(str, "", "");
    }

    private final void f() {
        BaseYYStudioFragment baseYYStudioFragment;
        if (this.f17634a == null || (baseYYStudioFragment = this.f17634a) == null) {
            return;
        }
        Context context = baseYYStudioFragment.b;
        Intrinsics.c(context, "it.mContext");
        baseYYStudioFragment.a(new YYKtvBroadcastView(context), -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
        if (baseConnectingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
        }
        ((YYSeatKTVAdapter) baseConnectingAdapter).a(str);
    }

    private final void g() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            YYMsgKtvMusic yYMsgKtvMusic = b.music;
            if (yYMsgKtvMusic != null && TextUtils.equals(YYRoomInfoManager.e().k(), yYMsgKtvMusic.uid)) {
                yYMsgKtvMusic.isSinging = false;
                yYMsgKtvMusic.currentTime = 0L;
                LogUtils.d("TRTC", Intrinsics.a("reset : ", (Object) yYMsgKtvMusic));
            }
            YYKtvStageModel yYKtvStageModel = b.stage_info;
            if (yYKtvStageModel != null) {
                yYKtvStageModel.beans = "0";
                yYKtvStageModel.score = "0";
                yYKtvStageModel.total_score = "0";
            }
        }
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment != null) {
            BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).e();
            BaseConnectingAdapter baseConnectingAdapter2 = baseYYStudioFragment.E;
            if (baseConnectingAdapter2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter2).g();
            a(baseYYStudioFragment);
        }
        AudioChannelManager.j().g(0);
        AudioChannelManager.j().a(4443, 0.0f);
        AudioChannelManager.j().a(4444, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        YYMsgKtvMusic yYMsgKtvMusic;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null && yYMsgKtvMusic.completedLrc && yYMsgKtvMusic.completedMidi) {
            YYMusicManager.f11418a.c().a(yYMsgKtvMusic.dynamicLyricUrl, yYMsgKtvMusic.staticLyricUrl, GenerateTestUserSig.e(), GenerateTestUserSig.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYKtvPresenter this$0, String str) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null) {
            yYMsgKtvMusic.isOriginal = str;
        }
        BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
        if (baseConnectingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
        }
        ((YYSeatKTVAdapter) baseConnectingAdapter).a(Boolean.valueOf(TextUtils.equals("0", str)));
    }

    private final void i() {
        Context context;
        Resources resources;
        DialogKtvCommonView.KtvDialogBuilder ktvDialogBuilder = new DialogKtvCommonView.KtvDialogBuilder();
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment != null && (context = baseYYStudioFragment.b) != null && (resources = context.getResources()) != null) {
            ktvDialogBuilder.a(resources.getString(R.string.yy_ktv_confirm_sing_title));
            ktvDialogBuilder.b("请在10s内确定是否进行演唱，否则将自动放弃此次机会");
            ktvDialogBuilder.c(resources.getString(R.string.yy_ktv_stop_sing));
            ktvDialogBuilder.d(resources.getString(R.string.yy_ktv_start_sing));
        }
        ktvDialogBuilder.a(true);
        ktvDialogBuilder.a(new DialogKtvCommonView.DialogListener() { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$showTimeDialog$2
            @Override // com.blued.android.module.yy_china.view.DialogKtvCommonView.DialogListener
            public void a() {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                final YYKtvPresenter yYKtvPresenter = YYKtvPresenter.this;
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_TURN_POP_START_CLICK;
                String str = b.room_id;
                String str2 = b.uid;
                YYMsgKtvMusic yYMsgKtvMusic = b.music;
                EventTrackYY.b(event, str, str2, yYMsgKtvMusic == null ? null : yYMsgKtvMusic.musicId, !b.getNormalKtv().booleanValue());
                final YYMsgKtvMusic yYMsgKtvMusic2 = b.music;
                if (yYMsgKtvMusic2 == null) {
                    return;
                }
                String str3 = yYMsgKtvMusic2.musicId;
                final ActivityFragmentActive fragmentActive = yYKtvPresenter.f17634a.getFragmentActive();
                YYRoomHttpUtils.r(str3, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvMusicDetailModel>>(yYKtvPresenter, fragmentActive) { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$showTimeDialog$2$onClickConfirm$1$1$1
                    final /* synthetic */ YYKtvPresenter b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(fragmentActive);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<YYKtvMusicDetailModel> bluedEntityA) {
                        YYKtvMusicDetailModel singleData;
                        if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                            return;
                        }
                        YYMsgKtvMusic yYMsgKtvMusic3 = YYMsgKtvMusic.this;
                        YYKtvPresenter yYKtvPresenter2 = this.b;
                        yYMsgKtvMusic3.dynamicLyricUrl = singleData.LyricsUrl;
                        yYMsgKtvMusic3.playToken = singleData.PlayToken;
                        yYMsgKtvMusic3.staticLyricUrl = singleData.MidiUrl;
                        yYMsgKtvMusic3.PreludeInterval = singleData.PreludeInterval;
                        yYKtvPresenter2.b(yYMsgKtvMusic3.staticLyricUrl);
                        yYKtvPresenter2.a("1", singleData.LyricsUrl, yYMsgKtvMusic3.staticLyricUrl);
                    }
                }, yYKtvPresenter.f17634a.getFragmentActive());
            }

            @Override // com.blued.android.module.yy_china.view.DialogKtvCommonView.DialogListener
            public void b() {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_TURN_POP_GIVE_UP_CLICK;
                    String str = b.room_id;
                    String str2 = b.uid;
                    YYMsgKtvMusic yYMsgKtvMusic = b.music;
                    EventTrackYY.k(event, str, str2, yYMsgKtvMusic == null ? null : yYMsgKtvMusic.musicId);
                }
                YYKtvPresenter.this.a("2", "", "");
            }
        });
        DialogKtvCommonView g = ktvDialogBuilder.g();
        FragmentManager parentFragmentManager = this.f17634a.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "fragment.parentFragmentManager");
        g.show(parentFragmentManager, "confirm_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YYKtvPresenter this$0, String str) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYMsgKtvMusic = b.music) == null || !TextUtils.equals(YYRoomInfoManager.e().k(), yYMsgKtvMusic.uid)) {
            return;
        }
        yYMsgKtvMusic.isSinging = false;
        LiveLogUtils.a(Intrinsics.a("ktv演唱结束：", (Object) yYMsgKtvMusic.musicId));
        YYMusicManager.f11418a.c().g();
        LogUtils.d("TRTC", Intrinsics.a("KEY_EVENT_KTV_MUSIC_FINISH : ", (Object) yYMsgKtvMusic));
        this$0.a("3", "", "");
    }

    private final void j() {
        Context context;
        Resources resources;
        DialogKtvCommonView.KtvDialogBuilder ktvDialogBuilder = new DialogKtvCommonView.KtvDialogBuilder();
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment != null && (context = baseYYStudioFragment.b) != null && (resources = context.getResources()) != null) {
            ktvDialogBuilder.a(resources.getString(R.string.yy_ktv_stop_sing_title));
            ktvDialogBuilder.b(resources.getString(R.string.yy_ktv_stop_sing_content));
            ktvDialogBuilder.c(resources.getString(R.string.yy_ktv_stop_sing));
            ktvDialogBuilder.d(resources.getString(R.string.yy_ktv_resume_sing));
        }
        ktvDialogBuilder.a(false);
        ktvDialogBuilder.a(new DialogKtvCommonView.DialogListener() { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$giveUpDialog$2
            @Override // com.blued.android.module.yy_china.view.DialogKtvCommonView.DialogListener
            public void a() {
            }

            @Override // com.blued.android.module.yy_china.view.DialogKtvCommonView.DialogListener
            public void b() {
                YYMsgKtvMusic yYMsgKtvMusic;
                String str;
                YYRoomModel b = YYRoomInfoManager.e().b();
                LiveLogUtils.a(Intrinsics.a("放弃演唱歌曲 music_id：", (Object) ((b == null || (yYMsgKtvMusic = b.music) == null) ? null : yYMsgKtvMusic.musicId)));
                YYMusicManager c2 = YYMusicManager.f11418a.c();
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 == null) {
                    str = null;
                } else {
                    YYMsgKtvMusic yYMsgKtvMusic2 = b2.music;
                    str = yYMsgKtvMusic2 == null ? null : yYMsgKtvMusic2.musicId;
                }
                c2.c(str);
                YYKtvPresenter.this.a("2", "", "");
            }
        });
        DialogKtvCommonView g = ktvDialogBuilder.g();
        FragmentManager parentFragmentManager = this.f17634a.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "fragment.parentFragmentManager");
        g.show(parentFragmentManager, "give_up_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    private final void k() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<YYConfiguredResourcesModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYConfiguredResourcesModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$getConfiguredResources$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYConfiguredResourcesModel> bluedEntityA) {
                YYConfiguredResourcesModel singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYGiftManager.a().a(singleData.bg_active);
                YYGiftManager.a().a(singleData.foot_light);
                YYGiftManager.a().a(singleData.foot_light_single);
                YYGiftManager.a().a(singleData.top_light);
                YYGiftManager.a().a(singleData.top_light_single);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 == null) {
                    return;
                }
                b2.resourcesModel = singleData;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.f17634a;
        YYRoomHttpUtils.u(str, (BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f17634a instanceof PlayingStudioFragment) {
            BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
            if (baseYYStudioFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.fragment.PlayingStudioFragment");
            }
            ((PlayingStudioFragment) baseYYStudioFragment).V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if ((baseYYStudioFragment == null ? null : baseYYStudioFragment.E) instanceof YYSeatKTVAdapter) {
            BaseYYStudioFragment baseYYStudioFragment2 = this$0.f17634a;
            BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(YYKtvPresenter this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void b(LifecycleOwner lifecycleOwner) {
        YYMusicManager.f11418a.c().a(YYMusicManager.f11418a.c().j(), new YYKtvPresenter$registerLiveEvent$1(this));
        YYRoomInfoManager.e().M().a(new ISongScoreListener() { // from class: com.blued.android.module.yy_china.presenter.YYKtvPresenter$registerLiveEvent$2
            @Override // com.blued.android.module.live.base.music.ISongScoreListener
            public void a(int i) {
                BaseYYStudioFragment baseYYStudioFragment = YYKtvPresenter.this.f17634a;
                if (baseYYStudioFragment == null) {
                    return;
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                YYKtvStageModel yYKtvStageModel = b == null ? null : b.stage_info;
                if (yYKtvStageModel != null) {
                    yYKtvStageModel.total_score = String.valueOf(i);
                }
                BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
                if (baseConnectingAdapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
                }
                ((YYSeatKTVAdapter) baseConnectingAdapter).a(YYRoomInfoManager.e().I());
            }

            @Override // com.blued.android.module.live.base.music.ISongScoreListener
            public void a(int i, int i2, int i3) {
            }

            @Override // com.blued.android.module.live.base.music.ISongScoreListener
            public void a(YYUserSongScoreNoteItem itemGrove) {
                Intrinsics.e(itemGrove, "itemGrove");
                BaseYYStudioFragment baseYYStudioFragment = YYKtvPresenter.this.f17634a;
                if (baseYYStudioFragment == null) {
                    return;
                }
                BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
                if (baseConnectingAdapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
                }
                ((YYSeatKTVAdapter) baseConnectingAdapter).a(itemGrove);
            }

            @Override // com.blued.android.module.live.base.music.ISongScoreListener
            public void a(ArrayList<YYTXSongScoreNoteItem> allGrove) {
                Intrinsics.e(allGrove, "allGrove");
                BaseYYStudioFragment baseYYStudioFragment = YYKtvPresenter.this.f17634a;
                if (baseYYStudioFragment == null) {
                    return;
                }
                BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
                if (baseConnectingAdapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
                }
                ((YYSeatKTVAdapter) baseConnectingAdapter).a(allGrove);
            }
        });
        Observable observable = LiveEventBus.get("event_ktv_pick_music", String.class);
        Intrinsics.a(lifecycleOwner);
        observable.observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$gzzZZK9sjGEmyBO6Of2EYq8PTpw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.b(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_KTV_GUIDE_GIFT_APPL", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$nYp9MG2bHbHs8cColkeRUnuz05Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.c(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_KTV_GUIDE_APPL_UP_MIC", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$VBA5zfO0F_-_1hiPYvvlNWZbmuM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.d(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_out_loud", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$lMkUWly3PF-znvlTnqlcc2zX8aQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.e(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_music_num_change", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$1vlcXUuO-fh7Et2_3xAVjb9-hyE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.f(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_show_time", YYMsgKtvSinger.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$mU_wRDvTxc7FM77KtCFn0JQ1s1c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (YYMsgKtvSinger) obj);
            }
        });
        LiveEventBus.get("event_ktv_give_up", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$LidyCWZQ77csu5d_kQ_1IrbnttY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.g(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("ktv_music_start", YYMsgKtvMusic.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$qdovRGmVc01FFAcBtADBsID3_80
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (YYMsgKtvMusic) obj);
            }
        });
        LiveEventBus.get("ktv_music_progress", TrtcMusicModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$DpwFlD5uCqHYUXHP6zdxEXheywc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (TrtcMusicModel) obj);
            }
        });
        LiveEventBus.get("ktv_music_mode", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$CvWsmEabHGOzb4k41PTD6yUhnEI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.h(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("ktv_music_play_finish", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$EX-wEA-iqMGlzn1iiBi7zGgg2r8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.i(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("ktv_music_finish", YYMsgKtvPrize.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$IXyBBTlamHN6FxdQK5oGGzOpDR0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (YYMsgKtvPrize) obj);
            }
        });
        LiveEventBus.get("ktv_music_end", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$CdfZ46T55LGuLK-7L6G0Izzi7r8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.j(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_up_to_mic_song", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$No7Q6a-cH6g1pnmhZyvrHHSBbRE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.k(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_show_applaud", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$j7XeQfNbPK8WsfOjWVBKjkVesmg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.l(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("show_blind_guide", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$5N5EVWaO5qPeTqXjWyvuy5n1JOk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.m(YYKtvPresenter.this, (String) obj);
            }
        });
        LiveEventBus.get("event_ktv_stage_style", YYKtvStageModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$m5tN-WUznOl7GIWoLj32dOi4k14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (YYKtvStageModel) obj);
            }
        });
        LiveEventBus.get("event_update_song_score", TrtcSongScoreModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$QIkqy2SC_PzOcCDBKah60x9RjFc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYKtvPresenter.a(YYKtvPresenter.this, (TrtcSongScoreModel) obj);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.presenter.AbstractBasePresenter
    public void e() {
        super.e();
        YYMusicManager.f11418a.c().d(YYMusicManager.f11418a.c().j());
        YYKtvMusicManager M = YYRoomInfoManager.e().M();
        if (M == null) {
            return;
        }
        M.c();
    }
}
