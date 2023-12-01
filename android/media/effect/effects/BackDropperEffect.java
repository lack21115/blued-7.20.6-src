package android.media.effect.effects;

import android.filterfw.core.OneShotScheduler;
import android.filterpacks.videoproc.BackDropperFilter;
import android.media.effect.EffectContext;
import android.media.effect.EffectUpdateListener;
import android.media.effect.FilterGraphEffect;
import android.provider.MediaStore;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/BackDropperEffect.class */
public class BackDropperEffect extends FilterGraphEffect {
    private static final String mGraphDefinition = "@import android.filterpacks.base;\n@import android.filterpacks.videoproc;\n@import android.filterpacks.videosrc;\n\n@filter GLTextureSource foreground {\n  texId = 0;\n  width = 0;\n  height = 0;\n  repeatFrame = true;\n}\n\n@filter MediaSource background {\n  sourceUrl = \"no_file_specified\";\n  waitForNewFrame = false;\n  sourceIsUrl = true;\n}\n\n@filter BackDropperFilter replacer {\n  autowbToggle = 1;\n}\n\n@filter GLTextureTarget output {\n  texId = 0;\n}\n\n@connect foreground[frame]  => replacer[video];\n@connect background[video]  => replacer[background];\n@connect replacer[video]    => output[frame];\n";
    private EffectUpdateListener mEffectListener;
    private BackDropperFilter.LearningDoneListener mLearningListener;

    public BackDropperEffect(EffectContext effectContext, String str) {
        super(effectContext, str, mGraphDefinition, "foreground", MediaStore.EXTRA_OUTPUT, OneShotScheduler.class);
        this.mEffectListener = null;
        this.mLearningListener = new BackDropperFilter.LearningDoneListener() { // from class: android.media.effect.effects.BackDropperEffect.1
            @Override // android.filterpacks.videoproc.BackDropperFilter.LearningDoneListener
            public void onLearningDone(BackDropperFilter backDropperFilter) {
                if (BackDropperEffect.this.mEffectListener != null) {
                    BackDropperEffect.this.mEffectListener.onEffectUpdated(BackDropperEffect.this, null);
                }
            }
        };
        this.mGraph.getFilter("replacer").setInputValue("learningDoneListener", this.mLearningListener);
    }

    @Override // android.media.effect.FilterGraphEffect, android.media.effect.Effect
    public void setParameter(String str, Object obj) {
        if (str.equals("source")) {
            this.mGraph.getFilter("background").setInputValue("sourceUrl", obj);
        } else if (str.equals("context")) {
            this.mGraph.getFilter("background").setInputValue("context", obj);
        }
    }

    @Override // android.media.effect.Effect
    public void setUpdateListener(EffectUpdateListener effectUpdateListener) {
        this.mEffectListener = effectUpdateListener;
    }
}
