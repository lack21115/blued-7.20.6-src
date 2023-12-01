package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.view.PopAnchorBadge;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MedalView.class */
public class MedalView extends LinearLayout implements View.OnClickListener, PopAnchorBadge.DismissLisnter {
    public View a;
    public Context b;
    public LayoutInflater c;
    public String d;
    public String e;
    public BaseFragment f;
    public ActivityFragmentActive g;
    public List<BadgeData> h;
    public RecordingOnliveFragment i;
    public PlayingOnliveBaseModeFragment j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private LoadOptions n;

    public MedalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new ArrayList();
        this.b = context;
        this.c = LayoutInflater.from(context);
        c();
        d();
    }

    private void d() {
        this.k = (ImageView) this.a.findViewById(R.id.medal_view1);
        this.l = (ImageView) this.a.findViewById(R.id.medal_view2);
        this.m = (ImageView) this.a.findViewById(R.id.medal_view3);
        LoadOptions loadOptions = new LoadOptions();
        this.n = loadOptions;
        loadOptions.d = R.drawable.anchor_badge_default;
        this.n.l = false;
        this.n.a(DensityUtils.a(this.b, 32.0f), DensityUtils.a(this.b, 28.0f));
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
    public void a() {
        if (!(this.f instanceof RecordingOnliveFragment)) {
            LiveRefreshUIObserver.a().d(0);
            LiveSetDataObserver.a().e(0);
            return;
        }
        RecordingOnliveFragment recordingOnliveFragment = this.i;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.P();
        }
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
    public void b() {
        LiveRefreshUIObserver.a().b(true);
    }

    public void c() {
        this.a = this.c.inflate(R.layout.live_medal_layout, (ViewGroup) this, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<BadgeData> list;
        Tracker.onClick(view);
        if (view.getId() == R.id.medal_view1) {
            List<BadgeData> list2 = this.h;
            if (list2 != null && list2.size() >= 1) {
                if (!(this.f instanceof PlayingOnliveBaseModeFragment)) {
                    RecordingOnliveFragment recordingOnliveFragment = this.i;
                    if (recordingOnliveFragment == null || !recordingOnliveFragment.x) {
                        Context context = this.b;
                        String str = this.d;
                        String str2 = this.e;
                        PopAnchorBadge.a(context, str, str2, this.h.get(0).id + "", this, this.g);
                    } else {
                        Context context2 = this.b;
                        String str3 = this.d;
                        String str4 = this.e;
                        PopAnchorBadgeCenter.b(context2, str3, str4, this.h.get(0).id + "", this, this.g);
                    }
                } else if (this.j.u) {
                    Context context3 = this.b;
                    String str5 = this.d;
                    String str6 = this.e;
                    PopAnchorBadgeCenter.b(context3, str5, str6, this.h.get(0).id + "", this, this.g);
                } else {
                    Context context4 = this.b;
                    String str7 = this.d;
                    String str8 = this.e;
                    PopAnchorBadge.a(context4, str7, str8, this.h.get(0).id + "", this, this.g);
                }
            }
        } else if (view.getId() == R.id.medal_view2) {
            List<BadgeData> list3 = this.h;
            if (list3 != null && list3.size() >= 2) {
                if (!(this.f instanceof PlayingOnliveBaseModeFragment)) {
                    RecordingOnliveFragment recordingOnliveFragment2 = this.i;
                    if (recordingOnliveFragment2 == null || !recordingOnliveFragment2.x) {
                        Context context5 = this.b;
                        String str9 = this.d;
                        String str10 = this.e;
                        PopAnchorBadge.a(context5, str9, str10, this.h.get(0).id + "", this, this.g);
                    } else {
                        Context context6 = this.b;
                        String str11 = this.d;
                        String str12 = this.e;
                        PopAnchorBadgeCenter.b(context6, str11, str12, this.h.get(0).id + "", this, this.g);
                    }
                } else if (this.j.u) {
                    Context context7 = this.b;
                    String str13 = this.d;
                    String str14 = this.e;
                    PopAnchorBadgeCenter.b(context7, str13, str14, this.h.get(1).id + "", this, this.g);
                } else {
                    Context context8 = this.b;
                    String str15 = this.d;
                    String str16 = this.e;
                    PopAnchorBadge.a(context8, str15, str16, this.h.get(1).id + "", this, this.g);
                }
            }
        } else if (view.getId() == R.id.medal_view3 && (list = this.h) != null && list.size() >= 3) {
            if (!(this.f instanceof PlayingOnliveBaseModeFragment)) {
                RecordingOnliveFragment recordingOnliveFragment3 = this.i;
                if (recordingOnliveFragment3 == null || !recordingOnliveFragment3.x) {
                    Context context9 = this.b;
                    String str17 = this.d;
                    String str18 = this.e;
                    PopAnchorBadge.a(context9, str17, str18, this.h.get(0).id + "", this, this.g);
                } else {
                    Context context10 = this.b;
                    String str19 = this.d;
                    String str20 = this.e;
                    PopAnchorBadgeCenter.b(context10, str19, str20, this.h.get(0).id + "", this, this.g);
                }
            } else if (this.j.u) {
                Context context11 = this.b;
                String str21 = this.d;
                String str22 = this.e;
                PopAnchorBadgeCenter.b(context11, str21, str22, this.h.get(2).id + "", this, this.g);
            } else {
                Context context12 = this.b;
                String str23 = this.d;
                String str24 = this.e;
                PopAnchorBadge.a(context12, str23, str24, this.h.get(2).id + "", this, this.g);
            }
        }
        List<BadgeData> list4 = this.h;
        if (list4 == null || list4.size() < 1) {
            return;
        }
        if (!(this.f instanceof RecordingOnliveFragment)) {
            LiveRefreshUIObserver.a().d(4);
            LiveSetDataObserver.a().e(4);
            return;
        }
        RecordingOnliveFragment recordingOnliveFragment4 = this.i;
        if (recordingOnliveFragment4 != null) {
            recordingOnliveFragment4.O();
        }
    }

    public void setMedalData(List<BadgeData> list) {
        this.h = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || i2 > 2) {
                return;
            }
            Logger.a("drb", "setMedalData = ", Integer.valueOf(i2));
            ImageWrapper d = ImageLoader.a((IRequestHost) null, list.get(i2).url).d(R.drawable.anchor_badge_default);
            if (i2 == 0) {
                this.k.setVisibility(0);
                d.a(this.k);
            } else if (i2 == 1) {
                this.l.setVisibility(0);
                d.a(this.l);
            } else if (i2 == 2) {
                this.m.setVisibility(0);
                d.a(this.m);
            }
            i = i2 + 1;
        }
    }
}
