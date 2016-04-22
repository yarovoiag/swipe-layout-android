package ru.rambler.swipe_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.rambler.libs.swipe_layout.SwipeLayout;

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
            final ViewHolder viewHolder = new ViewHolder(itemView);

            View.OnClickListener onClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.swipeLayout.animateReset();
                }
            };

            if (viewHolder.leftView != null) {
                viewHolder.leftView.setClickable(true);
                viewHolder.leftView.setOnClickListener(onClick);
            }

            if (viewHolder.rightView != null) {
                viewHolder.rightView.setClickable(true);
                viewHolder.rightView.setOnClickListener(onClick);
            }

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
            private final SwipeLayout swipeLayout;
            private final View rightView;
            private final View leftView;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewPos = (TextView) itemView.findViewById(R.id.text_view_pos);
                swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe_layout);
                rightView = itemView.findViewById(R.id.right_view);
                leftView = itemView.findViewById(R.id.left_view);
            }
        }
    }
}
