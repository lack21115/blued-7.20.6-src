package com.blued.community.ui.send.fragment;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.DateUtils;
import com.blued.android.module.common.utils.HtmlUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.click.SingleItemChildClickProxy;
import com.blued.android.module.common.view.MDatePickerDialog;
import com.blued.android.module.common.widget.menu.ActionSheetDefaultItem;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentEventAddPostBinding;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventPostModel;
import com.blued.community.ui.send.adapter.EventAddPostTypeAdapter;
import com.blued.community.ui.send.adapter.EventPostImageAdapter;
import com.blued.community.ui.send.dialog.AlbumSelectDialogFragment;
import com.blued.community.ui.send.dialog.EventTypeDialogFragment;
import com.blued.community.ui.send.dialog.SelectCityDialogFragment;
import com.blued.community.ui.send.dialog.SelectLocationDialogFragment;
import com.blued.community.ui.send.manager.EventSendManager;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.send.model.EventAddPostTypeExtra;
import com.blued.community.ui.send.model.EventAddPostTypeModel;
import com.blued.community.ui.send.observer.IAddPost;
import com.blued.community.ui.send.observer.OnAddPostTitleListener;
import com.blued.community.ui.send.vm.EventAddPostViewModel;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.community.ui.send.vm.SelectCityViewModel;
import com.blued.community.ui.send.vm.SelectLocationViewModel;
import com.blued.community.utils.CityHelper;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.view.EditInputNumView;
import com.blued.community.view.SelectionEditText;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.simonvt.datepicker.DatePicker;
import net.simonvt.datepicker.DatePickerDialog;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventAddPostFragment.class */
public final class EventAddPostFragment extends MVVMBaseFragment<EventAddPostViewModel> implements IAddPost {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19971c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final TextWatcher i;
    private OnAddPostTitleListener j;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(EventAddPostFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentEventAddPostBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19970a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventAddPostFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            if (CommunityServiceManager.a().v() < 60) {
                AppMethods.a((CharSequence) "彩虹分余额不足，不能发布活动");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("event_from_page", FeedProtos.SourcePage.ACTIVITY_PAGE);
            TerminalActivity.d(context, EventAddPostFragment.class, bundle);
        }
    }

    public EventAddPostFragment() {
        super(R.layout.fragment_event_add_post);
        this.f19971c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<EventAddPostFragment, FragmentEventAddPostBinding>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventAddPostBinding invoke(EventAddPostFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventAddPostBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<EventAddPostFragment, FragmentEventAddPostBinding>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventAddPostBinding invoke(EventAddPostFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventAddPostBinding.a(fragment.requireView());
            }
        });
        this.d = LazyKt.a(new Function0<EventAddPostTypeAdapter>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$typeAdapter$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final EventAddPostTypeAdapter invoke() {
                return new EventAddPostTypeAdapter();
            }
        });
        this.e = LazyKt.a(new Function0<EventPostImageAdapter>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$photoAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final EventPostImageAdapter invoke() {
                return new EventPostImageAdapter(EventAddPostFragment.this.getFragmentActive(), DensityUtils.a(EventAddPostFragment.this.getContext(), 94.0f), false);
            }
        });
        this.f = LazyKt.a(new Function0<SelectLocationViewModel>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$mLocationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final SelectLocationViewModel invoke() {
                ViewModelStore viewModelStore = EventAddPostFragment.this.requireActivity().getViewModelStore();
                Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
                Application application = EventAddPostFragment.this.requireActivity().getApplication();
                Intrinsics.c(application, "requireActivity().application");
                return (SelectLocationViewModel) new ViewModelProvider(viewModelStore, new ViewModelProvider.AndroidViewModelFactory(application)).get(SelectLocationViewModel.class);
            }
        });
        this.g = LazyKt.a(new Function0<SelectCityViewModel>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$mSelectCityViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final SelectCityViewModel invoke() {
                ViewModelStore viewModelStore = EventAddPostFragment.this.requireActivity().getViewModelStore();
                Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
                Application application = EventAddPostFragment.this.requireActivity().getApplication();
                Intrinsics.c(application, "requireActivity().application");
                return (SelectCityViewModel) new ViewModelProvider(viewModelStore, new ViewModelProvider.AndroidViewModelFactory(application)).get(SelectCityViewModel.class);
            }
        });
        this.h = LazyKt.a(new Function0<SelectAlbumViewModel>() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$mAlbumViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final SelectAlbumViewModel invoke() {
                ViewModelStore viewModelStore = EventAddPostFragment.this.requireActivity().getViewModelStore();
                Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
                Application application = EventAddPostFragment.this.requireActivity().getApplication();
                Intrinsics.c(application, "requireActivity().application");
                return (SelectAlbumViewModel) new ViewModelProvider(viewModelStore, new ViewModelProvider.AndroidViewModelFactory(application)).get(SelectAlbumViewModel.class);
            }
        });
        this.i = new TextWatcher() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$changeTextWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EventAddPostFragment.this.O();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private final void A() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }

    private final void B() {
        ShapeLinearLayout shapeLinearLayout;
        FragmentEventAddPostBinding p = p();
        if (p != null && (shapeLinearLayout = p.p) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$iS9Zhu5bFBpwCy9IPb4TqtlLfCI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.a(EventAddPostFragment.this, view);
                }
            });
        }
        OnItemDragListener onItemDragListener = new OnItemDragListener() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$initLivePhoto$listener$1
            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void a(RecyclerView.ViewHolder viewHolder, int i) {
                Intrinsics.e(viewHolder, "viewHolder");
                KeyboardUtils.a(EventAddPostFragment.this.getActivity());
                ((BaseViewHolder) viewHolder).setGone(R.id.drag, true);
            }

            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void a(RecyclerView.ViewHolder source, int i, RecyclerView.ViewHolder target, int i2) {
                Intrinsics.e(source, "source");
                Intrinsics.e(target, "target");
            }

            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void b(RecyclerView.ViewHolder viewHolder, int i) {
                Intrinsics.e(viewHolder, "viewHolder");
                ((BaseViewHolder) viewHolder).setGone(R.id.drag, false);
            }
        };
        FragmentEventAddPostBinding p2 = p();
        RecyclerView recyclerView = p2 == null ? null : p2.y;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(r());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        FragmentEventAddPostBinding p3 = p();
        itemTouchHelper.attachToRecyclerView(p3 == null ? null : p3.y);
        itemDragAndSwipeCallback.a(15);
        itemDragAndSwipeCallback.b(48);
        r().h();
        r().a(itemTouchHelper);
        r().a(onItemDragListener);
        r().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$bHt03sb7bMftVLud2D1QvT15AX4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventAddPostFragment.a(EventAddPostFragment.this, baseQuickAdapter, view, i);
            }
        });
        r().setOnItemChildClickListener(new SingleItemChildClickProxy(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$W3a0TfQucR47o6gGxBwnzNSFEI8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventAddPostFragment.b(EventAddPostFragment.this, baseQuickAdapter, view, i);
            }
        }));
        FragmentEventAddPostBinding p4 = p();
        RecyclerView recyclerView2 = p4 == null ? null : p4.y;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(r());
    }

    private final void C() {
        D();
        AlbumSelectDialogFragment.Companion companion = AlbumSelectDialogFragment.f19909a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.c(requireActivity, "requireActivity()");
        companion.a(requireActivity, 4, 1, 9, 196, false);
    }

    private final void D() {
        FragmentEventAddPostBinding p;
        RecyclerView recyclerView;
        ShapeLinearLayout shapeLinearLayout;
        ImageView imageView;
        ShapeLinearLayout shapeLinearLayout2;
        ImageView imageView2;
        r().a();
        AlbumSelectInfo value = u().f().getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            List<ChildImageInfo> data = r().getData();
            Intrinsics.c(data, "photoAdapter.data");
            for (ChildImageInfo childImageInfo : data) {
                arrayList.add(childImageInfo.mImagePath);
            }
            ArrayList<String> arrayList2 = new ArrayList();
            List<MediaInfo> c2 = value.c();
            Intrinsics.c(c2, "albumSelectInfo.selectImgeList");
            for (MediaInfo mediaInfo : c2) {
                if (!arrayList.contains(mediaInfo.imagePath)) {
                    arrayList2.add(mediaInfo.imagePath);
                }
            }
            for (String str : arrayList2) {
                value.a(str);
                u().h().setValue(str);
            }
        }
        if (r().c() <= 0) {
            FragmentEventAddPostBinding p2 = p();
            RecyclerView recyclerView2 = p2 == null ? null : p2.y;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
        } else {
            FragmentEventAddPostBinding p3 = p();
            RecyclerView recyclerView3 = p3 == null ? null : p3.y;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
        }
        if (r().c() >= 9) {
            FragmentEventAddPostBinding p4 = p();
            ShapeHelper.d(p4 == null ? null : p4.p, R.color.syc_k);
            FragmentEventAddPostBinding p5 = p();
            TextView textView = p5 == null ? null : p5.b;
            if (textView != null) {
                textView.setAlpha(0.4f);
            }
            FragmentEventAddPostBinding p6 = p();
            if (p6 != null && (imageView2 = p6.i) != null) {
                imageView2.setImageResource(R.drawable.event_post_add_pic_gray);
            }
            FragmentEventAddPostBinding p7 = p();
            if (p7 == null || (shapeLinearLayout2 = p7.p) == null) {
                return;
            }
            shapeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$2y1VUXqPJpA3t6FcDoOMPirZ8yg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.b(EventAddPostFragment.this, view);
                }
            });
            return;
        }
        FragmentEventAddPostBinding p8 = p();
        ShapeHelper.d(p8 == null ? null : p8.p, R.color.syc_h);
        FragmentEventAddPostBinding p9 = p();
        TextView textView2 = p9 == null ? null : p9.b;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        FragmentEventAddPostBinding p10 = p();
        if (p10 != null && (imageView = p10.i) != null) {
            imageView.setImageResource(R.drawable.event_post_add_pic);
        }
        FragmentEventAddPostBinding p11 = p();
        if (p11 != null && (shapeLinearLayout = p11.p) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$_G825T0wsNg3w0ysTjttG3ZVgiY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.c(EventAddPostFragment.this, view);
                }
            });
        }
        if (r().c() < 2 || (p = p()) == null || (recyclerView = p.y) == null) {
            return;
        }
        recyclerView.scrollToPosition(r().c() - 1);
    }

    private final void E() {
        I();
        H();
        G();
        F();
    }

    private final void F() {
        SelectionEditText selectionEditText;
        SelectionEditText selectionEditText2;
        FragmentEventAddPostBinding p = p();
        MarkDownLinkHelper.a(p == null ? null : p.e);
        FragmentEventAddPostBinding p2 = p();
        if (p2 != null && (selectionEditText2 = p2.e) != null) {
            selectionEditText2.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$initHyperlinks$1
                private int b;

                /* renamed from: c  reason: collision with root package name */
                private int f19974c;
                private SpannableStringBuilder d;
                private SpannableStringBuilder e;

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SelectionEditText selectionEditText3;
                    SelectionEditText selectionEditText4;
                    FragmentEventAddPostBinding p3 = EventAddPostFragment.this.p();
                    if (p3 != null && (selectionEditText4 = p3.e) != null) {
                        selectionEditText4.removeTextChangedListener(this);
                    }
                    FragmentEventAddPostBinding p4 = EventAddPostFragment.this.p();
                    MarkDownLinkHelper.a(p4 == null ? null : p4.e, this.d, this.e, editable, this.b, this.f19974c);
                    FragmentEventAddPostBinding p5 = EventAddPostFragment.this.p();
                    if (p5 != null && (selectionEditText3 = p5.e) != null) {
                        selectionEditText3.addTextChangedListener(this);
                    }
                    if (MarkDownLinkHelper.a((Spannable) editable)) {
                        return;
                    }
                    EventAddPostFragment.this.a().e().online_url = String.valueOf(editable);
                    EventAddPostFragment.this.a().e().online_text = "";
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    SelectionEditText selectionEditText3;
                    Integer valueOf;
                    this.d = new SpannableStringBuilder(charSequence);
                    FragmentEventAddPostBinding p3 = EventAddPostFragment.this.p();
                    Integer valueOf2 = (p3 == null || (selectionEditText3 = p3.e) == null) ? null : Integer.valueOf(selectionEditText3.getSelectionStart());
                    Intrinsics.a(valueOf2);
                    this.b = valueOf2.intValue();
                    FragmentEventAddPostBinding p4 = EventAddPostFragment.this.p();
                    if (p4 == null) {
                        valueOf = null;
                    } else {
                        SelectionEditText selectionEditText4 = p4.e;
                        valueOf = selectionEditText4 == null ? null : Integer.valueOf(selectionEditText4.getSelectionEnd());
                    }
                    Intrinsics.a(valueOf);
                    this.f19974c = valueOf.intValue();
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    this.e = new SpannableStringBuilder(charSequence);
                }
            });
        }
        FragmentEventAddPostBinding p3 = p();
        if (p3 == null || (selectionEditText = p3.e) == null) {
            return;
        }
        selectionEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$UMeVj8YvQ35PfpgVwup_-Q2W7W0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                EventAddPostFragment.a(EventAddPostFragment.this, view, z);
            }
        });
    }

    private final void G() {
        LinearLayout linearLayout;
        EditText editText;
        EditInputNumView editInputNumView;
        TextView textView;
        String c2 = CityHelper.a().c(getContext());
        a().e().cityDef = c2;
        FragmentEventAddPostBinding p = p();
        TextView textView2 = p == null ? null : p.C;
        if (textView2 != null) {
            textView2.setText(c2);
        }
        FragmentEventAddPostBinding p2 = p();
        if (p2 != null && (textView = p2.C) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$X9IBDWKtGWtSTMBeJawRmxxhXiY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.d(EventAddPostFragment.this, view);
                }
            });
        }
        FragmentEventAddPostBinding p3 = p();
        if (p3 != null && (editInputNumView = p3.j) != null) {
            FragmentEventAddPostBinding p4 = p();
            editInputNumView.init(p4 == null ? null : p4.f18850c);
        }
        FragmentEventAddPostBinding p5 = p();
        if (p5 != null && (editText = p5.f18850c) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$initLocation$2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TextUtils.isEmpty(editable)) {
                        EventAddPostFragment.this.s().c((String) null);
                        EventAddPostFragment.this.s().b((String) null);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        FragmentEventAddPostBinding p6 = p();
        if (p6 == null || (linearLayout = p6.f18849a) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$z4y2vVGj-eSxb4pMMRcZuFDk6uU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventAddPostFragment.e(EventAddPostFragment.this, view);
            }
        });
    }

    private final void H() {
        ShapeLinearLayout shapeLinearLayout;
        FragmentEventAddPostBinding p = p();
        if (p == null || (shapeLinearLayout = p.r) == null) {
            return;
        }
        shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$BKHd2YSwQxOinkkxlnO7u_MCRv4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventAddPostFragment.f(EventAddPostFragment.this, view);
            }
        });
    }

    private final void I() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        FragmentEventAddPostBinding p = p();
        if (p != null && (editText3 = p.f) != null) {
            editText3.addTextChangedListener(this.i);
        }
        FragmentEventAddPostBinding p2 = p();
        if (p2 != null && (editText2 = p2.f) != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$initNumber$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Intrinsics.e(s, "s");
                    EventAddPostFragment.this.a(s);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                    Intrinsics.e(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                    Intrinsics.e(s, "s");
                }
            });
        }
        FragmentEventAddPostBinding p3 = p();
        if (p3 == null || (editText = p3.f) == null) {
            return;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$fmFg2ocoSdu5gPJ7L--7zTEMdbU
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                EventAddPostFragment.b(EventAddPostFragment.this, view, z);
            }
        });
    }

    private final void J() {
        q().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$UIqFBoOGVyF2rniBUO7UPMkaZRM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventAddPostFragment.c(EventAddPostFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentEventAddPostBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.z;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
        FragmentEventAddPostBinding p2 = p();
        RecyclerView recyclerView2 = p2 == null ? null : p2.z;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(q());
    }

    private final void K() {
        ShapeFrameLayout shapeFrameLayout;
        ShapeFrameLayout shapeFrameLayout2;
        a().e().mode_id = 1;
        FragmentEventAddPostBinding p = p();
        if (p != null && (shapeFrameLayout2 = p.w) != null) {
            shapeFrameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$8Ay-LY1ehBX8HhNXvvfR9vTq034
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.g(EventAddPostFragment.this, view);
                }
            });
        }
        FragmentEventAddPostBinding p2 = p();
        if (p2 == null || (shapeFrameLayout = p2.x) == null) {
            return;
        }
        shapeFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$Di5IHsgu3tSxfLcaNRHyf-FJWUk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventAddPostFragment.h(EventAddPostFragment.this, view);
            }
        });
    }

    private final void L() {
        SelectionEditText selectionEditText;
        SelectionEditText selectionEditText2;
        EditText editText;
        EditInputNumView editInputNumView;
        EditInputNumView editInputNumView2;
        ImageView imageView;
        FragmentEventAddPostBinding p = p();
        if (p != null && (imageView = p.h) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$li4d3YOfXh3-ediCSLBH0CmG5TU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.i(EventAddPostFragment.this, view);
                }
            });
        }
        FragmentEventAddPostBinding p2 = p();
        if (p2 != null && (editInputNumView2 = p2.l) != null) {
            FragmentEventAddPostBinding p3 = p();
            editInputNumView2.init(p3 == null ? null : p3.g);
        }
        FragmentEventAddPostBinding p4 = p();
        if (p4 != null && (editInputNumView = p4.k) != null) {
            FragmentEventAddPostBinding p5 = p();
            editInputNumView.init(p5 == null ? null : p5.d);
        }
        FragmentEventAddPostBinding p6 = p();
        if (p6 != null && (editText = p6.g) != null) {
            editText.addTextChangedListener(this.i);
        }
        FragmentEventAddPostBinding p7 = p();
        if (p7 != null && (selectionEditText2 = p7.d) != null) {
            selectionEditText2.addTextChangedListener(this.i);
        }
        FragmentEventAddPostBinding p8 = p();
        if (p8 == null || (selectionEditText = p8.d) == null) {
            return;
        }
        selectionEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$IU_UE7v9Hxu3819TOj7xc9OOUQ4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = EventAddPostFragment.a(view, motionEvent);
                return a2;
            }
        });
    }

    private final void M() {
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.community.ui.send.fragment.EventAddPostFragment$toSelectCover$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                CommunityServiceManager.b().a(EventAddPostFragment.this, 16, 176);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] perms) {
                Intrinsics.e(perms, "perms");
            }
        });
    }

    private final void N() {
        ShapeTextView shapeTextView;
        ImageView imageView;
        FragmentEventAddPostBinding p = p();
        if (p != null && (imageView = p.m) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$YN8v8d7qMmNDdYhN8ZIYOqUzRnM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.j(EventAddPostFragment.this, view);
                }
            });
        }
        FragmentEventAddPostBinding p2 = p();
        if (p2 != null && (shapeTextView = p2.H) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$02mfyiPIz2FWExsPwpralCCWuNY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventAddPostFragment.k(EventAddPostFragment.this, view);
                }
            });
        }
        if (this.j == null) {
            return;
        }
        FragmentEventAddPostBinding p3 = p();
        ConstraintLayout constraintLayout = p3 == null ? null : p3.q;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        P();
        FragmentEventAddPostBinding p = p();
        ShapeTextView shapeTextView = p == null ? null : p.H;
        if (shapeTextView != null) {
            shapeTextView.setAlpha(b(false) ? 1.0f : 0.3f);
        }
        OnAddPostTitleListener onAddPostTitleListener = this.j;
        if (onAddPostTitleListener == null) {
            return;
        }
        onAddPostTitleListener.a();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final void P() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final boolean Q() {
        P();
        return !a().e().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Editable editable) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (editable != null) {
            if (editable.length() > 0) {
                if (Integer.parseInt(editable.toString()) < 2) {
                    FragmentEventAddPostBinding p = p();
                    TextView textView4 = p == null ? null : p.E;
                    if (textView4 != null) {
                        textView4.setText(requireContext().getString(R.string.event_post_number_persons_less));
                    }
                    FragmentEventAddPostBinding p2 = p();
                    if (p2 == null || (textView3 = p2.E) == null) {
                        return;
                    }
                    textView3.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_g));
                } else if (Integer.parseInt(editable.toString()) > a().m()) {
                    FragmentEventAddPostBinding p3 = p();
                    TextView textView5 = p3 == null ? null : p3.E;
                    if (textView5 != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                        String string = requireContext().getString(R.string.event_post_number_persons_exceed);
                        Intrinsics.c(string, "requireContext().getStri…st_number_persons_exceed)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(a().m())}, 1));
                        Intrinsics.c(format, "format(format, *args)");
                        textView5.setText(format);
                    }
                    FragmentEventAddPostBinding p4 = p();
                    if (p4 == null || (textView2 = p4.E) == null) {
                        return;
                    }
                    textView2.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_g));
                } else {
                    FragmentEventAddPostBinding p5 = p();
                    TextView textView6 = p5 == null ? null : p5.E;
                    if (textView6 != null) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                        String string2 = requireContext().getString(R.string.event_post_number_persons_limit);
                        Intrinsics.c(string2, "requireContext().getStri…ost_number_persons_limit)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(a().m())}, 1));
                        Intrinsics.c(format2, "format(format, *args)");
                        textView6.setText(format2);
                    }
                    FragmentEventAddPostBinding p6 = p();
                    if (p6 == null || (textView = p6.E) == null) {
                        return;
                    }
                    textView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(this$0.a().g().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final EventAddPostFragment this$0, View view, boolean z) {
        SelectionEditText selectionEditText;
        Intrinsics.e(this$0, "this$0");
        if (z) {
            return;
        }
        EventPostModel e = this$0.a().e();
        FragmentEventAddPostBinding p = this$0.p();
        Editable editable = null;
        if (p != null && (selectionEditText = p.e) != null) {
            editable = selectionEditText.getText();
        }
        e.online_url = String.valueOf(editable);
        HtmlUtils.a(this$0.a().e().online_url, new HtmlUtils.HtmlCallback() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$fFiNW7acrM3PzHJ6tsGfi3Bi-bQ
            @Override // com.blued.android.module.common.utils.HtmlUtils.HtmlCallback
            public final void onUIData(String str) {
                EventAddPostFragment.d(EventAddPostFragment.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, BluedActionSheet bluedActionSheet) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.getActivity(), i, 0, (LoadOptions) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventAddPostFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.e(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3);
        int l = this$0.a().l();
        long a2 = DateUtils.a(calendar);
        boolean z = false;
        if (0 <= a2) {
            z = false;
            if (a2 <= l) {
                z = true;
            }
        }
        if (!z) {
            AppMethods.a((CharSequence) ("只能选择" + l + "天以内的日期"));
            return;
        }
        int i4 = i2 + 1;
        String a3 = i4 <= 9 ? Intrinsics.a("0", (Object) Integer.valueOf(i4)) : String.valueOf(i4);
        String a4 = i3 <= 9 ? Intrinsics.a("0", (Object) Integer.valueOf(i3)) : String.valueOf(i3);
        FragmentEventAddPostBinding p = this$0.p();
        TextView textView = p == null ? null : p.D;
        if (textView != null) {
            textView.setText(a3 + (char) 26376 + a4 + (char) 26085);
        }
        this$0.a().e().activity_date = calendar.getTimeInMillis() / 1000;
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(EventAddPostTypeExtra eventAddPostTypeExtra) {
        FragmentEventAddPostBinding p = p();
        TextView textView = p == null ? null : p.E;
        if (textView == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = requireContext().getString(R.string.event_post_number_persons_limit);
        Intrinsics.c(string, "requireContext().getStri…ost_number_persons_limit)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(a().m())}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        EditText editText;
        FragmentEventAddPostBinding p = p();
        if (p != null && (editText = p.f18850c) != null) {
            editText.setText(str);
        }
        a().e().location = str;
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<EventAddPostTypeModel> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<EventAddPostTypeModel> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EventAddPostTypeModel next = it.next();
                if (next.getMode_id() == a().f() && next.isSelect(a().h().getValue())) {
                    arrayList.add(next);
                    break;
                }
            }
            Iterator<EventAddPostTypeModel> it2 = list.iterator();
            while (true) {
                z = false;
                if (!it2.hasNext()) {
                    break;
                }
                EventAddPostTypeModel next2 = it2.next();
                if (next2.getMode_id() == a().f() && !next2.isSelect(a().h().getValue())) {
                    if (arrayList.size() >= 7) {
                        z = true;
                        break;
                    }
                    arrayList.add(next2);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            arrayList.add(new EventAddPostTypeModel(true));
        }
        q().setNewData(arrayList);
    }

    private final void a(boolean z, String str) {
        if (z) {
            AppMethods.a((CharSequence) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.edt_content) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventAddPostFragment this$0, View view) {
        String format;
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            format = null;
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = context.getString(R.string.max_select_num);
            Intrinsics.c(string, "it1.getString(R.string.max_select_num)");
            format = String.format(string, Arrays.copyOf(new Object[]{9}, 1));
            Intrinsics.c(format, "format(format, *args)");
        }
        AppMethods.a((CharSequence) format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventAddPostFragment this$0, View view, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            FragmentEventAddPostBinding p = this$0.p();
            TextView textView = p == null ? null : p.E;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentEventAddPostBinding p2 = this$0.p();
        TextView textView2 = p2 == null ? null : p2.E;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventAddPostFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        int id = view.getId();
        if (id != R.id.iv_image_delete) {
            if (id == R.id.img_add) {
                this$0.C();
                return;
            }
            return;
        }
        SelectPhotoManager.a().b(this$0.r().getData().get(i));
        AlbumSelectInfo value = this$0.u().f().getValue();
        if (value != null) {
            value.a(this$0.r().getData().get(i).mImagePath);
        }
        this$0.u().h().setValue(this$0.r().getData().get(i).mImagePath);
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        FragmentEventAddPostBinding p = p();
        TextView textView = p == null ? null : p.C;
        if (textView != null) {
            textView.setText(str);
        }
        a().e().city = str;
        O();
    }

    private final boolean b(boolean z) {
        if (TextUtils.isEmpty(a().e().name)) {
            a(z, "请输入活动标题");
            return false;
        } else if (a().e().name.length() > 10) {
            a(z, "活动标题必须在10字以内");
            return false;
        } else if (TextUtils.isEmpty(a().e().description)) {
            a(z, "请输入活动描述");
            return false;
        } else if (a().e().description.length() > 512) {
            a(z, "活动描述必须在512字以内");
            return false;
        } else if (a().e().quota_num == 0) {
            a(z, "请输入满员人数");
            return false;
        } else if (a().e().quota_num < 2) {
            a(z, "满员人数不能低于2人");
            return false;
        } else if (TextUtils.isEmpty(a().e().type_id)) {
            a(z, "请选择活动类型");
            return false;
        } else if (a().e().quota_num > a().m()) {
            a(z, "满员人数必须小于" + a().m() + (char) 20154);
            return false;
        } else {
            if (a().f() == 1) {
                if (TextUtils.isEmpty(a().e().city)) {
                    a(z, "请选择活动城市");
                    return false;
                } else if (a().e().location.length() > 50) {
                    a(z, "活动地址必须在50字以内");
                    return false;
                }
            }
            if (a().e().activity_date <= 0) {
                a(z, "请选择活动开始日期");
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final EventAddPostFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        EventAddPostTypeModel eventAddPostTypeModel = this$0.q().getData().get(i);
        if (!eventAddPostTypeModel.isMore()) {
            this$0.a().h().setValue(eventAddPostTypeModel.getType_id());
            return;
        }
        FragmentManager fragmentManager = this$0.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        EventTypeDialogFragment.f19915a.a(fragmentManager).a(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$9flz2wNKka9R8TqkDzLcpgUm8Dw
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EventAddPostFragment.a(EventAddPostFragment.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        a().a(str);
        q().a(str);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentManager fragmentManager = this$0.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        SelectCityDialogFragment.f19926a.a(fragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventAddPostFragment this$0, String str) {
        SelectionEditText selectionEditText;
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this$0.a().e().online_text = str;
        CharSequence a2 = MarkDownLinkHelper.a(this$0.getContext(), '[' + ((Object) str) + "](" + ((Object) this$0.a().e().online_url) + ')', true, R.color.syc_m);
        FragmentEventAddPostBinding p = this$0.p();
        if (p == null || (selectionEditText = p.e) == null) {
            return;
        }
        selectionEditText.setText(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentManager fragmentManager = this$0.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        SelectLocationDialogFragment.f19932a.a(fragmentManager, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final EventAddPostFragment this$0, View view) {
        int i;
        int i2;
        TextView textView;
        Intrinsics.e(this$0, "this$0");
        int i3 = Calendar.getInstance().get(1);
        int i4 = Calendar.getInstance().get(2) + 1;
        int i5 = Calendar.getInstance().get(5);
        FragmentEventAddPostBinding p = this$0.p();
        CharSequence charSequence = null;
        if (p != null && (textView = p.D) != null) {
            charSequence = textView.getText();
        }
        String valueOf = String.valueOf(charSequence);
        int i6 = i4;
        if (!TextUtils.isEmpty(valueOf)) {
            Object[] array = StringsKt.b((CharSequence) valueOf, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            i6 = i4;
            if (strArr.length == 2) {
                i6 = i4;
                try {
                    int parseInt = Integer.parseInt(strArr[0]);
                    i6 = parseInt;
                    i2 = Integer.parseInt(strArr[1]);
                    i = parseInt;
                } catch (Exception e) {
                }
                new MDatePickerDialog(this$0.getContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$NZKu9yx6ed2JeFKvZ2WPBXxZht0
                    @Override // net.simonvt.datepicker.DatePickerDialog.OnDateSetListener
                    public final void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                        EventAddPostFragment.a(EventAddPostFragment.this, datePicker, i7, i8, i9);
                    }
                }, i3, i - 1, i2).show();
            }
        }
        i = i6;
        i2 = i5;
        new MDatePickerDialog(this$0.getContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$NZKu9yx6ed2JeFKvZ2WPBXxZht0
            @Override // net.simonvt.datepicker.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                EventAddPostFragment.a(EventAddPostFragment.this, datePicker, i7, i8, i9);
            }
        }, i3, i - 1, i2).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EventAddPostFragment this$0, View view) {
        Editable text;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        Intrinsics.e(this$0, "this$0");
        FragmentEventAddPostBinding p = this$0.p();
        ShapeHelper.b(p == null ? null : p.w, R.color.syc_event_post_select);
        FragmentEventAddPostBinding p2 = this$0.p();
        if (p2 != null && (textView2 = p2.F) != null) {
            textView2.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_a));
        }
        FragmentEventAddPostBinding p3 = this$0.p();
        if (p3 != null && (imageView2 = p3.n) != null) {
            imageView2.setImageResource(R.drawable.send_event_form_selected);
        }
        FragmentEventAddPostBinding p4 = this$0.p();
        ShapeHelper.b(p4 == null ? null : p4.x, R.color.syc_x);
        FragmentEventAddPostBinding p5 = this$0.p();
        if (p5 != null && (textView = p5.G) != null) {
            textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_j));
        }
        FragmentEventAddPostBinding p6 = this$0.p();
        if (p6 != null && (imageView = p6.o) != null) {
            imageView.setImageResource(R.drawable.send_event_form_unselected);
        }
        FragmentEventAddPostBinding p7 = this$0.p();
        ShapeLinearLayout shapeLinearLayout = p7 == null ? null : p7.u;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setVisibility(0);
        }
        FragmentEventAddPostBinding p8 = this$0.p();
        ShapeLinearLayout shapeLinearLayout2 = p8 == null ? null : p8.s;
        if (shapeLinearLayout2 != null) {
            shapeLinearLayout2.setVisibility(8);
        }
        this$0.a().e().mode_id = 1;
        this$0.a().n();
        this$0.a(this$0.a().g().getValue());
        FragmentEventAddPostBinding p9 = this$0.p();
        TextView textView3 = p9 == null ? null : p9.E;
        if (textView3 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = this$0.requireContext().getString(R.string.event_post_number_persons_limit);
            Intrinsics.c(string, "requireContext().getStri…ost_number_persons_limit)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.a().m())}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView3.setText(format);
        }
        FragmentEventAddPostBinding p10 = this$0.p();
        if (p10 == null) {
            text = null;
        } else {
            EditText editText = p10.f;
            text = editText == null ? null : editText.getText();
        }
        this$0.a(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EventAddPostFragment this$0, View view) {
        Editable text;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        Intrinsics.e(this$0, "this$0");
        FragmentEventAddPostBinding p = this$0.p();
        ShapeHelper.b(p == null ? null : p.x, R.color.syc_event_post_select);
        FragmentEventAddPostBinding p2 = this$0.p();
        if (p2 != null && (textView2 = p2.G) != null) {
            textView2.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_a));
        }
        FragmentEventAddPostBinding p3 = this$0.p();
        if (p3 != null && (imageView2 = p3.o) != null) {
            imageView2.setImageResource(R.drawable.send_event_form_selected);
        }
        FragmentEventAddPostBinding p4 = this$0.p();
        ShapeHelper.b(p4 == null ? null : p4.w, R.color.syc_x);
        FragmentEventAddPostBinding p5 = this$0.p();
        if (p5 != null && (textView = p5.F) != null) {
            textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_j));
        }
        FragmentEventAddPostBinding p6 = this$0.p();
        if (p6 != null && (imageView = p6.n) != null) {
            imageView.setImageResource(R.drawable.send_event_form_unselected);
        }
        FragmentEventAddPostBinding p7 = this$0.p();
        ShapeLinearLayout shapeLinearLayout = p7 == null ? null : p7.s;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setVisibility(0);
        }
        FragmentEventAddPostBinding p8 = this$0.p();
        ShapeLinearLayout shapeLinearLayout2 = p8 == null ? null : p8.u;
        if (shapeLinearLayout2 != null) {
            shapeLinearLayout2.setVisibility(8);
        }
        this$0.a().e().mode_id = 2;
        this$0.a().n();
        this$0.a(this$0.a().g().getValue());
        FragmentEventAddPostBinding p9 = this$0.p();
        TextView textView3 = p9 == null ? null : p9.E;
        if (textView3 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = this$0.requireContext().getString(R.string.event_post_number_persons_limit);
            Intrinsics.c(string, "requireContext().getStri…ost_number_persons_limit)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.a().m())}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView3.setText(format);
        }
        FragmentEventAddPostBinding p10 = this$0.p();
        if (p10 == null) {
            text = null;
        } else {
            EditText editText = p10.f;
            text = editText == null ? null : editText.getText();
        }
        this$0.a(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(EventAddPostFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.y();
    }

    public final String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : !TextUtils.isEmpty(str2) ? str2 : "";
    }

    public void a(OnAddPostTitleListener listenerAddPost) {
        Intrinsics.e(listenerAddPost, "listenerAddPost");
        this.j = listenerAddPost;
    }

    public final String b(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : !TextUtils.isEmpty(str2) ? str2 : "";
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void e() {
        Window window;
        super.e();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(18);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        N();
        L();
        K();
        J();
        B();
        E();
        EventAddPostViewModel a2 = a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        super.g();
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_EDIT_PAGE_SHOW, a().d());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public ViewModelStoreOwner h() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.c(requireActivity, "requireActivity()");
        return requireActivity;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        super.k();
        u().j().observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$y1wUWBkfERe3IEkSVMOVDxj7cT4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventAddPostFragment.a(EventAddPostFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        EventAddPostFragment eventAddPostFragment = this;
        LifecycleExtKt.b(eventAddPostFragment, a().g(), new EventAddPostFragment$liveDataObserver$1(this));
        LifecycleExtKt.b(eventAddPostFragment, a().k(), new EventAddPostFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(eventAddPostFragment, a().h(), new EventAddPostFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(eventAddPostFragment, t().d(), new EventAddPostFragment$liveDataObserver$4(this));
        LifecycleExtKt.a(eventAddPostFragment, s().e(), new EventAddPostFragment$liveDataObserver$5(this));
        LifecycleExtKt.a(eventAddPostFragment, s().f(), new EventAddPostFragment$liveDataObserver$6(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 176) {
                if (i == 196 && intent != null) {
                    Serializable serializableExtra = intent.getSerializableExtra("result_model");
                    if (serializableExtra == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.base.shortvideo.StvResultModel");
                    }
                    StvResultModel stvResultModel = (StvResultModel) serializableExtra;
                    ChildImageInfo childImageInfo = new ChildImageInfo();
                    childImageInfo.mImagePath = stvResultModel.b();
                    SelectPhotoManager.a().a(childImageInfo);
                    SelectAlbumViewModel u = u();
                    String b2 = stvResultModel.b();
                    Intrinsics.c(b2, "stvResultModel.captureFramePath");
                    u.a(b2);
                    D();
                }
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("photo_path");
                if (!TextUtils.isEmpty(stringExtra)) {
                    ImageWrapper d = ImageLoader.d(getFragmentActive(), String.valueOf(stringExtra));
                    FragmentEventAddPostBinding p = p();
                    d.a(p == null ? null : p.h);
                    FragmentEventAddPostBinding p2 = p();
                    TextView textView = p2 == null ? null : p2.B;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    a().e().localPic = stringExtra;
                    O();
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        w();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        A();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        D();
    }

    public final FragmentEventAddPostBinding p() {
        return (FragmentEventAddPostBinding) this.f19971c.b(this, b[0]);
    }

    public final EventAddPostTypeAdapter q() {
        return (EventAddPostTypeAdapter) this.d.getValue();
    }

    public final EventPostImageAdapter r() {
        return (EventPostImageAdapter) this.e.getValue();
    }

    public final SelectLocationViewModel s() {
        return (SelectLocationViewModel) this.f.getValue();
    }

    public final SelectCityViewModel t() {
        return (SelectCityViewModel) this.g.getValue();
    }

    public final SelectAlbumViewModel u() {
        return (SelectAlbumViewModel) this.h.getValue();
    }

    public final void v() {
        EventSendManager.a().a(getActivity(), a().e());
    }

    public final void w() {
        if (!Q()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        BluedActionSheet.Builder builder = new BluedActionSheet.Builder(getContext());
        Context context = getContext();
        builder.a(context == null ? null : context.getString(R.string.event_post_back_title));
        ActionSheetDefaultItem a2 = ActionSheetDefaultItem.a();
        Context context2 = getContext();
        builder.a(a2.a(context2 == null ? null : context2.getString(R.string.event_post_back_give_up)).a(R.color.syc_g).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$EventAddPostFragment$6jNz827RwgEaHuhlEm36_NruEOQ
            @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
            public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                EventAddPostFragment.a(EventAddPostFragment.this, bluedActionSheet);
            }
        }));
        builder.d();
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public void x() {
        w();
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public void y() {
        P();
        if (b(true)) {
            EventTrackFeed.b(FeedProtos.Event.ACTIVITY_EDIT_PAGE_PUBLISH_CLICK, a().d(), r().f());
            v();
        }
    }

    @Override // com.blued.community.ui.send.observer.IAddPost
    public boolean z() {
        return b(false);
    }
}
