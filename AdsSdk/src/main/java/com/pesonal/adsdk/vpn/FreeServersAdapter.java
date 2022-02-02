package com.pesonal.adsdk.vpn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.anchorfree.partner.api.data.Country;
import com.pesonal.adsdk.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FreeServersAdapter extends RecyclerView.Adapter<FreeServersAdapter.FreeServersViewHolder> {

    private List<Country> list = new ArrayList();
    Context context;
    private PassServerData mCallback;

    public FreeServersAdapter(Context context, List<Country> list, PassServerData passServerData) {
        this.context = context;
        this.list = list;
        mCallback = passServerData;
    }

    @Override
    public FreeServersViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new FreeServersViewHolder(inflater.inflate(R.layout.region_list_item, viewGroup, false));
    }

    public void onBindViewHolder(FreeServersViewHolder freeServersViewHolder, int i) {
        freeServersViewHolder.populateView((Country) list.get(i));
        freeServersViewHolder.mRegionImage.setImageResource(context.getResources().getIdentifier("drawable/" + list.get(i).getCountry(), null, context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FreeServersViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mItemView;
        private ImageView mRegionImage;
        private TextView mRegionTitle;
        private TextView btnChange;


        public FreeServersViewHolder(View view) {
            super(view);
            this.mRegionTitle = (TextView) view.findViewById(R.id.region_title);
            this.mRegionImage = (ImageView) view.findViewById(R.id.region_image);
            this.btnChange = (TextView) view.findViewById(R.id.btnChange);
            this.mItemView = (LinearLayout) view.findViewById(R.id.itemView);
        }

        public void populateView(final Country country) {
            this.mRegionTitle.setText(new Locale("", country.getCountry()).getDisplayCountry());
            ImageView imageView = this.mRegionImage;
            imageView.setImageResource(0);
            this.btnChange.setOnClickListener(view -> mCallback.getSelectedServer(country));
        }
    }
}