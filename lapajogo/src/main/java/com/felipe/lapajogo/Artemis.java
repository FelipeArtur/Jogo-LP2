package com.felipe.lapajogo;
public class Artemis extends Personagem{
//FELIPE ARTUR MACEDO LIMA 
    public Artemis(){
        this.setNome("Artemis");
        this.setVida(150);
        this.setDano(10);
        this.setDefesa(100);
        this.setPh(100);
        this.setIcone('@');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){     
        boolean achouPatacado = false;
        //Ataca ao longo de toda a coluna
        //obs: Se tiver coisa no caminha do ataque que não seja o alvo a flecha é perdida
        for(int i = 1; i <= 20; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = (this.linha + i)-1; j > this.linha; j-- ){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                         break;
                    }
                }    
                break;
            }
          }
          
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = (this.linha - i) + 1; j < this.linha; j++){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                         break;
                    }
                }              
                break;
            }
         }
        }
        
        if(achouPatacado){
            System.out.println(this.getNome()+" mostrando a o poder da caçadora para " +pAtacado.getNome());
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
            System.out.println("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque");
        }
       
    }
    
    @Override
    public void ult(){
    //A Ult(Flechas Lunares) é uma habilidade da Artemis pode ativar suas 
    //flechas especias e dar o dobro de dano de suas flechas padrão;
    //Range:ao longo de toda a coluna
    //Dano: 30;
       if(this.getPh() >= 50){
           System.out.println("Não terei piedade");
           this.setDano(this.getDano()*2);
           this.setPh(this.getPh()-50);
       }else System.out.println("Sem PH o sufuciente");
    }
}

