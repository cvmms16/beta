# PRD — Beta Turismo

## 1. Identificação do Projeto

**Nome do aplicativo:** Beta  
**Nome da solução:** Vai de Beta Turismo  
**Turma:** 3º ano A — Ensino Médio  
**Repositório:** https://github.com/cvmms16/beta  
**Data de preenchimento do Canvas:** 16/09/2026  
**Entrega final:** 10/12/2026  
**Versão inicial:** 1.0  
**Application ID:** `br.edu.ifpe.beta`

---

## 2. Visão Geral

O Beta é um aplicativo Android desenvolvido para ajudar pequenas empresas de turismo a organizar viagens, passageiros, pagamentos e reservas de assentos.

A proposta é substituir o controle manual feito por listas e anotações separadas por uma organização das informações dentro do aplicativo.

O aplicativo terá como foco o cadastro e visualização das viagens, controle dos assentos do ônibus, gerenciamento das reservas e acompanhamento do status de pagamento dos passageiros.

---

## 3. Problema

As reservas de viagens precisam ser organizadas manualmente, dificultando a visualização de quem está confirmado, quem pagou, quem cancelou e quais assentos ainda estão disponíveis em cada viagem.

O Beta busca organizar essas informações em um único aplicativo, facilitando o acompanhamento das viagens e reservas.

---

## 4. Público-Alvo

O público principal são pequenas empresas de turismo e responsáveis pela organização de viagens.

O aplicativo será utilizado durante:

- cadastro das viagens;
- organização dos passageiros;
- acompanhamento das reservas;
- controle dos assentos;
- acompanhamento dos pagamentos.

Uma pessoa que poderá testar o aplicativo é Betânia, responsável pela empresa de turismo que apresentou o problema.

---

## 5. Objetivo

O objetivo do Beta é facilitar a organização das viagens, passageiros, reservas, assentos e pagamentos em um único aplicativo.

O sistema deverá permitir que a pessoa responsável pela organização consiga cadastrar viagens, visualizar os assentos, realizar reservas, cancelar reservas, consultar reservas e acompanhar o status de pagamento dos passageiros.

---

## 6. Fluxo Principal

O fluxo principal do aplicativo será:

**Tela inicial → escolher viagem → visualizar detalhes → visualizar assentos → selecionar assento → realizar reserva → visualizar confirmação.**

A tela principal apresentará as viagens cadastradas, permitindo que o usuário escolha uma viagem para consultar seus detalhes e realizar uma reserva.

Após selecionar um assento disponível, o usuário poderá realizar a reserva e visualizar a confirmação com o assento escolhido.

---

# 7. Funcionalidades do MVP

O MVP terá quatro funcionalidades principais.

## F1 — Cadastrar e visualizar viagens

Permitir o cadastro e a visualização das viagens.

A tela deverá apresentar informações como destino e data.

**Responsável pelo uso:** Administradora.

## F2 — Visualizar a planta do ônibus e os assentos disponíveis

Permitir visualizar uma representação dos assentos do ônibus.

Os assentos deverão apresentar seus respectivos status, permitindo identificar quais estão disponíveis e quais estão ocupados.

**Responsável pelo uso:** Administradora.

## F3 — Realizar, cancelar e consultar reservas

Permitir:

- realizar reservas;
- consultar reservas;
- cancelar reservas.

O sistema deverá impedir que um assento já ocupado seja reservado novamente.

Após a realização da reserva, deverá ser apresentada uma confirmação com o assento escolhido.

**Responsável pelo uso:** Administradora.

## F4 — Controlar o status de pagamento dos passageiros

Permitir acompanhar o status do pagamento dos passageiros relacionados às reservas.

**Responsável pelo uso:** Administradora.

---

# 8. Fora do Escopo

Nesta versão, o aplicativo não terá:

- pagamento online dentro do aplicativo;
- sistema de chat entre passageiros;
- comunicação entre passageiros;
- notificações push;
- integração com WhatsApp;
- sincronização em nuvem;
- sistema completo para múltiplas empresas.

Funcionalidades extras não serão adicionadas sem avaliação do grupo.

---

# 9. Requisitos Funcionais

### RF01 — Cadastro de viagem
O sistema deverá permitir cadastrar uma nova viagem.

### RF02 — Visualização de viagens
O sistema deverá apresentar as viagens cadastradas na tela principal.

### RF03 — Seleção de viagem
O sistema deverá permitir selecionar uma viagem para consultar suas informações.

### RF04 — Visualização dos assentos
O sistema deverá apresentar visualmente os assentos da viagem selecionada.

### RF05 — Status dos assentos
O sistema deverá permitir identificar os assentos disponíveis e ocupados.

### RF06 — Reserva
O sistema deverá permitir realizar uma reserva selecionando um assento disponível.

### RF07 — Bloqueio de assento ocupado
O sistema não deverá permitir reservar um assento que já esteja ocupado.

### RF08 — Confirmação
Após uma reserva realizada com sucesso, o sistema deverá apresentar uma confirmação com o assento escolhido.

### RF09 — Consulta de reserva
O sistema deverá permitir consultar as reservas realizadas.

### RF10 — Cancelamento
O sistema deverá permitir cancelar uma reserva.

### RF11 — Status de pagamento
O sistema deverá permitir controlar o status de pagamento dos passageiros.

### RF12 — Tratamento de erros
Quando uma operação não puder ser realizada, o aplicativo deverá apresentar uma mensagem clara ao usuário.

---

# 10. Requisitos Não Funcionais

### RNF01 — Plataforma
O aplicativo deverá ser desenvolvido para Android.

### RNF02 — Linguagem
O projeto será desenvolvido utilizando Kotlin.

### RNF03 — Interface
A interface será desenvolvida utilizando Jetpack Compose e Material 3.

### RNF04 — Banco de dados
Os dados serão armazenados localmente utilizando Room.

### RNF05 — Navegação
A navegação entre as telas será realizada utilizando Navigation Compose.

### RNF06 — Operações assíncronas
O projeto poderá utilizar Coroutines e Flow para trabalhar com operações e observação dos dados.

### RNF07 — Versionamento
O código será versionado utilizando Git e GitHub.

### RNF08 — Identidade visual
O aplicativo deverá possuir nome, ícone e identidade visual próprios.

### RNF09 — Estabilidade
O aplicativo não deverá fechar sozinho durante a utilização normal.

### RNF10 — Tratamento de erros
As operações que possam apresentar falhas deverão ser tratadas para evitar o fechamento inesperado do aplicativo.

---

# 11. Tecnologias

O projeto utilizará:

- Kotlin;
- Jetpack Compose;
- Material 3;
- Navigation Compose;
- Room;
- Android Jetpack;
- Coroutines;
- Flow;
- Git;
- GitHub.

---

# 12. Estrutura Inicial do Projeto

```text
app/
└── src/
    └── main/
        └── java/
            └── br/
                └── edu/
                    └── ifpe/
                        └── beta/
                            ├── data/
                            │   ├── local/
                            │   ├── remote/
                            │   └── repository/
                            │
                            ├── model/
                            │
                            ├── ui/
                            │   ├── theme/
                            │   ├── navigation/
                            │   └── features/
                            │
                            └── MainActivity.kt
```

---

# 13. Entidades Principais

## Viagem

Representa uma viagem cadastrada.

Possíveis informações:

- id;
- destino;
- data;
- informações da viagem.

## Assento

Representa um assento de uma viagem.

Possíveis informações:

- id;
- número do assento;
- viagem relacionada;
- status.

## Reserva

Representa uma reserva realizada.

Possíveis informações:

- id;
- viagem;
- passageiro;
- assento;
- status da reserva.

## Passageiro

Representa a pessoa relacionada à reserva.

Possíveis informações:

- id;
- nome;
- informações necessárias para identificação.

## Pagamento

Representa o status do pagamento relacionado ao passageiro ou à reserva.

Possíveis informações:

- id;
- reserva;
- status do pagamento.

---

# 14. Telas do Aplicativo

## Tela 1 — Viagens

Será a tela principal.

Deverá apresentar as viagens cadastradas, mostrando informações como destino e data.

O usuário poderá selecionar uma viagem.

## Tela 2 — Detalhes da Viagem

Apresentará as informações da viagem selecionada.

A partir dela, o usuário poderá acessar os assentos.

## Tela 3 — Assentos

Apresentará uma planta visual simplificada do ônibus.

Deverá permitir identificar:

- assentos disponíveis;
- assentos ocupados;
- assento selecionado.

## Tela 4 — Reserva

Apresentará as informações da reserva antes da confirmação.

Após confirmar, deverá mostrar o resultado da reserva e o assento escolhido.

## Tela 5 — Reservas e Pagamentos

Permitirá consultar as reservas e acompanhar o status de pagamento dos passageiros.

---

# 15. Tratamento de Erros

O `try/catch` será utilizado principalmente nas operações de armazenamento e recuperação dos dados.

Poderão ocorrer erros durante:

- salvamento de uma viagem;
- alteração de uma viagem;
- exclusão de uma viagem;
- salvamento de uma reserva;
- consulta dos dados.

Quando ocorrer um erro, deverá ser apresentada uma mensagem clara, como:

**"Não foi possível realizar esta ação. Tente novamente."**

Também serão realizadas validações para evitar situações como uma reserva em um assento que já esteja ocupado.

---

# 16. Identidade Visual

**Nome exibido:** Beta

**Cor principal:** `#FFC222`

A identidade visual terá como base as cores azul e amarelo.

A ideia do ícone é apresentar o nome **"Vai de Beta Turismo"** junto a elementos relacionados a viagens, como:

- ônibus;
- avião;
- sol;
- linhas de movimento.

A identidade deverá transmitir a ideia de turismo, viagem, transporte e aventura.

---

# 17. Application ID e Versão

**Application ID:**

`br.edu.ifpe.beta`

**Versão inicial:** `1.0`

**Version Code:** `1`

---

# 18. Equipe

## Alexsandro Soares e Laryssa Vitória

**Papel:** Desenvolvimento / telas

**Responsabilidades:**

- interfaces;
- telas;
- navegação;
- integração entre as telas;
- funcionamento do fluxo principal.

## Júlia Allana

**Papel:** Desenvolvimento / dados

**Responsabilidades:**

- Room;
- entidades;
- banco de dados;
- operações de armazenamento;
- operações de consulta, alteração e exclusão.

## Cauanne Victória

**Papel:** Design e identidade visual

**Responsabilidades:**

- cores;
- identidade visual;
- ícone;
- organização visual;
- aparência das telas.

## Ana Beatrys

**Papel:** Documentação, build e entrega

**Responsabilidades:**

- README;
- documentação;
- testes;
- builds;
- APK;
- AAB;
- materiais de entrega.

Todos os integrantes participam da programação. Os papéis definem principalmente quem ficará responsável por cada área.

---

# 19. Riscos

## Risco 1 — Planta do ônibus ficar muito complexa

**Plano B:** Criar uma planta visual mais simples, mantendo a seleção e o status dos assentos.

## Risco 2 — Não conseguir implementar todas as funcionalidades

**Plano B:** Priorizar as quatro funcionalidades do MVP e retirar funcionalidades extras.

---

# 20. Uso de Inteligência Artificial

A implementação poderá utilizar Inteligência Artificial, como o Gemini no Android Studio.

A IA deverá seguir as seguintes regras:

1. A IA deverá explicar as alterações realizadas quando solicitado e não deverá adicionar funcionalidades fora do escopo definido no PRD.
2. Todo código gerado ou alterado pela IA deverá ser revisado e testado por um integrante da equipe antes de ser aceito.
3. A IA deverá seguir a arquitetura, tecnologias e padrões definidos pelo grupo, evitando alterações desnecessárias no projeto.

### Combinados do grupo

- Ninguém deverá clicar em Accept no Agent Mode sem ler a mudança inteira.
- Quem aceitar o código deverá escrever o comentário de fronteira do arquivo.
- Antes de cada marco, o grupo deverá revisar o projeto em conjunto.
- Nenhuma chave de API ou senha será colocada no prompt.
- Quem implementar uma funcionalidade deverá apresentar aos outros integrantes como ela funciona.
- Cada integrante deverá realizar pequenas alterações no projeto individualmente.

---

# 21. Cronograma

| Marco | Prazo | Comprovação |
|---|---|---|
| M1 — Canvas preenchido + repositório | 16/09/2026 | `CANVAS.md` no main |
| M2 — PRD aprovado + telas rascunhadas | 30/09/2026 | `PRD.md` + imagens em `docs/` |
| M3 — Funcionalidade base funcionando | 21/10/2026 | Tela principal + 1 ação + `try/catch` |
| M4 — Dados completos e erros tratados | 11/11/2026 | Commits da camada de dados |
| M5 — Identidade visual + APK | 25/11/2026 | Ícone + cores + APK testado |
| M6 — AAB + material de loja + README | 02/12/2026 | Pasta `loja/` + README |
| Entrega e apresentação | 10/12/2026 | Tag `v1.0` |

---

# 22. Critérios de Aceitação

O aplicativo será considerado pronto quando:

- [ ] O aplicativo abre e não fecha sozinho depois de 5 minutos de uso.
- [ ] A tela principal mostra dados reais.
- [ ] A ação principal funciona.
- [ ] O resultado da ação aparece na tela.
- [ ] Quando algo falha, aparece uma mensagem clara.
- [ ] O aplicativo possui nome próprio.
- [ ] O aplicativo possui ícone próprio.
- [ ] O aplicativo possui cores próprias.
- [ ] Duas pessoas de fora do grupo conseguiram instalar e utilizar o APK.
- [ ] O `README.md` explica o que o aplicativo faz.
- [ ] O `README.md` explica como o projeto foi desenvolvido.
- [ ] O `README.md` explica como gerar o build.
- [ ] O `docs/USO_DE_IA.md` está preenchido.
- [ ] O `AGENTS.md` está preenchido.
- [ ] Cada integrante consegue realizar uma pequena alteração sozinho.
- [ ] Todo arquivo possui o comentário de fronteira definido pelo grupo.

---

# 23. Entregáveis

Ao final do projeto deverão estar disponíveis:

- código-fonte do aplicativo;
- `CANVAS.md`;
- `PRD.md`;
- `README.md`;
- `AGENTS.md`;
- `docs/USO_DE_IA.md`;
- imagens das telas/protótipos;
- APK de release;
- AAB;
- materiais para loja;
- tag `v1.0`.

---

# 24. Definição de Pronto

O projeto será considerado concluído quando todas as funcionalidades do MVP estiverem implementadas, testadas e funcionando.

Além disso, os critérios de estabilidade, identidade visual, documentação, testes externos, participação dos integrantes e organização do repositório deverão estar cumpridos.

**Versão:** 1.0  
**Projeto:** Beta — Vai de Beta Turismo  
**Application ID:** `br.edu.ifpe.beta`  
**Entrega final:** 10/12/2026
