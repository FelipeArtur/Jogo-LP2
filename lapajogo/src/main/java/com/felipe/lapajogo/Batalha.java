/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.lapajogo;

import java.io.IOException;
import javax.swing.JOptionPane;


public class Batalha {
//MAGICA, FAVOR NAO MEXA ❤;                                 
    private int turno;
    private  Jogador[] J;
    private char[][] tabuleiro;
    public Mapa map;
    private Jogador jogadorVencedor;

    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public void setJogadorVencedor(Jogador jogadorVencedor) {
        this.jogadorVencedor = jogadorVencedor;
    }


    public Jogador[] getJ() {
        return J;
    }

    public void setJ(Jogador[] J) {
        this.J = J;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Mapa getMap() {
        return map;
    }

    public void setMap(Mapa map) {
        this.map = map;
    }
   
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public Batalha() {
        this.turno = turno;
        this.J = J;
        this.tabuleiro = tabuleiro;
        this.map = map;
        this.jogadorVencedor = jogadorVencedor;
    }    
    
    //CHAMA O ESCOLHER O MAPA 
    //COLOCA O MAPA ESCOLHIDO EM TABULEIRO
    public void escolherMapa(){
        this.map = new Mapa();
        this.tabuleiro = new char[0][0];
        this.tabuleiro = map.escolha(tabuleiro);
        map.mostrarmapa(this.tabuleiro); 
        //return tabuleiro;
    }
    //POSICIONAR AS PEÇAS NO TABULEIRO
    public void posicionarTime(Jogador[] j, int comeca1, int comeca2){
                
        for(int i = 0; i < 3; i++){
            map.mostrarmapa(this.tabuleiro);  
            System.out.println("Posicione o "+j[comeca1].P[i].getNome());
            map.Posiciona(this.tabuleiro, j[comeca1].P[i] , j[comeca1]);
            map.mostrarmapa(this.tabuleiro); 
            System.out.println("Posicione o "+j[comeca2].P[i].getNome());
            map.Posiciona(this.tabuleiro, j[comeca2].P[i] , j[comeca2]);
            map.mostrarmapa(this.tabuleiro); 
        }
        
    }
    //FUNCAO QUE INICIALIZA A BATALHA
        public void batalha() throws IOException{
        J = new Jogador[2];
        J[0] = new Jogador(JOptionPane.showInputDialog("Digite seu nome:"));
        J[1] = new Jogador(JOptionPane.showInputDialog("Digite seu nome:"));
        //SORTEIO
        J[0].setLado(J[0].sorteio());
        //EH ESCOLHIDO O MAPA
        this.escolherMapa();

        //ORGANIZA QUEM COMEÇA JOGANDO;
        //PARA QUE O JOGADOR J[] QUE FOI SORTEADO PARA COMEÇAR FIQUE J[comeca1];
        int comeca1, comeca2;
        if(J[0].getLado() == 1){
            comeca1 = 0;
            comeca2 = 1;
            J[1].setLado(2);
        }else{
            comeca1 = 1;
            comeca2 = 0;
            J[1].setLado(1); 
        }
        //==========================ESCOLHA DE PERSONAGENS(3X3)===================
        //EH ESCOLHIDO OS PERSONAGENS DOS JOGADORES, VALE LEMBRAR QUE NAO PODE REPETIR PERSONAGENS;
        
        J[0].setP(new Personagem[3]);
        J[1].setP(new Personagem[3]);
        this.escolhertime(J, comeca1, comeca2);
        //=========================ESCOLHA DE ITEM================================
        //Jogador1
        if(J[comeca1].verificaJog(J[comeca1]) == 0){
            
            System.out.println("Personagem: 1 "+J[comeca1].P[0].getNome());
            System.out.println("Personagem: 2 "+J[comeca1].P[1].getNome());
            System.out.println("Personagem: 3 "+J[comeca1].P[2].getNome());        
            for(;;){
                int op = (Integer.parseInt(JOptionPane.showInputDialog(null, J[comeca1].getNome()+"ITEM: CASO QUEIRA USA-LO DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM")));
                if(op == 1){
                    J[comeca1].usaritem(J[comeca1], J[comeca1].P[0]);
                    break;
                }else if(op == 2){
                    J[comeca1].usaritem(J[comeca1], J[comeca1].P[1]);
                    break;
                }else if(op == 3){
                    J[comeca1].usaritem(J[comeca1], J[comeca1].P[2]);
                    break;
                }else{
                    System.out.println("Valor digitado incorreto");
                }
            }
        }
        //Jogador2
        if(J[comeca1].verificaJog(J[comeca2]) == 0){
            
            System.out.println("Personagem: 1 "+J[comeca2].P[0].getNome());
            System.out.println("Personagem: 2 "+J[comeca2].P[1].getNome());
            System.out.println("Personagem: 3 "+J[comeca2].P[2].getNome()); 
            for(;;){
                int op = (Integer.parseInt(JOptionPane.showInputDialog(null, J[comeca1].getNome()+"ITEM: CASO QUEIRA USA-LO DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM")));
                if(op == 1){
                    J[comeca2].usaritem(J[comeca2], J[comeca2].P[0]);
                    break;
                }else if(op == 2){
                    J[comeca2].usaritem(J[comeca2], J[comeca2].P[1]);
                    break;
                }else if(op == 3){
                    J[comeca2].usaritem(J[comeca2], J[comeca2].P[2]);
                    break;
                }else{
                    System.out.println("Valor digitado incorreto");
                }
            }
        }
        
        
        
        //=========================ESCOLHA POSICAO DOS PERSONAGENS================
        //EH ESCOLHIDO A POSICAO DOS PERSONAGENS NO TABULEIRO, VALE LEMBRAR QUE SO EH POSSIVEL POSICIONAR NA PRIMEIRA LINHA DA SUA BASE
        
        System.out.println("==========================================");
        System.out.println(J[0].getNome() +" esta no lado " +J[0].getLado());
        System.out.println(J[1].getNome() +" esta no lado " +J[1].getLado());
        System.out.println("==========================================");       
        this.posicionarTime(J, comeca1, comeca2);
        
        //PRINTA
        imprimir(J, comeca1, comeca2);

        //FUNCAO POG PARA LIMPAR A TELA
        //COISAS DO JAVA
        //for (int i = 0; i < 100; ++i){
           // System.out.println();
        //}  

        //==========================TURNO ATE ACHAR UM VENCEDOR==================
        Jogadas(J, comeca1, comeca2);
        if(verificarVencedor(this.tabuleiro, J, comeca1, comeca2) == 0){
           System.out.println("O VENCEDOR DA PARTIDA É "+this.jogadorVencedor.getNome());
           J[comeca1].dadosjogador(this.jogadorVencedor);
        }
        
        //System.out.println("defesa: "+J[comeca1].P[0].getDefesa()+ " nome: " +J[comeca1].P[0].getNome()+ "jogador:"+J[comeca1].getNome());
        //System.out.println("defesa: "+J[comeca2].P[0].getDefesa()+ " nome: " +J[comeca2].P[0].getNome()+ "jogador:"+J[comeca2].getNome());
            //DEU BOM
            System.out.println("deu bom");
            imprimir(J, comeca1, comeca2);    
        }
    //ESCOLHA DOS PERSONAGENS DOS JOGADORES    
    public void escolhertime(Jogador[] j, int comeca1, int comeca2){
        
        
        System.out.println("1 - Zoro");
        System.out.println("2 - Zagreu");
        System.out.println("3 - Artemis");
        System.out.println("4 - Batman");
        System.out.println("5 - Zatanna");
        System.out.println("6 - Oryx");
        
        boolean JaescolheuZoro = false;
        boolean JaescolheuZagreu = false;
        boolean JaescolheuArtemis = false;
        boolean JaescolheuBatman = false;
        boolean JaescolheuZatanna = false;
        boolean JaescolheuOryx = false;
        
        for(int i = 0; i < 3; i++){// 6 personagens (3 de cada jogador); // nao pode repetir personagens
             
            for(;;){
                int op = (Integer.parseInt(JOptionPane.showInputDialog(null, j[comeca1].getNome()+" - Selecione o personagem desejado ")));
                if(op == 1 && JaescolheuZoro == false){
                  j[comeca1].P[i] = new Zoro();
                  JaescolheuZoro = true;
                  break;
                }else if(op == 2 && JaescolheuZagreu == false){
                  j[comeca1].P[i] = new Zagreu();
                  JaescolheuZagreu = true;
                  break;
                }else if(op == 3 && JaescolheuArtemis == false){
                  j[comeca1].P[i] = new Artemis(); 
                  JaescolheuArtemis = true;
                  break;
                }else if(op == 4 && JaescolheuBatman == false){
                  j[comeca1].P[i] = new Batman(); 
                  JaescolheuBatman = true;
                  break;
                }else if(op == 5 && JaescolheuZatanna == false){
                  j[comeca1].P[i] = new Zatanna(); 
                  JaescolheuZatanna = true;
                  break;
                }else if(op == 6 && JaescolheuOryx == false){
                  j[comeca1].P[i] = new Oryx(); 
                  JaescolheuOryx = true;
                  break;
                }else{
                    System.out.println("Numero do personagem incorreto ou Personagem ja foi escolhido por outro jogador ");
                }
            }
            
            for(;;){
                int op = (Integer.parseInt(JOptionPane.showInputDialog(null, j[comeca2].getNome()+" - Selecione o personagem desejado ")));
                if(op == 1 && JaescolheuZoro == false){
                  j[comeca2].P[i] = new Zoro();
                  JaescolheuZoro = true;
                  break;
                }else if(op == 2 && JaescolheuZagreu == false){
                  j[comeca2].P[i] = new Zagreu();
                  JaescolheuZagreu = true;
                  break;
                }else if(op == 3 && JaescolheuArtemis == false){
                  j[comeca2].P[i] = new Artemis(); 
                  JaescolheuArtemis = true;
                  break;
                }else if(op == 4 && JaescolheuBatman == false){
                  j[comeca2].P[i] = new Batman(); 
                  JaescolheuBatman = true;
                  break;
                }else if(op == 5 && JaescolheuZatanna == false){
                  j[comeca2].P[i] = new Zatanna(); 
                  JaescolheuZatanna = true;
                  break;
                }else if(op == 6 && JaescolheuOryx == false){
                  j[comeca2].P[i] = new Oryx(); 
                  JaescolheuOryx = true;
                  break;
                }else{
                    System.out.println("Numero do personagem incorreto ou Personagem ja foi escolhido por outro jogador ");
                }
            }
        }
    }
    //MOSTRA OPCOES POSSIVEIS NO TURNO
    public void turno(Jogador[] j, int  comeca1, int  comeca2, int perso){
                for(;;){
                    System.out.println("1 - para atacar");
                    System.out.println("2 - para movimentar");
                    System.out.println("3 - para usar a ult");                   
                    int op = (Integer.parseInt(JOptionPane.showInputDialog(null, j[comeca1].getNome()+" Digite o numero que representa a ação que deseja fazer o personagem "+ j[comeca1].P[perso].getNome())));
                    if(op == 1){
                        for(;;){
                            System.out.println("1 - "+j[comeca2].P[0].getNome()+" VIDA "+j[comeca2].P[0].getVida());
                            System.out.println("2 - "+j[comeca2].P[1].getNome()+" VIDA "+j[comeca2].P[1].getVida());
                            System.out.println("3 - "+j[comeca2].P[2].getNome()+" VIDA "+j[comeca2].P[2].getVida());                            
                            op = (Integer.parseInt(JOptionPane.showInputDialog(null, " Digite o numero que representa o Personagem inimigo que deseja atacar ")));
                            if(op == 1){
                                j[comeca1].P[perso].atacar(this.tabuleiro, j[comeca2].P[0]);
                                break;
                            }else if(op == 2){
                               j[comeca1].P[perso].atacar(this.tabuleiro, j[comeca2].P[1]);
                                break;
                            }else if(op == 3){
                               j[comeca1].P[perso].atacar(this.tabuleiro, j[comeca2].P[2]);
                                break;
                            }else{
                                System.out.println("Valor para o numero do personagem atacado incorreto ");
                            }                            
                        }
                        break;
                    }else if(op == 2){
                       map.movimentar(this.tabuleiro, j[comeca1].P[perso], j[comeca1]);
                       break;
                    }else if(op == 3){
                        
                        if(j[comeca1].P[perso].getIcone()  == '$' || j[comeca1].P[perso].getIcone() == 'O'){
                            j[comeca1].P[perso].ult(this.tabuleiro, j[comeca2].P[0],  j[comeca2].P[1], j[comeca2].P[2]);
                        }else{
                            j[comeca1].P[perso].ult();
                        }
                        
                        break;
                    }else{
                        System.out.println("Valor para o numero da acao incorreto ");
                    }
                }        
    }
    //ONCE OCORRE AS JOGADAS // POSSUI "SETA" CONTADOR QUE DETERMINA A DURACAO DA PRATIDA// CHAMA TURNO 
    public void Jogadas(Jogador[] j, int comeca1, int comeca2){
    this.turno = 0;
    int perso;
    while(this.turno <= 3){ 
        for(;;){
            System.out.println("1 - "+j[comeca1].P[0].getNome());
            System.out.println("2 - "+j[comeca1].P[1].getNome());
            System.out.println("3 - "+j[comeca1].P[2].getNome());            
           int op = (Integer.parseInt(JOptionPane.showInputDialog(null, j[comeca1].getNome()+" Digite o numero que representa o personagem que deseja fazer uma ação")));
            if(op == 1 && j[comeca1].P[0].getVida() > 0){
                perso = 0;
                turno(J, comeca1, comeca2, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else if(op == 2 && j[comeca1].P[1].getVida() > 0){
                perso = 1;
                turno(J, comeca1, comeca2, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else if(op == 3 && j[comeca1].P[2].getVida() > 0){
                perso = 2;
                turno(J, comeca1, comeca2, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else{
                System.out.println("Valor para opcao do personagem invalido ou o personagem esta morto");
            }  
        }
        
        if(verificarVencedor(this.tabuleiro, J, comeca1, comeca2) == 0){
           break;
        }
        for(;;){
            System.out.println("1 - "+j[comeca2].P[0].getNome());
            System.out.println("2 - "+j[comeca2].P[1].getNome());
            System.out.println("3 - "+j[comeca2].P[2].getNome());            
           int op = (Integer.parseInt(JOptionPane.showInputDialog(null, j[comeca2].getNome()+" Digite o numero que representa o personagem que deseja fazer uma ação")));
            if(op == 1 && j[comeca2].P[0].getVida() > 0){
                perso = 0;
                turno(J, comeca2, comeca1, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else if(op == 2 && j[comeca2].P[1].getVida() > 0){
                perso = 1;
                turno(J, comeca2, comeca1, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else if(op == 3 && j[comeca2].P[2].getVida() > 0){
                perso = 2;
                turno(J, comeca2, comeca1, perso);
                map.mostrarmapa(this.tabuleiro);
                break;
            }else{
                System.out.println("Valor para opcao do personagem invalido ou o personagem esta morto");
            }  
        }
        verificarVencedor(this.tabuleiro, J, comeca1, comeca2);
        this.turno++;
        System.out.println("TURNO:"+this.getTurno());
    }             
}
    //VERIFICA O VENCEDOR DO JOGO
    public int verificarVencedor(char[][] Mapa, Jogador[] j, int comeca1, int comeca2){
       int contPersonagens1 = 0;
       int contPersonagens2 = 0; 
       for (int l = 0; l < Mapa.length - 1; l++){
        for (int c = 0; c < Mapa.length - 1; c++){
          if(Mapa[l][c] == j[comeca1].P[0].getIcone() || Mapa[l][c] == j[comeca1].P[1].getIcone() || Mapa[l][c] == j[comeca1].P[2].getIcone()){
              contPersonagens1++;
          }
          if(Mapa[l][c] == j[comeca2].P[0].getIcone() || Mapa[l][c] == j[comeca2].P[1].getIcone() || Mapa[l][c] == j[comeca2].P[2].getIcone()){
              contPersonagens2++;
          } 
        }
      }
       //CASO UM TIME TODO MORRA
      if(contPersonagens1 == 0){
       this.setJogadorVencedor(j[comeca2]);
       return 0;
      }else if(contPersonagens2 == 0){
        this.setJogadorVencedor(j[comeca1]);
        return 0;
      } 
     //QUANTIDADE DE JOGADOR EM CADA LADO
      if(this.getTurno() == 4){
          if(contPersonagens1 > contPersonagens2){
              this.setJogadorVencedor(j[comeca1]);
              return 0;
          }else if(contPersonagens2 > contPersonagens1){
              this.setJogadorVencedor(j[comeca2]);
              return 0;
          }
      }
      //SOMA DAS VIDAS DOS PERSONAGNS DO JOGADORES
      if(this.getTurno() == 4 && contPersonagens1 == contPersonagens2){
          if((j[comeca1].P[0].getVida() + j[comeca1].P[1].getVida() + j[comeca1].P[2].getVida()) > (j[comeca2].P[0].getVida() + j[comeca2].P[1].getVida() + j[comeca2].P[2].getVida())){
              this.setJogadorVencedor(j[comeca1]);
              return 0;
          }else if((j[comeca1].P[0].getVida() + j[comeca1].P[1].getVida() + j[comeca1].P[2].getVida()) < (j[comeca2].P[0].getVida() + j[comeca2].P[1].getVida() + j[comeca2].P[2].getVida())){
              this.setJogadorVencedor(j[comeca2]);
              return 0;
          }else{
              System.out.println("empatou em tudo");
          }
      }
      

      
      return 1;
    }
    //PRINTA ALGUMAS INFORMACOES DO JOGADORES E PERSONAGENS    
    public void imprimir(Jogador[] j, int comeca1, int comeca2){ 
       System.out.println("O personagem 1 do jogador " +j[comeca1].getNome() + " é "+j[comeca1].P[0].getNome()+" e possui " +j[comeca1].P[0].getVida()+" de vida");
       System.out.println("O personagem 2 do jogador " +j[comeca1].getNome() + " é "+j[comeca1].P[1].getNome()+" e possui " +j[comeca1].P[1].getVida()+" de vida");
       System.out.println("O personagem 3 do jogador " +j[comeca1].getNome() + " é "+j[comeca1].P[2].getNome()+" e possui " +j[comeca1].P[2].getVida()+" de vida");
       System.out.println("O personagem 1 do jogador " +j[comeca2].getNome() + " é "+j[comeca2].P[0].getNome()+" e possui " +j[comeca2].P[0].getVida()+" de vida");
       System.out.println("O personagem 2 do jogador " +j[comeca2].getNome() + " é "+j[comeca2].P[1].getNome()+" e possui " +j[comeca2].P[1].getVida()+" de vida");
       System.out.println("O personagem 3 do jogador " +j[comeca2].getNome() + " é "+j[comeca2].P[2].getNome()+" e possui " +j[comeca2].P[2].getVida()+" de vida");
       
    }
     
}
