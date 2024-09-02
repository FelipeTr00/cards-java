package Model;

import java.util.List;

public class Carta {

    private int id;
    private String jogador;
    private Boolean estrela;

    private Integer ritmo;
    private Integer finalizacao;
    private Integer conducao;
    private Integer passe;
    private Integer defesa;
    private Posicao posicao;
    private List<Posicao> posicoesSecundarias;
    private Pais pais;
    private int overall;

    public void calculateOverall() {
        this.overall = (ritmo + finalizacao +
        conducao + passe + defesa) / 5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public Boolean getEstrela() {
        return estrela;
    }

    public void setEstrela(Boolean estrela) {
        this.estrela = estrela;
    }

    public Integer getRitmo() {
        return ritmo;
    }

    public void setRitmo(Integer ritmo) {
        this.ritmo = ritmo;
    }

    public Integer getFinalizacao() {
        return finalizacao;
    }

    public void setFinalizacao(Integer finalizacao) {
        this.finalizacao = finalizacao;
    }

    public Integer getConducao() {
        return conducao;
    }

    public void setConducao(Integer conducao) {
        this.conducao = conducao;
    }

    public Integer getPasse() {
        return passe;
    }

    public void setPasse(Integer passe) {
        this.passe = passe;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public List<Posicao> getPosicoesSecundarias() {
        return posicoesSecundarias;
    }

    public void setPosicoesSecundarias(List<Posicao> posicoes) {
        this.posicoesSecundarias = posicoes;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
}
