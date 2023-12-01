package com.blued.android.module.yy_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewKtvNewSongMessageBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.MusicDTO;
import com.blued.android.module.yy_china.model.NewSongMessageModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/KtvNewSongMessageView.class */
public final class KtvNewSongMessageView extends FrameLayout {
    public static final Companion a = new Companion(null);
    private final ViewKtvNewSongMessageBinding b;
    private final NewSongMessHandler c;
    private final int d;
    private NewSongMessageModel e;
    private BaseYYStudioFragment f;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/KtvNewSongMessageView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KtvNewSongMessageView a(ViewGroup parent) {
            Intrinsics.e(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.c(context, "parent.context");
            KtvNewSongMessageView ktvNewSongMessageView = new KtvNewSongMessageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            layoutParams.setMargins(parent.getContext().getResources().getDimensionPixelOffset(R.dimen.dp_10), 0, 0, parent.getResources().getDimensionPixelOffset(R.dimen.dp_200));
            ktvNewSongMessageView.setVisibility(8);
            parent.addView(ktvNewSongMessageView, layoutParams);
            ktvNewSongMessageView.a();
            return ktvNewSongMessageView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KtvNewSongMessageView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KtvNewSongMessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtvNewSongMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewKtvNewSongMessageBinding a2 = ViewKtvNewSongMessageBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.b = a2;
        this.c = new NewSongMessHandler(this);
        this.d = getResources().getDimensionPixelOffset(R.dimen.dp_10);
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$KtvNewSongMessageView$DrshxCxZRas7AeOxOwWLU7zdlMc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KtvNewSongMessageView.a(KtvNewSongMessageView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(KtvNewSongMessageView this$0) {
        Intrinsics.e(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0, "translationX", 0.0f, -((this$0.getWidth() * 1.0f) + this$0.d));
        ofFloat.setDuration(10L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(KtvNewSongMessageView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c.removeCallbacksAndMessages(null);
        this$0.c.sendEmptyMessage(1);
        this$0.d();
    }

    private final void d() {
        BaseYYStudioFragment baseYYStudioFragment = this.f;
        if (baseYYStudioFragment == null) {
            return;
        }
        Context context = baseYYStudioFragment.b;
        Intrinsics.c(context, "it.mContext");
        YYChooseSongDialog yYChooseSongDialog = new YYChooseSongDialog(context);
        NewSongMessageModel single = getSingle();
        Intrinsics.a(single);
        yYChooseSongDialog.a(baseYYStudioFragment, single);
        baseYYStudioFragment.a(yYChooseSongDialog, -2);
    }

    public final void a() {
        post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$KtvNewSongMessageView$mMKlA4nW_7CE9VRse9uUmFu7cY0
            @Override // java.lang.Runnable
            public final void run() {
                KtvNewSongMessageView.a(KtvNewSongMessageView.this);
            }
        });
    }

    public final void a(String con) {
        Intrinsics.e(con, "con");
        this.b.a.setText(con);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", -((getWidth() * 1.0f) + this.d), 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
        this.c.sendEmptyMessageDelayed(1, 5000L);
    }

    public final void b() {
        String str = YYRoomInfoManager.e().b().room_id;
        BaseYYStudioFragment baseYYStudioFragment = this.f;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<NewSongMessageModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<NewSongMessageModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.KtvNewSongMessageView$addMess$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<NewSongMessageModel> bluedEntityA) {
                YYRoomModel b;
                String musicName;
                if ((bluedEntityA == null ? null : bluedEntityA.getSingleData()) == null || (b = YYRoomInfoManager.e().b()) == null || !TextUtils.equals(ATAdConst.ATDevFrameworkType.FLUTTER, b.type_id)) {
                    return;
                }
                KtvNewSongMessageView.this.setSingle(bluedEntityA == null ? null : bluedEntityA.getSingleData());
                if (!YYRoomInfoManager.e().i() || YYRoomInfoManager.e().y()) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((char) 12298);
                NewSongMessageModel single = KtvNewSongMessageView.this.getSingle();
                if (single == null) {
                    musicName = null;
                } else {
                    MusicDTO musicDTO = single.music;
                    musicName = musicDTO == null ? null : musicDTO.getMusicName();
                }
                sb.append((Object) musicName);
                sb.append("》这首歌最近很多人唱过，戳我直接点唱~");
                String sb2 = sb.toString();
                KtvNewSongMessageView.this.setVisibility(0);
                KtvNewSongMessageView.this.a(sb2);
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.f;
        YYRoomHttpUtils.d(str, (BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    public final void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, -((getWidth() * 1.0f) + this.d));
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public final BaseYYStudioFragment getFrag() {
        return this.f;
    }

    @Override // android.view.View
    public final NewSongMessHandler getHandler() {
        return this.c;
    }

    public final NewSongMessageModel getSingle() {
        return this.e;
    }

    public final void setFrag(BaseYYStudioFragment baseYYStudioFragment) {
        this.f = baseYYStudioFragment;
    }

    public final void setSingle(NewSongMessageModel newSongMessageModel) {
        this.e = newSongMessageModel;
    }
}
