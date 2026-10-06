package padroescriacao.factorymethod;

public class ServicoRecurso implements IServicoJudicial {

    public String executar() {
        return "Recurso efetivado";
    }

    public String cancelar() {
        return "Recurso cancelado";
    }
}
