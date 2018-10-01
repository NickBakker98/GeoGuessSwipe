package com.example.nick0.geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;



public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    // We will not support moves in the list
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }


    //Called when a user swipes left or right on a ViewHolder
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

        //Get the index corresponding to the selected position
        int position = (viewHolder.getAdapterPosition());
        //viewHolder.remove(position);
        //mAdapter.notifyItemRemoved(position);
        // Hier moet de logica komen of het goed of fout is
        // if swipedir = LEFT then
        // user thinks in Europe = true
        // check if INEUROPE[position] == true
        // then success
        // else fail
        // if swipedir = RIGHT then
        // user thinks in Europe = false
        // check if INEUROPE[position] == false
        // then success
        // else fail

        //if (mGeoObjects.PRE_DEFINED_GEO_OBJECT_INEUROPE[position] == true)
        //mGeoObjects.remove(position);
        //mAdapter.notifyItemRemoved(position);
    }



}
