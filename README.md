# HeroForge - RPG 
Esse é um jogo simples de RPG interativo feito em Kotlin usando Jetpack Compose.  
Criei ele para treinar o que venho aprendendo em desenvolvimento Android e pra mostrar um projeto prático no meu portfólio.

- [Tecnologias](#tecnologias-utilizadas)
- [Por que Jetpack Compose?](#por-que-jetpack-compose)
- [Como funciona?](#como-o-jogo-funciona)
- [Tomadas de Decisão](#tomadas-de-decisão)
- [Demonstração](#demonstração)
- [Observações](#observações)
- [Créditos](#créditos)

## Tecnologias utilizadas
- [Kotlin](https://kotlinlang.org/) — A melhor linguagem de todas.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) —  Criação rápida e simples da interface.
- [Material 3](https://m3.material.io/) — Visual moderno e consistente.
- Arquitetura MVVM — ViewModel para controlar o estado e separar a interface da lógica.

## Por que Jetpack Compose?
Decidi usar Jetpack Compose porque já vinha estudando a ferramenta e queria colocar em prática num projeto "real".
Senti que ele facilita bastante na hora de criar a interface, sem precisar lidar com aquele XML chato (sim, tenho pavor e ódio de XML).  
Quis fazer algo simples e direto, que fosse fácil de entender e que oferecesse uma experiência visual agradável e fluida para quem usar o app (vulgo somente eu).

## Como o jogo funciona?
O app conta uma história em capítulos, e você pode escolher o caminho que quer seguir.  
Cada escolha leva pra um capítulo diferente, e dependendo do caminho, você chega a finais distintos.  
Quando o fim chega, você pode reiniciar e tentar outros caminhos.

## Tomadas de Decisão
### ViewModel 
Usei ViewModel pra gerenciar o estado da história porque ele mantém os dados mesmo se a tela for recriada, além de ser a forma recomendada pelo Android pra separar UI e lógica. 
 
### Material 3 
Optei por Material3 pra dar um visual moderno e limpo, sem muita customização, só o suficiente pra deixar o app com uma cara profissional.  

### Animações simples 
Usei animações básicas nas transições de texto só pra deixar a experiência mais agradável, sem complicar demais.  

### Arquitetura MVVM simples 
Não quis complicar demais, então deixei tudo básico, só com ViewModel e UI componível, pra facilitar entendimento e manutenção.  

### Dados hardcoded 
Como o foco era a lógica da história e UI, deixei os capítulos e escolhas “fixos” no código mesmo, sem banco ou network.

## Demonstração
Abaixo irei disponibilizar um GIF mostrando como o jogo está funcionando no momento atual:  

![studio64_KkTdPz7Pdx](https://github.com/user-attachments/assets/57b454ed-ddc0-44d2-9801-c76066aa46db)

## Observações
Esse app é só um projeto pessoal, pra mostrar que eu sei colocar um app Android junto com uma história interativa.  
Não pretendo fazer atualizações frequentes nem abrir para colaboração.  
O código pode não ser perfeito, mas foi feito com foco em aprender.
> A imagem de background `rpg_background` foi gerada por IA, mas isso a gente não comenta :D

## Créditos
Para mim mesmo, Gabriel Rodrigues entusiasta em Desenvolvimento Mobile (Android).
- [LinkedIn](https://www.linkedin.com/in/gahrodrigues/)
> [Kotlin](https://kotlinlang.org/) + [Jetpack Compose](https://developer.android.com/jetpack/compose) = ❤️
