package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvSongListBinding;
import com.blued.android.module.yy_china.fragment.YYKtvSongListDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYKtvOrderedMusicModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvSongListDialog.class */
public final class YYKtvSongListDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private FragmentYyKtvSongListBinding f17324a;
    private SongAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvSongListDialog$SongAdapter.class */
    public final class SongAdapter extends BaseQuickAdapter<YYKtvOrderedMusicModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYKtvSongListDialog f17325a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SongAdapter(YYKtvSongListDialog this$0) {
            super(R.layout.item_song_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17325a = this$0;
        }

        private final void a() {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            final YYKtvSongListDialog yYKtvSongListDialog = this.f17325a;
            String str = b.room_id;
            final ActivityFragmentActive a2 = yYKtvSongListDialog.a();
            YYRoomHttpUtils.v(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvOrderedMusicModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$SongAdapter$toWinSinger$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(a2);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
                    r0 = r3.f17326a.b;
                 */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.yy_china.model.YYKtvOrderedMusicModel> r4) {
                    /*
                        r3 = this;
                        r0 = 0
                        r5 = r0
                        r0 = r4
                        if (r0 != 0) goto L9
                        goto L12
                    L9:
                        r0 = r4
                        boolean r0 = r0.hasData()
                        if (r0 != 0) goto L12
                        r0 = 1
                        r5 = r0
                    L12:
                        r0 = r5
                        if (r0 == 0) goto L17
                        return
                    L17:
                        r0 = r3
                        com.blued.android.module.yy_china.fragment.YYKtvSongListDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSongListDialog.this
                        com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYKtvSongListDialog.a(r0)
                        r6 = r0
                        r0 = r6
                        if (r0 != 0) goto L24
                        return
                    L24:
                        r0 = r4
                        if (r0 != 0) goto L2d
                        r0 = 0
                        r4 = r0
                        goto L32
                    L2d:
                        r0 = r4
                        java.util.List<T> r0 = r0.data
                        r4 = r0
                    L32:
                        r0 = r6
                        r1 = r4
                        r0.setNewData(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$SongAdapter$toWinSinger$1$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
                }
            }, yYKtvSongListDialog.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(SongAdapter this$0, YYKtvOrderedMusicModel it, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(it, "$it");
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.i(ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_LIST_TOP_CLICK, b.room_id, b.uid, it.uid, it.musicId);
            }
            this$0.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYKtvSongListDialog this$0, YYKtvOrderedMusicModel it, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(it, "$it");
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.i(ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_LIST_SING_CLICK, b.room_id, b.uid, it.uid, it.musicId);
            }
            YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
            if (!TextUtils.equals(yYUserInfo == null ? null : yYUserInfo.is_mic, "1")) {
                ToastUtils.a("点唱歌曲需要上麦哦，快去上麦吧~");
                return;
            }
            LiveEventBus.get("event_ktv_pick_music").post("");
            this$0.dismissAllowingStateLoss();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYKtvOrderedMusicModel yYKtvOrderedMusicModel) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_song_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_singing);
            ShapeableImageView shapeableImageView = baseViewHolder == null ? null : (ShapeableImageView) baseViewHolder.getView(R.id.iv_singer_header);
            TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_singer_name);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_sing_song);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_to_top);
            if (yYKtvOrderedMusicModel == null) {
                return;
            }
            final YYKtvSongListDialog yYKtvSongListDialog = this.f17325a;
            if (textView != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition() + 1));
                sb.append('.');
                sb.append((Object) yYKtvOrderedMusicModel.musicName);
                textView.setText(sb.toString());
            }
            if (TextUtils.equals("1", yYKtvOrderedMusicModel.in_singing)) {
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            } else if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageLoader.a(yYKtvSongListDialog.a(), yYKtvOrderedMusicModel.avatar).b(R.drawable.user_bg_round).a(shapeableImageView);
            if (textView3 != null) {
                textView3.setText(yYKtvOrderedMusicModel.name);
            }
            if (shapeTextView != null) {
                shapeTextView.setVisibility(TextUtils.equals(yYKtvOrderedMusicModel.uid, YYRoomInfoManager.e().k()) ? 8 : 0);
            }
            if (!TextUtils.equals(yYKtvOrderedMusicModel.uid, YYRoomInfoManager.e().k()) || TextUtils.equals("1", yYKtvOrderedMusicModel.in_singing)) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSongListDialog$SongAdapter$9wNtN9PbMEU2hSH3lk4BhQ8ux8o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYKtvSongListDialog.SongAdapter.a(YYKtvSongListDialog.SongAdapter.this, yYKtvOrderedMusicModel, view);
                    }
                });
            }
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSongListDialog$SongAdapter$r1Ndcc3XmwZ1SpVD7hgyVEas4tI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYKtvSongListDialog.SongAdapter.a(YYKtvSongListDialog.this, yYKtvOrderedMusicModel, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvSongListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        View view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        FragmentYyKtvSongListBinding fragmentYyKtvSongListBinding = this.f17324a;
        RecyclerView recyclerView = fragmentYyKtvSongListBinding == null ? null : fragmentYyKtvSongListBinding.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.b = new SongAdapter(this);
        FragmentYyKtvSongListBinding fragmentYyKtvSongListBinding2 = this.f17324a;
        RecyclerView recyclerView2 = fragmentYyKtvSongListBinding2 == null ? null : fragmentYyKtvSongListBinding2.b;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        FragmentYyKtvSongListBinding fragmentYyKtvSongListBinding3 = this.f17324a;
        if (fragmentYyKtvSongListBinding3 == null || (view = fragmentYyKtvSongListBinding3.f16525a) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvSongListDialog$kKJL1ACOpCSC37gfwdtHmPesQvA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYKtvSongListDialog.a(YYKtvSongListDialog.this, view2);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_song_list, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…ng_list, container, true)");
        this.f17324a = FragmentYyKtvSongListBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        String str = b.room_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.j(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvOrderedMusicModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$onViewCreated$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
                r0 = r3.f17327a.b;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.yy_china.model.YYKtvOrderedMusicModel> r4) {
                /*
                    r3 = this;
                    r0 = 0
                    r5 = r0
                    r0 = r4
                    if (r0 != 0) goto L9
                    goto L12
                L9:
                    r0 = r4
                    boolean r0 = r0.hasData()
                    if (r0 != 0) goto L12
                    r0 = 1
                    r5 = r0
                L12:
                    r0 = r5
                    if (r0 == 0) goto L17
                    return
                L17:
                    r0 = r3
                    com.blued.android.module.yy_china.fragment.YYKtvSongListDialog r0 = com.blued.android.module.yy_china.fragment.YYKtvSongListDialog.this
                    com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$SongAdapter r0 = com.blued.android.module.yy_china.fragment.YYKtvSongListDialog.a(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L24
                    return
                L24:
                    r0 = r4
                    if (r0 != 0) goto L2d
                    r0 = 0
                    r4 = r0
                    goto L32
                L2d:
                    r0 = r4
                    java.util.List<T> r0 = r0.data
                    r4 = r0
                L32:
                    r0 = r6
                    r1 = r4
                    r0.setNewData(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYKtvSongListDialog$onViewCreated$1$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, a());
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_LIST_SHOW, b.room_id, b.uid);
    }
}
