package com.kwad.sdk.service.kwai;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/service/kwai/g.class */
public interface g {
    void load(Context context, ImageView imageView, Object obj, int i, int i2);

    void load(ImageView imageView, Object obj);

    void load(ImageView imageView, Object obj, AdTemplate adTemplate);

    void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2);

    void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2, float f);
}
