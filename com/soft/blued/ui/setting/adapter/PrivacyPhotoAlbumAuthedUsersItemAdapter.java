package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.SlideView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/PrivacyPhotoAlbumAuthedUsersItemAdapter.class */
public class PrivacyPhotoAlbumAuthedUsersItemAdapter extends BaseAdapter implements SlideView.OnSlideListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19611a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<UserFindResult> f19612c;
    private OnDeleteClickListener d;
    private SlideView e;
    private boolean f;
    private IRequestHost g;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/PrivacyPhotoAlbumAuthedUsersItemAdapter$OnDeleteClickListener.class */
    public interface OnDeleteClickListener {
        void a(String str, int i);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/PrivacyPhotoAlbumAuthedUsersItemAdapter$ViewHolder.class */
    class ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f19619c;
        private ImageView d;
        private ImageView e;
        private ImageView f;
        private LinearLayout g;
        private ImageView h;
        private SlideView i;
        private TextView j;
        private TextView k;
        private TextView l;
        private TextView m;
        private TextView n;
        private TextView o;
        private TextView p;
        private TextView q;
        private TextView r;
        private TextView s;

        public ViewHolder(View view) {
            this.g = (LinearLayout) view.findViewById(R.id.layout_friend);
            this.h = (ImageView) view.findViewById(2131364232);
            this.b = (ImageView) view.findViewById(R.id.img_blued_medal);
            this.f19619c = (ImageView) view.findViewById(R.id.img_living);
            this.d = (ImageView) view.findViewById(R.id.img_online);
            this.e = (ImageView) view.findViewById(R.id.img_verify);
            this.f = (ImageView) view.findViewById(R.id.img_recommend);
            this.i = view.findViewById(R.id.sv_slide_item);
            this.j = (TextView) view.findViewById(R.id.age_view);
            this.k = (TextView) view.findViewById(R.id.height_view);
            this.m = (TextView) view.findViewById(R.id.name_view);
            this.l = (TextView) view.findViewById(R.id.distance_view);
            this.n = (TextView) view.findViewById(R.id.online_time_view);
            this.o = (TextView) view.findViewById(R.id.role_view);
            this.p = (TextView) view.findViewById(R.id.sign_view);
            this.q = (TextView) view.findViewById(R.id.weight_view);
            this.r = (TextView) view.findViewById(R.id.tv_item_button);
            this.s = (TextView) view.findViewById(R.id.tv_cover_transparent);
        }
    }

    public PrivacyPhotoAlbumAuthedUsersItemAdapter(Context context, IRequestHost iRequestHost, List<UserFindResult> list) {
        this.f19611a = context;
        this.g = iRequestHost;
        this.f19612c = list;
        this.b = LayoutInflater.from(context);
    }

    public void a() {
        this.f19612c.clear();
        notifyDataSetChanged();
    }

    public void a(int i) {
        this.f19612c.remove(i);
        notifyDataSetChanged();
    }

    public void a(View view, int i) {
        SlideView slideView = this.e;
        if (slideView != null && slideView != view) {
            slideView.a();
        }
        if (i == 1) {
            ((SlideView) view).a();
        }
        if (i == 2) {
            this.e = (SlideView) view;
        }
    }

    public void a(OnDeleteClickListener onDeleteClickListener) {
        this.d = onDeleteClickListener;
    }

    public void a(List<UserFindResult> list) {
        this.f19612c.addAll(list);
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.f = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<UserFindResult> list = this.f19612c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<UserFindResult> list = this.f19612c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        final UserFindResult userFindResult = (UserFindResult) getItem(i);
        if (view == null) {
            view = this.b.inflate(R.layout.item_authed_user, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.f) {
            viewHolder.s.setVisibility(0);
        } else {
            viewHolder.s.setVisibility(8);
        }
        viewHolder.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
            }
        });
        if (userFindResult.is_recommend == 1) {
            viewHolder.f.setVisibility(0);
            viewHolder.e.setVisibility(4);
        } else {
            viewHolder.f.setVisibility(4);
            viewHolder.e.setVisibility(0);
            UserInfoHelper.a(viewHolder.e, userFindResult.vbadge, 3);
        }
        DisplayMetrics displayMetrics = this.f19611a.getResources().getDisplayMetrics();
        viewHolder.g.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels + 1, DensityUtils.a(this.f19611a, 87.5f)));
        final ViewHolder viewHolder2 = viewHolder;
        viewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                UserInfoFragmentNew.a(PrivacyPhotoAlbumAuthedUsersItemAdapter.this.f19611a, userFindResult, "", viewHolder2.h);
            }
        });
        viewHolder.i.setOnSlideListener(this);
        final ViewHolder viewHolder3 = viewHolder;
        viewHolder.r.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (PrivacyPhotoAlbumAuthedUsersItemAdapter.this.d != null) {
                    PrivacyPhotoAlbumAuthedUsersItemAdapter.this.d.a(userFindResult.uid, i);
                    viewHolder3.i.a();
                }
            }
        });
        String a2 = TimeAndDateUtils.a(this.f19611a, TimeAndDateUtils.c(userFindResult.last_operate));
        String a3 = DistanceUtils.a(userFindResult.distance, BlueAppLocal.c(), false);
        if (userFindResult.live > 0) {
            viewHolder.f19619c.setVisibility(0);
        } else {
            viewHolder.f19619c.setVisibility(8);
        }
        ImageLoader.a(this.g, AvatarUtils.a(0, userFindResult.avatar)).b(2131237310).c().a(viewHolder.h);
        UserInfoHelper.a(this.f19611a, viewHolder.o, userFindResult.role);
        UserRelationshipUtils.a(viewHolder.b, userFindResult);
        if (TextUtils.isEmpty(a3)) {
            viewHolder.l.setText("");
        } else {
            viewHolder.l.setText(a3);
        }
        DistanceUtils.a(this.f19611a, viewHolder.l, userFindResult, 1);
        if (!TextUtils.isEmpty(userFindResult.note)) {
            viewHolder.m.setText(userFindResult.note);
        } else if (TextUtils.isEmpty(userFindResult.name)) {
            viewHolder.m.setText("");
        } else {
            viewHolder.m.setText(userFindResult.name);
        }
        UserRelationshipUtils.a(this.f19611a, viewHolder.m, userFindResult);
        if (1 == userFindResult.online_state) {
            viewHolder.d.setVisibility(0);
        } else {
            viewHolder.d.setVisibility(8);
        }
        if (TextUtils.isEmpty(a2)) {
            viewHolder.n.setText("");
        } else {
            viewHolder.n.setText(a2);
        }
        TypefaceUtils.a(this.f19611a, viewHolder.n, userFindResult.is_hide_last_operate, 1);
        if (TextUtils.isEmpty(userFindResult.age)) {
            viewHolder.j.setText("");
        } else {
            TextView textView = viewHolder.j;
            textView.setText(userFindResult.age + this.f19611a.getResources().getString(2131886374));
        }
        if (TextUtils.isEmpty(userFindResult.height)) {
            viewHolder.k.setText("");
        } else {
            viewHolder.k.setText(userFindResult.height);
        }
        if (TextUtils.isEmpty(userFindResult.weight)) {
            viewHolder.q.setText("");
        } else {
            viewHolder.q.setText(userFindResult.weight);
        }
        if (TextUtils.isEmpty(userFindResult.description)) {
            viewHolder.p.setText(this.f19611a.getResources().getString(R.string.user_no_description));
            return view;
        }
        viewHolder.p.setText(userFindResult.description);
        return view;
    }
}
