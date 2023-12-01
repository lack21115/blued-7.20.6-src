package com.blued.login.test;

import android.view.View;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.login.databinding.FragmentLoginTestBinding;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginFragment$liveDataObserver$2.class */
final class LoginFragment$liveDataObserver$2 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginFragment f6965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginFragment$liveDataObserver$2(LoginFragment loginFragment) {
        super(1);
        this.f6965a = loginFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginFragment loginFragment, View view) {
        Intrinsics.e(loginFragment, "this$0");
        LoginViewModel loginViewModel = (LoginViewModel) loginFragment.a();
        FragmentLoginTestBinding p = loginFragment.p();
        Intrinsics.a(p);
        loginViewModel.d(p.e.getText().toString());
    }

    public final void a(Integer num) {
        if (num == null || num.intValue() != 1) {
            if (num != null && num.intValue() == 2) {
                FragmentLoginTestBinding p = this.f6965a.p();
                Intrinsics.a(p);
                p.h.setVisibility(0);
                FragmentLoginTestBinding p2 = this.f6965a.p();
                Intrinsics.a(p2);
                TextView textView = p2.k;
                final LoginFragment loginFragment = this.f6965a;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$liveDataObserver$2$h8WGvMMfPWjDDPZ7ESvLinMOaB8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoginFragment$liveDataObserver$2.a(LoginFragment.this, view);
                    }
                });
                return;
            }
            return;
        }
        FragmentLoginTestBinding p3 = this.f6965a.p();
        Intrinsics.a(p3);
        p3.g.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        LoginAccountModel k = ((LoginViewModel) this.f6965a.a()).k();
        sb.append((Object) (k == null ? null : k.f()));
        sb.append('?');
        sb.append(UUID.randomUUID());
        ImageWrapper a2 = ImageLoader.a((IRequestHost) null, sb.toString()).a();
        FragmentLoginTestBinding p4 = this.f6965a.p();
        Intrinsics.a(p4);
        a2.a(p4.f6917a);
        FragmentLoginTestBinding p5 = this.f6965a.p();
        Intrinsics.a(p5);
        p5.b.requestFocus();
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.a;
    }
}
