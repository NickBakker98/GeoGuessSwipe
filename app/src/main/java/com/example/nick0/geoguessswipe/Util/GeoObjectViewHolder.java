package com.example.nick0.geoguessswipe.Util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nick0.geoguessswipe.R;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView geoImage;
    public View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        geoImage = itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}
