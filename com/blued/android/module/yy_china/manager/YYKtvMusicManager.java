package com.blued.android.module.yy_china.manager;

import com.blued.android.core.AppInfo;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.ISongScoreListener;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.yy_china.manager.YYKtvMusicManager;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcSongScoreModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYKtvMusicManager.class */
public final class YYKtvMusicManager implements RoomManagerController {

    /* renamed from: a  reason: collision with root package name */
    private ISongScoreListener f17558a;

    @Metadata
    /* renamed from: com.blued.android.module.yy_china.manager.YYKtvMusicManager$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYKtvMusicManager$1.class */
    public static final class AnonymousClass1 implements ISongScoreListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i, int i2, int i3) {
            TrtcSongScoreModel trtcSongScoreModel = new TrtcSongScoreModel();
            trtcSongScoreModel.cmdID = 6;
            trtcSongScoreModel.currentScore = i;
            trtcSongScoreModel.gotTotalScore = i2;
            trtcSongScoreModel.curIndex = i3;
            trtcSongScoreModel.hitCount = YYMusicManager.f11418a.c().a(i);
            LiveEventBus.get("event_update_song_score").post(trtcSongScoreModel);
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(int i) {
            ISongScoreListener b = YYKtvMusicManager.this.b();
            if (b == null) {
                return;
            }
            b.a(i);
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(final int i, final int i2, final int i3) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYKtvMusicManager$1$eHoBaTeZO_kvfT9LLNCLX0GAuBY
                @Override // java.lang.Runnable
                public final void run() {
                    YYKtvMusicManager.AnonymousClass1.b(i, i2, i3);
                }
            });
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(YYUserSongScoreNoteItem itemGrove) {
            Intrinsics.e(itemGrove, "itemGrove");
            ISongScoreListener b = YYKtvMusicManager.this.b();
            if (b == null) {
                return;
            }
            b.a(itemGrove);
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(ArrayList<YYTXSongScoreNoteItem> allGrove) {
            Intrinsics.e(allGrove, "allGrove");
            ISongScoreListener b = YYKtvMusicManager.this.b();
            if (b == null) {
                return;
            }
            b.a(allGrove);
        }
    }

    public YYKtvMusicManager() {
        YYMusicManager.f11418a.c().a(YYMusicManager.f11418a.c().l(), new AnonymousClass1());
    }

    @Override // com.blued.android.module.yy_china.manager.RoomManagerController
    public void a() {
        YYMusicManager.f11418a.c().e(YYMusicManager.f11418a.c().l());
        this.f17558a = null;
    }

    public final void a(ISongScoreListener callback) {
        Intrinsics.e(callback, "callback");
        this.f17558a = callback;
    }

    public final ISongScoreListener b() {
        return this.f17558a;
    }

    public final void c() {
        this.f17558a = null;
    }
}
