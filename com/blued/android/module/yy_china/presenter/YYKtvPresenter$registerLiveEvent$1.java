package com.blued.android.module.yy_china.presenter;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYKtvPresenter$registerLiveEvent$1.class */
public final class YYKtvPresenter$registerLiveEvent$1 implements MusicPlayMusicInfoCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYKtvPresenter f17769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYKtvPresenter$registerLiveEvent$1(YYKtvPresenter yYKtvPresenter) {
        this.f17769a = yYKtvPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, String str, YYKtvPresenter this$0, String str2) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(this$0, "this$0");
        if (i == YYMusicManager.f11418a.b()) {
            LiveLogUtils.a(Intrinsics.a("取消歌曲预加载 music_id：", (Object) str));
        } else if (i != YYMusicManager.f11418a.a()) {
            LiveLogUtils.a(Intrinsics.a("歌曲预加载失败 music_id：", (Object) str));
            ToastUtils.a("歌曲加载失败");
            this$0.a("6", "", "");
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || (yYMsgKtvMusic = b.music) == null) {
                return;
            }
            LiveLogUtils.a(Intrinsics.a("歌曲预加载成功 music_id：", (Object) str));
            yYMsgKtvMusic.accompanyUrl = YYMusicManager.f11418a.c().a(str, 1);
            yYMsgKtvMusic.musicUrl = YYMusicManager.f11418a.c().a(str, 0);
            Logger.e("YYMusicManager", Intrinsics.a("onClickConfirm: ", (Object) AppInfo.f().toJson(yYMsgKtvMusic)));
            if (TextUtils.equals(yYMsgKtvMusic.musicId, str)) {
                YYMusicManager.f11418a.c().a(str, str2);
            }
        }
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, ITXCMMusicTrack iTXCMMusicTrack, String str2, String str3) {
        LiveLogUtils.a(Intrinsics.a("音乐信息获取成功：playKTVMusic music_id：", (Object) str));
        AudioChannelManager.j().a(4443, str2, 4444, str3, 0L);
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, String str2) {
        Logger.e("YYMusicManager", Intrinsics.a("trtc onPreloadStart musicId: ", (Object) str));
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, String str2, float f) {
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(final String str, final String str2, final int i, String str3) {
        Logger.e("YYMusicManager", "trtc onPreloadComplete musicId: " + ((Object) str) + " ---- errorCode：" + i + " --- msg：" + ((Object) str3));
        BaseYYStudioFragment baseYYStudioFragment = this.f17769a.f17634a;
        final YYKtvPresenter yYKtvPresenter = this.f17769a;
        baseYYStudioFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$registerLiveEvent$1$V_UGVjFa52oSy29xzWsi9gix_mU
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvPresenter$registerLiveEvent$1.a(i, str, yYKtvPresenter, str2);
            }
        });
    }
}
