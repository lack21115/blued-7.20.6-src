package com.soft.blued.ui.welcome;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.ui.TimeoutFragment;
import com.miui.externalserver.IExternalMediaSplashAdListener;
import com.miui.externalserver.IExternalMediaSplashAdService;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/XIAOMISplashFragment.class */
public class XIAOMISplashFragment extends TimeoutFragment {
    public static boolean m = false;
    public Context n;
    public View o;
    public long p;
    private String[] s;
    private String[] t;
    private String[] u;
    private String v;
    public boolean q = false;
    boolean r = false;
    private IExternalMediaSplashAdListener w = new IExternalMediaSplashAdListener.Stub() { // from class: com.soft.blued.ui.welcome.XIAOMISplashFragment.1
        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a() throws RemoteException {
            XIAOMISplashFragment.this.q = true;
            XIAOMISplashFragment.this.p = System.currentTimeMillis();
            FindHttpUtils.b(XIAOMISplashFragment.this.s);
            Log.v("drb", "小米 onAdLoaded");
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a(int i) throws RemoteException {
            XIAOMISplashFragment.this.j();
            Log.v("drb", "小米 onAdError:" + i);
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void b() throws RemoteException {
            FindHttpUtils.b(XIAOMISplashFragment.this.u);
            XIAOMISplashFragment.this.j();
        }
    };

    private void a(final String str, final IExternalMediaSplashAdListener iExternalMediaSplashAdListener) {
        getActivity().getApplication().bindService(l(), new ServiceConnection() { // from class: com.soft.blued.ui.welcome.XIAOMISplashFragment.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("splash_default_enable", true);
                try {
                    IExternalMediaSplashAdService.Stub.a(iBinder).a(str, iExternalMediaSplashAdListener, bundle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1);
    }

    private void k() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            m = false;
            Intent intent = new Intent();
            long j = this.p;
            long j2 = j;
            if (j == 0) {
                j2 = System.currentTimeMillis();
            }
            intent.putExtra("THIRD_UNVALID_DURATION", j2);
            intent.putExtra("THIRD_HAS_CALL_BACK", this.q);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private Intent l() {
        Intent intent = new Intent();
        intent.setClassName("com.miui.systemAdSolution", "com.miui.systemAdSolution.splashAd.ExternalMediaSplashAdService");
        return intent;
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void g() {
        k();
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public View h() {
        return this.o;
    }

    public void j() {
        if (this.r) {
            return;
        }
        this.r = true;
        k();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.o;
        if (view == null) {
            if (getArguments() != null) {
                this.s = getArguments().getStringArray("KEY_SHOW_URL");
                this.t = getArguments().getStringArray("KEY_CLICK_URL");
                this.u = getArguments().getStringArray("KEY_HIDDEN_URL");
                this.v = getArguments().getString("SPLASH_ID");
            }
            this.o = layoutInflater.inflate(R.layout.fragment_tx_splash, viewGroup, false);
            a(AppInfo.f9486a, this.w);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        return this.o;
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
