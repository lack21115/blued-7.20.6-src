package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveTwoLevelFragment.class */
public class LiveTwoLevelFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f31225a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private LiveTwoFloorModel f31226c;
    private String d = "two_floor_live";
    private LoadOptions e = null;
    private Observer<String> f = new Observer<String>() { // from class: com.soft.blued.ui.live.fragment.LiveTwoLevelFragment.2
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(String str) {
            Log.i("xpm", "LiveTwoLevelFragment  KEY_EVENT_BACK_TWO_LEVEL ... ");
            LiveTwoLevelFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveTwoLevelFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveTwoLevelFragment.this.b();
                }
            }, 300L);
        }
    };

    public static void a(Context context, String str, LiveTwoFloorModel liveTwoFloorModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("liveTwoFloorModel", liveTwoFloorModel);
        bundle.putString("from_page", str);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, LiveTwoLevelFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        getActivity().finish();
    }

    public void a() {
        String str;
        String str2;
        int i;
        LiveTwoFloorModel liveTwoFloorModel = this.f31226c;
        if (liveTwoFloorModel == null || StringUtils.a(liveTwoFloorModel.lid, 0) <= 0) {
            b();
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, this.f31226c.lid, this.f31226c.uid, this.f31226c.id);
        long a2 = StringUtils.a(this.f31226c.lid, 0L);
        if (this.f31226c.anchor != null) {
            str = this.f31226c.anchor.name;
            str2 = this.f31226c.anchor.avatar;
            i = this.f31226c.anchor.vbadge;
        } else {
            str = "";
            str2 = str;
            i = 0;
        }
        LiveRoomData liveRoomData = new LiveRoomData(a2, this.f31226c.screen_pattern, this.d, this.f31226c.uid, str, str2, i);
        liveRoomData.live_url = this.f31226c.live_play;
        LiveRoomInfoChannel.a(getContext(), liveRoomData);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ActivityChangeAnimationUtils.b(getActivity());
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = 2131237310;
        this.e.b = 2131237310;
        if (getArguments() != null) {
            this.f31226c = (LiveTwoFloorModel) getArguments().getSerializable("liveTwoFloorModel");
            this.d = getArguments().getString("from_page", "two_floor_live");
        }
        if (this.f31226c == null) {
            b();
        }
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f31225a;
        if (view == null) {
            LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.f);
            View inflate = layoutInflater.inflate(R.layout.fragment_play_two_level, viewGroup, false);
            this.f31225a = inflate;
            this.b = (ImageView) inflate.findViewById(2131364545);
            if (this.f31226c.anchor == null || TextUtils.isEmpty(this.f31226c.anchor.avatar)) {
                a();
            } else {
                ImageLoader.a(getFragmentActive(), this.f31226c.anchor.avatar).b(2131236500).e().d().a(new ImageLoadResult(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveTwoLevelFragment.1
                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a() {
                        super.a();
                        LiveTwoLevelFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveTwoLevelFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiveTwoLevelFragment.this.a();
                            }
                        }, 300L);
                    }

                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a(int i, Exception exc) {
                        LiveTwoLevelFragment.this.a();
                    }
                }).a(this.b);
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f31225a.getParent()).removeView(this.f31225a);
        }
        return this.f31225a;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(this.f);
    }
}
