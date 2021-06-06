package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaEntidades (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL(
            "CREATE TABLE " + NOME_TABELA + "(" +
                    BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CAMPO_OFERTAS + " TEXT NOT NULL, " +
                    CAMPO_NOME + " TEXT NOT NULL, " +
                    CAMPO_TELEMOVEL + " INTEGER NOT NULL, " +
                    ")")
    }

    companion object {
        const val NOME_TABELA = "Entidades"
        const val CAMPO_NOME = "nome"
        const val CAMPO_OFERTAS = "ofertas"
        const val CAMPO_TELEMOVEL = "telemovel"
    }
}