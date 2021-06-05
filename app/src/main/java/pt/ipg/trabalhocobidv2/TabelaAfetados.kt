package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaAfetados (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL(
            "CREATE TABLE " + NOME_TABELA + "(" +
                    BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CAMPO_NOME + " TEXT NOT NULL, " +
                    CAMPO_ENDERECO + " TEXT NOT NULL, " +
                    CAMPO_NECESSIDADE + " TEXT NOT NULL, " +
                    CAMPO_DATA_NASCIMENTO + " INTEGER NOT NULL, " +
                    CAMPO_TELEMOVEL + " INTEGER NOT NULL, " +
                    CAMPO_DESCRCAO_PROBLEMA + " TEXT NOT NULL, " +
                    ")")
    }

    companion object {
        const val NOME_TABELA = "afetados"
        const val CAMPO_NOME = "nome"
        const val CAMPO_ENDERECO = "endereco"
        const val CAMPO_NECESSIDADE = "necessidade"
        const val CAMPO_DATA_NASCIMENTO = "data nascimento"
        const val CAMPO_TELEMOVEL = "telemovel"
        const val CAMPO_DESCRCAO_PROBLEMA = "Descrcao do problema"
    }
}