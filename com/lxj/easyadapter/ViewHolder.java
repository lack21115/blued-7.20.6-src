package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/ViewHolder.class */
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f23936a = new Companion(null);
    private final SparseArray<View> b;

    /* renamed from: c  reason: collision with root package name */
    private final View f23937c;

    @Metadata
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/ViewHolder$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewHolder a(Context context, ViewGroup parent, int i) {
            Intrinsics.d(context, "context");
            Intrinsics.d(parent, "parent");
            View itemView = LayoutInflater.from(context).inflate(i, parent, false);
            Intrinsics.b(itemView, "itemView");
            return new ViewHolder(itemView);
        }

        public final ViewHolder a(View itemView) {
            Intrinsics.d(itemView, "itemView");
            return new ViewHolder(itemView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(View convertView) {
        super(convertView);
        Intrinsics.d(convertView, "convertView");
        this.f23937c = convertView;
        this.b = new SparseArray<>();
    }

    public final View a() {
        return this.f23937c;
    }
}
