package com.soft.blued.ui.find.viewholder;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.MaskFilterSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/viewholder/VisitorViewHolder.class */
public class VisitorViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private int f30739a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    public BluedMyVisitorList f30740c;
    public LinearLayout d;
    public ImageView e;
    public LoadOptions f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private Context q;
    private int r;
    private IRequestHost s;
    private LinearLayout t;
    private final FlowLayout u;

    public VisitorViewHolder(Context context, IRequestHost iRequestHost, View view, LoadOptions loadOptions, int i) {
        this.f = loadOptions;
        this.q = context;
        this.s = iRequestHost;
        this.r = i;
        this.d = (LinearLayout) view.findViewById(R.id.layout_friend);
        this.e = (ImageView) view.findViewById(2131364232);
        this.k = (TextView) view.findViewById(2131369448);
        this.b = (TextView) view.findViewById(2131368652);
        this.g = (TextView) view.findViewById(2131363246);
        this.h = (TextView) view.findViewById(2131362003);
        this.i = (TextView) view.findViewById(2131364242);
        this.j = (TextView) view.findViewById(2131373390);
        this.l = (ImageView) view.findViewById(2131364625);
        this.m = (ImageView) view.findViewById(2131364720);
        this.n = (TextView) view.findViewById(R.id.sign_view);
        this.o = (TextView) view.findViewById(R.id.online_time_view);
        this.p = (ImageView) view.findViewById(2131364459);
        this.t = (LinearLayout) view.findViewById(R.id.ll_personal_info);
        this.u = (FlowLayout) view.findViewById(R.id.flow_tag);
    }

    private void a() {
        if (this.r == 0) {
            if (this.f30740c.online_state == 1) {
                this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131233953));
            } else {
                this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131233951));
            }
        } else if (this.f30740c.is_call == 1) {
            this.l.setImageDrawable(BluedSkinUtils.b(this.q, R.drawable.icon_from_hello));
        } else if (this.f30740c.is_shadow == 1) {
            this.l.setImageDrawable(BluedSkinUtils.b(this.q, R.drawable.icon_from_shadow));
        } else if (this.f30740c.online_state == 1) {
            this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131233953));
        } else {
            this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131233951));
        }
    }

    public void a(int i) {
        String str;
        Long valueOf;
        String str2;
        UserInfoHelper.b(this.m, this.f30740c.vbadge, 2, 8);
        this.o.setVisibility(8);
        ImageWrapper c2 = ImageLoader.a(this.s, AvatarUtils.a(0, this.f30740c.avatar)).b(2131237310).c();
        if (a(this.f30740c)) {
            c2.d();
        }
        c2.a(this.e);
        UserRelationshipUtils.a(this.p, this.f30740c);
        if (this.f30740c.vbadge != 3 && this.f30740c.vbadge != 5) {
            UserInfoHelper.a(this.q, this.k, this.f30740c.role);
        }
        if (this.f30740c.vbadge == 3) {
            this.g.setText("");
        } else {
            if (TextUtils.isEmpty(this.f30740c.distance)) {
                this.g.setText("");
            } else {
                BluedMyVisitorList bluedMyVisitorList = this.f30740c;
                bluedMyVisitorList.distanceStr = DistanceUtils.a(bluedMyVisitorList.distance, BlueAppLocal.c(), false);
                this.g.setText(this.f30740c.distanceStr + " ");
            }
            DistanceUtils.a(this.q, this.g, this.f30740c, 1);
        }
        String str3 = !TextUtils.isEmpty(this.f30740c.note) ? this.f30740c.note : !TextUtils.isEmpty(this.f30740c.name) ? this.f30740c.name : "";
        a(this.f30740c.label);
        SpannableString spannableString = new SpannableString(str3);
        if (a(this.f30740c)) {
            spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString.length(), 17);
        }
        this.b.setText(spannableString);
        UserRelationshipUtils.a(this.q, this.b, this.f30740c);
        if (UserInfoHelper.c(this.f30740c.vbadge)) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
            if (TextUtils.isEmpty(this.f30740c.age)) {
                this.h.setText("");
            } else {
                this.h.setText(this.f30740c.age + this.q.getResources().getString(2131886374));
            }
            if (TextUtils.isEmpty(this.f30740c.height)) {
                this.i.setText("");
            } else {
                this.i.setText(this.f30740c.height);
            }
            if (TextUtils.isEmpty(this.f30740c.weight)) {
                this.j.setText("");
            } else {
                this.j.setText(this.f30740c.weight);
            }
        }
        if (this.f30740c.online_state == 1) {
            str = " " + this.q.getResources().getString(R.string.friends_actice);
        } else if (TextUtils.isEmpty(this.f30740c.last_operate)) {
            str = " " + this.q.getResources().getString(R.string.biao_time_just);
        } else {
            if (StringUtils.d(TimeAndDateUtils.f(AppInfo.d(), Long.valueOf(TimeAndDateUtils.c(this.f30740c.last_operate)).longValue()))) {
                str = " " + this.q.getResources().getString(R.string.biao_time_just);
            } else {
                str = " " + TimeAndDateUtils.f(AppInfo.d(), valueOf.longValue());
            }
        }
        SpannableString spannableString2 = new SpannableString(str);
        if (a(this.f30740c)) {
            spannableString2.setSpan(new MaskFilterSpan(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString2.length(), 17);
        }
        this.o.setText(spannableString2);
        if (!a(this.f30740c)) {
            TypefaceUtils.a(this.q, this.o, this.f30740c.is_hide_last_operate, 1);
        }
        if (this.r != 0) {
            if (TextUtils.isEmpty(this.f30740c.visitors_time)) {
                this.n.setVisibility(4);
            } else {
                this.n.setVisibility(0);
                if (BlueAppLocal.d()) {
                    if (this.f30740c.is_shadow == 1) {
                        str2 = TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visitors_time)) + this.q.getResources().getString(R.string.visitor_shadow);
                    } else {
                        str2 = TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visitors_time)) + this.q.getResources().getString(R.string.visitor);
                    }
                } else if (this.f30740c.is_shadow == 1) {
                    str2 = this.q.getResources().getString(R.string.visitor_shadow) + TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visitors_time));
                } else {
                    str2 = this.q.getResources().getString(R.string.visitor) + TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visitors_time));
                }
                SpannableString spannableString3 = new SpannableString(str2);
                if (a(this.f30740c)) {
                    spannableString3.setSpan(new MaskFilterSpan(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString3.length(), 17);
                }
                this.n.setText(spannableString3);
            }
            if (StringUtils.a(this.f30740c.last_visit_time, 0L) < StringUtils.a(this.f30740c.visitors_time, 0L)) {
                this.d.setBackground(new ColorDrawable(BluedSkinUtils.a(this.q, 2131101796)));
            } else {
                this.d.setBackground(BluedSkinUtils.b(this.q, 2131236289));
            }
        } else if (TextUtils.isEmpty(this.f30740c.visited_time)) {
            this.n.setVisibility(4);
        } else {
            this.n.setVisibility(0);
            if (BlueAppLocal.d()) {
                this.n.setText(TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visited_time)) + this.q.getResources().getString(R.string.visited));
            } else {
                this.n.setText(this.q.getResources().getString(R.string.visited) + TimeAndDateUtils.g(this.q, TimeAndDateUtils.c(this.f30740c.visited_time)));
            }
        }
        final LogData logData = new LogData();
        logData.from = "my_visitor";
        logData.logService = "click_position";
        logData.position = i + "";
        logData.uid = this.f30740c.uid;
        logData.is_hello = this.f30740c.is_call == 1 ? "1" : "0";
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.viewholder.VisitorViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackVIP.d(VipProtos.Event.VISIT_PAGE_VAGUE_CLICK, VisitorViewHolder.this.f30740c.uid);
                VisitorViewHolder visitorViewHolder = VisitorViewHolder.this;
                if (visitorViewHolder.a(visitorViewHolder.f30740c)) {
                    PayUtils.a(VisitorViewHolder.this.q, 12, "nearby_visit_vague", VipProtos.FromType.VISIT_VAGUE);
                } else {
                    VisitorViewHolder.this.a(logData);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.viewholder.VisitorViewHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackVIP.d(VipProtos.Event.VISIT_PAGE_VAGUE_CLICK, VisitorViewHolder.this.f30740c.uid);
                VisitorViewHolder visitorViewHolder = VisitorViewHolder.this;
                if (visitorViewHolder.a(visitorViewHolder.f30740c)) {
                    PayUtils.a(VisitorViewHolder.this.q, 12, "nearby_visit_vague", VipProtos.FromType.VISIT_VAGUE);
                } else {
                    VisitorViewHolder.this.a(logData);
                }
            }
        });
        if (!this.f30740c.isShowUrlVisited) {
            LogData logData2 = new LogData();
            logData2.logService = "my_visitor_show";
            logData2.uid = this.f30740c.uid;
            logData2.is_hello = this.f30740c.is_call == 1 ? "1" : "0";
            InstantLog.a(logData2);
            this.f30740c.isShowUrlVisited = true;
        }
        a();
    }

    public void a(LogData logData) {
        MessageProtos.StrangerSource strangerSource;
        String str;
        if (this.r == 1) {
            strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_VISIT;
            str = "my_visitor";
        } else {
            strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_VIEW;
            str = "my_visited";
        }
        BluedMyVisitorList mo9108clone = this.f30740c.mo9108clone();
        mo9108clone.uid = this.f30740c.uid;
        mo9108clone.avatar = this.f30740c.avatar;
        mo9108clone.name = this.f30740c.name;
        mo9108clone.age = this.f30740c.age + "";
        mo9108clone.height = this.f30740c.height + "";
        mo9108clone.weight = this.f30740c.weight + "";
        mo9108clone.role = this.f30740c.role + "";
        mo9108clone.distance = this.f30740c.distance;
        mo9108clone.is_hide_distance = this.f30740c.is_hide_distance;
        mo9108clone.is_hide_last_operate = this.f30740c.is_hide_last_operate;
        mo9108clone.last_operate = this.f30740c.last_operate;
        mo9108clone.vip_grade = this.f30740c.vip_grade;
        mo9108clone.vbadge = this.f30740c.vbadge;
        mo9108clone.is_show_vip_page = this.f30740c.is_show_vip_page;
        mo9108clone.is_shadow = 0;
        UserInfoFragmentNew.a(this.q, mo9108clone, str, this.e, (LogData) null, new MsgSourceEntity(strangerSource, ""));
        InstantLog.a(logData);
    }

    public void a(BluedMyVisitorList bluedMyVisitorList, int i) {
        this.f30740c = bluedMyVisitorList;
        this.f30739a = i;
        a(i);
    }

    public void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.u.removeAllViews();
            return;
        }
        this.u.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            View inflate = LayoutInflater.from(this.q).inflate(R.layout.user_profile_tag, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(2131372684);
            textView.setPadding(20, 4, 20, 4);
            textView.setTextColor(this.q.getResources().getColor(2131102263));
            textView.setText(strArr[i2]);
            this.u.addView(inflate);
            i = i2 + 1;
        }
    }

    public boolean a(BluedMyVisitorList bluedMyVisitorList) {
        return BluedConfig.a().T() == 1 && bluedMyVisitorList.label != null && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0;
    }
}
