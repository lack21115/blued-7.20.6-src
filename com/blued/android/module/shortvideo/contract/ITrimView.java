package com.blued.android.module.shortvideo.contract;

import android.widget.VideoView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.view.RangeSeekBar;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/contract/ITrimView.class */
public interface ITrimView extends IView {
    BaseFragment a();

    void a(double d);

    void a(RecyclerView.OnScrollListener onScrollListener);

    void a(TrimDataModel trimDataModel);

    void a(RangeSeekBar.OnRangeSeekBarChangeListener onRangeSeekBarChangeListener);

    VideoView b();

    long c();

    void c(int i);

    long d();

    void e();

    FragmentActivity getActivity();
}
