package com.sobot.chat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/DropdownListView.class */
public class DropdownListView extends ListView implements AbsListView.OnScrollListener {
    private static final int DONE = 3;
    private static final int LOADING = 4;
    private static final int PULL_To_REFRESH = 1;
    private static final int RATIO = 3;
    private static final int REFRESHING = 2;
    private static final int RELEASE_To_REFRESH = 0;
    private static final String TAG = "listview";
    private DropdownListScrollListener dropdownListScrollListener;
    private int firstItemIndex;
    private FrameLayout fl;
    private int headContentHeight;
    private int headContentWidth;
    private LinearLayout headView;
    private LayoutInflater inflater;
    private boolean isBack;
    private boolean isRecored;
    private boolean isRefreshableHeader;
    private ProgressBar progressBar;
    private boolean pullRefreshEnable;
    private OnRefreshListenerHeader refreshListenerHeader;
    private int startY;
    private int state;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/DropdownListView$DropdownListScrollListener.class */
    public interface DropdownListScrollListener {
        void onScroll(AbsListView absListView, int i, int i2, int i3);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/DropdownListView$OnRefreshListenerFooter.class */
    public interface OnRefreshListenerFooter {
        void onRefresh();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/DropdownListView$OnRefreshListenerHeader.class */
    public interface OnRefreshListenerHeader {
        void onRefresh();
    }

    public DropdownListView(Context context) {
        super(context);
        init(context);
    }

    public DropdownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void changeHeaderViewByState() {
        int i = this.state;
        if (i == 0) {
            this.progressBar.setVisibility(0);
        } else if (i == 1) {
            this.progressBar.setVisibility(0);
            if (this.isBack) {
                this.isBack = false;
            }
        } else if (i == 2) {
            this.headView.setPadding(0, 0, 0, 0);
            this.progressBar.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.headView.setPadding(0, this.headContentHeight * (-1), 0, 0);
            this.progressBar.setVisibility(8);
        }
    }

    private void init(Context context) {
        setCacheColorHint(context.getResources().getColor(ResourceUtils.getIdByName(getContext(), "color", "sobot_transparent")));
        LayoutInflater from = LayoutInflater.from(context);
        this.inflater = from;
        FrameLayout frameLayout = (FrameLayout) from.inflate(ResourceUtils.getIdByName(getContext(), "layout", "sobot_dropdown_lv_head"), (ViewGroup) null);
        this.fl = frameLayout;
        this.headView = (LinearLayout) frameLayout.findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_drop_down_head"));
        this.progressBar = (ProgressBar) this.fl.findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_loading"));
        measureView(this.headView);
        this.headContentHeight = this.headView.getMeasuredHeight();
        this.headContentWidth = this.headView.getMeasuredWidth();
        this.headView.setPadding(0, this.headContentHeight * (-1), 0, 0);
        this.headView.invalidate();
        addHeaderView(this.fl, null, false);
        setOnScrollListener(this);
        this.state = 3;
        this.isRefreshableHeader = false;
    }

    private void measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams2.width);
        int i = layoutParams2.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void onRefresh() {
        OnRefreshListenerHeader onRefreshListenerHeader = this.refreshListenerHeader;
        if (onRefreshListenerHeader != null) {
            if (this.pullRefreshEnable) {
                onRefreshListenerHeader.onRefresh();
            } else {
                onRefreshCompleteHeader();
            }
        }
    }

    public void onRefreshCompleteHeader() {
        this.state = 3;
        changeHeaderViewByState();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.firstItemIndex = i;
        DropdownListScrollListener dropdownListScrollListener = this.dropdownListScrollListener;
        if (dropdownListScrollListener != null) {
            dropdownListScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isRefreshableHeader) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    int i = this.state;
                    if (i != 2 && i != 4) {
                        if (i == 1) {
                            this.state = 3;
                            changeHeaderViewByState();
                        }
                        if (this.state == 0) {
                            this.state = 2;
                            changeHeaderViewByState();
                            onRefresh();
                        }
                    }
                    this.isRecored = false;
                    this.isBack = false;
                } else if (action == 2) {
                    int y = (int) motionEvent.getY();
                    if (!this.isRecored && this.firstItemIndex == 0) {
                        this.isRecored = true;
                        this.startY = y;
                    }
                    int i2 = this.state;
                    if (i2 != 2 && this.isRecored && i2 != 4) {
                        if (i2 == 0) {
                            setSelection(0);
                            int i3 = this.startY;
                            if ((y - i3) / 3 < this.headContentHeight && y - i3 > 0) {
                                this.state = 1;
                                changeHeaderViewByState();
                            } else if (y - this.startY <= 0) {
                                this.state = 3;
                                changeHeaderViewByState();
                            }
                        }
                        if (this.state == 1) {
                            setSelection(0);
                            int i4 = this.startY;
                            if ((y - i4) / 3 >= this.headContentHeight) {
                                this.state = 0;
                                this.isBack = true;
                                changeHeaderViewByState();
                            } else if (y - i4 <= 0) {
                                this.state = 3;
                                changeHeaderViewByState();
                            }
                        }
                        if (this.state == 3 && y - this.startY > 0) {
                            this.state = 1;
                            changeHeaderViewByState();
                        }
                        if (this.state == 1) {
                            this.headView.setPadding(0, (this.headContentHeight * (-1)) + ((y - this.startY) / 3), 0, 0);
                        }
                        if (this.state == 0) {
                            this.headView.setPadding(0, ((y - this.startY) / 3) - this.headContentHeight, 0, 0);
                        }
                    }
                }
            } else if (this.firstItemIndex == 0 && !this.isRecored) {
                this.isRecored = true;
                this.startY = (int) motionEvent.getY();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        super.setAdapter((ListAdapter) baseAdapter);
    }

    public void setDropdownListScrollListener(DropdownListScrollListener dropdownListScrollListener) {
        this.dropdownListScrollListener = dropdownListScrollListener;
    }

    public void setOnRefreshListenerHead(OnRefreshListenerHeader onRefreshListenerHeader) {
        this.refreshListenerHeader = onRefreshListenerHeader;
        this.isRefreshableHeader = true;
    }

    public void setPullRefreshEnable(boolean z) {
        this.pullRefreshEnable = z;
    }
}
