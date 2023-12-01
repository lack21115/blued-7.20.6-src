package android.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/view/GhostView.class */
public class GhostView extends View {
    private boolean mBeingMoved;
    private int mReferences;
    private final View mView;

    private GhostView(View view) {
        super(view.getContext());
        this.mView = view;
        this.mView.mGhostView = this;
        ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
        setGhostedVisibility(4);
        viewGroup.mRecreateDisplayList = true;
        viewGroup.getDisplayList();
    }

    public static GhostView addGhost(View view, ViewGroup viewGroup) {
        return addGhost(view, viewGroup, null);
    }

    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostView ghostView;
        if (view.getParent() instanceof ViewGroup) {
            ViewGroupOverlay overlay = viewGroup.getOverlay();
            ViewOverlay.OverlayViewGroup overlayViewGroup = overlay.mOverlayViewGroup;
            GhostView ghostView2 = view.mGhostView;
            GhostView ghostView3 = ghostView2;
            int i = 0;
            if (ghostView2 != null) {
                View view2 = (View) ghostView2.getParent();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                ghostView3 = ghostView2;
                i = 0;
                if (viewGroup2 != overlayViewGroup) {
                    i = ghostView2.mReferences;
                    viewGroup2.removeView(view2);
                    ghostView3 = null;
                }
            }
            if (ghostView3 == null) {
                Matrix matrix2 = matrix;
                if (matrix == null) {
                    matrix2 = new Matrix();
                    calculateMatrix(view, viewGroup, matrix2);
                }
                GhostView ghostView4 = new GhostView(view);
                ghostView4.setMatrix(matrix2);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setClipChildren(false);
                copySize(viewGroup, frameLayout);
                copySize(viewGroup, ghostView4);
                frameLayout.addView(ghostView4);
                ArrayList arrayList = new ArrayList();
                insertIntoOverlay(overlay.mOverlayViewGroup, frameLayout, ghostView4, arrayList, moveGhostViewsToTop(overlay.mOverlayViewGroup, arrayList));
                ghostView4.mReferences = i;
                ghostView = ghostView4;
            } else {
                ghostView = ghostView3;
                if (matrix != null) {
                    ghostView3.setMatrix(matrix);
                    ghostView = ghostView3;
                }
            }
            ghostView.mReferences++;
            return ghostView;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        viewGroup2.transformMatrixToGlobal(matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        viewGroup.transformMatrixToLocal(matrix);
    }

    private static void copySize(View view, View view2) {
        view2.setLeft(0);
        view2.setTop(0);
        view2.setRight(view.getWidth());
        view2.setBottom(view.getHeight());
    }

    public static GhostView getGhost(View view) {
        return view.mGhostView;
    }

    private static int getInsertIndex(ViewGroup viewGroup, ArrayList<View> arrayList, ArrayList<View> arrayList2, int i) {
        int childCount = viewGroup.getChildCount() - 1;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            getParents(((GhostView) ((ViewGroup) viewGroup.getChildAt(i2)).getChildAt(0)).mView, arrayList2);
            if (isOnTop(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static void insertIntoOverlay(ViewGroup viewGroup, ViewGroup viewGroup2, GhostView ghostView, ArrayList<View> arrayList, int i) {
        if (i == -1) {
            viewGroup.addView(viewGroup2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        getParents(ghostView.mView, arrayList2);
        int insertIndex = getInsertIndex(viewGroup, arrayList2, arrayList, i);
        if (insertIndex < 0 || insertIndex >= viewGroup.getChildCount()) {
            viewGroup.addView(viewGroup2);
        } else {
            viewGroup.addView(viewGroup2, insertIndex);
        }
    }

    private static boolean isGhostWrapper(View view) {
        boolean z = false;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            z = false;
            if (frameLayout.getChildCount() == 1) {
                z = frameLayout.getChildAt(0) instanceof GhostView;
            }
        }
        return z;
    }

    private static boolean isOnTop(View view, View view2) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        ArrayList<View> buildOrderedChildList = viewGroup.buildOrderedChildList();
        boolean z2 = buildOrderedChildList == null && viewGroup.isChildrenDrawingOrderEnabled();
        int i = 0;
        while (true) {
            int i2 = i;
            z = true;
            if (i2 >= childCount) {
                break;
            }
            int childDrawingOrder = z2 ? viewGroup.getChildDrawingOrder(childCount, i2) : i2;
            View childAt = buildOrderedChildList == null ? viewGroup.getChildAt(childDrawingOrder) : buildOrderedChildList.get(childDrawingOrder);
            if (childAt == view) {
                z = false;
                break;
            } else if (childAt == view2) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (buildOrderedChildList != null) {
            buildOrderedChildList.clear();
        }
        return z;
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                return arrayList2.size() == min;
            }
            View view = arrayList.get(i2);
            View view2 = arrayList2.get(i2);
            if (view != view2) {
                return isOnTop(view, view2);
            }
            i = i2 + 1;
        }
    }

    private static int moveGhostViewsToTop(ViewGroup viewGroup, ArrayList<View> arrayList) {
        int i;
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            i = -1;
        } else if (isGhostWrapper(viewGroup.getChildAt(childCount - 1))) {
            int i2 = childCount - 1;
            int i3 = childCount;
            int i4 = 2;
            while (true) {
                int i5 = i3 - i4;
                i = i2;
                if (i5 < 0) {
                    break;
                }
                i = i2;
                if (!isGhostWrapper(viewGroup.getChildAt(i5))) {
                    break;
                }
                i2 = i5;
                i3 = i5;
                i4 = 1;
            }
        } else {
            int i6 = childCount;
            int i7 = 2;
            while (true) {
                int i8 = i6 - i7;
                if (i8 < 0) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i8);
                if (isGhostWrapper(childAt)) {
                    arrayList.add(childAt);
                    GhostView ghostView = (GhostView) ((ViewGroup) childAt).getChildAt(0);
                    ghostView.mBeingMoved = true;
                    viewGroup.removeViewAt(i8);
                    ghostView.mBeingMoved = false;
                }
                i6 = i8;
                i7 = 1;
            }
            if (arrayList.isEmpty()) {
                return -1;
            }
            int childCount2 = viewGroup.getChildCount();
            int size = arrayList.size();
            while (true) {
                int i9 = size - 1;
                if (i9 < 0) {
                    arrayList.clear();
                    return childCount2;
                }
                viewGroup.addView(arrayList.get(i9));
                size = i9;
            }
        }
        return i;
    }

    public static void removeGhost(View view) {
        GhostView ghostView = view.mGhostView;
        if (ghostView != null) {
            ghostView.mReferences--;
            if (ghostView.mReferences == 0) {
                ViewGroup viewGroup = (ViewGroup) ghostView.getParent();
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
        }
    }

    private void setGhostedVisibility(int i) {
        this.mView.mViewFlags = (this.mView.mViewFlags & (-13)) | i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mBeingMoved) {
            return;
        }
        setGhostedVisibility(0);
        this.mView.mGhostView = null;
        ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
        if (viewGroup != null) {
            viewGroup.mRecreateDisplayList = true;
            viewGroup.getDisplayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas instanceof HardwareCanvas) {
            HardwareCanvas hardwareCanvas = (HardwareCanvas) canvas;
            this.mView.mRecreateDisplayList = true;
            RenderNode displayList = this.mView.getDisplayList();
            if (displayList.isValid()) {
                hardwareCanvas.insertReorderBarrier();
                hardwareCanvas.drawRenderNode(displayList);
                hardwareCanvas.insertInorderBarrier();
            }
        }
    }

    public void setMatrix(Matrix matrix) {
        this.mRenderNode.setAnimationMatrix(matrix);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mView.mGhostView == this) {
            setGhostedVisibility(i == 0 ? 4 : 0);
        }
    }
}
