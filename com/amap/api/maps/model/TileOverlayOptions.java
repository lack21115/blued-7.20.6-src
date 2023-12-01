package com.amap.api.maps.model;

import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/TileOverlayOptions.class */
public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private TileProvider _tileProvider;
    private String diskCacheDir;
    private boolean diskCacheEnabled;
    private long diskCacheSize;
    private TileProviderInner mTileProvider;
    private final int mVersionCode;
    private boolean mVisible;
    private float mZIndex;
    private int memCacheSize;
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = IntentFilter.MATCH_CATEGORY_PATH;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i, boolean z, float f) {
        this.mVisible = true;
        this.memCacheSize = IntentFilter.MATCH_CATEGORY_PATH;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i;
        this.mVisible = z;
        this.mZIndex = f;
        this.type = "TileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z) {
        this.diskCacheEnabled = z;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i) {
        this.diskCacheSize = i * 1024;
        return this;
    }

    public final String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public final TileProvider getTileProvider() {
        return this._tileProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public final float getZIndex() {
        return this.mZIndex;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final TileOverlayOptions memCacheSize(int i) {
        this.memCacheSize = i;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.memoryCacheEnabled = z;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new TileProviderInner(tileProvider);
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.mVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.mZIndex = f;
        return this;
    }
}
