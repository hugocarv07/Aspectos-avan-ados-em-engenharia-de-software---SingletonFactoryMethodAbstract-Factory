package padroescriacao.factorymethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ServicoJudicialFactoryTest {

    @ParameterizedTest
    @CsvSource({
            "Protocolo,Protocolo efetivado,Protocolo cancelado",
            "Arquivamento,Arquivamento efetivado,Arquivamento cancelado",
            "Recurso,Recurso efetivado,Recurso cancelado",
            "Suspensao,Suspensão efetivada,Suspensão cancelada"
    })
    void criaServicoCorretoEComportamentoEsperado(String nome, String executar, String cancelar) {
        IServicoJudicial servico = ServicoJudicialFactory.obterServico(nome);

        assertEquals(executar, servico.executar());
        assertEquals(cancelar, servico.cancelar());
    }

    @Test
    void criaClasseConcretaCorreta() {
        assertInstanceOf(ServicoProtocolo.class, ServicoJudicialFactory.obterServico("Protocolo"));
        assertInstanceOf(ServicoRecurso.class, ServicoJudicialFactory.obterServico("Recurso"));
    }

    @Test
    void cadaChamadaRetornaNovaInstancia() {
        assertNotSame(ServicoJudicialFactory.obterServico("Protocolo"),
                ServicoJudicialFactory.obterServico("Protocolo"));
    }

    @Test
    void servicoInexistenteLancaExcecao() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ServicoJudicialFactory.obterServico("Inexistente"));
        assertEquals("Serviço inexistente", ex.getMessage());
    }

    @Test
    void nomeNuloOuVazioLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> ServicoJudicialFactory.obterServico(null));
        assertThrows(IllegalArgumentException.class, () -> ServicoJudicialFactory.obterServico("  "));
    }

    @Test
    void classeQueNaoImplementaInterfaceLancaServicoInvalido() {
        // "Factory" resolve para ServicoFactory?  Não existe; usamos uma classe sem a interface.
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ServicoJudicialFactory.obterServico("Invalido"));
        assertEquals("Serviço inválido", ex.getMessage());
    }
}
