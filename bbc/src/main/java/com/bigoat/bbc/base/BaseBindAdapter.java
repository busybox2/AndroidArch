package com.bigoat.bbc.base;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 数据绑定适配器
 *
 * @param <Item>
 * @param <ItemBind>
 */
public abstract class BaseBindAdapter<Item, ItemBind extends ViewDataBinding> extends BaseQuickAdapter<Item, BaseViewHolder> implements LoadMoreModule {

    public BaseBindAdapter(int layoutResId, @Nullable List<Item> data) {
        super(layoutResId, data);
    }

    public BaseBindAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Item item) {
        if (item == null) {
            return;
        }



        ItemBind binding = DataBindingUtil.getBinding(holder.itemView);
        if (binding != null) {
            convert(holder, item, binding);
            binding.executePendingBindings();
        }

    }

    public abstract void convert(@NotNull BaseViewHolder holder, Item item, ItemBind itemBind);
}
