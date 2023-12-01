package com.blued.android.module.shortvideo.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/widget/SpacesItemDecoration.class */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/widget/SpacesItemDecoration$ItemPos.class */
    interface ItemPos {
    }

    public SpacesItemDecoration(int i) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.m = 0;
        this.n = -1;
        this.d = i;
        this.c = i;
        this.b = i;
        this.a = i;
    }

    public SpacesItemDecoration(int i, int i2) {
        this(i, i2, -1);
    }

    public SpacesItemDecoration(int i, int i2, int i3) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.m = 0;
        this.n = -1;
        this.d = i2;
        this.c = i2;
        this.b = i2;
        this.a = i2;
        a(i);
        this.n = i3;
    }

    private int a(int i, int i2, int i3) {
        if (i2 != -1) {
            if (i3 > i2 || this.n - 1 > i2) {
                if (i < i2) {
                    return 5;
                }
                if (i % i2 == 0) {
                    return 6;
                }
                int i4 = i + 1;
                if (i4 % i2 == 0) {
                    return 7;
                }
                int i5 = this.n;
                if (i5 != -1) {
                    i3 = i5;
                }
                int i6 = i3 % i2;
                return i6 == 0 ? i3 - i4 < i2 ? 8 : 10 : i3 - i4 < i6 ? 8 : 10;
            }
            return 9;
        }
        return 10;
    }

    private int a(RecyclerView recyclerView) {
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return layoutManager.getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private void a(Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            rect.left = this.a;
        } else if (this.e) {
            rect.left = this.a + this.i;
        }
        if (!z2) {
            rect.right = this.c;
        } else if (this.g) {
            rect.right = this.c + this.j;
        }
        if (!z3) {
            rect.top = this.b;
        } else if (this.f) {
            rect.top = this.b + this.k;
        }
        if (!z4) {
            rect.bottom = this.d;
        } else if (this.h) {
            rect.bottom = this.d + this.l;
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 != -1) {
            if (i < i2) {
                if (i == 0) {
                    return 1;
                }
                return i == i2 - 1 ? 2 : 10;
            } else if (i % i2 == 0) {
                return i3 - (i + 1) < i2 ? 3 : 10;
            } else {
                int i4 = i + 1;
                return (i4 % i2 == 0 && i3 == i4) ? 4 : 10;
            }
        }
        return 10;
    }

    public void a(int i) {
        if (i != 0 && i != 1 && i != 5) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.m = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i = i;
        this.k = i2;
        this.j = i3;
        this.l = i4;
    }

    public void a(boolean z, boolean z2) {
        this.e = z;
        this.g = z2;
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int a = a(recyclerView);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = true;
            if (this.m == 5) {
                switch (a(childAdapterPosition, a, itemCount)) {
                    case 5:
                        int b = b(childAdapterPosition, a, itemCount);
                        if (b == 1) {
                            z = true;
                        } else if (b == 2) {
                            z = false;
                            z2 = true;
                            z3 = true;
                            z4 = false;
                            break;
                        } else {
                            z = false;
                        }
                        z2 = false;
                        z3 = true;
                        z4 = false;
                    case 6:
                        z2 = false;
                        z4 = b(childAdapterPosition, a, itemCount) == 3;
                        z = true;
                        z3 = false;
                        break;
                    case 7:
                        z4 = b(childAdapterPosition, a, itemCount) == 4;
                        z = false;
                        z2 = true;
                        z3 = false;
                        break;
                    case 8:
                        z = false;
                        z2 = false;
                        z3 = false;
                        z4 = true;
                        break;
                    case 9:
                        int b2 = b(childAdapterPosition, a, itemCount);
                        if (b2 != 1) {
                            z5 = b2 == 2;
                        } else {
                            z5 = false;
                            z8 = true;
                        }
                        boolean z11 = z5;
                        z = z8;
                        z2 = z11;
                        z3 = true;
                        z4 = true;
                        break;
                    default:
                        z = false;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        break;
                }
            } else {
                int i = this.n;
                if (i != -1) {
                    itemCount = i;
                }
                if (itemCount != 1) {
                    if (childAdapterPosition == 0) {
                        if (this.m == 1) {
                            z6 = true;
                        } else {
                            z6 = false;
                            z7 = false;
                            z9 = true;
                            z10 = false;
                        }
                    } else if (recyclerView.getChildAdapterPosition(view) != itemCount - 1) {
                        z6 = false;
                    } else if (this.m == 1) {
                        z6 = false;
                        z7 = true;
                        z10 = false;
                    } else {
                        z6 = false;
                        z7 = false;
                        z9 = false;
                    }
                    z7 = false;
                    z10 = false;
                } else if (this.m == 1) {
                    z6 = true;
                    z7 = true;
                    z10 = false;
                } else {
                    z6 = false;
                    z7 = false;
                    z9 = true;
                }
                boolean z12 = z6;
                boolean z13 = z7;
                z = z9;
                z2 = z10;
                z3 = z12;
                z4 = z13;
            }
            a(rect, z, z2, z3, z4);
        }
    }
}
