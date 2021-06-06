package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaIntermediarias (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL(
            "CREATE TABLE " + NOME_TABELA + "(" +
                    BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FOREIGN KEY(" + BaseColumns._ID + ") " +
                    "REFERENCES " + TabelaAfetados.NOME_TABELA  +
                    "FOREIGN KEY(" + BaseColumns._ID + ") " +
                    "REFERENCES " + TabelaVoluntarios.NOME_TABELA  +
                    ")")
    }

    companion object {
        const val NOME_TABELA = "Intermediaria"

    }
}