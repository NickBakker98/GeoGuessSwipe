package com.example.nick0.geoguessswipe.View;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.nick0.geoguessswipe.Model.GeoObject;
import com.example.nick0.geoguessswipe.R;
import com.example.nick0.geoguessswipe.Util.GeoObjectAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public GeoObjectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<GeoObject> mGeoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {

            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], GeoObject.PRE_DEFINED_GEO_OBJECT_INEUROPE[i]));
        }

        recyclerView = findViewById(R.id.recyclerView);

        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        recyclerView.setAdapter(mAdapter);

        // Layoutmanager: Tells the RecyclerView how to layout all those views

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallBack =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    //Creating the swipe function for the pictures.
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int position = (viewHolder.getAdapterPosition());
                        boolean isEurope = mAdapter.getItem(position).getmGeoInEurope();

                        if (swipeDir == ItemTouchHelper.LEFT && isEurope ) {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), getText(R.string.Europe), Snackbar.LENGTH_INDEFINITE);
                            snackbar.show();
                        } else {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), getText(R.string.Loser), Snackbar.LENGTH_INDEFINITE);
                            snackbar.show();
                        }
                        if (swipeDir == ItemTouchHelper.RIGHT && !isEurope ) {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), getText(R.string.Not_Europe), Snackbar.LENGTH_INDEFINITE);
                            snackbar.show();
                        } else {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), getText(R.string.Loser), Snackbar.LENGTH_INDEFINITE);
                            snackbar.show();
                        }
                        mAdapter.removeItem(position);
                        mAdapter.notifyItemRemoved(position);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallBack);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
