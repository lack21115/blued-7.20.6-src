package android.webkit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewFragment.class */
public class WebViewFragment extends Fragment {
    private boolean mIsWebViewAvailable;
    private WebView mWebView;

    public WebView getWebView() {
        if (this.mIsWebViewAvailable) {
            return this.mWebView;
        }
        return null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mWebView != null) {
            this.mWebView.destroy();
        }
        this.mWebView = new WebView(getActivity());
        this.mIsWebViewAvailable = true;
        return this.mWebView;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        if (this.mWebView != null) {
            this.mWebView.destroy();
            this.mWebView = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.mIsWebViewAvailable = false;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWebView.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        this.mWebView.onResume();
        super.onResume();
    }
}
