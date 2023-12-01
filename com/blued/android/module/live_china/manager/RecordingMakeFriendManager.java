package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.LiveMakeFriendCardView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingMakeFriendManager.class */
public class RecordingMakeFriendManager {

    /* renamed from: a  reason: collision with root package name */
    public static int f13752a = 0;
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static double f13753c = 0.9d;
    public List<LiveFriendModel> d = new ArrayList();
    private Context e;
    private RecordingOnliveFragment f;
    private int g;

    public RecordingMakeFriendManager(RecordingOnliveFragment recordingOnliveFragment) {
        this.f = recordingOnliveFragment;
        this.e = recordingOnliveFragment.getContext();
        int i = AppInfo.l / 2;
        this.g = i;
        f13752a = (int) (i * f13753c);
        b = DensityUtils.a(this.e, 148);
    }

    public void a() {
        this.f.d_(0);
        this.f.J.setVisibility(8);
        this.f.ac.d();
        this.f.bC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.bD.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f.bD.setLayoutParams(layoutParams);
        this.f.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.bD.setBackgroundResource(R.color.transparent);
        this.f.bQ.setVisibility(8);
        this.f.bR.setVisibility(8);
        this.f.bS.setVisibility(8);
        this.f.bV.setVisibility(8);
        this.f.bW.setVisibility(8);
        this.f.bX.setVisibility(8);
        this.f.cu.setVisibility(8);
        this.f.cw.setVisibility(8);
        this.f.bh.setVisibility(8);
        this.f.bi.setVisibility(8);
        this.f.bj.setVisibility(8);
        Log.v("==record", "stopMakeFriends");
        this.f.ac.h();
        this.d.clear();
    }

    public void a(int i) {
        if (this.d.size() > i) {
            LiveFriendModel liveFriendModel = this.d.get(i);
            if (TextUtils.isEmpty(liveFriendModel.uid)) {
                return;
            }
            new LiveMakeFriendCardView(this.f).a(liveFriendModel, i);
            Logger.a("pk", "friendModel.voice = ", Integer.valueOf(liveFriendModel.voice));
        }
    }

    public void a(LiveFriendModel liveFriendModel) {
        this.f.d_(5);
        this.f.J.setVisibility(0);
        this.f.ac.d();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(0, b, 0, 0);
        this.f.bC.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.bD.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = f13752a * 2;
        this.f.bD.setLayoutParams(layoutParams2);
        this.f.L.setLayoutParams(new FrameLayout.LayoutParams(this.g, f13752a));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.g, f13752a);
        layoutParams3.leftMargin = this.g;
        this.f.bQ.setLayoutParams(layoutParams3);
        this.f.bV.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.g, f13752a);
        layoutParams4.topMargin = f13752a;
        this.f.bR.setLayoutParams(layoutParams4);
        this.f.bW.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.g, f13752a);
        layoutParams5.topMargin = f13752a;
        layoutParams5.leftMargin = this.g;
        this.f.bS.setLayoutParams(layoutParams5);
        this.f.bX.setLayoutParams(layoutParams5);
        this.f.bQ.setVisibility(0);
        this.f.bR.setVisibility(0);
        this.f.bS.setVisibility(0);
        this.f.bV.setVisibility(0);
        this.f.bW.setVisibility(0);
        this.f.bX.setVisibility(0);
        this.f.cu.setVisibility(0);
        this.f.cw.setVisibility(0);
        this.f.bh.setVisibility(0);
        this.f.bi.setVisibility(0);
        this.f.bj.setVisibility(0);
        this.f.be.setVisibility(8);
        this.f.bf.setVisibility(8);
        this.f.bg.setVisibility(8);
        this.f.aW.setVisibility(8);
        this.f.ac.a(3, liveFriendModel.target_stream);
    }

    public void a(List<LiveFriendModel> list) {
        this.d = list;
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            LiveFriendModel liveFriendModel = this.d.get(i2);
            if (i2 == 0) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.f.bY.setVisibility(8);
                    if (this.f.bh.getVisibility() == 8) {
                        this.f.bh.setVisibility(0);
                        this.f.aQ.setVisibility(8);
                    }
                } else {
                    this.f.bY.setVisibility(0);
                    this.f.bY.setText(liveFriendModel.name);
                    this.f.bh.setVisibility(8);
                }
                if (this.d.size() > 1) {
                    this.f.cb.setVisibility(8);
                }
            }
            if (i2 == 1) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.f.bZ.setVisibility(8);
                    if (this.f.bi.getVisibility() == 8) {
                        this.f.bi.setVisibility(0);
                        this.f.aR.setVisibility(8);
                    }
                } else {
                    this.f.bZ.setVisibility(0);
                    this.f.bZ.setText(liveFriendModel.name);
                    this.f.bi.setVisibility(8);
                }
            }
            if (i2 == 2) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.f.ca.setVisibility(8);
                    if (this.f.bj.getVisibility() == 8) {
                        this.f.bj.setVisibility(0);
                        this.f.aS.setVisibility(8);
                    }
                } else {
                    this.f.ca.setVisibility(0);
                    this.f.ca.setText(liveFriendModel.name);
                    this.f.bj.setVisibility(8);
                }
            }
            i = i2 + 1;
        }
    }

    public void a(final boolean z) {
        LiveRoomHttpUtils.e(new BluedUIHttpResponse(this.f.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.RecordingMakeFriendManager.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (z) {
                    RecordingMakeFriendManager.this.f.G();
                }
            }
        });
    }

    public void b() {
        if (this.f.aU()) {
            a(false);
        }
    }
}
