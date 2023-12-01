package com.blued.android.module.yy_china.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusMusicItemFragment$createMusicItemAdapter$1.class */
public final class YYChorusMusicItemFragment$createMusicItemAdapter$1 extends BaseMultiItemQuickAdapter<YYKtvMusicModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYChorusMusicItemFragment f17137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYChorusMusicItemFragment$createMusicItemAdapter$1(YYChorusMusicItemFragment yYChorusMusicItemFragment) {
        super(null);
        this.f17137a = yYChorusMusicItemFragment;
        addItemType(0, R.layout.item_yy_ktv_music_info);
        addItemType(1, R.layout.live_music_item_no_more_view);
        addItemType(2, R.layout.item_yy_chorus_music_info);
    }

    private final void a(YYKtvMusicModel yYKtvMusicModel) {
        final YYChorusMusicItemFragment yYChorusMusicItemFragment = this.f17137a;
        YYRoomModel d = yYChorusMusicItemFragment.d();
        String str = d == null ? null : d.room_id;
        String str2 = yYKtvMusicModel.musicId;
        final ActivityFragmentActive fragmentActive = yYChorusMusicItemFragment.getFragmentActive();
        YYRoomHttpUtils.l(str, str2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYChorusMusicItemFragment$createMusicItemAdapter$1$getMusicDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                ToastUtils.a("点歌申请已发出，请等待房主或场控通过");
                YYChorusMusicItemFragment.this.getParentFragmentManager().setFragmentResult("key_cancel", BundleKt.bundleOf(new Pair[0]));
            }
        }, yYChorusMusicItemFragment.getFragmentActive());
    }

    private final void a(YYKtvMusicModel yYKtvMusicModel, String str, final int i) {
        YYRoomModel d = this.f17137a.d();
        String str2 = d == null ? null : d.room_id;
        String str3 = yYKtvMusicModel == null ? null : yYKtvMusicModel.musicId;
        final ActivityFragmentActive fragmentActive = this.f17137a.getFragmentActive();
        final YYChorusMusicItemFragment yYChorusMusicItemFragment = this.f17137a;
        YYRoomHttpUtils.e(str2, str3, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(i, fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYChorusMusicItemFragment$createMusicItemAdapter$1$toAcceptOrDeny$1
            final /* synthetic */ int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                List<YYKtvMusicModel> data;
                BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> b = YYChorusMusicItemFragment.this.b();
                if (b != null) {
                    b.remove(this.b);
                }
                BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> b2 = YYChorusMusicItemFragment.this.b();
                boolean z = true;
                if (b2 == null || (data = b2.getData()) == null || !data.isEmpty()) {
                    z = false;
                }
                if (z) {
                    YYChorusMusicItemFragment.this.f();
                }
            }
        }, this.f17137a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, YYKtvMusicModel yYKtvMusicModel, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(yYKtvMusicModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, YYKtvMusicModel yYKtvMusicModel, BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        this$0.a(yYKtvMusicModel, "1", helper.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, final YYKtvMusicModel yYKtvMusicModel, View view) {
        Intrinsics.e(this$0, "this$0");
        new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$o0HUdHlht1Z456KAvo6X8mY5O9s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.a(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, view2);
            }
        }, 2000L, null).onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, final YYKtvMusicModel yYKtvMusicModel, final BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$tzAI5KwFbvt9XQl3mT6EfEloU_U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.a(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, helper, view2);
            }
        }, 2000L, null).onClick(view);
    }

    private final void b(BaseViewHolder baseViewHolder, final YYKtvMusicModel yYKtvMusicModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.music_cover);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_music_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_music_writer);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.btn_book_in);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_logo);
        shapeTextView.setText("想唱");
        if (yYKtvMusicModel == null) {
            return;
        }
        ImageLoader.a(this.f17137a.getFragmentActive(), yYKtvMusicModel.coverUrl).a(imageView);
        if (textView != null) {
            textView.setText(yYKtvMusicModel.musicName);
        }
        if (textView2 != null) {
            textView2.setText(yYKtvMusicModel.artist);
        }
        if (imageView2 != null) {
            imageView2.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$nUIHaBa9d9IBRjg3UwbAyopVMJk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.b(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, YYKtvMusicModel yYKtvMusicModel, BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        this$0.a(yYKtvMusicModel, "2", helper.getAdapterPosition());
    }

    private final void c(final BaseViewHolder baseViewHolder, final YYKtvMusicModel yYKtvMusicModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.music_cover);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_music_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_music_writer);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.btn_accept);
        ShapeTextView shapeTextView2 = (ShapeTextView) baseViewHolder.getView(R.id.btn_deny);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_logo);
        if (yYKtvMusicModel != null) {
            ImageLoader.a(this.f17137a.getFragmentActive(), yYKtvMusicModel.coverUrl).a(imageView);
            if (textView != null) {
                textView.setText(yYKtvMusicModel.musicName);
            }
            if (textView2 != null) {
                textView2.setText(yYKtvMusicModel.artist);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
            }
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$6gVSRYYl0cm_30vBLbKsIUTCJK4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.b(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, baseViewHolder, view);
            }
        });
        shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$lGnUP_ClGoJuFNvgcQao37pQojo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.d(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, baseViewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final YYChorusMusicItemFragment$createMusicItemAdapter$1 this$0, final YYKtvMusicModel yYKtvMusicModel, final BaseViewHolder helper, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicItemFragment$createMusicItemAdapter$1$K4rtJmSPvFQhgtiGPpkZv1xzy0g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusMusicItemFragment$createMusicItemAdapter$1.c(YYChorusMusicItemFragment$createMusicItemAdapter$1.this, yYKtvMusicModel, helper, view2);
            }
        }, 2000L, null).onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYKtvMusicModel yYKtvMusicModel) {
        if (baseViewHolder == null) {
            return;
        }
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 0) {
            b(baseViewHolder, yYKtvMusicModel);
        } else if (itemViewType != 2) {
        } else {
            c(baseViewHolder, yYKtvMusicModel);
        }
    }
}
