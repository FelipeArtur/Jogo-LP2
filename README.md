Instruções do Jogo: O jogo consiste em uma batalha 3x3 (3 contra 3), que ganha a última equipe viva no mapa, para efeito de teste existiram apenas 4 rodadas ganhando a equipe que acabar com mais vida, sendo que para a formação das equipes será feito um sorteio e escolhas alternadas, sem a possibilidade de Duplicação de personagens.

Existem 3 tipos de mapas,sendo eles: 
- Mapa 1: Tamanho:7x7 (7 linhas e 7 colunas) existindo Obstáculos, representados por “~”.
- Mapa 2: Tamanho:10x10 (10 linhas e 10 colunas) existindo Obstáculos, representados por “~”.
- Mapa 3: Tamanho:11x11 (11 linhas e 11 colunas) existindo Obstáculos, representados por “~”.

Observações importantes:
- Gerar um arquivo chamado "dados.txt" na pasta contendo o jogo, exemplo: ESTECOMPUTADOR/DOCUMENTOS/NETBEANSPROJECTS/CONFIA
- Nunca escrever letras quando uma opção numérica é sugerida, exemplo: Posicionar personagem
- As letras A e B dispostas no mapa são respectivamente os números 10 e 11

Regras:
- Ao Iniciar o jogo os personagens devem ser colocados nas extremidades do mapa (Lado 1 na última linha do mapa e o Lado 2 na linha 1);
- O jogo termina após 4 rodadas para facilitar o teste do jogo, a contagem começa da rodada 0;
- Ganha a equipe que tiver o maior número de vida somando todos os personagens vivos;
- Não é possível duplicação de personagens, por tanto todos os 6 personagens devem ser usados;
- O ganhador ganhará um item ao final do jogo, o item é sorteado aleatoriamente dentre os 4 itens Existentes;
- Itens podem ser utilizado mais de uma vez por personagem;
- Cada Personagem pode andar 2 casa por rodada, movimentos somente em linhas e colunas;

Informações Personagens:
Artemis:
Ataque Básico: Uma flecha que pode atingir qualquer personagem presente em sua Coluna. Obs: Não atravessa personagens nem Obstáculos.
Vida: 150
Defesa: 100
Dano: 10
Range: Coluna Toda. 
Ph: 100
Ícone: @
Ult: Dobra o Dano Das Flechas. (Custo: 50 Ph)

Batman:
Ataque Básico: Ataque corpo-a-corpo.
Vida:180 
Defesa:120
Dano:20
Range: 1 Casa
Ph:50
Icone: G
Ult: //Ao ativar a Ult o Batman ganha um Bonos de Defesa e De Dano. (Custo: 25 Ph)

Oryx:		.
Ataque básico: atira esferas de fogo e podem passar por cima de personagens.
Vida:110 
Defesa:100
Dano:30
Range: 3 Casa
Ph:70
Ícone: O
Ult: Uma bola de fogo condensada atirada por Oryx de 120 de dano em uma posição escolhida pelo jogador. Range: 4 casas. (Custo 50 Ph)

Zagreu:
Ataque Básico: Nega a armadura (Defesa) inimiga e recupera 5 de vida a cada vez que acerta um inimigo;
Vida:200
Defesa:100
Dano:25
Range: 2 Casa
Ph:50
Ícone: #
Ult: Caso sua vida esteja menor ou igual a 50, restaura a vida por completo (200 de vida). Caso tente ultar sem cumprir o requisito nenhuma ação será executada e o turno será perdido


Zatanna:
Ataque Básico:Invoca  uma bola de fogo e atinge o inimigo.
Vida:175
Defesa:100
Dano:25
Range: 3 Casa
Ph:100
Ícone: Z
Ult: Cria um Campo de Força que concede +50 de Defesa

Zoro:
Ataque Básico: Pula no inimigo e o atinge com suas espadas, em seguida retorna para seu lugar de início.
Vida:100
Defesa:100
Dano:40
Range: 2 Casa
Ph:50
Ícone: $
Ult: Segue o sentido da sua coluna e fatia todos os inimigos nelas. Dano:180. Obs: Não pega em aliados.


Informações Itens:
Luvas Assassinas do Poder: Concede + 50 de Dano;

Anel do Poder: Concede + 50 de PH (Pontos de Habilidade);

Cota de Malha: Concede + 50 de Vida;

Armadura Completa: Concede + 50 de Armadura;
