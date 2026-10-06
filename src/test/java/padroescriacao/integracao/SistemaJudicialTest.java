package padroescriacao.integracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padroescriacao.abstractfactory.FabricaCivel;
import padroescriacao.abstractfactory.FabricaCriminal;
import padroescriacao.abstractfactory.Processo;
import padroescriacao.singleton.ParametrosTribunal;

import static org.junit.jupiter.api.Assertions.*;

class SistemaJudicialTest {

    private SistemaJudicial sistema;

    @BeforeEach
    void preparar() {
        ParametrosTribunal parametros = ParametrosTribunal.getInstance();
        parametros.setNomeTribunal("TJMG");
        parametros.setUsuarioLogado("Dr. Hugo");
        sistema = new SistemaJudicial();
    }

    @Test
    void executarServicoUsaSingletonEFactoryMethod() {
        assertEquals("[TJMG | Dr. Hugo] Protocolo efetivado", sistema.executarServico("Protocolo"));
    }

    @Test
    void cancelarServicoUsaSingletonEFactoryMethod() {
        assertEquals("[TJMG | Dr. Hugo] Recurso cancelado", sistema.cancelarServico("Recurso"));
    }

    @Test
    void mudancaNoSingletonRefleteNasProximasOperacoes() {
        ParametrosTribunal.getInstance().setUsuarioLogado("Juíza Ana");

        assertEquals("[TJMG | Juíza Ana] Arquivamento efetivado", sistema.executarServico("Arquivamento"));
    }

    @Test
    void emitirDocumentosDeProcessoCivelUsaAbstractFactory() {
        Processo processo = sistema.abrirProcesso("0001", new FabricaCivel());

        assertEquals("[TJMG | Dr. Hugo] Processo 0001 -> Petição Inicial Cível | Sentença Cível",
                sistema.emitirDocumentos(processo));
    }

    @Test
    void emitirDocumentosDeProcessoCriminalUsaAbstractFactory() {
        Processo processo = sistema.abrirProcesso("0002", new FabricaCriminal());

        assertEquals("[TJMG | Dr. Hugo] Processo 0002 -> Denúncia Criminal | Sentença Criminal",
                sistema.emitirDocumentos(processo));
    }

    @Test
    void semUsuarioLogadoOperacoesSaoRecusadas() {
        ParametrosTribunal.getInstance().setUsuarioLogado(null);

        assertThrows(IllegalStateException.class, () -> sistema.executarServico("Protocolo"));
        assertThrows(IllegalStateException.class, () -> sistema.abrirProcesso("0003", new FabricaCivel()));
    }

    @Test
    void servicoInexistentePropagaExcecaoDaFactory() {
        assertThrows(IllegalArgumentException.class, () -> sistema.executarServico("Inexistente"));
    }
}
