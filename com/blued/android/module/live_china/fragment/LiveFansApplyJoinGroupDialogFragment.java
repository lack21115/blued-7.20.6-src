package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansApplyJoinGroupDialogFragment.class */
public class LiveFansApplyJoinGroupDialogFragment extends BaseDialogFragment {
    public Context a;
    private View b;
    private View c;
    private TextView d;
    private EditText e;
    private TextView f;
    private LiveFansGroupModel g;
    private CallBack h;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansApplyJoinGroupDialogFragment$CallBack.class */
    public interface CallBack {
        void onSuccess();
    }

    public LiveFansApplyJoinGroupDialogFragment(Context context, LiveFansGroupModel liveFansGroupModel, CallBack callBack) {
        this.a = context;
        this.g = liveFansGroupModel;
        this.h = callBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    private void e() {
        if (this.g == null) {
            return;
        }
        f();
    }

    private void f() {
        this.f.setClickable(false);
        LiveRoomHttpUtils.a(this.g.group_id, this.g.allow_join, !TextUtils.isEmpty(this.e.getText()) ? this.e.getText().toString() : null, new BluedUIHttpResponse<BluedEntityA<Object>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveFansApplyJoinGroupDialogFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (LiveFansApplyJoinGroupDialogFragment.this.h != null) {
                    LiveFansApplyJoinGroupDialogFragment.this.h.onSuccess();
                }
                LiveFansApplyJoinGroupDialogFragment.this.dismiss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveFansApplyJoinGroupDialogFragment.this.f.setClickable(true);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.c.animate().translationY(0.0f).setDuration(300L).start();
    }

    public void d() {
        super.dismiss();
    }

    public void dismiss() {
        if (this.c.getTranslationY() != 0.0f) {
            return;
        }
        this.c.animate().translationY(this.c.getHeight()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveFansApplyJoinGroupDialogFragment.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveFansApplyJoinGroupDialogFragment.this.d();
                super.onAnimationEnd(animator);
            }
        }).start();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_apply_join_group, (ViewGroup) null);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getContext(), R.color.transparent)));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(width, -1));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.alpha_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = width;
        attributes.height = -1;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        window.setGravity(80);
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_fans_apply_join_group, viewGroup);
        this.b = inflate.findViewById(R.id.view_background);
        this.c = inflate.findViewById(R.id.rl_content);
        this.d = (TextView) inflate.findViewById(R.id.tv_title);
        this.e = (EditText) inflate.findViewById(R.id.et_apply_reason);
        this.f = (TextView) inflate.findViewById(R.id.tv_apply_join);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansApplyJoinGroupDialogFragment$XzjoEnjzGzLtQ2XAtZUwKYs58F8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansApplyJoinGroupDialogFragment.this.b(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansApplyJoinGroupDialogFragment$XYpHisPjdSck2NaUl16_EuCCNHI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansApplyJoinGroupDialogFragment.this.a(view);
            }
        });
        this.b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansApplyJoinGroupDialogFragment$BR5TL8YCnc9rcia2DLhVR8it5Cw
            @Override // java.lang.Runnable
            public final void run() {
                LiveFansApplyJoinGroupDialogFragment.this.g();
            }
        });
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
