package com.felipe.lapajogo;
public class Zagreu extends Personagem{
//FELIPE ARTUR MACEDO LIMA 
    public Zagreu(){
        this.setNome("Zagreu");
        this.setVida(200);
        this.setDano(25);
        this.setDefesa(100);
        this.setPh(50);
        this.setIcone('#');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 2 casas;
        //Zagreu nega a armadura de seus oponentes, ou seja, ele ataca diretamente a vida deles
        //Alem disso, ao atacar inimigos ele ganhar 5 de vida
        //Sua ult deixa ele reviver apenas uma vez por combate, ele volta com 200 de vida
        boolean achouPatacado = false;
        for(int i = 1; i <= 4; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = this.linha + 1; j < this.linha + i; j++ ){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                    }
                }    
                break;
            }
          }
          
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = this.linha - 1; j < this.linha - i; j--){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                    }
                }              
                break;
            }
         }
        }
            if(achouPatacado){
                System.out.println(pAtacado.getNome()+" foi golpeado por "+this.getNome());
                pAtacado.setVida(pAtacado.getVida() - this.getDano());
                this.setVida(this.getVida() + (this.getDano()/2));
                        
                if(pAtacado.getVida() <= 0){
                    System.out.println("Manda um abraço para o meu pai "+pAtacado.getNome()+ " ,fala que "+this.getNome()+ "te mandou");
                    Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                    pAtacado.setVida(0);
                }

            }else{
                System.out.println("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque");
            }
    }
    
    @Override
    public void ult(){
    //A Ult(Reviver) é uma magia criada pelo Zagreu que ou recupera
    //a vido toda em caso de vida<=50;
    //Revive uma vez
       if(this.getVida() <= 50 && this.getPh() == 50){
           this.setVida(200);
           System.out.println("Mais uma chance");
           this.setPh(this.getPh() - 50);
       }else if (this.getVida() != 0){
           System.out.println("Ainda estou vivo");
       }else System.out.println("Sem PH o sufuciente");
    }
}