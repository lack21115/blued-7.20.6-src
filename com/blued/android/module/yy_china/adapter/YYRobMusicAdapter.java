package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyConnectingRobLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYChorusGiftsDialog;
import com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog;
import com.blued.android.module.yy_china.fragment.YYKtvVoiceDialog;
import com.blued.android.module.yy_china.lrc.model.LineInfo;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyMode;
import com.blued.android.module.yy_china.model.YYBorImJsonMode;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYIsFollowMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.presenter.AbstractBasePresenter;
import com.blued.android.module.yy_china.presenter.YYRobMusicPresenter;
import com.blued.android.module.yy_china.utils.YYCommonStringUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYMemberRobView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.ktv.method.lrc.LyricsReader;
import com.ktv.method.lrc.widget.AbstractLrcView;
import com.ktv.method.lrc.widget.LyricsBorShowingView;
import com.ktv.method.lrc.widget.LyricsBorSingSingerView;
import com.ktv.method.lrc.widget.LyricsBorSinglisView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRobMusicAdapter.class */
public final class YYRobMusicAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements FollowStatusObserver, SeatChangedObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f16218a;
    private ItemYyConnectingRobLayoutBinding b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, YYMemberRobView> f16219c;
    private YYRoomModel d;
    private SVGAParser e;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRobMusicAdapter$LrcAsyncTask.class */
    final class LrcAsyncTask extends AsyncTask<Object, Object, ArrayList<LineInfo>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRobMusicAdapter f16220a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final AbstractLrcView f16221c;
        private final File d;
        private final LyricsReader e;

        public LrcAsyncTask(YYRobMusicAdapter this$0, long j, AbstractLrcView lrcView, File file, LyricsReader mLyricsReader) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(lrcView, "lrcView");
            Intrinsics.e(file, "file");
            Intrinsics.e(mLyricsReader, "mLyricsReader");
            this.f16220a = this$0;
            this.b = j;
            this.f16221c = lrcView;
            this.d = file;
            this.e = mLyricsReader;
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
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.adapter.YYRobMusicAdapter.LrcAsyncTask.doInBackground(java.lang.Object[]):java.util.ArrayList");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(ArrayList<LineInfo> arrayList) {
            BaseYYStudioFragment baseYYStudioFragment = this.f16220a.f16218a;
            boolean z = false;
            if (baseYYStudioFragment != null && baseYYStudioFragment.isDetached()) {
                z = true;
            }
            if (z) {
                return;
            }
            AbstractLrcView abstractLrcView = this.f16221c;
            if (abstractLrcView != null) {
                abstractLrcView.setLyricsReader(this.e);
            }
            AbstractLrcView abstractLrcView2 = this.f16221c;
            if (abstractLrcView2 == null) {
                return;
            }
            abstractLrcView2.c(this.b + 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRobMusicAdapter(Context context, BaseYYStudioFragment fragmentActive) {
        super(null);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.mContext = context;
        this.e = SVGAParser.f15958a.b();
        this.f16218a = fragmentActive;
        addItemType(10, R.layout.item_yy_connecting_rob_layout);
        this.d = YYRoomInfoManager.e().b();
        this.f16219c = new HashMap<>();
    }

    private final void a(int i, View view) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.d;
        if (yYRoomModel2 != null) {
            List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
            if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.d) == null || (list = yYRoomModel.mics) == null || i > list.size() - 1 || i < 0) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i);
            BaseYYStudioFragment baseYYStudioFragment = this.f16218a;
            if (baseYYStudioFragment == null) {
                return;
            }
            baseYYStudioFragment.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
        }
    }

    private final void a(int i, YYSeatMemberModel yYSeatMemberModel) {
        HashMap<Integer, YYMemberRobView> hashMap = this.f16219c;
        ActivityFragmentActive activityFragmentActive = null;
        YYMemberRobView yYMemberRobView = hashMap == null ? null : hashMap.get(Integer.valueOf(i));
        if (yYMemberRobView == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.f16218a;
        if (baseYYStudioFragment != null) {
            activityFragmentActive = baseYYStudioFragment.getFragmentActive();
        }
        yYMemberRobView.a(yYSeatMemberModel, activityFragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(0, view);
    }

    private final void a(String str) {
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding != null) {
            itemYyConnectingRobLayoutBinding.e.setVisibility(8);
            itemYyConnectingRobLayoutBinding.d.setVisibility(8);
            itemYyConnectingRobLayoutBinding.f.setVisibility(8);
            itemYyConnectingRobLayoutBinding.B.setVisibility(8);
            itemYyConnectingRobLayoutBinding.g.setVisibility(8);
            itemYyConnectingRobLayoutBinding.h.setVisibility(8);
            itemYyConnectingRobLayoutBinding.j.a(true);
        }
        SVGAParser sVGAParser = this.e;
        if (sVGAParser == null) {
            return;
        }
        SVGAParser.a(sVGAParser, str, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.adapter.YYRobMusicAdapter$playSvga$2
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2;
                ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3;
                ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding4;
                ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding5;
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                Intrinsics.e(videoItem, "videoItem");
                itemYyConnectingRobLayoutBinding2 = YYRobMusicAdapter.this.b;
                SVGAImageView sVGAImageView3 = itemYyConnectingRobLayoutBinding2 == null ? null : itemYyConnectingRobLayoutBinding2.y;
                if (sVGAImageView3 != null) {
                    sVGAImageView3.setLoops(1);
                }
                itemYyConnectingRobLayoutBinding3 = YYRobMusicAdapter.this.b;
                SVGAImageView sVGAImageView4 = itemYyConnectingRobLayoutBinding3 == null ? null : itemYyConnectingRobLayoutBinding3.y;
                if (sVGAImageView4 != null) {
                    sVGAImageView4.setFillMode(SVGAImageView.FillMode.Forward);
                }
                itemYyConnectingRobLayoutBinding4 = YYRobMusicAdapter.this.b;
                if (itemYyConnectingRobLayoutBinding4 != null && (sVGAImageView2 = itemYyConnectingRobLayoutBinding4.y) != null) {
                    sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem));
                }
                itemYyConnectingRobLayoutBinding5 = YYRobMusicAdapter.this.b;
                if (itemYyConnectingRobLayoutBinding5 == null || (sVGAImageView = itemYyConnectingRobLayoutBinding5.y) == null) {
                    return;
                }
                sVGAImageView.a();
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        ToastUtils.a("只有房主可以开启抢唱");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(1, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(2, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(3, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(4, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(5, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(6, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(7, view);
    }

    private final void i() {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.d;
        if (yYRoomModel2 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.d) == null || (list = yYRoomModel.mics) == null) {
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
            Intrinsics.c(member, "member");
            a(i2, member);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YYRobMusicAdapter this$0, View view) {
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        if (baseYYStudioFragment != null && (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) != null) {
            new YYChorusMusicCenterDialog().show(parentFragmentManager, "show_chorus_music_center_dialog");
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROB_SING_SONG_CLICK, b.room_id, b.uid);
    }

    private final void j() {
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding == null) {
            return;
        }
        itemYyConnectingRobLayoutBinding.e.setVisibility(0);
        itemYyConnectingRobLayoutBinding.A.setVisibility(0);
        itemYyConnectingRobLayoutBinding.d.setVisibility(8);
        itemYyConnectingRobLayoutBinding.f.setVisibility(8);
        itemYyConnectingRobLayoutBinding.B.setVisibility(8);
        itemYyConnectingRobLayoutBinding.g.setVisibility(8);
        itemYyConnectingRobLayoutBinding.h.setVisibility(8);
        itemYyConnectingRobLayoutBinding.E.setVisibility(8);
        itemYyConnectingRobLayoutBinding.A.setBackgroundResource(R.drawable.icon_yy_rob_begin_btn_true);
        itemYyConnectingRobLayoutBinding.A.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$PGscoCO-D0f_5eOWoGftJNORnUY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRobMusicAdapter.p(YYRobMusicAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(YYRobMusicAdapter this$0, View view) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        String uid;
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        if (baseYYStudioFragment != null && (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) != null) {
            new YYChorusGiftsDialog().show(parentFragmentManager, "show_chorus_gifts_dialog");
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_ROB_SING_FLOWER_CLICK;
        String str = b.room_id;
        String str2 = b.uid;
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        String str3 = "";
        if (b2 != null && (yYBorImJsonBodyInfoMode = b2.robMus) != null && (uid = yYBorImJsonBodyInfoMode.getUid()) != null) {
            str3 = uid;
        }
        EventTrackYY.a(event, str, str2, str3);
    }

    private final void k() {
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding == null) {
            return;
        }
        itemYyConnectingRobLayoutBinding.e.setVisibility(0);
        itemYyConnectingRobLayoutBinding.A.setVisibility(0);
        itemYyConnectingRobLayoutBinding.d.setVisibility(8);
        itemYyConnectingRobLayoutBinding.f.setVisibility(8);
        itemYyConnectingRobLayoutBinding.B.setVisibility(8);
        itemYyConnectingRobLayoutBinding.E.setVisibility(8);
        itemYyConnectingRobLayoutBinding.g.setVisibility(8);
        itemYyConnectingRobLayoutBinding.h.setVisibility(8);
        itemYyConnectingRobLayoutBinding.A.setBackgroundResource(R.drawable.icon_yy_rob_begin_btn_false);
        itemYyConnectingRobLayoutBinding.A.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$h8SVXIwPY0t5g2J5f3biChyZshM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRobMusicAdapter.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(YYRobMusicAdapter this$0, View view) {
        AbstractBasePresenter l;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        if (baseYYStudioFragment == null || (l = baseYYStudioFragment.l()) == null || !(l instanceof YYRobMusicPresenter)) {
            return;
        }
        ((YYRobMusicPresenter) l).k();
    }

    private final void l() {
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding != null && (sVGAImageView2 = itemYyConnectingRobLayoutBinding.y) != null) {
            sVGAImageView2.a(true);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2 = this.b;
        if (itemYyConnectingRobLayoutBinding2 == null || (sVGAImageView = itemYyConnectingRobLayoutBinding2.y) == null) {
            return;
        }
        sVGAImageView.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(YYRobMusicAdapter this$0, View view) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
            return;
        }
        YYRoomInfoManager e = YYRoomInfoManager.e();
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        Context context = baseYYStudioFragment == null ? null : baseYYStudioFragment.b;
        String uid = yYBorImJsonBodyInfoMode.getUid();
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.f16218a;
        e.b(context, uid, "", baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this$0.b;
        ShapeTextView shapeTextView = itemYyConnectingRobLayoutBinding == null ? null : itemYyConnectingRobLayoutBinding.B;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(8);
        }
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null) {
            return;
        }
        EventTrackYY.l(ChatRoomProtos.Event.YY_ROB_SING_FOLLOW_CLICK, b2.room_id, b2.uid, yYBorImJsonBodyInfoMode.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(YYRobMusicAdapter this$0, View view) {
        AbstractBasePresenter l;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        if (baseYYStudioFragment == null || (l = baseYYStudioFragment.l()) == null || !(l instanceof YYRobMusicPresenter)) {
            return;
        }
        ((YYRobMusicPresenter) l).j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final YYRobMusicAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        LiveAlterDialog.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.b, R.layout.dialog_rob_music_close_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$Rc-idoPfSttjxI93n-1NJL8LRuQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRobMusicAdapter.m(YYRobMusicAdapter.this, view2);
            }
        }, true, false);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROB_SING_END_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(YYRobMusicAdapter this$0, View view) {
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.f16218a;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        new YYKtvVoiceDialog().show(parentFragmentManager, "show_voice_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(YYRobMusicAdapter this$0, View view) {
        BaseYYStudioFragment baseYYStudioFragment;
        AbstractBasePresenter l;
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(view.getId(), 2000L) || (baseYYStudioFragment = this$0.f16218a) == null || (l = baseYYStudioFragment.l()) == null) {
            return;
        }
        if (l instanceof YYRobMusicPresenter) {
            ((YYRobMusicPresenter) l).f();
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_ROB_SING_START_CLICK, b.room_id, b.uid);
    }

    public final void a() {
        LiveEventBus.get("bor_music_ims_bg").post("1");
        if (YYRoomInfoManager.e().h()) {
            j();
        } else {
            k();
        }
        l();
        BaseYYStudioFragment baseYYStudioFragment = this.f16218a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.R();
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel != null) {
            if ((yYRoomModel == null ? null : yYRoomModel.mics) == null) {
                return;
            }
            YYRoomModel yYRoomModel2 = this.d;
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
            i();
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        HashMap<Integer, YYMemberRobView> hashMap = this.f16219c;
        if (hashMap != null) {
            ActivityFragmentActive activityFragmentActive = null;
            Integer valueOf = hashMap == null ? null : Integer.valueOf(hashMap.size());
            Intrinsics.a(valueOf);
            if (i > valueOf.intValue()) {
                return;
            }
            HashMap<Integer, YYMemberRobView> hashMap2 = this.f16219c;
            YYMemberRobView yYMemberRobView = hashMap2 == null ? null : hashMap2.get(Integer.valueOf(i));
            if (yYMemberRobView == null) {
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment = this.f16218a;
            if (baseYYStudioFragment != null) {
                activityFragmentActive = baseYYStudioFragment.getFragmentActive();
            }
            yYMemberRobView.a(activityFragmentActive, str, str2, yYImModel);
        }
    }

    public final void a(long j) {
        LyricsBorShowingView lyricsBorShowingView;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding == null || (lyricsBorShowingView = itemYyConnectingRobLayoutBinding.v) == null) {
            return;
        }
        lyricsBorShowingView.b(j);
    }

    public final void a(YYBorImJsonMode yYBorImJsonMode) {
        YYBorImJsonBodyMode body;
        YYBorImJsonBodyInfoMode musicInfo;
        List<YYSeatMemberModel> list;
        HashMap<Integer, YYMemberRobView> hashMap;
        YYMemberRobView yYMemberRobView;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding != null) {
            itemYyConnectingRobLayoutBinding.e.setVisibility(8);
            itemYyConnectingRobLayoutBinding.d.setVisibility(8);
            itemYyConnectingRobLayoutBinding.f.setVisibility(8);
            itemYyConnectingRobLayoutBinding.B.setVisibility(8);
            itemYyConnectingRobLayoutBinding.g.setVisibility(8);
        }
        if (yYBorImJsonMode != null && (body = yYBorImJsonMode.getBody()) != null && (musicInfo = body.getMusicInfo()) != null) {
            YYRoomModel yYRoomModel = this.d;
            if (yYRoomModel == null) {
                return;
            }
            List<YYSeatMemberModel> list2 = yYRoomModel == null ? null : yYRoomModel.mics;
            int i = 0;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            YYRoomModel yYRoomModel2 = this.d;
            if (yYRoomModel2 != null && (list = yYRoomModel2.mics) != null) {
                int size = list.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        break;
                    } else if (TextUtils.equals(list.get(i3).getUid(), musicInfo.getUid())) {
                        HashMap<Integer, YYMemberRobView> hashMap2 = this.f16219c;
                        if (hashMap2 != null) {
                            i = hashMap2.size();
                        }
                        if (i3 < i && (hashMap = this.f16219c) != null && (yYMemberRobView = hashMap.get(Integer.valueOf(i3))) != null) {
                            yYMemberRobView.a(musicInfo.getAni_rob_svga());
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
        }
        SVGAParser sVGAParser = this.e;
        if (sVGAParser == null) {
            return;
        }
        SVGAParser.a(sVGAParser, "bor_music_chance.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.adapter.YYRobMusicAdapter$onRobMusicByUser$3
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(final SVGAVideoEntity videoItem) {
                final YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
                Intrinsics.e(videoItem, "videoItem");
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) {
                    return;
                }
                final YYRobMusicAdapter yYRobMusicAdapter = YYRobMusicAdapter.this;
                BaseYYStudioFragment baseYYStudioFragment = yYRobMusicAdapter.f16218a;
                ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYBorImJsonBodyInfoMode.getAvatar()).c().a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.adapter.YYRobMusicAdapter$onRobMusicByUser$3$onComplete$1$1
                    @Override // com.bumptech.glide.request.target.Target
                    /* renamed from: a */
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        Context context;
                        Context context2;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding4;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding5;
                        SVGAImageView sVGAImageView;
                        SVGAImageView sVGAImageView2;
                        Context context3;
                        Resources resources;
                        Intrinsics.e(resource, "resource");
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                        Intrinsics.c(bitmap, "resource as BitmapDrawable).bitmap");
                        sVGADynamicEntity.a(bitmap, "img_834");
                        TextPaint textPaint = new TextPaint();
                        context = YYRobMusicAdapter.this.mContext;
                        textPaint.setColor(context.getResources().getColor(R.color.white));
                        context2 = YYRobMusicAdapter.this.mContext;
                        textPaint.setTextSize(context2.getResources().getDimensionPixelOffset(R.dimen.sp_13));
                        String a2 = Intrinsics.a("恭喜 ", (Object) yYBorImJsonBodyInfoMode.getName());
                        TextPaint textPaint2 = textPaint;
                        BaseYYStudioFragment baseYYStudioFragment2 = YYRobMusicAdapter.this.f16218a;
                        int i4 = 100;
                        if (baseYYStudioFragment2 != null && (context3 = baseYYStudioFragment2.getContext()) != null && (resources = context3.getResources()) != null) {
                            i4 = resources.getDimensionPixelOffset(R.dimen.dp_120);
                        }
                        String a3 = YYCommonStringUtils.a(a2, textPaint2, i4);
                        Intrinsics.c(a3, "getSubString(\"恭喜 ${it.na…                  ?: 100)");
                        sVGADynamicEntity.a(a3, textPaint, "img_839");
                        itemYyConnectingRobLayoutBinding2 = YYRobMusicAdapter.this.b;
                        SVGAImageView sVGAImageView3 = itemYyConnectingRobLayoutBinding2 == null ? null : itemYyConnectingRobLayoutBinding2.y;
                        if (sVGAImageView3 != null) {
                            sVGAImageView3.setLoops(1);
                        }
                        itemYyConnectingRobLayoutBinding3 = YYRobMusicAdapter.this.b;
                        SVGAImageView sVGAImageView4 = itemYyConnectingRobLayoutBinding3 == null ? null : itemYyConnectingRobLayoutBinding3.y;
                        if (sVGAImageView4 != null) {
                            sVGAImageView4.setFillMode(SVGAImageView.FillMode.Forward);
                        }
                        itemYyConnectingRobLayoutBinding4 = YYRobMusicAdapter.this.b;
                        if (itemYyConnectingRobLayoutBinding4 != null && (sVGAImageView2 = itemYyConnectingRobLayoutBinding4.y) != null) {
                            sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                        }
                        itemYyConnectingRobLayoutBinding5 = YYRobMusicAdapter.this.b;
                        if (itemYyConnectingRobLayoutBinding5 == null || (sVGAImageView = itemYyConnectingRobLayoutBinding5.y) == null) {
                            return;
                        }
                        sVGAImageView.a();
                    }
                });
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        List<YYSeatMemberModel> list;
        HashMap<Integer, YYMemberRobView> hashMap;
        YYMemberRobView yYMemberRobView;
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null || yYRoomModel == null || (list = yYRoomModel.mics) == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.a(list.get(i).getUid(), str) && (hashMap = this.f16219c) != null && (yYMemberRobView = hashMap.get(Integer.valueOf(i))) != null) {
                yYMemberRobView.a(getViewX_Y_W_H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, YYSeatMemberModel yYSeatMemberModel) {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ShapeTextView shapeTextView3;
        ShapeTextView shapeTextView4;
        ImageView imageView;
        ShapeTextView shapeTextView5;
        YYMemberRobView yYMemberRobView;
        YYMemberRobView yYMemberRobView2;
        YYMemberRobView yYMemberRobView3;
        YYMemberRobView yYMemberRobView4;
        YYMemberRobView yYMemberRobView5;
        YYMemberRobView yYMemberRobView6;
        YYMemberRobView yYMemberRobView7;
        YYMemberRobView yYMemberRobView8;
        ConstraintLayout root;
        Intrinsics.e(helper, "helper");
        ItemYyConnectingRobLayoutBinding a2 = ItemYyConnectingRobLayoutBinding.a(helper.itemView);
        this.b = a2;
        if (a2 != null && (root = a2.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$qNJfGcIWbmchTqq6aLr0l6lvjOE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.a(view);
                }
            });
        }
        HashMap<Integer, YYMemberRobView> hashMap = this.f16219c;
        if (hashMap != null) {
            HashMap<Integer, YYMemberRobView> hashMap2 = hashMap;
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
            hashMap2.put(0, itemYyConnectingRobLayoutBinding == null ? null : itemYyConnectingRobLayoutBinding.H);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2 = this.b;
            hashMap2.put(1, itemYyConnectingRobLayoutBinding2 == null ? null : itemYyConnectingRobLayoutBinding2.I);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3 = this.b;
            hashMap2.put(2, itemYyConnectingRobLayoutBinding3 == null ? null : itemYyConnectingRobLayoutBinding3.J);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding4 = this.b;
            hashMap2.put(3, itemYyConnectingRobLayoutBinding4 == null ? null : itemYyConnectingRobLayoutBinding4.K);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding5 = this.b;
            hashMap2.put(4, itemYyConnectingRobLayoutBinding5 == null ? null : itemYyConnectingRobLayoutBinding5.L);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding6 = this.b;
            hashMap2.put(5, itemYyConnectingRobLayoutBinding6 == null ? null : itemYyConnectingRobLayoutBinding6.M);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding7 = this.b;
            hashMap2.put(6, itemYyConnectingRobLayoutBinding7 == null ? null : itemYyConnectingRobLayoutBinding7.N);
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding8 = this.b;
            hashMap2.put(7, itemYyConnectingRobLayoutBinding8 == null ? null : itemYyConnectingRobLayoutBinding8.O);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding9 = this.b;
        if (itemYyConnectingRobLayoutBinding9 != null && (yYMemberRobView8 = itemYyConnectingRobLayoutBinding9.H) != null) {
            yYMemberRobView8.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$wWZ5PPChlYVy7WkTXpOiADiVaXg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.a(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding10 = this.b;
        if (itemYyConnectingRobLayoutBinding10 != null && (yYMemberRobView7 = itemYyConnectingRobLayoutBinding10.I) != null) {
            yYMemberRobView7.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$VwO6BXCixSvJL2Dcq8j5psQBME8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.b(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding11 = this.b;
        if (itemYyConnectingRobLayoutBinding11 != null && (yYMemberRobView6 = itemYyConnectingRobLayoutBinding11.J) != null) {
            yYMemberRobView6.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$qJHPiYQj-mBZXUoF4UkKPxLQBM4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.c(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding12 = this.b;
        if (itemYyConnectingRobLayoutBinding12 != null && (yYMemberRobView5 = itemYyConnectingRobLayoutBinding12.K) != null) {
            yYMemberRobView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$3NucDpVr1mvSPwXi4x85ICDI5Rs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.d(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding13 = this.b;
        if (itemYyConnectingRobLayoutBinding13 != null && (yYMemberRobView4 = itemYyConnectingRobLayoutBinding13.L) != null) {
            yYMemberRobView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$EOfOkV_G6HymOdqOJuLd375P6Gc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.e(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding14 = this.b;
        if (itemYyConnectingRobLayoutBinding14 != null && (yYMemberRobView3 = itemYyConnectingRobLayoutBinding14.M) != null) {
            yYMemberRobView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$DG7xkxqFJSnof7zBVt4FeF_JUso
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.f(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding15 = this.b;
        if (itemYyConnectingRobLayoutBinding15 != null && (yYMemberRobView2 = itemYyConnectingRobLayoutBinding15.N) != null) {
            yYMemberRobView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$avQIA-KFKamV1W6eOqh66PyXVBk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.g(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding16 = this.b;
        if (itemYyConnectingRobLayoutBinding16 != null && (yYMemberRobView = itemYyConnectingRobLayoutBinding16.O) != null) {
            yYMemberRobView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$gqGSyiCAG83w9q4Je4fvQLhLa2Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.h(YYRobMusicAdapter.this, view);
                }
            });
        }
        i();
        a();
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding17 = this.b;
        if (itemYyConnectingRobLayoutBinding17 != null && (shapeTextView5 = itemYyConnectingRobLayoutBinding17.G) != null) {
            shapeTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$bgLudZ4yloKgit016KAAyQxYCss
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.i(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding18 = this.b;
        if (itemYyConnectingRobLayoutBinding18 != null && (imageView = itemYyConnectingRobLayoutBinding18.q) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$j2xxYDxWFfV5keGv5hUBo2uL4yU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.j(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding19 = this.b;
        if (itemYyConnectingRobLayoutBinding19 != null && (shapeTextView4 = itemYyConnectingRobLayoutBinding19.f16693a) != null) {
            shapeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$wcXo6TOPDzlKHfdYFM26yiZVElo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.k(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding20 = this.b;
        if (itemYyConnectingRobLayoutBinding20 != null && (shapeTextView3 = itemYyConnectingRobLayoutBinding20.B) != null) {
            shapeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$QlCctaf3ai_WUgisA_hWfgRCdwc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.l(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding21 = this.b;
        if (itemYyConnectingRobLayoutBinding21 != null && (shapeTextView2 = itemYyConnectingRobLayoutBinding21.E) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$MTNi3Yz4iuskUsAvuytXsPjGu9c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRobMusicAdapter.n(YYRobMusicAdapter.this, view);
                }
            });
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding22 = this.b;
        if (itemYyConnectingRobLayoutBinding22 == null || (shapeTextView = itemYyConnectingRobLayoutBinding22.b) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRobMusicAdapter$9bsoL432Olk7aS0KwC1w93TMsFg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRobMusicAdapter.o(YYRobMusicAdapter.this, view);
            }
        });
    }

    public final void a(File lrcFile, boolean z) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        LyricsBorSinglisView lyricsBorSinglisView;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode2;
        LyricsBorSingSingerView lyricsBorSingSingerView;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode3;
        LyricsBorSingSingerView lyricsBorSingSingerView2;
        LyricsBorSinglisView lyricsBorSinglisView2;
        LyricsBorShowingView lyricsBorShowingView;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode4;
        LyricsBorShowingView lyricsBorShowingView2;
        LyricsBorSinglisView lyricsBorSinglisView3;
        LyricsBorShowingView lyricsBorShowingView3;
        LyricsBorSingSingerView lyricsBorSingSingerView3;
        Intrinsics.e(lrcFile, "lrcFile");
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding != null && (lyricsBorSingSingerView3 = itemYyConnectingRobLayoutBinding.x) != null) {
            lyricsBorSingSingerView3.b();
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2 = this.b;
        if (itemYyConnectingRobLayoutBinding2 != null && (lyricsBorShowingView3 = itemYyConnectingRobLayoutBinding2.v) != null) {
            lyricsBorShowingView3.b();
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3 = this.b;
        if (itemYyConnectingRobLayoutBinding3 != null && (lyricsBorSinglisView3 = itemYyConnectingRobLayoutBinding3.w) != null) {
            lyricsBorSinglisView3.b();
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding4 = this.b;
        LyricsBorSingSingerView lyricsBorSingSingerView4 = itemYyConnectingRobLayoutBinding4 == null ? null : itemYyConnectingRobLayoutBinding4.x;
        if (lyricsBorSingSingerView4 != null) {
            lyricsBorSingSingerView4.setLrcStatus(0);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding5 = this.b;
        LyricsBorShowingView lyricsBorShowingView4 = itemYyConnectingRobLayoutBinding5 == null ? null : itemYyConnectingRobLayoutBinding5.v;
        if (lyricsBorShowingView4 != null) {
            lyricsBorShowingView4.setLrcStatus(0);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding6 = this.b;
        LyricsBorSinglisView lyricsBorSinglisView4 = itemYyConnectingRobLayoutBinding6 == null ? null : itemYyConnectingRobLayoutBinding6.w;
        if (lyricsBorSinglisView4 != null) {
            lyricsBorSinglisView4.setLrcStatus(0);
        }
        LyricsReader lyricsReader = new LyricsReader();
        YYRoomModel b = YYRoomInfoManager.e().b();
        long j = 0;
        long startTime = (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null) ? 0L : yYBorImJsonBodyInfoMode.getStartTime();
        if (z) {
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding7 = this.b;
            LyricsBorSingSingerView lyricsBorSingSingerView5 = itemYyConnectingRobLayoutBinding7 == null ? null : itemYyConnectingRobLayoutBinding7.x;
            if (lyricsBorSingSingerView5 != null) {
                lyricsBorSingSingerView5.setLyricsReader(null);
            }
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding8 = this.b;
            LyricsBorSinglisView lyricsBorSinglisView5 = itemYyConnectingRobLayoutBinding8 == null ? null : itemYyConnectingRobLayoutBinding8.w;
            if (lyricsBorSinglisView5 != null) {
                lyricsBorSinglisView5.setLyricsReader(null);
            }
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding9 = this.b;
            if (itemYyConnectingRobLayoutBinding9 != null && (lyricsBorShowingView2 = itemYyConnectingRobLayoutBinding9.v) != null) {
                new LrcAsyncTask(this, startTime, lyricsBorShowingView2, lrcFile, lyricsReader).execute(new Object[0]);
            }
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding10 = this.b;
            if (itemYyConnectingRobLayoutBinding10 == null || (lyricsBorShowingView = itemYyConnectingRobLayoutBinding10.v) == null) {
                return;
            }
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null && (yYBorImJsonBodyInfoMode4 = b2.robMus) != null) {
                j = yYBorImJsonBodyInfoMode4.getStartTime();
            }
            lyricsBorShowingView.b(j);
            return;
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding11 = this.b;
        LyricsBorShowingView lyricsBorShowingView5 = itemYyConnectingRobLayoutBinding11 == null ? null : itemYyConnectingRobLayoutBinding11.v;
        if (lyricsBorShowingView5 != null) {
            lyricsBorShowingView5.setLyricsReader(null);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding12 = this.b;
        if (itemYyConnectingRobLayoutBinding12 != null && (lyricsBorSinglisView2 = itemYyConnectingRobLayoutBinding12.w) != null) {
            new LrcAsyncTask(this, startTime, lyricsBorSinglisView2, lrcFile, lyricsReader).execute(new Object[0]);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding13 = this.b;
        if (itemYyConnectingRobLayoutBinding13 != null && (lyricsBorSingSingerView2 = itemYyConnectingRobLayoutBinding13.x) != null) {
            new LrcAsyncTask(this, startTime, lyricsBorSingSingerView2, lrcFile, lyricsReader).execute(new Object[0]);
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding14 = this.b;
        if (itemYyConnectingRobLayoutBinding14 != null && (lyricsBorSingSingerView = itemYyConnectingRobLayoutBinding14.x) != null) {
            YYRoomModel b3 = YYRoomInfoManager.e().b();
            lyricsBorSingSingerView.b((b3 == null || (yYBorImJsonBodyInfoMode3 = b3.robMus) == null) ? 0L : yYBorImJsonBodyInfoMode3.getStartTime());
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding15 = this.b;
        if (itemYyConnectingRobLayoutBinding15 == null || (lyricsBorSinglisView = itemYyConnectingRobLayoutBinding15.w) == null) {
            return;
        }
        YYRoomModel b4 = YYRoomInfoManager.e().b();
        if (b4 != null && (yYBorImJsonBodyInfoMode2 = b4.robMus) != null) {
            j = yYBorImJsonBodyInfoMode2.getStartTime();
        }
        lyricsBorSinglisView.b(j);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel;
        List<YYSeatMemberModel> list;
        YYRoomModel yYRoomModel2 = this.d;
        if (yYRoomModel2 == null) {
            return;
        }
        List<YYSeatMemberModel> list2 = yYRoomModel2 == null ? null : yYRoomModel2.mics;
        if ((list2 == null || list2.isEmpty()) || (yYRoomModel = this.d) == null || (list = yYRoomModel.mics) == null) {
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
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.chat_anchor = str2;
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        List<YYSeatMemberModel> list;
        YYMemberRobView yYMemberRobView;
        YYRoomModel yYRoomModel = this.d;
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
                HashMap<Integer, YYMemberRobView> hashMap = this.f16219c;
                if (hashMap != null && (yYMemberRobView = hashMap.get(Integer.valueOf(i2))) != null) {
                    yYMemberRobView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    public final void a(boolean z, int i) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode2;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode3;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2 = this.b;
        if (itemYyConnectingRobLayoutBinding2 == null) {
            return;
        }
        itemYyConnectingRobLayoutBinding2.e.setVisibility(8);
        itemYyConnectingRobLayoutBinding2.d.setVisibility(8);
        itemYyConnectingRobLayoutBinding2.f.setVisibility(0);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode3 = b.robMus) != null) {
            YYBaseUserHeadView yYBaseUserHeadView = itemYyConnectingRobLayoutBinding2.i;
            BaseYYStudioFragment baseYYStudioFragment = this.f16218a;
            yYBaseUserHeadView.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYBorImJsonBodyInfoMode3.getAvatar(), "");
            itemYyConnectingRobLayoutBinding2.F.setText(yYBorImJsonBodyInfoMode3.getName());
        }
        if (YYRoomInfoManager.e().h()) {
            itemYyConnectingRobLayoutBinding2.E.setVisibility(0);
        }
        if (z) {
            itemYyConnectingRobLayoutBinding2.B.setVisibility(8);
            YYRoomModel yYRoomModel = this.d;
            if (yYRoomModel != null && (yYBorImJsonBodyInfoMode2 = yYRoomModel.robMus) != null) {
                long endTime = yYBorImJsonBodyInfoMode2.getEndTime() - yYBorImJsonBodyInfoMode2.getStartTime();
                long j = endTime;
                if (endTime < 0) {
                    j = 0;
                }
                ShapeTextView shapeTextView = itemYyConnectingRobLayoutBinding2.D;
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
                shapeTextView.setText(simpleDateFormat == null ? null : simpleDateFormat.format(Long.valueOf(j)));
            }
            itemYyConnectingRobLayoutBinding2.h.setVisibility(0);
            itemYyConnectingRobLayoutBinding2.g.setVisibility(8);
            if (i > 0) {
                itemYyConnectingRobLayoutBinding2.m.setVisibility(0);
            } else {
                itemYyConnectingRobLayoutBinding2.m.setVisibility(8);
            }
            if (i > 1) {
                itemYyConnectingRobLayoutBinding2.n.setVisibility(0);
            } else {
                itemYyConnectingRobLayoutBinding2.n.setVisibility(8);
            }
            if (i > 2) {
                itemYyConnectingRobLayoutBinding2.o.setVisibility(0);
            } else {
                itemYyConnectingRobLayoutBinding2.o.setVisibility(8);
            }
            if (i > 3) {
                itemYyConnectingRobLayoutBinding2.p.setVisibility(0);
            } else {
                itemYyConnectingRobLayoutBinding2.p.setVisibility(8);
            }
        } else {
            itemYyConnectingRobLayoutBinding2.g.setVisibility(0);
            itemYyConnectingRobLayoutBinding2.h.setVisibility(8);
            if (i > 3) {
                itemYyConnectingRobLayoutBinding2.B.setVisibility(8);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                String uid = (b2 == null || (yYBorImJsonBodyInfoMode = b2.robMus) == null) ? null : yYBorImJsonBodyInfoMode.getUid();
                BaseYYStudioFragment baseYYStudioFragment2 = this.f16218a;
                final ActivityFragmentActive fragmentActive = baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive();
                BluedUIHttpResponse<BluedEntityA<YYIsFollowMode>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYIsFollowMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.adapter.YYRobMusicAdapter$showUserRobMusicUI$1$3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<YYIsFollowMode> bluedEntityA) {
                        YYIsFollowMode singleData;
                        String status;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3;
                        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding4;
                        if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null || (status = singleData.getStatus()) == null) {
                            return;
                        }
                        YYRobMusicAdapter yYRobMusicAdapter = YYRobMusicAdapter.this;
                        String str = status;
                        ShapeTextView shapeTextView2 = null;
                        if (TextUtils.equals(str, "1") || TextUtils.equals(str, "3")) {
                            itemYyConnectingRobLayoutBinding3 = yYRobMusicAdapter.b;
                            ShapeTextView shapeTextView3 = itemYyConnectingRobLayoutBinding3 == null ? null : itemYyConnectingRobLayoutBinding3.B;
                            if (shapeTextView3 == null) {
                                return;
                            }
                            shapeTextView3.setVisibility(8);
                            return;
                        }
                        itemYyConnectingRobLayoutBinding4 = yYRobMusicAdapter.b;
                        if (itemYyConnectingRobLayoutBinding4 != null) {
                            shapeTextView2 = itemYyConnectingRobLayoutBinding4.B;
                        }
                        if (shapeTextView2 == null) {
                            return;
                        }
                        shapeTextView2.setVisibility(0);
                    }
                };
                BaseYYStudioFragment baseYYStudioFragment3 = this.f16218a;
                YYRoomHttpUtils.b(uid, (BluedUIHttpResponse) bluedUIHttpResponse, (IRequestHost) (baseYYStudioFragment3 == null ? null : baseYYStudioFragment3.getFragmentActive()));
            }
        }
        if (i > 3 && (itemYyConnectingRobLayoutBinding = this.b) != null) {
            SVGAPlayer.Builder builder = new SVGAPlayer.Builder("https://web.bldimg.com/cblued/static/声波修改版本0420.1guh51m0727ljol.svga");
            SVGAImageView sVGAImageView = itemYyConnectingRobLayoutBinding.j;
            Intrinsics.c(sVGAImageView, "it.headUserAni");
            builder.a(sVGAImageView);
        }
        l();
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        String uid;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYBorImJsonBodyInfoMode = b.robMus) == null || (uid = yYBorImJsonBodyInfoMode.getUid()) == null || !StringUtils.a(str, uid)) {
            return;
        }
        String str3 = str2;
        ShapeTextView shapeTextView = null;
        if (TextUtils.equals(str3, "1") || TextUtils.equals(str3, "3")) {
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
            ShapeTextView shapeTextView2 = itemYyConnectingRobLayoutBinding == null ? null : itemYyConnectingRobLayoutBinding.B;
            if (shapeTextView2 == null) {
                return;
            }
            shapeTextView2.setVisibility(8);
            return;
        }
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2 = this.b;
        if (itemYyConnectingRobLayoutBinding2 != null) {
            shapeTextView = itemYyConnectingRobLayoutBinding2.B;
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setVisibility(0);
    }

    public final void b() {
        if (YYRoomInfoManager.e().h()) {
            ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
            ShapeTextView shapeTextView = itemYyConnectingRobLayoutBinding == null ? null : itemYyConnectingRobLayoutBinding.E;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(0);
            }
        }
        LiveEventBus.get("bor_music_ims_bg").post("2");
        a("bor_music_123go.svga");
    }

    public final void b(long j) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding == null) {
            return;
        }
        itemYyConnectingRobLayoutBinding.w.b(j);
        itemYyConnectingRobLayoutBinding.x.b(j);
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null || (yYBorImJsonBodyInfoMode = yYRoomModel.robMus) == null) {
            return;
        }
        long endTime = yYBorImJsonBodyInfoMode.getEndTime() - j;
        long j2 = endTime;
        if (endTime < 0) {
            j2 = 0;
        }
        ShapeTextView shapeTextView = itemYyConnectingRobLayoutBinding.D;
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
        shapeTextView.setText(simpleDateFormat == null ? null : simpleDateFormat.format(Long.valueOf(j2)));
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        if (list == null) {
            return;
        }
        i();
    }

    public final void d() {
        a("bor_music_nouser.svga");
    }

    public final void e() {
        a("bor_music_succes.svga");
    }

    public final void f() {
        a("bor_music_faile.svga");
    }

    public final void g() {
        a("bor_music_uping.svga");
    }

    public final void h() {
        YYRoomModel b;
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        LiveEventBus.get("bor_music_ims_bg").post("3");
        l();
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding = this.b;
        if (itemYyConnectingRobLayoutBinding == null) {
            return;
        }
        if (itemYyConnectingRobLayoutBinding.e.getVisibility() == 0 || itemYyConnectingRobLayoutBinding.f.getVisibility() == 0 || itemYyConnectingRobLayoutBinding.B.getVisibility() == 0 || itemYyConnectingRobLayoutBinding.g.getVisibility() == 0 || itemYyConnectingRobLayoutBinding.h.getVisibility() == 0) {
            itemYyConnectingRobLayoutBinding.e.setVisibility(8);
            itemYyConnectingRobLayoutBinding.f.setVisibility(8);
            itemYyConnectingRobLayoutBinding.B.setVisibility(8);
            itemYyConnectingRobLayoutBinding.g.setVisibility(8);
            itemYyConnectingRobLayoutBinding.h.setVisibility(8);
        }
        itemYyConnectingRobLayoutBinding.d.setVisibility(0);
        YYRoomInfoManager e = YYRoomInfoManager.e();
        if (e != null && (b = e.b()) != null && (yYBorImJsonBodyInfoMode = b.robMus) != null) {
            TextView textView = itemYyConnectingRobLayoutBinding.C;
            textView.setText((char) 12298 + yYBorImJsonBodyInfoMode.getMusicName() + (char) 12299);
        }
        if (YYRoomInfoManager.e().h()) {
            itemYyConnectingRobLayoutBinding.E.setVisibility(0);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a((SeatChangedObserver) this);
        YYObserverManager.a().a((FollowStatusObserver) this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        Logger.e("observer", "YYSeatKTVAdapter onDetachedFromRecyclerView ...");
        YYObserverManager.a().b((SeatChangedObserver) this);
        YYObserverManager.a().b((FollowStatusObserver) this);
        YYRoomModel yYRoomModel = this.d;
        if (yYRoomModel == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<? extends YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 10;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
