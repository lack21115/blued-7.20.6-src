package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogDatePickerLayoutBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDatePickerDialog.class */
public final class YYDatePickerDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogDatePickerLayoutBinding f17197a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CharSequence> f17198c;
    private ArrayList<CharSequence> d;
    private ArrayList<CharSequence> e;
    private ArrayList<CharSequence> f;
    private long g;
    private long h;
    private long i = 86400000;
    private long j = 3600000;
    private long k = 60000;
    private long l = 1000;
    private IEventCallback m;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDatePickerDialog$IEventCallback.class */
    public interface IEventCallback {
        void a(long j, String str);
    }

    private final String a(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            String format = new SimpleDateFormat("yyyy/MM/dd", BlueAppLocal.c()).format(calendar.getTime());
            Intrinsics.c(format, "dateFormat.format(calendar.time)");
            return format;
        }
        String format2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(calendar.getTime());
        Intrinsics.c(format2, "dateFormat.format(calendar.time)");
        return format2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDatePickerDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void b(long j) {
        List b;
        List<String> b2 = new Regex("-").b(c(j), 0);
        if (!b2.isEmpty()) {
            ListIterator<String> listIterator = b2.listIterator(b2.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    b = CollectionsKt.b((Iterable) b2, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        b = CollectionsKt.b();
        Object[] array = b.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        int parseInt = Integer.parseInt(strArr[0]);
        int parseInt2 = Integer.parseInt(strArr[1]);
        int parseInt3 = Integer.parseInt(strArr[2]);
        ArrayList<CharSequence> arrayList = this.d;
        IntRange a2 = arrayList == null ? null : CollectionsKt.a((Collection<?>) arrayList);
        Intrinsics.a(a2);
        int a3 = a2.a();
        int b3 = a2.b();
        if (a3 <= b3) {
            while (true) {
                ArrayList<CharSequence> arrayList2 = this.d;
                if (Integer.parseInt(String.valueOf(arrayList2 == null ? null : arrayList2.get(a3))) == parseInt) {
                    DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding = this.f17197a;
                    DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding2 = dialogDatePickerLayoutBinding;
                    if (dialogDatePickerLayoutBinding == null) {
                        Intrinsics.c("mBinging");
                        dialogDatePickerLayoutBinding2 = null;
                    }
                    dialogDatePickerLayoutBinding2.f16325c.setSelectedPosition(a3);
                } else if (a3 == b3) {
                    break;
                } else {
                    a3++;
                }
            }
        }
        ArrayList<CharSequence> arrayList3 = this.e;
        IntRange a4 = arrayList3 == null ? null : CollectionsKt.a((Collection<?>) arrayList3);
        Intrinsics.a(a4);
        int a5 = a4.a();
        int b4 = a4.b();
        if (a5 <= b4) {
            while (true) {
                ArrayList<CharSequence> arrayList4 = this.e;
                if (Integer.parseInt(String.valueOf(arrayList4 == null ? null : arrayList4.get(a5))) >= parseInt2) {
                    DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding3 = this.f17197a;
                    DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding4 = dialogDatePickerLayoutBinding3;
                    if (dialogDatePickerLayoutBinding3 == null) {
                        Intrinsics.c("mBinging");
                        dialogDatePickerLayoutBinding4 = null;
                    }
                    dialogDatePickerLayoutBinding4.d.setSelectedPosition(a5);
                } else if (a5 == b4) {
                    break;
                } else {
                    a5++;
                }
            }
        }
        ArrayList<CharSequence> arrayList5 = this.f;
        IntRange a6 = arrayList5 == null ? null : CollectionsKt.a((Collection<?>) arrayList5);
        Intrinsics.a(a6);
        int a7 = a6.a();
        int b5 = a6.b();
        if (a7 > b5) {
            return;
        }
        while (true) {
            ArrayList<CharSequence> arrayList6 = this.f;
            if (Integer.parseInt(String.valueOf(arrayList6 == null ? null : arrayList6.get(a7))) >= parseInt3) {
                DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding5 = this.f17197a;
                if (dialogDatePickerLayoutBinding5 == null) {
                    Intrinsics.c("mBinging");
                    dialogDatePickerLayoutBinding5 = null;
                }
                dialogDatePickerLayoutBinding5.e.setSelectedPosition(a7);
                return;
            } else if (a7 == b5) {
                return;
            } else {
                a7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYDatePickerDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final String c(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            String format = new SimpleDateFormat("HH-mm-ss", BlueAppLocal.c()).format(calendar.getTime());
            Intrinsics.c(format, "{\n            val dateFo…(calendar.time)\n        }");
            return format;
        }
        String format2 = new SimpleDateFormat("HH-mm-ss", Locale.ENGLISH).format(calendar.getTime());
        Intrinsics.c(format2, "{\n            val dateFo…(calendar.time)\n        }");
        return format2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYDatePickerDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    private final long d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    private final void f() {
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding2 = dialogDatePickerLayoutBinding;
        if (dialogDatePickerLayoutBinding == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding2 = null;
        }
        dialogDatePickerLayoutBinding2.f16324a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDatePickerDialog$ZeK0byQ8f5b3M4zo2UtXMh5PVTg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDatePickerDialog.a(YYDatePickerDialog.this, view);
            }
        });
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding3 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding4 = dialogDatePickerLayoutBinding3;
        if (dialogDatePickerLayoutBinding3 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding4 = null;
        }
        dialogDatePickerLayoutBinding4.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDatePickerDialog$yyrvStFATBNmGmNDsCdGOWdPLCQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDatePickerDialog.b(YYDatePickerDialog.this, view);
            }
        });
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding5 = this.f17197a;
        if (dialogDatePickerLayoutBinding5 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding5 = null;
        }
        dialogDatePickerLayoutBinding5.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDatePickerDialog$tSCuzqW09uu30UpnqCre7mBGY1o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYDatePickerDialog.c(YYDatePickerDialog.this, view);
            }
        });
        long j = this.h;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        this.b = j;
        g();
    }

    private final void g() {
        this.f17198c = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                break;
            }
            ArrayList<CharSequence> arrayList = this.f17198c;
            Intrinsics.a(arrayList);
            arrayList.add(a(this.b + (this.i * i2)));
            i = i2 + 1;
        }
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding2 = dialogDatePickerLayoutBinding;
        if (dialogDatePickerLayoutBinding == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding2 = null;
        }
        dialogDatePickerLayoutBinding2.b.setData(this.f17198c);
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding3 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding4 = dialogDatePickerLayoutBinding3;
        if (dialogDatePickerLayoutBinding3 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding4 = null;
        }
        dialogDatePickerLayoutBinding4.b.setSelectedPosition(0);
        this.d = new ArrayList<>();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 24) {
                break;
            }
            ArrayList<CharSequence> arrayList2 = this.d;
            Intrinsics.a(arrayList2);
            arrayList2.add(i4 < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(i4)) : String.valueOf(i4));
            i3 = i4 + 1;
        }
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding5 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding6 = dialogDatePickerLayoutBinding5;
        if (dialogDatePickerLayoutBinding5 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding6 = null;
        }
        dialogDatePickerLayoutBinding6.f16325c.setData(this.d);
        this.e = new ArrayList<>();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 60) {
                break;
            }
            ArrayList<CharSequence> arrayList3 = this.e;
            Intrinsics.a(arrayList3);
            arrayList3.add(i6 < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(i6)) : String.valueOf(i6));
            i5 = i6 + 1;
        }
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding7 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding8 = dialogDatePickerLayoutBinding7;
        if (dialogDatePickerLayoutBinding7 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding8 = null;
        }
        dialogDatePickerLayoutBinding8.d.setData(this.e);
        this.f = new ArrayList<>();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 60) {
                break;
            }
            ArrayList<CharSequence> arrayList4 = this.f;
            Intrinsics.a(arrayList4);
            arrayList4.add(i8 < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(i8)) : String.valueOf(i8));
            i7 = i8 + 1;
        }
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding9 = this.f17197a;
        if (dialogDatePickerLayoutBinding9 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding9 = null;
        }
        dialogDatePickerLayoutBinding9.e.setData(this.f);
        h();
    }

    private final void h() {
        String a2 = a(this.b);
        ArrayList<CharSequence> arrayList = this.f17198c;
        Intrinsics.a(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            ArrayList<CharSequence> arrayList2 = this.f17198c;
            Intrinsics.a(arrayList2);
            if (Intrinsics.a((Object) arrayList2.get(i2), (Object) a2)) {
                DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding = this.f17197a;
                DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding2 = dialogDatePickerLayoutBinding;
                if (dialogDatePickerLayoutBinding == null) {
                    Intrinsics.c("mBinging");
                    dialogDatePickerLayoutBinding2 = null;
                }
                dialogDatePickerLayoutBinding2.b.setSelectedPosition(i2);
            } else {
                i = i2 + 1;
            }
        }
        b(this.b);
    }

    private final void i() {
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding2 = dialogDatePickerLayoutBinding;
        if (dialogDatePickerLayoutBinding == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding2 = null;
        }
        CharSequence selectedItem = dialogDatePickerLayoutBinding2.e.getSelectedItem();
        if (selectedItem == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        int parseInt = Integer.parseInt((String) selectedItem);
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding3 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding4 = dialogDatePickerLayoutBinding3;
        if (dialogDatePickerLayoutBinding3 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding4 = null;
        }
        CharSequence selectedItem2 = dialogDatePickerLayoutBinding4.f16325c.getSelectedItem();
        if (selectedItem2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        int parseInt2 = Integer.parseInt((String) selectedItem2);
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding5 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding6 = dialogDatePickerLayoutBinding5;
        if (dialogDatePickerLayoutBinding5 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding6 = null;
        }
        CharSequence selectedItem3 = dialogDatePickerLayoutBinding6.d.getSelectedItem();
        if (selectedItem3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        int parseInt3 = Integer.parseInt((String) selectedItem3);
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding7 = this.f17197a;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding8 = dialogDatePickerLayoutBinding7;
        if (dialogDatePickerLayoutBinding7 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding8 = null;
        }
        CharSequence selectedItem4 = dialogDatePickerLayoutBinding8.b.getSelectedItem();
        if (selectedItem4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) selectedItem4;
        DialogDatePickerLayoutBinding dialogDatePickerLayoutBinding9 = this.f17197a;
        if (dialogDatePickerLayoutBinding9 == null) {
            Intrinsics.c("mBinging");
            dialogDatePickerLayoutBinding9 = null;
        }
        int selectedPosition = dialogDatePickerLayoutBinding9.b.getSelectedPosition();
        long d = d(this.b);
        long j = this.l;
        long j2 = parseInt;
        long j3 = this.k;
        long j4 = parseInt3;
        long j5 = this.j;
        long j6 = (j * j2) + (j3 * j4) + (parseInt2 * j5) + (this.i * selectedPosition) + d;
        long j7 = this.h;
        if (j7 <= 0) {
            if (j6 < System.currentTimeMillis() + (this.k * 3)) {
                ToastUtils.a("主题专场开始时间过于接近，建议选择3分钟后的时间");
                return;
            }
        } else if (j7 > j6) {
            ToastUtils.a("请设置大于开始时间的时间");
            return;
        } else if (j6 > j7 + (j5 * 3)) {
            ToastUtils.a("活动时长仅限3个小时");
            return;
        }
        this.g = j6;
        IEventCallback iEventCallback = this.m;
        if (iEventCallback != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(' ');
            sb.append(parseInt2 < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(parseInt2)) : String.valueOf(parseInt2));
            sb.append(':');
            sb.append(parseInt3 < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(parseInt3)) : String.valueOf(parseInt3));
            sb.append(':');
            sb.append(parseInt < 10 ? Intrinsics.a("0", (Object) Integer.valueOf(parseInt)) : String.valueOf(parseInt));
            iEventCallback.a(j6, sb.toString());
        }
        dismissAllowingStateLoss();
    }

    public final void a(IEventCallback iEventCallback) {
        this.m = iEventCallback;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if ((arguments == null ? null : Long.valueOf(arguments.getLong("start_time"))) != null) {
                Bundle arguments2 = getArguments();
                Long valueOf = arguments2 == null ? null : Long.valueOf(arguments2.getLong("start_time"));
                Intrinsics.a(valueOf);
                this.h = valueOf.longValue();
                return;
            }
        }
        this.h = 0L;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_date_picker_layout, (ViewGroup) null);
        DialogDatePickerLayoutBinding a2 = DialogDatePickerLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f17197a = a2;
        f();
        return inflate;
    }
}
