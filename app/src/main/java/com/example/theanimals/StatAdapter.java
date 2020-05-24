package com.example.theanimals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatAdapter extends RecyclerView.Adapter<StatAdapter.ViewHolder> {

    private static List<StatModel> statModelList;
    private static Context context;
    private static ImageClicked imageClicked;

    public StatAdapter(List<StatModel> statModelList, Context context, ImageClicked imageClicked) {
        this.statModelList = statModelList;
        this.context = context;
        this.imageClicked = imageClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = statModelList.get(position).getImageResource();
        String name = statModelList.get(position).getAnimalName();
        String info = statModelList.get(position).getInfo();

        ViewHolder.setData(image, name, info);
    }

    @Override
    public int getItemCount() {
        return statModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface ImageClicked{
        void imageClicked(StatModel statModel, Context context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imageView;
        private static TextView textView;
        private static TextView textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.AnimalImage);
            textView = itemView.findViewById(R.id.textViewStat);
            textTitle = itemView.findViewById(R.id.textName);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageClicked.imageClicked(statModelList.get(getAdapterPosition()), context);
                }
            });

        }

        public static void setData(int image, String name, String info) {
            imageView.setImageResource(image);
            textView.setText(info);
            textTitle.setText(name);
        }
    }
}
