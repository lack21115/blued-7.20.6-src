package com.blued.android.module.yy_china.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.ISongScoreListener;
import com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.RobMusicMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyMode;
import com.blued.android.module.yy_china.model.YYBorImJsonMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager.class */
public final class YYRobMusicManager implements RoomManagerController {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17566a;
    private final RobHandler b = new RobHandler(new WeakReference(this));

    /* renamed from: c  reason: collision with root package name */
    private final Observer<YYBorImJsonMode> f17567c = new Observer() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$6TQ4HmXisxPcYUY5JYpK07gqjOw
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            YYRobMusicManager.a(YYRobMusicManager.this, (YYBorImJsonMode) obj);
        }
    };
    private final Observer<TrtcMusicModel> d = new Observer() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$OAB-qajij6G21Qf-fAz45FAvn2U
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            YYRobMusicManager.a(YYRobMusicManager.this, (TrtcMusicModel) obj);
        }
    };
    private final MusicPlayMusicInfoCallback e = new YYRobMusicManager$mLoadMusicCallback$1(this);
    private final ISongScoreListener f = new ISongScoreListener() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$mPlayingMusicCallback$1
        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(int i) {
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(int i, int i2, int i3) {
            ArrayList<Integer> arrayList = YYRoomInfoManager.e().g;
            if (arrayList == null) {
                return;
            }
            arrayList.add(Integer.valueOf(i));
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(YYUserSongScoreNoteItem itemGrove) {
            Intrinsics.e(itemGrove, "itemGrove");
        }

        @Override // com.blued.android.module.live.base.music.ISongScoreListener
        public void a(ArrayList<YYTXSongScoreNoteItem> allGrove) {
            Intrinsics.e(allGrove, "allGrove");
        }
    };
    private boolean g;
    private long h;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$RobHandler.class */
    public static final class RobHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f17568a = new Companion(null);
        private final WeakReference<YYRobMusicManager> b;

        @Metadata
        /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$RobHandler$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RobHandler(WeakReference<YYRobMusicManager> mManager) {
            super(Looper.getMainLooper());
            Intrinsics.e(mManager, "mManager");
            this.b = mManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            YYRobMusicManager yYRobMusicManager;
            Intrinsics.e(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                YYRobMusicManager yYRobMusicManager2 = this.b.get();
                if (yYRobMusicManager2 == null) {
                    return;
                }
                yYRobMusicManager2.g();
            } else if (i != 2) {
                if (i == 3 && (yYRobMusicManager = this.b.get()) != null) {
                    yYRobMusicManager.i();
                }
            } else {
                YYRobMusicManager yYRobMusicManager3 = this.b.get();
                if (yYRobMusicManager3 != null) {
                    yYRobMusicManager3.a(msg.arg1);
                }
                if (msg.arg1 > 0) {
                    Message obtain = Message.obtain();
                    obtain.arg1 = msg.arg1 - 1;
                    obtain.what = 2;
                    sendMessageDelayed(obtain, 1000L);
                }
            }
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$RobMusicHandlerData.class */
    public static final class RobMusicHandlerData {

        /* renamed from: a  reason: collision with root package name */
        private final String f17569a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final long f17570c;
        private final boolean d;
        private final String e;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RobMusicHandlerData) {
                RobMusicHandlerData robMusicHandlerData = (RobMusicHandlerData) obj;
                return Intrinsics.a((Object) this.f17569a, (Object) robMusicHandlerData.f17569a) && Intrinsics.a((Object) this.b, (Object) robMusicHandlerData.b) && this.f17570c == robMusicHandlerData.f17570c && this.d == robMusicHandlerData.d && Intrinsics.a((Object) this.e, (Object) robMusicHandlerData.e);
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public String toString() {
            return "RobMusicHandlerData(musicId=" + this.f17569a + ", playToke=" + this.b + ", starTime=" + this.f17570c + ", isHostPlay=" + this.d + ", msg=" + this.e + ')';
        }
    }

    public YYRobMusicManager() {
        LiveEventBus.get("bor_music_ims", YYBorImJsonMode.class).observeForever(this.f17567c);
        LiveEventBus.get("rob_music_progress", TrtcMusicModel.class).observeForever(this.d);
        YYMusicManager.f11418a.c().a(YYMusicManager.f11418a.c().i(), this.e);
        YYMusicManager.f11418a.c().a(YYMusicManager.f11418a.c().i(), this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicManager this$0, TrtcMusicModel trtcMusicModel) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(this$0, "this$0");
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().robMus == null) {
            this$0.d();
            return;
        }
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setHostPlay(this$0.g);
        robMusicMode.setTime(trtcMusicModel.curPtsMS);
        LiveEventBus.get("bor_music_ims_time").post(robMusicMode);
        YYRoomInfoManager.e().b();
        YYRoomModel b = YYRoomInfoManager.e().b();
        long endTime = (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) ? 0L : yYBorImJsonBodyInfoMode.getEndTime();
        if (trtcMusicModel.curPtsMS >= endTime) {
            this$0.j();
            if (this$0.g || endTime == 0) {
                return;
            }
            LiveEventBus.get("bor_music_show_user_result_uping").post(new RobMusicMode());
            RobHandler robHandler = this$0.b;
            if (robHandler == null) {
                return;
            }
            robHandler.sendEmptyMessageDelayed(3, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicManager this$0, YYBorImJsonMode msg) {
        Intrinsics.e(this$0, "this$0");
        switch (msg.getType()) {
            case 1:
                Intrinsics.c(msg, "msg");
                this$0.d(msg);
                return;
            case 2:
                this$0.p();
                return;
            case 3:
                Intrinsics.c(msg, "msg");
                this$0.a(msg);
                return;
            case 4:
                this$0.c(msg);
                return;
            case 5:
                this$0.l();
                return;
            case 6:
                this$0.b(msg);
                return;
            case 7:
                this$0.a(msg.getBody());
                return;
            default:
                return;
        }
    }

    private final void a(YYBorImJsonBodyMode yYBorImJsonBodyMode) {
        YYRoomModel b;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setStatus(yYBorImJsonBodyMode);
        LiveEventBus.get("bor_music_ims_add_user").post(robMusicMode);
        YYRoomInfoManager e = YYRoomInfoManager.e();
        if (e == null || (b = e.b()) == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        this.f17566a = true;
        int status = yYBorImJsonBodyMode.getStatus();
        if (status == 0) {
            a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), true);
        } else if (status != 1) {
            this.f17566a = false;
        } else {
            a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), false);
        }
    }

    private final void a(String str, String str2, long j, boolean z) {
        this.g = z;
        this.h = j;
        YYMusicManager.f11418a.c().a(str, str2, false);
    }

    private final void a(String str, boolean z) {
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
        Logger.e("download", Intrinsics.a("lrc fileStart: ", (Object) str2));
        LiveLogUtils.a(Intrinsics.a("Lrc --> 抢唱歌词下载：", (Object) str2));
        FileDownloader.a(str, str2, new YYRobMusicManager$downloadLrc$1(str2, z, this), null);
    }

    private final void b(YYBorImJsonMode yYBorImJsonMode) {
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setMsg(yYBorImJsonMode);
        LiveEventBus.get("bor_music_ims_light").post(robMusicMode);
    }

    private final void b(String str) {
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
        FileDownloader.a(str, str2, new YYRobMusicManager$downloadMidi$1(this), null);
    }

    private final void c(YYBorImJsonMode yYBorImJsonMode) {
        YYBorImJsonBodyMode body;
        YYBorImJsonBodyMode body2;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        YYBorImJsonBodyMode body3;
        YYBorImJsonBodyInfoMode musicInfo;
        String musicId;
        RobHandler robHandler = this.b;
        if (robHandler != null) {
            robHandler.removeMessages(2);
        }
        j();
        k();
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setMsg(yYBorImJsonMode);
        LiveEventBus.get("bor_music_ims_result").post(robMusicMode);
        StringBuilder sb = new StringBuilder();
        sb.append("抢唱 播放结果  result -> ");
        sb.append((yYBorImJsonMode == null || (body = yYBorImJsonMode.getBody()) == null) ? 1 : body.getResult());
        sb.append("    mid-> ");
        String str = "";
        if (yYBorImJsonMode != null && (body3 = yYBorImJsonMode.getBody()) != null && (musicInfo = body3.getMusicInfo()) != null && (musicId = musicInfo.getMusicId()) != null) {
            str = musicId;
        }
        sb.append(str);
        LiveLogUtils.a(sb.toString());
        RobHandler robHandler2 = this.b;
        int result = (yYBorImJsonMode == null || (body2 = yYBorImJsonMode.getBody()) == null) ? 1 : body2.getResult();
        long j = 3000;
        if (result != 1) {
            j = 3000;
            if (result != 2) {
                j = result != 3 ? 0L : 6000L;
            }
        }
        robHandler2.sendEmptyMessageDelayed(1, j);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), true);
    }

    private final void d(YYBorImJsonMode yYBorImJsonMode) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        j();
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setMsg(yYBorImJsonMode);
        LiveEventBus.get("bor_music_ims_show_begin").post(robMusicMode);
        YYBorImJsonBodyMode body = yYBorImJsonMode.getBody();
        if (body != null) {
            if (body.getStatus() == 1) {
                c().sendEmptyMessageDelayed(1, 5500L);
                this.f17566a = true;
                LiveLogUtils.a("开启抢唱大流程");
            } else {
                this.f17566a = false;
                c().removeCallbacksAndMessages(null);
                k();
                LiveLogUtils.a("关闭抢唱大流程");
            }
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), true);
    }

    private final void l() {
        if (YYRoomInfoManager.e().i()) {
            Iterator<YYBorImJsonBodyInfoMode> it = YYRoomInfoManager.e().b().robMusics.iterator();
            while (it.hasNext()) {
                YYBorImJsonBodyInfoMode next = it.next();
                a(next.getMusicId(), next.getPlayToken());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        YYRoomInfoManager.e().g = new ArrayList<>();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null && yYBorImJsonBodyInfoMode.getCompletedLrc() && yYBorImJsonBodyInfoMode.getCompletedMidi()) {
            YYMusicManager.f11418a.c().a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), yYBorImJsonBodyInfoMode.getStaticLyricUrl(), GenerateTestUserSig.e(), GenerateTestUserSig.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        YYRoomHttpUtils.q(b.room_id, yYBorImJsonBodyInfoMode.getMusicId(), new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$hostPlayMusic$1$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || b.robMus == null) {
            return;
        }
        YYRoomHttpUtils.f(b.room_id, "1", "[]", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$userPlayMusic$1$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, null);
    }

    private final void p() {
        LiveEventBus.get("bor_music_ims_paly_rob_music_ani").post(new RobMusicMode());
    }

    @Override // com.blued.android.module.yy_china.manager.RoomManagerController
    public void a() {
        LiveEventBus.get("bor_music_ims", YYBorImJsonMode.class).removeObserver(this.f17567c);
        LiveEventBus.get("rob_music_progress", TrtcMusicModel.class).removeObserver(this.d);
        this.b.removeCallbacksAndMessages(null);
        YYMusicManager.f11418a.c().d(YYMusicManager.f11418a.c().i());
        YYMusicManager.f11418a.c().e(YYMusicManager.f11418a.c().k());
    }

    public final void a(int i) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setCountDown(i);
        LiveEventBus.get("bor_music_ims_user_music").post(robMusicMode);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null && StringUtils.a(yYBorImJsonBodyInfoMode.getUid(), YYRoomInfoManager.e().k()) && i <= 0) {
            LiveLogUtils.a(Intrinsics.a("抢唱 用户开始 播放 ", (Object) yYBorImJsonBodyInfoMode.getMusicId()));
            a(yYBorImJsonBodyInfoMode.getMusicId(), yYBorImJsonBodyInfoMode.getPlayToken(), yYBorImJsonBodyInfoMode.getStartTime(), false);
            b(yYBorImJsonBodyInfoMode.getStaticLyricUrl());
        }
    }

    public final void a(final IRequestHost iRequestHost) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.p(b.room_id, "1", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$robMusicStart$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IRequestHost.this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, iRequestHost);
    }

    public final void a(YYBorImJsonMode msg) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        YYBorImJsonBodyInfoMode musicInfo;
        String uid;
        Intrinsics.e(msg, "msg");
        StringBuilder sb = new StringBuilder();
        sb.append("用户");
        YYBorImJsonBodyMode body = msg.getBody();
        String str = "";
        if (body != null && (musicInfo = body.getMusicInfo()) != null && (uid = musicInfo.getUid()) != null) {
            str = uid;
        }
        sb.append(str);
        sb.append("抢到   musicId->");
        sb.append(msg.getBody().getMusicId());
        LiveLogUtils.a(sb.toString());
        j();
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setMsg(msg);
        LiveEventBus.get("bor_music_ims_paly_rob_by_user").post(robMusicMode);
        Message obtain = Message.obtain();
        obtain.arg1 = 4;
        obtain.what = 2;
        this.b.sendMessageDelayed(obtain, 2000L);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        a(yYBorImJsonBodyInfoMode.getDynamicLyricUrl(), false);
    }

    public final void a(String str, String str2) {
        YYMusicManager.f11418a.c().a(str, str2, new ITXMusicPreloadCallback() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$preloadMusic$1
            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadComplete(String str3, String str4, int i, String str5) {
                Logger.e("preloadMusic", Intrinsics.a("onPreloadComplete: ", (Object) str3));
                LiveLogUtils.a(Intrinsics.a("抢唱歌曲预加载成功 music_id：", (Object) str3));
            }

            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadProgress(String str3, String str4, float f) {
            }

            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadStart(String str3, String str4) {
                Logger.e("preloadMusic", Intrinsics.a("onPreloadStart: ", (Object) str3));
                LiveLogUtils.a(Intrinsics.a("抢唱歌曲预加载开始 music_id：", (Object) str3));
            }
        });
    }

    public final boolean a(String musicId) {
        Intrinsics.e(musicId, "musicId");
        return YYMusicManager.f11418a.c().b(musicId);
    }

    public final void b(final IRequestHost iRequestHost) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.p(b.room_id, "0", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$stopRobMusic$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IRequestHost.this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, iRequestHost);
    }

    public final boolean b() {
        return this.f17566a;
    }

    public final RobHandler c() {
        return this.b;
    }

    public final void c(final IRequestHost iRequestHost) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.f(b.room_id, "2", "[]", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$nextMusic$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IRequestHost.this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, iRequestHost);
    }

    public final void d() {
        j();
    }

    public final boolean e() {
        return this.g;
    }

    public final long f() {
        return this.h;
    }

    public final void g() {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        LiveEventBus.get("bor_music_ims_host_music").post(new RobMusicMode());
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null || !YYRoomInfoManager.e().h()) {
            return;
        }
        a(yYBorImJsonBodyInfoMode.getMusicId(), yYBorImJsonBodyInfoMode.getPlayToken(), yYBorImJsonBodyInfoMode.getStartTime(), true);
    }

    public final void h() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.U(b.room_id, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$robMusic$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        }, null);
    }

    public final void i() {
        ArrayList<Integer> arrayList = YYRoomInfoManager.e().g;
        if (arrayList != null && arrayList.size() > 0) {
            arrayList.remove((Object) 0);
        }
        String json = AppInfo.f().toJson(YYRoomInfoManager.e().g);
        YYRoomInfoManager.e().g = new ArrayList<>();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRobMusicManager$onRobMusicByUserUpResult$value$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        };
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || b.robMus == null || e()) {
            return;
        }
        YYRoomHttpUtils.f(b.room_id, "2", json, bluedUIHttpResponse, null);
    }

    public final void j() {
        YYMusicManager.f11418a.c().g();
        AudioChannelManager.j().d(4443);
        AudioChannelManager.j().d(4444);
    }

    public final void k() {
        AudioChannelManager.j().g(0);
        AudioChannelManager.j().a(4443, 0.0f);
        AudioChannelManager.j().a(4444, 0.0f);
    }
}
