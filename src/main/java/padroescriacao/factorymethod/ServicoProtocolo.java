package padroescriacao.factorymethod;

public class ServicoProtocolo implements IServicoJudicial {

    public String executar() {
        return "Protocolo efetivado";
    }

    public String cancelar() {
        return "Protocolo cancelado";
    }
}
