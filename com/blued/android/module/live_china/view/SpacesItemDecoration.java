package com.blued.android.module.live_china.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/SpacesItemDecoration.class */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private int c;
    private int d;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private int m = 0;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/SpacesItemDecoration$ItemPos.class */
    interface ItemPos {
    }

    public SpacesItemDecoration(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    private int a(int i, int i2, int i3) {
        if (i2 != -1) {
            if (i3 <= i2) {
                return 9;
            }
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
            int i5 = i3 % i2;
            return i5 == 0 ? i3 - i4 < i2 ? 8 : 10 : i3 - i4 < i5 ? 8 : 10;
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
            int i = this.m;
            boolean z8 = false;
            if (i == 5) {
                switch (a(childAdapterPosition, a, itemCount)) {
                    case 5:
                        int b = b(childAdapterPosition, a, itemCount);
                        if (b == 1) {
                            z = true;
                        } else if (b == 2) {
                            z = false;
                            z2 = true;
                            z3 = z2;
                            z5 = true;
                            break;
                        } else {
                            z = false;
                        }
                        z2 = false;
                        z3 = z2;
                        z5 = true;
                    case 6:
                        z3 = false;
                        z4 = b(childAdapterPosition, a, itemCount) == 3;
                        z = true;
                        z5 = false;
                        break;
                    case 7:
                        z4 = b(childAdapterPosition, a, itemCount) == 4;
                        z = false;
                        z3 = true;
                        z5 = false;
                        break;
                    case 8:
                        z = false;
                        z3 = false;
                        z7 = false;
                        z5 = z7;
                        z4 = true;
                        break;
                    case 9:
                        int b2 = b(childAdapterPosition, a, itemCount);
                        if (b2 != 1) {
                            z6 = b2 == 2;
                        } else {
                            z6 = false;
                            z8 = true;
                        }
                        z3 = z6;
                        z = z8;
                        z7 = true;
                        z5 = z7;
                        z4 = true;
                        break;
                    default:
                        z = false;
                        z3 = false;
                        z5 = false;
                        break;
                }
                a(rect, z, z3, z5, z4);
            }
            if (itemCount == 1) {
                if (i == 1) {
                    z = false;
                    z3 = false;
                    z7 = true;
                    z5 = z7;
                    z4 = true;
                    a(rect, z, z3, z5, z4);
                }
                z = true;
            } else if (childAdapterPosition != 0) {
                if (recyclerView.getChildAdapterPosition(view) == itemCount - 1) {
                    if (this.m != 1) {
                        z = false;
                    }
                    z = false;
                    z3 = false;
                    z7 = false;
                    z5 = z7;
                    z4 = true;
                    a(rect, z, z3, z5, z4);
                }
                z = false;
                z3 = false;
                z5 = false;
            } else if (i == 1) {
                z = false;
                z3 = false;
                z5 = true;
            } else {
                z = true;
                z3 = false;
                z5 = false;
            }
            z3 = true;
            z5 = false;
            z4 = false;
            a(rect, z, z3, z5, z4);
        }
    }
}
