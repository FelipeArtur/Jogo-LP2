package com.felipe.lapajogo;
    public class Batman extends Personagem {
    //  BRENO BOGÉA ALVOS PASSOS
    public Batman(){
        this.setNome("Batman");
        this.setVida(180);
        this.setDano(20);
        this.setDefesa(120);
        this.setPh(50);
        this.setIcone('G');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 1 casas;
        //Ao Atacabar Batman entra em combate corpo a corpo com o inimigo 
        //Utilizando suas tecnicas de combate;
        boolean achouPatacado = false;
            if(this.linha + 1 < Mapa.length - 1){//verifica se esta acima 
                if(Mapa[this.linha + 1][this.coluna] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }
                }
            }
            if(this.linha - 1 > 0){//verifica se esta embaixo 
                if(Mapa[this.linha - 1][this.coluna] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }               
                }
            }
            if(this.coluna + 1 < Mapa.length - 1){//verifica se esta a direita
                if(Mapa[this.linha][this.coluna + 1] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }                            
                }
            }
            if(this.coluna - 1 > 0){//verifica se esta a esquerda
                if(Mapa[this.linha][this.coluna - 1] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }                
                }
            }
        
        if(achouPatacado == true){
            System.out.println(pAtacado.getNome() + "é atacado com as técnicas de combate do " + this.getNome());
            if(pAtacado.getDefesa() != 0){
                pAtacado.setDefesa((pAtacado.getDefesa() - this.getDano()* + 10));
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
            System.out.println("O personagem que voce escolheu atacar não está dentro do alcance do seu golpe, ou existe um obstáculo impedindo o ataque");
        }
    }
        
        @Override
        public void ult(){
            //A Ult(Preparo) se trata do preparo que o Batman é tão conhecido;
            //Ao ativar a Ult o Batman ganha um Bonos de Defesa e De Dano;
            if(this.getPh() <= 25){
                System.out.println("Você não tem Pontos de Habilidade (PH) necessários para usar essa habilidade.");
            }
            System.out.println("O " + this.getNome() + " utiliza o seu preparo para ganhar bônus no ataque e na defesa.");
            this.setDano(this.getDano() + 10);
            this.setDefesa(this.getDefesa() + 40);
            this.setPh(this.getPh() - 25);
            
        }
        
}
