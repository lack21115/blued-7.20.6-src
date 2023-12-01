package com.blued.community.ui.send.view;

import android.app.Application;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.ui.send.dialog.FeedPostReadAuthDialogFragment;
import com.blued.community.ui.send.vm.FeedPostViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/view/FeedPostAuthView.class */
public final class FeedPostAuthView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f20083a;
    private CardView b;

    /* renamed from: c  reason: collision with root package name */
    private View f20084c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private Fragment g;
    private FeedPostViewModel h;
    private int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostAuthView(Context context) {
        super(context);
        Intrinsics.a(context);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostAuthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.a(context);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostAuthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        a();
    }

    private final void a() {
        CardView cardView = (CardView) LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.b = cardView;
        if (cardView == null) {
            return;
        }
        this.f20084c = cardView.findViewById(R.id.layout_read_auth);
        this.d = (ImageView) cardView.findViewById(R.id.iv_read_auth);
        this.e = (TextView) cardView.findViewById(R.id.tv_read_auth);
        this.f = (ImageView) cardView.findViewById(R.id.iv_read_auth_close);
        View view = this.f20084c;
        if (view != null) {
            view.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostAuthView$Uj6090uzNzwlLBjiGX7o9dgEdfE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedPostAuthView.a(FeedPostAuthView.this, view2);
                }
            }));
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostAuthView$EB-45WrUTLnpZKTCIMJ04xwSUbU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedPostAuthView.b(FeedPostAuthView.this, view2);
                }
            }));
        }
        d();
        addView(cardView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostAuthView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostAuthView this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    private final void b() {
        if (this.f20083a) {
            AppMethods.d(R.string.feed_post_anonymous_auth_toast);
            return;
        }
        Fragment fragment = this.g;
        if (fragment == null) {
            return;
        }
        KeyboardUtils.a(fragment.getActivity());
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        FeedPostReadAuthDialogFragment.f19920a.a(fragmentManager, getShowType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostAuthView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostAuthView this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    private final void c() {
        FeedPostViewModel feedPostViewModel = this.h;
        MutableLiveData<Integer> d = feedPostViewModel == null ? null : feedPostViewModel.d();
        if (d != null) {
            d.setValue(0);
        }
        FeedPostViewModel feedPostViewModel2 = this.h;
        MutableLiveData<Integer> e = feedPostViewModel2 == null ? null : feedPostViewModel2.e();
        if (e == null) {
            return;
        }
        e.setValue(0);
    }

    private final void d() {
        MutableLiveData<Integer> d;
        Integer value;
        MutableLiveData<Integer> d2;
        Integer value2;
        MutableLiveData<Integer> e;
        Integer value3;
        if (this.f20083a) {
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.feed_post_anonym));
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(R.string.feed_anonymous);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_i));
            }
            ImageView imageView2 = this.f;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            CardView cardView = this.b;
            if (cardView == null) {
                return;
            }
            cardView.setCardBackgroundColor(getResources().getColor(R.color.syc_x));
            return;
        }
        ImageView imageView3 = this.d;
        if (imageView3 != null) {
            imageView3.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.feed_post_read_auth));
        }
        if (BluedSkinUtils.c()) {
            TextView textView3 = this.e;
            if (textView3 != null) {
                textView3.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            }
        } else {
            TextView textView4 = this.e;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getResources().getColor(R.color.syc_h_in_dark_mode));
            }
        }
        FeedPostViewModel feedPostViewModel = this.h;
        if ((feedPostViewModel == null || (d = feedPostViewModel.d()) == null || (value = d.getValue()) == null || value.intValue() != 0) ? false : true) {
            FeedPostViewModel feedPostViewModel2 = this.h;
            if ((feedPostViewModel2 == null || (e = feedPostViewModel2.e()) == null || (value3 = e.getValue()) == null || value3.intValue() != 0) ? false : true) {
                TextView textView5 = this.e;
                if (textView5 != null) {
                    textView5.setText(R.string.feed_post_privacy_all);
                }
                if (BluedSkinUtils.c()) {
                    CardView cardView2 = this.b;
                    if (cardView2 != null) {
                        cardView2.setCardBackgroundColor(getResources().getColor(R.color.syc_x));
                    }
                } else {
                    CardView cardView3 = this.b;
                    if (cardView3 != null) {
                        cardView3.setCardBackgroundColor(getResources().getColor(R.color.syc_1B1B1B));
                    }
                }
                ImageView imageView4 = this.f;
                if (imageView4 == null) {
                    return;
                }
                imageView4.setVisibility(8);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        FeedPostViewModel feedPostViewModel3 = this.h;
        Integer value4 = (feedPostViewModel3 == null || (d2 = feedPostViewModel3.d()) == null) ? null : d2.getValue();
        if (value4 != null && value4.intValue() == 0) {
            sb.append(getContext().getString(R.string.feed_public));
        } else if (value4 != null && value4.intValue() == 1) {
            sb.append(getContext().getString(R.string.feed_visible_friends));
        } else if (value4 != null && value4.intValue() == 2) {
            sb.append(getContext().getString(R.string.feed_visible_self));
        }
        sb.append("、");
        FeedPostViewModel feedPostViewModel4 = this.h;
        if (feedPostViewModel4 == null) {
            value2 = null;
        } else {
            MutableLiveData<Integer> e2 = feedPostViewModel4.e();
            value2 = e2 == null ? null : e2.getValue();
        }
        if (value2 != null && value2.intValue() == 0) {
            sb.append(getContext().getString(R.string.feed_post_comment_all));
        } else if (value2 != null && value2.intValue() == 1) {
            sb.append(getContext().getString(R.string.feed_post_comment_follow_fans));
        } else if (value2 != null && value2.intValue() == 2) {
            sb.append(getContext().getString(R.string.feed_post_comment_follow));
        } else if (value2 != null && value2.intValue() == 3) {
            sb.append(getContext().getString(R.string.feed_post_comment_fans));
        }
        TextView textView6 = this.e;
        if (textView6 != null) {
            textView6.setText(sb);
        }
        CardView cardView4 = this.b;
        if (cardView4 != null) {
            cardView4.setCardBackgroundColor(getResources().getColor(R.color.syc_a_10));
        }
        ImageView imageView5 = this.f;
        if (imageView5 == null) {
            return;
        }
        imageView5.setVisibility(0);
    }

    private final int getLayoutId() {
        return R.layout.include_feed_post_auth;
    }

    public final Integer getAuthValue() {
        MutableLiveData<Integer> d;
        FeedPostViewModel feedPostViewModel = this.h;
        if (feedPostViewModel == null || (d = feedPostViewModel.d()) == null) {
            return null;
        }
        return d.getValue();
    }

    public final Integer getCommentValue() {
        MutableLiveData<Integer> e;
        FeedPostViewModel feedPostViewModel = this.h;
        if (feedPostViewModel == null || (e = feedPostViewModel.e()) == null) {
            return null;
        }
        return e.getValue();
    }

    public final Fragment getFragment() {
        return this.g;
    }

    public final int getShowType() {
        return this.i;
    }

    public void setAnonymousTopic(boolean z) {
        this.f20083a = z;
        d();
    }

    public final void setAuthValue(int i) {
        FeedPostViewModel feedPostViewModel = this.h;
        MutableLiveData<Integer> d = feedPostViewModel == null ? null : feedPostViewModel.d();
        if (d == null) {
            return;
        }
        d.setValue(Integer.valueOf(i));
    }

    public final void setCommentValue(int i) {
        FeedPostViewModel feedPostViewModel = this.h;
        MutableLiveData<Integer> e = feedPostViewModel == null ? null : feedPostViewModel.e();
        if (e == null) {
            return;
        }
        e.setValue(Integer.valueOf(i));
    }

    public void setContentTextLpType(int i) {
        TextView textView = this.e;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) (textView == null ? null : textView.getLayoutParams());
        if (i == 1) {
            if (layoutParams != null) {
                layoutParams.width = 0;
            }
            if (layoutParams != null) {
                layoutParams.weight = 1.0f;
            }
        } else {
            if (layoutParams != null) {
                layoutParams.width = -2;
            }
            if (layoutParams != null) {
                layoutParams.weight = 0.0f;
            }
        }
        TextView textView2 = this.e;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(layoutParams);
    }

    public final void setFragment(Fragment fragment) {
        this.g = fragment;
    }

    public final void setOwnFragment(Fragment fm) {
        MutableLiveData<Integer> e;
        MutableLiveData<Integer> d;
        Intrinsics.e(fm, "fm");
        this.g = fm;
        if (fm == null) {
            return;
        }
        FragmentActivity activity = fm.getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            Intrinsics.c(viewModelStore, "it.viewModelStore");
            ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
            Context d2 = AppInfo.d();
            if (d2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
            }
            this.h = (FeedPostViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d2)).get(FeedPostViewModel.class);
        }
        FeedPostViewModel feedPostViewModel = this.h;
        if (feedPostViewModel != null && (d = feedPostViewModel.d()) != null) {
            d.observe(fm.getViewLifecycleOwner(), new Observer() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostAuthView$OPq0lmvdL5EdP3oAcupiSZKI76o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedPostAuthView.a(FeedPostAuthView.this, (Integer) obj);
                }
            });
        }
        FeedPostViewModel feedPostViewModel2 = this.h;
        if (feedPostViewModel2 == null || (e = feedPostViewModel2.e()) == null) {
            return;
        }
        e.observe(fm.getViewLifecycleOwner(), new Observer() { // from class: com.blued.community.ui.send.view.-$$Lambda$FeedPostAuthView$vNwSVO6gMJW5Nzk-v46OpdOMYzU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedPostAuthView.b(FeedPostAuthView.this, (Integer) obj);
            }
        });
    }

    public final void setShowType(int i) {
        this.i = i;
    }

    public void setWidthParam(int i) {
        View view = this.f20084c;
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
        }
        View view2 = this.f20084c;
        if (view2 == null) {
            return;
        }
        view2.setLayoutParams(layoutParams);
    }
}
