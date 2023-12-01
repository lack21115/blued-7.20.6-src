package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.ad.ADConstants;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentBluedInterstitialBinding;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.welcome.AdMiniAppDialogFragment;
import com.soft.blued.ui.welcome.model.TwoFloorModel;
import com.soft.blued.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.WeChatUtils;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BluedInterstitialFragment.class */
public final class BluedInterstitialFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20827a = new Companion(null);
    private FragmentBluedInterstitialBinding b;

    /* renamed from: c  reason: collision with root package name */
    private TwoFloorModel f20828c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BluedInterstitialFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, TwoFloorModel twoFloorModel) {
            Intrinsics.e(context, "context");
            Intrinsics.e(twoFloorModel, "model");
            Bundle bundle = new Bundle();
            bundle.putSerializable("AD_MODEL", (Serializable) twoFloorModel);
            TerminalActivity.d(context, BluedInterstitialFragment.class, bundle);
        }
    }

    private final void a() {
        final TwoFloorModel twoFloorModel = this.f20828c;
        if (twoFloorModel == null) {
            return;
        }
        if (TextUtils.isEmpty(twoFloorModel.master_image)) {
            d();
        } else {
            ImageFileLoader.a(getFragmentActive()).a(twoFloorModel.master_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$PwY4sLuwI52WFp8hfFcYY1phRIA
                public final void onUIFinish(File file, Exception exc) {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, twoFloorModel, file, exc);
                }
            }).a();
        }
    }

    @JvmStatic
    public static final void a(Context context, TwoFloorModel twoFloorModel) {
        f20827a.a(context, twoFloorModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedInterstitialFragment bluedInterstitialFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        bluedInterstitialFragment.b();
        bluedInterstitialFragment.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment bluedInterstitialFragment, final TwoFloorModel twoFloorModel) {
        ShapeTextView shapeTextView;
        ImageView imageView;
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        Intrinsics.e(twoFloorModel, "$it");
        ImageWrapper a2 = ImageLoader.a(bluedInterstitialFragment.getFragmentActive(), twoFloorModel.master_image).a(new BluedInterstitialFragment$loadPic$1$1$1$1(bluedInterstitialFragment, twoFloorModel, bluedInterstitialFragment.getFragmentActive()));
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = bluedInterstitialFragment.b;
        a2.a(fragmentBluedInterstitialBinding == null ? null : fragmentBluedInterstitialBinding.b);
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding2 = bluedInterstitialFragment.b;
        if (fragmentBluedInterstitialBinding2 != null && (imageView = fragmentBluedInterstitialBinding2.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$iotsYRdja5hyoO82QSroYubG1_k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, view);
                }
            });
        }
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding3 = bluedInterstitialFragment.b;
        if (fragmentBluedInterstitialBinding3 == null || (shapeTextView = fragmentBluedInterstitialBinding3.f15098a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$l_LYgzqit6oAl7sg6_O3SjT_wqw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluedInterstitialFragment.a(BluedInterstitialFragment.this, twoFloorModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment bluedInterstitialFragment, TwoFloorModel twoFloorModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        Intrinsics.e(twoFloorModel, "$it");
        FragmentActivity activity = bluedInterstitialFragment.getActivity();
        TwoFloorModel twoFloorModel2 = twoFloorModel;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = bluedInterstitialFragment.b;
        ADClosePopOptionsUtils.a(activity, twoFloorModel2, fragmentBluedInterstitialBinding == null ? null : fragmentBluedInterstitialBinding.f15098a, ADConstants.AD_POSITION.NONE, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$ZmVIJfU94IQCddx3SSPDFJ6Fyeo
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                BluedInterstitialFragment.c(BluedInterstitialFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment bluedInterstitialFragment, final TwoFloorModel twoFloorModel, File file, Exception exc) {
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        Intrinsics.e(twoFloorModel, "$it");
        if (file == null || !file.exists()) {
            bluedInterstitialFragment.d();
        } else {
            bluedInterstitialFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$DQKTW9Mi-Pt0eJGKZZ95kPe5Lww
                @Override // java.lang.Runnable
                public final void run() {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, twoFloorModel);
                }
            });
        }
    }

    private final void b() {
        TwoFloorModel twoFloorModel = this.f20828c;
        if (twoFloorModel == null) {
            return;
        }
        FindHttpUtils.b(twoFloorModel.click_url);
        if (twoFloorModel.wx != null && !TextUtils.isEmpty(twoFloorModel.wx.id) && !TextUtils.isEmpty(twoFloorModel.wx.path)) {
            if (twoFloorModel.wx.is_popup != 1) {
                WeChatUtils.a(getContext(), twoFloorModel.wx.id, twoFloorModel.wx.path);
                return;
            }
            AdMiniAppDialogFragment.Companion companion = AdMiniAppDialogFragment.f20819a;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            String str = twoFloorModel.wx.id;
            Intrinsics.c(str, "it.wx.id");
            String str2 = twoFloorModel.wx.path;
            Intrinsics.c(str2, "it.wx.path");
            companion.a(childFragmentManager, str, str2, twoFloorModel);
            return;
        }
        Log.v("drb", "intoAdUrl deep_link_url:" + ((Object) twoFloorModel.deep_link_url) + " -- target_url:" + ((Object) twoFloorModel.target_url));
        if (TextUtils.isEmpty(twoFloorModel.deep_link_url)) {
            Uri f = BluedURIRouter.a().f(twoFloorModel.target_url);
            Uri uri = f;
            if (f == null) {
                uri = BluedURIRouter.a().a(twoFloorModel.target_url, 9);
            }
            BluedURIRouter.a().a(getActivity(), uri);
            if (StringsKt.a("2", twoFloorModel.adms_type, true)) {
                FindHttpUtils.a(twoFloorModel.target_url);
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(twoFloorModel.deep_link_url));
        if (AppUtils.a(intent)) {
            if (StringsKt.a("2", twoFloorModel.adms_type, true)) {
                FindHttpUtils.a(twoFloorModel.deep_link_url);
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.startActivity(intent);
            return;
        }
        Uri f2 = BluedURIRouter.a().f(twoFloorModel.target_url);
        Uri uri2 = f2;
        if (f2 == null) {
            uri2 = BluedURIRouter.a().a(twoFloorModel.target_url, 9);
        }
        BluedURIRouter.a().a(getActivity(), uri2);
        if (StringsKt.a("2", twoFloorModel.adms_type, true)) {
            FindHttpUtils.a(twoFloorModel.target_url);
        }
    }

    private final void c() {
        Bundle arguments = getArguments();
        Object obj = arguments == null ? null : arguments.get("AD_MODEL");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.welcome.model.TwoFloorModel");
        }
        this.f20828c = (TwoFloorModel) obj;
        LiveEventBus.get("live_back_to_two_level").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(BluedInterstitialFragment bluedInterstitialFragment) {
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        bluedInterstitialFragment.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        ActivityChangeAnimationUtils.d(getActivity());
    }

    public boolean onBackPressed() {
        ShapeTextView shapeTextView;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = this.b;
        return (fragmentBluedInterstitialBinding == null || (shapeTextView = fragmentBluedInterstitialBinding.f15098a) == null || !shapeTextView.performClick()) ? false : true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityChangeAnimationUtils.b(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_blued_interstitial, (ViewGroup) null);
        this.b = FragmentBluedInterstitialBinding.a(inflate);
        c();
        a();
        return inflate;
    }
}
