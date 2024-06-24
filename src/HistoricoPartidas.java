import java.util.ArrayList;
import javax.swing.*;

public class HistoricoPartidas {
    
    private static ArrayList<Jogos> listaJogos = new ArrayList<>();
    private static Equipes[] ranking = new Equipes[4];
    private static int contadorJogosCancelados;
    
    
    public static void atualizarRanking(Equipes[] equipesPosJogo){
        ranking = equipesPosJogo;
    }
    
    public static void somarJogoCancelado(){
        contadorJogosCancelados++;
        if(contadorJogosCancelados == 3){
            JOptionPane.showMessageDialog(null,"A temporada foi encerrada por conta da baixa temperatura.");
            finalizarTemporada();
        }
    }
    
    public static void zerarJogoCancelado(){
        contadorJogosCancelados = 0;
    }
    
    public static boolean finalizarTemporada(){
        return true;
    }
    
    public static void mostrarRanking(){
        
    }
    
    public static int getContadorJogosCancelados(){
        return contadorJogosCancelados;
    }
}
