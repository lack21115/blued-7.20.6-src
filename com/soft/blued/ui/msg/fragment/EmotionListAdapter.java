package com.soft.blued.ui.msg.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.EmotionListItemModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionListAdapter.class */
public class EmotionListAdapter extends CommonAdapter<EmotionListItemModel> {
    public int d;
    private EmotionAdapterListener e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionListAdapter$EmotionAdapterListener.class */
    public interface EmotionAdapterListener {
        void a(EmotionListItemModel emotionListItemModel);
    }

    public EmotionListAdapter(int i, EmotionAdapterListener emotionAdapterListener) {
        super(i);
        this.d = this.d;
        this.e = emotionAdapterListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EmotionListItemModel emotionListItemModel, View view) {
        Tracker.onClick(view);
        a(emotionListItemModel.emotion_id, emotionListItemModel.code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(EmotionListItemModel emotionListItemModel, View view) {
        Tracker.onClick(view);
        b(emotionListItemModel);
    }

    private boolean b() {
        String language = LocaleUtils.c().getLanguage();
        String country = LocaleUtils.c().getCountry();
        if (a.V.equalsIgnoreCase(language)) {
            return "tw".equalsIgnoreCase(country) || "hk".equalsIgnoreCase(country);
        }
        return false;
    }

    private String c(EmotionListItemModel emotionListItemModel) {
        String str = c() ? emotionListItemModel.name_en : b() ? emotionListItemModel.name_zh_tw : null;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = emotionListItemModel.name;
        }
        return str2;
    }

    private boolean c() {
        return "en".equalsIgnoreCase(LocaleUtils.c().getLanguage());
    }

    private String d(EmotionListItemModel emotionListItemModel) {
        String str = c() ? emotionListItemModel.description_en : b() ? emotionListItemModel.description_zh_tw : null;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = emotionListItemModel.description;
        }
        return str2;
    }

    public String a(EmotionListItemModel emotionListItemModel) {
        if (emotionListItemModel.downloadState != 3) {
            return emotionListItemModel.downloadState == 2 ? this.f10437a.getString(2131887694) : emotionListItemModel.downloadState == 1 ? this.f10437a.getString(2131887690) : this.f10437a.getString(2131887695);
        }
        int i = this.d;
        return (i == 1 || i == 2) ? this.f10437a.getString(2131887700) : this.f10437a.getString(2131887693);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(int i, String str) {
        EmotionDetailFragment.a(this.f10437a, i, str);
    }

    @Override // com.blued.android.module.common.adapter.CommonAdapter
    public void a(CommonAdapter.ViewHolder viewHolder, final EmotionListItemModel emotionListItemModel, int i) {
        CommonAdapter.ViewHolder b = viewHolder.c(R.id.item_emotion_iv, emotionListItemModel.icon).a(R.id.item_emotion_name, c(emotionListItemModel)).a(R.id.item_emotion_des, d(emotionListItemModel)).a(R.id.item_emotion_btn, a(emotionListItemModel)).b(R.id.item_emotion_btn_cv, this.d == 2 ? 8 : 0);
        int i2 = 8;
        if (this.d == 2) {
            i2 = 0;
        }
        b.b(R.id.item_emotion_arrow_iv, i2).a(R.id.item_emotion_btn, new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionListAdapter$kqoYwAxFg3mSOGcf0yiKo81Jrzo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionListAdapter.this.b(emotionListItemModel, view);
            }
        }).a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionListAdapter$7MfKM1B6S8uAZnXatiiQGdRs0wI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionListAdapter.this.a(emotionListItemModel, view);
            }
        });
        CardView cardView = (CardView) viewHolder.a(R.id.item_emotion_btn_cv);
        TextView textView = (TextView) viewHolder.a(R.id.item_emotion_btn);
        if (emotionListItemModel.downloadState == 3) {
            cardView.setCardBackgroundColor(BluedSkinUtils.a(this.f10437a, 2131102360));
            textView.setTextColor(this.f10437a.getResources().getColor(2131102263));
            return;
        }
        cardView.setCardBackgroundColor(BluedSkinUtils.a(this.f10437a, 2131101766));
        textView.setTextColor(this.f10437a.getResources().getColor(2131102478));
    }

    public void b(EmotionListItemModel emotionListItemModel) {
        EmotionAdapterListener emotionAdapterListener = this.e;
        if (emotionAdapterListener != null) {
            emotionAdapterListener.a(emotionListItemModel);
        }
    }
}
