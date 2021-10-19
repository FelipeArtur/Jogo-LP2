package com.felipe.lapajogovisual;
//import javax.swing.JOptionPane;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

        

public class Mapa {
    
    private char[][] mapa1 = {

        {'x', 'y', 'f', 'y', 'p', 'y', 'e', 'y', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '~', '*', '~', '*', '*', '~', 'x'},
        {'x', '*', '*', '~', '*', '*', '~', '~', 'x'},
        {'x', '*', '*', '*', '*', '~', '*', '*', 'x'},
        {'x', '*', '*', '~', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '~', '*', '*', '~', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
    
    private char[][] mapa2 = {

        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '~', '*', '~', '*', '*', '~', '*', 'x'},
        {'x', '*', '*', '~', '*', '*', '*', '~', '*', '*', '~', 'x'},
        {'x', '*', '~', '*', '*', '*', '*', '*', '*', '~', '*', 'x'},
        {'x', '*', '*', '~', '*', '*', '~', '~', '*', '~', '*', 'x'},
        {'x', '*', '*', '*', '*', '~', '~', '*', '*', '*', '*', 'x'},
        {'x', '*', '~', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
        
    private char[][] mapa3 = {

        {'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '~', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '~', '~', '*', '~', '*', '*', '~', '*', 'x'},
        {'x', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '~', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', '*', '*', '~', '*', '*', '*', '*', '~', '~', '*', '*', 'x'},
        {'x', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'x'},
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
    

    public char[][] getMapa1() {
        return mapa1;
    }

    public void setMapa1(char[][] mapa1) {
        this.mapa1 = mapa1;
    }

    public char[][] getMapa2() {
        return mapa2;
    }

    public void setMapa2(char[][] mapa2) {
        this.mapa2 = mapa2;
    }

    public char[][] getMapa3() {
        return mapa3;
    }

    public void setMapa3(char[][] mapa3) {
        this.mapa3 = mapa3;
    }
    //ESCOLHA DOS MAPAS CRIADOS ACIMA, COM SWITCH CASE;
    public char[][] escolha(char[][] Mapa , int op){
        
            
            if(op == 1){
                Mapa = mapa1;       
            }else if(op == 2){
                Mapa = mapa2;                
            }else if(op == 3){
                Mapa = mapa3;             
            }
            
        return Mapa;    
        
    }
    //PRINTAR O MAPA
    public void mostrarmapa(char[][] Mapa){
        
      for (int l = 0; l < Mapa.length; l++){
        for (int c = 0; c < Mapa.length; c++){
          System.out.print(" "+ Mapa[l][c]);

        }
        System.out.print("\n");
      }
    }
    //POSICIONA UM PERSONAGEM DE UM JOGADOR
    public void Posiciona(char[][] Mapa, Personagem P, Jogador j){ 
            
            int lado;
            if(j.getLado()== 1){
                lado = Mapa.length - 2;
            }else{
                lado = 1;
            }
       
            for(;;){
                //==========-> ANTIGO
                /*
                P.linha = (Integer.parseInt(JOptionPane.showInputDialog(null, j.getNome()+" Digite a linha que deseja posicionar seu personagem, o seu lado é o "+j.getLado())));
                P.coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, j.getNome()+" Digite a coluna que deseja posicionar seu personagem, o seu lado é o "+j.getLado())));
                */
                P.linha = pegarLinha(j);
                P.coluna = pegarColuna(j);     
                if(P.linha == lado && Mapa[P.linha][P.coluna] == '*'){
                    Mapa[P.linha][P.coluna] = P.getIcone();
                    break;
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor de linha e coluna invalidos!\n"+
                    "So é possivel posicionar na primeira linha do seu lado"       
                    ); 
                    a1.setHeaderText(null); a1.showAndWait();
                }
            }
       
        
       
   }
   // MOTEDO USADO PARA TODOS OS PERSONAGENS MOVIMENTAREM
   public void movimentar(char[][] Mapa, Personagem P, Jogador j){
    int linha = P.linha;
    int coluna = P.coluna;
    //caso nao tenha pra onde ele ir
    if((Mapa[linha + 1][coluna] != '*') && (Mapa[linha - 1][coluna] != '*') && (Mapa[linha][coluna + 1] != '*') && (Mapa[linha][coluna - 1] != '*')){
        Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem escolhido para movimentar esta preso por todos os lados, logo não é possivel movimentar"); a1.setHeaderText(null); a1.showAndWait();
        
    }else{   
        //coloca um '*' para local que ele estaca antes
    Mapa[linha][coluna] = '*';    
    
     for(;;){
        //===================-> ANTIGO 
        /* 
        P.linha = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a linha que deseja mover seu personagem:")));
        P.coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a coluna que deseja mover seu personagem:"))); 
        */
        P.linha = pegarLinha(j);
        P.coluna = pegarColuna(j);
        //verifca posicoes acima e embaixo
        if(((linha + 1  == P.linha && coluna == P.coluna) || ((linha + 2  == P.linha && coluna == P.coluna) && Mapa[linha + 1][coluna] == '*') || (linha - 1 == P.linha && coluna == P.coluna) || ((linha - 2  == P.linha && coluna == P.coluna) && Mapa[linha - 1][coluna] == '*') ) &&  Mapa[P.linha][P.coluna] == '*' ){
            Mapa[P.linha][P.coluna] = P.getIcone();
            break;
        //verifca posicoes aos lados
        }else if(((linha == P.linha && coluna + 1 == P.coluna) || ((linha == P.linha && coluna + 2 == P.coluna) && Mapa[linha][coluna + 1] == '*') || (linha == P.linha && coluna - 1 == P.coluna) ||  ((linha == P.linha && coluna - 2 == P.coluna) && Mapa[linha][coluna - 1] == '*') ) && Mapa[P.linha][P.coluna] == '*' ){
            Mapa[P.linha][P.coluna] = P.getIcone();
            break;
        }else{
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Posicao invalida!\n"+
            "Lembre-se, o personagem so pode andar 2 casss para frente, atras ou lados e\n"+
            "não pode ficar em cima de obstaculos ou personagens"       
            ); 
            a1.setHeaderText(null); a1.showAndWait();            
        }
     }
    }
   }
   

   public int pegarLinha(Jogador j){
    TextInputDialog dialog = new TextInputDialog("OLA");
    dialog.setTitle("Escolha de linha");
    dialog.setHeaderText(j.getNome()+ ", seu lado é o "+ j.getLado());
    
    dialog.setContentText("Insira o numero da linha");
            
    Optional<String> result = dialog.showAndWait();    
    
    int numeroConvertido = Integer.parseInt(result.get());
   return numeroConvertido;
   }
   
    public int pegarColuna(Jogador j){
     TextInputDialog dialog = new TextInputDialog("OLA");
     dialog.setTitle("Escolha de coluna");
     dialog.setHeaderText(j.getNome()+ ", seu lado é o "+ j.getLado());
     
     dialog.setContentText("Insira o numero da coluna");
            
     Optional<String> result = dialog.showAndWait();    
    
     int numeroConvertido = Integer.parseInt(result.get());
    return numeroConvertido;
   }
   
   
   
}
