package com.blued.android.module.yy_china.manager;

import android.os.Handler;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$mLoadMusicCallback$1.class */
public final class YYRobMusicManager$mLoadMusicCallback$1 implements MusicPlayMusicInfoCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYRobMusicManager f17574a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYRobMusicManager$mLoadMusicCallback$1(YYRobMusicManager yYRobMusicManager) {
        this.f17574a = yYRobMusicManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, String str, YYRobMusicManager this$0, String str2) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(this$0, "this$0");
        if (i == YYMusicManager.f11418a.b()) {
            LiveLogUtils.a(Intrinsics.a("抢唱取消歌曲预加载 music_id：", (Object) str));
        } else if (i != YYMusicManager.f11418a.a()) {
            LiveLogUtils.a(Intrinsics.a("抢唱歌曲预加载失败 music_id：", (Object) str));
            ToastUtils.a("歌曲加载失败");
            if (this$0.e()) {
                this$0.b((IRequestHost) null);
            } else {
                this$0.c((IRequestHost) null);
            }
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
                return;
            }
            LiveLogUtils.a(Intrinsics.a("抢唱歌曲预加载成功 music_id：", (Object) str));
            yYBorImJsonBodyInfoMode.setAccompanyUrl(YYMusicManager.f11418a.c().a(str, 1));
            yYBorImJsonBodyInfoMode.setMusicUrl(YYMusicManager.f11418a.c().a(str, 0));
            Logger.e("YYMusicManager", Intrinsics.a("onClickConfirm: ", (Object) AppInfo.f().toJson(yYBorImJsonBodyInfoMode)));
            if (TextUtils.equals(yYBorImJsonBodyInfoMode.getMusicId(), str)) {
                YYMusicManager.f11418a.c().a(str, str2);
            }
        }
    }

    @Override // com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback
    public void a(String str, ITXCMMusicTrack iTXCMMusicTrack, String str2, String str3) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        LiveLogUtils.a(Intrinsics.a("音乐信息获取成功：playRobMusic music_id：", (Object) str));
        Logger.e("preloadMusic", Intrinsics.a("OnPreparedPlay: ", (Object) str));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        YYRobMusicManager yYRobMusicManager = this.f17574a;
        if (!TextUtils.equals(yYBorImJsonBodyInfoMode.getMusicId(), str)) {
            LiveLogUtils.a(Intrinsics.a("抢唱歌曲播放 错过 music_id：", (Object) str));
            return;
        }
        AudioChannelManager.j().a(4443, yYRobMusicManager.e(), str2, 4444, str3, yYRobMusicManager.f());
        if (yYRobMusicManager.e()) {
            LiveLogUtils.a(Intrinsics.a("抢唱歌曲播放 主持人 music_id：", (Object) str));
            yYRobMusicManager.n();
            return;
        }
        LiveLogUtils.a(Intrinsics.a("抢唱歌曲播放 抢唱用户 music_id：", (Object) str));
        yYRobMusicManager.o();
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
        Handler n = AppInfo.n();
        final YYRobMusicManager yYRobMusicManager = this.f17574a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$mLoadMusicCallback$1$0iX0tAx50HWWClPHq16906idAVE
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicManager$mLoadMusicCallback$1.a(i, str, yYRobMusicManager, str2);
            }
        });
    }
}
