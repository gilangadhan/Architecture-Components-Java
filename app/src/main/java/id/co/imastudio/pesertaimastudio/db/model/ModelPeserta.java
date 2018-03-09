package id.co.imastudio.pesertaimastudio.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "peserta")
public class ModelPeserta {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_peserta")
    int id_peserta;

    @ColumnInfo(name = "nama_peserta")
    String nama_peserta;

    @ColumnInfo(name = "training_peserta")
    String training_peserta;

    public ModelPeserta(String nama_peserta, String training_peserta) {
        this.nama_peserta = nama_peserta;
        this.training_peserta = training_peserta;
    }

    @NonNull
    public int getId_peserta() {
        return id_peserta;
    }

    public void setId_peserta(@NonNull int id_peserta) {
        this.id_peserta = id_peserta;
    }

    public String getNama_peserta() {
        return nama_peserta;
    }

    public void setNama_peserta(String nama_peserta) {
        this.nama_peserta = nama_peserta;
    }

    public String getTraining_peserta() {
        return training_peserta;
    }

    public void setTraining_peserta(String training_peserta) {
        this.training_peserta = training_peserta;
    }
}
