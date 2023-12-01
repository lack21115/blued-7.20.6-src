package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ShowAlbumActivity.class */
public class ShowAlbumActivity extends TerminalActivity {
    public static TerminalActivity.WrapIntent a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new TerminalActivity.WrapIntent(context, cls, bundle, ShowAlbumActivity.class);
    }

    public static void b(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        a(context, cls, bundle).b();
    }

    @Override // com.blued.android.core.ui.TerminalActivity, com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
