import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.*;
import java.util.Random;

public class Jogos {
    
    static Equipes[] equipes = new Equipes[4];
    private double temperatura;
    private static int maiorTemperatura = -1000;
    private static int menorTemperatura = 1000;
    private int idPartida;
    private Equipes equipeVencedora;
    private static ArrayList<HistoricoPartidas> relatorioPartidas = new ArrayList<>();
    
    
    
    public static void definirEquipes(){
        String equipeNome;
        
        for(int i = 0;i < 4;i++){
            equipeNome = JOptionPane.showInputDialog(null,"Por favor, declare o nome da " + (i+1) + "ª Equipe:");
            Equipes time = new Equipes(equipeNome);
            equipes[i] = time;
        }
        
        JOptionPane.showMessageDialog(null,"Perfeito! Essas são as equipes da temporada:\n" 
                                          +"\n"+equipes[0].getEquipeNome()
                                          +"\n"+equipes[1].getEquipeNome()
                                          +"\n"+equipes[2].getEquipeNome()
                                          +"\n"+equipes[3].getEquipeNome());
    }
    
    public static void mostrarEstatistica(){
        
        String estatistica = "";
        for(int i = 0;i < 4;i++){
            estatistica += "\nEquipe: " + equipes[i].getEquipeNome() +
                           "\nGols Marcados: " + equipes[i].getTotalGols() +
                           "\nVitorias: " + equipes[i].getVitorias() +
                           "\nEmpates: " + equipes[i].getEmpates() +
                           "\nDerrotas: " + equipes[i].getDerrotas() + "\n";
        }
        estatistica += "\nTemperatura Máxima: " + maiorTemperatura +
                       "\nTemperatura Mínima: " + menorTemperatura;
        
        JOptionPane.showMessageDialog(null,estatistica);
    }
        
    public void haveraJogo(){
        int temperatura = definirTemperatura();
        if(temperatura == -1){
            JOptionPane.showMessageDialog(null,"Sinto muito. Hoje está muito frio para que possa haver jogo!");
            HistoricoPartidas.somarJogoCancelado();
        }
        else{
            HistoricoPartidas.zerarJogoCancelado();
            definirPartidas(temperatura);
        }
    }
    public static void definirPartidas(int temperatura){
        Random partidas = new Random();
        int numero;
        
        ArrayList<Integer> combinacoes = new ArrayList<>();
        
        for(int i = 0;i < 4;i++){
            do{
                numero = partidas.nextInt(4);
            }while(combinacoes.contains(numero));
            combinacoes.add(i,numero);
        }
        
        resultadoPartidas(combinacoes,temperatura);
    }
    
    public static void resultadoPartidas(ArrayList combinacoes, int temperatura){
        int[] golsTimes = golsDaPartida(temperatura);
        
        for(int i = 0;i < 4;i++){
            equipes[combinacoes.indexOf(i)].setGols(golsTimes[i]);
        }
        
        int timeA = combinacoes.indexOf(0);
        int timeB = combinacoes.indexOf(1);
        definirVencedores(equipes, combinacoes,timeA,timeB);
        timeA = combinacoes.indexOf(2);
        timeB = combinacoes.indexOf(3);
        definirVencedores(equipes, combinacoes,timeA,timeB);
    }
    
    public static int[] golsDaPartida(int temperatura){
        Random gols = new Random();
        
        int golsTimes[] = new int[4];
        for(int i = 0;i < 4;i++){
            golsTimes[i] = gols.nextInt(temperatura);
        }
        return golsTimes;
    }
    
    public int definirTemperatura(){
        
        int temperatura = Integer.parseInt(JOptionPane.showInputDialog("Por favor, insira a temperatura de hoje:"));
        if(temperatura > maiorTemperatura){
            maiorTemperatura = temperatura;
        }
        if(temperatura < menorTemperatura){
            menorTemperatura = temperatura;
        }
        if(temperatura <= 0){
            return -1;
        }
        else if(temperatura <= 10){
            return 3;
        }
        else if(temperatura <= 20){
            return 7;
        }
        else{
            return 10;
        }
    }
    
    public static void definirVencedores(Equipes[] equipes, ArrayList combinacoes,int timeA, int timeB){
        String vencedor;
        int[] gols = new int[4];
        
        for(int i = 0;i < 4;i++){
            gols[i] = equipes[combinacoes.indexOf(i)].getGols();
        }
        int golsTimeA = gols[timeA];
        int golsTimeB = gols[timeB];
        if(golsTimeA > golsTimeB){
            equipes[timeA].somarVitorias();
            equipes[timeB].somarDerrotas();
            vencedor = equipes[timeA].getEquipeNome();
        }
        else if(golsTimeA < golsTimeB){
            equipes[timeB].somarVitorias();
            equipes[timeA].somarDerrotas();
            vencedor = equipes[timeB].getEquipeNome();
        }
        else{
            equipes[timeB].somarEmpates();
            equipes[timeA].somarEmpates();
            vencedor = "Empate";
        }
        HistoricoPartidas.atualizarRanking(equipes);
        mostrarResultado(equipes,golsTimeA,golsTimeB, timeA, timeB, vencedor);
    }
    
    public static void mostrarResultado(Equipes[] equipes, int golsTimeA, int golsTimeB,int timeA,int timeB, String vencedor){
        
        JOptionPane.showMessageDialog(null, "Resultado das partidas de hoje:\n"
                                    + "\nVencedor: " + vencedor + "\n"
                                    + "\nTime: " + equipes[timeA].getEquipeNome() + "   Gols: " + golsTimeA
                                    + "\nTime: " + equipes[timeB].getEquipeNome() + "   Gols: " + golsTimeB);
        
        
    }
        
}


