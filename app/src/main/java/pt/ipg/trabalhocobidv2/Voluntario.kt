package pt.ipg.trabalhocobidv2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Voluntario(var id: Long = -1, var nome: String, var localizacao: String, var email: String, var disponibilidade: String, var telemovel: String, var area_conhecimento: String) {
    fun toContentValues(): ContentValues {
        val valores = ContentValues().apply{
            put(TabelaVoluntarios.CAMPO_NOME, nome)
            put(TabelaVoluntarios.CAMPO_LOCALIZACAO, localizacao)
            put(TabelaVoluntarios.CAMPO_EMAIL, email)
            put(TabelaVoluntarios.CAMPO_DISPONIBILIDADE, disponibilidade)
            put(TabelaVoluntarios.CAMPO_TELEMOVEL, telemovel)
            put(TabelaVoluntarios.CAMPO_AREA_CONHECIMENTO, area_conhecimento)
        }
        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Voluntario {

            val posCampoId = cursor.getColumnIndex(BaseColumns._ID)
            val posCampoNome = cursor.getColumnIndex(TabelaVoluntarios.CAMPO_NOME)
            val posCampoLocalizacao = cursor.getColumnIndex(TabelaVoluntarios.CAMPO_LOCALIZACAO)
            val posCampoEmail = cursor.getColumnIndex(TabelaVoluntarios.CAMPO_EMAIL)
            val posCampoDisponibilidade =
                cursor.getColumnIndex(TabelaVoluntarios.CAMPO_DISPONIBILIDADE)
            val posCampoTelemovel = cursor.getColumnIndex(TabelaVoluntarios.CAMPO_TELEMOVEL)
            val posCampoAreaConhecimento =
                cursor.getColumnIndex(TabelaVoluntarios.CAMPO_AREA_CONHECIMENTO)

            val id = cursor.getLong(posCampoId)
            val nome = cursor.getString(posCampoNome)
            val localizacao = cursor.getString(posCampoLocalizacao)
            val email = cursor.getString(posCampoEmail)
            val Disponibilidade = cursor.getString(posCampoDisponibilidade)
            val Telemovel = cursor.getString(posCampoTelemovel)
            val AreaConhecimento = cursor.getString(posCampoAreaConhecimento)

            return Voluntario(
                id,
                nome,
                localizacao,
                email,
                Disponibilidade,
                Telemovel,
                AreaConhecimento
            )
        }
    }
}