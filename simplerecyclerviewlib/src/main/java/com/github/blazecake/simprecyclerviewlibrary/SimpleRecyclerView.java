package com.github.blazecake.simprecyclerviewlibrary;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by MZ on 2017/4/17.
 */

public class SimpleRecyclerView extends RecyclerView {

    private boolean isLoadable=true; //是否可加载更多
    private boolean loading=false;
    private int previousTotal=0;
    private LinearLayoutManager layoutManager;

    private OnLoadMoreListener onLoadMoreListener;

    public void setLoadable(boolean loadable) {
        isLoadable = loadable;
    }

    public void setLinearLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        setLayoutManager(layoutManager);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public SimpleRecyclerView(Context context) {
        this(context, null, 0);
    }

    public SimpleRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(layoutManager);

        setHasFixedSize(true);
        setItemAnimator(new DefaultItemAnimator());

        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(isLoadable) {
                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                    int totalItemCount = layoutManager.getItemCount();
                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false;
                            previousTotal = totalItemCount;
                        }
                    }else{
                        previousTotal = totalItemCount;
                    }
                    if (!loading && lastVisibleItem >= totalItemCount - 1) {
                        loading=true;
                        if(onLoadMoreListener!=null){
                            onLoadMoreListener.onLoadMore();
                        }
                    }
                }
            }
        });
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }

}
