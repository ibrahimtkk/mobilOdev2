package com.example.a15011018_persinf;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private static final String TAG = "MyAdapter";
    private ArrayList<String> mDersNotlari = new ArrayList<>();
    private Context mContext;
    private ArrayList<Drawable> drawableArrayList;
    private ArrayList<Ders> dersler = new ArrayList<>();

    public MyAdapter(Context mContext, ArrayList<Drawable> drawableArrayList, ArrayList<Ders> dersler) {
        this.mContext = mContext;
        this.drawableArrayList = drawableArrayList;
        this.dersler =  dersler;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName, dersNotu;
        RelativeLayout parentLayout;
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            dersNotu = itemView.findViewById(R.id.dersNotuTextView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        // Download the pictures from URL
        // Glide.with(mContext)
        //         .asBitmap()
        //         .load(mImages.get(position))
        //         .into(holder.image);
//
        Glide.with(mContext)
                .load(drawableArrayList.get(position))
                .into(holder.image);

        holder.imageName.setText(dersler.get(position).getDersIsmi());
        holder.dersNotu.setText(dersler.get(position).getNot());

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click on: "+ dersler.get(position).getDersIsmi());
                Intent intent = new Intent(mContext, dersAyrinti.class);
                intent.putExtra("dersAdi", dersler.get(position).getDersIsmi());
                intent.putExtra("notOrt", dersler.get(position).getNotOrt());
                intent.putExtra("hocaAdi", dersler.get(position).getHocaAdi());
                intent.putExtra("ogrSayisi", dersler.get(position).getOgrSayisi());
                mContext.startActivity(intent);
                Toast.makeText(mContext, dersler.get(position).getDersIsmi(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dersler.size();
    }
}