package id.co.imastudio.pesertaimastudio.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import id.co.imastudio.pesertaimastudio.db.DbApp;
import id.co.imastudio.pesertaimastudio.db.model.ModelPeserta;

public class MainViewModel extends AndroidViewModel {
    private final LiveData<List<ModelPeserta>> itemList;

    private DbApp db;

    //TODO inisialisasi
    public MainViewModel(@NonNull Application application) {
        super(application);
        //inil db
        db = DbApp.getDatabase(this.getApplication());
        //query get All
        itemList = db.itemAndPesertaModel().getAllPeserta();
    }

    public LiveData<List<ModelPeserta>> getAll(){
        return itemList;
    }

    public void deleteItem(ModelPeserta peserta){
        new deleteAsyncTask(db).execute(peserta);
    }

    private class deleteAsyncTask extends AsyncTask<ModelPeserta, Void, Void> {

        private DbApp db;

        public deleteAsyncTask(DbApp db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(ModelPeserta... userModels) {
            db.itemAndPesertaModel().deletePeserta(userModels[0]);
            return null;
        }
    }
}
