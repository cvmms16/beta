# Beta — Gestão de Viagens e Reservas

## Sobre o projeto

O **Beta** é um aplicativo Android desenvolvido para auxiliar a **VaideBeta** na organização de suas viagens e reservas.

O sistema é destinado ao uso administrativo de **Betânia**, permitindo centralizar em um único aplicativo as informações relacionadas às viagens, ônibus, passageiros, assentos e situação dos pagamentos.

A proposta é substituir parte do controle manual por uma organização digital mais simples e prática.

## Problema

A organização das viagens de forma manual pode dificultar o controle de passageiros, assentos e pagamentos. Quando uma viagem possui muitos passageiros ou mais de um ônibus, torna-se mais difícil acompanhar quais lugares estão ocupados, quem está em cada ônibus e a situação de cada reserva.

Além disso, alterações e cancelamentos podem exigir a reorganização das informações, aumentando a possibilidade de erros e informações desatualizadas.

O **Beta** busca solucionar esse problema centralizando as informações das viagens e permitindo que Betânia consulte e atualize os dados de forma mais organizada.

## Funcionalidades

O Beta permite:

- Cadastrar e consultar viagens;
- Informar o destino e a data de cada viagem;
- Selecionar os ônibus utilizados em cada viagem;
- Visualizar a disposição dos assentos dos ônibus;
- Cadastrar passageiros;
- Associar passageiros aos seus respectivos ônibus e assentos;
- Consultar os assentos ocupados;
- Registrar a situação do pagamento como **Pago** ou **Pendente**;
- Editar informações dos passageiros;
- Cancelar ou remover reservas.

O aplicativo é destinado exclusivamente ao **uso administrativo da VaideBeta**. Os passageiros não utilizam o sistema diretamente e o aplicativo não realiza pagamentos.

## Tecnologias utilizadas

- **Kotlin** — linguagem de programação;
- **Android Studio** — ambiente de desenvolvimento;
- **Jetpack Compose** — desenvolvimento da interface;
- **Room** — persistência dos dados;
- **SQLite** — banco de dados utilizado pelo Room;
- **Git e GitHub** — controle de versão e colaboração.

## Armazenamento dos dados

O aplicativo utiliza o **Room Database** para armazenar localmente as informações cadastradas.

Os dados de viagens, passageiros, reservas, assentos e situação dos pagamentos são armazenados no banco de dados.

As plantas dos ônibus são representadas por imagens incluídas nos recursos do aplicativo.

## Como executar o projeto

### Requisitos

Para executar o projeto, é necessário ter:

- Android Studio;
- JDK compatível com a versão do projeto;
- Android SDK;
- Emulador Android ou dispositivo físico.

### Execução

1. Clone o repositório do projeto.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Inicie um emulador ou conecte um dispositivo Android.
5. Execute o projeto pelo botão **Run** do Android Studio.

## Uso de Inteligência Artificial

A Inteligência Artificial será utilizada como ferramenta de apoio durante o desenvolvimento do projeto.

Ela poderá auxiliar em atividades como:

- Compreensão de conceitos de Kotlin e Android;
- Compreensão das tecnologias utilizadas;
- Identificação e correção de erros;
- Sugestões de organização e melhoria do código;
- Apoio na documentação do projeto.

Todo conteúdo gerado ou sugerido com auxílio de Inteligência Artificial será analisado, testado e compreendido pela equipe antes de ser utilizado no projeto.

Os usos de Inteligência Artificial serão registrados de acordo com as orientações estabelecidas para a atividade.

## Status do projeto

**Em desenvolvimento.**

O Beta está sendo desenvolvido com foco em uma solução simples e funcional para auxiliar na organização das viagens e reservas da VaideBeta.
