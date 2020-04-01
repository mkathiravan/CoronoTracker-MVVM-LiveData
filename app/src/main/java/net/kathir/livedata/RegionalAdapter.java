package net.kathir.livedata;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionalAdapter extends RecyclerView.Adapter<RegionalAdapter.RegionalViewHolder> {

    private Context mCtx;
    private List<RegionalModel> regionalModelList;
    RegionalAdapter.DataFromAdapterToActivity dataFromAdapterToActivity;

    public RegionalAdapter(Context mCtx, List<RegionalModel> regionalModelList, RegionalAdapter.DataFromAdapterToActivity listener) {
        this.mCtx = mCtx;
        this.regionalModelList = regionalModelList;
        this.dataFromAdapterToActivity = listener;
    }

    @Override
    public RegionalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_adapter,parent,false);
        return new RegionalAdapter.RegionalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RegionalViewHolder holder, int position) {
        //getting the product of the specified position
        RegionalModel regionalModel = regionalModelList.get(position);

        holder.regionalStateText.setText(regionalModel.getLoc());

        int indian_count = regionalModel.getConfirmedCasesIndian();
        int foreign_count = regionalModel.getConfirmedCasesForeign();
        int total = indian_count + foreign_count;

        holder.patientCount.setText(String.valueOf(total));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dataFromAdapterToActivity.getRegionalInfo(regionalModelList.get(position));
            }
        });


    }


    public interface DataFromAdapterToActivity
    {
        public void getRegionalInfo(RegionalModel regionalModel);
    }


    @Override
    public int getItemCount() {
        return regionalModelList.size();
    }


    class RegionalViewHolder extends RecyclerView.ViewHolder {

        public TextView regionalStateText, patientCount;
        public CardView cardView;

        public RegionalViewHolder(View itemView) {
            super(itemView);

            regionalStateText = itemView.findViewById(R.id.regionalName);
            patientCount =  itemView.findViewById(R.id.patient_count);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }

}
