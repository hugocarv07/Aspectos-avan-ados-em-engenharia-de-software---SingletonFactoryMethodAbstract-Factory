package padroescriacao.factorymethod;

/**
 * Factory Method: cria o serviço judicial a partir do nome ("Protocolo",
 * "Arquivamento", "Recurso", "Suspensao").
 */
public class ServicoJudicialFactory {

    private ServicoJudicialFactory() {
    }

    public static IServicoJudicial obterServico(String servico) {
        if (servico == null || servico.isBlank()) {
            throw new IllegalArgumentException("Serviço inexistente");
        }
        Object objeto;
        try {
            Class<?> classe = Class.forName("padroescriacao.factorymethod.Servico" + servico);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException ex) {
            throw new IllegalArgumentException("Serviço inexistente");
        }
        if (!(objeto instanceof IServicoJudicial)) {
            throw new IllegalArgumentException("Serviço inválido");
        }
        return (IServicoJudicial) objeto;
    }
}
