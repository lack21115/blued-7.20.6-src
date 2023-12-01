package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogCreateComingEventsBinding.class */
public final class DialogCreateComingEventsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16322a;
    public final CheckBox b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16323c;
    public final CheckBox d;
    public final CheckBox e;
    public final View f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final View k;
    public final View l;
    public final View m;
    public final RecyclerView n;
    public final TextView o;
    public final TextView p;
    public final EditText q;
    public final TextView r;
    public final EditText s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    private final ConstraintLayout y;

    private DialogCreateComingEventsBinding(ConstraintLayout constraintLayout, View view, CheckBox checkBox, ShapeTextView shapeTextView, CheckBox checkBox2, CheckBox checkBox3, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view3, View view4, View view5, RecyclerView recyclerView, TextView textView, TextView textView2, EditText editText, TextView textView3, EditText editText2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.y = constraintLayout;
        this.f16322a = view;
        this.b = checkBox;
        this.f16323c = shapeTextView;
        this.d = checkBox2;
        this.e = checkBox3;
        this.f = view2;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = view3;
        this.l = view4;
        this.m = view5;
        this.n = recyclerView;
        this.o = textView;
        this.p = textView2;
        this.q = editText;
        this.r = textView3;
        this.s = editText2;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = textView7;
        this.x = textView8;
    }

    public static DialogCreateComingEventsBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.bg_line);
        if (findViewById != null) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.btn_both_action);
            if (checkBox != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_create);
                if (shapeTextView != null) {
                    CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.btn_notify_fans);
                    if (checkBox2 != null) {
                        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.btn_publish_feed);
                        if (checkBox3 != null) {
                            View findViewById2 = view.findViewById(R.id.cover_view);
                            if (findViewById2 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.img_close);
                                if (imageView != null) {
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_editor);
                                    if (imageView2 != null) {
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_issues);
                                        if (imageView3 != null) {
                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.img_notice_info);
                                            if (imageView4 != null) {
                                                View findViewById3 = view.findViewById(R.id.line_end_date);
                                                if (findViewById3 != null) {
                                                    View findViewById4 = view.findViewById(R.id.line_introduction);
                                                    if (findViewById4 != null) {
                                                        View findViewById5 = view.findViewById(R.id.line_start_date);
                                                        if (findViewById5 != null) {
                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_theme_list);
                                                            if (recyclerView != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_date_title);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_end_date);
                                                                    if (textView2 != null) {
                                                                        EditText editText = (EditText) view.findViewById(R.id.tv_event_name);
                                                                        if (editText != null) {
                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_events_title);
                                                                            if (textView3 != null) {
                                                                                EditText editText2 = (EditText) view.findViewById(R.id.tv_introduction_content);
                                                                                if (editText2 != null) {
                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_introduction_title);
                                                                                    if (textView4 != null) {
                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_notice_title);
                                                                                        if (textView5 != null) {
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_start_date);
                                                                                            if (textView6 != null) {
                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_theme_title);
                                                                                                if (textView7 != null) {
                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_to_text);
                                                                                                    if (textView8 != null) {
                                                                                                        return new DialogCreateComingEventsBinding((ConstraintLayout) view, findViewById, checkBox, shapeTextView, checkBox2, checkBox3, findViewById2, imageView, imageView2, imageView3, imageView4, findViewById3, findViewById4, findViewById5, recyclerView, textView, textView2, editText, textView3, editText2, textView4, textView5, textView6, textView7, textView8);
                                                                                                    }
                                                                                                    str = "tvToText";
                                                                                                } else {
                                                                                                    str = "tvThemeTitle";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvStartDate";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvNoticeTitle";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvIntroductionTitle";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvIntroductionContent";
                                                                                }
                                                                            } else {
                                                                                str = "tvEventsTitle";
                                                                            }
                                                                        } else {
                                                                            str = "tvEventName";
                                                                        }
                                                                    } else {
                                                                        str = "tvEndDate";
                                                                    }
                                                                } else {
                                                                    str = "tvDateTitle";
                                                                }
                                                            } else {
                                                                str = "rvThemeList";
                                                            }
                                                        } else {
                                                            str = "lineStartDate";
                                                        }
                                                    } else {
                                                        str = "lineIntroduction";
                                                    }
                                                } else {
                                                    str = "lineEndDate";
                                                }
                                            } else {
                                                str = "imgNoticeInfo";
                                            }
                                        } else {
                                            str = "imgIssues";
                                        }
                                    } else {
                                        str = "imgEditor";
                                    }
                                } else {
                                    str = "imgClose";
                                }
                            } else {
                                str = "coverView";
                            }
                        } else {
                            str = "btnPublishFeed";
                        }
                    } else {
                        str = "btnNotifyFans";
                    }
                } else {
                    str = "btnCreate";
                }
            } else {
                str = "btnBothAction";
            }
        } else {
            str = "bgLine";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.y;
    }
}
