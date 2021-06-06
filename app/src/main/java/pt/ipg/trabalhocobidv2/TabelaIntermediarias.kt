package pt.ipg.trabalhocobidv2

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaIntermediarias (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL(
            "CREATE TABLE " + NOME_TABELA + "(" +
                    "FOREIGN KEY,(" + BaseColumns._ID + ") " +
                    "REFERENCES " + TabelaAfetados.NOME_TABELA  +
                    "FOREIGN KEY(" + BaseColumns._ID + ") " +
                    "REFERENCES " + TabelaVoluntarios.NOME_TABELA  +
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
        const val NOME_TABELA = "Intermediaria"

    }
}