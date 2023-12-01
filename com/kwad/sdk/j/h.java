package com.kwad.sdk.j;

import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/h.class */
public final class h extends Resources {
    private final Resources aDE;

    public h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aDE = resources2;
    }

    private static boolean ak(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean cu(int i) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getAnimation(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getAnimation(i) : super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getBoolean(i) : super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getColor(i) : super.getColor(i);
    }

    public final int getColor(int i, Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getColor(i, theme) : super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDimension(i) : super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDimensionPixelOffset(i) : super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDimensionPixelSize(i) : super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDrawable(i) : super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDrawable(i) : super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDrawableForDensity(i, i2) : super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getDrawableForDensity(i, i2, theme) : super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    public final float getFloat(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getFloat(i) : super.getFloat(i);
    }

    public final Typeface getFont(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getFont(i) : super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getFraction(i, i2, i3) : super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        return ak(str, str3) ? this.aDE.getIdentifier(str, str2, str3) : super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public final int[] getIntArray(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getIntArray(i) : super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getInteger(i) : super.getInteger(i);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getLayout(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getLayout(i) : super.getLayout(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getMovie(i) : super.getMovie(i);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getQuantityString(i, i2) : super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2, Object... objArr) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getQuantityString(i, i2, objArr) : super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int i, int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getQuantityText(i, i2) : super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getResourceEntryName(i) : super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getResourceName(i) : super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getResourcePackageName(i) : super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getResourceTypeName(i) : super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public final String getString(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getString(i) : super.getString(i);
    }

    @Override // android.content.res.Resources
    public final String getString(int i, Object... objArr) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getString(i, objArr) : super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getStringArray(i) : super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getText(i) : super.getText(i);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getText(i, charSequence) : super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getTextArray(i) : super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i));
        if (cu(i)) {
            this.aDE.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, "string", null);
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (cu(identifier)) {
            this.aDE.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i));
        if (cu(i)) {
            this.aDE.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getXml(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.getXml(i) : super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i));
        return cu(i) ? this.aDE.obtainTypedArray(i) : super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.openRawResource(i) : super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.openRawResource(i, typedValue) : super.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i));
        return cu(i) ? this.aDE.openRawResourceFd(i) : super.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }
}
