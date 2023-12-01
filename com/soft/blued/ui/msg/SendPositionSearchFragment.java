package com.soft.blued.ui.msg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.core.PoiItem;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnPOIListener;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.SendPositionSearchFragment;
import com.soft.blued.utils.StringUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionSearchFragment.class */
public class SendPositionSearchFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f31902a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private RenrenPullToRefreshListView f31903c;
    private ListView d;
    private List<PoiItem> e;
    private POISearchAdapter f;
    private int g;
    private boolean h = true;
    private TextView i;
    private EditText j;
    private ImageView k;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionSearchFragment$POISearchAdapter.class */
    public class POISearchAdapter extends BaseAdapter {
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f31907c;
        private List<PositionPOIModel> d = new ArrayList();

        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionSearchFragment$POISearchAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f31908a;
            public TextView b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f31909c;
            public ImageView d;

            private ViewHolder() {
            }
        }

        public POISearchAdapter(Context context) {
            this.b = context;
            this.f31907c = LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(PositionPOIModel positionPOIModel, View view) {
            double d;
            Tracker.onClick(view);
            Intent intent = new Intent();
            intent.putExtra("address", positionPOIModel.address);
            double d2 = 0.0d;
            try {
                double parseDouble = Double.parseDouble(positionPOIModel.longitude);
                d = Double.parseDouble(positionPOIModel.latitude);
                d2 = parseDouble;
            } catch (Exception e) {
                d = 0.0d;
            }
            intent.putExtra("lot", d2);
            intent.putExtra("lat", d);
            SendPositionSearchFragment.this.getActivity().setResult(-1, intent);
            SendPositionSearchFragment.this.getActivity().finish();
        }

        public void a(List<PositionPOIModel> list) {
            this.d.clear();
            if (list != null && list.size() > 0) {
                this.d.addAll(list);
            }
            notifyDataSetChanged();
        }

        public void b(List<PositionPOIModel> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            this.d.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.f31907c.inflate(R.layout.item_send_postion_poi, viewGroup, false);
                viewHolder.f31908a = (LinearLayout) view2.findViewById(R.id.ll_item);
                viewHolder.b = (TextView) view2.findViewById(R.id.tv_poi_shortname);
                viewHolder.f31909c = (TextView) view2.findViewById(R.id.tv_poi_address);
                viewHolder.d = (ImageView) view2.findViewById(R.id.img_choosen_mark);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            final PositionPOIModel positionPOIModel = this.d.get(i);
            viewHolder.b.setText(positionPOIModel.name);
            viewHolder.f31909c.setText(positionPOIModel.address);
            viewHolder.d.setVisibility(8);
            viewHolder.f31908a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionSearchFragment$POISearchAdapter$Sz9hHsx1HMgeHzdlnTfMrcQ4W1g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SendPositionSearchFragment.POISearchAdapter.this.a(positionPOIModel, view3);
                }
            });
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, List list, boolean z) {
        if (i == 0) {
            if (this.g == 0) {
                this.f.a(list);
            } else if (list != null && list.size() > 0) {
                this.f.b(list);
            }
            if (z) {
                this.f31903c.o();
            } else {
                this.f31903c.p();
            }
        }
        this.f31903c.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.g = 0;
        }
        if (this.g == 0) {
            this.h = true;
        }
        if (this.h || (i = this.g) == 0) {
            a(this.g);
            return;
        }
        this.g = i - 1;
        AppMethods.a((CharSequence) this.f31902a.getResources().getString(2131887275));
        this.f31903c.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, int i, KeyEvent keyEvent) {
        if (i == 66 && !TextUtils.isEmpty(this.j.getText().toString()) && keyEvent.getAction() == 0) {
            KeyboardUtils.a(getActivity());
            this.g = 0;
            a(0);
            return false;
        }
        return false;
    }

    static /* synthetic */ int c(SendPositionSearchFragment sendPositionSearchFragment) {
        int i = sendPositionSearchFragment.g;
        sendPositionSearchFragment.g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.j, 0);
    }

    public void a() {
        TextView textView = (TextView) this.b.findViewById(2131363126);
        this.i = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_clear_edit);
        this.k = imageView;
        imageView.setOnClickListener(this);
        EditText editText = (EditText) this.b.findViewById(2131363108);
        this.j = editText;
        editText.setImeOptions(3);
        this.j.setOnClickListener(this);
        this.j.setCursorVisible(true);
        this.j.requestFocus();
        this.j.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.msg.SendPositionSearchFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    SendPositionSearchFragment.this.i.setText(R.string.biao_b_search);
                    SendPositionSearchFragment.this.k.setVisibility(0);
                    return;
                }
                SendPositionSearchFragment.this.i.setText(2131886885);
                SendPositionSearchFragment.this.k.setVisibility(8);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.j.setOnKeyListener(new View.OnKeyListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionSearchFragment$Iyj0C9fV2GXwoJwUzF6XneJW0Ww
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = SendPositionSearchFragment.this.a(view, i, keyEvent);
                return a2;
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionSearchFragment$2ZLvztLdpFh_qpf7UoqZ-UE0JZ4
            @Override // java.lang.Runnable
            public final void run() {
                SendPositionSearchFragment.this.c();
            }
        }, 300L);
    }

    public void a(int i) {
        GaoDeUtils.b(getViewLifecycleOwner(), i, this.j.getText().toString(), new OnPOIListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionSearchFragment$j0l6QaGKP2NQvWM6TRfoDcHhAag
            @Override // com.blued.android.module.common.utils.gaode.OnPOIListener
            public final void onComplete(int i2, List list, boolean z) {
                SendPositionSearchFragment.this.a(i2, list, z);
            }
        });
    }

    public void b() {
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.clear();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.b.findViewById(2131366898);
        this.f31903c = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        ListView listView = (ListView) this.f31903c.getRefreshableView();
        this.d = listView;
        listView.setClipToPadding(false);
        this.d.setScrollBarStyle(33554432);
        this.d.setHeaderDividersEnabled(false);
        this.d.setDividerHeight(1);
        this.d.setDivider(getResources().getDrawable(2131234662));
        POISearchAdapter pOISearchAdapter = new POISearchAdapter(getActivity());
        this.f = pOISearchAdapter;
        this.d.setAdapter((ListAdapter) pOISearchAdapter);
        this.f31903c.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.msg.SendPositionSearchFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                SendPositionSearchFragment.this.g = 0;
                SendPositionSearchFragment.this.a(false);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                SendPositionSearchFragment.c(SendPositionSearchFragment.this);
                PrintStream printStream = System.out;
                printStream.println("position load more:" + SendPositionSearchFragment.this.g);
                SendPositionSearchFragment.this.a(false);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363108) {
            this.j.setHint("");
            this.j.setCursorVisible(true);
            this.j.setGravity(48);
        } else if (id != 2131363126) {
            if (id != 2131364487) {
                return;
            }
            this.j.setText("");
        } else if (StringUtils.d(this.j.getText().toString())) {
            getActivity().finish();
        } else {
            KeyboardUtils.a(getActivity());
            this.g = 0;
            a(0);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f31902a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_send_position_search, viewGroup, false);
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
