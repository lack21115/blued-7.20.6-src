package com.blued.android.module.live.base.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.live.base.music.ISongScoreListener;
import com.blued.android.module.live.base.music.MusicPlayMusicInfoCallback;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcAudioFrameModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback;
import com.tencent.txcopyrightedmedia.ITXSongScore;
import com.tencent.txcopyrightedmedia.ITXSongScoreCallback;
import com.tencent.txcopyrightedmedia.TXCMMusicInfo;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.TXSongScoreConfig;
import com.tencent.txcopyrightedmedia.TXSongScoreNoteItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/manager/YYMusicManager.class */
public final class YYMusicManager {
    private static final int J = 0;
    private List<? extends YYKtvMusicModel> A;
    private int B;
    private final ArrayMap<String, MusicPlayMusicInfoCallback> C;
    private final ArrayMap<String, ISongScoreListener> D;
    private final String E;
    private final String F;
    private final String G;
    private final String H;
    private final String I;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11419c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final int k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private TXCopyrightedMedia p;
    private ITXCMMusicTrack q;
    private ITXSongScore r;
    private Boolean s;
    private int t;
    private int u;
    private boolean v;
    private String w;
    private String x;
    private LiveMusicModel y;
    private YYKtvMusicModel z;

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f11418a = new Companion(null);
    private static final int K = -1;
    private static final int L = -2;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/manager/YYMusicManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return YYMusicManager.J;
        }

        public final int b() {
            return YYMusicManager.L;
        }

        public final YYMusicManager c() {
            return InstanceHelper.f11420a.a();
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/manager/YYMusicManager$InstanceHelper.class */
    public static final class InstanceHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final InstanceHelper f11420a = new InstanceHelper();
        private static final YYMusicManager b = new YYMusicManager(null);

        private InstanceHelper() {
        }

        public final YYMusicManager a() {
            return b;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private YYMusicManager() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public /* synthetic */ YYMusicManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    static /* synthetic */ String a(YYMusicManager yYMusicManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYMusicManager.o;
        }
        return yYMusicManager.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2, int i3) {
        for (String str : this.D.keySet()) {
            ISongScoreListener iSongScoreListener = this.D.get(str);
            if (iSongScoreListener != null) {
                iSongScoreListener.a(i, i2, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMusicManager this$0, int i, String str) {
        Intrinsics.e(this$0, "this$0");
        LiveLogUtils.a(" prepare music error: " + i + ", msg: " + ((Object) str));
        String str2 = this$0.j;
        Logger.c(str2, " prepare music error: " + i + ", msg: " + ((Object) str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMusicManager this$0, String str) {
        String str2;
        String str3;
        Intrinsics.e(this$0, "this$0");
        Logger.c(this$0.j, "trtc onPrepared ... ");
        ITXCMMusicTrack iTXCMMusicTrack = this$0.q;
        if (iTXCMMusicTrack != null) {
            iTXCMMusicTrack.start();
        }
        try {
            str2 = TXCopyrightedMedia.genMusicURI(str, 0, a(this$0, (String) null, 1, (Object) null));
            Intrinsics.c(str2, "genMusicURI(musicId, 0, getBitrate())");
            try {
                str3 = TXCopyrightedMedia.genMusicURI(str, 1, a(this$0, (String) null, 1, (Object) null));
                Intrinsics.c(str3, "genMusicURI(musicId, 1, getBitrate())");
            } catch (Exception e) {
                e = e;
                LiveLogUtils.a("获取K歌音乐播放连接失败 message：" + ((Object) e.getMessage()) + "，music_id：" + ((Object) str));
                Log.e("trtc", "歌曲播放链接错误");
                str3 = "";
                LiveLogUtils.a("获取K歌音乐播放连接成功，开始播放K歌音乐 music_id：" + ((Object) str) + "，origin_uri：" + str2);
                this$0.a(str, this$0.q, str2, str3);
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        LiveLogUtils.a("获取K歌音乐播放连接成功，开始播放K歌音乐 music_id：" + ((Object) str) + "，origin_uri：" + str2);
        this$0.a(str, this$0.q, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYUserSongScoreNoteItem yYUserSongScoreNoteItem) {
        for (String str : this.D.keySet()) {
            ISongScoreListener iSongScoreListener = this.D.get(str);
            if (iSongScoreListener != null) {
                iSongScoreListener.a(yYUserSongScoreNoteItem);
            }
        }
    }

    private final void a(String str, ITXCMMusicTrack iTXCMMusicTrack, String str2, String str3) {
        for (String str4 : this.C.keySet()) {
            MusicPlayMusicInfoCallback musicPlayMusicInfoCallback = this.C.get(str4);
            if (musicPlayMusicInfoCallback != null) {
                musicPlayMusicInfoCallback.a(str, iTXCMMusicTrack, str2, str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, float f) {
        for (String str3 : this.C.keySet()) {
            MusicPlayMusicInfoCallback musicPlayMusicInfoCallback = this.C.get(str3);
            if (musicPlayMusicInfoCallback != null) {
                musicPlayMusicInfoCallback.a(str, str2, f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, int i, String str3) {
        for (String str4 : this.C.keySet()) {
            MusicPlayMusicInfoCallback musicPlayMusicInfoCallback = this.C.get(str4);
            if (musicPlayMusicInfoCallback != null) {
                musicPlayMusicInfoCallback.a(str, str2, i, str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<YYTXSongScoreNoteItem> arrayList) {
        for (String str : this.D.keySet()) {
            ISongScoreListener iSongScoreListener = this.D.get(str);
            if (iSongScoreListener != null) {
                iSongScoreListener.a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        for (String str : this.D.keySet()) {
            ISongScoreListener iSongScoreListener = this.D.get(str);
            if (iSongScoreListener != null) {
                iSongScoreListener.a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str, String str2) {
        for (String str3 : this.C.keySet()) {
            MusicPlayMusicInfoCallback musicPlayMusicInfoCallback = this.C.get(str3);
            if (musicPlayMusicInfoCallback != null) {
                musicPlayMusicInfoCallback.a(str, str2);
            }
        }
    }

    private final String f(String str) {
        if (this.k != 0) {
            return this.o;
        }
        String str2 = str;
        return TextUtils.equals("hi", str2) ? this.l : TextUtils.equals("lo", str2) ? this.m : TextUtils.equals("mi", str2) ? this.n : this.o;
    }

    private final void o() {
        Context d = AppInfo.d();
        Intrinsics.c(d, "getAppContext()");
        a(d, p(), q());
        TXCopyrightedMedia.instance().init();
        TXCopyrightedMedia instance = TXCopyrightedMedia.instance();
        this.p = instance;
        if (instance == null) {
            return;
        }
        instance.setMusicCacheMaxCount(10);
    }

    private final String p() {
        return this.v ? r() : t();
    }

    private final String q() {
        return BluedHttpUrl.h() ? s() : u();
    }

    private final String r() {
        return BluedHttpUrl.h() ? this.h : this.f;
    }

    private final String s() {
        return BluedHttpUrl.h() ? this.i : this.g;
    }

    private final String t() {
        return BluedHttpUrl.h() ? this.d : this.b;
    }

    private final String u() {
        return BluedHttpUrl.h() ? this.e : this.f11419c;
    }

    public final int a(int i) {
        int i2 = i >= 90 ? 3 : i >= 80 ? 2 : i >= 70 ? 1 : 0;
        if (i2 == this.t) {
            this.u++;
        } else {
            this.u = 1;
            this.t = i2;
        }
        return this.u;
    }

    public final LiveMusicModel a() {
        return this.y;
    }

    public final YYKtvMusicModel a(String str) {
        int i;
        List<? extends YYKtvMusicModel> list = this.A;
        Intrinsics.a(list);
        int size = list.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= size) {
                break;
            }
            i = i3 + 1;
            List<? extends YYKtvMusicModel> list2 = this.A;
            Intrinsics.a(list2);
            if (TextUtils.equals(str, list2.get(i3).musicId)) {
                break;
            }
            i2 = i;
        }
        List<? extends YYKtvMusicModel> list3 = this.A;
        Intrinsics.a(list3);
        if (i <= list3.size() - 1) {
            List<? extends YYKtvMusicModel> list4 = this.A;
            Intrinsics.a(list4);
            return list4.get(i);
        }
        return null;
    }

    public final String a(String str, int i) {
        try {
            String genMusicURI = TXCopyrightedMedia.genMusicURI(str, i, a(this, (String) null, 1, (Object) null));
            Intrinsics.c(genMusicURI, "genMusicURI(musicId, bgmType, getBitrate())");
            return genMusicURI;
        } catch (Exception e) {
            return "";
        }
    }

    public final void a(Context context, String licenceUrl, String key) {
        Intrinsics.e(context, "context");
        Intrinsics.e(licenceUrl, "licenceUrl");
        Intrinsics.e(key, "key");
        TXCopyrightedMedia.instance().setLicense(context, licenceUrl, key);
    }

    public final void a(LiveMusicModel liveMusicModel) {
        this.y = liveMusicModel;
    }

    public final void a(TrtcAudioFrameModel trtcAudioFrameModel, boolean z) {
        if (!Intrinsics.a((Object) this.s, (Object) false) && trtcAudioFrameModel != null && trtcAudioFrameModel.d > 0 && z) {
            long j = trtcAudioFrameModel.d;
            long j2 = 200;
            ITXSongScore iTXSongScore = this.r;
            if (iTXSongScore == null) {
                return;
            }
            iTXSongScore.process(trtcAudioFrameModel.f11445a, trtcAudioFrameModel.f11445a.length, (float) (j - j2));
        }
    }

    public final void a(YYKtvMusicModel yYKtvMusicModel) {
        this.z = yYKtvMusicModel;
    }

    public final void a(Boolean bool) {
        this.s = bool;
    }

    public final void a(String key, ISongScoreListener callback) {
        Intrinsics.e(key, "key");
        Intrinsics.e(callback, "callback");
        this.D.put(key, callback);
    }

    public final void a(String key, MusicPlayMusicInfoCallback callback) {
        Intrinsics.e(key, "key");
        Intrinsics.e(callback, "callback");
        this.C.put(key, callback);
    }

    public final void a(final String str, String str2) {
        Logger.c(this.j, Intrinsics.a("trtc start play music id: ", (Object) str));
        TXCMMusicInfo tXCMMusicInfo = new TXCMMusicInfo(str, str2, 0);
        TXCopyrightedMedia tXCopyrightedMedia = this.p;
        this.q = tXCopyrightedMedia == null ? null : tXCopyrightedMedia.createMusicTrack(tXCMMusicInfo);
        LiveLogUtils.a(Intrinsics.a("播放k歌，创建音轨成功 music_id：", (Object) str));
        ITXCMMusicTrack iTXCMMusicTrack = this.q;
        if (iTXCMMusicTrack != null) {
            iTXCMMusicTrack.setOnPreparedListener(new ITXCMMusicTrack.OnPreparedListener() { // from class: com.blued.android.module.live.base.manager.-$$Lambda$YYMusicManager$ZkVVD4unpSS3dupYRTunFjGa1Fo
                @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack.OnPreparedListener
                public final void onPrepared() {
                    YYMusicManager.a(YYMusicManager.this, str);
                }
            });
        }
        ITXCMMusicTrack iTXCMMusicTrack2 = this.q;
        if (iTXCMMusicTrack2 != null) {
            iTXCMMusicTrack2.setOnErrorListener(new ITXCMMusicTrack.OnErrorListener() { // from class: com.blued.android.module.live.base.manager.-$$Lambda$YYMusicManager$YQrYcCqmEpF1741wgZKMbrJ8HIU
                @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack.OnErrorListener
                public final void onError(int i, String str3) {
                    YYMusicManager.a(YYMusicManager.this, i, str3);
                }
            });
        }
        ITXCMMusicTrack iTXCMMusicTrack3 = this.q;
        if (iTXCMMusicTrack3 == null) {
            return;
        }
        iTXCMMusicTrack3.prepare();
    }

    public final void a(String str, String str2, int i, int i2) {
        String lowerCase;
        String lowerCase2;
        StringBuilder sb = new StringBuilder();
        sb.append(AppMethods.b("/lrc"));
        sb.append((Object) File.separator);
        if (str == null) {
            lowerCase = null;
        } else {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        sb.append((Object) Md5.a(lowerCase));
        File file = new File(sb.toString());
        if (!file.exists()) {
            Logger.c(this.j, "ysd lyricFile did not exist");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AppMethods.b("/lrc"));
        sb2.append((Object) File.separator);
        if (str2 == null) {
            lowerCase2 = null;
        } else {
            lowerCase2 = str2.toLowerCase(Locale.ROOT);
            Intrinsics.c(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        sb2.append((Object) Md5.a(lowerCase2));
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            Logger.c(this.j, "ysd noteFile did not exist");
        }
        TXSongScoreConfig tXSongScoreConfig = new TXSongScoreConfig();
        tXSongScoreConfig.sampleRate = i;
        tXSongScoreConfig.channel = i2;
        tXSongScoreConfig.lyricFilePath = file.getAbsolutePath();
        tXSongScoreConfig.noteFilePath = file2.getAbsolutePath();
        if (this.r == null || !Intrinsics.a((Object) this.s, (Object) true)) {
            this.u = 1;
            this.B = 0;
            LogUtils.d(this.j, Intrinsics.a("config: ", (Object) AppInfo.f().toJson(tXSongScoreConfig)));
            ITXSongScore createSongScore = TXCopyrightedMedia.instance().createSongScore(tXSongScoreConfig);
            this.r = createSongScore;
            if (createSongScore != null) {
                createSongScore.setSongScoreCallback(new ITXSongScoreCallback() { // from class: com.blued.android.module.live.base.manager.YYMusicManager$startSongScore$1
                    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
                    public void onMIDIGroveAndHint(boolean z, float f, float f2, int i3) {
                        String str3;
                        str3 = YYMusicManager.this.j;
                        String a2 = Intrinsics.a(str3, (Object) "a");
                        LogUtils.d(a2, "isHit: " + z + ", timeStamp: " + f + ", pitch: " + f2 + ", viewValue: " + i3);
                        YYMusicManager.this.a(new YYUserSongScoreNoteItem(z, f, f2, i3));
                    }

                    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
                    public void onMIDISCoreUpdate(int i3, int i4, int i5) {
                        int i6;
                        String str3;
                        int i7;
                        int i8;
                        int i9 = (int) (i3 * 1.1f);
                        int i10 = i9;
                        if (i9 > 100) {
                            i10 = 100;
                        }
                        YYMusicManager yYMusicManager = YYMusicManager.this;
                        i6 = yYMusicManager.B;
                        yYMusicManager.B = i6 + i10;
                        str3 = YYMusicManager.this.j;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("currentScore: ");
                        sb3.append(i10);
                        sb3.append(", totalScore: ");
                        i7 = YYMusicManager.this.B;
                        sb3.append(i7);
                        sb3.append(", curIndex: ");
                        sb3.append(i5);
                        LogUtils.d(str3, sb3.toString());
                        YYMusicManager yYMusicManager2 = YYMusicManager.this;
                        i8 = yYMusicManager2.B;
                        yYMusicManager2.a(i10, i8, i5);
                    }

                    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
                    public void onMIDIScoreError(int i3, String errMsg) {
                        String str3;
                        ITXSongScore iTXSongScore;
                        Intrinsics.e(errMsg, "errMsg");
                        str3 = YYMusicManager.this.j;
                        LogUtils.d(str3, "errorCode: " + i3 + ", errMsg: " + errMsg);
                        YYMusicManager.this.a((Boolean) false);
                        YYMusicManager.this.t = -1;
                        YYMusicManager.this.u = 1;
                        iTXSongScore = YYMusicManager.this.r;
                        if (iTXSongScore == null) {
                            return;
                        }
                        iTXSongScore.destroy();
                    }

                    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
                    public void onMIDIScoreFinish(int[] scoreArray, int i3) {
                        String str3;
                        ITXSongScore iTXSongScore;
                        String str4;
                        Intrinsics.e(scoreArray, "scoreArray");
                        str3 = YYMusicManager.this.j;
                        LogUtils.d(Intrinsics.a(str3, (Object) "a"), Intrinsics.a("onMIDIScoreFinish: totalScore: ", (Object) Integer.valueOf(i3)));
                        int length = scoreArray.length;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length) {
                                break;
                            }
                            str4 = YYMusicManager.this.j;
                            String a2 = Intrinsics.a(str4, (Object) "a");
                            Logger.c(a2, "score[" + i5 + "] = " + scoreArray[i5]);
                            i4 = i5 + 1;
                        }
                        YYMusicManager.this.a((Boolean) false);
                        YYMusicManager.this.t = -1;
                        YYMusicManager.this.u = 1;
                        YYMusicManager.this.B = 0;
                        iTXSongScore = YYMusicManager.this.r;
                        if (iTXSongScore == null) {
                            return;
                        }
                        iTXSongScore.destroy();
                    }

                    @Override // com.tencent.txcopyrightedmedia.ITXSongScoreCallback
                    public void onMIDIScorePrepared() {
                        String str3;
                        ITXSongScore iTXSongScore;
                        ITXSongScore iTXSongScore2;
                        TXSongScoreNoteItem[] allGrove;
                        String str4;
                        str3 = YYMusicManager.this.j;
                        LogUtils.d(str3, "onMIDIScorePrepared");
                        ArrayList arrayList = new ArrayList();
                        iTXSongScore = YYMusicManager.this.r;
                        if (iTXSongScore != null && (allGrove = iTXSongScore.getAllGrove()) != null) {
                            YYMusicManager yYMusicManager = YYMusicManager.this;
                            for (TXSongScoreNoteItem tXSongScoreNoteItem : allGrove) {
                                str4 = yYMusicManager.j;
                                LogUtils.d(Intrinsics.a(str4, (Object) "a"), tXSongScoreNoteItem.toString());
                                YYTXSongScoreNoteItem yYTXSongScoreNoteItem = new YYTXSongScoreNoteItem();
                                yYTXSongScoreNoteItem.b = tXSongScoreNoteItem.duration;
                                yYTXSongScoreNoteItem.f11447a = tXSongScoreNoteItem.startTime;
                                yYTXSongScoreNoteItem.f11448c = tXSongScoreNoteItem.endTime;
                                yYTXSongScoreNoteItem.d = tXSongScoreNoteItem.noteHeight;
                                arrayList.add(yYTXSongScoreNoteItem);
                            }
                        }
                        iTXSongScore2 = YYMusicManager.this.r;
                        if (iTXSongScore2 != null) {
                            YYMusicManager.this.b(iTXSongScore2.calculateTotalScore());
                        }
                        YYMusicManager.this.a((Boolean) true);
                        YYMusicManager.this.a((ArrayList<YYTXSongScoreNoteItem>) arrayList);
                    }
                });
            }
            ITXSongScore iTXSongScore = this.r;
            if (iTXSongScore == null) {
                return;
            }
            iTXSongScore.prepare();
        }
    }

    public final void a(String str, String str2, ITXMusicPreloadCallback callback) {
        Intrinsics.e(callback, "callback");
        TXCopyrightedMedia tXCopyrightedMedia = this.p;
        if (tXCopyrightedMedia == null) {
            return;
        }
        tXCopyrightedMedia.preloadMusic(str, a(this, (String) null, 1, (Object) null), str2, callback);
    }

    public final void a(String str, String str2, final boolean z) {
        ITXMusicPreloadCallback iTXMusicPreloadCallback = new ITXMusicPreloadCallback() { // from class: com.blued.android.module.live.base.manager.YYMusicManager$getMusicInfo$call$1
            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadComplete(String str3, String str4, int i, String str5) {
                if (!z) {
                    YYMusicManager.this.a(str3, str4, i, str5);
                } else if (i == YYMusicManager.f11418a.a()) {
                    String str6 = str3;
                    if (TextUtils.equals(str6, str6)) {
                        YYMusicManager.this.a(str3, str4);
                    }
                }
            }

            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadProgress(String str3, String str4, float f) {
                YYMusicManager.this.a(str3, str4, f);
            }

            @Override // com.tencent.txcopyrightedmedia.ITXMusicPreloadCallback
            public void onPreloadStart(String str3, String str4) {
                YYMusicManager.this.b(str3, str4);
            }
        };
        TXCopyrightedMedia tXCopyrightedMedia = this.p;
        boolean z2 = false;
        if (tXCopyrightedMedia != null && tXCopyrightedMedia.isMusicPreloaded(str, a(this, (String) null, 1, (Object) null))) {
            z2 = true;
        }
        if (z2) {
            a(str, a(this, (String) null, 1, (Object) null));
        } else {
            a(str, str2, iTXMusicPreloadCallback);
        }
    }

    public final void a(List<? extends YYKtvMusicModel> list) {
        this.A = list;
    }

    public final void a(boolean z, String str, String str2) {
        this.v = z;
        this.x = str;
        this.w = str2;
        if (!z) {
            TXCopyrightedMedia.instance().setExtInfo(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE, TXCopyrightedMedia.PLAY_SCENE_CHAT);
            return;
        }
        TXCopyrightedMedia.instance().setExtInfo(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE, TXCopyrightedMedia.PLAY_SCENE_LIVE);
        TXCopyrightedMedia.instance().setExtInfo(TXCopyrightedMedia.EXT_INFO_ROOM_ID, e());
    }

    public final YYKtvMusicModel b() {
        return this.z;
    }

    public final boolean b(String musicId) {
        Intrinsics.e(musicId, "musicId");
        TXCopyrightedMedia tXCopyrightedMedia = this.p;
        if (tXCopyrightedMedia == null) {
            return false;
        }
        return tXCopyrightedMedia.isMusicPreloaded(musicId, a(this, (String) null, 1, (Object) null));
    }

    public final void c(String str) {
        TXCopyrightedMedia tXCopyrightedMedia = this.p;
        if (tXCopyrightedMedia == null) {
            return;
        }
        tXCopyrightedMedia.cancelPreloadMusic(str, a(this, (String) null, 1, (Object) null));
    }

    public final boolean c() {
        return this.v;
    }

    public final String d() {
        return this.w;
    }

    public final void d(String key) {
        Intrinsics.e(key, "key");
        this.C.remove(key);
    }

    public final String e() {
        return this.x;
    }

    public final void e(String key) {
        Intrinsics.e(key, "key");
        this.D.remove(key);
    }

    public final void f() {
        LogUtils.d(this.j, "onDestroy ...... ");
        this.r = null;
        this.q = null;
        this.s = false;
    }

    public final void g() {
        ITXCMMusicTrack iTXCMMusicTrack = this.q;
        if (iTXCMMusicTrack != null) {
            iTXCMMusicTrack.stop();
            iTXCMMusicTrack.destroy();
        }
        ITXSongScore iTXSongScore = this.r;
        if (iTXSongScore == null) {
            return;
        }
        iTXSongScore.finish();
    }

    public final String h() {
        return this.E;
    }

    public final String i() {
        return this.F;
    }

    public final String j() {
        return this.G;
    }

    public final String k() {
        return this.H;
    }

    public final String l() {
        return this.I;
    }
}
