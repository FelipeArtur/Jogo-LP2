/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.lapajogo;

public class Zoro extends Personagem{
// FELIPE SERRA PORTO DE AZEVEDO ☺
    public Zoro(){
        this.setNome("Zoro");
        this.setVida(100);
        this.setDano(40);
        this.setDefesa(100);
        this.setPh(50);
        this.setIcone('$');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 2 casas;
        //O ataque basico do Zoro pula personagens inimigos e aliados; //Exemplo se eh tiver um personagem na frente do zoro e um atras desse
        // e for pedido para atacar o de tras ele ira ignorar o da frente dele e dara o dano do de tras
        // Vale ressaltar que ele nao atravessa obstaculos(~);
        boolean achouPatacado = false;
        for(int i = 1; i <= 2; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }
                break;
            }
          }
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;
            }
          }
          if(this.coluna + i < Mapa.length - 1){//verifica se esta a direita
            if(Mapa[this.linha][this.coluna + i] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;                
            }
          }
          if(this.coluna - i > 0){//verifica se esta a esquerda
            if(Mapa[this.linha][this.coluna - i] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;  
            }
          } 
        }
        if(achouPatacado){
            System.out.println(this.getNome()+" atacando com estilo duplo o inimigo: " +pAtacado.getNome());
            if(pAtacado.getDefesa() != 0){
                pAtacado.setDefesa(pAtacado.getDefesa() - this.getDano()); 
                if(pAtacado.getDefesa() - this.getDano() < 0){
                    int danoExtra = (pAtacado.getDefesa() - this.getDano()) * -1;
                    pAtacado.setDefesa(0);
                    pAtacado.setVida(pAtacado.getVida() - danoExtra);
                }
            }else if (pAtacado.getDefesa() == 0){
                 pAtacado.setVida(pAtacado.getVida() - this.getDano());
            }
            if(pAtacado.getVida() <= 0){
            System.out.println(pAtacado.getNome()+" está morto(a)");
            Mapa[pAtacado.linha][pAtacado.coluna] = '*';
            pAtacado.setVida(0);
            }  
        }else{
            System.out.println("O personagem que voce escolheu atacar não esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque");
        }
        
    }
    
    @Override
    public void ult(char[][] Mapa, Personagem pAtacado, Personagem pAtacado2, Personagem pAtacado3){//PRONTO
        //A ult(Sentoryu) eh ataque com range ate o final das casas;
        //Ele pode ser utilizado para frente ou para tras;
        //Porem se um personagem aliado estiver na frente da linha do ataque, o aliado nao sofrera da dano e o ataque nao passara;
        //O ult atrevessa personagens inimigos, logo se tiver 3 inimigos um atras do outro, os levam o dano
        //Dano da ult eh 180
       int dano = 180;
       if (this.getPh() >= 50){
           boolean achouPatacado1 = false;
           boolean achouPatacado2 = false;
           boolean achouPatacado3 = false;
           for(int i = this.linha + 1; i < Mapa.length; i++){
               if(Mapa[i][this.coluna] == pAtacado.getIcone()){
                   achouPatacado1 = true;
               }else if(Mapa[i][this.coluna] == pAtacado2.getIcone()){
                   achouPatacado2 = true;
               }else if(Mapa[i][this.coluna] == pAtacado3.getIcone()){
                   achouPatacado3 = true;
               }else if(Mapa[i][this.coluna] != '*'){
                   break;                   
               }
           }
           for(int i = this.linha - 1; i > 0; i--){
               if(Mapa[i][this.coluna] == pAtacado.getIcone()){
                    achouPatacado1 = true;  
               }else if(Mapa[i][this.coluna] == pAtacado2.getIcone()){
                   achouPatacado2 = true;
               }else if(Mapa[i][this.coluna] == pAtacado3.getIcone()){
                   achouPatacado3 = true;
               }else if(Mapa[i][this.coluna] != '*'){
                   break;                   
               }
           }
           
        this.setPh(this.getPh() - 50);  
        if(achouPatacado1){
            System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado.getNome());
            if(pAtacado.getDefesa() != 0){
                if(pAtacado.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado.getDefesa() - dano) * -1;
                    pAtacado.setDefesa(0);
                    pAtacado.setVida(pAtacado.getVida() - danoExtra);
                }else{
                    pAtacado.setDefesa(pAtacado.getDefesa() - dano);                     
                }
            }else if (pAtacado.getDefesa() == 0){
                 pAtacado.setVida(pAtacado.getVida() - dano);
            }  
            
            if(pAtacado.getVida() <= 0){
            System.out.println(pAtacado.getNome()+" está morto(a)");
            Mapa[pAtacado.linha][pAtacado.coluna] = '*';
            pAtacado.setVida(0);
            }  
            
        }
        if(achouPatacado2){
            System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado2.getNome());
            if(pAtacado2.getDefesa() != 0){
                if(pAtacado2.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado2.getDefesa() - dano) * -1;
                    pAtacado2.setDefesa(0);
                    pAtacado2.setVida(pAtacado2.getVida() - danoExtra);
                }else{
                    pAtacado2.setDefesa(pAtacado2.getDefesa() - dano);                     
                }
            }else if (pAtacado2.getDefesa() == 0){
                 pAtacado2.setVida(pAtacado2.getVida() - dano);
            }  
            
            if(pAtacado2.getVida() <= 0){
            System.out.println(pAtacado2.getNome()+" está morto(a)");
            Mapa[pAtacado2.linha][pAtacado2.coluna] = '*';
            pAtacado2.setVida(0);
            }   
        }
        if(achouPatacado3){
            System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado3.getNome());
            if(pAtacado3.getDefesa() != 0){
                if(pAtacado3.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado3.getDefesa() - dano) * -1;
                    pAtacado3.setDefesa(0);
                    pAtacado3.setVida(pAtacado3.getVida() - danoExtra);
                }else{
                    pAtacado3.setDefesa(pAtacado3.getDefesa() - dano);                     
                }
            }else if (pAtacado3.getDefesa() == 0){
                 pAtacado3.setVida(pAtacado3.getVida() - dano);
            }  
            
            if(pAtacado3.getVida() <= 0){
            System.out.println(pAtacado3.getNome()+" está morto(a)");
            Mapa[pAtacado3.linha][pAtacado3.coluna] = '*';
            pAtacado3.setVida(0);
            }   
        }
        if(achouPatacado1 == false && achouPatacado2 == false && achouPatacado3 == false){
            System.out.println("Sua ult nao acertou nenhum adversario");
        }
      }else System.out.println("Voce nao possui pontos de habilidade (Ph) suficentes");//Não ulta 
    }    
}
