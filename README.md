# Jogo de Dominó
Nosso objetivo foi criar o jogo de dominó em Java mais próximo das regras e experiência de jogatina da vida real. Entretanto, para realizar esse objetivo, eu, Lucca, conversei com meu sogro que é um fanático e ótimo jogador de dominó, lhe expliquei os objetivos e começamos a pontuar as regras e como o fluxo do jogo de dominó deveria ser. Sendo assim, optamos por seguir outro caminho do que foi sugerido na descrição do trabalho.

O jogo de dominó criado tem objetivo de trazer a experiência mais próxima da realidade. Contudo, o fluxo do jogo foi desenvolvido e pensado exclusivamente nas regras do jogo de dominó e na experiência do usuário.

## Desenvolvimento
Utilizamos uma lista por jogador e três listas representando a mesa, estás: Duas listas representando a direção da mesa, tanto direita como esquerda e uma lista para representar o "monte" para compra das peças.

Para resolução do problema, criamos classes sugeridas e outras classes para segregação das responsabilidades e melhor tomada de decisão para construção do jogo de dominó. As classes escolhidas foram: Game, List, Node, Piece, Player, Table, Input, Output e Menu.

O dominó possuí 28 peças, então, para darmos inicio ao jogo, é distribuído 7 peças para cada jogador e 14 peças ao monte. Após distribuição, validamos quem é o jogador com a maior peça de lados iguais, quem possuir, começa o jogo mas, caso nenhum dos dois tenham, as peças são devolvidas e novamente as 28 peças são embaralhadas e distribuídas.

Contudo, após validado o primeiro jogador com a maior peça de lados iguais, este, começa jogando. A primeira peça é jogada na primeira posição da lista direita e esquerda, simulando o "meio". Após, é intercalado as jogadas e o jogo segue até um dos jogadores encaixar todas as suas peças ou quando nenhum dos jogadores possuir jogadas válidas. O vencedor será o jogador que encaixou todas as suas peças ou o que possuir a menor quantidade de pontos em suas peças restantes.

A divisibilidade das direções da lista trouxe maior aproveitamento e flexibilidade na lógica e desenvolvimento do código. Também, visualmente fica mais fácil de entender e interpretar o jogo.

## Como jogar?
- O jogo é baseado em terminal, sendo assim, para jogar é preciso realizar o clone dos arquivos em sua máquina para executar o código Java.
```bash
git clone https://github.com/LuccaRebelloToledo/domino-game.git
```

- Você deverá utilizar uma IDEA de sua escolha, como citado abaixo, utilizamos a IDEA IntelliJ. Contudo, após realizar o clones dos arquivos, será necessário importar o projeto para a IDEA e executar o código atrás do método `MAIN` encontrado na classe StartApp.

- Após execução do método `MAIN` terá o seguinte Output em seu terminal:

![image](https://github.com/LuccaRebelloToledo/domino-game/assets/99377036/630904ba-f7b6-470a-be93-3f6a2b965a3c)

## Regras
- O jogo de Dominó é composto por dois jogadores, você e o computador.
- O jogo começa com 7 peças para cada jogador e 14 peças no monte para compra.
- O jogador que possuir a maior peça dupla, ou seja, a maior pontuação de peças com lados iguais, começará o jogo.
- Cada jogador deve tentar encaixar uma de suas peças em uma das extremidades da mesa, desde que o número nas extremidades corresponda ao de sua peça.
- Caso o jogador não possua uma jogada válida, deverá comprar uma peça do monte ou passar a vez mas, só poderá passar a vez caso, não possuir jogadas válidas e não houver peças no monte.
- O jogo termina quando um dos jogadores encaixar todas as suas peças ou quando nenhum dos jogadores possuir jogadas válidas. O vencedor é o jogador que encaixar todas as suas peças ou que possuir a menor quantidade de pontos nas peças restantes.

## Experiência de Jogo
- Esperamos que se divirtam e tenham um ótimo jogo de dominó!

## Ferramentas utilizadas
- Java 17
- IntelliJ IDEA
- Git
