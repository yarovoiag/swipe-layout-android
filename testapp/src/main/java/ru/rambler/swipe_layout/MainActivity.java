package ru.rambler.swipe_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(new Adapter());
    }


    private static class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        @Override
        public int getItemViewType(int position) {
            return position % 3;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layoutId;
            switch (viewType) {
                case 0:
                    layoutId = R.layout.list_item_left_right;
                    break;

                case 1:
                    layoutId = R.layout.list_item_left;
                    break;

                case 2:
                    layoutId = R.layout.list_item_right;
                    break;

                default:
                    throw new IllegalArgumentException();
            }
            View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textViewPos.setText("#" + (position + 1));
        }

        @Override
        public int getItemCount() {
            return 30;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView textViewPos;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewPos = (TextView) itemView.findViewById(R.id.text_view_pos);
            }
        }
    }
}
