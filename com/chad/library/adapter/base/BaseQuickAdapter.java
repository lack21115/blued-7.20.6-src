package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter.class */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    public static final int ALPHAIN = 1;
    public static final int EMPTY_VIEW = 1365;
    public static final int FOOTER_VIEW = 819;
    public static final int HEADER_VIEW = 273;
    public static final int LOADING_VIEW = 546;
    public static final int SCALEIN = 2;
    public static final int SLIDEIN_BOTTOM = 3;
    public static final int SLIDEIN_LEFT = 4;
    public static final int SLIDEIN_RIGHT = 5;
    public static final String TAG = BaseQuickAdapter.class.getSimpleName();
    private boolean footerViewAsFlow;
    private boolean headerViewAsFlow;
    public Context mContext;
    private BaseAnimation mCustomAnimation;
    public List<T> mData;
    private int mDuration;
    private FrameLayout mEmptyLayout;
    private boolean mEnableLoadMoreEndClick;
    private boolean mFirstOnlyEnable;
    private boolean mFootAndEmptyEnable;
    private LinearLayout mFooterLayout;
    private boolean mHeadAndEmptyEnable;
    private LinearLayout mHeaderLayout;
    private Interpolator mInterpolator;
    private boolean mIsUseEmpty;
    private int mLastPosition;
    protected LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    private boolean mLoadMoreEnable;
    private LoadMoreView mLoadMoreView;
    private boolean mLoading;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    private boolean mNextLoadEnable;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private boolean mOpenAnimationEnable;
    private int mPreLoadNumber;
    private RecyclerView mRecyclerView;
    private RequestLoadMoreListener mRequestLoadMoreListener;
    private BaseAnimation mSelectAnimation;
    private SpanSizeLookup mSpanSizeLookup;
    private int mStartUpFetchPosition;
    private boolean mUpFetchEnable;
    private UpFetchListener mUpFetchListener;
    private boolean mUpFetching;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$AnimationType.class */
    public @interface AnimationType {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener.class */
    public interface OnItemChildClickListener {
        void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$OnItemChildLongClickListener.class */
    public interface OnItemChildLongClickListener {
        boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$OnItemClickListener.class */
    public interface OnItemClickListener {
        void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$OnItemLongClickListener.class */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$RequestLoadMoreListener.class */
    public interface RequestLoadMoreListener {
        void onLoadMoreRequested();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$SpanSizeLookup.class */
    public interface SpanSizeLookup {
        int getSpanSize(GridLayoutManager gridLayoutManager, int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseQuickAdapter$UpFetchListener.class */
    public interface UpFetchListener {
        void onUpFetch();
    }

    public BaseQuickAdapter(int i) {
        this(i, null);
    }

    public BaseQuickAdapter(int i, List<T> list) {
        this.mNextLoadEnable = false;
        this.mLoadMoreEnable = false;
        this.mLoading = false;
        this.mLoadMoreView = new SimpleLoadMoreView();
        this.mEnableLoadMoreEndClick = false;
        this.mFirstOnlyEnable = true;
        this.mOpenAnimationEnable = false;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = 300;
        this.mLastPosition = -1;
        this.mSelectAnimation = new AlphaInAnimation();
        this.mIsUseEmpty = true;
        this.mStartUpFetchPosition = 1;
        this.mPreLoadNumber = 1;
        this.mData = list == null ? new ArrayList() : list;
        if (i != 0) {
            this.mLayoutResId = i;
        }
    }

    public BaseQuickAdapter(List<T> list) {
        this(0, list);
    }

    private void addAnimation(RecyclerView.ViewHolder viewHolder) {
        if (!this.mOpenAnimationEnable) {
            return;
        }
        if (this.mFirstOnlyEnable && viewHolder.getLayoutPosition() <= this.mLastPosition) {
            return;
        }
        BaseAnimation baseAnimation = this.mCustomAnimation;
        if (baseAnimation == null) {
            baseAnimation = this.mSelectAnimation;
        }
        Animator[] a2 = baseAnimation.a(viewHolder.itemView);
        int length = a2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mLastPosition = viewHolder.getLayoutPosition();
                return;
            } else {
                startAnim(a2[i2], viewHolder.getLayoutPosition());
                i = i2 + 1;
            }
        }
    }

    private void autoLoadMore(int i) {
        if (getLoadMoreViewCount() != 0 && i >= getItemCount() - this.mPreLoadNumber && this.mLoadMoreView.e() == 1) {
            this.mLoadMoreView.a(2);
            if (this.mLoading) {
                return;
            }
            this.mLoading = true;
            if (getRecyclerView() != null) {
                getRecyclerView().post(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.7
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseQuickAdapter.this.mRequestLoadMoreListener.onLoadMoreRequested();
                    }
                });
            } else {
                this.mRequestLoadMoreListener.onLoadMoreRequested();
            }
        }
    }

    private void autoUpFetch(int i) {
        UpFetchListener upFetchListener;
        if (!isUpFetchEnable() || isUpFetching() || i > this.mStartUpFetchPosition || (upFetchListener = this.mUpFetchListener) == null) {
            return;
        }
        upFetchListener.onUpFetch();
    }

    private void bindViewClickListener(final BaseViewHolder baseViewHolder) {
        View view;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        if (getOnItemClickListener() != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    BaseQuickAdapter.this.getOnItemClickListener().onItemClick(BaseQuickAdapter.this, view2, baseViewHolder.getLayoutPosition() - BaseQuickAdapter.this.getHeaderLayoutCount());
                }
            });
        }
        if (getOnItemLongClickListener() != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return BaseQuickAdapter.this.getOnItemLongClickListener().onItemLongClick(BaseQuickAdapter.this, view2, baseViewHolder.getLayoutPosition() - BaseQuickAdapter.this.getHeaderLayoutCount());
                }
            });
        }
    }

    private void checkNotNull() {
        if (getRecyclerView() == null) {
            throw new RuntimeException("please bind recyclerView first!");
        }
    }

    private void compatibilityDataSizeChanged(int i) {
        List<T> list = this.mData;
        if ((list == null ? 0 : list.size()) == i) {
            notifyDataSetChanged();
        }
    }

    private K createGenericKInstance(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(view);
            }
            Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(this, view);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private IExpandable getExpandableItem(int i) {
        T item = getItem(i);
        if (isExpandable(item)) {
            return (IExpandable) item;
        }
        return null;
    }

    private int getFooterViewPosition() {
        if (getEmptyViewCount() == 1) {
            int i = 1;
            if (this.mHeadAndEmptyEnable) {
                i = 1;
                if (getHeaderLayoutCount() != 0) {
                    i = 2;
                }
            }
            if (this.mFootAndEmptyEnable) {
                return i;
            }
            return -1;
        }
        return getHeaderLayoutCount() + this.mData.size();
    }

    private int getHeaderViewPosition() {
        return (getEmptyViewCount() != 1 || this.mHeadAndEmptyEnable) ? 0 : -1;
    }

    private Class getInstancedGenericKClass(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        int length = actualTypeArguments.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Type type = actualTypeArguments[i2];
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (BaseViewHolder.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            }
            i = i2 + 1;
        }
    }

    private int getItemPosition(T t) {
        List<T> list;
        if (t == null || (list = this.mData) == null || list.isEmpty()) {
            return -1;
        }
        return this.mData.indexOf(t);
    }

    private K getLoadingView(ViewGroup viewGroup) {
        K createBaseViewHolder = createBaseViewHolder(getItemView(this.mLoadMoreView.a(), viewGroup));
        createBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BaseQuickAdapter.this.mLoadMoreView.e() == 3) {
                    BaseQuickAdapter.this.notifyLoadMoreToLoading();
                }
                if (BaseQuickAdapter.this.mEnableLoadMoreEndClick && BaseQuickAdapter.this.mLoadMoreView.e() == 4) {
                    BaseQuickAdapter.this.notifyLoadMoreToLoading();
                }
            }
        });
        return createBaseViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTheBiggestNumber(int[] iArr) {
        int i = -1;
        int i2 = -1;
        if (iArr != null) {
            if (iArr.length != 0) {
                int length = iArr.length;
                int i3 = 0;
                while (true) {
                    i2 = i;
                    if (i3 >= length) {
                        break;
                    }
                    int i4 = iArr[i3];
                    int i5 = i;
                    if (i4 > i) {
                        i5 = i4;
                    }
                    i3++;
                    i = i5;
                }
            } else {
                return -1;
            }
        }
        return i2;
    }

    private boolean hasSubItems(IExpandable iExpandable) {
        if (iExpandable == null) {
            return false;
        }
        List<T> b = iExpandable.b();
        boolean z = false;
        if (b != null) {
            z = false;
            if (b.size() > 0) {
                z = true;
            }
        }
        return z;
    }

    private void openLoadMore(RequestLoadMoreListener requestLoadMoreListener) {
        this.mRequestLoadMoreListener = requestLoadMoreListener;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
    }

    private int recursiveCollapse(int i) {
        T item = getItem(i);
        int i2 = 0;
        int i3 = 0;
        if (isExpandable(item)) {
            IExpandable iExpandable = (IExpandable) item;
            if (iExpandable.a()) {
                List<T> b = iExpandable.b();
                int size = b.size();
                while (true) {
                    int i4 = size - 1;
                    i2 = i3;
                    if (i4 < 0) {
                        break;
                    }
                    T t = b.get(i4);
                    int itemPosition = getItemPosition(t);
                    if (itemPosition >= 0) {
                        int i5 = i3;
                        if (t instanceof IExpandable) {
                            i5 = i3 + recursiveCollapse(itemPosition);
                        }
                        this.mData.remove(itemPosition);
                        i3 = i5 + 1;
                    }
                    size = i4;
                }
            }
            return i2;
        }
        return 0;
    }

    private int recursiveExpand(int i, List list) {
        int size = (i + list.size()) - 1;
        int size2 = list.size() - 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (size2 < 0) {
                return i3;
            }
            int i4 = i3;
            if (list.get(size2) instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) list.get(size2);
                i4 = i3;
                if (iExpandable.a()) {
                    i4 = i3;
                    if (hasSubItems(iExpandable)) {
                        List<T> b = iExpandable.b();
                        int i5 = size + 1;
                        this.mData.addAll(i5, b);
                        i4 = i3 + recursiveExpand(i5, b);
                    }
                }
            }
            size2--;
            size--;
            i2 = i4;
        }
    }

    private void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Deprecated
    public void add(int i, T t) {
        addData(i, (int) t);
    }

    public void addData(int i, T t) {
        this.mData.add(i, t);
        notifyItemInserted(i + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(int i, Collection<? extends T> collection) {
        this.mData.addAll(i, collection);
        notifyItemRangeInserted(i + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public void addData(T t) {
        this.mData.add(t);
        notifyItemInserted(this.mData.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(Collection<? extends T> collection) {
        this.mData.addAll(collection);
        notifyItemRangeInserted((this.mData.size() - collection.size()) + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public int addFooterView(View view) {
        return addFooterView(view, -1, 1);
    }

    public int addFooterView(View view, int i) {
        return addFooterView(view, i, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (r8 > r0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addFooterView(android.view.View r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            if (r0 != 0) goto L50
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r1 = r0
            r2 = r7
            android.content.Context r2 = r2.getContext()
            r1.<init>(r2)
            r11 = r0
            r0 = r6
            r1 = r11
            r0.mFooterLayout = r1
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L39
            r0 = r11
            r1 = 1
            r0.setOrientation(r1)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
            r2 = r1
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r0.setLayoutParams(r1)
            goto L50
        L39:
            r0 = r11
            r1 = 0
            r0.setOrientation(r1)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
            r2 = r1
            r3 = -2
            r4 = -1
            r2.<init>(r3, r4)
            r0.setLayoutParams(r1)
        L50:
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            int r0 = r0.getChildCount()
            r10 = r0
            r0 = r8
            if (r0 < 0) goto L65
            r0 = r8
            r9 = r0
            r0 = r8
            r1 = r10
            if (r0 <= r1) goto L68
        L65:
            r0 = r10
            r9 = r0
        L68:
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            r1 = r7
            r2 = r9
            r0.addView(r1, r2)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mFooterLayout
            int r0 = r0.getChildCount()
            r1 = 1
            if (r0 != r1) goto L8b
            r0 = r6
            int r0 = r0.getFooterViewPosition()
            r8 = r0
            r0 = r8
            r1 = -1
            if (r0 == r1) goto L8b
            r0 = r6
            r1 = r8
            r0.notifyItemInserted(r1)
        L8b:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.BaseQuickAdapter.addFooterView(android.view.View, int, int):int");
    }

    public int addHeaderView(View view) {
        return addHeaderView(view, -1);
    }

    public int addHeaderView(View view, int i) {
        return addHeaderView(view, i, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (r8 > r0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addHeaderView(android.view.View r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            if (r0 != 0) goto L50
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r1 = r0
            r2 = r7
            android.content.Context r2 = r2.getContext()
            r1.<init>(r2)
            r11 = r0
            r0 = r6
            r1 = r11
            r0.mHeaderLayout = r1
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L39
            r0 = r11
            r1 = 1
            r0.setOrientation(r1)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
            r2 = r1
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r0.setLayoutParams(r1)
            goto L50
        L39:
            r0 = r11
            r1 = 0
            r0.setOrientation(r1)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
            r2 = r1
            r3 = -2
            r4 = -1
            r2.<init>(r3, r4)
            r0.setLayoutParams(r1)
        L50:
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            int r0 = r0.getChildCount()
            r10 = r0
            r0 = r8
            if (r0 < 0) goto L65
            r0 = r8
            r9 = r0
            r0 = r8
            r1 = r10
            if (r0 <= r1) goto L68
        L65:
            r0 = r10
            r9 = r0
        L68:
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            r1 = r7
            r2 = r9
            r0.addView(r1, r2)
            r0 = r6
            android.widget.LinearLayout r0 = r0.mHeaderLayout
            int r0 = r0.getChildCount()
            r1 = 1
            if (r0 != r1) goto L8b
            r0 = r6
            int r0 = r0.getHeaderViewPosition()
            r8 = r0
            r0 = r8
            r1 = -1
            if (r0 == r1) goto L8b
            r0 = r6
            r1 = r8
            r0.notifyItemInserted(r1)
        L8b:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.BaseQuickAdapter.addHeaderView(android.view.View, int, int):int");
    }

    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            throw new RuntimeException("Don't bind twice");
        }
        setRecyclerView(recyclerView);
        getRecyclerView().setAdapter(this);
    }

    public int collapse(int i) {
        return collapse(i, true, true);
    }

    public int collapse(int i, boolean z) {
        return collapse(i, z, true);
    }

    public int collapse(int i, boolean z, boolean z2) {
        int headerLayoutCount = i - getHeaderLayoutCount();
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null) {
            return 0;
        }
        int recursiveCollapse = recursiveCollapse(headerLayoutCount);
        expandableItem.a(false);
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z2) {
            if (z) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeRemoved(headerLayoutCount2 + 1, recursiveCollapse);
                return recursiveCollapse;
            }
            notifyDataSetChanged();
        }
        return recursiveCollapse;
    }

    protected abstract void convert(K k, T t);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.chad.library.adapter.base.BaseViewHolder] */
    protected K createBaseViewHolder(View view) {
        Class cls = null;
        for (Class<? super Object> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = getInstancedGenericKClass(cls2);
        }
        K baseViewHolder = cls == null ? new BaseViewHolder(view) : createGenericKInstance(cls, view);
        return baseViewHolder != null ? baseViewHolder : (K) new BaseViewHolder(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public K createBaseViewHolder(ViewGroup viewGroup, int i) {
        return createBaseViewHolder(getItemView(i, viewGroup));
    }

    public void disableLoadMoreIfNotFullPage() {
        checkNotNull();
        disableLoadMoreIfNotFullPage(getRecyclerView());
    }

    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        setEnableLoadMore(false);
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            recyclerView.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 != BaseQuickAdapter.this.getItemCount()) {
                        BaseQuickAdapter.this.setEnableLoadMore(true);
                    }
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            recyclerView.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                    staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
                    if (BaseQuickAdapter.this.getTheBiggestNumber(iArr) + 1 != BaseQuickAdapter.this.getItemCount()) {
                        BaseQuickAdapter.this.setEnableLoadMore(true);
                    }
                }
            }, 50L);
        }
    }

    public void enableLoadMoreEndClick(boolean z) {
        this.mEnableLoadMoreEndClick = z;
    }

    public int expand(int i) {
        return expand(i, true, true);
    }

    public int expand(int i, boolean z) {
        return expand(i, z, true);
    }

    public int expand(int i, boolean z, boolean z2) {
        int headerLayoutCount = i - getHeaderLayoutCount();
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        int i2 = 0;
        if (expandableItem == null) {
            return 0;
        }
        if (!hasSubItems(expandableItem)) {
            expandableItem.a(false);
            return 0;
        }
        if (!expandableItem.a()) {
            List<T> b = expandableItem.b();
            int i3 = headerLayoutCount + 1;
            this.mData.addAll(i3, b);
            int recursiveExpand = recursiveExpand(i3, b);
            expandableItem.a(true);
            i2 = recursiveExpand + 0 + b.size();
        }
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z2) {
            if (z) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeInserted(headerLayoutCount2 + 1, i2);
                return i2;
            }
            notifyDataSetChanged();
        }
        return i2;
    }

    public int expandAll(int i, boolean z) {
        return expandAll(i, true, !z);
    }

    public int expandAll(int i, boolean z, boolean z2) {
        int i2;
        T item;
        int headerLayoutCount = i - getHeaderLayoutCount();
        int i3 = headerLayoutCount + 1;
        T item2 = i3 < this.mData.size() ? getItem(i3) : null;
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null || !hasSubItems(expandableItem)) {
            return 0;
        }
        int expand = expand(getHeaderLayoutCount() + headerLayoutCount, false, false);
        while (true) {
            i2 = expand;
            if (i3 >= this.mData.size() || (item = getItem(i3)) == item2) {
                break;
            }
            int i4 = i2;
            if (isExpandable(item)) {
                i4 = i2 + expand(getHeaderLayoutCount() + i3, false, false);
            }
            i3++;
            expand = i4;
        }
        if (z2) {
            if (z) {
                notifyItemRangeInserted(headerLayoutCount + getHeaderLayoutCount() + 1, i2);
                return i2;
            }
            notifyDataSetChanged();
        }
        return i2;
    }

    public void expandAll() {
        int size = (this.mData.size() - 1) + getHeaderLayoutCount();
        while (true) {
            int i = size;
            if (i < getHeaderLayoutCount()) {
                return;
            }
            expandAll(i, false, false);
            size = i - 1;
        }
    }

    public List<T> getData() {
        return this.mData;
    }

    protected int getDefItemViewType(int i) {
        MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        return multiTypeDelegate != null ? multiTypeDelegate.a(this.mData, i) : super.getItemViewType(i);
    }

    public View getEmptyView() {
        return this.mEmptyLayout;
    }

    public int getEmptyViewCount() {
        FrameLayout frameLayout = this.mEmptyLayout;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.mIsUseEmpty || this.mData.size() != 0) ? 0 : 1;
    }

    public LinearLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public int getFooterLayoutCount() {
        LinearLayout linearLayout = this.mFooterLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getFooterViewsCount() {
        return getFooterLayoutCount();
    }

    public LinearLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public int getHeaderLayoutCount() {
        LinearLayout linearLayout = this.mHeaderLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getHeaderViewsCount() {
        return getHeaderLayoutCount();
    }

    public T getItem(int i) {
        if (i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int loadMoreViewCount;
        if (getEmptyViewCount() == 1) {
            int i = 1;
            if (this.mHeadAndEmptyEnable) {
                i = 1;
                if (getHeaderLayoutCount() != 0) {
                    i = 2;
                }
            }
            loadMoreViewCount = i;
            if (this.mFootAndEmptyEnable) {
                loadMoreViewCount = i;
                if (getFooterLayoutCount() != 0) {
                    return i + 1;
                }
            }
        } else {
            loadMoreViewCount = getLoadMoreViewCount() + getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
        }
        return loadMoreViewCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    protected View getItemView(int i, ViewGroup viewGroup) {
        return this.mLayoutInflater.inflate(i, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (getEmptyViewCount() == 1) {
            boolean z = this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0;
            if (i != 0) {
                return i != 1 ? i != 2 ? EMPTY_VIEW : FOOTER_VIEW : z ? EMPTY_VIEW : FOOTER_VIEW;
            } else if (z) {
                return 273;
            } else {
                return EMPTY_VIEW;
            }
        }
        int headerLayoutCount = getHeaderLayoutCount();
        if (i < headerLayoutCount) {
            return 273;
        }
        int i2 = i - headerLayoutCount;
        int size = this.mData.size();
        if (i2 < size) {
            return getDefItemViewType(i2);
        }
        if (i2 - size < getFooterLayoutCount()) {
            return FOOTER_VIEW;
        }
        return 546;
    }

    public int getLoadMoreViewCount() {
        if (this.mRequestLoadMoreListener == null || !this.mLoadMoreEnable) {
            return 0;
        }
        return ((this.mNextLoadEnable || !this.mLoadMoreView.f()) && this.mData.size() != 0) ? 1 : 0;
    }

    public int getLoadMoreViewPosition() {
        return getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public int getParentPosition(T t) {
        int itemPosition = getItemPosition(t);
        if (itemPosition == -1) {
            return -1;
        }
        int c2 = t instanceof IExpandable ? ((IExpandable) t).c() : Integer.MAX_VALUE;
        if (c2 == 0) {
            return itemPosition;
        }
        if (c2 == -1) {
            return -1;
        }
        while (itemPosition >= 0) {
            T t2 = this.mData.get(itemPosition);
            if (t2 instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) t2;
                if (iExpandable.c() >= 0 && iExpandable.c() < c2) {
                    return itemPosition;
                }
            }
            itemPosition--;
        }
        return -1;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getViewByPosition(int i, int i2) {
        checkNotNull();
        return getViewByPosition(getRecyclerView(), i, i2);
    }

    public View getViewByPosition(RecyclerView recyclerView, int i, int i2) {
        BaseViewHolder baseViewHolder;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i)) == null) {
            return null;
        }
        return baseViewHolder.getView(i2);
    }

    public boolean isExpandable(T t) {
        return t != null && (t instanceof IExpandable);
    }

    public void isFirstOnly(boolean z) {
        this.mFirstOnlyEnable = z;
    }

    protected boolean isFixedViewType(int i) {
        return i == 1365 || i == 273 || i == 819 || i == 546;
    }

    public boolean isFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public boolean isHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public boolean isLoadMoreEnable() {
        return this.mLoadMoreEnable;
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isUpFetchEnable() {
        return this.mUpFetchEnable;
    }

    public boolean isUpFetching() {
        return this.mUpFetching;
    }

    public void isUseEmpty(boolean z) {
        this.mIsUseEmpty = z;
    }

    public void loadMoreComplete() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mNextLoadEnable = true;
        this.mLoadMoreView.a(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public void loadMoreEnd(boolean z) {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mNextLoadEnable = false;
        this.mLoadMoreView.a(z);
        if (z) {
            notifyItemRemoved(getLoadMoreViewPosition());
            return;
        }
        this.mLoadMoreView.a(4);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void loadMoreFail() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mLoadMoreView.a(3);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void notifyLoadMoreToLoading() {
        if (this.mLoadMoreView.e() == 2) {
            return;
        }
        this.mLoadMoreView.a(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.4
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    int itemViewType = BaseQuickAdapter.this.getItemViewType(i);
                    if (itemViewType == 273 && BaseQuickAdapter.this.isHeaderViewAsFlow()) {
                        return 1;
                    }
                    if (itemViewType == 819 && BaseQuickAdapter.this.isFooterViewAsFlow()) {
                        return 1;
                    }
                    if (BaseQuickAdapter.this.mSpanSizeLookup != null) {
                        return BaseQuickAdapter.this.isFixedViewType(itemViewType) ? gridLayoutManager.getSpanCount() : BaseQuickAdapter.this.mSpanSizeLookup.getSpanSize(gridLayoutManager, i - BaseQuickAdapter.this.getHeaderLayoutCount());
                    }
                    int i2 = 1;
                    if (BaseQuickAdapter.this.isFixedViewType(itemViewType)) {
                        i2 = gridLayoutManager.getSpanCount();
                    }
                    return i2;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseQuickAdapter<T, K>) ((BaseViewHolder) viewHolder), i);
    }

    public void onBindViewHolder(K k, int i) {
        autoUpFetch(i);
        autoLoadMore(i);
        int itemViewType = k.getItemViewType();
        if (itemViewType == 0) {
            convert(k, getItem(i - getHeaderLayoutCount()));
        } else if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.mLoadMoreView.a(k);
            } else if (itemViewType == 819 || itemViewType == 1365) {
            } else {
                convert(k, getItem(i - getHeaderLayoutCount()));
            }
        }
    }

    protected K onCreateDefViewHolder(ViewGroup viewGroup, int i) {
        int i2 = this.mLayoutResId;
        MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        if (multiTypeDelegate != null) {
            i2 = multiTypeDelegate.a(i);
        }
        return createBaseViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(ViewGroup viewGroup, int i) {
        K createBaseViewHolder;
        Context context = viewGroup.getContext();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        if (i == 273) {
            createBaseViewHolder = createBaseViewHolder(this.mHeaderLayout);
        } else if (i == 546) {
            createBaseViewHolder = getLoadingView(viewGroup);
        } else if (i == 819) {
            createBaseViewHolder = createBaseViewHolder(this.mFooterLayout);
        } else if (i != 1365) {
            createBaseViewHolder = onCreateDefViewHolder(viewGroup, i);
            bindViewClickListener(createBaseViewHolder);
        } else {
            createBaseViewHolder = createBaseViewHolder(this.mEmptyLayout);
        }
        createBaseViewHolder.setAdapter(this);
        return createBaseViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        onViewAttachedToWindow((BaseQuickAdapter<T, K>) ((BaseViewHolder) viewHolder));
    }

    public void onViewAttachedToWindow(K k) {
        super.onViewAttachedToWindow((BaseQuickAdapter<T, K>) k);
        int itemViewType = k.getItemViewType();
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            setFullSpan(k);
        } else {
            addAnimation(k);
        }
    }

    public void openLoadAnimation() {
        this.mOpenAnimationEnable = true;
    }

    public void openLoadAnimation(int i) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = null;
        if (i == 1) {
            this.mSelectAnimation = new AlphaInAnimation();
        } else if (i == 2) {
            this.mSelectAnimation = new ScaleInAnimation();
        } else if (i == 3) {
            this.mSelectAnimation = new SlideInBottomAnimation();
        } else if (i == 4) {
            this.mSelectAnimation = new SlideInLeftAnimation();
        } else if (i != 5) {
        } else {
            this.mSelectAnimation = new SlideInRightAnimation();
        }
    }

    public void openLoadAnimation(BaseAnimation baseAnimation) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = baseAnimation;
    }

    public void remove(int i) {
        this.mData.remove(i);
        int headerLayoutCount = i + getHeaderLayoutCount();
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.mData.size() - headerLayoutCount);
    }

    public void removeAllFooterView() {
        if (getFooterLayoutCount() == 0) {
            return;
        }
        this.mFooterLayout.removeAllViews();
        int footerViewPosition = getFooterViewPosition();
        if (footerViewPosition != -1) {
            notifyItemRemoved(footerViewPosition);
        }
    }

    public void removeAllHeaderView() {
        if (getHeaderLayoutCount() == 0) {
            return;
        }
        this.mHeaderLayout.removeAllViews();
        int headerViewPosition = getHeaderViewPosition();
        if (headerViewPosition != -1) {
            notifyItemRemoved(headerViewPosition);
        }
    }

    public void removeFooterView(View view) {
        int footerViewPosition;
        if (getFooterLayoutCount() == 0) {
            return;
        }
        this.mFooterLayout.removeView(view);
        if (this.mFooterLayout.getChildCount() != 0 || (footerViewPosition = getFooterViewPosition()) == -1) {
            return;
        }
        notifyItemRemoved(footerViewPosition);
    }

    public void removeHeaderView(View view) {
        int headerViewPosition;
        if (getHeaderLayoutCount() == 0) {
            return;
        }
        this.mHeaderLayout.removeView(view);
        if (this.mHeaderLayout.getChildCount() != 0 || (headerViewPosition = getHeaderViewPosition()) == -1) {
            return;
        }
        notifyItemRemoved(headerViewPosition);
    }

    public void replaceData(Collection<? extends T> collection) {
        List<T> list = this.mData;
        if (collection != list) {
            list.clear();
            this.mData.addAll(collection);
        }
        notifyDataSetChanged();
    }

    @Deprecated
    public void setAutoLoadMoreSize(int i) {
        setPreLoadNumber(i);
    }

    public void setData(int i, T t) {
        this.mData.set(i, t);
        notifyItemChanged(i + getHeaderLayoutCount());
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setEmptyView(int i) {
        checkNotNull();
        setEmptyView(i, getRecyclerView());
    }

    public void setEmptyView(int i, ViewGroup viewGroup) {
        setEmptyView(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    public void setEmptyView(View view) {
        boolean z;
        if (this.mEmptyLayout == null) {
            this.mEmptyLayout = new FrameLayout(view.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
            }
            this.mEmptyLayout.setLayoutParams(layoutParams);
            z = true;
        } else {
            z = false;
        }
        this.mEmptyLayout.removeAllViews();
        this.mEmptyLayout.addView(view);
        this.mIsUseEmpty = true;
        if (z && getEmptyViewCount() == 1) {
            int i = 0;
            if (this.mHeadAndEmptyEnable) {
                i = 0;
                if (getHeaderLayoutCount() != 0) {
                    i = 1;
                }
            }
            notifyItemInserted(i);
        }
    }

    public void setEnableLoadMore(boolean z) {
        int loadMoreViewCount = getLoadMoreViewCount();
        this.mLoadMoreEnable = z;
        int loadMoreViewCount2 = getLoadMoreViewCount();
        if (loadMoreViewCount == 1) {
            if (loadMoreViewCount2 == 0) {
                notifyItemRemoved(getLoadMoreViewPosition());
            }
        } else if (loadMoreViewCount2 == 1) {
            this.mLoadMoreView.a(1);
            notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public int setFooterView(View view) {
        return setFooterView(view, 0, 1);
    }

    public int setFooterView(View view, int i) {
        return setFooterView(view, i, 1);
    }

    public int setFooterView(View view, int i, int i2) {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i) {
            return addFooterView(view, i, i2);
        }
        this.mFooterLayout.removeViewAt(i);
        this.mFooterLayout.addView(view, i);
        return i;
    }

    public void setFooterViewAsFlow(boolean z) {
        this.footerViewAsFlow = z;
    }

    protected void setFullSpan(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }

    public void setHeaderAndEmpty(boolean z) {
        setHeaderFooterEmpty(z, false);
    }

    public void setHeaderFooterEmpty(boolean z, boolean z2) {
        this.mHeadAndEmptyEnable = z;
        this.mFootAndEmptyEnable = z2;
    }

    public int setHeaderView(View view) {
        return setHeaderView(view, 0, 1);
    }

    public int setHeaderView(View view, int i) {
        return setHeaderView(view, i, 1);
    }

    public int setHeaderView(View view, int i, int i2) {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i) {
            return addHeaderView(view, i, i2);
        }
        this.mHeaderLayout.removeViewAt(i);
        this.mHeaderLayout.addView(view, i);
        return i;
    }

    public void setHeaderViewAsFlow(boolean z) {
        this.headerViewAsFlow = z;
    }

    public void setLoadMoreView(LoadMoreView loadMoreView) {
        this.mLoadMoreView = loadMoreView;
    }

    public void setMultiTypeDelegate(MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }

    public void setNewData(List<T> list) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.mData = arrayList;
        if (this.mRequestLoadMoreListener != null) {
            this.mNextLoadEnable = true;
            this.mLoadMoreEnable = true;
            this.mLoading = false;
            this.mLoadMoreView.a(1);
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
    }

    public void setNotDoAnimationCount(int i) {
        this.mLastPosition = i;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    @Deprecated
    public void setOnLoadMoreListener(RequestLoadMoreListener requestLoadMoreListener) {
        openLoadMore(requestLoadMoreListener);
    }

    public void setOnLoadMoreListener(RequestLoadMoreListener requestLoadMoreListener, RecyclerView recyclerView) {
        openLoadMore(requestLoadMoreListener);
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
        }
    }

    public void setPreLoadNumber(int i) {
        if (i > 1) {
            this.mPreLoadNumber = i;
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStartUpFetchPosition(int i) {
        this.mStartUpFetchPosition = i;
    }

    public void setUpFetchEnable(boolean z) {
        this.mUpFetchEnable = z;
    }

    public void setUpFetchListener(UpFetchListener upFetchListener) {
        this.mUpFetchListener = upFetchListener;
    }

    public void setUpFetching(boolean z) {
        this.mUpFetching = z;
    }

    protected void startAnim(Animator animator, int i) {
        animator.setDuration(this.mDuration).start();
        animator.setInterpolator(this.mInterpolator);
    }
}
