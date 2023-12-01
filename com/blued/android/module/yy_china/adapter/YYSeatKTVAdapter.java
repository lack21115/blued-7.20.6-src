package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYKtvSongListDialog;
import com.blued.android.module.yy_china.fragment.YYKtvVoiceDialog;
import com.blued.android.module.yy_china.lrc.model.LineInfo;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYConfiguredResourcesModel;
import com.blued.android.module.yy_china.model.YYGiftBeansModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYKtvStageModel;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMsgKtvSinger;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YyImSong1MlateTogiftModel;
import com.blued.android.module.yy_china.observer.NewGiftComesObserver;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.SurfaceRhythmView;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYImListView;
import com.blued.android.module.yy_china.view.YYKtvMusicGiftView;
import com.blued.android.module.yy_china.view.YYKtvMusicProView;
import com.blued.android.module.yy_china.view.YYMemberKtvView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.ktv.method.lrc.LyricsReader;
import com.ktv.method.lrc.widget.LyricsView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatKTVAdapter.class */
public final class YYSeatKTVAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements View.OnClickListener, ImageLoader.OnAnimationStateListener, NewGiftComesObserver, SeatChangedObserver {
    private ConstraintLayout A;
    private LinearLayout B;
    private ConstraintLayout C;
    private ShapeFrameLayout D;
    private LinearLayout E;
    private ConstraintLayout F;
    private HollowView G;
    private ImageView H;
    private TextView I;
    private LinearLayout J;
    private final ArrayList<ShapeTextView> K;
    private YYRoomModel L;
    private HashMap<Integer, YYMemberKtvView> M;
    private int N;
    private int O;
    private BaseYYStudioFragment a;
    private ShapeTextView b;
    private ShapeTextView c;
    private ShapeTextView d;
    private ShapeTextView e;
    private ImageView f;
    private ShapeTextView g;
    private ShapeTextView h;
    private ShapeTextView i;
    private ShapeTextView j;
    private ShapeableImageView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private YYKtvMusicProView o;
    private YYKtvMusicGiftView p;
    private ShapeableImageView q;
    private ShapeableImageView r;
    private TextView s;
    private LyricsView t;
    private RelativeLayout u;
    private SurfaceRhythmView v;
    private ImageView w;
    private LinearLayout x;
    private ConstraintLayout y;
    private ConstraintLayout z;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatKTVAdapter$LrcAsyncTask.class */
    final class LrcAsyncTask extends AsyncTask<Object, Object, ArrayList<LineInfo>> {
        final /* synthetic */ YYSeatKTVAdapter a;
        private final File b;
        private final LyricsReader c;

        public LrcAsyncTask(YYSeatKTVAdapter this$0, File file, LyricsReader mLyricsReader) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(file, "file");
            Intrinsics.e(mLyricsReader, "mLyricsReader");
            this.a = this$0;
            this.b = file;
            this.c = mLyricsReader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: Exception -> 0x00cc, all -> 0x00e8, TRY_ENTER, TryCatch #0 {Exception -> 0x00cc, blocks: (B:12:0x002f, B:14:0x004d, B:17:0x005a, B:19:0x006a, B:21:0x0072), top: B:36:0x002f, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.ArrayList<com.blued.android.module.yy_china.lrc.model.LineInfo> doInBackground(java.lang.Object[] r8) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter.LrcAsyncTask.doInBackground(java.lang.Object[]):java.util.ArrayList");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(ArrayList<LineInfo> arrayList) {
            LyricsView lyricsView;
            BaseYYStudioFragment baseYYStudioFragment = this.a.a;
            boolean z = false;
            if (baseYYStudioFragment != null && baseYYStudioFragment.isDetached()) {
                z = true;
            }
            if (z || (lyricsView = this.a.t) == null) {
                return;
            }
            lyricsView.setLyricsReader(this.c);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatKTVAdapter$ProgressRange.class */
    public enum ProgressRange {
        HALF,
        WHOLE,
        NONE
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatKTVAdapter$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ProgressRange.values().length];
            iArr[ProgressRange.HALF.ordinal()] = 1;
            iArr[ProgressRange.WHOLE.ordinal()] = 2;
            iArr[ProgressRange.NONE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSeatKTVAdapter(Context context, BaseYYStudioFragment fragmentActive) {
        super(null);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.K = new ArrayList<>();
        this.mContext = context;
        this.a = fragmentActive;
        addItemType(8, R.layout.item_yy_connecting_ktv_layout);
        this.L = YYRoomInfoManager.e().b();
        this.M = new HashMap<>();
    }

    private final void A() {
        final BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment == null || baseYYStudioFragment.Y.getVisibility() == 0) {
            return;
        }
        baseYYStudioFragment.X.setVisibility(0);
        baseYYStudioFragment.Z.setVisibility(0);
        ImageLoader.c(baseYYStudioFragment.getFragmentActive(), "ktv_scan_light.png").f().g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter$showStageBackgroundEffect$1$1
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                YYRoomModel yYRoomModel;
                YYConfiguredResourcesModel yYConfiguredResourcesModel;
                String str;
                BaseYYStudioFragment.this.Y.setVisibility(0);
                yYRoomModel = this.L;
                if (yYRoomModel == null || (yYConfiguredResourcesModel = yYRoomModel.resourcesModel) == null || (str = yYConfiguredResourcesModel.top_arrow_light) == null) {
                    return;
                }
                BaseYYStudioFragment baseYYStudioFragment2 = BaseYYStudioFragment.this;
                ImageLoader.a(baseYYStudioFragment2.getFragmentActive(), str).f().g(-1).a(baseYYStudioFragment2.X);
            }
        }).a(baseYYStudioFragment.X);
    }

    private final void B() {
        YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
        Integer num = null;
        Integer valueOf = yYKtvMusicGiftView == null ? null : Integer.valueOf(yYKtvMusicGiftView.getMaxProgressBar());
        YYKtvMusicGiftView yYKtvMusicGiftView2 = this.p;
        if (yYKtvMusicGiftView2 != null) {
            num = Integer.valueOf(yYKtvMusicGiftView2.getCurrentProgress());
        }
        if (valueOf == null || num == null) {
            return;
        }
        if (num.intValue() >= valueOf.intValue() / 2 && num.intValue() < valueOf.intValue()) {
            a(ProgressRange.HALF);
        } else if (num.intValue() < valueOf.intValue()) {
            a(ProgressRange.NONE);
        } else {
            a(ProgressRange.WHOLE);
            YYKtvMusicProView yYKtvMusicProView = this.o;
            boolean z = false;
            if (yYKtvMusicProView != null && yYKtvMusicProView.b()) {
                z = true;
            }
            if (z) {
                A();
            }
        }
    }

    private final void C() {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        Integer num = null;
        Integer valueOf = yYKtvMusicProView == null ? null : Integer.valueOf(yYKtvMusicProView.getMaxProgressBar());
        YYKtvMusicProView yYKtvMusicProView2 = this.o;
        if (yYKtvMusicProView2 != null) {
            num = Integer.valueOf(yYKtvMusicProView2.getCurrentProgress());
        }
        if (valueOf == null || num == null) {
            return;
        }
        if (num.intValue() > valueOf.intValue() / 2 && num.intValue() < valueOf.intValue()) {
            b(ProgressRange.HALF);
        } else if (num.intValue() < valueOf.intValue()) {
            b(ProgressRange.NONE);
        } else {
            b(ProgressRange.WHOLE);
            YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
            boolean z = false;
            if (yYKtvMusicGiftView != null && yYKtvMusicGiftView.a()) {
                z = true;
            }
            if (z) {
                A();
            }
        }
    }

    private final int D() {
        YYKtvStageModel yYKtvStageModel;
        YYRoomModel yYRoomModel = this.L;
        String str = null;
        if (yYRoomModel != null && (yYKtvStageModel = yYRoomModel.stage_info) != null) {
            str = yYKtvStageModel.lowest_score;
        }
        return StringUtils.a(str, 0);
    }

    private final int E() {
        YYKtvStageModel yYKtvStageModel;
        YYRoomModel yYRoomModel = this.L;
        String str = null;
        if (yYRoomModel != null && (yYKtvStageModel = yYRoomModel.stage_info) != null) {
            str = yYKtvStageModel.reach_beans;
        }
        return StringUtils.a(str, 0);
    }

    private final int F() {
        YYKtvStageModel yYKtvStageModel;
        YYRoomModel yYRoomModel = this.L;
        String str = null;
        if (yYRoomModel != null && (yYKtvStageModel = yYRoomModel.stage_info) != null) {
            str = yYKtvStageModel.total_score;
        }
        return (int) ((StringUtils.a(str, 0.0f) * D()) / 100.0d);
    }

    private final void a(int i, View view) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.L;
        if (yYRoomModel2 != null) {
            List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
            if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.L) == null || (list = yYRoomModel.mics) == null || i > list.size() - 1 || i < 0) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i);
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            if (baseYYStudioFragment == null) {
                return;
            }
            baseYYStudioFragment.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
        }
    }

    private final void a(int i, YYSeatMemberModel yYSeatMemberModel) {
        HashMap<Integer, YYMemberKtvView> hashMap = this.M;
        ActivityFragmentActive activityFragmentActive = null;
        YYMemberKtvView yYMemberKtvView = hashMap == null ? null : hashMap.get(Integer.valueOf(i));
        if (yYMemberKtvView == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment != null) {
            activityFragmentActive = baseYYStudioFragment.getFragmentActive();
        }
        yYMemberKtvView.a(yYSeatMemberModel, activityFragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void a(ProgressRange progressRange) {
        YYConfiguredResourcesModel yYConfiguredResourcesModel;
        YYConfiguredResourcesModel yYConfiguredResourcesModel2;
        String str;
        YYConfiguredResourcesModel yYConfiguredResourcesModel3;
        YYConfiguredResourcesModel yYConfiguredResourcesModel4;
        YYConfiguredResourcesModel yYConfiguredResourcesModel5;
        String str2;
        YYConfiguredResourcesModel yYConfiguredResourcesModel6;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment == null) {
            return;
        }
        if (baseYYStudioFragment.V.getVisibility() != 0) {
            baseYYStudioFragment.V.setVisibility(0);
        }
        ImageView imageView = baseYYStudioFragment.V;
        Object tag = imageView == null ? null : imageView.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str3 = (String) tag;
        int i = WhenMappings.a[progressRange.ordinal()];
        if (i == 1) {
            String str4 = str3;
            YYRoomModel yYRoomModel = this.L;
            if (TextUtils.equals(str4, (yYRoomModel == null || (yYConfiguredResourcesModel = yYRoomModel.resourcesModel) == null) ? null : yYConfiguredResourcesModel.top_light_single)) {
                return;
            }
            ImageView imageView2 = baseYYStudioFragment.V;
            if (imageView2 != null) {
                YYRoomModel yYRoomModel2 = this.L;
                imageView2.setTag((yYRoomModel2 == null || (yYConfiguredResourcesModel3 = yYRoomModel2.resourcesModel) == null) ? null : yYConfiguredResourcesModel3.top_light_single);
            }
            YYRoomModel yYRoomModel3 = this.L;
            if (yYRoomModel3 == null || (yYConfiguredResourcesModel2 = yYRoomModel3.resourcesModel) == null || (str = yYConfiguredResourcesModel2.top_light_single) == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment2 = this.a;
            ImageLoader.a(baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive(), str).g(-1).f().a(baseYYStudioFragment.V);
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            baseYYStudioFragment.V.setVisibility(8);
        } else {
            String str5 = str3;
            YYRoomModel yYRoomModel4 = this.L;
            if (TextUtils.equals(str5, (yYRoomModel4 == null || (yYConfiguredResourcesModel4 = yYRoomModel4.resourcesModel) == null) ? null : yYConfiguredResourcesModel4.top_light)) {
                return;
            }
            ImageView imageView3 = baseYYStudioFragment.V;
            if (imageView3 != null) {
                YYRoomModel yYRoomModel5 = this.L;
                imageView3.setTag((yYRoomModel5 == null || (yYConfiguredResourcesModel6 = yYRoomModel5.resourcesModel) == null) ? null : yYConfiguredResourcesModel6.top_light);
            }
            YYRoomModel yYRoomModel6 = this.L;
            if (yYRoomModel6 == null || (yYConfiguredResourcesModel5 = yYRoomModel6.resourcesModel) == null || (str2 = yYConfiguredResourcesModel5.top_light) == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment3 = this.a;
            ImageLoader.a(baseYYStudioFragment3 == null ? null : baseYYStudioFragment3.getFragmentActive(), str2).g(-1).f().a(baseYYStudioFragment.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYSeatKTVAdapter this$0, View view) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel yYRoomModel = this$0.L;
        if (yYRoomModel == null || (yYMsgKtvMusic = yYRoomModel.music) == null) {
            return;
        }
        String str = null;
        if (TextUtils.equals(yYMsgKtvMusic.isOriginal, "0")) {
            LiveEventBus.get("event_ktv_out_loud").post("4");
            yYMsgKtvMusic.isOriginal = "1";
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_ACCOMPANIMENT_CLICK;
            YYRoomModel yYRoomModel2 = this$0.L;
            String str2 = yYRoomModel2 == null ? null : yYRoomModel2.room_id;
            YYRoomModel yYRoomModel3 = this$0.L;
            if (yYRoomModel3 != null) {
                str = yYRoomModel3.uid;
            }
            EventTrackYY.k(event, str2, str, yYMsgKtvMusic.musicId);
            AudioChannelManager.j().a(4443, 4444, false);
        } else {
            LiveEventBus.get("event_ktv_out_loud").post("5");
            yYMsgKtvMusic.isOriginal = "0";
            ChatRoomProtos.Event event2 = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_SING_CLICK;
            YYRoomModel yYRoomModel4 = this$0.L;
            String str3 = yYRoomModel4 == null ? null : yYRoomModel4.room_id;
            YYRoomModel yYRoomModel5 = this$0.L;
            EventTrackYY.k(event2, str3, yYRoomModel5 == null ? null : yYRoomModel5.uid, yYMsgKtvMusic.musicId);
            AudioChannelManager.j().a(4443, 4444, true);
        }
        this$0.a(Boolean.valueOf(TextUtils.equals("0", yYMsgKtvMusic.isOriginal)));
    }

    private final void a(YYMsgKtvMusic yYMsgKtvMusic) {
        YYKtvStageModel yYKtvStageModel;
        YYKtvStageModel yYKtvStageModel2;
        if (yYMsgKtvMusic == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYMsgKtvMusic.coverUrl).a((ImageView) this.k);
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(yYMsgKtvMusic.musicName);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
            textView2.setText(simpleDateFormat == null ? null : simpleDateFormat.format(Long.valueOf(yYMsgKtvMusic.duration)));
        }
        a(Boolean.valueOf(TextUtils.equals(yYMsgKtvMusic.isOriginal, "0")));
        BaseYYStudioFragment baseYYStudioFragment2 = this.a;
        ImageLoader.a(baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive(), yYMsgKtvMusic.avatar).b(R.drawable.user_bg_round).a((ImageView) this.r);
        if (!TextUtils.equals(YYRoomInfoManager.e().k(), yYMsgKtvMusic.uid)) {
            ShapeTextView shapeTextView = this.d;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            SurfaceRhythmView surfaceRhythmView = this.v;
            if (surfaceRhythmView != null) {
                surfaceRhythmView.setVisibility(8);
            }
            ShapeTextView shapeTextView2 = this.g;
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(8);
            }
            ShapeTextView shapeTextView3 = this.h;
            if (shapeTextView3 != null) {
                shapeTextView3.setVisibility(8);
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            a(true);
            YYRoomModel yYRoomModel = this.L;
            if ((yYRoomModel == null || (yYKtvStageModel = yYRoomModel.stage_info) == null || yYKtvStageModel.status != 1) ? false : true) {
                LyricsView lyricsView = this.t;
                if (lyricsView == null) {
                    return;
                }
                lyricsView.setHost(true);
                return;
            }
            s();
            LyricsView lyricsView2 = this.t;
            if (lyricsView2 == null) {
                return;
            }
            lyricsView2.setHost(false);
            return;
        }
        ShapeTextView shapeTextView4 = this.d;
        if (shapeTextView4 != null) {
            shapeTextView4.setVisibility(0);
        }
        ShapeTextView shapeTextView5 = this.g;
        if (shapeTextView5 != null) {
            shapeTextView5.setVisibility(0);
        }
        ShapeTextView shapeTextView6 = this.h;
        if (shapeTextView6 != null) {
            shapeTextView6.setVisibility(0);
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        a(false);
        YYRoomModel yYRoomModel2 = this.L;
        if ((yYRoomModel2 == null || (yYKtvStageModel2 = yYRoomModel2.stage_info) == null || yYKtvStageModel2.status != 1) ? false : true) {
            RelativeLayout relativeLayout2 = this.u;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            SurfaceRhythmView surfaceRhythmView2 = this.v;
            if (surfaceRhythmView2 != null) {
                surfaceRhythmView2.setVisibility(8);
            }
            LyricsView lyricsView3 = this.t;
            if (lyricsView3 == null) {
                return;
            }
            lyricsView3.setHost(true);
            return;
        }
        t();
        LyricsView lyricsView4 = this.t;
        if (lyricsView4 != null) {
            lyricsView4.setHost(true);
        }
        RelativeLayout relativeLayout3 = this.u;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
        }
        SurfaceRhythmView surfaceRhythmView3 = this.v;
        if (surfaceRhythmView3 == null) {
            return;
        }
        surfaceRhythmView3.setVisibility(0);
    }

    private final String b(Boolean bool) {
        Resources resources;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment == null || (resources = baseYYStudioFragment.getResources()) == null) {
            return null;
        }
        return resources.getString(Intrinsics.a((Object) bool, (Object) true) ? R.string.yy_ktv_music_original : R.string.yy_ktv_music_accompany);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        LiveEventBus.get("event_ktv_pick_music").post("");
    }

    private final void b(ProgressRange progressRange) {
        YYConfiguredResourcesModel yYConfiguredResourcesModel;
        YYConfiguredResourcesModel yYConfiguredResourcesModel2;
        String str;
        YYConfiguredResourcesModel yYConfiguredResourcesModel3;
        YYConfiguredResourcesModel yYConfiguredResourcesModel4;
        YYConfiguredResourcesModel yYConfiguredResourcesModel5;
        String str2;
        YYConfiguredResourcesModel yYConfiguredResourcesModel6;
        ImageView imageView;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment == null) {
            return;
        }
        if (baseYYStudioFragment.W.getVisibility() != 0) {
            baseYYStudioFragment.W.setVisibility(0);
        }
        ImageView imageView2 = baseYYStudioFragment.W;
        if ((imageView2 == null ? null : imageView2.getTag()) == null && (imageView = baseYYStudioFragment.W) != null) {
            imageView.setTag("");
        }
        ImageView imageView3 = baseYYStudioFragment.W;
        Object tag = imageView3 == null ? null : imageView3.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str3 = (String) tag;
        int i = WhenMappings.a[progressRange.ordinal()];
        if (i == 1) {
            String str4 = str3;
            YYRoomModel yYRoomModel = this.L;
            if (TextUtils.equals(str4, (yYRoomModel == null || (yYConfiguredResourcesModel = yYRoomModel.resourcesModel) == null) ? null : yYConfiguredResourcesModel.foot_light_single)) {
                return;
            }
            LogUtils.d(BaseConnectingAdapter.TAG, "show half lights ... ");
            ImageView imageView4 = baseYYStudioFragment.W;
            if (imageView4 != null) {
                YYRoomModel yYRoomModel2 = this.L;
                imageView4.setTag((yYRoomModel2 == null || (yYConfiguredResourcesModel3 = yYRoomModel2.resourcesModel) == null) ? null : yYConfiguredResourcesModel3.foot_light_single);
            }
            YYRoomModel yYRoomModel3 = this.L;
            if (yYRoomModel3 == null || (yYConfiguredResourcesModel2 = yYRoomModel3.resourcesModel) == null || (str = yYConfiguredResourcesModel2.foot_light_single) == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment2 = this.a;
            ImageLoader.a(baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive(), str).g(-1).f().a(baseYYStudioFragment.W);
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ImageView imageView5 = baseYYStudioFragment.W;
            if (imageView5 != null) {
                imageView5.setTag("");
            }
            ImageView imageView6 = baseYYStudioFragment.W;
            if (imageView6 == null) {
                return;
            }
            imageView6.setVisibility(8);
        } else {
            String str5 = str3;
            YYRoomModel yYRoomModel4 = this.L;
            if (TextUtils.equals(str5, (yYRoomModel4 == null || (yYConfiguredResourcesModel4 = yYRoomModel4.resourcesModel) == null) ? null : yYConfiguredResourcesModel4.foot_light)) {
                return;
            }
            LogUtils.d(BaseConnectingAdapter.TAG, "show all lights ... ");
            ImageView imageView7 = baseYYStudioFragment.W;
            if (imageView7 != null) {
                YYRoomModel yYRoomModel5 = this.L;
                imageView7.setTag((yYRoomModel5 == null || (yYConfiguredResourcesModel6 = yYRoomModel5.resourcesModel) == null) ? null : yYConfiguredResourcesModel6.foot_light);
            }
            YYRoomModel yYRoomModel6 = this.L;
            if (yYRoomModel6 == null || (yYConfiguredResourcesModel5 = yYRoomModel6.resourcesModel) == null || (str2 = yYConfiguredResourcesModel5.foot_light) == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment3 = this.a;
            ImageLoader.a(baseYYStudioFragment3 == null ? null : baseYYStudioFragment3.getFragmentActive(), str2).g(-1).f().a(baseYYStudioFragment.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYSeatKTVAdapter this$0, View view) {
        FragmentManager parentFragmentManager;
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_TONE_CLICK;
        YYRoomModel yYRoomModel = this$0.L;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.L;
        String str3 = yYRoomModel2 == null ? null : yYRoomModel2.uid;
        YYRoomModel yYRoomModel3 = this$0.L;
        if (yYRoomModel3 != null && (yYMsgKtvMusic = yYRoomModel3.music) != null) {
            str = yYMsgKtvMusic.musicId;
        }
        EventTrackYY.k(event, str2, str3, str);
        YYKtvVoiceDialog yYKtvVoiceDialog = new YYKtvVoiceDialog();
        BaseYYStudioFragment baseYYStudioFragment = this$0.a;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        yYKtvVoiceDialog.show(parentFragmentManager, "show_voice_dialog");
    }

    private final void b(boolean z) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.C);
        constraintSet.clear(R.id.ll_empty_song, 3);
        constraintSet.clear(R.id.ll_empty_song, 4);
        constraintSet.clear(R.id.ll_prepare_view, 3);
        constraintSet.clear(R.id.ll_prepare_view, 4);
        LinearLayout.LayoutParams layoutParams = null;
        if (z) {
            ShapeTextView shapeTextView = this.b;
            if (shapeTextView != null) {
                layoutParams = shapeTextView.getLayoutParams();
            }
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            layoutParams.topMargin = 0;
            LinearLayout linearLayout = this.x;
            if (linearLayout != null) {
                linearLayout.setGravity(17);
            }
            constraintSet.connect(R.id.ll_empty_song, 4, R.id.ll_normal_view, 4);
            constraintSet.connect(R.id.ll_empty_song, 3, R.id.ll_normal_view, 3);
            constraintSet.connect(R.id.ll_prepare_view, 4, R.id.ll_normal_view, 4);
            constraintSet.connect(R.id.ll_prepare_view, 3, R.id.ll_normal_view, 3);
        } else {
            if (YYRoomInfoManager.e().y()) {
                ShapeTextView shapeTextView2 = this.b;
                ViewGroup.LayoutParams layoutParams2 = shapeTextView2 == null ? null : shapeTextView2.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                ((LinearLayout.LayoutParams) layoutParams2).topMargin = DensityUtils.a(this.mContext, 45.0f);
            } else {
                ShapeTextView shapeTextView3 = this.b;
                ViewGroup.LayoutParams layoutParams3 = shapeTextView3 == null ? null : shapeTextView3.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                ((LinearLayout.LayoutParams) layoutParams3).topMargin = DensityUtils.a(this.mContext, 25.0f);
            }
            LinearLayout linearLayout2 = this.x;
            if (linearLayout2 != null) {
                linearLayout2.setGravity(1);
            }
            constraintSet.connect(R.id.ll_empty_song, 4, R.id.img_stage_bg, 4);
            constraintSet.connect(R.id.ll_empty_song, 3, R.id.img_stage_bg, 3);
            constraintSet.connect(R.id.ll_prepare_view, 4, R.id.img_stage_bg, 4);
            constraintSet.connect(R.id.ll_prepare_view, 3, R.id.img_stage_bg, 3);
        }
        constraintSet.applyTo(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view) {
        LiveEventBus.get("event_ktv_pick_music").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYSeatKTVAdapter this$0, View view) {
        String str;
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_GIVE_UP_CLICK;
        YYRoomModel yYRoomModel = this$0.L;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.L;
        String str3 = yYRoomModel2 == null ? null : yYRoomModel2.uid;
        YYRoomModel yYRoomModel3 = this$0.L;
        if (yYRoomModel3 == null) {
            str = null;
        } else {
            YYMsgKtvMusic yYMsgKtvMusic = yYRoomModel3.music;
            str = yYMsgKtvMusic == null ? null : yYMsgKtvMusic.musicId;
        }
        EventTrackYY.k(event, str2, str3, str);
        LiveEventBus.get("event_ktv_give_up").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYSeatKTVAdapter this$0, View view) {
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        YYKtvSongListDialog yYKtvSongListDialog = new YYKtvSongListDialog();
        BaseYYStudioFragment baseYYStudioFragment = this$0.a;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        yYKtvSongListDialog.show(parentFragmentManager, "open_song_list_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYSeatKTVAdapter this$0, View view) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel;
        YYImListView yYImListView;
        YYImMsgAdapter yYImMsgAdapter;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYMsgKtvMusic = b.music) == null || (yyImSong1MlateTogiftModel = yYMsgKtvMusic.songApplaud) == null) {
            return;
        }
        YYGiftModel yYGiftModel = yyImSong1MlateTogiftModel.android_goods_info;
        Intrinsics.c(yYGiftModel, "it.android_goods_info");
        BaseYYStudioFragment baseYYStudioFragment = this$0.a;
        if (baseYYStudioFragment == null || (yYImListView = baseYYStudioFragment.l) == null || (yYImMsgAdapter = yYImListView.a) == null) {
            return;
        }
        yYImMsgAdapter.a(yYGiftModel, "", false, yyImSong1MlateTogiftModel.host_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYSeatKTVAdapter this$0, View view) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel;
        YYImListView yYImListView;
        YYImMsgAdapter yYImMsgAdapter;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYMsgKtvMusic = b.music) == null || (yyImSong1MlateTogiftModel = yYMsgKtvMusic.songApplaud) == null || yyImSong1MlateTogiftModel.isClick) {
            return;
        }
        yyImSong1MlateTogiftModel.isClick = true;
        BaseYYStudioFragment baseYYStudioFragment = this$0.a;
        if (baseYYStudioFragment != null && (yYImListView = baseYYStudioFragment.l) != null && (yYImMsgAdapter = yYImListView.a) != null) {
            yYImMsgAdapter.notifyDataSetChanged();
        }
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().music == null) {
            ToastUtils.a(R.string.yy_toa_ktv_gz_more);
            return;
        }
        YYMsgKtvMusic yYMsgKtvMusic2 = YYRoomInfoManager.e().b().music;
        if (!Intrinsics.a((Object) yYMsgKtvMusic2.uid, (Object) yyImSong1MlateTogiftModel.host_id) || !Intrinsics.a((Object) yYMsgKtvMusic2.musicName, (Object) yyImSong1MlateTogiftModel.music_name)) {
            ToastUtils.a(R.string.yy_toa_ktv_gz_more);
            return;
        }
        String str = YYRoomInfoManager.e().b().room_id;
        String str2 = yyImSong1MlateTogiftModel.choosed_id;
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>() { // from class: com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter$initListening$8$1$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LiveEventBus.get("event_ktv_show_applaud").post("");
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.a;
        Intrinsics.a(baseYYStudioFragment2);
        YYRoomHttpUtils.b(str, str2, (BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2.getFragmentActive());
    }

    private final void g(int i) {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        boolean z = false;
        if (yYKtvMusicProView != null && !yYKtvMusicProView.b()) {
            z = true;
        }
        int D = z ? D() : YYRoomInfoManager.e().d(i);
        LogUtils.d("ktv", Intrinsics.a("average score：", (Object) Integer.valueOf(D)));
        d(D);
    }

    private final void k() {
        ShapeTextView shapeTextView = this.b;
        if (shapeTextView != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$eo0H9ioCJhb5cLa9D1ROrH23BBw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.b(view);
                }
            });
        }
        ShapeTextView shapeTextView2 = this.h;
        if (shapeTextView2 != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$0t8prVNxVBZFUibtEaYrq9wKsko
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.a(YYSeatKTVAdapter.this, view);
                }
            });
        }
        ShapeTextView shapeTextView3 = this.g;
        if (shapeTextView3 != null) {
            shapeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$8exr4rkfIQJWlx9URMlC02Rq4_o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.b(YYSeatKTVAdapter.this, view);
                }
            });
        }
        ShapeTextView shapeTextView4 = this.d;
        if (shapeTextView4 != null) {
            shapeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$fyESIrj3Ik81WHoWdcT8UN_043E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.c(YYSeatKTVAdapter.this, view);
                }
            });
        }
        ShapeTextView shapeTextView5 = this.c;
        if (shapeTextView5 != null) {
            shapeTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$mP9uDV3J3JX1Y5UXBobzRjgzHLU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.d(YYSeatKTVAdapter.this, view);
                }
            });
        }
        ShapeTextView shapeTextView6 = this.j;
        if (shapeTextView6 != null) {
            shapeTextView6.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$oESABICbrLDQAacqQ7Gk7-BMy6o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.c(view);
                }
            });
        }
        HollowView hollowView = this.G;
        if (hollowView != null) {
            hollowView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$CyVQbb5HyN7c1NWzBdtcyFDmgqo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYSeatKTVAdapter.e(YYSeatKTVAdapter.this, view);
                }
            });
        }
        ShapeTextView shapeTextView7 = this.e;
        if (shapeTextView7 == null) {
            return;
        }
        shapeTextView7.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$BI9-_Rq2B0265CZ5Fv4wbhZZqq0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSeatKTVAdapter.f(YYSeatKTVAdapter.this, view);
            }
        });
    }

    private final void l() {
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        ImageLoader.c(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), "yy_ktv_applaud.png").g(1).e((int) SystemClock.elapsedRealtime()).a(this).a(this.f);
    }

    private final void m() {
        YYConfiguredResourcesModel yYConfiguredResourcesModel;
        String str;
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.U.setVisibility(0);
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null || (yYConfiguredResourcesModel = yYRoomModel.resourcesModel) == null || (str = yYConfiguredResourcesModel.head_light) == null) {
            return;
        }
        ImageLoader.a(baseYYStudioFragment.getFragmentActive(), str).f().g(-1).a(baseYYStudioFragment.U);
    }

    private final void n() {
        ShapeTextView shapeTextView;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel != null) {
            List<YYSeatMemberModel> list2 = yYRoomModel == null ? null : yYRoomModel.mics;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            YYRoomModel yYRoomModel2 = this.L;
            if (yYRoomModel2 != null && (list = yYRoomModel2.mics) != null) {
                int size = list.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    YYSeatMemberModel member = list.get(i2);
                    Intrinsics.c(member, "member");
                    a(i2, member);
                    i = i2 + 1;
                }
            }
            YYRoomModel yYRoomModel3 = this.L;
            if (yYRoomModel3 == null || yYRoomModel3.music == null || (shapeTextView = this.j) == null) {
                return;
            }
            shapeTextView.setVisibility(0);
        }
    }

    private final void o() {
        ConstraintLayout constraintLayout = this.z;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setVisibility(8);
        }
        YYKtvMusicProView yYKtvMusicProView = this.o;
        if (yYKtvMusicProView != null) {
            yYKtvMusicProView.setVisibility(0);
        }
        YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
        if (yYKtvMusicGiftView == null) {
            return;
        }
        yYKtvMusicGiftView.setVisibility(0);
    }

    private final void p() {
        ConstraintLayout constraintLayout = this.F;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        ShapeFrameLayout shapeFrameLayout = this.D;
        if (shapeFrameLayout != null) {
            shapeFrameLayout.setVisibility(0);
        }
        b(true);
        t();
        u();
        w();
        z();
    }

    private final void q() {
        ConstraintLayout constraintLayout = this.F;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ShapeFrameLayout shapeFrameLayout = this.D;
        if (shapeFrameLayout != null) {
            shapeFrameLayout.setVisibility(8);
        }
        b(false);
        r();
        v();
        x();
    }

    private final void r() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.C);
        constraintSet.clear(R.id.lrc_view, 3);
        constraintSet.connect(R.id.lrc_view, 4, 0, 4, DensityUtils.a(this.mContext, 2.0f));
        constraintSet.constrainHeight(R.id.lrc_view, DensityUtils.a(this.mContext, 66.0f));
        constraintSet.applyTo(this.C);
    }

    private final void s() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.C);
        constraintSet.connect(R.id.lrc_view, 3, 0, 3, DensityUtils.a(this.mContext, 10.0f));
        constraintSet.connect(R.id.lrc_view, 4, 0, 4, DensityUtils.a(this.mContext, 10.0f));
        constraintSet.constrainHeight(R.id.lrc_view, DensityUtils.a(this.mContext, 120.0f));
        constraintSet.applyTo(this.C);
    }

    private final void t() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.C);
        constraintSet.connect(R.id.lrc_view, 3, R.id.sur_rhy_view, 4);
        constraintSet.constrainHeight(R.id.lrc_view, DensityUtils.a(this.mContext, 66.0f));
        constraintSet.applyTo(this.C);
    }

    private final void u() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.A);
        constraintSet.connect(R.id.tv_music_count, 4, R.id.btn_choose_music, 4);
        constraintSet.connect(R.id.tv_music_count, 7, R.id.btn_choose_music, 6);
        constraintSet.connect(R.id.tv_music_count, 3, R.id.btn_choose_music, 3);
        constraintSet.applyTo(this.A);
    }

    private final void v() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.A);
        constraintSet.clear(R.id.tv_music_count, 7);
        constraintSet.clear(R.id.tv_music_count, 3);
        constraintSet.clear(R.id.tv_music_count, 4);
        constraintSet.connect(R.id.tv_music_count, 3, R.id.btn_choose_music, 4, DensityUtils.a(this.mContext, 5.0f));
        constraintSet.connect(R.id.tv_music_count, 2, 0, 2);
        constraintSet.applyTo(this.A);
    }

    private final void w() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.A);
        constraintSet.clear(R.id.btn_accompany_with, 4);
        constraintSet.clear(R.id.btn_accompany_with, 3);
        constraintSet.clear(R.id.btn_accompany_with, 2);
        constraintSet.connect(R.id.btn_accompany_with, 4, R.id.btn_control_volume, 4, 0);
        constraintSet.connect(R.id.btn_accompany_with, 2, R.id.btn_control_volume, 1);
        constraintSet.connect(R.id.btn_accompany_with, 3, R.id.btn_control_volume, 3);
        constraintSet.clear(R.id.btn_give_up, 4);
        constraintSet.clear(R.id.btn_give_up, 3);
        constraintSet.clear(R.id.btn_give_up, 2);
        constraintSet.connect(R.id.btn_give_up, 4, R.id.btn_accompany_with, 4, 0);
        constraintSet.connect(R.id.btn_give_up, 2, R.id.btn_accompany_with, 1);
        constraintSet.connect(R.id.btn_give_up, 3, R.id.btn_accompany_with, 3);
        constraintSet.clear(R.id.ll_music_info, 3);
        constraintSet.connect(R.id.ll_music_info, 3, 0, 3, DensityUtils.a(this.mContext, 5.0f));
        constraintSet.applyTo(this.A);
    }

    private final void x() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.A);
        constraintSet.clear(R.id.btn_give_up, 4);
        constraintSet.clear(R.id.btn_give_up, 3);
        constraintSet.clear(R.id.btn_give_up, 2);
        constraintSet.connect(R.id.btn_give_up, 4, R.id.btn_control_volume, 3, DensityUtils.a(this.mContext, 5.0f));
        constraintSet.connect(R.id.btn_give_up, 2, 0, 2);
        constraintSet.clear(R.id.btn_accompany_with, 4);
        constraintSet.clear(R.id.btn_accompany_with, 3);
        constraintSet.clear(R.id.btn_accompany_with, 2);
        constraintSet.connect(R.id.btn_accompany_with, 4, R.id.btn_give_up, 3, DensityUtils.a(this.mContext, 5.0f));
        constraintSet.connect(R.id.btn_accompany_with, 2, 0, 2);
        constraintSet.clear(R.id.ll_music_info, 3);
        constraintSet.connect(R.id.ll_music_info, 3, 0, 3, 0);
        constraintSet.applyTo(this.A);
    }

    private final void y() {
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.W.setVisibility(8);
            baseYYStudioFragment.V.setVisibility(8);
            baseYYStudioFragment.X.setVisibility(8);
            baseYYStudioFragment.U.setVisibility(8);
            baseYYStudioFragment.Y.setVisibility(8);
            baseYYStudioFragment.Z.setVisibility(8);
        }
        z();
    }

    private final void z() {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        if (yYKtvMusicProView != null) {
            yYKtvMusicProView.setVisibility(8);
        }
        YYKtvMusicProView yYKtvMusicProView2 = this.o;
        if (yYKtvMusicProView2 != null) {
            yYKtvMusicProView2.a();
        }
        YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
        if (yYKtvMusicGiftView != null) {
            yYKtvMusicGiftView.setVisibility(8);
        }
        YYKtvMusicGiftView yYKtvMusicGiftView2 = this.p;
        if (yYKtvMusicGiftView2 == null) {
            return;
        }
        yYKtvMusicGiftView2.b();
    }

    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
    public void a() {
        ImageView imageView = this.f;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    public final void a(int i) {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        if (yYKtvMusicProView == null) {
            return;
        }
        yYKtvMusicProView.setMaxProgress(i);
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel != null) {
            if ((yYRoomModel == null ? null : yYRoomModel.mics) == null) {
                return;
            }
            YYRoomModel yYRoomModel2 = this.L;
            if (yYRoomModel2 != null && (list = yYRoomModel2.mics) != null) {
                int i3 = 0;
                int size = list.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    YYSeatMemberModel yYSeatMemberModel = list.get(i3);
                    if (yYSeatMemberModel.mic_position != i) {
                        i3++;
                    } else if (i2 == 1) {
                        yYSeatMemberModel.position_status = -1;
                    } else {
                        yYSeatMemberModel.position_status = i2;
                    }
                }
            }
            n();
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        HashMap<Integer, YYMemberKtvView> hashMap = this.M;
        if (hashMap != null) {
            ActivityFragmentActive activityFragmentActive = null;
            Integer valueOf = hashMap == null ? null : Integer.valueOf(hashMap.size());
            Intrinsics.a(valueOf);
            if (i > valueOf.intValue()) {
                return;
            }
            HashMap<Integer, YYMemberKtvView> hashMap2 = this.M;
            YYMemberKtvView yYMemberKtvView = hashMap2 == null ? null : hashMap2.get(Integer.valueOf(i));
            if (yYMemberKtvView == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            if (baseYYStudioFragment != null) {
                activityFragmentActive = baseYYStudioFragment.getFragmentActive();
            }
            yYMemberKtvView.a(activityFragmentActive, str, str2, yYImModel);
        }
    }

    public final void a(long j) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel != null && (yYMsgKtvMusic = yYRoomModel.music) != null) {
            long j2 = yYMsgKtvMusic.duration;
            long j3 = 1000;
            long j4 = (j2 - (j / j3)) * j3;
            long j5 = j4;
            if (j4 < 0) {
                j5 = 0;
            }
            TextView textView = this.m;
            if (textView != null) {
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
                textView.setText(simpleDateFormat == null ? null : simpleDateFormat.format(Long.valueOf(j5)));
            }
        }
        LyricsView lyricsView = this.t;
        if (lyricsView == null) {
            return;
        }
        lyricsView.b(j);
    }

    public final void a(YYUserSongScoreNoteItem itemGrove) {
        Intrinsics.e(itemGrove, "itemGrove");
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView != null) {
            surfaceRhythmView.a(itemGrove);
        }
        BuildersKt__Builders_commonKt.a(GlobalScope.a, Dispatchers.b(), null, new YYSeatKTVAdapter$itemGrove$1(itemGrove, this, null), 2, null);
    }

    @Override // com.blued.android.module.yy_china.observer.NewGiftComesObserver
    public void a(YYGiftBeansModel yYGiftBeansModel) {
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null ? false : Intrinsics.a((Object) yYRoomModel.getNormalKtv(), (Object) true)) {
            return;
        }
        int a = StringUtils.a(yYGiftBeansModel == null ? null : yYGiftBeansModel.beans, 0);
        YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
        if (yYKtvMusicGiftView != null) {
            yYKtvMusicGiftView.a(a);
        }
        B();
    }

    public final void a(YYKtvStageModel yYKtvStageModel) {
        if (yYKtvStageModel == null) {
            return;
        }
        if (yYKtvStageModel.status == 1) {
            q();
        } else {
            p();
        }
        e(E());
        g(D());
    }

    public final void a(YYMsgKtvSinger yYMsgKtvSinger) {
        Boolean normalKtv;
        ShapeableImageView shapeableImageView = this.k;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.x;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        LyricsView lyricsView = this.t;
        if (lyricsView != null) {
            lyricsView.setVisibility(8);
        }
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView != null) {
            surfaceRhythmView.a();
        }
        ConstraintLayout constraintLayout = this.A;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        a(false);
        y();
        m();
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel != null && (normalKtv = yYRoomModel.getNormalKtv()) != null) {
            boolean booleanValue = normalKtv.booleanValue();
            YYRoomModel yYRoomModel2 = this.L;
            a(yYRoomModel2 == null ? null : yYRoomModel2.stage_info);
            ConstraintLayout constraintLayout2 = this.z;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(booleanValue ? 8 : 0);
            }
            ConstraintLayout constraintLayout3 = this.y;
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(booleanValue ? 0 : 8);
            }
            TextView textView = this.s;
            if (textView != null) {
                textView.setVisibility(booleanValue ? 8 : 0);
            }
        }
        if (yYMsgKtvSinger == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.a;
        ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYMsgKtvSinger.avatar).b(R.drawable.user_bg_round).a((ImageView) this.q);
        BaseYYStudioFragment baseYYStudioFragment2 = this.a;
        ImageLoader.a(baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive(), yYMsgKtvSinger.avatar).b(R.drawable.user_bg_round).a((ImageView) this.r);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        List<YYSeatMemberModel> list;
        HashMap<Integer, YYMemberKtvView> hashMap;
        YYMemberKtvView yYMemberKtvView;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null || yYRoomModel == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.a(str, list.get(i).getUid()) && (hashMap = this.M) != null && (yYMemberKtvView = hashMap.get(Integer.valueOf(i))) != null) {
                yYMemberKtvView.a(getViewX_Y_W_H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        View view;
        if (baseViewHolder != null && (view = baseViewHolder.itemView) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatKTVAdapter$B8Jol3UnrXDsrp4Cyj7cS6V6Y5U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYSeatKTVAdapter.a(view2);
                }
            });
        }
        this.y = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_prepare_view);
        this.x = baseViewHolder == null ? null : (LinearLayout) baseViewHolder.getView(R.id.ll_empty_song);
        this.D = baseViewHolder == null ? null : (ShapeFrameLayout) baseViewHolder.getView(R.id.ll_normal_view);
        this.p = baseViewHolder == null ? null : (YYKtvMusicGiftView) baseViewHolder.getView(R.id.ktv_gift_pro);
        this.o = baseViewHolder == null ? null : (YYKtvMusicProView) baseViewHolder.getView(R.id.ktv_music_pro);
        this.b = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_pick_music);
        this.c = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_music_count);
        this.h = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_accompany_with);
        this.d = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_give_up);
        this.e = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_applaud);
        this.f = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_applaud);
        this.g = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_control_volume);
        this.i = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_original_singer);
        this.k = baseViewHolder == null ? null : baseViewHolder.getView(R.id.iv_music_cover);
        this.l = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_name);
        this.m = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_play_time);
        this.n = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_no_singer);
        this.J = baseViewHolder == null ? null : (LinearLayout) baseViewHolder.getView(R.id.ll_lrc_start);
        this.q = baseViewHolder == null ? null : baseViewHolder.getView(R.id.iv_singer_header);
        this.r = baseViewHolder == null ? null : baseViewHolder.getView(R.id.img_gorgeous_singer);
        this.t = baseViewHolder == null ? null : baseViewHolder.getView(R.id.lrc_view);
        this.u = baseViewHolder == null ? null : (RelativeLayout) baseViewHolder.getView(R.id.sur_rhy_view);
        this.w = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_lrc_bg);
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            SurfaceRhythmView surfaceRhythmView = new SurfaceRhythmView(this.mContext);
            this.v = surfaceRhythmView;
            relativeLayout.addView(surfaceRhythmView, -1, -2);
        }
        this.j = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_choose_music);
        this.A = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_buttons);
        this.B = baseViewHolder == null ? null : (LinearLayout) baseViewHolder.getView(R.id.ll_music_info);
        this.F = baseViewHolder == null ? null : baseViewHolder.getView(R.id.img_stage_bg);
        this.C = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_stage_view);
        this.E = baseViewHolder == null ? null : (LinearLayout) baseViewHolder.getView(R.id.ll_music_cover_mc);
        this.z = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_gorgeous_prepare_view);
        this.s = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_gorgeous_singer_name);
        this.G = baseViewHolder == null ? null : (HollowView) baseViewHolder.getView(R.id.btn_give_flower);
        this.H = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_flower);
        this.I = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_flower);
        ArrayList<ShapeTextView> arrayList = this.K;
        ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.iv_lrc_start_1);
        if (shapeTextView == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeTextView");
        }
        arrayList.add(shapeTextView);
        ArrayList<ShapeTextView> arrayList2 = this.K;
        ShapeTextView shapeTextView2 = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.iv_lrc_start_2);
        if (shapeTextView2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeTextView");
        }
        arrayList2.add(shapeTextView2);
        ArrayList<ShapeTextView> arrayList3 = this.K;
        ShapeTextView shapeTextView3 = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.iv_lrc_start_3);
        if (shapeTextView3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeTextView");
        }
        arrayList3.add(shapeTextView3);
        ArrayList<ShapeTextView> arrayList4 = this.K;
        ShapeTextView shapeTextView4 = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.iv_lrc_start_4);
        if (shapeTextView4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeTextView");
        }
        arrayList4.add(shapeTextView4);
        YYMemberKtvView yYMemberKtvView = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_1);
        if (yYMemberKtvView != null) {
            yYMemberKtvView.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView2 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_2);
        if (yYMemberKtvView2 != null) {
            yYMemberKtvView2.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView3 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_3);
        if (yYMemberKtvView3 != null) {
            yYMemberKtvView3.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView4 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_4);
        if (yYMemberKtvView4 != null) {
            yYMemberKtvView4.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView5 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_5);
        if (yYMemberKtvView5 != null) {
            yYMemberKtvView5.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView6 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_6);
        if (yYMemberKtvView6 != null) {
            yYMemberKtvView6.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView7 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_7);
        if (yYMemberKtvView7 != null) {
            yYMemberKtvView7.setOnClickListener(this);
        }
        YYMemberKtvView yYMemberKtvView8 = baseViewHolder == null ? null : (YYMemberKtvView) baseViewHolder.getView(R.id.user_8);
        if (yYMemberKtvView8 != null) {
            yYMemberKtvView8.setOnClickListener(this);
        }
        HashMap<Integer, YYMemberKtvView> hashMap = this.M;
        if (hashMap != null) {
            HashMap<Integer, YYMemberKtvView> hashMap2 = hashMap;
            hashMap2.put(0, yYMemberKtvView);
            hashMap2.put(1, yYMemberKtvView2);
            hashMap2.put(2, yYMemberKtvView3);
            hashMap2.put(3, yYMemberKtvView4);
            hashMap2.put(4, yYMemberKtvView5);
            hashMap2.put(5, yYMemberKtvView6);
            hashMap2.put(6, yYMemberKtvView7);
            hashMap2.put(7, yYMemberKtvView8);
        }
        k();
        n();
        e();
    }

    public final void a(File lrcFile) {
        Intrinsics.e(lrcFile, "lrcFile");
        LyricsView lyricsView = this.t;
        if (lyricsView != null) {
            lyricsView.b();
        }
        LyricsView lyricsView2 = this.t;
        if (lyricsView2 != null) {
            lyricsView2.setLrcStatus(1);
        }
        new LrcAsyncTask(this, lrcFile, new LyricsReader()).execute(new Object[0]);
    }

    public final void a(Boolean bool) {
        ShapeTextView shapeTextView = this.i;
        if (shapeTextView != null) {
            shapeTextView.setText(b(bool));
        }
        ShapeTextView shapeTextView2 = this.h;
        if (shapeTextView2 == null) {
            return;
        }
        Intrinsics.a(bool);
        shapeTextView2.setText(b(Boolean.valueOf(!bool.booleanValue())));
    }

    public final void a(String str) {
        ShapeTextView shapeTextView;
        if (str == null || (shapeTextView = this.c) == null) {
            return;
        }
        shapeTextView.setText(Intrinsics.a("已点", (Object) str));
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.L;
        if (yYRoomModel2 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.L) == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel member = list.get(i2);
            if (TextUtils.equals(member.getUid(), str)) {
                member.chat_anchor = str2;
                Intrinsics.c(member, "member");
                a(i2, member);
                return;
            }
            i = i2 + 1;
        }
    }

    public final void a(ArrayList<YYTXSongScoreNoteItem> allGrove) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(allGrove, "allGrove");
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView != null) {
            surfaceRhythmView.a(allGrove);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYMsgKtvMusic = b.music) == null) {
            return;
        }
        f(yYMsgKtvMusic.PreludeInterval);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        List<YYSeatMemberModel> list;
        YYMemberKtvView yYMemberKtvView;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null || yYRoomModel == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                Set<String> set2 = set;
                if ((set2 == null || set2.isEmpty()) || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                HashMap<Integer, YYMemberKtvView> hashMap = this.M;
                if (hashMap != null && (yYMemberKtvView = hashMap.get(Integer.valueOf(i2))) != null) {
                    yYMemberKtvView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    public final void a(boolean z) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel;
        Integer valueOf;
        Integer valueOf2;
        boolean z2 = z;
        if (z) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || (yYMsgKtvMusic = b.music) == null || (yyImSong1MlateTogiftModel = yYMsgKtvMusic.songApplaud) == null) {
                z2 = false;
            } else {
                if (yyImSong1MlateTogiftModel.isClick) {
                    Context context = this.mContext;
                    Drawable drawable = context == null ? null : context.getDrawable(R.drawable.icon_yy_ktv_btn_applaud_black);
                    Intrinsics.a(drawable);
                    Intrinsics.c(drawable, "mContext?.getDrawable(R.…_ktv_btn_applaud_black)!!");
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    ShapeTextView shapeTextView = this.e;
                    if (shapeTextView != null) {
                        shapeTextView.setCompoundDrawables(drawable, null, null, null);
                    }
                    ShapeTextView shapeTextView2 = this.e;
                    if (shapeTextView2 != null) {
                        Context context2 = this.mContext;
                        if (context2 == null) {
                            valueOf2 = null;
                        } else {
                            Resources resources = context2.getResources();
                            valueOf2 = resources == null ? null : Integer.valueOf(resources.getColor(R.color.white_alpha45));
                        }
                        Intrinsics.a(valueOf2);
                        shapeTextView2.setTextColor(valueOf2.intValue());
                    }
                } else {
                    Context context3 = this.mContext;
                    Drawable drawable2 = context3 == null ? null : context3.getDrawable(R.drawable.icon_yy_ktv_btn_applaud);
                    Intrinsics.a(drawable2);
                    Intrinsics.c(drawable2, "mContext?.getDrawable(R.…con_yy_ktv_btn_applaud)!!");
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    ShapeTextView shapeTextView3 = this.e;
                    if (shapeTextView3 != null) {
                        shapeTextView3.setCompoundDrawables(drawable2, null, null, null);
                    }
                    ShapeTextView shapeTextView4 = this.e;
                    if (shapeTextView4 != null) {
                        Context context4 = this.mContext;
                        if (context4 == null) {
                            valueOf = null;
                        } else {
                            Resources resources2 = context4.getResources();
                            valueOf = resources2 == null ? null : Integer.valueOf(resources2.getColor(R.color.white));
                        }
                        Intrinsics.a(valueOf);
                        shapeTextView4.setTextColor(valueOf.intValue());
                    }
                }
                z2 = true;
            }
        }
        HollowView hollowView = this.G;
        if (hollowView != null) {
            hollowView.setVisibility(z2 ? 0 : 8);
        }
        ShapeTextView shapeTextView5 = this.e;
        if (shapeTextView5 != null) {
            shapeTextView5.setVisibility(z2 ? 0 : 8);
        }
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
        TextView textView = this.I;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
    public void b() {
        int i = this.N - 1;
        this.N = i;
        if (i > 0) {
            l();
            return;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public final void b(int i) {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        if (yYKtvMusicProView != null) {
            yYKtvMusicProView.a(i);
        }
        g(i);
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        TextView textView;
        if (list == null) {
            return;
        }
        n();
        LinearLayout linearLayout = this.x;
        if (!(linearLayout != null && linearLayout.getVisibility() == 0)) {
            ShapeTextView shapeTextView = this.b;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            TextView textView2 = this.n;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
            return;
        }
        ShapeTextView shapeTextView2 = this.b;
        if (shapeTextView2 != null) {
            shapeTextView2.setVisibility(0);
        }
        TextView textView3 = this.n;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (!YYRoomInfoManager.e().y() || (textView = this.n) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void c(int i) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YYKtvMusicProView yYKtvMusicProView;
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null ? false : Intrinsics.a((Object) yYRoomModel.getNormalKtv(), (Object) true)) {
            return;
        }
        YYRoomModel yYRoomModel2 = this.L;
        if (yYRoomModel2 != null && (yYMsgKtvMusic = yYRoomModel2.music) != null && (yYKtvMusicProView = this.o) != null) {
            yYKtvMusicProView.a(i, yYMsgKtvMusic.hitCount);
        }
        C();
    }

    public final void d() {
        this.N++;
        ImageView imageView = this.f;
        if (imageView != null && imageView.getVisibility() == 0) {
            return;
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        l();
        a(true);
    }

    public final void d(int i) {
        YYKtvMusicProView yYKtvMusicProView = this.o;
        if (yYKtvMusicProView == null) {
            return;
        }
        yYKtvMusicProView.setKtvLeve(i);
    }

    public final void e() {
        Boolean normalKtv;
        TextView textView;
        ShapeableImageView shapeableImageView = this.k;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.y;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = this.z;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.x;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LyricsView lyricsView = this.t;
        if (lyricsView != null) {
            lyricsView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView != null) {
            surfaceRhythmView.setVisibility(8);
        }
        ConstraintLayout constraintLayout3 = this.A;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.J;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        a(false);
        y();
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setText("00:00");
        }
        LyricsView lyricsView2 = this.t;
        if (lyricsView2 != null) {
            lyricsView2.b();
        }
        ShapeTextView shapeTextView = this.b;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(0);
        }
        if (YYRoomInfoManager.e().y() && (textView = this.n) != null) {
            textView.setVisibility(8);
        }
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null || (normalKtv = yYRoomModel.getNormalKtv()) == null) {
            return;
        }
        normalKtv.booleanValue();
        YYRoomModel yYRoomModel2 = this.L;
        a(yYRoomModel2 == null ? null : yYRoomModel2.stage_info);
    }

    public final void e(int i) {
        YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
        if (yYKtvMusicGiftView == null) {
            return;
        }
        yYKtvMusicGiftView.setMaxGiftBar(i);
    }

    public final void f() {
        LyricsView lyricsView = this.t;
        int i = 0;
        if (lyricsView != null) {
            lyricsView.setVisibility(0);
        }
        LinearLayout linearLayout = this.x;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.A;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.y;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null) {
            return;
        }
        a(yYRoomModel.stage_info);
        Boolean normalKtv = yYRoomModel.getNormalKtv();
        Intrinsics.c(normalKtv, "normalKtv");
        if (normalKtv.booleanValue()) {
            ImageView imageView = this.w;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.E;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            ShapeableImageView shapeableImageView = this.k;
            if (shapeableImageView != null) {
                shapeableImageView.setVisibility(0);
            }
            ConstraintLayout constraintLayout3 = this.z;
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(8);
            }
            YYRoomInfoManager.e().i();
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            SurfaceRhythmView surfaceRhythmView = this.v;
            if (surfaceRhythmView != null) {
                surfaceRhythmView.setVisibility(0);
            }
            y();
        } else {
            ImageView imageView2 = this.w;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            LinearLayout linearLayout3 = this.E;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            ShapeableImageView shapeableImageView2 = this.k;
            if (shapeableImageView2 != null) {
                shapeableImageView2.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.u;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            SurfaceRhythmView surfaceRhythmView2 = this.v;
            if (surfaceRhythmView2 != null) {
                surfaceRhythmView2.setVisibility(8);
            }
            e(E());
            YYKtvMusicGiftView yYKtvMusicGiftView = this.p;
            if (yYKtvMusicGiftView != null) {
                YYKtvStageModel yYKtvStageModel = yYRoomModel.stage_info;
                yYKtvMusicGiftView.b(StringUtils.a(yYKtvStageModel == null ? null : yYKtvStageModel.beans, 0));
            }
            B();
            m();
            int F = F();
            LogUtils.d("ktv", Intrinsics.a("total score：", (Object) Integer.valueOf(F)));
            a(F);
            if (F > 0) {
                YYKtvStageModel yYKtvStageModel2 = yYRoomModel.stage_info;
                i = StringUtils.a(yYKtvStageModel2 == null ? null : yYKtvStageModel2.score, 0);
            }
            LogUtils.d("ktv", Intrinsics.a("got score：", (Object) Integer.valueOf(i)));
            b(i);
            C();
            o();
        }
        a(yYRoomModel.music);
    }

    public final void f(int i) {
        this.O = i;
    }

    public final void g() {
        n();
    }

    public final void h() {
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView == null) {
            return;
        }
        surfaceRhythmView.b();
    }

    public final void i() {
        SurfaceRhythmView surfaceRhythmView = this.v;
        if (surfaceRhythmView == null) {
            return;
        }
        surfaceRhythmView.c();
    }

    public final int j() {
        return this.O;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a((SeatChangedObserver) this);
        YYObserverManager.a().a((NewGiftComesObserver) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v42, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v50, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v58, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v66, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v74, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    /* JADX WARN: Type inference failed for: r0v83, types: [com.blued.android.module.yy_china.view.YYMemberKtvView] */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        int id = v.getId();
        View view = null;
        if (id == R.id.user_1) {
            HashMap<Integer, YYMemberKtvView> hashMap = this.M;
            if (hashMap != null) {
                view = hashMap.get(0);
            }
            a(0, view);
        } else if (id == R.id.user_2) {
            HashMap<Integer, YYMemberKtvView> hashMap2 = this.M;
            a(1, hashMap2 == null ? null : hashMap2.get(1));
        } else if (id == R.id.user_3) {
            HashMap<Integer, YYMemberKtvView> hashMap3 = this.M;
            a(2, hashMap3 == null ? null : hashMap3.get(2));
        } else if (id == R.id.user_4) {
            HashMap<Integer, YYMemberKtvView> hashMap4 = this.M;
            a(3, hashMap4 == null ? null : hashMap4.get(3));
        } else if (id == R.id.user_5) {
            HashMap<Integer, YYMemberKtvView> hashMap5 = this.M;
            a(4, hashMap5 == null ? null : hashMap5.get(4));
        } else if (id == R.id.user_6) {
            HashMap<Integer, YYMemberKtvView> hashMap6 = this.M;
            a(5, hashMap6 == null ? null : hashMap6.get(5));
        } else if (id == R.id.user_7) {
            HashMap<Integer, YYMemberKtvView> hashMap7 = this.M;
            a(6, hashMap7 == null ? null : hashMap7.get(6));
        } else if (id == R.id.user_8) {
            HashMap<Integer, YYMemberKtvView> hashMap8 = this.M;
            a(7, hashMap8 == null ? null : hashMap8.get(7));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onDetachedFromRecyclerView ...");
        YYObserverManager.a().b((SeatChangedObserver) this);
        YYObserverManager.a().b((NewGiftComesObserver) this);
        YYRoomModel yYRoomModel = this.L;
        if (yYRoomModel == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }

    public void setNewData(List<? extends YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 8;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
