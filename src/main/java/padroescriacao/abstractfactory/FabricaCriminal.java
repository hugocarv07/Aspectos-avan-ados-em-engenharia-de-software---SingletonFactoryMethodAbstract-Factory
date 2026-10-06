package padroescriacao.abstractfactory;

public class FabricaCriminal implements FabricaJudicial {

    @Override
    public Peticao createPeticao() {
        return new PeticaoCriminal();
    }

    @Override
    public Sentenca createSentenca() {
        return new SentencaCriminal();
    }
}
