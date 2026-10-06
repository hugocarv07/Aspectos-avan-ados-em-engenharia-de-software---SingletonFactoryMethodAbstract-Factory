package padroescriacao.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessoAbstractFactoryTest {

    @Test
    void fabricaCivelCriaFamiliaCivel() {
        FabricaJudicial fabrica = new FabricaCivel();

        assertInstanceOf(PeticaoCivel.class, fabrica.createPeticao());
        assertInstanceOf(SentencaCivel.class, fabrica.createSentenca());
    }

    @Test
    void fabricaCriminalCriaFamiliaCriminal() {
        FabricaJudicial fabrica = new FabricaCriminal();

        assertInstanceOf(PeticaoCriminal.class, fabrica.createPeticao());
        assertInstanceOf(SentencaCriminal.class, fabrica.createSentenca());
    }

    @Test
    void processoCivelEmiteDocumentosCiveis() {
        Processo processo = new Processo("001", new FabricaCivel());

        assertEquals("001", processo.getNumero());
        assertEquals("Petição Inicial Cível", processo.emitirPeticao());
        assertEquals("Sentença Cível", processo.emitirSentenca());
    }

    @Test
    void processoCriminalEmiteDocumentosCriminais() {
        Processo processo = new Processo("002", new FabricaCriminal());

        assertEquals("Denúncia Criminal", processo.emitirPeticao());
        assertEquals("Sentença Criminal", processo.emitirSentenca());
    }

    @Test
    void familiasNaoSeMisturam() {
        Processo civel = new Processo("003", new FabricaCivel());
        Processo criminal = new Processo("004", new FabricaCriminal());

        assertNotEquals(civel.emitirPeticao(), criminal.emitirPeticao());
        assertNotEquals(civel.emitirSentenca(), criminal.emitirSentenca());
    }
}
