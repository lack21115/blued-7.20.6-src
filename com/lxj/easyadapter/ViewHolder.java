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
    public static final Companion f10325a = new Companion(null);
    private final SparseArray<View> b;

    /* renamed from: c  reason: collision with root package name */
    private final View f10326c;

    @Metadata
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/ViewHolder$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewHolder a(Context context, ViewGroup viewGroup, int i) {
            Intrinsics.d(context, "context");
            Intrinsics.d(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
            Intrinsics.b(inflate, "itemView");
            return new ViewHolder(inflate);
        }

        public final ViewHolder a(View view) {
            Intrinsics.d(view, "itemView");
            return new ViewHolder(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(View view) {
        super(view);
        Intrinsics.d(view, "convertView");
        this.f10326c = view;
        this.b = new SparseArray<>();
    }

    public final View a() {
        return this.f10326c;
    }
}
