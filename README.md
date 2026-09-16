# Beta — Gestão de Viagens e Reservas

O **Beta** é um aplicativo Android desenvolvido para ajudar na organização da empresa de turismo **VaideBeta**, criada por Betânia. O aplicativo tem como objetivo facilitar o controle de viagens, passageiros, pagamentos e reservas de assentos nos ônibus.

## Sobre o projeto

A VaideBeta possui dois problemas principais que o aplicativo busca solucionar:

1. **Conflitos na escolha dos assentos:** várias pessoas podem querer o mesmo assento. Para evitar esse problema, o aplicativo mostra os assentos disponíveis e reservados, permitindo que cada pessoa escolha a quantidade de assentos que deseja e selecione os assentos disponíveis.

2. **Organização dos passageiros:** atualmente, quando uma pessoa cancela uma viagem, Betânia precisa reorganizar a tabela de passageiros. Com o Beta, cada viagem terá sua própria lista de passageiros, reservas, assentos e informações de pagamento. Assim, é possível cancelar ou excluir uma reserva sem precisar refazer toda a lista.

## Objetivo

O objetivo do Beta é facilitar a organização das viagens da VaideBeta, permitindo:

* Controlar os passageiros de cada viagem;
* Organizar as reservas;
* Controlar os pagamentos;
* Mostrar os assentos disponíveis e reservados;
* Permitir que o passageiro escolha seus assentos;
* Evitar conflitos na escolha dos assentos;
* Facilitar o cancelamento de reservas;
* Atualizar automaticamente a disponibilidade dos assentos.

## Público-alvo

### Administrador — Betânia

O administrador poderá:

* Cadastrar viagens;
* Visualizar as viagens;
* Ver a lista de passageiros de cada viagem;
* Ver os assentos reservados;
* Ver os assentos disponíveis;
* Adicionar e editar reservas;
* Cancelar ou excluir reservas;
* Ver o status dos pagamentos;
* Identificar pagamentos pendentes ou não realizados;
* Acompanhar a quantidade de assentos disponíveis.

### Passageiro

O passageiro poderá:

* Visualizar as viagens disponíveis;
* Escolher uma viagem;
* Ver as informações da viagem;
* Visualizar o mapa de assentos do ônibus;
* Ver quais assentos estão disponíveis ou reservados;
* Escolher a quantidade de assentos;
* Escolher os assentos que deseja;
* Fazer uma reserva;
* Consultar sua própria reserva.

## Organização dos ônibus

A empresa trabalha com dois ônibus:

### Ônibus 1

* 50 lugares;
* 48 lugares comuns;
* 2 lugares preferenciais.

### Ônibus 2

* 60 lugares;
* 57 lugares comuns;
* 2 lugares preferenciais;
* 1 lugar de inclusão/acessibilidade.

O aplicativo terá uma representação visual dos assentos para facilitar a escolha.

Cada assento poderá apresentar um status:

* Disponível;
* Reservado;
* Preferencial;
* Inclusão/acessibilidade.

Depois que um assento for reservado, ele ficará indisponível para outras pessoas naquela viagem.

## Organização das viagens

A empresa pode ter várias viagens durante o mesmo mês. Cada viagem será cadastrada separadamente.

Exemplo:

* Porto de Galinhas — 05/09;
* Maragogi — 12/09;
* João Pessoa — 19/09;
* Porto de Galinhas — 26/09.

Cada viagem terá suas próprias:

* Reservas;
* Lista de passageiros;
* Assentos;
* Informações de pagamento;
* Quantidade de assentos disponíveis.

As informações de uma viagem não devem interferir nas outras.

Betânia poderá entrar em uma viagem específica e visualizar somente os passageiros e reservas relacionados a ela.

## Lista de passageiros

Cada viagem terá sua própria lista de passageiros.

Exemplo:

| Passageiro  | Assento | Pagamento | Status     |
| ----------- | ------: | --------- | ---------- |
| Maria Silva |      12 | Pago      | Confirmado |
| João Santos |      18 | Pendente  | Confirmado |
| Ana Souza   |      25 | Não pago  | Confirmado |

Caso um passageiro cancele a viagem, Betânia poderá excluir ou cancelar a reserva diretamente.

O assento reservado também ficará disponível novamente, sem a necessidade de reorganizar toda a lista de passageiros.

## Controle de pagamentos

O aplicativo permitirá que Betânia acompanhe a situação dos pagamentos de cada passageiro.

Os principais status serão:

* Pago;
* Pendente;
* Cancelado.

Essas informações ficarão vinculadas à viagem e à reserva do passageiro.

## Principais telas

* Tela inicial;
* Login;
* Cadastro de usuário;
* Viagens disponíveis;
* Detalhes da viagem;
* Escolha do ônibus;
* Planta dos assentos;
* Seleção dos assentos;
* Confirmação da reserva;
* Minhas reservas;
* Painel administrativo;
* Lista de passageiros;
* Controle de pagamentos;
* Cadastro e edição de viagens.

## Tecnologias utilizadas

* **Android Studio**
* **Kotlin**
* **Jetpack Compose**
* **Room**
* **Git e GitHub**

## Persistência dos dados

O aplicativo utilizará o **Room** para armazenar os dados localmente.

Serão armazenadas informações como:

* Viagens;
* Passageiros;
* Reservas;
* Assentos;
* Status dos pagamentos.

Os dados serão relacionados às viagens para manter a organização de cada grupo de passageiros.

## Modelagem do Banco de Dados (Room)

### Viagem

Armazena:

* Destino;
* Data;
* Mês;
* Modelo do ônibus.

### Passageiro

Armazena:

* Nome;
* Telefone;
* Documento.

### Reserva

Relaciona o passageiro com uma viagem e armazena:

* Assentos escolhidos;
* Status do pagamento;
* Informações da reserva.

### Relacionamento

```text
Viagem
   ↓
Reserva
   ↓
Passageiro
   ↓
Assentos
   ↓
Status do pagamento
```

Quando uma reserva for cancelada ou excluída, o assento relacionado ficará disponível novamente.

## Funcionamento principal

### Fluxo do passageiro

```text
Usuário
   ↓
Visualiza as viagens
   ↓
Escolhe uma viagem
   ↓
Visualiza o ônibus
   ↓
Visualiza os assentos
   ↓
Escolhe a quantidade de assentos
   ↓
Escolhe os assentos disponíveis
   ↓
Confirma a reserva
   ↓
Reserva registrada
```

### Fluxo do administrador

```text
Betânia
   ↓
Painel administrativo
   ↓
Escolhe uma viagem
   ↓
Visualiza a lista de passageiros
   ↓
Visualiza os assentos reservados
   ↓
Verifica os pagamentos
   ↓
Adiciona, edita ou cancela reservas
   ↓
Lista e assentos são atualizados
```

## Identidade visual

A identidade visual do Beta será relacionada ao turismo e à organização das viagens.

A interface deverá ser simples, clara e fácil de utilizar, principalmente na tela de escolha dos assentos.

## Uso de Inteligência Artificial

A Inteligência Artificial será utilizada como ferramenta de apoio durante o desenvolvimento do aplicativo no Android Studio.

A equipe será responsável por:

* Definir as funcionalidades;
* Tomar as decisões do projeto;
* Analisar os códigos gerados;
* Testar o aplicativo;
* Corrigir erros;
* Compreender o funcionamento do código.

O uso da IA será registrado de acordo com as orientações do projeto.

## Organização do projeto

```text
Beta/
├── app/
│   └── src/
├── README.md
├── AGENTS.md
├── CANVAS.md
├── PRD.md
└── docs/
    └── USO_DE_IA.md
```

## Como executar o projeto

1. Clonar o repositório do projeto:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abrir o projeto no Android Studio.

3. Aguardar a sincronização do Gradle e das dependências.

4. Executar o aplicativo em um dispositivo Android ou em um emulador.

5. Clicar em **Run** no Android Studio.

## Processo de desenvolvimento

### M1 — Planejamento

* Definição do problema;
* Definição da solução;
* Definição do sistema de reserva de assentos;
* Criação do Canvas;
* Criação do repositório.

### M2 — Requisitos

* Definição das funcionalidades;
* Criação do PRD;
* Definição das telas;
* Definição do funcionamento das reservas e da lista de passageiros.

### M3 — Funcionalidade básica

* Criação das telas;
* Lista de viagens;
* Ações principais;
* Tratamento de erros.

### M4 — Persistência

* Implementação do Room;
* Cadastro de viagens;
* Cadastro de passageiros;
* Reservas;
* Assentos;
* Status dos pagamentos;
* Tratamento de erros.

### M5 — Identidade e testes

* Identidade visual;
* Sistema de escolha dos assentos;
* Testes do aplicativo;
* Testes com usuários.

### M6 — Finalização

* Geração do APK/AAB;
* Finalização do README;
* Organização da documentação;
* Preparação da apresentação.

## Resultado esperado

O Beta deverá facilitar a organização das viagens da VaideBeta.

Betânia poderá visualizar os passageiros de cada viagem, suas reservas, os assentos escolhidos e os pagamentos.

Os passageiros poderão visualizar as viagens e escolher os assentos disponíveis no momento da reserva.

Dessa forma, o aplicativo busca resolver os conflitos na escolha dos assentos e evitar que Betânia precise reorganizar toda a lista de passageiros quando ocorrer um cancelamento.

## Equipe

* **Projeto:** Beta
* **Empresa:** VaideBeta
* **Plataforma:** Android
* **Desenvolvimento:** Android Studio
* **Linguagem:** Kotlin
* **Persistência:** Room
* **Entrega:** 10/12/2026
