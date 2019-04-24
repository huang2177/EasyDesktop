package com.xiaoxinghu.testwebview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Des:
 * Created by huang on 2019/4/24 0024 18:04
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private List<AppInfo> appInfo;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup v, int i) {
        return new ViewHolder(LayoutInflater.from(v.getContext()).inflate(R.layout.item_app, v, false), i);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tv.setText(appInfo.get(i).getName());
        holder.iv.setImageDrawable(appInfo.get(i).getIco());
    }

    @Override
    public int getItemCount() {
        return (appInfo == null) ? 0 : appInfo.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    void notifyDataChange(List<AppInfo> appInfo) {
        this.appInfo = appInfo;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv;
        TextView tv;
        private int position;

        ViewHolder(@NonNull View itemView, int position) {
            super(itemView);
            this.position = position;
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = view.getContext()
                    .getPackageManager()
                    .getLaunchIntentForPackage(appInfo.get(position).getPackageName());
            if (intent != null) {
                intent.putExtra("type", "110");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        }
    }
}