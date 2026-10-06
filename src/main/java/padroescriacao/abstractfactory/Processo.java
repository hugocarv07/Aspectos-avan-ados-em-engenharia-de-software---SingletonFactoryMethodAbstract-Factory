package padroescriacao.abstractfactory;

public class Processo {

    private final String numero;
    private final Peticao peticao;
    private final Sentenca sentenca;

    public Processo(String numero, FabricaJudicial fabrica) {
        this.numero = numero;
        this.peticao = fabrica.createPeticao();
        this.sentenca = fabrica.createSentenca();
    }

    public String getNumero() {
        return numero;
    }

    public String emitirPeticao() {
        return this.peticao.emitir();
    }

    public String emitirSentenca() {
        return this.sentenca.emitir();
    }
}
