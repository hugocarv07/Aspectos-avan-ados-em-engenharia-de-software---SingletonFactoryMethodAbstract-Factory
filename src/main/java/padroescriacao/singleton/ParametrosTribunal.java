package padroescriacao.singleton;

/**
 * Singleton: guarda os parâmetros globais da sessão do sistema judicial.
 */
public class ParametrosTribunal {

    private static final ParametrosTribunal instance = new ParametrosTribunal();

    private String nomeTribunal;
    private String usuarioLogado;

    private ParametrosTribunal() {
    }

    public static ParametrosTribunal getInstance() {
        return instance;
    }

    public String getNomeTribunal() {
        return nomeTribunal;
    }

    public void setNomeTribunal(String nomeTribunal) {
        this.nomeTribunal = nomeTribunal;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
