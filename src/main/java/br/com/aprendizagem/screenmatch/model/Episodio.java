package br.com.aprendizagem.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "episodios")
public class Episodio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private double avaliacao;
    private LocalDate dataLancamento;

    @ManyToOne
    private Serie serie;

    public Episodio(){}
    public Episodio(Integer temporada, DadosEpisodio dadosEpsodio) {
        this.temporada = temporada;
        this.titulo = dadosEpsodio.Titulo();
        this.numeroEpisodio = dadosEpsodio.numero();
        try{
            this.avaliacao = Double.valueOf(dadosEpsodio.avaliacao());
        }catch(NumberFormatException e){
            this.avaliacao=0.0;
        }
        try {
            this.dataLancamento = LocalDate.parse(dadosEpsodio.dataLançamento());
        } catch (DateTimeParseException e) {
            this.dataLancamento=null;
        }
        
    }
    public Integer getTemporada() {
        return temporada;
    }
    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }
    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }
    public double getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------");
        sb.append("temporada=").append(temporada);
        sb.append(", titulo=").append(titulo);
        sb.append(", numeroEpisodio=").append(numeroEpisodio);
        sb.append(", avaliacao=").append(avaliacao);
        sb.append(", dataLancamento=").append(dataLancamento);
        sb.append("\n--------");
        return sb.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    
}
