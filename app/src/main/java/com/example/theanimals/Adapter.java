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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private static List<Model> modelList;
    private static Context context;
    private static SelectedAnimal selected;

    public Adapter(List<Model> modelList, Context context, SelectedAnimal selected) {
        this.modelList = modelList;
        this.context = context;
        this.selected = selected;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imageResource = modelList.get(position).getImageResource();
        String nameTitle = modelList.get(position).getAnimalName();
        String bodyInfo = modelList.get(position).getInfo();
        int nextArrow = modelList.get(position).getNext();

        ViewHolder.setData(imageResource, nameTitle, bodyInfo, nextArrow);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public interface SelectedAnimal{
        void selected(Model model, Context context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imageView;
        private static TextView title;
        private static TextView body;
        private static ImageView next;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_resource);
            title = itemView.findViewById(R.id.textView_Title);
            body = itemView.findViewById(R.id.textView_body);
            next = itemView.findViewById(R.id.imageViewButton);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected.selected(modelList.get(getAdapterPosition()), context);
                }
            });

        }

        public static void setData(int imageResource, String nameTitle, String bodyInfo, int nextArrow) {

            imageView.setImageResource(imageResource);
            title.setText(nameTitle);
            body.setText(bodyInfo);
            next.setImageResource(nextArrow);
        }
    }
}
