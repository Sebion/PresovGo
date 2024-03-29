package com.example.sebastian.presovgo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList <String> mImages = new ArrayList<>();
   private ArrayList<Double> mCoordinates =new ArrayList<>();
   private ArrayList<String>mLatLong=new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageNames, ArrayList<String> mImages,ArrayList<Double>mCoordinates,ArrayList<String>mLatLong) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
        this.mCoordinates=mCoordinates;
        this.mLatLong=mLatLong;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent ,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image) ;

        holder.imageName.setText(mImageNames.get(position));
        if(mCoordinates.get(position)!=0.0){
        holder.coordinates.setText("Distance to this church: "+mCoordinates.get(position)+" km.");}
        else{holder.coordinates.setText("Loading distance...");}
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+ mImageNames.get(position));

                           String[]pomoc= mLatLong.get(position).split(",");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<+"+pomoc[0]+"+>,<"+pomoc[1]+">?q=<+"+pomoc[0]+"+>,<"+pomoc[1]+">(Label+Name)"));
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        TextView coordinates;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            coordinates=itemView.findViewById(R.id.image_coordinates);
        }
    }
}