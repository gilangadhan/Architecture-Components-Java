package id.co.imastudio.pesertaimastudio.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import id.co.imastudio.pesertaimastudio.db.dao.DaoPeserta;
import id.co.imastudio.pesertaimastudio.db.model.ModelPeserta;

@Database(entities = {ModelPeserta.class}, version = 1)
public abstract class DbApp extends RoomDatabase {

    private static volatile DbApp INSTANCE;

    public static DbApp getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DbApp.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DbApp.class, "user_db").build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract DaoPeserta itemAndPesertaModel();
}
