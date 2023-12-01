package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/ListFragment.class */
public class ListFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    ListAdapter f3047a;
    ListView b;

    /* renamed from: c  reason: collision with root package name */
    View f3048c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;
    private final Handler i = new Handler();
    private final Runnable j = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListFragment.this.b.focusableViewAvailable(ListFragment.this.b);
        }
    };
    private final AdapterView.OnItemClickListener k = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    private void a() {
        if (this.b != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.b = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.d = textView;
            if (textView == null) {
                this.f3048c = view.findViewById(16908292);
            } else {
                textView.setVisibility(8);
            }
            this.e = view.findViewById(16711682);
            this.f = view.findViewById(16711683);
            View findViewById = view.findViewById(16908298);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) findViewById;
            this.b = listView;
            View view2 = this.f3048c;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.g;
                if (charSequence != null) {
                    this.d.setText(charSequence);
                    this.b.setEmptyView(this.d);
                }
            }
        }
        this.h = true;
        this.b.setOnItemClickListener(this.k);
        ListAdapter listAdapter = this.f3047a;
        if (listAdapter != null) {
            this.f3047a = null;
            setListAdapter(listAdapter);
        } else if (this.e != null) {
            a(false, false);
        }
        this.i.post(this.j);
    }

    private void a(boolean z, boolean z2) {
        a();
        View view = this.e;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            } else {
                view.clearAnimation();
                this.f.clearAnimation();
            }
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        } else {
            view.clearAnimation();
            this.f.clearAnimation();
        }
        this.e.setVisibility(0);
        this.f.setVisibility(8);
    }

    public ListAdapter getListAdapter() {
        return this.f3047a;
    }

    public ListView getListView() {
        a();
        return this.b;
    }

    public long getSelectedItemId() {
        a();
        return this.b.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        a();
        return this.b.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.i.removeCallbacks(this.j);
        this.b = null;
        this.h = false;
        this.f = null;
        this.e = null;
        this.f3048c = null;
        this.d = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a();
    }

    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(CharSequence charSequence) {
        a();
        TextView textView = this.d;
        if (textView == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        textView.setText(charSequence);
        if (this.g == null) {
            this.b.setEmptyView(this.d);
        }
        this.g = charSequence;
    }

    public void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f3047a != null;
        this.f3047a = listAdapter;
        ListView listView = this.b;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.h || z2) {
                return;
            }
            if (requireView().getWindowToken() != null) {
                z = true;
            }
            a(true, z);
        }
    }

    public void setListShown(boolean z) {
        a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        a(z, false);
    }

    public void setSelection(int i) {
        a();
        this.b.setSelection(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}
