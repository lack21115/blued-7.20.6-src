package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveRoomFuctionBinding.class */
public final class FragmentLiveRoomFuctionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ListView f11971a;
    private final FrameLayout b;

    private FragmentLiveRoomFuctionBinding(FrameLayout frameLayout, ListView listView) {
        this.b = frameLayout;
        this.f11971a = listView;
    }

    public static FragmentLiveRoomFuctionBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLiveRoomFuctionBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_room_fuction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveRoomFuctionBinding a(View view) {
        ListView listView = (ListView) view.findViewById(R.id.live_room_function_lv);
        if (listView != null) {
            return new FragmentLiveRoomFuctionBinding((FrameLayout) view, listView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("liveRoomFunctionLv"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
