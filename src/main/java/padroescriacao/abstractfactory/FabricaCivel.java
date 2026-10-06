package padroescriacao.abstractfactory;

public class FabricaCivel implements FabricaJudicial {

    @Override
    public Peticao createPeticao() {
        return new PeticaoCivel();
    }

    @Override
    public Sentenca createSentenca() {
        return new SentencaCivel();
    }
}
