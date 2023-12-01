package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogSelectTopicBinding;
import com.blued.android.module.yy_china.databinding.ItemTopicTypeBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.TopicSetInfoMode;
import com.blued.android.module.yy_china.model.TopicTypeListMode;
import com.blued.android.module.yy_china.model.TopicTypeMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.TopicListDialog;
import com.blued.android.module.yy_china.view.YYTopicListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/TopicListDialog.class */
public final class TopicListDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogSelectTopicBinding f18012a;

    /* renamed from: c  reason: collision with root package name */
    private TopicTypeListMode f18013c;
    private int e;
    private final Ad b = new Ad(this);
    private String d = "";

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/TopicListDialog$Ad.class */
    public final class Ad extends BaseQuickAdapter<TopicTypeMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TopicListDialog f18014a;
        private String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(TopicListDialog this$0) {
            super(R.layout.item_topic_type);
            Intrinsics.e(this$0, "this$0");
            this.f18014a = this$0;
            this.b = "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ad this$0, TopicTypeMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.b = item.getTheme_id();
            this$0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final TopicTypeMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            ItemTopicTypeBinding a2 = ItemTopicTypeBinding.a(helper.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.f16668a.setText(item.getTheme_name());
            if (Intrinsics.a((Object) this.b, (Object) item.getTheme_id())) {
                a2.b.setVisibility(0);
                this.f18014a.a(item);
            } else {
                a2.b.setVisibility(8);
            }
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$Ad$Tu6GH4yEyPox8Zl-uSoFGFcgSjY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopicListDialog.Ad.a(TopicListDialog.Ad.this, item, view);
                }
            });
        }

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            this.b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TopicListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TopicListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TopicListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TopicListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h().g.getRanTopic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogSelectTopicBinding h() {
        DialogSelectTopicBinding dialogSelectTopicBinding = this.f18012a;
        Intrinsics.a(dialogSelectTopicBinding);
        return dialogSelectTopicBinding;
    }

    private final void i() {
        h().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$ps_do6UH3Pf7whyqn2AZG_f8vis
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.a(TopicListDialog.this, view);
            }
        });
        h().f16408c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$bwTOUyCw4azBOdqS4ABpcrj63-Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.b(TopicListDialog.this, view);
            }
        });
        h().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$G3eqLbu80Cqp8Wtk8oB8tEk3KJU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.a(view);
            }
        });
        h().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$ILuQGHMRy2E5CJLUzcwdLi5GJE4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.b(view);
            }
        });
        h().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$EMEIB06P5Sc7BYnjahsdBA0kx2o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.c(TopicListDialog.this, view);
            }
        });
        h().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$ezZHNTY2Z-TLey-FQCJz1-lPtrs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicListDialog.d(TopicListDialog.this, view);
            }
        });
        h().f.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        h().f.setAdapter(this.b);
        EnglishCharFilter englishCharFilter = new EnglishCharFilter(60);
        englishCharFilter.a(new EnglishCharFilter.OnEnglishCharFilterToMaxLenListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$TopicListDialog$du-RLVhG_fbU9CLpufUY0yYgNgw
            @Override // com.blued.android.module.yy_china.utils.EnglishCharFilter.OnEnglishCharFilterToMaxLenListener
            public final void onMaxLen() {
                TopicListDialog.k();
            }
        });
        h().f16407a.setFilters(new InputFilter[]{englishCharFilter});
        h().f16407a.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.yy_china.view.TopicListDialog$initView$8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DialogSelectTopicBinding h;
                DialogSelectTopicBinding h2;
                DialogSelectTopicBinding h3;
                DialogSelectTopicBinding h4;
                DialogSelectTopicBinding h5;
                DialogSelectTopicBinding h6;
                Intrinsics.e(s, "s");
                if (s.length() > 0) {
                    h5 = TopicListDialog.this.h();
                    h5.i.setVisibility(8);
                    h6 = TopicListDialog.this.h();
                    h6.h.setVisibility(0);
                } else {
                    h = TopicListDialog.this.h();
                    h.i.setVisibility(0);
                    h2 = TopicListDialog.this.h();
                    h2.h.setVisibility(8);
                }
                if (" ".equals(s.toString())) {
                    h3 = TopicListDialog.this.h();
                    h3.i.setVisibility(0);
                    h4 = TopicListDialog.this.h();
                    h4.h.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                DialogSelectTopicBinding h;
                if (" ".equals(String.valueOf(charSequence))) {
                    h = TopicListDialog.this.h();
                    h.f16407a.setText("");
                }
            }
        });
        h().g.setOnClickTopic(new YYTopicListView.OnCLickTopicListener() { // from class: com.blued.android.module.yy_china.view.TopicListDialog$initView$9
            @Override // com.blued.android.module.yy_china.view.YYTopicListView.OnCLickTopicListener
            public void a(TopicTypeListMode topic) {
                DialogSelectTopicBinding h;
                DialogSelectTopicBinding h2;
                Intrinsics.e(topic, "topic");
                TopicListDialog.this.f18013c = topic;
                h = TopicListDialog.this.h();
                h.f16407a.setText(topic.getTopic());
                h2 = TopicListDialog.this.h();
                h2.f16407a.clearFocus();
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.c(ChatRoomProtos.Event.YY_TOPIC_CLICK, b.room_id, b.uid, b.topic_set_info != null ? b.topic_set_info.getTopic_id() : "");
        }
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntityA<TopicTypeMode>>(a2) { // from class: com.blued.android.module.yy_china.view.TopicListDialog$initView$11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<TopicTypeMode> bluedEntityA) {
                TopicListDialog.Ad ad;
                TopicSetInfoMode topicSetInfoMode;
                TopicListDialog.Ad ad2;
                TopicListDialog.Ad ad3;
                if (bluedEntityA == null) {
                    return;
                }
                TopicListDialog topicListDialog = TopicListDialog.this;
                if (bluedEntityA.data.size() > 0) {
                    ad = topicListDialog.b;
                    ad.setNewData(bluedEntityA.data);
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 == null || (topicSetInfoMode = b2.topic_set_info) == null) {
                        return;
                    }
                    ad2 = topicListDialog.b;
                    ad2.a(topicSetInfoMode.getTheme_id());
                    ad3 = topicListDialog.b;
                    ad3.notifyDataSetChanged();
                }
            }
        }, a());
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.String] */
    private final void j() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        final String obj = h().f16407a.getText().toString();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = "0";
        TopicTypeListMode topicTypeListMode = this.f18013c;
        if (topicTypeListMode != null && Intrinsics.a((Object) topicTypeListMode.getTopic(), (Object) obj)) {
            objectRef.f42545a = topicTypeListMode.getId();
        }
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.c(b.room_id, this.d, obj, (String) objectRef.f42545a, new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.android.module.yy_china.view.TopicListDialog$clickItem$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                TopicSetInfoMode topicSetInfoMode;
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (b2 != null && (topicSetInfoMode = b2.topic_set_info) != null) {
                    String str = obj;
                    TopicListDialog topicListDialog = TopicListDialog.this;
                    Ref.ObjectRef<String> objectRef2 = objectRef;
                    topicSetInfoMode.setTopic(str);
                    topicSetInfoMode.setTheme_id(topicListDialog.f());
                    topicSetInfoMode.setTopic_id(objectRef2.f42545a);
                }
                TopicListDialog.this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 4034010) {
                    ToastUtils.a(str, 0);
                }
                return super.onUIFailure(i, str);
            }
        }, a());
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null) {
            return;
        }
        EventTrackYY.c(ChatRoomProtos.Event.YY_TOPIC_SETTINGS_DONE_CLICK, b2.room_id, b2.uid, (String) objectRef.f42545a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        ToastUtils.a("已超出最大编辑字数", 0);
    }

    public final void a(TopicTypeMode item) {
        TopicSetInfoMode topicSetInfoMode;
        Intrinsics.e(item, "item");
        this.d = item.getTheme_id();
        h().f16407a.setText("");
        ArrayList<TopicTypeListMode> topic_lists = item.getTopic_lists();
        if (topic_lists != null) {
            for (TopicTypeListMode topicTypeListMode : topic_lists) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null && (topicSetInfoMode = b.topic_set_info) != null && "1".equals(topicTypeListMode.is_default())) {
                    if (g() != 0) {
                        h().f16407a.setText(topicTypeListMode.getTopic());
                    } else if (topicTypeListMode.getTopic().equals(topicSetInfoMode.getTopic())) {
                        h().f16407a.setText(topicTypeListMode.getTopic());
                    } else {
                        h().f16407a.setText(topicSetInfoMode.getTopic());
                    }
                }
            }
            h().g.a(item.getTopic_lists());
            h().g.a(h().f16407a.getText().toString());
        }
        this.e++;
        this.f18013c = null;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final String f() {
        return this.d;
    }

    public final int g() {
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18012a = DialogSelectTopicBinding.a(inflater.inflate(R.layout.dialog_select_topic, viewGroup, true));
        i();
        return h().getRoot();
    }
}
