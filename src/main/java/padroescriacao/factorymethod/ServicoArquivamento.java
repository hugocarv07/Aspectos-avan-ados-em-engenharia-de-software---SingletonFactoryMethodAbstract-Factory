package padroescriacao.factorymethod;

public class ServicoArquivamento implements IServicoJudicial {

    public String executar() {
        return "Arquivamento efetivado";
    }

    public String cancelar() {
        return "Arquivamento cancelado";
    }
}
