package com.felipe.lapajogo;
public class Zatanna extends Personagem {
    //DANILO SCHELTES CARDOSO
    public Zatanna(){
        this.setNome("Zatanna");
        this.setVida(175);
        this.setDano(25);
        this.setDefesa(100);
        this.setPh(100);
        this.setIcone('Z');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 3 casas;
        //O ataque so vai pra frente e para tras
        //O ataque basico da Zatanna se trata da envocação de uma Bola de Fogo atirada em um inimigo
        //Vale ressaltar que ele nao atravessa obstaculos(~), atravessa somente persnoagens;
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
 
        }
        if(achouPatacado){
            System.out.println(this.getNome()+"Ogof!!(Fogo) Uma Bola de fogo foi airada no inimigo: " +pAtacado.getNome());
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
            System.out.println("A Bola de Fogo não atingiu ninguém ou bateu em um obstaculo.");
        }
        
    }
    
    @Override
    public void ult(){
        //A Ult (Opmac ed saçrof) se trata de um campo de força criada por Zatanna;
        //Que consede a personagem um Bonos de 50 de Defesa;
    if(this.getPh() >= 50){
           this.setDefesa(this.getDefesa() + 50);
           System.out.println("Opmac ed saçrof!!");
           this.setPh(this.getPh() - 50);
       }else{ 
        System.out.println("Não tenho Pontos de Habiliadade (Ph) suficientes para essa magia");
        }
        }
    }

