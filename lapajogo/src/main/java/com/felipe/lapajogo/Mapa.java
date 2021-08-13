package com.felipe.lapajogo;
import javax.swing.JOptionPane;

public class Mapa {
    
    private char[][] mapa1 = {

        {' ', '1', '2', '3', '4', '5', '6', '7', ' '},
        {'1', '*', '*', '*', '*', '*', '*', '*', '1'},
        {'2', '*', '~', '*', '~', '*', '*', '~', '2'},
        {'3', '*', '*', '~', '*', '*', '~', '~', '3'},
        {'4', '*', '*', '*', '*', '~', '*', '*', '4'},
        {'5', '*', '*', '~', '*', '*', '*', '*', '5'},
        {'6', '*', '*', '~', '*', '*', '~', '*', '6'},
        {'7', '*', '*', '*', '*', '*', '*', '*', '7'},
        {' ', '1', '2', '3', '4', '5', '6', '7', ' '}
    };
    
    private char[][] mapa2 = {

        {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ' '},
        {'1', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '1'},
        {'2', '*', '*', '*', '~', '*', '~', '*', '*', '~', '*', '2'},
        {'3', '*', '*', '~', '*', '*', '*', '~', '*', '*', '~', '3'},
        {'4', '*', '~', '*', '*', '*', '*', '*', '*', '~', '*', '4'},
        {'5', '*', '*', '*', '*', '*', '~', '*', '*', '~', '*', '5'},
        {'6', '*', '*', '~', '*', '~', '*', '*', '*', '*', '*', '6'},
        {'7', '~', '~', '~', '*', '*', '*', '*', '*', '*', '*', '7'},
        {'8', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', '8'},
        {'9', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', '9'},
        {'A', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'A'},
        {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ' '}
    };
        
    private char[][] mapa3 = {

        {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', ' '},
        {'1', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '1'},
        {'2', '*', '*', '*', '*', '*', '*', '~', '*', '*', '*', '*', '2'},
        {'3', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', '*', '3'},
        {'4', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '4'},
        {'5', '*', '*', '*', '~', '~', '*', '~', '*', '*', '~', '*', '5'},
        {'6', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', '6'},
        {'7', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '7'},
        {'8', '*', '~', '*', '*', '*', '*', '*', '*', '*', '*', '*', '8'},
        {'9', '*', '*', '*', '*', '~', '*', '*', '*', '*', '*', '*', '9'},
        {'A', '*', '*', '~', '*', '*', '*', '*', '~', '~', '*', '*', 'A'},
        {'B', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', 'B'},
        {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', ' '}
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
    public char[][] escolha(char[][] Mapa){
        
        for(;;){
            int op = (Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE O NUMERO DO MAPA DESEJADO")));

            if(op == 1){
                Mapa = mapa1;
                break;
            }else if(op == 2){
                Mapa = mapa2;
                break;
            }else if(op == 3){
                Mapa = mapa3;
                break;
            }else{
                System.out.println("VALOR DIGITADO PARA O MAPA INCORRETPO");
            }
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
                P.linha = (Integer.parseInt(JOptionPane.showInputDialog(null, j.getNome()+" Digite a linha que deseja posicionar seu personagem, o seu lado é o "+j.getLado())));
                P.coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, j.getNome()+" Digite a coluna que deseja posicionar seu personagem, o seu lado é o "+j.getLado())));
                if(P.linha == lado && Mapa[P.linha][P.coluna] == '*'){
                    Mapa[P.linha][P.coluna] = P.getIcone();
                    break;
                }else{
                    System.out.println("Valor de linha e coluna invalidos!");
                    System.out.println("So é possivel posicionar na primeira linha do seu lado");
                }
            }
       
        
       
   }
   // MOTEDO USADO PARA TODOS OS PERSONAGENS MOVIMENTAREM
   public void movimentar(char[][] Mapa, Personagem P, Jogador j){
    int linha = P.linha;
    int coluna = P.coluna;
    //caso nao tenha pra onde ele ir
    if((Mapa[linha + 1][coluna] != '*') && (Mapa[linha - 1][coluna] != '*') && (Mapa[linha][coluna + 1] != '*') && (Mapa[linha][coluna - 1] != '*')){
        System.out.println("O personagem escolhido para movimentar esta preso por todos os lados, logo não é possivel movimentar");
        
    }else{   
        //coloca um '*' para local que ele estaca antes
    Mapa[linha][coluna] = '*';
     for(;;){
        P.linha = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a linha que deseja mover seu personagem:")));
        P.coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a coluna que deseja mover seu personagem:"))); 
       

        //verifca posicoes acima e embaixo
        if(((linha + 1  == P.linha && coluna == P.coluna) || ((linha + 2  == P.linha && coluna == P.coluna) && Mapa[linha + 1][coluna] == '*') || (linha - 1 == P.linha && coluna == P.coluna) || ((linha - 2  == P.linha && coluna == P.coluna) && Mapa[linha - 1][coluna] == '*') ) &&  Mapa[P.linha][P.coluna] == '*' ){
            Mapa[P.linha][P.coluna] = P.getIcone();
            break;
        //verifca posicoes aos lados
        }else if(((linha == P.linha && coluna + 1 == P.coluna) || ((linha == P.linha && coluna + 2 == P.coluna) && Mapa[linha][coluna + 1] == '*') || (linha == P.linha && coluna - 1 == P.coluna) ||  ((linha == P.linha && coluna - 2 == P.coluna) && Mapa[linha][coluna - 1] == '*') ) && Mapa[P.linha][P.coluna] == '*' ){
            Mapa[P.linha][P.coluna] = P.getIcone();
            break;
        }else{
            System.out.println("Posicao invalida!");
            System.out.println("Lembre-se, o personagem so pode andar 2 cass para frente, atras ou lados e "
                    + "não pode ficar em cima de obstaculos ou personagens");
        }
     }
    }
   }
   

   
   
}
