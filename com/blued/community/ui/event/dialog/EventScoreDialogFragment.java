package com.blued.community.ui.event.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.R;
import com.blued.community.databinding.DialogEventScoreBinding;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.dialog.EventScoreDialogFragment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.send.fragment.EventScoreAddPostFragment;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.das.client.feed.FeedProtos;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventScoreDialogFragment.class */
public final class EventScoreDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19526a = new Companion(null);
    private List<EventDetailsModel.QuickEvaluate> e;
    private EventScoreListener h;
    private final Lazy b = LazyKt.a(new Function0<DialogEventScoreBinding>() { // from class: com.blued.community.ui.event.dialog.EventScoreDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogEventScoreBinding invoke() {
            return DialogEventScoreBinding.a(LayoutInflater.from(EventScoreDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f19527c = LazyKt.a(new Function0<Dialog>() { // from class: com.blued.community.ui.event.dialog.EventScoreDialogFragment$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final Dialog invoke() {
            return DialogUtils.a(EventScoreDialogFragment.this.getContext());
        }
    });
    private EventDetailsModel d = new EventDetailsModel();
    private final Set<String> f = new HashSet();
    private final Set<String> g = new HashSet();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventScoreDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventScoreDialogFragment a(EventDetailsModel event, FragmentManager manager) {
            Intrinsics.e(event, "event");
            Intrinsics.e(manager, "manager");
            EventScoreDialogFragment eventScoreDialogFragment = new EventScoreDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("event_details", event);
            eventScoreDialogFragment.setArguments(bundle);
            eventScoreDialogFragment.show(manager, EventScoreDialogFragment.class.getSimpleName());
            return eventScoreDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventScoreDialogFragment$EventScoreListener.class */
    public interface EventScoreListener {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventScoreDialogFragment this$0, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventScoreDialogFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            this$0.i().f.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsModel.QuickEvaluate quickEvaluate, EventScoreDialogFragment this$0, ShapeTextView stvEvaluate, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(stvEvaluate, "$stvEvaluate");
        if (TextUtils.isEmpty(quickEvaluate.id)) {
            return;
        }
        if (this$0.f.contains(quickEvaluate.id)) {
            this$0.f.remove(quickEvaluate.id);
            this$0.g.remove(quickEvaluate.name);
            ShapeHelper.b(stvEvaluate, R.color.syc_x);
            stvEvaluate.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_j));
        } else if (this$0.f.size() >= 3) {
            AppMethods.d(R.string.event_score_select_max_toast);
        } else {
            Set<String> set = this$0.f;
            String str = quickEvaluate.id;
            Intrinsics.c(str, "evaluate.id");
            set.add(str);
            Set<String> set2 = this$0.g;
            String str2 = quickEvaluate.name;
            Intrinsics.c(str2, "evaluate.name");
            set2.add(str2);
            ShapeHelper.b(stvEvaluate, R.color.syc_e_10);
            stvEvaluate.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final int i) {
        i().l.setVisibility(4);
        i().m.setVisibility(0);
        i().k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$I4T1NMwnxje9kLOuJsdz4fCh49M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.h(EventScoreDialogFragment.this, view);
            }
        });
        TextView textView = i().z;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = requireContext().getString(R.string.event_score_score_num);
        Intrinsics.c(string, "requireContext().getStri…ng.event_score_score_num)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(i)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        i().f18794a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$Yql-Gs8BriQUg5CbHjustT2Jc4Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.a(EventScoreDialogFragment.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventScoreDialogFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            this$0.i().e.setChecked(true);
        }
    }

    private final void c(int i) {
        EventScoreAddPostFragment.Companion companion = EventScoreAddPostFragment.b;
        Context requireContext = requireContext();
        Intrinsics.c(requireContext, "requireContext()");
        String str = this.d.id;
        Intrinsics.c(str, "event.id");
        companion.a(requireContext, str, i, q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        this$0.i().g.setChecked(true);
        this$0.i().y.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventScoreDialogFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            this$0.i().d.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        this$0.i().f.setChecked(true);
        this$0.i().x.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventScoreDialogFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            this$0.i().f18795c.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        this$0.i().e.setChecked(true);
        this$0.i().w.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventScoreDialogFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            this$0.i().b.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        this$0.i().d.setChecked(true);
        this$0.i().v.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        this$0.i().f18795c.setChecked(true);
        this$0.i().u.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EventScoreDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final DialogEventScoreBinding i() {
        return (DialogEventScoreBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog j() {
        return (Dialog) this.f19527c.getValue();
    }

    private final void k() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Serializable serializable = arguments.getSerializable("event_details");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.event.model.EventDetailsModel");
        }
        this.d = (EventDetailsModel) serializable;
    }

    private final void l() {
        i().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$FuA0EdVfaCdRmETGJyaQh60zFTA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.a(EventScoreDialogFragment.this, view);
            }
        });
        i().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$y-7TC3pZuOwSIadMku5fU0h0h6U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.b(EventScoreDialogFragment.this, view);
            }
        });
        i().r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$Y6JXN3pfKGKUW1cMLca7BqFdYZk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.c(EventScoreDialogFragment.this, view);
            }
        });
        i().q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$cWfK1kupdNyXdyr_EMK0-EtxfZA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.d(EventScoreDialogFragment.this, view);
            }
        });
        i().p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$Qm2cpnsNrIpQ3sIp_UcIjODUykQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.e(EventScoreDialogFragment.this, view);
            }
        });
        i().o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$02SkFA7jRQVmTPJkBWgzjKWiEag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.f(EventScoreDialogFragment.this, view);
            }
        });
        i().n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$hO1Jw35MdnQaIdZdtv8FfSYwj40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScoreDialogFragment.g(EventScoreDialogFragment.this, view);
            }
        });
        i().g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$Cyvi6oDDsrHQ1HHpGB2bh-IiVzI
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventScoreDialogFragment.a(EventScoreDialogFragment.this, compoundButton, z);
            }
        });
        i().f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$HWjRG_FuKapgX3BUOe1LeMRhur8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventScoreDialogFragment.b(EventScoreDialogFragment.this, compoundButton, z);
            }
        });
        i().e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$1oCFUFTaijPiwTEomr6oq6xlzGs
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventScoreDialogFragment.c(EventScoreDialogFragment.this, compoundButton, z);
            }
        });
        i().d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$EUzEyzd4x29wPm9tfxwJK1VSBRg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventScoreDialogFragment.d(EventScoreDialogFragment.this, compoundButton, z);
            }
        });
        i().f18795c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$P97o05B9nGvIDMJES10-tcYV1pc
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventScoreDialogFragment.e(EventScoreDialogFragment.this, compoundButton, z);
            }
        });
        this.e = this.d.quick_evaluate;
        if (this.d.quick_evaluate == null || this.d.quick_evaluate.size() <= 0) {
            return;
        }
        int size = this.d.quick_evaluate.size();
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                i().h.setReferencedIds(iArr);
                return;
            }
            final EventDetailsModel.QuickEvaluate quickEvaluate = this.d.quick_evaluate.get(i2);
            final ShapeTextView shapeTextView = new ShapeTextView(getContext());
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.height = BluedViewExtKt.a(32);
            shapeTextView.setLayoutParams(layoutParams);
            shapeTextView.setPadding(BluedViewExtKt.a(12), 0, BluedViewExtKt.a(12), 0);
            ShapeTextView shapeTextView2 = shapeTextView;
            ShapeHelper.b(shapeTextView2, R.color.syc_x);
            ShapeHelper.a(shapeTextView2, BluedViewExtKt.a(32));
            shapeTextView.setText(quickEvaluate.name);
            shapeTextView.setTextSize(14.0f);
            shapeTextView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
            shapeTextView.setGravity(17);
            shapeTextView.setTag(quickEvaluate);
            int i3 = i2 + size;
            shapeTextView.setId(i3);
            iArr[i2] = i3;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventScoreDialogFragment$kXpK4OATgan-tB3VTAObl3wte5E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventScoreDialogFragment.a(EventDetailsModel.QuickEvaluate.this, this, shapeTextView, view);
                }
            });
            i().l.addView(shapeTextView);
            i = i2 + 1;
        }
    }

    private final void m() {
        i().g.setChecked(false);
        i().f.setChecked(false);
        i().e.setChecked(false);
        i().d.setChecked(false);
        i().f18795c.setChecked(false);
        i().y.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
        i().x.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
        i().w.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
        i().v.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
        i().u.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
    }

    private final void n() {
        final int p = p();
        if (p <= 0) {
            return;
        }
        EventTrackFeed.b(FeedProtos.Event.ACTIVITY_COMMENT_PUBLISH, this.d.id, p);
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        final ActivityFragmentActive a2 = a();
        BluedUIHttpResponse<BluedEntityA<EventDetailsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>(a2) { // from class: com.blued.community.ui.event.dialog.EventScoreDialogFragment$postScore$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> bluedEntityA) {
                EventScoreDialogFragment.EventScoreListener h = EventScoreDialogFragment.this.h();
                if (h != null) {
                    h.a(p);
                }
                EventScoreDialogFragment.this.b(p);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                Dialog j;
                EventDetailsModel eventDetailsModel;
                EventDetailsModel eventDetailsModel2;
                String q;
                EventDetailsModel eventDetailsModel3;
                super.onUIFinish(z);
                j = EventScoreDialogFragment.this.j();
                j.dismiss();
                if (!z) {
                    AppMethods.d(R.string.event_post_fail);
                    return;
                }
                eventDetailsModel = EventScoreDialogFragment.this.d;
                eventDetailsModel.activity_score = p;
                eventDetailsModel2 = EventScoreDialogFragment.this.d;
                q = EventScoreDialogFragment.this.q();
                eventDetailsModel2.activity_evaluate = q;
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.f20461a;
                eventDetailsModel3 = EventScoreDialogFragment.this.d;
                commEventBusUtil.a(eventDetailsModel3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                Dialog j;
                super.onUIStart();
                j = EventScoreDialogFragment.this.j();
                j.show();
            }
        };
        String str = this.d.id;
        Intrinsics.c(str, "event.id");
        eventHttpUtils.a(bluedUIHttpResponse, str, p, o(), a());
    }

    private final String o() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f) {
            sb.append(str);
            sb.append(",");
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "str.toString()");
        return sb2;
    }

    private final int p() {
        if (i().g.isChecked()) {
            return 5;
        }
        if (i().f.isChecked()) {
            return 4;
        }
        if (i().e.isChecked()) {
            return 3;
        }
        if (i().d.isChecked()) {
            return 2;
        }
        return i().f18795c.isChecked() ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.g) {
            sb.append(str);
            sb.append("・");
        }
        if (StringsKt.b((CharSequence) sb, (CharSequence) "・", false, 2, (Object) null)) {
            Intrinsics.c(sb.deleteCharAt(sb.length() - 1), "this.deleteCharAt(index)");
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "str.toString()");
        return sb2;
    }

    public final EventScoreListener h() {
        return this.h;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(i().getRoot());
        k();
        l();
    }
}
