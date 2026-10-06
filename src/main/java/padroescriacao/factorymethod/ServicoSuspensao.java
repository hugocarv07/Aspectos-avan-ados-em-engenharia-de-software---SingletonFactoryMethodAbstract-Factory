package padroescriacao.factorymethod;

public class ServicoSuspensao implements IServicoJudicial {

    public String executar() {
        return "Suspensão efetivada";
    }

    public String cancelar() {
        return "Suspensão cancelada";
    }
}
