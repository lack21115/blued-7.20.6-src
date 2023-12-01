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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BluedInterstitialFragment.class */
public final class BluedInterstitialFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34518a = new Companion(null);
    private FragmentBluedInterstitialBinding b;

    /* renamed from: c  reason: collision with root package name */
    private TwoFloorModel f34519c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BluedInterstitialFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, TwoFloorModel model) {
            Intrinsics.e(context, "context");
            Intrinsics.e(model, "model");
            Bundle bundle = new Bundle();
            bundle.putSerializable("AD_MODEL", model);
            TerminalActivity.d(context, BluedInterstitialFragment.class, bundle);
        }
    }

    private final void a() {
        final TwoFloorModel twoFloorModel = this.f34519c;
        if (twoFloorModel == null) {
            return;
        }
        if (TextUtils.isEmpty(twoFloorModel.master_image)) {
            d();
        } else {
            ImageFileLoader.a(getFragmentActive()).a(twoFloorModel.master_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$PwY4sLuwI52WFp8hfFcYY1phRIA
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, twoFloorModel, file, exc);
                }
            }).a();
        }
    }

    @JvmStatic
    public static final void a(Context context, TwoFloorModel twoFloorModel) {
        f34518a.a(context, twoFloorModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedInterstitialFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.b();
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment this$0, final TwoFloorModel it) {
        ShapeTextView shapeTextView;
        ImageView imageView;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        ImageWrapper a2 = ImageLoader.a(this$0.getFragmentActive(), it.master_image).a(new BluedInterstitialFragment$loadPic$1$1$1$1(this$0, it, this$0.getFragmentActive()));
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = this$0.b;
        a2.a(fragmentBluedInterstitialBinding == null ? null : fragmentBluedInterstitialBinding.b);
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding2 = this$0.b;
        if (fragmentBluedInterstitialBinding2 != null && (imageView = fragmentBluedInterstitialBinding2.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$iotsYRdja5hyoO82QSroYubG1_k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, view);
                }
            });
        }
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding3 = this$0.b;
        if (fragmentBluedInterstitialBinding3 == null || (shapeTextView = fragmentBluedInterstitialBinding3.f28788a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$l_LYgzqit6oAl7sg6_O3SjT_wqw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluedInterstitialFragment.a(BluedInterstitialFragment.this, it, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment this$0, TwoFloorModel it, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        FragmentActivity activity = this$0.getActivity();
        TwoFloorModel twoFloorModel = it;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = this$0.b;
        ADClosePopOptionsUtils.a(activity, twoFloorModel, fragmentBluedInterstitialBinding == null ? null : fragmentBluedInterstitialBinding.f28788a, ADConstants.AD_POSITION.NONE, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$ZmVIJfU94IQCddx3SSPDFJ6Fyeo
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                BluedInterstitialFragment.c(BluedInterstitialFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final BluedInterstitialFragment this$0, final TwoFloorModel it, File file, Exception exc) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        if (file == null || !file.exists()) {
            this$0.d();
        } else {
            this$0.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$DQKTW9Mi-Pt0eJGKZZ95kPe5Lww
                @Override // java.lang.Runnable
                public final void run() {
                    BluedInterstitialFragment.a(BluedInterstitialFragment.this, it);
                }
            });
        }
    }

    private final void b() {
        TwoFloorModel twoFloorModel = this.f34519c;
        if (twoFloorModel == null) {
            return;
        }
        FindHttpUtils.b(twoFloorModel.click_url);
        if (twoFloorModel.wx != null && !TextUtils.isEmpty(twoFloorModel.wx.id) && !TextUtils.isEmpty(twoFloorModel.wx.path)) {
            if (twoFloorModel.wx.is_popup != 1) {
                WeChatUtils.a(getContext(), twoFloorModel.wx.id, twoFloorModel.wx.path);
                return;
            }
            AdMiniAppDialogFragment.Companion companion = AdMiniAppDialogFragment.f34510a;
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
        this.f34519c = (TwoFloorModel) obj;
        LiveEventBus.get("live_back_to_two_level").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(BluedInterstitialFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        ActivityChangeAnimationUtils.d(getActivity());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        ShapeTextView shapeTextView;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding = this.b;
        return (fragmentBluedInterstitialBinding == null || (shapeTextView = fragmentBluedInterstitialBinding.f28788a) == null || !shapeTextView.performClick()) ? false : true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityChangeAnimationUtils.b(getActivity());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_blued_interstitial, (ViewGroup) null);
        this.b = FragmentBluedInterstitialBinding.a(inflate);
        c();
        a();
        return inflate;
    }
}
