package com.blued.community.ui.send.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackVote;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.das.client.vote.VoteProtos;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/view/FeedPostVoteView.class */
public final class FeedPostVoteView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f20085a;
    private ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f20086c;
    private ImageView d;
    private CardView e;
    private CardView f;
    private FeedAddPostFragment g;
    private SparseArray<ChildImageInfo> h;
    private int i;
    private final int j;
    private final int k;
    private final ImageView[] l;
    private final View[] m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostVoteView(Context context) {
        super(context);
        Intrinsics.a(context);
        this.h = new SparseArray<>(2);
        this.k = 1;
        this.l = new ImageView[2];
        this.m = new View[2];
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostVoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.a(context);
        this.h = new SparseArray<>(2);
        this.k = 1;
        this.l = new ImageView[2];
        this.m = new View[2];
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostVoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        this.h = new SparseArray<>(2);
        this.k = 1;
        this.l = new ImageView[2];
        this.m = new View[2];
        d();
    }

    private final void a(int i) {
        ICommunityShowPageService b = CommunityServiceManager.b();
        FeedAddPostFragment feedAddPostFragment = this.g;
        b.a(feedAddPostFragment == null ? null : feedAddPostFragment.getActivity(), i, 0, (LoadOptions) null);
    }

    private final void a(int i, String str) {
        SelectAlbumViewModel selectAlbumViewModel;
        if (str == null) {
            return;
        }
        ChildImageInfo childImageInfo = new ChildImageInfo();
        childImageInfo.mImagePath = str;
        this.h.put(i, childImageInfo);
        SelectPhotoManager.a().a(childImageInfo);
        FeedAddPostFragment feedAddPostFragment = this.g;
        if (feedAddPostFragment != null && (selectAlbumViewModel = feedAddPostFragment.az) != null) {
            selectAlbumViewModel.a(str);
        }
        c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostVoteView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostVoteView this$0, File file, Exception exc) {
        Intrinsics.e(this$0, "this$0");
        if (file == null || !file.exists()) {
            return;
        }
        this$0.a(this$0.j, file.getAbsolutePath());
    }

    private final void b(int i) {
        this.i = i;
        FeedAddPostFragment feedAddPostFragment = this.g;
        if (feedAddPostFragment != null) {
            feedAddPostFragment.k();
        }
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_UPLOAD_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostVoteView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostVoteView this$0, File file, Exception exc) {
        Intrinsics.e(this$0, "this$0");
        if (file == null || !file.exists()) {
            return;
        }
        this$0.a(this$0.k, file.getAbsolutePath());
    }

    private final void c(int i) {
        String str;
        ChildImageInfo childImageInfo = this.h.get(i);
        if (childImageInfo == null || (str = childImageInfo.mImagePath) == null) {
            return;
        }
        FeedAddPostFragment feedAddPostFragment = this.g;
        ImageLoader.d(feedAddPostFragment == null ? null : feedAddPostFragment.getFragmentActive(), str).a(10.0f).a(this.l[i]);
        View view = this.m[i];
        if (view != null) {
            view.setVisibility(0);
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedPostVoteView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    private final void d() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.feed_post_vote_view_layout, (ViewGroup) null);
        this.f20085a = frameLayout;
        if (frameLayout == null) {
            return;
        }
        this.b = (ShapeLinearLayout) frameLayout.findViewById(R.id.feed_post_vote_content_lo);
        this.f20086c = (TextView) frameLayout.findViewById(R.id.feed_post_vote_title);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.feed_post_vote_close);
        this.d = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$QWblRE0azX_2SL2BkkJIhBhng4M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostVoteView.a(FeedPostVoteView.this, view);
                }
            }));
        }
        this.e = (CardView) frameLayout.findViewById(R.id.feed_post_vote_cv_a);
        ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.feed_post_vote_img_a);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$12hSQ1RUR33mRrbevB4Hv7P8u70
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostVoteView.b(FeedPostVoteView.this, view);
                }
            }));
        }
        View findViewById = frameLayout.findViewById(R.id.feed_post_vote_delete_a);
        if (findViewById != null) {
            findViewById.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$WK_MC3h5sPtoMiL8uHt8jZ3N028
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostVoteView.c(FeedPostVoteView.this, view);
                }
            }));
        }
        this.f = (CardView) frameLayout.findViewById(R.id.feed_post_vote_cv_b);
        ImageView imageView3 = (ImageView) frameLayout.findViewById(R.id.feed_post_vote_img_b);
        if (imageView3 != null) {
            imageView3.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$yROnwKDIRoJvp7wEmNMiwSTLpJM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostVoteView.d(FeedPostVoteView.this, view);
                }
            }));
        }
        View findViewById2 = frameLayout.findViewById(R.id.feed_post_vote_delete_b);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$ly5yXBPjvicA27NJ2wH-SsSlT_I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostVoteView.e(FeedPostVoteView.this, view);
                }
            }));
        }
        ImageView[] imageViewArr = this.l;
        int i = this.j;
        imageViewArr[i] = imageView2;
        int i2 = this.k;
        imageViewArr[i2] = imageView3;
        View[] viewArr = this.m;
        viewArr[i] = findViewById;
        viewArr[i2] = findViewById2;
        e();
        addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedPostVoteView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    private final void e() {
        boolean s = CommunityManager.f19086a.a().s();
        ShapeLinearLayout shapeLinearLayout = this.b;
        ShapeModel shapeModel = null;
        ShapeModel shapeModel2 = shapeLinearLayout == null ? null : shapeLinearLayout.getShapeModel();
        ShapeLinearLayout shapeLinearLayout2 = this.b;
        if (shapeLinearLayout2 != null) {
            shapeModel = shapeLinearLayout2.getShapeModel();
        }
        if (shapeModel == null) {
            shapeModel2 = new ShapeModel();
        }
        if (shapeModel2 != null) {
            shapeModel2.n = Color.parseColor(s ? "#2C2C2C" : "#E2E4E7");
        }
        ShapeLinearLayout shapeLinearLayout3 = this.b;
        if (shapeLinearLayout3 != null) {
            shapeLinearLayout3.setShapeModel(shapeModel2);
        }
        CardView cardView = this.e;
        if (cardView != null) {
            cardView.setBackgroundColor(Color.parseColor(s ? "#28282B" : "#F3F4F4"));
        }
        CardView cardView2 = this.f;
        if (cardView2 != null) {
            cardView2.setBackgroundColor(Color.parseColor(s ? "#28282B" : "#F3F4F4"));
        }
        if (this.h.get(this.j) == null) {
            setDefaultImg(this.j);
        }
        if (this.h.get(this.k) == null) {
            setDefaultImg(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FeedPostVoteView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    private final void f() {
        ChildImageInfo childImageInfo = this.h.get(this.j);
        if (TextUtils.isEmpty(childImageInfo == null ? null : childImageInfo.mImagePath)) {
            b(this.j);
        } else {
            a(this.j);
        }
    }

    private final void g() {
        ChildImageInfo childImageInfo = this.h.get(this.k);
        if (TextUtils.isEmpty(childImageInfo == null ? null : childImageInfo.mImagePath)) {
            b(this.k);
        } else {
            a(this.k);
        }
    }

    private final void h() {
        String str;
        FeedAddPostFragment feedAddPostFragment;
        ChildImageInfo childImageInfo = this.h.get(this.j);
        if (childImageInfo != null && (str = childImageInfo.mImagePath) != null && (feedAddPostFragment = this.g) != null) {
            feedAddPostFragment.a(str);
        }
        setDefaultImg(this.j);
    }

    private final void i() {
        String str;
        FeedAddPostFragment feedAddPostFragment;
        ChildImageInfo childImageInfo = this.h.get(this.k);
        if (childImageInfo != null && (str = childImageInfo.mImagePath) != null && (feedAddPostFragment = this.g) != null) {
            feedAddPostFragment.a(str);
        }
        setDefaultImg(this.k);
    }

    private final void j() {
        ChildImageInfo childImageInfo = this.h.get(this.j);
        if (!TextUtils.isEmpty(childImageInfo == null ? null : childImageInfo.mImagePath)) {
            ChildImageInfo childImageInfo2 = this.h.get(this.k);
            if (!TextUtils.isEmpty(childImageInfo2 == null ? null : childImageInfo2.mImagePath)) {
                FeedAddPostFragment feedAddPostFragment = this.g;
                if (feedAddPostFragment != null) {
                    feedAddPostFragment.B();
                }
                TextView textView = this.f20086c;
                if (textView == null) {
                    return;
                }
                textView.setText(R.string.feed_vote_post_add_pic_done);
                return;
            }
        }
        FeedAddPostFragment feedAddPostFragment2 = this.g;
        if (feedAddPostFragment2 != null) {
            feedAddPostFragment2.B();
        }
        TextView textView2 = this.f20086c;
        if (textView2 == null) {
            return;
        }
        textView2.setText(R.string.feed_vote_post_add_pic_tips);
    }

    private final void setDefaultImg(int i) {
        this.h.remove(i);
        View view = this.m[i];
        if (view != null) {
            view.setVisibility(8);
        }
        if (CommunityManager.f19086a.a().s()) {
            ImageView imageView = this.l[i];
            if (imageView != null) {
                imageView.setImageResource(R.drawable.feed_post_vote_add_dark);
            }
        } else {
            ImageView imageView2 = this.l[i];
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.feed_post_vote_add);
            }
        }
        j();
    }

    public void a() {
        setVisibility(8);
        View view = this.m[this.j];
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.m[this.k];
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (CommunityManager.f19086a.a().s()) {
            ImageView imageView = this.l[this.j];
            if (imageView != null) {
                imageView.setImageResource(R.drawable.feed_post_vote_add_dark);
            }
            ImageView imageView2 = this.l[this.k];
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.feed_post_vote_add_dark);
            }
        } else {
            ImageView imageView3 = this.l[this.j];
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.feed_post_vote_add);
            }
            ImageView imageView4 = this.l[this.k];
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.feed_post_vote_add);
            }
        }
        this.h.remove(this.j);
        this.h.remove(this.k);
        FeedAddPostFragment feedAddPostFragment = this.g;
        if (feedAddPostFragment == null) {
            return;
        }
        feedAddPostFragment.A();
    }

    public final boolean b() {
        if (getVisibility() != 0) {
            return true;
        }
        ChildImageInfo childImageInfo = this.h.get(this.j);
        if (TextUtils.isEmpty(childImageInfo == null ? null : childImageInfo.mImagePath)) {
            return false;
        }
        ChildImageInfo childImageInfo2 = this.h.get(this.k);
        return !TextUtils.isEmpty(childImageInfo2 == null ? null : childImageInfo2.mImagePath);
    }

    public final void c() {
        int i;
        Iterator<ChildImageInfo> it = SelectPhotoManager.a().c().iterator();
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            i = i4;
            if (!it.hasNext()) {
                break;
            }
            ChildImageInfo next = it.next();
            int i5 = i2;
            int i6 = i;
            if (!TextUtils.isEmpty(next.mImagePath)) {
                String str = next.mImagePath;
                ChildImageInfo childImageInfo = this.h.get(this.j);
                if (str.equals(childImageInfo == null ? null : childImageInfo.mImagePath)) {
                    i2 = i3;
                }
                String str2 = next.mImagePath;
                ChildImageInfo childImageInfo2 = this.h.get(this.k);
                i5 = i2;
                i6 = i;
                if (str2.equals(childImageInfo2 == null ? null : childImageInfo2.mImagePath)) {
                    i6 = i3;
                    i5 = i2;
                }
            }
            i3++;
            i2 = i5;
            i4 = i6;
        }
        if (i2 == -1 && i == -1) {
            if (SelectPhotoManager.a().c().size() > 0) {
                this.h.put(this.j, SelectPhotoManager.a().c().get(0));
                c(this.j);
            } else {
                h();
                i();
            }
            if (SelectPhotoManager.a().c().size() > 1) {
                this.h.put(this.k, SelectPhotoManager.a().c().get(1));
                c(this.k);
            }
        } else {
            if (i2 == 0) {
                this.h.put(this.j, SelectPhotoManager.a().c().get(0));
                c(this.j);
                if (SelectPhotoManager.a().c().size() > 1) {
                    this.h.put(this.k, SelectPhotoManager.a().c().get(1));
                    c(this.k);
                } else {
                    i();
                }
            } else if (i2 == 1) {
                this.h.put(this.j, SelectPhotoManager.a().c().get(1));
                c(this.j);
                this.h.put(this.k, SelectPhotoManager.a().c().get(0));
                c(this.k);
            }
            if (i == 0) {
                this.h.put(this.k, SelectPhotoManager.a().c().get(0));
                c(this.k);
                if (SelectPhotoManager.a().c().size() > 1) {
                    this.h.put(this.j, SelectPhotoManager.a().c().get(1));
                    c(this.j);
                } else {
                    h();
                }
            } else if (i == 1) {
                this.h.put(this.k, SelectPhotoManager.a().c().get(1));
                c(this.k);
                this.h.put(this.j, SelectPhotoManager.a().c().get(0));
                c(this.j);
            }
        }
        j();
    }

    public final String getLeftPicLocalPath() {
        ChildImageInfo childImageInfo = this.h.get(this.j);
        if (childImageInfo == null) {
            return null;
        }
        return childImageInfo.mImagePath;
    }

    public final String getPicPaths() {
        StringBuilder sb = new StringBuilder();
        ChildImageInfo childImageInfo = this.h.get(this.j);
        sb.append((Object) (childImageInfo == null ? null : childImageInfo.mImagePath));
        sb.append(';');
        ChildImageInfo childImageInfo2 = this.h.get(this.k);
        sb.append((Object) (childImageInfo2 == null ? null : childImageInfo2.mImagePath));
        return sb.toString();
    }

    public final void setOwnFragment(FeedAddPostFragment fm) {
        Intrinsics.e(fm, "fm");
        this.g = fm;
    }

    public final void setPics(String[] strArr) {
        if (strArr == null) {
            return;
        }
        if (!(strArr.length == 0)) {
            if (StringsKt.c((CharSequence) strArr[0], (CharSequence) "http://", false, 2, (Object) null) || StringsKt.c((CharSequence) strArr[0], (CharSequence) "https://", false, 2, (Object) null)) {
                FeedAddPostFragment feedAddPostFragment = this.g;
                ImageFileLoader.a(feedAddPostFragment == null ? null : feedAddPostFragment.getFragmentActive()).a(strArr[0]).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$CBNDbfmFD6MTKBD5Upb20TaN0cg
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        FeedPostVoteView.a(FeedPostVoteView.this, file, exc);
                    }
                }).a();
            } else {
                a(this.j, strArr[0]);
            }
        }
        if (strArr.length > 1) {
            if (!StringsKt.c((CharSequence) strArr[1], (CharSequence) "http://", false, 2, (Object) null) && !StringsKt.c((CharSequence) strArr[1], (CharSequence) "https://", false, 2, (Object) null)) {
                a(this.k, strArr[1]);
                return;
            }
            FeedAddPostFragment feedAddPostFragment2 = this.g;
            ImageFileLoader.a(feedAddPostFragment2 == null ? null : feedAddPostFragment2.getFragmentActive()).a(strArr[1]).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostVoteView$z7nkiMN4awgWnSlrrIyc-Cx5bAI
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    FeedPostVoteView.b(FeedPostVoteView.this, file, exc);
                }
            }).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        FeedAddPostFragment feedAddPostFragment = this.g;
        if (feedAddPostFragment != null) {
            feedAddPostFragment.B();
        }
        if (i == 0) {
            EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_SHOW);
        }
    }
}
