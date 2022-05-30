package com.pesonal.adsdk.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pesonal.adsdk.R;
import com.pesonal.adsdk.remote.APIManager;


public class PrivacyDialog {
    public static void show(Activity context, String[] strings) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().addFlags(2);
        dialog.getWindow().setDimAmount(0.7f);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.policy_dialog);
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.policiesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PrivacyAdapter(strings));
        ((RelativeLayout) dialog.findViewById(R.id.acceptButton)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        APIManager instance = APIManager.getInstance(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((RelativeLayout) dialog.findViewById(R.id.acceptButton)).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(instance.getButtonColor())));
        } else {
            ((RelativeLayout) dialog.findViewById(R.id.acceptButton)).setBackgroundColor(Color.parseColor(instance.getButtonColor()));
        }
        ((TextView) dialog.findViewById(R.id.txtBtn)).setTextColor(Color.parseColor(instance.getButtonTextColor()));

        dialog.show();
    }

    public static class PrivacyAdapter extends RecyclerView.Adapter<PrivacyAdapter.Holder> {
        String[] strings;

        public class Holder extends RecyclerView.ViewHolder {
            private TextView tvItem;

            public Holder(@NonNull View itemView) {
                super(itemView);
                this.tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            }
        }

        public PrivacyAdapter(String[] strings) {
            this.strings = strings;
        }

        @NonNull
        public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_privacy_policy, viewGroup, false));
        }

        public void onBindViewHolder(@NonNull Holder holder, int i) {
            holder.tvItem.setText(this.strings[i]);
        }

        public int getItemCount() {
            return this.strings.length;
        }
    }
}
