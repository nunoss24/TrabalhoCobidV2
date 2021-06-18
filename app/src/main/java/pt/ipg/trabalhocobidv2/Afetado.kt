package pt.ipg.trabalhocobidv2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Afetado(var id: Long = -1, var nome: String, var endereco: String, var necessidade: String, var data_nascimento: Int, var telemovel: String, var descricao_problema: String) {
    fun toContentValues(): ContentValues {
        val valores = ContentValues().apply{
            put(TabelaAfetados.CAMPO_NOME, nome)
            put(TabelaAfetados.CAMPO_ENDERECO, endereco)
            put(TabelaAfetados.CAMPO_NECESSIDADE, necessidade)
            put(TabelaAfetados.CAMPO_DATA_NASCIMENTO, data_nascimento)
            put(TabelaAfetados.CAMPO_TELEMOVEL, telemovel)
            put(TabelaAfetados.CAMPO_DESCRICAO_PROBLEMA, descricao_problema)
        }
        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Afetado {

            val posCampoId = cursor.getColumnIndex(BaseColumns._ID)
            val posCampoNome = cursor.getColumnIndex(TabelaAfetados.CAMPO_NOME)
            val posCampoEndereco = cursor.getColumnIndex(TabelaAfetados.CAMPO_ENDERECO)
            val posCampoNecessidade = cursor.getColumnIndex(TabelaAfetados.CAMPO_NECESSIDADE)
            val posCampoDataNascimento = cursor.getColumnIndex(TabelaAfetados.CAMPO_DATA_NASCIMENTO)
            val posCampoTelemovel = cursor.getColumnIndex(TabelaAfetados.CAMPO_TELEMOVEL)
            val posCampoDescricaoProblema = cursor.getColumnIndex(TabelaAfetados.CAMPO_DESCRICAO_PROBLEMA)

            val id = cursor.getLong(posCampoId)
            val nome = cursor.getString(posCampoNome)
            val endereco = cursor.getString(posCampoEndereco)
            val necessidade = cursor.getString(posCampoNecessidade)
            val DataNascimento = cursor.getInt(posCampoDataNascimento)
            val Telemovel = cursor.getString(posCampoTelemovel)
            val DescricaoProblema = cursor.getString(posCampoDescricaoProblema)

            return Afetado(
                id,
                nome,
                endereco,
                necessidade,
                DataNascimento,
                Telemovel,
                DescricaoProblema
            )
        }
    }
}