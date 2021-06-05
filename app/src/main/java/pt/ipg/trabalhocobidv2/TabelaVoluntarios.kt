package pt.ipg.trabalhocobidv2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaVoluntarios (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME + " TEXT NOT NULL, " +
                CAMPO_LOCALIZACAO + " TEXT NOT NULL, " +
                CAMPO_EMAIL + " TEXT NOT NULL, " +
                CAMPO_DISPONIBILIDADE + " BOOLEAN NOT NULL, " +
                CAMPO_TELEMOVEL + " INTEGER NOT NULL, " +
                CAMPO_AREA_CONHECIMENTO + " TEXT NOT NULL, " +
                ")")
    }

    companion object {
        const val NOME_TABELA = "voluntarios"
        const val CAMPO_NOME = "nome"
        const val CAMPO_LOCALIZACAO = "endereco"
        const val CAMPO_EMAIL = "necessidade"
        const val CAMPO_DISPONIBILIDADE = "data nascimento"
        const val CAMPO_TELEMOVEL = "telemovel"
        const val CAMPO_AREA_CONHECIMENTO = "area conhecimento"

    }
}