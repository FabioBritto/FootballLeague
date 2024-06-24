import javax.swing.*;
import java.util.Random;

public class Equipes {
    
    private String equipeNome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int gols;
    private int totalGols;
    
    public Equipes(String equipeNome){
        this.equipeNome = equipeNome;
        vitorias = 0;
        empates = 0;
        derrotas = 0;
    }
    
    public void mostrarEstatistica(){
        
        JOptionPane.showMessageDialog(null, "Equipe: " + equipeNome +
                                            "Vitorias: " + getVitorias() +
                                            "Empates: " + getEmpates() +
                                            "Derrotas: " + getDerrotas());
    }
    
    
    
    public String getEquipeNome(){
        return equipeNome;
    }
    
    public void setGols(int gols){
        this.gols = gols;
        somarTotalGols(gols);
    }
    
    public int getGols(){
        return this.gols;
    }
    
    public int getVitorias() {
        return vitorias;
    }

    public void somarVitorias() {
        this.vitorias ++;
    }
    
    public int getEmpates() {
        return empates;
    }

    public void somarEmpates() {
        this.empates ++;
    }

    public int getDerrotas() {
        return derrotas;
    }
    
    public void somarDerrotas() {
        this.derrotas ++;
    }
    
    public void somarTotalGols(int gols){
        this.totalGols += gols;
    }
    
    public int getTotalGols(){
        return totalGols;
    }
}
