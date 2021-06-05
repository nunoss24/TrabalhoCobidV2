package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase

class TabelaAfetados (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE afetados(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, autor TEXT NOT NULL, telemovel INTEGER NOT NULL)")
    }
}