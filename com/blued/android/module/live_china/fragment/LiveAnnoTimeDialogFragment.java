package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.common.view.scrollpicker.StringScrollPicker;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemAnnounceWeekly;
import com.bytedance.applog.tracker.Tracker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Grego;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoTimeDialogFragment.class */
public class LiveAnnoTimeDialogFragment extends BaseDialogFragment implements View.OnClickListener, OnClickCallback {
    List<CharSequence> a;
    List<CharSequence> b;
    List<CharSequence> c;
    IEventCallback d;
    private View e;
    private StringScrollPicker f;
    private StringScrollPicker g;
    private StringScrollPicker h;
    private RecyclerView i;
    private FreedomAdapter j;
    private List<FitemAnnounceWeekly> k;
    private Context l;
    private boolean m = false;
    private String n;
    private long o;
    private long p;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoTimeDialogFragment$IEventCallback.class */
    public interface IEventCallback {
        void save(String str, long j);
    }

    public static String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = calendar.get(7) - 1;
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        return new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"}[i2];
    }

    private void a(boolean z) {
        boolean k = k();
        if (!k || this.f.e()) {
            if (k || !this.f.e()) {
                return;
            }
            this.f.setDisallowTouch(false);
            this.f.animate().alpha(1.0f).setDuration(200L);
            return;
        }
        this.f.setDisallowTouch(true);
        this.f.animate().alpha(0.2f).setDuration(200L);
        if (z) {
            ToastUtils.a(R.string.live_announce_toast_select_weekly);
        }
    }

    private void b(long j) {
        int i;
        String[] split = d(j).split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= this.b.size()) {
                break;
            } else if (Integer.parseInt(this.b.get(i3).toString()) == parseInt) {
                this.g.setSelectedPosition(i3);
                i = 0;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        while (i < this.c.size()) {
            if (Integer.parseInt(this.c.get(i).toString()) >= parseInt2) {
                this.h.setSelectedPosition(i);
                return;
            }
            i++;
        }
    }

    private String c(long j) {
        String format;
        String format2;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            format = new SimpleDateFormat("M月d日", BlueAppLocal.c()).format(calendar.getTime());
            format2 = new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()).format(calendar.getTime());
        } else {
            format = new SimpleDateFormat("M月d日", Locale.ENGLISH).format(calendar.getTime());
            format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime());
        }
        return format + a(format2);
    }

    private String d(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        return BlueAppLocal.d() ? new SimpleDateFormat("H-m", BlueAppLocal.c()).format(calendar.getTime()) : new SimpleDateFormat("H-m", Locale.ENGLISH).format(calendar.getTime());
    }

    private void e() {
        if (getArguments() != null) {
            this.n = getArguments().getString("live_week_time");
            this.o = getArguments().getLong("live_time");
        }
    }

    private void f() {
        this.f = (StringScrollPicker) this.e.findViewById(R.id.sp_day);
        this.g = (StringScrollPicker) this.e.findViewById(R.id.sp_hour);
        this.h = (StringScrollPicker) this.e.findViewById(R.id.sp_min);
        this.i = this.e.findViewById(R.id.rv_weekly);
        this.e.findViewById(R.id.tv_cancel).setOnClickListener(this);
        this.e.findViewById(R.id.tv_save).setOnClickListener(this);
        this.p = System.currentTimeMillis();
        g();
        j();
    }

    private void g() {
        String valueOf;
        this.a = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 7) {
                break;
            }
            this.a.add(c(this.p + (Grego.MILLIS_PER_DAY * i2)));
            i = i2 + 1;
        }
        this.f.setData(this.a);
        this.f.setSelectedPosition(0);
        this.b = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 24) {
                break;
            }
            List<CharSequence> list = this.b;
            if (i4 < 10) {
                valueOf = "0" + i4;
            } else {
                valueOf = String.valueOf(i4);
            }
            list.add(valueOf);
            i3 = i4 + 1;
        }
        this.g.setData(this.b);
        this.c = new ArrayList();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 6) {
                break;
            }
            this.c.add(i6 + "0");
            i5 = i6 + 1;
        }
        this.h.setData(this.c);
        if (this.o > 86400000) {
            h();
        } else if (TextUtils.isEmpty(this.n) || this.n.length() < 7 || this.n.equals("0000000")) {
            i();
        } else {
            b(a(this.p) + this.o);
        }
    }

    private void h() {
        String c = c(this.o);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                break;
            } else if (this.a.get(i2).equals(c)) {
                this.f.setSelectedPosition(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        b(this.o);
    }

    private void i() {
        boolean z;
        String[] split = d(this.p + 600000).split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                z = false;
                break;
            } else if (Integer.parseInt(this.c.get(i2).toString()) >= parseInt2) {
                this.h.setSelectedPosition(i2);
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        int i3 = 0;
        int i4 = parseInt;
        if (!z) {
            this.h.setSelectedPosition(0);
            int i5 = parseInt + 1;
            i3 = 0;
            i4 = i5;
            if (i5 == 24) {
                this.f.setSelectedPosition(1);
                i4 = 0;
                i3 = 0;
            }
        }
        while (i3 < this.b.size()) {
            if (Integer.parseInt(this.b.get(i3).toString()) == i4) {
                this.g.setSelectedPosition(i3);
                return;
            }
            i3++;
        }
    }

    private void j() {
        if (TextUtils.isEmpty(this.n) || this.n.length() < 7) {
            this.n = "0000000";
        }
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        arrayList.add(new FitemAnnounceWeekly("每周一", this.n.charAt(6) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周二", this.n.charAt(5) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周三", this.n.charAt(4) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周四", this.n.charAt(3) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周五", this.n.charAt(2) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周六", this.n.charAt(1) == '1'));
        this.k.add(new FitemAnnounceWeekly("每周日", this.n.charAt(0) == '1'));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.l, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveAnnoTimeDialogFragment.2
            public int getSpanSize(int i) {
                return ((FreedomItem) LiveAnnoTimeDialogFragment.this.k.get(i)).a(gridLayoutManager.getSpanCount());
            }
        });
        this.i.setLayoutManager(gridLayoutManager);
        FreedomAdapter freedomAdapter = new FreedomAdapter(this.l, a(), this.k, this);
        this.j = freedomAdapter;
        this.i.setAdapter(freedomAdapter);
        this.i.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveAnnoTimeDialogFragment$IP2muGhQAJsskDfX-AKd4bf2Kq8
            @Override // java.lang.Runnable
            public final void run() {
                LiveAnnoTimeDialogFragment.this.m();
            }
        });
    }

    private boolean k() {
        for (FitemAnnounceWeekly fitemAnnounceWeekly : this.k) {
            if (fitemAnnounceWeekly.e()) {
                return true;
            }
        }
        return false;
    }

    private boolean l() {
        if (this.d == null) {
            return true;
        }
        if (k()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (FitemAnnounceWeekly fitemAnnounceWeekly : this.k) {
                stringBuffer.insert(0, fitemAnnounceWeekly.e() ? "1" : "0");
            }
            this.n = stringBuffer.toString();
            this.o = (Integer.parseInt((String) this.h.getSelectedItem()) * 60000) + (Integer.parseInt((String) this.g.getSelectedItem()) * Grego.MILLIS_PER_HOUR);
        } else {
            int parseInt = Integer.parseInt((String) this.g.getSelectedItem());
            long parseInt2 = (Integer.parseInt((String) this.h.getSelectedItem()) * 60000) + (parseInt * Grego.MILLIS_PER_HOUR) + (this.f.getSelectedPosition() * Grego.MILLIS_PER_DAY) + a(this.p);
            if (parseInt2 < System.currentTimeMillis() + 600000) {
                ToastUtils.a(R.string.live_announce_toast_select_time_error);
                return false;
            }
            this.o = parseInt2;
            this.n = "0000000";
        }
        this.d.save(this.n, this.o);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        a(false);
    }

    public long a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public void a(IEventCallback iEventCallback) {
        this.d = iEventCallback;
    }

    public boolean d() {
        return this.m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_cancel) {
            dismissAllowingStateLoss();
        } else if (view.getId() == R.id.tv_save && l()) {
            dismissAllowingStateLoss();
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        FitemAnnounceWeekly fitemAnnounceWeekly = this.k.get(i);
        fitemAnnounceWeekly.a(!fitemAnnounceWeekly.e());
        a(true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.l = getContext();
        this.m = true;
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_announce_time, (ViewGroup) null);
        int a = DensityUtils.a(this.l, 364.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.dialog_live_announce_time, viewGroup, false);
            f();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveAnnoTimeDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                LiveAnnoTimeDialogFragment.this.m = false;
            }
        }, 300L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
