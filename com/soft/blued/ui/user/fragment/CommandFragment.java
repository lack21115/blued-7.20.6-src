package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.WatchWordModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/CommandFragment.class */
public class CommandFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Activity f20152a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f20153c;
    private ImageView d;
    private WatchWordModel e;

    public static void a() {
        ClipboardManager clipboardManager = (ClipboardManager) AppInfo.d().getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager != null) {
            try {
                clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
                clipboardManager.setText("");
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, WatchWordModel watchWordModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", watchWordModel);
        TerminalActivity.a(bundle);
        TransparentActivity.b(context, CommandFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        a();
        d();
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = (WatchWordModel) arguments.getSerializable("model");
        }
        if (this.e == null) {
            d();
        }
    }

    private void c() {
        if (this.e == null) {
            d();
            return;
        }
        this.f20153c = this.b.findViewById(R.id.img_close);
        this.d = (ImageView) this.b.findViewById(R.id.img_command);
        ImageLoader.a(getFragmentActive(), this.e.image).a(this.d);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.CommandFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommandFragment.a();
                WebViewShowInfoFragment.show(CommandFragment.this.f20152a, CommandFragment.this.e.url, -1);
                CommandFragment.this.d();
            }
        });
        this.f20153c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$CommandFragment$NQjSiLZIm_fWSHoASOe2dzWeAZ8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommandFragment.this.a(view);
            }
        });
        this.d.postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$CommandFragment$nFA3wyTPOGVh5OsRvXeKYmzQhS0
            @Override // java.lang.Runnable
            public final void run() {
                CommandFragment.this.e();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        getActivity().finish();
        ActivityChangeAnimationUtils.k(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        this.d.startAnimation(scaleAnimation);
        this.d.setVisibility(0);
        this.f20153c.setVisibility(0);
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public boolean onBackPressed() {
        this.f20153c.performClick();
        return true;
    }

    public void onCreate(Bundle bundle) {
        this.f20152a = getActivity();
        ActivityChangeAnimationUtils.h(getActivity());
        b();
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_command, viewGroup, false);
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
