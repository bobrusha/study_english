package com.bobrusha.android.yandex.english;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aleksandra on 23/07/16.
 */
public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {
    private final List<String> dataset;

    public TrainingAdapter(List<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_choose_training, parent, false);
        return new TrainingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (position < dataset.size()) {
            holder.bind(dataset.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataset != null ? dataset.size() : 0;
    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        private final TextView trainingNameTextView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            trainingNameTextView = (TextView) itemView.findViewById(R.id.text_view_name_of_training);
        }

        public void bind(final String training) {
            trainingNameTextView.setText(training);
        }
    }
}
