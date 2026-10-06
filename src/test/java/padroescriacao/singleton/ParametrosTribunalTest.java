package padroescriacao.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosTribunalTest {

    @Test
    void getInstanceRetornaSempreAMesmaInstancia() {
        assertSame(ParametrosTribunal.getInstance(), ParametrosTribunal.getInstance());
    }

    @Test
    void estadoEhCompartilhadoEntreAsReferencias() {
        ParametrosTribunal a = ParametrosTribunal.getInstance();
        ParametrosTribunal b = ParametrosTribunal.getInstance();

        a.setNomeTribunal("Tribunal Regional Federal");
        a.setUsuarioLogado("Juíza Ana");

        assertEquals("Tribunal Regional Federal", b.getNomeTribunal());
        assertEquals("Juíza Ana", b.getUsuarioLogado());
    }

    @Test
    void construtorEhPrivado() {
        Constructor<?>[] construtores = ParametrosTribunal.class.getDeclaredConstructors();
        assertEquals(1, construtores.length);
        assertTrue(Modifier.isPrivate(construtores[0].getModifiers()));
    }
}
