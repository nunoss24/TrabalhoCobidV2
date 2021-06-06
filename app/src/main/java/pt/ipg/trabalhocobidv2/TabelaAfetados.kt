package pt.ipg.trabalhocobidv2

import android.content.ContentValues
import android.database.Cursor
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
                    CAMPO_DESCRCAO_PROBLEMA + " TEXT NOT NULL " +
                    ")")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaVoluntarios.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaVoluntarios.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaVoluntarios.NOME_TABELA, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(TabelaVoluntarios.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
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