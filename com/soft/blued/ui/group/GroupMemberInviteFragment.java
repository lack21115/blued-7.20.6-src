package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.model.MsgExtra;
import com.blued.android.module.common.utils.ClickUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.ExtraGroupInvitationModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupMemberInviteFragment.class */
public class GroupMemberInviteFragment extends BaseFragment implements View.OnClickListener {
    public static List<String> g;
    private ChatHelperV4 A;
    private String B;
    private View l;
    private Context m;
    private TabPageIndicatorWithDot n;
    private ViewPager o;
    private MyPagerAdapter p;
    private Dialog q;
    private String w;
    private String x;
    private String y;
    private boolean z;

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f17120a = new ArrayList();
    public static List<String> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f17121c = new ArrayList();
    public static List<Integer> d = new ArrayList();
    public static List<Short> e = new ArrayList();
    public static List<String> f = new ArrayList();
    public static String h = "isinvite";
    private String k = GroupMemberInviteFragment.class.getSimpleName();
    private List<String> r = new ArrayList();
    private List<String> s = new ArrayList();
    private List<String> t = new ArrayList();
    private List<Integer> u = new ArrayList();
    private List<Short> v = new ArrayList();
    private ViewPager.OnPageChangeListener C = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.group.GroupMemberInviteFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (i == 0) {
                if (GroupMemberInviteFragment.this.p.d == null || GroupMemberInviteFragment.this.p.d.f17111a == null) {
                    return;
                }
                GroupMemberInviteFragment.this.p.d.f17111a.notifyDataSetChanged();
            } else if (i == 1) {
                if (GroupMemberInviteFragment.this.p.f17126a != null) {
                    GroupMemberInviteFragment.this.p.f17126a.f17176a.notifyDataSetChanged();
                }
            } else if (i == 2) {
                if (GroupMemberInviteFragment.this.p.b != null) {
                    GroupMemberInviteFragment.this.p.b.f17176a.notifyDataSetChanged();
                }
            } else if (GroupMemberInviteFragment.this.p.f17127c != null) {
                GroupMemberInviteFragment.this.p.f17127c.f17176a.notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 0) {
                if (GroupMemberInviteFragment.this.p.d == null || GroupMemberInviteFragment.this.p.d.f17111a == null) {
                    return;
                }
                GroupMemberInviteFragment.this.p.d.f17111a.notifyDataSetChanged();
            } else if (i == 1) {
                if (GroupMemberInviteFragment.this.p.f17126a != null) {
                    GroupMemberInviteFragment.this.p.f17126a.f17176a.notifyDataSetChanged();
                }
            } else if (i == 2) {
                if (GroupMemberInviteFragment.this.p.b != null) {
                    GroupMemberInviteFragment.this.p.b.f17176a.notifyDataSetChanged();
                }
            } else if (GroupMemberInviteFragment.this.p.f17127c != null) {
                GroupMemberInviteFragment.this.p.f17127c.f17176a.notifyDataSetChanged();
            }
        }
    };
    public BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntityA<String>>() { // from class: com.soft.blued.ui.group.GroupMemberInviteFragment.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<String> parseData(String str) {
            Logger.a(GroupMemberInviteFragment.this.k, "onSuccess, content:", str);
            return super.parseData(str);
        }

        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.hasData()) {
                        GroupMemberInviteFragment.g.clear();
                        GroupMemberInviteFragment.g.addAll(new ArrayList(bluedEntityA.data));
                        GroupMemberInviteFragment.this.e();
                    }
                } catch (Exception e2) {
                    AppMethods.a(GroupMemberInviteFragment.this.getResources().getString(2131887272));
                    e2.printStackTrace();
                }
            }
        }

        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            Logger.a(GroupMemberInviteFragment.this.k, "onFailure, error:", th);
        }

        public void onUIFinish() {
            Logger.a(GroupMemberInviteFragment.this.k, "onUIFinish");
            DialogUtils.b(GroupMemberInviteFragment.this.q);
        }

        public void onUIStart() {
            DialogUtils.a(GroupMemberInviteFragment.this.q);
        }
    };
    public BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntity<Object, ExtraGroupInvitationModel>>() { // from class: com.soft.blued.ui.group.GroupMemberInviteFragment.3
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            AppMethods.a(GroupMemberInviteFragment.this.getResources().getString(2131887272));
        }

        public void onUIFinish() {
            Logger.a(GroupMemberInviteFragment.this.k, "onUIFinish");
            DialogUtils.b(GroupMemberInviteFragment.this.q);
            GroupMemberInviteFragment.this.getActivity().finish();
        }

        public void onUIStart() {
            DialogUtils.a(GroupMemberInviteFragment.this.q);
        }

        public void onUIUpdate(BluedEntity<Object, ExtraGroupInvitationModel> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.extra != null && ((ExtraGroupInvitationModel) bluedEntity.extra).iid != null && ((ExtraGroupInvitationModel) bluedEntity.extra).iid.size() > 0) {
                        int size = ((ExtraGroupInvitationModel) bluedEntity.extra).iid.size();
                        Gson f2 = AppInfo.f();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                GroupMemberInviteFragment.this.t.clear();
                                GroupMemberInviteFragment.this.v.clear();
                                GroupMemberInviteFragment.this.r.clear();
                                GroupMemberInviteFragment.this.s.clear();
                                GroupMemberInviteFragment.this.u.clear();
                                AppMethods.d((int) R.string.btn_invitation_send);
                                return;
                            }
                            MsgExtra msgExtra = (MsgExtra) f2.fromJson(GroupMemberInviteFragment.this.x, new TypeToken<MsgExtra>() { // from class: com.soft.blued.ui.group.GroupMemberInviteFragment.3.1
                            }.getType());
                            String str = ((ExtraGroupInvitationModel) bluedEntity.extra).iid.get(i2).iid;
                            if (TextUtils.isEmpty(str)) {
                                AppMethods.a(GroupMemberInviteFragment.this.getResources().getString(2131887272));
                            } else {
                                msgExtra.setGroups_iid(str);
                                GroupMemberInviteFragment.this.a(Long.parseLong((String) GroupMemberInviteFragment.this.r.get(i2)), ((Short) GroupMemberInviteFragment.this.v.get(i2)).shortValue(), (String) GroupMemberInviteFragment.this.s.get(i2), (String) GroupMemberInviteFragment.this.t.get(i2), ((Integer) GroupMemberInviteFragment.this.u.get(i2)).intValue(), f2.toJson(msgExtra), StringUtils.a(GroupMemberInviteFragment.this.y, -1));
                            }
                            i = i2 + 1;
                        }
                    }
                } catch (Exception e2) {
                    AppMethods.a(GroupMemberInviteFragment.this.getResources().getString(2131887272));
                    e2.printStackTrace();
                    return;
                }
            }
            AppMethods.a(GroupMemberInviteFragment.this.getResources().getString(2131887272));
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupMemberInviteFragment$MyPagerAdapter.class */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public GroupUserInviteFragment f17126a;
        public GroupUserInviteFragment b;

        /* renamed from: c  reason: collision with root package name */
        public GroupUserInviteFragment f17127c;
        public GroupInviteFromChatListFragment d;
        private final String[] f;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f = new String[]{GroupMemberInviteFragment.this.getResources().getString(R.string.group_chat), GroupMemberInviteFragment.this.getResources().getString(R.string.group_mynearbys), GroupMemberInviteFragment.this.getResources().getString(R.string.group_myvisits), GroupMemberInviteFragment.this.getResources().getString(R.string.group_myconcerns)};
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                if (this.d == null) {
                    GroupInviteFromChatListFragment groupInviteFromChatListFragment = new GroupInviteFromChatListFragment();
                    this.d = groupInviteFromChatListFragment;
                    groupInviteFromChatListFragment.a(GroupMemberInviteFragment.this.w);
                }
                return this.d;
            } else if (i == 1) {
                if (this.f17126a == null) {
                    this.f17126a = GroupUserInviteFragment.a(0);
                }
                return this.f17126a;
            } else if (i == 2) {
                if (this.b == null) {
                    this.b = GroupUserInviteFragment.a(1);
                }
                return this.b;
            } else if (i != 3) {
                return null;
            } else {
                if (this.f17127c == null) {
                    this.f17127c = GroupUserInviteFragment.a(2);
                }
                return this.f17127c;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f[i];
        }
    }

    private void a() {
        if (StringUtils.d(this.w)) {
            return;
        }
        GroupHttpUtils.c(this.m, this.i, this.w, "", "", "desc", this.B, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, short s, String str, String str2, int i, String str3, int i2) {
        if (StringUtils.d(str3) || i2 == -1) {
            return;
        }
        ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(j, i2 == 0 ? (short) 10 : (short) 9, getResources().getString(R.string.biao_im_msg_share_toone), this.A.b(), str3, s);
        if (chattingModelForSendmsg == null) {
            return;
        }
        this.A.c(chattingModelForSendmsg, str, str2, i, 0, 0, 0, 0, false);
    }

    public static void a(Context context, BluedCreatedGroupInfo bluedCreatedGroupInfo) {
        String str;
        if (bluedCreatedGroupInfo != null) {
            String str2 = bluedCreatedGroupInfo.groups_gid;
            String str3 = bluedCreatedGroupInfo.groups_is_created;
            String str4 = bluedCreatedGroupInfo.groups_is_admins;
            Bundle bundle = new Bundle();
            bundle.putString("gid", str2);
            if (str3.equals("1") || str4.equals("1")) {
                bundle.putBoolean(h, true);
            } else {
                bundle.putBoolean(h, false);
            }
            MsgExtra msgExtra = new MsgExtra();
            msgExtra.setGroups_avatar(bluedCreatedGroupInfo.groups_avatar);
            msgExtra.setGroups_city(bluedCreatedGroupInfo.groups_city);
            msgExtra.setGroups_members_count(bluedCreatedGroupInfo.groups_members_count);
            msgExtra.setGroups_name(bluedCreatedGroupInfo.groups_name);
            msgExtra.setGroups_gid(bluedCreatedGroupInfo.groups_gid);
            msgExtra.setGroups_description(bluedCreatedGroupInfo.groups_description);
            if (StringUtils.d(str3) || StringUtils.d(str4)) {
                str = "";
            } else {
                str = "1";
                if (!str3.equals("1")) {
                    str = str4.equals("1") ? "1" : "0";
                }
            }
            bundle.putString("group_extra_json", AppInfo.f().toJson(msgExtra));
            bundle.putString("flag", str);
            TerminalActivity.d(context, GroupMemberInviteFragment.class, bundle);
        }
    }

    public static void a(Context context, String str) {
        a(context, (BluedCreatedGroupInfo) AppInfo.f().fromJson(str, (Class<Object>) BluedCreatedGroupInfo.class));
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.w = arguments.getString("gid");
        this.z = arguments.getBoolean(h);
        this.x = arguments.getString("group_extra_json");
        this.y = arguments.getString("flag");
        this.B = "uid";
        f17120a.clear();
        b.clear();
        f17121c.clear();
        d.clear();
        e.clear();
        f.clear();
    }

    private void c() {
        CommonTopTitleNoTrans findViewById = this.l.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.group_member_invitation));
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
        findViewById.setRightText(this.m.getString(R.string.done));
        ((TextView) findViewById.findViewById(2131363108)).setOnTouchListener(new ClickUtils());
    }

    private void d() {
        this.q = DialogUtils.a(this.m);
        g = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.l.findViewById(R.id.indicator);
        this.n = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setOnPageChangeListener(this.C);
        this.o = (ViewPager) this.l.findViewById(R.id.p_viewpager);
        this.p = new MyPagerAdapter(getChildFragmentManager());
        this.o.setOffscreenPageLimit(4);
        this.o.setAdapter(this.p);
        this.n.setViewPager(this.o);
        this.l.findViewById(2131363249).setVisibility(0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.p.d != null) {
            this.p.d.onActivityResult(i, i2, intent);
        }
        if (this.p.f17126a != null) {
            this.p.f17126a.onActivityResult(i, i2, intent);
        }
        if (this.p.b != null) {
            this.p.b.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id == 2131363126) {
            if (f17120a.size() == 0) {
                AppMethods.a(getResources().getString(R.string.nomember_invite_show));
                return;
            }
            if (!this.z) {
                for (int i = 0; i < f17120a.size(); i++) {
                    a(Long.valueOf(f17120a.get(i)).longValue(), e.get(i).shortValue(), b.get(i), f17121c.get(i), d.get(i).intValue(), this.x, StringUtils.a(this.y, -1));
                }
                AppMethods.d((int) R.string.btn_invitation_send);
                getActivity().finish();
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= f17120a.size()) {
                    break;
                }
                if (3 == e.get(i3).shortValue()) {
                    a(Long.parseLong(f17120a.get(i3)), e.get(i3).shortValue(), b.get(i3), f17121c.get(i3), d.get(i3).intValue(), this.x, 0);
                } else {
                    this.t.add(f17121c.get(i3));
                    this.v.add(e.get(i3));
                    this.r.add(f17120a.get(i3));
                    this.s.add(b.get(i3));
                    this.u.add(d.get(i3));
                }
                i2 = i3 + 1;
            }
            if (this.r.size() <= 0) {
                getActivity().finish();
                return;
            }
            GroupHttpUtils.a(this.j, this.w, (String[]) this.r.toArray(new String[this.r.size()]), true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.m = getActivity();
        View view = this.l;
        if (view == null) {
            this.l = layoutInflater.inflate(R.layout.fragment_group_member_invite, viewGroup, false);
            c();
            d();
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        this.A = ChatHelperV4.a();
        return this.l;
    }
}
