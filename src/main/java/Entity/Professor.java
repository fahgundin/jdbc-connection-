package Entity;

public class Professor {
    private int id;
    private String nome;
    private String siape;
    private String unidade_academica;
    private String curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getUnidade_academica() {
        return unidade_academica;
    }

    public void setUnidade_academica(String unidade_academica) {
        this.unidade_academica = unidade_academica;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
