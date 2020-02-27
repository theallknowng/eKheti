package com.example.cropad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ViewHolder> {
    private Context context;
    private ArrayList<expertdata> dataList;

    public ExpertAdapter(Context context, ArrayList<expertdata> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.expert_item1,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageView imageView = holder.imageView;
        TextView title = holder.title;
        TextView author = holder.author;
        final String link=dataList.get(position).getLink();

        title.setText(dataList.get(position).getTitle());
        author.setText(dataList.get(position).getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));


                // Always use string resources for UI text. This says something like "Share this photo with"
                String title = "Select to open";
                // Create and start the chooser
                Intent chooser = Intent.createChooser(intent, title);
                chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(chooser);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, author;
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgtitle1);
            title = itemView.findViewById(R.id.title1);
            author = itemView.findViewById(R.id.authorname1);
            linearLayout=itemView.findViewById(R.id.expert_item);

        }
    }
}
