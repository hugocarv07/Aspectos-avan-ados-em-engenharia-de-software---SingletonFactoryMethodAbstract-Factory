package padroescriacao.integracao;

import padroescriacao.abstractfactory.FabricaJudicial;
import padroescriacao.abstractfactory.Processo;
import padroescriacao.factorymethod.IServicoJudicial;
import padroescriacao.factorymethod.ServicoJudicialFactory;
import padroescriacao.singleton.ParametrosTribunal;

/**
 * Integra os três padrões:
 * - Singleton: dados da sessão (tribunal e usuário logado);
 * - Factory Method: criação do serviço judicial pelo nome;
 * - Abstract Factory: criação da família de documentos do processo (cível ou criminal).
 */
public class SistemaJudicial {

    public String executarServico(String nomeServico) {
        IServicoJudicial servico = ServicoJudicialFactory.obterServico(nomeServico);
        return identificacao() + servico.executar();
    }

    public String cancelarServico(String nomeServico) {
        IServicoJudicial servico = ServicoJudicialFactory.obterServico(nomeServico);
        return identificacao() + servico.cancelar();
    }

    public Processo abrirProcesso(String numero, FabricaJudicial fabrica) {
        exigirUsuarioLogado();
        return new Processo(numero, fabrica);
    }

    public String emitirDocumentos(Processo processo) {
        return identificacao() + "Processo " + processo.getNumero()
                + " -> " + processo.emitirPeticao()
                + " | " + processo.emitirSentenca();
    }

    private String identificacao() {
        exigirUsuarioLogado();
        ParametrosTribunal p = ParametrosTribunal.getInstance();
        return "[" + p.getNomeTribunal() + " | " + p.getUsuarioLogado() + "] ";
    }

    private void exigirUsuarioLogado() {
        String usuario = ParametrosTribunal.getInstance().getUsuarioLogado();
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalStateException("Nenhum usuário logado");
        }
    }
}
