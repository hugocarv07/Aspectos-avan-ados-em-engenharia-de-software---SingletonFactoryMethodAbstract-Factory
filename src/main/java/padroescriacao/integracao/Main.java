package padroescriacao.integracao;

import padroescriacao.abstractfactory.FabricaCivel;
import padroescriacao.abstractfactory.FabricaCriminal;
import padroescriacao.abstractfactory.Processo;
import padroescriacao.singleton.ParametrosTribunal;

public class Main {

    public static void main(String[] args) {
        ParametrosTribunal parametros = ParametrosTribunal.getInstance();
        parametros.setNomeTribunal("Tribunal de Justiça de Minas Gerais");
        parametros.setUsuarioLogado("Dr. Hugo");

        SistemaJudicial sistema = new SistemaJudicial();

        System.out.println(sistema.executarServico("Protocolo"));
        System.out.println(sistema.executarServico("Recurso"));
        System.out.println(sistema.cancelarServico("Suspensao"));

        Processo civel = sistema.abrirProcesso("0001234-56.2026.8.13.0145", new FabricaCivel());
        Processo criminal = sistema.abrirProcesso("0007890-12.2026.8.13.0145", new FabricaCriminal());

        System.out.println(sistema.emitirDocumentos(civel));
        System.out.println(sistema.emitirDocumentos(criminal));
    }
}
