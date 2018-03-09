package id.co.imastudio.pesertaimastudio.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.co.imastudio.pesertaimastudio.R;
import id.co.imastudio.pesertaimastudio.db.model.ModelPeserta;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.PelatihanViewHolder> {
    private List<ModelPeserta> modelPesertas;
    private View.OnLongClickListener longClickListener;

    public MainAdapter(List<ModelPeserta> userModelLiveData, View.OnLongClickListener longClickListener) {
        this.modelPesertas = userModelLiveData;
        this.longClickListener = longClickListener;
    }

    @Override
    public PelatihanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PelatihanViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(PelatihanViewHolder holder, int position) {
        ModelPeserta userModel = modelPesertas.get(position);
        holder.textPelatihan.setText(userModel.getTraining_peserta());
        holder.textNama.setText(userModel.getNama_peserta());
        holder.itemView.setTag(userModel);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return modelPesertas.size();
    }

    public void addUser(List<ModelPeserta> modelModels) {
        this.modelPesertas = modelModels;
        notifyDataSetChanged();
    }

    public class PelatihanViewHolder extends RecyclerView.ViewHolder {
        TextView textNama;
        TextView textPelatihan;

        public PelatihanViewHolder(View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.nama);
            textPelatihan = itemView.findViewById(R.id.edtPelatihan);
        }
    }
}
