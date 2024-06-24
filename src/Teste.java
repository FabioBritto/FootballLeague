import java.util.ArrayList;
import javax.swing.*;

public class Teste {
    
    public static void main(String[]args){
        
        JOptionPane.showMessageDialog(null, "Bom dia! Vamos começar?");
        Jogos.definirEquipes();
        ArrayList<Jogos> listaJogos = new ArrayList<>();
        
        do{
            
            Jogos jogo = new Jogos();
            jogo.haveraJogo();
            listaJogos.add(jogo);
        }while(HistoricoPartidas.getContadorJogosCancelados() < 3);
        Jogos.mostrarEstatistica();
    }
}

