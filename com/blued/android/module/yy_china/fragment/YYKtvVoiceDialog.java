package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvVoiceBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudioEffectModel;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvVoiceDialog.class */
public final class YYKtvVoiceDialog extends BaseFullScreenDialog {
    private FragmentYyKtvVoiceBinding a;
    private YYMsgKtvMusic b;
    private AudioEffectAdapter c;
    private int d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvVoiceDialog$AudioEffectAdapter.class */
    public final class AudioEffectAdapter extends BaseQuickAdapter<YYAudioEffectModel, BaseViewHolder> {
        final /* synthetic */ YYKtvVoiceDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioEffectAdapter(YYKtvVoiceDialog this$0) {
            super(R.layout.item_audio_effect_layout, (List) null);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYAudioEffectModel yYAudioEffectModel) {
            View view;
            ImageView imageView;
            String str = null;
            ConstraintLayout view2 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.item_ll_root);
            ViewGroup.LayoutParams layoutParams = view2 == null ? null : view2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
            RecyclerView.LayoutParams layoutParams2 = layoutParams;
            Integer valueOf = baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition());
            if (valueOf != null && valueOf.intValue() == 0) {
                layoutParams2.rightMargin = DensityUtils.a(this.a.getContext(), 8.0f);
                layoutParams2.leftMargin = 0;
            } else {
                layoutParams2.leftMargin = DensityUtils.a(this.a.getContext(), 8.0f);
                layoutParams2.rightMargin = DensityUtils.a(this.a.getContext(), 8.0f);
            }
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_effect_name);
            if (textView != null) {
                if (yYAudioEffectModel != null) {
                    str = yYAudioEffectModel.effectName;
                }
                textView.setText(str);
            }
            if (yYAudioEffectModel == null) {
                return;
            }
            if (baseViewHolder != null && (imageView = (ImageView) baseViewHolder.getView(R.id.img_effect_view)) != null) {
                imageView.setImageResource(yYAudioEffectModel.effectImg);
            }
            if (baseViewHolder == null || (view = baseViewHolder.getView(R.id.item_bg)) == null) {
                return;
            }
            view.setBackgroundResource(yYAudioEffectModel.isChecked ? R.drawable.shape_voice_effect_selected : R.drawable.shape_raduis_6_tran10_ffffff);
        }
    }

    private final void a(float f) {
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        TextView textView = fragmentYyKtvVoiceBinding == null ? null : fragmentYyKtvVoiceBinding.q;
        if (textView != null) {
            textView.setText(String.valueOf((int) f));
        }
        float f2 = (float) (f / 12.0d);
        AudioChannelManager.j().a(4443, f2);
        AudioChannelManager.j().a(4444, f2);
    }

    private final void a(int i) {
        AudioEffectAdapter audioEffectAdapter = this.c;
        if (audioEffectAdapter == null) {
            return;
        }
        YYAudioEffectModel yYAudioEffectModel = (YYAudioEffectModel) audioEffectAdapter.getItem(i);
        for (YYAudioEffectModel yYAudioEffectModel2 : audioEffectAdapter.getData()) {
            yYAudioEffectModel2.isChecked = false;
        }
        if (yYAudioEffectModel != null) {
            yYAudioEffectModel.isChecked = true;
        }
        AudioChannelManager.j().g(StringUtils.a(yYAudioEffectModel == null ? null : yYAudioEffectModel.effectId, 0));
        audioEffectAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CompoundButton compoundButton, boolean z) {
        AudioChannelManager.j().b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvVoiceDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvVoiceDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYKtvVoiceDialog this$0, View view) {
        SeekBar seekBar;
        SeekBar seekBar2;
        ToggleButton toggleButton;
        Intrinsics.e(this$0, "this$0");
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this$0.a;
        if ((fragmentYyKtvVoiceBinding == null || (seekBar = fragmentYyKtvVoiceBinding.a) == null || seekBar.getProgress() != 50) ? false : true) {
            FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this$0.a;
            if (((fragmentYyKtvVoiceBinding2 == null || (seekBar2 = fragmentYyKtvVoiceBinding2.b) == null || seekBar2.getProgress() != 100) ? false : true) && AudioChannelManager.j().r() == 0) {
                if (AudioChannelManager.j().q() == 0.0f) {
                    FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding3 = this$0.a;
                    if ((fragmentYyKtvVoiceBinding3 == null || (toggleButton = fragmentYyKtvVoiceBinding3.d) == null || toggleButton.isChecked()) ? false : true) {
                        ToastUtils.a("当前已是默认效果");
                        return;
                    }
                }
            }
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding4 = this$0.a;
        SeekBar seekBar3 = fragmentYyKtvVoiceBinding4 == null ? null : fragmentYyKtvVoiceBinding4.a;
        if (seekBar3 != null) {
            seekBar3.setProgress(50);
        }
        this$0.d = 100;
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding5 = this$0.a;
        SeekBar seekBar4 = fragmentYyKtvVoiceBinding5 == null ? null : fragmentYyKtvVoiceBinding5.b;
        if (seekBar4 != null) {
            seekBar4.setProgress(this$0.d);
        }
        this$0.a(0);
        this$0.a(0.0f);
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding6 = this$0.a;
        ToggleButton toggleButton2 = fragmentYyKtvVoiceBinding6 == null ? null : fragmentYyKtvVoiceBinding6.d;
        if (toggleButton2 != null) {
            toggleButton2.setChecked(false);
        }
        ToastUtils.a("已使用默认效果");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYKtvVoiceDialog this$0, View view) {
        TextView textView;
        Intrinsics.e(this$0, "this$0");
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this$0.a;
        CharSequence charSequence = null;
        if (fragmentYyKtvVoiceBinding != null && (textView = fragmentYyKtvVoiceBinding.q) != null) {
            charSequence = textView.getText();
        }
        float a = StringUtils.a(String.valueOf(charSequence), 0.0f) + 1.0f;
        float f = a;
        if (a > 12.0f) {
            f = 12.0f;
        }
        this$0.a(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYKtvVoiceDialog this$0, View view) {
        TextView textView;
        Intrinsics.e(this$0, "this$0");
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this$0.a;
        CharSequence charSequence = null;
        if (fragmentYyKtvVoiceBinding != null && (textView = fragmentYyKtvVoiceBinding.q) != null) {
            charSequence = textView.getText();
        }
        float a = StringUtils.a(String.valueOf(charSequence), 0.0f) - 1.0f;
        float f = a;
        if (a < -12.0f) {
            f = -12.0f;
        }
        this$0.a(f);
    }

    private final void f() {
        ToggleButton toggleButton;
        ShapeTextView shapeTextView;
        View view;
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        if (fragmentYyKtvVoiceBinding != null && (view = fragmentYyKtvVoiceBinding.g) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$YzlR37Fk3HNPY2GbwnZ1nnlm_NE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvVoiceDialog.a(YYKtvVoiceDialog.this, view2);
                }
            });
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this.a;
        if (fragmentYyKtvVoiceBinding2 != null && (shapeTextView = fragmentYyKtvVoiceBinding2.e) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$3n4pDwKfdPRhGieV9JFAk27yf_A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvVoiceDialog.b(YYKtvVoiceDialog.this, view2);
                }
            });
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding3 = this.a;
        ToggleButton toggleButton2 = fragmentYyKtvVoiceBinding3 == null ? null : fragmentYyKtvVoiceBinding3.d;
        if (toggleButton2 != null) {
            toggleButton2.setChecked(AudioChannelManager.j().p());
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding4 = this.a;
        if (fragmentYyKtvVoiceBinding4 != null && (toggleButton = fragmentYyKtvVoiceBinding4.d) != null) {
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$-72hc_vX7DAqvJSQtB_i0f_7M7M
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    YYKtvVoiceDialog.a(compoundButton, z);
                }
            });
        }
        h();
        g();
        i();
        j();
    }

    private final void g() {
        SeekBar seekBar;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        YYMsgKtvMusic yYMsgKtvMusic = this.b;
        booleanRef.a = TextUtils.equals(r0, yYMsgKtvMusic == null ? null : yYMsgKtvMusic.isOriginal);
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        SeekBar seekBar2 = fragmentYyKtvVoiceBinding == null ? null : fragmentYyKtvVoiceBinding.a;
        if (seekBar2 != null) {
            seekBar2.setProgress(booleanRef.a ? AudioChannelManager.j().f() : AudioChannelManager.j().g());
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this.a;
        if (fragmentYyKtvVoiceBinding2 == null || (seekBar = fragmentYyKtvVoiceBinding2.a) == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYKtvVoiceDialog$initAccompany$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar3, int i, boolean z) {
                YYMsgKtvMusic yYMsgKtvMusic2;
                yYMsgKtvMusic2 = YYKtvVoiceDialog.this.b;
                if (yYMsgKtvMusic2 == null) {
                    return;
                }
                if (booleanRef.a) {
                    AudioChannelManager.j().a(true, i);
                } else {
                    AudioChannelManager.j().a(false, i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar3) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar3) {
                Tracker.onStopTrackingTouch(seekBar3);
            }
        });
    }

    private final void h() {
        SeekBar seekBar;
        if (YYRoomInfoManager.e().a == null) {
            YYRoomInfoManager.e().a = new YYUserInfo();
            YYRoomInfoManager.e().a.setUid(YYRoomInfoManager.e().k());
            YYRoomInfoManager.e().a.setName(YYRoomInfoManager.e().l());
            YYRoomInfoManager.e().a.setAvatar(YYRoomInfoManager.e().m());
        }
        int i = YYRoomInfoManager.e().a.is_open_mic;
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        SeekBar seekBar2 = fragmentYyKtvVoiceBinding == null ? null : fragmentYyKtvVoiceBinding.b;
        if (seekBar2 != null) {
            seekBar2.setMax(100);
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this.a;
        SeekBar seekBar3 = fragmentYyKtvVoiceBinding2 == null ? null : fragmentYyKtvVoiceBinding2.b;
        if (seekBar3 != null) {
            seekBar3.setProgress(AudioChannelManager.j().h());
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding3 = this.a;
        if (fragmentYyKtvVoiceBinding3 == null || (seekBar = fragmentYyKtvVoiceBinding3.b) == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYKtvVoiceDialog$initVolume$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int i2, boolean z) {
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                if (yYUserInfo != null && yYUserInfo.is_open_mic == 0) {
                    AudioChannelManager.j().f(i2);
                } else {
                    AudioChannelManager.j().e(i2);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar4) {
                Tracker.onStopTrackingTouch(seekBar4);
            }
        });
    }

    private final void i() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        RecyclerView recyclerView = fragmentYyKtvVoiceBinding == null ? null : fragmentYyKtvVoiceBinding.k;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.c = new AudioEffectAdapter(this);
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this.a;
        RecyclerView recyclerView2 = fragmentYyKtvVoiceBinding2 == null ? null : fragmentYyKtvVoiceBinding2.k;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.c);
        }
        AudioEffectAdapter audioEffectAdapter = this.c;
        if (audioEffectAdapter != null) {
            audioEffectAdapter.setNewData(k());
        }
        AudioEffectAdapter audioEffectAdapter2 = this.c;
        if (audioEffectAdapter2 == null) {
            return;
        }
        audioEffectAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$92vJvM3Fe_Sxr8HsteMVcL9iEFA
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYKtvVoiceDialog.a(YYKtvVoiceDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    private final void j() {
        ImageView imageView;
        ImageView imageView2;
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding = this.a;
        TextView textView = fragmentYyKtvVoiceBinding == null ? null : fragmentYyKtvVoiceBinding.q;
        if (textView != null) {
            textView.setText(String.valueOf((int) (AudioChannelManager.j().q() * 12)));
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding2 = this.a;
        if (fragmentYyKtvVoiceBinding2 != null && (imageView2 = fragmentYyKtvVoiceBinding2.f) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$1vUdBfKqTxkewQrX2bYhvlIG38w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYKtvVoiceDialog.c(YYKtvVoiceDialog.this, view);
                }
            });
        }
        FragmentYyKtvVoiceBinding fragmentYyKtvVoiceBinding3 = this.a;
        if (fragmentYyKtvVoiceBinding3 == null || (imageView = fragmentYyKtvVoiceBinding3.c) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvVoiceDialog$_Ko7WoSYYLVj62zpz5dir8cojks
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYKtvVoiceDialog.d(YYKtvVoiceDialog.this, view);
            }
        });
    }

    private final List<YYAudioEffectModel> k() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        String[] stringArray = (context == null || (resources = context.getResources()) == null) ? null : resources.getStringArray(R.array.audio_effect_type);
        Context context2 = getContext();
        String[] stringArray2 = (context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getStringArray(R.array.audio_effect_name);
        Context context3 = getContext();
        TypedArray obtainTypedArray = (context3 == null || (resources3 = context3.getResources()) == null) ? null : resources3.obtainTypedArray(R.array.audio_effect_url);
        if (stringArray != null) {
            int length = stringArray.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                YYAudioEffectModel yYAudioEffectModel = new YYAudioEffectModel();
                yYAudioEffectModel.effectId = stringArray[i2];
                Integer valueOf = stringArray2 == null ? null : Integer.valueOf(stringArray2.length);
                Intrinsics.a(valueOf);
                if (i2 < valueOf.intValue()) {
                    yYAudioEffectModel.effectName = stringArray2[i2];
                }
                if (obtainTypedArray != null) {
                    yYAudioEffectModel.effectImg = obtainTypedArray.getResourceId(i2, 0);
                }
                yYAudioEffectModel.isChecked = AudioChannelManager.j().r() == StringUtils.a(yYAudioEffectModel.effectId, 0);
                arrayList.add(yYAudioEffectModel);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_voice, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…v_voice, container, true)");
        this.a = FragmentYyKtvVoiceBinding.a(inflate);
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.b = b == null ? null : b.music;
        f();
        return inflate;
    }
}
