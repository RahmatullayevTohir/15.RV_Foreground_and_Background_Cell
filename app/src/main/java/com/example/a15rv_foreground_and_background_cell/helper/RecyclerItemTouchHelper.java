package com.example.a15rv_foreground_and_background_cell.helper;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a15rv_foreground_and_background_cell.adapter.CustomAdapter;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private RecyclerItemTouchHelperListener listener;

    public RecyclerItemTouchHelper(int dragDris, int swipeDris, RecyclerItemTouchHelperListener listener){
        super(dragDris,swipeDris);
        this.listener = listener;
    }
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        listener.onSwiped(viewHolder, direction,viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null){
            final View foregrounView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;
        }
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;
        getDefaultUIUtil().onDrawOver(c,recyclerView,foregroundView,dX/3,dY,actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder)viewHolder).view_foreground;
        getDefaultUIUtil().onDraw(c,recyclerView, foregroundView,dX/3,dY,actionState,isCurrentlyActive);
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    public interface RecyclerItemTouchHelperListener{
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
    }
}
