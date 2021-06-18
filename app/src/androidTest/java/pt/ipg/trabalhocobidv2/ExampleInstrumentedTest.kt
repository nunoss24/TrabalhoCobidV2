package pt.ipg.trabalhocobidv2

import android.content.ContentValues
import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class TestesBaseDados {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext
    private fun getBdCovidOpenHelper() = BdCovidOpenHelper(getAppContext())

    private fun insertVoluntarios(tabelaVoluntarios: TabelaVoluntarios, voluntario: Voluntario): Long {
        val id = tabelaVoluntarios.insert(voluntario.toContentValues())
        assertNotEquals(-1, id)

        return id
    }

    private fun GetVoluntarioBd(tabelaVoluntarios: TabelaVoluntarios, id: Long): Voluntario {
        val cursor = tabelaVoluntarios.query(
            TabelaVoluntarios.TODOS_CAMPOS,
            "${BaseColumns._ID}=?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        assertNotNull(cursor)
        assert(cursor!!.moveToNext())

        return Voluntario.fromCursor(cursor)

    }

    @Before
    fun apagaBaseDados(){
        getAppContext().deleteDatabase(BdCovidOpenHelper.NOME_BASE_DADOS)
    }
    @Test
    fun consegueAbrirBaseDados() {
        val db = getBdCovidOpenHelper().readableDatabase
        assert(db.isOpen)
        db.close()
    }
    @Test
    fun consegueInserirVoluntarios() {
        val db = getBdCovidOpenHelper().writableDatabase

        val voluntario = Voluntario(nome = "Afonso Costa", localizacao = "Viseu", email = "acosta@gmail.com", disponibilidade = "0", telemovel = "912234234", area_conhecimento = "Cuidados médicos" )
        voluntario.id = insertVoluntarios(TabelaVoluntarios(db), voluntario)

        assertEquals(voluntario, GetVoluntarioBd(TabelaVoluntarios(db), voluntario.id))




        db.close()
    }
}