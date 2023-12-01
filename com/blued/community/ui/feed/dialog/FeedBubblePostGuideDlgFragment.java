package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;
import com.blued.community.databinding.FragmentFeedBubblePostGuideBinding;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.feed.model.FeedBubbleListGuideExtra;
import com.blued.community.ui.send.fragment.FeedPostSignBaseFragment;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.das.client.feed.FeedProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubblePostGuideDlgFragment.class */
public final class FeedBubblePostGuideDlgFragment extends CommFullScreenDialog {
    private final Context a;
    private final FeedBubbleListGuideExtra b;
    private FragmentFeedBubblePostGuideBinding c;
    private FeedPostSignStateItem d;
    private CommonMultiItemAdapter<FeedPostSignStateItem> e;

    public FeedBubblePostGuideDlgFragment(Context mContext, FeedBubbleListGuideExtra extraModel) {
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(extraModel, "extraModel");
        this.a = mContext;
        this.b = extraModel;
        this.e = new FeedBubblePostGuideDlgFragment$adapter$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubblePostGuideDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
        EventTrackFeed.c(FeedProtos.Event.FEED_PUNCH_BACK_GUIDE_POP_NO_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(FeedPostSignStateItem feedPostSignStateItem) {
        this.d = feedPostSignStateItem;
        this.e.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBubblePostGuideDlgFragment this$0) {
        final ShapeLinearLayout shapeLinearLayout;
        Intrinsics.e(this$0, "this$0");
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding = this$0.c;
        if (fragmentFeedBubblePostGuideBinding == null || (shapeLinearLayout = fragmentFeedBubblePostGuideBinding.a) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(shapeLinearLayout, "alpha", 0.1f, 1.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.1f, 1f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedBubblePostGuideDlgFragment$showAnim$1$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ShapeLinearLayout.this.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ShapeLinearLayout.this.setVisibility(0);
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBubblePostGuideDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    private final void j() {
        TextView textView;
        ShapeTextView shapeTextView;
        FrameLayout frameLayout;
        RecyclerView recyclerView;
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding = this.c;
        TextView textView2 = fragmentFeedBubblePostGuideBinding == null ? null : fragmentFeedBubblePostGuideBinding.f;
        if (textView2 != null) {
            String title = this.b.getTitle();
            String str = title;
            if (title == null) {
                str = "选个状态去冒泡，相同状态好撩更好聊!";
            }
            textView2.setText(str);
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding2 = this.c;
        ShapeTextView shapeTextView2 = fragmentFeedBubblePostGuideBinding2 == null ? null : fragmentFeedBubblePostGuideBinding2.b;
        if (shapeTextView2 != null) {
            String remove = this.b.getRemove();
            String str2 = remove;
            if (remove == null) {
                str2 = "吸引同城的他";
            }
            shapeTextView2.setText(str2);
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding3 = this.c;
        TextView textView3 = fragmentFeedBubblePostGuideBinding3 == null ? null : fragmentFeedBubblePostGuideBinding3.e;
        if (textView3 != null) {
            String button = this.b.getButton();
            String str3 = button;
            if (button == null) {
                str3 = "去冒泡";
            }
            textView3.setText(str3);
        }
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding4 = this.c;
        RecyclerView recyclerView2 = fragmentFeedBubblePostGuideBinding4 == null ? null : fragmentFeedBubblePostGuideBinding4.c;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding5 = this.c;
        if (fragmentFeedBubblePostGuideBinding5 != null && (recyclerView = fragmentFeedBubblePostGuideBinding5.c) != null) {
            recyclerView.setHasFixedSize(true);
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding6 = this.c;
        RecyclerView recyclerView3 = fragmentFeedBubblePostGuideBinding6 == null ? null : fragmentFeedBubblePostGuideBinding6.c;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.e);
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding7 = this.c;
        if (fragmentFeedBubblePostGuideBinding7 != null && (frameLayout = fragmentFeedBubblePostGuideBinding7.d) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubblePostGuideDlgFragment$5hQ4i0WZwnMkZnfoPiWTHvgCkjs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubblePostGuideDlgFragment.a(view);
                }
            });
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding8 = this.c;
        if (fragmentFeedBubblePostGuideBinding8 != null && (shapeTextView = fragmentFeedBubblePostGuideBinding8.b) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubblePostGuideDlgFragment$fr4cPo3aAJQGyqh6Or9VJ9bpu0k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubblePostGuideDlgFragment.a(FeedBubblePostGuideDlgFragment.this, view);
                }
            });
        }
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding9 = this.c;
        if (fragmentFeedBubblePostGuideBinding9 != null && (textView = fragmentFeedBubblePostGuideBinding9.e) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubblePostGuideDlgFragment$6HqQu6pmr3Z2--s7qfkM4OJ7RYU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubblePostGuideDlgFragment.b(FeedBubblePostGuideDlgFragment.this, view);
                }
            });
        }
        ArrayList<FeedPostSignStateItem> state_data = this.b.getState_data();
        if (state_data != null) {
            if (state_data.size() > 1) {
                this.d = state_data.get(1);
            } else if (!state_data.isEmpty()) {
                this.d = state_data.get(0);
            }
            this.e.setDataAndNotify(state_data);
        }
        EventTrackFeed.c(FeedProtos.Event.FEED_PUNCH_BACK_GUIDE_POP_SHOW);
    }

    private final void k() {
        Context activity = getActivity();
        if (activity != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("selected_model", this.d);
            bundle.putInt("page_from", 3);
            FeedPostSignBaseFragment.a(activity, bundle);
        }
        dismissAllowingStateLoss();
        FeedProtos.Event event = FeedProtos.Event.FEED_PUNCH_BACK_GUIDE_POP_YES_CLICK;
        FeedPostSignStateItem feedPostSignStateItem = this.d;
        EventTrackFeed.j(event, feedPostSignStateItem == null ? null : feedPostSignStateItem.getBubble_state_id());
    }

    private final void l() {
        ShapeLinearLayout shapeLinearLayout;
        FragmentFeedBubblePostGuideBinding fragmentFeedBubblePostGuideBinding = this.c;
        if (fragmentFeedBubblePostGuideBinding == null || (shapeLinearLayout = fragmentFeedBubblePostGuideBinding.a) == null) {
            return;
        }
        shapeLinearLayout.postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubblePostGuideDlgFragment$RByl5qCmiTVGdN6sa6S7UTD-6zM
            @Override // java.lang.Runnable
            public final void run() {
                FeedBubblePostGuideDlgFragment.b(FeedBubblePostGuideDlgFragment.this);
            }
        }, 50L);
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public int e() {
        return R.layout.fragment_feed_bubble_post_guide;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public void i() {
        super.i();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        this.c = FragmentFeedBubblePostGuideBinding.a(onCreateView);
        return onCreateView;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        j();
        l();
    }
}
