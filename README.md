# Jogo de Dominó

Nosso objetivo foi criar o jogo de dominó em Java mais próximo das regras e experiência de jogatina da vida real. Entretanto, para realizar esse objetivo, eu, Lucca, conversei com meu sogro que é um fanático e ótimo jogador de dominó, lhe expliquei os objetivos e começamos a pontuar as regras e como o fluxo do jogo de dominó deveria ser. Sendo assim, optamos por seguir outro caminho do que foi sugerido na descrição do trabalho.

Utilizamos uma lista por jogador e três listas representando a mesa, estás: Duas listas representando a direção da mesa, tanto direita como esquerda e uma lista para representar o "monte" para compra das peças.

Para resolução do problema, criamos classes sugeridas e outras classes para segregação das responsabilidades e melhor tomada de decisão para construção do jogo de dominó. As classes escolhidas foram: Game, List, Node, Piece, Player, Table, Input, Output e Menu.

O jogo de dominó criado tem objetivo de trazer a experiência mais próxima da realidade. Contudo, o fluxo do jogo foi desenvolvido e pensado exclusivamente nas regras do jogo de dominó e na experiência do usuário.

## Como jogar?
- O jogo é baseado em terminal, sendo assim, para jogar é preciso realizar o clone dos arquivos em sua máquina para executar o código Java.
```bash
git clone https://github.com/LuccaRebelloToledo/domino-game.git
```

- Você deverá utilizar uma IDEA de sua escolha, como citado abaixo, utilizamos a IDEA IntelliJ. Contudo, após realizar o clones dos arquivos, será necessário importar o projeto para a IDEA e executar o código atrás do método `MAIN` encontrado na classe StartApp.

- Após execução do método `MAIN` terá o seguinte Output em seu terminal:

![image](https://github.com/LuccaRebelloToledo/domino-game/assets/99377036/630904ba-f7b6-470a-be93-3f6a2b965a3c)

## Experiência de Jogo
- Esperamos que vocês se divirtam e tenha um ótimo jogo de dominó!

## Ferramentas utilizadas
- Java 17
- IntelliJ IDEA
- Git
