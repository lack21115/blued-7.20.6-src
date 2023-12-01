package com.blued.android.module.yy_china.view;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogNewUserGiftBinding;
import com.blued.android.module.yy_china.databinding.ItemNewUserGiftBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.model.NewComesNewGiftModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYNewUserGiftDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftDialog.class */
public final class YYNewUserGiftDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f18336a = new Companion(null);
    private DialogNewUserGiftBinding b;

    /* renamed from: c  reason: collision with root package name */
    private NewComesNewGiftModel f18337c;
    private List<NewComesNewGiftModel> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftDialog$CAdapter.class */
    public final class CAdapter extends BaseQuickAdapter<NewComesNewGiftModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYNewUserGiftDialog f18338a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CAdapter(YYNewUserGiftDialog this$0) {
            super(R.layout.item_new_user_gift, new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f18338a = this$0;
        }

        private final void a(final View view) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
            Intrinsics.c(ofFloat, "ofFloat(1f, 0.8f, 1f)");
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftDialog$CAdapter$yyHa_E5rHmeNP6MV0DZ6Htv6_4w
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    YYNewUserGiftDialog.CAdapter.a(View.this, valueAnimator);
                }
            });
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View giftView, ValueAnimator valueAnimator) {
            Intrinsics.e(giftView, "$giftView");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            float floatValue = ((Float) animatedValue).floatValue();
            giftView.setScaleX(floatValue);
            giftView.setScaleY(floatValue);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, NewComesNewGiftModel newComesNewGiftModel) {
            Intrinsics.e(helper, "helper");
            ItemNewUserGiftBinding a2 = ItemNewUserGiftBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            int lastIndexOf = getData().lastIndexOf(newComesNewGiftModel);
            if (lastIndexOf == 0) {
                a2.f.setText("第一天");
            } else if (lastIndexOf == 1) {
                a2.f.setText("第二天");
            } else if (lastIndexOf == 2) {
                a2.f.setText("第三天");
            } else if (lastIndexOf == 3) {
                a2.f.setText("第四天");
            }
            a2.f16632a.setBackgroundResource(R.color.transparent);
            if (newComesNewGiftModel == null) {
                return;
            }
            ImageLoader.a(this.f18338a.a(), newComesNewGiftModel.getPic()).a(a2.f16632a);
            TextView textView = a2.d;
            textView.setText(newComesNewGiftModel.getName() + ' ' + newComesNewGiftModel.getDuration() + (char) 22825);
            a2.e.setText(Intrinsics.a("x", (Object) newComesNewGiftModel.getCount()));
            ShapeModel shapeModel = a2.f16633c.getShapeModel();
            shapeModel.q = 0.0f;
            a2.f.setTextColor(a2.d.getResources().getColor(R.color.syc_e84e5d));
            ShapeModel shapeModel2 = a2.f.getShapeModel();
            shapeModel2.k = a2.f.getResources().getColor(R.color.syc_dark_e5e5e5);
            int status = newComesNewGiftModel.getStatus();
            if (status == 0) {
                a2.b.setVisibility(8);
                a2.f16632a.setAlpha(1.0f);
            } else if (status == 1) {
                shapeModel2.k = a2.f.getResources().getColor(R.color.syc_f82645);
                shapeModel.q = a2.f16633c.getResources().getDimensionPixelOffset(R.dimen.dp_1);
                a2.b.setVisibility(4);
                a2.f16632a.setAlpha(1.0f);
                shapeModel2.b = a2.d.getResources().getColor(R.color.white);
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NEW_GIFT_POP_SHOW, getData().lastIndexOf(newComesNewGiftModel) + 1);
                SquareImageView squareImageView = a2.f16632a;
                Intrinsics.c(squareImageView, "bind.iv");
                a(squareImageView);
            } else if (status == 2) {
                a2.b.setImageResource(R.drawable.yy_icon_newcome_ylq);
                a2.b.setVisibility(0);
                a2.f16632a.setAlpha(0.2f);
            } else if (status == 3) {
                a2.b.setImageResource(R.drawable.yy_icon_newcome_sx);
                a2.b.setVisibility(0);
                a2.f16632a.setAlpha(0.2f);
            }
            a2.f16633c.setShapeModel(shapeModel);
            a2.f.setShapeModel(shapeModel2);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(final BaseFragment fragment) {
            Intrinsics.e(fragment, "fragment");
            final ActivityFragmentActive fragmentActive = fragment.getFragmentActive();
            YYRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntityA<NewComesNewGiftModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYNewUserGiftDialog$Companion$loadData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fragmentActive);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<NewComesNewGiftModel> bluedEntityA) {
                    if (bluedEntityA != null && bluedEntityA.hasData()) {
                        List<NewComesNewGiftModel> list = bluedEntityA.data;
                        Intrinsics.c(list, "p0.data");
                        boolean z = false;
                        for (NewComesNewGiftModel newComesNewGiftModel : list) {
                            if (newComesNewGiftModel.getStatus() == 1) {
                                z = true;
                            }
                        }
                        if (z) {
                            YYNewUserGiftDialog yYNewUserGiftDialog = new YYNewUserGiftDialog();
                            yYNewUserGiftDialog.d = bluedEntityA == null ? null : bluedEntityA.data;
                            FragmentManager childFragmentManager = BaseFragment.this.getChildFragmentManager();
                            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
                            yYNewUserGiftDialog.show(childFragmentManager, "YYNewUserGiftDialog");
                        }
                    }
                }
            }, fragment.getFragmentActive());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYNewUserGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYNewUserGiftinsfoDialog yYNewUserGiftinsfoDialog = new YYNewUserGiftinsfoDialog();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYNewUserGiftinsfoDialog.show(childFragmentManager, "YYNewUserGiftinsfoDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final YYNewUserGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final ActivityFragmentActive a2 = this$0.a();
        YYRoomHttpUtils.i(new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.android.module.yy_china.view.YYNewUserGiftDialog$initView$2$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                List list;
                NewComesNewGiftModel newComesNewGiftModel;
                NewComesNewGiftModel newComesNewGiftModel2;
                list = YYNewUserGiftDialog.this.d;
                if (list != null) {
                    YYNewUserGiftDialog yYNewUserGiftDialog = YYNewUserGiftDialog.this;
                    newComesNewGiftModel = yYNewUserGiftDialog.f18337c;
                    int b = CollectionsKt.b((List<? extends NewComesNewGiftModel>) list, newComesNewGiftModel);
                    newComesNewGiftModel2 = yYNewUserGiftDialog.f18337c;
                    yYNewUserGiftDialog.a(newComesNewGiftModel2, Integer.valueOf(b));
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NEW_GIFT_POP_GET_CLICK, b + 1);
                }
                YYNewUserGiftDialog.this.dismissAllowingStateLoss();
            }
        }, this$0.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYNewUserGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        ImageView imageView;
        ShapeTextView shapeTextView;
        ImageView imageView2;
        DialogNewUserGiftBinding dialogNewUserGiftBinding = this.b;
        if (dialogNewUserGiftBinding != null && (imageView2 = dialogNewUserGiftBinding.f16369c) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftDialog$LE6yrTRE_d8OZlGmZ7uWVGJfS-Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYNewUserGiftDialog.a(YYNewUserGiftDialog.this, view);
                }
            });
        }
        DialogNewUserGiftBinding dialogNewUserGiftBinding2 = this.b;
        if (dialogNewUserGiftBinding2 != null && (shapeTextView = dialogNewUserGiftBinding2.e) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftDialog$RxGT1CElGEVOzX_iVc3Mv8MQOMA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYNewUserGiftDialog.b(YYNewUserGiftDialog.this, view);
                }
            });
        }
        DialogNewUserGiftBinding dialogNewUserGiftBinding3 = this.b;
        if (dialogNewUserGiftBinding3 != null && (imageView = dialogNewUserGiftBinding3.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftDialog$J3lhdluqEwjQN_0px21kpqmJqcw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYNewUserGiftDialog.c(YYNewUserGiftDialog.this, view);
                }
            });
        }
        DialogNewUserGiftBinding dialogNewUserGiftBinding4 = this.b;
        RecyclerView recyclerView = dialogNewUserGiftBinding4 == null ? null : dialogNewUserGiftBinding4.d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        CAdapter cAdapter = new CAdapter(this);
        DialogNewUserGiftBinding dialogNewUserGiftBinding5 = this.b;
        RecyclerView recyclerView2 = dialogNewUserGiftBinding5 == null ? null : dialogNewUserGiftBinding5.d;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cAdapter);
        }
        List<NewComesNewGiftModel> list = this.d;
        if (list == null) {
            return;
        }
        cAdapter.setNewData(list);
        for (NewComesNewGiftModel newComesNewGiftModel : list) {
            if (newComesNewGiftModel.getStatus() == 1) {
                this.f18337c = newComesNewGiftModel;
            }
        }
    }

    public final void a(NewComesNewGiftModel newComesNewGiftModel, Integer num) {
        if (newComesNewGiftModel == null) {
            return;
        }
        YYNewUserGiftINfoDialog a2 = new YYNewUserGiftINfoDialog().a(newComesNewGiftModel, num);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        a2.show(childFragmentManager, "YYNewUserGiftINfoDialog");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_new_user_gift, viewGroup, true);
        this.b = DialogNewUserGiftBinding.a(inflate);
        f();
        return inflate;
    }
}
