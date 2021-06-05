package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaVoluntarios (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE voluntarios(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL)")
    }
}