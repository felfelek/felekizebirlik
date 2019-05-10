package com.lecboxyazilim.lecbox;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class TeachersListAdapter extends RecyclerView.Adapter<TeachersListAdapter.ViewHolder> {
    public List<Teachers> teachersList;
    public TeachersListAdapter(List<Teachers> teachersList){
        this.teachersList = teachersList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameText.setText(teachersList.get(i).getName());
        viewHolder.statusText.setText(teachersList.get(i).getStatus());

    }

    @Override
    public int getItemCount() {
        return teachersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public TextView nameText;
        public TextView statusText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            nameText = (TextView) mView.findViewById(R.id.nameText);
            statusText = (TextView) mView.findViewById(R.id.statusText);
        }
    }
}
